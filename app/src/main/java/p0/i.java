package p0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

public class i
{
  public static boolean a(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, boolean paramBoolean)
  {
    if (!j(paramXmlPullParser, paramString)) {
      return paramBoolean;
    }
    return paramTypedArray.getBoolean(paramInt, paramBoolean);
  }
  
  public static int b(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!j(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getColor(paramInt1, paramInt2);
  }
  
  public static ColorStateList c(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme, String paramString, int paramInt)
  {
    if (j(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt, paramXmlPullParser);
      int i = paramXmlPullParser.type;
      if (i != 2)
      {
        if ((i >= 28) && (i <= 31)) {
          return d(paramXmlPullParser);
        }
        return c.d(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt, 0), paramTheme);
      }
      paramTypedArray = new StringBuilder();
      paramTypedArray.append("Failed to resolve attribute at index ");
      paramTypedArray.append(paramInt);
      paramTypedArray.append(": ");
      paramTypedArray.append(paramXmlPullParser);
      throw new UnsupportedOperationException(paramTypedArray.toString());
    }
    return null;
  }
  
  private static ColorStateList d(TypedValue paramTypedValue)
  {
    return ColorStateList.valueOf(paramTypedValue.data);
  }
  
  public static d e(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme, String paramString, int paramInt1, int paramInt2)
  {
    if (j(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt1, paramXmlPullParser);
      int i = paramXmlPullParser.type;
      if ((i >= 28) && (i <= 31)) {
        return d.b(paramXmlPullParser.data);
      }
      paramTypedArray = d.g(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt1, 0), paramTheme);
      if (paramTypedArray != null) {
        return paramTypedArray;
      }
    }
    return d.b(paramInt2);
  }
  
  public static float f(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt, float paramFloat)
  {
    if (!j(paramXmlPullParser, paramString)) {
      return paramFloat;
    }
    return paramTypedArray.getFloat(paramInt, paramFloat);
  }
  
  public static int g(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!j(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getInt(paramInt1, paramInt2);
  }
  
  public static int h(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt1, int paramInt2)
  {
    if (!j(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getResourceId(paramInt1, paramInt2);
  }
  
  public static String i(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    if (!j(paramXmlPullParser, paramString)) {
      return null;
    }
    return paramTypedArray.getString(paramInt);
  }
  
  public static boolean j(XmlPullParser paramXmlPullParser, String paramString)
  {
    return paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null;
  }
  
  public static TypedArray k(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
  
  public static TypedValue l(TypedArray paramTypedArray, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    if (!j(paramXmlPullParser, paramString)) {
      return null;
    }
    return paramTypedArray.peekValue(paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p0.i
 * JD-Core Version:    0.7.0.1
 */