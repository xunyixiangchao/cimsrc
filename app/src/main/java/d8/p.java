package d8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

class p
  implements m
{
  private static final SensorEventListener b = new a();
  private Context a;
  
  p(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a()
  {
    SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
    try
    {
      Sensor localSensor = localSensorManager.getDefaultSensor(21);
      SensorEventListener localSensorEventListener = b;
      localSensorManager.registerListener(localSensorEventListener, localSensor, 3);
      localSensorManager.unregisterListener(localSensorEventListener, localSensor);
      return true;
    }
    finally
    {
      label40:
      break label40;
    }
    return this.a.getPackageManager().hasSystemFeature("android.hardware.sensor.heartrate") ^ true;
  }
  
  static final class a
    implements SensorEventListener
  {
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.p
 * JD-Core Version:    0.7.0.1
 */