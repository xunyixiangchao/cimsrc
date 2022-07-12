package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.string;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;
import androidx.core.widget.l;
import androidx.emoji2.text.d;
import androidx.emoji2.text.d.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final Property<SwitchCompat, Float> S = new a(Float.class, "thumbPos");
  private static final int[] T = { 16842912 };
  private int A;
  private int B;
  private int C;
  private int E;
  private int F;
  private int G;
  private int H;
  private final TextPaint I;
  private ColorStateList J;
  private Layout K;
  private Layout L;
  private TransformationMethod M;
  ObjectAnimator N;
  private final p O;
  private i P;
  private b Q;
  private final Rect R = new Rect();
  private Drawable a;
  private ColorStateList b = null;
  private PorterDuff.Mode c = null;
  private boolean d = false;
  private boolean e = false;
  private Drawable f;
  private ColorStateList g = null;
  private PorterDuff.Mode h = null;
  private boolean i = false;
  private boolean j = false;
  private int k;
  private int l;
  private int m;
  private boolean n;
  private CharSequence o;
  private CharSequence p;
  private CharSequence q;
  private CharSequence r;
  private boolean s;
  private int t;
  private int u;
  private float v;
  private float w;
  private VelocityTracker x = VelocityTracker.obtain();
  private int y;
  float z;
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f0.a(this, getContext());
    Object localObject1 = new TextPaint(1);
    this.I = ((TextPaint)localObject1);
    ((TextPaint)localObject1).density = getResources().getDisplayMetrics().density;
    Object localObject2 = R.styleable.SwitchCompat;
    localObject1 = k0.v(paramContext, paramAttributeSet, (int[])localObject2, paramInt, 0);
    x.o0(this, paramContext, (int[])localObject2, paramAttributeSet, ((k0)localObject1).r(), paramInt, 0);
    localObject2 = ((k0)localObject1).g(R.styleable.SwitchCompat_android_thumb);
    this.a = ((Drawable)localObject2);
    if (localObject2 != null) {
      ((Drawable)localObject2).setCallback(this);
    }
    localObject2 = ((k0)localObject1).g(R.styleable.SwitchCompat_track);
    this.f = ((Drawable)localObject2);
    if (localObject2 != null) {
      ((Drawable)localObject2).setCallback(this);
    }
    setTextOnInternal(((k0)localObject1).p(R.styleable.SwitchCompat_android_textOn));
    setTextOffInternal(((k0)localObject1).p(R.styleable.SwitchCompat_android_textOff));
    this.s = ((k0)localObject1).a(R.styleable.SwitchCompat_showText, true);
    this.k = ((k0)localObject1).f(R.styleable.SwitchCompat_thumbTextPadding, 0);
    this.l = ((k0)localObject1).f(R.styleable.SwitchCompat_switchMinWidth, 0);
    this.m = ((k0)localObject1).f(R.styleable.SwitchCompat_switchPadding, 0);
    this.n = ((k0)localObject1).a(R.styleable.SwitchCompat_splitTrack, false);
    localObject2 = ((k0)localObject1).c(R.styleable.SwitchCompat_thumbTint);
    if (localObject2 != null)
    {
      this.b = ((ColorStateList)localObject2);
      this.d = true;
    }
    localObject2 = t.e(((k0)localObject1).k(R.styleable.SwitchCompat_thumbTintMode, -1), null);
    if (this.c != localObject2)
    {
      this.c = ((PorterDuff.Mode)localObject2);
      this.e = true;
    }
    if ((this.d) || (this.e)) {
      b();
    }
    localObject2 = ((k0)localObject1).c(R.styleable.SwitchCompat_trackTint);
    if (localObject2 != null)
    {
      this.g = ((ColorStateList)localObject2);
      this.i = true;
    }
    localObject2 = t.e(((k0)localObject1).k(R.styleable.SwitchCompat_trackTintMode, -1), null);
    if (this.h != localObject2)
    {
      this.h = ((PorterDuff.Mode)localObject2);
      this.j = true;
    }
    if ((this.i) || (this.j)) {
      c();
    }
    int i1 = ((k0)localObject1).n(R.styleable.SwitchCompat_switchTextAppearance, 0);
    if (i1 != 0) {
      m(paramContext, i1);
    }
    localObject2 = new p(this);
    this.O = ((p)localObject2);
    ((p)localObject2).m(paramAttributeSet, paramInt);
    ((k0)localObject1).w();
    paramContext = ViewConfiguration.get(paramContext);
    this.u = paramContext.getScaledTouchSlop();
    this.y = paramContext.getScaledMinimumFlingVelocity();
    getEmojiTextViewHelper().c(paramAttributeSet, paramInt);
    refreshDrawableState();
    setChecked(isChecked());
  }
  
  private void a(boolean paramBoolean)
  {
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, S, new float[] { f1 });
    this.N = localObjectAnimator;
    localObjectAnimator.setDuration(250L);
    this.N.setAutoCancel(true);
    this.N.start();
  }
  
  private void b()
  {
    Drawable localDrawable = this.a;
    if ((localDrawable != null) && ((this.d) || (this.e)))
    {
      localDrawable = r0.a.r(localDrawable).mutate();
      this.a = localDrawable;
      if (this.d) {
        r0.a.o(localDrawable, this.b);
      }
      if (this.e) {
        r0.a.p(this.a, this.c);
      }
      if (this.a.isStateful()) {
        this.a.setState(getDrawableState());
      }
    }
  }
  
  private void c()
  {
    Drawable localDrawable = this.f;
    if ((localDrawable != null) && ((this.i) || (this.j)))
    {
      localDrawable = r0.a.r(localDrawable).mutate();
      this.f = localDrawable;
      if (this.i) {
        r0.a.o(localDrawable, this.g);
      }
      if (this.j) {
        r0.a.p(this.f, this.h);
      }
      if (this.f.isStateful()) {
        this.f.setState(getDrawableState());
      }
    }
  }
  
  private void d()
  {
    ObjectAnimator localObjectAnimator = this.N;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
  }
  
  private static float f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    paramFloat2 = paramFloat1;
    if (paramFloat1 > paramFloat3) {
      paramFloat2 = paramFloat3;
    }
    return paramFloat2;
  }
  
  private CharSequence g(CharSequence paramCharSequence)
  {
    TransformationMethod localTransformationMethod = getEmojiTextViewHelper().f(this.M);
    CharSequence localCharSequence = paramCharSequence;
    if (localTransformationMethod != null) {
      localCharSequence = localTransformationMethod.getTransformation(paramCharSequence, this);
    }
    return localCharSequence;
  }
  
  private i getEmojiTextViewHelper()
  {
    if (this.P == null) {
      this.P = new i(this);
    }
    return this.P;
  }
  
  private boolean getTargetCheckedState()
  {
    return this.z > 0.5F;
  }
  
  private int getThumbOffset()
  {
    float f1;
    if (r0.b(this)) {
      f1 = 1.0F - this.z;
    } else {
      f1 = this.z;
    }
    return (int)(f1 * getThumbScrollRange() + 0.5F);
  }
  
  private int getThumbScrollRange()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      Rect localRect = this.R;
      ((Drawable)localObject).getPadding(localRect);
      localObject = this.a;
      if (localObject != null) {
        localObject = t.d((Drawable)localObject);
      } else {
        localObject = t.c;
      }
      return this.A - this.C - localRect.left - localRect.right - ((Rect)localObject).left - ((Rect)localObject).right;
    }
    return 0;
  }
  
  private boolean h(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.a;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    int i3 = getThumbOffset();
    this.a.getPadding(this.R);
    int i1 = this.F;
    int i2 = this.u;
    i3 = this.E + i3 - i2;
    int i4 = this.C;
    localObject = this.R;
    int i5 = ((Rect)localObject).left;
    int i6 = ((Rect)localObject).right;
    int i7 = this.H;
    boolean bool1 = bool2;
    if (paramFloat1 > i3)
    {
      bool1 = bool2;
      if (paramFloat1 < i4 + i3 + i5 + i6 + i2)
      {
        bool1 = bool2;
        if (paramFloat2 > i1 - i2)
        {
          bool1 = bool2;
          if (paramFloat2 < i7 + i2) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private Layout i(CharSequence paramCharSequence)
  {
    TextPaint localTextPaint = this.I;
    int i1;
    if (paramCharSequence != null) {
      i1 = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, localTextPaint));
    } else {
      i1 = 0;
    }
    return new StaticLayout(paramCharSequence, localTextPaint, i1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
  }
  
  private void k()
  {
    if (Build.VERSION.SDK_INT >= 30)
    {
      CharSequence localCharSequence = this.q;
      Object localObject = localCharSequence;
      if (localCharSequence == null) {
        localObject = getResources().getString(R.string.abc_capital_off);
      }
      x.J0(this, (CharSequence)localObject);
    }
  }
  
  private void l()
  {
    if (Build.VERSION.SDK_INT >= 30)
    {
      CharSequence localCharSequence = this.o;
      Object localObject = localCharSequence;
      if (localCharSequence == null) {
        localObject = getResources().getString(R.string.abc_capital_on);
      }
      x.J0(this, (CharSequence)localObject);
    }
  }
  
  private void o(int paramInt1, int paramInt2)
  {
    Typeface localTypeface;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          localTypeface = null;
        } else {
          localTypeface = Typeface.MONOSPACE;
        }
      }
      else {
        localTypeface = Typeface.SERIF;
      }
    }
    else {
      localTypeface = Typeface.SANS_SERIF;
    }
    n(localTypeface, paramInt2);
  }
  
  private void p()
  {
    if (this.Q == null)
    {
      if (!this.P.b()) {
        return;
      }
      if (d.h())
      {
        d locald = d.b();
        int i1 = locald.d();
        if ((i1 == 3) || (i1 == 0))
        {
          b localb = new b(this);
          this.Q = localb;
          locald.s(localb);
        }
      }
    }
  }
  
  private void q(MotionEvent paramMotionEvent)
  {
    this.t = 0;
    int i1 = paramMotionEvent.getAction();
    boolean bool1 = true;
    if ((i1 == 1) && (isEnabled())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool2 = isChecked();
    if (i1 != 0)
    {
      this.x.computeCurrentVelocity(1000);
      float f1 = this.x.getXVelocity();
      if (Math.abs(f1) > this.y)
      {
        if (r0.b(this) ? f1 >= 0.0F : f1 <= 0.0F) {
          bool1 = false;
        }
      }
      else {
        bool1 = getTargetCheckedState();
      }
    }
    else
    {
      bool1 = bool2;
    }
    if (bool1 != bool2) {
      playSoundEffect(0);
    }
    setChecked(bool1);
    e(paramMotionEvent);
  }
  
  private void setTextOffInternal(CharSequence paramCharSequence)
  {
    this.q = paramCharSequence;
    this.r = g(paramCharSequence);
    this.L = null;
    if (this.s) {
      p();
    }
  }
  
  private void setTextOnInternal(CharSequence paramCharSequence)
  {
    this.o = paramCharSequence;
    this.p = g(paramCharSequence);
    this.K = null;
    if (this.s) {
      p();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.R;
    int i4 = this.E;
    int i7 = this.F;
    int i5 = this.G;
    int i8 = this.H;
    int i2 = getThumbOffset() + i4;
    Object localObject = this.a;
    if (localObject != null) {
      localObject = t.d((Drawable)localObject);
    } else {
      localObject = t.c;
    }
    Drawable localDrawable = this.f;
    int i1 = i2;
    if (localDrawable != null)
    {
      localDrawable.getPadding(localRect);
      int i3 = localRect.left;
      int i9 = i2 + i3;
      if (localObject != null)
      {
        i2 = ((Rect)localObject).left;
        i1 = i4;
        if (i2 > i3) {
          i1 = i4 + (i2 - i3);
        }
        i2 = ((Rect)localObject).top;
        i3 = localRect.top;
        if (i2 > i3) {
          i2 = i2 - i3 + i7;
        } else {
          i2 = i7;
        }
        i4 = ((Rect)localObject).right;
        i6 = localRect.right;
        i3 = i5;
        if (i4 > i6) {
          i3 = i5 - (i4 - i6);
        }
        int i10 = ((Rect)localObject).bottom;
        int i11 = localRect.bottom;
        i4 = i1;
        i5 = i3;
        i6 = i2;
        if (i10 > i11)
        {
          i6 = i8 - (i10 - i11);
          break label258;
        }
      }
      else
      {
        i6 = i7;
      }
      i1 = i8;
      i2 = i6;
      int i6 = i1;
      i3 = i5;
      i1 = i4;
      label258:
      this.f.setBounds(i1, i2, i3, i6);
      i1 = i9;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(localRect);
      i2 = i1 - localRect.left;
      i1 = i1 + this.C + localRect.right;
      this.a.setBounds(i2, i7, i1, i8);
      localObject = getBackground();
      if (localObject != null) {
        r0.a.l((Drawable)localObject, i2, i7, i1, i8);
      }
    }
    super.draw(paramCanvas);
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      r0.a.k(localDrawable, paramFloat1, paramFloat2);
    }
    localDrawable = this.f;
    if (localDrawable != null) {
      r0.a.k(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.a;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | localDrawable.setState(arrayOfInt);
      }
    }
    localDrawable = this.f;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool2) {
      invalidate();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    if (!r0.b(this)) {
      return super.getCompoundPaddingLeft();
    }
    int i2 = super.getCompoundPaddingLeft() + this.A;
    int i1 = i2;
    if (!TextUtils.isEmpty(getText())) {
      i1 = i2 + this.m;
    }
    return i1;
  }
  
  public int getCompoundPaddingRight()
  {
    if (r0.b(this)) {
      return super.getCompoundPaddingRight();
    }
    int i2 = super.getCompoundPaddingRight() + this.A;
    int i1 = i2;
    if (!TextUtils.isEmpty(getText())) {
      i1 = i2 + this.m;
    }
    return i1;
  }
  
  public ActionMode.Callback getCustomSelectionActionModeCallback()
  {
    return l.q(super.getCustomSelectionActionModeCallback());
  }
  
  public boolean getShowText()
  {
    return this.s;
  }
  
  public boolean getSplitTrack()
  {
    return this.n;
  }
  
  public int getSwitchMinWidth()
  {
    return this.l;
  }
  
  public int getSwitchPadding()
  {
    return this.m;
  }
  
  public CharSequence getTextOff()
  {
    return this.q;
  }
  
  public CharSequence getTextOn()
  {
    return this.o;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.a;
  }
  
  public int getThumbTextPadding()
  {
    return this.k;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.b;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.c;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.f;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.g;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.h;
  }
  
  void j()
  {
    setTextOnInternal(this.o);
    setTextOffInternal(this.q);
    requestLayout();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Object localObject = this.a;
    if (localObject != null) {
      ((Drawable)localObject).jumpToCurrentState();
    }
    localObject = this.f;
    if (localObject != null) {
      ((Drawable)localObject).jumpToCurrentState();
    }
    localObject = this.N;
    if ((localObject != null) && (((ObjectAnimator)localObject).isStarted()))
    {
      this.N.end();
      this.N = null;
    }
  }
  
  public void m(Context paramContext, int paramInt)
  {
    k0 localk0 = k0.t(paramContext, paramInt, R.styleable.TextAppearance);
    paramContext = localk0.c(R.styleable.TextAppearance_android_textColor);
    if (paramContext == null) {
      paramContext = getTextColors();
    }
    this.J = paramContext;
    paramInt = localk0.f(R.styleable.TextAppearance_android_textSize, 0);
    if (paramInt != 0)
    {
      float f1 = paramInt;
      if (f1 != this.I.getTextSize())
      {
        this.I.setTextSize(f1);
        requestLayout();
      }
    }
    o(localk0.k(R.styleable.TextAppearance_android_typeface, -1), localk0.k(R.styleable.TextAppearance_android_textStyle, -1));
    if (localk0.a(R.styleable.TextAppearance_textAllCaps, false)) {
      paramContext = new f.a(getContext());
    } else {
      paramContext = null;
    }
    this.M = paramContext;
    setTextOnInternal(this.o);
    setTextOffInternal(this.q);
    localk0.w();
  }
  
  public void n(Typeface paramTypeface, int paramInt)
  {
    float f1 = 0.0F;
    boolean bool = false;
    if (paramInt > 0)
    {
      if (paramTypeface == null) {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
      } else {
        paramTypeface = Typeface.create(paramTypeface, paramInt);
      }
      setSwitchTypeface(paramTypeface);
      int i1;
      if (paramTypeface != null) {
        i1 = paramTypeface.getStyle();
      } else {
        i1 = 0;
      }
      paramInt = i1 & paramInt;
      paramTypeface = this.I;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      paramTypeface.setFakeBoldText(bool);
      paramTypeface = this.I;
      if ((paramInt & 0x2) != 0) {
        f1 = -0.25F;
      }
      paramTypeface.setTextSkewX(f1);
      return;
    }
    this.I.setFakeBoldText(false);
    this.I.setTextSkewX(0.0F);
    setSwitchTypeface(paramTypeface);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      CompoundButton.mergeDrawableStates(arrayOfInt, T);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = this.R;
    Object localObject3 = this.f;
    if (localObject3 != null) {
      ((Drawable)localObject3).getPadding((Rect)localObject1);
    } else {
      ((Rect)localObject1).setEmpty();
    }
    int i3 = this.F;
    int i4 = this.H;
    int i5 = ((Rect)localObject1).top;
    int i6 = ((Rect)localObject1).bottom;
    Object localObject2 = this.a;
    Object localObject4;
    int i1;
    if (localObject3 != null) {
      if ((this.n) && (localObject2 != null))
      {
        localObject4 = t.d((Drawable)localObject2);
        ((Drawable)localObject2).copyBounds((Rect)localObject1);
        ((Rect)localObject1).left += ((Rect)localObject4).left;
        ((Rect)localObject1).right -= ((Rect)localObject4).right;
        i1 = paramCanvas.save();
        paramCanvas.clipRect((Rect)localObject1, Region.Op.DIFFERENCE);
        ((Drawable)localObject3).draw(paramCanvas);
        paramCanvas.restoreToCount(i1);
      }
      else
      {
        ((Drawable)localObject3).draw(paramCanvas);
      }
    }
    int i2 = paramCanvas.save();
    if (localObject2 != null) {
      ((Drawable)localObject2).draw(paramCanvas);
    }
    if (getTargetCheckedState()) {
      localObject1 = this.K;
    } else {
      localObject1 = this.L;
    }
    if (localObject1 != null)
    {
      localObject3 = getDrawableState();
      localObject4 = this.J;
      if (localObject4 != null) {
        this.I.setColor(((ColorStateList)localObject4).getColorForState((int[])localObject3, 0));
      }
      this.I.drawableState = ((int[])localObject3);
      if (localObject2 != null)
      {
        localObject2 = ((Drawable)localObject2).getBounds();
        i1 = ((Rect)localObject2).left + ((Rect)localObject2).right;
      }
      else
      {
        i1 = getWidth();
      }
      i1 /= 2;
      int i7 = ((Layout)localObject1).getWidth() / 2;
      i3 = (i3 + i5 + (i4 - i6)) / 2;
      i4 = ((Layout)localObject1).getHeight() / 2;
      paramCanvas.translate(i1 - i7, i3 - i4);
      ((Layout)localObject1).draw(paramCanvas);
    }
    paramCanvas.restoreToCount(i2);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
    if (Build.VERSION.SDK_INT < 30)
    {
      CharSequence localCharSequence1;
      if (isChecked()) {
        localCharSequence1 = this.o;
      } else {
        localCharSequence1 = this.q;
      }
      if (!TextUtils.isEmpty(localCharSequence1))
      {
        CharSequence localCharSequence2 = paramAccessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(localCharSequence2))
        {
          paramAccessibilityNodeInfo.setText(localCharSequence1);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localCharSequence2);
        localStringBuilder.append(' ');
        localStringBuilder.append(localCharSequence1);
        paramAccessibilityNodeInfo.setText(localStringBuilder);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = this.a;
    paramInt1 = 0;
    if (localObject1 != null)
    {
      localObject1 = this.R;
      Object localObject2 = this.f;
      if (localObject2 != null) {
        ((Drawable)localObject2).getPadding((Rect)localObject1);
      } else {
        ((Rect)localObject1).setEmpty();
      }
      localObject2 = t.d(this.a);
      paramInt2 = Math.max(0, ((Rect)localObject2).left - ((Rect)localObject1).left);
      paramInt1 = Math.max(0, ((Rect)localObject2).right - ((Rect)localObject1).right);
    }
    else
    {
      paramInt2 = 0;
    }
    if (r0.b(this))
    {
      paramInt3 = getPaddingLeft() + paramInt2;
      paramInt1 = this.A + paramInt3 - paramInt2 - paramInt1;
      paramInt2 = paramInt3;
      paramInt3 = paramInt1;
    }
    else
    {
      paramInt3 = getWidth() - getPaddingRight() - paramInt1;
      paramInt2 = paramInt3 - this.A + paramInt2 + paramInt1;
    }
    paramInt1 = getGravity() & 0x70;
    if (paramInt1 != 16)
    {
      if (paramInt1 != 80)
      {
        paramInt1 = getPaddingTop();
        paramInt4 = this.B;
      }
      else
      {
        paramInt4 = getHeight() - getPaddingBottom();
        paramInt1 = paramInt4 - this.B;
        break label256;
      }
    }
    else
    {
      paramInt1 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2;
      paramInt4 = this.B;
      paramInt1 -= paramInt4 / 2;
    }
    paramInt4 += paramInt1;
    label256:
    this.E = paramInt2;
    this.F = paramInt1;
    this.H = paramInt4;
    this.G = paramInt3;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.s)
    {
      if (this.K == null) {
        this.K = i(this.p);
      }
      if (this.L == null) {
        this.L = i(this.r);
      }
    }
    Object localObject = this.R;
    Drawable localDrawable = this.a;
    int i4 = 0;
    int i2;
    if (localDrawable != null)
    {
      localDrawable.getPadding((Rect)localObject);
      i2 = this.a.getIntrinsicWidth() - ((Rect)localObject).left - ((Rect)localObject).right;
      i1 = this.a.getIntrinsicHeight();
    }
    else
    {
      i2 = 0;
      i1 = i2;
    }
    if (this.s) {
      i3 = Math.max(this.K.getWidth(), this.L.getWidth()) + this.k * 2;
    } else {
      i3 = 0;
    }
    this.C = Math.max(i3, i2);
    localDrawable = this.f;
    if (localDrawable != null)
    {
      localDrawable.getPadding((Rect)localObject);
      i2 = this.f.getIntrinsicHeight();
    }
    else
    {
      ((Rect)localObject).setEmpty();
      i2 = i4;
    }
    int i6 = ((Rect)localObject).left;
    int i5 = ((Rect)localObject).right;
    localObject = this.a;
    i4 = i5;
    int i3 = i6;
    if (localObject != null)
    {
      localObject = t.d((Drawable)localObject);
      i3 = Math.max(i6, ((Rect)localObject).left);
      i4 = Math.max(i5, ((Rect)localObject).right);
    }
    i3 = Math.max(this.l, this.C * 2 + i3 + i4);
    int i1 = Math.max(i2, i1);
    this.A = i3;
    this.B = i1;
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < i1) {
      setMeasuredDimension(getMeasuredWidthAndState(), i1);
    }
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    CharSequence localCharSequence;
    if (isChecked()) {
      localCharSequence = this.o;
    } else {
      localCharSequence = this.q;
    }
    if (localCharSequence != null) {
      paramAccessibilityEvent.getText().add(localCharSequence);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.x.addMovement(paramMotionEvent);
    int i1 = paramMotionEvent.getActionMasked();
    float f1;
    float f2;
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            break label306;
          }
        }
        else
        {
          i1 = this.t;
          if (i1 != 1)
          {
            if (i1 != 2) {
              break label306;
            }
            float f3 = paramMotionEvent.getX();
            i1 = getThumbScrollRange();
            f1 = f3 - this.v;
            if (i1 != 0) {
              f1 /= i1;
            } else if (f1 > 0.0F) {
              f1 = 1.0F;
            } else {
              f1 = -1.0F;
            }
            f2 = f1;
            if (r0.b(this)) {
              f2 = -f1;
            }
            f1 = f(this.z + f2, 0.0F, 1.0F);
            if (f1 != this.z)
            {
              this.v = f3;
              setThumbPosition(f1);
            }
            return true;
          }
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.v) <= this.u) && (Math.abs(f2 - this.w) <= this.u)) {
            break label306;
          }
          this.t = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.v = f1;
          this.w = f2;
          return true;
        }
      }
      if (this.t == 2)
      {
        q(paramMotionEvent);
        super.onTouchEvent(paramMotionEvent);
        return true;
      }
      this.t = 0;
      this.x.clear();
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      if ((isEnabled()) && (h(f1, f2)))
      {
        this.t = 1;
        this.v = f1;
        this.w = f2;
      }
    }
    label306:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    super.setAllCaps(paramBoolean);
    getEmojiTextViewHelper().d(paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if (paramBoolean) {
      l();
    } else {
      k();
    }
    if ((getWindowToken() != null) && (x.U(this)))
    {
      a(paramBoolean);
      return;
    }
    d();
    float f1;
    if (paramBoolean) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    setThumbPosition(f1);
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(l.r(this, paramCallback));
  }
  
  public void setEmojiCompatEnabled(boolean paramBoolean)
  {
    getEmojiTextViewHelper().e(paramBoolean);
    setTextOnInternal(this.o);
    setTextOffInternal(this.q);
    requestLayout();
  }
  
  public void setFilters(InputFilter[] paramArrayOfInputFilter)
  {
    super.setFilters(getEmojiTextViewHelper().a(paramArrayOfInputFilter));
  }
  
  public void setShowText(boolean paramBoolean)
  {
    if (this.s != paramBoolean)
    {
      this.s = paramBoolean;
      requestLayout();
      if (paramBoolean) {
        p();
      }
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.n = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.l = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.m = paramInt;
    requestLayout();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (((this.I.getTypeface() != null) && (!this.I.getTypeface().equals(paramTypeface))) || ((this.I.getTypeface() == null) && (paramTypeface != null)))
    {
      this.I.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    setTextOffInternal(paramCharSequence);
    requestLayout();
    if (!isChecked()) {
      k();
    }
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    setTextOnInternal(paramCharSequence);
    requestLayout();
    if (isChecked()) {
      l();
    }
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.a = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  void setThumbPosition(float paramFloat)
  {
    this.z = paramFloat;
    invalidate();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(c.a.b(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.k = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    this.b = paramColorStateList;
    this.d = true;
    b();
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    this.c = paramMode;
    this.e = true;
    b();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = this.f;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.f = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(c.a.b(getContext(), paramInt));
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList)
  {
    this.g = paramColorStateList;
    this.i = true;
    c();
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    this.h = paramMode;
    this.j = true;
    c();
  }
  
  public void toggle()
  {
    setChecked(isChecked() ^ true);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.a) || (paramDrawable == this.f);
  }
  
  class a
    extends Property<SwitchCompat, Float>
  {
    a(String paramString)
    {
      super(paramString);
    }
    
    public Float a(SwitchCompat paramSwitchCompat)
    {
      return Float.valueOf(paramSwitchCompat.z);
    }
    
    public void b(SwitchCompat paramSwitchCompat, Float paramFloat)
    {
      paramSwitchCompat.setThumbPosition(paramFloat.floatValue());
    }
  }
  
  static class b
    extends d.e
  {
    private final Reference<SwitchCompat> a;
    
    b(SwitchCompat paramSwitchCompat)
    {
      this.a = new WeakReference(paramSwitchCompat);
    }
    
    public void a(Throwable paramThrowable)
    {
      paramThrowable = (SwitchCompat)this.a.get();
      if (paramThrowable != null) {
        paramThrowable.j();
      }
    }
    
    public void b()
    {
      SwitchCompat localSwitchCompat = (SwitchCompat)this.a.get();
      if (localSwitchCompat != null) {
        localSwitchCompat.j();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.SwitchCompat
 * JD-Core Version:    0.7.0.1
 */