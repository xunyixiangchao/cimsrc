package o1;

public class f
{
  public static final String[] a = new String[0];
  
  public static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append("?");
      if (i < paramInt - 1) {
        paramStringBuilder.append(",");
      }
      i += 1;
    }
  }
  
  public static StringBuilder b()
  {
    return new StringBuilder();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o1.f
 * JD-Core Version:    0.7.0.1
 */