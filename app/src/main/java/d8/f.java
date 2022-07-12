package d8;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class f
  implements m
{
  private static final Camera.PreviewCallback b = new a();
  private Context a;
  
  f(Context paramContext)
  {
    this.a = paramContext;
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: invokestatic 31	android/hardware/Camera:open	()Landroid/hardware/Camera;
    //   3: astore_2
    //   4: aload_2
    //   5: aload_2
    //   6: invokevirtual 35	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   9: invokevirtual 39	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   12: aload_2
    //   13: getstatic 19	d8/f:b	Landroid/hardware/Camera$PreviewCallback;
    //   16: invokevirtual 43	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   19: aload_2
    //   20: invokevirtual 46	android/hardware/Camera:startPreview	()V
    //   23: aload_2
    //   24: invokevirtual 49	android/hardware/Camera:stopPreview	()V
    //   27: aload_2
    //   28: aconst_null
    //   29: invokevirtual 43	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   32: aload_2
    //   33: invokevirtual 52	android/hardware/Camera:release	()V
    //   36: iconst_1
    //   37: ireturn
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 24	d8/f:a	Landroid/content/Context;
    //   44: invokevirtual 58	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   47: ldc 60
    //   49: invokevirtual 66	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   52: istore_1
    //   53: aload_2
    //   54: ifnull +16 -> 70
    //   57: aload_2
    //   58: invokevirtual 49	android/hardware/Camera:stopPreview	()V
    //   61: aload_2
    //   62: aconst_null
    //   63: invokevirtual 43	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   66: aload_2
    //   67: invokevirtual 52	android/hardware/Camera:release	()V
    //   70: iconst_1
    //   71: iload_1
    //   72: ixor
    //   73: ireturn
    //   74: astore_3
    //   75: aload_2
    //   76: ifnull +16 -> 92
    //   79: aload_2
    //   80: invokevirtual 49	android/hardware/Camera:stopPreview	()V
    //   83: aload_2
    //   84: aconst_null
    //   85: invokevirtual 43	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   88: aload_2
    //   89: invokevirtual 52	android/hardware/Camera:release	()V
    //   92: aload_3
    //   93: athrow
    //   94: astore_2
    //   95: goto -57 -> 38
    //   98: astore_3
    //   99: goto -59 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	f
    //   52	21	1	bool	boolean
    //   3	86	2	localCamera	Camera
    //   94	1	2	localObject1	Object
    //   74	19	3	localObject2	Object
    //   98	1	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   40	53	74	finally
    //   0	4	94	finally
    //   4	23	98	finally
  }
  
  static final class a
    implements Camera.PreviewCallback
  {
    public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.f
 * JD-Core Version:    0.7.0.1
 */