package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import java.util.Map;
import p0.i;

public class ChangeBounds
  extends Transition
{
  private static final String[] O = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  private static final Property<Drawable, PointF> P = new b(PointF.class, "boundsOrigin");
  private static final Property<k, PointF> Q = new c(PointF.class, "topLeft");
  private static final Property<k, PointF> R = new d(PointF.class, "bottomRight");
  private static final Property<View, PointF> S = new e(PointF.class, "bottomRight");
  private static final Property<View, PointF> T = new f(PointF.class, "topLeft");
  private static final Property<View, PointF> U = new g(PointF.class, "position");
  private static n V = new n();
  private int[] L = new int[2];
  private boolean M = false;
  private boolean N = false;
  
  public ChangeBounds() {}
  
  @SuppressLint({"RestrictedApi"})
  public ChangeBounds(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.d);
    boolean bool = i.a(paramContext, (XmlResourceParser)paramAttributeSet, "resizeClip", 0, false);
    paramContext.recycle();
    n0(bool);
  }
  
  private void l0(t paramt)
  {
    View localView = paramt.b;
    if ((x.U(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      paramt.a.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      paramt.a.put("android:changeBounds:parent", paramt.b.getParent());
      if (this.N)
      {
        paramt.b.getLocationInWindow(this.L);
        paramt.a.put("android:changeBounds:windowX", Integer.valueOf(this.L[0]));
        paramt.a.put("android:changeBounds:windowY", Integer.valueOf(this.L[1]));
      }
      if (this.M) {
        paramt.a.put("android:changeBounds:clip", x.u(localView));
      }
    }
  }
  
  private boolean m0(View paramView1, View paramView2)
  {
    if (this.N)
    {
      t localt = x(paramView1, true);
      if (localt == null) {
        if (paramView1 == paramView2) {
          return true;
        }
      }
      while (paramView2 != localt.b) {
        return false;
      }
    }
    return true;
  }
  
  public String[] I()
  {
    return O;
  }
  
  public void j(t paramt)
  {
    l0(paramt);
  }
  
  public void m(t paramt)
  {
    l0(paramt);
  }
  
  public void n0(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public Animator q(final ViewGroup paramViewGroup, final t paramt1, t paramt2)
  {
    if ((paramt1 != null) && (paramt2 != null))
    {
      Object localObject2 = paramt1.a;
      Object localObject1 = paramt2.a;
      localObject2 = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
      Object localObject3 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
      if ((localObject2 != null) && (localObject3 != null))
      {
        localObject1 = paramt2.b;
        int k;
        final int m;
        int j;
        int i;
        if (m0((View)localObject2, (View)localObject3))
        {
          paramViewGroup = (Rect)paramt1.a.get("android:changeBounds:bounds");
          localObject2 = (Rect)paramt2.a.get("android:changeBounds:bounds");
          k = paramViewGroup.left;
          m = ((Rect)localObject2).left;
          int n = paramViewGroup.top;
          final int i1 = ((Rect)localObject2).top;
          int i2 = paramViewGroup.right;
          final int i3 = ((Rect)localObject2).right;
          int i4 = paramViewGroup.bottom;
          final int i5 = ((Rect)localObject2).bottom;
          int i6 = i2 - k;
          int i7 = i4 - n;
          int i8 = i3 - m;
          int i9 = i5 - i1;
          paramt1 = (Rect)paramt1.a.get("android:changeBounds:clip");
          localObject2 = (Rect)paramt2.a.get("android:changeBounds:clip");
          if (((i6 != 0) && (i7 != 0)) || ((i8 != 0) && (i9 != 0)))
          {
            if ((k == m) && (n == i1)) {
              j = 0;
            } else {
              j = 1;
            }
            if (i2 == i3)
            {
              i = j;
              if (i4 == i5) {}
            }
            else
            {
              i = j + 1;
            }
          }
          else
          {
            i = 0;
          }
          if ((paramt1 == null) || (paramt1.equals(localObject2)))
          {
            j = i;
            if (paramt1 == null)
            {
              j = i;
              if (localObject2 == null) {}
            }
          }
          else
          {
            j = i + 1;
          }
          if (j > 0)
          {
            if (!this.M)
            {
              paramt2 = (t)localObject1;
              b0.g(paramt2, k, n, i2, i4);
              if (j == 2)
              {
                if ((i6 == i8) && (i7 == i9))
                {
                  paramViewGroup = z().a(k, n, m, i1);
                  paramt1 = U;
                }
                else
                {
                  paramt1 = new k(paramt2);
                  paramViewGroup = z().a(k, n, m, i1);
                  paramt2 = l.a(paramt1, Q, paramViewGroup);
                  paramViewGroup = z().a(i2, i4, i3, i5);
                  localObject2 = l.a(paramt1, R, paramViewGroup);
                  paramViewGroup = new AnimatorSet();
                  paramViewGroup.playTogether(new Animator[] { paramt2, localObject2 });
                  paramViewGroup.addListener(new h(paramt1));
                  break label800;
                }
              }
              else if ((k == m) && (n == i1))
              {
                paramViewGroup = z().a(i2, i4, i3, i5);
                paramt1 = S;
              }
              else
              {
                paramViewGroup = z().a(k, n, m, i1);
                paramt1 = T;
              }
              paramViewGroup = l.a(paramt2, paramt1, paramViewGroup);
            }
            else
            {
              localObject3 = localObject1;
              b0.g((View)localObject3, k, n, Math.max(i6, i8) + k, Math.max(i7, i9) + n);
              if ((k == m) && (n == i1))
              {
                paramViewGroup = null;
              }
              else
              {
                paramViewGroup = z().a(k, n, m, i1);
                paramViewGroup = l.a(localObject3, U, paramViewGroup);
              }
              if (paramt1 == null) {
                paramt1 = new Rect(0, 0, i6, i7);
              }
              if (localObject2 == null) {
                paramt2 = new Rect(0, 0, i8, i9);
              } else {
                paramt2 = (t)localObject2;
              }
              if (!paramt1.equals(paramt2))
              {
                x.x0((View)localObject3, paramt1);
                paramt1 = ObjectAnimator.ofObject(localObject3, "clipBounds", V, new Object[] { paramt1, paramt2 });
                paramt1.addListener(new i((View)localObject3, (Rect)localObject2, m, i1, i3, i5));
              }
              else
              {
                paramt1 = null;
              }
              paramViewGroup = s.c(paramViewGroup, paramt1);
            }
            label800:
            if ((((View)localObject1).getParent() instanceof ViewGroup))
            {
              paramt1 = (ViewGroup)((View)localObject1).getParent();
              y.d(paramt1, true);
              a(new j(paramt1));
            }
            return paramViewGroup;
          }
        }
        else
        {
          i = ((Integer)paramt1.a.get("android:changeBounds:windowX")).intValue();
          j = ((Integer)paramt1.a.get("android:changeBounds:windowY")).intValue();
          k = ((Integer)paramt2.a.get("android:changeBounds:windowX")).intValue();
          m = ((Integer)paramt2.a.get("android:changeBounds:windowY")).intValue();
          if ((i != k) || (j != m)) {
            break label936;
          }
        }
        return null;
        label936:
        paramViewGroup.getLocationInWindow(this.L);
        paramt1 = Bitmap.createBitmap(((View)localObject1).getWidth(), ((View)localObject1).getHeight(), Bitmap.Config.ARGB_8888);
        ((View)localObject1).draw(new Canvas(paramt1));
        paramt1 = new BitmapDrawable(paramt1);
        final float f = b0.c((View)localObject1);
        b0.h((View)localObject1, 0.0F);
        b0.b(paramViewGroup).a(paramt1);
        paramt2 = z();
        localObject2 = this.L;
        paramt2 = paramt2.a(i - localObject2[0], j - localObject2[1], k - localObject2[0], m - localObject2[1]);
        paramt2 = ObjectAnimator.ofPropertyValuesHolder(paramt1, new PropertyValuesHolder[] { m.a(P, paramt2) });
        paramt2.addListener(new a(paramViewGroup, paramt1, (View)localObject1, f));
        return paramt2;
      }
      return null;
    }
    return null;
  }
  
  class a
    extends AnimatorListenerAdapter
  {
    a(ViewGroup paramViewGroup, BitmapDrawable paramBitmapDrawable, View paramView, float paramFloat) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      b0.b(paramViewGroup).b(paramt1);
      b0.h(this.c, f);
    }
  }
  
  static final class b
    extends Property<Drawable, PointF>
  {
    private Rect a = new Rect();
    
    b(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public PointF a(Drawable paramDrawable)
    {
      paramDrawable.copyBounds(this.a);
      paramDrawable = this.a;
      return new PointF(paramDrawable.left, paramDrawable.top);
    }
    
    public void b(Drawable paramDrawable, PointF paramPointF)
    {
      paramDrawable.copyBounds(this.a);
      this.a.offsetTo(Math.round(paramPointF.x), Math.round(paramPointF.y));
      paramDrawable.setBounds(this.a);
    }
  }
  
  static final class c
    extends Property<ChangeBounds.k, PointF>
  {
    c(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public PointF a(ChangeBounds.k paramk)
    {
      return null;
    }
    
    public void b(ChangeBounds.k paramk, PointF paramPointF)
    {
      paramk.c(paramPointF);
    }
  }
  
  static final class d
    extends Property<ChangeBounds.k, PointF>
  {
    d(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public PointF a(ChangeBounds.k paramk)
    {
      return null;
    }
    
    public void b(ChangeBounds.k paramk, PointF paramPointF)
    {
      paramk.a(paramPointF);
    }
  }
  
  static final class e
    extends Property<View, PointF>
  {
    e(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public PointF a(View paramView)
    {
      return null;
    }
    
    public void b(View paramView, PointF paramPointF)
    {
      b0.g(paramView, paramView.getLeft(), paramView.getTop(), Math.round(paramPointF.x), Math.round(paramPointF.y));
    }
  }
  
  static final class f
    extends Property<View, PointF>
  {
    f(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public PointF a(View paramView)
    {
      return null;
    }
    
    public void b(View paramView, PointF paramPointF)
    {
      b0.g(paramView, Math.round(paramPointF.x), Math.round(paramPointF.y), paramView.getRight(), paramView.getBottom());
    }
  }
  
  static final class g
    extends Property<View, PointF>
  {
    g(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public PointF a(View paramView)
    {
      return null;
    }
    
    public void b(View paramView, PointF paramPointF)
    {
      int i = Math.round(paramPointF.x);
      int j = Math.round(paramPointF.y);
      b0.g(paramView, i, j, paramView.getWidth() + i, paramView.getHeight() + j);
    }
  }
  
  class h
    extends AnimatorListenerAdapter
  {
    private ChangeBounds.k mViewBounds;
    
    h(ChangeBounds.k paramk)
    {
      this.mViewBounds = paramk;
    }
  }
  
  class i
    extends AnimatorListenerAdapter
  {
    private boolean a;
    
    i(View paramView, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      this.a = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.a)
      {
        x.x0(this.b, this.c);
        b0.g(this.b, m, i1, i3, i5);
      }
    }
  }
  
  class j
    extends q
  {
    boolean a = false;
    
    j(ViewGroup paramViewGroup) {}
    
    public void b(Transition paramTransition)
    {
      y.d(paramt1, false);
      this.a = true;
    }
    
    public void c(Transition paramTransition)
    {
      y.d(paramt1, false);
    }
    
    public void d(Transition paramTransition)
    {
      y.d(paramt1, true);
    }
    
    public void e(Transition paramTransition)
    {
      if (!this.a) {
        y.d(paramt1, false);
      }
      paramTransition.W(this);
    }
  }
  
  private static class k
  {
    private int a;
    private int b;
    private int c;
    private int d;
    private View e;
    private int f;
    private int g;
    
    k(View paramView)
    {
      this.e = paramView;
    }
    
    private void b()
    {
      b0.g(this.e, this.a, this.b, this.c, this.d);
      this.f = 0;
      this.g = 0;
    }
    
    void a(PointF paramPointF)
    {
      this.c = Math.round(paramPointF.x);
      this.d = Math.round(paramPointF.y);
      int i = this.g + 1;
      this.g = i;
      if (this.f == i) {
        b();
      }
    }
    
    void c(PointF paramPointF)
    {
      this.a = Math.round(paramPointF.x);
      this.b = Math.round(paramPointF.y);
      int i = this.f + 1;
      this.f = i;
      if (i == this.g) {
        b();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.ChangeBounds
 * JD-Core Version:    0.7.0.1
 */