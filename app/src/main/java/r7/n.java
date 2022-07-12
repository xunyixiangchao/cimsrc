package r7;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PointF;
import android.graphics.RectF;

public class n
{
  private final o[] a = new o[4];
  private final Matrix[] b = new Matrix[4];
  private final Matrix[] c = new Matrix[4];
  private final PointF d = new PointF();
  private final Path e = new Path();
  private final Path f = new Path();
  private final o g = new o();
  private final float[] h = new float[2];
  private final float[] i = new float[2];
  private final Path j = new Path();
  private final Path k = new Path();
  private boolean l = true;
  
  public n()
  {
    int m = 0;
    while (m < 4)
    {
      this.a[m] = new o();
      this.b[m] = new Matrix();
      this.c[m] = new Matrix();
      m += 1;
    }
  }
  
  private float a(int paramInt)
  {
    return (paramInt + 1) * 90;
  }
  
  private void b(c paramc, int paramInt)
  {
    this.h[0] = this.a[paramInt].k();
    this.h[1] = this.a[paramInt].l();
    this.b[paramInt].mapPoints(this.h);
    Path localPath = paramc.b;
    float[] arrayOfFloat = this.h;
    if (paramInt == 0) {
      localPath.moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    } else {
      localPath.lineTo(arrayOfFloat[0], arrayOfFloat[1]);
    }
    this.a[paramInt].d(this.b[paramInt], paramc.b);
    paramc = paramc.d;
    if (paramc != null) {
      paramc.a(this.a[paramInt], this.b[paramInt], paramInt);
    }
  }
  
  private void c(c paramc, int paramInt)
  {
    int m = (paramInt + 1) % 4;
    this.h[0] = this.a[paramInt].i();
    this.h[1] = this.a[paramInt].j();
    this.b[paramInt].mapPoints(this.h);
    this.i[0] = this.a[m].k();
    this.i[1] = this.a[m].l();
    this.b[m].mapPoints(this.i);
    Object localObject1 = this.h;
    float f1 = localObject1[0];
    Object localObject2 = this.i;
    f1 = Math.max((float)Math.hypot(f1 - localObject2[0], localObject1[1] - localObject2[1]) - 0.001F, 0.0F);
    float f2 = i(paramc.c, paramInt);
    this.g.n(0.0F, 0.0F);
    localObject1 = j(paramInt, paramc.a);
    ((f)localObject1).b(f1, f2, paramc.e, this.g);
    this.j.reset();
    this.g.d(this.c[paramInt], this.j);
    Path localPath;
    if ((this.l) && ((((f)localObject1).a()) || (l(this.j, paramInt)) || (l(this.j, m))))
    {
      localObject1 = this.j;
      ((Path)localObject1).op((Path)localObject1, this.f, Path.Op.DIFFERENCE);
      this.h[0] = this.g.k();
      this.h[1] = this.g.l();
      this.c[paramInt].mapPoints(this.h);
      localObject1 = this.e;
      localObject2 = this.h;
      ((Path)localObject1).moveTo(localObject2[0], localObject2[1]);
      localObject1 = this.g;
      localObject2 = this.c[paramInt];
      localPath = this.e;
    }
    else
    {
      localObject1 = this.g;
      localObject2 = this.c[paramInt];
      localPath = paramc.b;
    }
    ((o)localObject1).d((Matrix)localObject2, localPath);
    paramc = paramc.d;
    if (paramc != null) {
      paramc.b(this.g, this.c[paramInt], paramInt);
    }
  }
  
