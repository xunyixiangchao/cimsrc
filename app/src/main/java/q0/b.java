package q0;

import android.graphics.Insets;
import android.graphics.Rect;

public final class b
{
  public static final b e = new b(0, 0, 0, 0);
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  
  private b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public static b a(b paramb1, b paramb2)
  {
    return b(Math.max(paramb1.a, paramb2.a), Math.max(paramb1.b, paramb2.b), Math.max(paramb1.c, paramb2.c), Math.max(paramb1.d, paramb2.d));
  }
  
  public static b b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0)) {
      return e;
    }
    return new b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static b c(Rect paramRect)
  {
    return b(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  public static b d(Insets paramInsets)
  {
    return b(paramInsets.left, paramInsets.top, paramInsets.right, paramInsets.bottom);
  }
  
  public Insets e()
  {
    return Insets.of(this.a, this.b, this.c, this.d);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (b.class != paramObject.getClass()) {
        return false;
      }
      paramObject = (b)paramObject;
      if (this.d != paramObject.d) {
        return false;
      }
      if (this.a != paramObject.a) {
        return false;
      }
      if (this.c != paramObject.c) {
        return false;
      }
      return this.b == paramObject.b;
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((this.a * 31 + this.b) * 31 + this.c) * 31 + this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Insets{left=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", top=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", right=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", bottom=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.b
 * JD-Core Version:    0.7.0.1
 */