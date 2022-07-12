package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.os.PowerManager.WakeLock;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver
  extends BroadcastReceiver
{
  private static final SparseArray<PowerManager.WakeLock> a = new SparseArray();
  private static int b = 1;
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.legacy.content.WakefulBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */