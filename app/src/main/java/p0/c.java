package p0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R.attr;
import androidx.core.R.styleable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class c
{
  private static final ThreadLocal<TypedValue> a = new ThreadLocal();
  
  public static ColorStateList a(Resources paramResources, XmlPullParser paramXmlPullParser, Resources.Theme paramTheme)
  {
    AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2) {
      return b(paramResources, paramXmlPullParser, localAttributeSet, paramTheme);
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  public static ColorStateList b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    String str = paramXmlPullParser.getName();
    if (str.equals("selector")) {
      return e(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    paramResources = new StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": invalid color state list tag ");
    paramResources.append(str);
    throw new XmlPullParserException(paramResources.toString());
  }
  
  private static TypedValue c()
  {
    ThreadLocal localThreadLocal = a;
    TypedValue localTypedValue2 = (TypedValue)localThreadLocal.get();
    TypedValue localTypedValue1 = localTypedValue2;
    if (localTypedValue2 == null)
    {
      localTypedValue1 = new TypedValue();
      localThreadLocal.set(localTypedValue1);
    }
    return localTypedValue1;
  }
  
  public static ColorStateList d(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    try
    {
      paramResources = a(paramResources, paramResources.getXml(paramInt), paramTheme);
      return paramResources;
    }
    catch (Exception paramResources)
    {
      Log.e("CSLCompat", "Failed to inflate ColorStateList.", paramResources);
    }
    return null;
  }
  
  private static ColorStateList e(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    int i2 = paramXmlPullParser.getDepth() + 1;
    Object localObject1 = new int[20][];
    Object localObject2 = new int[20];
    int j;
    for (int i = 0;; i = j)
    {
      Resources localResources = paramResources;
      int k = paramXmlPullParser.next();
      if (k == 1) {
        break;
      }
      int m = paramXmlPullParser.getDepth();
      if ((m < i2) && (k == 3)) {
        break;
      }
      Object localObject4 = localObject2;
      Object localObject3 = localObject1;
      j = i;
      if (k == 2)
      {
        localObject4 = localObject2;
        localObject3 = localObject1;
        j = i;
        if (m <= i2) {
          if (!paramXmlPullParser.getName().equals("item"))
          {
            localObject4 = localObject2;
            localObject3 = localObject1;
            j = i;
          }
          else
          {
            localObject3 = h(localResources, paramTheme, paramAttributeSet, R.styleable.ColorStateListItem);
            k = R.styleable.ColorStateListItem_android_color;
            m = ((TypedArray)localObject3).getResourceId(k, -1);
            j = k;
            if (m != -1)
            {
              j = k;
              if (f(localResources, m)) {}
            }
          }
        }
      }
      try
      {
        j = a(localResources, localResources.getXml(m), paramTheme).getDefaultColor();
      }
      catch (Exception localException)
      {
        label202:
        float f1;
        float f2;
        int i3;
        int n;
        break label202;
      }
      j = R.styleable.ColorStateListItem_android_color;
      j = ((TypedArray)localObject3).getColor(j, -65281);
      f1 = 1.0F;
      k = R.styleable.ColorStateListItem_android_alpha;
      if (((TypedArray)localObject3).hasValue(k)) {}
      do
      {
        f1 = ((TypedArray)localObject3).getFloat(k, 1.0F);
        break;
        k = R.styleable.ColorStateListItem_alpha;
      } while (((TypedArray)localObject3).hasValue(k));
      if (u0.a.c())
      {
        k = R.styleable.ColorStateListItem_android_lStar;
        if (((TypedArray)localObject3).hasValue(k)) {}
      }
      else
      {
        k = R.styleable.ColorStateListItem_lStar;
      }
      f2 = ((TypedArray)localObject3).getFloat(k, -1.0F);
      ((TypedArray)localObject3).recycle();
      i3 = paramAttributeSet.getAttributeCount();
      localObject3 = new int[i3];
      k = 0;
      for (m = 0; k < i3; m = n)
      {
        int i1 = paramAttributeSet.getAttributeNameResource(k);
        n = m;
        if (i1 != 16843173)
        {
          n = m;
          if (i1 != 16843551)
          {
            n = m;
            if (i1 != R.attr.alpha)
            {
              n = m;
              if (i1 != R.attr.lStar)
              {
                if (paramAttributeSet.getAttributeBooleanValue(k, false)) {
                  n = i1;
                } else {
                  n = -i1;
                }
                localObject3[m] = n;
                n = m + 1;
              }
            }
          }
        }
        k += 1;
      }
      localObject3 = StateSet.trimStateSet((int[])localObject3, m);
      localObject4 = g.a((int[])localObject2, i, g(j, f1, f2));
      localObject3 = (int[][])g.b((Object[])localObject1, i, localObject3);
      j = i + 1;
      localObject2 = localObject4;
      localObject1 = localObject3;
    }
    paramResources = new int[i];
    paramXmlPullParser = new int[i][];
    System.arraycopy(localObject2, 0, paramResources, 0, i);
    System.arraycopy(localObject1, 0, paramXmlPullParser, 0, i);
    return new ColorStateList(paramXmlPullParser, paramResources);
  }
  
  private static boolean f(Resources paramResources, int paramInt)
  {
    TypedValue localTypedValue = c();
    paramResources.getValue(paramInt, localTypedValue, true);
    paramInt = localTypedValue.type;
    return (paramInt >= 28) && (paramInt <= 31);
  }
  
  private static int g(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i;
    if ((paramFloat2 >= 0.0F) && (paramFloat2 <= 100.0F)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramFloat1 == 1.0F) && (i == 0)) {
      return paramInt;
    }
    int k = t0.a.b((int)(Color.alpha(paramInt) * paramFloat1 + 0.5F), 0, 255);
    int j = paramInt;
    if (i != 0)
    {
      a locala = a.c(paramInt);
      j = a.m(locala.j(), locala.i(), paramFloat2);
    }
    return j & 0xFFFFFF | k << 24;
  }
  
  private static TypedArray h(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p0.c
 * JD-Core Version:    0.7.0.1
 */