  private void f(int paramInt, RectF paramRectF, PointF paramPointF)
  {
    float f1;
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          f1 = paramRectF.right;
        }
      }
    }
    for (float f2 = paramRectF.top;; f2 = paramRectF.bottom)
    {
      paramPointF.set(f1, f2);
      return;
      f1 = paramRectF.left;
      break;
      f1 = paramRectF.left;
      continue;
      f1 = paramRectF.right;
    }
  }
  
  private c g(int paramInt, m paramm)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramm.t();
        }
        return paramm.r();
      }
      return paramm.j();
    }
    return paramm.l();
  }
  
  private d h(int paramInt, m paramm)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramm.s();
        }
        return paramm.q();
      }
      return paramm.i();
    }
    return paramm.k();
  }
  
  private float i(RectF paramRectF, int paramInt)
  {
    float[] arrayOfFloat = this.h;
    o[] arrayOfo = this.a;
    arrayOfFloat[0] = arrayOfo[paramInt].c;
    arrayOfFloat[1] = arrayOfo[paramInt].d;
    this.b[paramInt].mapPoints(arrayOfFloat);
    float f1;
    if ((paramInt != 1) && (paramInt != 3)) {
      f1 = paramRectF.centerY();
    }
    for (float f2 = this.h[1];; f2 = this.h[0])
    {
      return Math.abs(f1 - f2);
      f1 = paramRectF.centerX();
    }
  }
  
  private f j(int paramInt, m paramm)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramm.o();
        }
        return paramm.p();
      }
      return paramm.n();
    }
    return paramm.h();
  }
  
  public static n k()
  {
    return a.a;
  }
  
  private boolean l(Path paramPath, int paramInt)
  {
    this.k.reset();
    this.a[paramInt].d(this.b[paramInt], this.k);
    RectF localRectF = new RectF();
    boolean bool = true;
    paramPath.computeBounds(localRectF, true);
    this.k.computeBounds(localRectF, true);
    paramPath.op(this.k, Path.Op.INTERSECT);
    paramPath.computeBounds(localRectF, true);
    if (localRectF.isEmpty())
    {
      if ((localRectF.width() > 1.0F) && (localRectF.height() > 1.0F)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void m(c paramc, int paramInt)
  {
    Object localObject = g(paramInt, paramc.a);
    h(paramInt, paramc.a).b(this.a[paramInt], 90.0F, paramc.e, paramc.c, (c)localObject);
    float f1 = a(paramInt);
    this.b[paramInt].reset();
    f(paramInt, paramc.c, this.d);
    paramc = this.b[paramInt];
    localObject = this.d;
    paramc.setTranslate(((PointF)localObject).x, ((PointF)localObject).y);
    this.b[paramInt].preRotate(f1);
  }
  
  private void n(int paramInt)
  {
    this.h[0] = this.a[paramInt].i();
    this.h[1] = this.a[paramInt].j();
    this.b[paramInt].mapPoints(this.h);
    float f1 = a(paramInt);
    this.c[paramInt].reset();
    Matrix localMatrix = this.c[paramInt];
    float[] arrayOfFloat = this.h;
    localMatrix.setTranslate(arrayOfFloat[0], arrayOfFloat[1]);
    this.c[paramInt].preRotate(f1);
  }
  
  public void d(m paramm, float paramFloat, RectF paramRectF, Path paramPath)
  {
    e(paramm, paramFloat, paramRectF, null, paramPath);
  }
  
  public void e(m paramm, float paramFloat, RectF paramRectF, b paramb, Path paramPath)
  {
    paramPath.rewind();
    this.e.rewind();
    this.f.rewind();
    this.f.addRect(paramRectF, Path.Direction.CW);
    paramm = new c(paramm, paramFloat, paramRectF, paramb, paramPath);
    int i1 = 0;
    int m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= 4) {
        break;
      }
      m(paramm, m);
      n(m);
      m += 1;
    }
    while (n < 4)
    {
      b(paramm, n);
      c(paramm, n);
      n += 1;
    }
    paramPath.close();
    this.e.close();
    if (!this.e.isEmpty()) {
      paramPath.op(this.e, Path.Op.UNION);
    }
  }
  
  private static class a
  {
    static final n a = new n();
  }
  
  public static abstract interface b
  {
    public abstract void a(o paramo, Matrix paramMatrix, int paramInt);
    
    public abstract void b(o paramo, Matrix paramMatrix, int paramInt);
  }
  
  static final class c
  {
    public final m a;
    public final Path b;
    public final RectF c;
    public final n.b d;
    public final float e;
    
    c(m paramm, float paramFloat, RectF paramRectF, n.b paramb, Path paramPath)
    {
      this.d = paramb;
      this.a = paramm;
      this.e = paramFloat;
      this.c = paramRectF;
      this.b = paramPath;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r7.n
 * JD-Core Version:    0.7.0.1
 */