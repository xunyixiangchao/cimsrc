package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class e
{
  private SparseIntArray a = new SparseIntArray();
  private HashMap<Integer, HashSet<WeakReference<a>>> b = new HashMap();
  
  public void a(int paramInt, a parama)
  {
    HashSet localHashSet2 = (HashSet)this.b.get(Integer.valueOf(paramInt));
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      this.b.put(Integer.valueOf(paramInt), localHashSet1);
    }
    localHashSet1.add(new WeakReference(parama));
  }
  
  public void b(int paramInt, a parama)
  {
    HashSet localHashSet = (HashSet)this.b.get(Integer.valueOf(paramInt));
    if (localHashSet == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      a locala = (a)localWeakReference.get();
      if ((locala == null) || (locala == parama)) {
        localArrayList.add(localWeakReference);
      }
    }
    localHashSet.removeAll(localArrayList);
  }
  
  public static abstract interface a {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.e
 * JD-Core Version:    0.7.0.1
 */