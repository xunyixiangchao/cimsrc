package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ca.a;
import com.farsunset.hoxin.common.widget.CircleProgressView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatFile;
import com.farsunset.hoxin.message.ui.FileViewerActivity;
import s3.d0;
import u3.g0;
import u3.l;

public class ChatFileView
  extends FrameLayout
  implements View.OnClickListener, d0
{
  private CircleProgressView a;
  private Message b;
  private TextView c;
  private TextView d;
  private ImageView e;
  
  public ChatFileView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a(float paramFloat)
  {
    this.a.setProgress((int)paramFloat);
    if (paramFloat >= 100.0F)
    {
      this.a.setVisibility(8);
      return;
    }
    if (paramFloat > 0.0F) {
      this.a.setVisibility(0);
    }
  }
  
  public void b(Message paramMessage)
  {
    this.b = paramMessage;
    paramMessage = (ChatFile)l.s0(paramMessage.content, ChatFile.class);
    setTag(paramMessage.file);
    this.c.setText(a.a(paramMessage.size));
    this.d.setText(paramMessage.name);
    this.e.setImageResource(g0.e(paramMessage.name));
  }
  
  public void onClick(View paramView)
  {
    if (!this.b.state.equals(Byte.valueOf((byte)1)))
    {
      if (this.b.state.equals(Byte.valueOf((byte)2))) {
        return;
      }
      paramView = new Intent(getContext(), FileViewerActivity.class);
      paramView.putExtra("ATTR_MESSAGE_ID", this.b.id);
      getContext().startActivity(paramView);
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.d = ((TextView)findViewById(2131230998));
    this.c = ((TextView)findViewById(2131231000));
    this.e = ((ImageView)findViewById(2131230996));
  }
  
  public void setSendProgressView(CircleProgressView paramCircleProgressView)
  {
    this.a = paramCircleProgressView;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChatFileView
 * JD-Core Version:    0.7.0.1
 */