package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

public class RemoteActionCompatParcelizer
{
  public static RemoteActionCompat read(a parama)
  {
    RemoteActionCompat localRemoteActionCompat = new RemoteActionCompat();
    localRemoteActionCompat.a = ((IconCompat)parama.v(localRemoteActionCompat.a, 1));
    localRemoteActionCompat.b = parama.l(localRemoteActionCompat.b, 2);
    localRemoteActionCompat.c = parama.l(localRemoteActionCompat.c, 3);
    localRemoteActionCompat.d = ((PendingIntent)parama.r(localRemoteActionCompat.d, 4));
    localRemoteActionCompat.e = parama.h(localRemoteActionCompat.e, 5);
    localRemoteActionCompat.f = parama.h(localRemoteActionCompat.f, 6);
    return localRemoteActionCompat;
  }
  
  public static void write(RemoteActionCompat paramRemoteActionCompat, a parama)
  {
    parama.x(false, false);
    parama.M(paramRemoteActionCompat.a, 1);
    parama.D(paramRemoteActionCompat.b, 2);
    parama.D(paramRemoteActionCompat.c, 3);
    parama.H(paramRemoteActionCompat.d, 4);
    parama.z(paramRemoteActionCompat.e, 5);
    parama.z(paramRemoteActionCompat.f, 6);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.RemoteActionCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */