package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

final class b
  extends ViewPager2.i
{
  private final List<ViewPager2.i> a;
  
  b(int paramInt)
  {
    this.a = new ArrayList(paramInt);
  }
  
  private void e(ConcurrentModificationException paramConcurrentModificationException)
  {
    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", paramConcurrentModificationException);
  }
  
  public void a(int paramInt)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager2.i)localIterator.next()).a(paramInt);
      }
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      e(localConcurrentModificationException);
    }
  }
  
  public void b(int paramInt1, float paramFloat, int paramInt2)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager2.i)localIterator.next()).b(paramInt1, paramFloat, paramInt2);
      }
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      e(localConcurrentModificationException);
    }
  }
  
  public void c(int paramInt)
  {
    try
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ViewPager2.i)localIterator.next()).c(paramInt);
      }
      return;
    }
    catch (ConcurrentModificationException localConcurrentModificationException)
    {
      e(localConcurrentModificationException);
    }
  }
  
  void d(ViewPager2.i parami)
  {
    this.a.add(parami);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.viewpager2.widget.b
 * JD-Core Version:    0.7.0.1
 */