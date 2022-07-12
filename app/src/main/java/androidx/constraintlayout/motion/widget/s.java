package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.R.id;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.c.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class s
{
  private static String w = "ViewTransition";
  private int a;
  private int b = -1;
  private boolean c = false;
  private int d = 0;
  int e;
  g f;
  c.a g;
  private int h = -1;
  private int i = -1;
  private int j;
  private String k;
  private int l = 0;
  private String m = null;
  private int n = -1;
  Context o;
  private int p = -1;
  private int q = -1;
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private int u = -1;
  private int v = -1;
  
  s(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    this.o = paramContext;
    for (;;)
    {
      try
      {
        i1 = paramXmlPullParser.getEventType();
        String str;
        if (i1 != 1) {
          if (i1 != 2)
          {
            if ((i1 != 3) || (!"ViewTransition".equals(paramXmlPullParser.getName()))) {}
          }
          else {
            str = paramXmlPullParser.getName();
          }
        }
        switch (str.hashCode())
        {
        case 1791837707: 
          if (str.equals("CustomAttribute")) {
            i1 = 3;
          }
          break;
        case 366511058: 
          if (str.equals("CustomMethod")) {
            i1 = 4;
          }
          break;
        case 61998586: 
          if (str.equals("ViewTransition")) {
            i1 = 0;
          }
          break;
        case -1239391468: 
          if (str.equals("KeyFrameSet")) {
            i1 = 1;
          }
          break;
        case -1962203927: 
          if (str.equals("ConstraintOverride"))
          {
            i1 = 2;
            if (i1 != 0)
            {
              if (i1 != 1)
              {
                if (i1 != 2)
                {
                  if ((i1 != 3) && (i1 != 4))
                  {
                    Object localObject = w;
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append(a.a());
                    localStringBuilder.append(" unknown tag ");
                    localStringBuilder.append(str);
                    Log.e((String)localObject, localStringBuilder.toString());
                    str = w;
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append(".xml:");
                    ((StringBuilder)localObject).append(paramXmlPullParser.getLineNumber());
                    Log.e(str, ((StringBuilder)localObject).toString());
                  }
                  else
                  {
                    androidx.constraintlayout.widget.a.i(paramContext, paramXmlPullParser, this.g.g);
                  }
                }
                else {
                  this.g = androidx.constraintlayout.widget.c.m(paramContext, paramXmlPullParser);
                }
              }
              else {
                this.f = new g(paramContext, paramXmlPullParser);
              }
            }
            else {
              l(paramContext, paramXmlPullParser);
            }
            i1 = paramXmlPullParser.next();
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
      int i1 = -1;
    }
  }
  
  private void l(Context paramContext, XmlPullParser paramXmlPullParser)
  {
    paramContext = paramContext.obtainStyledAttributes(Xml.asAttributeSet(paramXmlPullParser), R.styleable.ViewTransition);
    int i2 = paramContext.getIndexCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramContext.getIndex(i1);
      if (i3 == R.styleable.ViewTransition_android_id)
      {
        this.a = paramContext.getResourceId(i3, this.a);
      }
      else
      {
        int i4;
        if (i3 == R.styleable.ViewTransition_motionTarget)
        {
          if (MotionLayout.d1)
          {
            i4 = paramContext.getResourceId(i3, this.j);
            this.j = i4;
            if (i4 != -1) {
              break label565;
            }
          }
          else
          {
            if (paramContext.peekValue(i3).type != 3) {
              break label125;
            }
          }
          this.k = paramContext.getString(i3);
          break label565;
          label125:
          this.j = paramContext.getResourceId(i3, this.j);
        }
        else if (i3 == R.styleable.ViewTransition_onStateTransition)
        {
          this.b = paramContext.getInt(i3, this.b);
        }
        else if (i3 == R.styleable.ViewTransition_transitionDisable)
        {
          this.c = paramContext.getBoolean(i3, this.c);
        }
        else if (i3 == R.styleable.ViewTransition_pathMotionArc)
        {
          this.d = paramContext.getInt(i3, this.d);
        }
        else if (i3 == R.styleable.ViewTransition_duration)
        {
          this.h = paramContext.getInt(i3, this.h);
        }
        else if (i3 == R.styleable.ViewTransition_upDuration)
        {
          this.i = paramContext.getInt(i3, this.i);
        }
        else if (i3 == R.styleable.ViewTransition_viewTransitionMode)
        {
          this.e = paramContext.getInt(i3, this.e);
        }
        else if (i3 == R.styleable.ViewTransition_motionInterpolator)
        {
          i4 = paramContext.peekValue(i3).type;
          if (i4 == 1)
          {
            i3 = paramContext.getResourceId(i3, -1);
            this.n = i3;
            if (i3 == -1) {}
          }
          else
          {
            for (;;)
            {
              this.l = -2;
              break label565;
              if (i4 != 3) {
                break label401;
              }
              paramXmlPullParser = paramContext.getString(i3);
              this.m = paramXmlPullParser;
              if ((paramXmlPullParser == null) || (paramXmlPullParser.indexOf("/") <= 0)) {
                break;
              }
              this.n = paramContext.getResourceId(i3, -1);
            }
            this.l = -1;
            break label565;
            label401:
            this.l = paramContext.getInteger(i3, this.l);
          }
        }
        else if (i3 == R.styleable.ViewTransition_setsTag)
        {
          this.p = paramContext.getResourceId(i3, this.p);
        }
        else if (i3 == R.styleable.ViewTransition_clearsTag)
        {
          this.q = paramContext.getResourceId(i3, this.q);
        }
        else if (i3 == R.styleable.ViewTransition_ifTagSet)
        {
          this.r = paramContext.getResourceId(i3, this.r);
        }
        else if (i3 == R.styleable.ViewTransition_ifTagNotSet)
        {
          this.s = paramContext.getResourceId(i3, this.s);
        }
        else if (i3 == R.styleable.ViewTransition_SharedValueId)
        {
          this.u = paramContext.getResourceId(i3, this.u);
        }
        else if (i3 == R.styleable.ViewTransition_SharedValue)
        {
          this.t = paramContext.getInteger(i3, this.t);
        }
      }
      label565:
      i1 += 1;
    }
    paramContext.recycle();
  }
  
  private void n(p.b paramb, View paramView)
  {
    int i1 = this.h;
    if (i1 != -1) {
      paramb.E(i1);
    }
    paramb.I(this.d);
    paramb.G(this.l, this.m, this.n);
    i1 = paramView.getId();
    paramView = this.f;
    if (paramView != null)
    {
      Object localObject = paramView.d(-1);
      paramView = new g();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramView.c(((d)((Iterator)localObject).next()).b().i(i1));
      }
      paramb.t(paramView);
    }
  }
  
  void b(t paramt, MotionLayout paramMotionLayout, View paramView)
  {
    m localm = new m(paramView);
    localm.B(paramView);
    this.f.a(localm);
    localm.I(paramMotionLayout.getWidth(), paramMotionLayout.getHeight(), this.h, System.nanoTime());
    new b(paramt, localm, this.h, this.i, this.b, f(paramMotionLayout.getContext()), this.p, this.q);
  }
  
  void c(t paramt, MotionLayout paramMotionLayout, int paramInt, androidx.constraintlayout.widget.c paramc, View... paramVarArgs)
  {
    if (this.c) {
      return;
    }
    int i1 = this.e;
    int i3 = 0;
    if (i1 == 2)
    {
      b(paramt, paramMotionLayout, paramVarArgs[0]);
      return;
    }
    Object localObject;
    c.a locala1;
    if (i1 == 1)
    {
      paramt = paramMotionLayout.getConstraintSetIds();
      i1 = 0;
      while (i1 < paramt.length)
      {
        i2 = paramt[i1];
        if (i2 != paramInt)
        {
          localObject = paramMotionLayout.m0(i2);
          int i4 = paramVarArgs.length;
          i2 = 0;
          while (i2 < i4)
          {
            locala1 = ((androidx.constraintlayout.widget.c)localObject).w(paramVarArgs[i2].getId());
            c.a locala2 = this.g;
            if (locala2 != null)
            {
              locala2.d(locala1);
              locala1.g.putAll(this.g.g);
            }
            i2 += 1;
          }
        }
        i1 += 1;
      }
    }
    paramt = new androidx.constraintlayout.widget.c();
    paramt.q(paramc);
    int i2 = paramVarArgs.length;
    i1 = 0;
    while (i1 < i2)
    {
      localObject = paramt.w(paramVarArgs[i1].getId());
      locala1 = this.g;
      if (locala1 != null)
      {
        locala1.d((c.a)localObject);
        ((c.a)localObject).g.putAll(this.g.g);
      }
      i1 += 1;
    }
    paramMotionLayout.L0(paramInt, paramt);
    i1 = R.id.view_transition;
    paramMotionLayout.L0(i1, paramc);
    paramMotionLayout.y0(i1, -1, -1);
    paramt = new p.b(-1, paramMotionLayout.y, i1, paramInt);
    i1 = paramVarArgs.length;
    paramInt = i3;
    while (paramInt < i1)
    {
      n(paramt, paramVarArgs[paramInt]);
      paramInt += 1;
    }
    paramMotionLayout.setTransition(paramt);
    paramMotionLayout.E0(new r(this, paramVarArgs));
  }
  
  boolean d(View paramView)
  {
    int i1 = this.r;
    boolean bool2 = false;
    if (i1 == -1) {}
    while (paramView.getTag(i1) != null)
    {
      i1 = 1;
      break;
    }
    i1 = 0;
    int i2 = this.s;
    if (i2 == -1) {}
    while (paramView.getTag(i2) == null)
    {
      i2 = 1;
      break;
    }
    i2 = 0;
    boolean bool1 = bool2;
    if (i1 != 0)
    {
      bool1 = bool2;
      if (i2 != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  int e()
  {
    return this.a;
  }
  
  Interpolator f(Context paramContext)
  {
    int i1 = this.l;
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
      return new a(i0.c.c(this.m));
    }
    return AnimationUtils.loadInterpolator(paramContext, this.n);
  }
  
  public int g()
  {
    return this.t;
  }
  
  public int h()
  {
    return this.u;
  }
  
  public int i()
  {
    return this.b;
  }
  
  boolean k(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if ((this.j == -1) && (this.k == null)) {
      return false;
    }
    if (!d(paramView)) {
      return false;
    }
    if (paramView.getId() == this.j) {
      return true;
    }
    if (this.k == null) {
      return false;
    }
    if ((paramView.getLayoutParams() instanceof ConstraintLayout.LayoutParams))
    {
      paramView = ((ConstraintLayout.LayoutParams)paramView.getLayoutParams()).c0;
      if ((paramView != null) && (paramView.matches(this.k))) {
        return true;
      }
    }
    return false;
  }
  
  boolean m(int paramInt)
  {
    int i1 = this.b;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i1 == 1)
    {
      if (paramInt == 0) {
        bool1 = true;
      }
      return bool1;
    }
    if (i1 == 2)
    {
      bool1 = bool3;
      if (paramInt == 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (i1 == 3)
    {
      bool1 = bool2;
      if (paramInt == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ViewTransition(");
    localStringBuilder.append(a.c(this.o, this.a));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
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
  
  static class b
  {
    private final int a;
    private final int b;
    long c;
    m d;
    int e;
    int f;
    i0.d g = new i0.d();
    t h;
    Interpolator i;
    boolean j = false;
    float k;
    float l;
    long m;
    Rect n = new Rect();
    boolean o = false;
    
    b(t paramt, m paramm, int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator, int paramInt4, int paramInt5)
    {
      this.h = paramt;
      this.d = paramm;
      this.e = paramInt1;
      this.f = paramInt2;
      long l1 = System.nanoTime();
      this.c = l1;
      this.m = l1;
      this.h.b(this);
      this.i = paramInterpolator;
      this.a = paramInt4;
      this.b = paramInt5;
      if (paramInt3 == 3) {
        this.o = true;
      }
      float f1;
      if (paramInt1 == 0) {
        f1 = 3.4028235E+38F;
      } else {
        f1 = 1.0F / paramInt1;
      }
      this.l = f1;
      a();
    }
    
    void a()
    {
      if (this.j)
      {
        c();
        return;
      }
      b();
    }
    
    void b()
    {
      long l1 = System.nanoTime();
      long l2 = this.m;
      this.m = l1;
      float f1 = this.k + (float)((l1 - l2) * 1.0E-006D) * this.l;
      this.k = f1;
      if (f1 >= 1.0F) {
        this.k = 1.0F;
      }
      Object localObject = this.i;
      if (localObject == null) {
        f1 = this.k;
      } else {
        f1 = ((Interpolator)localObject).getInterpolation(this.k);
      }
      localObject = this.d;
      boolean bool = ((m)localObject).x(((m)localObject).b, f1, l1, this.g);
      if (this.k >= 1.0F)
      {
        if (this.a != -1) {
          this.d.v().setTag(this.a, Long.valueOf(System.nanoTime()));
        }
        if (this.b != -1) {
          this.d.v().setTag(this.b, null);
        }
        if (!this.o) {
          this.h.g(this);
        }
      }
      if ((this.k < 1.0F) || (bool)) {
        this.h.e();
      }
    }
    
    void c()
    {
      long l1 = System.nanoTime();
      long l2 = this.m;
      this.m = l1;
      float f1 = this.k - (float)((l1 - l2) * 1.0E-006D) * this.l;
      this.k = f1;
      if (f1 < 0.0F) {
        this.k = 0.0F;
      }
      Object localObject = this.i;
      if (localObject == null) {
        f1 = this.k;
      } else {
        f1 = ((Interpolator)localObject).getInterpolation(this.k);
      }
      localObject = this.d;
      boolean bool = ((m)localObject).x(((m)localObject).b, f1, l1, this.g);
      if (this.k <= 0.0F)
      {
        if (this.a != -1) {
          this.d.v().setTag(this.a, Long.valueOf(System.nanoTime()));
        }
        if (this.b != -1) {
          this.d.v().setTag(this.b, null);
        }
        this.h.g(this);
      }
      if ((this.k > 0.0F) || (bool)) {
        this.h.e();
      }
    }
    
    public void d(int paramInt, float paramFloat1, float paramFloat2)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.d.v().getHitRect(this.n);
        if ((!this.n.contains((int)paramFloat1, (int)paramFloat2)) && (!this.j)) {
          e(true);
        }
        return;
      }
      if (!this.j) {
        e(true);
      }
    }
    
    void e(boolean paramBoolean)
    {
      this.j = paramBoolean;
      if (paramBoolean)
      {
        int i1 = this.f;
        if (i1 != -1)
        {
          float f1;
          if (i1 == 0) {
            f1 = 3.4028235E+38F;
          } else {
            f1 = 1.0F / i1;
          }
          this.l = f1;
        }
      }
      this.h.e();
      this.m = System.nanoTime();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.s
 * JD-Core Version:    0.7.0.1
 */