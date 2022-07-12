package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R.styleable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class k
  extends d
{
  HashMap<String, Method> A;
  private int g = -1;
  private String h = null;
  private int i;
  private String j;
  private String k;
  private int l;
  private int m;
  private View n;
  float o;
  private boolean p;
  private boolean q;
  private boolean r;
  private float s;
  private float t;
  private boolean u;
  int v;
  int w;
  int x;
  RectF y;
  RectF z;
  
  public k()
  {
    int i1 = d.f;
    this.i = i1;
    this.j = null;
    this.k = null;
    this.l = i1;
    this.m = i1;
    this.n = null;
    this.o = 0.1F;
    this.p = true;
    this.q = true;
    this.r = true;
    this.s = (0.0F / 0.0F);
    this.u = false;
    this.v = i1;
    this.w = i1;
    this.x = i1;
    this.y = new RectF();
    this.z = new RectF();
    this.A = new HashMap();
    this.d = 5;
    this.e = new HashMap();
  }
  
  private void A(String paramString, View paramView)
  {
    int i1;
    if (paramString.length() == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    String str1 = paramString;
    if (i1 == 0) {
      str1 = paramString.substring(1).toLowerCase(Locale.ROOT);
    }
    paramString = this.e.keySet().iterator();
    while (paramString.hasNext())
    {
      Object localObject = (String)paramString.next();
      String str2 = ((String)localObject).toLowerCase(Locale.ROOT);
      if ((i1 != 0) || (str2.matches(str1)))
      {
        localObject = (androidx.constraintlayout.widget.a)this.e.get(localObject);
        if (localObject != null) {
          ((androidx.constraintlayout.widget.a)localObject).a(paramView);
        }
      }
    }
  }
  
  private void B(RectF paramRectF, View paramView, boolean paramBoolean)
  {
    paramRectF.top = paramView.getTop();
    paramRectF.bottom = paramView.getBottom();
    paramRectF.left = paramView.getLeft();
    paramRectF.right = paramView.getRight();
    if (paramBoolean) {
      paramView.getMatrix().mapRect(paramRectF);
    }
  }
  
  private void z(String paramString, View paramView)
  {
    if (paramString == null) {
      return;
    }
    if (paramString.startsWith("."))
    {
      A(paramString, paramView);
      return;
    }
    if (this.A.containsKey(paramString))
    {
      localObject2 = (Method)this.A.get(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = paramView.getClass().getMethod(paramString, new Class[0]);
      this.A.put(paramString, localObject2);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label91:
      break label91;
    }
    this.A.put(paramString, null);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Could not find method \"");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("\"on class ");
    ((StringBuilder)localObject1).append(paramView.getClass().getSimpleName());
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(a.d(paramView));
    Log.e("KeyTrigger", ((StringBuilder)localObject1).toString());
    return;
    try
    {
      ((Method)localObject2).invoke(paramView, new Object[0]);
      return;
    }
    catch (Exception paramString)
    {
      label180:
      break label180;
    }
    paramString = new StringBuilder();
    paramString.append("Exception in call \"");
    paramString.append(this.h);
    paramString.append("\"on class ");
    paramString.append(paramView.getClass().getSimpleName());
    paramString.append(" ");
    paramString.append(a.d(paramView));
    Log.e("KeyTrigger", paramString.toString());
  }
  
  public void a(HashMap<String, n0.d> paramHashMap) {}
  
  public d b()
  {
    return new k().c(this);
  }
  
  public d c(d paramd)
  {
    super.c(paramd);
    paramd = (k)paramd;
    this.g = paramd.g;
    this.h = paramd.h;
    this.i = paramd.i;
    this.j = paramd.j;
    this.k = paramd.k;
    this.l = paramd.l;
    this.m = paramd.m;
    this.n = paramd.n;
    this.o = paramd.o;
    this.p = paramd.p;
    this.q = paramd.q;
    this.r = paramd.r;
    this.s = paramd.s;
    this.t = paramd.t;
    this.u = paramd.u;
    this.y = paramd.y;
    this.z = paramd.z;
    this.A = paramd.A;
    return this;
  }
  
  public void d(HashSet<String> paramHashSet) {}
  
  public void e(Context paramContext, AttributeSet paramAttributeSet)
  {
    a.a(this, paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.KeyTrigger), paramContext);
  }
  
  public void y(float paramFloat, View paramView)
  {
    int i1;
    int i2;
    if (this.m != d.f)
    {
      if (this.n == null) {
        this.n = ((ViewGroup)paramView.getParent()).findViewById(this.m);
      }
      B(this.y, this.n, this.u);
      B(this.z, paramView, this.u);
      if (this.y.intersect(this.z))
      {
        if (this.p)
        {
          this.p = false;
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
        if (this.r)
        {
          this.r = false;
          bool = true;
        }
        else
        {
          bool = false;
        }
        this.q = true;
        i2 = 0;
        break label398;
      }
      if (!this.p)
      {
        this.p = true;
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      if (this.q)
      {
        this.q = false;
        i2 = 1;
      }
      else
      {
        i2 = 0;
      }
      this.r = true;
    }
    else
    {
      float f1;
      if (this.p)
      {
        f1 = this.s;
        if ((paramFloat - f1) * (this.t - f1) < 0.0F)
        {
          this.p = false;
          i1 = 1;
          break label244;
        }
      }
      else if (Math.abs(paramFloat - this.s) > this.o)
      {
        this.p = true;
      }
      i1 = 0;
      label244:
      float f2;
      if (this.q)
      {
        f1 = this.s;
        f2 = paramFloat - f1;
        if (((this.t - f1) * f2 < 0.0F) && (f2 < 0.0F))
        {
          this.q = false;
          i2 = 1;
          break label318;
        }
      }
      else if (Math.abs(paramFloat - this.s) > this.o)
      {
        this.q = true;
      }
      i2 = 0;
      label318:
      if (this.r)
      {
        f1 = this.s;
        f2 = paramFloat - f1;
        if (((this.t - f1) * f2 < 0.0F) && (f2 > 0.0F))
        {
          this.r = false;
          bool = true;
        }
        else
        {
          bool = false;
        }
        break label398;
      }
      if (Math.abs(paramFloat - this.s) > this.o) {
        this.r = true;
      }
    }
    boolean bool = false;
    label398:
    this.t = paramFloat;
    if ((i2 != 0) || (i1 != 0) || (bool)) {
      ((MotionLayout)paramView.getParent()).k0(this.l, bool, paramFloat);
    }
    View localView;
    if (this.i == d.f) {
      localView = paramView;
    } else {
      localView = ((MotionLayout)paramView.getParent()).findViewById(this.i);
    }
    String str;
    if (i2 != 0)
    {
      str = this.j;
      if (str != null) {
        z(str, localView);
      }
      if (this.v != d.f) {
        ((MotionLayout)paramView.getParent()).M0(this.v, new View[] { localView });
      }
    }
    if (bool)
    {
      str = this.k;
      if (str != null) {
        z(str, localView);
      }
      if (this.w != d.f) {
        ((MotionLayout)paramView.getParent()).M0(this.w, new View[] { localView });
      }
    }
    if (i1 != 0)
    {
      str = this.h;
      if (str != null) {
        z(str, localView);
      }
      if (this.x != d.f) {
        ((MotionLayout)paramView.getParent()).M0(this.x, new View[] { localView });
      }
    }
  }
  
  private static class a
  {
    private static SparseIntArray a;
    
    static
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      a = localSparseIntArray;
      localSparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
      a.append(R.styleable.KeyTrigger_onCross, 4);
      a.append(R.styleable.KeyTrigger_onNegativeCross, 1);
      a.append(R.styleable.KeyTrigger_onPositiveCross, 2);
      a.append(R.styleable.KeyTrigger_motionTarget, 7);
      a.append(R.styleable.KeyTrigger_triggerId, 6);
      a.append(R.styleable.KeyTrigger_triggerSlack, 5);
      a.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
      a.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
      a.append(R.styleable.KeyTrigger_triggerReceiver, 11);
      a.append(R.styleable.KeyTrigger_viewTransitionOnCross, 12);
      a.append(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
      a.append(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
    }
    
    public static void a(k paramk, TypedArray paramTypedArray, Context paramContext)
    {
      int j = paramTypedArray.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramTypedArray.getIndex(i);
        switch (a.get(k))
        {
        case 3: 
        default: 
          paramContext = new StringBuilder();
          paramContext.append("unused attribute 0x");
          paramContext.append(Integer.toHexString(k));
          paramContext.append("   ");
          paramContext.append(a.get(k));
          Log.e("KeyTrigger", paramContext.toString());
          break;
        case 14: 
          paramk.w = paramTypedArray.getResourceId(k, paramk.w);
          break;
        case 13: 
          paramk.v = paramTypedArray.getResourceId(k, paramk.v);
          break;
        case 12: 
          paramk.x = paramTypedArray.getResourceId(k, paramk.x);
          break;
        case 11: 
          k.x(paramk, paramTypedArray.getResourceId(k, k.w(paramk)));
          break;
        case 10: 
          k.v(paramk, paramTypedArray.getBoolean(k, k.u(paramk)));
          break;
        case 9: 
          k.t(paramk, paramTypedArray.getResourceId(k, k.s(paramk)));
          break;
        case 8: 
          k = paramTypedArray.getInteger(k, paramk.a);
          paramk.a = k;
          k.m(paramk, (k + 0.5F) / 100.0F);
          break;
        case 7: 
          if (MotionLayout.d1)
          {
            int m = paramTypedArray.getResourceId(k, paramk.b);
            paramk.b = m;
            if (m != -1) {
              break;
            }
          }
          else
          {
            if (paramTypedArray.peekValue(k).type != 3) {
              break label357;
            }
          }
          paramk.c = paramTypedArray.getString(k);
          break;
          paramk.b = paramTypedArray.getResourceId(k, paramk.b);
          break;
        case 6: 
          k.r(paramk, paramTypedArray.getResourceId(k, k.q(paramk)));
          break;
        case 5: 
          paramk.o = paramTypedArray.getFloat(k, paramk.o);
          break;
        case 4: 
          k.p(paramk, paramTypedArray.getString(k));
          break;
        case 2: 
          k.o(paramk, paramTypedArray.getString(k));
          break;
        case 1: 
          label357:
          k.n(paramk, paramTypedArray.getString(k));
        }
        i += 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.k
 * JD-Core Version:    0.7.0.1
 */