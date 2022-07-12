package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.Map;
import t1.a;

public class Explode
  extends Visibility
{
  private static final TimeInterpolator O = new DecelerateInterpolator();
  private static final TimeInterpolator P = new AccelerateInterpolator();
  private int[] N = new int[2];
  
  public Explode()
  {
    h0(new a());
  }
  
  public Explode(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h0(new a());
  }
  
  private void l0(t paramt)
  {
    View localView = paramt.b;
    localView.getLocationOnScreen(this.N);
    int[] arrayOfInt = this.N;
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = localView.getWidth();
    int m = localView.getHeight();
    paramt.a.put("android:explode:screenBounds", new Rect(i, j, k + i, m + j));
  }
  
  private static float t0(float paramFloat1, float paramFloat2)
  {
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private static float u0(View paramView, int paramInt1, int paramInt2)
  {
    paramInt1 = Math.max(paramInt1, paramView.getWidth() - paramInt1);
    paramInt2 = Math.max(paramInt2, paramView.getHeight() - paramInt2);
    return t0(paramInt1, paramInt2);
  }
  
  private void v0(View paramView, Rect paramRect, int[] paramArrayOfInt)
  {
    paramView.getLocationOnScreen(this.N);
    Object localObject = this.N;
    int k = localObject[0];
    int m = localObject[1];
    localObject = u();
    int i;
    int j;
    if (localObject == null)
    {
      i = paramView.getWidth() / 2 + k + Math.round(paramView.getTranslationX());
      j = paramView.getHeight() / 2 + m + Math.round(paramView.getTranslationY());
    }
    else
    {
      i = ((Rect)localObject).centerX();
      j = ((Rect)localObject).centerY();
    }
    int n = paramRect.centerX();
    int i1 = paramRect.centerY();
    float f3 = n - i;
    float f4 = i1 - j;
    float f2 = f3;
    float f1 = f4;
    if (f3 == 0.0F)
    {
      f2 = f3;
      f1 = f4;
      if (f4 == 0.0F)
      {
        f2 = (float)(Math.random() * 2.0D) - 1.0F;
        f1 = (float)(Math.random() * 2.0D) - 1.0F;
      }
    }
    f3 = t0(f2, f1);
    f2 /= f3;
    f1 /= f3;
    f3 = u0(paramView, i - k, j - m);
    paramArrayOfInt[0] = Math.round(f2 * f3);
    paramArrayOfInt[1] = Math.round(f3 * f1);
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
    paramt1 = (Rect)paramt2.a.get("android:explode:screenBounds");
    float f1 = paramView.getTranslationX();
    float f2 = paramView.getTranslationY();
    v0(paramViewGroup, paramt1, this.N);
    paramViewGroup = this.N;
    float f3 = paramViewGroup[0];
    float f4 = paramViewGroup[1];
    return v.a(paramView, paramt2, paramt1.left, paramt1.top, f1 + f3, f2 + f4, f1, f2, O, this);
  }
  
  public Animator q0(ViewGroup paramViewGroup, View paramView, t paramt1, t paramt2)
  {
    if (paramt1 == null) {
      return null;
    }
    paramt2 = (Rect)paramt1.a.get("android:explode:screenBounds");
    int i = paramt2.left;
    int j = paramt2.top;
    float f3 = paramView.getTranslationX();
    float f4 = paramView.getTranslationY();
    int[] arrayOfInt = (int[])paramt1.b.getTag(R.id.transition_position);
    float f1;
    float f2;
    if (arrayOfInt != null)
    {
      f1 = arrayOfInt[0] - paramt2.left + f3;
      f2 = arrayOfInt[1] - paramt2.top + f4;
      paramt2.offsetTo(arrayOfInt[0], arrayOfInt[1]);
    }
    else
    {
      f1 = f3;
      f2 = f4;
    }
    v0(paramViewGroup, paramt2, this.N);
    paramViewGroup = this.N;
    return v.a(paramView, paramt1, i, j, f3, f4, f1 + paramViewGroup[0], f2 + paramViewGroup[1], P, this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.Explode
 * JD-Core Version:    0.7.0.1
 */