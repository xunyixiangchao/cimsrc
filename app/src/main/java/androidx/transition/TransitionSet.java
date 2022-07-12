package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import p0.i;
import t1.c;

public class TransitionSet
  extends Transition
{
  private ArrayList<Transition> L = new ArrayList();
  private boolean M = true;
  int N;
  boolean O = false;
  private int P = 0;
  
  public TransitionSet() {}
  
  @SuppressLint({"RestrictedApi"})
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.i);
    v0(i.g(paramContext, (XmlResourceParser)paramAttributeSet, "transitionOrdering", 0, 0));
    paramContext.recycle();
  }
  
  private void o0(Transition paramTransition)
  {
    this.L.add(paramTransition);
    paramTransition.r = this;
  }
  
  private void x0()
  {
    b localb = new b(this);
    Iterator localIterator = this.L.iterator();
    while (localIterator.hasNext()) {
      ((Transition)localIterator.next()).a(localb);
    }
    this.N = this.L.size();
  }
  
  public void U(View paramView)
  {
    super.U(paramView);
    int j = this.L.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.L.get(i)).U(paramView);
      i += 1;
    }
  }
  
  public void Y(View paramView)
  {
    super.Y(paramView);
    int j = this.L.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.L.get(i)).Y(paramView);
      i += 1;
    }
  }
  
  protected void a0()
  {
    if (this.L.isEmpty())
    {
      j0();
      s();
      return;
    }
    x0();
    Object localObject;
    if (!this.M)
    {
      int i = 1;
      while (i < this.L.size())
      {
        ((Transition)this.L.get(i - 1)).a(new a((Transition)this.L.get(i)));
        i += 1;
      }
      localObject = (Transition)this.L.get(0);
      if (localObject != null) {
        ((Transition)localObject).a0();
      }
    }
    else
    {
      localObject = this.L.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Transition)((Iterator)localObject).next()).a0();
      }
    }
  }
  
  public void c0(Transition.e parame)
  {
    super.c0(parame);
    this.P |= 0x8;
    int j = this.L.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.L.get(i)).c0(parame);
      i += 1;
    }
  }
  
  public void g0(PathMotion paramPathMotion)
  {
    super.g0(paramPathMotion);
    this.P |= 0x4;
    if (this.L != null)
    {
      int i = 0;
      while (i < this.L.size())
      {
        ((Transition)this.L.get(i)).g0(paramPathMotion);
        i += 1;
      }
    }
  }
  
  public void h0(c paramc)
  {
    super.h0(paramc);
    this.P |= 0x2;
    int j = this.L.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.L.get(i)).h0(paramc);
      i += 1;
    }
  }
  
  public void j(t paramt)
  {
    if (M(paramt.b))
    {
      Iterator localIterator = this.L.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.M(paramt.b))
        {
          localTransition.j(paramt);
          paramt.c.add(localTransition);
        }
      }
    }
  }
  
  String k0(String paramString)
  {
    Object localObject = super.k0(paramString);
    int i = 0;
    while (i < this.L.size())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append((String)localObject);
      localStringBuilder1.append("\n");
      localObject = (Transition)this.L.get(i);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("  ");
      localStringBuilder1.append(((Transition)localObject).k0(localStringBuilder2.toString()));
      localObject = localStringBuilder1.toString();
      i += 1;
    }
    return localObject;
  }
  
  void l(t paramt)
  {
    super.l(paramt);
    int j = this.L.size();
    int i = 0;
    while (i < j)
    {
      ((Transition)this.L.get(i)).l(paramt);
      i += 1;
    }
  }
  
  public TransitionSet l0(Transition.f paramf)
  {
    return (TransitionSet)super.a(paramf);
  }
  
  public void m(t paramt)
  {
    if (M(paramt.b))
    {
      Iterator localIterator = this.L.iterator();
      while (localIterator.hasNext())
      {
        Transition localTransition = (Transition)localIterator.next();
        if (localTransition.M(paramt.b))
        {
          localTransition.m(paramt);
          paramt.c.add(localTransition);
        }
      }
    }
  }
  
  public TransitionSet m0(View paramView)
  {
    int i = 0;
    while (i < this.L.size())
    {
      ((Transition)this.L.get(i)).b(paramView);
      i += 1;
    }
    return (TransitionSet)super.b(paramView);
  }
  
  public TransitionSet n0(Transition paramTransition)
  {
    o0(paramTransition);
    long l = this.c;
    if (l >= 0L) {
      paramTransition.b0(l);
    }
    if ((this.P & 0x1) != 0) {
      paramTransition.e0(w());
    }
    if ((this.P & 0x2) != 0) {
      paramTransition.h0(A());
    }
    if ((this.P & 0x4) != 0) {
      paramTransition.g0(z());
    }
    if ((this.P & 0x8) != 0) {
      paramTransition.c0(v());
    }
    return this;
  }
  
  public Transition p()
  {
    TransitionSet localTransitionSet = (TransitionSet)super.p();
    localTransitionSet.L = new ArrayList();
    int j = this.L.size();
    int i = 0;
    while (i < j)
    {
      localTransitionSet.o0(((Transition)this.L.get(i)).p());
      i += 1;
    }
    return localTransitionSet;
  }
  
  public Transition p0(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.L.size())) {
      return (Transition)this.L.get(paramInt);
    }
    return null;
  }
  
  public int q0()
  {
    return this.L.size();
  }
  
  protected void r(ViewGroup paramViewGroup, u paramu1, u paramu2, ArrayList<t> paramArrayList1, ArrayList<t> paramArrayList2)
  {
    long l1 = D();
    int j = this.L.size();
    int i = 0;
    while (i < j)
    {
      Transition localTransition = (Transition)this.L.get(i);
      if ((l1 > 0L) && ((this.M) || (i == 0)))
      {
        long l2 = localTransition.D();
        if (l2 > 0L) {
          localTransition.i0(l2 + l1);
        } else {
          localTransition.i0(l1);
        }
      }
      localTransition.r(paramViewGroup, paramu1, paramu2, paramArrayList1, paramArrayList2);
      i += 1;
    }
  }
  
  public TransitionSet r0(Transition.f paramf)
  {
    return (TransitionSet)super.W(paramf);
  }
  
  public TransitionSet s0(View paramView)
  {
    int i = 0;
    while (i < this.L.size())
    {
      ((Transition)this.L.get(i)).X(paramView);
      i += 1;
    }
    return (TransitionSet)super.X(paramView);
  }
  
  public TransitionSet t0(long paramLong)
  {
    super.b0(paramLong);
    if (this.c >= 0L)
    {
      ArrayList localArrayList = this.L;
      if (localArrayList != null)
      {
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((Transition)this.L.get(i)).b0(paramLong);
          i += 1;
        }
      }
    }
    return this;
  }
  
  public TransitionSet u0(TimeInterpolator paramTimeInterpolator)
  {
    this.P |= 0x1;
    ArrayList localArrayList = this.L;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((Transition)this.L.get(i)).e0(paramTimeInterpolator);
        i += 1;
      }
    }
    return (TransitionSet)super.e0(paramTimeInterpolator);
  }
  
  public TransitionSet v0(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        this.M = false;
        return this;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid parameter for TransitionSet ordering: ");
      localStringBuilder.append(paramInt);
      throw new AndroidRuntimeException(localStringBuilder.toString());
    }
    this.M = true;
    return this;
  }
  
  public TransitionSet w0(long paramLong)
  {
    return (TransitionSet)super.i0(paramLong);
  }
  
  class a
    extends q
  {
    a(Transition paramTransition) {}
    
    public void e(Transition paramTransition)
    {
      this.a.a0();
      paramTransition.W(this);
    }
  }
  
  static class b
    extends q
  {
    TransitionSet a;
    
    b(TransitionSet paramTransitionSet)
    {
      this.a = paramTransitionSet;
    }
    
    public void a(Transition paramTransition)
    {
      paramTransition = this.a;
      if (!paramTransition.O)
      {
        paramTransition.j0();
        this.a.O = true;
      }
    }
    
    public void e(Transition paramTransition)
    {
      TransitionSet localTransitionSet = this.a;
      int i = localTransitionSet.N - 1;
      localTransitionSet.N = i;
      if (i == 0)
      {
        localTransitionSet.O = false;
        localTransitionSet.s();
      }
      paramTransition.W(this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.TransitionSet
 * JD-Core Version:    0.7.0.1
 */