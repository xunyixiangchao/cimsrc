package o7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import com.google.android.material.R.styleable;
import p0.h;
import p0.h.d;

public class d
{
  public final ColorStateList a;
  public final ColorStateList b;
  public final ColorStateList c;
  public final String d;
  public final int e;
  public final int f;
  public final boolean g;
  public final float h;
  public final float i;
  public final float j;
  public final boolean k;
  public final float l;
  private ColorStateList m;
  private float n;
  private final int o;
  private boolean p = false;
  private Typeface q;
  
  public d(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.TextAppearance);
    l(localTypedArray.getDimension(R.styleable.TextAppearance_android_textSize, 0.0F));
    k(c.a(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColor));
    this.a = c.a(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColorHint);
    this.b = c.a(paramContext, localTypedArray, R.styleable.TextAppearance_android_textColorLink);
    this.e = localTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, 0);
    this.f = localTypedArray.getInt(R.styleable.TextAppearance_android_typeface, 1);
    int i1 = c.f(localTypedArray, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
    this.o = localTypedArray.getResourceId(i1, 0);
    this.d = localTypedArray.getString(i1);
    this.g = localTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
    this.c = c.a(paramContext, localTypedArray, R.styleable.TextAppearance_android_shadowColor);
    this.h = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0F);
    this.i = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0F);
    this.j = localTypedArray.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0F);
    localTypedArray.recycle();
    paramContext = paramContext.obtainStyledAttributes(paramInt, R.styleable.MaterialTextAppearance);
    paramInt = R.styleable.MaterialTextAppearance_android_letterSpacing;
    this.k = paramContext.hasValue(paramInt);
    this.l = paramContext.getFloat(paramInt, 0.0F);
    paramContext.recycle();
  }
  
  private void d()
  {
    Object localObject;
    if (this.q == null)
    {
      localObject = this.d;
      if (localObject != null) {
        this.q = Typeface.create((String)localObject, this.e);
      }
    }
    if (this.q == null)
    {
      int i1 = this.f;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            localObject = Typeface.DEFAULT;
          } else {
            localObject = Typeface.MONOSPACE;
          }
        }
        else {
          localObject = Typeface.SERIF;
        }
      }
      else {
        localObject = Typeface.SANS_SERIF;
      }
      this.q = ((Typeface)localObject);
      this.q = Typeface.create(this.q, this.e);
    }
  }
  
  private boolean m(Context paramContext)
  {
    if (e.a()) {
      return true;
    }
    int i1 = this.o;
    if (i1 != 0) {
      paramContext = h.c(paramContext, i1);
    } else {
      paramContext = null;
    }
    return paramContext != null;
  }
  
  public Typeface e()
  {
    d();
    return this.q;
  }
  
  public Typeface f(Context paramContext)
  {
    if (this.p) {
      return this.q;
    }
    if (!paramContext.isRestricted()) {}
    try
    {
      try
      {
        paramContext = h.g(paramContext, this.o);
        this.q = paramContext;
        if (paramContext != null) {
          this.q = Typeface.create(paramContext, this.e);
        }
      }
      catch (Exception paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Error loading font ");
        localStringBuilder.append(this.d);
        Log.d("TextAppearance", localStringBuilder.toString(), paramContext);
      }
    }
    catch (UnsupportedOperationException|Resources.NotFoundException paramContext)
    {
      label88:
      break label88;
    }
    d();
    this.p = true;
    return this.q;
  }
  
  public void g(final Context paramContext, final TextPaint paramTextPaint, final f paramf)
  {
    p(paramContext, paramTextPaint, e());
    h(paramContext, new b(paramContext, paramTextPaint, paramf));
  }
  
  public void h(Context paramContext, final f paramf)
  {
    if (m(paramContext)) {
      f(paramContext);
    } else {
      d();
    }
    int i1 = this.o;
    if (i1 == 0) {
      this.p = true;
    }
    if (this.p)
    {
      paramf.b(this.q, true);
      return;
    }
    try
    {
      h.i(paramContext, i1, new a(paramf), null);
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error loading font ");
      localStringBuilder.append(this.d);
      Log.d("TextAppearance", localStringBuilder.toString(), paramContext);
      this.p = true;
      paramf.a(-3);
      return;
      this.p = true;
      paramf.a(1);
      return;
    }
    catch (Resources.NotFoundException paramContext)
    {
      label120:
      break label120;
    }
  }
  
  public ColorStateList i()
  {
    return this.m;
  }
  
  public float j()
  {
    return this.n;
  }
  
  public void k(ColorStateList paramColorStateList)
  {
    this.m = paramColorStateList;
  }
  
  public void l(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public void n(Context paramContext, TextPaint paramTextPaint, f paramf)
  {
    o(paramContext, paramTextPaint, paramf);
    paramContext = this.m;
    int i1;
    if (paramContext != null) {
      i1 = paramContext.getColorForState(paramTextPaint.drawableState, paramContext.getDefaultColor());
    } else {
      i1 = -16777216;
    }
    paramTextPaint.setColor(i1);
    float f1 = this.j;
    float f2 = this.h;
    float f3 = this.i;
    paramContext = this.c;
    if (paramContext != null) {
      i1 = paramContext.getColorForState(paramTextPaint.drawableState, paramContext.getDefaultColor());
    } else {
      i1 = 0;
    }
    paramTextPaint.setShadowLayer(f1, f2, f3, i1);
  }
  
  public void o(Context paramContext, TextPaint paramTextPaint, f paramf)
  {
    if (m(paramContext))
    {
      p(paramContext, paramTextPaint, f(paramContext));
      return;
    }
    g(paramContext, paramTextPaint, paramf);
  }
  
  public void p(Context paramContext, TextPaint paramTextPaint, Typeface paramTypeface)
  {
    paramContext = g.a(paramContext, paramTypeface);
    if (paramContext != null) {
      paramTypeface = paramContext;
    }
    paramTextPaint.setTypeface(paramTypeface);
    int i1 = this.e & paramTypeface.getStyle();
    boolean bool;
    if ((i1 & 0x1) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramTextPaint.setFakeBoldText(bool);
    float f1;
    if ((i1 & 0x2) != 0) {
      f1 = -0.25F;
    } else {
      f1 = 0.0F;
    }
    paramTextPaint.setTextSkewX(f1);
    paramTextPaint.setTextSize(this.n);
    if (this.k) {
      paramTextPaint.setLetterSpacing(this.l);
    }
  }
  
  class a
    extends h.d
  {
    a(f paramf) {}
    
    public void d(int paramInt)
    {
      d.c(d.this, true);
      paramf.a(paramInt);
    }
    
    public void e(Typeface paramTypeface)
    {
      d locald = d.this;
      d.b(locald, Typeface.create(paramTypeface, locald.e));
      d.c(d.this, true);
      paramf.b(d.a(d.this), false);
    }
  }
  
  class b
    extends f
  {
    b(Context paramContext, TextPaint paramTextPaint, f paramf) {}
    
    public void a(int paramInt)
    {
      paramf.a(paramInt);
    }
    
    public void b(Typeface paramTypeface, boolean paramBoolean)
    {
      d.this.p(paramContext, paramTextPaint, paramTypeface);
      paramf.b(paramTypeface, paramBoolean);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o7.d
 * JD-Core Version:    0.7.0.1
 */