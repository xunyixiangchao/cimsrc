package a9;

public class k
{
  public String a(e parame)
  {
    String str = parame.getClass().getGenericInterfaces()[0].toString();
    parame = str;
    if (str.startsWith("kotlin.jvm.functions.")) {
      parame = str.substring(21);
    }
    return parame;
  }
  
  public String b(g paramg)
  {
    return a(paramg);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a9.k
 * JD-Core Version:    0.7.0.1
 */