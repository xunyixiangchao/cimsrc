package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.SystemClock;
import android.util.AndroidException;
import android.util.Range;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(21)
public class Camera2Enumerator
  implements CameraEnumerator
{
  private static final double NANO_SECONDS_PER_SECOND = 1000000000.0D;
  private static final String TAG = "Camera2Enumerator";
  private static final Map<String, List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats = new HashMap();
  final CameraManager cameraManager;
  final Context context;
  
  public Camera2Enumerator(Context paramContext)
  {
    this.context = paramContext;
    this.cameraManager = ((CameraManager)paramContext.getSystemService("camera"));
  }
  
  static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(Range<Integer>[] paramArrayOfRange, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfRange.length;
    int i = 0;
    while (i < j)
    {
      Range<Integer> localRange = paramArrayOfRange[i];
      localArrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(((Integer)localRange.getLower()).intValue() * paramInt, ((Integer)localRange.getUpper()).intValue() * paramInt));
      i += 1;
    }
    return localArrayList;
  }
  
  private static List<Size> convertSizes(android.util.Size[] paramArrayOfSize)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfSize.length;
    int i = 0;
    while (i < j)
    {
      android.util.Size localSize = paramArrayOfSize[i];
      localArrayList.add(new Size(localSize.getWidth(), localSize.getHeight()));
      i += 1;
    }
    return localArrayList;
  }
  
  private CameraCharacteristics getCameraCharacteristics(String paramString)
  {
    try
    {
      paramString = this.cameraManager.getCameraCharacteristics(paramString);
      return paramString;
    }
    catch (AndroidException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Camera access exception: ");
      localStringBuilder.append(paramString);
      Logging.e("Camera2Enumerator", localStringBuilder.toString());
    }
    return null;
  }
  
  static int getFpsUnitFactor(Range<Integer>[] paramArrayOfRange)
  {
    if (paramArrayOfRange.length == 0) {
      return 1000;
    }
    if (((Integer)paramArrayOfRange[0].getUpper()).intValue() < 1000) {
      return 1000;
    }
    return 1;
  }
  
  static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(Context paramContext, String paramString)
  {
    return getSupportedFormats((CameraManager)paramContext.getSystemService("camera"), paramString);
  }
  
  static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(CameraManager paramCameraManager, String paramString)
  {
    synchronized (cachedSupportedFormats)
    {
      if (???.containsKey(paramString))
      {
        paramCameraManager = (List)???.get(paramString);
        return paramCameraManager;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Get supported formats for camera index ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(".");
      Logging.d("Camera2Enumerator", ((StringBuilder)localObject1).toString());
      long l2 = SystemClock.elapsedRealtime();
      for (;;)
      {
        try
        {
          localObject1 = paramCameraManager.getCameraCharacteristics(paramString);
          paramCameraManager = (StreamConfigurationMap)((CameraCharacteristics)localObject1).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
          Object localObject2 = (Range[])((CameraCharacteristics)localObject1).get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
          localObject3 = convertFramerates((Range[])localObject2, getFpsUnitFactor((Range[])localObject2));
          localObject2 = getSupportedSizes((CameraCharacteristics)localObject1);
          localObject1 = ((List)localObject3).iterator();
          i = 0;
          if (((Iterator)localObject1).hasNext())
          {
            i = Math.max(i, ((CameraEnumerationAndroid.CaptureFormat.FramerateRange)((Iterator)localObject1).next()).max);
            continue;
          }
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext()) {
            localObject3 = (Size)((Iterator)localObject2).next();
          }
        }
        catch (Exception paramCameraManager)
        {
          Object localObject3;
          int i;
          long l1;
          int j;
          double d;
          StringBuilder localStringBuilder;
          paramString = new StringBuilder();
          paramString.append("getCameraCharacteristics(): ");
          paramString.append(paramCameraManager);
          Logging.e("Camera2Enumerator", paramString.toString());
          paramCameraManager = new ArrayList();
          return paramCameraManager;
        }
        try
        {
          l1 = paramCameraManager.getOutputMinFrameDuration(SurfaceTexture.class, new android.util.Size(((Size)localObject3).width, ((Size)localObject3).height));
        }
        catch (Exception localException)
        {
          continue;
        }
        l1 = 0L;
        if (l1 == 0L)
        {
          j = i;
        }
        else
        {
          d = 1000000000.0D / l1;
          j = (int)Math.round(d) * 1000;
        }
        ((List)localObject1).add(new CameraEnumerationAndroid.CaptureFormat(((Size)localObject3).width, ((Size)localObject3).height, 0, j));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Format: ");
        localStringBuilder.append(((Size)localObject3).width);
        localStringBuilder.append("x");
        localStringBuilder.append(((Size)localObject3).height);
        localStringBuilder.append("@");
        localStringBuilder.append(j);
        Logging.d("Camera2Enumerator", localStringBuilder.toString());
      }
      cachedSupportedFormats.put(paramString, localObject1);
      l1 = SystemClock.elapsedRealtime();
      paramCameraManager = new StringBuilder();
      paramCameraManager.append("Get supported formats for camera index ");
      paramCameraManager.append(paramString);
      paramCameraManager.append(" done. Time spent: ");
      paramCameraManager.append(l1 - l2);
      paramCameraManager.append(" ms.");
      Logging.d("Camera2Enumerator", paramCameraManager.toString());
      return localObject1;
    }
  }
  
  static List<Size> getSupportedSizes(CameraCharacteristics paramCameraCharacteristics)
  {
    StreamConfigurationMap localStreamConfigurationMap = (StreamConfigurationMap)paramCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    ((Integer)paramCameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
    return convertSizes(localStreamConfigurationMap.getOutputSizes(SurfaceTexture.class));
  }
  
  public static boolean isSupported(Context paramContext)
  {
    paramContext = (CameraManager)paramContext.getSystemService("camera");
    try
    {
      localObject = paramContext.getCameraIdList();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Integer)paramContext.getCameraCharacteristics(localObject[i]).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        if (k == 2) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    catch (AndroidException paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Camera access exception: ");
      ((StringBuilder)localObject).append(paramContext);
      Logging.e("Camera2Enumerator", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public CameraVideoCapturer createCapturer(String paramString, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler)
  {
    return new Camera2Capturer(this.context, paramString, paramCameraEventsHandler);
  }
  
  public String[] getDeviceNames()
  {
    try
    {
      String[] arrayOfString = this.cameraManager.getCameraIdList();
      return arrayOfString;
    }
    catch (AndroidException localAndroidException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Camera access exception: ");
      localStringBuilder.append(localAndroidException);
      Logging.e("Camera2Enumerator", localStringBuilder.toString());
    }
    return new String[0];
  }
  
  public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String paramString)
  {
    return getSupportedFormats(this.context, paramString);
  }
  
  public boolean isBackFacing(String paramString)
  {
    paramString = getCameraCharacteristics(paramString);
    return (paramString != null) && (((Integer)paramString.get(CameraCharacteristics.LENS_FACING)).intValue() == 1);
  }
  
  public boolean isFrontFacing(String paramString)
  {
    paramString = getCameraCharacteristics(paramString);
    return (paramString != null) && (((Integer)paramString.get(CameraCharacteristics.LENS_FACING)).intValue() == 0);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.Camera2Enumerator
 * JD-Core Version:    0.7.0.1
 */