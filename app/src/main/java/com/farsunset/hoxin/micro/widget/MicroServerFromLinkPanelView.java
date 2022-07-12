package com.farsunset.hoxin.micro.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.farsunset.hoxin.common.model.Link;
import com.farsunset.hoxin.common.ui.WebViewActivity;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import java.util.Iterator;
import java.util.List;
import u3.l;

public class MicroServerFromLinkPanelView
  extends BaseMicroServerFromView
  implements View.OnClickListener
{
  public MicroServerFromLinkPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void b()
  {
    Object localObject = l.u0(this.b.content, Link.class);
    Link localLink = (Link)((List)localObject).get(0);
    removeAllViews();
    View localView = LayoutInflater.from(getContext()).inflate(2131427565, null);
    ((TextView)localView.findViewById(2131231557)).setText(localLink.title);
    ((WebImageView)localView.findViewById(2131230825)).p(localLink.image, 2131034649);
    localView.setTag(localLink.link);
    localView.setOnClickListener(this);
    localView.setOnTouchListener(this);
    localView.setOnLongClickListener(this);
    addView(localView);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      localLink = (Link)((Iterator)localObject).next();
      localView = LayoutInflater.from(getContext()).inflate(2131427566, null);
      ((TextView)localView.findViewById(2131231557)).setText(localLink.title);
      ((WebImageView)localView.findViewById(2131231072)).o(localLink.image);
      addView(localView);
      localView.setTag(localLink.link);
      localView.setOnClickListener(this);
      localView.setOnTouchListener(this);
      localView.setOnLongClickListener(this);
    }
  }
  
  public Object getTag()
  {
    return getTag(2131231522);
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(getContext(), WebViewActivity.class);
    localIntent.setData(Uri.parse(paramView.getTag().toString()));
    getContext().startActivity(localIntent);
  }
  
  public void setTag(Object paramObject)
  {
    setTag(2131231522, paramObject);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.micro.widget.MicroServerFromLinkPanelView
 * JD-Core Version:    0.7.0.1
 */