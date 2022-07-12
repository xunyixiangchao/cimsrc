package p0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

public final class h
{
  private static final ThreadLocal<TypedValue> a = new ThreadLocal();
  private static final WeakHashMap<c, SparseArray<b>> b = new WeakHashMap(0);
  private static final Object c = new Object();
  
  private static void a(c paramc, int paramInt, ColorStateList paramColorStateList)
  {
    synchronized (c)
    {
      WeakHashMap localWeakHashMap = b;
      SparseArray localSparseArray2 = (SparseArray)localWeakHashMap.get(paramc);
      SparseArray localSparseArray1 = localSparseArray2;
      if (localSparseArray2 == null)
      {
        localSparseArray1 = new SparseArray();
        localWeakHashMap.put(paramc, localSparseArray1);
      }
      localSparseArray1.append(paramInt, new b(paramColorStateList, paramc.a.getConfiguration()));
      return;
    }
  }
  
  private static ColorStateList b(c paramc, int paramInt)
  {
    synchronized (c)
    {
      SparseArray localSparseArray = (SparseArray)b.get(paramc);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        b localb = (b)localSparseArray.get(paramInt);
        if (localb != null)
        {
          if (localb.b.equals(paramc.a.getConfiguration()))
          {
            paramc = localb.a;
            return paramc;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
  }
  
  public static Typeface c(Context paramContext, int paramInt)
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return m(paramContext, paramInt, new TypedValue(), 0, null, null, false, true);
  }
  
  public static ColorStateList d(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    c localc = new c(paramResources, paramTheme);
    ColorStateList localColorStateList = b(localc, paramInt);
    if (localColorStateList != null) {
      return localColorStateList;
    }
    localColorStateList = k(paramResources, paramInt, paramTheme);
    if (localColorStateList != null)
    {
      a(localc, paramInt, localColorStateList);
      return localColorStateList;
    }
    return a.a(paramResources, paramInt, paramTheme);
  }
  
  public static Drawable e(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    return paramResources.getDrawable(paramInt, paramTheme);
  }
  
  public static Drawable f(Resources paramResources, int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    return paramResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
  }
  
  public static Typeface g(Context paramContext, int paramInt)
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return m(paramContext, paramInt, new TypedValue(), 0, null, null, false, false);
  }
  
  public static Typeface h(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, d paramd)
  {
    if (paramContext.isRestricted()) {
      return null;
    }
    return m(paramContext, paramInt1, paramTypedValue, paramInt2, paramd, null, true, false);
  }
  
  public static void i(Context paramContext, int paramInt, d paramd, Handler paramHandler)
  {
    x0.h.g(paramd);
    if (paramContext.isRestricted())
    {
      paramd.a(-4, paramHandler);
      return;
    }
    m(paramContext, paramInt, new TypedValue(), 0, paramd, paramHandler, false, false);
  }
  
  private static TypedValue j()
  {
    ThreadLocal localThreadLocal = a;
    TypedValue localTypedValue2 = (TypedValue)localThreadLocal.get();
    TypedValue localTypedValue1 = localTypedValue2;
    if (localTypedValue2 == null)
    {
      localTypedValue1 = new TypedValue();
      localThreadLocal.set(localTypedValue1);
    }
    return localTypedValue1;
  }
  
  private static ColorStateList k(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    if (l(paramResources, paramInt)) {
      return null;
    }
    XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
    try
    {
      paramResources = c.a(paramResources, localXmlResourceParser, paramTheme);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", paramResources);
    }
    return null;
  }
  
  private static boolean l(Resources paramResources, int paramInt)
  {
    TypedValue localTypedValue = j();
    paramResources.getValue(paramInt, localTypedValue, true);
    paramInt = localTypedValue.type;
    return (paramInt >= 28) && (paramInt <= 31);
  }
  
  private static Typeface m(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, d paramd, Handler paramHandler, boolean paramBoolean1, boolean paramBoolean2)
  {
    Resources localResources = paramContext.getResources();
    localResources.getValue(paramInt1, paramTypedValue, true);
    paramContext = n(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, paramd, paramHandler, paramBoolean1, paramBoolean2);
    if ((paramContext == null) && (paramd == null))
    {
      if (paramBoolean2) {
        return paramContext;
      }
      paramContext = new StringBuilder();
      paramContext.append("Font resource ID #0x");
      paramContext.append(Integer.toHexString(paramInt1));
      paramContext.append(" could not be retrieved.");
      throw new Resources.NotFoundException(paramContext.toString());
    }
    return paramContext;
  }
  
  private static Typeface n(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, d paramd, Handler paramHandler, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramTypedValue.string;
    if (localObject != null)
    {
      localObject = ((CharSequence)localObject).toString();
      if (!((String)localObject).startsWith("res/"))
      {
        if (paramd != null) {
          paramd.a(-3, paramHandler);
        }
        return null;
      }
      paramTypedValue = q0.e.f(paramResources, paramInt1, paramInt2);
      if (paramTypedValue != null)
      {
        if (paramd != null) {
          paramd.b(paramTypedValue, paramHandler);
        }
        return paramTypedValue;
      }
      if (paramBoolean2) {
        return null;
      }
      try
      {
        if (((String)localObject).toLowerCase().endsWith(".xml"))
        {
          paramTypedValue = e.b(paramResources.getXml(paramInt1), paramResources);
          if (paramTypedValue == null)
          {
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (paramd == null) {
              break label328;
            }
            paramd.a(-3, paramHandler);
            return null;
          }
          return q0.e.c(paramContext, paramTypedValue, paramResources, paramInt1, paramInt2, paramd, paramHandler, paramBoolean1);
        }
        paramContext = q0.e.d(paramContext, paramResources, paramInt1, (String)localObject, paramInt2);
        if (paramd != null)
        {
          if (paramContext != null)
          {
            paramd.b(paramContext, paramHandler);
            return paramContext;
          }
          paramd.a(-3, paramHandler);
        }
        return paramContext;
      }
      catch (IOException paramContext)
      {
        paramResources = new StringBuilder();
        paramTypedValue = "Failed to read xml resource ";
      }
      catch (XmlPullParserException paramContext)
      {
        paramResources = new StringBuilder();
        paramTypedValue = "Failed to parse xml resource ";
      }
      paramResources.append(paramTypedValue);
      paramResources.append((String)localObject);
      Log.e("ResourcesCompat", paramResources.toString(), paramContext);
      if (paramd != null) {
        paramd.a(-3, paramHandler);
      }
      return null;
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append("Resource \"");
      paramContext.append(paramResources.getResourceName(paramInt1));
      paramContext.append("\" (");
      paramContext.append(Integer.toHexString(paramInt1));
      paramContext.append(") is not a Font: ");
      paramContext.append(paramTypedValue);
      throw new Resources.NotFoundException(paramContext.toString());
    }
    label328:
    return null;
  }
  
  static class a
  {
    static ColorStateList a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    {
      return paramResources.getColorStateList(paramInt, paramTheme);
    }
  }
  
  private static class b
  {
    final ColorStateList a;
    final Configuration b;
    
    b(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      this.a = paramColorStateList;
      this.b = paramConfiguration;
    }
  }
  
  private static final class c
  {
    final Resources a;
    final Resources.Theme b;
    
    c(Resources paramResources, Resources.Theme paramTheme)
    {
      this.a = paramResources;
      this.b = paramTheme;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (c.class != paramObject.getClass()) {
          return false;
        }
        paramObject = (c)paramObject;
        return (this.a.equals(paramObject.a)) && (x0.c.a(this.b, paramObject.b));
      }
      return false;
    }
    
    public int hashCode()
    {
      return x0.c.b(new Object[] { this.a, this.b });
    }
  }
  
