package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

public class AutoTransition
  extends TransitionSet
{
  public AutoTransition()
  {
    y0();
  }
  
  public AutoTransition(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    y0();
  }
  
  private void y0()
  {
    v0(1);
    n0(new Fade(2)).n0(new ChangeBounds()).n0(new Fade(1));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.AutoTransition
 * JD-Core Version:    0.7.0.1
 */