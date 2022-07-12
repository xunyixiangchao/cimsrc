package u3;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import androidx.core.content.b;
import com.farsunset.hoxin.HoxinApplication;
import java.io.File;
import r5.i;

public class i0
  implements MediaPlayer.OnCompletionListener, AudioManager.OnAudioFocusChangeListener
{
  private static i0 e;
  private final MediaPlayer a;
  private i b;
  private String c;
  private final AudioManager d;
  
  private i0()
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    this.a = localMediaPlayer;
    localMediaPlayer.setAudioStreamType(3);
    this.d = ((AudioManager)b.h(HoxinApplication.h(), AudioManager.class));
  }
  
  public static i0 a()
  {
    if (e == null) {
      e = new i0();
    }
    return e;
  }
  
  private void c()
  {
    if (b()) {
      this.a.stop();
    }
    try
    {
      this.a.reset();
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      this.a.setOnCompletionListener(this);
      this.a.setDataSource(this.c);
      this.a.prepare();
      this.a.start();
      return;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
  }
  
  public boolean b()
  {
    return this.a.isPlaying();
  }
  
  public void d(File paramFile, i parami)
  {
    if (this.c != null)
    {
      if ((b()) && (paramFile.getAbsolutePath().equals(this.c)))
      {
        e();
        return;
      }
      if ((b()) && (!paramFile.getAbsolutePath().equals(this.c)))
      {
        i locali = this.b;
        if (locali != null) {
          locali.a();
        }
      }
    }
    this.b = parami;
    this.c = paramFile.getAbsolutePath();
    this.d.requestAudioFocus(this, 3, 2);
    this.d.setSpeakerphoneOn(true);
    c();
  }
  
  public void e()
  {
    if (b()) {
      this.a.stop();
    }
    i locali = this.b;
    if (locali != null)
    {
      locali.a();
      this.b = null;
    }
    this.d.abandonAudioFocus(this);
    this.d.setSpeakerphoneOn(false);
  }
  
  public void onAudioFocusChange(int paramInt) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = this.b;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.b();
    }
    l.v0(2131623938);
    this.d.abandonAudioFocus(this);
    this.d.setSpeakerphoneOn(false);
    this.c = null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.i0
 * JD-Core Version:    0.7.0.1
 */