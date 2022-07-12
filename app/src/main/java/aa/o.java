package aa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
import p8.l;

public final class o
  extends p8.b<e>
  implements RandomAccess
{
  public static final a d = new a(null);
  private final e[] b;
  private final int[] c;
  
  private o(e[] paramArrayOfe, int[] paramArrayOfInt)
  {
    this.b = paramArrayOfe;
    this.c = paramArrayOfInt;
  }
  
  public int a()
  {
    return this.b.length;
  }
  
  public e c(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public final e[] d()
  {
    return this.b;
  }
  
  public final int[] e()
  {
    return this.c;
  }
  
  public static final class a
  {
    private final void a(long paramLong, b paramb, int paramInt1, List<? extends e> paramList, int paramInt2, int paramInt3, List<Integer> paramList1)
    {
      int i = paramInt1;
      if (paramInt2 < paramInt3) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0)
      {
        if (paramInt2 < paramInt3)
        {
          for (paramInt1 = paramInt2;; paramInt1 = j)
          {
            j = paramInt1 + 1;
            if (((e)paramList.get(paramInt1)).r() >= i) {
              paramInt1 = 1;
            } else {
              paramInt1 = 0;
            }
            if (paramInt1 == 0) {
              break;
            }
            if (j >= paramInt3) {
              break label106;
            }
          }
          throw new IllegalArgumentException("Failed requirement.".toString());
        }
        label106:
        Object localObject = (e)paramList.get(paramInt2);
        e locale = (e)paramList.get(paramInt3 - 1);
        int k;
        if (i == ((e)localObject).r())
        {
          k = ((Number)paramList1.get(paramInt2)).intValue();
          paramInt1 = paramInt2 + 1;
          localObject = (e)paramList.get(paramInt1);
        }
        else
        {
          paramInt1 = paramInt2;
          k = -1;
        }
        int m;
        int n;
        if (((e)localObject).d(i) != locale.d(i))
        {
          m = paramInt1 + 1;
          paramInt2 = 1;
          j = 1;
          if (m < paramInt3) {
            for (;;)
            {
              n = m + 1;
              paramInt2 = j;
              if (((e)paramList.get(m - 1)).d(i) != ((e)paramList.get(m)).d(i)) {
                paramInt2 = j + 1;
              }
              if (n >= paramInt3) {
                break;
              }
              m = n;
              j = paramInt2;
            }
          }
          paramLong = paramLong + c(paramb) + 2 + paramInt2 * 2;
          paramb.K0(paramInt2);
          paramb.K0(k);
          if (paramInt1 < paramInt3) {
            for (paramInt2 = paramInt1;; paramInt2 = j)
            {
              j = paramInt2 + 1;
              k = ((e)paramList.get(paramInt2)).d(i);
              if ((paramInt2 == paramInt1) || (k != ((e)paramList.get(paramInt2 - 1)).d(i))) {
                paramb.K0(k & 0xFF);
              }
              if (j >= paramInt3) {
                break;
              }
            }
          }
          localObject = new b();
          for (paramInt2 = paramInt1; paramInt2 < paramInt3; paramInt2 = paramInt1)
          {
            m = ((e)paramList.get(paramInt2)).d(i);
            j = paramInt2 + 1;
            if (j < paramInt3) {
              for (paramInt1 = j;; paramInt1 = k)
              {
                k = paramInt1 + 1;
                if (m != ((e)paramList.get(paramInt1)).d(i)) {
                  break label539;
                }
                if (k >= paramInt3) {
                  break;
                }
              }
            }
            paramInt1 = paramInt3;
            label539:
            if ((j == paramInt1) && (i + 1 == ((e)paramList.get(paramInt2)).r()))
            {
              paramb.K0(((Number)paramList1.get(paramInt2)).intValue());
            }
            else
            {
              paramb.K0((int)(paramLong + c((b)localObject)) * -1);
              a(paramLong, (b)localObject, i + 1, paramList, paramInt2, paramInt1, paramList1);
            }
          }
          paramb.G0((x)localObject);
          return;
        }
        int i1 = Math.min(((e)localObject).r(), locale.r());
        if (i < i1)
        {
          m = i;
          paramInt2 = 0;
          for (;;)
          {
            n = m + 1;
            j = paramInt2;
            if (((e)localObject).d(m) != locale.d(m)) {
              break;
            }
            paramInt2 += 1;
            if (n >= i1)
            {
              j = paramInt2;
              break;
            }
            m = n;
          }
        }
        int j = 0;
        paramLong = paramLong + c(paramb) + 2 + j + 1L;
        paramb.K0(-j);
        paramb.K0(k);
        j = i + j;
        if (i < j) {
          for (;;)
          {
            paramInt2 = i + 1;
            paramb.K0(((e)localObject).d(i) & 0xFF);
            if (paramInt2 >= j) {
              break;
            }
            i = paramInt2;
          }
        }
        if (paramInt1 + 1 == paramInt3)
        {
          if (j == ((e)paramList.get(paramInt1)).r()) {
            paramInt2 = 1;
          } else {
            paramInt2 = 0;
          }
          if (paramInt2 != 0)
          {
            paramb.K0(((Number)paramList1.get(paramInt1)).intValue());
            return;
          }
          throw new IllegalStateException("Check failed.".toString());
        }
        localObject = new b();
        paramb.K0((int)(c((b)localObject) + paramLong) * -1);
        a(paramLong, (b)localObject, j, paramList, paramInt1, paramInt3, paramList1);
        paramb.G0((x)localObject);
        return;
      }
      throw new IllegalArgumentException("Failed requirement.".toString());
    }
    
    private final long c(b paramb)
    {
      return paramb.z0() / 4;
    }
    
    public final o d(e... paramVarArgs)
    {
      a9.f.f(paramVarArgs, "byteStrings");
      int i = paramVarArgs.length;
      int n = 0;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return new o(new e[0], new int[] { 0, -1 }, null);
      }
      Object localObject1 = p8.f.v(paramVarArgs);
      l.r((List)localObject1);
      Object localObject2 = new ArrayList(paramVarArgs.length);
      int j = paramVarArgs.length;
      i = 0;
      Object localObject3;
      while (i < j)
      {
        localObject3 = paramVarArgs[i];
        ((Collection)localObject2).add(Integer.valueOf(-1));
        i += 1;
      }
      localObject2 = ((Collection)localObject2).toArray(new Integer[0]);
      Objects.requireNonNull(localObject2, "null cannot be cast to non-null type kotlin.Array<T>");
      localObject2 = (Integer[])localObject2;
      localObject2 = l.m(Arrays.copyOf((Object[])localObject2, localObject2.length));
      int k = paramVarArgs.length;
      j = 0;
      i = j;
      while (j < k)
      {
        ((List)localObject2).set(l.g((List)localObject1, paramVarArgs[j], 0, 0, 6, null), Integer.valueOf(i));
        j += 1;
        i += 1;
      }
      if (((e)((List)localObject1).get(0)).r() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        for (i = 0; i < ((List)localObject1).size(); i = j)
        {
          localObject3 = (e)((List)localObject1).get(i);
          j = i + 1;
          k = j;
          while (k < ((List)localObject1).size())
          {
            e locale = (e)((List)localObject1).get(k);
            if (locale.s((e)localObject3))
            {
              int m;
              if (locale.r() != ((e)localObject3).r()) {
                m = 1;
              } else {
                m = 0;
              }
              if (m != 0)
              {
                if (((Number)((List)localObject2).get(k)).intValue() > ((Number)((List)localObject2).get(i)).intValue())
                {
                  ((List)localObject1).remove(k);
                  ((List)localObject2).remove(k);
                }
                else
                {
                  k += 1;
                }
              }
              else {
                throw new IllegalArgumentException(a9.f.m("duplicate option: ", locale).toString());
              }
            }
          }
        }
        localObject3 = new b();
        b(this, 0L, (b)localObject3, 0, (List)localObject1, 0, 0, (List)localObject2, 53, null);
        localObject1 = new int[(int)c((b)localObject3)];
        i = n;
        while (!((b)localObject3).D())
        {
          localObject1[i] = ((b)localObject3).readInt();
          i += 1;
        }
        paramVarArgs = Arrays.copyOf(paramVarArgs, paramVarArgs.length);
        a9.f.e(paramVarArgs, "java.util.Arrays.copyOf(this, size)");
        return new o((e[])paramVarArgs, (int[])localObject1, null);
      }
      throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     aa.o
 * JD-Core Version:    0.7.0.1
 */