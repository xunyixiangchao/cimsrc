package q0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.CustomFallbackBuilder;
import android.graphics.fonts.Font;
import android.graphics.fonts.Font.Builder;
import android.graphics.fonts.FontFamily.Builder;
import android.graphics.fonts.FontStyle;
import java.io.IOException;
import p0.e.b;
import p0.e.c;
import v0.f.b;

public class j
  extends k
{
  public Typeface a(Context paramContext, e.b paramb, Resources paramResources, int paramInt)
  {
    for (;;)
    {
      try
      {
        e.c[] arrayOfc = paramb.a();
        int m = arrayOfc.length;
        k = 0;
        paramContext = null;
        i = 0;
        j = 1;
        if (i < m) {
          paramb = arrayOfc[i];
        }
      }
      catch (Exception paramContext)
      {
        Font.Builder localBuilder;
        return null;
      }
      try
      {
        localBuilder = new Font.Builder(paramResources, paramb.b()).setWeight(paramb.e());
        if (!paramb.f()) {
          break label185;
        }
      }
      catch (IOException paramb)
      {
        continue;
        j = 0;
        continue;
        i = 400;
        j = k;
        if ((paramInt & 0x2) == 0) {
          continue;
        }
        j = 1;
        continue;
      }
      paramb = localBuilder.setSlant(j).setTtcIndex(paramb.c()).setFontVariationSettings(paramb.d()).build();
      if (paramContext == null)
      {
        paramb = new FontFamily.Builder(paramb);
        paramContext = paramb;
      }
      else
      {
        paramContext.addFont(paramb);
      }
      i += 1;
    }
    if (paramContext == null) {
      return null;
    }
    if ((paramInt & 0x1) != 0)
    {
      i = 700;
      break label196;
      paramb = new FontStyle(i, j);
      paramContext = new Typeface.CustomFallbackBuilder(paramContext.build()).setStyle(paramb).build();
      return paramContext;
    }
  }
  
  /* Error */
  public Typeface b(Context paramContext, android.os.CancellationSignal paramCancellationSignal, f.b[] paramArrayOfb, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 99	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 10
    //   6: aload_3
    //   7: arraylength
    //   8: istore 8
    //   10: iconst_0
    //   11: istore 7
    //   13: aconst_null
    //   14: astore_1
    //   15: iconst_0
    //   16: istore 5
    //   18: iconst_1
    //   19: istore 6
    //   21: iload 5
    //   23: iload 8
    //   25: if_icmpge +175 -> 200
    //   28: aload_3
    //   29: iload 5
    //   31: aaload
    //   32: astore 12
    //   34: aload_1
    //   35: astore 9
    //   37: aload 10
    //   39: aload 12
    //   41: invokevirtual 104	v0/f$b:d	()Landroid/net/Uri;
    //   44: ldc 106
    //   46: aload_2
    //   47: invokevirtual 112	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   50: astore 11
    //   52: aload 11
    //   54: ifnonnull +25 -> 79
    //   57: aload_1
    //   58: astore 9
    //   60: aload 11
    //   62: ifnull +126 -> 188
    //   65: aload_1
    //   66: astore 9
    //   68: aload 11
    //   70: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
    //   73: aload_1
    //   74: astore 9
    //   76: goto +112 -> 188
    //   79: new 22	android/graphics/fonts/Font$Builder
    //   82: dup
    //   83: aload 11
    //   85: invokespecial 120	android/graphics/fonts/Font$Builder:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   88: aload 12
    //   90: invokevirtual 121	v0/f$b:e	()I
    //   93: invokevirtual 38	android/graphics/fonts/Font$Builder:setWeight	(I)Landroid/graphics/fonts/Font$Builder;
    //   96: astore 9
    //   98: aload 12
    //   100: invokevirtual 122	v0/f$b:f	()Z
    //   103: ifeq +158 -> 261
    //   106: goto +3 -> 109
    //   109: aload 9
    //   111: iload 6
    //   113: invokevirtual 45	android/graphics/fonts/Font$Builder:setSlant	(I)Landroid/graphics/fonts/Font$Builder;
    //   116: aload 12
    //   118: invokevirtual 123	v0/f$b:c	()I
    //   121: invokevirtual 51	android/graphics/fonts/Font$Builder:setTtcIndex	(I)Landroid/graphics/fonts/Font$Builder;
    //   124: invokevirtual 63	android/graphics/fonts/Font$Builder:build	()Landroid/graphics/fonts/Font;
    //   127: astore 9
    //   129: aload_1
    //   130: ifnonnull +20 -> 150
    //   133: new 65	android/graphics/fonts/FontFamily$Builder
    //   136: dup
    //   137: aload 9
    //   139: invokespecial 68	android/graphics/fonts/FontFamily$Builder:<init>	(Landroid/graphics/fonts/Font;)V
    //   142: astore 9
    //   144: aload 9
    //   146: astore_1
    //   147: goto -82 -> 65
    //   150: aload_1
    //   151: aload 9
    //   153: invokevirtual 72	android/graphics/fonts/FontFamily$Builder:addFont	(Landroid/graphics/fonts/Font;)Landroid/graphics/fonts/FontFamily$Builder;
    //   156: pop
    //   157: goto -92 -> 65
    //   160: astore 12
    //   162: aload 11
    //   164: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
    //   167: goto +15 -> 182
    //   170: astore 11
    //   172: aload_1
    //   173: astore 9
    //   175: aload 12
    //   177: aload 11
    //   179: invokevirtual 129	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   182: aload_1
    //   183: astore 9
    //   185: aload 12
    //   187: athrow
    //   188: iload 5
    //   190: iconst_1
    //   191: iadd
    //   192: istore 5
    //   194: aload 9
    //   196: astore_1
    //   197: goto -179 -> 18
    //   200: aload_1
    //   201: ifnonnull +5 -> 206
    //   204: aconst_null
    //   205: areturn
    //   206: iload 4
    //   208: iconst_1
    //   209: iand
    //   210: ifeq +57 -> 267
    //   213: sipush 700
    //   216: istore 5
    //   218: goto +54 -> 272
    //   221: new 74	android/graphics/fonts/FontStyle
    //   224: dup
    //   225: iload 5
    //   227: iload 6
    //   229: invokespecial 77	android/graphics/fonts/FontStyle:<init>	(II)V
    //   232: astore_2
    //   233: new 79	android/graphics/Typeface$CustomFallbackBuilder
    //   236: dup
    //   237: aload_1
    //   238: invokevirtual 82	android/graphics/fonts/FontFamily$Builder:build	()Landroid/graphics/fonts/FontFamily;
    //   241: invokespecial 85	android/graphics/Typeface$CustomFallbackBuilder:<init>	(Landroid/graphics/fonts/FontFamily;)V
    //   244: aload_2
    //   245: invokevirtual 89	android/graphics/Typeface$CustomFallbackBuilder:setStyle	(Landroid/graphics/fonts/FontStyle;)Landroid/graphics/Typeface$CustomFallbackBuilder;
    //   248: invokevirtual 92	android/graphics/Typeface$CustomFallbackBuilder:build	()Landroid/graphics/Typeface;
    //   251: astore_1
    //   252: aload_1
    //   253: areturn
    //   254: astore_1
    //   255: aconst_null
    //   256: areturn
    //   257: astore_1
    //   258: goto -70 -> 188
    //   261: iconst_0
    //   262: istore 6
    //   264: goto -155 -> 109
    //   267: sipush 400
    //   270: istore 5
    //   272: iload 7
    //   274: istore 6
    //   276: iload 4
    //   278: iconst_2
    //   279: iand
    //   280: ifeq -59 -> 221
    //   283: iconst_1
    //   284: istore 6
    //   286: goto -65 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	j
    //   0	289	1	paramContext	Context
    //   0	289	2	paramCancellationSignal	android.os.CancellationSignal
    //   0	289	3	paramArrayOfb	f.b[]
    //   0	289	4	paramInt	int
    //   16	255	5	i	int
    //   19	266	6	j	int
    //   11	262	7	k	int
    //   8	18	8	m	int
    //   35	160	9	localObject1	java.lang.Object
    //   4	34	10	localContentResolver	android.content.ContentResolver
    //   50	113	11	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   170	8	11	localThrowable	java.lang.Throwable
    //   32	85	12	localb	f.b
    //   160	26	12	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   79	106	160	finally
    //   109	129	160	finally
    //   133	144	160	finally
    //   150	157	160	finally
    //   162	167	170	finally
    //   6	10	254	java/lang/Exception
    //   37	52	254	java/lang/Exception
    //   68	73	254	java/lang/Exception
    //   175	182	254	java/lang/Exception
    //   185	188	254	java/lang/Exception
    //   221	252	254	java/lang/Exception
    //   37	52	257	java/io/IOException
    //   68	73	257	java/io/IOException
    //   175	182	257	java/io/IOException
    //   185	188	257	java/io/IOException
  }
  
  public Typeface d(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      paramContext = new Font.Builder(paramResources, paramInt1).build();
      paramContext = new Typeface.CustomFallbackBuilder(new FontFamily.Builder(paramContext).build()).setStyle(paramContext.getStyle()).build();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label44:
      break label44;
    }
    return null;
  }
  
  protected f.b f(f.b[] paramArrayOfb, int paramInt)
  {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.j
 * JD-Core Version:    0.7.0.1
 */