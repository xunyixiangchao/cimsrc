package w0;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Locale;
import x0.c;

public class b
  implements Spannable
{
  private static final Object d = new Object();
  private final Spannable a;
  private final a b;
  private final PrecomputedText c;
  
  public a a()
  {
    return this.b;
  }
  
  public PrecomputedText b()
  {
    Spannable localSpannable = this.a;
    if ((localSpannable instanceof PrecomputedText)) {
      return (PrecomputedText)localSpannable;
    }
    return null;
  }
  
  public char charAt(int paramInt)
  {
    return this.a.charAt(paramInt);
  }
  
  public int getSpanEnd(Object paramObject)
  {
    return this.a.getSpanEnd(paramObject);
  }
  
  public int getSpanFlags(Object paramObject)
  {
    return this.a.getSpanFlags(paramObject);
  }
  
  public int getSpanStart(Object paramObject)
  {
    return this.a.getSpanStart(paramObject);
  }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return this.c.getSpans(paramInt1, paramInt2, paramClass);
    }
    return this.a.getSpans(paramInt1, paramInt2, paramClass);
  }
  
  public int length()
  {
    return this.a.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    return this.a.nextSpanTransition(paramInt1, paramInt2, paramClass);
  }
  
  public void removeSpan(Object paramObject)
  {
    if (!(paramObject instanceof MetricAffectingSpan))
    {
      if (Build.VERSION.SDK_INT >= 29)
      {
        this.c.removeSpan(paramObject);
        return;
      }
      this.a.removeSpan(paramObject);
      return;
    }
    throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!(paramObject instanceof MetricAffectingSpan))
    {
      if (Build.VERSION.SDK_INT >= 29)
      {
        this.c.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
        return;
      }
      this.a.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
      return;
    }
    throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return this.a.subSequence(paramInt1, paramInt2);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public static final class a
  {
    private final TextPaint a;
    private final TextDirectionHeuristic b;
    private final int c;
    private final int d;
    final PrecomputedText.Params e;
    
    public a(PrecomputedText.Params paramParams)
    {
      this.a = paramParams.getTextPaint();
      this.b = paramParams.getTextDirection();
      this.c = paramParams.getBreakStrategy();
      this.d = paramParams.getHyphenationFrequency();
      if (Build.VERSION.SDK_INT < 29) {
        paramParams = null;
      }
      this.e = paramParams;
    }
    
    a(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
    {
      PrecomputedText.Params localParams;
      if (Build.VERSION.SDK_INT >= 29) {
        localParams = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();
      } else {
        localParams = null;
      }
      this.e = localParams;
      this.a = paramTextPaint;
      this.b = paramTextDirectionHeuristic;
      this.c = paramInt1;
      this.d = paramInt2;
    }
    
    public boolean a(a parama)
    {
      int i = Build.VERSION.SDK_INT;
      if (this.c != parama.b()) {
        return false;
      }
      if (this.d != parama.c()) {
        return false;
      }
      if (this.a.getTextSize() != parama.e().getTextSize()) {
        return false;
      }
      if (this.a.getTextScaleX() != parama.e().getTextScaleX()) {
        return false;
      }
      if (this.a.getTextSkewX() != parama.e().getTextSkewX()) {
        return false;
      }
      if (this.a.getLetterSpacing() != parama.e().getLetterSpacing()) {
        return false;
      }
      if (!TextUtils.equals(this.a.getFontFeatureSettings(), parama.e().getFontFeatureSettings())) {
        return false;
      }
      if (this.a.getFlags() != parama.e().getFlags()) {
        return false;
      }
      if (i >= 24)
      {
        if (!this.a.getTextLocales().equals(parama.e().getTextLocales())) {
          return false;
        }
      }
      else if (!this.a.getTextLocale().equals(parama.e().getTextLocale())) {
        return false;
      }
      if (this.a.getTypeface() == null)
      {
        if (parama.e().getTypeface() != null) {
          return false;
        }
      }
      else if (!this.a.getTypeface().equals(parama.e().getTypeface())) {
        return false;
      }
      return true;
    }
    
    public int b()
    {
      return this.c;
    }
    
    public int c()
    {
      return this.d;
    }
    
    public TextDirectionHeuristic d()
    {
      return this.b;
    }
    
    public TextPaint e()
    {
      return this.a;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (!a(paramObject)) {
        return false;
      }
      return this.b == paramObject.d();
    }
    
    public int hashCode()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return c.b(new Object[] { Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d) });
      }
      return c.b(new Object[] { Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d) });
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder2 = new StringBuilder("{");
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("textSize=");
      localStringBuilder1.append(this.a.getTextSize());
      localStringBuilder2.append(localStringBuilder1.toString());
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(", textScaleX=");
      localStringBuilder1.append(this.a.getTextScaleX());
      localStringBuilder2.append(localStringBuilder1.toString());
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(", textSkewX=");
      localStringBuilder1.append(this.a.getTextSkewX());
      localStringBuilder2.append(localStringBuilder1.toString());
      int i = Build.VERSION.SDK_INT;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(", letterSpacing=");
      localStringBuilder1.append(this.a.getLetterSpacing());
      localStringBuilder2.append(localStringBuilder1.toString());
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(", elegantTextHeight=");
      localStringBuilder1.append(this.a.isElegantTextHeight());
      localStringBuilder2.append(localStringBuilder1.toString());
      if (i >= 24)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(", textLocale=");
      }
      for (Object localObject = this.a.getTextLocales();; localObject = this.a.getTextLocale())
      {
        localStringBuilder1.append(localObject);
        localStringBuilder2.append(localStringBuilder1.toString());
        break;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(", textLocale=");
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(", typeface=");
      localStringBuilder1.append(this.a.getTypeface());
      localStringBuilder2.append(localStringBuilder1.toString());
      if (i >= 26)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(", variationSettings=");
        localStringBuilder1.append(this.a.getFontVariationSettings());
        localStringBuilder2.append(localStringBuilder1.toString());
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(", textDir=");
      localStringBuilder1.append(this.b);
      localStringBuilder2.append(localStringBuilder1.toString());
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(", breakStrategy=");
      localStringBuilder1.append(this.c);
      localStringBuilder2.append(localStringBuilder1.toString());
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(", hyphenationFrequency=");
      localStringBuilder1.append(this.d);
      localStringBuilder2.append(localStringBuilder1.toString());
      localStringBuilder2.append("}");
      return localStringBuilder2.toString();
    }
    
    public static class a
    {
      private final TextPaint a;
      private TextDirectionHeuristic b;
      private int c;
      private int d;
      
      public a(TextPaint paramTextPaint)
      {
        this.a = paramTextPaint;
        this.c = 1;
        this.d = 1;
        this.b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
      }
      
      public b.a a()
      {
        return new b.a(this.a, this.b, this.c, this.d);
      }
      
      public a b(int paramInt)
      {
        this.c = paramInt;
        return this;
      }
      
      public a c(int paramInt)
      {
        this.d = paramInt;
        return this;
      }
      
      public a d(TextDirectionHeuristic paramTextDirectionHeuristic)
      {
        this.b = paramTextDirectionHeuristic;
        return this;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     w0.b
 * JD-Core Version:    0.7.0.1
 */