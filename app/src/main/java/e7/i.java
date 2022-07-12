package e7;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class i
{
  private long a;
  private long b;
  private TimeInterpolator c;
  private int d;
  private int e;
  
  public i(long paramLong1, long paramLong2)
  {
    this.c = null;
    this.d = 0;
    this.e = 1;
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public i(long paramLong1, long paramLong2, TimeInterpolator paramTimeInterpolator)
  {
    this.d = 0;
    this.e = 1;
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramTimeInterpolator;
  }
  
  static i b(ValueAnimator paramValueAnimator)
  {
    i locali = new i(paramValueAnimator.getStartDelay(), paramValueAnimator.getDuration(), f(paramValueAnimator));
    locali.d = paramValueAnimator.getRepeatCount();
    locali.e = paramValueAnimator.getRepeatMode();
    return locali;
  }
  
  private static TimeInterpolator f(ValueAnimator paramValueAnimator)
  {
    TimeInterpolator localTimeInterpolator = paramValueAnimator.getInterpolator();
    if ((!(localTimeInterpolator instanceof AccelerateDecelerateInterpolator)) && (localTimeInterpolator != null))
    {
      if ((localTimeInterpolator instanceof AccelerateInterpolator)) {
        return a.c;
      }
      paramValueAnimator = localTimeInterpolator;
      if ((localTimeInterpolator instanceof DecelerateInterpolator)) {
        paramValueAnimator = a.d;
      }
      return paramValueAnimator;
    }
    return a.b;
  }
  
  public void a(Animator paramAnimator)
  {
    paramAnimator.setStartDelay(c());
    paramAnimator.setDuration(d());
    paramAnimator.setInterpolator(e());
    if ((paramAnimator instanceof ValueAnimator))
    {
      paramAnimator = (ValueAnimator)paramAnimator;
      paramAnimator.setRepeatCount(g());
      paramAnimator.setRepeatMode(h());
    }
  }
  
  public long c()
  {
    return this.a;
  }
  
  public long d()
  {
    return this.b;
  }
  
  public TimeInterpolator e()
  {
    TimeInterpolator localTimeInterpolator = this.c;
    if (localTimeInterpolator != null) {
      return localTimeInterpolator;
    }
    return a.b;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof i)) {
      return false;
    }
    paramObject = (i)paramObject;
    if (c() != paramObject.c()) {
      return false;
    }
    if (d() != paramObject.d()) {
      return false;
    }
    if (g() != paramObject.g()) {
      return false;
    }
    if (h() != paramObject.h()) {
      return false;
    }
    return e().getClass().equals(paramObject.e().getClass());
  }
  
  public int g()
  {
    return this.d;
  }
  
  public int h()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    return ((((int)(c() ^ c() >>> 32) * 31 + (int)(d() ^ d() >>> 32)) * 31 + e().getClass().hashCode()) * 31 + g()) * 31 + h();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" delay: ");
    localStringBuilder.append(c());
    localStringBuilder.append(" duration: ");
    localStringBuilder.append(d());
    localStringBuilder.append(" interpolator: ");
    localStringBuilder.append(e().getClass());
    localStringBuilder.append(" repeatCount: ");
    localStringBuilder.append(g());
    localStringBuilder.append(" repeatMode: ");
    localStringBuilder.append(h());
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e7.i
 * JD-Core Version:    0.7.0.1
 */