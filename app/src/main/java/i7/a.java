package i7;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a
{
  public static AttributeSet a(Context paramContext, int paramInt, CharSequence paramCharSequence)
  {
    try
    {
      paramContext = paramContext.getResources().getXml(paramInt);
      int i;
      do
      {
        i = paramContext.next();
      } while ((i != 2) && (i != 1));
      if (i == 2)
      {
        if (TextUtils.equals(paramContext.getName(), paramCharSequence)) {
          return Xml.asAttributeSet(paramContext);
        }
        paramContext = new StringBuilder();
        paramContext.append("Must have a <");
        paramContext.append(paramCharSequence);
        paramContext.append("> start tag");
        throw new XmlPullParserException(paramContext.toString());
      }
      throw new XmlPullParserException("No start tag found");
    }
    catch (IOException paramContext) {}catch (XmlPullParserException paramContext) {}
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Can't load badge resource ID #0x");
    paramCharSequence.append(Integer.toHexString(paramInt));
    paramCharSequence = new Resources.NotFoundException(paramCharSequence.toString());
    paramCharSequence.initCause(paramContext);
    throw paramCharSequence;
  }
  
  @TargetApi(21)
  public static void b(RippleDrawable paramRippleDrawable, int paramInt)
  {
    paramRippleDrawable.setRadius(paramInt);
  }
  
  public static PorterDuffColorFilter c(Drawable paramDrawable, ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(paramDrawable.getState(), 0), paramMode);
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i7.a
 * JD-Core Version:    0.7.0.1
 */