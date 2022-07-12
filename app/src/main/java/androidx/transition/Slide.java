package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.x;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import p0.i;
import t1.b;
import t1.c;

public class Slide
  extends Visibility
{
  private static final TimeInterpolator P = new DecelerateInterpolator();
  private static final TimeInterpolator Q = new AccelerateInterpolator();
  private static final g R = new a();
  private static final g S = new b();
  private static final g T = new c();
  private static final g U = new d();
  private static final g V = new e();
  private static final g W = new f();
  private g N = W;
  private int O = 80;
  
  public Slide()
  {
    t0(80);
  }
  
  @SuppressLint({"RestrictedApi"})
  public Slide(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.h);
    int i = i.g(paramContext, (XmlPullParser)paramAttributeSet, "slideEdge", 0, 80);
    paramContext.recycle();
    t0(i);
  }
  
  private void l0(t paramt)
  {
    View localView = paramt.b;
    int[] arrayOfInt = new int[2];
    localView.getLocationOnScreen(arrayOfInt);
    paramt.a.put("android:slide:screenPosition", arrayOfInt);
  }
  
  public void j(t paramt)
  {
    super.j(paramt);
    l0(paramt);
  }
  
  public void m(t paramt)
  {
    super.m(paramt);
    l0(paramt);
  }
  
  public Animator o0(ViewGroup paramViewGroup, View paramView, t paramt1, t paramt2)
  {
    if (paramt2 == null) {
      return null;
    }
    paramt1 = (int[])paramt2.a.get("android:slide:screenPosition");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    float f3 = this.N.b(paramViewGroup, paramView);
    float f4 = this.N.a(paramViewGroup, paramView);
    return v.a(paramView, paramt2, paramt1[0], paramt1[1], f3, f4, f1, f2, P, this);
  }
  
  public Animator q0(ViewGroup paramViewGroup, View paramView, t paramt1, t paramt2)
  {
    if (paramt1 == null) {
      return null;
    }
    paramt2 = (int[])paramt1.a.get("android:slide:screenPosition");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    float f3 = this.N.b(paramViewGroup, paramView);
    float f4 = this.N.a(paramViewGroup, paramView);
    return v.a(paramView, paramt1, paramt2[0], paramt2[1], f1, f2, f3, f4, Q, this);
  }
  
  public void t0(int paramInt)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 48)
        {
          if (paramInt != 80)
          {
            if (paramInt != 8388611)
            {
              if (paramInt == 8388613) {
                localObject = V;
              } else {
                throw new IllegalArgumentException("Invalid slide direction");
              }
            }
            else {
              localObject = S;
            }
          }
          else {
            localObject = W;
          }
        }
        else {
          localObject = T;
        }
      }
      else {
        localObject = U;
      }
    }
    else {
      localObject = R;
    }
    this.N = ((g)localObject);
    this.O = paramInt;
    Object localObject = new b();
    ((b)localObject).j(paramInt);
    h0((c)localObject);
  }
  
  static final class a
    extends Slide.h
  {
    a()
    {
      super();
    }
    
    public float b(ViewGroup paramViewGroup, View paramView)
    {
      return paramView.getTranslationX() - paramViewGroup.getWidth();
    }
  }
  
  static final class b
    extends Slide.h
  {
    b()
    {
      super();
    }
    
    public float b(ViewGroup paramViewGroup, View paramView)
    {
      int j = x.B(paramViewGroup);
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      float f1 = paramView.getTranslationX();
      float f2 = paramViewGroup.getWidth();
      if (i != 0) {
        return f1 + f2;
      }
      return f1 - f2;
    }
  }
  
  static final class c
    extends Slide.i
  {
    c()
    {
      super();
    }
    
    public float a(ViewGroup paramViewGroup, View paramView)
    {
      return paramView.getTranslationY() - paramViewGroup.getHeight();
    }
  }
  
  static final class d
    extends Slide.h
  {
    d()
    {
      super();
    }
    
    public float b(ViewGroup paramViewGroup, View paramView)
    {
      return paramView.getTranslationX() + paramViewGroup.getWidth();
    }
  }
  
  static final class e
    extends Slide.h
  {
    e()
    {
      super();
    }
    
    public float b(ViewGroup paramViewGroup, View paramView)
    {
      int j = x.B(paramViewGroup);
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      float f1 = paramView.getTranslationX();
      float f2 = paramViewGroup.getWidth();
      if (i != 0) {
        return f1 - f2;
      }
      return f1 + f2;
    }
  }
  
  static final class f
    extends Slide.i
  {
    f()
    {
      super();
    }
    
    public float a(ViewGroup paramViewGroup, View paramView)
    {
      return paramView.getTranslationY() + paramViewGroup.getHeight();
    }
  }
  
  private static abstract interface g
  {
    public abstract float a(ViewGroup paramViewGroup, View paramView);
    
    public abstract float b(ViewGroup paramViewGroup, View paramView);
  }
  
  private static abstract class h
    implements Slide.g
  {
    public float a(ViewGroup paramViewGroup, View paramView)
    {
      return paramView.getTranslationY();
    }
  }
  
  private static abstract class i
    implements Slide.g
  {
    public float b(ViewGroup paramViewGroup, View paramView)
    {
      return paramView.getTranslationX();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.Slide
 * JD-Core Version:    0.7.0.1
 */