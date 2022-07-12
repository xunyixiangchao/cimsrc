package e;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class c
{
  public static Drawable a(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    return Drawable.createFromXmlInner(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public static int b(TypedArray paramTypedArray)
  {
    return paramTypedArray.getChangingConfigurations();
  }
  
  public static void c(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e.c
 * JD-Core Version:    0.7.0.1
 */