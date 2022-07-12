package android.support.v4.app;

import androidx.core.app.RemoteActionCompat;
import androidx.versionedparcelable.a;

public final class RemoteActionCompatParcelizer
  extends androidx.core.app.RemoteActionCompatParcelizer
{
  public static RemoteActionCompat read(a parama)
  {
    return androidx.core.app.RemoteActionCompatParcelizer.read(parama);
  }
  
  public static void write(RemoteActionCompat paramRemoteActionCompat, a parama)
  {
    androidx.core.app.RemoteActionCompatParcelizer.write(paramRemoteActionCompat, parama);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     android.support.v4.app.RemoteActionCompatParcelizer
 * JD-Core Version:    0.7.0.1
 */