package n8;

public class b
{
  /* Error */
  public static android.graphics.Bitmap a(android.content.Context paramContext, android.graphics.Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokestatic 12	android/renderscript/RenderScript:create	(Landroid/content/Context;)Landroid/renderscript/RenderScript;
    //   10: astore 4
    //   12: aload 4
    //   14: new 14	android/renderscript/RenderScript$RSMessageHandler
    //   17: dup
    //   18: invokespecial 18	android/renderscript/RenderScript$RSMessageHandler:<init>	()V
    //   21: invokevirtual 22	android/renderscript/RenderScript:setMessageHandler	(Landroid/renderscript/RenderScript$RSMessageHandler;)V
    //   24: aload 4
    //   26: aload_1
    //   27: getstatic 28	android/renderscript/Allocation$MipmapControl:MIPMAP_NONE	Landroid/renderscript/Allocation$MipmapControl;
    //   30: iconst_1
    //   31: invokestatic 34	android/renderscript/Allocation:createFromBitmap	(Landroid/renderscript/RenderScript;Landroid/graphics/Bitmap;Landroid/renderscript/Allocation$MipmapControl;I)Landroid/renderscript/Allocation;
    //   34: astore_3
    //   35: aload 4
    //   37: aload_3
    //   38: invokevirtual 38	android/renderscript/Allocation:getType	()Landroid/renderscript/Type;
    //   41: invokestatic 42	android/renderscript/Allocation:createTyped	(Landroid/renderscript/RenderScript;Landroid/renderscript/Type;)Landroid/renderscript/Allocation;
    //   44: astore 6
    //   46: aload 5
    //   48: astore_0
    //   49: aload 4
    //   51: aload 4
    //   53: invokestatic 48	android/renderscript/Element:U8_4	(Landroid/renderscript/RenderScript;)Landroid/renderscript/Element;
    //   56: invokestatic 53	android/renderscript/ScriptIntrinsicBlur:create	(Landroid/renderscript/RenderScript;Landroid/renderscript/Element;)Landroid/renderscript/ScriptIntrinsicBlur;
    //   59: astore 5
    //   61: aload 5
    //   63: astore_0
    //   64: aload 5
    //   66: aload_3
    //   67: invokevirtual 57	android/renderscript/ScriptIntrinsicBlur:setInput	(Landroid/renderscript/Allocation;)V
    //   70: aload 5
    //   72: astore_0
    //   73: aload 5
    //   75: iload_2
    //   76: i2f
    //   77: invokevirtual 61	android/renderscript/ScriptIntrinsicBlur:setRadius	(F)V
    //   80: aload 5
    //   82: astore_0
    //   83: aload 5
    //   85: aload 6
    //   87: invokevirtual 64	android/renderscript/ScriptIntrinsicBlur:forEach	(Landroid/renderscript/Allocation;)V
    //   90: aload 5
    //   92: astore_0
    //   93: aload 6
    //   95: aload_1
    //   96: invokevirtual 68	android/renderscript/Allocation:copyTo	(Landroid/graphics/Bitmap;)V
    //   99: invokestatic 71	android/renderscript/RenderScript:releaseAllContexts	()V
    //   102: aload_3
    //   103: invokevirtual 74	android/renderscript/Allocation:destroy	()V
    //   106: aload 6
    //   108: invokevirtual 74	android/renderscript/Allocation:destroy	()V
    //   111: aload 5
    //   113: invokevirtual 75	android/renderscript/ScriptIntrinsicBlur:destroy	()V
    //   116: aload_1
    //   117: areturn
    //   118: astore 7
    //   120: aload_0
    //   121: astore 5
    //   123: aload 4
    //   125: astore_0
    //   126: aload_3
    //   127: astore_1
    //   128: aload 6
    //   130: astore 4
    //   132: aload 7
    //   134: astore_3
    //   135: goto +47 -> 182
    //   138: astore_0
    //   139: aload_3
    //   140: astore_1
    //   141: aload_0
    //   142: astore_3
    //   143: goto +6 -> 149
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_1
    //   149: aconst_null
    //   150: astore 5
    //   152: aload 4
    //   154: astore_0
    //   155: aconst_null
    //   156: astore 6
    //   158: aload 5
    //   160: astore 4
    //   162: aload 6
    //   164: astore 5
    //   166: goto +16 -> 182
    //   169: astore_3
    //   170: aconst_null
    //   171: astore 5
    //   173: aload 5
    //   175: astore_1
    //   176: aload_1
    //   177: astore 4
    //   179: aload 6
    //   181: astore_0
    //   182: aload_0
    //   183: ifnull +6 -> 189
    //   186: invokestatic 71	android/renderscript/RenderScript:releaseAllContexts	()V
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 74	android/renderscript/Allocation:destroy	()V
    //   197: aload 4
    //   199: ifnull +8 -> 207
    //   202: aload 4
    //   204: invokevirtual 74	android/renderscript/Allocation:destroy	()V
    //   207: aload 5
    //   209: ifnull +8 -> 217
    //   212: aload 5
    //   214: invokevirtual 75	android/renderscript/ScriptIntrinsicBlur:destroy	()V
    //   217: aload_3
    //   218: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramContext	android.content.Context
    //   0	219	1	paramBitmap	android.graphics.Bitmap
    //   0	219	2	paramInt	int
    //   34	109	3	localObject1	Object
    //   146	1	3	localObject2	Object
    //   169	49	3	localObject3	Object
    //   10	193	4	localObject4	Object
    //   4	209	5	localObject5	Object
    //   1	179	6	localAllocation	android.renderscript.Allocation
    //   118	15	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   49	61	118	finally
    //   64	70	118	finally
    //   73	80	118	finally
    //   83	90	118	finally
    //   93	99	118	finally
    //   35	46	138	finally
    //   12	35	146	finally
    //   6	12	169	finally
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     n8.b
 * JD-Core Version:    0.7.0.1
 */