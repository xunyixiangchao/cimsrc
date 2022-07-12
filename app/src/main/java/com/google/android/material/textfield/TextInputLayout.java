package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStructure;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.x;
import androidx.core.widget.l;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.r;
import com.google.android.material.R.attr;
import com.google.android.material.R.color;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import r7.m;
import r7.m.b;

public class TextInputLayout
  extends LinearLayout
{
  private static final int J0 = R.style.Widget_Design_TextInputLayout;
  private CharSequence A;
  private int A0;
  private final TextView B;
  private int B0;
  private boolean C;
  private boolean C0;
  final com.google.android.material.internal.b D0;
  private CharSequence E;
  private boolean E0;
  private boolean F;
  private boolean F0;
  private r7.h G;
  private ValueAnimator G0;
  private r7.h H;
  private boolean H0;
  private r7.h I;
  private boolean I0;
  private m J;
  private boolean K;
  private final int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private int R;
  private int S;
  private final Rect T;
  private final Rect U;
  private final RectF V;
  private Typeface W;
  private final FrameLayout a;
  private Drawable a0;
  private final j b;
  private int b0;
  private final LinearLayout c;
  private final LinkedHashSet<f> c0;
  private final FrameLayout d;
  private int d0;
  EditText e;
  private final SparseArray<e> e0;
  private CharSequence f;
  private final CheckableImageButton f0;
  private int g;
  private final LinkedHashSet<g> g0;
  private int h;
  private ColorStateList h0;
  private int i;
  private PorterDuff.Mode i0;
  private int j;
  private Drawable j0;
  private final g k;
  private int k0;
  boolean l;
  private Drawable l0;
  private int m;
  private View.OnLongClickListener m0;
  private boolean n;
  private View.OnLongClickListener n0;
  private TextView o;
  private final CheckableImageButton o0;
  private int p;
  private ColorStateList p0;
  private int q;
  private PorterDuff.Mode q0;
  private CharSequence r;
  private ColorStateList r0;
  private boolean s;
  private ColorStateList s0;
  private TextView t;
  private int t0;
  private ColorStateList u;
  private int u0;
  private int v;
  private int v0;
  private Fade w;
  private ColorStateList w0;
  private Fade x;
  private int x0;
  private ColorStateList y;
  private int y0;
  private ColorStateList z;
  private int z0;
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.textInputStyle);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {}
  
  private boolean A()
  {
    return (this.C) && (!TextUtils.isEmpty(this.E)) && ((this.G instanceof c));
  }
  
  private void A0(int paramInt)
  {
    if ((paramInt == 0) && (!this.C0))
    {
      h0();
      return;
    }
    J();
  }
  
  private void B()
  {
    Iterator localIterator = this.c0.iterator();
    while (localIterator.hasNext()) {
      ((f)localIterator.next()).a(this);
    }
  }
  
  private void B0(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = this.w0.getDefaultColor();
    int i2 = this.w0.getColorForState(new int[] { 16843623, 16842910 }, i1);
    int i3 = this.w0.getColorForState(new int[] { 16843518, 16842910 }, i1);
    if (paramBoolean1)
    {
      this.R = i3;
      return;
    }
    if (paramBoolean2)
    {
      this.R = i2;
      return;
    }
    this.R = i1;
  }
  
  private void C(int paramInt)
  {
    Iterator localIterator = this.g0.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).a(this, paramInt);
    }
  }
  
  private void C0()
  {
    if (this.e == null) {
      return;
    }
    int i1;
    if ((!K()) && (!L())) {
      i1 = x.F(this.e);
    } else {
      i1 = 0;
    }
    x.F0(this.B, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.e.getPaddingTop(), i1, this.e.getPaddingBottom());
  }
  
  private void D(Canvas paramCanvas)
  {
    if (this.I != null)
    {
      Object localObject = this.H;
      if (localObject != null)
      {
        ((r7.h)localObject).draw(paramCanvas);
        if (this.e.isFocused())
        {
          localObject = this.I.getBounds();
          Rect localRect = this.H.getBounds();
          float f1 = this.D0.D();
          int i1 = localRect.centerX();
          ((Rect)localObject).left = e7.a.c(i1, localRect.left, f1);
          ((Rect)localObject).right = e7.a.c(i1, localRect.right, f1);
          this.I.draw(paramCanvas);
        }
      }
    }
  }
  
  private void D0()
  {
    int i2 = this.B.getVisibility();
    Object localObject = this.A;
    boolean bool = false;
    int i1;
    if ((localObject != null) && (!N())) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    if (i2 != i1)
    {
      localObject = getEndIconDelegate();
      if (i1 == 0) {
        bool = true;
      }
      ((e)localObject).c(bool);
    }
    t0();
    this.B.setVisibility(i1);
    q0();
  }
  
  private void E(Canvas paramCanvas)
  {
    if (this.C) {
      this.D0.l(paramCanvas);
    }
  }
  
  private void F(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = this.G0;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.G0.cancel();
    }
    if ((paramBoolean) && (this.F0)) {
      k(0.0F);
    } else {
      this.D0.u0(0.0F);
    }
    if ((A()) && (((c)this.G).q0())) {
      x();
    }
    this.C0 = true;
    J();
    this.b.i(true);
    D0();
  }
  
  private int G(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt + this.e.getCompoundPaddingLeft();
    paramInt = i1;
    if (getPrefixText() != null)
    {
      paramInt = i1;
      if (!paramBoolean) {
        paramInt = i1 - getPrefixTextView().getMeasuredWidth() + getPrefixTextView().getPaddingLeft();
      }
    }
    return paramInt;
  }
  
  private int H(int paramInt, boolean paramBoolean)
  {
    int i1 = paramInt - this.e.getCompoundPaddingRight();
    paramInt = i1;
    if (getPrefixText() != null)
    {
      paramInt = i1;
      if (paramBoolean) {
        paramInt = i1 + (getPrefixTextView().getMeasuredWidth() - getPrefixTextView().getPaddingRight());
      }
    }
    return paramInt;
  }
  
  private boolean I()
  {
    return this.d0 != 0;
  }
  
  private void J()
  {
    TextView localTextView = this.t;
    if ((localTextView != null) && (this.s))
    {
      localTextView.setText(null);
      r.a(this.a, this.x);
      this.t.setVisibility(4);
    }
  }
  
  private boolean L()
  {
    return this.o0.getVisibility() == 0;
  }
  
  private boolean P()
  {
    return (this.M == 1) && (this.e.getMinLines() <= 1);
  }
  
  private void Q()
  {
    o();
    Z();
    E0();
    j0();
    j();
    if (this.M != 0) {
      v0();
    }
  }
  
  private void R()
  {
    if (!A()) {
      return;
    }
    RectF localRectF = this.V;
    this.D0.o(localRectF, this.e.getWidth(), this.e.getGravity());
    n(localRectF);
    localRectF.offset(-getPaddingLeft(), -getPaddingTop() - localRectF.height() / 2.0F + this.O);
    ((c)this.G).t0(localRectF);
  }
  
  private void S()
  {
    if ((A()) && (!this.C0))
    {
      x();
      R();
    }
  }
  
  private static void T(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = paramViewGroup.getChildAt(i1);
      localView.setEnabled(paramBoolean);
      if ((localView instanceof ViewGroup)) {
        T((ViewGroup)localView, paramBoolean);
      }
      i1 += 1;
    }
  }
  
  private void X()
  {
    TextView localTextView = this.t;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void Z()
  {
    if (g0()) {
      x.u0(this.e, this.G);
    }
  }
  
  private static void a0(CheckableImageButton paramCheckableImageButton, View.OnLongClickListener paramOnLongClickListener)
  {
    boolean bool3 = x.P(paramCheckableImageButton);
    boolean bool2 = false;
    int i1 = 1;
    boolean bool1;
    if (paramOnLongClickListener != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((bool3) || (bool1)) {
      bool2 = true;
    }
    paramCheckableImageButton.setFocusable(bool2);
    paramCheckableImageButton.setClickable(bool3);
    paramCheckableImageButton.setPressable(bool3);
    paramCheckableImageButton.setLongClickable(bool1);
    if (!bool2) {
      i1 = 2;
    }
    x.B0(paramCheckableImageButton, i1);
  }
  
  private static void b0(CheckableImageButton paramCheckableImageButton, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener)
  {
    paramCheckableImageButton.setOnClickListener(paramOnClickListener);
    a0(paramCheckableImageButton, paramOnLongClickListener);
  }
  
  private static void c0(CheckableImageButton paramCheckableImageButton, View.OnLongClickListener paramOnLongClickListener)
  {
    paramCheckableImageButton.setOnLongClickListener(paramOnLongClickListener);
    a0(paramCheckableImageButton, paramOnLongClickListener);
  }
  
  private boolean e0()
  {
    return ((this.o0.getVisibility() == 0) || ((I()) && (K())) || (this.A != null)) && (this.c.getMeasuredWidth() > 0);
  }
  
  private boolean f0()
  {
    return ((getStartIconDrawable() != null) || ((getPrefixText() != null) && (getPrefixTextView().getVisibility() == 0))) && (this.b.getMeasuredWidth() > 0);
  }
  
  private boolean g0()
  {
    EditText localEditText = this.e;
    return (localEditText != null) && (this.G != null) && (localEditText.getBackground() == null) && (this.M != 0);
  }
  
  private e getEndIconDelegate()
  {
    e locale = (e)this.e0.get(this.d0);
    if (locale != null) {
      return locale;
    }
    return (e)this.e0.get(0);
  }
  
  private CheckableImageButton getEndIconToUpdateDummyDrawable()
  {
    if (this.o0.getVisibility() == 0) {
      return this.o0;
    }
    if ((I()) && (K())) {
      return this.f0;
    }
    return null;
  }
  
  private void h0()
  {
    if ((this.t != null) && (this.s) && (!TextUtils.isEmpty(this.r)))
    {
      this.t.setText(this.r);
      r.a(this.a, this.w);
      this.t.setVisibility(0);
      this.t.bringToFront();
      announceForAccessibility(this.r);
    }
  }
  
  private void i()
  {
    TextView localTextView = this.t;
    if (localTextView != null)
    {
      this.a.addView(localTextView);
      this.t.setVisibility(0);
    }
  }
  
  private void i0(boolean paramBoolean)
  {
    if ((paramBoolean) && (getEndIconDrawable() != null))
    {
      Drawable localDrawable = r0.a.r(getEndIconDrawable()).mutate();
      r0.a.n(localDrawable, this.k.p());
      this.f0.setImageDrawable(localDrawable);
      return;
    }
    f.a(this, this.f0, this.h0, this.i0);
  }
  
  private void j()
  {
    if (this.e != null)
    {
      if (this.M != 1) {
        return;
      }
      EditText localEditText;
      int i1;
      int i2;
      int i3;
      Resources localResources;
      if (o7.c.j(getContext()))
      {
        localEditText = this.e;
        i1 = x.G(localEditText);
        i2 = getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top);
        i3 = x.F(this.e);
        localResources = getResources();
      }
      for (int i4 = R.dimen.material_filled_edittext_font_2_0_padding_bottom;; i4 = R.dimen.material_filled_edittext_font_1_3_padding_bottom)
      {
        x.F0(localEditText, i1, i2, i3, localResources.getDimensionPixelSize(i4));
        return;
        if (!o7.c.i(getContext())) {
          break;
        }
        localEditText = this.e;
        i1 = x.G(localEditText);
        i2 = getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top);
        i3 = x.F(this.e);
        localResources = getResources();
      }
    }
  }
  
  private void j0()
  {
    if (this.M == 1)
    {
      Resources localResources;
      if (o7.c.j(getContext())) {
        localResources = getResources();
      }
      for (int i1 = R.dimen.material_font_2_0_box_collapsed_padding_top;; i1 = R.dimen.material_font_1_3_box_collapsed_padding_top)
      {
        this.N = localResources.getDimensionPixelSize(i1);
        return;
        if (!o7.c.i(getContext())) {
          break;
        }
        localResources = getResources();
      }
    }
  }
  
  private void k0(Rect paramRect)
  {
    r7.h localh = this.H;
    int i1;
    int i2;
    if (localh != null)
    {
      i1 = paramRect.bottom;
      i2 = this.P;
      localh.setBounds(paramRect.left, i1 - i2, paramRect.right, i1);
    }
    localh = this.I;
    if (localh != null)
    {
      i1 = paramRect.bottom;
      i2 = this.Q;
      localh.setBounds(paramRect.left, i1 - i2, paramRect.right, i1);
    }
  }
  
  private void l()
  {
    Object localObject = this.G;
    if (localObject == null) {
      return;
    }
    localObject = ((r7.h)localObject).E();
    m localm = this.J;
    if (localObject != localm)
    {
      this.G.setShapeAppearanceModel(localm);
      p0();
    }
    if (v()) {
      this.G.j0(this.O, this.R);
    }
    int i1 = p();
    this.S = i1;
    this.G.b0(ColorStateList.valueOf(i1));
    if (this.d0 == 3) {
      this.e.getBackground().invalidateSelf();
    }
    m();
    invalidate();
  }
  
  private void l0()
  {
    if (this.o != null)
    {
      EditText localEditText = this.e;
      int i1;
      if (localEditText == null) {
        i1 = 0;
      } else {
        i1 = localEditText.getText().length();
      }
      m0(i1);
    }
  }
  
  private void m()
  {
    if (this.H != null)
    {
      if (this.I == null) {
        return;
      }
      if (w())
      {
        r7.h localh = this.H;
        int i1;
        if (this.e.isFocused()) {
          i1 = this.t0;
        } else {
          i1 = this.R;
        }
        localh.b0(ColorStateList.valueOf(i1));
        this.I.b0(ColorStateList.valueOf(this.R));
      }
      invalidate();
    }
  }
  
  private void n(RectF paramRectF)
  {
    float f1 = paramRectF.left;
    int i1 = this.L;
    paramRectF.left = (f1 - i1);
    paramRectF.right += i1;
  }
  
  private static void n0(Context paramContext, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = R.string.character_counter_overflowed_content_description;
    } else {
      i1 = R.string.character_counter_content_description;
    }
    paramTextView.setContentDescription(paramContext.getString(i1, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
  }
  
  private void o()
  {
    int i1 = this.M;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        Object localObject;
        if (i1 == 2)
        {
          if ((this.C) && (!(this.G instanceof c))) {
            localObject = new c(this.J);
          } else {
            localObject = new r7.h(this.J);
          }
          this.G = ((r7.h)localObject);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.M);
          ((StringBuilder)localObject).append(" is illegal; only @BoxBackgroundMode constants are supported.");
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.G = new r7.h(this.J);
        this.H = new r7.h();
        this.I = new r7.h();
      }
    }
    else {
      this.G = null;
    }
    this.H = null;
    this.I = null;
  }
  
  private void o0()
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      int i1;
      if (this.n) {
        i1 = this.p;
      } else {
        i1 = this.q;
      }
      d0((TextView)localObject, i1);
      if (!this.n)
      {
        localObject = this.y;
        if (localObject != null) {
          this.o.setTextColor((ColorStateList)localObject);
        }
      }
      if (this.n)
      {
        localObject = this.z;
        if (localObject != null) {
          this.o.setTextColor((ColorStateList)localObject);
        }
      }
    }
  }
  
  private int p()
  {
    int i1 = this.S;
    if (this.M == 1) {
      i1 = g7.a.g(g7.a.e(this, R.attr.colorSurface, 0), this.S);
    }
    return i1;
  }
  
  private void p0()
  {
    if ((this.d0 == 3) && (this.M == 2)) {
      ((d)this.e0.get(3)).O((AutoCompleteTextView)this.e);
    }
  }
  
  private Rect q(Rect paramRect)
  {
    if (this.e != null)
    {
      Rect localRect = this.U;
      boolean bool = com.google.android.material.internal.t.i(this);
      localRect.bottom = paramRect.bottom;
      int i1 = this.M;
      if (i1 != 1) {
        if (i1 != 2) {
          localRect.left = G(paramRect.left, bool);
        }
      }
      for (i1 = getPaddingTop();; i1 = paramRect.top + this.N)
      {
        localRect.top = i1;
        for (i1 = H(paramRect.right, bool);; i1 = paramRect.right - this.e.getPaddingRight())
        {
          localRect.right = i1;
          return localRect;
          paramRect.left += this.e.getPaddingLeft();
          paramRect.top -= u();
        }
        localRect.left = G(paramRect.left, bool);
      }
    }
    throw new IllegalStateException();
  }
  
  private int r(Rect paramRect1, Rect paramRect2, float paramFloat)
  {
    if (P()) {
      return (int)(paramRect2.top + paramFloat);
    }
    return paramRect1.bottom - this.e.getCompoundPaddingBottom();
  }
  
  private int s(Rect paramRect, float paramFloat)
  {
    if (P()) {
      return (int)(paramRect.centerY() - paramFloat / 2.0F);
    }
    return paramRect.top + this.e.getCompoundPaddingTop();
  }
  
  private boolean s0()
  {
    if (this.e == null) {
      return false;
    }
    int i1 = Math.max(this.c.getMeasuredHeight(), this.b.getMeasuredHeight());
    if (this.e.getMeasuredHeight() < i1)
    {
      this.e.setMinimumHeight(i1);
      return true;
    }
    return false;
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (this.e == null)
    {
      if ((this.d0 != 3) && (!(paramEditText instanceof TextInputEditText))) {
        Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
      }
      this.e = paramEditText;
      int i1 = this.g;
      if (i1 != -1) {
        setMinEms(i1);
      } else {
        setMinWidth(this.i);
      }
      i1 = this.h;
      if (i1 != -1) {
        setMaxEms(i1);
      } else {
        setMaxWidth(this.j);
      }
      Q();
      setTextInputAccessibilityDelegate(new e(this));
      this.D0.H0(this.e.getTypeface());
      this.D0.r0(this.e.getTextSize());
      this.D0.m0(this.e.getLetterSpacing());
      i1 = this.e.getGravity();
      this.D0.g0(i1 & 0xFFFFFF8F | 0x30);
      this.D0.q0(i1);
      this.e.addTextChangedListener(new a());
      if (this.r0 == null) {
        this.r0 = this.e.getHintTextColors();
      }
      if (this.C)
      {
        if (TextUtils.isEmpty(this.E))
        {
          CharSequence localCharSequence = this.e.getHint();
          this.f = localCharSequence;
          setHint(localCharSequence);
          this.e.setHint(null);
        }
        this.F = true;
      }
      if (this.o != null) {
        m0(this.e.getText().length());
      }
      r0();
      this.k.f();
      this.b.bringToFront();
      this.c.bringToFront();
      this.d.bringToFront();
      this.o0.bringToFront();
      B();
      C0();
      if (!isEnabled()) {
        paramEditText.setEnabled(false);
      }
      x0(false, true);
      return;
    }
    throw new IllegalArgumentException("We already have an EditText, can only have one");
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(paramCharSequence, this.E))
    {
      this.E = paramCharSequence;
      this.D0.F0(paramCharSequence);
      if (!this.C0) {
        R();
      }
    }
  }
  
  private void setPlaceholderTextEnabled(boolean paramBoolean)
  {
    if (this.s == paramBoolean) {
      return;
    }
    if (paramBoolean)
    {
      i();
    }
    else
    {
      X();
      this.t = null;
    }
    this.s = paramBoolean;
  }
  
  private Rect t(Rect paramRect)
  {
    if (this.e != null)
    {
      Rect localRect = this.U;
      float f1 = this.D0.B();
      paramRect.left += this.e.getCompoundPaddingLeft();
      localRect.top = s(paramRect, f1);
      paramRect.right -= this.e.getCompoundPaddingRight();
      localRect.bottom = r(paramRect, localRect, f1);
      return localRect;
    }
    throw new IllegalStateException();
  }
  
  private void t0()
  {
    Object localObject = this.d;
    int i1 = this.f0.getVisibility();
    int i2 = 8;
    if ((i1 == 0) && (!L())) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FrameLayout)localObject).setVisibility(i1);
    if ((this.A != null) && (!N())) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    if ((!K()) && (!L()) && (i1 != 0)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    localObject = this.c;
    if (i1 != 0) {
      i2 = 0;
    }
    ((LinearLayout)localObject).setVisibility(i2);
  }
  
  private int u()
  {
    if (!this.C) {
      return 0;
    }
    int i1 = this.M;
    if (i1 != 0) {
      if (i1 != 2) {
        return 0;
      }
    }
    for (float f1 = this.D0.r() / 2.0F;; f1 = this.D0.r()) {
      return (int)f1;
    }
  }
  
  private void u0()
  {
    Object localObject = getErrorIconDrawable();
    int i2 = 0;
    int i1;
    if ((localObject != null) && (this.k.z()) && (this.k.l())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject = this.o0;
    if (i1 != 0) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((ImageButton)localObject).setVisibility(i1);
    t0();
    C0();
    if (!I()) {
      q0();
    }
  }
  
  private boolean v()
  {
    return (this.M == 2) && (w());
  }
  
  private void v0()
  {
    if (this.M != 1)
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
      int i1 = u();
      if (i1 != localLayoutParams.topMargin)
      {
        localLayoutParams.topMargin = i1;
        this.a.requestLayout();
      }
    }
  }
  
  private boolean w()
  {
    return (this.O > -1) && (this.R != 0);
  }
  
  private void x()
  {
    if (A()) {
      ((c)this.G).r0();
    }
  }
  
  private void x0(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = isEnabled();
    Object localObject = this.e;
    int i1;
    if ((localObject != null) && (!TextUtils.isEmpty(((EditText)localObject).getText()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    localObject = this.e;
    int i2;
    if ((localObject != null) && (((EditText)localObject).hasFocus())) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    boolean bool2 = this.k.l();
    localObject = this.r0;
    if (localObject != null)
    {
      this.D0.f0((ColorStateList)localObject);
      this.D0.p0(this.r0);
    }
    if (!bool1)
    {
      localObject = this.r0;
      int i3;
      if (localObject != null)
      {
        i3 = this.B0;
        i3 = ((ColorStateList)localObject).getColorForState(new int[] { -16842910 }, i3);
      }
      else
      {
        i3 = this.B0;
      }
      this.D0.f0(ColorStateList.valueOf(i3));
      this.D0.p0(ColorStateList.valueOf(i3));
    }
    else if (bool2)
    {
      this.D0.f0(this.k.q());
    }
    else
    {
      com.google.android.material.internal.b localb;
      if (this.n)
      {
        localObject = this.o;
        if (localObject != null)
        {
          localb = this.D0;
          localObject = ((TextView)localObject).getTextColors();
        }
      }
      for (;;)
      {
        localb.f0((ColorStateList)localObject);
        break;
        if (i2 == 0) {
          break;
        }
        localObject = this.s0;
        if (localObject == null) {
          break;
        }
        localb = this.D0;
      }
    }
    if ((i1 == 0) && (this.E0) && ((!isEnabled()) || (i2 == 0)))
    {
      if ((paramBoolean2) || (!this.C0)) {
        F(paramBoolean1);
      }
    }
    else if ((paramBoolean2) || (this.C0)) {
      y(paramBoolean1);
    }
  }
  
  private void y(boolean paramBoolean)
  {
    ValueAnimator localValueAnimator = this.G0;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.G0.cancel();
    }
    if ((paramBoolean) && (this.F0)) {
      k(1.0F);
    } else {
      this.D0.u0(1.0F);
    }
    this.C0 = false;
    if (A()) {
      R();
    }
    z0();
    this.b.i(false);
    D0();
  }
  
  private void y0()
  {
    if (this.t != null)
    {
      EditText localEditText = this.e;
      if (localEditText != null)
      {
        int i1 = localEditText.getGravity();
        this.t.setGravity(i1);
        this.t.setPadding(this.e.getCompoundPaddingLeft(), this.e.getCompoundPaddingTop(), this.e.getCompoundPaddingRight(), this.e.getCompoundPaddingBottom());
      }
    }
  }
  
  private Fade z()
  {
    Fade localFade = new Fade();
    localFade.b0(87L);
    localFade.e0(e7.a.a);
    return localFade;
  }
  
  private void z0()
  {
    EditText localEditText = this.e;
    int i1;
    if (localEditText == null) {
      i1 = 0;
    } else {
      i1 = localEditText.getText().length();
    }
    A0(i1);
  }
  
  void E0()
  {
    if (this.G != null)
    {
      if (this.M == 0) {
        return;
      }
      boolean bool1 = isFocused();
      boolean bool3 = false;
      Object localObject;
      if (!bool1)
      {
        localObject = this.e;
        if ((localObject == null) || (!((EditText)localObject).hasFocus()))
        {
          bool1 = false;
          break label56;
        }
      }
      bool1 = true;
      label56:
      boolean bool2;
      if (!isHovered())
      {
        localObject = this.e;
        bool2 = bool3;
        if (localObject != null)
        {
          bool2 = bool3;
          if (!((EditText)localObject).isHovered()) {}
        }
      }
      else
      {
        bool2 = true;
      }
      int i1;
      if (!isEnabled()) {
        i1 = this.B0;
      }
      for (;;)
      {
        this.R = i1;
        break;
        if (this.k.l()) {
          if (this.w0 == null) {}
        }
        do
        {
          B0(bool1, bool2);
          break label221;
          i1 = this.k.p();
          break;
          if (!this.n) {
            break label188;
          }
          localObject = this.o;
          if (localObject == null) {
            break label188;
          }
        } while (this.w0 != null);
        i1 = ((TextView)localObject).getCurrentTextColor();
        continue;
        label188:
        if (bool1) {
          i1 = this.v0;
        } else if (bool2) {
          i1 = this.u0;
        } else {
          i1 = this.t0;
        }
      }
      label221:
      u0();
      V();
      W();
      U();
      if (getEndIconDelegate().d()) {
        i0(this.k.l());
      }
      if (this.M == 2)
      {
        int i2 = this.O;
        if ((bool1) && (isEnabled())) {
          i1 = this.Q;
        } else {
          i1 = this.P;
        }
        this.O = i1;
        if (this.O != i2) {
          S();
        }
      }
      if (this.M == 1)
      {
        if (!isEnabled()) {
          i1 = this.y0;
        }
        for (;;)
        {
          this.S = i1;
          break;
          if ((bool2) && (!bool1)) {
            i1 = this.A0;
          } else if (bool1) {
            i1 = this.z0;
          } else {
            i1 = this.x0;
          }
        }
      }
      l();
    }
  }
  
  public boolean K()
  {
    return (this.d.getVisibility() == 0) && (this.f0.getVisibility() == 0);
  }
  
  public boolean M()
  {
    return this.k.A();
  }
  
  final boolean N()
  {
    return this.C0;
  }
  
  public boolean O()
  {
    return this.F;
  }
  
  public void U()
  {
    f.c(this, this.f0, this.h0);
  }
  
  public void V()
  {
    f.c(this, this.o0, this.p0);
  }
  
  public void W()
  {
    this.b.j();
  }
  
  public void Y(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    boolean bool = com.google.android.material.internal.t.i(this);
    this.K = bool;
    float f1;
    if (bool) {
      f1 = paramFloat2;
    } else {
      f1 = paramFloat1;
    }
    if (!bool) {
      paramFloat1 = paramFloat2;
    }
    if (bool) {
      paramFloat2 = paramFloat4;
    } else {
      paramFloat2 = paramFloat3;
    }
    if (!bool) {
      paramFloat3 = paramFloat4;
    }
    r7.h localh = this.G;
    if ((localh == null) || (localh.J() != f1) || (this.G.K() != paramFloat1) || (this.G.s() != paramFloat2) || (this.G.t() != paramFloat3))
    {
      this.J = this.J.v().E(f1).I(paramFloat1).v(paramFloat2).z(paramFloat3).m();
      l();
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.a.addView(paramView, localLayoutParams);
      this.a.setLayoutParams(paramLayoutParams);
      v0();
      setEditText((EditText)paramView);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  void d0(TextView paramTextView, int paramInt)
  {
    i1 = 1;
    try
    {
      l.o(paramTextView, paramInt);
      paramInt = paramTextView.getTextColors().getDefaultColor();
      if (paramInt == -65281) {
        paramInt = i1;
      } else {
        paramInt = 0;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramInt = i1;
      }
    }
    if (paramInt != 0)
    {
      l.o(paramTextView, R.style.TextAppearance_AppCompat_Caption);
      paramTextView.setTextColor(androidx.core.content.b.b(getContext(), R.color.design_error));
    }
  }
  
  @TargetApi(26)
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    Object localObject1 = this.e;
    if (localObject1 == null)
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    Object localObject2 = this.f;
    int i1 = 0;
    if (localObject2 != null)
    {
      boolean bool = this.F;
      this.F = false;
      localObject1 = ((EditText)localObject1).getHint();
      this.e.setHint(this.f);
      try
      {
        super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
        return;
      }
      finally
      {
        this.e.setHint((CharSequence)localObject1);
        this.F = bool;
      }
    }
    paramViewStructure.setAutofillId(getAutofillId());
    onProvideAutofillStructure(paramViewStructure, paramInt);
    onProvideAutofillVirtualStructure(paramViewStructure, paramInt);
    paramViewStructure.setChildCount(this.a.getChildCount());
    while (i1 < this.a.getChildCount())
    {
      localObject1 = this.a.getChildAt(i1);
      localObject2 = paramViewStructure.newChild(i1);
      ((View)localObject1).dispatchProvideAutofillStructure((ViewStructure)localObject2, paramInt);
      if (localObject1 == this.e) {
        ((ViewStructure)localObject2).setHint(getHint());
      }
      i1 += 1;
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    this.I0 = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.I0 = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    E(paramCanvas);
    D(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.H0) {
      return;
    }
    boolean bool2 = true;
    this.H0 = true;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    com.google.android.material.internal.b localb = this.D0;
    boolean bool1;
    if (localb != null) {
      bool1 = localb.E0(arrayOfInt) | false;
    } else {
      bool1 = false;
    }
    if (this.e != null)
    {
      if ((!x.U(this)) || (!isEnabled())) {
        bool2 = false;
      }
      w0(bool2);
    }
    r0();
    E0();
    if (bool1) {
      invalidate();
    }
    this.H0 = false;
  }
  
  public void g(f paramf)
  {
    this.c0.add(paramf);
    if (this.e != null) {
      paramf.a(this);
    }
  }
  
  public int getBaseline()
  {
    EditText localEditText = this.e;
    if (localEditText != null) {
      return localEditText.getBaseline() + getPaddingTop() + u();
    }
    return super.getBaseline();
  }
  
  r7.h getBoxBackground()
  {
    int i1 = this.M;
    if ((i1 != 1) && (i1 != 2)) {
      throw new IllegalStateException();
    }
    return this.G;
  }
  
  public int getBoxBackgroundColor()
  {
    return this.S;
  }
  
  public int getBoxBackgroundMode()
  {
    return this.M;
  }
  
  public int getBoxCollapsedPaddingTop()
  {
    return this.N;
  }
  
  public float getBoxCornerRadiusBottomEnd()
  {
    r7.c localc;
    if (com.google.android.material.internal.t.i(this)) {
      localc = this.J.j();
    } else {
      localc = this.J.l();
    }
    return localc.a(this.V);
  }
  
  public float getBoxCornerRadiusBottomStart()
  {
    r7.c localc;
    if (com.google.android.material.internal.t.i(this)) {
      localc = this.J.l();
    } else {
      localc = this.J.j();
    }
    return localc.a(this.V);
  }
  
  public float getBoxCornerRadiusTopEnd()
  {
    r7.c localc;
    if (com.google.android.material.internal.t.i(this)) {
      localc = this.J.r();
    } else {
      localc = this.J.t();
    }
    return localc.a(this.V);
  }
  
  public float getBoxCornerRadiusTopStart()
  {
    r7.c localc;
    if (com.google.android.material.internal.t.i(this)) {
      localc = this.J.t();
    } else {
      localc = this.J.r();
    }
    return localc.a(this.V);
  }
  
  public int getBoxStrokeColor()
  {
    return this.v0;
  }
  
  public ColorStateList getBoxStrokeErrorColor()
  {
    return this.w0;
  }
  
  public int getBoxStrokeWidth()
  {
    return this.P;
  }
  
  public int getBoxStrokeWidthFocused()
  {
    return this.Q;
  }
  
  public int getCounterMaxLength()
  {
    return this.m;
  }
  
  CharSequence getCounterOverflowDescription()
  {
    if ((this.l) && (this.n))
    {
      TextView localTextView = this.o;
      if (localTextView != null) {
        return localTextView.getContentDescription();
      }
    }
    return null;
  }
  
  public ColorStateList getCounterOverflowTextColor()
  {
    return this.y;
  }
  
  public ColorStateList getCounterTextColor()
  {
    return this.y;
  }
  
  public ColorStateList getDefaultHintTextColor()
  {
    return this.r0;
  }
  
  public EditText getEditText()
  {
    return this.e;
  }
  
  public CharSequence getEndIconContentDescription()
  {
    return this.f0.getContentDescription();
  }
  
  public Drawable getEndIconDrawable()
  {
    return this.f0.getDrawable();
  }
  
  public int getEndIconMode()
  {
    return this.d0;
  }
  
  CheckableImageButton getEndIconView()
  {
    return this.f0;
  }
  
  public CharSequence getError()
  {
    if (this.k.z()) {
      return this.k.o();
    }
    return null;
  }
  
  public CharSequence getErrorContentDescription()
  {
    return this.k.n();
  }
  
  public int getErrorCurrentTextColors()
  {
    return this.k.p();
  }
  
  public Drawable getErrorIconDrawable()
  {
    return this.o0.getDrawable();
  }
  
  final int getErrorTextCurrentColor()
  {
    return this.k.p();
  }
  
  public CharSequence getHelperText()
  {
    if (this.k.A()) {
      return this.k.r();
    }
    return null;
  }
  
  public int getHelperTextCurrentTextColor()
  {
    return this.k.t();
  }
  
  public CharSequence getHint()
  {
    if (this.C) {
      return this.E;
    }
    return null;
  }
  
  final float getHintCollapsedTextHeight()
  {
    return this.D0.r();
  }
  
  final int getHintCurrentCollapsedTextColor()
  {
    return this.D0.v();
  }
  
  public ColorStateList getHintTextColor()
  {
    return this.s0;
  }
  
  public int getMaxEms()
  {
    return this.h;
  }
  
  public int getMaxWidth()
  {
    return this.j;
  }
  
  public int getMinEms()
  {
    return this.g;
  }
  
  public int getMinWidth()
  {
    return this.i;
  }
  
  @Deprecated
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.f0.getContentDescription();
  }
  
  @Deprecated
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.f0.getDrawable();
  }
  
  public CharSequence getPlaceholderText()
  {
    if (this.s) {
      return this.r;
    }
    return null;
  }
  
  public int getPlaceholderTextAppearance()
  {
    return this.v;
  }
  
  public ColorStateList getPlaceholderTextColor()
  {
    return this.u;
  }
  
  public CharSequence getPrefixText()
  {
    return this.b.a();
  }
  
  public ColorStateList getPrefixTextColor()
  {
    return this.b.b();
  }
  
  public TextView getPrefixTextView()
  {
    return this.b.c();
  }
  
  public CharSequence getStartIconContentDescription()
  {
    return this.b.d();
  }
  
  public Drawable getStartIconDrawable()
  {
    return this.b.e();
  }
  
  public CharSequence getSuffixText()
  {
    return this.A;
  }
  
  public ColorStateList getSuffixTextColor()
  {
    return this.B.getTextColors();
  }
  
  public TextView getSuffixTextView()
  {
    return this.B;
  }
  
  public Typeface getTypeface()
  {
    return this.W;
  }
  
  public void h(g paramg)
  {
    this.g0.add(paramg);
  }
  
  void k(float paramFloat)
  {
    if (this.D0.D() == paramFloat) {
      return;
    }
    if (this.G0 == null)
    {
      ValueAnimator localValueAnimator = new ValueAnimator();
      this.G0 = localValueAnimator;
      localValueAnimator.setInterpolator(e7.a.b);
      this.G0.setDuration(167L);
      this.G0.addUpdateListener(new d());
    }
    this.G0.setFloatValues(new float[] { this.D0.D(), paramFloat });
    this.G0.start();
  }
  
  void m0(int paramInt)
  {
    boolean bool2 = this.n;
    int i1 = this.m;
    if (i1 == -1)
    {
      this.o.setText(String.valueOf(paramInt));
      this.o.setContentDescription(null);
      this.n = false;
    }
    else
    {
      boolean bool1;
      if (paramInt > i1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.n = bool1;
      n0(getContext(), this.o, paramInt, this.m, this.n);
      if (bool2 != this.n) {
        o0();
      }
      w0.a locala = w0.a.c();
      this.o.setText(locala.j(getContext().getString(R.string.character_counter_pattern, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.m) })));
    }
    if ((this.e != null) && (bool2 != this.n))
    {
      w0(false);
      E0();
      r0();
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.D0.V(paramConfiguration);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    EditText localEditText = this.e;
    if (localEditText != null)
    {
      Rect localRect = this.T;
      com.google.android.material.internal.d.a(this, localEditText, localRect);
      k0(localRect);
      if (this.C)
      {
        this.D0.r0(this.e.getTextSize());
        paramInt1 = this.e.getGravity();
        this.D0.g0(paramInt1 & 0xFFFFFF8F | 0x30);
        this.D0.q0(paramInt1);
        this.D0.c0(q(localRect));
        this.D0.l0(t(localRect));
        this.D0.Y();
        if ((A()) && (!this.C0)) {
          R();
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    boolean bool1 = s0();
    boolean bool2 = q0();
    if ((bool1) || (bool2)) {
      this.e.post(new c());
    }
    y0();
    C0();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.g());
    setError(paramParcelable.c);
    if (paramParcelable.d) {
      this.f0.post(new b());
    }
    setHint(paramParcelable.e);
    setHelperText(paramParcelable.f);
    setPlaceholderText(paramParcelable.g);
    requestLayout();
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    super.onRtlPropertiesChanged(paramInt);
    int i1 = 0;
    boolean bool1;
    if (paramInt == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = this.K;
    if (bool1 != bool2)
    {
      paramInt = i1;
      if (bool1)
      {
        paramInt = i1;
        if (!bool2) {
          paramInt = 1;
        }
      }
      float f4 = this.J.r().a(this.V);
      float f5 = this.J.t().a(this.V);
      float f2 = this.J.j().a(this.V);
      float f1 = this.J.l().a(this.V);
      float f3;
      if (paramInt != 0) {
        f3 = f4;
      } else {
        f3 = f5;
      }
      if (paramInt != 0) {
        f4 = f5;
      }
      if (paramInt != 0) {
        f5 = f2;
      } else {
        f5 = f1;
      }
      if (paramInt != 0) {
        f2 = f1;
      }
      Y(f3, f4, f5, f2);
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.k.l()) {
      localSavedState.c = getError();
    }
    boolean bool;
    if ((I()) && (this.f0.isChecked())) {
      bool = true;
    } else {
      bool = false;
    }
    localSavedState.d = bool;
    localSavedState.e = getHint();
    localSavedState.f = getHelperText();
    localSavedState.g = getPlaceholderText();
    return localSavedState;
  }
  
  boolean q0()
  {
    if (this.e == null) {
      return false;
    }
    boolean bool1 = f0();
    boolean bool2 = true;
    boolean bool3 = true;
    int i1;
    Object localObject1;
    Object localObject2;
    Drawable localDrawable;
    if (bool1)
    {
      i1 = this.b.getMeasuredWidth() - this.e.getPaddingLeft();
      if ((this.a0 == null) || (this.b0 != i1))
      {
        localObject1 = new ColorDrawable();
        this.a0 = ((Drawable)localObject1);
        this.b0 = i1;
        ((Drawable)localObject1).setBounds(0, 0, i1, 1);
      }
      localObject1 = l.a(this.e);
      localObject2 = localObject1[0];
      localDrawable = this.a0;
      if (localObject2 == localDrawable) {
        break label182;
      }
      l.j(this.e, localDrawable, localObject1[1], localObject1[2], localObject1[3]);
    }
    else
    {
      if (this.a0 == null) {
        break label182;
      }
      localObject1 = l.a(this.e);
      l.j(this.e, null, localObject1[1], localObject1[2], localObject1[3]);
      this.a0 = null;
    }
    bool1 = true;
    break label184;
    label182:
    bool1 = false;
    label184:
    if (e0())
    {
      int i2 = this.B.getMeasuredWidth() - this.e.getPaddingRight();
      localObject1 = getEndIconToUpdateDummyDrawable();
      i1 = i2;
      if (localObject1 != null) {
        i1 = i2 + ((View)localObject1).getMeasuredWidth() + androidx.core.view.h.b((ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams());
      }
      localObject1 = l.a(this.e);
      localObject2 = this.j0;
      if ((localObject2 != null) && (this.k0 != i1))
      {
        this.k0 = i1;
        ((Drawable)localObject2).setBounds(0, 0, i1, 1);
        l.j(this.e, localObject1[0], localObject1[1], this.j0, localObject1[3]);
        bool1 = bool2;
      }
      else
      {
        if (localObject2 == null)
        {
          localObject2 = new ColorDrawable();
          this.j0 = ((Drawable)localObject2);
          this.k0 = i1;
          ((Drawable)localObject2).setBounds(0, 0, i1, 1);
        }
        localObject2 = localObject1[2];
        localDrawable = this.j0;
        if (localObject2 != localDrawable)
        {
          this.l0 = localObject1[2];
          l.j(this.e, localObject1[0], localObject1[1], localDrawable, localObject1[3]);
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool2 = bool1;
      if (this.j0 == null) {
        break label469;
      }
      localObject1 = l.a(this.e);
      if (localObject1[2] == this.j0)
      {
        l.j(this.e, localObject1[0], localObject1[1], this.l0, localObject1[3]);
        bool1 = bool3;
      }
      this.j0 = null;
    }
    bool2 = bool1;
    label469:
    return bool2;
  }
  
  void r0()
  {
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      if (this.M != 0) {
        return;
      }
      Object localObject2 = ((EditText)localObject1).getBackground();
      if (localObject2 == null) {
        return;
      }
      localObject1 = localObject2;
      if (androidx.appcompat.widget.t.a((Drawable)localObject2)) {
        localObject1 = ((Drawable)localObject2).mutate();
      }
      if (this.k.l()) {}
      for (int i1 = this.k.p();; i1 = ((TextView)localObject2).getCurrentTextColor())
      {
        ((Drawable)localObject1).setColorFilter(androidx.appcompat.widget.g.e(i1, PorterDuff.Mode.SRC_IN));
        return;
        if (!this.n) {
          break;
        }
        localObject2 = this.o;
        if (localObject2 == null) {
          break;
        }
      }
      r0.a.c((Drawable)localObject1);
      this.e.refreshDrawableState();
    }
  }
  
  public void setBoxBackgroundColor(int paramInt)
  {
    if (this.S != paramInt)
    {
      this.S = paramInt;
      this.x0 = paramInt;
      this.z0 = paramInt;
      this.A0 = paramInt;
      l();
    }
  }
  
  public void setBoxBackgroundColorResource(int paramInt)
  {
    setBoxBackgroundColor(androidx.core.content.b.b(getContext(), paramInt));
  }
  
  public void setBoxBackgroundColorStateList(ColorStateList paramColorStateList)
  {
    int i1 = paramColorStateList.getDefaultColor();
    this.x0 = i1;
    this.S = i1;
    this.y0 = paramColorStateList.getColorForState(new int[] { -16842910 }, -1);
    this.z0 = paramColorStateList.getColorForState(new int[] { 16842908, 16842910 }, -1);
    this.A0 = paramColorStateList.getColorForState(new int[] { 16843623, 16842910 }, -1);
    l();
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    if (paramInt == this.M) {
      return;
    }
    this.M = paramInt;
    if (this.e != null) {
      Q();
    }
  }
  
  public void setBoxCollapsedPaddingTop(int paramInt)
  {
    this.N = paramInt;
  }
  
  public void setBoxStrokeColor(int paramInt)
  {
    if (this.v0 != paramInt)
    {
      this.v0 = paramInt;
      E0();
    }
  }
  
  public void setBoxStrokeColorStateList(ColorStateList paramColorStateList)
  {
    if (paramColorStateList.isStateful())
    {
      this.t0 = paramColorStateList.getDefaultColor();
      this.B0 = paramColorStateList.getColorForState(new int[] { -16842910 }, -1);
      this.u0 = paramColorStateList.getColorForState(new int[] { 16843623, 16842910 }, -1);
    }
    for (int i1 = paramColorStateList.getColorForState(new int[] { 16842908, 16842910 }, -1);; i1 = paramColorStateList.getDefaultColor())
    {
      this.v0 = i1;
      break;
      if (this.v0 == paramColorStateList.getDefaultColor()) {
        break;
      }
    }
    E0();
  }
  
  public void setBoxStrokeErrorColor(ColorStateList paramColorStateList)
  {
    if (this.w0 != paramColorStateList)
    {
      this.w0 = paramColorStateList;
      E0();
    }
  }
  
  public void setBoxStrokeWidth(int paramInt)
  {
    this.P = paramInt;
    E0();
  }
  
  public void setBoxStrokeWidthFocused(int paramInt)
  {
    this.Q = paramInt;
    E0();
  }
  
  public void setBoxStrokeWidthFocusedResource(int paramInt)
  {
    setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setBoxStrokeWidthResource(int paramInt)
  {
    setBoxStrokeWidth(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (this.l != paramBoolean)
    {
      if (paramBoolean)
      {
        Object localObject = new AppCompatTextView(getContext());
        this.o = ((TextView)localObject);
        ((TextView)localObject).setId(R.id.textinput_counter);
        localObject = this.W;
        if (localObject != null) {
          this.o.setTypeface((Typeface)localObject);
        }
        this.o.setMaxLines(1);
        this.k.e(this.o, 2);
        androidx.core.view.h.d((ViewGroup.MarginLayoutParams)this.o.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
        o0();
        l0();
      }
      else
      {
        this.k.B(this.o, 2);
        this.o = null;
      }
      this.l = paramBoolean;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.m != paramInt)
    {
      if (paramInt <= 0) {
        paramInt = -1;
      }
      this.m = paramInt;
      if (this.l) {
        l0();
      }
    }
  }
  
  public void setCounterOverflowTextAppearance(int paramInt)
  {
    if (this.p != paramInt)
    {
      this.p = paramInt;
      o0();
    }
  }
  
  public void setCounterOverflowTextColor(ColorStateList paramColorStateList)
  {
    if (this.z != paramColorStateList)
    {
      this.z = paramColorStateList;
      o0();
    }
  }
  
  public void setCounterTextAppearance(int paramInt)
  {
    if (this.q != paramInt)
    {
      this.q = paramInt;
      o0();
    }
  }
  
  public void setCounterTextColor(ColorStateList paramColorStateList)
  {
    if (this.y != paramColorStateList)
    {
      this.y = paramColorStateList;
      o0();
    }
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList)
  {
    this.r0 = paramColorStateList;
    this.s0 = paramColorStateList;
    if (this.e != null) {
      w0(false);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    T(this, paramBoolean);
    super.setEnabled(paramBoolean);
  }
  
  public void setEndIconActivated(boolean paramBoolean)
  {
    this.f0.setActivated(paramBoolean);
  }
  
  public void setEndIconCheckable(boolean paramBoolean)
  {
    this.f0.setCheckable(paramBoolean);
  }
  
  public void setEndIconContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getResources().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setEndIconContentDescription(localCharSequence);
  }
  
  public void setEndIconContentDescription(CharSequence paramCharSequence)
  {
    if (getEndIconContentDescription() != paramCharSequence) {
      this.f0.setContentDescription(paramCharSequence);
    }
  }
  
  public void setEndIconDrawable(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = c.a.b(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setEndIconDrawable(localDrawable);
  }
  
  public void setEndIconDrawable(Drawable paramDrawable)
  {
    this.f0.setImageDrawable(paramDrawable);
    if (paramDrawable != null)
    {
      f.a(this, this.f0, this.h0, this.i0);
      U();
    }
  }
  
  public void setEndIconMode(int paramInt)
  {
    int i1 = this.d0;
    if (i1 == paramInt) {
      return;
    }
    this.d0 = paramInt;
    C(i1);
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    setEndIconVisible(bool);
    if (getEndIconDelegate().b(this.M))
    {
      getEndIconDelegate().a();
      f.a(this, this.f0, this.h0, this.i0);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The current box background mode ");
    localStringBuilder.append(this.M);
    localStringBuilder.append(" is not supported by the end icon mode ");
    localStringBuilder.append(paramInt);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void setEndIconOnClickListener(View.OnClickListener paramOnClickListener)
  {
    b0(this.f0, paramOnClickListener, this.m0);
  }
  
  public void setEndIconOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.m0 = paramOnLongClickListener;
    c0(this.f0, paramOnLongClickListener);
  }
  
  public void setEndIconTintList(ColorStateList paramColorStateList)
  {
    if (this.h0 != paramColorStateList)
    {
      this.h0 = paramColorStateList;
      f.a(this, this.f0, paramColorStateList, this.i0);
    }
  }
  
  public void setEndIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.i0 != paramMode)
    {
      this.i0 = paramMode;
      f.a(this, this.f0, this.h0, paramMode);
    }
  }
  
  public void setEndIconVisible(boolean paramBoolean)
  {
    if (K() != paramBoolean)
    {
      CheckableImageButton localCheckableImageButton = this.f0;
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localCheckableImageButton.setVisibility(i1);
      t0();
      C0();
      q0();
    }
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    if (!this.k.z())
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        return;
      }
      setErrorEnabled(true);
    }
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      this.k.O(paramCharSequence);
      return;
    }
    this.k.v();
  }
  
  public void setErrorContentDescription(CharSequence paramCharSequence)
  {
    this.k.D(paramCharSequence);
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    this.k.E(paramBoolean);
  }
  
  public void setErrorIconDrawable(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = c.a.b(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setErrorIconDrawable(localDrawable);
    V();
  }
  
  public void setErrorIconDrawable(Drawable paramDrawable)
  {
    this.o0.setImageDrawable(paramDrawable);
    u0();
    f.a(this, this.o0, this.p0, this.q0);
  }
  
  public void setErrorIconOnClickListener(View.OnClickListener paramOnClickListener)
  {
    b0(this.o0, paramOnClickListener, this.n0);
  }
  
  public void setErrorIconOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.n0 = paramOnLongClickListener;
    c0(this.o0, paramOnLongClickListener);
  }
  
  public void setErrorIconTintList(ColorStateList paramColorStateList)
  {
    if (this.p0 != paramColorStateList)
    {
      this.p0 = paramColorStateList;
      f.a(this, this.o0, paramColorStateList, this.q0);
    }
  }
  
  public void setErrorIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.q0 != paramMode)
    {
      this.q0 = paramMode;
      f.a(this, this.o0, this.p0, paramMode);
    }
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    this.k.F(paramInt);
  }
  
  public void setErrorTextColor(ColorStateList paramColorStateList)
  {
    this.k.G(paramColorStateList);
  }
  
  public void setExpandedHintEnabled(boolean paramBoolean)
  {
    if (this.E0 != paramBoolean)
    {
      this.E0 = paramBoolean;
      w0(false);
    }
  }
  
  public void setHelperText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (M()) {
        setHelperTextEnabled(false);
      }
    }
    else
    {
      if (!M()) {
        setHelperTextEnabled(true);
      }
      this.k.P(paramCharSequence);
    }
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList)
  {
    this.k.J(paramColorStateList);
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    this.k.I(paramBoolean);
  }
  
  public void setHelperTextTextAppearance(int paramInt)
  {
    this.k.H(paramInt);
  }
  
  public void setHint(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getResources().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setHint(localCharSequence);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    if (this.C)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.F0 = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.C)
    {
      this.C = paramBoolean;
      if (!paramBoolean)
      {
        this.F = false;
        if ((!TextUtils.isEmpty(this.E)) && (TextUtils.isEmpty(this.e.getHint()))) {
          this.e.setHint(this.E);
        }
        setHintInternal(null);
      }
      else
      {
        CharSequence localCharSequence = this.e.getHint();
        if (!TextUtils.isEmpty(localCharSequence))
        {
          if (TextUtils.isEmpty(this.E)) {
            setHint(localCharSequence);
          }
          this.e.setHint(null);
        }
        this.F = true;
      }
      if (this.e != null) {
        v0();
      }
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    this.D0.d0(paramInt);
    this.s0 = this.D0.p();
    if (this.e != null)
    {
      w0(false);
      v0();
    }
  }
  
  public void setHintTextColor(ColorStateList paramColorStateList)
  {
    if (this.s0 != paramColorStateList)
    {
      if (this.r0 == null) {
        this.D0.f0(paramColorStateList);
      }
      this.s0 = paramColorStateList;
      if (this.e != null) {
        w0(false);
      }
    }
  }
  
  public void setMaxEms(int paramInt)
  {
    this.h = paramInt;
    EditText localEditText = this.e;
    if ((localEditText != null) && (paramInt != -1)) {
      localEditText.setMaxEms(paramInt);
    }
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.j = paramInt;
    EditText localEditText = this.e;
    if ((localEditText != null) && (paramInt != -1)) {
      localEditText.setMaxWidth(paramInt);
    }
  }
  
  public void setMaxWidthResource(int paramInt)
  {
    setMaxWidth(getContext().getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setMinEms(int paramInt)
  {
    this.g = paramInt;
    EditText localEditText = this.e;
    if ((localEditText != null) && (paramInt != -1)) {
      localEditText.setMinEms(paramInt);
    }
  }
  
  public void setMinWidth(int paramInt)
  {
    this.i = paramInt;
    EditText localEditText = this.e;
    if ((localEditText != null) && (paramInt != -1)) {
      localEditText.setMinWidth(paramInt);
    }
  }
  
  public void setMinWidthResource(int paramInt)
  {
    setMinWidth(getContext().getResources().getDimensionPixelSize(paramInt));
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getResources().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setPasswordVisibilityToggleContentDescription(localCharSequence);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleContentDescription(CharSequence paramCharSequence)
  {
    this.f0.setContentDescription(paramCharSequence);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleDrawable(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = c.a.b(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setPasswordVisibilityToggleDrawable(localDrawable);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable)
  {
    this.f0.setImageDrawable(paramDrawable);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.d0 != 1))
    {
      setEndIconMode(1);
      return;
    }
    if (!paramBoolean) {
      setEndIconMode(0);
    }
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    this.h0 = paramColorStateList;
    f.a(this, this.f0, paramColorStateList, this.i0);
  }
  
  @Deprecated
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    this.i0 = paramMode;
    f.a(this, this.f0, this.h0, paramMode);
  }
  
  public void setPlaceholderText(CharSequence paramCharSequence)
  {
    if (this.t == null)
    {
      Object localObject = new AppCompatTextView(getContext());
      this.t = ((TextView)localObject);
      ((TextView)localObject).setId(R.id.textinput_placeholder);
      x.B0(this.t, 2);
      localObject = z();
      this.w = ((Fade)localObject);
      ((Transition)localObject).i0(67L);
      this.x = z();
      setPlaceholderTextAppearance(this.v);
      setPlaceholderTextColor(this.u);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      setPlaceholderTextEnabled(false);
    }
    else
    {
      if (!this.s) {
        setPlaceholderTextEnabled(true);
      }
      this.r = paramCharSequence;
    }
    z0();
  }
  
  public void setPlaceholderTextAppearance(int paramInt)
  {
    this.v = paramInt;
    TextView localTextView = this.t;
    if (localTextView != null) {
      l.o(localTextView, paramInt);
    }
  }
  
  public void setPlaceholderTextColor(ColorStateList paramColorStateList)
  {
    if (this.u != paramColorStateList)
    {
      this.u = paramColorStateList;
      TextView localTextView = this.t;
      if ((localTextView != null) && (paramColorStateList != null)) {
        localTextView.setTextColor(paramColorStateList);
      }
    }
  }
  
  public void setPrefixText(CharSequence paramCharSequence)
  {
    this.b.k(paramCharSequence);
  }
  
  public void setPrefixTextAppearance(int paramInt)
  {
    this.b.l(paramInt);
  }
  
  public void setPrefixTextColor(ColorStateList paramColorStateList)
  {
    this.b.m(paramColorStateList);
  }
  
  public void setStartIconCheckable(boolean paramBoolean)
  {
    this.b.n(paramBoolean);
  }
  
  public void setStartIconContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getResources().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setStartIconContentDescription(localCharSequence);
  }
  
  public void setStartIconContentDescription(CharSequence paramCharSequence)
  {
    this.b.o(paramCharSequence);
  }
  
  public void setStartIconDrawable(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = c.a.b(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setStartIconDrawable(localDrawable);
  }
  
  public void setStartIconDrawable(Drawable paramDrawable)
  {
    this.b.p(paramDrawable);
  }
  
  public void setStartIconOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b.q(paramOnClickListener);
  }
  
  public void setStartIconOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.b.r(paramOnLongClickListener);
  }
  
  public void setStartIconTintList(ColorStateList paramColorStateList)
  {
    this.b.s(paramColorStateList);
  }
  
  public void setStartIconTintMode(PorterDuff.Mode paramMode)
  {
    this.b.t(paramMode);
  }
  
  public void setStartIconVisible(boolean paramBoolean)
  {
    this.b.u(paramBoolean);
  }
  
  public void setSuffixText(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence;
    if (TextUtils.isEmpty(paramCharSequence)) {
      localCharSequence = null;
    } else {
      localCharSequence = paramCharSequence;
    }
    this.A = localCharSequence;
    this.B.setText(paramCharSequence);
    D0();
  }
  
  public void setSuffixTextAppearance(int paramInt)
  {
    l.o(this.B, paramInt);
  }
  
  public void setSuffixTextColor(ColorStateList paramColorStateList)
  {
    this.B.setTextColor(paramColorStateList);
  }
  
  public void setTextInputAccessibilityDelegate(e parame)
  {
    EditText localEditText = this.e;
    if (localEditText != null) {
      x.q0(localEditText, parame);
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (paramTypeface != this.W)
    {
      this.W = paramTypeface;
      this.D0.H0(paramTypeface);
      this.k.L(paramTypeface);
      TextView localTextView = this.o;
      if (localTextView != null) {
        localTextView.setTypeface(paramTypeface);
      }
    }
  }
  
  void w0(boolean paramBoolean)
  {
    x0(paramBoolean, false);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    CharSequence c;
    boolean d;
    CharSequence e;
    CharSequence f;
    CharSequence g;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.c = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.d = bool;
      this.e = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      this.f = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
      this.g = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TextInputLayout.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" error=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" hint=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" helperText=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(" placeholderText=");
      localStringBuilder.append(this.g);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    class a
      implements Parcelable.ClassLoaderCreator<TextInputLayout.SavedState>
    {
      public TextInputLayout.SavedState a(Parcel paramParcel)
      {
        return new TextInputLayout.SavedState(paramParcel, null);
      }
      
      public TextInputLayout.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new TextInputLayout.SavedState(paramParcel, paramClassLoader);
      }
      
      public TextInputLayout.SavedState[] c(int paramInt)
      {
        return new TextInputLayout.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      TextInputLayout localTextInputLayout = TextInputLayout.this;
      localTextInputLayout.w0(TextInputLayout.a(localTextInputLayout) ^ true);
      localTextInputLayout = TextInputLayout.this;
      if (localTextInputLayout.l) {
        localTextInputLayout.m0(paramEditable.length());
      }
      if (TextInputLayout.b(TextInputLayout.this)) {
        TextInputLayout.c(TextInputLayout.this, paramEditable.length());
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      TextInputLayout.d(TextInputLayout.this).performClick();
      TextInputLayout.d(TextInputLayout.this).jumpDrawablesToCurrentState();
    }
  }
  
  class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      TextInputLayout.this.e.requestLayout();
    }
  }
  
  class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      TextInputLayout.this.D0.u0(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    }
  }
  
  public static class e
    extends androidx.core.view.a
  {
    private final TextInputLayout d;
    
    public e(TextInputLayout paramTextInputLayout)
    {
      this.d = paramTextInputLayout;
    }
    
    public void g(View paramView, y0.d paramd)
    {
      super.g(paramView, paramd);
      paramView = this.d.getEditText();
      Editable localEditable;
      if (paramView != null) {
        localEditable = paramView.getText();
      } else {
        localEditable = null;
      }
      paramView = this.d.getHint();
      CharSequence localCharSequence1 = this.d.getError();
      Object localObject = this.d.getPlaceholderText();
      int j = this.d.getCounterMaxLength();
      CharSequence localCharSequence2 = this.d.getCounterOverflowDescription();
      boolean bool2 = TextUtils.isEmpty(localEditable) ^ true;
      boolean bool3 = TextUtils.isEmpty(paramView);
      boolean bool4 = this.d.N();
      boolean bool1 = TextUtils.isEmpty(localCharSequence1) ^ true;
      int i;
      if ((!bool1) && (TextUtils.isEmpty(localCharSequence2))) {
        i = 0;
      } else {
        i = 1;
      }
      if ((bool3 ^ true)) {
        paramView = paramView.toString();
      } else {
        paramView = "";
      }
      TextInputLayout.e(this.d).v(paramd);
      if (bool2)
      {
        paramd.F0(localEditable);
      }
      else
      {
        if (!TextUtils.isEmpty(paramView))
        {
          paramd.F0(paramView);
          if ((!(bool4 ^ true)) || (localObject == null)) {
            break label252;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramView);
          localStringBuilder.append(", ");
          localStringBuilder.append(localObject);
          localObject = localStringBuilder.toString();
        }
        else
        {
          if (localObject == null) {
            break label252;
          }
        }
        paramd.F0((CharSequence)localObject);
      }
      label252:
      if (!TextUtils.isEmpty(paramView))
      {
        if (Build.VERSION.SDK_INT >= 26)
        {
          paramd.n0(paramView);
        }
        else
        {
          localObject = paramView;
          if (bool2)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localEditable);
            ((StringBuilder)localObject).append(", ");
            ((StringBuilder)localObject).append(paramView);
            localObject = ((StringBuilder)localObject).toString();
          }
          paramd.F0((CharSequence)localObject);
        }
        paramd.B0(bool2 ^ true);
      }
      if ((localEditable == null) || (localEditable.length() != j)) {
        j = -1;
      }
      paramd.q0(j);
      if (i != 0)
      {
        if (bool1) {
          paramView = localCharSequence1;
        } else {
          paramView = localCharSequence2;
        }
        paramd.j0(paramView);
      }
      paramView = TextInputLayout.f(this.d).s();
      if (paramView != null) {
        paramd.o0(paramView);
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract void a(TextInputLayout paramTextInputLayout);
  }
  
  public static abstract interface g
  {
    public abstract void a(TextInputLayout paramTextInputLayout, int paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.TextInputLayout
 * JD-Core Version:    0.7.0.1
 */