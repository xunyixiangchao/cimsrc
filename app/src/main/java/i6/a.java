package i6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import s3.p;
import u3.l;

public class a
  extends PopupWindow
  implements View.OnClickListener
{
  private final TextView a;
  private p b;
  
  public a(Context paramContext)
  {
    super(paramContext, null, 2130903862);
    paramContext = LayoutInflater.from(paramContext).inflate(2131427675, null);
    setContentView(paramContext);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    setWidth(paramContext.getMeasuredWidth());
    setHeight(paramContext.getMeasuredHeight());
    setOutsideTouchable(true);
    setFocusable(true);
    this.a = ((TextView)getContentView().findViewById(2131230833));
    getContentView().findViewById(2131230833).setOnClickListener(this);
    getContentView().findViewById(2131230827).setOnClickListener(this);
  }
  
  public void a()
  {
    getContentView().findViewById(2131230833).setEnabled(false);
  }
  
  public void b()
  {
    getContentView().findViewById(2131230833).setEnabled(true);
  }
  
  public void c(p paramp)
  {
    this.b = paramp;
  }
  
  public void d(View paramView, boolean paramBoolean)
  {
    Object localObject = this.a;
    int i;
    if (paramBoolean) {
      i = 2131689520;
    } else {
      i = 2131689547;
    }
    ((TextView)localObject).setText(i);
    localObject = new int[2];
    paramView.getLocationOnScreen((int[])localObject);
    super.showAtLocation(paramView, 0, localObject[0] - getWidth(), localObject[1] - l.p(12.0F));
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    this.b.C0(paramView.getTag(), paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i6.a
 * JD-Core Version:    0.7.0.1
 */