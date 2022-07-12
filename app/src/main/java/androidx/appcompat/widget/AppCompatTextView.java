package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.widget.l;
import androidx.core.widget.n;
import c.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import q0.e;
import w0.b.a;

public class AppCompatTextView
  extends TextView
  implements n, androidx.core.widget.b
{
  private final d mBackgroundTintHelper;
  private i mEmojiTextViewHelper;
  private boolean mIsSetTypefaceProcessing = false;
  private Future<w0.b> mPrecomputedTextFuture;
  private final o mTextClassifierHelper;
  private final p mTextHelper;
  
  public AppCompatTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public AppCompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(h0.b(paramContext), paramAttributeSet, paramInt);
    f0.a(this, getContext());
    paramContext = new d(this);
    this.mBackgroundTintHelper = paramContext;
    paramContext.e(paramAttributeSet, paramInt);
    paramContext = new p(this);
    this.mTextHelper = paramContext;
    paramContext.m(paramAttributeSet, paramInt);
    paramContext.b();
    this.mTextClassifierHelper = new o(this);
    getEmojiTextViewHelper().c(paramAttributeSet, paramInt);
  }
  
  private void consumeTextFutureAndSetBlocking()
  {
    Future localFuture = this.mPrecomputedTextFuture;
    if (localFuture != null) {}
    try
    {
      this.mPrecomputedTextFuture = null;
      l.n(this, (w0.b)localFuture.get());
      return;
    }
    catch (InterruptedException|ExecutionException localInterruptedException) {}
  }
  
  private i getEmojiTextViewHelper()
  {
    if (this.mEmojiTextViewHelper == null) {
      this.mEmojiTextViewHelper = new i(this);
    }
    return this.mEmojiTextViewHelper;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.mBackgroundTintHelper;
    if (localObject != null) {
      ((d)localObject).b();
    }
    localObject = this.mTextHelper;
    if (localObject != null) {
      ((p)localObject).b();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (androidx.core.widget.b.D) {
      return super.getAutoSizeMaxTextSize();
    }
    p localp = this.mTextHelper;
    if (localp != null) {
      return localp.e();
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (androidx.core.widget.b.D) {
      return super.getAutoSizeMinTextSize();
    }
    p localp = this.mTextHelper;
    if (localp != null) {
      return localp.f();
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (androidx.core.widget.b.D) {
      return super.getAutoSizeStepGranularity();
    }
    p localp = this.mTextHelper;
    if (localp != null) {
      return localp.g();
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (androidx.core.widget.b.D) {
      return super.getAutoSizeTextAvailableSizes();
    }
    p localp = this.mTextHelper;
    if (localp != null) {
      return localp.h();
    }
    return new int[0];
  }
  
  @SuppressLint({"WrongConstant"})
  public int getAutoSizeTextType()
  {
    boolean bool = androidx.core.widget.b.D;
    int i = 0;
    if (bool)
    {
      if (super.getAutoSizeTextType() == 1) {
        i = 1;
      }
      return i;
    }
    p localp = this.mTextHelper;
    if (localp != null) {
      return localp.i();
    }
    return 0;
  }
  
  public ActionMode.Callback getCustomSelectionActionModeCallback()
  {
    return l.q(super.getCustomSelectionActionModeCallback());
  }
  
  public int getFirstBaselineToTopHeight()
  {
    return l.b(this);
  }
  
  public int getLastBaselineToBottomHeight()
  {
    return l.c(this);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      return locald.c();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      return locald.d();
    }
    return null;
  }
  
  public ColorStateList getSupportCompoundDrawablesTintList()
  {
    return this.mTextHelper.j();
  }
  
  public PorterDuff.Mode getSupportCompoundDrawablesTintMode()
  {
    return this.mTextHelper.k();
  }
  
  public CharSequence getText()
  {
    consumeTextFutureAndSetBlocking();
    return super.getText();
  }
  
  public TextClassifier getTextClassifier()
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      o localo = this.mTextClassifierHelper;
      if (localo != null) {
        return localo.a();
      }
    }
    return super.getTextClassifier();
  }
  
  public b.a getTextMetricsParamsCompat()
  {
    return l.g(this);
  }
  
  public boolean isEmojiCompatEnabled()
  {
    return getEmojiTextViewHelper().b();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    this.mTextHelper.r(this, localInputConnection, paramEditorInfo);
    return j.a(localInputConnection, paramEditorInfo, this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    p localp = this.mTextHelper;
    if (localp != null) {
      localp.o(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    consumeTextFutureAndSetBlocking();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    paramCharSequence = this.mTextHelper;
    if ((paramCharSequence != null) && (!androidx.core.widget.b.D) && (paramCharSequence.l())) {
      this.mTextHelper.c();
    }
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    super.setAllCaps(paramBoolean);
    getEmojiTextViewHelper().d(paramBoolean);
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (androidx.core.widget.b.D)
    {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    p localp = this.mTextHelper;
    if (localp != null) {
      localp.t(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (androidx.core.widget.b.D)
    {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
      return;
    }
    p localp = this.mTextHelper;
    if (localp != null) {
      localp.u(paramArrayOfInt, paramInt);
    }
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (androidx.core.widget.b.D)
    {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
      return;
    }
    p localp = this.mTextHelper;
    if (localp != null) {
      localp.v(paramInt);
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      locald.f(paramDrawable);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      locald.g(paramInt);
    }
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = this.mTextHelper;
    if (paramDrawable1 != null) {
      paramDrawable1.p();
    }
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = this.mTextHelper;
    if (paramDrawable1 != null) {
      paramDrawable1.p();
    }
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Context localContext = getContext();
    Drawable localDrawable3 = null;
    if (paramInt1 != 0) {
      localObject = a.b(localContext, paramInt1);
    } else {
      localObject = null;
    }
    Drawable localDrawable1;
    if (paramInt2 != 0) {
      localDrawable1 = a.b(localContext, paramInt2);
    } else {
      localDrawable1 = null;
    }
    Drawable localDrawable2;
    if (paramInt3 != 0) {
      localDrawable2 = a.b(localContext, paramInt3);
    } else {
      localDrawable2 = null;
    }
    if (paramInt4 != 0) {
      localDrawable3 = a.b(localContext, paramInt4);
    }
    setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable)localObject, localDrawable1, localDrawable2, localDrawable3);
    Object localObject = this.mTextHelper;
    if (localObject != null) {
      ((p)localObject).p();
    }
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = this.mTextHelper;
    if (paramDrawable1 != null) {
      paramDrawable1.p();
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Context localContext = getContext();
    Drawable localDrawable3 = null;
    if (paramInt1 != 0) {
      localObject = a.b(localContext, paramInt1);
    } else {
      localObject = null;
    }
    Drawable localDrawable1;
    if (paramInt2 != 0) {
      localDrawable1 = a.b(localContext, paramInt2);
    } else {
      localDrawable1 = null;
    }
    Drawable localDrawable2;
    if (paramInt3 != 0) {
      localDrawable2 = a.b(localContext, paramInt3);
    } else {
      localDrawable2 = null;
    }
    if (paramInt4 != 0) {
      localDrawable3 = a.b(localContext, paramInt4);
    }
    setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, localDrawable1, localDrawable2, localDrawable3);
    Object localObject = this.mTextHelper;
    if (localObject != null) {
      ((p)localObject).p();
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    paramDrawable1 = this.mTextHelper;
    if (paramDrawable1 != null) {
      paramDrawable1.p();
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
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    l.k(this, paramInt);
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setLastBaselineToBottomHeight(paramInt);
      return;
    }
    l.l(this, paramInt);
  }
  
  public void setLineHeight(int paramInt)
  {
    l.m(this, paramInt);
  }
  
  public void setPrecomputedText(w0.b paramb)
  {
    l.n(this, paramb);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      locald.i(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    d locald = this.mBackgroundTintHelper;
    if (locald != null) {
      locald.j(paramMode);
    }
  }
  
  public void setSupportCompoundDrawablesTintList(ColorStateList paramColorStateList)
  {
    this.mTextHelper.w(paramColorStateList);
    this.mTextHelper.b();
  }
  
  public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode paramMode)
  {
    this.mTextHelper.x(paramMode);
    this.mTextHelper.b();
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    p localp = this.mTextHelper;
    if (localp != null) {
      localp.q(paramContext, paramInt);
    }
  }
  
  public void setTextClassifier(TextClassifier paramTextClassifier)
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      o localo = this.mTextClassifierHelper;
      if (localo != null)
      {
        localo.b(paramTextClassifier);
        return;
      }
    }
    super.setTextClassifier(paramTextClassifier);
  }
  
  public void setTextFuture(Future<w0.b> paramFuture)
  {
    this.mPrecomputedTextFuture = paramFuture;
    if (paramFuture != null) {
      requestLayout();
    }
  }
  
  public void setTextMetricsParamsCompat(b.a parama)
  {
    l.p(this, parama);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (androidx.core.widget.b.D)
    {
      super.setTextSize(paramInt, paramFloat);
      return;
    }
    p localp = this.mTextHelper;
    if (localp != null) {
      localp.A(paramInt, paramFloat);
    }
  }
  
  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    if (this.mIsSetTypefaceProcessing) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramTypeface != null)
    {
      localObject1 = localObject2;
      if (paramInt > 0) {
        localObject1 = e.a(getContext(), paramTypeface, paramInt);
      }
    }
    this.mIsSetTypefaceProcessing = true;
    if (localObject1 != null) {
      paramTypeface = (Typeface)localObject1;
    }
    try
    {
      super.setTypeface(paramTypeface, paramInt);
      return;
    }
    finally
    {
      this.mIsSetTypefaceProcessing = false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextView
 * JD-Core Version:    0.7.0.1
 */