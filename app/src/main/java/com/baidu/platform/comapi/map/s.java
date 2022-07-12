package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class s
  extends h
{
  private List<GeoPoint> k = new ArrayList();
  
  public s(a0 parama0)
  {
    super(parama0);
    this.i = 0;
    this.j = 2;
  }
  
  private boolean b()
  {
    synchronized (this.k)
    {
      if (this.k.size() < 2) {
        return false;
      }
      int j = this.k.size();
      this.d = new double[this.k.size() * 2 + 5];
      if (c())
      {
        this.d[0] = this.e.getLongitude();
        this.d[1] = this.e.getLatitude();
        this.d[2] = this.f.getLongitude();
        this.d[3] = this.f.getLatitude();
      }
      double[] arrayOfDouble = this.d;
      arrayOfDouble[4] = 2.0D;
      arrayOfDouble[5] = ((GeoPoint)this.k.get(0)).getLongitude();
      this.d[6] = ((GeoPoint)this.k.get(0)).getLatitude();
      int i = 1;
      while (i < j)
      {
        arrayOfDouble = this.d;
        int m = i * 2 + 5;
        double d = ((GeoPoint)this.k.get(i)).getLongitude();
        List localList2 = this.k;
        int n = i - 1;
        arrayOfDouble[m] = (d - ((GeoPoint)localList2.get(n)).getLongitude());
        this.d[(m + 1)] = (((GeoPoint)this.k.get(i)).getLatitude() - ((GeoPoint)this.k.get(n)).getLatitude());
        i += 1;
      }
      return true;
    }
  }
  
  private boolean c()
  {
    synchronized (this.k)
    {
      if (this.k.size() < 2) {
        return false;
      }
      this.e.setLatitude(((GeoPoint)this.k.get(0)).getLatitude());
      this.e.setLongitude(((GeoPoint)this.k.get(0)).getLongitude());
      this.f.setLatitude(((GeoPoint)this.k.get(0)).getLatitude());
      this.f.setLongitude(((GeoPoint)this.k.get(0)).getLongitude());
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        GeoPoint localGeoPoint = (GeoPoint)localIterator.next();
        if (this.e.getLatitude() >= localGeoPoint.getLatitude()) {
          this.e.setLatitude(localGeoPoint.getLatitude());
        }
        if (this.e.getLongitude() >= localGeoPoint.getLongitude()) {
          this.e.setLongitude(localGeoPoint.getLongitude());
        }
        if (this.f.getLatitude() <= localGeoPoint.getLatitude()) {
          this.f.setLatitude(localGeoPoint.getLatitude());
        }
        if (this.f.getLongitude() <= localGeoPoint.getLongitude()) {
          this.f.setLongitude(localGeoPoint.getLongitude());
        }
      }
      return true;
    }
  }
  
  public String a()
  {
    synchronized (this.k)
    {
      if (this.g) {
        this.g = (b() ^ true);
      }
      String str = a(this.i);
      return str;
    }
  }
  
  public void a(a0 parama0)
  {
    this.a = parama0;
  }
  
  public void a(List<GeoPoint> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 2) {
        synchronized (this.k)
        {
          this.k.clear();
          this.k.addAll(paramList);
          this.g = true;
          return;
        }
      }
      throw new IllegalArgumentException("points count can not be less than two!");
    }
    throw new IllegalArgumentException("points list can not be null!");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.s
 * JD-Core Version:    0.7.0.1
 */