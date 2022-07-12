package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class a
{
  private final DataSetObservable a = new DataSetObservable();
  private DataSetObserver b;
  
  @Deprecated
  public void a(View paramView, int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }
  
  public void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    a(paramViewGroup, paramInt, paramObject);
  }
  
  @Deprecated
  public void c(View paramView) {}
  
  public void d(ViewGroup paramViewGroup)
  {
    c(paramViewGroup);
  }
  
  public abstract int e();
  
  public int f(Object paramObject)
  {
    return -1;
  }
  
  public CharSequence g(int paramInt)
  {
    return null;
  }
  
  public float h(int paramInt)
  {
    return 1.0F;
  }
  
  @Deprecated
  public Object i(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  public Object j(ViewGroup paramViewGroup, int paramInt)
  {
    return i(paramViewGroup, paramInt);
  }
  
  public abstract boolean k(View paramView, Object paramObject);
  
  public void l(DataSetObserver paramDataSetObserver)
  {
    this.a.registerObserver(paramDataSetObserver);
  }
  
  public void m(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable n()
  {
    return null;
  }
  
  @Deprecated
  public void o(View paramView, int paramInt, Object paramObject) {}
  
  public void p(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    o(paramViewGroup, paramInt, paramObject);
  }
  
  void q(DataSetObserver paramDataSetObserver)
  {
    try
    {
      this.b = paramDataSetObserver;
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void r(View paramView) {}
  
  public void s(ViewGroup paramViewGroup)
  {
    r(paramViewGroup);
  }
  
  public void t(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterObserver(paramDataSetObserver);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.viewpager.widget.a
 * JD-Core Version:    0.7.0.1
 */