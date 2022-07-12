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

public class ToMessageTextView
  extends BaseToMessageView<EmoticonTextView>
{
  private TextView h;
  private MessageTranslateView i;
  
  public ToMessageTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void r()
  {
    TextView localTextView = this.h;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  private void s()
  {
    if (this.i == null) {
      this.i = ((MessageTranslateView)((ViewStub)findViewById(2131231585)).inflate());
    }
  }
  
  private void t(Message paramMessage)
  {
    if (paramMessage == null)
    {
      r();
      return;
    }
    if (this.h == null) {
      this.h = ((TextView)((ViewStub)findViewById(2131231373)).inflate());
    }
    this.h.setText(l0.b(paramMessage));
    this.h.setVisibility(0);
  }
  
  public void f()
  {
    ((EmoticonTextView)this.f).setFaceSize(24);
    ((EmoticonTextView)this.f).setText(this.e.content);
    Object localObject = q5.a.c(this.e.title);
    if (((q5.a)localObject).g()) {
      t(j5.b.o(((q5.a)localObject).e().longValue()));
    } else {
      r();
    }
    localObject = p3.a.b(this.e.id);
    if (localObject != null)
    {
      s();
      this.i.e((String)localObject);
    }
    if (localObject == null)
    {
      localObject = this.i;
      if (localObject != null) {
        ((MessageTranslateView)localObject).a();
      }
    }
  }
  
  protected void j() {}
  
  public void k(int paramInt, Message paramMessage)
  {
    if (paramInt == 2131231197)
    {
      ((ClipboardManager)androidx.core.content.b.h(getContext(), ClipboardManager.class)).setPrimaryClip(ClipData.newPlainText(null, ((EmoticonTextView)this.f).getText().toString()));
      Snackbar.b0(this, 2131690029, -1).P();
      return;
    }
    if (paramInt == 2131231209)
    {
      Intent localIntent = new Intent(getContext(), MessageForwardActivity.class);
      paramMessage = l0.a(paramMessage);
      paramMessage.content = ((EmoticonTextView)this.f).getText().toString();
      localIntent.putExtra(Message.NAME, paramMessage);
      getContext().startActivity(localIntent);
      return;
    }
    if (paramInt == 2131231252)
    {
      s();
      this.i.f(paramMessage);
      return;
    }
    super.k(paramInt, paramMessage);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.ToMessageTextView
 * JD-Core Version:    0.7.0.1
 */