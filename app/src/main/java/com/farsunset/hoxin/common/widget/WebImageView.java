package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.google.android.material.imageview.ShapeableImageView;
import java.io.File;
import s3.c;
import u3.l;
import u3.r;
import u3.s;

public class WebImageView
  extends ShapeableImageView
{
  public WebImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void k(Uri paramUri, int paramInt)
  {
    if (paramUri == null) {
      return;
    }
    p(paramUri.toString(), paramInt);
  }
  
  public void l(File paramFile)
  {
    p(l.L(paramFile).toString(), 0);
  }
  
  public void m(File paramFile, int paramInt)
  {
    p(l.L(paramFile).toString(), paramInt);
  }
  
  public void n(File paramFile, c paramc)
  {
    q(l.L(paramFile).toString(), 0, paramc);
  }
  
  public void o(String paramString)
  {
    p(paramString, 0);
  }
  
  public void p(String paramString, int paramInt)
  {
    q(paramString, paramInt, null);
  }
  
  public void q(String paramString, int paramInt, c paramc)
  {
    s.a().i(this, paramString, paramInt, paramc);
  }
  
  public void r(String paramString, c paramc)
  {
    q(paramString, 0, paramc);
  }
  
  public void s(String paramString, int paramInt)
  {
    s.a().m(this, paramString, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.WebImageView
 * JD-Core Version:    0.7.0.1
 */