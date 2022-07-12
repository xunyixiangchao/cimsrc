package l0;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import k0.a;
import k0.d;
import k0.d.b;
import k0.e;
import k0.e.b;
import k0.f;
import k0.g;
import k0.h;
import k0.j;
import k0.n;

public class i
{
  public static o a(e parame, int paramInt, ArrayList<o> paramArrayList, o paramo)
  {
    int i;
    if (paramInt == 0) {
      i = parame.S0;
    } else {
      i = parame.T0;
    }
    int k = 0;
    int j;
    if ((i != -1) && ((paramo == null) || (i != paramo.b)))
    {
      j = 0;
      for (;;)
      {
        localObject = paramo;
        if (j >= paramArrayList.size()) {
          break;
        }
        localObject = (o)paramArrayList.get(j);
        if (((o)localObject).c() == i)
        {
          if (paramo != null)
          {
            paramo.g(paramInt, (o)localObject);
            paramArrayList.remove(paramo);
          }
          break;
        }
        j += 1;
      }
    }
    Object localObject = paramo;
    if (i != -1) {
      return paramo;
    }
    paramo = (o)localObject;
    if (localObject == null)
    {
      paramo = (o)localObject;
      if ((parame instanceof j))
      {
        j = ((j)parame).w1(paramInt);
        paramo = (o)localObject;
        if (j != -1)
        {
          i = 0;
          for (;;)
          {
            paramo = (o)localObject;
            if (i >= paramArrayList.size()) {
              break;
            }
            paramo = (o)paramArrayList.get(i);
            if (paramo.c() == j) {
              break;
            }
            i += 1;
          }
        }
      }
      localObject = paramo;
      if (paramo == null) {
        localObject = new o(paramInt);
      }
      paramArrayList.add(localObject);
      paramo = (o)localObject;
    }
    if (paramo.a(parame))
    {
      if ((parame instanceof h))
      {
        localObject = (h)parame;
        d locald = ((h)localObject).v1();
        i = k;
        if (((h)localObject).w1() == 0) {
          i = 1;
        }
        locald.c(i, paramArrayList, paramo);
      }
      i = paramo.c();
      if (paramInt == 0)
      {
        parame.S0 = i;
        parame.Q.c(paramInt, paramArrayList, paramo);
        localObject = parame.S;
      }
      else
      {
        parame.T0 = i;
        parame.R.c(paramInt, paramArrayList, paramo);
        parame.U.c(paramInt, paramArrayList, paramo);
        localObject = parame.T;
      }
      ((d)localObject).c(paramInt, paramArrayList, paramo);
      parame.X.c(paramInt, paramArrayList, paramo);
    }
    return paramo;
  }
  
