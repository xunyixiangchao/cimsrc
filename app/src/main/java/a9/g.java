package a9;

import java.io.Serializable;

public abstract class g<R>
  implements e<R>, Serializable
{
  private final int a;
  
  public g(int paramInt)
  {
    this.a = paramInt;
  }
  
  public String toString()
  {
    String str = j.a(this);
    f.e(str, "renderLambdaToString(this)");
    return str;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a9.g
 * JD-Core Version:    0.7.0.1
 */