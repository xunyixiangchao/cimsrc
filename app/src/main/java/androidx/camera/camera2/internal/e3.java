package androidx.camera.camera2.internal;

import androidx.camera.core.j3;

class e3
  implements j3
{
  private float a;
  private final float b;
  private final float c;
  private float d;
  
  e3(float paramFloat1, float paramFloat2)
  {
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  private float e(float paramFloat)
  {
    float f2 = this.b;
    float f1 = this.c;
    if (f2 == f1) {
      return 0.0F;
    }
    if (paramFloat == f2) {
      return 1.0F;
    }
    if (paramFloat == f1) {
      return 0.0F;
    }
    paramFloat = 1.0F / paramFloat;
    f2 = 1.0F / f2;
    f1 = 1.0F / f1;
    return (paramFloat - f1) / (f2 - f1);
  }
  
  public float a()
  {
    return this.b;
  }
  
  public float b()
  {
    return this.a;
  }
  
  public float c()
  {
    return this.d;
  }
  
  public float d()
  {
    return this.c;
  }
  
  void f(float paramFloat)
  {
    if ((paramFloat <= this.b) && (paramFloat >= this.c))
    {
      this.a = paramFloat;
      this.d = e(paramFloat);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Requested zoomRatio ");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append(" is not within valid range [");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" , ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.e3
 * JD-Core Version:    0.7.0.1
 */