  public static abstract class d
  {
    public static Handler c(Handler paramHandler)
    {
      Handler localHandler = paramHandler;
      if (paramHandler == null) {
        localHandler = new Handler(Looper.getMainLooper());
      }
      return localHandler;
    }
    
    public final void a(final int paramInt, Handler paramHandler)
    {
      c(paramHandler).post(new b(paramInt));
    }
    
    public final void b(final Typeface paramTypeface, Handler paramHandler)
    {
      c(paramHandler).post(new a(paramTypeface));
    }
    
    public abstract void d(int paramInt);
    
    public abstract void e(Typeface paramTypeface);
    
    class a
      implements Runnable
    {
      a(Typeface paramTypeface) {}
      
      public void run()
      {
        h.d.this.e(paramTypeface);
      }
    }
    
    class b
      implements Runnable
    {
      b(int paramInt) {}
      
      public void run()
      {
        h.d.this.d(paramInt);
      }
    }
  }
  
  public static final class e
  {
    public static void a(Resources.Theme paramTheme)
    {
      if (Build.VERSION.SDK_INT >= 29)
      {
        b.a(paramTheme);
        return;
      }
      a.a(paramTheme);
    }
    
    static class a
    {
      private static final Object a = new Object();
      private static Method b;
      private static boolean c;
      
      static void a(Resources.Theme paramTheme)
      {
        synchronized (a)
        {
          boolean bool = c;
          if (!bool)
          {
            try
            {
              Method localMethod1 = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
              b = localMethod1;
              localMethod1.setAccessible(true);
            }
            catch (NoSuchMethodException localNoSuchMethodException)
            {
              Log.i("ResourcesCompat", "Failed to retrieve rebase() method", localNoSuchMethodException);
            }
            c = true;
          }
          Method localMethod2 = b;
          if (localMethod2 != null)
          {
            try
            {
              localMethod2.invoke(paramTheme, new Object[0]);
            }
            catch (InvocationTargetException paramTheme) {}catch (IllegalAccessException paramTheme) {}
            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", paramTheme);
            b = null;
          }
          return;
        }
      }
    }
    
    static class b
    {
      static void a(Resources.Theme paramTheme)
      {
        paramTheme.rebase();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p0.h
 * JD-Core Version:    0.7.0.1
 */