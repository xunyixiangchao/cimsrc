package r7;

import android.graphics.RectF;
import java.util.Arrays;

public final class b
  implements c
{
  private final c a;
  private final float b;
  
  public b(float paramFloat, c paramc)
  {
    while ((paramc instanceof b))
    {
      paramc = ((b)paramc).a;
      paramFloat += ((b)paramc).b;
    }
    this.a = paramc;
    this.b = paramFloat;
  }
  
  public float a(RectF paramRectF)
  {
    return Math.max(0.0F, this.a.a(paramRectF) + this.b);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    paramObject = (b)paramObject;
    return (this.a.equals(paramObject.a)) && (this.b == paramObject.b);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.a, Float.valueOf(this.b) });
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r7.b
 * JD-Core Version:    0.7.0.1
 */