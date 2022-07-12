package org.webrtc;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camera1Enumerator
  implements CameraEnumerator
{
  private static final String TAG = "Camera1Enumerator";
  private static List<List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
  private final boolean captureToTexture;
  
  public Camera1Enumerator()
  {
    this(true);
  }
  
  public Camera1Enumerator(boolean paramBoolean)
  {
    this.captureToTexture = paramBoolean;
  }
  
  static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(List<int[]> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      int[] arrayOfInt = (int[])paramList.next();
      localArrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(arrayOfInt[0], arrayOfInt[1]));
    }
    return localArrayList;
  }
  
  static List<Size> convertSizes(List<Camera.Size> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Camera.Size localSize = (Camera.Size)paramList.next();
      localArrayList.add(new Size(localSize.width, localSize.height));
    }
    return localArrayList;
  }
  
  /* Error */
  private static List<CameraEnumerationAndroid.CaptureFormat> enumerateFormats(int paramInt)
  {
    // Byte code:
    //   0: new 81	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc 84
    //   13: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 7
    //   19: iload_0
    //   20: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 7
    //   26: ldc 93
    //   28: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: ldc 10
    //   34: aload 7
    //   36: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 103	org/webrtc/Logging:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: invokestatic 109	android/os/SystemClock:elapsedRealtime	()J
    //   45: lstore_3
    //   46: aconst_null
    //   47: astore 10
    //   49: aconst_null
    //   50: astore 9
    //   52: aload 9
    //   54: astore 7
    //   56: aload 10
    //   58: astore 8
    //   60: new 81	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   67: astore 11
    //   69: aload 9
    //   71: astore 7
    //   73: aload 10
    //   75: astore 8
    //   77: aload 11
    //   79: ldc 111
    //   81: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 9
    //   87: astore 7
    //   89: aload 10
    //   91: astore 8
    //   93: aload 11
    //   95: iload_0
    //   96: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 9
    //   102: astore 7
    //   104: aload 10
    //   106: astore 8
    //   108: ldc 10
    //   110: aload 11
    //   112: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 103	org/webrtc/Logging:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload 9
    //   120: astore 7
    //   122: aload 10
    //   124: astore 8
    //   126: iload_0
    //   127: invokestatic 117	android/hardware/Camera:open	(I)Landroid/hardware/Camera;
    //   130: astore 9
    //   132: aload 9
    //   134: astore 7
    //   136: aload 9
    //   138: astore 8
    //   140: aload 9
    //   142: invokevirtual 121	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   145: astore 10
    //   147: aload 9
    //   149: invokevirtual 124	android/hardware/Camera:release	()V
    //   152: new 29	java/util/ArrayList
    //   155: dup
    //   156: invokespecial 30	java/util/ArrayList:<init>	()V
    //   159: astore 7
    //   161: aload 10
    //   163: invokevirtual 130	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   166: astore 8
    //   168: iconst_0
    //   169: istore_2
    //   170: aload 8
    //   172: ifnull +305 -> 477
    //   175: aload 8
    //   177: aload 8
    //   179: invokeinterface 134 1 0
    //   184: iconst_1
    //   185: isub
    //   186: invokeinterface 138 2 0
    //   191: checkcast 48	[I
    //   194: astore 8
    //   196: aload 8
    //   198: iconst_0
    //   199: iaload
    //   200: istore_2
    //   201: aload 8
    //   203: iconst_1
    //   204: iaload
    //   205: istore_1
    //   206: goto +3 -> 209
    //   209: aload 10
    //   211: invokevirtual 141	android/hardware/Camera$Parameters:getSupportedPreviewSizes	()Ljava/util/List;
    //   214: invokeinterface 36 1 0
    //   219: astore 8
    //   221: aload 8
    //   223: invokeinterface 42 1 0
    //   228: ifeq +83 -> 311
    //   231: aload 8
    //   233: invokeinterface 46 1 0
    //   238: checkcast 62	android/hardware/Camera$Size
    //   241: astore 9
    //   243: aload 7
    //   245: new 143	org/webrtc/CameraEnumerationAndroid$CaptureFormat
    //   248: dup
    //   249: aload 9
    //   251: getfield 68	android/hardware/Camera$Size:width	I
    //   254: aload 9
    //   256: getfield 71	android/hardware/Camera$Size:height	I
    //   259: iload_2
    //   260: iload_1
    //   261: invokespecial 146	org/webrtc/CameraEnumerationAndroid$CaptureFormat:<init>	(IIII)V
    //   264: invokeinterface 57 2 0
    //   269: pop
    //   270: goto -49 -> 221
    //   273: astore 8
    //   275: new 81	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   282: astore 9
    //   284: aload 9
    //   286: ldc 148
    //   288: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 9
    //   294: iload_0
    //   295: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: ldc 10
    //   301: aload 9
    //   303: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload 8
    //   308: invokestatic 152	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   311: invokestatic 109	android/os/SystemClock:elapsedRealtime	()J
    //   314: lstore 5
    //   316: new 81	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   323: astore 8
    //   325: aload 8
    //   327: ldc 84
    //   329: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 8
    //   335: iload_0
    //   336: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 8
    //   342: ldc 154
    //   344: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 8
    //   350: lload 5
    //   352: lload_3
    //   353: lsub
    //   354: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 8
    //   360: ldc 159
    //   362: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: pop
    //   366: ldc 10
    //   368: aload 8
    //   370: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 103	org/webrtc/Logging:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: aload 7
    //   378: areturn
    //   379: astore 8
    //   381: goto +83 -> 464
    //   384: astore 9
    //   386: aload 8
    //   388: astore 7
    //   390: new 81	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   397: astore 10
    //   399: aload 8
    //   401: astore 7
    //   403: aload 10
    //   405: ldc 161
    //   407: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 8
    //   413: astore 7
    //   415: aload 10
    //   417: iload_0
    //   418: invokevirtual 91	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 8
    //   424: astore 7
    //   426: ldc 10
    //   428: aload 10
    //   430: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: aload 9
    //   435: invokestatic 152	org/webrtc/Logging:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   438: aload 8
    //   440: astore 7
    //   442: new 29	java/util/ArrayList
    //   445: dup
    //   446: invokespecial 30	java/util/ArrayList:<init>	()V
    //   449: astore 9
    //   451: aload 8
    //   453: ifnull +8 -> 461
    //   456: aload 8
    //   458: invokevirtual 124	android/hardware/Camera:release	()V
    //   461: aload 9
    //   463: areturn
    //   464: aload 7
    //   466: ifnull +8 -> 474
    //   469: aload 7
    //   471: invokevirtual 124	android/hardware/Camera:release	()V
    //   474: aload 8
    //   476: athrow
    //   477: iconst_0
    //   478: istore_1
    //   479: goto -270 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	paramInt	int
    //   205	274	1	i	int
    //   169	91	2	j	int
    //   45	308	3	l1	long
    //   314	37	5	l2	long
    //   7	463	7	localObject1	Object
    //   58	174	8	localObject2	Object
    //   273	34	8	localException	Exception
    //   323	46	8	localStringBuilder1	StringBuilder
    //   379	96	8	localObject3	Object
    //   50	252	9	localObject4	Object
    //   384	50	9	localRuntimeException	java.lang.RuntimeException
    //   449	13	9	localArrayList	ArrayList
    //   47	382	10	localObject5	Object
    //   67	44	11	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   161	168	273	java/lang/Exception
    //   175	196	273	java/lang/Exception
    //   209	221	273	java/lang/Exception
    //   221	270	273	java/lang/Exception
    //   60	69	379	finally
    //   77	85	379	finally
    //   93	100	379	finally
    //   108	118	379	finally
    //   126	132	379	finally
    //   140	147	379	finally
    //   390	399	379	finally
    //   403	411	379	finally
    //   415	422	379	finally
    //   426	438	379	finally
    //   442	451	379	finally
    //   60	69	384	java/lang/RuntimeException
    //   77	85	384	java/lang/RuntimeException
    //   93	100	384	java/lang/RuntimeException
    //   108	118	384	java/lang/RuntimeException
    //   126	132	384	java/lang/RuntimeException
    //   140	147	384	java/lang/RuntimeException
  }
  
  static int getCameraIndex(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCameraIndex: ");
    localStringBuilder.append(paramString);
    Logging.d("Camera1Enumerator", localStringBuilder.toString());
    int i = 0;
    while (i < Camera.getNumberOfCameras())
    {
      if (paramString.equals(getDeviceName(i))) {
        return i;
      }
      i += 1;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("No such camera: ");
    localStringBuilder.append(paramString);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static Camera.CameraInfo getCameraInfo(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    try
    {
      Camera.getCameraInfo(paramInt, localCameraInfo);
      return localCameraInfo;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCameraInfo failed on index ");
      localStringBuilder.append(paramInt);
      Logging.e("Camera1Enumerator", localStringBuilder.toString(), localException);
    }
    return null;
  }
  
  static String getDeviceName(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = getCameraInfo(paramInt);
    if (localCameraInfo == null) {
      return null;
    }
    String str;
    if (localCameraInfo.facing == 1) {
      str = "front";
    } else {
      str = "back";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Camera ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", Facing ");
    localStringBuilder.append(str);
    localStringBuilder.append(", Orientation ");
    localStringBuilder.append(localCameraInfo.orientation);
    return localStringBuilder.toString();
  }
  
  static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int paramInt)
  {
    try
    {
      if (cachedSupportedFormats == null)
      {
        cachedSupportedFormats = new ArrayList();
        int i = 0;
        while (i < Camera.getNumberOfCameras())
        {
          cachedSupportedFormats.add(enumerateFormats(i));
          i += 1;
        }
      }
      List localList = (List)cachedSupportedFormats.get(paramInt);
      return localList;
    }
    finally {}
  }
  
  public CameraVideoCapturer createCapturer(String paramString, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler)
  {
    return new Camera1Capturer(paramString, paramCameraEventsHandler, this.captureToTexture);
  }
  
  public String[] getDeviceNames()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < Camera.getNumberOfCameras())
    {
      Object localObject = getDeviceName(i);
      if (localObject != null)
      {
        localArrayList.add(localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Index: ");
        localStringBuilder.append(i);
        localStringBuilder.append(". ");
        localStringBuilder.append((String)localObject);
        Logging.d("Camera1Enumerator", localStringBuilder.toString());
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Index: ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(". Failed to query camera name.");
        Logging.e("Camera1Enumerator", ((StringBuilder)localObject).toString());
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String paramString)
  {
    return getSupportedFormats(getCameraIndex(paramString));
  }
  
  public boolean isBackFacing(String paramString)
  {
    paramString = getCameraInfo(getCameraIndex(paramString));
    return (paramString != null) && (paramString.facing == 0);
  }
  
  public boolean isFrontFacing(String paramString)
  {
    paramString = getCameraInfo(getCameraIndex(paramString));
    return (paramString != null) && (paramString.facing == 1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.Camera1Enumerator
 * JD-Core Version:    0.7.0.1
 */