package m1;

public class k
{
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("')");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m1.k
 * JD-Core Version:    0.7.0.1
 */