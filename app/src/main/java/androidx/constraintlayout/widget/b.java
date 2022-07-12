package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class b
{
  private final ConstraintLayout a;
  c b;
  int c = -1;
  int d = -1;
  private SparseArray<a> e = new SparseArray();
  private SparseArray<c> f = new SparseArray();
  
  b(Context paramContext, ConstraintLayout paramConstraintLayout, int paramInt)
  {
    this.a = paramConstraintLayout;
    a(paramContext, paramInt);
  }
  
  private void a(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    Object localObject1 = null;
    int i;
    try
    {
      paramInt = localXmlResourceParser.getEventType();
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      label163:
      label177:
      label212:
      label241:
      paramContext.printStackTrace();
    }
    Object localObject2 = localXmlResourceParser.getName();
    switch (((String)localObject2).hashCode())
    {
    case 1901439077: 
      if (((String)localObject2).equals("Variant")) {
        paramInt = 3;
      }
      break;
    case 1657696882: 
      if (((String)localObject2).equals("layoutDescription")) {
        paramInt = 0;
      }
      break;
    case 1382829617: 
      if (((String)localObject2).equals("StateSet")) {
        paramInt = i;
      }
      break;
    case 80204913: 
      if (((String)localObject2).equals("State")) {
        paramInt = 2;
      }
      break;
    case -1349929691: 
      if (((String)localObject2).equals("ConstraintSet"))
      {
        paramInt = 4;
        break label305;
        b(paramContext, localXmlResourceParser);
        localObject2 = localObject1;
        break;
        b localb = new b(paramContext, localXmlResourceParser);
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject1.a(localb);
          localObject2 = localObject1;
          break;
          localObject2 = new a(paramContext, localXmlResourceParser);
          this.e.put(((a)localObject2).a, localObject2);
          break;
          localXmlResourceParser.getName();
          localObject2 = localObject1;
        }
      }
      break;
    }
    for (;;)
    {
      paramInt = localXmlResourceParser.next();
      localObject1 = localObject2;
      do
      {
        return;
        i = 1;
      } while (paramInt == 1);
      if (paramInt == 0) {
        break label241;
      }
      if (paramInt == 2) {
        break;
      }
      localObject2 = localObject1;
      continue;
      paramInt = -1;
      label305:
      if (paramInt == 2) {
        break label212;
      }
      if (paramInt == 3) {
        break label177;
      }
      if (paramInt == 4) {
        break label163;
      }
      localObject2 = localObject1;
    }
  }
  
  private void b(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    c localc = new c();
    int j = paramXmlPullParser.getAttributeCount();
    int i = 0;
    while (i < j)
    {
      String str2 = paramXmlPullParser.getAttributeName(i);
      String str1 = paramXmlPullParser.getAttributeValue(i);
      if ((str2 != null) && (str1 != null) && ("id".equals(str2)))
      {
        if (str1.contains("/"))
        {
          str2 = str1.substring(str1.indexOf('/') + 1);
          i = paramContext.getResources().getIdentifier(str2, "id", paramContext.getPackageName());
        }
        else
        {
          i = -1;
        }
        j = i;
        if (i == -1) {
          if (str1.length() > 1)
          {
            j = Integer.parseInt(str1.substring(1));
          }
          else
          {
            Log.e("ConstraintLayoutStates", "error in parsing id");
            j = i;
          }
        }
        localc.E(paramContext, paramXmlPullParser);
        this.f.put(j, localc);
        return;
      }
      i += 1;
    }
  }
  
  public void c(d paramd) {}
  
  public void d(int paramInt, float paramFloat1, float paramFloat2)
  {
    int i = this.c;
    Object localObject;
    if (i == paramInt)
    {
      if (paramInt == -1) {
        localObject = this.e.valueAt(0);
      } else {
        localObject = this.e.get(i);
      }
      locala = (a)localObject;
      paramInt = this.d;
      if ((paramInt != -1) && (((b)locala.b.get(paramInt)).a(paramFloat1, paramFloat2))) {
        return;
      }
      paramInt = locala.b(paramFloat1, paramFloat2);
      if (this.d == paramInt) {
        return;
      }
      if (paramInt == -1) {
        localObject = this.b;
      } else {
        localObject = ((b)locala.b.get(paramInt)).f;
      }
      if (paramInt != -1) {
        i = ((b)locala.b.get(paramInt)).e;
      }
      if (localObject == null) {
        return;
      }
      this.d = paramInt;
      ((c)localObject).i(this.a);
      return;
    }
    this.c = paramInt;
    a locala = (a)this.e.get(paramInt);
    i = locala.b(paramFloat1, paramFloat2);
    if (i == -1) {
      localObject = locala.d;
    } else {
      localObject = ((b)locala.b.get(i)).f;
    }
    if (i != -1) {
      int j = ((b)locala.b.get(i)).e;
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NO Constraint set found ! id=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", dim =");
      ((StringBuilder)localObject).append(paramFloat1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramFloat2);
      Log.v("ConstraintLayoutStates", ((StringBuilder)localObject).toString());
      return;
    }
    this.d = i;
    ((c)localObject).i(this.a);
  }
  
  static class a
  {
    int a;
    ArrayList<b.b> b = new ArrayList();
    int c = -1;
    c d;
    
    public a(Context paramContext, XmlPullParser paramXmlPullParser)
    {
      paramXmlPullParser = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.State);
      int j = paramXmlPullParser.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramXmlPullParser.getIndex(i);
        if (k == R.styleable.State_android_id)
        {
          this.a = paramXmlPullParser.getResourceId(k, this.a);
        }
        else if (k == R.styleable.State_constraints)
        {
          this.c = paramXmlPullParser.getResourceId(k, this.c);
          Object localObject = paramContext.getResources().getResourceTypeName(this.c);
          paramContext.getResources().getResourceName(this.c);
          if ("layout".equals(localObject))
          {
            localObject = new c();
            this.d = ((c)localObject);
            ((c)localObject).o(paramContext, this.c);
          }
        }
        i += 1;
      }
      paramXmlPullParser.recycle();
    }
    
    void a(b.b paramb)
    {
      this.b.add(paramb);
    }
    
    public int b(float paramFloat1, float paramFloat2)
    {
      int i = 0;
      while (i < this.b.size())
      {
        if (((b.b)this.b.get(i)).a(paramFloat1, paramFloat2)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
  }
  
  static class b
  {
    float a = (0.0F / 0.0F);
    float b = (0.0F / 0.0F);
    float c = (0.0F / 0.0F);
    float d = (0.0F / 0.0F);
    int e = -1;
    c f;
    
    public b(Context paramContext, XmlPullParser paramXmlPullParser)
    {
      paramXmlPullParser = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.Variant);
      int j = paramXmlPullParser.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramXmlPullParser.getIndex(i);
        if (k == R.styleable.Variant_constraints)
        {
          this.e = paramXmlPullParser.getResourceId(k, this.e);
          Object localObject = paramContext.getResources().getResourceTypeName(this.e);
          paramContext.getResources().getResourceName(this.e);
          if ("layout".equals(localObject))
          {
            localObject = new c();
            this.f = ((c)localObject);
            ((c)localObject).o(paramContext, this.e);
          }
        }
        else if (k == R.styleable.Variant_region_heightLessThan)
        {
          this.d = paramXmlPullParser.getDimension(k, this.d);
        }
        else if (k == R.styleable.Variant_region_heightMoreThan)
        {
          this.b = paramXmlPullParser.getDimension(k, this.b);
        }
        else if (k == R.styleable.Variant_region_widthLessThan)
        {
          this.c = paramXmlPullParser.getDimension(k, this.c);
        }
        else if (k == R.styleable.Variant_region_widthMoreThan)
        {
          this.a = paramXmlPullParser.getDimension(k, this.a);
        }
        else
        {
          Log.v("ConstraintLayoutStates", "Unknown tag");
        }
        i += 1;
      }
      paramXmlPullParser.recycle();
    }
    
    boolean a(float paramFloat1, float paramFloat2)
    {
      if ((!Float.isNaN(this.a)) && (paramFloat1 < this.a)) {
        return false;
      }
      if ((!Float.isNaN(this.b)) && (paramFloat2 < this.b)) {
        return false;
      }
      if ((!Float.isNaN(this.c)) && (paramFloat1 > this.c)) {
        return false;
      }
      return (Float.isNaN(this.d)) || (paramFloat2 <= this.d);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.b
 * JD-Core Version:    0.7.0.1
 */