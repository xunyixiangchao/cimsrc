package x0;

public class b
{
  public static void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = Integer.toHexString(System.identityHashCode(paramObject)))
    {
      paramStringBuilder.append(paramObject);
      return;
      String str2 = paramObject.getClass().getSimpleName();
      String str1 = str2;
      if (str2.length() <= 0)
      {
        str2 = paramObject.getClass().getName();
        int i = str2.lastIndexOf('.');
        str1 = str2;
        if (i > 0) {
          str1 = str2.substring(i + 1);
        }
      }
      paramStringBuilder.append(str1);
      paramStringBuilder.append('{');
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     x0.b
 * JD-Core Version:    0.7.0.1
 */