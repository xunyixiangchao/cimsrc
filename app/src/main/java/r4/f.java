package r4;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.farsunset.hoxin.common.widget.WebImageView;
import s3.m;
import u3.l;

public class f
  extends e
  implements View.OnClickListener, DialogInterface.OnShowListener
{
  private m c;
  private final EditText d;
  
  public f(Context paramContext)
  {
    super(paramContext, 2131756076);
    getWindow().setSoftInputMode(4);
    setContentView(2131427436);
    findViewById(2131231128).setOnClickListener(this);
    findViewById(2131231396).setOnClickListener(this);
    ((TextView)findViewById(2131231396)).setText(2131689553);
    EditText localEditText = (EditText)findViewById(2131231087);
    this.d = localEditText;
    localEditText.setHint(Html.fromHtml(paramContext.getString(2131689597)));
    setCanceledOnTouchOutside(false);
    setOnShowListener(this);
  }
  
  public void dismiss()
  {
    this.d.setText(null);
    super.dismiss();
  }
  
  public void e(m paramm)
  {
    this.c = paramm;
  }
  
  public void f(String paramString)
  {
    this.d.setText(paramString);
  }
  
  public void g(long paramLong)
  {
    ((WebImageView)findViewById(2131231150)).l(l.A(paramLong));
    super.show();
    this.d.requestFocus();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231128)
    {
      dismiss();
      return;
    }
    if ((!TextUtils.isEmpty(this.d.getText())) && (paramView.getId() == 2131231396))
    {
      this.c.P(this.d.getText().toString().trim());
      dismiss();
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.d;
    paramDialogInterface.setSelection(paramDialogInterface.getText().length());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r4.f
 * JD-Core Version:    0.7.0.1
 */