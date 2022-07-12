package d0;

import androidx.camera.extensions.impl.advanced.Camera2OutputConfigImpl;
import androidx.camera.extensions.impl.advanced.ImageReaderOutputConfigImpl;
import androidx.camera.extensions.impl.advanced.MultiResolutionImageReaderOutputConfigImpl;
import androidx.camera.extensions.impl.advanced.SurfaceOutputConfigImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class f
{
  static e a(Camera2OutputConfigImpl paramCamera2OutputConfigImpl)
  {
    Object localObject = new ArrayList();
    if (paramCamera2OutputConfigImpl.getSurfaceSharingOutputConfigs() != null)
    {
      Iterator localIterator = paramCamera2OutputConfigImpl.getSurfaceSharingOutputConfigs().iterator();
      while (localIterator.hasNext()) {
        ((List)localObject).add(a((Camera2OutputConfigImpl)localIterator.next()));
      }
    }
    if ((paramCamera2OutputConfigImpl instanceof SurfaceOutputConfigImpl))
    {
      paramCamera2OutputConfigImpl = (SurfaceOutputConfigImpl)paramCamera2OutputConfigImpl;
      return m.d(paramCamera2OutputConfigImpl.getId(), paramCamera2OutputConfigImpl.getSurfaceGroupId(), paramCamera2OutputConfigImpl.getPhysicalCameraId(), (List)localObject, paramCamera2OutputConfigImpl.getSurface());
    }
    if ((paramCamera2OutputConfigImpl instanceof ImageReaderOutputConfigImpl))
    {
      paramCamera2OutputConfigImpl = (ImageReaderOutputConfigImpl)paramCamera2OutputConfigImpl;
      return i.d(paramCamera2OutputConfigImpl.getId(), paramCamera2OutputConfigImpl.getSurfaceGroupId(), paramCamera2OutputConfigImpl.getPhysicalCameraId(), (List)localObject, paramCamera2OutputConfigImpl.getSize(), paramCamera2OutputConfigImpl.getImageFormat(), paramCamera2OutputConfigImpl.getMaxImages());
    }
    if ((paramCamera2OutputConfigImpl instanceof MultiResolutionImageReaderOutputConfigImpl))
    {
      paramCamera2OutputConfigImpl = (MultiResolutionImageReaderOutputConfigImpl)paramCamera2OutputConfigImpl;
      return j.d(paramCamera2OutputConfigImpl.getId(), paramCamera2OutputConfigImpl.getSurfaceGroupId(), paramCamera2OutputConfigImpl.getPhysicalCameraId(), (List)localObject, paramCamera2OutputConfigImpl.getImageFormat(), paramCamera2OutputConfigImpl.getMaxImages());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Not supported Camera2OutputConfigImpl: ");
    ((StringBuilder)localObject).append(paramCamera2OutputConfigImpl.getClass());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d0.f
 * JD-Core Version:    0.7.0.1
 */