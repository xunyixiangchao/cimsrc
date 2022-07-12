package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.R.attr;
import androidx.core.widget.l;
import c.a;

public class AppCompatAutoCompleteTextView
  extends AutoCompleteTextView
{
  private static final int[] d = { 16843126 };
  private final d a;
  private final p b;
  private final h c;
  
  public AppCompatAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
  }
  
  public AppCompatAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(h0.b(paramContext), paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = k0.v(getContext(), paramAttributeSet, d, paramInt, 0);
    if (paramContext.s(0)) {
      setDropDownBackgroundDrawable(paramContext.g(0));
    }
    paramContext.w();
    paramContext = new d(this);
    this.a = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
    paramContext = new p(this);
    this.b = paramContext;
    paramContext.m(paramAttributeSet, paramInt);
    paramContext.b();
    paramContext = new h(this);
    this.c = paramContext;
    paramContext.c(paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  void a(h paramh)
  {
    KeyListener localKeyListener = getKeyListener();
    if (paramh.b(localKeyListener))
    {
      boolean bool = super.isFocusable();
      int i = super.getInputType();
      paramh = paramh.a(localKeyListener);
      if (paramh == localKeyListener) {
        return;
      }
      super.setKeyListener(paramh);
      super.setRawInputType(i);
      super.setFocusable(bool);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.a;
    if (localObject != null) {
      ((d)localObject).b();
    }
    localObject = this.b;
    if (localObject != null) {
      ((p)localObject).b();
    }
  }
  
  public ActionMode.Callback getCustomSelectionActionModeCallback()
  {
    return l.q(super.getCustomSelectionActionModeCallback());
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.c();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    d locald = this.a;
    if (locald != null) {
      return locald.d();
    }
    return null;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = j.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
    return this.c.d(localInputConnection, paramEditorInfo);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    d locald = this.a;
    if (locald != null) {
      locald.f(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    d locald = this.a;
    if (locald != null) {
      locald.g(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(l.r(this, paramCallback));
  }
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    setDropDownBackgroundDrawable(a.b(getContext(), paramInt));
  }
  
  public void setEmojiCompatEnabled(boolean paramBoolean)
  {
    this.c.e(paramBoolean);
  }
  
  public void setKeyListener(KeyListener paramKeyListener)
  {
    super.setKeyListener(this.c.a(paramKeyListener));
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    d locald = this.a;
    if (locald != null) {
      locald.i(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    d locald = this.a;
    if (locald != null) {
      locald.j(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    p localp = this.b;
    if (localp != null) {
      localp.q(paramContext, paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */