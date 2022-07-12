package l0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import k0.e.b;
import k0.h;

public class e
{
  private k0.f a;
  private boolean b = true;
  private boolean c = true;
  private k0.f d;
  private ArrayList<p> e = new ArrayList();
  private ArrayList<m> f = new ArrayList();
  private b.b g = null;
  private b.a h = new b.a();
  ArrayList<m> i = new ArrayList();
  
  public e(k0.f paramf)
  {
    this.a = paramf;
    this.d = paramf;
  }
  
  private void a(f paramf1, int paramInt1, int paramInt2, f paramf2, ArrayList<m> paramArrayList, m paramm)
  {
    Object localObject1 = paramf1.d;
    if (((p)localObject1).c == null)
    {
      paramf1 = this.a;
      if (localObject1 != paramf1.e)
      {
        if (localObject1 == paramf1.f) {
          return;
        }
        paramf1 = paramm;
        if (paramm == null)
        {
          paramf1 = new m((p)localObject1, paramInt2);
          paramArrayList.add(paramf1);
        }
        ((p)localObject1).c = paramf1;
        paramf1.a((p)localObject1);
        paramm = ((p)localObject1).h.k.iterator();
        Object localObject2;
        while (paramm.hasNext())
        {
          localObject2 = (d)paramm.next();
          if ((localObject2 instanceof f)) {
            a((f)localObject2, paramInt1, 0, paramf2, paramArrayList, paramf1);
          }
        }
        paramm = ((p)localObject1).i.k.iterator();
        while (paramm.hasNext())
        {
          localObject2 = (d)paramm.next();
          if ((localObject2 instanceof f)) {
            a((f)localObject2, paramInt1, 1, paramf2, paramArrayList, paramf1);
          }
        }
        if ((paramInt1 == 1) && ((localObject1 instanceof n)))
        {
          paramm = ((n)localObject1).k.k.iterator();
          while (paramm.hasNext())
          {
            localObject2 = (d)paramm.next();
            if ((localObject2 instanceof f)) {
              a((f)localObject2, paramInt1, 2, paramf2, paramArrayList, paramf1);
            }
          }
        }
        paramm = ((p)localObject1).h.l.iterator();
        while (paramm.hasNext())
        {
          localObject2 = (f)paramm.next();
          if (localObject2 == paramf2) {
            paramf1.b = true;
          }
          a((f)localObject2, paramInt1, 0, paramf2, paramArrayList, paramf1);
        }
        paramm = ((p)localObject1).i.l.iterator();
        while (paramm.hasNext())
        {
          localObject2 = (f)paramm.next();
          if (localObject2 == paramf2) {
            paramf1.b = true;
          }
          a((f)localObject2, paramInt1, 1, paramf2, paramArrayList, paramf1);
        }
        if ((paramInt1 == 1) && ((localObject1 instanceof n))) {
          paramm = ((n)localObject1).k.l.iterator();
        }
      }
    }
    for (;;)
    {
      if (paramm.hasNext()) {
        localObject1 = (f)paramm.next();
      }
      try
      {
        a((f)localObject1, paramInt1, 2, paramf2, paramArrayList, paramf1);
      }
      finally {}
    }
  }
  
