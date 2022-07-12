package r7;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q7.a;

public class o
{
  @Deprecated
  public float a;
  @Deprecated
  public float b;
  @Deprecated
  public float c;
  @Deprecated
  public float d;
  @Deprecated
  public float e;
  @Deprecated
  public float f;
  private final List<f> g = new ArrayList();
  private final List<g> h = new ArrayList();
  private boolean i;
  
  public o()
  {
    n(0.0F, 0.0F);
  }
  
  private void b(float paramFloat)
  {
    if (g() == paramFloat) {
      return;
    }
    float f1 = (paramFloat - g() + 360.0F) % 360.0F;
    if (f1 > 180.0F) {
      return;
    }
    d locald = new d(i(), j(), i(), j());
    d.f(locald, g());
    d.g(locald, f1);
    this.h.add(new b(locald));
    p(paramFloat);
  }
  
  private void c(g paramg, float paramFloat1, float paramFloat2)
  {
    b(paramFloat1);
    this.h.add(paramg);
    p(paramFloat2);
  }
  
  private float g()
  {
    return this.e;
  }
  
  private float h()
  {
    return this.f;
  }
  
  private void p(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  private void q(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  private void r(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  private void s(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  private void t(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  private void u(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Object localObject = new d(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    d.f((d)localObject, paramFloat5);
    d.g((d)localObject, paramFloat6);
    this.g.add(localObject);
    localObject = new b((d)localObject);
    float f1 = paramFloat5 + paramFloat6;
    int j;
    if (paramFloat6 < 0.0F) {
      j = 1;
    } else {
      j = 0;
    }
    paramFloat6 = paramFloat5;
    if (j != 0) {
      paramFloat6 = (paramFloat5 + 180.0F) % 360.0F;
    }
    if (j != 0) {
      paramFloat5 = (180.0F + f1) % 360.0F;
    } else {
      paramFloat5 = f1;
    }
    c((g)localObject, paramFloat6, paramFloat5);
    paramFloat5 = (paramFloat3 - paramFloat1) / 2.0F;
    double d1 = f1;
    r((paramFloat1 + paramFloat3) * 0.5F + paramFloat5 * (float)Math.cos(Math.toRadians(d1)));
    s((paramFloat2 + paramFloat4) * 0.5F + (paramFloat4 - paramFloat2) / 2.0F * (float)Math.sin(Math.toRadians(d1)));
  }
  
  public void d(Matrix paramMatrix, Path paramPath)
  {
    int k = this.g.size();
    int j = 0;
    while (j < k)
    {
      ((f)this.g.get(j)).a(paramMatrix, paramPath);
      j += 1;
    }
  }
  
  boolean e()
  {
    return this.i;
  }
  
  g f(final Matrix paramMatrix)
  {
    b(h());
    paramMatrix = new Matrix(paramMatrix);
    return new a(new ArrayList(this.h), paramMatrix);
  }
  
  float i()
  {
    return this.c;
  }
  
  float j()
  {
    return this.d;
  }
  
  float k()
  {
    return this.a;
  }
  
  float l()
  {
    return this.b;
  }
  
  public void m(float paramFloat1, float paramFloat2)
  {
    Object localObject = new e();
    e.c((e)localObject, paramFloat1);
    e.e((e)localObject, paramFloat2);
    this.g.add(localObject);
    localObject = new c((e)localObject, i(), j());
    c((g)localObject, ((c)localObject).c() + 270.0F, ((c)localObject).c() + 270.0F);
    r(paramFloat1);
    s(paramFloat2);
  }
  
  public void n(float paramFloat1, float paramFloat2)
  {
    o(paramFloat1, paramFloat2, 270.0F, 0.0F);
  }
  
  public void o(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    t(paramFloat1);
    u(paramFloat2);
    r(paramFloat1);
    s(paramFloat2);
    p(paramFloat3);
    q((paramFloat3 + paramFloat4) % 360.0F);
    this.g.clear();
    this.h.clear();
    this.i = false;
  }
  
  class a
    extends o.g
  {
    a(List paramList, Matrix paramMatrix) {}
    
    public void a(Matrix paramMatrix, a parama, int paramInt, Canvas paramCanvas)
    {
      paramMatrix = this.b.iterator();
      while (paramMatrix.hasNext()) {
        ((o.g)paramMatrix.next()).a(paramMatrix, parama, paramInt, paramCanvas);
      }
    }
  }
  
  static class b
    extends o.g
  {
    private final o.d b;
    
    public b(o.d paramd)
    {
      this.b = paramd;
    }
    
    public void a(Matrix paramMatrix, a parama, int paramInt, Canvas paramCanvas)
    {
      float f1 = o.d.h(this.b);
      float f2 = o.d.i(this.b);
      parama.a(paramCanvas, paramMatrix, new RectF(o.d.b(this.b), o.d.c(this.b), o.d.d(this.b), o.d.e(this.b)), paramInt, f1, f2);
    }
  }
  
  static class c
    extends o.g
  {
    private final o.e b;
    private final float c;
    private final float d;
    
    public c(o.e parame, float paramFloat1, float paramFloat2)
    {
      this.b = parame;
      this.c = paramFloat1;
      this.d = paramFloat2;
    }
    
    public void a(Matrix paramMatrix, a parama, int paramInt, Canvas paramCanvas)
    {
      float f1 = o.e.d(this.b);
      float f2 = this.d;
      float f3 = o.e.b(this.b);
      float f4 = this.c;
      RectF localRectF = new RectF(0.0F, 0.0F, (float)Math.hypot(f1 - f2, f3 - f4), 0.0F);
      paramMatrix = new Matrix(paramMatrix);
      paramMatrix.preTranslate(this.c, this.d);
      paramMatrix.preRotate(c());
      parama.b(paramCanvas, paramMatrix, localRectF, paramInt);
    }
    
    float c()
    {
      return (float)Math.toDegrees(Math.atan((o.e.d(this.b) - this.d) / (o.e.b(this.b) - this.c)));
    }
  }
  
  public static class d
    extends o.f
  {
    private static final RectF h = new RectF();
    @Deprecated
    public float b;
    @Deprecated
    public float c;
    @Deprecated
    public float d;
    @Deprecated
    public float e;
    @Deprecated
    public float f;
    @Deprecated
    public float g;
    
    public d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      q(paramFloat1);
      u(paramFloat2);
      r(paramFloat3);
      p(paramFloat4);
    }
    
    private float j()
    {
      return this.e;
    }
    
    private float k()
    {
      return this.b;
    }
    
    private float l()
    {
      return this.d;
    }
    
    private float m()
    {
      return this.f;
    }
    
    private float n()
    {
      return this.g;
    }
    
    private float o()
    {
      return this.c;
    }
    
    private void p(float paramFloat)
    {
      this.e = paramFloat;
    }
    
    private void q(float paramFloat)
    {
      this.b = paramFloat;
    }
    
    private void r(float paramFloat)
    {
      this.d = paramFloat;
    }
    
    private void s(float paramFloat)
    {
      this.f = paramFloat;
    }
    
    private void t(float paramFloat)
    {
      this.g = paramFloat;
    }
    
    private void u(float paramFloat)
    {
      this.c = paramFloat;
    }
    
    public void a(Matrix paramMatrix, Path paramPath)
    {
      Object localObject = this.a;
      paramMatrix.invert((Matrix)localObject);
      paramPath.transform((Matrix)localObject);
      localObject = h;
      ((RectF)localObject).set(k(), o(), l(), j());
      paramPath.arcTo((RectF)localObject, m(), n(), false);
      paramPath.transform(paramMatrix);
    }
  }
  
  public static class e
    extends o.f
  {
    private float b;
    private float c;
    
    public void a(Matrix paramMatrix, Path paramPath)
    {
      Matrix localMatrix = this.a;
      paramMatrix.invert(localMatrix);
      paramPath.transform(localMatrix);
      paramPath.lineTo(this.b, this.c);
      paramPath.transform(paramMatrix);
    }
  }
  
  public static abstract class f
  {
    protected final Matrix a = new Matrix();
    
    public abstract void a(Matrix paramMatrix, Path paramPath);
  }
  
  static abstract class g
  {
    static final Matrix a = new Matrix();
    
    public abstract void a(Matrix paramMatrix, a parama, int paramInt, Canvas paramCanvas);
    
    public final void b(a parama, int paramInt, Canvas paramCanvas)
    {
      a(a, parama, paramInt, paramCanvas);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r7.o
 * JD-Core Version:    0.7.0.1
 */