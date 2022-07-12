package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.function.parser.MessageParser;
import com.farsunset.hoxin.message.function.parser.MessageParserFactory;
import u3.l;

public class ChattingTipsMessageView
  extends AppCompatTextView
  implements View.OnClickListener
{
  private Message a;
  
  public ChattingTipsMessageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void k(Message paramMessage)
  {
    this.a = paramMessage;
    if ((paramMessage.state.byteValue() == 6) && (paramMessage.isTextFormat()))
    {
      setText(Html.fromHtml(getContext().getString(2131690089)));
      setOnClickListener(this);
      setClickable(true);
      return;
    }
    setOnClickListener(null);
    setClickable(false);
    setText(l.t(MessageParserFactory.getMessageParser(paramMessage.action).getDescription(paramMessage)));
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent("com.farsunset.hoxin.ACTION_REDO_MESSAGE");
    paramView.putExtra(Message.NAME, this.a);
    HoxinApplication.t(paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChattingTipsMessageView
 * JD-Core Version:    0.7.0.1
 */