package androidx.appcompat.widget;

import a1.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;
import androidx.core.widget.b;
import androidx.core.widget.l;
import java.lang.ref.WeakReference;
import java.util.Locale;
import p0.h.d;

class p
{
  private final TextView a;
  private i0 b;
  private i0 c;
  private i0 d;
  private i0 e;
  private i0 f;
  private i0 g;
  private i0 h;
  private final q i;
  private int j = 0;
  private int k = -1;
  private Typeface l;
  private boolean m;
  
  p(TextView paramTextView)
  {
    this.a = paramTextView;
    this.i = new q(paramTextView);
  }
  
  private void B(int paramInt, float paramFloat)
  {
    this.i.u(paramInt, paramFloat);
  }
  
  private void C(Context paramContext, k0 paramk0)
  {
    this.j = paramk0.k(R.styleable.TextAppearance_android_textStyle, this.j);
    int i2 = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i2 >= 28)
    {
      n = paramk0.k(R.styleable.TextAppearance_android_textFontWeight, -1);
      this.k = n;
      if (n != -1) {
        this.j = (this.j & 0x2 | 0x0);
      }
    }
    int n = R.styleable.TextAppearance_android_fontFamily;
    if ((!paramk0.s(n)) && (!paramk0.s(R.styleable.TextAppearance_fontFamily)))
    {
      n = R.styleable.TextAppearance_android_typeface;
      if (paramk0.s(n))
      {
        this.m = false;
        n = paramk0.k(n, 1);
        if (n != 1)
        {
          if (n != 2)
          {
            if (n != 3) {
              return;
            }
            paramContext = Typeface.MONOSPACE;
          }
          else
          {
            paramContext = Typeface.SERIF;
          }
        }
        else {
          paramContext = Typeface.SANS_SERIF;
        }
        this.l = paramContext;
      }
      return;
    }
    this.l = null;
    final int i1 = R.styleable.TextAppearance_fontFamily;
    if (paramk0.s(i1)) {
      n = i1;
    }
    i1 = this.k;
    final int i3 = this.j;
    if (!paramContext.isRestricted()) {
      paramContext = new a(i1, i3, new WeakReference(this.a));
    }
    try
    {
      Typeface localTypeface = paramk0.j(n, this.j, paramContext);
      if (localTypeface == null) {
        break label295;
      }
      paramContext = localTypeface;
      if (i2 < 28) {
        break label290;
      }
      paramContext = localTypeface;
      if (this.k == -1) {
        break label290;
      }
      paramContext = Typeface.create(localTypeface, 0);
      i1 = this.k;
      if ((this.j & 0x2) == 0) {
        break label404;
      }
      bool1 = true;
    }
    catch (UnsupportedOperationException|Resources.NotFoundException paramContext)
    {
      for (;;)
      {
        continue;
        boolean bool1 = false;
        continue;
        bool1 = false;
      }
    }
    paramContext = Typeface.create(paramContext, i1, bool1);
    label290:
    this.l = paramContext;
    label295:
    if (this.l == null)
    {
      bool1 = true;
      this.m = bool1;
      if (this.l == null)
      {
        paramContext = paramk0.o(n);
        if (paramContext != null)
        {
          if ((Build.VERSION.SDK_INT >= 28) && (this.k != -1))
          {
            paramContext = Typeface.create(paramContext, 0);
            n = this.k;
            bool1 = bool2;
            if ((this.j & 0x2) != 0) {
              bool1 = true;
            }
            paramContext = Typeface.create(paramContext, n, bool1);
          }
          else
          {
            paramContext = Typeface.create(paramContext, this.j);
          }
          this.l = paramContext;
        }
      }
      return;
    }
  }
  
  private void a(Drawable paramDrawable, i0 parami0)
  {
    if ((paramDrawable != null) && (parami0 != null)) {
      g.i(paramDrawable, parami0, this.a.getDrawableState());
    }
  }
  
  private static i0 d(Context paramContext, g paramg, int paramInt)
  {
    paramContext = paramg.f(paramContext, paramInt);
    if (paramContext != null)
    {
      paramg = new i0();
      paramg.d = true;
      paramg.a = paramContext;
      return paramg;
    }
    return null;
  }
  
  private void y(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4, Drawable paramDrawable5, Drawable paramDrawable6)
  {
    if ((paramDrawable5 == null) && (paramDrawable6 == null))
    {
      if ((paramDrawable1 != null) || (paramDrawable2 != null) || (paramDrawable3 != null) || (paramDrawable4 != null))
      {
        paramDrawable5 = this.a.getCompoundDrawablesRelative();
        if ((paramDrawable5[0] == null) && (paramDrawable5[2] == null))
        {
          paramDrawable6 = this.a.getCompoundDrawables();
          paramDrawable5 = this.a;
          if (paramDrawable1 == null) {
            paramDrawable1 = paramDrawable6[0];
          }
          if (paramDrawable2 == null) {
            paramDrawable2 = paramDrawable6[1];
          }
          if (paramDrawable3 == null) {
            paramDrawable3 = paramDrawable6[2];
          }
          if (paramDrawable4 == null) {
            paramDrawable4 = paramDrawable6[3];
          }
          paramDrawable5.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
          return;
        }
        paramDrawable1 = this.a;
        paramDrawable3 = paramDrawable5[0];
        if (paramDrawable2 == null) {
          paramDrawable2 = paramDrawable5[1];
        }
        paramDrawable6 = paramDrawable5[2];
        if (paramDrawable4 == null) {
          paramDrawable4 = paramDrawable5[3];
        }
        paramDrawable1.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable3, paramDrawable2, paramDrawable6, paramDrawable4);
      }
    }
    else
    {
      paramDrawable3 = this.a.getCompoundDrawablesRelative();
      paramDrawable1 = this.a;
      if (paramDrawable5 == null) {
        paramDrawable5 = paramDrawable3[0];
      }
      if (paramDrawable2 == null) {
        paramDrawable2 = paramDrawable3[1];
      }
      if (paramDrawable6 == null) {
        paramDrawable6 = paramDrawable3[2];
      }
      if (paramDrawable4 == null) {
        paramDrawable4 = paramDrawable3[3];
      }
      paramDrawable1.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable5, paramDrawable2, paramDrawable6, paramDrawable4);
    }
  }
  
  private void z()
  {
    i0 locali0 = this.h;
    this.b = locali0;
    this.c = locali0;
    this.d = locali0;
    this.e = locali0;
    this.f = locali0;
    this.g = locali0;
  }
  
  void A(int paramInt, float paramFloat)
  {
    if ((!b.D) && (!l())) {
      B(paramInt, paramFloat);
    }
  }
  
  void b()
  {
    Drawable[] arrayOfDrawable;
    if ((this.b != null) || (this.c != null) || (this.d != null) || (this.e != null))
    {
      arrayOfDrawable = this.a.getCompoundDrawables();
      a(arrayOfDrawable[0], this.b);
      a(arrayOfDrawable[1], this.c);
      a(arrayOfDrawable[2], this.d);
      a(arrayOfDrawable[3], this.e);
    }
    if ((this.f != null) || (this.g != null))
    {
      arrayOfDrawable = this.a.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.f);
      a(arrayOfDrawable[2], this.g);
    }
  }
  
  void c()
  {
    this.i.a();
  }
  
  int e()
  {
    return this.i.g();
  }
  
  int f()
  {
    return this.i.h();
  }
  
  int g()
  {
    return this.i.i();
  }
  
  int[] h()
  {
    return this.i.j();
  }
  
  int i()
  {
    return this.i.k();
  }
  
  ColorStateList j()
  {
    i0 locali0 = this.h;
    if (locali0 != null) {
      return locali0.a;
    }
    return null;
  }
  
  PorterDuff.Mode k()
  {
    i0 locali0 = this.h;
    if (locali0 != null) {
      return locali0.b;
    }
    return null;
  }
  
  boolean l()
  {
    return this.i.o();
  }
  
  @SuppressLint({"NewApi"})
  void m(AttributeSet paramAttributeSet, int paramInt)
  {
    Object localObject5 = this.a.getContext();
    g localg = g.b();
    Object localObject1 = R.styleable.AppCompatTextHelper;
    Object localObject2 = k0.v((Context)localObject5, paramAttributeSet, (int[])localObject1, paramInt, 0);
    Object localObject3 = this.a;
    x.o0((View)localObject3, ((TextView)localObject3).getContext(), (int[])localObject1, paramAttributeSet, ((k0)localObject2).r(), paramInt, 0);
    int i1 = ((k0)localObject2).n(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
    int n = R.styleable.AppCompatTextHelper_android_drawableLeft;
    if (((k0)localObject2).s(n)) {
      this.b = d((Context)localObject5, localg, ((k0)localObject2).n(n, 0));
    }
    n = R.styleable.AppCompatTextHelper_android_drawableTop;
    if (((k0)localObject2).s(n)) {
      this.c = d((Context)localObject5, localg, ((k0)localObject2).n(n, 0));
    }
    n = R.styleable.AppCompatTextHelper_android_drawableRight;
    if (((k0)localObject2).s(n)) {
      this.d = d((Context)localObject5, localg, ((k0)localObject2).n(n, 0));
    }
    n = R.styleable.AppCompatTextHelper_android_drawableBottom;
    if (((k0)localObject2).s(n)) {
      this.e = d((Context)localObject5, localg, ((k0)localObject2).n(n, 0));
    }
    n = Build.VERSION.SDK_INT;
    int i2 = R.styleable.AppCompatTextHelper_android_drawableStart;
    if (((k0)localObject2).s(i2)) {
      this.f = d((Context)localObject5, localg, ((k0)localObject2).n(i2, 0));
    }
    i2 = R.styleable.AppCompatTextHelper_android_drawableEnd;
    if (((k0)localObject2).s(i2)) {
      this.g = d((Context)localObject5, localg, ((k0)localObject2).n(i2, 0));
    }
    ((k0)localObject2).w();
    boolean bool2 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
    boolean bool1;
    int i3;
    if (i1 != -1)
    {
      localObject3 = k0.t((Context)localObject5, i1, R.styleable.TextAppearance);
      if (!bool2)
      {
        i1 = R.styleable.TextAppearance_textAllCaps;
        if (((k0)localObject3).s(i1))
        {
          bool1 = ((k0)localObject3).a(i1, false);
          i3 = 1;
          break label342;
        }
      }
      bool1 = false;
      i3 = bool1;
      label342:
      C((Context)localObject5, (k0)localObject3);
      i1 = R.styleable.TextAppearance_textLocale;
      if (((k0)localObject3).s(i1)) {
        localObject2 = ((k0)localObject3).o(i1);
      } else {
        localObject2 = null;
      }
      if (n >= 26)
      {
        i1 = R.styleable.TextAppearance_fontVariationSettings;
        if (((k0)localObject3).s(i1))
        {
          localObject1 = ((k0)localObject3).o(i1);
          break label416;
        }
      }
      localObject1 = null;
      label416:
      ((k0)localObject3).w();
    }
    else
    {
      bool1 = false;
      i3 = bool1;
      localObject1 = null;
      localObject2 = null;
    }
    Object localObject4 = k0.v((Context)localObject5, paramAttributeSet, R.styleable.TextAppearance, paramInt, 0);
    if (!bool2)
    {
      i1 = R.styleable.TextAppearance_textAllCaps;
      if (((k0)localObject4).s(i1))
      {
        bool1 = ((k0)localObject4).a(i1, false);
        i3 = 1;
      }
    }
    i1 = R.styleable.TextAppearance_textLocale;
    if (((k0)localObject4).s(i1)) {
      localObject2 = ((k0)localObject4).o(i1);
    }
    localObject3 = localObject1;
    if (n >= 26)
    {
      i1 = R.styleable.TextAppearance_fontVariationSettings;
      localObject3 = localObject1;
      if (((k0)localObject4).s(i1)) {
        localObject3 = ((k0)localObject4).o(i1);
      }
    }
    if (n >= 28)
    {
      i1 = R.styleable.TextAppearance_android_textSize;
      if ((((k0)localObject4).s(i1)) && (((k0)localObject4).f(i1, -1) == 0)) {
        this.a.setTextSize(0, 0.0F);
      }
    }
    C((Context)localObject5, (k0)localObject4);
    ((k0)localObject4).w();
    if ((!bool2) && (i3 != 0)) {
      s(bool1);
    }
    localObject1 = this.l;
    if (localObject1 != null) {
      if (this.k == -1) {
        this.a.setTypeface((Typeface)localObject1, this.j);
      } else {
        this.a.setTypeface((Typeface)localObject1);
      }
    }
    if (localObject3 != null) {
      this.a.setFontVariationSettings((String)localObject3);
    }
    if (localObject2 != null) {
      if (n >= 24)
      {
        this.a.setTextLocales(LocaleList.forLanguageTags((String)localObject2));
      }
      else
      {
        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).indexOf(','));
        this.a.setTextLocale(Locale.forLanguageTag((String)localObject1));
      }
    }
    this.i.p(paramAttributeSet, paramInt);
    if ((b.D) && (this.i.k() != 0))
    {
      localObject1 = this.i.j();
      if (localObject1.length > 0) {
        if (this.a.getAutoSizeStepGranularity() != -1.0F) {
          this.a.setAutoSizeTextTypeUniformWithConfiguration(this.i.h(), this.i.g(), this.i.i(), 0);
        } else {
          this.a.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
        }
      }
    }
    k0 localk0 = k0.u((Context)localObject5, paramAttributeSet, R.styleable.AppCompatTextView);
    paramInt = localk0.n(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
    if (paramInt != -1) {
      paramAttributeSet = localg.c((Context)localObject5, paramInt);
    } else {
      paramAttributeSet = null;
    }
    paramInt = localk0.n(R.styleable.AppCompatTextView_drawableTopCompat, -1);
    if (paramInt != -1) {
      localObject1 = localg.c((Context)localObject5, paramInt);
    } else {
      localObject1 = null;
    }
    paramInt = localk0.n(R.styleable.AppCompatTextView_drawableRightCompat, -1);
    if (paramInt != -1) {
      localObject2 = localg.c((Context)localObject5, paramInt);
    } else {
      localObject2 = null;
    }
    paramInt = localk0.n(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
    if (paramInt != -1) {
      localObject3 = localg.c((Context)localObject5, paramInt);
    } else {
      localObject3 = null;
    }
    paramInt = localk0.n(R.styleable.AppCompatTextView_drawableStartCompat, -1);
    if (paramInt != -1) {
      localObject4 = localg.c((Context)localObject5, paramInt);
    } else {
      localObject4 = null;
    }
    paramInt = localk0.n(R.styleable.AppCompatTextView_drawableEndCompat, -1);
    if (paramInt != -1) {
      localObject5 = localg.c((Context)localObject5, paramInt);
    } else {
      localObject5 = null;
    }
    y(paramAttributeSet, (Drawable)localObject1, (Drawable)localObject2, (Drawable)localObject3, (Drawable)localObject4, (Drawable)localObject5);
    paramInt = R.styleable.AppCompatTextView_drawableTint;
    if (localk0.s(paramInt))
    {
      paramAttributeSet = localk0.c(paramInt);
      l.h(this.a, paramAttributeSet);
    }
    paramInt = R.styleable.AppCompatTextView_drawableTintMode;
    if (localk0.s(paramInt))
    {
      paramAttributeSet = t.e(localk0.k(paramInt, -1), null);
      l.i(this.a, paramAttributeSet);
    }
    paramInt = localk0.f(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
    n = localk0.f(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
    i1 = localk0.f(R.styleable.AppCompatTextView_lineHeight, -1);
    localk0.w();
    if (paramInt != -1) {
      l.k(this.a, paramInt);
    }
    if (n != -1) {
      l.l(this.a, n);
    }
    if (i1 != -1) {
      l.m(this.a, i1);
    }
  }
  
  void n(final WeakReference<TextView> paramWeakReference, final Typeface paramTypeface)
  {
    if (this.m)
    {
      this.l = paramTypeface;
      paramWeakReference = (TextView)paramWeakReference.get();
      if (paramWeakReference != null)
      {
        if (x.T(paramWeakReference))
        {
          paramWeakReference.post(new b(paramWeakReference, paramTypeface, this.j));
          return;
        }
        paramWeakReference.setTypeface(paramTypeface, this.j);
      }
    }
  }
  
  void o(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!b.D) {
      c();
    }
  }
  
  void p()
  {
    b();
  }
  
  void q(Context paramContext, int paramInt)
  {
    k0 localk0 = k0.t(paramContext, paramInt, R.styleable.TextAppearance);
    paramInt = R.styleable.TextAppearance_textAllCaps;
    if (localk0.s(paramInt)) {
      s(localk0.a(paramInt, false));
    }
    paramInt = Build.VERSION.SDK_INT;
    int n = R.styleable.TextAppearance_android_textSize;
    if ((localk0.s(n)) && (localk0.f(n, -1) == 0)) {
      this.a.setTextSize(0, 0.0F);
    }
    C(paramContext, localk0);
    if (paramInt >= 26)
    {
      paramInt = R.styleable.TextAppearance_fontVariationSettings;
      if (localk0.s(paramInt))
      {
        paramContext = localk0.o(paramInt);
        if (paramContext != null) {
          this.a.setFontVariationSettings(paramContext);
        }
      }
    }
    localk0.w();
    paramContext = this.l;
    if (paramContext != null) {
      this.a.setTypeface(paramContext, this.j);
    }
  }
  
  void r(TextView paramTextView, InputConnection paramInputConnection, EditorInfo paramEditorInfo)
  {
    if ((Build.VERSION.SDK_INT < 30) && (paramInputConnection != null)) {
      a.f(paramEditorInfo, paramTextView.getText());
    }
  }
  
  void s(boolean paramBoolean)
  {
    this.a.setAllCaps(paramBoolean);
  }
  
  void t(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.i.q(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void u(int[] paramArrayOfInt, int paramInt)
  {
    this.i.r(paramArrayOfInt, paramInt);
  }
  
  void v(int paramInt)
  {
    this.i.s(paramInt);
  }
  
  void w(ColorStateList paramColorStateList)
  {
    if (this.h == null) {
      this.h = new i0();
    }
    i0 locali0 = this.h;
    locali0.a = paramColorStateList;
    boolean bool;
    if (paramColorStateList != null) {
      bool = true;
    } else {
      bool = false;
    }
    locali0.d = bool;
    z();
  }
  
  void x(PorterDuff.Mode paramMode)
  {
    if (this.h == null) {
      this.h = new i0();
    }
    i0 locali0 = this.h;
    locali0.b = paramMode;
    boolean bool;
    if (paramMode != null) {
      bool = true;
    } else {
      bool = false;
    }
    locali0.c = bool;
    z();
  }
  
  class a
    extends h.d
  {
    a(int paramInt1, int paramInt2, WeakReference paramWeakReference) {}
    
    public void d(int paramInt) {}
    
    public void e(Typeface paramTypeface)
    {
      Typeface localTypeface = paramTypeface;
      if (Build.VERSION.SDK_INT >= 28)
      {
        int i = i1;
        localTypeface = paramTypeface;
        if (i != -1)
        {
          boolean bool;
          if ((i3 & 0x2) != 0) {
            bool = true;
          } else {
            bool = false;
          }
          localTypeface = Typeface.create(paramTypeface, i, bool);
        }
      }
      p.this.n(this.c, localTypeface);
    }
  }
  
  class b
    implements Runnable
  {
    b(TextView paramTextView, Typeface paramTypeface, int paramInt) {}
    
    public void run()
    {
      paramWeakReference.setTypeface(paramTypeface, this.c);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.p
 * JD-Core Version:    0.7.0.1
 */