package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.e;
import androidx.constraintlayout.widget.e.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class t
{
  private final MotionLayout a;
  private ArrayList<s> b = new ArrayList();
  private HashSet<View> c;
  private String d = "ViewTransitionController";
  ArrayList<s.b> e;
  ArrayList<s.b> f = new ArrayList();
  
  public t(MotionLayout paramMotionLayout)
  {
    this.a = paramMotionLayout;
  }
  
  private void f(final s params, final boolean paramBoolean)
  {
    final int i = params.h();
    final int j = params.g();
    ConstraintLayout.getSharedValues().a(params.h(), new a(params, i, paramBoolean, j));
  }
  
  private void j(s params, View... paramVarArgs)
  {
    int i = this.a.getCurrentState();
    if (params.e != 2)
    {
      if (i == -1)
      {
        params = this.d;
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("No support for ViewTransition within transition yet. Currently: ");
        paramVarArgs.append(this.a.toString());
        Log.w(params, paramVarArgs.toString());
        return;
      }
      c localc = this.a.m0(i);
      if (localc == null) {
        return;
      }
      params.c(this, this.a, i, localc, paramVarArgs);
      return;
    }
    params.c(this, this.a, i, null, paramVarArgs);
  }
  
  public void a(s params)
  {
    this.b.add(params);
    this.c = null;
    if (params.i() == 4) {}
    for (boolean bool = true;; bool = false)
    {
      f(params, bool);
      return;
      if (params.i() != 5) {
        break;
      }
    }
  }
  
  void b(s.b paramb)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    this.e.add(paramb);
  }
  
  void c()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((s.b)((Iterator)localObject).next()).a();
    }
    this.e.removeAll(this.f);
    this.f.clear();
    if (this.e.isEmpty()) {
      this.e = null;
    }
  }
  
  boolean d(int paramInt, m paramm)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      if (locals.e() == paramInt)
      {
        locals.f.a(paramm);
        return true;
      }
    }
    return false;
  }
  
  void e()
  {
    this.a.invalidate();
  }
  
  void g(s.b paramb)
  {
    this.f.add(paramb);
  }
  
  void h(MotionEvent paramMotionEvent)
  {
    int j = this.a.getCurrentState();
    if (j == -1) {
      return;
    }
    if (this.c == null)
    {
      this.c = new HashSet();
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (s)((Iterator)localObject1).next();
        int k = this.a.getChildCount();
        i = 0;
        while (i < k)
        {
          localObject3 = this.a.getChildAt(i);
          if (((s)localObject2).k((View)localObject3))
          {
            ((View)localObject3).getId();
            this.c.add(localObject3);
          }
          i += 1;
        }
      }
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Object localObject1 = new Rect();
    int i = paramMotionEvent.getAction();
    paramMotionEvent = this.e;
    if ((paramMotionEvent != null) && (!paramMotionEvent.isEmpty()))
    {
      paramMotionEvent = this.e.iterator();
      while (paramMotionEvent.hasNext()) {
        ((s.b)paramMotionEvent.next()).d(i, f1, f2);
      }
    }
    if ((i != 0) && (i != 1)) {
      return;
    }
    Object localObject2 = this.a.m0(j);
    Object localObject3 = this.b.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      paramMotionEvent = (s)((Iterator)localObject3).next();
      if (paramMotionEvent.m(i))
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          View localView = (View)localIterator.next();
          if (paramMotionEvent.k(localView))
          {
            localView.getHitRect((Rect)localObject1);
            if (((Rect)localObject1).contains((int)f1, (int)f2)) {
              paramMotionEvent.c(this, this.a, j, (c)localObject2, new View[] { localView });
            }
          }
        }
      }
    }
  }
  
  void i(int paramInt, View... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      if (locals.e() == paramInt)
      {
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramVarArgs[i];
          if (locals.d((View)localObject)) {
            localArrayList.add(localObject);
          }
          i += 1;
        }
        if (!localArrayList.isEmpty())
        {
          j(locals, (View[])localArrayList.toArray(new View[0]));
          localArrayList.clear();
        }
        localObject = locals;
      }
    }
    if (localObject == null) {
      Log.e(this.d, " Could not find ViewTransition");
    }
  }
  
  class a
    implements e.a
  {
    a(s params, int paramInt1, boolean paramBoolean, int paramInt2) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.t
 * JD-Core Version:    0.7.0.1
 */