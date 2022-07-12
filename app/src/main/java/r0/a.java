package r0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public final class a
{
  public static void a(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    paramDrawable.applyTheme(paramTheme);
  }
  
  public static boolean b(Drawable paramDrawable)
  {
    return paramDrawable.canApplyTheme();
  }
  
  public static void c(Drawable paramDrawable)
  {
    paramDrawable.clearColorFilter();
  }
  
  public static int d(Drawable paramDrawable)
  {
    return paramDrawable.getAlpha();
  }
  
  public static ColorFilter e(Drawable paramDrawable)
  {
    return paramDrawable.getColorFilter();
  }
  
  public static int f(Drawable paramDrawable)
  {
    return paramDrawable.getLayoutDirection();
  }
  
  public static void g(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public static boolean h(Drawable paramDrawable)
  {
    return paramDrawable.isAutoMirrored();
  }
  
  @Deprecated
  public static void i(Drawable paramDrawable)
  {
    paramDrawable.jumpToCurrentState();
  }
  
  public static void j(Drawable paramDrawable, boolean paramBoolean)
  {
    paramDrawable.setAutoMirrored(paramBoolean);
  }
  
  public static void k(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    paramDrawable.setHotspot(paramFloat1, paramFloat2);
  }
  
  public static void l(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static boolean m(Drawable paramDrawable, int paramInt)
  {
    return paramDrawable.setLayoutDirection(paramInt);
  }
  
  public static void n(Drawable paramDrawable, int paramInt)
  {
    paramDrawable.setTint(paramInt);
  }
  
  public static void o(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    paramDrawable.setTintList(paramColorStateList);
  }
  
  public static void p(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    paramDrawable.setTintMode(paramMode);
  }
  
  public static <T extends Drawable> T q(Drawable paramDrawable)
  {
    Drawable localDrawable = paramDrawable;
    if ((paramDrawable instanceof b)) {
      localDrawable = ((b)paramDrawable).b();
    }
    return localDrawable;
  }
  
  public static Drawable r(Drawable paramDrawable)
  {
    return paramDrawable;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r0.a
 * JD-Core Version:    0.7.0.1
 */