package n0;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import i0.b;
import i0.d;
import i0.o;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class f
  extends o
{
  public static f g(String paramString, SparseArray<androidx.constraintlayout.widget.a> paramSparseArray)
  {
    return new b(paramString, paramSparseArray);
  }
  
  public static f h(String paramString, long paramLong)
  {
    paramString.hashCode();
    int j = paramString.hashCode();
    int i = -1;
    switch (j)
    {
    default: 
      break;
    case 92909918: 
      if (paramString.equals("alpha")) {
        i = 11;
      }
      break;
    case 37232917: 
      if (paramString.equals("transitionPathRotate")) {
        i = 10;
      }
      break;
    case -4379043: 
      if (paramString.equals("elevation")) {
        i = 9;
      }
      break;
    case -40300674: 
      if (paramString.equals("rotation")) {
        i = 8;
      }
      break;
    case -908189617: 
      if (paramString.equals("scaleY")) {
        i = 7;
      }
      break;
    case -908189618: 
      if (paramString.equals("scaleX")) {
        i = 6;
      }
      break;
    case -1001078227: 
      if (paramString.equals("progress")) {
        i = 5;
      }
      break;
    case -1225497655: 
      if (paramString.equals("translationZ")) {
        i = 4;
      }
      break;
    case -1225497656: 
      if (paramString.equals("translationY")) {
        i = 3;
      }
      break;
    case -1225497657: 
      if (paramString.equals("translationX")) {
        i = 2;
      }
      break;
    case -1249320805: 
      if (paramString.equals("rotationY")) {
        i = 1;
      }
      break;
    case -1249320806: 
      if (paramString.equals("rotationX")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      return null;
    case 11: 
      paramString = new a();
      break;
    case 10: 
      paramString = new d();
      break;
    case 9: 
      paramString = new c();
      break;
    case 8: 
      paramString = new f();
      break;
    case 7: 
      paramString = new j();
      break;
    case 6: 
      paramString = new i();
      break;
    case 5: 
      paramString = new e();
      break;
    case 4: 
      paramString = new m();
      break;
    case 3: 
      paramString = new l();
      break;
    case 2: 
      paramString = new k();
      break;
    case 1: 
      paramString = new h();
      break;
    case 0: 
      paramString = new g();
    }
    paramString.c(paramLong);
    return paramString;
  }
  
  public float f(float paramFloat, long paramLong, View paramView, d paramd)
  {
    this.a.e(paramFloat, this.g);
    float[] arrayOfFloat = this.g;
    paramFloat = arrayOfFloat[1];
    boolean bool1 = paramFloat < 0.0F;
    if (!bool1)
    {
      this.h = false;
      return arrayOfFloat[2];
    }
    if (Float.isNaN(this.j))
    {
      f1 = paramd.a(paramView, this.f, 0);
      this.j = f1;
      if (Float.isNaN(f1)) {
        this.j = 0.0F;
      }
    }
    long l = this.i;
    paramFloat = (float)((this.j + (paramLong - l) * 1.E-009D * paramFloat) % 1.0D);
    this.j = paramFloat;
    paramd.b(paramView, this.f, 0, paramFloat);
    this.i = paramLong;
    paramFloat = this.g[0];
    float f1 = a(this.j);
    float f2 = this.g[2];
    boolean bool2;
    if ((paramFloat == 0.0F) && (!bool1)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    this.h = bool2;
    return f1 * paramFloat + f2;
  }
  
  public abstract boolean i(View paramView, float paramFloat, long paramLong, d paramd);
  
  static class a
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      paramView.setAlpha(f(paramFloat, paramLong, paramView, paramd));
      return this.h;
    }
  }
  
  public static class b
    extends f
  {
    String l = paramString.split(",")[1];
    SparseArray<androidx.constraintlayout.widget.a> m;
    SparseArray<float[]> n = new SparseArray();
    float[] o;
    float[] p;
    
    public b(String paramString, SparseArray<androidx.constraintlayout.widget.a> paramSparseArray)
    {
      this.m = paramSparseArray;
    }
    
    public void b(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3)
    {
      throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
    }
    
    public void e(int paramInt)
    {
      int k = this.m.size();
      int i1 = ((androidx.constraintlayout.widget.a)this.m.valueAt(0)).h();
      double[] arrayOfDouble = new double[k];
      int i = i1 + 2;
      this.o = new float[i];
      this.p = new float[i1];
      double[][] arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { k, i });
      i = 0;
      while (i < k)
      {
        int j = this.m.keyAt(i);
        Object localObject = (androidx.constraintlayout.widget.a)this.m.valueAt(i);
        float[] arrayOfFloat = (float[])this.n.valueAt(i);
        arrayOfDouble[i] = (j * 0.01D);
        ((androidx.constraintlayout.widget.a)localObject).f(this.o);
        j = 0;
        for (;;)
        {
          localObject = this.o;
          if (j >= localObject.length) {
            break;
          }
          arrayOfDouble1[i][j] = localObject[j];
          j += 1;
        }
        arrayOfDouble1[i][i1] = arrayOfFloat[0];
        arrayOfDouble1[i][(i1 + 1)] = arrayOfFloat[1];
        i += 1;
      }
      this.a = b.a(paramInt, arrayOfDouble, arrayOfDouble1);
    }
    
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      this.a.e(paramFloat, this.o);
      float[] arrayOfFloat = this.o;
      paramFloat = arrayOfFloat[(arrayOfFloat.length - 2)];
      float f1 = arrayOfFloat[(arrayOfFloat.length - 1)];
      long l1 = this.i;
      if (Float.isNaN(this.j))
      {
        f2 = paramd.a(paramView, this.l, 0);
        this.j = f2;
        if (Float.isNaN(f2)) {
          this.j = 0.0F;
        }
      }
      float f2 = (float)((this.j + (paramLong - l1) * 1.E-009D * paramFloat) % 1.0D);
      this.j = f2;
      this.i = paramLong;
      f2 = a(f2);
      this.h = false;
      int i = 0;
      for (;;)
      {
        paramd = this.p;
        if (i >= paramd.length) {
          break;
        }
        boolean bool2 = this.h;
        arrayOfFloat = this.o;
        boolean bool1;
        if (arrayOfFloat[i] != 0.0D) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.h = (bool2 | bool1);
        paramd[i] = (arrayOfFloat[i] * f2 + f1);
        i += 1;
      }
      a.b((androidx.constraintlayout.widget.a)this.m.valueAt(0), paramView, this.p);
      if (paramFloat != 0.0F) {
        this.h = true;
      }
      return this.h;
    }
    
    public void j(int paramInt1, androidx.constraintlayout.widget.a parama, float paramFloat1, int paramInt2, float paramFloat2)
    {
      this.m.append(paramInt1, parama);
      this.n.append(paramInt1, new float[] { paramFloat1, paramFloat2 });
      this.b = Math.max(this.b, paramInt2);
    }
  }
  
  static class c
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      paramView.setElevation(f(paramFloat, paramLong, paramView, paramd));
      return this.h;
    }
  }
  
  public static class d
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      return this.h;
    }
    
    public boolean j(View paramView, d paramd, float paramFloat, long paramLong, double paramDouble1, double paramDouble2)
    {
      paramView.setRotation(f(paramFloat, paramLong, paramView, paramd) + (float)Math.toDegrees(Math.atan2(paramDouble2, paramDouble1)));
      return this.h;
    }
  }
  
  static class e
    extends f
  {
    boolean l = false;
    
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      Object localObject;
      if ((paramView instanceof MotionLayout))
      {
        ((MotionLayout)paramView).setProgress(f(paramFloat, paramLong, paramView, paramd));
      }
      else
      {
        if (this.l) {
          return false;
        }
        localObject = null;
      }
      try
      {
        Method localMethod = paramView.getClass().getMethod("setProgress", new Class[] { Float.TYPE });
        localObject = localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        label66:
        break label66;
      }
      this.l = true;
      if (localObject != null)
      {
        try
        {
          localObject.invoke(paramView, new Object[] { Float.valueOf(f(paramFloat, paramLong, paramView, paramd)) });
        }
        catch (InvocationTargetException paramView) {}catch (IllegalAccessException paramView) {}
        Log.e("ViewTimeCycle", "unable to setProgress", paramView);
      }
      return this.h;
    }
  }
  
  static class f
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      paramView.setRotation(f(paramFloat, paramLong, paramView, paramd));
      return this.h;
    }
  }
  
  static class g
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      paramView.setRotationX(f(paramFloat, paramLong, paramView, paramd));
      return this.h;
    }
  }
  
  static class h
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      paramView.setRotationY(f(paramFloat, paramLong, paramView, paramd));
      return this.h;
    }
  }
  
  static class i
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      paramView.setScaleX(f(paramFloat, paramLong, paramView, paramd));
      return this.h;
    }
  }
  
  static class j
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      paramView.setScaleY(f(paramFloat, paramLong, paramView, paramd));
      return this.h;
    }
  }
  
  static class k
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      paramView.setTranslationX(f(paramFloat, paramLong, paramView, paramd));
      return this.h;
    }
  }
  
  static class l
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      paramView.setTranslationY(f(paramFloat, paramLong, paramView, paramd));
      return this.h;
    }
  }
  
  static class m
    extends f
  {
    public boolean i(View paramView, float paramFloat, long paramLong, d paramd)
    {
      paramView.setTranslationZ(f(paramFloat, paramLong, paramView, paramd));
      return this.h;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n0.f
 * JD-Core Version:    0.7.0.1
 */