package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R.styleable;
import g1.f;

class i
{
  private final TextView a;
  private final f b;
  
  i(TextView paramTextView)
  {
    this.a = paramTextView;
    this.b = new f(paramTextView, false);
  }
  
  InputFilter[] a(InputFilter[] paramArrayOfInputFilter)
  {
    return this.b.a(paramArrayOfInputFilter);
  }
  
  public boolean b()
  {
    return this.b.b();
  }
  
  void c(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.a.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.AppCompatTextView, paramInt, 0);
    try
    {
      paramInt = R.styleable.AppCompatTextView_emojiCompatEnabled;
      boolean bool2 = paramAttributeSet.hasValue(paramInt);
      boolean bool1 = true;
      if (bool2) {
        bool1 = paramAttributeSet.getBoolean(paramInt, true);
      }
      paramAttributeSet.recycle();
      e(bool1);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  void d(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
  }
  
  void e(boolean paramBoolean)
  {
    this.b.d(paramBoolean);
  }
  
  public TransformationMethod f(TransformationMethod paramTransformationMethod)
  {
    return this.b.e(paramTransformationMethod);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.i
 * JD-Core Version:    0.7.0.1
 */