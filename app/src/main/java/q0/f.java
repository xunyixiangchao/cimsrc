package q0;

import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class f
  extends k
{
  private static Class<?> b;
  private static Constructor<?> c;
  private static Method d;
  private static Method e;
  private static boolean f = false;
  
  private static boolean g(Object paramObject, String paramString, int paramInt, boolean paramBoolean)
  {
    
    try
    {
      paramBoolean = ((Boolean)d.invoke(paramObject, new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
    }
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
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
    catch (InvocationTargetException paramObject) {}catch (IllegalAccessException paramObject) {}
    throw new RuntimeException(paramObject);
  }
  
  private File i(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/proc/self/fd/");
      localStringBuilder.append(paramParcelFileDescriptor.getFd());
      paramParcelFileDescriptor = Os.readlink(localStringBuilder.toString());
      if (OsConstants.S_ISREG(Os.stat(paramParcelFileDescriptor).st_mode))
      {
        paramParcelFileDescriptor = new File(paramParcelFileDescriptor);
        return paramParcelFileDescriptor;
      }
      return null;
    }
    catch (ErrnoException paramParcelFileDescriptor) {}
    return null;
  }
  
  private static void j()
  {
    if (f) {
      return;
    }
    f = true;
    Object localObject4 = null;
    try
    {
      localObject2 = Class.forName("android.graphics.FontFamily");
      Constructor localConstructor = ((Class)localObject2).getConstructor(new Class[0]);
      localObject3 = ((Class)localObject2).getMethod("addFontWeightStyle", new Class[] { String.class, Integer.TYPE, Boolean.TYPE });
      localMethod = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance((Class)localObject2, 1).getClass() });
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    Log.e("TypefaceCompatApi21Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
    Method localMethod = null;
    Object localObject1 = localMethod;
    Object localObject3 = localObject1;
    Object localObject2 = localObject1;
    localObject1 = localObject4;
    c = localObject1;
    b = (Class)localObject2;
    d = (Method)localObject3;
    e = localMethod;
  }
  
  private static Object k()
  {
    
    try
    {
      Object localObject = c.newInstance(new Object[0]);
      return localObject;
    }
    catch (InvocationTargetException localInvocationTargetException) {}catch (InstantiationException localInstantiationException) {}catch (IllegalAccessException localIllegalAccessException) {}
    throw new RuntimeException(localIllegalAccessException);
  }
  
  /* Error */
  public Typeface a(android.content.Context paramContext, p0.e.b paramb, android.content.res.Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 193	q0/f:k	()Ljava/lang/Object;
    //   3: astore 7
    //   5: aload_2
    //   6: invokevirtual 198	p0/e$b:a	()[Lp0/e$c;
    //   9: astore 8
    //   11: aload 8
    //   13: arraylength
    //   14: istore 5
    //   16: iconst_0
    //   17: istore 4
    //   19: iload 4
    //   21: iload 5
    //   23: if_icmpge +102 -> 125
    //   26: aload 8
    //   28: iload 4
    //   30: aaload
    //   31: astore 9
    //   33: aload_1
    //   34: invokestatic 203	q0/l:e	(Landroid/content/Context;)Ljava/io/File;
    //   37: astore_2
    //   38: aload_2
    //   39: ifnonnull +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: aload_2
    //   45: aload_3
    //   46: aload 9
    //   48: invokevirtual 207	p0/e$c:b	()I
    //   51: invokestatic 210	q0/l:c	(Ljava/io/File;Landroid/content/res/Resources;I)Z
    //   54: istore 6
    //   56: iload 6
    //   58: ifne +10 -> 68
    //   61: aload_2
    //   62: invokevirtual 213	java/io/File:delete	()Z
    //   65: pop
    //   66: aconst_null
    //   67: areturn
    //   68: aload 7
    //   70: aload_2
    //   71: invokevirtual 216	java/io/File:getPath	()Ljava/lang/String;
    //   74: aload 9
    //   76: invokevirtual 218	p0/e$c:e	()I
    //   79: aload 9
    //   81: invokevirtual 220	p0/e$c:f	()Z
    //   84: invokestatic 222	q0/f:g	(Ljava/lang/Object;Ljava/lang/String;IZ)Z
    //   87: istore 6
    //   89: aload_2
    //   90: invokevirtual 213	java/io/File:delete	()Z
    //   93: pop
    //   94: iload 6
    //   96: ifne +5 -> 101
    //   99: aconst_null
    //   100: areturn
    //   101: iload 4
    //   103: iconst_1
    //   104: iadd
    //   105: istore 4
    //   107: goto -88 -> 19
    //   110: astore_1
    //   111: aload_2
    //   112: invokevirtual 213	java/io/File:delete	()Z
    //   115: pop
    //   116: aload_1
    //   117: athrow
    //   118: aload_2
    //   119: invokevirtual 213	java/io/File:delete	()Z
    //   122: pop
    //   123: aconst_null
    //   124: areturn
    //   125: aload 7
    //   127: invokestatic 224	q0/f:h	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   130: areturn
    //   131: astore_1
    //   132: goto -14 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	f
    //   0	135	1	paramContext	android.content.Context
    //   0	135	2	paramb	p0.e.b
    //   0	135	3	paramResources	android.content.res.Resources
    //   0	135	4	paramInt	int
    //   14	10	5	i	int
    //   54	41	6	bool	boolean
    //   3	123	7	localObject	Object
    //   9	18	8	arrayOfc	p0.e.c[]
    //   31	49	9	localc	p0.e.c
    // Exception table:
    //   from	to	target	type
    //   44	56	110	finally
    //   68	89	110	finally
    //   44	56	131	java/lang/RuntimeException
    //   68	89	131	java/lang/RuntimeException
  }
  
  /* Error */
  public Typeface b(android.content.Context paramContext, android.os.CancellationSignal paramCancellationSignal, v0.f.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: aload_3
    //   10: iload 4
    //   12: invokevirtual 230	q0/k:f	([Lv0/f$b;I)Lv0/f$b;
    //   15: astore_3
    //   16: aload_1
    //   17: invokevirtual 236	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 5
    //   22: aload 5
    //   24: aload_3
    //   25: invokevirtual 241	v0/f$b:d	()Landroid/net/Uri;
    //   28: ldc 243
    //   30: aload_2
    //   31: invokevirtual 249	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnonnull +13 -> 49
    //   39: aload_2
    //   40: ifnull +7 -> 47
    //   43: aload_2
    //   44: invokevirtual 252	android/os/ParcelFileDescriptor:close	()V
    //   47: aconst_null
    //   48: areturn
    //   49: aload_0
    //   50: aload_2
    //   51: invokespecial 254	q0/f:i	(Landroid/os/ParcelFileDescriptor;)Ljava/io/File;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull +24 -> 80
    //   59: aload_3
    //   60: invokevirtual 257	java/io/File:canRead	()Z
    //   63: ifne +6 -> 69
    //   66: goto +14 -> 80
    //   69: aload_3
    //   70: invokestatic 261	android/graphics/Typeface:createFromFile	(Ljava/io/File;)Landroid/graphics/Typeface;
    //   73: astore_1
    //   74: aload_2
    //   75: invokevirtual 252	android/os/ParcelFileDescriptor:close	()V
    //   78: aload_1
    //   79: areturn
    //   80: new 263	java/io/FileInputStream
    //   83: dup
    //   84: aload_2
    //   85: invokevirtual 267	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   88: invokespecial 270	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   91: astore_3
    //   92: aload_0
    //   93: aload_1
    //   94: aload_3
    //   95: invokespecial 273	q0/k:c	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   98: astore_1
    //   99: aload_3
    //   100: invokevirtual 274	java/io/FileInputStream:close	()V
    //   103: aload_2
    //   104: invokevirtual 252	android/os/ParcelFileDescriptor:close	()V
    //   107: aload_1
    //   108: areturn
    //   109: astore_1
    //   110: aload_3
    //   111: invokevirtual 274	java/io/FileInputStream:close	()V
    //   114: goto +9 -> 123
    //   117: astore_3
    //   118: aload_1
    //   119: aload_3
    //   120: invokevirtual 279	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_2
    //   127: invokevirtual 252	android/os/ParcelFileDescriptor:close	()V
    //   130: goto +9 -> 139
    //   133: astore_2
    //   134: aload_1
    //   135: aload_2
    //   136: invokevirtual 279	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   139: aload_1
    //   140: athrow
    //   141: astore_1
    //   142: aconst_null
    //   143: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	f
    //   0	144	1	paramContext	android.content.Context
    //   0	144	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	144	3	paramArrayOfb	v0.f.b[]
    //   0	144	4	paramInt	int
    //   20	3	5	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   92	99	109	finally
    //   110	114	117	finally
    //   49	55	125	finally
    //   59	66	125	finally
    //   69	74	125	finally
    //   80	92	125	finally
    //   99	103	125	finally
    //   118	123	125	finally
    //   123	125	125	finally
    //   126	130	133	finally
    //   22	35	141	java/io/IOException
    //   43	47	141	java/io/IOException
    //   74	78	141	java/io/IOException
    //   103	107	141	java/io/IOException
    //   134	139	141	java/io/IOException
    //   139	141	141	java/io/IOException
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.f
 * JD-Core Version:    0.7.0.1
 */