package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class a
{
  private boolean a;
  String b;
  private b c;
  private int d;
  private float e;
  private String f;
  boolean g;
  private int h;
  
  public a(a parama, Object paramObject)
  {
    this.a = false;
    this.b = parama.b;
    this.c = parama.c;
    k(paramObject);
  }
  
  public a(String paramString, b paramb, Object paramObject, boolean paramBoolean)
  {
    this.b = paramString;
    this.c = paramb;
    this.a = paramBoolean;
    k(paramObject);
  }
  
  public static HashMap<String, a> b(HashMap<String, a> paramHashMap, View paramView)
  {
    HashMap localHashMap = new HashMap();
    Class localClass = paramView.getClass();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a locala = (a)paramHashMap.get(str);
      try
      {
        if (str.equals("BackgroundColor")) {}
        StringBuilder localStringBuilder;
        for (locala = new a(locala, Integer.valueOf(((ColorDrawable)paramView.getBackground()).getColor()));; locala = new a(locala, localClass.getMethod(localStringBuilder.toString(), new Class[0]).invoke(paramView, new Object[0])))
        {
          localHashMap.put(str, locala);
          break;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getMap");
          localStringBuilder.append(str);
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localInvocationTargetException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    return localHashMap;
  }
  
  public static void i(Context paramContext, XmlPullParser paramXmlPullParser, HashMap<String, a> paramHashMap)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void j(View paramView, HashMap<String, a> paramHashMap)
  {
    Class localClass = paramView.getClass();
    Iterator localIterator = paramHashMap.keySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        Object localObject3 = (a)paramHashMap.get(localObject2);
        Object localObject1;
        if (!((a)localObject3).a)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("set");
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = localObject2;
        }
        try
        {
          switch (a.a[localObject3.c.ordinal()])
          {
          case 8: 
            localClass.getMethod((String)localObject1, new Class[] { Float.TYPE }).invoke(paramView, new Object[] { Float.valueOf(((a)localObject3).e) });
            break;
          case 7: 
            localClass.getMethod((String)localObject1, new Class[] { Float.TYPE }).invoke(paramView, new Object[] { Float.valueOf(((a)localObject3).e) });
            break;
          case 6: 
            localClass.getMethod((String)localObject1, new Class[] { Integer.TYPE }).invoke(paramView, new Object[] { Integer.valueOf(((a)localObject3).d) });
            break;
          case 5: 
            Method localMethod = localClass.getMethod((String)localObject1, new Class[] { Drawable.class });
            ColorDrawable localColorDrawable = new ColorDrawable();
            localColorDrawable.setColor(((a)localObject3).h);
            localMethod.invoke(paramView, new Object[] { localColorDrawable });
            break;
          case 4: 
            localClass.getMethod((String)localObject1, new Class[] { Integer.TYPE }).invoke(paramView, new Object[] { Integer.valueOf(((a)localObject3).h) });
            break;
          case 3: 
            localClass.getMethod((String)localObject1, new Class[] { CharSequence.class }).invoke(paramView, new Object[] { ((a)localObject3).f });
            break;
          case 2: 
            localClass.getMethod((String)localObject1, new Class[] { Boolean.TYPE }).invoke(paramView, new Object[] { Boolean.valueOf(((a)localObject3).g) });
            break;
          case 1: 
            localClass.getMethod((String)localObject1, new Class[] { Integer.TYPE }).invoke(paramView, new Object[] { Integer.valueOf(((a)localObject3).d) });
          }
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(" Custom Attribute \"");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("\" not found on ");
          ((StringBuilder)localObject3).append(localClass.getName());
          Log.e("TransitionLayout", ((StringBuilder)localObject3).toString());
          localInvocationTargetException.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(" Custom Attribute \"");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("\" not found on ");
          ((StringBuilder)localObject3).append(localClass.getName());
          Log.e("TransitionLayout", ((StringBuilder)localObject3).toString());
          localIllegalAccessException.printStackTrace();
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.e("TransitionLayout", localNoSuchMethodException.getMessage());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" Custom Attribute \"");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("\" not found on ");
          localStringBuilder.append(localClass.getName());
          Log.e("TransitionLayout", localStringBuilder.toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localClass.getName());
          ((StringBuilder)localObject2).append(" must have a method ");
          ((StringBuilder)localObject2).append(localIllegalAccessException);
          Log.e("TransitionLayout", ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public void a(View paramView)
  {
    Class localClass = paramView.getClass();
    String str = this.b;
    Object localObject;
    if (!this.a)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = str;
    }
    try
    {
      switch (a.a[this.c.ordinal()])
      {
      case 8: 
        localClass.getMethod((String)localObject, new Class[] { Float.TYPE }).invoke(paramView, new Object[] { Float.valueOf(this.e) });
        return;
      }
    }
    catch (InvocationTargetException paramView)
    {
      Method localMethod;
      ColorDrawable localColorDrawable;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" Custom Attribute \"");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("\" not found on ");
      ((StringBuilder)localObject).append(localClass.getName());
      Log.e("TransitionLayout", ((StringBuilder)localObject).toString());
      paramView.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramView)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" Custom Attribute \"");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("\" not found on ");
      ((StringBuilder)localObject).append(localClass.getName());
      Log.e("TransitionLayout", ((StringBuilder)localObject).toString());
      paramView.printStackTrace();
      return;
    }
    catch (NoSuchMethodException paramView)
    {
      Log.e("TransitionLayout", paramView.getMessage());
      paramView = new StringBuilder();
      paramView.append(" Custom Attribute \"");
      paramView.append(str);
      paramView.append("\" not found on ");
      paramView.append(localClass.getName());
      Log.e("TransitionLayout", paramView.toString());
      paramView = new StringBuilder();
      paramView.append(localClass.getName());
      paramView.append(" must have a method ");
      paramView.append((String)localObject);
      Log.e("TransitionLayout", paramView.toString());
      return;
    }
    localClass.getMethod((String)localObject, new Class[] { Float.TYPE }).invoke(paramView, new Object[] { Float.valueOf(this.e) });
    return;
    localMethod = localClass.getMethod((String)localObject, new Class[] { Drawable.class });
    localColorDrawable = new ColorDrawable();
    localColorDrawable.setColor(this.h);
    localMethod.invoke(paramView, new Object[] { localColorDrawable });
    return;
    localClass.getMethod((String)localObject, new Class[] { Integer.TYPE }).invoke(paramView, new Object[] { Integer.valueOf(this.h) });
    return;
    localClass.getMethod((String)localObject, new Class[] { CharSequence.class }).invoke(paramView, new Object[] { this.f });
    return;
    localClass.getMethod((String)localObject, new Class[] { Boolean.TYPE }).invoke(paramView, new Object[] { Boolean.valueOf(this.g) });
    return;
    localClass.getMethod((String)localObject, new Class[] { Integer.TYPE }).invoke(paramView, new Object[] { Integer.valueOf(this.d) });
    return;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public b d()
  {
    return this.c;
  }
  
  public float e()
  {
    switch (a.a[this.c.ordinal()])
    {
    default: 
      return (0.0F / 0.0F);
    case 8: 
      return this.e;
    case 7: 
      return this.e;
    case 6: 
      return this.d;
    case 4: 
    case 5: 
      throw new RuntimeException("Color does not have a single color to interpolate");
    case 3: 
      throw new RuntimeException("Cannot interpolate String");
    }
    if (this.g) {
      return 1.0F;
    }
    return 0.0F;
  }
  
  public void f(float[] paramArrayOfFloat)
  {
    float f1;
    switch (a.a[this.c.ordinal()])
    {
    default: 
      return;
    case 8: 
      paramArrayOfFloat[0] = this.e;
      return;
    case 7: 
      paramArrayOfFloat[0] = this.e;
      return;
    case 6: 
      paramArrayOfFloat[0] = this.d;
      return;
    case 4: 
    case 5: 
      int i = this.h;
      f1 = (float)Math.pow((i >> 16 & 0xFF) / 255.0F, 2.2D);
      float f2 = (float)Math.pow((i >> 8 & 0xFF) / 255.0F, 2.2D);
      float f3 = (float)Math.pow((i & 0xFF) / 255.0F, 2.2D);
      paramArrayOfFloat[0] = f1;
      paramArrayOfFloat[1] = f2;
      paramArrayOfFloat[2] = f3;
      paramArrayOfFloat[3] = ((i >> 24 & 0xFF) / 255.0F);
      return;
    case 3: 
      throw new RuntimeException("Color does not have a single color to interpolate");
    }
    if (this.g) {
      f1 = 1.0F;
    } else {
      f1 = 0.0F;
    }
    paramArrayOfFloat[0] = f1;
  }
  
  public boolean g()
  {
    int i = a.a[this.c.ordinal()];
    return (i != 1) && (i != 2) && (i != 3);
  }
  
  public int h()
  {
    int i = a.a[this.c.ordinal()];
    if ((i != 4) && (i != 5)) {
      return 1;
    }
    return 4;
  }
  
  public void k(Object paramObject)
  {
    switch (a.a[this.c.ordinal()])
    {
    default: 
      return;
    case 7: 
    case 8: 
      this.e = ((Float)paramObject).floatValue();
      return;
    case 4: 
    case 5: 
      this.h = ((Integer)paramObject).intValue();
      return;
    case 3: 
      this.f = ((String)paramObject);
      return;
    case 2: 
      this.g = ((Boolean)paramObject).booleanValue();
      return;
    }
    this.d = ((Integer)paramObject).intValue();
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.a
 * JD-Core Version:    0.7.0.1
 */