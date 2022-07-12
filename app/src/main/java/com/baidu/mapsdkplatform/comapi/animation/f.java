package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.Animation.AnimationListener;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;

public class f
  extends BDAnimation
{
  private Animator a = null;
  private long b = 0L;
  private Interpolator c = null;
  private Animation.AnimationListener d = null;
  private int e = 1;
  private int f = 0;
  private Object[] g;
  
  public f(Point... paramVarArgs)
  {
    this.g = paramVarArgs;
  }
  
  public f(LatLng... paramVarArgs)
  {
    this.g = paramVarArgs;
  }
  
  public int a()
  {
    return this.e;
  }
  
  @TargetApi(11)
  ObjectAnimator a(Marker paramMarker)
  {
    Object localObject;
    if (paramMarker.isFixed())
    {
      localObject = this.g;
      if ((localObject[0] instanceof Point)) {
        paramMarker = ObjectAnimator.ofObject(paramMarker, "fixedScreenPosition", new c(), (Object[])localObject);
      } else {
        throw new ClassCastException("BDMapSDKException: if the marker is fixed on screen, the parameters of Transformation must be android.graphics.Point");
      }
    }
    else
    {
      localObject = this.g;
      if (!(localObject[0] instanceof LatLng)) {
        break label125;
      }
      paramMarker = ObjectAnimator.ofObject(paramMarker, "position", new b(), (Object[])localObject);
    }
    if (paramMarker != null)
    {
      paramMarker.setRepeatCount(this.f);
      paramMarker.setRepeatMode(a());
      paramMarker.setDuration(this.b);
      localObject = this.c;
      if (localObject != null) {
        paramMarker.setInterpolator((TimeInterpolator)localObject);
      }
    }
    return paramMarker;
    label125:
    throw new ClassCastException("BDMapSDKException: if the marker isn't fixed on screen, the parameters of Transformation must be Latlng");
  }
  
  @TargetApi(11)
  protected void addAnimationListener(Animator paramAnimator)
  {
    if (paramAnimator == null) {
      return;
    }
    paramAnimator.addListener(new a());
  }
  
  @TargetApi(11)
  public void cancelAnimation()
  {
    Animator localAnimator = this.a;
    if (localAnimator != null)
    {
      localAnimator.cancel();
      this.a = null;
    }
  }
  
  @TargetApi(11)
  public void setAnimation(Marker paramMarker, Animation paramAnimation)
  {
    paramMarker = a(paramMarker);
    this.a = paramMarker;
    addAnimationListener(paramMarker);
  }
  
  public void setAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.d = paramAnimationListener;
  }
  
  public void setAnimatorSetMode(int paramInt) {}
  
  public void setDuration(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.b = l;
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.c = paramInterpolator;
  }
  
  public void setRepeatCount(int paramInt)
  {
    if ((paramInt > 0) || (paramInt == -1)) {
      this.f = paramInt;
    }
  }
  
  public void setRepeatMode(int paramInt)
  {
    this.e = paramInt;
  }
  
  @TargetApi(11)
  public void startAnimation()
  {
    Animator localAnimator = this.a;
    if (localAnimator == null) {
      return;
    }
    localAnimator.start();
  }
  
  class a
    implements Animator.AnimatorListener
  {
    a() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      if (f.a(f.this) != null) {
        f.a(f.this).onAnimationCancel();
      }
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (f.a(f.this) != null) {
        f.a(f.this).onAnimationEnd();
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator)
    {
      if (f.a(f.this) != null) {
        f.a(f.this).onAnimationRepeat();
      }
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      if (f.a(f.this) != null) {
        f.a(f.this).onAnimationStart();
      }
    }
  }
  
  @TargetApi(11)
  public class b
    implements TypeEvaluator
  {
    public b() {}
    
    public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
    {
      paramObject1 = (LatLng)paramObject1;
      paramObject2 = (LatLng)paramObject2;
      double d1 = paramObject1.longitude;
      double d2 = paramFloat;
      double d3 = paramObject2.longitude;
      double d4 = paramObject1.latitude;
      return new LatLng(d4 + d2 * (paramObject2.latitude - d4), d1 + (d3 - d1) * d2);
    }
  }
  
  @TargetApi(11)
  public class c
    implements TypeEvaluator
  {
    public c() {}
    
    public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
    {
      paramObject1 = (Point)paramObject1;
      paramObject2 = (Point)paramObject2;
      int i = paramObject1.x;
      float f1 = i;
      float f2 = paramObject2.x - i;
      i = paramObject1.y;
      float f3 = i;
      float f4 = paramObject2.y - i;
      return new Point((int)(f1 + f2 * paramFloat), (int)(f3 + paramFloat * f4));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.animation.f
 * JD-Core Version:    0.7.0.1
 */