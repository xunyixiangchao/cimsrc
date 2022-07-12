package com.baidu.platform.comapi.util.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.vi.VIContext;
import java.io.File;

public class b
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public String a()
  {
    if (TextUtils.isEmpty(this.c)) {
      a(VIContext.getContext());
    }
    return this.c;
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext.getFilesDir().getAbsolutePath();
    this.d = paramContext.getCacheDir().getAbsolutePath();
    this.b = Environment.getExternalStorageDirectory().getPath();
    this.c = Environment.getExternalStorageDirectory().getPath();
    File localFile = paramContext.getExternalFilesDir(null);
    if (localFile != null) {
      this.e = localFile.getAbsolutePath();
    }
    paramContext = paramContext.getExternalCacheDir();
    if (paramContext != null) {
      paramContext.getAbsolutePath();
    }
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.e)) {
      a(VIContext.getContext());
    }
    return this.e;
  }
  
  public String c()
  {
    if (TextUtils.isEmpty(this.d)) {
      a(VIContext.getContext());
    }
    return this.d;
  }
  
  public String d()
  {
    if (TextUtils.isEmpty(this.a)) {
      a(VIContext.getContext());
    }
    return this.a;
  }
  
  public String e()
  {
    if (TextUtils.isEmpty(this.b)) {
      a(VIContext.getContext());
    }
    return this.b;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.a.b
 * JD-Core Version:    0.7.0.1
 */