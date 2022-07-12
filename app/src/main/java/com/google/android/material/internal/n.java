package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.t;
import java.util.Map;

public class n
  extends Transition
{
  private void l0(t paramt)
  {
    Object localObject = paramt.b;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      paramt.a.put("android:textscale:scale", Float.valueOf(((TextView)localObject).getScaleX()));
    }
  }
  
  public void j(t paramt)
  {
    l0(paramt);
  }
  
  public void m(t paramt)
  {
    l0(paramt);
  }
  
  public Animator q(ViewGroup paramViewGroup, t paramt1, t paramt2)
  {
    final TextView localTextView = null;
    paramViewGroup = localTextView;
    if (paramt1 != null)
    {
      paramViewGroup = localTextView;
      if (paramt2 != null)
      {
        paramViewGroup = localTextView;
        if ((paramt1.b instanceof TextView))
        {
          paramViewGroup = paramt2.b;
          if (!(paramViewGroup instanceof TextView)) {
            return null;
          }
          localTextView = (TextView)paramViewGroup;
          paramViewGroup = paramt1.a;
          paramt1 = paramt2.a;
          paramt2 = paramViewGroup.get("android:textscale:scale");
          float f2 = 1.0F;
          float f1;
          if (paramt2 != null) {
            f1 = ((Float)paramViewGroup.get("android:textscale:scale")).floatValue();
          } else {
            f1 = 1.0F;
          }
          if (paramt1.get("android:textscale:scale") != null) {
            f2 = ((Float)paramt1.get("android:textscale:scale")).floatValue();
          }
          if (f1 == f2) {
            return null;
          }
          paramViewGroup = ValueAnimator.ofFloat(new float[] { f1, f2 });
          paramViewGroup.addUpdateListener(new a(localTextView));
        }
      }
    }
    return paramViewGroup;
  }
  
  class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(TextView paramTextView) {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      localTextView.setScaleX(f);
      localTextView.setScaleY(f);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.n
 * JD-Core Version:    0.7.0.1
 */