package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

public class ChangeScroll
  extends Transition
{
  private static final String[] L = { "android:changeScroll:x", "android:changeScroll:y" };
  
  public ChangeScroll() {}
  
  public ChangeScroll(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void l0(t paramt)
  {
    paramt.a.put("android:changeScroll:x", Integer.valueOf(paramt.b.getScrollX()));
    paramt.a.put("android:changeScroll:y", Integer.valueOf(paramt.b.getScrollY()));
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
    paramViewGroup = null;
    Object localObject = null;
    if (paramt1 != null)
    {
      if (paramt2 == null) {
        return null;
      }
      View localView = paramt2.b;
      int i = ((Integer)paramt1.a.get("android:changeScroll:x")).intValue();
      int j = ((Integer)paramt2.a.get("android:changeScroll:x")).intValue();
      int k = ((Integer)paramt1.a.get("android:changeScroll:y")).intValue();
      int m = ((Integer)paramt2.a.get("android:changeScroll:y")).intValue();
      if (i != j)
      {
        localView.setScrollX(i);
        paramViewGroup = ObjectAnimator.ofInt(localView, "scrollX", new int[] { i, j });
      }
      else
      {
        paramViewGroup = null;
      }
      paramt1 = localObject;
      if (k != m)
      {
        localView.setScrollY(k);
        paramt1 = ObjectAnimator.ofInt(localView, "scrollY", new int[] { k, m });
      }
      paramViewGroup = s.c(paramViewGroup, paramt1);
    }
    return paramViewGroup;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.ChangeScroll
 * JD-Core Version:    0.7.0.1
 */