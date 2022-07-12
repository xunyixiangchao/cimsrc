package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
  extends q
{
  private static TimeInterpolator s;
  private ArrayList<RecyclerView.c0> h = new ArrayList();
  private ArrayList<RecyclerView.c0> i = new ArrayList();
  private ArrayList<j> j = new ArrayList();
  private ArrayList<i> k = new ArrayList();
  ArrayList<ArrayList<RecyclerView.c0>> l = new ArrayList();
  ArrayList<ArrayList<j>> m = new ArrayList();
  ArrayList<ArrayList<i>> n = new ArrayList();
  ArrayList<RecyclerView.c0> o = new ArrayList();
  ArrayList<RecyclerView.c0> p = new ArrayList();
  ArrayList<RecyclerView.c0> q = new ArrayList();
  ArrayList<RecyclerView.c0> r = new ArrayList();
  
  private void T(final RecyclerView.c0 paramc0)
  {
    final View localView = paramc0.a;
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.q.add(paramc0);
    localViewPropertyAnimator.setDuration(o()).alpha(0.0F).setListener(new d(paramc0, localViewPropertyAnimator, localView)).start();
  }
  
  private void W(List<i> paramList, RecyclerView.c0 paramc0)
  {
    int i1 = paramList.size() - 1;
    while (i1 >= 0)
    {
      i locali = (i)paramList.get(i1);
      if ((Y(locali, paramc0)) && (locali.a == null) && (locali.b == null)) {
        paramList.remove(locali);
      }
      i1 -= 1;
    }
  }
  
  private void X(i parami)
  {
    RecyclerView.c0 localc0 = parami.a;
    if (localc0 != null) {
      Y(parami, localc0);
    }
    localc0 = parami.b;
    if (localc0 != null) {
      Y(parami, localc0);
    }
  }
  
  private boolean Y(i parami, RecyclerView.c0 paramc0)
  {
    RecyclerView.c0 localc0 = parami.b;
    boolean bool = false;
    if (localc0 == paramc0)
    {
      parami.b = null;
    }
    else
    {
      if (parami.a != paramc0) {
        break label69;
      }
      parami.a = null;
      bool = true;
    }
    paramc0.a.setAlpha(1.0F);
    paramc0.a.setTranslationX(0.0F);
    paramc0.a.setTranslationY(0.0F);
    C(paramc0, bool);
    return true;
    label69:
    return false;
  }
  
  private void Z(RecyclerView.c0 paramc0)
  {
    if (s == null) {
      s = new ValueAnimator().getInterpolator();
    }
    paramc0.a.animate().setInterpolator(s);
    j(paramc0);
  }
  
  void Q(final RecyclerView.c0 paramc0)
  {
    final View localView = paramc0.a;
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.o.add(paramc0);
    localViewPropertyAnimator.alpha(1.0F).setDuration(l()).setListener(new e(paramc0, localView, localViewPropertyAnimator)).start();
  }
  
  void R(final i parami)
  {
    Object localObject1 = parami.a;
    final View localView = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((RecyclerView.c0)localObject1).a;
    }
    Object localObject2 = parami.b;
    if (localObject2 != null) {
      localView = ((RecyclerView.c0)localObject2).a;
    }
    if (localObject1 != null)
    {
      localObject2 = ((View)localObject1).animate().setDuration(m());
      this.r.add(parami.a);
      ((ViewPropertyAnimator)localObject2).translationX(parami.e - parami.c);
      ((ViewPropertyAnimator)localObject2).translationY(parami.f - parami.d);
      ((ViewPropertyAnimator)localObject2).alpha(0.0F).setListener(new g(parami, (ViewPropertyAnimator)localObject2, (View)localObject1)).start();
    }
    if (localView != null)
    {
      localObject1 = localView.animate();
      this.r.add(parami.b);
      ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(m()).alpha(1.0F).setListener(new h(parami, (ViewPropertyAnimator)localObject1, localView)).start();
    }
  }
  
  void S(final RecyclerView.c0 paramc0, final int paramInt1, final int paramInt2, int paramInt3, int paramInt4)
  {
    final View localView = paramc0.a;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if (paramInt1 != 0) {
      localView.animate().translationX(0.0F);
    }
    if (paramInt2 != 0) {
      localView.animate().translationY(0.0F);
    }
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.p.add(paramc0);
    localViewPropertyAnimator.setDuration(n()).setListener(new f(paramc0, paramInt1, localView, paramInt2, localViewPropertyAnimator)).start();
  }
  
  void U(List<RecyclerView.c0> paramList)
  {
    int i1 = paramList.size() - 1;
    while (i1 >= 0)
    {
      ((RecyclerView.c0)paramList.get(i1)).a.animate().cancel();
      i1 -= 1;
    }
  }
  
  void V()
  {
    if (!p()) {
      i();
    }
  }
  
  public boolean g(RecyclerView.c0 paramc0, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.g(paramc0, paramList));
  }
  
  public void j(RecyclerView.c0 paramc0)
  {
    View localView = paramc0.a;
    localView.animate().cancel();
    int i1 = this.j.size() - 1;
    while (i1 >= 0)
    {
      if (((j)this.j.get(i1)).a == paramc0)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        E(paramc0);
        this.j.remove(i1);
      }
      i1 -= 1;
    }
    W(this.k, paramc0);
    if (this.h.remove(paramc0))
    {
      localView.setAlpha(1.0F);
      G(paramc0);
    }
    if (this.i.remove(paramc0))
    {
      localView.setAlpha(1.0F);
      A(paramc0);
    }
    i1 = this.n.size() - 1;
    ArrayList localArrayList;
    while (i1 >= 0)
    {
      localArrayList = (ArrayList)this.n.get(i1);
      W(localArrayList, paramc0);
      if (localArrayList.isEmpty()) {
        this.n.remove(i1);
      }
      i1 -= 1;
    }
    i1 = this.m.size() - 1;
    while (i1 >= 0)
    {
      localArrayList = (ArrayList)this.m.get(i1);
      int i2 = localArrayList.size() - 1;
      while (i2 >= 0)
      {
        if (((j)localArrayList.get(i2)).a == paramc0)
        {
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          E(paramc0);
          localArrayList.remove(i2);
          if (!localArrayList.isEmpty()) {
            break;
          }
          this.m.remove(i1);
          break;
        }
        i2 -= 1;
      }
      i1 -= 1;
    }
    i1 = this.l.size() - 1;
    while (i1 >= 0)
    {
      localArrayList = (ArrayList)this.l.get(i1);
      if (localArrayList.remove(paramc0))
      {
        localView.setAlpha(1.0F);
        A(paramc0);
        if (localArrayList.isEmpty()) {
          this.l.remove(i1);
        }
      }
      i1 -= 1;
    }
    this.q.remove(paramc0);
    this.o.remove(paramc0);
    this.r.remove(paramc0);
    this.p.remove(paramc0);
    V();
  }
  
  public void k()
  {
    int i1 = this.j.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i1 >= 0)
    {
      localObject1 = (j)this.j.get(i1);
      localObject2 = ((j)localObject1).a.a;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      E(((j)localObject1).a);
      this.j.remove(i1);
      i1 -= 1;
    }
    i1 = this.h.size() - 1;
    while (i1 >= 0)
    {
      G((RecyclerView.c0)this.h.get(i1));
      this.h.remove(i1);
      i1 -= 1;
    }
    i1 = this.i.size() - 1;
    while (i1 >= 0)
    {
      localObject1 = (RecyclerView.c0)this.i.get(i1);
      ((RecyclerView.c0)localObject1).a.setAlpha(1.0F);
      A((RecyclerView.c0)localObject1);
      this.i.remove(i1);
      i1 -= 1;
    }
    i1 = this.k.size() - 1;
    while (i1 >= 0)
    {
      X((i)this.k.get(i1));
      i1 -= 1;
    }
    this.k.clear();
    if (!p()) {
      return;
    }
    i1 = this.m.size() - 1;
    int i2;
    while (i1 >= 0)
    {
      localObject1 = (ArrayList)this.m.get(i1);
      i2 = ((ArrayList)localObject1).size() - 1;
      while (i2 >= 0)
      {
        localObject2 = (j)((ArrayList)localObject1).get(i2);
        View localView = ((j)localObject2).a.a;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        E(((j)localObject2).a);
        ((ArrayList)localObject1).remove(i2);
        if (((ArrayList)localObject1).isEmpty()) {
          this.m.remove(localObject1);
        }
        i2 -= 1;
      }
      i1 -= 1;
    }
    i1 = this.l.size() - 1;
    while (i1 >= 0)
    {
      localObject1 = (ArrayList)this.l.get(i1);
      i2 = ((ArrayList)localObject1).size() - 1;
      while (i2 >= 0)
      {
        localObject2 = (RecyclerView.c0)((ArrayList)localObject1).get(i2);
        ((RecyclerView.c0)localObject2).a.setAlpha(1.0F);
        A((RecyclerView.c0)localObject2);
        ((ArrayList)localObject1).remove(i2);
        if (((ArrayList)localObject1).isEmpty()) {
          this.l.remove(localObject1);
        }
        i2 -= 1;
      }
      i1 -= 1;
    }
    i1 = this.n.size() - 1;
    while (i1 >= 0)
    {
      localObject1 = (ArrayList)this.n.get(i1);
      i2 = ((ArrayList)localObject1).size() - 1;
      while (i2 >= 0)
      {
        X((i)((ArrayList)localObject1).get(i2));
        if (((ArrayList)localObject1).isEmpty()) {
          this.n.remove(localObject1);
        }
        i2 -= 1;
      }
      i1 -= 1;
    }
    U(this.q);
    U(this.p);
    U(this.o);
    U(this.r);
    i();
  }
  
  public boolean p()
  {
    return (!this.i.isEmpty()) || (!this.k.isEmpty()) || (!this.j.isEmpty()) || (!this.h.isEmpty()) || (!this.p.isEmpty()) || (!this.q.isEmpty()) || (!this.o.isEmpty()) || (!this.r.isEmpty()) || (!this.m.isEmpty()) || (!this.l.isEmpty()) || (!this.n.isEmpty());
  }
  
  public void u()
  {
    boolean bool1 = this.h.isEmpty() ^ true;
    boolean bool2 = this.j.isEmpty() ^ true;
    boolean bool3 = this.k.isEmpty() ^ true;
    boolean bool4 = this.i.isEmpty() ^ true;
    if ((!bool1) && (!bool2) && (!bool4) && (!bool3)) {
      return;
    }
    Object localObject1 = this.h.iterator();
    while (((Iterator)localObject1).hasNext()) {
      T((RecyclerView.c0)((Iterator)localObject1).next());
    }
    this.h.clear();
    Object localObject2;
    if (bool2)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.j);
      this.m.add(localObject1);
      this.j.clear();
      localObject2 = new a((ArrayList)localObject1);
      if (bool1) {
        x.j0(((j)((ArrayList)localObject1).get(0)).a.a, (Runnable)localObject2, o());
      } else {
        ((Runnable)localObject2).run();
      }
    }
    if (bool3)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.k);
      this.n.add(localObject1);
      this.k.clear();
      localObject2 = new b((ArrayList)localObject1);
      if (bool1) {
        x.j0(((i)((ArrayList)localObject1).get(0)).a.a, (Runnable)localObject2, o());
      } else {
        ((Runnable)localObject2).run();
      }
    }
    if (bool4)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.i);
      this.l.add(localObject1);
      this.i.clear();
      localObject2 = new c((ArrayList)localObject1);
      if ((!bool1) && (!bool2) && (!bool3))
      {
        ((Runnable)localObject2).run();
        return;
      }
      long l3 = 0L;
      long l1;
      if (bool1) {
        l1 = o();
      } else {
        l1 = 0L;
      }
      if (bool2) {
        l2 = n();
      } else {
        l2 = 0L;
      }
      if (bool3) {
        l3 = m();
      }
      long l2 = Math.max(l2, l3);
      x.j0(((RecyclerView.c0)((ArrayList)localObject1).get(0)).a, (Runnable)localObject2, l1 + l2);
    }
  }
  
  public boolean w(RecyclerView.c0 paramc0)
  {
    Z(paramc0);
    paramc0.a.setAlpha(0.0F);
    this.i.add(paramc0);
    return true;
  }
  
  public boolean x(RecyclerView.c0 paramc01, RecyclerView.c0 paramc02, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramc01 == paramc02) {
      return y(paramc01, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = paramc01.a.getTranslationX();
    float f2 = paramc01.a.getTranslationY();
    float f3 = paramc01.a.getAlpha();
    Z(paramc01);
    int i1 = (int)(paramInt3 - paramInt1 - f1);
    int i2 = (int)(paramInt4 - paramInt2 - f2);
    paramc01.a.setTranslationX(f1);
    paramc01.a.setTranslationY(f2);
    paramc01.a.setAlpha(f3);
    if (paramc02 != null)
    {
      Z(paramc02);
      paramc02.a.setTranslationX(-i1);
      paramc02.a.setTranslationY(-i2);
      paramc02.a.setAlpha(0.0F);
    }
    this.k.add(new i(paramc01, paramc02, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean y(RecyclerView.c0 paramc0, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramc0.a;
    paramInt1 += (int)localView.getTranslationX();
    paramInt2 += (int)paramc0.a.getTranslationY();
    Z(paramc0);
    int i1 = paramInt3 - paramInt1;
    int i2 = paramInt4 - paramInt2;
    if ((i1 == 0) && (i2 == 0))
    {
      E(paramc0);
      return false;
    }
    if (i1 != 0) {
      localView.setTranslationX(-i1);
    }
    if (i2 != 0) {
      localView.setTranslationY(-i2);
    }
    this.j.add(new j(paramc0, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean z(RecyclerView.c0 paramc0)
  {
    Z(paramc0);
    this.h.add(paramc0);
    return true;
  }
  
  class a
    implements Runnable
  {
    a(ArrayList paramArrayList) {}
    
    public void run()
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        e.j localj = (e.j)localIterator.next();
        e.this.S(localj.a, localj.b, localj.c, localj.d, localj.e);
      }
      this.a.clear();
      e.this.m.remove(this.a);
    }
  }
  
  class b
    implements Runnable
  {
    b(ArrayList paramArrayList) {}
    
    public void run()
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        e.i locali = (e.i)localIterator.next();
        e.this.R(locali);
      }
      this.a.clear();
      e.this.n.remove(this.a);
    }
  }
  
  class c
    implements Runnable
  {
    c(ArrayList paramArrayList) {}
    
    public void run()
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        RecyclerView.c0 localc0 = (RecyclerView.c0)localIterator.next();
        e.this.Q(localc0);
      }
      this.a.clear();
      e.this.l.remove(this.a);
    }
  }
  
  class d
    extends AnimatorListenerAdapter
  {
    d(RecyclerView.c0 paramc0, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      localViewPropertyAnimator.setListener(null);
      localView.setAlpha(1.0F);
      e.this.G(paramc0);
      e.this.q.remove(paramc0);
      e.this.V();
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      e.this.H(paramc0);
    }
  }
  
  class e
    extends AnimatorListenerAdapter
  {
    e(RecyclerView.c0 paramc0, View paramView, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      localView.setAlpha(1.0F);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      localViewPropertyAnimator.setListener(null);
      e.this.A(paramc0);
      e.this.o.remove(paramc0);
      e.this.V();
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      e.this.B(paramc0);
    }
  }
  
  class f
    extends AnimatorListenerAdapter
  {
    f(RecyclerView.c0 paramc0, int paramInt1, View paramView, int paramInt2, ViewPropertyAnimator paramViewPropertyAnimator) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      if (paramInt1 != 0) {
        localView.setTranslationX(0.0F);
      }
      if (paramInt2 != 0) {
        localView.setTranslationY(0.0F);
      }
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      localViewPropertyAnimator.setListener(null);
      e.this.E(paramc0);
      e.this.p.remove(paramc0);
      e.this.V();
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      e.this.F(paramc0);
    }
  }
  
  class g
    extends AnimatorListenerAdapter
  {
    g(e.i parami, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      this.b.setListener(null);
      this.c.setAlpha(1.0F);
      this.c.setTranslationX(0.0F);
      this.c.setTranslationY(0.0F);
      e.this.C(parami.a, true);
      e.this.r.remove(parami.a);
      e.this.V();
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      e.this.D(parami.a, true);
    }
  }
  
  class h
    extends AnimatorListenerAdapter
  {
    h(e.i parami, ViewPropertyAnimator paramViewPropertyAnimator, View paramView) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      this.b.setListener(null);
      localView.setAlpha(1.0F);
      localView.setTranslationX(0.0F);
      localView.setTranslationY(0.0F);
      e.this.C(parami.b, false);
      e.this.r.remove(parami.b);
      e.this.V();
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      e.this.D(parami.b, false);
    }
  }
  
  private static class i
  {
    public RecyclerView.c0 a;
    public RecyclerView.c0 b;
    public int c;
    public int d;
    public int e;
    public int f;
    
    private i(RecyclerView.c0 paramc01, RecyclerView.c0 paramc02)
    {
      this.a = paramc01;
      this.b = paramc02;
    }
    
    i(RecyclerView.c0 paramc01, RecyclerView.c0 paramc02, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramc01, paramc02);
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramInt3;
      this.f = paramInt4;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ChangeInfo{oldHolder=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", newHolder=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", fromX=");
      localStringBuilder.append(this.c);
      localStringBuilder.append(", fromY=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", toX=");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", toY=");
      localStringBuilder.append(this.f);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  private static class j
  {
    public RecyclerView.c0 a;
    public int b;
    public int c;
    public int d;
    public int e;
    
    j(RecyclerView.c0 paramc0, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramc0;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.recyclerview.widget.e
 * JD-Core Version:    0.7.0.1
 */