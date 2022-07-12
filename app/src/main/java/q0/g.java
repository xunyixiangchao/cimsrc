package q0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import p0.e.b;
import p0.e.c;
import v0.f.b;

class g
  extends k
{
  private static final Class<?> b;
  private static final Constructor<?> c;
  private static final Method d;
  private static final Method e;
  
  static
  {
    Object localObject2 = null;
    try
    {
      localClass2 = Class.forName("android.graphics.FontFamily");
      Constructor localConstructor = localClass2.getConstructor(new Class[0]);
      Object localObject1 = Integer.TYPE;
      localObject3 = localClass2.getMethod("addFontWeightStyle", new Class[] { ByteBuffer.class, localObject1, List.class, localObject1, Boolean.TYPE });
      localObject1 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass2, 1).getClass() });
      localObject2 = localConstructor;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Log.e("TypefaceCompatApi24Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
    Class localClass2 = null;
    Class localClass1 = localClass2;
    Object localObject3 = localClass1;
    c = localObject2;
    b = localClass2;
    d = (Method)localObject3;
    e = localClass1;
  }
  
  private static boolean g(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      paramBoolean = ((Boolean)d.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return false;
  }
  
  private static Typeface h(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(b, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)e.invoke(null, new Object[] { localObject });
      return paramObject;
    }
    catch (IllegalAccessException|InvocationTargetException paramObject) {}
    return null;
  }
  
  public static boolean i()
  {
    Method localMethod = d;
    if (localMethod == null) {
      Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
    }
    return localMethod != null;
  }
  
  private static Object j()
  {
    try
    {
      Object localObject = c.newInstance(new Object[0]);
      return localObject;
    }
    catch (IllegalAccessException|InstantiationException|InvocationTargetException localIllegalAccessException)
    {
      label13:
      break label13;
    }
    return null;
  }
  
  public Typeface a(Context paramContext, e.b paramb, Resources paramResources, int paramInt)
  {
    Object localObject1 = j();
    if (localObject1 == null) {
      return null;
    }
    paramb = paramb.a();
    int i = paramb.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject2 = paramb[paramInt];
      ByteBuffer localByteBuffer = l.b(paramContext, paramResources, localObject2.b());
      if (localByteBuffer == null) {
        return null;
      }
      if (!g(localObject1, localByteBuffer, localObject2.c(), localObject2.e(), localObject2.f())) {
        return null;
      }
      paramInt += 1;
    }
    return h(localObject1);
  }
  
  public Typeface b(Context paramContext, CancellationSignal paramCancellationSignal, f.b[] paramArrayOfb, int paramInt)
  {
    Object localObject = j();
    if (localObject == null) {
      return null;
    }
    g0.g localg = new g0.g();
    int j = paramArrayOfb.length;
    int i = 0;
    while (i < j)
    {
      f.b localb = paramArrayOfb[i];
      Uri localUri = localb.d();
      ByteBuffer localByteBuffer2 = (ByteBuffer)localg.get(localUri);
      ByteBuffer localByteBuffer1 = localByteBuffer2;
      if (localByteBuffer2 == null)
      {
        localByteBuffer1 = l.f(paramContext, paramCancellationSignal, localUri);
        localg.put(localUri, localByteBuffer1);
      }
      if (localByteBuffer1 == null) {
        return null;
      }
      if (!g(localObject, localByteBuffer1, localb.c(), localb.e(), localb.f())) {
        return null;
      }
      i += 1;
    }
    paramContext = h(localObject);
    if (paramContext == null) {
      return null;
    }
    return Typeface.create(paramContext, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.g
 * JD-Core Version:    0.7.0.1
 */