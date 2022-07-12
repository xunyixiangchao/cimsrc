package com.baidu.vi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.util.Iterator;

public class VGps
{
  private static int f = 3;
  @SuppressLint({"HandlerLeak"})
  private static Handler g = new c();
  private GpsStatus.Listener a = new a();
  private LocationListener b = new b();
  private LocationManager c = null;
  private GpsStatus d = null;
  private int e = 0;
  
  private void b()
  {
    try
    {
      if (!g.hasMessages(1))
      {
        Message localMessage = g.obtainMessage(1, this);
        g.sendMessageDelayed(localMessage, 3000L);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getGpsSatellitesNum()
  {
    return this.e;
  }
  
  public boolean init()
  {
    g.removeMessages(2);
    Handler localHandler = g;
    localHandler.sendMessage(localHandler.obtainMessage(2, this));
    return true;
  }
  
  public boolean unInit()
  {
    g.removeMessages(1);
    g.removeMessages(3);
    Handler localHandler = g;
    localHandler.sendMessage(localHandler.obtainMessage(3, this));
    return true;
  }
  
  public native void updateGps(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
  
  class a
    implements GpsStatus.Listener
  {
    a() {}
    
    public void onGpsStatusChanged(int paramInt)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          return;
        }
        if (VGps.a(VGps.this) != null) {
          if (VGps.b(VGps.this) == null)
          {
            localObject = VGps.this;
            VGps.a((VGps)localObject, VGps.a((VGps)localObject).getGpsStatus(null));
          }
          else
          {
            VGps.a(VGps.this).getGpsStatus(VGps.b(VGps.this));
          }
        }
        Object localObject = VGps.b(VGps.this).getSatellites().iterator();
        paramInt = 0;
        while (((Iterator)localObject).hasNext()) {
          if (((GpsSatellite)((Iterator)localObject).next()).usedInFix()) {
            paramInt += 1;
          }
        }
        if ((paramInt < VGps.a()) && (VGps.c(VGps.this) >= VGps.a())) {
          VGps.d(VGps.this);
        }
        VGps.a(VGps.this, paramInt);
        return;
      }
      VGps.this.updateGps(0.0D, 0.0D, 0.0F, 0.0F, 0.0F, 0);
    }
  }
  
  class b
    implements LocationListener
  {
    b() {}
    
    public void onLocationChanged(Location paramLocation)
    {
      if (paramLocation != null)
      {
        float f = 0.0F;
        if (paramLocation.hasAccuracy()) {
          f = paramLocation.getAccuracy();
        }
        if (VGps.c(VGps.this) >= VGps.a())
        {
          VGps.this.updateGps(paramLocation.getLongitude(), paramLocation.getLatitude(), (float)(paramLocation.getSpeed() * 3.6D), paramLocation.getBearing(), f, VGps.c(VGps.this));
          return;
        }
        VGps.d(VGps.this);
      }
    }
    
    public void onProviderDisabled(String paramString)
    {
      VGps.this.updateGps(0.0D, 0.0D, 0.0F, 0.0F, 0.0F, 0);
    }
    
    public void onProviderEnabled(String paramString) {}
    
    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        return;
      }
      VGps.this.updateGps(0.0D, 0.0D, 0.0F, 0.0F, 0.0F, 0);
    }
  }
  
  static final class c
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      VGps localVGps = (VGps)paramMessage.obj;
      if (localVGps == null) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          if (VGps.a(localVGps) != null)
          {
            VGps.a(localVGps).removeGpsStatusListener(VGps.e(localVGps));
            VGps.a(localVGps).removeUpdates(VGps.f(localVGps));
          }
        }
        else if (VIContext.getContext() != null)
        {
          VGps.a(localVGps, (LocationManager)VIContext.getContext().getSystemService("location"));
          VGps.a(localVGps).addGpsStatusListener(VGps.e(localVGps));
        }
      }
      else if (VGps.c(localVGps) < VGps.a()) {
        localVGps.updateGps(0.0D, 0.0D, 0.0F, 0.0F, 0.0F, 0);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.vi.VGps
 * JD-Core Version:    0.7.0.1
 */