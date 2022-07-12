package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.f;

public class m
  implements SensorEventListener
{
  private static m c;
  private float[] a;
  private SensorManager b;
  private float d;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  
  public static m a()
  {
    try
    {
      if (c == null) {
        c = new m();
      }
      m localm = c;
      return localm;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b()
  {
    try
    {
      boolean bool = this.g;
      if (bool) {
        return;
      }
      bool = this.e;
      if (!bool) {
        return;
      }
      if (this.b == null) {
        this.b = ((SensorManager)f.getServiceContext().getSystemService("sensor"));
      }
      Object localObject1 = this.b;
      if (localObject1 != null)
      {
        localObject1 = ((SensorManager)localObject1).getDefaultSensor(11);
        if ((localObject1 != null) && (this.e)) {
          this.b.registerListener(this, (Sensor)localObject1, 3);
        }
      }
      this.g = true;
      return;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      boolean bool = this.g;
      if (!bool) {
        return;
      }
      SensorManager localSensorManager = this.b;
      if (localSensorManager != null)
      {
        localSensorManager.unregisterListener(this);
        this.b = null;
      }
      this.g = false;
      return;
    }
    finally {}
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public float e()
  {
    return this.d;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  @SuppressLint({"NewApi"})
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 11) {
      return;
    }
    float[] arrayOfFloat = (float[])paramSensorEvent.values.clone();
    this.a = arrayOfFloat;
    paramSensorEvent = new float[9];
    float f1;
    try
    {
      SensorManager.getRotationMatrixFromVector(paramSensorEvent, arrayOfFloat);
      arrayOfFloat = new float[3];
      SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
      f1 = (float)Math.toDegrees(arrayOfFloat[0]);
      this.d = f1;
      if (f1 < 0.0F) {
        break label108;
      }
    }
    catch (Exception paramSensorEvent)
    {
      Object localObject;
      label91:
      break label91;
    }
    this.d = ((float)Math.floor(localObject));
    return;
    this.d = 0.0F;
    return;
    for (;;)
    {
      double d1 = f1;
      break;
      label108:
      f1 += 360.0F;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.m
 * JD-Core Version:    0.7.0.1
 */