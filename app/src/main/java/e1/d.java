package e1;

import android.os.Looper;
import android.util.AndroidRuntimeException;

public final class d
  extends b<d>
{
  private e A = null;
  private float B = 3.4028235E+38F;
  private boolean C = false;
  
  public <K> d(K paramK, c<K> paramc)
  {
    super(paramK, paramc);
  }
  
  private void o()
  {
    e locale = this.A;
    if (locale != null)
    {
      double d = locale.a();
      if (d <= this.g)
      {
        if (d >= this.h) {
          return;
        }
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
      }
      throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    }
    throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
  }
  
  public void i()
  {
    o();
    this.A.g(d());
    super.i();
  }
  
  boolean k(long paramLong)
  {
    if (this.C)
    {
      f = this.B;
      if (f != 3.4028235E+38F)
      {
        this.A.e(f);
        this.B = 3.4028235E+38F;
      }
      this.b = this.A.a();
      this.a = 0.0F;
      this.C = false;
      return true;
    }
    double d1;
    double d2;
    if (this.B != 3.4028235E+38F)
    {
      this.A.a();
      localObject = this.A;
      d1 = this.b;
      d2 = this.a;
      paramLong /= 2L;
      b.o localo = ((e)localObject).h(d1, d2, paramLong);
      this.A.e(this.B);
      this.B = 3.4028235E+38F;
      localObject = this.A;
      d1 = localo.a;
      d2 = localo.b;
    }
    else
    {
      localObject = this.A;
      d1 = this.b;
      d2 = this.a;
    }
    Object localObject = ((e)localObject).h(d1, d2, paramLong);
    this.b = ((b.o)localObject).a;
    this.a = ((b.o)localObject).b;
    float f = Math.max(this.b, this.h);
    this.b = f;
    f = Math.min(f, this.g);
    this.b = f;
    if (n(f, this.a))
    {
      this.b = this.A.a();
      this.a = 0.0F;
      return true;
    }
    return false;
  }
  
  public void l(float paramFloat)
  {
    if (e())
    {
      this.B = paramFloat;
      return;
    }
    if (this.A == null) {
      this.A = new e(paramFloat);
    }
    this.A.e(paramFloat);
    i();
  }
  
  public boolean m()
  {
    return this.A.b > 0.0D;
  }
  
  boolean n(float paramFloat1, float paramFloat2)
  {
    return this.A.c(paramFloat1, paramFloat2);
  }
  
  public d p(e parame)
  {
    this.A = parame;
    return this;
  }
  
  public void q()
  {
    if (m())
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        if (this.f) {
          this.C = true;
        }
        return;
      }
      throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }
    throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e1.d
 * JD-Core Version:    0.7.0.1
 */