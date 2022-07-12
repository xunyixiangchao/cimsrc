package n0;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import i0.b;
import i0.j;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class d
  extends j
{
  public static d f(String paramString, SparseArray<androidx.constraintlayout.widget.a> paramSparseArray)
  {
    return new b(paramString, paramSparseArray);
  }
  
  public static d g(String paramString)
  {
    paramString.hashCode();
    int j = paramString.hashCode();
    int i = -1;
    switch (j)
    {
    default: 
      break;
    case 156108012: 
      if (paramString.equals("waveOffset")) {
        i = 15;
      }
      break;
    case 92909918: 
      if (paramString.equals("alpha")) {
        i = 14;
      }
      break;
    case 37232917: 
      if (paramString.equals("transitionPathRotate")) {
        i = 13;
      }
      break;
    case -4379043: 
      if (paramString.equals("elevation")) {
        i = 12;
      }
      break;
    case -40300674: 
      if (paramString.equals("rotation")) {
        i = 11;
      }
      break;
    case -760884509: 
      if (paramString.equals("transformPivotY")) {
        i = 10;
      }
      break;
    case -760884510: 
      if (paramString.equals("transformPivotX")) {
        i = 9;
      }
      break;
    case -797520672: 
      if (paramString.equals("waveVariesBy")) {
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
    case 15: 
      return new a();
    case 14: 
      return new a();
    case 13: 
      return new d();
    case 12: 
      return new c();
    case 11: 
      return new h();
    case 10: 
      return new f();
    case 9: 
      return new e();
    case 8: 
      return new a();
    case 7: 
      return new l();
    case 6: 
      return new k();
    case 5: 
      return new g();
    case 4: 
      return new o();
    case 3: 
      return new n();
    case 2: 
      return new m();
    case 1: 
      return new j();
    }
    return new i();
  }
  
  public abstract void h(View paramView, float paramFloat);
  
  static class a
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setAlpha(a(paramFloat));
    }
  }
  
  public static class b
    extends d
  {
    String f = paramString.split(",")[1];
    SparseArray<androidx.constraintlayout.widget.a> g;
    float[] h;
    
    public b(String paramString, SparseArray<androidx.constraintlayout.widget.a> paramSparseArray)
    {
      this.g = paramSparseArray;
    }
    
    public void c(int paramInt, float paramFloat)
    {
      throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
    }
    
    public void e(int paramInt)
    {
      int k = this.g.size();
      int i = ((androidx.constraintlayout.widget.a)this.g.valueAt(0)).h();
      double[] arrayOfDouble = new double[k];
      this.h = new float[i];
      double[][] arrayOfDouble1 = (double[][])Array.newInstance(Double.TYPE, new int[] { k, i });
      i = 0;
      while (i < k)
      {
        int j = this.g.keyAt(i);
        Object localObject = (androidx.constraintlayout.widget.a)this.g.valueAt(i);
        arrayOfDouble[i] = (j * 0.01D);
        ((androidx.constraintlayout.widget.a)localObject).f(this.h);
        j = 0;
        for (;;)
        {
          localObject = this.h;
          if (j >= localObject.length) {
            break;
          }
          arrayOfDouble1[i][j] = localObject[j];
          j += 1;
        }
        i += 1;
      }
      this.a = b.a(paramInt, arrayOfDouble, arrayOfDouble1);
    }
    
    public void h(View paramView, float paramFloat)
    {
      this.a.e(paramFloat, this.h);
      a.b((androidx.constraintlayout.widget.a)this.g.valueAt(0), paramView, this.h);
    }
    
    public void i(int paramInt, androidx.constraintlayout.widget.a parama)
    {
      this.g.append(paramInt, parama);
    }
  }
  
  static class c
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setElevation(a(paramFloat));
    }
  }
  
  public static class d
    extends d
  {
    public void h(View paramView, float paramFloat) {}
    
    public void i(View paramView, float paramFloat, double paramDouble1, double paramDouble2)
    {
      paramView.setRotation(a(paramFloat) + (float)Math.toDegrees(Math.atan2(paramDouble2, paramDouble1)));
    }
  }
  
  static class e
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setPivotX(a(paramFloat));
    }
  }
  
  static class f
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setPivotY(a(paramFloat));
    }
  }
  
  static class g
    extends d
  {
    boolean f = false;
    
    public void h(View paramView, float paramFloat)
    {
      if ((paramView instanceof MotionLayout))
      {
        ((MotionLayout)paramView).setProgress(a(paramFloat));
        return;
      }
      if (this.f) {
        return;
      }
      Object localObject = null;
      try
      {
        Method localMethod = paramView.getClass().getMethod("setProgress", new Class[] { Float.TYPE });
        localObject = localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        label57:
        break label57;
      }
      this.f = true;
      if (localObject != null)
      {
        try
        {
          localObject.invoke(paramView, new Object[] { Float.valueOf(a(paramFloat)) });
          return;
        }
        catch (InvocationTargetException paramView) {}catch (IllegalAccessException paramView) {}
        Log.e("ViewSpline", "unable to setProgress", paramView);
      }
    }
  }
  
  static class h
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setRotation(a(paramFloat));
    }
  }
  
  static class i
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setRotationX(a(paramFloat));
    }
  }
  
  static class j
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setRotationY(a(paramFloat));
    }
  }
  
  static class k
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setScaleX(a(paramFloat));
    }
  }
  
  static class l
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setScaleY(a(paramFloat));
    }
  }
  
  static class m
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setTranslationX(a(paramFloat));
    }
  }
  
  static class n
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setTranslationY(a(paramFloat));
    }
  }
  
  static class o
    extends d
  {
    public void h(View paramView, float paramFloat)
    {
      paramView.setTranslationZ(a(paramFloat));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n0.d
 * JD-Core Version:    0.7.0.1
 */