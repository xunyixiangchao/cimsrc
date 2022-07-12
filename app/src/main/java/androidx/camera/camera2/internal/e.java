package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;
import android.os.Build.VERSION;
import androidx.camera.core.impl.utils.g.b;
import androidx.camera.core.impl.utils.g.c;
import androidx.camera.core.n1;
import s.n;
import s.n2;
import s.o;
import s.p;
import s.q;
import s.r;
import s.s;
import s.t;

public class e
  implements t
{
  private final n2 a;
  private final CaptureResult b;
  
  public e(CaptureResult paramCaptureResult)
  {
    this(n2.a(), paramCaptureResult);
  }
  
  public e(n2 paramn2, CaptureResult paramCaptureResult)
  {
    this.a = paramn2;
    this.b = paramCaptureResult;
  }
  
  public n2 a()
  {
    return this.a;
  }
  
  public void b(g.b paramb)
  {
    s.a(this, paramb);
    Object localObject = (Rect)this.b.get(CaptureResult.SCALER_CROP_REGION);
    if (localObject != null) {
      paramb.j(((Rect)localObject).width()).i(((Rect)localObject).height());
    }
    localObject = (Integer)this.b.get(CaptureResult.JPEG_ORIENTATION);
    if (localObject != null) {
      paramb.m(((Integer)localObject).intValue());
    }
    localObject = (Long)this.b.get(CaptureResult.SENSOR_EXPOSURE_TIME);
    if (localObject != null) {
      paramb.f(((Long)localObject).longValue());
    }
    localObject = (Float)this.b.get(CaptureResult.LENS_APERTURE);
    if (localObject != null) {
      paramb.l(((Float)localObject).floatValue());
    }
    Integer localInteger1 = (Integer)this.b.get(CaptureResult.SENSOR_SENSITIVITY);
    if (localInteger1 != null)
    {
      localObject = localInteger1;
      if (Build.VERSION.SDK_INT >= 24)
      {
        Integer localInteger2 = (Integer)this.b.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
        localObject = localInteger1;
        if (localInteger2 != null) {
          localObject = Integer.valueOf(localInteger1.intValue() * (int)(localInteger2.intValue() / 100.0F));
        }
      }
      paramb.k(((Integer)localObject).intValue());
    }
    localObject = (Float)this.b.get(CaptureResult.LENS_FOCAL_LENGTH);
    if (localObject != null) {
      paramb.h(((Float)localObject).floatValue());
    }
    localInteger1 = (Integer)this.b.get(CaptureResult.CONTROL_AWB_MODE);
    if (localInteger1 != null)
    {
      localObject = g.c.a;
      if (localInteger1.intValue() == 0) {
        localObject = g.c.b;
      }
      paramb.n((g.c)localObject);
    }
  }
  
  public n c()
  {
    Integer localInteger = (Integer)this.b.get(CaptureResult.CONTROL_AE_STATE);
    if (localInteger == null) {
      return n.a;
    }
    int i = localInteger.intValue();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Undefined ae state: ");
                localStringBuilder.append(localInteger);
                n1.c("C2CameraCaptureResult", localStringBuilder.toString());
                return n.a;
              }
            }
            else {
              return n.d;
            }
          }
          else {
            return n.f;
          }
        }
        else {
          return n.e;
        }
      }
      return n.c;
    }
    return n.b;
  }
  
  public q d()
  {
    Integer localInteger = (Integer)this.b.get(CaptureResult.CONTROL_AWB_STATE);
    if (localInteger == null) {
      return q.a;
    }
    int i = localInteger.intValue();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Undefined awb state: ");
            localStringBuilder.append(localInteger);
            n1.c("C2CameraCaptureResult", localStringBuilder.toString());
            return q.a;
          }
          return q.e;
        }
        return q.d;
      }
      return q.c;
    }
    return q.b;
  }
  
  public r e()
  {
    Integer localInteger = (Integer)this.b.get(CaptureResult.FLASH_STATE);
    if (localInteger == null) {
      return r.a;
    }
    int i = localInteger.intValue();
    if ((i != 0) && (i != 1))
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Undefined flash state: ");
          localStringBuilder.append(localInteger);
          n1.c("C2CameraCaptureResult", localStringBuilder.toString());
          return r.a;
        }
        return r.d;
      }
      return r.c;
    }
    return r.b;
  }
  
  public CaptureResult f()
  {
    return this.b;
  }
  
  public p g()
  {
    Integer localInteger = (Integer)this.b.get(CaptureResult.CONTROL_AF_STATE);
    if (localInteger == null) {
      return p.a;
    }
    switch (localInteger.intValue())
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Undefined af state: ");
      localStringBuilder.append(localInteger);
      n1.c("C2CameraCaptureResult", localStringBuilder.toString());
      return p.a;
    case 6: 
      return p.e;
    case 5: 
      return p.g;
    case 4: 
      return p.f;
    case 2: 
      return p.d;
    case 1: 
    case 3: 
      return p.c;
    }
    return p.b;
  }
  
  public long getTimestamp()
  {
    Long localLong = (Long)this.b.get(CaptureResult.SENSOR_TIMESTAMP);
    if (localLong == null) {
      return -1L;
    }
    return localLong.longValue();
  }
  
  public o h()
  {
    Integer localInteger = (Integer)this.b.get(CaptureResult.CONTROL_AF_MODE);
    if (localInteger == null) {
      return o.a;
    }
    int i = localInteger.intValue();
    if (i != 0) {
      if ((i != 1) && (i != 2))
      {
        if ((i != 3) && (i != 4))
        {
          if (i != 5)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Undefined af mode: ");
            localStringBuilder.append(localInteger);
            n1.c("C2CameraCaptureResult", localStringBuilder.toString());
            return o.a;
          }
        }
        else {
          return o.d;
        }
      }
      else {
        return o.c;
      }
    }
    return o.b;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.e
 * JD-Core Version:    0.7.0.1
 */