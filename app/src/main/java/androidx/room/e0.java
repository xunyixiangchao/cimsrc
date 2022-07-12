package androidx.room;

import android.content.Context;

public class e0
{
  public static <T extends f0> f0.a<T> a(Context paramContext, Class<T> paramClass, String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() != 0)) {
      return new f0.a(paramContext, paramClass, paramString);
    }
    throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
  }
  
  public static <T, C> T b(Class<C> paramClass, String paramString)
  {
    String str2 = paramClass.getPackage().getName();
    String str1 = paramClass.getCanonicalName();
    if (!str2.isEmpty()) {
      str1 = str1.substring(str2.length() + 1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str1.replace('.', '_'));
    localStringBuilder.append(paramString);
    str1 = localStringBuilder.toString();
    try
    {
      if (str2.isEmpty())
      {
        paramString = str1;
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append(str2);
        paramString.append(".");
        paramString.append(str1);
        paramString = paramString.toString();
      }
      paramString = Class.forName(paramString, true, paramClass.getClassLoader()).newInstance();
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      break label201;
    }
    catch (IllegalAccessException paramString)
    {
      break label165;
    }
    catch (InstantiationException paramString)
    {
      label129:
      break label129;
    }
    paramString = new StringBuilder();
    paramString.append("Failed to create an instance of ");
    paramString.append(paramClass.getCanonicalName());
    throw new RuntimeException(paramString.toString());
    label165:
    paramString = new StringBuilder();
    paramString.append("Cannot access the constructor");
    paramString.append(paramClass.getCanonicalName());
    throw new RuntimeException(paramString.toString());
    label201:
    paramString = new StringBuilder();
    paramString.append("cannot find implementation for ");
    paramString.append(paramClass.getCanonicalName());
    paramString.append(". ");
    paramString.append(str1);
    paramString.append(" does not exist");
    throw new RuntimeException(paramString.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.room.e0
 * JD-Core Version:    0.7.0.1
 */