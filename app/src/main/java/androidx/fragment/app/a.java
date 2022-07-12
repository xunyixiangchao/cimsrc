package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

final class a
  extends q
  implements FragmentManager.m
{
  final FragmentManager t;
  boolean u;
  int v = -1;
  
  a(FragmentManager paramFragmentManager)
  {
    super(localg, localClassLoader);
    this.t = paramFragmentManager;
  }
  
  private static boolean B(q.a parama)
  {
    parama = parama.b;
    return (parama != null) && (parama.mAdded) && (parama.mView != null) && (!parama.mDetached) && (!parama.mHidden) && (parama.isPostponed());
  }
  
  boolean A(ArrayList<a> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return false;
    }
    int i1 = this.c.size();
    int k = -1;
    int j = 0;
    while (j < i1)
    {
      Object localObject = ((q.a)this.c.get(j)).b;
      int i;
      if (localObject != null) {
        i = ((Fragment)localObject).mContainerId;
      } else {
        i = 0;
      }
      int m = k;
      if (i != 0)
      {
        m = k;
        if (i != k)
        {
          k = paramInt1;
          while (k < paramInt2)
          {
            localObject = (a)paramArrayList.get(k);
            int i2 = ((q)localObject).c.size();
            m = 0;
            while (m < i2)
            {
              Fragment localFragment = ((q.a)((q)localObject).c.get(m)).b;
              int n;
              if (localFragment != null) {
                n = localFragment.mContainerId;
              } else {
                n = 0;
              }
              if (n == i) {
                return true;
              }
              m += 1;
            }
            k += 1;
          }
          m = i;
        }
      }
      j += 1;
      k = m;
    }
    return false;
  }
  
  boolean C()
  {
    int i = 0;
    while (i < this.c.size())
    {
      if (B((q.a)this.c.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void D()
  {
    if (this.s != null)
    {
      int i = 0;
      while (i < this.s.size())
      {
        ((Runnable)this.s.get(i)).run();
        i += 1;
      }
      this.s = null;
    }
  }
  
  void E(Fragment.l paraml)
  {
    int i = 0;
    while (i < this.c.size())
    {
      q.a locala = (q.a)this.c.get(i);
      if (B(locala)) {
        locala.b.setOnStartEnterTransitionListener(paraml);
      }
      i += 1;
    }
  }
  
  Fragment F(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i = this.c.size() - 1;
    while (i >= 0)
    {
      q.a locala = (q.a)this.c.get(i);
      int j = locala.a;
      if (j != 1)
      {
        if (j != 3) {}
        switch (j)
        {
        default: 
          break;
        case 10: 
          locala.h = locala.g;
          break;
        case 9: 
          paramFragment = locala.b;
          break;
        case 8: 
          paramFragment = null;
          break;
        case 6: 
          paramArrayList.add(locala.b);
          break;
        }
      }
      else
      {
        paramArrayList.remove(locala.b);
      }
      i -= 1;
    }
    return paramFragment;
  }
  
  public boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (FragmentManager.G0(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Run: ");
      localStringBuilder.append(this);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.FALSE);
    if (this.i) {
      this.t.e(this);
    }
    return true;
  }
  
  public int g()
  {
    return s(false);
  }
  
  public int h()
  {
    return s(true);
  }
  
  public void i()
  {
    l();
    this.t.c0(this, false);
  }
  
  public void j()
  {
    l();
    this.t.c0(this, true);
  }
  
  public q k(Fragment paramFragment)
  {
    Object localObject = paramFragment.mFragmentManager;
    if ((localObject != null) && (localObject != this.t))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
      ((StringBuilder)localObject).append(paramFragment.toString());
      ((StringBuilder)localObject).append(" is already attached to a FragmentManager.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return super.k(paramFragment);
  }
  
  void m(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    super.m(paramInt1, paramFragment, paramString, paramInt2);
    paramFragment.mFragmentManager = this.t;
  }
  
  public q n(Fragment paramFragment)
  {
    Object localObject = paramFragment.mFragmentManager;
    if ((localObject != null) && (localObject != this.t))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
      ((StringBuilder)localObject).append(paramFragment.toString());
      ((StringBuilder)localObject).append(" is already attached to a FragmentManager.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    return super.n(paramFragment);
  }
  
  void r(int paramInt)
  {
    if (!this.i) {
      return;
    }
    Object localObject1;
    if (FragmentManager.G0(2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Bump nesting in ");
      ((StringBuilder)localObject1).append(this);
      ((StringBuilder)localObject1).append(" by ");
      ((StringBuilder)localObject1).append(paramInt);
      Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      localObject1 = (q.a)this.c.get(i);
      Object localObject2 = ((q.a)localObject1).b;
      if (localObject2 != null)
      {
        ((Fragment)localObject2).mBackStackNesting += paramInt;
        if (FragmentManager.G0(2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Bump nesting of ");
          ((StringBuilder)localObject2).append(((q.a)localObject1).b);
          ((StringBuilder)localObject2).append(" to ");
          ((StringBuilder)localObject2).append(((q.a)localObject1).b.mBackStackNesting);
          Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
        }
      }
      i += 1;
    }
  }
  
  int s(boolean paramBoolean)
  {
    if (!this.u)
    {
      if (FragmentManager.G0(2))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Commit: ");
        ((StringBuilder)localObject).append(this);
        Log.v("FragmentManager", ((StringBuilder)localObject).toString());
        localObject = new PrintWriter(new v("FragmentManager"));
        t("  ", (PrintWriter)localObject);
        ((PrintWriter)localObject).close();
      }
      this.u = true;
      int i;
      if (this.i) {
        i = this.t.j();
      } else {
        i = -1;
      }
      this.v = i;
      this.t.Z(this, paramBoolean);
      return this.v;
    }
    throw new IllegalStateException("commit already called");
  }
  
  public void t(String paramString, PrintWriter paramPrintWriter)
  {
    u(paramString, paramPrintWriter, true);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.v >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.v);
    }
    if (this.k != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.k);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void u(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.k);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.v);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.u);
      if (this.h != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.h));
      }
      if ((this.d != 0) || (this.e != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.d));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.e));
      }
      if ((this.f != 0) || (this.g != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.f));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.g));
      }
      if ((this.l != 0) || (this.m != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.l));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.m);
      }
      if ((this.n != 0) || (this.o != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.n));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.o);
      }
    }
    if (!this.c.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      int j = this.c.size();
      int i = 0;
      while (i < j)
      {
        q.a locala = (q.a)this.c.get(i);
        Object localObject;
        switch (locala.a)
        {
        default: 
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cmd=");
          ((StringBuilder)localObject).append(locala.a);
          localObject = ((StringBuilder)localObject).toString();
          break;
        case 10: 
          localObject = "OP_SET_MAX_LIFECYCLE";
          break;
        case 9: 
          localObject = "UNSET_PRIMARY_NAV";
          break;
        case 8: 
          localObject = "SET_PRIMARY_NAV";
          break;
        case 7: 
          localObject = "ATTACH";
          break;
        case 6: 
          localObject = "DETACH";
          break;
        case 5: 
          localObject = "SHOW";
          break;
        case 4: 
          localObject = "HIDE";
          break;
        case 3: 
          localObject = "REMOVE";
          break;
        case 2: 
          localObject = "REPLACE";
          break;
        case 1: 
          localObject = "ADD";
          break;
        case 0: 
          localObject = "NULL";
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  Op #");
        paramPrintWriter.print(i);
        paramPrintWriter.print(": ");
        paramPrintWriter.print((String)localObject);
        paramPrintWriter.print(" ");
        paramPrintWriter.println(locala.b);
        if (paramBoolean)
        {
          if ((locala.c != 0) || (locala.d != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("enterAnim=#");
            paramPrintWriter.print(Integer.toHexString(locala.c));
            paramPrintWriter.print(" exitAnim=#");
            paramPrintWriter.println(Integer.toHexString(locala.d));
          }
          if ((locala.e != 0) || (locala.f != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("popEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(locala.e));
            paramPrintWriter.print(" popExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(locala.f));
          }
        }
        i += 1;
      }
    }
  }
  
  void v()
  {
    int j = this.c.size();
    int i = 0;
    Object localObject1;
    while (i < j)
    {
      localObject1 = (q.a)this.c.get(i);
      Object localObject2 = ((q.a)localObject1).b;
      if (localObject2 != null)
      {
        ((Fragment)localObject2).setPopDirection(false);
        ((Fragment)localObject2).setNextTransition(this.h);
        ((Fragment)localObject2).setSharedElementNames(this.p, this.q);
      }
      switch (((q.a)localObject1).a)
      {
      case 2: 
      default: 
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Unknown cmd: ");
        ((StringBuilder)localObject2).append(((q.a)localObject1).a);
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
      case 10: 
        this.t.m1((Fragment)localObject2, ((q.a)localObject1).h);
        break;
      case 9: 
        this.t.n1(null);
        break;
      case 8: 
        this.t.n1((Fragment)localObject2);
        break;
      case 7: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.l1((Fragment)localObject2, false);
        this.t.l((Fragment)localObject2);
        break;
      case 6: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.y((Fragment)localObject2);
        break;
      case 5: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.l1((Fragment)localObject2, false);
        this.t.p1((Fragment)localObject2);
        break;
      case 4: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.D0((Fragment)localObject2);
        break;
      case 3: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.d1((Fragment)localObject2);
        break;
      case 1: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.l1((Fragment)localObject2, false);
        this.t.g((Fragment)localObject2);
      }
      if ((!this.r) && (((q.a)localObject1).a != 1) && (localObject2 != null) && (!FragmentManager.P)) {
        this.t.Q0((Fragment)localObject2);
      }
      i += 1;
    }
    if ((!this.r) && (!FragmentManager.P))
    {
      localObject1 = this.t;
      ((FragmentManager)localObject1).R0(((FragmentManager)localObject1).q, true);
    }
  }
  
  void w(boolean paramBoolean)
  {
    int i = this.c.size() - 1;
    Object localObject1;
    while (i >= 0)
    {
      localObject1 = (q.a)this.c.get(i);
      Object localObject2 = ((q.a)localObject1).b;
      if (localObject2 != null)
      {
        ((Fragment)localObject2).setPopDirection(true);
        ((Fragment)localObject2).setNextTransition(FragmentManager.i1(this.h));
        ((Fragment)localObject2).setSharedElementNames(this.q, this.p);
      }
      switch (((q.a)localObject1).a)
      {
      case 2: 
      default: 
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Unknown cmd: ");
        ((StringBuilder)localObject2).append(((q.a)localObject1).a);
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
      case 10: 
        this.t.m1((Fragment)localObject2, ((q.a)localObject1).g);
        break;
      case 9: 
        this.t.n1((Fragment)localObject2);
        break;
      case 8: 
        this.t.n1(null);
        break;
      case 7: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.l1((Fragment)localObject2, true);
        this.t.y((Fragment)localObject2);
        break;
      case 6: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.l((Fragment)localObject2);
        break;
      case 5: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.l1((Fragment)localObject2, true);
        this.t.D0((Fragment)localObject2);
        break;
      case 4: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.p1((Fragment)localObject2);
        break;
      case 3: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.g((Fragment)localObject2);
        break;
      case 1: 
        ((Fragment)localObject2).setAnimations(((q.a)localObject1).c, ((q.a)localObject1).d, ((q.a)localObject1).e, ((q.a)localObject1).f);
        this.t.l1((Fragment)localObject2, true);
        this.t.d1((Fragment)localObject2);
      }
      if ((!this.r) && (((q.a)localObject1).a != 3) && (localObject2 != null) && (!FragmentManager.P)) {
        this.t.Q0((Fragment)localObject2);
      }
      i -= 1;
    }
    if ((!this.r) && (paramBoolean) && (!FragmentManager.P))
    {
      localObject1 = this.t;
      ((FragmentManager)localObject1).R0(((FragmentManager)localObject1).q, true);
    }
  }
  
  Fragment x(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int j = 0;
    for (Fragment localFragment1 = paramFragment; j < this.c.size(); localFragment1 = paramFragment)
    {
      Object localObject = (q.a)this.c.get(j);
      int i = ((q.a)localObject).a;
      if (i != 1) {
        if (i != 2)
        {
          if ((i != 3) && (i != 6))
          {
            if (i != 7)
            {
              if (i != 8)
              {
                paramFragment = localFragment1;
                i = j;
                break label445;
              }
              this.c.add(j, new q.a(9, localFragment1));
              i = j + 1;
              paramFragment = ((q.a)localObject).b;
              break label445;
            }
          }
          else
          {
            paramArrayList.remove(((q.a)localObject).b);
            localObject = ((q.a)localObject).b;
            paramFragment = localFragment1;
            i = j;
            if (localObject != localFragment1) {
              break label445;
            }
            this.c.add(j, new q.a(9, (Fragment)localObject));
            i = j + 1;
            paramFragment = null;
            break label445;
          }
        }
        else
        {
          Fragment localFragment2 = ((q.a)localObject).b;
          int i1 = localFragment2.mContainerId;
          int k = paramArrayList.size() - 1;
          int m = 0;
          i = j;
          paramFragment = localFragment1;
          while (k >= 0)
          {
            Fragment localFragment3 = (Fragment)paramArrayList.get(k);
            localFragment1 = paramFragment;
            j = i;
            int n = m;
            if (localFragment3.mContainerId == i1) {
              if (localFragment3 == localFragment2)
              {
                n = 1;
                localFragment1 = paramFragment;
                j = i;
              }
              else
              {
                localFragment1 = paramFragment;
                j = i;
                if (localFragment3 == paramFragment)
                {
                  this.c.add(i, new q.a(9, localFragment3));
                  j = i + 1;
                  localFragment1 = null;
                }
                paramFragment = new q.a(3, localFragment3);
                paramFragment.c = ((q.a)localObject).c;
                paramFragment.e = ((q.a)localObject).e;
                paramFragment.d = ((q.a)localObject).d;
                paramFragment.f = ((q.a)localObject).f;
                this.c.add(j, paramFragment);
                paramArrayList.remove(localFragment3);
                j += 1;
                n = m;
              }
            }
            k -= 1;
            paramFragment = localFragment1;
            i = j;
            m = n;
          }
          if (m != 0)
          {
            this.c.remove(i);
            i -= 1;
            break label445;
          }
          ((q.a)localObject).a = 1;
          paramArrayList.add(localFragment2);
          break label445;
        }
      }
      paramArrayList.add(((q.a)localObject).b);
      i = j;
      paramFragment = localFragment1;
      label445:
      j = i + 1;
    }
    return localFragment1;
  }
  
  public String y()
  {
    return this.k;
  }
  
  boolean z(int paramInt)
  {
    int k = this.c.size();
    int i = 0;
    while (i < k)
    {
      Fragment localFragment = ((q.a)this.c.get(i)).b;
      int j;
      if (localFragment != null) {
        j = localFragment.mContainerId;
      } else {
        j = 0;
      }
      if ((j != 0) && (j == paramInt)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.a
 * JD-Core Version:    0.7.0.1
 */