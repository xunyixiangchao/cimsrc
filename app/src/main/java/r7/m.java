package r7;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R.styleable;

public class m
{
  public static final c m = new k(0.5F);
  d a;
  d b;
  d c;
  d d;
  c e;
  c f;
  c g;
  c h;
  f i;
  f j;
  f k;
  f l;
  
  public m()
  {
    this.a = i.b();
    this.b = i.b();
    this.c = i.b();
    this.d = i.b();
    this.e = new a(0.0F);
    this.f = new a(0.0F);
    this.g = new a(0.0F);
    this.h = new a(0.0F);
    this.i = i.c();
    this.j = i.c();
    this.k = i.c();
    this.l = i.c();
  }
  
  private m(b paramb)
  {
    this.a = b.a(paramb);
    this.b = b.e(paramb);
    this.c = b.f(paramb);
    this.d = b.g(paramb);
    this.e = b.h(paramb);
    this.f = b.i(paramb);
    this.g = b.j(paramb);
    this.h = b.k(paramb);
    this.i = b.l(paramb);
    this.j = b.b(paramb);
    this.k = b.c(paramb);
    this.l = b.d(paramb);
  }
  
  public static b a()
  {
    return new b();
  }
  
  public static b b(Context paramContext, int paramInt1, int paramInt2)
  {
    return c(paramContext, paramInt1, paramInt2, 0);
  }
  
  private static b c(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    return d(paramContext, paramInt1, paramInt2, new a(paramInt3));
  }
  
