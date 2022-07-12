package d8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioRecord;

class o
  implements m
{
  private static final int[] b = { 8000, 11025, 22050, 44100 };
  private Context a;
  
  o(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static boolean b(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
  }
  
  private static AudioRecord c()
  {
    int[] arrayOfInt = b;
    int m = arrayOfInt.length;
    int i = 0;
    while (i < m)
    {
      int n = arrayOfInt[i];
      int j = 0;
      while (j < 2)
      {
        int i1 = new short[] { 3, 2 }[j];
        int k = 0;
        while (k < 2)
        {
          int i2 = new short[] { 16, 12 }[k];
          int i3 = AudioRecord.getMinBufferSize(n, i2, i1);
          if (i3 != -2)
          {
            AudioRecord localAudioRecord = new AudioRecord(1, n, i2, i1, i3);
            if (localAudioRecord.getState() == 1) {
              return localAudioRecord;
            }
          }
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    return null;
  }
  
  public boolean a()
  {
    AudioRecord localAudioRecord = c();
    if (localAudioRecord != null) {}
    try
    {
      localAudioRecord.startRecording();
      localAudioRecord.stop();
      localAudioRecord.release();
      return true;
    }
    finally
    {
      boolean bool;
      break label46;
    }
    bool = b(this.a);
    if (localAudioRecord != null)
    {
      localAudioRecord.stop();
      localAudioRecord.release();
    }
    return true ^ bool;
    try
    {
      label46:
      bool = b(this.a);
      return true ^ bool;
    }
    finally
    {
      if (localAudioRecord != null)
      {
        localAudioRecord.stop();
        localAudioRecord.release();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.o
 * JD-Core Version:    0.7.0.1
 */