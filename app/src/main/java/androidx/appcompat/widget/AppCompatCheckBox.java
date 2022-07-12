package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.R.attr;
import c.a;

public class AppCompatCheckBox
  extends CheckBox
{
  private final f a;
  private final d b;
  private final p c;
  private i d;
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.checkboxStyle);
  }
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(h0.b(paramContext), paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = new f(this);
    this.a = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
    paramContext = new d(this);
    this.b = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
    paramContext = new p(this);
    this.c = paramContext;
    paramContext.m(paramAttributeSet, paramInt);
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
    Object localObject = this.b;
    if (localObject != null) {
      ((d)localObject).b();
    }
    localObject = this.c;
    if (localObject != null) {
      ((p)localObject).b();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = super.getCompoundPaddingLeft();
    f localf = this.a;
    int i = j;
    if (localf != null) {
      i = localf.b(j);
    }
    return i;
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
  
  public ColorStateList getSupportButtonTintList()
  {
    f localf = this.a;
    if (localf != null) {
      return localf.c();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    f localf = this.a;
    if (localf != null) {
      return localf.d();
    }
    return null;
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
  
  public void setButtonDrawable(int paramInt)
  {
    setButtonDrawable(a.b(getContext(), paramInt));
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    super.setButtonDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null) {
      paramDrawable.f();
    }
  }
  
  public void setEmojiCompatEnabled(boolean paramBoolean)
  {
    getEmojiTextViewHelper().e(paramBoolean);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    super.setFilters(getEmojiTextViewHelper().a(paramArrayOfInputFilter));
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
  
  public void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    f localf = this.a;
    if (localf != null) {
      localf.g(paramColorStateList);
    }
  }
  
  public void setSupportButtonTintMode(PorterDuff.Mode paramMode)
  {
    f localf = this.a;
    if (localf != null) {
      localf.h(paramMode);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatCheckBox
 * JD-Core Version:    0.7.0.1
 */