package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import java.util.Map;

public class ChangeClipBounds
  extends Transition
{
  private static final String[] L = { "android:clipBounds:clip" };
  
  public ChangeClipBounds() {}
  
  public ChangeClipBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void l0(t paramt)
  {
    Object localObject = paramt.b;
    if (((View)localObject).getVisibility() == 8) {
      return;
    }
    Rect localRect = x.u((View)localObject);
    paramt.a.put("android:clipBounds:clip", localRect);
    if (localRect == null)
    {
      localObject = new Rect(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
      paramt.a.put("android:clipBounds:bounds", localObject);
    }
  }
  
  public String[] I()
  {
    return L;
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
    Object localObject = null;
    paramViewGroup = (ViewGroup)localObject;
    if (paramt1 != null)
    {
      paramViewGroup = (ViewGroup)localObject;
      if (paramt2 != null)
      {
        paramViewGroup = (ViewGroup)localObject;
        if (paramt1.a.containsKey("android:clipBounds:clip"))
        {
          if (!paramt2.a.containsKey("android:clipBounds:clip")) {
            return null;
          }
          localObject = (Rect)paramt1.a.get("android:clipBounds:clip");
          Rect localRect = (Rect)paramt2.a.get("android:clipBounds:clip");
          int i;
          if (localRect == null) {
            i = 1;
          } else {
            i = 0;
          }
          if ((localObject == null) && (localRect == null)) {
            return null;
          }
          if (localObject == null)
          {
            paramViewGroup = (Rect)paramt1.a.get("android:clipBounds:bounds");
            paramt1 = localRect;
          }
          else
          {
            paramViewGroup = (ViewGroup)localObject;
            paramt1 = localRect;
            if (localRect == null)
            {
              paramt1 = (Rect)paramt2.a.get("android:clipBounds:bounds");
              paramViewGroup = (ViewGroup)localObject;
            }
          }
          if (paramViewGroup.equals(paramt1)) {
            return null;
          }
          x.x0(paramt2.b, paramViewGroup);
          localObject = new n(new Rect());
          paramt1 = ObjectAnimator.ofObject(paramt2.b, b0.c, (TypeEvaluator)localObject, new Rect[] { paramViewGroup, paramt1 });
          paramViewGroup = paramt1;
          if (i != 0)
          {
            paramt1.addListener(new a(paramt2.b));
            paramViewGroup = paramt1;
          }
        }
      }
    }
    return paramViewGroup;
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a(View paramView) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      x.x0(this.a, null);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.ChangeClipBounds
 * JD-Core Version:    0.7.0.1
 */