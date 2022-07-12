package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

public class f
{
  final Bundle a;
  private IconCompat b;
  private final m[] c;
  private boolean d;
  boolean e;
  private final int f;
  private final boolean g;
  @Deprecated
  public int h;
  public CharSequence i;
  public PendingIntent j;
  
  public PendingIntent a()
  {
    return this.j;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public Bundle c()
  {
    return this.a;
  }
  
  public IconCompat d()
  {
    if (this.b == null)
    {
      int k = this.h;
      if (k != 0) {
        this.b = IconCompat.b(null, "", k);
      }
    }
    return this.b;
  }
  
  public m[] e()
  {
    return this.c;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public boolean g()
  {
    return this.e;
  }
  
  public CharSequence h()
  {
    return this.i;
  }
  
  public boolean i()
  {
    return this.g;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.f
 * JD-Core Version:    0.7.0.1
 */