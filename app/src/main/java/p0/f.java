package p0;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R.styleable;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

final class f
{
  private static a a(a parama, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (parama != null) {
      return parama;
    }
    if (paramBoolean)
    {
      parama = new a(paramInt1, paramInt3, paramInt2);
      return parama;
    }
    parama = new a(paramInt1, paramInt2);
    return parama;
  }
  
  static Shader b(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject = paramXmlPullParser.getName();
    if (((String)localObject).equals("gradient"))
    {
      localObject = i.k(paramResources, paramTheme, paramAttributeSet, R.styleable.GradientColor);
      float f1 = i.f((TypedArray)localObject, paramXmlPullParser, "startX", R.styleable.GradientColor_android_startX, 0.0F);
      float f2 = i.f((TypedArray)localObject, paramXmlPullParser, "startY", R.styleable.GradientColor_android_startY, 0.0F);
      float f3 = i.f((TypedArray)localObject, paramXmlPullParser, "endX", R.styleable.GradientColor_android_endX, 0.0F);
      float f4 = i.f((TypedArray)localObject, paramXmlPullParser, "endY", R.styleable.GradientColor_android_endY, 0.0F);
      float f5 = i.f((TypedArray)localObject, paramXmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0F);
      float f6 = i.f((TypedArray)localObject, paramXmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0F);
      int i = i.g((TypedArray)localObject, paramXmlPullParser, "type", R.styleable.GradientColor_android_type, 0);
      int j = i.b((TypedArray)localObject, paramXmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
      boolean bool = i.j(paramXmlPullParser, "centerColor");
      int k = i.b((TypedArray)localObject, paramXmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
      int m = i.b((TypedArray)localObject, paramXmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
      int n = i.g((TypedArray)localObject, paramXmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
      float f7 = i.f((TypedArray)localObject, paramXmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0F);
      ((TypedArray)localObject).recycle();
      paramResources = a(c(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme), j, m, bool, k);
      if (i != 1)
      {
        if (i != 2) {
          return new LinearGradient(f1, f2, f3, f4, paramResources.a, paramResources.b, d(n));
        }
        return new SweepGradient(f5, f6, paramResources.a, paramResources.b);
      }
      if (f7 > 0.0F) {
        return new RadialGradient(f5, f6, f7, paramResources.a, paramResources.b, d(n));
      }
      throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }
    paramResources = new StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": invalid gradient color tag ");
    paramResources.append((String)localObject);
    throw new XmlPullParserException(paramResources.toString());
  }
  
  private static a c(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    int i = paramXmlPullParser.getDepth() + 1;
    ArrayList localArrayList1 = new ArrayList(20);
    ArrayList localArrayList2 = new ArrayList(20);
    for (;;)
    {
      int j = paramXmlPullParser.next();
      if (j == 1) {
        break label241;
      }
      int k = paramXmlPullParser.getDepth();
      if ((k < i) && (j == 3)) {
        break label241;
      }
      if ((j == 2) && (k <= i) && (paramXmlPullParser.getName().equals("item")))
      {
        TypedArray localTypedArray = i.k(paramResources, paramTheme, paramAttributeSet, R.styleable.GradientColorItem);
        k = R.styleable.GradientColorItem_android_color;
        boolean bool1 = localTypedArray.hasValue(k);
        j = R.styleable.GradientColorItem_android_offset;
        boolean bool2 = localTypedArray.hasValue(j);
        if ((!bool1) || (!bool2)) {
          break;
        }
        k = localTypedArray.getColor(k, 0);
        float f = localTypedArray.getFloat(j, 0.0F);
        localTypedArray.recycle();
        localArrayList2.add(Integer.valueOf(k));
        localArrayList1.add(Float.valueOf(f));
      }
    }
    paramResources = new StringBuilder();
    paramResources.append(paramXmlPullParser.getPositionDescription());
    paramResources.append(": <item> tag requires a 'color' attribute and a 'offset' attribute!");
    throw new XmlPullParserException(paramResources.toString());
    label241:
    if (localArrayList2.size() > 0) {
      return new a(localArrayList2, localArrayList1);
    }
    return null;
  }
  
  private static Shader.TileMode d(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return Shader.TileMode.CLAMP;
      }
      return Shader.TileMode.MIRROR;
    }
    return Shader.TileMode.REPEAT;
  }
  
  static final class a
  {
    final int[] a;
    final float[] b;
    
    a(int paramInt1, int paramInt2)
    {
      this.a = new int[] { paramInt1, paramInt2 };
      this.b = new float[] { 0.0F, 1.0F };
    }
    
    a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = new int[] { paramInt1, paramInt2, paramInt3 };
      this.b = new float[] { 0.0F, 0.5F, 1.0F };
    }
    
    a(List<Integer> paramList, List<Float> paramList1)
    {
      int j = paramList.size();
      this.a = new int[j];
      this.b = new float[j];
      int i = 0;
      while (i < j)
      {
        this.a[i] = ((Integer)paramList.get(i)).intValue();
        this.b[i] = ((Float)paramList1.get(i)).floatValue();
        i += 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p0.f
 * JD-Core Version:    0.7.0.1
 */