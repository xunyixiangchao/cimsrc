package o3;

public enum b
{
  private String a;
  
  static
  {
    b localb1 = new b("USER_ICON", 0, "hoxin-user-icon");
    b = localb1;
    b localb2 = new b("USER_BANNER", 1, "hoxin-user-banner");
    c = localb2;
    b localb3 = new b("GROUP_ICON", 2, "hoxin-group-icon");
    d = localb3;
    b localb4 = new b("MICRO_SERVER_ICON", 3, "hoxin-micro-server-icon");
    e = localb4;
    b localb5 = new b("CHAT_SPACE", 4, "hoxin-chat-space");
    f = localb5;
    b localb6 = new b("MOMENT_SPACE", 5, "hoxin-moment-space");
    g = localb6;
    b localb7 = new b("MOMENT_WALLPAPER", 6, "hoxin-moment-wallpaper");
    h = localb7;
    b localb8 = new b("MICRO_APP_ICON", 7, "hoxin-micro-app-icon");
    i = localb8;
    b localb9 = new b("EMOTICON_LOGO", 8, "hoxin-emoticon-logo");
    j = localb9;
    b localb10 = new b("EMOTICON_ITEM", 9, "hoxin-emoticon-item");
    k = localb10;
    l = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8, localb9, localb10 };
  }
  
  private b(String paramString)
  {
    this.a = paramString;
  }
  
  public String a()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o3.b
 * JD-Core Version:    0.7.0.1
 */