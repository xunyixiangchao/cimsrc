package l8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class a
  extends c
{
  private Activity e;
  
  public a(Activity paramActivity)
  {
    this.e = paramActivity;
  }
  
  public Context c()
  {
    return this.e;
  }
  
  public boolean g(String paramString)
  {
    return this.e.shouldShowRequestPermissionRationale(paramString);
  }
  
  public void i(Intent paramIntent)
  {
    this.e.startActivity(paramIntent);
  }
  
  public void j(Intent paramIntent, int paramInt)
  {
    this.e.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l8.a
 * JD-Core Version:    0.7.0.1
 */