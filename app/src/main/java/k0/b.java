package k0;

import h0.i;
import java.util.ArrayList;

public class b
{
  static void a(f paramf, h0.d paramd, int paramInt1, int paramInt2, c paramc)
  {
    int i5 = paramInt1;
    Object localObject4 = paramc.a;
    e locale3 = paramc.c;
    e locale1 = paramc.b;
    e locale2 = paramc.d;
    Object localObject2 = paramc.e;
    float f1 = paramc.k;
    int i1;
    if (paramf.b0[i5] == e.b.b) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int j;
    if (i5 == 0)
    {
      n = ((e)localObject2).J0;
      if (n == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (n == 1) {
        j = 1;
      } else {
        j = 0;
      }
      k = i;
      m = j;
      if (n != 2) {
        break label189;
      }
    }
    else
    {
      n = ((e)localObject2).K0;
      if (n == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (n == 1) {
        j = 1;
      } else {
        j = 0;
      }
      k = i;
      m = j;
      if (n != 2) {
        break label189;
      }
    }
    int i2 = 1;
    int k = i;
    int m = j;
    break label192;
    label189:
    i2 = 0;
    label192:
    Object localObject3 = localObject4;
    int i = 0;
    int n = k;
    Object localObject7;
    Object localObject5;
    Object localObject1;
    Object localObject6;
    for (;;)
    {
      localObject7 = null;
      localObject5 = null;
      if (i != 0) {
        break;
      }
      localObject1 = localObject3.Y[paramInt2];
      if (i2 != 0) {
        j = 1;
      } else {
        j = 4;
      }
      k = ((d)localObject1).f();
      localObject7 = localObject3.b0[i5];
      localObject6 = e.b.c;
      int i4;
      if ((localObject7 == localObject6) && (localObject3.y[i5] == 0)) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      localObject7 = ((d)localObject1).f;
      int i3 = k;
      if (localObject7 != null)
      {
        i3 = k;
        if (localObject3 != localObject4) {
          i3 = k + ((d)localObject7).f();
        }
      }
      if ((i2 != 0) && (localObject3 != localObject4) && (localObject3 != locale1)) {
        j = 8;
      }
      localObject7 = ((d)localObject1).f;
      if (localObject7 != null)
      {
        if (localObject3 == locale1) {
          paramd.h(((d)localObject1).i, ((d)localObject7).i, i3, 6);
        } else {
          paramd.h(((d)localObject1).i, ((d)localObject7).i, i3, 8);
        }
        k = j;
        if (i4 != 0)
        {
          k = j;
          if (i2 == 0) {
            k = 5;
          }
        }
        if ((localObject3 == locale1) && (i2 != 0) && (((e)localObject3).j0(i5))) {
          k = 5;
        }
        paramd.e(((d)localObject1).i, ((d)localObject1).f.i, i3, k);
      }
      if (i1 != 0)
      {
        if ((((e)localObject3).X() != 8) && (localObject3.b0[i5] == localObject6))
        {
          localObject1 = ((e)localObject3).Y;
          paramd.h(localObject1[(paramInt2 + 1)].i, localObject1[paramInt2].i, 0, 5);
        }
        paramd.h(localObject3.Y[paramInt2].i, paramf.Y[paramInt2].i, 0, 8);
      }
      localObject6 = localObject3.Y[(paramInt2 + 1)].f;
      localObject1 = localObject5;
      if (localObject6 != null)
      {
        localObject6 = ((d)localObject6).d;
        localObject7 = ((e)localObject6).Y;
        localObject1 = localObject5;
        if (localObject7[paramInt2].f != null) {
          if (localObject7[paramInt2].f.d != localObject3) {
            localObject1 = localObject5;
          } else {
            localObject1 = localObject6;
          }
        }
      }
      if (localObject1 != null) {
        localObject3 = localObject1;
      } else {
        i = 1;
      }
    }
    if (locale2 != null)
    {
      localObject1 = locale3.Y;
      j = paramInt2 + 1;
      if (localObject1[j].f != null)
      {
        localObject1 = locale2.Y[j];
        if ((locale2.b0[i5] == e.b.c) && (locale2.y[i5] == 0)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i != 0) && (i2 == 0))
        {
          localObject3 = ((d)localObject1).f;
          if (((d)localObject3).d == paramf)
          {
            paramd.e(((d)localObject1).i, ((d)localObject3).i, -((d)localObject1).f(), 5);
            break label825;
          }
        }
        if (i2 != 0)
        {
          localObject3 = ((d)localObject1).f;
          if (((d)localObject3).d == paramf) {
            paramd.e(((d)localObject1).i, ((d)localObject3).i, -((d)localObject1).f(), 4);
          }
        }
        label825:
        paramd.j(((d)localObject1).i, locale3.Y[j].f.i, -((d)localObject1).f(), 6);
      }
    }
    if (i1 != 0)
    {
      paramf = paramf.Y;
      i = paramInt2 + 1;
      paramf = paramf[i].i;
      localObject1 = locale3.Y;
      paramd.h(paramf, localObject1[i].i, localObject1[i].f(), 8);
    }
    paramf = paramc.h;
    label1094:
    Object localObject8;
    Object localObject9;
    if (paramf != null)
    {
      i = paramf.size();
      if (i > 1)
      {
        float f2;
        if ((paramc.r) && (!paramc.t)) {
          f2 = paramc.j;
        } else {
          f2 = f1;
        }
        float f3 = 0.0F;
        localObject1 = null;
        j = 0;
        while (j < i)
        {
          localObject3 = (e)paramf.get(j);
          f1 = localObject3.N0[i5];
          if (f1 < 0.0F)
          {
            if (paramc.t)
            {
              localObject3 = ((e)localObject3).Y;
              paramd.e(localObject3[(paramInt2 + 1)].i, localObject3[paramInt2].i, 0, 4);
              break label1094;
            }
            f1 = 1.0F;
          }
          if (f1 == 0.0F)
          {
            localObject3 = ((e)localObject3).Y;
            paramd.e(localObject3[(paramInt2 + 1)].i, localObject3[paramInt2].i, 0, 8);
            f1 = f3;
          }
          else
          {
            if (localObject1 != null)
            {
              localObject5 = ((e)localObject1).Y;
              localObject1 = localObject5[paramInt2].i;
              k = paramInt2 + 1;
              localObject5 = localObject5[k].i;
              localObject8 = ((e)localObject3).Y;
              localObject6 = localObject8[paramInt2].i;
              localObject8 = localObject8[k].i;
              localObject9 = paramd.r();
              ((h0.b)localObject9).l(f3, f2, f1, (i)localObject1, (i)localObject5, (i)localObject6, (i)localObject8);
              paramd.d((h0.b)localObject9);
            }
            localObject1 = localObject3;
          }
          j += 1;
          f3 = f1;
        }
      }
    }
    if ((locale1 != null) && ((locale1 == locale2) || (i2 != 0)))
    {
      paramf = localObject4.Y[paramInt2];
      paramc = locale3.Y;
      paramInt1 = paramInt2 + 1;
      localObject1 = paramc[paramInt1];
      paramf = paramf.f;
      if (paramf != null) {
        paramf = paramf.i;
      } else {
        paramf = null;
      }
      paramc = ((d)localObject1).f;
      if (paramc != null) {
        paramc = paramc.i;
      } else {
        paramc = null;
      }
      localObject3 = locale1.Y[paramInt2];
      if (locale2 != null) {
        localObject1 = locale2.Y[paramInt1];
      }
      if ((paramf != null) && (paramc != null))
      {
        if (i5 == 0) {
          f1 = ((e)localObject2).q0;
        } else {
          f1 = ((e)localObject2).r0;
        }
        paramInt1 = ((d)localObject3).f();
        i = ((d)localObject1).f();
        paramd.c(((d)localObject3).i, paramf, paramInt1, f1, paramc, ((d)localObject1).i, i, 7);
      }
    }
    else
    {
      if ((n != 0) && (locale1 != null))
      {
        paramInt1 = paramc.j;
        if ((paramInt1 > 0) && (paramc.i == paramInt1)) {
          i = 1;
        } else {
          i = 0;
        }
        paramc = locale1;
        localObject1 = paramc;
      }
      while (localObject1 != null)
      {
        for (paramf = localObject1.P0[i5]; (paramf != null) && (paramf.X() == 8); paramf = paramf.P0[i5]) {}
        if ((paramf == null) && (localObject1 != locale2)) {}
        for (;;)
        {
          break;
          localObject3 = localObject1.Y[paramInt2];
          localObject8 = ((d)localObject3).i;
          localObject2 = ((d)localObject3).f;
          if (localObject2 != null) {
            localObject2 = ((d)localObject2).i;
          } else {
            localObject2 = null;
          }
          if (paramc != localObject1) {}
          for (localObject2 = paramc.Y[(paramInt2 + 1)];; localObject2 = localObject2[paramInt2].f)
          {
            localObject2 = ((d)localObject2).i;
            break label1604;
            if (localObject1 != locale1) {
              break label1604;
            }
            localObject2 = ((e)localObject4).Y;
            if (localObject2[paramInt2].f == null) {
              break;
            }
          }
          localObject2 = null;
          label1604:
          i1 = ((d)localObject3).f();
          localObject3 = ((e)localObject1).Y;
          k = paramInt2 + 1;
          j = localObject3[k].f();
          if (paramf != null) {}
          for (localObject3 = paramf.Y[paramInt2];; localObject3 = localObject5)
          {
            localObject6 = ((d)localObject3).i;
            localObject5 = localObject3;
            localObject3 = localObject6;
            break label1691;
            localObject5 = locale3.Y[k].f;
            if (localObject5 == null) {
              break;
            }
          }
          localObject3 = null;
          label1691:
          localObject6 = localObject1.Y[k].i;
          paramInt1 = j;
          if (localObject5 != null) {
            paramInt1 = j + ((d)localObject5).f();
          }
          j = i1 + paramc.Y[k].f();
          if ((localObject8 != null) && (localObject2 != null) && (localObject3 != null) && (localObject6 != null))
          {
            if (localObject1 == locale1) {
              j = locale1.Y[paramInt2].f();
            }
            if (localObject1 == locale2) {
              paramInt1 = locale2.Y[k].f();
            }
            if (i != 0) {
              k = 8;
            } else {
              k = 5;
            }
            paramd.c((i)localObject8, (i)localObject2, j, 0.5F, (i)localObject3, (i)localObject6, paramInt1, k);
            break;
          }
        }
        if (((e)localObject1).X() == 8) {
          localObject1 = paramc;
        }
        paramc = (c)localObject1;
        localObject1 = paramf;
        continue;
        i = 8;
        if ((m != 0) && (locale1 != null))
        {
          j = paramc.j;
          if ((j > 0) && (paramc.i == j)) {
            j = 1;
          } else {
            j = 0;
          }
          paramc = locale1;
          for (localObject1 = paramc;; localObject1 = paramf)
          {
            k = paramInt1;
            if (localObject1 == null) {
              break;
            }
            for (paramf = localObject1.P0[k]; (paramf != null) && (paramf.X() == i); paramf = paramf.P0[k]) {}
            if ((localObject1 != locale1) && (localObject1 != locale2) && (paramf != null))
            {
              if (paramf == locale2) {
                paramf = null;
              }
              localObject2 = localObject1.Y[paramInt2];
              localObject8 = ((d)localObject2).i;
              localObject3 = ((d)localObject2).f;
              if (localObject3 != null) {
                localObject3 = ((d)localObject3).i;
              }
              localObject3 = paramc.Y;
              i2 = paramInt2 + 1;
              localObject9 = localObject3[i2].i;
              i1 = ((d)localObject2).f();
              k = localObject1.Y[i2].f();
              if (paramf != null)
              {
                localObject3 = paramf.Y[paramInt2];
                localObject5 = ((d)localObject3).i;
                localObject2 = ((d)localObject3).f;
                if (localObject2 != null) {
                  localObject2 = ((d)localObject2).i;
                } else {
                  localObject2 = null;
                }
                localObject6 = localObject2;
              }
              else
              {
                localObject3 = locale2.Y[paramInt2];
                if (localObject3 != null) {
                  localObject2 = ((d)localObject3).i;
                } else {
                  localObject2 = null;
                }
                localObject6 = localObject1.Y[i2].i;
                localObject5 = localObject2;
              }
              i = k;
              if (localObject3 != null) {
                i = k + ((d)localObject3).f();
              }
              i2 = paramc.Y[i2].f();
              if (j != 0) {
                k = 8;
              } else {
                k = 4;
              }
              if ((localObject8 != null) && (localObject9 != null) && (localObject5 != null) && (localObject6 != null)) {
                paramd.c((i)localObject8, (i)localObject9, i2 + i1, 0.5F, (i)localObject5, (i)localObject6, i, k);
              }
              i = 8;
            }
            if (((e)localObject1).X() != i) {
              paramc = (c)localObject1;
            }
          }
          paramf = locale1.Y[paramInt2];
          paramc = localObject4.Y[paramInt2].f;
          localObject1 = locale2.Y;
          paramInt1 = paramInt2 + 1;
          localObject1 = localObject1[paramInt1];
          localObject2 = locale3.Y[paramInt1].f;
          if (paramc != null) {
            if (locale1 != locale2) {
              paramd.e(paramf.i, paramc.i, paramf.f(), 5);
            } else if (localObject2 != null) {
              paramd.c(paramf.i, paramc.i, paramf.f(), 0.5F, ((d)localObject1).i, ((d)localObject2).i, ((d)localObject1).f(), 5);
            }
          }
          if ((localObject2 != null) && (locale1 != locale2)) {
            paramd.e(((d)localObject1).i, ((d)localObject2).i, -((d)localObject1).f(), 5);
          }
        }
      }
    }
    if (((n != 0) || (m != 0)) && (locale1 != null) && (locale1 != locale2))
    {
      localObject4 = locale1.Y;
      localObject2 = localObject4[paramInt2];
      paramc = locale2;
      if (locale2 == null) {
        paramc = locale1;
      }
      paramf = paramc.Y;
      paramInt1 = paramInt2 + 1;
      localObject3 = paramf[paramInt1];
      paramf = ((d)localObject2).f;
      if (paramf != null) {
        localObject1 = paramf.i;
      } else {
        localObject1 = null;
      }
      paramf = ((d)localObject3).f;
      if (paramf != null) {
        paramf = paramf.i;
      } else {
        paramf = null;
      }
      if (locale3 != paramc)
      {
        localObject5 = locale3.Y[paramInt1].f;
        paramf = (f)localObject7;
        if (localObject5 != null) {
          paramf = ((d)localObject5).i;
        }
      }
      if (locale1 == paramc)
      {
        localObject2 = localObject4[paramInt2];
        localObject3 = localObject4[paramInt1];
      }
      if ((localObject1 != null) && (paramf != null))
      {
        paramInt2 = ((d)localObject2).f();
        paramInt1 = paramc.Y[paramInt1].f();
        paramd.c(((d)localObject2).i, (i)localObject1, paramInt2, 0.5F, paramf, ((d)localObject3).i, paramInt1, 5);
      }
    }
  }
  
  public static void b(f paramf, h0.d paramd, ArrayList<e> paramArrayList, int paramInt)
  {
    int k = 0;
    int i;
    c[] arrayOfc;
    int j;
    if (paramInt == 0)
    {
      i = paramf.g1;
      arrayOfc = paramf.j1;
      j = 0;
    }
    else
    {
      i = paramf.h1;
      arrayOfc = paramf.i1;
      j = 2;
    }
    while (k < i)
    {
      c localc = arrayOfc[k];
      localc.a();
      if ((paramArrayList == null) || (paramArrayList.contains(localc.a))) {
        a(paramf, paramd, paramInt, j, localc);
      }
      k += 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     k0.b
 * JD-Core Version:    0.7.0.1
 */