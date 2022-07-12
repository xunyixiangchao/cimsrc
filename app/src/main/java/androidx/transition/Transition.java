package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.x;
import g0.d;
import g0.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import p0.i;
import t1.c;

public abstract class Transition
  implements Cloneable
{
  private static final int[] I = { 2, 1, 3, 4 };
  private static final PathMotion J = new a();
  private static ThreadLocal<g0.a<Animator, d>> K = new ThreadLocal();
  private boolean A = false;
  private ArrayList<f> B = null;
  private ArrayList<Animator> C = new ArrayList();
  c E;
  private e F;
  private g0.a<String, String> G;
  private PathMotion H = J;
  private String a = getClass().getName();
  private long b = -1L;
  long c = -1L;
  private TimeInterpolator d = null;
  ArrayList<Integer> e = new ArrayList();
  ArrayList<View> f = new ArrayList();
  private ArrayList<String> g = null;
  private ArrayList<Class<?>> h = null;
  private ArrayList<Integer> i = null;
  private ArrayList<View> j = null;
  private ArrayList<Class<?>> k = null;
  private ArrayList<String> l = null;
  private ArrayList<Integer> m = null;
  private ArrayList<View> n = null;
  private ArrayList<Class<?>> o = null;
  private u p = new u();
  private u q = new u();
  TransitionSet r = null;
  private int[] s = I;
  private ArrayList<t> t;
  private ArrayList<t> u;
  private ViewGroup v = null;
  boolean w = false;
  ArrayList<Animator> x = new ArrayList();
  private int y = 0;
  private boolean z = false;
  
  public Transition() {}
  
  @SuppressLint({"RestrictedApi"})
  public Transition(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, p.c);
    paramAttributeSet = (XmlResourceParser)paramAttributeSet;
    long l1 = i.g(localTypedArray, paramAttributeSet, "duration", 1, -1);
    if (l1 >= 0L) {
      b0(l1);
    }
    l1 = i.g(localTypedArray, paramAttributeSet, "startDelay", 2, -1);
    if (l1 > 0L) {
      i0(l1);
    }
    int i1 = i.h(localTypedArray, paramAttributeSet, "interpolator", 0, 0);
    if (i1 > 0) {
      e0(AnimationUtils.loadInterpolator(paramContext, i1));
    }
    paramContext = i.i(localTypedArray, paramAttributeSet, "matchOrder", 3);
    if (paramContext != null) {
      f0(T(paramContext));
    }
    localTypedArray.recycle();
  }
  
  private static g0.a<Animator, d> C()
  {
    g0.a locala2 = (g0.a)K.get();
    g0.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new g0.a();
      K.set(locala1);
    }
    return locala1;
  }
  
  private static boolean L(int paramInt)
  {
    return (paramInt >= 1) && (paramInt <= 4);
  }
  
  private static boolean N(t paramt1, t paramt2, String paramString)
  {
    paramt1 = paramt1.a.get(paramString);
    paramt2 = paramt2.a.get(paramString);
    boolean bool = true;
    if ((paramt1 == null) && (paramt2 == null)) {
      return false;
    }
    if (paramt1 != null)
    {
      if (paramt2 == null) {
        return true;
      }
      bool = true ^ paramt1.equals(paramt2);
    }
    return bool;
  }
  
  private void O(g0.a<View, t> parama1, g0.a<View, t> parama2, SparseArray<View> paramSparseArray1, SparseArray<View> paramSparseArray2)
  {
    int i2 = paramSparseArray1.size();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView1 = (View)paramSparseArray1.valueAt(i1);
      if ((localView1 != null) && (M(localView1)))
      {
        View localView2 = (View)paramSparseArray2.get(paramSparseArray1.keyAt(i1));
        if ((localView2 != null) && (M(localView2)))
        {
          t localt1 = (t)parama1.get(localView1);
          t localt2 = (t)parama2.get(localView2);
          if ((localt1 != null) && (localt2 != null))
          {
            this.t.add(localt1);
            this.u.add(localt2);
            parama1.remove(localView1);
            parama2.remove(localView2);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void P(g0.a<View, t> parama1, g0.a<View, t> parama2)
  {
    int i1 = parama1.size() - 1;
    while (i1 >= 0)
    {
      Object localObject = (View)parama1.i(i1);
      if ((localObject != null) && (M((View)localObject)))
      {
        localObject = (t)parama2.remove(localObject);
        if ((localObject != null) && (M(((t)localObject).b)))
        {
          t localt = (t)parama1.k(i1);
          this.t.add(localt);
          this.u.add(localObject);
        }
      }
      i1 -= 1;
    }
  }
  
  private void Q(g0.a<View, t> parama1, g0.a<View, t> parama2, d<View> paramd1, d<View> paramd2)
  {
    int i2 = paramd1.o();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView1 = (View)paramd1.p(i1);
      if ((localView1 != null) && (M(localView1)))
      {
        View localView2 = (View)paramd2.e(paramd1.k(i1));
        if ((localView2 != null) && (M(localView2)))
        {
          t localt1 = (t)parama1.get(localView1);
          t localt2 = (t)parama2.get(localView2);
          if ((localt1 != null) && (localt2 != null))
          {
            this.t.add(localt1);
            this.u.add(localt2);
            parama1.remove(localView1);
            parama2.remove(localView2);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void R(g0.a<View, t> parama1, g0.a<View, t> parama2, g0.a<String, View> parama3, g0.a<String, View> parama4)
  {
    int i2 = parama3.size();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView1 = (View)parama3.m(i1);
      if ((localView1 != null) && (M(localView1)))
      {
        View localView2 = (View)parama4.get(parama3.i(i1));
        if ((localView2 != null) && (M(localView2)))
        {
          t localt1 = (t)parama1.get(localView1);
          t localt2 = (t)parama2.get(localView2);
          if ((localt1 != null) && (localt2 != null))
          {
            this.t.add(localt1);
            this.u.add(localt2);
            parama1.remove(localView1);
            parama2.remove(localView2);
          }
        }
      }
      i1 += 1;
    }
  }
  
  private void S(u paramu1, u paramu2)
  {
    g0.a locala1 = new g0.a(paramu1.a);
    g0.a locala2 = new g0.a(paramu2.a);
    int i1 = 0;
    for (;;)
    {
      int[] arrayOfInt = this.s;
      if (i1 >= arrayOfInt.length) {
        break;
      }
      int i2 = arrayOfInt[i1];
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 == 4) {
              Q(locala1, locala2, paramu1.c, paramu2.c);
            }
          }
          else {
            O(locala1, locala2, paramu1.b, paramu2.b);
          }
        }
        else {
          R(locala1, locala2, paramu1.d, paramu2.d);
        }
      }
      else {
        P(locala1, locala2);
      }
      i1 += 1;
    }
    c(locala1, locala2);
  }
  
  private static int[] T(String paramString)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString, ",");
    paramString = new int[localStringTokenizer.countTokens()];
    int i1 = 0;
    while (localStringTokenizer.hasMoreTokens())
    {
      Object localObject = localStringTokenizer.nextToken().trim();
      if ("id".equalsIgnoreCase((String)localObject))
      {
        paramString[i1] = 3;
      }
      else if ("instance".equalsIgnoreCase((String)localObject))
      {
        paramString[i1] = 1;
      }
      else if ("name".equalsIgnoreCase((String)localObject))
      {
        paramString[i1] = 2;
      }
      else if ("itemId".equalsIgnoreCase((String)localObject))
      {
        paramString[i1] = 4;
      }
      else
      {
        if (!((String)localObject).isEmpty()) {
          break label139;
        }
        localObject = new int[paramString.length - 1];
        System.arraycopy(paramString, 0, localObject, 0, i1);
        i1 -= 1;
        paramString = (String)localObject;
      }
      i1 += 1;
      continue;
      label139:
      paramString = new StringBuilder();
      paramString.append("Unknown match type in matchOrder: '");
      paramString.append((String)localObject);
      paramString.append("'");
      throw new InflateException(paramString.toString());
    }
    return paramString;
  }
  
  private void Z(Animator paramAnimator, final g0.a<Animator, d> parama)
  {
    if (paramAnimator != null)
    {
      paramAnimator.addListener(new b(parama));
      f(paramAnimator);
    }
  }
  
  private void c(g0.a<View, t> parama1, g0.a<View, t> parama2)
  {
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= parama1.size()) {
        break;
      }
      t localt = (t)parama1.m(i1);
      if (M(localt.b))
      {
        this.t.add(localt);
        this.u.add(null);
      }
      i1 += 1;
    }
    while (i2 < parama2.size())
    {
      parama1 = (t)parama2.m(i2);
      if (M(parama1.b))
      {
        this.u.add(parama1);
        this.t.add(null);
      }
      i2 += 1;
    }
  }
  
  private static void d(u paramu, View paramView, t paramt)
  {
    paramu.a.put(paramView, paramt);
    int i1 = paramView.getId();
    if (i1 >= 0) {
      if (paramu.b.indexOfKey(i1) >= 0) {
        paramu.b.put(i1, null);
      } else {
        paramu.b.put(i1, paramView);
      }
    }
    paramt = x.K(paramView);
    if (paramt != null) {
      if (paramu.d.containsKey(paramt)) {
        paramu.d.put(paramt, null);
      } else {
        paramu.d.put(paramt, paramView);
      }
    }
    if ((paramView.getParent() instanceof ListView))
    {
      paramt = (ListView)paramView.getParent();
      if (paramt.getAdapter().hasStableIds())
      {
        long l1 = paramt.getItemIdAtPosition(paramt.getPositionForView(paramView));
        if (paramu.c.j(l1) >= 0)
        {
          paramView = (View)paramu.c.e(l1);
          if (paramView != null)
          {
            x.A0(paramView, false);
            paramu.c.l(l1, null);
          }
        }
        else
        {
          x.A0(paramView, true);
          paramu.c.l(l1, paramView);
        }
      }
    }
  }
  
  private static boolean e(int[] paramArrayOfInt, int paramInt)
  {
    int i2 = paramArrayOfInt[paramInt];
    int i1 = 0;
    while (i1 < paramInt)
    {
      if (paramArrayOfInt[i1] == i2) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private void k(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int i3 = paramView.getId();
    Object localObject = this.i;
    if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(i3)))) {
      return;
    }
    localObject = this.j;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
      return;
    }
    localObject = this.k;
    int i2 = 0;
    int i1;
    if (localObject != null)
    {
      int i4 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i4)
      {
        if (((Class)this.k.get(i1)).isInstance(paramView)) {
          return;
        }
        i1 += 1;
      }
    }
    if ((paramView.getParent() instanceof ViewGroup))
    {
      t localt = new t(paramView);
      if (paramBoolean) {
        m(localt);
      } else {
        j(localt);
      }
      localt.c.add(this);
      l(localt);
      if (paramBoolean) {
        localObject = this.p;
      } else {
        localObject = this.q;
      }
      d((u)localObject, paramView, localt);
    }
    if ((paramView instanceof ViewGroup))
    {
      localObject = this.m;
      if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(i3)))) {
        return;
      }
      localObject = this.n;
      if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
        return;
      }
      localObject = this.o;
      if (localObject != null)
      {
        i3 = ((ArrayList)localObject).size();
        i1 = 0;
        while (i1 < i3)
        {
          if (((Class)this.o.get(i1)).isInstance(paramView)) {
            return;
          }
          i1 += 1;
        }
      }
      paramView = (ViewGroup)paramView;
      i1 = i2;
      while (i1 < paramView.getChildCount())
      {
        k(paramView.getChildAt(i1), paramBoolean);
        i1 += 1;
      }
    }
  }
  
  public c A()
  {
    return this.E;
  }
  
  public long D()
  {
    return this.b;
  }
  
  public List<Integer> E()
  {
    return this.e;
  }
  
  public List<String> F()
  {
    return this.g;
  }
  
  public List<Class<?>> G()
  {
    return this.h;
  }
  
  public List<View> H()
  {
    return this.f;
  }
  
  public String[] I()
  {
    return null;
  }
  
  public t J(View paramView, boolean paramBoolean)
  {
    Object localObject = this.r;
    if (localObject != null) {
      return ((Transition)localObject).J(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject = this.p;
    } else {
      localObject = this.q;
    }
    return (t)((u)localObject).a.get(paramView);
  }
  
  public boolean K(t paramt1, t paramt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramt1 != null)
    {
      bool1 = bool2;
      if (paramt2 != null)
      {
        Object localObject = I();
        if (localObject != null)
        {
          int i2 = localObject.length;
          int i1 = 0;
          for (;;)
          {
            bool1 = bool2;
            if (i1 >= i2) {
              break label120;
            }
            if (N(paramt1, paramt2, localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        localObject = paramt1.a.keySet().iterator();
        do
        {
          bool1 = bool2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!N(paramt1, paramt2, (String)((Iterator)localObject).next()));
        bool1 = true;
      }
    }
    label120:
    return bool1;
  }
  
  boolean M(View paramView)
  {
    int i2 = paramView.getId();
    ArrayList localArrayList = this.i;
    if ((localArrayList != null) && (localArrayList.contains(Integer.valueOf(i2)))) {
      return false;
    }
    localArrayList = this.j;
    if ((localArrayList != null) && (localArrayList.contains(paramView))) {
      return false;
    }
    localArrayList = this.k;
    int i1;
    if (localArrayList != null)
    {
      int i3 = localArrayList.size();
      i1 = 0;
      while (i1 < i3)
      {
        if (((Class)this.k.get(i1)).isInstance(paramView)) {
          return false;
        }
        i1 += 1;
      }
    }
    if ((this.l != null) && (x.K(paramView) != null) && (this.l.contains(x.K(paramView)))) {
      return false;
    }
    if ((this.e.size() == 0) && (this.f.size() == 0))
    {
      localArrayList = this.h;
      if ((localArrayList == null) || (localArrayList.isEmpty()))
      {
        localArrayList = this.g;
        if ((localArrayList == null) || (localArrayList.isEmpty())) {
          return true;
        }
      }
    }
    if (!this.e.contains(Integer.valueOf(i2)))
    {
      if (this.f.contains(paramView)) {
        return true;
      }
      localArrayList = this.g;
      if ((localArrayList != null) && (localArrayList.contains(x.K(paramView)))) {
        return true;
      }
      if (this.h != null)
      {
        i1 = 0;
        while (i1 < this.h.size())
        {
          if (((Class)this.h.get(i1)).isInstance(paramView)) {
            return true;
          }
          i1 += 1;
        }
      }
      return false;
    }
    return true;
  }
  
  public void U(View paramView)
  {
    if (!this.A)
    {
      g0.a locala = C();
      int i1 = locala.size();
      paramView = b0.d(paramView);
      i1 -= 1;
      while (i1 >= 0)
      {
        d locald = (d)locala.m(i1);
        if ((locald.a != null) && (paramView.equals(locald.d))) {
          a.b((Animator)locala.i(i1));
        }
        i1 -= 1;
      }
      paramView = this.B;
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = (ArrayList)this.B.clone();
        int i2 = paramView.size();
        i1 = 0;
        while (i1 < i2)
        {
          ((f)paramView.get(i1)).c(this);
          i1 += 1;
        }
      }
      this.z = true;
    }
  }
  
  void V(ViewGroup paramViewGroup)
  {
    this.t = new ArrayList();
    this.u = new ArrayList();
    S(this.p, this.q);
    g0.a locala = C();
    int i1 = locala.size();
    j0 localj0 = b0.d(paramViewGroup);
    i1 -= 1;
    while (i1 >= 0)
    {
      Animator localAnimator = (Animator)locala.i(i1);
      if (localAnimator != null)
      {
        d locald = (d)locala.get(localAnimator);
        if ((locald != null) && (locald.a != null) && (localj0.equals(locald.d)))
        {
          t localt3 = locald.c;
          View localView = locald.a;
          t localt4 = J(localView, true);
          t localt2 = x(localView, true);
          t localt1 = localt2;
          if (localt4 == null)
          {
            localt1 = localt2;
            if (localt2 == null) {
              localt1 = (t)this.q.a.get(localView);
            }
          }
          int i2;
          if (((localt4 != null) || (localt1 != null)) && (locald.e.K(localt3, localt1))) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (i2 != 0) {
            if ((!localAnimator.isRunning()) && (!localAnimator.isStarted())) {
              locala.remove(localAnimator);
            } else {
              localAnimator.cancel();
            }
          }
        }
      }
      i1 -= 1;
    }
    r(paramViewGroup, this.p, this.q, this.t, this.u);
    a0();
  }
  
  public Transition W(f paramf)
  {
    ArrayList localArrayList = this.B;
    if (localArrayList == null) {
      return this;
    }
    localArrayList.remove(paramf);
    if (this.B.size() == 0) {
      this.B = null;
    }
    return this;
  }
  
  public Transition X(View paramView)
  {
    this.f.remove(paramView);
    return this;
  }
  
  public void Y(View paramView)
  {
    if (this.z)
    {
      if (!this.A)
      {
        g0.a locala = C();
        int i1 = locala.size();
        paramView = b0.d(paramView);
        i1 -= 1;
        while (i1 >= 0)
        {
          d locald = (d)locala.m(i1);
          if ((locald.a != null) && (paramView.equals(locald.d))) {
            a.c((Animator)locala.i(i1));
          }
          i1 -= 1;
        }
        paramView = this.B;
        if ((paramView != null) && (paramView.size() > 0))
        {
          paramView = (ArrayList)this.B.clone();
          int i2 = paramView.size();
          i1 = 0;
          while (i1 < i2)
          {
            ((f)paramView.get(i1)).d(this);
            i1 += 1;
          }
        }
      }
      this.z = false;
    }
  }
  
  public Transition a(f paramf)
  {
    if (this.B == null) {
      this.B = new ArrayList();
    }
    this.B.add(paramf);
    return this;
  }
  
  protected void a0()
  {
    j0();
    g0.a locala = C();
    Iterator localIterator = this.C.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (locala.containsKey(localAnimator))
      {
        j0();
        Z(localAnimator, locala);
      }
    }
    this.C.clear();
    s();
  }
  
  public Transition b(View paramView)
  {
    this.f.add(paramView);
    return this;
  }
  
  public Transition b0(long paramLong)
  {
    this.c = paramLong;
    return this;
  }
  
  public void c0(e parame)
  {
    this.F = parame;
  }
  
  protected void cancel()
  {
    int i1 = this.x.size() - 1;
    while (i1 >= 0)
    {
      ((Animator)this.x.get(i1)).cancel();
      i1 -= 1;
    }
    ArrayList localArrayList = this.B;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      localArrayList = (ArrayList)this.B.clone();
      int i2 = localArrayList.size();
      i1 = 0;
      while (i1 < i2)
      {
        ((f)localArrayList.get(i1)).b(this);
        i1 += 1;
      }
    }
  }
  
  public Transition e0(TimeInterpolator paramTimeInterpolator)
  {
    this.d = paramTimeInterpolator;
    return this;
  }
  
  protected void f(Animator paramAnimator)
  {
    if (paramAnimator == null)
    {
      s();
      return;
    }
    if (t() >= 0L) {
      paramAnimator.setDuration(t());
    }
    if (D() >= 0L) {
      paramAnimator.setStartDelay(D() + paramAnimator.getStartDelay());
    }
    if (w() != null) {
      paramAnimator.setInterpolator(w());
    }
    paramAnimator.addListener(new c());
    paramAnimator.start();
  }
  
  public void f0(int... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      int i1 = 0;
      while (i1 < paramVarArgs.length) {
        if (L(paramVarArgs[i1]))
        {
          if (!e(paramVarArgs, i1)) {
            i1 += 1;
          } else {
            throw new IllegalArgumentException("matches contains a duplicate value");
          }
        }
        else {
          throw new IllegalArgumentException("matches contains invalid value");
        }
      }
      this.s = ((int[])paramVarArgs.clone());
      return;
    }
    this.s = I;
  }
  
  public void g0(PathMotion paramPathMotion)
  {
    PathMotion localPathMotion = paramPathMotion;
    if (paramPathMotion == null) {
      localPathMotion = J;
    }
    this.H = localPathMotion;
  }
  
  public void h0(c paramc)
  {
    this.E = paramc;
  }
  
  public Transition i0(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public abstract void j(t paramt);
  
  protected void j0()
  {
    if (this.y == 0)
    {
      ArrayList localArrayList = this.B;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localArrayList = (ArrayList)this.B.clone();
        int i2 = localArrayList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          ((f)localArrayList.get(i1)).a(this);
          i1 += 1;
        }
      }
      this.A = false;
    }
    this.y += 1;
  }
  
  String k0(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject).append(": ");
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (this.c != -1L)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("dur(");
      paramString.append(this.c);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    localObject = paramString;
    if (this.b != -1L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("dly(");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(") ");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = (String)localObject;
    if (this.d != null)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("interp(");
      paramString.append(this.d);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    if (this.e.size() <= 0)
    {
      localObject = paramString;
      if (this.f.size() <= 0) {}
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("tgts(");
      paramString = ((StringBuilder)localObject).toString();
      int i1 = this.e.size();
      int i2 = 0;
      localObject = paramString;
      if (i1 > 0)
      {
        i1 = 0;
        for (;;)
        {
          localObject = paramString;
          if (i1 >= this.e.size()) {
            break;
          }
          localObject = paramString;
          if (i1 > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", ");
            localObject = ((StringBuilder)localObject).toString();
          }
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(this.e.get(i1));
          paramString = paramString.toString();
          i1 += 1;
        }
      }
      paramString = (String)localObject;
      if (this.f.size() > 0)
      {
        i1 = i2;
        for (;;)
        {
          paramString = (String)localObject;
          if (i1 >= this.f.size()) {
            break;
          }
          paramString = (String)localObject;
          if (i1 > 0)
          {
            paramString = new StringBuilder();
            paramString.append((String)localObject);
            paramString.append(", ");
            paramString = paramString.toString();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(this.f.get(i1));
          localObject = ((StringBuilder)localObject).toString();
          i1 += 1;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  void l(t paramt)
  {
    if ((this.E != null) && (!paramt.a.isEmpty()))
    {
      String[] arrayOfString = this.E.b();
      if (arrayOfString == null) {
        return;
      }
      int i2 = 0;
      int i1 = 0;
      while (i1 < arrayOfString.length)
      {
        if (!paramt.a.containsKey(arrayOfString[i1]))
        {
          i1 = i2;
          break label75;
        }
        i1 += 1;
      }
      i1 = 1;
      label75:
      if (i1 == 0) {
        this.E.a(paramt);
      }
    }
  }
  
  public abstract void m(t paramt);
  
  void n(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    o(paramBoolean);
    int i1 = this.e.size();
    int i3 = 0;
    Object localObject1;
    if ((i1 > 0) || (this.f.size() > 0))
    {
      localObject1 = this.g;
      if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty()))
      {
        localObject1 = this.h;
        if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
          break label80;
        }
      }
    }
    k(paramViewGroup, paramBoolean);
    break label303;
    label80:
    i1 = 0;
    Object localObject2;
    while (i1 < this.e.size())
    {
      localObject2 = paramViewGroup.findViewById(((Integer)this.e.get(i1)).intValue());
      if (localObject2 != null)
      {
        t localt = new t((View)localObject2);
        if (paramBoolean) {
          m(localt);
        } else {
          j(localt);
        }
        localt.c.add(this);
        l(localt);
        if (paramBoolean) {
          localObject1 = this.p;
        } else {
          localObject1 = this.q;
        }
        d((u)localObject1, (View)localObject2, localt);
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < this.f.size())
    {
      localObject1 = (View)this.f.get(i1);
      localObject2 = new t((View)localObject1);
      if (paramBoolean) {
        m((t)localObject2);
      } else {
        j((t)localObject2);
      }
      ((t)localObject2).c.add(this);
      l((t)localObject2);
      if (paramBoolean) {
        paramViewGroup = this.p;
      } else {
        paramViewGroup = this.q;
      }
      d(paramViewGroup, (View)localObject1, (t)localObject2);
      i1 += 1;
    }
    label303:
    if (!paramBoolean)
    {
      paramViewGroup = this.G;
      if (paramViewGroup != null)
      {
        int i4 = paramViewGroup.size();
        paramViewGroup = new ArrayList(i4);
        i1 = 0;
        int i2;
        for (;;)
        {
          i2 = i3;
          if (i1 >= i4) {
            break;
          }
          localObject1 = (String)this.G.i(i1);
          paramViewGroup.add(this.p.d.remove(localObject1));
          i1 += 1;
        }
        while (i2 < i4)
        {
          localObject1 = (View)paramViewGroup.get(i2);
          if (localObject1 != null)
          {
            localObject2 = (String)this.G.m(i2);
            this.p.d.put(localObject2, localObject1);
          }
          i2 += 1;
        }
      }
    }
  }
  
  void o(boolean paramBoolean)
  {
    u localu;
    if (paramBoolean)
    {
      this.p.a.clear();
      this.p.b.clear();
      localu = this.p;
    }
    else
    {
      this.q.a.clear();
      this.q.b.clear();
      localu = this.q;
    }
    localu.c.b();
  }
  
  public Transition p()
  {
    try
    {
      Transition localTransition = (Transition)super.clone();
      localTransition.C = new ArrayList();
      localTransition.p = new u();
      localTransition.q = new u();
      localTransition.t = null;
      localTransition.u = null;
      return localTransition;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public Animator q(ViewGroup paramViewGroup, t paramt1, t paramt2)
  {
    return null;
  }
  
  protected void r(ViewGroup paramViewGroup, u paramu1, u paramu2, ArrayList<t> paramArrayList1, ArrayList<t> paramArrayList2)
  {
    g0.a locala = C();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int i3 = paramArrayList1.size();
    long l1 = 9223372036854775807L;
    int i1 = 0;
    int i2;
    while (i1 < i3)
    {
      Object localObject1 = (t)paramArrayList1.get(i1);
      paramu1 = (t)paramArrayList2.get(i1);
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!((t)localObject1).c.contains(this)) {
          localObject2 = null;
        }
      }
      u localu = paramu1;
      if (paramu1 != null)
      {
        localu = paramu1;
        if (!paramu1.c.contains(this)) {
          localu = null;
        }
      }
      if ((localObject2 == null) && (localu == null)) {}
      do
      {
        do
        {
          l2 = l1;
          i2 = i1;
          break;
          if ((localObject2 != null) && (localu != null) && (!K(localObject2, localu))) {
            i2 = 0;
          } else {
            i2 = 1;
          }
        } while (i2 == 0);
        paramu1 = q(paramViewGroup, localObject2, localu);
      } while (paramu1 == null);
      Object localObject4;
      Object localObject3;
      if (localu != null)
      {
        localObject4 = localu.b;
        String[] arrayOfString = I();
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          localObject3 = new t((View)localObject4);
          localObject1 = (t)paramu2.a.get(localObject4);
          i2 = i1;
          if (localObject1 != null)
          {
            i4 = 0;
            for (;;)
            {
              i2 = i1;
              if (i4 >= arrayOfString.length) {
                break;
              }
              ((t)localObject3).a.put(arrayOfString[i4], ((t)localObject1).a.get(arrayOfString[i4]));
              i4 += 1;
            }
          }
          i1 = i2;
          int i4 = locala.size();
          i2 = 0;
          while (i2 < i4)
          {
            localObject1 = (d)locala.get((Animator)locala.i(i2));
            if ((((d)localObject1).c != null) && (((d)localObject1).a == localObject4) && (((d)localObject1).b.equals(y())) && (((d)localObject1).c.equals(localObject3)))
            {
              paramu1 = null;
              localObject1 = localObject3;
              break label417;
            }
            i2 += 1;
          }
          localObject1 = localObject3;
        }
        else
        {
          localObject1 = null;
        }
        label417:
        localObject3 = paramu1;
        paramu1 = (u)localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
      }
      else
      {
        localObject3 = localObject2.b;
        localObject4 = null;
        localObject1 = paramu1;
        paramu1 = (u)localObject4;
      }
      long l2 = l1;
      i2 = i1;
      if (localObject1 != null)
      {
        localObject4 = this.E;
        l2 = l1;
        if (localObject4 != null)
        {
          l2 = ((c)localObject4).c(paramViewGroup, this, localObject2, localu);
          localSparseIntArray.put(this.C.size(), (int)l2);
          l2 = Math.min(l2, l1);
        }
        locala.put(localObject1, new d((View)localObject3, y(), this, b0.d(paramViewGroup), paramu1));
        this.C.add(localObject1);
        i2 = i1;
      }
      i1 = i2 + 1;
      l1 = l2;
    }
    if (localSparseIntArray.size() != 0)
    {
      i1 = 0;
      while (i1 < localSparseIntArray.size())
      {
        i2 = localSparseIntArray.keyAt(i1);
        paramViewGroup = (Animator)this.C.get(i2);
        paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i1) - l1 + paramViewGroup.getStartDelay());
        i1 += 1;
      }
    }
  }
  
  protected void s()
  {
    int i1 = this.y - 1;
    this.y = i1;
    if (i1 == 0)
    {
      Object localObject = this.B;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (ArrayList)this.B.clone();
        int i2 = ((ArrayList)localObject).size();
        i1 = 0;
        while (i1 < i2)
        {
          ((f)((ArrayList)localObject).get(i1)).e(this);
          i1 += 1;
        }
      }
      i1 = 0;
      while (i1 < this.p.c.o())
      {
        localObject = (View)this.p.c.p(i1);
        if (localObject != null) {
          x.A0((View)localObject, false);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < this.q.c.o())
      {
        localObject = (View)this.q.c.p(i1);
        if (localObject != null) {
          x.A0((View)localObject, false);
        }
        i1 += 1;
      }
      this.A = true;
    }
  }
  
  public long t()
  {
    return this.c;
  }
  
  public String toString()
  {
    return k0("");
  }
  
  public Rect u()
  {
    e locale = this.F;
    if (locale == null) {
      return null;
    }
    return locale.a(this);
  }
  
  public e v()
  {
    return this.F;
  }
  
  public TimeInterpolator w()
  {
    return this.d;
  }
  
  t x(View paramView, boolean paramBoolean)
  {
    Object localObject1 = this.r;
    if (localObject1 != null) {
      return ((Transition)localObject1).x(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject1 = this.t;
    } else {
      localObject1 = this.u;
    }
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    int i4 = ((ArrayList)localObject1).size();
    int i3 = -1;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= i4) {
        break;
      }
      t localt = (t)((ArrayList)localObject1).get(i1);
      if (localt == null) {
        return null;
      }
      if (localt.b == paramView)
      {
        i2 = i1;
        break;
      }
      i1 += 1;
    }
    paramView = localObject2;
    if (i2 >= 0)
    {
      if (paramBoolean) {
        paramView = this.u;
      } else {
        paramView = this.t;
      }
      paramView = (t)paramView.get(i2);
    }
    return paramView;
  }
  
  public String y()
  {
    return this.a;
  }
  
  public PathMotion z()
  {
    return this.H;
  }
  
  static final class a
    extends PathMotion
  {
    public Path a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      Path localPath = new Path();
      localPath.moveTo(paramFloat1, paramFloat2);
      localPath.lineTo(paramFloat3, paramFloat4);
      return localPath;
    }
  }
  
  class b
    extends AnimatorListenerAdapter
  {
    b(g0.a parama) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      parama.remove(paramAnimator);
      Transition.this.x.remove(paramAnimator);
    }
    
    public void onAnimationStart(Animator paramAnimator)
    {
      Transition.this.x.add(paramAnimator);
    }
  }
  
  class c
    extends AnimatorListenerAdapter
  {
    c() {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      Transition.this.s();
      paramAnimator.removeListener(this);
    }
  }
  
  private static class d
  {
    View a;
    String b;
    t c;
    j0 d;
    Transition e;
    
    d(View paramView, String paramString, Transition paramTransition, j0 paramj0, t paramt)
    {
      this.a = paramView;
      this.b = paramString;
      this.c = paramt;
      this.d = paramj0;
      this.e = paramTransition;
    }
  }
  
  public static abstract class e
  {
    public abstract Rect a(Transition paramTransition);
  }
  
  public static abstract interface f
  {
    public abstract void a(Transition paramTransition);
    
    public abstract void b(Transition paramTransition);
    
    public abstract void c(Transition paramTransition);
    
    public abstract void d(Transition paramTransition);
    
    public abstract void e(Transition paramTransition);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.Transition
 * JD-Core Version:    0.7.0.1
 */