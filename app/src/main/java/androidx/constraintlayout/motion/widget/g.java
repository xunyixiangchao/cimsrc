package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.a;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g
{
  static HashMap<String, Constructor<? extends d>> b;
  private HashMap<Integer, ArrayList<d>> a = new HashMap();
  
  static
  {
    HashMap localHashMap = new HashMap();
    b = localHashMap;
    try
    {
      localHashMap.put("KeyAttribute", e.class.getConstructor(new Class[0]));
      b.put("KeyPosition", h.class.getConstructor(new Class[0]));
      b.put("KeyCycle", f.class.getConstructor(new Class[0]));
      b.put("KeyTimeCycle", j.class.getConstructor(new Class[0]));
      b.put("KeyTrigger", k.class.getConstructor(new Class[0]));
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.e("KeyFrames", "unable to load", localNoSuchMethodException);
    }
  }
  
  public g() {}
  
  public g(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    Object localObject1 = null;
    int i;
    try
    {
      i = paramXmlPullParser.getEventType();
    }
    catch (IOException paramContext)
    {
      Object localObject2;
      String str;
      boolean bool;
      Object localObject4;
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      label47:
      label186:
      paramContext.printStackTrace();
    }
    localObject2 = localObject1;
    Object localObject3;
    if ("KeyFrameSet".equals(paramXmlPullParser.getName()))
    {
      return;
      str = paramXmlPullParser.getName();
      bool = b.containsKey(str);
      if (bool) {
        try
        {
          localObject2 = (Constructor)b.get(str);
          if (localObject2 != null)
          {
            localObject2 = (d)((Constructor)localObject2).newInstance(new Object[0]);
            try
            {
              ((d)localObject2).e(paramContext, Xml.asAttributeSet(paramXmlPullParser));
              c((d)localObject2);
              localObject1 = localObject2;
            }
            catch (Exception localException2)
            {
              localObject1 = localObject2;
              break label186;
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Keymaker for ");
            ((StringBuilder)localObject2).append(localException2);
            ((StringBuilder)localObject2).append(" not found");
            throw new NullPointerException(((StringBuilder)localObject2).toString());
          }
        }
        catch (Exception localException1)
        {
          localObject4 = localException1;
          Log.e("KeyFrames", "unable to create ", (Throwable)localObject4);
        }
      }
      if (((String)localObject4).equalsIgnoreCase("CustomAttribute"))
      {
        localObject3 = localObject1;
        if (localObject1 != null)
        {
          localObject4 = localObject1.e;
          localObject3 = localObject1;
          if (localObject4 == null) {}
        }
      }
      else
      {
        for (localObject3 = localObject4;; localObject3 = localObject4)
        {
          a.i(paramContext, paramXmlPullParser, localObject3);
          localObject3 = localObject1;
          break;
          localObject3 = localObject1;
          if (!((String)localObject4).equalsIgnoreCase("CustomMethod")) {
            break;
          }
          localObject3 = localObject1;
          if (localObject1 == null) {
            break;
          }
          localObject4 = localObject1.e;
          localObject3 = localObject1;
          if (localObject4 == null) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      i = paramXmlPullParser.next();
      localObject1 = localObject3;
      while (i == 1) {
        return;
      }
      if (i == 2) {
        break label47;
      }
      if (i == 3) {
        break;
      }
      localObject3 = localObject1;
      continue;
      localObject3 = localObject1;
    }
  }
  
  public void a(m paramm)
  {
    ArrayList localArrayList = (ArrayList)this.a.get(Integer.valueOf(-1));
    if (localArrayList != null) {
      paramm.b(localArrayList);
    }
  }
  
  public void b(m paramm)
  {
    Object localObject = (ArrayList)this.a.get(Integer.valueOf(paramm.c));
    if (localObject != null) {
      paramm.b((ArrayList)localObject);
    }
    localObject = (ArrayList)this.a.get(Integer.valueOf(-1));
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        d locald = (d)((Iterator)localObject).next();
        if (locald.f(((ConstraintLayout.LayoutParams)paramm.b.getLayoutParams()).c0)) {
          paramm.a(locald);
        }
      }
    }
  }
  
  public void c(d paramd)
  {
    if (!this.a.containsKey(Integer.valueOf(paramd.b))) {
      this.a.put(Integer.valueOf(paramd.b), new ArrayList());
    }
    ArrayList localArrayList = (ArrayList)this.a.get(Integer.valueOf(paramd.b));
    if (localArrayList != null) {
      localArrayList.add(paramd);
    }
  }
  
  public ArrayList<d> d(int paramInt)
  {
    return (ArrayList)this.a.get(Integer.valueOf(paramInt));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.g
 * JD-Core Version:    0.7.0.1
 */