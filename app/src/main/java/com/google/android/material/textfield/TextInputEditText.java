package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R.attr;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.f;
import com.google.android.material.internal.p;
import s7.a;

public class TextInputEditText
  extends AppCompatEditText
{
  private final Rect f = new Rect();
  private boolean g;
  
  public TextInputEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.editTextStyle);
  }
  
  public TextInputEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(a.c(paramContext, paramAttributeSet, paramInt, 0), paramAttributeSet, paramInt);
    paramContext = p.h(paramContext, paramAttributeSet, R.styleable.TextInputEditText, paramInt, R.style.Widget_Design_TextInputEditText, new int[0]);
    setTextInputLayoutFocusedRectEnabled(paramContext.getBoolean(R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled, false));
    paramContext.recycle();
  }
  
  private boolean c(TextInputLayout paramTextInputLayout)
  {
    return (paramTextInputLayout != null) && (this.g);
  }
  
  private CharSequence getHintFromLayout()
  {
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if (localTextInputLayout != null) {
      return localTextInputLayout.getHint();
    }
    return null;
  }
  
  private TextInputLayout getTextInputLayout()
  {
    for (ViewParent localViewParent = getParent(); (localViewParent instanceof View); localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof TextInputLayout)) {
        return (TextInputLayout)localViewParent;
      }
    }
    return null;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    super.getFocusedRect(paramRect);
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((c(localTextInputLayout)) && (paramRect != null))
    {
      localTextInputLayout.getFocusedRect(this.f);
      paramRect.bottom = this.f.bottom;
    }
  }
  
  public boolean getGlobalVisibleRect(Rect paramRect, Point paramPoint)
  {
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if (c(localTextInputLayout)) {
      return localTextInputLayout.getGlobalVisibleRect(paramRect, paramPoint);
    }
    return super.getGlobalVisibleRect(paramRect, paramPoint);
  }
  
  public CharSequence getHint()
  {
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (localTextInputLayout.O())) {
      return localTextInputLayout.getHint();
    }
    return super.getHint();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((localTextInputLayout != null) && (localTextInputLayout.O()) && (super.getHint() == null) && (f.c())) {
      setHint("");
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if ((localInputConnection != null) && (paramEditorInfo.hintText == null)) {
      paramEditorInfo.hintText = getHintFromLayout();
    }
    return localInputConnection;
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    getTextInputLayout();
  }
  
  public boolean requestRectangleOnScreen(Rect paramRect)
  {
    TextInputLayout localTextInputLayout = getTextInputLayout();
    if ((c(localTextInputLayout)) && (paramRect != null))
    {
      int i = localTextInputLayout.getHeight();
      int j = getHeight();
      this.f.set(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom + (i - j));
      return super.requestRectangleOnScreen(this.f);
    }
    return super.requestRectangleOnScreen(paramRect);
  }
  
  public void setTextInputLayoutFocusedRectEnabled(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.TextInputEditText
 * JD-Core Version:    0.7.0.1
 */