package q0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import p0.e.b;
import v0.f.b;

public class h
  extends f
{
  protected final Class<?> g;
  protected final Constructor<?> h;
  protected final Method i;
  protected final Method j;
  protected final Method k;
  protected final Method l;
  protected final Method m;
  
  public h()
  {
    Object localObject9 = null;
    try
    {
      Class localClass = u();
      localObject3 = v(localClass);
      localObject4 = r(localClass);
      localObject5 = s(localClass);
      localObject6 = w(localClass);
      localObject7 = q(localClass);
      localObject2 = t(localClass);
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Unable to collect necessary methods for class ");
    ((StringBuilder)localObject2).append(localClassNotFoundException.getClass().getName());
    Log.e("TypefaceCompatApi26Impl", ((StringBuilder)localObject2).toString(), localClassNotFoundException);
    Object localObject8 = null;
    Object localObject1 = localObject8;
    localObject2 = localObject1;
    Object localObject3 = localObject2;
    Object localObject4 = localObject3;
    Object localObject7 = localObject4;
    Object localObject6 = localObject4;
    Object localObject5 = localObject3;
    localObject4 = localObject2;
    localObject3 = localObject1;
    localObject2 = localObject8;
    localObject1 = localObject9;
    this.g = localObject1;
    this.h = ((Constructor)localObject3);
    this.i = ((Method)localObject4);
    this.j = ((Method)localObject5);
    this.k = ((Method)localObject6);
    this.l = ((Method)localObject7);
    this.m = ((Method)localObject2);
  }
  
  private Object k()
  {
    try
    {
      Object localObject = this.h.newInstance(new Object[0]);
      return localObject;
    }
    catch (IllegalAccessException|InstantiationException|InvocationTargetException localIllegalAccessException)
    {
      label14:
      break label14;
    }
    return null;
  }
  
  private void l(Object paramObject)
  {
    try
    {
      this.l.invoke(paramObject, new Object[0]);
      return;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
  }
  
  private boolean m(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, FontVariationAxis[] paramArrayOfFontVariationAxis)
  {
    try
    {
      boolean bool = ((Boolean)this.i.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.FALSE, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramArrayOfFontVariationAxis })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramContext) {}
    return false;
  }
  
  private boolean n(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)this.j.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return false;
  }
  
  private boolean o(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)this.k.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return false;
  }
  
  private boolean p()
  {
    if (this.i == null) {
      Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
    }
    return this.i != null;
  }
  
  public Typeface a(Context paramContext, e.b paramb, Resources paramResources, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public Typeface b(Context paramContext, CancellationSignal paramCancellationSignal, f.b[] paramArrayOfb, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public Typeface d(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    if (!p()) {
      return super.d(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    paramResources = k();
    if (paramResources == null) {
      return null;
    }
    if (!m(paramContext, paramResources, paramString, 0, -1, -1, null))
    {
      l(paramResources);
      return null;
    }
    if (!o(paramResources)) {
      return null;
    }
    return h(paramResources);
  }
  
  protected Typeface h(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.g, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)this.m.invoke(null, new Object[] { localObject, Integer.valueOf(-1), Integer.valueOf(-1) });
      return paramObject;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return null;
  }
  
  protected Method q(Class<?> paramClass)
  {
    return paramClass.getMethod("abortCreation", new Class[0]);
  }
  
  protected Method r(Class<?> paramClass)
  {
    Class localClass = Integer.TYPE;
    return paramClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, localClass, Boolean.TYPE, localClass, localClass, localClass, [Landroid.graphics.fonts.FontVariationAxis.class });
  }
  
  protected Method s(Class<?> paramClass)
  {
    Class localClass = Integer.TYPE;
    return paramClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, localClass, [Landroid.graphics.fonts.FontVariationAxis.class, localClass, localClass });
  }
  
  protected Method t(Class<?> paramClass)
  {
    paramClass = Array.newInstance(paramClass, 1).getClass();
    Class localClass = Integer.TYPE;
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { paramClass, localClass, localClass });
    paramClass.setAccessible(true);
    return paramClass;
  }
  
  protected Class<?> u()
  {
    return Class.forName("android.graphics.FontFamily");
  }
  
  protected Constructor<?> v(Class<?> paramClass)
  {
    return paramClass.getConstructor(new Class[0]);
  }
  
  protected Method w(Class<?> paramClass)
  {
    return paramClass.getMethod("freeze", new Class[0]);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.h
 * JD-Core Version:    0.7.0.1
 */