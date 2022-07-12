package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.t;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
public class d
  extends t
{
  private static boolean C(Transition paramTransition)
  {
    return (!t.l(paramTransition.E())) || (!t.l(paramTransition.F())) || (!t.l(paramTransition.G()));
  }
  
  public void A(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.H().clear();
      paramObject.H().addAll(paramArrayList2);
      q(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public Object B(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.n0((Transition)paramObject);
    return localTransitionSet;
  }
  
  public void a(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).b(paramView);
    }
  }
  
  public void b(Object paramObject, ArrayList<View> paramArrayList)
  {
    paramObject = (Transition)paramObject;
    if (paramObject == null) {
      return;
    }
    boolean bool = paramObject instanceof TransitionSet;
    int j = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.q0();
      while (i < j)
      {
        b(paramObject.p0(i), paramArrayList);
        i += 1;
      }
    }
    if ((!C(paramObject)) && (t.l(paramObject.H())))
    {
      int k = paramArrayList.size();
      i = j;
      while (i < k)
      {
        paramObject.b((View)paramArrayList.get(i));
        i += 1;
      }
    }
  }
  
  public void c(ViewGroup paramViewGroup, Object paramObject)
  {
    r.a(paramViewGroup, (Transition)paramObject);
  }
  
  public boolean e(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public Object g(Object paramObject)
  {
    if (paramObject != null) {
      return ((Transition)paramObject).p();
    }
    return null;
  }
  
  public Object m(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().n0(paramObject1).n0(paramObject2).v0(1);
    } else if (paramObject1 == null) {
      if (paramObject2 != null) {
        paramObject1 = paramObject2;
      } else {
        paramObject1 = null;
      }
    }
    if (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        paramObject2.n0(paramObject1);
      }
      paramObject2.n0(paramObject3);
      return paramObject2;
    }
    return paramObject1;
  }
  
  public Object n(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.n0((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.n0((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.n0((Transition)paramObject3);
    }
    return localTransitionSet;
  }
  
  public void p(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).X(paramView);
    }
  }
  
  public void q(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    paramObject = (Transition)paramObject;
    boolean bool = paramObject instanceof TransitionSet;
    int j = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (TransitionSet)paramObject;
      j = paramObject.q0();
      while (i < j)
      {
        q(paramObject.p0(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!C(paramObject))
    {
      List localList = paramObject.H();
      if ((localList.size() == paramArrayList1.size()) && (localList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {
          i = 0;
        } else {
          i = paramArrayList2.size();
        }
        while (j < i)
        {
          paramObject.b((View)paramArrayList2.get(j));
          j += 1;
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.X((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public void r(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    ((Transition)paramObject).a(new b(paramView, paramArrayList));
  }
  
  public void t(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    ((Transition)paramObject1).a(new c(paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3));
  }
  
  public void u(Object paramObject, final Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).c0(new d(paramRect));
    }
  }
  
  public void v(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      final Rect localRect = new Rect();
      k(paramView, localRect);
      paramObject.c0(new a(localRect));
    }
  }
  
  public void z(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    List localList = paramObject.H();
    localList.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      t.d(localList, (View)paramArrayList.get(i));
      i += 1;
    }
    localList.add(paramView);
    paramArrayList.add(paramView);
    b(paramObject, paramArrayList);
  }
  
  class a
    extends Transition.e
  {
    a(Rect paramRect) {}
    
    public Rect a(Transition paramTransition)
    {
      return localRect;
    }
  }
  
  class b
    implements Transition.f
  {
    b(View paramView, ArrayList paramArrayList) {}
    
    public void a(Transition paramTransition) {}
    
    public void b(Transition paramTransition) {}
    
    public void c(Transition paramTransition) {}
    
    public void d(Transition paramTransition) {}
    
    public void e(Transition paramTransition)
    {
      paramTransition.W(this);
      paramView.setVisibility(8);
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((View)paramArrayList.get(i)).setVisibility(0);
        i += 1;
      }
    }
  }
  
  class c
    extends q
  {
    c(Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3) {}
    
    public void a(Transition paramTransition)
    {
      paramTransition = paramObject2;
      if (paramTransition != null) {
        d.this.q(paramTransition, paramArrayList1, null);
      }
      paramTransition = paramObject3;
      if (paramTransition != null) {
        d.this.q(paramTransition, paramArrayList2, null);
      }
      paramTransition = paramObject4;
      if (paramTransition != null) {
        d.this.q(paramTransition, paramArrayList3, null);
      }
    }
    
    public void e(Transition paramTransition)
    {
      paramTransition.W(this);
    }
  }
  
  class d
    extends Transition.e
  {
    d(Rect paramRect) {}
    
    public Rect a(Transition paramTransition)
    {
      paramTransition = paramRect;
      if ((paramTransition != null) && (!paramTransition.isEmpty())) {
        return paramRect;
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.d
 * JD-Core Version:    0.7.0.1
 */