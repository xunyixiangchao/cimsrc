package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.l;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.e
public class PagerTitleStrip
  extends ViewGroup
{
  private static final int[] o = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] p = { 16843660 };
  ViewPager a;
  TextView b;
  TextView c;
  TextView d;
  private int e = -1;
  float f = -1.0F;
  private int g;
  private int h;
  private boolean i;
  private boolean j;
  private final a k = new a();
  private WeakReference<a> l;
  private int m;
  int n;
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.b = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.c = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.d = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, o);
    boolean bool = false;
    int i1 = paramAttributeSet.getResourceId(0, 0);
    if (i1 != 0)
    {
      l.o(this.b, i1);
      l.o(this.c, i1);
      l.o(this.d, i1);
    }
    int i2 = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (i2 != 0) {
      a(0, i2);
    }
    if (paramAttributeSet.hasValue(2))
    {
      i2 = paramAttributeSet.getColor(2, 0);
      this.b.setTextColor(i2);
      this.c.setTextColor(i2);
      this.d.setTextColor(i2);
    }
    this.h = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.n = this.c.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.b.setEllipsize(TextUtils.TruncateAt.END);
    this.c.setEllipsize(TextUtils.TruncateAt.END);
    this.d.setEllipsize(TextUtils.TruncateAt.END);
    if (i1 != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i1, p);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    paramAttributeSet = this.b;
    if (bool)
    {
      setSingleLineAllCaps(paramAttributeSet);
      setSingleLineAllCaps(this.c);
      setSingleLineAllCaps(this.d);
    }
    else
    {
      paramAttributeSet.setSingleLine();
      this.c.setSingleLine();
      this.d.setSingleLine();
    }
    this.g = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView)
  {
    paramTextView.setTransformationMethod(new b(paramTextView.getContext()));
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.b.setTextSize(paramInt, paramFloat);
    this.c.setTextSize(paramInt, paramFloat);
    this.d.setTextSize(paramInt, paramFloat);
  }
  
  void b(a parama1, a parama2)
  {
    if (parama1 != null)
    {
      parama1.t(this.k);
      this.l = null;
    }
    if (parama2 != null)
    {
      parama2.l(this.k);
      this.l = new WeakReference(parama2);
    }
    parama1 = this.a;
    if (parama1 != null)
    {
      this.e = -1;
      this.f = -1.0F;
      c(parama1.getCurrentItem(), parama2);
      requestLayout();
    }
  }
  
  void c(int paramInt, a parama)
  {
    if (parama != null) {
      i1 = parama.e();
    } else {
      i1 = 0;
    }
    this.i = true;
    Object localObject2 = null;
    if ((paramInt >= 1) && (parama != null)) {
      localObject1 = parama.g(paramInt - 1);
    } else {
      localObject1 = null;
    }
    this.b.setText((CharSequence)localObject1);
    TextView localTextView = this.c;
    if ((parama != null) && (paramInt < i1)) {
      localObject1 = parama.g(paramInt);
    } else {
      localObject1 = null;
    }
    localTextView.setText((CharSequence)localObject1);
    int i2 = paramInt + 1;
    Object localObject1 = localObject2;
    if (i2 < i1)
    {
      localObject1 = localObject2;
      if (parama != null) {
        localObject1 = parama.g(i2);
      }
    }
    this.d.setText((CharSequence)localObject1);
    int i1 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
    i2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
    this.b.measure(i1, i2);
    this.c.measure(i1, i2);
    this.d.measure(i1, i2);
    this.e = paramInt;
    if (!this.j) {
      d(paramInt, this.f, false);
    }
    this.i = false;
  }
  
  void d(int paramInt, float paramFloat, boolean paramBoolean)
  {
    if (paramInt != this.e) {
      c(paramInt, this.a.getAdapter());
    } else if ((!paramBoolean) && (paramFloat == this.f)) {
      return;
    }
    this.j = true;
    int i4 = this.b.getMeasuredWidth();
    int i9 = this.c.getMeasuredWidth();
    int i3 = this.d.getMeasuredWidth();
    int i8 = i9 / 2;
    int i5 = getWidth();
    int i1 = getHeight();
    int i7 = getPaddingLeft();
    int i6 = getPaddingRight();
    paramInt = getPaddingTop();
    int i2 = getPaddingBottom();
    int i10 = i6 + i8;
    float f2 = 0.5F + paramFloat;
    float f1 = f2;
    if (f2 > 1.0F) {
      f1 = f2 - 1.0F;
    }
    i8 = i5 - i10 - (int)((i5 - (i7 + i8) - i10) * f1) - i8;
    i9 += i8;
    int i12 = this.b.getBaseline();
    i10 = this.c.getBaseline();
    int i11 = this.d.getBaseline();
    int i13 = Math.max(Math.max(i12, i10), i11);
    i12 = i13 - i12;
    i10 = i13 - i10;
    i11 = i13 - i11;
    i13 = this.b.getMeasuredHeight();
    int i14 = this.c.getMeasuredHeight();
    int i15 = this.d.getMeasuredHeight();
    i13 = Math.max(Math.max(i13 + i12, i14 + i10), i15 + i11);
    i14 = this.h & 0x70;
    if (i14 != 16)
    {
      if (i14 != 80)
      {
        i1 = i12 + paramInt;
        i2 = i10 + paramInt;
        paramInt += i11;
        break label372;
      }
      paramInt = i1 - i2 - i13;
    }
    else
    {
      paramInt = (i1 - paramInt - i2 - i13) / 2;
    }
    i1 = i12 + paramInt;
    i2 = i10 + paramInt;
    paramInt += i11;
    label372:
    TextView localTextView = this.c;
    localTextView.layout(i8, i2, i9, localTextView.getMeasuredHeight() + i2);
    i2 = Math.min(i7, i8 - this.g - i4);
    localTextView = this.b;
    localTextView.layout(i2, i1, i4 + i2, localTextView.getMeasuredHeight() + i1);
    i1 = Math.max(i5 - i6 - i3, i9 + this.g);
    localTextView = this.d;
    localTextView.layout(i1, paramInt, i1 + i3, localTextView.getMeasuredHeight() + paramInt);
    this.f = paramFloat;
    this.j = false;
  }
  
  int getMinHeight()
  {
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return 0;
  }
  
  public int getTextSpacing()
  {
    return this.g;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if ((localObject instanceof ViewPager))
    {
      localObject = (ViewPager)localObject;
      a locala = ((ViewPager)localObject).getAdapter();
      ((ViewPager)localObject).Q(this.k);
      ((ViewPager)localObject).b(this.k);
      this.a = ((ViewPager)localObject);
      localObject = this.l;
      if (localObject != null) {
        localObject = (a)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      b((a)localObject, locala);
      return;
    }
    throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ViewPager localViewPager = this.a;
    if (localViewPager != null)
    {
      b(localViewPager.getAdapter(), null);
      this.a.Q(null);
      this.a.I(this.k);
      this.a = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a != null)
    {
      float f1 = this.f;
      if (f1 < 0.0F) {
        f1 = 0.0F;
      }
      d(this.e, f1, true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824)
    {
      int i2 = getPaddingTop() + getPaddingBottom();
      int i3 = ViewGroup.getChildMeasureSpec(paramInt2, i2, -2);
      int i1 = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = ViewGroup.getChildMeasureSpec(paramInt1, (int)(i1 * 0.2F), -2);
      this.b.measure(paramInt1, i3);
      this.c.measure(paramInt1, i3);
      this.d.measure(paramInt1, i3);
      if (View.MeasureSpec.getMode(paramInt2) == 1073741824)
      {
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
      }
      else
      {
        paramInt1 = this.c.getMeasuredHeight();
        paramInt1 = Math.max(getMinHeight(), paramInt1 + i2);
      }
      setMeasuredDimension(i1, View.resolveSizeAndState(paramInt1, paramInt2, this.c.getMeasuredState() << 16));
      return;
    }
    throw new IllegalStateException("Must measure with an exact width");
  }
  
  public void requestLayout()
  {
    if (!this.i) {
      super.requestLayout();
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.h = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat)
  {
    int i1 = (int)(paramFloat * 255.0F) & 0xFF;
    this.m = i1;
    i1 = i1 << 24 | this.n & 0xFFFFFF;
    this.b.setTextColor(i1);
    this.d.setTextColor(i1);
  }
  
  public void setTextColor(int paramInt)
  {
    this.n = paramInt;
    this.c.setTextColor(paramInt);
    paramInt = this.m << 24 | this.n & 0xFFFFFF;
    this.b.setTextColor(paramInt);
    this.d.setTextColor(paramInt);
  }
  
  public void setTextSpacing(int paramInt)
  {
    this.g = paramInt;
    requestLayout();
  }
  
  private class a
    extends DataSetObserver
    implements ViewPager.i, ViewPager.h
  {
    private int a;
    
    a() {}
    
    public void D(int paramInt)
    {
      this.a = paramInt;
    }
    
    public void J(int paramInt)
    {
      if (this.a == 0)
      {
        PagerTitleStrip localPagerTitleStrip = PagerTitleStrip.this;
        localPagerTitleStrip.c(localPagerTitleStrip.a.getCurrentItem(), PagerTitleStrip.this.a.getAdapter());
        localPagerTitleStrip = PagerTitleStrip.this;
        float f = localPagerTitleStrip.f;
        if (f < 0.0F) {
          f = 0.0F;
        }
        localPagerTitleStrip.d(localPagerTitleStrip.a.getCurrentItem(), f, true);
      }
    }
    
    public void a(ViewPager paramViewPager, a parama1, a parama2)
    {
      PagerTitleStrip.this.b(parama1, parama2);
    }
    
    public void onChanged()
    {
      PagerTitleStrip localPagerTitleStrip = PagerTitleStrip.this;
      localPagerTitleStrip.c(localPagerTitleStrip.a.getCurrentItem(), PagerTitleStrip.this.a.getAdapter());
      localPagerTitleStrip = PagerTitleStrip.this;
      float f = localPagerTitleStrip.f;
      if (f < 0.0F) {
        f = 0.0F;
      }
      localPagerTitleStrip.d(localPagerTitleStrip.a.getCurrentItem(), f, true);
    }
    
    public void s(int paramInt1, float paramFloat, int paramInt2)
    {
      paramInt2 = paramInt1;
      if (paramFloat > 0.5F) {
        paramInt2 = paramInt1 + 1;
      }
      PagerTitleStrip.this.d(paramInt2, paramFloat, false);
    }
  }
  
  private static class b
    extends SingleLineTransformationMethod
  {
    private Locale a;
    
    b(Context paramContext)
    {
      this.a = paramContext.getResources().getConfiguration().locale;
    }
    
    public CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
    {
      paramCharSequence = super.getTransformation(paramCharSequence, paramView);
      if (paramCharSequence != null) {
        return paramCharSequence.toString().toUpperCase(this.a);
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.viewpager.widget.PagerTitleStrip
 * JD-Core Version:    0.7.0.1
 */