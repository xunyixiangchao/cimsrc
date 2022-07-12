package com.farsunset.hoxin.message.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;
import com.google.android.material.snackbar.Snackbar;
import u3.l0;

public class FromMessageTextView
  extends BaseFromMessageView<EmoticonTextView>
{
  private TextView i;
  private MessageTranslateView j;
  
  public FromMessageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void g()
  {
    TextView localTextView = this.i;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void h()
  {
    if (this.j == null) {
      this.j = ((MessageTranslateView)((ViewStub)findViewById(2131231585)).inflate());
    }
  }
  
  private void j(Message paramMessage)
  {
    if (paramMessage == null)
    {
      g();
      return;
    }
    if (this.i == null) {
      this.i = ((TextView)((ViewStub)findViewById(2131231373)).inflate());
    }
    this.i.setText(l0.b(paramMessage));
    this.i.setVisibility(0);
  }
  
  public void b()
  {
    ((EmoticonTextView)this.e).setFaceSize(24);
    ((EmoticonTextView)this.e).setText(this.f.content);
    Object localObject = q5.a.c(this.f.title);
    if (((q5.a)localObject).g()) {
      j(j5.b.o(((q5.a)localObject).e().longValue()));
    } else {
      g();
    }
    localObject = p3.a.b(this.f.id);
    if (localObject != null)
    {
      h();
      this.j.e((String)localObject);
    }
    if (localObject == null)
    {
      localObject = this.j;
      if (localObject != null) {
        ((MessageTranslateView)localObject).a();
      }
    }
  }
  
  public void f(int paramInt, Message paramMessage)
  {
    if (paramInt == 2131231197)
    {
      ((ClipboardManager)androidx.core.content.b.h(getContext(), ClipboardManager.class)).setPrimaryClip(ClipData.newPlainText(null, ((EmoticonTextView)this.e).getText().toString()));
      Snackbar.b0(this, 2131690029, -1).P();
    }
    if (paramInt == 2131231209)
    {
      Intent localIntent = new Intent(getContext(), MessageForwardActivity.class);
      paramMessage = l0.a(paramMessage);
      paramMessage.content = ((EmoticonTextView)this.e).getText().toString();
      localIntent.putExtra(Message.NAME, paramMessage);
      getContext().startActivity(localIntent);
      return;
    }
    if (paramInt == 2131231252)
    {
      i();
      return;
    }
    super.f(paramInt, paramMessage);
  }
  
  protected void i()
  {
    h();
    this.j.f(this.f);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.FromMessageTextView
 * JD-Core Version:    0.7.0.1
 */