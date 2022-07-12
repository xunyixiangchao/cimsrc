package c1;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class b
{
  private static boolean a(int paramInt, Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    boolean bool2 = b(paramInt, paramRect1, paramRect2);
    boolean bool3 = b(paramInt, paramRect1, paramRect3);
    boolean bool1 = false;
    if (!bool3)
    {
      if (!bool2) {
        return false;
      }
      if (!j(paramInt, paramRect1, paramRect3)) {
        return true;
      }
      if (paramInt != 17)
      {
        if (paramInt == 66) {
          return true;
        }
        if (k(paramInt, paramRect1, paramRect2) < m(paramInt, paramRect1, paramRect3)) {
          bool1 = true;
        }
        return bool1;
      }
      return true;
    }
    return false;
  }
  
  private static boolean b(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt == 66) {
          break label64;
        }
        if (paramInt != 130) {
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
      }
      return (paramRect2.right >= paramRect1.left) && (paramRect2.left <= paramRect1.right);
    }
    label64:
    return (paramRect2.bottom >= paramRect1.top) && (paramRect2.top <= paramRect1.bottom);
  }
  
  public static <L, T> T c(L paramL, b<L, T> paramb, a<T> parama, T paramT, Rect paramRect, int paramInt)
  {
    Rect localRect1 = new Rect(paramRect);
    int j = 0;
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130) {
            i = -(paramRect.height() + 1);
          } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
          }
        }
        else
        {
          i = -(paramRect.width() + 1);
          break label108;
        }
      }
      else {
        i = paramRect.height() + 1;
      }
      localRect1.offset(0, i);
      break label116;
    }
    else
    {
      i = paramRect.width() + 1;
    }
    label108:
    localRect1.offset(i, 0);
    label116:
    Object localObject1 = null;
    int k = paramb.b(paramL);
    Rect localRect2 = new Rect();
    int i = j;
    while (i < k)
    {
      Object localObject2 = paramb.a(paramL, i);
      if (localObject2 != paramT)
      {
        parama.a(localObject2, localRect2);
        if (h(paramInt, paramRect, localRect2, localRect1))
        {
          localRect1.set(localRect2);
          localObject1 = localObject2;
        }
      }
      i += 1;
    }
    return localObject1;
  }
  
  public static <L, T> T d(L paramL, b<L, T> paramb, a<T> parama, T paramT, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = paramb.b(paramL);
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramb.a(paramL, i));
      i += 1;
    }
    Collections.sort(localArrayList, new c(paramBoolean1, parama));
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        return e(paramT, localArrayList, paramBoolean2);
      }
      throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }
    return f(paramT, localArrayList, paramBoolean2);
  }
  
  private static <T> T e(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i;
    if (paramT == null) {
      i = -1;
    } else {
      i = paramArrayList.lastIndexOf(paramT);
    }
    i += 1;
    if (i < j) {
      return paramArrayList.get(i);
    }
    if ((paramBoolean) && (j > 0)) {
      return paramArrayList.get(0);
    }
    return null;
  }
  
  private static <T> T f(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean)
  {
    int j = paramArrayList.size();
    int i;
    if (paramT == null) {
      i = j;
    } else {
      i = paramArrayList.indexOf(paramT);
    }
    i -= 1;
    if (i >= 0) {
      return paramArrayList.get(i);
    }
    if ((paramBoolean) && (j > 0)) {
      return paramArrayList.get(j - 1);
    }
    return null;
  }
  
  private static int g(int paramInt1, int paramInt2)
  {
    return paramInt1 * 13 * paramInt1 + paramInt2 * paramInt2;
  }
  
  private static boolean h(int paramInt, Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    boolean bool2 = i(paramRect1, paramRect2, paramInt);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (!i(paramRect1, paramRect3, paramInt)) {
      return true;
    }
    if (a(paramInt, paramRect1, paramRect2, paramRect3)) {
      return true;
    }
    if (a(paramInt, paramRect1, paramRect3, paramRect2)) {
      return false;
    }
    if (g(k(paramInt, paramRect1, paramRect2), o(paramInt, paramRect1, paramRect2)) < g(k(paramInt, paramRect1, paramRect3), o(paramInt, paramRect1, paramRect3))) {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean i(Rect paramRect1, Rect paramRect2, int paramInt)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130)
          {
            paramInt = paramRect1.top;
            i = paramRect2.top;
            return ((paramInt < i) || (paramRect1.bottom <= i)) && (paramRect1.bottom < paramRect2.bottom);
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        paramInt = paramRect1.left;
        i = paramRect2.left;
        return ((paramInt < i) || (paramRect1.right <= i)) && (paramRect1.right < paramRect2.right);
      }
      paramInt = paramRect1.bottom;
      i = paramRect2.bottom;
      return ((paramInt > i) || (paramRect1.top >= i)) && (paramRect1.top > paramRect2.top);
    }
    paramInt = paramRect1.right;
    int i = paramRect2.right;
    return ((paramInt > i) || (paramRect1.left >= i)) && (paramRect1.left > paramRect2.left);
  }
  
  private static boolean j(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130) {
            return paramRect1.bottom <= paramRect2.top;
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return paramRect1.right <= paramRect2.left;
      }
      return paramRect1.top >= paramRect2.bottom;
    }
    return paramRect1.left >= paramRect2.right;
  }
  
  private static int k(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    return Math.max(0, l(paramInt, paramRect1, paramRect2));
  }
  
  private static int l(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    int i;
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130)
          {
            paramInt = paramRect2.top;
            i = paramRect1.bottom;
          }
        }
      }
    }
    for (;;)
    {
      return paramInt - i;
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      paramInt = paramRect2.left;
      i = paramRect1.right;
      continue;
      paramInt = paramRect1.top;
      i = paramRect2.bottom;
      continue;
      paramInt = paramRect1.left;
      i = paramRect2.right;
    }
  }
  
  private static int m(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    return Math.max(1, n(paramInt, paramRect1, paramRect2));
  }
  
  private static int n(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    int i;
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130)
          {
            paramInt = paramRect2.bottom;
            i = paramRect1.bottom;
          }
        }
      }
    }
    for (;;)
    {
      return paramInt - i;
      throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      paramInt = paramRect2.right;
      i = paramRect1.right;
      continue;
      paramInt = paramRect1.top;
      i = paramRect2.top;
      continue;
      paramInt = paramRect1.left;
      i = paramRect2.left;
    }
  }
  
  private static int o(int paramInt, Rect paramRect1, Rect paramRect2)
  {
    int i;
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt == 66) {
          break label73;
        }
        if (paramInt != 130) {
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
      }
      paramInt = paramRect1.left + paramRect1.width() / 2;
      i = paramRect2.left;
    }
    for (int j = paramRect2.width();; j = paramRect2.height())
    {
      return Math.abs(paramInt - (i + j / 2));
      label73:
      paramInt = paramRect1.top + paramRect1.height() / 2;
      i = paramRect2.top;
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(T paramT, Rect paramRect);
  }
  
  public static abstract interface b<T, V>
  {
    public abstract V a(T paramT, int paramInt);
    
    public abstract int b(T paramT);
  }
  
  private static class c<T>
    implements Comparator<T>
  {
    private final Rect a = new Rect();
    private final Rect b = new Rect();
    private final boolean c;
    private final b.a<T> d;
    
    c(boolean paramBoolean, b.a<T> parama)
    {
      this.c = paramBoolean;
      this.d = parama;
    }
    
    public int compare(T paramT1, T paramT2)
    {
      Rect localRect1 = this.a;
      Rect localRect2 = this.b;
      this.d.a(paramT1, localRect1);
      this.d.a(paramT2, localRect2);
      int j = localRect1.top;
      int k = localRect2.top;
      int i = -1;
      if (j < k) {
        return -1;
      }
      if (j > k) {
        return 1;
      }
      j = localRect1.left;
      k = localRect2.left;
      if (j < k)
      {
        if (this.c) {
          i = 1;
        }
        return i;
      }
      if (j > k)
      {
        if (this.c) {
          return -1;
        }
        return 1;
      }
      j = localRect1.bottom;
      k = localRect2.bottom;
      if (j < k) {
        return -1;
      }
      if (j > k) {
        return 1;
      }
      j = localRect1.right;
      k = localRect2.right;
      if (j < k)
      {
        if (this.c) {
          i = 1;
        }
        return i;
      }
      if (j > k)
      {
        if (this.c) {
          return -1;
        }
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c1.b
 * JD-Core Version:    0.7.0.1
 */