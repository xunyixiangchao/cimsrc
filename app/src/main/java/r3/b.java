package r3;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.e;
import s3.l;

public class b
  extends e
  implements View.OnClickListener
{
  private l c;
  private Object d;
  private boolean e;
  
  public b(Context paramContext)
  {
    super(paramContext, 2131756073);
    setContentView(2131427432);
    findViewById(2131231128).setOnClickListener(this);
    findViewById(2131231396).setOnClickListener(this);
    setCanceledOnTouchOutside(false);
  }
  
  public Object e()
  {
    return this.d;
  }
  
  public void f()
  {
    findViewById(2131231128).setEnabled(false);
  }
  
  public boolean g()
  {
    return this.e;
  }
  
  public void h(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void i(int paramInt1, int paramInt2)
  {
    ((TextView)findViewById(2131231128)).setText(paramInt1);
    ((TextView)findViewById(2131231396)).setText(paramInt2);
  }
  
  public void j(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    ((TextView)findViewById(2131231128)).setText(paramCharSequence1);
    ((TextView)findViewById(2131231396)).setText(paramCharSequence2);
  }
  
  public void k(int paramInt)
  {
    ((TextView)findViewById(2131231256)).setText(paramInt);
  }
  
  public void l(CharSequence paramCharSequence)
  {
    ((TextView)findViewById(2131231256)).setText(paramCharSequence);
  }
  
  public void n(l paraml)
  {
    this.c = paraml;
  }
  
  public void o(Object paramObject)
  {
    this.d = paramObject;
  }
  
  public void onClick(View paramView)
  {
    if (this.c == null)
    {
      dismiss();
      return;
    }
    if (paramView.getId() == 2131231128)
    {
      if (g()) {
        dismiss();
      }
      this.c.S();
    }
    if (paramView.getId() == 2131231396)
    {
      if (g()) {
        dismiss();
      }
      this.c.m();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow().getAttributes();
    paramBundle.width = ((int)(Resources.getSystem().getDisplayMetrics().widthPixels * 0.85D));
    getWindow().setAttributes(paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r3.b
 * JD-Core Version:    0.7.0.1
 */