  private boolean b(k0.f paramf)
  {
    Iterator localIterator = paramf.V0.iterator();
    if (localIterator.hasNext())
    {
      k0.e locale = (k0.e)localIterator.next();
      Object localObject2 = locale.b0;
      Object localObject1 = localObject2[0];
      Object localObject3 = localObject2[1];
      if (locale.X() == 8) {}
      for (;;)
      {
        locale.a = true;
        break;
        if ((locale.B < 1.0F) && (localObject1 == e.b.c)) {
          locale.w = 2;
        }
        if ((locale.E < 1.0F) && (localObject3 == e.b.c)) {
          locale.x = 2;
        }
        if (locale.x() > 0.0F)
        {
          localObject2 = e.b.c;
          if ((localObject1 == localObject2) && ((localObject3 == e.b.b) || (localObject3 == e.b.a)))
          {
            locale.w = 3;
          }
          else
          {
            if ((localObject3 == localObject2) && ((localObject1 == e.b.b) || (localObject1 == e.b.a))) {}
            do
            {
              locale.x = 3;
              break;
              if ((localObject1 != localObject2) || (localObject3 != localObject2)) {
                break;
              }
              if (locale.w == 0) {
                locale.w = 3;
              }
            } while (locale.x == 0);
          }
        }
        e.b localb = e.b.c;
        localObject2 = localObject1;
        if (localObject1 == localb)
        {
          localObject2 = localObject1;
          if (locale.w == 1) {
            if (locale.Q.f != null)
            {
              localObject2 = localObject1;
              if (locale.S.f != null) {}
            }
            else
            {
              localObject2 = e.b.b;
            }
          }
        }
        localObject1 = localObject3;
        if (localObject3 == localb)
        {
          localObject1 = localObject3;
          if (locale.x == 1) {
            if (locale.R.f != null)
            {
              localObject1 = localObject3;
              if (locale.T.f != null) {}
            }
            else
            {
              localObject1 = e.b.b;
            }
          }
        }
        localObject3 = locale.e;
        ((p)localObject3).d = ((e.b)localObject2);
        int j = locale.w;
        ((p)localObject3).a = j;
        localObject3 = locale.f;
        ((p)localObject3).d = ((e.b)localObject1);
        int k = locale.x;
        ((p)localObject3).a = k;
        Object localObject4 = e.b.d;
        if (((localObject2 != localObject4) && (localObject2 != e.b.a) && (localObject2 != e.b.b)) || ((localObject1 != localObject4) && (localObject1 != e.b.a) && (localObject1 != e.b.b)))
        {
          if (localObject2 == localb)
          {
            localObject3 = e.b.b;
            if ((localObject1 == localObject3) || (localObject1 == e.b.a)) {
              if (j == 3)
              {
                if (localObject1 == localObject3) {
                  l(locale, (e.b)localObject3, 0, (e.b)localObject3, 0);
                }
                k = locale.z();
                j = (int)(k * locale.f0 + 0.5F);
              }
            }
          }
          label539:
          label581:
          Object localObject5;
          Object localObject6;
          label698:
          label713:
          float f2;
          float f1;
          for (;;)
          {
            localObject2 = e.b.a;
            localObject1 = localObject2;
            break label1240;
            if (j == 1)
            {
              l(locale, (e.b)localObject3, 0, (e.b)localObject1, 0);
              localObject1 = locale.e.e;
              j = locale.Y();
              ((g)localObject1).m = j;
              break;
            }
            if (j == 2)
            {
              localObject5 = paramf.b0;
              localObject6 = localObject5[0];
              localObject3 = e.b.a;
              if ((localObject6 != localObject3) && (localObject5[0] != localObject4)) {
                break label713;
              }
              j = (int)(locale.B * paramf.Y() + 0.5F);
              k = locale.z();
              localObject2 = localObject3;
            }
            else
            {
              localObject5 = locale.Y;
              if ((localObject5[0].f != null) && (localObject5[1].f != null)) {
                break label713;
              }
              j = 0;
              k = 0;
              localObject2 = localObject3;
            }
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            break label1240;
            if (localObject1 != localb) {
              break label961;
            }
            localObject3 = e.b.b;
            if ((localObject2 != localObject3) && (localObject2 != e.b.a)) {
              break label961;
            }
            if (k != 3) {
              break label807;
            }
            if (localObject2 == localObject3) {
              l(locale, (e.b)localObject3, 0, (e.b)localObject3, 0);
            }
            j = locale.Y();
            f2 = locale.f0;
            f1 = f2;
            if (locale.y() == -1) {
              f1 = 1.0F / f2;
            }
            k = (int)(j * f1 + 0.5F);
          }
          label807:
          if (k == 1) {
            l(locale, (e.b)localObject2, 0, (e.b)localObject3, 0);
          }
          for (;;)
          {
            localObject1 = locale.f.e;
            j = locale.z();
            break label581;
            if (k == 2)
            {
              localObject5 = paramf.b0;
              localObject6 = localObject5[1];
              localObject3 = e.b.a;
              if ((localObject6 == localObject3) || (localObject5[1] == localObject4))
              {
                f1 = locale.E;
                j = locale.Y();
                k = (int)(f1 * paramf.z() + 0.5F);
                localObject1 = localObject2;
                localObject2 = localObject3;
                break label1240;
              }
            }
            else
            {
              localObject4 = locale.Y;
              if ((localObject4[2].f == null) || (localObject4[3].f == null))
              {
                j = 0;
                k = 0;
                localObject2 = localObject3;
                break label698;
              }
            }
            label961:
            if ((localObject2 != localb) || (localObject1 != localb)) {
              break;
            }
            if ((j != 1) && (k != 1))
            {
              if ((k != 2) || (j != 2)) {
                break;
              }
              localObject1 = paramf.b0;
              localObject3 = localObject1[0];
              localObject2 = e.b.a;
              if ((localObject3 != localObject2) || (localObject1[1] != localObject2)) {
                break;
              }
              f1 = locale.B;
              f2 = locale.E;
              j = (int)(f1 * paramf.Y() + 0.5F);
              k = (int)(f2 * paramf.z() + 0.5F);
              break label539;
            }
            localObject1 = e.b.b;
            l(locale, (e.b)localObject1, 0, (e.b)localObject1, 0);
            locale.e.e.m = locale.Y();
          }
        }
        j = locale.Y();
        int m;
        if (localObject2 == localObject4)
        {
          j = paramf.Y();
          k = locale.Q.g;
          m = locale.S.g;
          localObject3 = e.b.a;
          j = j - k - m;
        }
        else
        {
          localObject3 = localObject2;
        }
        k = locale.z();
        if (localObject1 == localObject4)
        {
          k = paramf.z();
          m = locale.R.g;
          int n = locale.T.g;
          localObject2 = e.b.a;
          k = k - m - n;
        }
        else
        {
          localObject2 = localObject1;
        }
        localObject1 = localObject3;
        label1240:
        l(locale, (e.b)localObject1, j, (e.b)localObject2, k);
        locale.e.e.d(locale.Y());
        locale.f.e.d(locale.z());
      }
    }
    return false;
  }
  
