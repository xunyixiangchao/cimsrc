package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import d.c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import r0.a;
import r0.b;

public class t
{
  private static final int[] a = { 16842912 };
  private static final int[] b = new int[0];
  public static final Rect c = new Rect();
  
  public static boolean a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof DrawableContainer))
    {
      paramDrawable = paramDrawable.getConstantState();
      if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
      {
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        int i = 0;
        while (i < j)
        {
          if (!a(paramDrawable[i])) {
            return false;
          }
          i += 1;
        }
      }
    }
    else
    {
      if ((paramDrawable instanceof b)) {
        paramDrawable = ((b)paramDrawable).b();
      }
      for (;;)
      {
        return a(paramDrawable);
        if ((paramDrawable instanceof c))
        {
          paramDrawable = ((c)paramDrawable).a();
        }
        else
        {
          if (!(paramDrawable instanceof ScaleDrawable)) {
            break;
          }
          paramDrawable = ((ScaleDrawable)paramDrawable).getDrawable();
        }
      }
    }
    return true;
  }
  
  static void b(Drawable paramDrawable)
  {
    String str = paramDrawable.getClass().getName();
    int i = Build.VERSION.SDK_INT;
    if ((i >= 29) && (i < 31) && ("android.graphics.drawable.ColorStateListDrawable".equals(str))) {
      c(paramDrawable);
    }
  }
  
  private static void c(Drawable paramDrawable)
  {
    int[] arrayOfInt = paramDrawable.getState();
    if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
      paramDrawable.setState(b);
    } else {
      paramDrawable.setState(a);
    }
    paramDrawable.setState(arrayOfInt);
  }
  
  public static Rect d(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramDrawable = b.a(paramDrawable);
      return new Rect(paramDrawable.left, paramDrawable.top, paramDrawable.right, paramDrawable.bottom);
    }
    return a.a(a.q(paramDrawable));
  }
  
  public static PorterDuff.Mode e(int paramInt, PorterDuff.Mode paramMode)
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
  
  static class a
  {
    private static final boolean a = false;
    private static final Method b;
    private static final Field c;
    private static final Field d;
    private static final Field e;
    private static final Field f;
    
    static
    {
      try
      {
        localObject2 = Class.forName("android.graphics.Insets");
        localObject1 = Drawable.class.getMethod("getOpticalInsets", new Class[0]);
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        Object localObject2;
        Object localObject1;
        Field localField;
        Object localObject4;
        Object localObject3;
        int i;
        break label133;
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        label133:
        label135:
        label139:
        label147:
        break label118;
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        label53:
        label59:
        label70:
        label81:
        label92:
        label95:
        label98:
        label103:
        label105:
        label118:
        label120:
        break label103;
      }
      try
      {
        localField = ((Class)localObject2).getField("left");
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        break label98;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        break label95;
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        break label92;
      }
      try
      {
        localObject4 = ((Class)localObject2).getField("top");
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        break label81;
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        break label70;
      }
      catch (NoSuchFieldException localNoSuchFieldException3)
      {
        break label59;
      }
      try
      {
        localObject3 = ((Class)localObject2).getField("right");
      }
      catch (NoSuchMethodException|ClassNotFoundException|NoSuchFieldException localNoSuchMethodException4)
      {
        break label53;
      }
      try
      {
        localObject2 = ((Class)localObject2).getField("bottom");
        i = 1;
      }
      catch (NoSuchMethodException|ClassNotFoundException|NoSuchFieldException localNoSuchMethodException5)
      {
        break label147;
      }
      localObject3 = null;
      break label147;
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label139;
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label139;
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label139;
      break label105;
      break label120;
      localObject2 = localObject1;
      break label135;
      localObject1 = null;
      localField = null;
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label139;
      localObject1 = null;
      localField = null;
      localObject3 = null;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break label139;
      localObject2 = null;
      localField = null;
      localObject1 = null;
      localObject3 = localObject1;
      localObject4 = localObject1;
      localObject1 = localObject2;
      i = 0;
      localObject2 = null;
      if (i != 0)
      {
        b = (Method)localObject1;
        c = localField;
        d = (Field)localObject4;
        e = (Field)localObject3;
        f = (Field)localObject2;
        a = true;
        return;
      }
      b = null;
      c = null;
      d = null;
      e = null;
      f = null;
    }
    
    static Rect a(Drawable paramDrawable)
    {
      if ((Build.VERSION.SDK_INT < 29) && (a)) {}
      try
      {
        paramDrawable = b.invoke(paramDrawable, new Object[0]);
        if (paramDrawable != null)
        {
          paramDrawable = new Rect(c.getInt(paramDrawable), d.getInt(paramDrawable), e.getInt(paramDrawable), f.getInt(paramDrawable));
          return paramDrawable;
        }
      }
      catch (IllegalAccessException|InvocationTargetException paramDrawable)
      {
        label68:
        break label68;
      }
      return t.c;
    }
  }
  
  static class b
  {
    static Insets a(Drawable paramDrawable)
    {
      return paramDrawable.getOpticalInsets();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.t
 * JD-Core Version:    0.7.0.1
 */