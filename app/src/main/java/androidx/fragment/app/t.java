package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.a0;
import androidx.core.view.u;
import androidx.core.view.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import u0.b;

@SuppressLint({"UnknownNullness"})
public abstract class t
{
  protected static void d(List<View> paramList, View paramView)
  {
    int k = paramList.size();
    if (h(paramList, paramView, k)) {
      return;
    }
    if (x.K(paramView) != null) {
      paramList.add(paramView);
    }
    int i = k;
    while (i < paramList.size())
    {
      paramView = (View)paramList.get(i);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int m = paramView.getChildCount();
        int j = 0;
        while (j < m)
        {
          View localView = paramView.getChildAt(j);
          if ((!h(paramList, localView, k)) && (x.K(localView) != null)) {
            paramList.add(localView);
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  private static boolean h(List<View> paramList, View paramView, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramList.get(i) == paramView) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  static String i(Map<String, String> paramMap, String paramString)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (paramString.equals(localEntry.getValue())) {
        return (String)localEntry.getKey();
      }
    }
    return null;
  }
  
  protected static boolean l(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public abstract void A(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract Object B(Object paramObject);
  
  public abstract void a(Object paramObject, View paramView);
  
  public abstract void b(Object paramObject, ArrayList<View> paramArrayList);
  
  public abstract void c(ViewGroup paramViewGroup, Object paramObject);
  
  public abstract boolean e(Object paramObject);
  
  void f(ArrayList<View> paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      Object localObject = paramView;
      if ((paramView instanceof ViewGroup))
      {
        localObject = (ViewGroup)paramView;
        if (!a0.b((ViewGroup)localObject))
        {
          int j = ((ViewGroup)localObject).getChildCount();
          int i = 0;
          while (i < j)
          {
            f(paramArrayList, ((ViewGroup)localObject).getChildAt(i));
            i += 1;
          }
        }
      }
      paramArrayList.add(localObject);
    }
  }
  
  public abstract Object g(Object paramObject);
  
  void j(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = x.K(paramView);
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          j(paramMap, paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  protected void k(View paramView, Rect paramRect)
  {
    if (!x.T(paramView)) {
      return;
    }
    RectF localRectF = new RectF();
    localRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    paramView.getMatrix().mapRect(localRectF);
    localRectF.offset(paramView.getLeft(), paramView.getTop());
    for (Object localObject = paramView.getParent(); (localObject instanceof View); localObject = ((View)localObject).getParent())
    {
      localObject = (View)localObject;
      localRectF.offset(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
      ((View)localObject).getMatrix().mapRect(localRectF);
      localRectF.offset(((View)localObject).getLeft(), ((View)localObject).getTop());
    }
    localObject = new int[2];
    paramView.getRootView().getLocationOnScreen((int[])localObject);
    localRectF.offset(localObject[0], localObject[1]);
    paramRect.set(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  public abstract Object m(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract Object n(Object paramObject1, Object paramObject2, Object paramObject3);
  
  ArrayList<String> o(ArrayList<View> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramArrayList.get(i);
      localArrayList.add(x.K(localView));
      x.K0(localView, null);
      i += 1;
    }
    return localArrayList;
  }
  
  public abstract void p(Object paramObject, View paramView);
  
  public abstract void q(Object paramObject, ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2);
  
  public abstract void r(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  void s(ViewGroup paramViewGroup, final ArrayList<View> paramArrayList, final Map<String, String> paramMap)
  {
    u.a(paramViewGroup, new c(paramArrayList, paramMap));
  }
  
  public abstract void t(Object paramObject1, Object paramObject2, ArrayList<View> paramArrayList1, Object paramObject3, ArrayList<View> paramArrayList2, Object paramObject4, ArrayList<View> paramArrayList3);
  
  public abstract void u(Object paramObject, Rect paramRect);
  
  public abstract void v(Object paramObject, View paramView);
  
  public void w(Fragment paramFragment, Object paramObject, b paramb, Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  void x(View paramView, final ArrayList<View> paramArrayList, final Map<String, String> paramMap)
  {
    u.a(paramView, new b(paramArrayList, paramMap));
  }
  
  void y(View paramView, final ArrayList<View> paramArrayList1, final ArrayList<View> paramArrayList2, final ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    final int k = paramArrayList2.size();
    final ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      Object localObject = (View)paramArrayList1.get(i);
      String str = x.K((View)localObject);
      localArrayList.add(str);
      if (str != null)
      {
        x.K0((View)localObject, null);
        localObject = (String)paramMap.get(str);
        int j = 0;
        while (j < k)
        {
          if (((String)localObject).equals(paramArrayList.get(j)))
          {
            x.K0((View)paramArrayList2.get(j), str);
            break;
          }
          j += 1;
        }
      }
      i += 1;
    }
    u.a(paramView, new a(k, paramArrayList2, paramArrayList, paramArrayList1, localArrayList));
  }
  
  public abstract void z(Object paramObject, View paramView, ArrayList<View> paramArrayList);
  
  class a
    implements Runnable
  {
    a(int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4) {}
    
    public void run()
    {
      int i = 0;
      while (i < k)
      {
        x.K0((View)paramArrayList2.get(i), (String)paramArrayList.get(i));
        x.K0((View)paramArrayList1.get(i), (String)localArrayList.get(i));
        i += 1;
      }
    }
  }
  
  class b
    implements Runnable
  {
    b(ArrayList paramArrayList, Map paramMap) {}
    
    public void run()
    {
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)paramArrayList.get(i);
        String str = x.K(localView);
        if (str != null) {
          x.K0(localView, t.i(paramMap, str));
        }
        i += 1;
      }
    }
  }
  
  class c
    implements Runnable
  {
    c(ArrayList paramArrayList, Map paramMap) {}
    
    public void run()
    {
      int j = paramArrayList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)paramArrayList.get(i);
        String str = x.K(localView);
        x.K0(localView, (String)paramMap.get(str));
        i += 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.t
 * JD-Core Version:    0.7.0.1
 */