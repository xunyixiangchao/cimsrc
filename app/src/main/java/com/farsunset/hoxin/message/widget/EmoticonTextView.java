package com.farsunset.hoxin.message.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatTextView;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.ui.WebViewActivity;
import d4.b;
import java.util.regex.Matcher;

public class EmoticonTextView
  extends AppCompatTextView
{
  private int a = 16;
  private final DisplayMetrics b = Resources.getSystem().getDisplayMetrics();
  private final int c = getAutoLinkMask();
  
  public EmoticonTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Spannable k(CharSequence paramCharSequence)
  {
    Object localObject;
    if ((paramCharSequence instanceof Spannable)) {
      localObject = (Spannable)paramCharSequence;
    } else {
      localObject = new SpannableString(paramCharSequence);
    }
    paramCharSequence = b.d().i(paramCharSequence);
    while (paramCharSequence.find())
    {
      Drawable localDrawable = b.d().e(paramCharSequence.group());
      if (localDrawable != null)
      {
        int i = (int)TypedValue.applyDimension(1, this.a, this.b);
        localDrawable.setBounds(0, 0, i, i);
        ((Spannable)localObject).setSpan(new a(localDrawable), paramCharSequence.start(), paramCharSequence.end(), 33);
      }
    }
    return localObject;
  }
  
  public void setFaceSize(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((paramCharSequence != null) && (!TextUtils.isEmpty(paramCharSequence.toString().trim())))
    {
      int i = getAutoLinkMask();
      int j = this.c;
      if (i != j) {
        super.setAutoLinkMask(j);
      }
      super.setText(k(paramCharSequence), paramBufferType);
      if ((getText() instanceof Spannable))
      {
        Spannable localSpannable = (Spannable)getText();
        paramCharSequence = (URLSpan[])localSpannable.getSpans(0, paramCharSequence.length(), URLSpan.class);
        j = paramCharSequence.length;
        i = 0;
        while (i < j)
        {
          Object localObject = paramCharSequence[i];
          int k = localSpannable.getSpanStart(localObject);
          int m = localSpannable.getSpanEnd(localObject);
          localSpannable.removeSpan(localObject);
          localSpannable.setSpan(new URLClickableSpan(localObject.getURL()), k, m, 33);
          i += 1;
        }
        super.setAutoLinkMask(0);
        super.setText(localSpannable, paramBufferType);
      }
      return;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
  
  static class URLClickableSpan
    extends URLSpan
  {
    URLClickableSpan(String paramString)
    {
      super();
    }
    
    public void onClick(View paramView)
    {
      paramView = Uri.parse(getURL());
      Intent localIntent;
      if (paramView.toString().startsWith("tel:"))
      {
        localIntent = new Intent("android.intent.action.DIAL", paramView);
        localIntent.setFlags(268435456);
        HoxinApplication.h().startActivity(localIntent);
      }
      if (paramView.toString().startsWith("mailto:"))
      {
        localIntent = new Intent("android.intent.action.SENDTO", paramView);
        localIntent.setFlags(268435456);
        HoxinApplication.h().startActivity(localIntent);
      }
      if ((paramView.toString().startsWith("https://")) || (paramView.toString().startsWith("http://")))
      {
        localIntent = new Intent(HoxinApplication.h(), WebViewActivity.class);
        localIntent.addFlags(268435456);
        localIntent.setData(paramView);
        HoxinApplication.h().startActivity(localIntent);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setUnderlineText(false);
    }
  }
  
  static class a
    extends ImageSpan
  {
    a(Drawable paramDrawable)
    {
      super();
    }
    
    public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
    {
      paramCanvas.save();
      paramCanvas.translate(paramFloat, (paramInt5 - paramInt3 - getDrawable().getBounds().bottom) / 2 + paramInt3);
      getDrawable().draw(paramCanvas);
      paramCanvas.restore();
    }
    
    public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      paramCharSequence = getDrawable().getBounds();
      if (paramFontMetricsInt != null)
      {
        paramPaint = paramPaint.getFontMetricsInt();
        paramInt2 = paramPaint.bottom;
        int i = paramPaint.top;
        paramInt1 = (paramCharSequence.bottom - paramCharSequence.top) / 2;
        i = (paramInt2 - i) / 4;
        paramInt2 = paramInt1 - i;
        paramInt1 = -(paramInt1 + i);
        paramFontMetricsInt.ascent = paramInt1;
        paramFontMetricsInt.top = paramInt1;
        paramFontMetricsInt.bottom = paramInt2;
        paramFontMetricsInt.descent = paramInt2;
      }
      return paramCharSequence.right;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.message.widget.EmoticonTextView
 * JD-Core Version:    0.7.0.1
 */