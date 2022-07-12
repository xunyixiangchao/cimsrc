package com.farsunset.hoxin.message.widget;

import a7.b;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import com.farsunset.hoxin.common.ui.FileSelectorActivity;
import com.farsunset.hoxin.common.ui.MapLocationActivity;
import com.farsunset.hoxin.common.ui.PhotoSelectorActivity;
import com.farsunset.hoxin.common.ui.VideoRecorderActivity;
import com.farsunset.hoxin.common.widget.SimpleInputPanelView;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import com.farsunset.hoxin.friend.ui.ProfileSelectorActivity;
import com.farsunset.hoxin.message.entity.Message;
import s3.n;
import s3.w;
import u3.l;
import u3.l0;
import x1.a;
import x1.a.c;

public class ChattingInputPanelView
  extends SimpleInputPanelView
{
  private View h;
  private View i;
  private ViewGroup j;
  private View k;
  private View l;
  private View m;
  private TextView n;
  private r5.c o;
  private b p;
  
  public ChattingInputPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void B()
  {
    Intent localIntent = new Intent(getContext(), VideoRecorderActivity.class);
    localIntent.setAction("com.farsunset.hoxin.ACTION_FROM_CHATTING");
    ((AppCompatActivity)getContext()).startActivityForResult(localIntent, 1);
  }
  
  private void C()
  {
    H();
    this.j.setVisibility(8);
    this.h.setSelected(false);
    x1.c.j(this.d);
    if (!TextUtils.isEmpty(this.d.getText().toString()))
    {
      this.i.setVisibility(8);
      this.c.setVisibility(0);
    }
  }
  
  private void E()
  {
    ((Activity)getContext()).startActivityForResult(new Intent(getContext(), ProfileSelectorActivity.class), 8155);
  }
  
  private void H()
  {
    this.l.setVisibility(0);
    this.b.setVisibility(0);
    this.k.setVisibility(8);
  }
  
  private void y()
  {
    this.l.setVisibility(8);
    this.b.setVisibility(8);
    this.k.setVisibility(0);
  }
  
  public void A()
  {
    h();
    this.p.u();
  }
  
  public void D()
  {
    l.i(getContext(), new b());
  }
  
  public void F()
  {
    l.h(getContext(), new a());
  }
  
  public void G()
  {
    h();
    this.p.o();
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      H();
      this.b.setSelected(false);
    }
  }
  
  public void c(View paramView, boolean paramBoolean)
  {
    super.c(paramView, paramBoolean);
    if (paramView == this.i)
    {
      this.h.setSelected(false);
      this.b.setSelected(false);
      H();
    }
    if (paramBoolean) {
      this.f.q(true);
    }
  }
  
  public Message getQuoteMessage()
  {
    return (Message)this.m.getTag(2131231522);
  }
  
  protected void i()
  {
    this.e.setOnVisibleChangedListener(new c(this));
    x1.c.b((Activity)getContext(), this.g, this);
    a.b(this.g, this.d, this, new a.c[] { new a.c(this.e, this.b), new a.c(this.j, this.i) });
  }
  
  public void j(EmoticonItem paramEmoticonItem)
  {
    if (paramEmoticonItem.id == null)
    {
      super.j(paramEmoticonItem);
      return;
    }
    this.o.j(paramEmoticonItem);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131231129)
    {
      if (i1 != 2131231375)
      {
        if (i1 != 2131231432)
        {
          Intent localIntent;
          switch (i1)
          {
          default: 
            return;
          case 2131231571: 
            A();
            return;
          case 2131231570: 
            G();
            return;
          case 2131231569: 
            E();
            return;
          case 2131231568: 
            localIntent = new Intent(getContext(), PhotoSelectorActivity.class);
            paramView = (Activity)getContext();
            i1 = 2;
            break;
          case 2131231567: 
            D();
            return;
          case 2131231566: 
            localIntent = new Intent(getContext(), FileSelectorActivity.class);
            paramView = (Activity)getContext();
            i1 = 3;
            paramView.startActivityForResult(localIntent, i1);
            return;
          }
          B();
          return;
        }
        this.f.n0(this.d.getText().toString());
        return;
      }
      x();
      return;
    }
    if (this.h.isSelected())
    {
      C();
      return;
    }
    F();
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.i = findViewById(2131230875);
    this.h = findViewById(2131231129);
    findViewById(2131231565).setOnClickListener(this);
    findViewById(2131231568).setOnClickListener(this);
    findViewById(2131231566).setOnClickListener(this);
    findViewById(2131231570).setOnClickListener(this);
    findViewById(2131231571).setOnClickListener(this);
    findViewById(2131231567).setOnClickListener(this);
    findViewById(2131231569).setOnClickListener(this);
    findViewById(2131231375).setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.j = ((ViewGroup)findViewById(2131231564));
    this.k = findViewById(2131231620);
    this.l = findViewById(2131231086);
    this.m = findViewById(2131231374);
    this.n = ((TextView)findViewById(2131231376));
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if (this.l.getVisibility() != 0) {
      return;
    }
    if (l.c0(paramCharSequence))
    {
      this.i.setVisibility(8);
      this.c.setVisibility(0);
      return;
    }
    this.i.setVisibility(0);
    this.c.setVisibility(8);
  }
  
  public void setOnCallMenuClickListener(b paramb)
  {
    this.p = paramb;
  }
  
  public void setOnEmoticonClickedListener(r5.c paramc)
  {
    this.o = paramc;
  }
  
  public void w(Message paramMessage)
  {
    this.m.setVisibility(0);
    this.m.setTag(2131231522, paramMessage);
    this.n.setText(l0.b(paramMessage));
  }
  
  public void x()
  {
    this.n.setText(null);
    this.m.setVisibility(8);
    this.m.setTag(2131231522, null);
  }
  
  class a
    implements w
  {
    a() {}
    
    public void a()
    {
      a.d(ChattingInputPanelView.p(ChattingInputPanelView.this));
      ChattingInputPanelView.q(ChattingInputPanelView.this).setVisibility(0);
      ChattingInputPanelView.r(ChattingInputPanelView.this).setVisibility(8);
      ChattingInputPanelView.s(ChattingInputPanelView.this).setSelected(false);
      ChattingInputPanelView.t(ChattingInputPanelView.this).setSelected(true);
      ChattingInputPanelView.u(ChattingInputPanelView.this);
      x1.c.h(ChattingInputPanelView.v(ChattingInputPanelView.this));
    }
    
    public void b() {}
  }
  
  class b
    implements w
  {
    b() {}
    
    public void a()
    {
      Intent localIntent = new Intent(ChattingInputPanelView.this.getContext(), MapLocationActivity.class);
      localIntent.setAction("com.farsunset.hoxin.ACTION_SELECT_CHAT_MAP");
      ((Activity)ChattingInputPanelView.this.getContext()).startActivityForResult(localIntent, 4);
    }
    
    public void b() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ChattingInputPanelView
 * JD-Core Version:    0.7.0.1
 */