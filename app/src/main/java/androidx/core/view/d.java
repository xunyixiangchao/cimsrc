package androidx.core.view;

import android.os.Build.VERSION;
import android.view.DisplayCutout;
import x0.c;

public final class d
{
  private final Object a;
  
  private d(Object paramObject)
  {
    this.a = paramObject;
  }
  
  static d e(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new d(paramObject);
  }
  
  public int a()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.a).getSafeInsetBottom();
    }
    return 0;
  }
  
  public int b()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.a).getSafeInsetLeft();
    }
    return 0;
  }
  
  public int c()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.a).getSafeInsetRight();
    }
    return 0;
  }
  
  public int d()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.a).getSafeInsetTop();
    }
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (d.class == paramObject.getClass()))
    {
      paramObject = (d)paramObject;
      return c.a(this.a, paramObject.a);
    }
    return false;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DisplayCutoutCompat{");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.view.d
 * JD-Core Version:    0.7.0.1
 */