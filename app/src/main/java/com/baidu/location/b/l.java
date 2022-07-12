package com.baidu.location.b;

import android.annotation.TargetApi;
import android.location.GnssNavigationMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class l
{
  private static final double[] a = { 1999.0D, 8.0D, 22.0D, 0.0D, 0.0D, 0.0D };
  private HashMap<String, c> b = new HashMap();
  private HashMap<String, String> c = new HashMap();
  
  public static l a()
  {
    return a.a();
  }
  
  @TargetApi(24)
  public void a(GnssNavigationMessage paramGnssNavigationMessage, long paramLong)
  {
    int i = paramGnssNavigationMessage.getSvid();
    int j = paramGnssNavigationMessage.getType();
    if (j != 257)
    {
      if (j != 769)
      {
        if (j != 1537)
        {
          if (j != 1281)
          {
            if (j != 1282) {
              str = "none";
            } else {
              str = "CT";
            }
          }
          else {
            str = "CO";
          }
        }
        else {
          str = "E";
        }
      }
      else {
        str = "R";
      }
    }
    else {
      str = "G";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(i);
    String str = ((StringBuilder)localObject).toString();
    if (str.contains("none")) {
      return;
    }
    localObject = this.b;
    if (localObject == null) {
      return;
    }
    if (!((HashMap)localObject).containsKey(str))
    {
      localObject = new c(i, j);
      this.b.put(str, localObject);
    }
    c.a((c)this.b.get(str), paramGnssNavigationMessage, paramLong);
  }
  
  public ArrayList<String> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject1).getKey();
      localObject1 = c.a((c)((Map.Entry)localObject1).getValue());
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        if (!this.c.containsKey(str))
        {
          this.c.put(str, localObject1);
        }
        else
        {
          localObject2 = (String)this.c.get(str);
          if (((String)localObject1).substring(0, 100).equals(((String)localObject2).substring(0, 100))) {
            continue;
          }
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append('|');
        ((StringBuilder)localObject2).append((String)localObject1);
        localArrayList.add(((StringBuilder)localObject2).toString());
      }
    }
    return localArrayList;
  }
  
  private static class a
  {
    private static l a = new l();
  }
  
  private class b
  {
    int a = 0;
    double b = 0.0D;
    
    public b() {}
  }
  
  private class c
  {
    private boolean b;
    private boolean c;
    private long d;
    private int e;
    private int f;
    private ArrayList<String> g;
    private ArrayList<Integer> h;
    private int i;
    private double j;
    private double k;
    private double l;
    private int m;
    private int n;
    private l.b o;
    
    public c(int paramInt1, int paramInt2)
    {
      a(paramInt1, paramInt2);
      this.i = 0;
      this.j = 0.0D;
      this.k = 0.0D;
      this.l = 0.0D;
      this.m = 0;
      this.n = 0;
      this.o = new l.b(l.this);
    }
    
    private l.b a(int paramInt, double paramDouble)
    {
      l.b localb = a(l.c());
      double d1;
      if (paramDouble >= -1000000000.0D)
      {
        d1 = paramDouble;
        if (1000000000.0D >= paramDouble) {}
      }
      else
      {
        d1 = 0.0D;
      }
      int i1 = localb.a;
      int i2 = (int)d1;
      localb.a = (i1 + (paramInt * 604800 + i2));
      localb.b = (d1 - i2);
      return localb;
    }
    
    private l.b a(double[] paramArrayOfDouble)
    {
      l.b localb = new l.b(l.this);
      int i2 = 0;
      int i3 = (int)paramArrayOfDouble[0];
      int i7 = (int)paramArrayOfDouble[1];
      int i4 = (int)paramArrayOfDouble[2];
      if ((i3 >= 1970) && (2099 >= i3) && (i7 >= 1))
      {
        if (12 < i7) {
          return localb;
        }
        int i5 = (i3 - 1969) / 4;
        int i6 = new int[] { 1, 32, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335 }[(i7 - 1)];
        int i1 = i2;
        if (i3 % 4 == 0)
        {
          i1 = i2;
          if (i7 >= 3) {
            i1 = 1;
          }
        }
        i2 = (int)Math.floor(paramArrayOfDouble[5]);
        localb.a = (((i3 - 1970) * 365 + i5 + i6 + i4 - 2 + i1) * 86400 + (int)paramArrayOfDouble[3] * 3600 + (int)paramArrayOfDouble[4] * 60 + i2);
        localb.b = (paramArrayOfDouble[5] - i2);
      }
      return localb;
    }
    
    @TargetApi(24)
    private String a(GnssNavigationMessage paramGnssNavigationMessage)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramGnssNavigationMessage = paramGnssNavigationMessage.getData();
      int i2 = paramGnssNavigationMessage.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder.append(String.format("%8s", new Object[] { Integer.toBinaryString(paramGnssNavigationMessage[i1] & 0xFF) }).replace(' ', '0'));
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    
    private void a()
    {
      int i1;
      if (this.g.size() != 0)
      {
        i1 = 0;
        while (i1 < this.g.size())
        {
          if (((String)this.g.get(i1)).contains("None")) {
            break label57;
          }
          i1 += 1;
        }
        i1 = 1;
      }
      else
      {
        label57:
        i1 = 0;
      }
      if (i1 != 0)
      {
        this.c = true;
        return;
      }
      this.c = false;
    }
    
    private void a(int paramInt1, int paramInt2)
    {
      int i3 = this.f;
      int i2 = 5;
      int i1 = i2;
      if (i3 != 257)
      {
        i1 = i2;
        if (i3 != 769) {
          if (i3 != 1537)
          {
            if (i3 != 1281)
            {
              if (i3 != 1282) {
                i1 = 0;
              } else {
                i1 = 10;
              }
            }
            else {
              i1 = 3;
            }
          }
          else {
            i1 = 6;
          }
        }
      }
      ArrayList localArrayList = this.g;
      if (localArrayList != null) {
        localArrayList.clear();
      } else {
        this.g = new ArrayList();
      }
      localArrayList = this.h;
      if (localArrayList != null) {
        localArrayList.clear();
      } else {
        this.h = new ArrayList();
      }
      i2 = 0;
      while (i2 < i1)
      {
        this.g.add("None");
        i2 += 1;
      }
      this.e = paramInt1;
      this.f = paramInt2;
      this.b = false;
      this.c = false;
      this.d = 0L;
    }
    
    @TargetApi(24)
    private void a(GnssNavigationMessage paramGnssNavigationMessage, long paramLong)
    {
      int i5 = paramGnssNavigationMessage.getType();
      int i1 = paramGnssNavigationMessage.getSvid();
      int i4 = paramGnssNavigationMessage.getSubmessageId();
      Object localObject = paramGnssNavigationMessage.getData();
      if ((paramLong - this.d > 1200L) || (this.b) || (this.g.size() == 0) || (i5 != this.f) || (i1 != this.e)) {
        a(i1, i5);
      }
      if (((i5 == 1282) || (i5 == 1281)) && (!b())) {
        a(i1, i5);
      }
      if (this.g.size() == 0) {
        return;
      }
      int i6 = this.f;
      int i3 = 1;
      if (i6 == 1537) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      int i2 = i4;
      if (i6 == 1282) {
        if (i4 == 1)
        {
          e(b(paramGnssNavigationMessage));
          i2 = this.m;
        }
        else
        {
          return;
        }
      }
      i4 = i2 - i1;
      if (i4 >= this.g.size()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      i6 = localObject.length;
      i1 = 0;
      i2 = i3;
      while (i1 < i6)
      {
        i3 = localObject[i1];
        if (i2 != 0) {
          i2 = 0;
        } else {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(i3);
        i1 += 1;
      }
      localObject = localStringBuilder.toString();
      this.g.set(i4, localObject);
      if ((i5 == 1281) || (i5 == 1282)) {
        this.h.add(Integer.valueOf(i4));
      }
      if (this.f == 1537) {
        a(a(paramGnssNavigationMessage));
      }
      a();
      this.d = paramLong;
    }
    
    private void a(String paramString)
    {
      int i1 = paramString.charAt(0);
      int i2 = paramString.charAt(120);
      StringBuilder localStringBuilder;
      if ((i1 == 49) && (i2 == 48))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.substring(2, 18));
      }
      for (i1 = 234;; i1 = 138)
      {
        localStringBuilder.append(paramString.substring(122, i1));
        paramString = localStringBuilder.toString();
        break;
        if ((i1 != 48) || (i2 != 49)) {
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString.substring(2, 114));
      }
      i1 = Integer.parseInt(paramString.substring(0, 6), 2);
      if (i1 == 0)
      {
        b(paramString);
        return;
      }
      if (i1 == 1)
      {
        c(paramString);
        return;
      }
      if (i1 == 4) {
        d(paramString);
      }
    }
    
    @TargetApi(24)
    private String b(GnssNavigationMessage paramGnssNavigationMessage)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      byte[] arrayOfByte = paramGnssNavigationMessage.getData();
      int i2 = arrayOfByte.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = String.format("%8s", new Object[] { Integer.toBinaryString(arrayOfByte[i1] & 0xFF) }).replace(' ', '0');
        paramGnssNavigationMessage = str;
        if (i1 % 4 == 0) {
          paramGnssNavigationMessage = str.substring(2, 8);
        }
        localStringBuilder.append(paramGnssNavigationMessage);
        i1 += 1;
      }
      return localStringBuilder.toString();
    }
    
    private void b(String paramString)
    {
      this.i = Integer.parseInt(paramString.substring(96, 108), 2);
      this.j = Long.parseLong(paramString.substring(108, 128), 2);
    }
    
    private boolean b()
    {
      if (this.h == null) {
        return false;
      }
      int i1 = 0;
      while (i1 < this.h.size())
      {
        if (((Integer)this.h.get(i1)).intValue() != i1) {
          return false;
        }
        i1 += 1;
      }
      return true;
    }
    
    private String c()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (!this.c) {
        return localStringBuilder.toString();
      }
      if (this.f == 1537) {
        d();
      }
      localStringBuilder.append(this.o.a);
      localStringBuilder.append('|');
      int i1 = 0;
      int i2 = 1;
      while (i1 < this.g.size())
      {
        if (i2 != 0) {
          i2 = 0;
        } else {
          localStringBuilder.append(',');
        }
        localStringBuilder.append((String)this.g.get(i1));
        i1 += 1;
      }
      this.b = true;
      return localStringBuilder.toString();
    }
    
    private void c(String paramString)
    {
      this.k = (Long.parseLong(paramString.substring(16, 30), 2) * 60.0D);
    }
    
    private void d()
    {
      l.b localb1 = a(this.i, this.j);
      l.b localb2 = a(this.i, this.k);
      double d1 = localb2.a - localb1.a + localb2.b - localb1.b;
      if (d1 > 302400.0D) {}
      for (int i1 = this.i - 1;; i1 = this.i + 1)
      {
        this.i = i1;
        break;
        if (d1 >= -302400.0D) {
          break;
        }
      }
      this.o = a(this.i, this.l);
      this.n = (this.i + 1024);
    }
    
    private void d(String paramString)
    {
      this.l = (Long.parseLong(paramString.substring(54, 68), 2) * 60L);
    }
    
    private void e(String paramString)
    {
      this.m = Integer.parseInt(paramString.substring(42, 46), 2);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.l
 * JD-Core Version:    0.7.0.1
 */