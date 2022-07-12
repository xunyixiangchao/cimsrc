package s;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k2
{
  private final List<l2> a = new ArrayList();
  
  private static void b(List<int[]> paramList, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramInt2 >= paramArrayOfInt.length)
    {
      paramList.add((int[])paramArrayOfInt.clone());
      return;
    }
    int i = 0;
    while (i < paramInt1)
    {
      int j = 0;
      while (j < paramInt2)
      {
        if (i == paramArrayOfInt[j])
        {
          j = 1;
          break label66;
        }
        j += 1;
      }
      j = 0;
      label66:
      if (j == 0)
      {
        paramArrayOfInt[paramInt2] = i;
        b(paramList, paramInt1, paramArrayOfInt, paramInt2 + 1);
      }
      i += 1;
    }
  }
  
  private List<int[]> c(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    b(localArrayList, paramInt, new int[paramInt], 0);
    return localArrayList;
  }
  
  public boolean a(l2 paraml2)
  {
    return this.a.add(paraml2);
  }
  
  public boolean d(List<l2> paramList)
  {
    if (paramList.isEmpty()) {
      return true;
    }
    if (paramList.size() > this.a.size()) {
      return false;
    }
    Iterator localIterator = c(this.a.size()).iterator();
    while (localIterator.hasNext())
    {
      int[] arrayOfInt = (int[])localIterator.next();
      boolean bool1 = true;
      int i = 0;
      boolean bool2;
      for (;;)
      {
        bool2 = bool1;
        if (i >= this.a.size()) {
          break;
        }
        bool2 = bool1;
        if (arrayOfInt[i] < paramList.size())
        {
          bool1 &= ((l2)this.a.get(i)).d((l2)paramList.get(arrayOfInt[i]));
          bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            break;
          }
        }
        i += 1;
        bool1 = bool2;
      }
      if (bool2) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.k2
 * JD-Core Version:    0.7.0.1
 */