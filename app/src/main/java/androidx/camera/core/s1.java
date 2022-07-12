package androidx.camera.core;

import android.graphics.Matrix;
import android.media.ImageReader;
import s.n2;

class s1
  extends d
{
  private volatile n2 c = null;
  private volatile Long d = null;
  private volatile Integer e = null;
  private volatile Matrix f = null;
  
  s1(ImageReader paramImageReader)
  {
    super(paramImageReader);
  }
  
  private e1 l(e1 parame1)
  {
    Object localObject = parame1.q();
    n2 localn2;
    if (this.c != null) {
      localn2 = this.c;
    } else {
      localn2 = ((d1)localObject).a();
    }
    long l;
    if (this.d != null) {
      l = this.d.longValue();
    } else {
      l = ((d1)localObject).getTimestamp();
    }
    int i;
    if (this.e != null) {
      i = this.e.intValue();
    } else {
      i = ((d1)localObject).c();
    }
    if (this.f != null) {
      localObject = this.f;
    } else {
      localObject = ((d1)localObject).d();
    }
    return new j2(parame1, l1.e(localn2, l, i, (Matrix)localObject));
  }
  
  public e1 b()
  {
    return l(super.g());
  }
  
  public e1 g()
  {
    return l(super.g());
  }
  
  void m(n2 paramn2)
  {
    this.c = paramn2;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.s1
 * JD-Core Version:    0.7.0.1
 */