package com.baidu.vi;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.os.Process;

public class AudioRecorder
{
  private static Handler e = new a();
  private volatile AudioRecord a;
  private boolean b;
  private int c;
  private volatile boolean d;
  
  public AudioRecorder(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    boolean bool = true;
    this.b = true;
    this.d = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AudioRecorder.class.getSimpleName());
    localStringBuilder.append("-Record");
    new b(localStringBuilder.toString());
    if (paramInt7 != 1) {
      bool = false;
    }
    this.b = bool;
    this.c = paramInt6;
  }
  
  private void a()
  {
    if (this.b)
    {
      c localc = new c(this, null, 0);
      Handler localHandler = e;
      localHandler.sendMessage(localHandler.obtainMessage(2, localc));
      return;
    }
    if (this.d) {
      onReadError();
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.b)
    {
      paramArrayOfByte = new c(this, paramArrayOfByte, paramInt);
      Handler localHandler = e;
      localHandler.sendMessage(localHandler.obtainMessage(1, paramArrayOfByte));
      return;
    }
    if (this.d) {
      onReadData(paramArrayOfByte, paramInt);
    }
  }
  
  native void onReadData(byte[] paramArrayOfByte, int paramInt);
  
  native void onReadError();
  
  static final class a
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      AudioRecorder localAudioRecorder = ((AudioRecorder.c)paramMessage.obj).a;
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        if (AudioRecorder.a(localAudioRecorder)) {
          localAudioRecorder.onReadError();
        }
      }
      else if (AudioRecorder.a(localAudioRecorder))
      {
        paramMessage = (AudioRecorder.c)paramMessage.obj;
        localAudioRecorder.onReadData(paramMessage.b, paramMessage.c);
      }
    }
  }
  
  class b
    extends Thread
  {
    b(String paramString)
    {
      super();
    }
    
    public void run()
    {
      Process.setThreadPriority(-19);
      AudioRecorder.b(AudioRecorder.this).startRecording();
      int i = 0;
      while (AudioRecorder.a(AudioRecorder.this))
      {
        byte[] arrayOfByte = new byte[AudioRecorder.c(AudioRecorder.this)];
        if (AudioRecorder.b(AudioRecorder.this) != null) {
          i = AudioRecorder.b(AudioRecorder.this).read(arrayOfByte, 0, AudioRecorder.c(AudioRecorder.this));
        }
        if ((i != -3) && (i != -2) && (i != -1) && (i != 0)) {
          AudioRecorder.a(AudioRecorder.this, arrayOfByte, i);
        } else {
          AudioRecorder.d(AudioRecorder.this);
        }
      }
    }
  }
  
  private class c
  {
    AudioRecorder a;
    byte[] b;
    int c;
    
    public c(AudioRecorder paramAudioRecorder, byte[] paramArrayOfByte, int paramInt)
    {
      this.a = paramAudioRecorder;
      this.b = paramArrayOfByte;
      this.c = paramInt;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.vi.AudioRecorder
 * JD-Core Version:    0.7.0.1
 */