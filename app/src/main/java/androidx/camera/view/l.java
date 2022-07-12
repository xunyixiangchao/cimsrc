package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Size;
import androidx.camera.core.r1;

class l
  extends r1
{
  static final PointF d = new PointF(2.0F, 2.0F);
  private final f b;
  private Matrix c;
  
  l(f paramf)
  {
    this.b = paramf;
  }
  
  void a(Size paramSize, int paramInt)
  {
    
    try
    {
      if ((paramSize.getWidth() != 0) && (paramSize.getHeight() != 0))
      {
        this.c = this.b.c(paramSize, paramInt);
        return;
      }
      this.c = null;
      return;
    }
    finally {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.view.l
 * JD-Core Version:    0.7.0.1
 */