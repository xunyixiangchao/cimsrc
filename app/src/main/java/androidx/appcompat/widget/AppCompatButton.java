package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R.attr;
import androidx.core.widget.b;
import androidx.core.widget.l;
import androidx.core.widget.n;

public class AppCompatButton
  extends Button
  implements b, n
{
  private final d a;
  private final p b;
  private i c;
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.buttonStyle);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(h0.b(paramContext), paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = new d(this);
    this.a = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
    paramContext = new p(this);
    this.b = paramContext;
    paramContext.m(paramAttributeSet, paramInt);
    paramContext.b();
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
  
  public int getAutoSizeMaxTextSize()
  {
    if (b.D) {
      return super.getAutoSizeMaxTextSize();
    }
    p localp = this.b;
    if (localp != null) {
      return localp.e();
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (b.D) {
      return super.getAutoSizeMinTextSize();
    }
    p localp = this.b;
    if (localp != null) {
      return localp.f();
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (b.D) {
      return super.getAutoSizeStepGranularity();
    }
    p localp = this.b;
    if (localp != null) {
      return localp.g();
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (b.D) {
      return super.getAutoSizeTextAvailableSizes();
    }
    p localp = this.b;
    if (localp != null) {
      return localp.h();
    }
    return new int[0];
  }
  
  @SuppressLint({"WrongConstant"})
  public int getAutoSizeTextType()
  {
    boolean bool = b.D;
    int i = 0;
    if (bool)
    {
      if (super.getAutoSizeTextType() == 1) {
        i = 1;
      }
      return i;
    }
    p localp = this.b;
    if (localp != null) {
      return localp.i();
    }
    return 0;
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
  
  public ColorStateList getSupportCompoundDrawablesTintList()
  {
    return this.b.j();
  }
  
  public PorterDuff.Mode getSupportCompoundDrawablesTintMode()
  {
    return this.b.k();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    p localp = this.b;
    if (localp != null) {
      localp.o(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramCharSequence = this.b;
    if ((paramCharSequence != null) && (!b.D) && (paramCharSequence.l())) {
      this.b.c();
    }
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    super.setAllCaps(paramBoolean);
    getEmojiTextViewHelper().d(paramBoolean);
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (b.D)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    p localp = this.b;
    if (localp != null) {
      localp.t(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (b.D)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      return;
    }
    p localp = this.b;
    if (localp != null) {
      localp.u(paramArrayOfInt, paramInt);
    }
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (b.D)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    }
    p localp = this.b;
    if (localp != null) {
      localp.v(paramInt);
    }
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
  
  public void setEmojiCompatEnabled(boolean paramBoolean)
  {
    getEmojiTextViewHelper().e(paramBoolean);
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    super.setFilters(getEmojiTextViewHelper().a(paramArrayOfInputFilter));
  }
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    p localp = this.b;
    if (localp != null) {
      localp.s(paramBoolean);
    }
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
  
  public void setSupportCompoundDrawablesTintList(ColorStateList paramColorStateList)
  {
    this.b.w(paramColorStateList);
    this.b.b();
  }
  
  public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode paramMode)
  {
    this.b.x(paramMode);
    this.b.b();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    p localp = this.b;
    if (localp != null) {
      localp.q(paramContext, paramInt);
    }
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (b.D)
    {
      super.setTextSize(paramInt, paramFloat);
      return;
    }
    p localp = this.b;
    if (localp != null) {
      localp.A(paramInt, paramFloat);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatButton
 * JD-Core Version:    0.7.0.1
 */