  private int e(k0.f paramf, int paramInt)
  {
    int k = this.i.size();
    long l = 0L;
    int j = 0;
    while (j < k)
    {
      l = Math.max(l, ((m)this.i.get(j)).b(paramf, paramInt));
      j += 1;
    }
    return (int)l;
  }
  
  private void i(p paramp, int paramInt, ArrayList<m> paramArrayList)
  {
    Object localObject = paramp.h.k.iterator();
    d locald;
    while (((Iterator)localObject).hasNext())
    {
      locald = (d)((Iterator)localObject).next();
      if ((locald instanceof f)) {
        a((f)locald, paramInt, 0, paramp.i, paramArrayList, null);
      } else if ((locald instanceof p)) {
        a(((p)locald).h, paramInt, 0, paramp.i, paramArrayList, null);
      }
    }
    localObject = paramp.i.k.iterator();
    while (((Iterator)localObject).hasNext())
    {
      locald = (d)((Iterator)localObject).next();
      if ((locald instanceof f)) {
        a((f)locald, paramInt, 1, paramp.h, paramArrayList, null);
      } else if ((locald instanceof p)) {
        a(((p)locald).i, paramInt, 1, paramp.h, paramArrayList, null);
      }
    }
    if (paramInt == 1)
    {
      paramp = ((n)paramp).k.k.iterator();
      while (paramp.hasNext())
      {
        localObject = (d)paramp.next();
        if ((localObject instanceof f)) {
          a((f)localObject, paramInt, 2, null, paramArrayList, null);
        }
      }
    }
  }
  
  private void l(k0.e parame, e.b paramb1, int paramInt1, e.b paramb2, int paramInt2)
  {
    b.a locala = this.h;
    locala.a = paramb1;
    locala.b = paramb2;
    locala.c = paramInt1;
    locala.d = paramInt2;
    this.g.b(parame, locala);
    parame.o1(this.h.e);
    parame.P0(this.h.f);
    parame.O0(this.h.h);
    parame.E0(this.h.g);
  }
  
  public void c()
  {
    d(this.e);
    this.i.clear();
    m.h = 0;
    i(this.a.e, 0, this.i);
    i(this.a.f, 1, this.i);
    this.b = false;
  }
  