  private static b d(Context paramContext, int paramInt1, int paramInt2, c paramc)
  {
    Object localObject = paramContext;
    int n = paramInt1;
    if (paramInt2 != 0)
    {
      localObject = new ContextThemeWrapper(paramContext, paramInt1);
      n = paramInt2;
    }
    paramContext = ((Context)localObject).obtainStyledAttributes(n, R.styleable.ShapeAppearance);
    try
    {
      int i1 = paramContext.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
      paramInt1 = paramContext.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i1);
      paramInt2 = paramContext.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i1);
      n = paramContext.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i1);
      i1 = paramContext.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i1);
      c localc2 = m(paramContext, R.styleable.ShapeAppearance_cornerSize, paramc);
      paramc = m(paramContext, R.styleable.ShapeAppearance_cornerSizeTopLeft, localc2);
      localObject = m(paramContext, R.styleable.ShapeAppearance_cornerSizeTopRight, localc2);
      c localc1 = m(paramContext, R.styleable.ShapeAppearance_cornerSizeBottomRight, localc2);
      localc2 = m(paramContext, R.styleable.ShapeAppearance_cornerSizeBottomLeft, localc2);
      paramc = new b().C(paramInt1, paramc).G(paramInt2, (c)localObject).x(n, localc1).t(i1, localc2);
      return paramc;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public static b e(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    return f(paramContext, paramAttributeSet, paramInt1, paramInt2, 0);
  }
  
  public static b f(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3)
  {
    return g(paramContext, paramAttributeSet, paramInt1, paramInt2, new a(paramInt3));
  }
  
  public static b g(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, c paramc)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MaterialShape, paramInt1, paramInt2);
    paramInt1 = paramAttributeSet.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
    paramInt2 = paramAttributeSet.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
    paramAttributeSet.recycle();
    return d(paramContext, paramInt1, paramInt2, paramc);
  }
  
  private static c m(TypedArray paramTypedArray, int paramInt, c paramc)
  {
    TypedValue localTypedValue = paramTypedArray.peekValue(paramInt);
    if (localTypedValue == null) {
      return paramc;
    }
    paramInt = localTypedValue.type;
    if (paramInt == 5) {
      return new a(TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramTypedArray.getResources().getDisplayMetrics()));
    }
    if (paramInt == 6) {
      return new k(localTypedValue.getFraction(1.0F, 1.0F));
    }
    return paramc;
  }
  
  public f h()
  {
    return this.k;
  }
  
  public d i()
  {
    return this.d;
  }
  
  public c j()
  {
    return this.h;
  }
  
  public d k()
  {
    return this.c;
  }
  
  public c l()
  {
    return this.g;
  }
  
  public f n()
  {
    return this.l;
  }
  
  public f o()
  {
    return this.j;
  }
  
  public f p()
  {
    return this.i;
  }
  
  public d q()
  {
    return this.a;
  }
  
  public c r()
  {
    return this.e;
  }
  
  public d s()
  {
    return this.b;
  }
  
  public c t()
  {
    return this.f;
  }
  
  public boolean u(RectF paramRectF)
  {
    int n;
    if ((this.l.getClass().equals(f.class)) && (this.j.getClass().equals(f.class)) && (this.i.getClass().equals(f.class)) && (this.k.getClass().equals(f.class))) {
      n = 1;
    } else {
      n = 0;
    }
    float f1 = this.e.a(paramRectF);
    int i1;
    if ((this.f.a(paramRectF) == f1) && (this.h.a(paramRectF) == f1) && (this.g.a(paramRectF) == f1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (((this.b instanceof l)) && ((this.a instanceof l)) && ((this.c instanceof l)) && ((this.d instanceof l))) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    return (n != 0) && (i1 != 0) && (i2 != 0);
  }
  
  public b v()
  {
    return new b(this);
  }
  
  public m w(float paramFloat)
  {
    return v().o(paramFloat).m();
  }
  
  public m x(c paramc)
  {
    return v().p(paramc).m();
  }
  
  public m y(c paramc)
  {
    return v().F(paramc.a(r())).J(paramc.a(t())).w(paramc.a(j())).A(paramc.a(l())).m();
  }
  
  public static final class b
  {
    private d a = i.b();
    private d b = i.b();
    private d c = i.b();
    private d d = i.b();
    private c e = new a(0.0F);
    private c f = new a(0.0F);
    private c g = new a(0.0F);
    private c h = new a(0.0F);
    private f i = i.c();
    private f j = i.c();
    private f k = i.c();
    private f l = i.c();
    
    public b() {}
    
    public b(m paramm)
    {
      this.a = paramm.a;
      this.b = paramm.b;
      this.c = paramm.c;
      this.d = paramm.d;
      this.e = paramm.e;
      this.f = paramm.f;
      this.g = paramm.g;
      this.h = paramm.h;
      this.i = paramm.i;
      this.j = paramm.j;
      this.k = paramm.k;
      this.l = paramm.l;
    }
    
    private static float n(d paramd)
    {
      if ((paramd instanceof l)) {
        return ((l)paramd).a;
      }
      if ((paramd instanceof e)) {
        return ((e)paramd).a;
      }
      return -1.0F;
    }
    
    public b A(c paramc)
    {
      this.g = paramc;
      return this;
    }
    
    public b B(f paramf)
    {
      this.i = paramf;
      return this;
    }
    
    public b C(int paramInt, c paramc)
    {
      return D(i.a(paramInt)).F(paramc);
    }
    
    public b D(d paramd)
    {
      this.a = paramd;
      float f1 = n(paramd);
      if (f1 != -1.0F) {
        E(f1);
      }
      return this;
    }
    
    public b E(float paramFloat)
    {
      this.e = new a(paramFloat);
      return this;
    }
    
    public b F(c paramc)
    {
      this.e = paramc;
      return this;
    }
    
    public b G(int paramInt, c paramc)
    {
      return H(i.a(paramInt)).J(paramc);
    }
    
    public b H(d paramd)
    {
      this.b = paramd;
      float f1 = n(paramd);
      if (f1 != -1.0F) {
        I(f1);
      }
      return this;
    }
    
    public b I(float paramFloat)
    {
      this.f = new a(paramFloat);
      return this;
    }
    
    public b J(c paramc)
    {
      this.f = paramc;
      return this;
    }
    
    public m m()
    {
      return new m(this, null);
    }
    
    public b o(float paramFloat)
    {
      return E(paramFloat).I(paramFloat).z(paramFloat).v(paramFloat);
    }
    
    public b p(c paramc)
    {
      return F(paramc).J(paramc).A(paramc).w(paramc);
    }
    
    public b q(int paramInt, float paramFloat)
    {
      return r(i.a(paramInt)).o(paramFloat);
    }
    
    public b r(d paramd)
    {
      return D(paramd).H(paramd).y(paramd).u(paramd);
    }
    
    public b s(f paramf)
    {
      this.k = paramf;
      return this;
    }
    
    public b t(int paramInt, c paramc)
    {
      return u(i.a(paramInt)).w(paramc);
    }
    
    public b u(d paramd)
    {
      this.d = paramd;
      float f1 = n(paramd);
      if (f1 != -1.0F) {
        v(f1);
      }
      return this;
    }
    
    public b v(float paramFloat)
    {
      this.h = new a(paramFloat);
      return this;
    }
    
    public b w(c paramc)
    {
      this.h = paramc;
      return this;
    }
    
    public b x(int paramInt, c paramc)
    {
      return y(i.a(paramInt)).A(paramc);
    }
    
    public b y(d paramd)
    {
      this.c = paramd;
      float f1 = n(paramd);
      if (f1 != -1.0F) {
        z(f1);
      }
      return this;
    }
    
    public b z(float paramFloat)
    {
      this.g = new a(paramFloat);
      return this;
    }
  }
  
  public static abstract interface c
  {
    public abstract c a(c paramc);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r7.m
 * JD-Core Version:    0.7.0.1
 */