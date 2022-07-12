package com.farsunset.hoxin.common.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.http.SslError;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import s3.i0;
import u3.l;

public class CustomWebView
  extends WebView
  implements DownloadListener
{
  private ViewGroup.MarginLayoutParams a;
  private int b;
  private int c;
  private int d;
  private final int e = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
  private ValueCallback<Uri[]> f;
  private i0 g;
  private boolean h = false;
  private WebViewClient i = new a();
  private WebChromeClient j = new b();
  
  public CustomWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().setJavaScriptEnabled(true);
    getSettings().setMixedContentMode(0);
    getSettings().setBlockNetworkImage(false);
    getSettings().setDomStorageEnabled(true);
    getSettings().setDefaultTextEncodingName("utf-8");
    setWebViewClient(this.i);
    setWebChromeClient(this.j);
    setDownloadListener(this);
  }
  
  @SuppressLint({"JavascriptInterface"})
  public void c(Object paramObject)
  {
    addJavascriptInterface(paramObject, "app");
  }
  
  public void d()
  {
    this.f.onReceiveValue(null);
    this.f = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.h) && (getScrollY() == 0))
    {
      int k = paramMotionEvent.getAction();
      if (k != 0)
      {
        if (k != 1)
        {
          if (k != 2) {
            break label190;
          }
          if (paramMotionEvent.getY() > this.c)
          {
            k = Math.min((int)(this.d + (paramMotionEvent.getY() - this.c) / 3.0F), this.e);
            this.b = k;
            this.a.setMargins(0, k, 0, 0);
            setLayoutParams(this.a);
          }
          float f1 = paramMotionEvent.getY();
          k = this.c;
          if (f1 >= k) {
            break label190;
          }
          k = Math.max((int)(this.d - (k - paramMotionEvent.getY()) / 3.0F), this.d);
        }
        else
        {
          k = this.d;
        }
        this.b = k;
        this.a.setMargins(0, k, 0, 0);
        setLayoutParams(this.a);
      }
      else
      {
        this.c = ((int)paramMotionEvent.getY());
      }
      label190:
      k = this.b;
      if ((k != 0) && (k != this.d)) {
        return false;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e(Uri paramUri)
  {
    this.f.onReceiveValue(new Uri[] { paramUri });
    this.f = null;
  }
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    l.q(paramString1, paramString3, paramString4);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.h) && (paramBoolean) && (this.d == 0))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
      this.a = localMarginLayoutParams;
      this.d = localMarginLayoutParams.topMargin;
    }
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setTextZoom(int paramInt)
  {
    getSettings().setTextZoom(paramInt);
  }
  
  public void setWebViewListener(i0 parami0)
  {
    this.g = parami0;
  }
  
  class a
    extends WebViewClient
  {
    a() {}
    
    public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      paramSslErrorHandler.proceed();
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      return false;
    }
  }
  
  class b
    extends WebChromeClient
  {
    b() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      CustomWebView.a(CustomWebView.this).Q(paramInt);
      super.onProgressChanged(paramWebView, paramInt);
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      CustomWebView.a(CustomWebView.this).t(paramString);
    }
    
    public boolean onShowFileChooser(WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, WebChromeClient.FileChooserParams paramFileChooserParams)
    {
      CustomWebView.b(CustomWebView.this, paramValueCallback);
      paramWebView = new Intent("android.intent.action.OPEN_DOCUMENT");
      paramWebView.addCategory("android.intent.category.OPENABLE");
      boolean bool;
      if (paramFileChooserParams.getMode() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramWebView.putExtra("android.intent.extra.ALLOW_MULTIPLE", bool);
      paramWebView.setType("*/*");
      ((Activity)CustomWebView.this.getContext()).startActivityForResult(Intent.createChooser(paramWebView, l.I(2131689704)), 321);
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.CustomWebView
 * JD-Core Version:    0.7.0.1
 */