  public void d(ArrayList<p> paramArrayList)
  {
    paramArrayList.clear();
    this.d.e.f();
    this.d.f.f();
    paramArrayList.add(this.d.e);
    paramArrayList.add(this.d.f);
    Iterator localIterator = this.d.V0.iterator();
    Object localObject1 = null;
    if (localIterator.hasNext())
    {
      Object localObject3 = (k0.e)localIterator.next();
      if ((localObject3 instanceof h)) {}
      for (Object localObject2 = new j((k0.e)localObject3);; localObject2 = localObject3)
      {
        paramArrayList.add(localObject2);
        break;
        if (((k0.e)localObject3).k0())
        {
          if (((k0.e)localObject3).c == null) {
            ((k0.e)localObject3).c = new c((k0.e)localObject3, 0);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new HashSet();
          }
          ((HashSet)localObject2).add(((k0.e)localObject3).c);
          localObject1 = localObject2;
        }
        else
        {
          paramArrayList.add(((k0.e)localObject3).e);
        }
        if (((k0.e)localObject3).m0())
        {
          if (((k0.e)localObject3).d == null) {
            ((k0.e)localObject3).d = new c((k0.e)localObject3, 1);
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new HashSet();
          }
          ((HashSet)localObject2).add(((k0.e)localObject3).d);
        }
        else
        {
          paramArrayList.add(((k0.e)localObject3).f);
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        if (!(localObject3 instanceof k0.j)) {
          break;
        }
        localObject3 = new k((k0.e)localObject3);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null) {
      paramArrayList.addAll((Collection)localObject1);
    }
    localObject1 = paramArrayList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((p)((Iterator)localObject1).next()).f();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject1 = (p)paramArrayList.next();
      if (((p)localObject1).b != this.d) {
        ((p)localObject1).d();
      }
    }
  }
  
  public boolean f(boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool2 = paramBoolean & true;
    if ((this.b) || (this.c))
    {
      localObject1 = this.a.V0.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (k0.e)((Iterator)localObject1).next();
        ((k0.e)localObject2).p();
        ((k0.e)localObject2).a = false;
        ((k0.e)localObject2).e.r();
        ((k0.e)localObject2).f.q();
      }
      this.a.p();
      localObject1 = this.a;
      ((k0.e)localObject1).a = false;
      ((k0.e)localObject1).e.r();
      this.a.f.q();
      this.c = false;
    }
    if (b(this.d)) {
      return false;
    }
    this.a.q1(0);
    this.a.r1(0);
    Object localObject1 = this.a.w(0);
    Object localObject2 = this.a.w(1);
    if (this.b) {
      c();
    }
    int m = this.a.Z();
    int k = this.a.a0();
    this.a.e.h.d(m);
    this.a.f.h.d(k);
    m();
    Object localObject3 = e.b.b;
    boolean bool1;
    if ((localObject1 == localObject3) || (localObject2 == localObject3))
    {
      bool1 = bool2;
      if (bool2)
      {
        localObject3 = this.e.iterator();
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (((p)((Iterator)localObject3).next()).m());
        bool1 = false;
      }
      if ((bool1) && (localObject1 == e.b.b))
      {
        this.a.T0(e.b.a);
        localObject3 = this.a;
        ((k0.e)localObject3).o1(e((k0.f)localObject3, 0));
        localObject3 = this.a;
        ((k0.e)localObject3).e.e.d(((k0.e)localObject3).Y());
      }
      if ((bool1) && (localObject2 == e.b.b))
      {
        this.a.k1(e.b.a);
        localObject3 = this.a;
        ((k0.e)localObject3).P0(e((k0.f)localObject3, 1));
        localObject3 = this.a;
        ((k0.e)localObject3).f.e.d(((k0.e)localObject3).z());
      }
    }
    Object localObject4 = this.a;
    e.b[] arrayOfb = ((k0.e)localObject4).b0;
    e.b localb = arrayOfb[0];
    localObject3 = e.b.a;
    int j;
    if ((localb != localObject3) && (arrayOfb[0] != e.b.d))
    {
      bool1 = false;
    }
    else
    {
      j = ((k0.e)localObject4).Y() + m;
      this.a.e.i.d(j);
      this.a.e.e.d(j - m);
      m();
      localObject4 = this.a;
      arrayOfb = ((k0.e)localObject4).b0;
      if ((arrayOfb[1] == localObject3) || (arrayOfb[1] == e.b.d))
      {
        j = ((k0.e)localObject4).z() + k;
        this.a.f.i.d(j);
        this.a.f.e.d(j - k);
      }
      m();
      j = 1;
    }
    localObject3 = this.e.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (p)((Iterator)localObject3).next();
      if ((((p)localObject4).b != this.a) || (((p)localObject4).g)) {
        ((p)localObject4).e();
      }
    }
    localObject3 = this.e.iterator();
    do
    {
      paramBoolean = bool3;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject4 = (p)((Iterator)localObject3).next();
    } while ((j == 0) && (((p)localObject4).b == this.a));
    if (!((p)localObject4).h.j) {}
    for (;;)
    {
      paramBoolean = false;
      break label781;
      if ((((p)localObject4).i.j) || ((localObject4 instanceof j))) {
        if ((((p)localObject4).e.j) || ((localObject4 instanceof c)) || ((localObject4 instanceof j))) {
          break;
        }
      }
    }
    label781:
    this.a.T0((e.b)localObject1);
    this.a.k1((e.b)localObject2);
    return paramBoolean;
  }
  
  public boolean g(boolean paramBoolean)
  {
    if (this.b)
    {
      Object localObject1 = this.a.V0.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (k0.e)((Iterator)localObject1).next();
        ((k0.e)localObject2).p();
        ((k0.e)localObject2).a = false;
        l locall = ((k0.e)localObject2).e;
        locall.e.j = false;
        locall.g = false;
        locall.r();
        localObject2 = ((k0.e)localObject2).f;
        ((p)localObject2).e.j = false;
        ((p)localObject2).g = false;
        ((n)localObject2).q();
      }
      this.a.p();
      localObject1 = this.a;
      ((k0.e)localObject1).a = false;
      localObject1 = ((k0.e)localObject1).e;
      ((p)localObject1).e.j = false;
      ((p)localObject1).g = false;
      ((l)localObject1).r();
      localObject1 = this.a.f;
      ((p)localObject1).e.j = false;
      ((p)localObject1).g = false;
      ((n)localObject1).q();
      c();
    }
    if (b(this.d)) {
      return false;
    }
    this.a.q1(0);
    this.a.r1(0);
    this.a.e.h.d(0);
    this.a.f.h.d(0);
    return true;
  }
  
  public boolean h(boolean paramBoolean, int paramInt)
  {
    boolean bool3 = true;
    boolean bool2 = paramBoolean & true;
    e.b localb1 = this.a.w(0);
    e.b localb2 = this.a.w(1);
    int k = this.a.Z();
    int m = this.a.a0();
    Object localObject2;
    if (bool2)
    {
      localObject1 = e.b.b;
      if ((localb1 == localObject1) || (localb2 == localObject1))
      {
        localObject1 = this.e.iterator();
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (p)((Iterator)localObject1).next();
        } while ((((p)localObject2).f != paramInt) || (((p)localObject2).m()));
        boolean bool1 = false;
        if (paramInt == 0)
        {
          if ((!bool1) || (localb1 != e.b.b)) {
            break label260;
          }
          this.a.T0(e.b.a);
          localObject1 = this.a;
          ((k0.e)localObject1).o1(e((k0.f)localObject1, 0));
          localObject2 = this.a;
          localObject1 = ((k0.e)localObject2).e.e;
          j = ((k0.e)localObject2).Y();
        }
        else
        {
          if ((j == 0) || (localb2 != e.b.b)) {
            break label260;
          }
          this.a.k1(e.b.a);
          localObject1 = this.a;
          ((k0.e)localObject1).P0(e((k0.f)localObject1, 1));
          localObject2 = this.a;
          localObject1 = ((k0.e)localObject2).f.e;
          j = ((k0.e)localObject2).z();
        }
        ((g)localObject1).d(j);
      }
    }
    label260:
    Object localObject1 = this.a;
    if (paramInt == 0)
    {
      localObject2 = ((k0.e)localObject1).b0;
      if ((localObject2[0] == e.b.a) || (localObject2[0] == e.b.d))
      {
        j = ((k0.e)localObject1).Y() + k;
        this.a.e.i.d(j);
        this.a.e.e.d(j - k);
        break label415;
      }
    }
    else
    {
      localObject2 = ((k0.e)localObject1).b0;
      if ((localObject2[1] == e.b.a) || (localObject2[1] == e.b.d)) {
        break label375;
      }
    }
    int j = 0;
    break label417;
    label375:
    j = ((k0.e)localObject1).z() + m;
    this.a.f.i.d(j);
    this.a.f.e.d(j - m);
    label415:
    j = 1;
    label417:
    m();
    localObject1 = this.e.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (p)((Iterator)localObject1).next();
      if ((((p)localObject2).f == paramInt) && ((((p)localObject2).b != this.a) || (((p)localObject2).g))) {
        ((p)localObject2).e();
      }
    }
    localObject1 = this.e.iterator();
    do
    {
      paramBoolean = bool3;
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (p)((Iterator)localObject1).next();
    } while ((((p)localObject2).f != paramInt) || ((j == 0) && (((p)localObject2).b == this.a)));
    if (!((p)localObject2).h.j) {}
    for (;;)
    {
      paramBoolean = false;
      break label612;
      if (((p)localObject2).i.j) {
        if (((localObject2 instanceof c)) || (((p)localObject2).e.j)) {
          break;
        }
      }
    }
    label612:
    this.a.T0(localb1);
    this.a.k1(localb2);
    return paramBoolean;
  }
  
  public void j()
  {
    this.b = true;
  }
  
  public void k()
  {
    this.c = true;
  }
  
  public void m()
  {
    Iterator localIterator = this.a.V0.iterator();
    while (localIterator.hasNext())
    {
      k0.e locale = (k0.e)localIterator.next();
      if (!locale.a)
      {
        Object localObject2 = locale.b0;
        int m = 0;
        Object localObject1 = localObject2[0];
        Object localObject3 = localObject2[1];
        int j = locale.w;
        int n = locale.x;
        e.b localb = e.b.b;
        if ((localObject1 != localb) && ((localObject1 != e.b.c) || (j != 1))) {
          j = 0;
        } else {
          j = 1;
        }
        int k;
        if (localObject3 != localb)
        {
          k = m;
          if (localObject3 == e.b.c)
          {
            k = m;
            if (n != 1) {}
          }
        }
        else
        {
          k = 1;
        }
        localObject2 = locale.e.e;
        boolean bool1 = ((f)localObject2).j;
        g localg = locale.f.e;
        boolean bool2 = localg.j;
        if ((bool1) && (bool2))
        {
          localObject1 = e.b.a;
          l(locale, (e.b)localObject1, ((f)localObject2).g, (e.b)localObject1, localg.g);
          locale.a = true;
        }
        else if ((bool1) && (k != 0))
        {
          l(locale, e.b.a, ((f)localObject2).g, localb, localg.g);
          if (localObject3 == e.b.c)
          {
            localObject1 = locale.f.e;
            j = locale.z();
            label273:
            ((g)localObject1).m = j;
          }
          else
          {
            localObject1 = locale.f.e;
          }
        }
        else
        {
          for (j = locale.z();; j = locale.Y())
          {
            ((g)localObject1).d(j);
            break;
            if ((!bool2) || (j == 0)) {
              break label383;
            }
            l(locale, localb, ((f)localObject2).g, e.b.a, localg.g);
            if (localObject1 == e.b.c)
            {
              localObject1 = locale.e.e;
              j = locale.Y();
              break label273;
            }
            localObject1 = locale.e.e;
          }
        }
        label383:
        if (locale.a)
        {
          localObject1 = locale.f.l;
          if (localObject1 != null) {
            ((g)localObject1).d(locale.r());
          }
        }
      }
    }
  }
  
  public void n(b.b paramb)
  {
    this.g = paramb;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     l0.e
 * JD-Core Version:    0.7.0.1
 */