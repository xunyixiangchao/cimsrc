package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class g
{
  private final Deque<WeakReference<XmlPullParser>> a = new ArrayDeque();
  
  private static boolean b(XmlPullParser paramXmlPullParser)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramXmlPullParser != null) {
      bool1 = bool2;
    }
    try
    {
      if (paramXmlPullParser.getEventType() != 3)
      {
        int i = paramXmlPullParser.getEventType();
        if (i == 1) {
          return true;
        }
        bool1 = false;
      }
      return bool1;
    }
    catch (XmlPullParserException paramXmlPullParser) {}
    return true;
  }
  
  private static XmlPullParser c(Deque<WeakReference<XmlPullParser>> paramDeque)
  {
    while (!paramDeque.isEmpty())
    {
      XmlPullParser localXmlPullParser = (XmlPullParser)((WeakReference)paramDeque.peek()).get();
      if (b(localXmlPullParser)) {
        paramDeque.pop();
      } else {
        return localXmlPullParser;
      }
    }
    return null;
  }
  
  private static boolean d(XmlPullParser paramXmlPullParser1, XmlPullParser paramXmlPullParser2)
  {
    if ((paramXmlPullParser2 != null) && (paramXmlPullParser1 != paramXmlPullParser2)) {}
    try
    {
      if (paramXmlPullParser2.getEventType() == 2)
      {
        boolean bool = "include".equals(paramXmlPullParser2.getName());
        return bool;
      }
    }
    catch (XmlPullParserException paramXmlPullParser1)
    {
      label33:
      break label33;
    }
    return false;
  }
  
  boolean a(AttributeSet paramAttributeSet)
  {
    if ((paramAttributeSet instanceof XmlPullParser))
    {
      paramAttributeSet = (XmlPullParser)paramAttributeSet;
      if (paramAttributeSet.getDepth() == 1)
      {
        XmlPullParser localXmlPullParser = c(this.a);
        this.a.push(new WeakReference(paramAttributeSet));
        if (d(paramAttributeSet, localXmlPullParser)) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.g
 * JD-Core Version:    0.7.0.1
 */