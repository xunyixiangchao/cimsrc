package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R.attr;
import androidx.core.widget.l;
import c.a;

public class AppCompatCheckedTextView
  extends CheckedTextView
{
  private final e a;
  private final d b;
  private final p c;
  private i d;
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.checkedTextViewStyle);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(h0.b(paramContext), paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = new p(this);
    this.c = paramContext;
    paramContext.m(paramAttributeSet, paramInt);
    paramContext.b();
    paramContext = new d(this);
    this.b = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
    paramContext = new e(this);
    this.a = paramContext;
    paramContext.d(paramAttributeSet, paramInt);
    getEmojiTextViewHelper().c(paramAttributeSet, paramInt);
  }
  
  private i getEmojiTextViewHelper()
  {
    if (this.d == null) {
      this.d = new i(this);
    }
    return this.d;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.c;
    if (localObject != null) {
      ((p)localObject).b();
    }
    localObject = this.b;
    if (localObject != null) {
      ((d)localObject).b();
    }
    localObject = this.a;
    if (localObject != null) {
      ((e)localObject).a();
    }
  }
  
  public ActionMode.Callback getCustomSelectionActionModeCallback()
  {
    return l.q(super.getCustomSelectionActionModeCallback());
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    d locald = this.b;
    if (locald != null) {
      return locald.c();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    d locald = this.b;
    if (locald != null) {
      return locald.d();
    }
    return null;
  }
  
  public ColorStateList getSupportCheckMarkTintList()
  {
    e locale = this.a;
    if (locale != null) {
      return locale.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportCheckMarkTintMode()
  {
    e locale = this.a;
    if (locale != null) {
      return locale.c();
    }
    return null;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return j.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    super.setAllCaps(paramBoolean);
    getEmojiTextViewHelper().d(paramBoolean);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    d locald = this.b;
    if (locald != null) {
      locald.f(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    d locald = this.b;
    if (locald != null) {
      locald.g(paramInt);
    }
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(a.b(getContext(), paramInt));
  }
  
  public void setCheckMarkDrawable(Drawable paramDrawable)
  {
    super.setCheckMarkDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null) {
      paramDrawable.e();
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(l.r(this, paramCallback));
  }
  
  public void setEmojiCompatEnabled(boolean paramBoolean)
  {
    getEmojiTextViewHelper().e(paramBoolean);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    d locald = this.b;
    if (locald != null) {
      locald.i(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    d locald = this.b;
    if (locald != null) {
      locald.j(paramMode);
    }
  }
  
  public void setSupportCheckMarkTintList(ColorStateList paramColorStateList)
  {
    e locale = this.a;
    if (locale != null) {
      locale.f(paramColorStateList);
    }
  }
  
  public void setSupportCheckMarkTintMode(PorterDuff.Mode paramMode)
  {
    e locale = this.a;
    if (locale != null) {
      locale.g(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    p localp = this.c;
    if (localp != null) {
      localp.q(paramContext, paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatCheckedTextView
 * JD-Core Version:    0.7.0.1
 */