package a0;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.d1;
import androidx.camera.extensions.impl.PreviewExtenderImpl;
import androidx.camera.extensions.impl.PreviewExtenderImpl.ProcessorType;
import androidx.camera.extensions.impl.RequestUpdateProcessorImpl;
import m.a;
import s.f1;
import s.u;

public final class d
  implements f1, i
{
  private final PreviewExtenderImpl a;
  private final RequestUpdateProcessorImpl b;
  private h c = new h();
  
  public d(PreviewExtenderImpl paramPreviewExtenderImpl)
  {
    boolean bool;
    if (paramPreviewExtenderImpl.getProcessorType() == PreviewExtenderImpl.ProcessorType.PROCESSOR_TYPE_REQUEST_UPDATE_ONLY) {
      bool = true;
    } else {
      bool = false;
    }
    x0.h.b(bool, "AdaptingRequestUpdateProcess can only adapt extender with PROCESSOR_TYPE_REQUEST_UPDATE_ONLY ProcessorType.");
    this.a = paramPreviewExtenderImpl;
    this.b = ((RequestUpdateProcessorImpl)paramPreviewExtenderImpl.getProcessor());
  }
  
  public boolean a(d1 paramd1)
  {
    boolean bool1 = this.c.c();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    try
    {
      paramd1 = a.a(u.a(paramd1));
      bool1 = bool2;
      if ((paramd1 instanceof TotalCaptureResult))
      {
        paramd1 = this.b.process((TotalCaptureResult)paramd1);
        bool1 = bool2;
        if (paramd1 != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      this.c.a();
    }
  }
  
  public void close()
  {
    this.c.b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.d
 * JD-Core Version:    0.7.0.1
 */