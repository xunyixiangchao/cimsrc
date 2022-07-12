package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.p.b;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R.styleable;
import androidx.constraintlayout.widget.c;
import androidx.constraintlayout.widget.c.a;
import java.util.ArrayList;
import m0.a;

public class Carousel
  extends MotionHelper
{
  private int A = 4;
  private int B = 1;
  private float C = 2.0F;
  private int E = -1;
  private int F = 200;
  int G = -1;
  Runnable H = new a();
  private b n = null;
  private final ArrayList<View> o = new ArrayList();
  private int p = 0;
  private int q = 0;
  private MotionLayout r;
  private int s = -1;
  private boolean t = false;
  private int u = -1;
  private int v = -1;
  private int w = -1;
  private int x = -1;
  private float y = 0.9F;
  private int z = 0;
  
  public Carousel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    P(paramContext, paramAttributeSet);
  }
  
  public Carousel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    P(paramContext, paramAttributeSet);
  }
  
  private boolean O(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      return false;
    }
    Object localObject = this.r;
    if (localObject == null) {
      return false;
    }
    localObject = ((MotionLayout)localObject).o0(paramInt);
    if (localObject == null) {
      return false;
    }
    if (paramBoolean == ((p.b)localObject).C()) {
      return false;
    }
    ((p.b)localObject).F(paramBoolean);
    return true;
  }
  
  private void P(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.Carousel);
      int j = paramContext.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramContext.getIndex(i);
        if (k == R.styleable.Carousel_carousel_firstView) {
          this.s = paramContext.getResourceId(k, this.s);
        } else if (k == R.styleable.Carousel_carousel_backwardTransition) {
          this.u = paramContext.getResourceId(k, this.u);
        } else if (k == R.styleable.Carousel_carousel_forwardTransition) {
          this.v = paramContext.getResourceId(k, this.v);
        } else if (k == R.styleable.Carousel_carousel_emptyViewsBehavior) {
          this.A = paramContext.getInt(k, this.A);
        } else if (k == R.styleable.Carousel_carousel_previousState) {
          this.w = paramContext.getResourceId(k, this.w);
        } else if (k == R.styleable.Carousel_carousel_nextState) {
          this.x = paramContext.getResourceId(k, this.x);
        } else if (k == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
          this.y = paramContext.getFloat(k, this.y);
        } else if (k == R.styleable.Carousel_carousel_touchUpMode) {
          this.B = paramContext.getInt(k, this.B);
        } else if (k == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
          this.C = paramContext.getFloat(k, this.C);
        } else if (k == R.styleable.Carousel_carousel_infinite) {
          this.t = paramContext.getBoolean(k, this.t);
        }
        i += 1;
      }
      paramContext.recycle();
    }
  }
  
  private void R()
  {
    Object localObject = this.n;
    if (localObject == null) {
      return;
    }
    if (this.r == null) {
      return;
    }
    if (((b)localObject).c() == 0) {
      return;
    }
    int i1 = this.o.size();
    int k = 0;
    while (k < i1)
    {
      localObject = (View)this.o.get(k);
      int m = this.q + k - this.z;
      int j;
      if (this.t)
      {
        if (m < 0)
        {
          i = this.A;
          if (i != 4) {
            T((View)localObject, i);
          } else {
            T((View)localObject, 0);
          }
          if (m % this.n.c() == 0)
          {
            this.n.a((View)localObject, 0);
            break label336;
          }
          b localb = this.n;
          localb.a((View)localObject, localb.c() + m % this.n.c());
          break label336;
        }
        j = m;
        if (m >= this.n.c())
        {
          if (m == this.n.c())
          {
            i = 0;
          }
          else
          {
            i = m;
            if (m > this.n.c()) {
              i = m % this.n.c();
            }
          }
          m = this.A;
          j = i;
          if (m != 4)
          {
            T((View)localObject, m);
            break label324;
          }
        }
      }
      else
      {
        if (m < 0) {}
        do
        {
          T((View)localObject, this.A);
          break;
          j = m;
        } while (m >= this.n.c());
      }
      T((View)localObject, 0);
      i = j;
      label324:
      this.n.a((View)localObject, i);
      label336:
      k += 1;
    }
    int i = this.E;
    if ((i != -1) && (i != this.q)) {
      this.r.post(new a(this));
    } else if (i == this.q) {
      this.E = -1;
    }
    if ((this.u != -1) && (this.v != -1))
    {
      if (this.t) {
        return;
      }
      i = this.n.c();
      if (this.q == 0)
      {
        O(this.u, false);
      }
      else
      {
        O(this.u, true);
        this.r.setTransition(this.u);
      }
      if (this.q == i - 1)
      {
        O(this.v, false);
        return;
      }
      O(this.v, true);
      this.r.setTransition(this.v);
      return;
    }
    Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
  }
  
  private boolean S(int paramInt1, View paramView, int paramInt2)
  {
    Object localObject = this.r.m0(paramInt1);
    if (localObject == null) {
      return false;
    }
    localObject = ((c)localObject).w(paramView.getId());
    if (localObject == null) {
      return false;
    }
    ((c.a)localObject).c.c = 1;
    paramView.setVisibility(paramInt2);
    return true;
  }
  
  private boolean T(View paramView, int paramInt)
  {
    Object localObject = this.r;
    int i = 0;
    if (localObject == null) {
      return false;
    }
    localObject = ((MotionLayout)localObject).getConstraintSetIds();
    boolean bool = false;
    while (i < localObject.length)
    {
      bool |= S(localObject[i], paramView, paramInt);
      i += 1;
    }
    return bool;
  }
  
  public void a(MotionLayout paramMotionLayout, int paramInt1, int paramInt2, float paramFloat)
  {
    this.G = paramInt1;
  }
  
  public void d(MotionLayout paramMotionLayout, int paramInt)
  {
    int i = this.q;
    this.p = i;
    if (paramInt == this.x) {}
    for (paramInt = i + 1;; paramInt = i - 1)
    {
      this.q = paramInt;
      break;
      if (paramInt != this.w) {
        break;
      }
    }
    if (this.t)
    {
      if (this.q >= this.n.c()) {
        this.q = 0;
      }
      if (this.q < 0) {
        this.q = (this.n.c() - 1);
      }
    }
    else
    {
      if (this.q >= this.n.c()) {
        this.q = (this.n.c() - 1);
      }
      if (this.q < 0) {
        this.q = 0;
      }
    }
    if (this.p != this.q) {
      this.r.post(this.H);
    }
  }
  
  public int getCount()
  {
    b localb = this.n;
    if (localb != null) {
      return localb.c();
    }
    return 0;
  }
  
  public int getCurrentIndex()
  {
    return this.q;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((getParent() instanceof MotionLayout))
    {
      Object localObject = (MotionLayout)getParent();
      int i = 0;
      while (i < this.b)
      {
        int j = this.a[i];
        View localView = ((ConstraintLayout)localObject).l(j);
        if (this.s == j) {
          this.z = i;
        }
        this.o.add(localView);
        i += 1;
      }
      this.r = ((MotionLayout)localObject);
      if (this.B == 2)
      {
        localObject = ((MotionLayout)localObject).o0(this.v);
        if (localObject != null) {
          ((p.b)localObject).H(5);
        }
        localObject = this.r.o0(this.u);
        if (localObject != null) {
          ((p.b)localObject).H(5);
        }
      }
      R();
    }
  }
  
  public void setAdapter(b paramb)
  {
    this.n = paramb;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      Carousel.G(Carousel.this).setProgress(0.0F);
      Carousel.H(Carousel.this);
      Carousel.J(Carousel.this).b(Carousel.I(Carousel.this));
      float f1 = Carousel.G(Carousel.this).getVelocity();
      if ((Carousel.K(Carousel.this) == 2) && (f1 > Carousel.L(Carousel.this)) && (Carousel.I(Carousel.this) < Carousel.J(Carousel.this).c() - 1))
      {
        float f2 = Carousel.M(Carousel.this);
        if ((Carousel.I(Carousel.this) == 0) && (Carousel.N(Carousel.this) > Carousel.I(Carousel.this))) {
          return;
        }
        if ((Carousel.I(Carousel.this) == Carousel.J(Carousel.this).c() - 1) && (Carousel.N(Carousel.this) < Carousel.I(Carousel.this))) {
          return;
        }
        Carousel.G(Carousel.this).post(new a(f1 * f2));
      }
    }
    
    class a
      implements Runnable
    {
      a(float paramFloat) {}
      
      public void run()
      {
        Carousel.G(Carousel.this).C0(5, 1.0F, this.a);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt);
    
    public abstract void b(int paramInt);
    
    public abstract int c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.helper.widget.Carousel
 * JD-Core Version:    0.7.0.1
 */