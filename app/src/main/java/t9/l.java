package t9;

import a9.f;
import aa.d;
import java.util.List;

public abstract interface l
{
  public static final a a = a.a;
  public static final l b = new l.a.a();
  
  public abstract boolean a(int paramInt, List<c> paramList);
  
  public abstract boolean b(int paramInt, List<c> paramList, boolean paramBoolean);
  
  public abstract void c(int paramInt, b paramb);
  
  public abstract boolean d(int paramInt1, d paramd, int paramInt2, boolean paramBoolean);
  
  public static final class a
  {
    private static final class a
      implements l
    {
      public boolean a(int paramInt, List<c> paramList)
      {
        f.f(paramList, "requestHeaders");
        return true;
      }
      
      public boolean b(int paramInt, List<c> paramList, boolean paramBoolean)
      {
        f.f(paramList, "responseHeaders");
        return true;
      }
      
      public void c(int paramInt, b paramb)
      {
        f.f(paramb, "errorCode");
      }
      
      public boolean d(int paramInt1, d paramd, int paramInt2, boolean paramBoolean)
      {
        f.f(paramd, "source");
        paramd.skip(paramInt2);
        return true;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.l
 * JD-Core Version:    0.7.0.1
 */