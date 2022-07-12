package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import p0.i;

public abstract class Visibility
  extends Transition
{
  private static final String[] M = { "android:visibility:visibility", "android:visibility:parent" };
  private int L = 3;
  
  public Visibility() {}
  
  @SuppressLint({"RestrictedApi"})
  public Visibility(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.e);
    int i = i.g(paramContext, (XmlResourceParser)paramAttributeSet, "transitionVisibilityMode", 0, 0);
    paramContext.recycle();
    if (i != 0) {
      s0(i);
    }
  }
  
  private void l0(t paramt)
  {
    int i = paramt.b.getVisibility();
    paramt.a.put("android:visibility:visibility", Integer.valueOf(i));
    paramt.a.put("android:visibility:parent", paramt.b.getParent());
    int[] arrayOfInt = new int[2];
    paramt.b.getLocationOnScreen(arrayOfInt);
    paramt.a.put("android:visibility:screenLocation", arrayOfInt);
  }
  
  private c n0(t paramt1, t paramt2)
  {
    c localc = new c();
    localc.a = false;
    localc.b = false;
    if ((paramt1 != null) && (paramt1.a.containsKey("android:visibility:visibility")))
    {
      localc.c = ((Integer)paramt1.a.get("android:visibility:visibility")).intValue();
      localc.e = ((ViewGroup)paramt1.a.get("android:visibility:parent"));
    }
    else
    {
      localc.c = -1;
      localc.e = null;
    }
    if ((paramt2 != null) && (paramt2.a.containsKey("android:visibility:visibility")))
    {
      localc.d = ((Integer)paramt2.a.get("android:visibility:visibility")).intValue();
      localc.f = ((ViewGroup)paramt2.a.get("android:visibility:parent"));
    }
    else
    {
      localc.d = -1;
      localc.f = null;
    }
    if ((paramt1 != null) && (paramt2 != null))
    {
      int i = localc.c;
      int j = localc.d;
      if ((i == j) && (localc.e == localc.f)) {
        return localc;
      }
      if (i != j)
      {
        if (i == 0) {
          break label294;
        }
        if (j != 0) {
          break label303;
        }
      }
      else
      {
        if (localc.f == null) {
          break label294;
        }
        if (localc.e != null) {
          break label303;
        }
      }
    }
    else
    {
      if ((paramt1 != null) || (localc.d != 0)) {
        break label282;
      }
    }
    label282:
    label294:
    for (localc.b = true;; localc.b = false)
    {
      localc.a = true;
      return localc;
      if ((paramt2 != null) || (localc.c != 0)) {
        break;
      }
    }
    label303:
    return localc;
  }
  
  public String[] I()
  {
    return M;
  }
  
  public boolean K(t paramt1, t paramt2)
  {
    boolean bool2 = false;
    if ((paramt1 == null) && (paramt2 == null)) {
      return false;
    }
    if ((paramt1 != null) && (paramt2 != null) && (paramt2.a.containsKey("android:visibility:visibility") != paramt1.a.containsKey("android:visibility:visibility"))) {
      return false;
    }
    paramt1 = n0(paramt1, paramt2);
    boolean bool1 = bool2;
    if (paramt1.a) {
      if (paramt1.c != 0)
      {
        bool1 = bool2;
        if (paramt1.d != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void j(t paramt)
  {
    l0(paramt);
  }
  
  public void m(t paramt)
  {
    l0(paramt);
  }
  
  public int m0()
  {
    return this.L;
  }
  
  public Animator o0(ViewGroup paramViewGroup, View paramView, t paramt1, t paramt2)
  {
    return null;
  }
  
  public Animator p0(ViewGroup paramViewGroup, t paramt1, int paramInt1, t paramt2, int paramInt2)
  {
    if ((this.L & 0x1) == 1)
    {
      if (paramt2 == null) {
        return null;
      }
      if (paramt1 == null)
      {
        View localView = (View)paramt2.b.getParent();
        if (n0(x(localView, false), J(localView, false)).a) {
          return null;
        }
      }
      return o0(paramViewGroup, paramt2.b, paramt1, paramt2);
    }
    return null;
  }
  
  public Animator q(ViewGroup paramViewGroup, t paramt1, t paramt2)
  {
    c localc = n0(paramt1, paramt2);
    if ((localc.a) && ((localc.e != null) || (localc.f != null)))
    {
      if (localc.b) {
        return p0(paramViewGroup, paramt1, localc.c, paramt2, localc.d);
      }
      return r0(paramViewGroup, paramt1, localc.c, paramt2, localc.d);
    }
    return null;
  }
  
  public Animator q0(ViewGroup paramViewGroup, View paramView, t paramt1, t paramt2)
  {
    return null;
  }
  
  public Animator r0(final ViewGroup paramViewGroup, t paramt1, int paramInt1, t paramt2, int paramInt2)
  {
    if ((this.L & 0x2) != 2) {
      return null;
    }
    if (paramt1 == null) {
      return null;
    }
    final View localView1 = paramt1.b;
    Object localObject2;
    if (paramt2 != null) {
      localObject2 = paramt2.b;
    } else {
      localObject2 = null;
    }
    int i = R.id.save_overlay_view;
    Object localObject1 = (View)localView1.getTag(i);
    if (localObject1 != null)
    {
      localObject2 = null;
      paramInt1 = 1;
    }
    else
    {
      if ((localObject2 != null) && (((View)localObject2).getParent() != null))
      {
        if ((paramInt2 == 4) || (localView1 == localObject2))
        {
          localObject1 = localObject2;
          paramInt1 = 0;
          localObject2 = null;
          break label138;
        }
      }
      else if (localObject2 != null)
      {
        localObject1 = null;
        paramInt1 = 0;
        break label138;
      }
      localObject2 = null;
      localObject1 = localObject2;
      paramInt1 = 1;
      label138:
      Object localObject3 = localObject2;
      if (paramInt1 != 0) {
        if (localView1.getParent() != null)
        {
          localObject3 = localObject2;
          if ((localView1.getParent() instanceof View))
          {
            View localView2 = (View)localView1.getParent();
            if (!n0(J(localView2, true), x(localView2, true)).a)
            {
              localObject3 = s.a(paramViewGroup, localView1, localView2);
            }
            else
            {
              paramInt1 = localView2.getId();
              localObject3 = localObject2;
              if (localView2.getParent() == null)
              {
                localObject3 = localObject2;
                if (paramInt1 != -1)
                {
                  localObject3 = localObject2;
                  if (paramViewGroup.findViewById(paramInt1) != null)
                  {
                    localObject3 = localObject2;
                    if (!this.w) {}
                  }
                }
              }
            }
          }
        }
        else
        {
          localObject2 = localObject1;
          paramInt1 = 0;
          localObject1 = localView1;
          break label292;
        }
      }
      paramInt1 = 0;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    label292:
    if (localObject1 != null)
    {
      if (paramInt1 == 0)
      {
        localObject2 = (int[])paramt1.a.get("android:visibility:screenLocation");
        paramInt2 = localObject2[0];
        int j = localObject2[1];
        localObject2 = new int[2];
        paramViewGroup.getLocationOnScreen((int[])localObject2);
        ((View)localObject1).offsetLeftAndRight(paramInt2 - localObject2[0] - ((View)localObject1).getLeft());
        ((View)localObject1).offsetTopAndBottom(j - localObject2[1] - ((View)localObject1).getTop());
        y.b(paramViewGroup).c((View)localObject1);
      }
      paramt1 = q0(paramViewGroup, (View)localObject1, paramt1, paramt2);
      if (paramInt1 == 0)
      {
        if (paramt1 == null)
        {
          y.b(paramViewGroup).d((View)localObject1);
          return paramt1;
        }
        localView1.setTag(i, localObject1);
        a(new a(paramViewGroup, (View)localObject1, localView1));
      }
      return paramt1;
    }
    if (localObject2 != null)
    {
      paramInt1 = ((View)localObject2).getVisibility();
      b0.i((View)localObject2, 0);
      paramViewGroup = q0(paramViewGroup, (View)localObject2, paramt1, paramt2);
      if (paramViewGroup != null)
      {
        paramt1 = new b((View)localObject2, paramInt2, true);
        paramViewGroup.addListener(paramt1);
        a.a(paramViewGroup, paramt1);
        a(paramt1);
        return paramViewGroup;
      }
      b0.i((View)localObject2, paramInt1);
      return paramViewGroup;
    }
    return null;
  }
  
  public void s0(int paramInt)
  {
    if ((paramInt & 0xFFFFFFFC) == 0)
    {
      this.L = paramInt;
      return;
    }
    throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
  }
  
  class a
    extends q
  {
    a(ViewGroup paramViewGroup, View paramView1, View paramView2) {}
    
    public void c(Transition paramTransition)
    {
      y.b(paramViewGroup).d(this.b);
    }
    
    public void d(Transition paramTransition)
    {
      if (this.b.getParent() == null)
      {
        y.b(paramViewGroup).c(this.b);
        return;
      }
      Visibility.this.cancel();
    }
    
    public void e(Transition paramTransition)
    {
      localView1.setTag(R.id.save_overlay_view, null);
      y.b(paramViewGroup).d(this.b);
      paramTransition.W(this);
    }
  }
  
  private static class b
    extends AnimatorListenerAdapter
    implements Transition.f
  {
    private final View a;
    private final int b;
    private final ViewGroup c;
    private final boolean d;
    private boolean e;
    boolean f = false;
    
    b(View paramView, int paramInt, boolean paramBoolean)
    {
      this.a = paramView;
      this.b = paramInt;
      this.c = ((ViewGroup)paramView.getParent());
      this.d = paramBoolean;
      g(true);
    }
    
    private void f()
    {
      if (!this.f)
      {
        b0.i(this.a, this.b);
        ViewGroup localViewGroup = this.c;
        if (localViewGroup != null) {
          localViewGroup.invalidate();
        }
      }
      g(false);
    }
    
    private void g(boolean paramBoolean)
    {
      if ((this.d) && (this.e != paramBoolean))
      {
        ViewGroup localViewGroup = this.c;
        if (localViewGroup != null)
        {
          this.e = paramBoolean;
          y.d(localViewGroup, paramBoolean);
        }
      }
    }
    
    public void a(Transition paramTransition) {}
    
    public void b(Transition paramTransition) {}
    
    public void c(Transition paramTransition)
    {
      g(false);
    }
    
    public void d(Transition paramTransition)
    {
      g(true);
    }
    
    public void e(Transition paramTransition)
    {
      f();
      paramTransition.W(this);
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.f = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      f();
    }
    
    public void onAnimationPause(Animator paramAnimator)
    {
      if (!this.f) {
        b0.i(this.a, this.b);
      }
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationResume(Animator paramAnimator)
    {
      if (!this.f) {
        b0.i(this.a, 0);
      }
    }
    
    public void onAnimationStart(Animator paramAnimator) {}
  }
  
  private static class c
  {
    boolean a;
    boolean b;
    int c;
    int d;
    ViewGroup e;
    ViewGroup f;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.Visibility
 * JD-Core Version:    0.7.0.1
 */