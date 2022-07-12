package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import ca.a;
import com.farsunset.hoxin.message.model.ChatVoice;
import com.google.android.material.button.MaterialButton;
import java.io.File;
import s3.z;
import u3.a0;
import u3.l;

public class RecordingButton
  extends MaterialButton
{
  private long t;
  private RecordingHintView u;
  private long v;
  private MediaRecorder w;
  private File x;
  private z<ChatVoice> y;
  private final Handler z = new a();
  
  public RecordingButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void o(MotionEvent paramMotionEvent)
  {
    this.v = System.currentTimeMillis();
    if (q(paramMotionEvent))
    {
      long l1 = this.v;
      long l2 = this.t;
      if (((l1 - l2) / 1000L > 0L) && (l2 > 0L))
      {
        bool = true;
        break label55;
      }
    }
    boolean bool = false;
    label55:
    r(bool);
  }
  
  private void p()
  {
    if (this.u == null) {
      this.u = ((RecordingHintView)View.inflate(getContext(), 2131427545, (ViewGroup)getParent().getParent().getParent()).findViewById(2131231388));
    }
  }
  
  private boolean q(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    return (paramMotionEvent.getRawY() >= arrayOfInt[1]) && (paramMotionEvent.getRawY() <= arrayOfInt[1] + getHeight()) && (paramMotionEvent.getRawX() >= arrayOfInt[0]) && (paramMotionEvent.getRawX() <= arrayOfInt[0] + getWidth());
  }
  
  private void r(boolean paramBoolean)
  {
    if (this.u.getRecording()) {}
    try
    {
      this.w.stop();
      this.w.release();
      label24:
      setSelected(false);
      this.u.setVisibility(8);
      setText(2131689678);
      this.u.setTimeText("00:00");
      if (paramBoolean)
      {
        ChatVoice localChatVoice = new ChatVoice();
        localChatVoice.length = ((this.v - this.t) / 1000L);
        localChatVoice.file = this.x.getName();
        this.y.w(localChatVoice);
      }
      else
      {
        a.k(this.x);
      }
      this.u.setRecording(false);
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label273;
          }
        }
        else
        {
          if (!this.u.getRecording()) {
            break label273;
          }
          if (!q(paramMotionEvent))
          {
            this.u.setTouchOutSide(true);
            setText(2131689677);
            break label273;
          }
          this.u.setTouchOutSide(false);
          setSelected(true);
          setText(2131689679);
          break label273;
        }
      }
      o(paramMotionEvent);
    }
    else
    {
      p();
      if (q(paramMotionEvent))
      {
        this.u.setRecording(true);
        Object localObject = this.z;
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage());
        setSelected(true);
        setText(2131689679);
        this.u.setHintText(2131689675);
        try
        {
          this.u.setVisibility(0);
          this.w = new MediaRecorder();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(l.K());
          ((StringBuilder)localObject).append(".arm");
          localObject = a0.g(((StringBuilder)localObject).toString());
          this.x = ((File)localObject);
          ((File)localObject).createNewFile();
          this.w.setAudioSource(1);
          this.w.setOutputFormat(3);
          this.w.setAudioEncoder(1);
          this.w.setOutputFile(this.x.getAbsolutePath());
          this.w.prepare();
          this.w.start();
          this.t = System.currentTimeMillis();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    label273:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.z.removeCallbacksAndMessages(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void setOnRecordCompletedListener(z<ChatVoice> paramz)
  {
    this.y = paramz;
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      long l = System.currentTimeMillis();
      int i = (int)((l - RecordingButton.j(RecordingButton.this)) / 1000L);
      if (i >= 60)
      {
        RecordingButton.k(RecordingButton.this, l);
        paramMessage = RecordingButton.this;
        boolean bool;
        if (RecordingButton.j(paramMessage) > 0L) {
          bool = true;
        } else {
          bool = false;
        }
        RecordingButton.l(paramMessage, bool);
      }
      else
      {
        StringBuilder localStringBuilder;
        String str;
        if (i < 10)
        {
          paramMessage = RecordingButton.m(RecordingButton.this);
          localStringBuilder = new StringBuilder();
          str = "00:0";
        }
        else
        {
          paramMessage = RecordingButton.m(RecordingButton.this);
          localStringBuilder = new StringBuilder();
          str = "00:";
        }
        localStringBuilder.append(str);
        localStringBuilder.append(i);
        paramMessage.setTimeText(localStringBuilder.toString());
      }
      if (RecordingButton.m(RecordingButton.this).getRecording()) {
        RecordingButton.n(RecordingButton.this).sendMessageDelayed(RecordingButton.n(RecordingButton.this).obtainMessage(), 1000L);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.RecordingButton
 * JD-Core Version:    0.7.0.1
 */