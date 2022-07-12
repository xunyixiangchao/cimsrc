package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.Transition.TransitionListener;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import u0.b;

class s
  extends t
{
  private static boolean C(Transition paramTransition)
  {
    return (!t.l(paramTransition.getTargetIds())) || (!t.l(paramTransition.getTargetNames())) || (!t.l(paramTransition.getTargetTypes()));
  }
  
  public void A(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2)
  {
    paramObject = (TransitionSet)paramObject;
    if (paramObject != null)
    {
      paramObject.getTargets().clear();
      paramObject.getTargets().addAll(paramArrayList2);
      q(paramObject, paramArrayList1, paramArrayList2);
    }
  }
  
  public Object B(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition((Transition)paramObject);
    return localTransitionSet;
  }
  
  public void a(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).addTarget(paramView);
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
      j = paramObject.getTransitionCount();
      while (i < j)
      {
        b(paramObject.getTransitionAt(i), paramArrayList);
        i += 1;
      }
    }
    if ((!C(paramObject)) && (t.l(paramObject.getTargets())))
    {
      int k = paramArrayList.size();
      i = j;
      while (i < k)
      {
        paramObject.addTarget((View)paramArrayList.get(i));
        i += 1;
      }
    }
  }
  
  public void c(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  public boolean e(Object paramObject)
  {
    return paramObject instanceof Transition;
  }
  
  public Object g(Object paramObject)
  {
    if (paramObject != null) {
      return ((Transition)paramObject).clone();
    }
    return null;
  }
  
  public Object m(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    if ((paramObject1 != null) && (paramObject2 != null)) {
      paramObject1 = new TransitionSet().addTransition(paramObject1).addTransition(paramObject2).setOrdering(1);
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
        paramObject2.addTransition(paramObject1);
      }
      paramObject2.addTransition(paramObject3);
      return paramObject2;
    }
    return paramObject1;
  }
  
  public Object n(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    TransitionSet localTransitionSet = new TransitionSet();
    if (paramObject1 != null) {
      localTransitionSet.addTransition((Transition)paramObject1);
    }
    if (paramObject2 != null) {
      localTransitionSet.addTransition((Transition)paramObject2);
    }
    if (paramObject3 != null) {
      localTransitionSet.addTransition((Transition)paramObject3);
    }
    return localTransitionSet;
  }
  
  public void p(Object paramObject, View paramView)
  {
    if (paramObject != null) {
      ((Transition)paramObject).removeTarget(paramView);
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
      j = paramObject.getTransitionCount();
      while (i < j)
      {
        q(paramObject.getTransitionAt(i), paramArrayList1, paramArrayList2);
        i += 1;
      }
    }
    if (!C(paramObject))
    {
      List localList = paramObject.getTargets();
      if ((localList != null) && (localList.size() == paramArrayList1.size()) && (localList.containsAll(paramArrayList1)))
      {
        if (paramArrayList2 == null) {
          i = 0;
        } else {
          i = paramArrayList2.size();
        }
        while (j < i)
        {
          paramObject.addTarget((View)paramArrayList2.get(j));
          j += 1;
        }
        i = paramArrayList1.size() - 1;
        while (i >= 0)
        {
          paramObject.removeTarget((View)paramArrayList1.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public void r(Object paramObject, final View paramView, final ArrayList<View> paramArrayList)
  {
    ((Transition)paramObject).addListener(new b(paramView, paramArrayList));
  }
  
  public void t(Object paramObject1, final Object paramObject2, final ArrayList<View> paramArrayList1, final Object paramObject3, final ArrayList<View> paramArrayList2, final Object paramObject4, final ArrayList<View> paramArrayList3)
  {
    ((Transition)paramObject1).addListener(new c(paramObject2, paramArrayList1, paramObject3, paramArrayList2, paramObject4, paramArrayList3));
  }
  
  public void u(Object paramObject, final Rect paramRect)
  {
    if (paramObject != null) {
      ((Transition)paramObject).setEpicenterCallback(new e(paramRect));
    }
  }
  
  public void v(Object paramObject, View paramView)
  {
    if (paramView != null)
    {
      paramObject = (Transition)paramObject;
      final Rect localRect = new Rect();
      k(paramView, localRect);
      paramObject.setEpicenterCallback(new a(localRect));
    }
  }
  
  public void w(Fragment paramFragment, Object paramObject, b paramb, final Runnable paramRunnable)
  {
    ((Transition)paramObject).addListener(new d(paramRunnable));
  }
  
  public void z(Object paramObject, View paramView, ArrayList<View> paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    List localList = paramObject.getTargets();
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
    extends Transition.EpicenterCallback
  {
    a(Rect paramRect) {}
    
    public Rect onGetEpicenter(Transition paramTransition)
    {
      return localRect;
    }
  }
  
  class b
    implements Transition.TransitionListener
  {
    b(View paramView, ArrayList paramArrayList) {}
    
    public void onTransitionCancel(Transition paramTransition) {}
    
    public void onTransitionEnd(Transition paramTransition)
    {
      paramTransition.removeListener(this);
      paramView.setVisibility(8);
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((View)paramArrayList.get(i)).setVisibility(0);
        i += 1;
      }
    }
    
    public void onTransitionPause(Transition paramTransition) {}
    
    public void onTransitionResume(Transition paramTransition) {}
    
    public void onTransitionStart(Transition paramTransition)
    {
      paramTransition.removeListener(this);
      paramTransition.addListener(this);
    }
  }
  
  class c
    implements Transition.TransitionListener
  {
    c(Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3) {}
    
    public void onTransitionCancel(Transition paramTransition) {}
    
    public void onTransitionEnd(Transition paramTransition)
    {
      paramTransition.removeListener(this);
    }
    
    public void onTransitionPause(Transition paramTransition) {}
    
    public void onTransitionResume(Transition paramTransition) {}
    
    public void onTransitionStart(Transition paramTransition)
    {
      paramTransition = paramObject2;
      if (paramTransition != null) {
        s.this.q(paramTransition, paramArrayList1, null);
      }
      paramTransition = paramObject3;
      if (paramTransition != null) {
        s.this.q(paramTransition, paramArrayList2, null);
      }
      paramTransition = paramObject4;
      if (paramTransition != null) {
        s.this.q(paramTransition, paramArrayList3, null);
      }
    }
  }
  
  class d
    implements Transition.TransitionListener
  {
    d(Runnable paramRunnable) {}
    
    public void onTransitionCancel(Transition paramTransition) {}
    
    public void onTransitionEnd(Transition paramTransition)
    {
      paramRunnable.run();
    }
    
    public void onTransitionPause(Transition paramTransition) {}
    
    public void onTransitionResume(Transition paramTransition) {}
    
    public void onTransitionStart(Transition paramTransition) {}
  }
  
  class e
    extends Transition.EpicenterCallback
  {
    e(Rect paramRect) {}
    
    public Rect onGetEpicenter(Transition paramTransition)
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
 * Qualified Name:     androidx.fragment.app.s
 * JD-Core Version:    0.7.0.1
 */