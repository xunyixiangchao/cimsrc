package b5;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.ui.WebViewActivity;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.function.parser.MessageParser;
import com.farsunset.hoxin.message.function.parser.MessageParserFactory;
import d5.i;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import u3.l;

public class j
  extends RecyclerView.h<i>
  implements View.OnClickListener, View.OnLongClickListener
{
  private final List<Message> d = new ArrayList();
  private Message e;
  
  public void I(List<Message> paramList)
  {
    this.d.addAll(0, paramList);
    s(0, paramList.size());
  }
  
  public void J(Message paramMessage)
  {
    this.d.add(0, paramMessage);
    p(0);
  }
  
  public Message K()
  {
    return this.e;
  }
  
  public void L(Message paramMessage)
  {
    int i = this.d.indexOf(paramMessage);
    if (i >= 0)
    {
      this.d.remove(i);
      u(i);
    }
  }
  
  public void M(i parami, int paramInt)
  {
    Message localMessage = (Message)this.d.get(paramInt);
    parami.a.setOnLongClickListener(this);
    parami.a.setTag(localMessage);
    Object localObject = MessageParserFactory.getMessageParser(localMessage.action);
    parami.u.setText(2131689557);
    ((MessageParser)localObject).displayWindowView(parami, localMessage);
    parami.v.setText(l.x(localMessage.createTime.longValue()));
    parami.a.setOnLongClickListener(this);
    parami.a.setTag(localMessage);
    localObject = localMessage.extra;
    if ((localObject != null) && (Patterns.WEB_URL.matcher((CharSequence)localObject).matches())) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      parami.y.setOnClickListener(this);
      parami.y.setTag(localMessage.extra);
      parami.y.setVisibility(0);
      return;
    }
    parami.y.setVisibility(8);
  }
  
  public i N(ViewGroup paramViewGroup, int paramInt)
  {
    return new i(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131427529, paramViewGroup, false));
  }
  
  public int d()
  {
    return this.d.size();
  }
  
  public long e(int paramInt)
  {
    return 0L;
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(paramView.getContext(), WebViewActivity.class);
    localIntent.setData(Uri.parse(paramView.getTag().toString()));
    paramView.getContext().startActivity(localIntent);
  }
  
  public boolean onLongClick(View paramView)
  {
    this.e = ((Message)paramView.getTag());
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b5.j
 * JD-Core Version:    0.7.0.1
 */