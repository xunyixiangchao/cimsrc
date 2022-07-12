package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.R.id;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.f;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class p
{
  private final MotionLayout a;
  f b = null;
  b c = null;
  private boolean d = false;
  private ArrayList<b> e = new ArrayList();
  private b f = null;
  private ArrayList<b> g = new ArrayList();
  private SparseArray<androidx.constraintlayout.widget.c> h = new SparseArray();
  private HashMap<String, Integer> i = new HashMap();
  private SparseIntArray j = new SparseIntArray();
  private boolean k = false;
  private int l = 400;
  private int m = 0;
  private MotionEvent n;
  private boolean o = false;
  private boolean p = false;
  private MotionLayout.g q;
  private boolean r;
  final t s;
  float t;
  float u;
  
  p(Context paramContext, MotionLayout paramMotionLayout, int paramInt)
  {
    this.a = paramMotionLayout;
    this.s = new t(paramMotionLayout);
    K(paramContext, paramInt);
    paramContext = this.h;
    paramInt = R.id.motion_base;
    paramContext.put(paramInt, new androidx.constraintlayout.widget.c());
    this.i.put("motion_base", Integer.valueOf(paramInt));
  }
  
  private boolean I(int paramInt)
  {
    int i2 = this.j.get(paramInt);
    int i1 = this.j.size();
    while (i2 > 0)
    {
      if (i2 == paramInt) {
        return true;
      }
      if (i1 < 0) {
        return true;
      }
      i2 = this.j.get(i2);
      i1 -= 1;
    }
    return false;
  }
  
  private boolean J()
  {
    return this.q != null;
  }
  
  private void K(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    Object localObject1 = null;
    try
    {
      i1 = localXmlResourceParser.getEventType();
    }
    catch (IOException paramContext)
    {
      Object localObject3;
      StringBuilder localStringBuilder;
      paramContext.printStackTrace();
      return;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
    Object localObject2 = localXmlResourceParser.getName();
    if (this.k)
    {
      localObject3 = System.out;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parsing = ");
      localStringBuilder.append((String)localObject2);
      ((PrintStream)localObject3).println(localStringBuilder.toString());
    }
    int i1 = ((String)localObject2).hashCode();
    int i2;
    switch (i1)
    {
    default: 
      break;
    case 1942574248: 
      if (((String)localObject2).equals("include")) {
        i1 = 6;
      }
      break;
    case 1382829617: 
      if (((String)localObject2).equals("StateSet")) {
        i1 = 4;
      }
      break;
    case 793277014: 
      if (((String)localObject2).equals("MotionScene")) {
        i1 = 0;
      }
      break;
    case 327855227: 
      if (((String)localObject2).equals("OnSwipe")) {
        i1 = 2;
      }
      break;
    case 312750793: 
      if (((String)localObject2).equals("OnClick")) {
        i1 = 3;
      }
      break;
    case 269306229: 
      if (((String)localObject2).equals("Transition")) {
        i1 = i2;
      }
      break;
    case 61998586: 
      if (((String)localObject2).equals("ViewTransition")) {
        i1 = 9;
      }
      break;
    case -687739768: 
      if (((String)localObject2).equals("Include")) {
        i1 = 7;
      }
      break;
    case -1239391468: 
      if (((String)localObject2).equals("KeyFrameSet")) {
        i1 = 8;
      }
      break;
    case -1349929691: 
      if (((String)localObject2).equals("ConstraintSet"))
      {
        i1 = 5;
        break label794;
        localObject2 = new s(paramContext, localXmlResourceParser);
        this.s.a((s)localObject2);
        localObject2 = localObject1;
        break label741;
        localObject3 = new g(paramContext, localXmlResourceParser);
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          b.f((b)localObject1).add(localObject3);
          localObject2 = localObject1;
          break label741;
          N(paramContext, localXmlResourceParser);
          localObject2 = localObject1;
          break label741;
          L(paramContext, localXmlResourceParser);
          localObject2 = localObject1;
          break label741;
          this.b = new f(paramContext, localXmlResourceParser);
          localObject2 = localObject1;
          break label741;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            ((b)localObject1).u(paramContext, localXmlResourceParser);
            localObject2 = localObject1;
            break label741;
            if (localObject1 == null)
            {
              localObject2 = paramContext.getResources().getResourceEntryName(paramInt);
              i1 = localXmlResourceParser.getLineNumber();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(" OnSwipe (");
              ((StringBuilder)localObject3).append((String)localObject2);
              ((StringBuilder)localObject3).append(".xml:");
              ((StringBuilder)localObject3).append(i1);
              ((StringBuilder)localObject3).append(")");
              Log.v("MotionScene", ((StringBuilder)localObject3).toString());
            }
            localObject2 = localObject1;
            if (localObject1 != null)
            {
              b.n((b)localObject1, new q(paramContext, this.a, localXmlResourceParser));
              localObject2 = localObject1;
              break label741;
              localObject1 = this.e;
              localObject2 = new b(this, paramContext, localXmlResourceParser);
              ((ArrayList)localObject1).add(localObject2);
              if ((this.c == null) && (!b.e((b)localObject2)))
              {
                this.c = ((b)localObject2);
                if (b.l((b)localObject2) != null) {
                  b.l(this.c).x(this.r);
                }
              }
              if (!b.e((b)localObject2)) {
                break label855;
              }
              if (b.a((b)localObject2) == -1) {
                this.f = ((b)localObject2);
              } else {
                this.g.add(localObject2);
              }
              this.e.remove(localObject2);
              break label855;
              O(paramContext, localXmlResourceParser);
              localObject2 = localObject1;
              break label741;
              label729:
              localXmlResourceParser.getName();
              localObject2 = localObject1;
            }
          }
        }
      }
      break;
    }
    label794:
    label855:
    for (;;)
    {
      label741:
      i1 = localXmlResourceParser.next();
      localObject1 = localObject2;
      do
      {
        return;
        i2 = 1;
      } while (i1 == 1);
      if (i1 == 0) {
        break label729;
      }
      if (i1 == 2) {
        break;
      }
      localObject2 = localObject1;
      continue;
      i1 = -1;
      switch (i1)
      {
      }
      localObject2 = localObject1;
    }
  }
  
  private int L(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    androidx.constraintlayout.widget.c localc = new androidx.constraintlayout.widget.c();
    localc.R(false);
    int i5 = paramXmlPullParser.getAttributeCount();
    int i2 = 0;
    int i4 = -1;
    int i3 = i4;
    while (i2 < i5)
    {
      String str2 = paramXmlPullParser.getAttributeName(i2);
      String str1 = paramXmlPullParser.getAttributeValue(i2);
      if (this.k)
      {
        PrintStream localPrintStream = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("id string = ");
        localStringBuilder.append(str1);
        localPrintStream.println(localStringBuilder.toString());
      }
      str2.hashCode();
      switch (str2.hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            i1 = -1;
            break;
          } while (!str2.equals("id"));
          i1 = 2;
          break;
        } while (!str2.equals("constraintRotate"));
        i1 = 1;
        break;
      } while (!str2.equals("deriveConstraintsFrom"));
      int i1 = 0;
      switch (i1)
      {
      default: 
        break;
      case 2: 
        i4 = r(paramContext, str1);
        this.i.put(a0(str1), Integer.valueOf(i4));
        localc.b = a.c(paramContext, i4);
        break;
      }
      try
      {
        localc.d = Integer.parseInt(str1);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label297:
        break label297;
      }
      str1.hashCode();
      switch (str1.hashCode())
      {
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                i1 = -1;
                break;
              } while (!str1.equals("x_right"));
              i1 = 4;
              break;
            } while (!str1.equals("right"));
            i1 = 3;
            break;
          } while (!str1.equals("none"));
          i1 = 2;
          break;
        } while (!str1.equals("left"));
        i1 = 1;
        break;
      } while (!str1.equals("x_left"));
      i1 = 0;
      switch (i1)
      {
      default: 
        break;
      case 4: 
        localc.d = 3;
        break;
      case 3: 
        localc.d = 1;
        break;
      case 2: 
        localc.d = 0;
        break;
      case 1: 
        localc.d = 2;
        break;
      case 0: 
        localc.d = 4;
        break;
        i3 = r(paramContext, str1);
      }
      i2 += 1;
    }
    if (i4 != -1)
    {
      if (this.a.W != 0) {
        localc.S(true);
      }
      localc.E(paramContext, paramXmlPullParser);
      if (i3 != -1) {
        this.j.put(i4, i3);
      }
      this.h.put(i4, localc);
    }
    return i4;
  }
  
  private int M(Context paramContext, int paramInt)
  {
    XmlResourceParser localXmlResourceParser = paramContext.getResources().getXml(paramInt);
    try
    {
      for (paramInt = localXmlResourceParser.getEventType(); paramInt != 1; paramInt = localXmlResourceParser.next())
      {
        String str = localXmlResourceParser.getName();
        if ((2 == paramInt) && ("ConstraintSet".equals(str))) {
          return L(paramContext, localXmlResourceParser);
        }
      }
      return -1;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void N(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    paramXmlPullParser = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.include);
    int i2 = paramXmlPullParser.getIndexCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramXmlPullParser.getIndex(i1);
      if (i3 == R.styleable.include_constraintSet) {
        M(paramContext, paramXmlPullParser.getResourceId(i3, -1));
      }
      i1 += 1;
    }
    paramXmlPullParser.recycle();
  }
  
  private void O(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    paramContext = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.MotionScene);
    int i2 = paramContext.getIndexCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramContext.getIndex(i1);
      if (i3 == R.styleable.MotionScene_defaultDuration)
      {
        i3 = paramContext.getInt(i3, this.l);
        this.l = i3;
        if (i3 < 8) {
          this.l = 8;
        }
      }
      else if (i3 == R.styleable.MotionScene_layoutDuringTransition)
      {
        this.m = paramContext.getInteger(i3, 0);
      }
      i1 += 1;
    }
    paramContext.recycle();
  }
  
  private void S(int paramInt, MotionLayout paramMotionLayout)
  {
    androidx.constraintlayout.widget.c localc = (androidx.constraintlayout.widget.c)this.h.get(paramInt);
    localc.c = localc.b;
    paramInt = this.j.get(paramInt);
    StringBuilder localStringBuilder;
    if (paramInt > 0)
    {
      S(paramInt, paramMotionLayout);
      paramMotionLayout = (androidx.constraintlayout.widget.c)this.h.get(paramInt);
      if (paramMotionLayout == null)
      {
        paramMotionLayout = new StringBuilder();
        paramMotionLayout.append("ERROR! invalid deriveConstraintsFrom: @id/");
        paramMotionLayout.append(a.c(this.a.getContext(), paramInt));
        Log.e("MotionScene", paramMotionLayout.toString());
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localc.c);
      localStringBuilder.append("/");
      localStringBuilder.append(paramMotionLayout.c);
      localc.c = localStringBuilder.toString();
      localc.M(paramMotionLayout);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localc.c);
      localStringBuilder.append("  layout");
      localc.c = localStringBuilder.toString();
      localc.L(paramMotionLayout);
    }
    localc.h(localc);
  }
  
  public static String a0(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i1 = paramString.indexOf('/');
    if (i1 < 0) {
      return paramString;
    }
    return paramString.substring(i1 + 1);
  }
  
  private int r(Context paramContext, String paramString)
  {
    int i1;
    if (paramString.contains("/"))
    {
      Object localObject = paramString.substring(paramString.indexOf('/') + 1);
      int i2 = paramContext.getResources().getIdentifier((String)localObject, "id", paramContext.getPackageName());
      i1 = i2;
      if (this.k)
      {
        paramContext = System.out;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("id getMap res = ");
        ((StringBuilder)localObject).append(i2);
        paramContext.println(((StringBuilder)localObject).toString());
        i1 = i2;
      }
    }
    else
    {
      i1 = -1;
    }
    if (i1 == -1)
    {
      if (paramString.length() > 1) {
        return Integer.parseInt(paramString.substring(1));
      }
      Log.e("MotionScene", "error in parsing id");
    }
    return i1;
  }
  
  private int y(int paramInt)
  {
    f localf = this.b;
    if (localf != null)
    {
      int i1 = localf.c(paramInt, -1, -1);
      if (i1 != -1) {
        return i1;
      }
    }
    return paramInt;
  }
  
  float A()
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      return b.l(this.c).l();
    }
    return 0.0F;
  }
  
  float B()
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      return b.l(this.c).m();
    }
    return 0.0F;
  }
  
  float C()
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      return b.l(this.c).n();
    }
    return 0.0F;
  }
  
  float D()
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      return b.l(this.c).o();
    }
    return 0.0F;
  }
  
  public float E()
  {
    b localb = this.c;
    if (localb != null) {
      return b.m(localb);
    }
    return 0.0F;
  }
  
  int F()
  {
    b localb = this.c;
    if (localb == null) {
      return -1;
    }
    return b.c(localb);
  }
  
  public b G(int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (b.o(localb) == paramInt) {
        return localb;
      }
    }
    return null;
  }
  
  public List<b> H(int paramInt)
  {
    paramInt = y(paramInt);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((b.c(localb) == paramInt) || (b.a(localb) == paramInt)) {
        localArrayList.add(localb);
      }
    }
    return localArrayList;
  }
  
  void P(float paramFloat1, float paramFloat2)
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      b.l(this.c).u(paramFloat1, paramFloat2);
    }
  }
  
  void Q(float paramFloat1, float paramFloat2)
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      b.l(this.c).v(paramFloat1, paramFloat2);
    }
  }
  
  void R(MotionEvent paramMotionEvent, int paramInt, MotionLayout paramMotionLayout)
  {
    Object localObject1 = new RectF();
    if (this.q == null) {
      this.q = this.a.t0();
    }
    this.q.b(paramMotionEvent);
    if (paramInt != -1)
    {
      int i1 = paramMotionEvent.getAction();
      boolean bool2 = false;
      if (i1 != 0)
      {
        if ((i1 == 2) && (!this.o))
        {
          float f1 = paramMotionEvent.getRawY() - this.u;
          float f2 = paramMotionEvent.getRawX() - this.t;
          if ((f2 != 0.0D) || (f1 != 0.0D))
          {
            localObject2 = this.n;
            if (localObject2 != null) {}
          }
          else
          {
            return;
          }
          Object localObject2 = i(paramInt, f2, f1, (MotionEvent)localObject2);
          if (localObject2 != null)
          {
            paramMotionLayout.setTransition((b)localObject2);
            localObject1 = b.l(this.c).p(this.a, (RectF)localObject1);
            boolean bool1 = bool2;
            if (localObject1 != null)
            {
              bool1 = bool2;
              if (!((RectF)localObject1).contains(this.n.getX(), this.n.getY())) {
                bool1 = true;
              }
            }
            this.p = bool1;
            b.l(this.c).z(this.t, this.u);
          }
        }
      }
      else
      {
        this.t = paramMotionEvent.getRawX();
        this.u = paramMotionEvent.getRawY();
        this.n = paramMotionEvent;
        this.o = false;
        if (b.l(this.c) != null)
        {
          paramMotionEvent = b.l(this.c).f(this.a, (RectF)localObject1);
          if ((paramMotionEvent != null) && (!paramMotionEvent.contains(this.n.getX(), this.n.getY())))
          {
            this.n = null;
            this.o = true;
            return;
          }
          paramMotionEvent = b.l(this.c).p(this.a, (RectF)localObject1);
          if ((paramMotionEvent != null) && (!paramMotionEvent.contains(this.n.getX(), this.n.getY()))) {
            this.p = true;
          } else {
            this.p = false;
          }
          b.l(this.c).w(this.t, this.u);
        }
        return;
      }
    }
    if (this.o) {
      return;
    }
    localObject1 = this.c;
    if ((localObject1 != null) && (b.l((b)localObject1) != null) && (!this.p)) {
      b.l(this.c).s(paramMotionEvent, this.q, paramInt, this);
    }
    this.t = paramMotionEvent.getRawX();
    this.u = paramMotionEvent.getRawY();
    if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = this.q;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.a();
        this.q = null;
        paramInt = paramMotionLayout.E;
        if (paramInt != -1) {
          h(paramMotionLayout, paramInt);
        }
      }
    }
  }
  
  void T(MotionLayout paramMotionLayout)
  {
    int i1 = 0;
    while (i1 < this.h.size())
    {
      int i2 = this.h.keyAt(i1);
      if (I(i2))
      {
        Log.e("MotionScene", "Cannot be derived from yourself");
        return;
      }
      S(i2, paramMotionLayout);
      i1 += 1;
    }
  }
  
  public void U(int paramInt, androidx.constraintlayout.widget.c paramc)
  {
    this.h.put(paramInt, paramc);
  }
  
  public void V(int paramInt)
  {
    b localb = this.c;
    if (localb != null)
    {
      localb.E(paramInt);
      return;
    }
    this.l = paramInt;
  }
  
  public void W(boolean paramBoolean)
  {
    this.r = paramBoolean;
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      b.l(this.c).x(this.r);
    }
  }
  
  void X(int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    int i2;
    if (localObject != null)
    {
      i1 = ((f)localObject).c(paramInt1, -1, -1);
      if (i1 == -1) {
        i1 = paramInt1;
      }
      i3 = this.b.c(paramInt2, -1, -1);
      i2 = i1;
      if (i3 != -1) {
        break label63;
      }
    }
    else
    {
      i2 = paramInt1;
    }
    int i3 = paramInt2;
    int i1 = i2;
    label63:
    localObject = this.c;
    if ((localObject != null) && (b.a((b)localObject) == paramInt2) && (b.c(this.c) == paramInt1)) {
      return;
    }
    localObject = this.e.iterator();
    b localb;
    while (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      if (((b.a(localb) == i3) && (b.c(localb) == i1)) || ((b.a(localb) == paramInt2) && (b.c(localb) == paramInt1)))
      {
        this.c = localb;
        if ((localb != null) && (b.l(localb) != null)) {
          b.l(this.c).x(this.r);
        }
        return;
      }
    }
    localObject = this.f;
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      localb = (b)localIterator.next();
      if (b.a(localb) == paramInt2) {
        localObject = localb;
      }
    }
    localObject = new b(this, (b)localObject);
    b.d((b)localObject, i1);
    b.b((b)localObject, i3);
    if (i1 != -1) {
      this.e.add(localObject);
    }
    this.c = ((b)localObject);
  }
  
  public void Y(b paramb)
  {
    this.c = paramb;
    if ((paramb != null) && (b.l(paramb) != null)) {
      b.l(this.c).x(this.r);
    }
  }
  
  void Z()
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      b.l(this.c).A();
    }
  }
  
  boolean b0()
  {
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (b.l((b)((Iterator)localObject).next()) != null) {
        return true;
      }
    }
    localObject = this.c;
    return (localObject != null) && (b.l((b)localObject) != null);
  }
  
  public void c0(int paramInt, View... paramVarArgs)
  {
    this.s.i(paramInt, paramVarArgs);
  }
  
  public void f(MotionLayout paramMotionLayout, int paramInt)
  {
    Iterator localIterator1 = this.e.iterator();
    Object localObject;
    while (localIterator1.hasNext())
    {
      localObject = (b)localIterator1.next();
      if (b.p((b)localObject).size() > 0)
      {
        localObject = b.p((b)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((p.b.a)((Iterator)localObject).next()).c(paramMotionLayout);
        }
      }
    }
    localIterator1 = this.g.iterator();
    while (localIterator1.hasNext())
    {
      localObject = (b)localIterator1.next();
      if (b.p((b)localObject).size() > 0)
      {
        localObject = b.p((b)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((p.b.a)((Iterator)localObject).next()).c(paramMotionLayout);
        }
      }
    }
    localIterator1 = this.e.iterator();
    Iterator localIterator2;
    while (localIterator1.hasNext())
    {
      localObject = (b)localIterator1.next();
      if (b.p((b)localObject).size() > 0)
      {
        localIterator2 = b.p((b)localObject).iterator();
        while (localIterator2.hasNext()) {
          ((p.b.a)localIterator2.next()).a(paramMotionLayout, paramInt, (b)localObject);
        }
      }
    }
    localIterator1 = this.g.iterator();
    while (localIterator1.hasNext())
    {
      localObject = (b)localIterator1.next();
      if (b.p((b)localObject).size() > 0)
      {
        localIterator2 = b.p((b)localObject).iterator();
        while (localIterator2.hasNext()) {
          ((p.b.a)localIterator2.next()).a(paramMotionLayout, paramInt, (b)localObject);
        }
      }
    }
  }
  
  public boolean g(int paramInt, m paramm)
  {
    return this.s.d(paramInt, paramm);
  }
  
  boolean h(MotionLayout paramMotionLayout, int paramInt)
  {
    if (J()) {
      return false;
    }
    if (this.d) {
      return false;
    }
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb1 = (b)((Iterator)localObject).next();
      if (b.r(localb1) != 0)
      {
        b localb2 = this.c;
        if ((localb2 != localb1) || (!localb2.D(2)))
        {
          if ((paramInt == b.c(localb1)) && ((b.r(localb1) == 4) || (b.r(localb1) == 2)))
          {
            localObject = MotionLayout.k.d;
            paramMotionLayout.setState((MotionLayout.k)localObject);
            paramMotionLayout.setTransition(localb1);
            if (b.r(localb1) == 4)
            {
              paramMotionLayout.D0();
              paramMotionLayout.setState(MotionLayout.k.b);
              paramMotionLayout.setState(MotionLayout.k.c);
              return true;
            }
            paramMotionLayout.setProgress(1.0F);
            paramMotionLayout.g0(true);
            paramMotionLayout.setState(MotionLayout.k.b);
            paramMotionLayout.setState(MotionLayout.k.c);
            paramMotionLayout.setState((MotionLayout.k)localObject);
            paramMotionLayout.u0();
            return true;
          }
          if ((paramInt == b.a(localb1)) && ((b.r(localb1) == 3) || (b.r(localb1) == 1)))
          {
            localObject = MotionLayout.k.d;
            paramMotionLayout.setState((MotionLayout.k)localObject);
            paramMotionLayout.setTransition(localb1);
            if (b.r(localb1) == 3)
            {
              paramMotionLayout.F0();
              paramMotionLayout.setState(MotionLayout.k.b);
              paramMotionLayout.setState(MotionLayout.k.c);
              return true;
            }
            paramMotionLayout.setProgress(0.0F);
            paramMotionLayout.g0(true);
            paramMotionLayout.setState(MotionLayout.k.b);
            paramMotionLayout.setState(MotionLayout.k.c);
            paramMotionLayout.setState((MotionLayout.k)localObject);
            paramMotionLayout.u0();
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public b i(int paramInt, float paramFloat1, float paramFloat2, MotionEvent paramMotionEvent)
  {
    if (paramInt != -1)
    {
      Object localObject2 = H(paramInt);
      float f1 = 0.0F;
      Object localObject1 = null;
      RectF localRectF1 = new RectF();
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (b)localIterator.next();
        if ((!b.q((b)localObject2)) && (b.l((b)localObject2) != null))
        {
          b.l((b)localObject2).x(this.r);
          RectF localRectF2 = b.l((b)localObject2).p(this.a, localRectF1);
          if ((localRectF2 == null) || (paramMotionEvent == null) || (localRectF2.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
          {
            localRectF2 = b.l((b)localObject2).f(this.a, localRectF1);
            if ((localRectF2 == null) || (paramMotionEvent == null) || (localRectF2.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
            {
              float f3 = b.l((b)localObject2).a(paramFloat1, paramFloat2);
              float f2 = f3;
              if (b.l((b)localObject2).l)
              {
                f2 = f3;
                if (paramMotionEvent != null)
                {
                  f2 = paramMotionEvent.getX() - b.l((b)localObject2).i;
                  f3 = paramMotionEvent.getY() - b.l((b)localObject2).j;
                  f2 = (float)(Math.atan2(paramFloat2 + f3, paramFloat1 + f2) - Math.atan2(f2, f3)) * 10.0F;
                }
              }
              if (b.a((b)localObject2) == paramInt) {
                f3 = -1.0F;
              } else {
                f3 = 1.1F;
              }
              f2 *= f3;
              if (f2 > f1)
              {
                localObject1 = localObject2;
                f1 = f2;
              }
            }
          }
        }
      }
      return localObject1;
    }
    return this.c;
  }
  
  public int j()
  {
    b localb = this.c;
    if (localb != null) {
      return b.k(localb);
    }
    return -1;
  }
  
  int k()
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      return b.l(this.c).d();
    }
    return 0;
  }
  
  androidx.constraintlayout.widget.c l(int paramInt)
  {
    return m(paramInt, -1, -1);
  }
  
  androidx.constraintlayout.widget.c m(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.k)
    {
      localObject = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id ");
      localStringBuilder.append(paramInt1);
      ((PrintStream)localObject).println(localStringBuilder.toString());
      localObject = System.out;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("size ");
      localStringBuilder.append(this.h.size());
      ((PrintStream)localObject).println(localStringBuilder.toString());
    }
    Object localObject = this.b;
    int i1 = paramInt1;
    if (localObject != null)
    {
      paramInt2 = ((f)localObject).c(paramInt1, paramInt2, paramInt3);
      i1 = paramInt1;
      if (paramInt2 != -1) {
        i1 = paramInt2;
      }
    }
    if (this.h.get(i1) == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Warning could not find ConstraintSet id/");
      ((StringBuilder)localObject).append(a.c(this.a.getContext(), i1));
      ((StringBuilder)localObject).append(" In MotionScene");
      Log.e("MotionScene", ((StringBuilder)localObject).toString());
      localObject = this.h;
    }
    for (localObject = ((SparseArray)localObject).get(((SparseArray)localObject).keyAt(0));; localObject = this.h.get(i1)) {
      return (androidx.constraintlayout.widget.c)localObject;
    }
  }
  
  public int[] n()
  {
    int i2 = this.h.size();
    int[] arrayOfInt = new int[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfInt[i1] = this.h.keyAt(i1);
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  public ArrayList<b> o()
  {
    return this.e;
  }
  
  public int p()
  {
    b localb = this.c;
    if (localb != null) {
      return b.j(localb);
    }
    return this.l;
  }
  
  int q()
  {
    b localb = this.c;
    if (localb == null) {
      return -1;
    }
    return b.a(localb);
  }
  
  public Interpolator s()
  {
    int i1 = b.g(this.c);
    if (i1 != -2)
    {
      if (i1 != -1)
      {
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            if (i1 != 2)
            {
              if (i1 != 4)
              {
                if (i1 != 5)
                {
                  if (i1 != 6) {
                    return null;
                  }
                  return new AnticipateInterpolator();
                }
                return new OvershootInterpolator();
              }
              return new BounceInterpolator();
            }
            return new DecelerateInterpolator();
          }
          return new AccelerateInterpolator();
        }
        return new AccelerateDecelerateInterpolator();
      }
      return new a(i0.c.c(b.h(this.c)));
    }
    return AnimationUtils.loadInterpolator(this.a.getContext(), b.i(this.c));
  }
  
  public void t(m paramm)
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      localObject = this.f;
      if (localObject != null)
      {
        localObject = b.f((b)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((g)((Iterator)localObject).next()).b(paramm);
        }
      }
      return;
    }
    localObject = b.f((b)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((g)((Iterator)localObject).next()).b(paramm);
    }
  }
  
  float u()
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      return b.l(this.c).g();
    }
    return 0.0F;
  }
  
  float v()
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      return b.l(this.c).h();
    }
    return 0.0F;
  }
  
  boolean w()
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      return b.l(this.c).i();
    }
    return false;
  }
  
  float x(float paramFloat1, float paramFloat2)
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      return b.l(this.c).j(paramFloat1, paramFloat2);
    }
    return 0.0F;
  }
  
  int z()
  {
    b localb = this.c;
    if ((localb != null) && (b.l(localb) != null)) {
      return b.l(this.c).k();
    }
    return 0;
  }
  
  class a
    implements Interpolator
  {
    a(i0.c paramc) {}
    
    public float getInterpolation(float paramFloat)
    {
      return (float)this.a.a(paramFloat);
    }
  }
  
  public static class b
  {
    private int a = -1;
    private boolean b = false;
    private int c = -1;
    private int d = -1;
    private int e = 0;
    private String f = null;
    private int g = -1;
    private int h = 400;
    private float i = 0.0F;
    private final p j;
    private ArrayList<g> k = new ArrayList();
    private q l = null;
    private ArrayList<a> m = new ArrayList();
    private int n = 0;
    private boolean o = false;
    private int p = -1;
    private int q = 0;
    private int r = 0;
    
    public b(int paramInt1, p paramp, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.j = paramp;
      this.d = paramInt2;
      this.c = paramInt3;
      this.h = p.e(paramp);
      this.q = p.a(paramp);
    }
    
    b(p paramp, Context paramContext, XmlPullParser paramXmlPullParser)
    {
      this.h = p.e(paramp);
      this.q = p.a(paramp);
      this.j = paramp;
      w(paramp, paramContext, Xml.asAttributeSet(paramXmlPullParser));
    }
    
    b(p paramp, b paramb)
    {
      this.j = paramp;
      this.h = p.e(paramp);
      if (paramb != null)
      {
        this.p = paramb.p;
        this.e = paramb.e;
        this.f = paramb.f;
        this.g = paramb.g;
        this.h = paramb.h;
        this.k = paramb.k;
        this.i = paramb.i;
        this.q = paramb.q;
      }
    }
    
    private void v(p paramp, Context paramContext, TypedArray paramTypedArray)
    {
      int i3 = paramTypedArray.getIndexCount();
      int i1 = 0;
      while (i1 < i3)
      {
        int i2 = paramTypedArray.getIndex(i1);
        Object localObject;
        SparseArray localSparseArray;
        if (i2 == R.styleable.Transition_constraintSetEnd)
        {
          this.c = paramTypedArray.getResourceId(i2, -1);
          localObject = paramContext.getResources().getResourceTypeName(this.c);
          if ("layout".equals(localObject))
          {
            localObject = new androidx.constraintlayout.widget.c();
            ((androidx.constraintlayout.widget.c)localObject).D(paramContext, this.c);
            localSparseArray = p.b(paramp);
          }
        }
        for (i2 = this.c;; i2 = this.d)
        {
          localSparseArray.append(i2, localObject);
          break label574;
          if (!"xml".equals(localObject)) {
            break label574;
          }
          this.c = p.c(paramp, paramContext, this.c);
          break label574;
          if (i2 != R.styleable.Transition_constraintSetStart) {
            break label240;
          }
          this.d = paramTypedArray.getResourceId(i2, this.d);
          localObject = paramContext.getResources().getResourceTypeName(this.d);
          if (!"layout".equals(localObject)) {
            break;
          }
          localObject = new androidx.constraintlayout.widget.c();
          ((androidx.constraintlayout.widget.c)localObject).D(paramContext, this.d);
          localSparseArray = p.b(paramp);
        }
        label352:
        if ("xml".equals(localObject))
        {
          this.d = p.c(paramp, paramContext, this.d);
          break label574;
          label240:
          if (i2 == R.styleable.Transition_motionInterpolator)
          {
            int i4 = paramTypedArray.peekValue(i2).type;
            if (i4 == 1)
            {
              i2 = paramTypedArray.getResourceId(i2, -1);
              this.g = i2;
              if (i2 == -1) {}
            }
            else
            {
              for (;;)
              {
                this.e = -2;
                break label574;
                if (i4 != 3) {
                  break label352;
                }
                localObject = paramTypedArray.getString(i2);
                this.f = ((String)localObject);
                if (localObject == null) {
                  break label574;
                }
                if (((String)localObject).indexOf("/") <= 0) {
                  break;
                }
                this.g = paramTypedArray.getResourceId(i2, -1);
              }
              this.e = -1;
              break label574;
              this.e = paramTypedArray.getInteger(i2, this.e);
            }
          }
          else if (i2 == R.styleable.Transition_duration)
          {
            i2 = paramTypedArray.getInt(i2, this.h);
            this.h = i2;
            if (i2 < 8) {
              this.h = 8;
            }
          }
          else if (i2 == R.styleable.Transition_staggered)
          {
            this.i = paramTypedArray.getFloat(i2, this.i);
          }
          else if (i2 == R.styleable.Transition_autoTransition)
          {
            this.n = paramTypedArray.getInteger(i2, this.n);
          }
          else if (i2 == R.styleable.Transition_android_id)
          {
            this.a = paramTypedArray.getResourceId(i2, this.a);
          }
          else if (i2 == R.styleable.Transition_transitionDisable)
          {
            this.o = paramTypedArray.getBoolean(i2, this.o);
          }
          else if (i2 == R.styleable.Transition_pathMotionArc)
          {
            this.p = paramTypedArray.getInteger(i2, -1);
          }
          else if (i2 == R.styleable.Transition_layoutDuringTransition)
          {
            this.q = paramTypedArray.getInteger(i2, 0);
          }
          else if (i2 == R.styleable.Transition_transitionFlags)
          {
            this.r = paramTypedArray.getInteger(i2, 0);
          }
        }
        label574:
        i1 += 1;
      }
      if (this.d == -1) {
        this.b = true;
      }
    }
    
    private void w(p paramp, Context paramContext, AttributeSet paramAttributeSet)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Transition);
      v(paramp, paramContext, paramAttributeSet);
      paramAttributeSet.recycle();
    }
    
    public int A()
    {
      return this.d;
    }
    
    public q B()
    {
      return this.l;
    }
    
    public boolean C()
    {
      return this.o ^ true;
    }
    
    public boolean D(int paramInt)
    {
      return (paramInt & this.r) != 0;
    }
    
    public void E(int paramInt)
    {
      this.h = Math.max(paramInt, 8);
    }
    
    public void F(boolean paramBoolean)
    {
      this.o = (paramBoolean ^ true);
    }
    
    public void G(int paramInt1, String paramString, int paramInt2)
    {
      this.e = paramInt1;
      this.f = paramString;
      this.g = paramInt2;
    }
    
    public void H(int paramInt)
    {
      q localq = B();
      if (localq != null) {
        localq.y(paramInt);
      }
    }
    
    public void I(int paramInt)
    {
      this.p = paramInt;
    }
    
    public void t(g paramg)
    {
      this.k.add(paramg);
    }
    
    public void u(Context paramContext, XmlPullParser paramXmlPullParser)
    {
      this.m.add(new a(paramContext, this, paramXmlPullParser));
    }
    
    public int x()
    {
      return this.n;
    }
    
    public int y()
    {
      return this.c;
    }
    
    public int z()
    {
      return this.q;
    }
    
    public static class a
      implements View.OnClickListener
    {
      private final p.b a;
      int b = -1;
      int c = 17;
      
      public a(Context paramContext, p.b paramb, XmlPullParser paramXmlPullParser)
      {
        this.a = paramb;
        paramContext = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.OnClick);
        int j = paramContext.getIndexCount();
        int i = 0;
        while (i < j)
        {
          int k = paramContext.getIndex(i);
          if (k == R.styleable.OnClick_targetId) {
            this.b = paramContext.getResourceId(k, this.b);
          } else if (k == R.styleable.OnClick_clickAction) {
            this.c = paramContext.getInt(k, this.c);
          }
          i += 1;
        }
        paramContext.recycle();
      }
      
      public void a(MotionLayout paramMotionLayout, int paramInt, p.b paramb)
      {
        int i = this.b;
        if (i != -1) {
          paramMotionLayout = paramMotionLayout.findViewById(i);
        }
        if (paramMotionLayout == null)
        {
          paramMotionLayout = new StringBuilder();
          paramMotionLayout.append("OnClick could not find id ");
          paramMotionLayout.append(this.b);
          Log.e("MotionScene", paramMotionLayout.toString());
          return;
        }
        int k = p.b.c(paramb);
        int i2 = p.b.a(paramb);
        if (k == -1)
        {
          paramMotionLayout.setOnClickListener(this);
          return;
        }
        int i3 = this.c;
        int i1 = 0;
        if (((i3 & 0x1) != 0) && (paramInt == k)) {
          i = 1;
        } else {
          i = 0;
        }
        int j;
        if (((i3 & 0x100) != 0) && (paramInt == k)) {
          j = 1;
        } else {
          j = 0;
        }
        if (((i3 & 0x1) != 0) && (paramInt == k)) {
          k = 1;
        } else {
          k = 0;
        }
        int m;
        if (((i3 & 0x10) != 0) && (paramInt == i2)) {
          m = 1;
        } else {
          m = 0;
        }
        int n = i1;
        if ((i3 & 0x1000) != 0)
        {
          n = i1;
          if (paramInt == i2) {
            n = 1;
          }
        }
        if ((k | i | j | m | n) != 0) {
          paramMotionLayout.setOnClickListener(this);
        }
      }
      
      boolean b(p.b paramb, MotionLayout paramMotionLayout)
      {
        p.b localb = this.a;
        boolean bool = true;
        if (localb == paramb) {
          return true;
        }
        int i = p.b.a(localb);
        int j = p.b.c(this.a);
        int k = paramMotionLayout.E;
        if (j == -1) {
          return k != i;
        }
        if (k != j)
        {
          if (k == i) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
      
      public void c(MotionLayout paramMotionLayout)
      {
        int i = this.b;
        if (i == -1) {
          return;
        }
        paramMotionLayout = paramMotionLayout.findViewById(i);
        if (paramMotionLayout == null)
        {
          paramMotionLayout = new StringBuilder();
          paramMotionLayout.append(" (*)  could not find id ");
          paramMotionLayout.append(this.b);
          Log.e("MotionScene", paramMotionLayout.toString());
          return;
        }
        paramMotionLayout.setOnClickListener(null);
      }
      
      public void onClick(View paramView)
      {
        paramView = p.d(p.b.s(this.a));
        if (!paramView.s0()) {
          return;
        }
        if (p.b.c(this.a) == -1)
        {
          i = paramView.getCurrentState();
          if (i == -1)
          {
            paramView.G0(p.b.a(this.a));
            return;
          }
          localb1 = new p.b(p.b.s(this.a), this.a);
          p.b.d(localb1, i);
          p.b.b(localb1, p.b.a(this.a));
          paramView.setTransition(localb1);
          paramView.D0();
          return;
        }
        p.b localb1 = p.b.s(this.a).c;
        int i = this.c;
        int n = 0;
        int j;
        if (((i & 0x1) == 0) && ((i & 0x100) == 0)) {
          j = 0;
        } else {
          j = 1;
        }
        if (((i & 0x10) == 0) && ((i & 0x1000) == 0)) {
          i = 0;
        } else {
          i = 1;
        }
        int m;
        if ((j != 0) && (i != 0)) {
          m = 1;
        } else {
          m = 0;
        }
        int k = i;
        if (m != 0)
        {
          p.b localb2 = p.b.s(this.a).c;
          p.b localb3 = this.a;
          if (localb2 != localb3) {
            paramView.setTransition(localb3);
          }
          k = i;
          m = n;
          if (paramView.getCurrentState() != paramView.getEndState()) {
            if (paramView.getProgress() > 0.5F)
            {
              k = i;
              m = n;
            }
            else
            {
              k = 0;
            }
          }
        }
        else
        {
          m = j;
        }
        if (b(localb1, paramView))
        {
          if ((m != 0) && ((this.c & 0x1) != 0))
          {
            paramView.setTransition(this.a);
            paramView.D0();
            return;
          }
          if ((k != 0) && ((this.c & 0x10) != 0))
          {
            paramView.setTransition(this.a);
            paramView.F0();
            return;
          }
          if ((m != 0) && ((this.c & 0x100) != 0)) {
            paramView.setTransition(this.a);
          }
          for (float f = 1.0F;; f = 0.0F)
          {
            paramView.setProgress(f);
            return;
            if ((k == 0) || ((this.c & 0x1000) == 0)) {
              break;
            }
            paramView.setTransition(this.a);
          }
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.p
 * JD-Core Version:    0.7.0.1
 */