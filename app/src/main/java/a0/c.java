package a0;

import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.e1;
import androidx.camera.core.n1;
import androidx.camera.extensions.impl.PreviewImageProcessorImpl;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import m.a;
import s.k1;
import s.p0;
import s.u;

public final class c
  implements p0, i
{
  private final PreviewImageProcessorImpl a;
  private h b = new h();
  
  public c(PreviewImageProcessorImpl paramPreviewImageProcessorImpl)
  {
    this.a = paramPreviewImageProcessorImpl;
  }
  
  public void a(Size paramSize)
  {
    if (!this.b.c()) {
      return;
    }
    try
    {
      this.a.onResolutionUpdate(paramSize);
      return;
    }
    finally
    {
      this.b.a();
    }
  }
  
  public void b(k1 paramk1)
  {
    Object localObject1 = paramk1.b();
    int i = ((List)localObject1).size();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Processing preview bundle must be 1, but found ");
    ((StringBuilder)localObject2).append(((List)localObject1).size());
    x0.h.b(bool, ((StringBuilder)localObject2).toString());
    paramk1 = paramk1.a(((Integer)((List)localObject1).get(0)).intValue());
    x0.h.a(paramk1.isDone());
    try
    {
      paramk1 = (e1)paramk1.get();
      localObject1 = paramk1.J();
      localObject2 = a.a(u.a(paramk1.q()));
      paramk1 = null;
      if ((localObject2 instanceof TotalCaptureResult)) {
        paramk1 = (TotalCaptureResult)localObject2;
      }
      if (localObject1 == null) {
        return;
      }
      if (!this.b.c()) {
        return;
      }
      try
      {
        this.a.process((Image)localObject1, paramk1);
        return;
      }
      finally
      {
        this.b.a();
      }
    }
    catch (ExecutionException|InterruptedException paramk1)
    {
      label192:
      break label192;
    }
    n1.c("AdaptingPreviewProcesso", "Unable to retrieve ImageProxy from bundle");
  }
  
  public void c(Surface paramSurface, int paramInt)
  {
    if (!this.b.c()) {
      return;
    }
    try
    {
      this.a.onOutputSurface(paramSurface, paramInt);
      this.a.onImageFormatUpdate(35);
      return;
    }
    finally
    {
      this.b.a();
    }
  }
  
  public void close()
  {
    this.b.b();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.c
 * JD-Core Version:    0.7.0.1
 */