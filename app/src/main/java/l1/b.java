package l1;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class b
{
  static final c f = new a();
  private final List<e> a;
  private final List<c> b;
  private final Map<c, e> c;
  private final SparseBooleanArray d;
  private final e e;
  
  b(List<e> paramList, List<c> paramList1)
  {
    this.a = paramList;
    this.b = paramList1;
    this.d = new SparseBooleanArray();
    this.c = new g0.a();
    this.e = a();
  }
  
  private e a()
  {
    int m = this.a.size();
    int j = -2147483648;
    Object localObject = null;
    int i = 0;
    while (i < m)
    {
      e locale = (e)this.a.get(i);
      int k = j;
      if (locale.d() > j)
      {
        k = locale.d();
        localObject = locale;
      }
      i += 1;
      j = k;
    }
    return localObject;
  }
  
  public static b b(Bitmap paramBitmap)
  {
    return new b(paramBitmap);
  }
  
  private float d(e parame, c paramc)
  {
    float[] arrayOfFloat = parame.c();
    e locale = this.e;
    int i;
    if (locale != null) {
      i = locale.d();
    } else {
      i = 1;
    }
    float f1 = paramc.g();
    float f3 = 0.0F;
    if (f1 > 0.0F) {
      f1 = paramc.g() * (1.0F - Math.abs(arrayOfFloat[1] - paramc.i()));
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (paramc.a() > 0.0F) {
      f2 = paramc.a() * (1.0F - Math.abs(arrayOfFloat[2] - paramc.h()));
    } else {
      f2 = 0.0F;
    }
    if (paramc.f() > 0.0F) {
      f3 = paramc.f() * (parame.d() / i);
    }
    return f1 + f2 + f3;
  }
  
  private e e(c paramc)
  {
    e locale = k(paramc);
    if ((locale != null) && (paramc.j())) {
      this.d.append(locale.e(), true);
    }
    return locale;
  }
  
  private e k(c paramc)
  {
    int j = this.a.size();
    float f1 = 0.0F;
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      e locale = (e)this.a.get(i);
      float f2 = f1;
      Object localObject2 = localObject1;
      if (n(locale, paramc))
      {
        float f3 = d(locale, paramc);
        if (localObject1 != null)
        {
          f2 = f1;
          localObject2 = localObject1;
          if (f3 <= f1) {}
        }
        else
        {
          localObject2 = locale;
          f2 = f3;
        }
      }
      i += 1;
      f1 = f2;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private boolean n(e parame, c paramc)
  {
    float[] arrayOfFloat = parame.c();
    return (arrayOfFloat[1] >= paramc.e()) && (arrayOfFloat[1] <= paramc.c()) && (arrayOfFloat[2] >= paramc.d()) && (arrayOfFloat[2] <= paramc.b()) && (!this.d.get(parame.e()));
  }
  
  void c()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      c localc = (c)this.b.get(i);
      localc.k();
      this.c.put(localc, e(localc));
      i += 1;
    }
    this.d.clear();
  }
  
  public e f()
  {
    return l(c.j);
  }
  
  public e g()
  {
    return l(c.g);
  }
  
  public e h()
  {
    return this.e;
  }
  
  public e i()
  {
    return l(c.h);
  }
  
  public e j()
  {
    return l(c.e);
  }
  
  public e l(c paramc)
  {
    return (e)this.c.get(paramc);
  }
  
  public e m()
  {
    return l(c.f);
  }
  
  static final class a
    implements b.c
  {
    private boolean b(float[] paramArrayOfFloat)
    {
      return paramArrayOfFloat[2] <= 0.05F;
    }
    
    private boolean c(float[] paramArrayOfFloat)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramArrayOfFloat[0] >= 10.0F)
      {
        bool1 = bool2;
        if (paramArrayOfFloat[0] <= 37.0F)
        {
          bool1 = bool2;
          if (paramArrayOfFloat[1] <= 0.82F) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    
    private boolean d(float[] paramArrayOfFloat)
    {
      return paramArrayOfFloat[2] >= 0.95F;
    }
    
    public boolean a(int paramInt, float[] paramArrayOfFloat)
    {
      return (!d(paramArrayOfFloat)) && (!b(paramArrayOfFloat)) && (!c(paramArrayOfFloat));
    }
  }
  
  public static final class b
  {
    private final List<b.e> a;
    private final Bitmap b;
    private final List<c> c;
    private int d;
    private int e;
    private int f;
    private final List<b.c> g;
    private Rect h;
    
    public b(Bitmap paramBitmap)
    {
      ArrayList localArrayList1 = new ArrayList();
      this.c = localArrayList1;
      this.d = 16;
      this.e = 12544;
      this.f = -1;
      ArrayList localArrayList2 = new ArrayList();
      this.g = localArrayList2;
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
      {
        localArrayList2.add(b.f);
        this.b = paramBitmap;
        this.a = null;
        localArrayList1.add(c.e);
        localArrayList1.add(c.f);
        localArrayList1.add(c.g);
        localArrayList1.add(c.h);
        localArrayList1.add(c.i);
        localArrayList1.add(c.j);
        return;
      }
      throw new IllegalArgumentException("Bitmap is not valid");
    }
    
    private int[] c(Bitmap paramBitmap)
    {
      int j = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      int[] arrayOfInt = new int[j * i];
      paramBitmap.getPixels(arrayOfInt, 0, j, 0, 0, j, i);
      paramBitmap = this.h;
      if (paramBitmap == null) {
        return arrayOfInt;
      }
      int k = paramBitmap.width();
      int m = this.h.height();
      paramBitmap = new int[k * m];
      i = 0;
      while (i < m)
      {
        Rect localRect = this.h;
        System.arraycopy(arrayOfInt, (localRect.top + i) * j + localRect.left, paramBitmap, i * k, k);
        i += 1;
      }
      return paramBitmap;
    }
    
    private Bitmap d(Bitmap paramBitmap)
    {
      int i = this.e;
      double d2 = -1.0D;
      int j;
      double d1;
      if (i > 0)
      {
        i = paramBitmap.getWidth() * paramBitmap.getHeight();
        j = this.e;
        d1 = d2;
        if (i > j) {
          d1 = Math.sqrt(j / i);
        }
      }
      else
      {
        d1 = d2;
        if (this.f > 0)
        {
          i = Math.max(paramBitmap.getWidth(), paramBitmap.getHeight());
          j = this.f;
          d1 = d2;
          if (i > j) {
            d1 = j / i;
          }
        }
      }
      if (d1 <= 0.0D) {
        return paramBitmap;
      }
      return Bitmap.createScaledBitmap(paramBitmap, (int)Math.ceil(paramBitmap.getWidth() * d1), (int)Math.ceil(paramBitmap.getHeight() * d1), false);
    }
    
    public AsyncTask<Bitmap, Void, b> a(final b.d paramd)
    {
      if (paramd != null) {
        return new a(paramd).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[] { this.b });
      }
      throw new IllegalArgumentException("listener can not be null");
    }
    
    public b b()
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        Bitmap localBitmap = d((Bitmap)localObject);
        localObject = this.h;
        if ((localBitmap != this.b) && (localObject != null))
        {
          double d1 = localBitmap.getWidth() / this.b.getWidth();
          ((Rect)localObject).left = ((int)Math.floor(((Rect)localObject).left * d1));
          ((Rect)localObject).top = ((int)Math.floor(((Rect)localObject).top * d1));
          ((Rect)localObject).right = Math.min((int)Math.ceil(((Rect)localObject).right * d1), localBitmap.getWidth());
          ((Rect)localObject).bottom = Math.min((int)Math.ceil(((Rect)localObject).bottom * d1), localBitmap.getHeight());
        }
        int[] arrayOfInt = c(localBitmap);
        int i = this.d;
        if (this.g.isEmpty())
        {
          localObject = null;
        }
        else
        {
          localObject = this.g;
          localObject = (b.c[])((List)localObject).toArray(new b.c[((List)localObject).size()]);
        }
        localObject = new a(arrayOfInt, i, (b.c[])localObject);
        if (localBitmap != this.b) {
          localBitmap.recycle();
        }
        localObject = ((a)localObject).d();
      }
      else
      {
        localObject = this.a;
        if (localObject == null) {
          break label270;
        }
      }
      localObject = new b((List)localObject, this.c);
      ((b)localObject).c();
      return localObject;
      label270:
      throw new AssertionError();
    }
    
    class a
      extends AsyncTask<Bitmap, Void, b>
    {
      a(b.d paramd) {}
      
      protected b a(Bitmap... paramVarArgs)
      {
        try
        {
          paramVarArgs = b.b.this.b();
          return paramVarArgs;
        }
        catch (Exception paramVarArgs)
        {
          Log.e("Palette", "Exception thrown during async generate", paramVarArgs);
        }
        return null;
      }
      
      protected void b(b paramb)
      {
        paramd.a(paramb);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(int paramInt, float[] paramArrayOfFloat);
  }
  
  public static abstract interface d
  {
    public abstract void a(b paramb);
  }
  
  public static final class e
  {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private boolean f;
    private int g;
    private int h;
    private float[] i;
    
    public e(int paramInt1, int paramInt2)
    {
      this.a = Color.red(paramInt1);
      this.b = Color.green(paramInt1);
      this.c = Color.blue(paramInt1);
      this.d = paramInt1;
      this.e = paramInt2;
    }
    
    private void a()
    {
      if (!this.f)
      {
        int j = q0.a.f(-1, this.d, 4.5F);
        int k = q0.a.f(-1, this.d, 3.0F);
        if ((j != -1) && (k != -1)) {
          this.h = q0.a.o(-1, j);
        }
        int n;
        int m;
        for (j = q0.a.o(-1, k);; j = q0.a.o(-16777216, m))
        {
          this.g = j;
          this.f = true;
          return;
          n = q0.a.f(-16777216, this.d, 4.5F);
          m = q0.a.f(-16777216, this.d, 3.0F);
          if ((n == -1) || (m == -1)) {
            break;
          }
          this.h = q0.a.o(-16777216, n);
        }
        if (j != -1) {
          j = q0.a.o(-1, j);
        } else {
          j = q0.a.o(-16777216, n);
        }
        this.h = j;
        if (k != -1) {
          j = q0.a.o(-1, k);
        } else {
          j = q0.a.o(-16777216, m);
        }
        this.g = j;
        this.f = true;
      }
    }
    
    public int b()
    {
      a();
      return this.h;
    }
    
    public float[] c()
    {
      if (this.i == null) {
        this.i = new float[3];
      }
      q0.a.a(this.a, this.b, this.c, this.i);
      return this.i;
    }
    
    public int d()
    {
      return this.e;
    }
    
    public int e()
    {
      return this.d;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (e.class != paramObject.getClass()) {
          return false;
        }
        paramObject = (e)paramObject;
        return (this.e == paramObject.e) && (this.d == paramObject.d);
      }
      return false;
    }
    
    public int f()
    {
      a();
      return this.g;
    }
    
    public int hashCode()
    {
      return this.d * 31 + this.e;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(e.class.getSimpleName());
      localStringBuilder.append(" [RGB: #");
      localStringBuilder.append(Integer.toHexString(e()));
      localStringBuilder.append(']');
      localStringBuilder.append(" [HSL: ");
      localStringBuilder.append(Arrays.toString(c()));
      localStringBuilder.append(']');
      localStringBuilder.append(" [Population: ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(']');
      localStringBuilder.append(" [Title Text: #");
      localStringBuilder.append(Integer.toHexString(f()));
      localStringBuilder.append(']');
      localStringBuilder.append(" [Body Text: #");
      localStringBuilder.append(Integer.toHexString(b()));
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l1.b
 * JD-Core Version:    0.7.0.1
 */