package a0;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.r;
import java.util.List;
import java.util.Map;
import s.h2;

public abstract interface n
{
  public abstract h2 a(Context paramContext);
  
  public abstract List<Pair<Integer, Size[]>> b();
  
  public abstract boolean c(String paramString, Map<String, CameraCharacteristics> paramMap);
  
  public abstract List<Pair<Integer, Size[]>> d();
  
  public abstract void e(r paramr);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a0.n
 * JD-Core Version:    0.7.0.1
 */