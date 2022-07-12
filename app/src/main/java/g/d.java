package g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.view.LayoutInflater;
import androidx.appcompat.R.style;

public class d
  extends ContextWrapper
{
  private int a;
  private Resources.Theme b;
  private LayoutInflater c;
  private Configuration d;
  private Resources e;
  
  public d()
  {
    super(null);
  }
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramInt;
  }
  
  public d(Context paramContext, Resources.Theme paramTheme)
  {
    super(paramContext);
    this.b = paramTheme;
  }
  
  private Resources b()
  {
    if (this.e == null)
    {
      Object localObject = this.d;
      if (localObject == null) {}
      for (localObject = super.getResources();; localObject = createConfigurationContext((Configuration)localObject).getResources())
      {
        this.e = ((Resources)localObject);
        break;
      }
    }
    return this.e;
  }
  
  private void d()
  {
    boolean bool;
    if (this.b == null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      this.b = getResources().newTheme();
      Resources.Theme localTheme = getBaseContext().getTheme();
      if (localTheme != null) {
        this.b.setTo(localTheme);
      }
    }
    e(this.b, this.a, bool);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.e == null)
    {
      if (this.d == null)
      {
        this.d = new Configuration(paramConfiguration);
        return;
      }
      throw new IllegalStateException("Override configuration has already been set");
    }
    throw new IllegalStateException("getResources() or getAssets() has already been called");
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public int c()
  {
    return this.a;
  }
  
  protected void e(Resources.Theme paramTheme, int paramInt, boolean paramBoolean)
  {
    paramTheme.applyStyle(paramInt, true);
  }
  
  public AssetManager getAssets()
  {
    return getResources().getAssets();
  }
  
  public Resources getResources()
  {
    return b();
  }
  
  public Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (this.c == null) {
        this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
      }
      return this.c;
    }
    return getBaseContext().getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    Resources.Theme localTheme = this.b;
    if (localTheme != null) {
      return localTheme;
    }
    if (this.a == 0) {
      this.a = R.style.Theme_AppCompat_Light;
    }
    d();
    return this.b;
  }
  
  public void setTheme(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      d();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     g.d
 * JD-Core Version:    0.7.0.1
 */