package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p0.i;
import q0.d.b;

public class h
  extends g
{
  static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;
  private h b;
  private PorterDuffColorFilter c;
  private ColorFilter d;
  private boolean e;
  private boolean f = true;
  private Drawable.ConstantState g;
  private final float[] h = new float[9];
  private final Matrix i = new Matrix();
  private final Rect j = new Rect();
  
  h()
  {
    this.b = new h();
  }
  
  h(h paramh)
  {
    this.b = paramh;
    this.c = j(this.c, paramh.c, paramh.d);
  }
  
  static int a(int paramInt, float paramFloat)
  {
    return paramInt & 0xFFFFFF | (int)(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  public static h b(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new h();
      ((g)localObject).a = p0.h.e(paramResources, paramInt, paramTheme);
      ((h)localObject).g = new i(((g)localObject).a.getConstantState());
      return localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2) {
        return c(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
      }
      throw new XmlPullParserException("No start tag found");
    }
    catch (IOException paramResources) {}catch (XmlPullParserException paramResources) {}
    Log.e("VectorDrawableCompat", "parser error", paramResources);
    return null;
  }
  
  public static h c(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    h localh = new h();
    localh.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localh;
  }
  
  private void e(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    h localh = this.b;
    g localg = localh.b;
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.push(localg.h);
    int i1 = paramXmlPullParser.getEventType();
    int i3 = paramXmlPullParser.getDepth();
    int n;
    for (int m = 1; (i1 != 1) && ((paramXmlPullParser.getDepth() >= i3 + 1) || (i1 != 3)); m = n)
    {
      if (i1 == 2)
      {
        Object localObject = paramXmlPullParser.getName();
        d locald = (d)localArrayDeque.peek();
        if ("path".equals(localObject))
        {
          localObject = new c();
          ((c)localObject).g(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          locald.b.add(localObject);
          if (((f)localObject).getPathName() != null) {
            localg.p.put(((f)localObject).getPathName(), localObject);
          }
          n = 0;
        }
        else
        {
          if (!"clip-path".equals(localObject)) {
            break label289;
          }
          b localb = new b();
          localb.e(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          locald.b.add(localb);
          localObject = localb;
          n = m;
          if (localb.getPathName() != null)
          {
            localg.p.put(localb.getPathName(), localb);
            n = m;
            localObject = localb;
          }
        }
        i1 = localh.a;
        int i2 = ((f)localObject).d;
        m = n;
        for (n = i2;; n = ((d)localObject).k)
        {
          localh.a = (n | i1);
          n = m;
          break;
          label289:
          n = m;
          if (!"group".equals(localObject)) {
            break;
          }
          localObject = new d();
          ((d)localObject).c(paramResources, paramAttributeSet, paramTheme, paramXmlPullParser);
          locald.b.add(localObject);
          localArrayDeque.push(localObject);
          if (((d)localObject).getGroupName() != null) {
            localg.p.put(((d)localObject).getGroupName(), localObject);
          }
          i1 = localh.a;
        }
      }
      n = m;
      if (i1 == 3)
      {
        n = m;
        if ("group".equals(paramXmlPullParser.getName()))
        {
          localArrayDeque.pop();
          n = m;
        }
      }
      i1 = paramXmlPullParser.next();
    }
    if (m == 0) {
      return;
    }
    throw new XmlPullParserException("no path defined");
  }
  
  private boolean f()
  {
    return (isAutoMirrored()) && (r0.a.f(this) == 1);
  }
  
  private static PorterDuff.Mode g(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
  
  private void i(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
  {
    h localh = this.b;
    g localg = localh.b;
    localh.d = g(i.g(paramTypedArray, paramXmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
    paramTheme = i.c(paramTypedArray, paramXmlPullParser, paramTheme, "tint", 1);
    if (paramTheme != null) {
      localh.c = paramTheme;
    }
    localh.e = i.a(paramTypedArray, paramXmlPullParser, "autoMirrored", 5, localh.e);
    localg.k = i.f(paramTypedArray, paramXmlPullParser, "viewportWidth", 7, localg.k);
    float f1 = i.f(paramTypedArray, paramXmlPullParser, "viewportHeight", 8, localg.l);
    localg.l = f1;
    if (localg.k > 0.0F)
    {
      if (f1 > 0.0F)
      {
        localg.i = paramTypedArray.getDimension(3, localg.i);
        f1 = paramTypedArray.getDimension(2, localg.j);
        localg.j = f1;
        if (localg.i > 0.0F)
        {
          if (f1 > 0.0F)
          {
            localg.setAlpha(i.f(paramTypedArray, paramXmlPullParser, "alpha", 4, localg.getAlpha()));
            paramTypedArray = paramTypedArray.getString(0);
            if (paramTypedArray != null)
            {
              localg.n = paramTypedArray;
              localg.p.put(paramTypedArray, localg);
            }
            return;
          }
          paramXmlPullParser = new StringBuilder();
          paramXmlPullParser.append(paramTypedArray.getPositionDescription());
          paramXmlPullParser.append("<vector> tag requires height > 0");
          throw new XmlPullParserException(paramXmlPullParser.toString());
        }
        paramXmlPullParser = new StringBuilder();
        paramXmlPullParser.append(paramTypedArray.getPositionDescription());
        paramXmlPullParser.append("<vector> tag requires width > 0");
        throw new XmlPullParserException(paramXmlPullParser.toString());
      }
      paramXmlPullParser = new StringBuilder();
      paramXmlPullParser.append(paramTypedArray.getPositionDescription());
      paramXmlPullParser.append("<vector> tag requires viewportHeight > 0");
      throw new XmlPullParserException(paramXmlPullParser.toString());
    }
    paramXmlPullParser = new StringBuilder();
    paramXmlPullParser.append(paramTypedArray.getPositionDescription());
    paramXmlPullParser.append("<vector> tag requires viewportWidth > 0");
    throw new XmlPullParserException(paramXmlPullParser.toString());
  }
  
  public boolean canApplyTheme()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      r0.a.b(localDrawable);
    }
    return false;
  }
  
  Object d(String paramString)
  {
    return this.b.b.p.get(paramString);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).draw(paramCanvas);
      return;
    }
    copyBounds(this.j);
    if (this.j.width() > 0)
    {
      if (this.j.height() <= 0) {
        return;
      }
      Object localObject2 = this.d;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.c;
      }
      paramCanvas.getMatrix(this.i);
      this.i.getValues(this.h);
      float f1 = Math.abs(this.h[0]);
      float f2 = Math.abs(this.h[4]);
      float f4 = Math.abs(this.h[1]);
      float f3 = Math.abs(this.h[3]);
      if ((f4 != 0.0F) || (f3 != 0.0F))
      {
        f1 = 1.0F;
        f2 = f1;
      }
      int m = (int)(this.j.width() * f1);
      int n = (int)(this.j.height() * f2);
      m = Math.min(2048, m);
      n = Math.min(2048, n);
      if (m > 0)
      {
        if (n <= 0) {
          return;
        }
        int i1 = paramCanvas.save();
        localObject2 = this.j;
        paramCanvas.translate(((Rect)localObject2).left, ((Rect)localObject2).top);
        if (f())
        {
          paramCanvas.translate(this.j.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        this.j.offsetTo(0, 0);
        this.b.c(m, n);
        if (!this.f)
        {
          this.b.j(m, n);
        }
        else if (!this.b.b())
        {
          this.b.j(m, n);
          this.b.i();
        }
        this.b.d(paramCanvas, (ColorFilter)localObject1, this.j);
        paramCanvas.restoreToCount(i1);
      }
    }
  }
  
  public int getAlpha()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return r0.a.d(localDrawable);
    }
    return this.b.b.getRootAlpha();
  }
  
  public int getChangingConfigurations()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | this.b.getChangingConfigurations();
  }
  
  public ColorFilter getColorFilter()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return r0.a.e(localDrawable);
    }
    return this.d;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if ((this.a != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new i(this.a.getConstantState());
    }
    this.b.a = getChangingConfigurations();
    return this.b;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return (int)this.b.b.j;
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return (int)this.b.b.i;
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return -3;
  }
  
  void h(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      r0.a.g((Drawable)localObject, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    localObject = this.b;
    ((h)localObject).b = new g();
    TypedArray localTypedArray = i.k(paramResources, paramTheme, paramAttributeSet, a.a);
    i(localTypedArray, paramXmlPullParser, paramTheme);
    localTypedArray.recycle();
    ((h)localObject).a = getChangingConfigurations();
    ((h)localObject).k = true;
    e(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    this.c = j(this.c, ((h)localObject).c, ((h)localObject).d);
  }
  
  public void invalidateSelf()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return r0.a.h(localDrawable);
    }
    return this.b.e;
  }
  
  public boolean isStateful()
  {
    Object localObject = this.a;
    if (localObject != null) {
      return ((Drawable)localObject).isStateful();
    }
    if (!super.isStateful())
    {
      localObject = this.b;
      if (localObject != null)
      {
        if (!((h)localObject).g())
        {
          localObject = this.b.c;
          if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {}
        }
      }
      else {
        return false;
      }
    }
    return true;
  }
  
  PorterDuffColorFilter j(PorterDuffColorFilter paramPorterDuffColorFilter, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.mutate();
      return this;
    }
    if ((!this.e) && (super.mutate() == this))
    {
      this.b = new h(this.b);
      this.e = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Object localObject = this.a;
    if (localObject != null) {
      return ((Drawable)localObject).setState(paramArrayOfInt);
    }
    boolean bool2 = false;
    localObject = this.b;
    ColorStateList localColorStateList = ((h)localObject).c;
    boolean bool1 = bool2;
    if (localColorStateList != null)
    {
      PorterDuff.Mode localMode = ((h)localObject).d;
      bool1 = bool2;
      if (localMode != null)
      {
        this.c = j(this.c, localColorStateList, localMode);
        invalidateSelf();
        bool1 = true;
      }
    }
    if ((((h)localObject).g()) && (((h)localObject).h(paramArrayOfInt)))
    {
      invalidateSelf();
      return true;
    }
    return bool1;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.setAlpha(paramInt);
      return;
    }
    if (this.b.b.getRootAlpha() != paramInt)
    {
      this.b.b.setRootAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      r0.a.j(localDrawable, paramBoolean);
      return;
    }
    this.b.e = paramBoolean;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      return;
    }
    this.d = paramColorFilter;
    invalidateSelf();
  }
  
  public void setTint(int paramInt)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      r0.a.n(localDrawable, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      r0.a.o((Drawable)localObject, paramColorStateList);
      return;
    }
    localObject = this.b;
    if (((h)localObject).c != paramColorStateList)
    {
      ((h)localObject).c = paramColorStateList;
      this.c = j(this.c, paramColorStateList, ((h)localObject).d);
      invalidateSelf();
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      r0.a.p((Drawable)localObject, paramMode);
      return;
    }
    localObject = this.b;
    if (((h)localObject).d != paramMode)
    {
      ((h)localObject).d = paramMode;
      this.c = j(this.c, ((h)localObject).c, paramMode);
      invalidateSelf();
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      return localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != null)
    {
      localDrawable.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
  
  private static class b
    extends h.f
  {
    b() {}
    
    b(b paramb)
    {
      super();
    }
    
    private void f(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.b = str;
      }
      str = paramTypedArray.getString(1);
      if (str != null) {
        this.a = q0.d.d(str);
      }
      this.c = i.g(paramTypedArray, paramXmlPullParser, "fillType", 2, 0);
    }
    
    public boolean c()
    {
      return true;
    }
    
    public void e(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      if (!i.j(paramXmlPullParser, "pathData")) {
        return;
      }
      paramResources = i.k(paramResources, paramTheme, paramAttributeSet, a.d);
      f(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }
  }
  
  private static class c
    extends h.f
  {
    private int[] e;
    p0.d f;
    float g = 0.0F;
    p0.d h;
    float i = 1.0F;
    float j = 1.0F;
    float k = 0.0F;
    float l = 1.0F;
    float m = 0.0F;
    Paint.Cap n = Paint.Cap.BUTT;
    Paint.Join o = Paint.Join.MITER;
    float p = 4.0F;
    
    c() {}
    
    c(c paramc)
    {
      super();
      this.e = paramc.e;
      this.f = paramc.f;
      this.g = paramc.g;
      this.i = paramc.i;
      this.h = paramc.h;
      this.c = paramc.c;
      this.j = paramc.j;
      this.k = paramc.k;
      this.l = paramc.l;
      this.m = paramc.m;
      this.n = paramc.n;
      this.o = paramc.o;
      this.p = paramc.p;
    }
    
    private Paint.Cap e(int paramInt, Paint.Cap paramCap)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return paramCap;
          }
          return Paint.Cap.SQUARE;
        }
        return Paint.Cap.ROUND;
      }
      return Paint.Cap.BUTT;
    }
    
    private Paint.Join f(int paramInt, Paint.Join paramJoin)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            return paramJoin;
          }
          return Paint.Join.BEVEL;
        }
        return Paint.Join.ROUND;
      }
      return Paint.Join.MITER;
    }
    
    private void h(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
    {
      this.e = null;
      if (!i.j(paramXmlPullParser, "pathData")) {
        return;
      }
      String str = paramTypedArray.getString(0);
      if (str != null) {
        this.b = str;
      }
      str = paramTypedArray.getString(2);
      if (str != null) {
        this.a = q0.d.d(str);
      }
      this.h = i.e(paramTypedArray, paramXmlPullParser, paramTheme, "fillColor", 1, 0);
      this.j = i.f(paramTypedArray, paramXmlPullParser, "fillAlpha", 12, this.j);
      this.n = e(i.g(paramTypedArray, paramXmlPullParser, "strokeLineCap", 8, -1), this.n);
      this.o = f(i.g(paramTypedArray, paramXmlPullParser, "strokeLineJoin", 9, -1), this.o);
      this.p = i.f(paramTypedArray, paramXmlPullParser, "strokeMiterLimit", 10, this.p);
      this.f = i.e(paramTypedArray, paramXmlPullParser, paramTheme, "strokeColor", 3, 0);
      this.i = i.f(paramTypedArray, paramXmlPullParser, "strokeAlpha", 11, this.i);
      this.g = i.f(paramTypedArray, paramXmlPullParser, "strokeWidth", 4, this.g);
      this.l = i.f(paramTypedArray, paramXmlPullParser, "trimPathEnd", 6, this.l);
      this.m = i.f(paramTypedArray, paramXmlPullParser, "trimPathOffset", 7, this.m);
      this.k = i.f(paramTypedArray, paramXmlPullParser, "trimPathStart", 5, this.k);
      this.c = i.g(paramTypedArray, paramXmlPullParser, "fillType", 13, this.c);
    }
    
    public boolean a()
    {
      return (this.h.i()) || (this.f.i());
    }
    
    public boolean b(int[] paramArrayOfInt)
    {
      boolean bool = this.h.j(paramArrayOfInt);
      return this.f.j(paramArrayOfInt) | bool;
    }
    
    public void g(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = i.k(paramResources, paramTheme, paramAttributeSet, a.c);
      h(paramResources, paramXmlPullParser, paramTheme);
      paramResources.recycle();
    }
    
    float getFillAlpha()
    {
      return this.j;
    }
    
    int getFillColor()
    {
      return this.h.e();
    }
    
    float getStrokeAlpha()
    {
      return this.i;
    }
    
    int getStrokeColor()
    {
      return this.f.e();
    }
    
    float getStrokeWidth()
    {
      return this.g;
    }
    
    float getTrimPathEnd()
    {
      return this.l;
    }
    
    float getTrimPathOffset()
    {
      return this.m;
    }
    
    float getTrimPathStart()
    {
      return this.k;
    }
    
    void setFillAlpha(float paramFloat)
    {
      this.j = paramFloat;
    }
    
    void setFillColor(int paramInt)
    {
      this.h.k(paramInt);
    }
    
    void setStrokeAlpha(float paramFloat)
    {
      this.i = paramFloat;
    }
    
    void setStrokeColor(int paramInt)
    {
      this.f.k(paramInt);
    }
    
    void setStrokeWidth(float paramFloat)
    {
      this.g = paramFloat;
    }
    
    void setTrimPathEnd(float paramFloat)
    {
      this.l = paramFloat;
    }
    
    void setTrimPathOffset(float paramFloat)
    {
      this.m = paramFloat;
    }
    
    void setTrimPathStart(float paramFloat)
    {
      this.k = paramFloat;
    }
  }
  
  private static class d
    extends h.e
  {
    final Matrix a = new Matrix();
    final ArrayList<h.e> b = new ArrayList();
    float c = 0.0F;
    private float d = 0.0F;
    private float e = 0.0F;
    private float f = 1.0F;
    private float g = 1.0F;
    private float h = 0.0F;
    private float i = 0.0F;
    final Matrix j;
    int k;
    private int[] l;
    private String m;
    
    public d()
    {
      super();
      this.j = new Matrix();
      this.m = null;
    }
    
    public d(d paramd, g0.a<String, Object> parama)
    {
      super();
      Object localObject = new Matrix();
      this.j = ((Matrix)localObject);
      this.m = null;
      this.c = paramd.c;
      this.d = paramd.d;
      this.e = paramd.e;
      this.f = paramd.f;
      this.g = paramd.g;
      this.h = paramd.h;
      this.i = paramd.i;
      this.l = paramd.l;
      String str = paramd.m;
      this.m = str;
      this.k = paramd.k;
      if (str != null) {
        parama.put(str, this);
      }
      ((Matrix)localObject).set(paramd.j);
      localObject = paramd.b;
      int n = 0;
      while (n < ((ArrayList)localObject).size())
      {
        paramd = ((ArrayList)localObject).get(n);
        if ((paramd instanceof d))
        {
          paramd = (d)paramd;
          this.b.add(new d(paramd, parama));
        }
        else
        {
          if ((paramd instanceof h.c))
          {
            paramd = new h.c((h.c)paramd);
          }
          else
          {
            if (!(paramd instanceof h.b)) {
              break label320;
            }
            paramd = new h.b((h.b)paramd);
          }
          this.b.add(paramd);
          str = paramd.b;
          if (str != null) {
            parama.put(str, paramd);
          }
        }
        n += 1;
        continue;
        label320:
        throw new IllegalStateException("Unknown object in the tree!");
      }
    }
    
    private void d()
    {
      this.j.reset();
      this.j.postTranslate(-this.d, -this.e);
      this.j.postScale(this.f, this.g);
      this.j.postRotate(this.c, 0.0F, 0.0F);
      this.j.postTranslate(this.h + this.d, this.i + this.e);
    }
    
    private void e(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser)
    {
      this.l = null;
      this.c = i.f(paramTypedArray, paramXmlPullParser, "rotation", 5, this.c);
      this.d = paramTypedArray.getFloat(1, this.d);
      this.e = paramTypedArray.getFloat(2, this.e);
      this.f = i.f(paramTypedArray, paramXmlPullParser, "scaleX", 3, this.f);
      this.g = i.f(paramTypedArray, paramXmlPullParser, "scaleY", 4, this.g);
      this.h = i.f(paramTypedArray, paramXmlPullParser, "translateX", 6, this.h);
      this.i = i.f(paramTypedArray, paramXmlPullParser, "translateY", 7, this.i);
      paramTypedArray = paramTypedArray.getString(0);
      if (paramTypedArray != null) {
        this.m = paramTypedArray;
      }
      d();
    }
    
    public boolean a()
    {
      int n = 0;
      while (n < this.b.size())
      {
        if (((h.e)this.b.get(n)).a()) {
          return true;
        }
        n += 1;
      }
      return false;
    }
    
    public boolean b(int[] paramArrayOfInt)
    {
      int n = 0;
      boolean bool = false;
      while (n < this.b.size())
      {
        bool |= ((h.e)this.b.get(n)).b(paramArrayOfInt);
        n += 1;
      }
      return bool;
    }
    
    public void c(Resources paramResources, AttributeSet paramAttributeSet, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser)
    {
      paramResources = i.k(paramResources, paramTheme, paramAttributeSet, a.b);
      e(paramResources, paramXmlPullParser);
      paramResources.recycle();
    }
    
    public String getGroupName()
    {
      return this.m;
    }
    
    public Matrix getLocalMatrix()
    {
      return this.j;
    }
    
    public float getPivotX()
    {
      return this.d;
    }
    
    public float getPivotY()
    {
      return this.e;
    }
    
    public float getRotation()
    {
      return this.c;
    }
    
    public float getScaleX()
    {
      return this.f;
    }
    
    public float getScaleY()
    {
      return this.g;
    }
    
    public float getTranslateX()
    {
      return this.h;
    }
    
    public float getTranslateY()
    {
      return this.i;
    }
    
    public void setPivotX(float paramFloat)
    {
      if (paramFloat != this.d)
      {
        this.d = paramFloat;
        d();
      }
    }
    
    public void setPivotY(float paramFloat)
    {
      if (paramFloat != this.e)
      {
        this.e = paramFloat;
        d();
      }
    }
    
    public void setRotation(float paramFloat)
    {
      if (paramFloat != this.c)
      {
        this.c = paramFloat;
        d();
      }
    }
    
    public void setScaleX(float paramFloat)
    {
      if (paramFloat != this.f)
      {
        this.f = paramFloat;
        d();
      }
    }
    
    public void setScaleY(float paramFloat)
    {
      if (paramFloat != this.g)
      {
        this.g = paramFloat;
        d();
      }
    }
    
    public void setTranslateX(float paramFloat)
    {
      if (paramFloat != this.h)
      {
        this.h = paramFloat;
        d();
      }
    }
    
    public void setTranslateY(float paramFloat)
    {
      if (paramFloat != this.i)
      {
        this.i = paramFloat;
        d();
      }
    }
  }
  
  private static abstract class e
  {
    public boolean a()
    {
      return false;
    }
    
    public boolean b(int[] paramArrayOfInt)
    {
      return false;
    }
  }
  
  private static abstract class f
    extends h.e
  {
    protected d.b[] a = null;
    String b;
    int c = 0;
    int d;
    
    public f()
    {
      super();
    }
    
    public f(f paramf)
    {
      super();
      this.b = paramf.b;
      this.d = paramf.d;
      this.a = q0.d.f(paramf.a);
    }
    
    public boolean c()
    {
      return false;
    }
    
    public void d(Path paramPath)
    {
      paramPath.reset();
      d.b[] arrayOfb = this.a;
      if (arrayOfb != null) {
        d.b.e(arrayOfb, paramPath);
      }
    }
    
    public d.b[] getPathData()
    {
      return this.a;
    }
    
    public String getPathName()
    {
      return this.b;
    }
    
    public void setPathData(d.b[] paramArrayOfb)
    {
      if (!q0.d.b(this.a, paramArrayOfb))
      {
        this.a = q0.d.f(paramArrayOfb);
        return;
      }
      q0.d.j(this.a, paramArrayOfb);
    }
  }
  
  private static class g
  {
    private static final Matrix q = new Matrix();
    private final Path a;
    private final Path b;
    private final Matrix c = new Matrix();
    Paint d;
    Paint e;
    private PathMeasure f;
    private int g;
    final h.d h;
    float i = 0.0F;
    float j = 0.0F;
    float k = 0.0F;
    float l = 0.0F;
    int m = 255;
    String n = null;
    Boolean o = null;
    final g0.a<String, Object> p;
    
    public g()
    {
      this.p = new g0.a();
      this.h = new h.d();
      this.a = new Path();
      this.b = new Path();
    }
    
    public g(g paramg)
    {
      g0.a locala = new g0.a();
      this.p = locala;
      this.h = new h.d(paramg.h, locala);
      this.a = new Path(paramg.a);
      this.b = new Path(paramg.b);
      this.i = paramg.i;
      this.j = paramg.j;
      this.k = paramg.k;
      this.l = paramg.l;
      this.g = paramg.g;
      this.m = paramg.m;
      this.n = paramg.n;
      String str = paramg.n;
      if (str != null) {
        locala.put(str, this);
      }
      this.o = paramg.o;
    }
    
    private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return paramFloat1 * paramFloat4 - paramFloat2 * paramFloat3;
    }
    
    private void c(h.d paramd, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      paramd.a.set(paramMatrix);
      paramd.a.preConcat(paramd.j);
      paramCanvas.save();
      int i1 = 0;
      while (i1 < paramd.b.size())
      {
        paramMatrix = (h.e)paramd.b.get(i1);
        if ((paramMatrix instanceof h.d)) {
          c((h.d)paramMatrix, paramd.a, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        } else if ((paramMatrix instanceof h.f)) {
          d(paramd, (h.f)paramMatrix, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
        i1 += 1;
      }
      paramCanvas.restore();
    }
    
    private void d(h.d paramd, h.f paramf, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      float f2 = paramInt1 / this.k;
      float f3 = paramInt2 / this.l;
      float f1 = Math.min(f2, f3);
      paramd = paramd.a;
      this.c.set(paramd);
      this.c.postScale(f2, f3);
      f2 = e(paramd);
      if (f2 == 0.0F) {
        return;
      }
      paramf.d(this.a);
      Object localObject1 = this.a;
      this.b.reset();
      if (paramf.c())
      {
        paramColorFilter = this.b;
        if (paramf.c == 0) {
          paramd = Path.FillType.WINDING;
        } else {
          paramd = Path.FillType.EVEN_ODD;
        }
        paramColorFilter.setFillType(paramd);
        this.b.addPath((Path)localObject1, this.c);
        paramCanvas.clipPath(this.b);
        return;
      }
      paramf = (h.c)paramf;
      float f6 = paramf.k;
      if ((f6 != 0.0F) || (paramf.l != 1.0F))
      {
        float f4 = paramf.m;
        float f5 = paramf.l;
        if (this.f == null) {
          this.f = new PathMeasure();
        }
        this.f.setPath(this.a, false);
        f3 = this.f.getLength();
        f6 = (f6 + f4) % 1.0F * f3;
        f4 = (f5 + f4) % 1.0F * f3;
        ((Path)localObject1).reset();
        if (f6 > f4)
        {
          this.f.getSegment(f6, f3, (Path)localObject1, true);
          this.f.getSegment(0.0F, f4, (Path)localObject1, true);
        }
        else
        {
          this.f.getSegment(f6, f4, (Path)localObject1, true);
        }
        ((Path)localObject1).rLineTo(0.0F, 0.0F);
      }
      this.b.addPath((Path)localObject1, this.c);
      Object localObject2;
      if (paramf.h.l())
      {
        paramd = paramf.h;
        if (this.e == null)
        {
          localObject1 = new Paint(1);
          this.e = ((Paint)localObject1);
          ((Paint)localObject1).setStyle(Paint.Style.FILL);
        }
        localObject1 = this.e;
        if (paramd.h())
        {
          paramd = paramd.f();
          paramd.setLocalMatrix(this.c);
          ((Paint)localObject1).setShader(paramd);
          ((Paint)localObject1).setAlpha(Math.round(paramf.j * 255.0F));
        }
        else
        {
          ((Paint)localObject1).setShader(null);
          ((Paint)localObject1).setAlpha(255);
          ((Paint)localObject1).setColor(h.a(paramd.e(), paramf.j));
        }
        ((Paint)localObject1).setColorFilter(paramColorFilter);
        localObject2 = this.b;
        if (paramf.c == 0) {
          paramd = Path.FillType.WINDING;
        } else {
          paramd = Path.FillType.EVEN_ODD;
        }
        ((Path)localObject2).setFillType(paramd);
        paramCanvas.drawPath(this.b, (Paint)localObject1);
      }
      if (paramf.f.l())
      {
        paramd = paramf.f;
        if (this.d == null)
        {
          localObject1 = new Paint(1);
          this.d = ((Paint)localObject1);
          ((Paint)localObject1).setStyle(Paint.Style.STROKE);
        }
        localObject1 = this.d;
        localObject2 = paramf.o;
        if (localObject2 != null) {
          ((Paint)localObject1).setStrokeJoin((Paint.Join)localObject2);
        }
        localObject2 = paramf.n;
        if (localObject2 != null) {
          ((Paint)localObject1).setStrokeCap((Paint.Cap)localObject2);
        }
        ((Paint)localObject1).setStrokeMiter(paramf.p);
        if (paramd.h())
        {
          paramd = paramd.f();
          paramd.setLocalMatrix(this.c);
          ((Paint)localObject1).setShader(paramd);
          ((Paint)localObject1).setAlpha(Math.round(paramf.i * 255.0F));
        }
        else
        {
          ((Paint)localObject1).setShader(null);
          ((Paint)localObject1).setAlpha(255);
          ((Paint)localObject1).setColor(h.a(paramd.e(), paramf.i));
        }
        ((Paint)localObject1).setColorFilter(paramColorFilter);
        ((Paint)localObject1).setStrokeWidth(paramf.g * (f1 * f2));
        paramCanvas.drawPath(this.b, (Paint)localObject1);
      }
    }
    
    private float e(Matrix paramMatrix)
    {
      float[] arrayOfFloat = new float[4];
      float[] tmp7_5 = arrayOfFloat;
      tmp7_5[0] = 0.0F;
      float[] tmp11_7 = tmp7_5;
      tmp11_7[1] = 1.0F;
      float[] tmp15_11 = tmp11_7;
      tmp15_11[2] = 1.0F;
      float[] tmp19_15 = tmp15_11;
      tmp19_15[3] = 0.0F;
      tmp19_15;
      paramMatrix.mapVectors(arrayOfFloat);
      float f1 = (float)Math.hypot(arrayOfFloat[0], arrayOfFloat[1]);
      float f3 = (float)Math.hypot(arrayOfFloat[2], arrayOfFloat[3]);
      float f2 = a(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3]);
      f3 = Math.max(f1, f3);
      f1 = 0.0F;
      if (f3 > 0.0F) {
        f1 = Math.abs(f2) / f3;
      }
      return f1;
    }
    
    public void b(Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      c(this.h, q, paramCanvas, paramInt1, paramInt2, paramColorFilter);
    }
    
    public boolean f()
    {
      if (this.o == null) {
        this.o = Boolean.valueOf(this.h.a());
      }
      return this.o.booleanValue();
    }
    
    public boolean g(int[] paramArrayOfInt)
    {
      return this.h.b(paramArrayOfInt);
    }
    
    public float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public int getRootAlpha()
    {
      return this.m;
    }
    
    public void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(paramFloat * 255.0F));
    }
    
    public void setRootAlpha(int paramInt)
    {
      this.m = paramInt;
    }
  }
  
  private static class h
    extends Drawable.ConstantState
  {
    int a;
    h.g b;
    ColorStateList c = null;
    PorterDuff.Mode d = h.k;
    boolean e;
    Bitmap f;
    ColorStateList g;
    PorterDuff.Mode h;
    int i;
    boolean j;
    boolean k;
    Paint l;
    
    public h()
    {
      this.b = new h.g();
    }
    
    public h(h paramh)
    {
      if (paramh != null)
      {
        this.a = paramh.a;
        h.g localg = new h.g(paramh.b);
        this.b = localg;
        if (paramh.b.e != null) {
          localg.e = new Paint(paramh.b.e);
        }
        if (paramh.b.d != null) {
          this.b.d = new Paint(paramh.b.d);
        }
        this.c = paramh.c;
        this.d = paramh.d;
        this.e = paramh.e;
      }
    }
    
    public boolean a(int paramInt1, int paramInt2)
    {
      return (paramInt1 == this.f.getWidth()) && (paramInt2 == this.f.getHeight());
    }
    
    public boolean b()
    {
      return (!this.k) && (this.g == this.c) && (this.h == this.d) && (this.j == this.e) && (this.i == this.b.getRootAlpha());
    }
    
    public void c(int paramInt1, int paramInt2)
    {
      if ((this.f == null) || (!a(paramInt1, paramInt2)))
      {
        this.f = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        this.k = true;
      }
    }
    
    public void d(Canvas paramCanvas, ColorFilter paramColorFilter, Rect paramRect)
    {
      paramColorFilter = e(paramColorFilter);
      paramCanvas.drawBitmap(this.f, null, paramRect, paramColorFilter);
    }
    
    public Paint e(ColorFilter paramColorFilter)
    {
      if ((!f()) && (paramColorFilter == null)) {
        return null;
      }
      if (this.l == null)
      {
        Paint localPaint = new Paint();
        this.l = localPaint;
        localPaint.setFilterBitmap(true);
      }
      this.l.setAlpha(this.b.getRootAlpha());
      this.l.setColorFilter(paramColorFilter);
      return this.l;
    }
    
    public boolean f()
    {
      return this.b.getRootAlpha() < 255;
    }
    
    public boolean g()
    {
      return this.b.f();
    }
    
    public int getChangingConfigurations()
    {
      return this.a;
    }
    
    public boolean h(int[] paramArrayOfInt)
    {
      boolean bool = this.b.g(paramArrayOfInt);
      this.k |= bool;
      return bool;
    }
    
    public void i()
    {
      this.g = this.c;
      this.h = this.d;
      this.i = this.b.getRootAlpha();
      this.j = this.e;
      this.k = false;
    }
    
    public void j(int paramInt1, int paramInt2)
    {
      this.f.eraseColor(0);
      Canvas localCanvas = new Canvas(this.f);
      this.b.b(localCanvas, paramInt1, paramInt2, null);
    }
    
    public Drawable newDrawable()
    {
      return new h(this);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new h(this);
    }
  }
  
  private static class i
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState a;
    
    public i(Drawable.ConstantState paramConstantState)
    {
      this.a = paramConstantState;
    }
    
    public boolean canApplyTheme()
    {
      return this.a.canApplyTheme();
    }
    
    public int getChangingConfigurations()
    {
      return this.a.getChangingConfigurations();
    }
    
    public Drawable newDrawable()
    {
      h localh = new h();
      localh.a = ((VectorDrawable)this.a.newDrawable());
      return localh;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      h localh = new h();
      localh.a = ((VectorDrawable)this.a.newDrawable(paramResources));
      return localh;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      h localh = new h();
      localh.a = ((VectorDrawable)this.a.newDrawable(paramResources, paramTheme));
      return localh;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.h
 * JD-Core Version:    0.7.0.1
 */