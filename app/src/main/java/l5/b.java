package l5;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.c0;
import androidx.recyclerview.widget.RecyclerView.h;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.model.MapAddress;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import com.farsunset.hoxin.message.entity.ChatSession;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatEmoticon;
import com.farsunset.hoxin.message.model.ChatFile;
import com.farsunset.hoxin.message.model.ChatLink;
import com.farsunset.hoxin.message.model.ChatMap;
import com.farsunset.hoxin.message.model.ChatProfile;
import com.farsunset.hoxin.message.model.ChatVoice;
import com.farsunset.hoxin.message.widget.EmoticonSmartView;
import com.farsunset.hoxin.message.widget.EmoticonTextView;
import java.util.ArrayList;
import java.util.List;
import u3.b0;

public class b
  extends androidx.appcompat.app.e
  implements View.OnClickListener
{
  private final List<ChatSession> c = new ArrayList();
  private final EmoticonTextView d;
  private final TextView e;
  private final TextView f;
  private final WebImageView g;
  private final WebImageView h;
  private final RecyclerView i;
  private s3.l j;
  private final CardView k;
  private final WebImageView l;
  private EmoticonSmartView m;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131756073);
    setCancelable(true);
    setCanceledOnTouchOutside(false);
    setContentView(2131427439);
    paramContext = (EmoticonTextView)findViewById(2131231528);
    this.d = paramContext;
    paramContext.setFaceSize(20);
    this.f = ((TextView)findViewById(2131231301));
    this.k = ((CardView)findViewById(2131231609));
    this.e = ((TextView)findViewById(2131231299));
    this.g = ((WebImageView)findViewById(2131231053));
    this.h = ((WebImageView)findViewById(2131231072));
    this.l = ((WebImageView)findViewById(2131231551));
    findViewById(2131231128).setOnClickListener(this);
    findViewById(2131231396).setOnClickListener(this);
    paramContext = (RecyclerView)findViewById(2131231298);
    this.i = paramContext;
    paramContext.h(new v3.e((int)Resources.getSystem().getDisplayMetrics().density * 8));
    paramContext.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    paramContext.setAdapter(new c(null));
    this.m = ((EmoticonSmartView)findViewById(2131230980));
  }
  
  private void f(CloudVideo paramCloudVideo)
  {
    this.k.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams;
    int n;
    if (paramCloudVideo.mode == 0)
    {
      this.l.getLayoutParams().width = getContext().getResources().getDimensionPixelOffset(2131100240);
      localLayoutParams = this.l.getLayoutParams();
      n = getContext().getResources().getDimensionPixelOffset(2131100241);
    }
    else
    {
      this.l.getLayoutParams().width = getContext().getResources().getDimensionPixelOffset(2131100241);
      localLayoutParams = this.l.getLayoutParams();
      n = getContext().getResources().getDimensionPixelOffset(2131100240);
    }
    localLayoutParams.height = n;
    this.l.requestLayout();
    this.l.p(paramCloudVideo.getFileUri(), 2131165336);
  }
  
  public void g(Message paramMessage)
  {
    if (paramMessage.isTextFormat())
    {
      this.d.setVisibility(0);
      this.d.setText(paramMessage.content);
      return;
    }
    if (paramMessage.isLinkFormat())
    {
      this.d.setVisibility(0);
      paramMessage = (ChatLink)u3.l.s0(paramMessage.content, ChatLink.class);
      this.d.setText(paramMessage.title);
      return;
    }
    Object localObject;
    if (paramMessage.isVoiceFormat())
    {
      this.e.setVisibility(0);
      paramMessage = (ChatVoice)u3.l.s0(paramMessage.content, ChatVoice.class);
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessage.length);
      localStringBuilder.append("\"");
      ((TextView)localObject).setText(u3.l.J(2131690177, new Object[] { localStringBuilder.toString() }));
      return;
    }
    if (paramMessage.isFileFormat())
    {
      this.e.setVisibility(0);
      paramMessage = (ChatFile)u3.l.s0(paramMessage.content, ChatFile.class);
      this.e.setText(u3.l.J(2131690174, new Object[] { paramMessage.name }));
      return;
    }
    if (paramMessage.isImageFormat())
    {
      this.h.setVisibility(0);
      paramMessage = (CloudImage)u3.l.s0(paramMessage.content, CloudImage.class);
      this.h.p(paramMessage.getFileUri(), 0);
      return;
    }
    if (paramMessage.isVideoFormat())
    {
      f((CloudVideo)u3.l.s0(paramMessage.content, CloudVideo.class));
      return;
    }
    if (paramMessage.isMapFormat())
    {
      paramMessage = (ChatMap)u3.l.s0(paramMessage.content, ChatMap.class);
      this.d.setVisibility(0);
      this.d.setText(u3.l.J(2131689764, new Object[] { paramMessage.name }));
      return;
    }
    int n = paramMessage.format;
    if (n == 14)
    {
      paramMessage = (ChatProfile)u3.l.s0(paramMessage.content, ChatProfile.class);
      this.d.setVisibility(0);
      this.d.setText(u3.l.J(2131690176, new Object[] { paramMessage.name }));
      return;
    }
    if (n == 18)
    {
      paramMessage = (ChatProfile)u3.l.s0(paramMessage.content, ChatProfile.class);
      this.d.setVisibility(0);
      this.d.setText(u3.l.J(2131690175, new Object[] { paramMessage.name }));
      return;
    }
    if (n == 15)
    {
      paramMessage = (ChatEmoticon)u3.l.s0(paramMessage.content, ChatEmoticon.class);
      localObject = new EmoticonItem();
      ((EmoticonItem)localObject).type = paramMessage.type;
      ((EmoticonItem)localObject).id = Long.valueOf(paramMessage.itemId);
      ((EmoticonItem)localObject).name = paramMessage.name;
      this.m.setVisibility(0);
      this.m.a((EmoticonItem)localObject);
    }
  }
  
  public void h(s3.l paraml)
  {
    this.j = paraml;
  }
  
  public void i(ChatSession paramChatSession)
  {
    this.i.setVisibility(8);
    findViewById(2131231443).setVisibility(0);
    this.f.setText(paramChatSession.name);
    if (paramChatSession.sourceType == 2) {
      this.g.l(u3.l.A(paramChatSession.sourceId));
    } else {
      this.g.p(b0.l(paramChatSession.sourceId), 2131165495);
    }
    super.show();
  }
  
  public void j(List<ChatSession> paramList)
  {
    if (paramList.size() == 1)
    {
      i((ChatSession)paramList.get(0));
      return;
    }
    this.i.setVisibility(0);
    findViewById(2131231443).setVisibility(8);
    this.c.clear();
    this.c.addAll(paramList);
    this.i.getAdapter().j();
    super.show();
  }
  
  public void onClick(View paramView)
  {
    if (2131231128 == paramView.getId()) {
      dismiss();
    }
    if (2131231396 == paramView.getId()) {
      this.j.m();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.width = ((int)(Resources.getSystem().getDisplayMetrics().widthPixels * 0.85D));
    getWindow().setAttributes(paramBundle);
  }
  
  private static class b
    extends RecyclerView.c0
  {
    final WebImageView u;
    final TextView v;
    
    b(View paramView)
    {
      super();
      this.u = ((WebImageView)paramView.findViewById(2131231053));
      this.v = ((TextView)paramView.findViewById(2131231301));
    }
  }
  
  private class c
    extends RecyclerView.h<b.b>
  {
    private c() {}
    
    public void I(b.b paramb, int paramInt)
    {
      ChatSession localChatSession = (ChatSession)b.e(b.this).get(paramInt);
      paramb.v.setText(localChatSession.name);
      paramInt = localChatSession.sourceType;
      paramb = paramb.u;
      if (paramInt == 2)
      {
        paramb.l(u3.l.A(localChatSession.sourceId));
        return;
      }
      paramb.p(b0.l(localChatSession.sourceId), 2131165495);
    }
    
    public b.b J(ViewGroup paramViewGroup, int paramInt)
    {
      return new b.b(View.inflate(b.this.getContext(), 2131427495, null));
    }
    
    public int d()
    {
      return b.e(b.this).size();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l5.b
 * JD-Core Version:    0.7.0.1
 */