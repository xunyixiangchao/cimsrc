package r7;

import android.graphics.RectF;
import java.util.Arrays;

public final class a
  implements c
{
  private final float a;
  
  public a(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public float a(RectF paramRectF)
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return this.a == paramObject.a;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Float.valueOf(this.a) });
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r7.a
 * JD-Core Version:    0.7.0.1
 */