  private static o b(ArrayList<o> paramArrayList, int paramInt)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      o localo = (o)paramArrayList.get(i);
      if (paramInt == localo.b) {
        return localo;
      }
      i += 1;
    }
    return null;
  }
  
  public static boolean c(f paramf, b.b paramb)
  {
    ArrayList localArrayList = paramf.v1();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (e)localArrayList.get(i);
      if (!d(paramf.C(), paramf.V(), ((e)localObject1).C(), ((e)localObject1).V())) {
        return false;
      }
      if ((localObject1 instanceof g)) {
        return false;
      }
      i += 1;
    }
    i = 0;
    Object localObject6 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject4 = null;
    label469:
    Object localObject12;
    for (Object localObject3 = null; i < j; localObject3 = localObject12)
    {
      e locale = (e)localArrayList.get(i);
      if (!d(paramf.C(), paramf.V(), locale.C(), locale.V())) {
        f.W1(0, locale, paramb, paramf.z1, b.a.k);
      }
      boolean bool = locale instanceof h;
      Object localObject9 = localObject6;
      Object localObject8 = localObject2;
      if (bool)
      {
        localObject10 = (h)locale;
        localObject7 = localObject2;
        if (((h)localObject10).w1() == 0)
        {
          localObject7 = localObject2;
          if (localObject2 == null) {
            localObject7 = new ArrayList();
          }
          ((ArrayList)localObject7).add(localObject10);
        }
        localObject9 = localObject6;
        localObject8 = localObject7;
        if (((h)localObject10).w1() == 1)
        {
          localObject2 = localObject6;
          if (localObject6 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localObject10);
          localObject8 = localObject7;
          localObject9 = localObject2;
        }
      }
      localObject7 = localObject1;
      Object localObject10 = localObject5;
      if ((locale instanceof j))
      {
        if ((locale instanceof a))
        {
          localObject11 = (a)locale;
          localObject2 = localObject1;
          if (((a)localObject11).B1() == 0)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localObject11);
          }
          localObject7 = localObject2;
          localObject10 = localObject5;
          if (((a)localObject11).B1() != 1) {
            break label469;
          }
          localObject6 = localObject11;
          localObject7 = localObject2;
          localObject1 = localObject5;
          if (localObject5 == null)
          {
            localObject1 = new ArrayList();
            localObject6 = localObject11;
            localObject7 = localObject2;
          }
        }
        else
        {
          localObject10 = (j)locale;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localObject10);
          localObject6 = localObject10;
          localObject7 = localObject2;
          localObject1 = localObject5;
          if (localObject5 == null)
          {
            localObject1 = new ArrayList();
            localObject7 = localObject2;
            localObject6 = localObject10;
          }
        }
        ((ArrayList)localObject1).add(localObject6);
        localObject10 = localObject1;
      }
      Object localObject11 = localObject4;
      if (locale.Q.f == null)
      {
        localObject11 = localObject4;
        if (locale.S.f == null)
        {
          localObject11 = localObject4;
          if (!bool)
          {
            localObject11 = localObject4;
            if (!(locale instanceof a))
            {
              localObject1 = localObject4;
              if (localObject4 == null) {
                localObject1 = new ArrayList();
              }
              ((ArrayList)localObject1).add(locale);
              localObject11 = localObject1;
            }
          }
        }
      }
      localObject12 = localObject3;
      if (locale.R.f == null)
      {
        localObject12 = localObject3;
        if (locale.T.f == null)
        {
          localObject12 = localObject3;
          if (locale.U.f == null)
          {
            localObject12 = localObject3;
            if (!bool)
            {
              localObject12 = localObject3;
              if (!(locale instanceof a))
              {
                localObject1 = localObject3;
                if (localObject3 == null) {
                  localObject1 = new ArrayList();
                }
                ((ArrayList)localObject1).add(locale);
                localObject12 = localObject1;
              }
            }
          }
        }
      }
      i += 1;
      localObject6 = localObject9;
      localObject1 = localObject7;
      localObject2 = localObject8;
      localObject5 = localObject10;
      localObject4 = localObject11;
    }
    Object localObject7 = new ArrayList();
    if (localObject6 != null)
    {
      paramb = ((ArrayList)localObject6).iterator();
      while (paramb.hasNext()) {
        a((h)paramb.next(), 0, (ArrayList)localObject7, null);
      }
    }
    if (localObject1 != null)
    {
      paramb = ((ArrayList)localObject1).iterator();
      while (paramb.hasNext())
      {
        localObject1 = (j)paramb.next();
        localObject6 = a((e)localObject1, 0, (ArrayList)localObject7, null);
        ((j)localObject1).v1((ArrayList)localObject7, 0, (o)localObject6);
        ((o)localObject6).b((ArrayList)localObject7);
      }
    }
    paramb = paramf.q(d.b.b);
    if (paramb.d() != null)
    {
      paramb = paramb.d().iterator();
      while (paramb.hasNext()) {
        a(((d)paramb.next()).d, 0, (ArrayList)localObject7, null);
      }
    }
    paramb = paramf.q(d.b.d);
    if (paramb.d() != null)
    {
      paramb = paramb.d().iterator();
      while (paramb.hasNext()) {
        a(((d)paramb.next()).d, 0, (ArrayList)localObject7, null);
      }
    }
    paramb = paramf.q(d.b.g);
    if (paramb.d() != null)
    {
      paramb = paramb.d().iterator();
      while (paramb.hasNext()) {
        a(((d)paramb.next()).d, 0, (ArrayList)localObject7, null);
      }
    }
    if (localObject4 != null)
    {
      paramb = localObject4.iterator();
      while (paramb.hasNext()) {
        a((e)paramb.next(), 0, (ArrayList)localObject7, null);
      }
    }
    if (localObject2 != null)
    {
      paramb = ((ArrayList)localObject2).iterator();
      while (paramb.hasNext()) {
        a((h)paramb.next(), 1, (ArrayList)localObject7, null);
      }
    }
    if (localObject5 != null)
    {
      paramb = localObject5.iterator();
      while (paramb.hasNext())
      {
        localObject1 = (j)paramb.next();
        localObject2 = a((e)localObject1, 1, (ArrayList)localObject7, null);
        ((j)localObject1).v1((ArrayList)localObject7, 1, (o)localObject2);
        ((o)localObject2).b((ArrayList)localObject7);
      }
    }
    paramb = paramf.q(d.b.c);
    if (paramb.d() != null)
    {
      paramb = paramb.d().iterator();
      while (paramb.hasNext()) {
        a(((d)paramb.next()).d, 1, (ArrayList)localObject7, null);
      }
    }
    paramb = paramf.q(d.b.f);
    if (paramb.d() != null)
    {
      paramb = paramb.d().iterator();
      while (paramb.hasNext()) {
        a(((d)paramb.next()).d, 1, (ArrayList)localObject7, null);
      }
    }
    paramb = paramf.q(d.b.e);
    if (paramb.d() != null)
    {
      paramb = paramb.d().iterator();
      while (paramb.hasNext()) {
        a(((d)paramb.next()).d, 1, (ArrayList)localObject7, null);
      }
    }
    paramb = paramf.q(d.b.g);
    if (paramb.d() != null)
    {
      paramb = paramb.d().iterator();
      while (paramb.hasNext()) {
        a(((d)paramb.next()).d, 1, (ArrayList)localObject7, null);
      }
    }
    if (localObject3 != null)
    {
      paramb = ((ArrayList)localObject3).iterator();
      while (paramb.hasNext()) {
        a((e)paramb.next(), 1, (ArrayList)localObject7, null);
      }
    }
    i = 0;
    while (i < j)
    {
      localObject1 = (e)localArrayList.get(i);
      if (((e)localObject1).u0())
      {
        paramb = b((ArrayList)localObject7, ((e)localObject1).S0);
        localObject1 = b((ArrayList)localObject7, ((e)localObject1).T0);
        if ((paramb != null) && (localObject1 != null))
        {
          paramb.g(0, (o)localObject1);
          ((o)localObject1).i(2);
          ((ArrayList)localObject7).remove(paramb);
        }
      }
      i += 1;
    }
    if (((ArrayList)localObject7).size() <= 1) {
      return false;
    }
    if (paramf.C() == e.b.b)
    {
      localObject2 = ((ArrayList)localObject7).iterator();
      paramb = null;
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (o)((Iterator)localObject2).next();
        if (((o)localObject1).d() != 1)
        {
          ((o)localObject1).h(false);
          j = ((o)localObject1).f(paramf.O1(), 0);
          if (j > i)
          {
            paramb = (b.b)localObject1;
            i = j;
          }
        }
      }
      if (paramb != null)
      {
        paramf.T0(e.b.a);
        paramf.o1(i);
        paramb.h(true);
        localObject1 = paramb;
        break label1566;
      }
    }
    localObject1 = null;
    label1566:
    if (paramf.V() == e.b.b)
    {
      localObject3 = ((ArrayList)localObject7).iterator();
      paramb = null;
      i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (o)((Iterator)localObject3).next();
        if (((o)localObject2).d() != 0)
        {
          ((o)localObject2).h(false);
          j = ((o)localObject2).f(paramf.O1(), 1);
          if (j > i)
          {
            paramb = (b.b)localObject2;
            i = j;
          }
        }
      }
      if (paramb != null)
      {
        paramf.k1(e.b.a);
        paramf.P0(i);
        paramb.h(true);
        break label1676;
      }
    }
    paramb = null;
    label1676:
    return (localObject1 != null) || (paramb != null);
  }
  
  public static boolean d(e.b paramb1, e.b paramb2, e.b paramb3, e.b paramb4)
  {
    e.b localb1 = e.b.a;
    if (paramb3 != localb1)
    {
      e.b localb2 = e.b.b;
      if ((paramb3 != localb2) && ((paramb3 != e.b.d) || (paramb1 == localb2)))
      {
        i = 0;
        break label47;
      }
    }
    int i = 1;
    label47:
    if (paramb4 != localb1)
    {
      paramb1 = e.b.b;
      if ((paramb4 != paramb1) && ((paramb4 != e.b.d) || (paramb2 == paramb1)))
      {
        j = 0;
        break label86;
      }
    }
    int j = 1;
    label86:
    if (i == 0) {
      return j != 0;
    }
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.i
 * JD-Core Version:    0.7.0.1
 */