package com.farsunset.hoxin.micro.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.b;
import com.farsunset.hoxin.common.model.MessageSource;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;
import com.farsunset.hoxin.message.widget.EmoticonTextView;
import com.farsunset.hoxin.micro.ui.MicroServerDetailedActivity;
import com.google.android.material.snackbar.Snackbar;
import u3.b0;
import u3.l0;
import x5.a;

public class MicroServerFromTextView
  extends BaseMicroServerFromView
  implements View.OnClickListener
{
  private WebImageView e;
  private EmoticonTextView f;
  
  public MicroServerFromTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    this.f.setOnLongClickListener(this);
    this.f.setOnTouchListener(this);
    this.e.o(b0.j(this.a.sourceId));
    this.f.setFaceSize(24);
    this.f.setClickable(false);
    this.f.setText(this.b.content);
  }
  
  public void e(int paramInt, Message paramMessage)
  {
    super.e(paramInt, paramMessage);
    if (paramInt == 2131231197)
    {
      ((ClipboardManager)b.h(getContext(), ClipboardManager.class)).setPrimaryClip(ClipData.newPlainText(null, this.f.getText().toString()));
      Snackbar.b0(this, 2131690029, -1).P();
    }
    if (paramInt == 2131231209)
    {
      paramMessage = l0.a(paramMessage);
      paramMessage.content = this.f.getText().toString();
      Intent localIntent = new Intent(getContext(), MessageForwardActivity.class);
      localIntent.putExtra(Message.NAME, paramMessage);
      getContext().startActivity(localIntent);
    }
  }
  
  public Object getTag()
  {
    return this.e.getTag(2131231150);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231150)
    {
      paramView = new Intent(getContext(), MicroServerDetailedActivity.class);
      paramView.putExtra(MessageSource.NAME, a.f(this.a.sourceId));
      getContext().startActivity(paramView);
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    WebImageView localWebImageView = (WebImageView)findViewById(2131231150);
    this.e = localWebImageView;
    localWebImageView.setOnClickListener(this);
    this.f = ((EmoticonTextView)findViewById(2131231549));
  }
  
  public void setTag(Object paramObject)
  {
    this.e.setTag(2131231150, paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.widget.MicroServerFromTextView
 * JD-Core Version:    0.7.0.1
 */