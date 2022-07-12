package a0;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.r;
import androidx.camera.extensions.impl.advanced.AdvancedExtenderImpl;
import androidx.camera.extensions.impl.advanced.AutoAdvancedExtenderImpl;
import androidx.camera.extensions.impl.advanced.BeautyAdvancedExtenderImpl;
import androidx.camera.extensions.impl.advanced.BokehAdvancedExtenderImpl;
import androidx.camera.extensions.impl.advanced.HdrAdvancedExtenderImpl;
import androidx.camera.extensions.impl.advanced.NightAdvancedExtenderImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s.h2;

public class e
  implements n
{
  private final c0.a a = new c0.a();
  private final AdvancedExtenderImpl b;
  private String c;
  private final int d;
  
  public e(int paramInt)
  {
    this.d = paramInt;
    if ((paramInt == 1) || ((paramInt == 2) || ((paramInt == 3) || ((paramInt == 4) || (paramInt == 5))))) {}
    for (;;)
    {
      try
      {
        localObject = new AutoAdvancedExtenderImpl();
        this.b = ((AdvancedExtenderImpl)localObject);
        return;
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        Object localObject;
        continue;
      }
      throw new IllegalArgumentException("Should not active ExtensionMode.NONE");
      localObject = new BeautyAdvancedExtenderImpl();
      continue;
      localObject = new NightAdvancedExtenderImpl();
      continue;
      localObject = new HdrAdvancedExtenderImpl();
      continue;
      localObject = new BokehAdvancedExtenderImpl();
    }
    throw new IllegalArgumentException("AdvancedExtenderImpl does not exist");
  }
  
  private List<Pair<Integer, Size[]>> f(Map<Integer, List<Size>> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localArrayList.add(new Pair(localInteger, (Size[])((List)paramMap.get(localInteger)).toArray(new Size[0])));
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public h2 a(Context paramContext)
  {
    x0.h.h(this.c, "VendorExtender#init() must be called first");
    return new d0.a(this.b.createSessionProcessor(), paramContext);
  }
  
  public List<Pair<Integer, Size[]>> b()
  {
    x0.h.h(this.c, "VendorExtender#init() must be called first");
    return f(this.b.getSupportedCaptureOutputResolutions(this.c));
  }
  
  public boolean c(String paramString, Map<String, CameraCharacteristics> paramMap)
  {
    if (this.a.a(paramString, this.d)) {
      return false;
    }
    return this.b.isExtensionAvailable(paramString, paramMap);
  }
  
  public List<Pair<Integer, Size[]>> d()
  {
    x0.h.h(this.c, "VendorExtender#init() must be called first");
    return f(this.b.getSupportedPreviewOutputResolutions(this.c));
  }
  
  public void e(r paramr)
  {
    this.c = r.h.b(paramr).e();
    paramr = r.h.b(paramr).d();
    this.b.init(this.c, paramr);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.e
 * JD-Core Version:    0.7.0.1
 */