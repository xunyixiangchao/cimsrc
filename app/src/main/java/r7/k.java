package r7;

import android.graphics.RectF;
import java.util.Arrays;

public final class k
  implements c
{
  private final float a;
  
  public k(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public float a(RectF paramRectF)
  {
    return this.a * paramRectF.height();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof k)) {
      return false;
    }
    paramObject = (k)paramObject;
    return this.a == paramObject.a;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Float.valueOf(this.a) });
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r7.k
 * JD-Core Version:    0.7.0.1
 */