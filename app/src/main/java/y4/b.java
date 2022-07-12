package y4;

import android.app.Dialog;
import android.content.Context;
import androidx.appcompat.app.e;
import k8.c;
import s3.l;

public class b
  extends r3.b
  implements l
{
  private b(Context paramContext)
  {
    super(paramContext);
  }
  
  public static b p(Context paramContext, int paramInt)
  {
    return q(paramContext, paramInt, 0);
  }
  
  public static b q(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = new b(paramContext);
    paramContext.k(paramInt1);
    paramContext.o(Integer.valueOf(paramInt2));
    paramContext.i(2131689520, 2131689516);
    paramContext.n(paramContext);
    return paramContext;
  }
  
  public void S()
  {
    dismiss();
  }
  
  public void m()
  {
    dismiss();
    c8.b.k(getContext()).b().b().a(((Integer)e()).intValue());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y4.b
 * JD-Core Version:    0.7.0.1
 */