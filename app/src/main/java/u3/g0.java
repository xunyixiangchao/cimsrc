package u3;

import android.content.Intent;
import ca.b;
import java.io.File;

public class g0
{
  private static Intent a(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "*/*");
    return localIntent;
  }
  
  private static Intent b(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "application/vnd.android.package-archive");
    return localIntent;
  }
  
  private static Intent c(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.putExtra("oneshot", 0);
    localIntent.putExtra("configchange", 0);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "audio/*");
    return localIntent;
  }
  
  private static Intent d(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "application/vnd.ms-excel");
    return localIntent;
  }
  
  public static int e(String paramString)
  {
    paramString = b.c(paramString).toLowerCase();
    if ((!"txt".equalsIgnoreCase(paramString)) && (!"sh".equalsIgnoreCase(paramString)) && (!"log".equalsIgnoreCase(paramString)) && (!"ini".equalsIgnoreCase(paramString)) && (!"xml".equalsIgnoreCase(paramString)))
    {
      if ((!"doc".equalsIgnoreCase(paramString)) && (!"docx".equalsIgnoreCase(paramString)))
      {
        if ((!"pptx".equalsIgnoreCase(paramString)) && (!"ppt".equalsIgnoreCase(paramString)))
        {
          if ((!"xls".equalsIgnoreCase(paramString)) && (!"xlsx".equalsIgnoreCase(paramString)))
          {
            if ("gif".equalsIgnoreCase(paramString)) {
              return 2131165515;
            }
            if ("png".equalsIgnoreCase(paramString)) {
              return 2131165521;
            }
            if ((!"mp3".equalsIgnoreCase(paramString)) && (!"wav".equalsIgnoreCase(paramString)) && (!"flac".equalsIgnoreCase(paramString)))
            {
              if ("pdf".equalsIgnoreCase(paramString)) {
                return 2131165520;
              }
              if ((!"jpg".equalsIgnoreCase(paramString)) && (!"jpeg".equalsIgnoreCase(paramString)))
              {
                if ("rar".equalsIgnoreCase(paramString)) {
                  return 2131165523;
                }
                if ((!"zip".equalsIgnoreCase(paramString)) && (!"7z".equalsIgnoreCase(paramString)))
                {
                  if ((!"html".equalsIgnoreCase(paramString)) && (!"htm".equalsIgnoreCase(paramString)))
                  {
                    if ("mp4".equalsIgnoreCase(paramString)) {
                      return 2131165519;
                    }
                    if ("apk".equalsIgnoreCase(paramString)) {
                      return 2131165512;
                    }
                    return 2131165513;
                  }
                  return 2131165516;
                }
                return 2131165526;
              }
              return 2131165517;
            }
            return 2131165518;
          }
          return 2131165525;
        }
        return 2131165522;
      }
      return 2131165514;
    }
    return 2131165524;
  }
  
  public static Intent f(String paramString)
  {
    String str = b.c(paramString).toLowerCase();
    if ((!"txt".equalsIgnoreCase(str)) && (!"sh".equalsIgnoreCase(str)) && (!"log".equalsIgnoreCase(str)) && (!"ini".equalsIgnoreCase(str)) && (!"xml".equalsIgnoreCase(str)))
    {
      if ((!"doc".equalsIgnoreCase(str)) && (!"docx".equalsIgnoreCase(str)))
      {
        if ((!"pptx".equalsIgnoreCase(str)) && (!"ppt".equalsIgnoreCase(str)))
        {
          if ((!"xls".equalsIgnoreCase(str)) && (!"xlsx".equalsIgnoreCase(str)))
          {
            if ((!"mp3".equalsIgnoreCase(str)) && (!"wav".equalsIgnoreCase(str)) && (!"flac".equalsIgnoreCase(str)))
            {
              if ("pdf".equalsIgnoreCase(str)) {
                return j(paramString);
              }
              if ((!"jpg".equalsIgnoreCase(str)) && (!"jpeg".equalsIgnoreCase(str)) && (!"png".equalsIgnoreCase(str)) && (!"gif".equalsIgnoreCase(str)))
              {
                if ((!"zip".equalsIgnoreCase(str)) && (!"7z".equalsIgnoreCase(str)) && (!"rar".equalsIgnoreCase(str)))
                {
                  if ((!"html".equalsIgnoreCase(str)) && (!"htm".equalsIgnoreCase(str)))
                  {
                    if ("apk".equalsIgnoreCase(str)) {
                      return b(paramString);
                    }
                    if ("mp4".equalsIgnoreCase(str)) {
                      return i(paramString);
                    }
                    return a(paramString);
                  }
                  return g(paramString);
                }
                return n(paramString);
              }
              return h(paramString);
            }
            return c(paramString);
          }
          return d(paramString);
        }
        return k(paramString);
      }
      return m(paramString);
    }
    return l(paramString);
  }
  
  private static Intent g(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "text/html");
    return localIntent;
  }
  
  private static Intent h(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "image/*");
    return localIntent;
  }
  
  private static Intent i(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "video/mp4");
    return localIntent;
  }
  
  private static Intent j(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "application/pdf");
    return localIntent;
  }
  
  private static Intent k(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "application/vnd.ms-powerpoint");
    return localIntent;
  }
  
  private static Intent l(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "text/plain");
    return localIntent;
  }
  
  private static Intent m(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "application/msword");
    return localIntent;
  }
  
  private static Intent n(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.addFlags(268435456);
    localIntent.addFlags(1);
    localIntent.setDataAndType(l.L(new File(paramString)), "application/zip");
    return localIntent;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.g0
 * JD-Core Version:    0.7.0.1
 */