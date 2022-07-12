package com.baidu.vi;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import java.util.List;

public class VCompass
{
  private SensorManager a = null;
  private float b;
  private float c = 2.0F;
  private SensorEventListener d = new b();
  
  static
  {
    new a();
  }
  
  private float a(float paramFloat)
  {
    paramFloat = a(this.b, paramFloat, this.c);
    this.b = paramFloat;
    return paramFloat;
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f = paramFloat1 - paramFloat2;
    if (f <= 180.0F)
    {
      if (f < -180.0F) {
        return paramFloat2;
      }
      if ((f >= -paramFloat3) && (paramFloat3 >= f)) {
        return paramFloat1;
      }
      return (paramFloat1 + paramFloat2) / 2.0F;
    }
    return paramFloat2;
  }
  
  private native void updateCompass(int paramInt);
  
  static final class a
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      VCompass localVCompass = (VCompass)paramMessage.obj;
      if (localVCompass == null) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        VCompass.a(localVCompass).unregisterListener(VCompass.b(localVCompass));
        return;
      }
      paramMessage = VIContext.getContext();
      if (VCompass.a(localVCompass) == null) {
        VCompass.a(localVCompass, (SensorManager)paramMessage.getSystemService("sensor"));
      }
      paramMessage = VCompass.a(localVCompass).getSensorList(3);
      if (paramMessage.size() > 0)
      {
        paramMessage = (Sensor)paramMessage.get(0);
        VCompass.a(localVCompass).registerListener(VCompass.b(localVCompass), paramMessage, 1);
      }
    }
  }
  
  class b
    implements SensorEventListener
  {
    b() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (paramSensorEvent.sensor.getType() != 3) {
        return;
      }
      int i = (int)VCompass.a(VCompass.this, paramSensorEvent.values[0]);
      VCompass.a(VCompass.this, i);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.vi.VCompass
 * JD-Core Version:    0.7.0.1
 */