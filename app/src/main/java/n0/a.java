package n0;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a
{
  private static int a(int paramInt)
  {
    paramInt = (paramInt & paramInt >> 31) - 255;
    return (paramInt & paramInt >> 31) + 255;
  }
  
  public static void b(androidx.constraintlayout.widget.a parama, View paramView, float[] paramArrayOfFloat)
  {
    Class localClass = paramView.getClass();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("set");
    ((StringBuilder)localObject).append(parama.c());
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    try
    {
      i = a.a[parama.d().ordinal()];
      bool = true;
      switch (i)
      {
      case 7: 
        localClass.getMethod((String)localObject, new Class[] { Float.TYPE }).invoke(paramView, new Object[] { Float.valueOf(paramArrayOfFloat[0]) });
        return;
      }
    }
    catch (InvocationTargetException parama)
    {
      int i;
      parama.printStackTrace();
      return;
    }
    catch (IllegalAccessException parama)
    {
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("cannot access method ");
      paramArrayOfFloat.append((String)localObject);
      paramArrayOfFloat.append(" on View \"");
      paramArrayOfFloat.append(androidx.constraintlayout.motion.widget.a.d(paramView));
      paramArrayOfFloat.append("\"");
      Log.e("CustomSupport", paramArrayOfFloat.toString());
      parama.printStackTrace();
      return;
    }
    catch (NoSuchMethodException parama)
    {
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("no method ");
      paramArrayOfFloat.append((String)localObject);
      paramArrayOfFloat.append(" on View \"");
      paramArrayOfFloat.append(androidx.constraintlayout.motion.widget.a.d(paramView));
      paramArrayOfFloat.append("\"");
      Log.e("CustomSupport", paramArrayOfFloat.toString());
      parama.printStackTrace();
      return;
    }
    parama = localClass.getMethod((String)localObject, new Class[] { Boolean.TYPE });
    if (paramArrayOfFloat[0] > 0.5F) {
      break label166;
    }
    for (;;)
    {
      label166:
      parama.invoke(paramView, new Object[] { Boolean.valueOf(bool) });
      return;
      paramArrayOfFloat = new StringBuilder();
      paramArrayOfFloat.append("unable to interpolate strings ");
      paramArrayOfFloat.append(parama.c());
      throw new RuntimeException(paramArrayOfFloat.toString());
      parama = localClass.getMethod((String)localObject, new Class[] { Integer.TYPE });
      i = a((int)((float)Math.pow(paramArrayOfFloat[0], 0.4545454545454545D) * 255.0F));
      int j = a((int)((float)Math.pow(paramArrayOfFloat[1], 0.4545454545454545D) * 255.0F));
      int k = a((int)((float)Math.pow(paramArrayOfFloat[2], 0.4545454545454545D) * 255.0F));
      parama.invoke(paramView, new Object[] { Integer.valueOf(i << 16 | a((int)(paramArrayOfFloat[3] * 255.0F)) << 24 | j << 8 | k) });
      return;
      parama = localClass.getMethod((String)localObject, new Class[] { Drawable.class });
      i = a((int)((float)Math.pow(paramArrayOfFloat[0], 0.4545454545454545D) * 255.0F));
      j = a((int)((float)Math.pow(paramArrayOfFloat[1], 0.4545454545454545D) * 255.0F));
      k = a((int)((float)Math.pow(paramArrayOfFloat[2], 0.4545454545454545D) * 255.0F));
      int m = a((int)(paramArrayOfFloat[3] * 255.0F));
      paramArrayOfFloat = new ColorDrawable();
      paramArrayOfFloat.setColor(i << 16 | m << 24 | j << 8 | k);
      parama.invoke(paramView, new Object[] { paramArrayOfFloat });
      return;
      localClass.getMethod((String)localObject, new Class[] { Float.TYPE }).invoke(paramView, new Object[] { Float.valueOf(paramArrayOfFloat[0]) });
      return;
      localClass.getMethod((String)localObject, new Class[] { Integer.TYPE }).invoke(paramView, new Object[] { Integer.valueOf((int)paramArrayOfFloat[0]) });
      return;
      return;
      bool = false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n0.a
 * JD-Core Version:    0.7.0.1
 */