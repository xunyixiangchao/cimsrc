package r9;

public final class f
{
  public static final f a = new f();
  
  public static final boolean a(String paramString)
  {
    a9.f.f(paramString, "method");
    return (!a9.f.a(paramString, "GET")) && (!a9.f.a(paramString, "HEAD"));
  }
  
  public static final boolean d(String paramString)
  {
    a9.f.f(paramString, "method");
    return (a9.f.a(paramString, "POST")) || (a9.f.a(paramString, "PUT")) || (a9.f.a(paramString, "PATCH")) || (a9.f.a(paramString, "PROPPATCH")) || (a9.f.a(paramString, "REPORT"));
  }
  
  public final boolean b(String paramString)
  {
    a9.f.f(paramString, "method");
    return a9.f.a(paramString, "PROPFIND") ^ true;
  }
  
  public final boolean c(String paramString)
  {
    a9.f.f(paramString, "method");
    return a9.f.a(paramString, "PROPFIND");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r9.f
 * JD-Core Version:    0.7.0.1
 */