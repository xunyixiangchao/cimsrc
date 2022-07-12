package p0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R.styleable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import v0.d;

public class e
{
  private static int a(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getType(paramInt);
  }
  
  public static a b(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i == 2) {
      return d(paramXmlPullParser, paramResources);
    }
    throw new XmlPullParserException("No start tag found");
  }
  
  public static List<List<byte[]>> c(Resources paramResources, int paramInt)
  {
    if (paramInt == 0) {
      return Collections.emptyList();
    }
    TypedArray localTypedArray = paramResources.obtainTypedArray(paramInt);
    for (;;)
    {
      try
      {
        if (localTypedArray.length() == 0)
        {
          paramResources = Collections.emptyList();
          return paramResources;
        }
        ArrayList localArrayList = new ArrayList();
        if (a(localTypedArray, 0) == 1)
        {
          paramInt = 0;
          if (paramInt < localTypedArray.length())
          {
            int i = localTypedArray.getResourceId(paramInt, 0);
            if (i == 0) {
              break label119;
            }
            localArrayList.add(h(paramResources.getStringArray(i)));
            break label119;
          }
        }
        else
        {
          localArrayList.add(h(paramResources.getStringArray(paramInt)));
        }
        return localArrayList;
      }
      finally
      {
        localTypedArray.recycle();
      }
      label119:
      paramInt += 1;
    }
  }
  
  private static a d(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    paramXmlPullParser.require(2, null, "font-family");
    if (paramXmlPullParser.getName().equals("font-family")) {
      return e(paramXmlPullParser, paramResources);
    }
    g(paramXmlPullParser);
    return null;
  }
  
  private static a e(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    Object localObject = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamily);
    String str1 = ((TypedArray)localObject).getString(R.styleable.FontFamily_fontProviderAuthority);
    String str2 = ((TypedArray)localObject).getString(R.styleable.FontFamily_fontProviderPackage);
    String str3 = ((TypedArray)localObject).getString(R.styleable.FontFamily_fontProviderQuery);
    int i = ((TypedArray)localObject).getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
    int j = ((TypedArray)localObject).getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
    int k = ((TypedArray)localObject).getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
    String str4 = ((TypedArray)localObject).getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
    ((TypedArray)localObject).recycle();
    if ((str1 != null) && (str2 != null) && (str3 != null))
    {
      while (paramXmlPullParser.next() != 3) {
        g(paramXmlPullParser);
      }
      return new d(new d(str1, str2, str3, c(paramResources, i)), j, k, str4);
    }
    localObject = new ArrayList();
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2) {
        if (paramXmlPullParser.getName().equals("font")) {
          ((List)localObject).add(f(paramXmlPullParser, paramResources));
        } else {
          g(paramXmlPullParser);
        }
      }
    }
    if (((List)localObject).isEmpty()) {
      return null;
    }
    return new b((c[])((List)localObject).toArray(new c[((List)localObject).size()]));
  }
  
  private static c f(XmlPullParser paramXmlPullParser, Resources paramResources)
  {
    paramResources = paramResources.obtainAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.FontFamilyFont);
    int i = R.styleable.FontFamilyFont_fontWeight;
    if (!paramResources.hasValue(i)) {
      i = R.styleable.FontFamilyFont_android_fontWeight;
    }
    int k = paramResources.getInt(i, 400);
    i = R.styleable.FontFamilyFont_fontStyle;
    if (!paramResources.hasValue(i)) {
      i = R.styleable.FontFamilyFont_android_fontStyle;
    }
    boolean bool;
    if (1 == paramResources.getInt(i, 0)) {
      bool = true;
    } else {
      bool = false;
    }
    i = R.styleable.FontFamilyFont_ttcIndex;
    if (!paramResources.hasValue(i)) {
      i = R.styleable.FontFamilyFont_android_ttcIndex;
    }
    int j = R.styleable.FontFamilyFont_fontVariationSettings;
    if (!paramResources.hasValue(j)) {
      j = R.styleable.FontFamilyFont_android_fontVariationSettings;
    }
    String str1 = paramResources.getString(j);
    j = paramResources.getInt(i, 0);
    i = R.styleable.FontFamilyFont_font;
    if (!paramResources.hasValue(i)) {
      i = R.styleable.FontFamilyFont_android_font;
    }
    int m = paramResources.getResourceId(i, 0);
    String str2 = paramResources.getString(i);
    paramResources.recycle();
    while (paramXmlPullParser.next() != 3) {
      g(paramXmlPullParser);
    }
    return new c(str2, k, bool, str1, j, m);
  }
  
  private static void g(XmlPullParser paramXmlPullParser)
  {
    int i = 1;
    while (i > 0)
    {
      int j = paramXmlPullParser.next();
      if (j != 2)
      {
        if (j == 3) {
          i -= 1;
        }
      }
      else {
        i += 1;
      }
    }
  }
  
  private static List<byte[]> h(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Base64.decode(paramArrayOfString[i], 0));
      i += 1;
    }
    return localArrayList;
  }
  
  public static abstract interface a {}
  
  public static final class b
    implements e.a
  {
    private final e.c[] a;
    
    public b(e.c[] paramArrayOfc)
    {
      this.a = paramArrayOfc;
    }
    
    public e.c[] a()
    {
      return this.a;
    }
  }
  
  public static final class c
  {
    private final String a;
    private int b;
    private boolean c;
    private String d;
    private int e;
    private int f;
    
    public c(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, int paramInt2, int paramInt3)
    {
      this.a = paramString1;
      this.b = paramInt1;
      this.c = paramBoolean;
      this.d = paramString2;
      this.e = paramInt2;
      this.f = paramInt3;
    }
    
    public String a()
    {
      return this.a;
    }
    
    public int b()
    {
      return this.f;
    }
    
    public int c()
    {
      return this.e;
    }
    
    public String d()
    {
      return this.d;
    }
    
    public int e()
    {
      return this.b;
    }
    
    public boolean f()
    {
      return this.c;
    }
  }
  
  public static final class d
    implements e.a
  {
    private final d a;
    private final int b;
    private final int c;
    private final String d;
    
    public d(d paramd, int paramInt1, int paramInt2, String paramString)
    {
      this.a = paramd;
      this.c = paramInt1;
      this.b = paramInt2;
      this.d = paramString;
    }
    
    public int a()
    {
      return this.c;
    }
    
    public d b()
    {
      return this.a;
    }
    
    public String c()
    {
      return this.d;
    }
    
    public int d()
    {
      return this.b;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p0.e
 * JD-Core Version:    0.7.0.1
 */