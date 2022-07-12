package a0;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.n1;
import androidx.camera.core.r;
import androidx.camera.extensions.impl.AutoImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.AutoPreviewExtenderImpl;
import androidx.camera.extensions.impl.BeautyImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.BeautyPreviewExtenderImpl;
import androidx.camera.extensions.impl.BokehImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.BokehPreviewExtenderImpl;
import androidx.camera.extensions.impl.HdrImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.HdrPreviewExtenderImpl;
import androidx.camera.extensions.impl.ImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.NightImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.NightPreviewExtenderImpl;
import androidx.camera.extensions.impl.PreviewExtenderImpl;
import c0.a;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import s.h2;

public class g
  implements n
{
  private final a a = new a();
  private final int b;
  private PreviewExtenderImpl c = null;
  private ImageCaptureExtenderImpl d = null;
  private r e;
  
  public g(int paramInt)
  {
    this.b = paramInt;
    if ((paramInt == 1) || ((paramInt == 2) || ((paramInt == 3) || ((paramInt == 4) || (paramInt == 5))))) {}
    for (;;)
    {
      try
      {
        this.c = new AutoPreviewExtenderImpl();
        localObject = new AutoImageCaptureExtenderImpl();
        this.d = ((ImageCaptureExtenderImpl)localObject);
        return;
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        Object localObject;
        continue;
      }
      throw new IllegalArgumentException("Should not activate ExtensionMode.NONE");
      this.c = new BeautyPreviewExtenderImpl();
      localObject = new BeautyImageCaptureExtenderImpl();
      continue;
      this.c = new NightPreviewExtenderImpl();
      localObject = new NightImageCaptureExtenderImpl();
      continue;
      this.c = new HdrPreviewExtenderImpl();
      localObject = new HdrImageCaptureExtenderImpl();
      continue;
      this.c = new BokehPreviewExtenderImpl();
      localObject = new BokehImageCaptureExtenderImpl();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OEM implementation for extension mode ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("does not exist!");
    n1.c("BasicVendorExtender", ((StringBuilder)localObject).toString());
  }
  
  private int f()
  {
    ImageCaptureExtenderImpl localImageCaptureExtenderImpl = this.d;
    if ((localImageCaptureExtenderImpl != null) && (localImageCaptureExtenderImpl.getCaptureProcessor() != null)) {
      return 35;
    }
    return 256;
  }
  
  private Size[] h(int paramInt)
  {
    return ((StreamConfigurationMap)r.h.b(this.e).c(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(paramInt);
  }
  
  private int j()
  {
    return 34;
  }
  
  public h2 a(Context paramContext)
  {
    x0.h.h(this.e, "VendorExtender#init() must be called first");
    return null;
  }
  
  public List<Pair<Integer, Size[]>> b()
  {
    x0.h.h(this.e, "VendorExtender#init() must be called first");
    if ((this.d != null) && (j.b().a(o.b) >= 0)) {}
    try
    {
      List localList = this.d.getSupportedResolutions();
      if (localList != null) {
        return localList;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label45:
      int i;
      break label45;
    }
    i = f();
    return Arrays.asList(new Pair[] { new Pair(Integer.valueOf(i), h(i)) });
  }
  
  public boolean c(String paramString, Map<String, CameraCharacteristics> paramMap)
  {
    boolean bool1 = this.a.a(paramString, this.b);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    bool1 = bool2;
    if (this.c != null)
    {
      if (this.d == null) {
        return false;
      }
      paramMap = (CameraCharacteristics)paramMap.get(paramString);
      bool1 = bool2;
      if (this.c.isExtensionAvailable(paramString, paramMap))
      {
        bool1 = bool2;
        if (this.d.isExtensionAvailable(paramString, paramMap)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public List<Pair<Integer, Size[]>> d()
  {
    x0.h.h(this.e, "VendorExtender#init() must be called first");
    if ((this.c != null) && (j.b().a(o.b) >= 0)) {}
    try
    {
      List localList = this.c.getSupportedResolutions();
      if (localList != null) {
        return localList;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label45:
      int i;
      break label45;
    }
    i = j();
    return Arrays.asList(new Pair[] { new Pair(Integer.valueOf(i), h(i)) });
  }
  
  public void e(r paramr)
  {
    this.e = paramr;
    if (this.c != null)
    {
      if (this.d == null) {
        return;
      }
      String str = r.h.b(paramr).e();
      paramr = r.h.a(paramr);
      this.c.init(str, paramr);
      this.d.init(str, paramr);
      paramr = new StringBuilder();
      paramr.append("Extension init Mode = ");
      paramr.append(this.b);
      n1.a("BasicVendorExtender", paramr.toString());
      paramr = new StringBuilder();
      paramr.append("PreviewExtender processorType= ");
      paramr.append(this.c.getProcessorType());
      n1.a("BasicVendorExtender", paramr.toString());
      paramr = new StringBuilder();
      paramr.append("ImageCaptureExtender processor= ");
      paramr.append(this.d.getCaptureProcessor());
      n1.a("BasicVendorExtender", paramr.toString());
    }
  }
  
  public ImageCaptureExtenderImpl g()
  {
    return this.d;
  }
  
  public PreviewExtenderImpl i()
  {
    return this.c;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.g
 * JD-Core Version:    0.7.0.1
 */