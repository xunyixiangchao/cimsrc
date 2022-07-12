package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.R.dimen;
import java.util.ArrayList;

public class h
{
  boolean A;
  String B;
  Bundle C;
  int D = 0;
  int E = 0;
  Notification F;
  RemoteViews G;
  RemoteViews H;
  RemoteViews I;
  String J;
  int K = 0;
  String L;
  long M;
  int N = 0;
  int O = 0;
  boolean P;
  Notification Q;
  boolean R;
  Icon S;
  @Deprecated
  public ArrayList<String> T;
  public Context a;
  public ArrayList<f> b = new ArrayList();
  public ArrayList<l> c = new ArrayList();
  ArrayList<f> d = new ArrayList();
  CharSequence e;
  CharSequence f;
  PendingIntent g;
  PendingIntent h;
  RemoteViews i;
  Bitmap j;
  CharSequence k;
  int l;
  int m;
  boolean n = true;
  boolean o;
  CharSequence p;
  CharSequence q;
  CharSequence[] r;
  int s;
  int t;
  boolean u;
  String v;
  boolean w;
  String x;
  boolean y = false;
  boolean z;
  
  public h(Context paramContext, String paramString)
  {
    Notification localNotification = new Notification();
    this.Q = localNotification;
    this.a = paramContext;
    this.J = paramString;
    localNotification.when = System.currentTimeMillis();
    this.Q.audioStreamType = -1;
    this.m = 0;
    this.T = new ArrayList();
    this.P = true;
  }
  
  protected static CharSequence c(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return paramCharSequence;
    }
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.length() > 5120) {
      localCharSequence = paramCharSequence.subSequence(0, 5120);
    }
    return localCharSequence;
  }
  
  private Bitmap d(Bitmap paramBitmap)
  {
    Object localObject = paramBitmap;
    if (paramBitmap != null)
    {
      if (Build.VERSION.SDK_INT >= 27) {
        return paramBitmap;
      }
      localObject = this.a.getResources();
      int i1 = ((Resources)localObject).getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
      int i2 = ((Resources)localObject).getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
      if ((paramBitmap.getWidth() <= i1) && (paramBitmap.getHeight() <= i2)) {
        return paramBitmap;
      }
      double d1 = Math.min(i1 / Math.max(1, paramBitmap.getWidth()), i2 / Math.max(1, paramBitmap.getHeight()));
      localObject = Bitmap.createScaledBitmap(paramBitmap, (int)Math.ceil(paramBitmap.getWidth() * d1), (int)Math.ceil(paramBitmap.getHeight() * d1), true);
    }
    return localObject;
  }
  
  private void i(int paramInt, boolean paramBoolean)
  {
    Notification localNotification;
    if (paramBoolean)
    {
      localNotification = this.Q;
      paramInt |= localNotification.flags;
    }
    else
    {
      localNotification = this.Q;
      paramInt &= localNotification.flags;
    }
    localNotification.flags = paramInt;
  }
  
  public Notification a()
  {
    return new i(this).b();
  }
  
  public Bundle b()
  {
    if (this.C == null) {
      this.C = new Bundle();
    }
    return this.C;
  }
  
  public h e(boolean paramBoolean)
  {
    i(16, paramBoolean);
    return this;
  }
  
  public h f(PendingIntent paramPendingIntent)
  {
    this.g = paramPendingIntent;
    return this;
  }
  
  public h g(CharSequence paramCharSequence)
  {
    this.f = c(paramCharSequence);
    return this;
  }
  
  public h h(CharSequence paramCharSequence)
  {
    this.e = c(paramCharSequence);
    return this;
  }
  
  public h j(Bitmap paramBitmap)
  {
    this.j = d(paramBitmap);
    return this;
  }
  
  public h k(boolean paramBoolean)
  {
    i(2, paramBoolean);
    return this;
  }
  
  public h l(int paramInt)
  {
    this.m = paramInt;
    return this;
  }
  
  public h m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.s = paramInt1;
    this.t = paramInt2;
    this.u = paramBoolean;
    return this;
  }
  
  public h n(int paramInt)
  {
    this.Q.icon = paramInt;
    return this;
  }
  
  public h o(CharSequence paramCharSequence)
  {
    this.Q.tickerText = c(paramCharSequence);
    return this;
  }
  
  public h p(int paramInt)
  {
    this.E = paramInt;
    return this;
  }
  
  public h q(long paramLong)
  {
    this.Q.when = paramLong;
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.h
 * JD-Core Version:    0.7.0.1
 */