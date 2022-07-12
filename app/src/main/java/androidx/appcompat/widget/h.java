package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R.styleable;
import g1.a;

class h
{
  private final EditText a;
  private final a b;
  
  h(EditText paramEditText)
  {
    this.a = paramEditText;
    this.b = new a(paramEditText, false);
  }
  
  KeyListener a(KeyListener paramKeyListener)
  {
    KeyListener localKeyListener = paramKeyListener;
    if (b(paramKeyListener)) {
      localKeyListener = this.b.a(paramKeyListener);
    }
    return localKeyListener;
  }
  
  boolean b(KeyListener paramKeyListener)
  {
    return paramKeyListener instanceof NumberKeyListener ^ true;
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
  
  InputConnection d(InputConnection paramInputConnection, EditorInfo paramEditorInfo)
  {
    return this.b.b(paramInputConnection, paramEditorInfo);
  }
  
  void e(boolean paramBoolean)
  {
    this.b.c(paramBoolean);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.h
 * JD-Core Version:    0.7.0.1
 */