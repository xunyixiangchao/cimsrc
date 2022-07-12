package c4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import u3.b0;
import u3.l;
import u3.r;
import u3.s;

public class a
  extends PopupWindow
{
  private final TextView a;
  private final ImageView b;
  
  public a(Context paramContext)
  {
    super(paramContext, null, 2130903862);
    paramContext = LayoutInflater.from(paramContext).inflate(2131427674, null);
    setContentView(paramContext);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    setWidth(paramContext.getMeasuredWidth());
    setHeight(paramContext.getMeasuredHeight());
    setOutsideTouchable(true);
    setFocusable(true);
    this.a = ((TextView)getContentView().findViewById(2131231301));
    this.b = ((ImageView)getContentView().findViewById(2131231072));
  }
  
  public void a(View paramView, EmoticonItem paramEmoticonItem)
  {
    this.a.setText(paramEmoticonItem.name);
    if (paramEmoticonItem.type == 0) {
      s.a().l(this.b, b0.d(paramEmoticonItem.id.longValue()));
    } else {
      s.a().f(this.b, b0.d(paramEmoticonItem.id.longValue()));
    }
    int i = getWidth();
    int j = getHeight();
    paramEmoticonItem = new int[2];
    paramView.getLocationInWindow(paramEmoticonItem);
    super.showAtLocation(paramView, 0, paramEmoticonItem[0] - (i - paramView.getMeasuredWidth()) / 2, paramEmoticonItem[1] - j + l.p(15.0F));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c4.a
 * JD-Core Version:    0.7.0.1
 */