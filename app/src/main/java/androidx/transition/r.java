package androidx.transition;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.view.x;
import g0.a;
import g0.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class r
{
  private static Transition a = new AutoTransition();
  private static ThreadLocal<WeakReference<a<ViewGroup, ArrayList<Transition>>>> b = new ThreadLocal();
  static ArrayList<ViewGroup> c = new ArrayList();
  
  public static void a(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((!c.contains(paramViewGroup)) && (x.U(paramViewGroup)))
    {
      c.add(paramViewGroup);
      Transition localTransition = paramTransition;
      if (paramTransition == null) {
        localTransition = a;
      }
      paramTransition = localTransition.p();
      d(paramViewGroup, paramTransition);
      o.c(paramViewGroup, null);
      c(paramViewGroup, paramTransition);
    }
  }
  
  static a<ViewGroup, ArrayList<Transition>> b()
  {
    Object localObject = (WeakReference)b.get();
    if (localObject != null)
    {
      localObject = (a)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = new a();
    WeakReference localWeakReference = new WeakReference(localObject);
    b.set(localWeakReference);
    return localObject;
  }
  
  private static void c(ViewGroup paramViewGroup, Transition paramTransition)
  {
    if ((paramTransition != null) && (paramViewGroup != null))
    {
      paramTransition = new a(paramTransition, paramViewGroup);
      paramViewGroup.addOnAttachStateChangeListener(paramTransition);
      paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramTransition);
    }
  }
  
  private static void d(ViewGroup paramViewGroup, Transition paramTransition)
  {
    Object localObject = (ArrayList)b().get(paramViewGroup);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).U(paramViewGroup);
      }
    }
    if (paramTransition != null) {
      paramTransition.n(paramViewGroup, true);
    }
    paramViewGroup = o.b(paramViewGroup);
    if (paramViewGroup != null) {
      paramViewGroup.a();
    }
  }
  
  private static class a
    implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener
  {
    Transition a;
    ViewGroup b;
    
    a(Transition paramTransition, ViewGroup paramViewGroup)
    {
      this.a = paramTransition;
      this.b = paramViewGroup;
    }
    
    private void a()
    {
      this.b.getViewTreeObserver().removeOnPreDrawListener(this);
      this.b.removeOnAttachStateChangeListener(this);
    }
    
    public boolean onPreDraw()
    {
      a();
      if (!r.c.remove(this.b)) {
        return true;
      }
      final a locala = r.b();
      ArrayList localArrayList2 = (ArrayList)locala.get(this.b);
      ArrayList localArrayList1 = null;
      Object localObject;
      if (localArrayList2 == null)
      {
        localObject = new ArrayList();
        locala.put(this.b, localObject);
      }
      else
      {
        localObject = localArrayList2;
        if (localArrayList2.size() > 0)
        {
          localArrayList1 = new ArrayList(localArrayList2);
          localObject = localArrayList2;
        }
      }
      ((ArrayList)localObject).add(this.a);
      this.a.a(new a(locala));
      this.a.n(this.b, false);
      if (localArrayList1 != null)
      {
        localObject = localArrayList1.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Transition)((Iterator)localObject).next()).Y(this.b);
        }
      }
      this.a.V(this.b);
      return true;
    }
    
    public void onViewAttachedToWindow(View paramView) {}
    
    public void onViewDetachedFromWindow(View paramView)
    {
      a();
      r.c.remove(this.b);
      paramView = (ArrayList)r.b().get(this.b);
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext()) {
          ((Transition)paramView.next()).Y(this.b);
        }
      }
      this.a.o(true);
    }
    
    class a
      extends q
    {
      a(a parama) {}
      
      public void e(Transition paramTransition)
      {
        ((ArrayList)locala.get(r.a.this.b)).remove(paramTransition);
        paramTransition.W(this);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.r
 * JD-Core Version:    0.7.0.1
 */