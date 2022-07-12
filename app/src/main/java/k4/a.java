package k4;

import android.app.Activity;
import android.app.Dialog;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.friend.entity.Friend;
import u3.b0;
import u3.l;

public class a
  extends androidx.appcompat.app.e
  implements View.OnClickListener, s3.e<BaseResult>
{
  private Friend c;
  private EditText d;
  
  public a(Activity paramActivity)
  {
    super(paramActivity, 2131756076);
    setOwnerActivity(paramActivity);
    setContentView(2131427436);
    findViewById(2131231128).setOnClickListener(this);
    findViewById(2131231396).setOnClickListener(this);
    ((TextView)findViewById(2131231396)).setText(2131689555);
    this.d = ((EditText)findViewById(2131231087));
    setCanceledOnTouchOutside(false);
  }
  
  public void e(Friend paramFriend)
  {
    this.c = paramFriend;
    ((WebImageView)findViewById(2131231150)).p(b0.l(paramFriend.id), 2131165495);
    this.d.setHint(Html.fromHtml(l.J(2131689574, new Object[] { i3.e.j() })));
    super.show();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131231396)
    {
      paramView = this.d.getText().toString();
      g4.a.c(this.c.id, paramView, this);
    }
    dismiss();
  }
  
  public void onHttpException(Exception paramException) {}
  
  public void onHttpResponse(BaseResult paramBaseResult)
  {
    l.z0(getContext(), 2131690008);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k4.a
 * JD-Core Version:    0.7.0.1
 */