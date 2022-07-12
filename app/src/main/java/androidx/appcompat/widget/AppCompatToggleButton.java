package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

public class AppCompatToggleButton
  extends ToggleButton
{
  private final d a;
  private final p b;
  private i c;
  
  public AppCompatToggleButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842827);
  }
  
  public AppCompatToggleButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = new d(this);
    this.a = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
    paramContext = new p(this);
    this.b = paramContext;
    paramContext.m(paramAttributeSet, paramInt);
    getEmojiTextViewHelper().c(paramAttributeSet, paramInt);
  }
  
  private i getEmojiTextViewHelper()
  {
    if (this.c == null) {
      this.c = new i(this);
    }
    return this.c;
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
  
  public void setAllCaps(boolean paramBoolean)
  {
    super.setAllCaps(paramBoolean);
    getEmojiTextViewHelper().d(paramBoolean);
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
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatToggleButton
 * JD-Core Version:    0.7.0.1
 */