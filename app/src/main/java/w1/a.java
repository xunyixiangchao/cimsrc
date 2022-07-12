package w1;

import android.view.View;
import x1.c;

public class a
{
  private final View a;
  private boolean b;
  private View c;
  
  public a(View paramView)
  {
    this.a = paramView;
  }
  
  private void b()
  {
    this.a.setVisibility(4);
    c.j(this.c);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if ((!paramBoolean) && (this.a.getVisibility() == 4)) {
      this.a.setVisibility(8);
    }
    if ((!paramBoolean) && (this.c != null))
    {
      b();
      this.c = null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w1.a
 * JD-Core Version:    0.7.0.1
 */