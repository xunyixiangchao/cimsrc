package y0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

public final class a
  extends ClickableSpan
{
  private final int a;
  private final d b;
  private final int c;
  
  public a(int paramInt1, d paramd, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramd;
    this.c = paramInt2;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.a);
    this.b.R(this.c, paramView);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y0.a
 * JD-Core Version:    0.7.0.1
 */