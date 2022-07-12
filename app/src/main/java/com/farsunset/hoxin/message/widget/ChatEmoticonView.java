package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.widget.AppCompatImageView;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import com.farsunset.hoxin.emoticon.ui.EmoticonViewActivity;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatEmoticon;
import u3.b0;
import u3.l;
import u3.r;
import u3.s;

public class ChatEmoticonView
  extends AppCompatImageView
  implements View.OnClickListener
{
  private ChatEmoticon a;
  
  public ChatEmoticonView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a(Message paramMessage)
  {
    paramMessage = (ChatEmoticon)l.s0(paramMessage.content, ChatEmoticon.class);
    this.a = paramMessage;
    if (paramMessage.type == 0)
    {
      s.a().l(this, b0.d(this.a.itemId));
      return;
    }
    s.a().f(this, b0.d(this.a.itemId));
  }
  
  public void onClick(View paramView)
  {
    EmoticonItem localEmoticonItem = new EmoticonItem();
    Object localObject = this.a;
    localEmoticonItem.type = ((ChatEmoticon)localObject).type;
    localEmoticonItem.name = ((ChatEmoticon)localObject).name;
    localEmoticonItem.emoticonId = Long.valueOf(((ChatEmoticon)localObject).id);
    localEmoticonItem.id = Long.valueOf(this.a.itemId);
    localObject = new Intent(paramView.getContext(), EmoticonViewActivity.class);
    ((Intent)localObject).putExtra(EmoticonItem.class.getName(), localEmoticonItem);
    paramView.getContext().startActivity((Intent)localObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChatEmoticonView
 * JD-Core Version:    0.7.0.1
 */