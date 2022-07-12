package a1;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.inputmethod.InputContentInfo;

public final class c
{
  private final c a;
  
  private c(c paramc)
  {
    this.a = paramc;
  }
  
  public c(Uri paramUri1, ClipDescription paramClipDescription, Uri paramUri2)
  {
    if (Build.VERSION.SDK_INT >= 25) {
      paramUri1 = new a(paramUri1, paramClipDescription, paramUri2);
    } else {
      paramUri1 = new b(paramUri1, paramClipDescription, paramUri2);
    }
    this.a = paramUri1;
  }
  
  public static c f(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 25) {
      return null;
    }
    return new c(new a(paramObject));
  }
  
  public Uri a()
  {
    return this.a.c();
  }
  
  public ClipDescription b()
  {
    return this.a.a();
  }
  
  public Uri c()
  {
    return this.a.e();
  }
  
  public void d()
  {
    this.a.d();
  }
  
  public Object e()
  {
    return this.a.b();
  }
  
  private static final class a
    implements c.c
  {
    final InputContentInfo a;
    
    a(Uri paramUri1, ClipDescription paramClipDescription, Uri paramUri2)
    {
      this.a = new InputContentInfo(paramUri1, paramClipDescription, paramUri2);
    }
    
    a(Object paramObject)
    {
      this.a = ((InputContentInfo)paramObject);
    }
    
    public ClipDescription a()
    {
      return this.a.getDescription();
    }
    
    public Object b()
    {
      return this.a;
    }
    
    public Uri c()
    {
      return this.a.getContentUri();
    }
    
    public void d()
    {
      this.a.requestPermission();
    }
    
    public Uri e()
    {
      return this.a.getLinkUri();
    }
  }
  
  private static final class b
    implements c.c
  {
    private final Uri a;
    private final ClipDescription b;
    private final Uri c;
    
    b(Uri paramUri1, ClipDescription paramClipDescription, Uri paramUri2)
    {
      this.a = paramUri1;
      this.b = paramClipDescription;
      this.c = paramUri2;
    }
    
    public ClipDescription a()
    {
      return this.b;
    }
    
    public Object b()
    {
      return null;
    }
    
    public Uri c()
    {
      return this.a;
    }
    
    public void d() {}
    
    public Uri e()
    {
      return this.c;
    }
  }
  
  private static abstract interface c
  {
    public abstract ClipDescription a();
    
    public abstract Object b();
    
    public abstract Uri c();
    
    public abstract void d();
    
    public abstract Uri e();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a1.c
 * JD-Core Version:    0.7.0.1
 */