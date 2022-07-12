package ea;

import java.util.Objects;

public class j
  extends RuntimeException
{
  private final int a;
  private final String b;
  private final transient t<?> c;
  
  public j(t<?> paramt)
  {
    super(a(paramt));
    this.a = paramt.b();
    this.b = paramt.e();
    this.c = paramt;
  }
  
  private static String a(t<?> paramt)
  {
    Objects.requireNonNull(paramt, "response == null");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HTTP ");
    localStringBuilder.append(paramt.b());
    localStringBuilder.append(" ");
    localStringBuilder.append(paramt.e());
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     ea.j
 * JD-Core Version:    0.7.0.1
 */