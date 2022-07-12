package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class f
{
  int a = -1;
  int b = -1;
  int c = -1;
  private SparseArray<a> d = new SparseArray();
  private SparseArray<c> e = new SparseArray();
  
  public f(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    b(paramContext, paramXmlPullParser);
  }
  
  private void b(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    Object localObject1 = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.StateSet);
    int j = ((TypedArray)localObject1).getIndexCount();
    int i = 0;
    while (i < j)
    {
      int k = ((TypedArray)localObject1).getIndex(i);
      if (k == R.styleable.StateSet_defaultState) {
        this.a = ((TypedArray)localObject1).getResourceId(k, this.a);
      }
      i += 1;
    }
    ((TypedArray)localObject1).recycle();
    localObject1 = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        i = paramXmlPullParser.getEventType();
        j = 1;
        if (i != 1) {
          if (i != 0)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                localObject2 = localObject1;
                continue;
              }
              localObject2 = localObject1;
              if (!"StateSet".equals(paramXmlPullParser.getName())) {
                continue;
              }
              return;
            }
            localObject2 = paramXmlPullParser.getName();
          }
        }
        switch (((String)localObject2).hashCode())
        {
        case 1901439077: 
          if (((String)localObject2).equals("Variant")) {
            i = 3;
          }
          break;
        case 1382829617: 
          if (((String)localObject2).equals("StateSet")) {
            i = j;
          }
          break;
        case 1301459538: 
          if (((String)localObject2).equals("LayoutDescription")) {
            i = 0;
          }
          break;
        case 80204913: 
          if (((String)localObject2).equals("State"))
          {
            i = 2;
            break label346;
            b localb = new b(paramContext, paramXmlPullParser);
            localObject2 = localObject1;
            if (localObject1 != null)
            {
              ((a)localObject1).a(localb);
              localObject2 = localObject1;
              continue;
              localObject2 = new a(paramContext, paramXmlPullParser);
              this.d.put(((a)localObject2).a, localObject2);
              continue;
              paramXmlPullParser.getName();
              localObject2 = localObject1;
            }
            i = paramXmlPullParser.next();
            localObject1 = localObject2;
            continue;
            return;
          }
          break;
        }
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      catch (XmlPullParserException paramContext)
      {
        paramContext.printStackTrace();
      }
      i = -1;
      label346:
      if (i != 2) {
        if (i != 3) {
          localObject2 = localObject1;
        }
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    a locala = (a)this.d.get(paramInt2);
    if (locala == null) {
      return paramInt2;
    }
    if ((paramFloat1 != -1.0F) && (paramFloat2 != -1.0F))
    {
      localObject = null;
      Iterator localIterator = locala.b.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.a(paramFloat1, paramFloat2))
        {
          if (paramInt1 == localb.e) {
            return paramInt1;
          }
          localObject = localb;
        }
      }
      if (localObject != null) {
        return ((b)localObject).e;
      }
      return locala.c;
    }
    if (locala.c == paramInt1) {
      return paramInt1;
    }
    Object localObject = locala.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (paramInt1 == ((b)((Iterator)localObject).next()).e) {
        return paramInt1;
      }
    }
    return locala.c;
  }
  
  public int c(int paramInt1, int paramInt2, int paramInt3)
  {
    return d(-1, paramInt1, paramInt2, paramInt3);
  }
  
  public int d(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if (paramInt1 == paramInt2)
    {
      if (paramInt2 == -1) {
        localObject = this.d.valueAt(0);
      } else {
        localObject = this.d.get(this.b);
      }
      localObject = (a)localObject;
      if (localObject == null) {
        return -1;
      }
      if ((this.c != -1) && (((b)((a)localObject).b.get(paramInt1)).a(paramFloat1, paramFloat2))) {
        return paramInt1;
      }
      paramInt2 = ((a)localObject).b(paramFloat1, paramFloat2);
      if (paramInt1 == paramInt2) {
        return paramInt1;
      }
      if (paramInt2 == -1) {
        return ((a)localObject).c;
      }
      return ((b)((a)localObject).b.get(paramInt2)).e;
    }
    Object localObject = (a)this.d.get(paramInt2);
    if (localObject == null) {
      return -1;
    }
    paramInt1 = ((a)localObject).b(paramFloat1, paramFloat2);
    if (paramInt1 == -1) {
      return ((a)localObject).c;
    }
    return ((b)((a)localObject).b.get(paramInt1)).e;
  }
  
  static class a
  {
    int a;
    ArrayList<f.b> b = new ArrayList();
    int c = -1;
    boolean d;
    
    public a(Context paramContext, XmlPullParser paramXmlPullParser)
    {
      int i = 0;
      this.d = false;
      paramXmlPullParser = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.State);
      int j = paramXmlPullParser.getIndexCount();
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
          String str = paramContext.getResources().getResourceTypeName(this.c);
          paramContext.getResources().getResourceName(this.c);
          if ("layout".equals(str)) {
            this.d = true;
          }
        }
        i += 1;
      }
      paramXmlPullParser.recycle();
    }
    
    void a(f.b paramb)
    {
      this.b.add(paramb);
    }
    
    public int b(float paramFloat1, float paramFloat2)
    {
      int i = 0;
      while (i < this.b.size())
      {
        if (((f.b)this.b.get(i)).a(paramFloat1, paramFloat2)) {
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
    boolean f;
    
    public b(Context paramContext, XmlPullParser paramXmlPullParser)
    {
      int i = 0;
      this.f = false;
      paramXmlPullParser = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.Variant);
      int j = paramXmlPullParser.getIndexCount();
      while (i < j)
      {
        int k = paramXmlPullParser.getIndex(i);
        if (k == R.styleable.Variant_constraints)
        {
          this.e = paramXmlPullParser.getResourceId(k, this.e);
          String str = paramContext.getResources().getResourceTypeName(this.e);
          paramContext.getResources().getResourceName(this.e);
          if ("layout".equals(str)) {
            this.f = true;
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
 * Qualified Name:     androidx.constraintlayout.widget.f
 * JD-Core Version:    0.7.0.1
 */