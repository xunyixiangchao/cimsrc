package n0;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import i0.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class c
  extends e
{
  public static c i(String paramString)
  {
    if (paramString.startsWith("CUSTOM")) {
      return new b();
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 156108012: 
      if (paramString.equals("waveOffset")) {
        i = 13;
      }
      break;
    case 92909918: 
      if (paramString.equals("alpha")) {
        i = 12;
      }
      break;
    case 37232917: 
      if (paramString.equals("transitionPathRotate")) {
        i = 11;
      }
      break;
    case -4379043: 
      if (paramString.equals("elevation")) {
        i = 10;
      }
      break;
    case -40300674: 
      if (paramString.equals("rotation")) {
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
    case 13: 
      return new a();
    case 12: 
      return new a();
    case 11: 
      return new d();
    case 10: 
      return new c();
    case 9: 
      return new f();
    case 8: 
      return new a();
    case 7: 
      return new j();
    case 6: 
      return new i();
    case 5: 
      return new e();
    case 4: 
      return new m();
    case 3: 
      return new l();
    case 2: 
      return new k();
    case 1: 
      return new h();
    }
    return new g();
  }
  
  public abstract void j(View paramView, float paramFloat);
  
  static class a
    extends c
  {
    public void j(View paramView, float paramFloat)
    {
      paramView.setAlpha(a(paramFloat));
    }
  }
  
  static class b
    extends c
  {
    float[] h = new float[1];
    protected androidx.constraintlayout.widget.a i;
    
    protected void c(Object paramObject)
    {
      this.i = ((androidx.constraintlayout.widget.a)paramObject);
    }
    
    public void j(View paramView, float paramFloat)
    {
      this.h[0] = a(paramFloat);
      a.b(this.i, paramView, this.h);
    }
  }
  
  static class c
    extends c
  {
    public void j(View paramView, float paramFloat)
    {
      paramView.setElevation(a(paramFloat));
    }
  }
  
  public static class d
    extends c
  {
    public void j(View paramView, float paramFloat) {}
    
    public void k(View paramView, float paramFloat, double paramDouble1, double paramDouble2)
    {
      paramView.setRotation(a(paramFloat) + (float)Math.toDegrees(Math.atan2(paramDouble2, paramDouble1)));
    }
  }
  
  static class e
    extends c
  {
    boolean h = false;
    
    public void j(View paramView, float paramFloat)
    {
      if ((paramView instanceof MotionLayout))
      {
        ((MotionLayout)paramView).setProgress(a(paramFloat));
        return;
      }
      if (this.h) {
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
      this.h = true;
      if (localObject != null)
      {
        try
        {
          localObject.invoke(paramView, new Object[] { Float.valueOf(a(paramFloat)) });
          return;
        }
        catch (InvocationTargetException paramView) {}catch (IllegalAccessException paramView) {}
        Log.e("ViewOscillator", "unable to setProgress", paramView);
      }
    }
  }
  
  static class f
    extends c
  {
    public void j(View paramView, float paramFloat)
    {
      paramView.setRotation(a(paramFloat));
    }
  }
  
  static class g
    extends c
  {
    public void j(View paramView, float paramFloat)
    {
      paramView.setRotationX(a(paramFloat));
    }
  }
  
  static class h
    extends c
  {
    public void j(View paramView, float paramFloat)
    {
      paramView.setRotationY(a(paramFloat));
    }
  }
  
  static class i
    extends c
  {
    public void j(View paramView, float paramFloat)
    {
      paramView.setScaleX(a(paramFloat));
    }
  }
  
  static class j
    extends c
  {
    public void j(View paramView, float paramFloat)
    {
      paramView.setScaleY(a(paramFloat));
    }
  }
  
  static class k
    extends c
  {
    public void j(View paramView, float paramFloat)
    {
      paramView.setTranslationX(a(paramFloat));
    }
  }
  
  static class l
    extends c
  {
    public void j(View paramView, float paramFloat)
    {
      paramView.setTranslationY(a(paramFloat));
    }
  }
  
  static class m
    extends c
  {
    public void j(View paramView, float paramFloat)
    {
      paramView.setTranslationZ(a(paramFloat));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n0.c
 * JD-Core Version:    0.7.0.1
 */