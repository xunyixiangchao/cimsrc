package g1;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.d;

class h
  implements TransformationMethod
{
  private final TransformationMethod a;
  
  h(TransformationMethod paramTransformationMethod)
  {
    this.a = paramTransformationMethod;
  }
  
  public TransformationMethod a()
  {
    return this.a;
  }
  
  public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
  {
    if (paramView.isInEditMode()) {
      return paramCharSequence;
    }
    TransformationMethod localTransformationMethod = this.a;
    CharSequence localCharSequence = paramCharSequence;
    if (localTransformationMethod != null) {
      localCharSequence = localTransformationMethod.getTransformation(paramCharSequence, paramView);
    }
    paramCharSequence = localCharSequence;
    if (localCharSequence != null)
    {
      if (d.b().d() != 1) {
        return localCharSequence;
      }
      paramCharSequence = d.b().o(localCharSequence);
    }
    return paramCharSequence;
  }
  
  public void onFocusChanged(View paramView, CharSequence paramCharSequence, boolean paramBoolean, int paramInt, Rect paramRect)
  {
    TransformationMethod localTransformationMethod = this.a;
    if (localTransformationMethod != null) {
      localTransformationMethod.onFocusChanged(paramView, paramCharSequence, paramBoolean, paramInt, paramRect);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g1.h
 * JD-Core Version:    0.7.0.1
 */