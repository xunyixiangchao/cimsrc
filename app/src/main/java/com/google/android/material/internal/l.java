package com.google.android.material.internal;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;

final class l
{
  static final int n = 1;
  private CharSequence a;
  private final TextPaint b;
  private final int c;
  private int d;
  private int e;
  private Layout.Alignment f;
  private int g;
  private float h;
  private float i;
  private int j;
  private boolean k;
  private boolean l;
  private TextUtils.TruncateAt m;
  
  private l(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    this.a = paramCharSequence;
    this.b = paramTextPaint;
    this.c = paramInt;
    this.d = 0;
    this.e = paramCharSequence.length();
    this.f = Layout.Alignment.ALIGN_NORMAL;
    this.g = 2147483647;
    this.h = 0.0F;
    this.i = 1.0F;
    this.j = n;
    this.k = true;
    this.m = null;
  }
  
  public static l b(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
  {
    return new l(paramCharSequence, paramTextPaint, paramInt);
  }
  
  public StaticLayout a()
  {
    if (this.a == null) {
      this.a = "";
    }
    int i1 = Math.max(0, this.c);
    Object localObject2 = this.a;
    Object localObject1 = localObject2;
    if (this.g == 1) {
      localObject1 = TextUtils.ellipsize((CharSequence)localObject2, this.b, i1, this.m);
    }
    int i2 = Math.min(((CharSequence)localObject1).length(), this.e);
    this.e = i2;
    if ((this.l) && (this.g == 1)) {
      this.f = Layout.Alignment.ALIGN_OPPOSITE;
    }
    localObject2 = StaticLayout.Builder.obtain((CharSequence)localObject1, this.d, i2, this.b, i1);
    ((StaticLayout.Builder)localObject2).setAlignment(this.f);
    ((StaticLayout.Builder)localObject2).setIncludePad(this.k);
    if (this.l) {
      localObject1 = TextDirectionHeuristics.RTL;
    } else {
      localObject1 = TextDirectionHeuristics.LTR;
    }
    ((StaticLayout.Builder)localObject2).setTextDirection((TextDirectionHeuristic)localObject1);
    localObject1 = this.m;
    if (localObject1 != null) {
      ((StaticLayout.Builder)localObject2).setEllipsize((TextUtils.TruncateAt)localObject1);
    }
    ((StaticLayout.Builder)localObject2).setMaxLines(this.g);
    float f1 = this.h;
    if ((f1 != 0.0F) || (this.i != 1.0F)) {
      ((StaticLayout.Builder)localObject2).setLineSpacing(f1, this.i);
    }
    if (this.g > 1) {
      ((StaticLayout.Builder)localObject2).setHyphenationFrequency(this.j);
    }
    return ((StaticLayout.Builder)localObject2).build();
  }
  
  public l c(Layout.Alignment paramAlignment)
  {
    this.f = paramAlignment;
    return this;
  }
  
  public l d(TextUtils.TruncateAt paramTruncateAt)
  {
    this.m = paramTruncateAt;
    return this;
  }
  
  public l e(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public l f(boolean paramBoolean)
  {
    this.k = paramBoolean;
    return this;
  }
  
  public l g(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
  
  public l h(float paramFloat1, float paramFloat2)
  {
    this.h = paramFloat1;
    this.i = paramFloat2;
    return this;
  }
  
  public l i(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  static class a
    extends Exception
  {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.internal.l
 * JD-Core Version:    0.7.0.1
 */