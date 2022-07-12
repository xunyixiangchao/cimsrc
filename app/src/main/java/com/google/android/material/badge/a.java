package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.internal.m;
import com.google.android.material.internal.m.b;
import com.google.android.material.internal.p;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import o7.d;
import r7.h;

public class a
  extends Drawable
  implements m.b
{
  private static final int n = R.style.Widget_MaterialComponents_Badge;
  private static final int o = R.attr.badgeStyle;
  private final WeakReference<Context> a;
  private final h b;
  private final m c;
  private final Rect d;
  private final BadgeState e;
  private float f;
  private float g;
  private int h;
  private float i;
  private float j;
  private float k;
  private WeakReference<View> l;
  private WeakReference<FrameLayout> m;
  
  private a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, BadgeState.State paramState)
  {
    this.a = new WeakReference(paramContext);
    p.c(paramContext);
    this.d = new Rect();
    this.b = new h();
    m localm = new m(this);
    this.c = localm;
    localm.e().setTextAlign(Paint.Align.CENTER);
    C(R.style.TextAppearance_MaterialComponents_Badge);
    this.e = new BadgeState(paramContext, paramInt1, paramInt2, paramInt3, paramState);
    w();
  }
  
  private void B(d paramd)
  {
    if (this.c.d() == paramd) {
      return;
    }
    Context localContext = (Context)this.a.get();
    if (localContext == null) {
      return;
    }
    this.c.h(paramd, localContext);
    H();
  }
  
  private void C(int paramInt)
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null) {
      return;
    }
    B(new d(localContext, paramInt));
  }
  
  private void E(final View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    if ((localViewGroup == null) || (localViewGroup.getId() != R.id.mtrl_anchor_parent))
    {
      localObject = this.m;
      if ((localObject == null) || (((WeakReference)localObject).get() != localViewGroup)) {}
    }
    else
    {
      return;
    }
    F(paramView);
    Object localObject = new FrameLayout(paramView.getContext());
    ((FrameLayout)localObject).setId(R.id.mtrl_anchor_parent);
    ((FrameLayout)localObject).setClipChildren(false);
    ((FrameLayout)localObject).setClipToPadding(false);
    ((FrameLayout)localObject).setLayoutParams(paramView.getLayoutParams());
    ((FrameLayout)localObject).setMinimumWidth(paramView.getWidth());
    ((FrameLayout)localObject).setMinimumHeight(paramView.getHeight());
    int i1 = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeViewAt(i1);
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    ((FrameLayout)localObject).addView(paramView);
    localViewGroup.addView((View)localObject, i1);
    this.m = new WeakReference(localObject);
    ((FrameLayout)localObject).post(new a(paramView, (FrameLayout)localObject));
  }
  
  private static void F(View paramView)
  {
    paramView = (ViewGroup)paramView.getParent();
    paramView.setClipChildren(false);
    paramView.setClipToPadding(false);
  }
  
  private void H()
  {
    Context localContext = (Context)this.a.get();
    Object localObject1 = this.l;
    FrameLayout localFrameLayout = null;
    if (localObject1 != null) {
      localObject1 = (View)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if (localContext != null)
    {
      if (localObject1 == null) {
        return;
      }
      Rect localRect1 = new Rect();
      localRect1.set(this.d);
      Rect localRect2 = new Rect();
      ((View)localObject1).getDrawingRect(localRect2);
      Object localObject2 = this.m;
      if (localObject2 != null) {
        localFrameLayout = (FrameLayout)((WeakReference)localObject2).get();
      }
      if ((localFrameLayout != null) || (b.a))
      {
        localObject2 = localFrameLayout;
        if (localFrameLayout == null) {
          localObject2 = (ViewGroup)((View)localObject1).getParent();
        }
        ((ViewGroup)localObject2).offsetDescendantRectToMyCoords((View)localObject1, localRect2);
      }
      b(localContext, localRect2, (View)localObject1);
      b.f(this.d, this.f, this.g, this.j, this.k);
      this.b.Y(this.i);
      if (!localRect1.equals(this.d)) {
        this.b.setBounds(this.d);
      }
    }
  }
  
  private void I()
  {
    this.h = ((int)Math.pow(10.0D, j() - 1.0D) - 1);
  }
  
  private void b(Context paramContext, Rect paramRect, View paramView)
  {
    int i1 = n();
    int i2 = this.e.f();
    if ((i2 != 8388691) && (i2 != 8388693)) {}
    for (i1 = paramRect.top + i1;; i1 = paramRect.bottom - i1)
    {
      this.g = i1;
      break;
    }
    float f1;
    if (k() <= 9)
    {
      if (!o()) {
        f1 = this.e.c;
      } else {
        f1 = this.e.d;
      }
      this.i = f1;
      this.k = f1;
    }
    else
    {
      f1 = this.e.d;
      this.i = f1;
      this.k = f1;
      String str = f();
      f1 = this.c.f(str) / 2.0F + this.e.e;
    }
    this.j = f1;
    paramContext = paramContext.getResources();
    if (o()) {
      i1 = R.dimen.mtrl_badge_text_horizontal_edge_offset;
    } else {
      i1 = R.dimen.mtrl_badge_horizontal_edge_offset;
    }
    i1 = paramContext.getDimensionPixelSize(i1);
    i2 = m();
    int i3 = this.e.f();
    if ((i3 != 8388659) && (i3 != 8388691) ? x.B(paramView) != 0 : x.B(paramView) == 0) {
      f1 = paramRect.left - this.j + i1 + i2;
    } else {
      f1 = paramRect.right + this.j - i1 - i2;
    }
    this.f = f1;
  }
  
  public static a c(Context paramContext)
  {
    return new a(paramContext, 0, o, n, null);
  }
  
  static a d(Context paramContext, BadgeState.State paramState)
  {
    return new a(paramContext, 0, o, n, paramState);
  }
  
  private void e(Canvas paramCanvas)
  {
    Rect localRect = new Rect();
    String str = f();
    this.c.e().getTextBounds(str, 0, str.length(), localRect);
    paramCanvas.drawText(str, this.f, this.g + localRect.height() / 2, this.c.e());
  }
  
  private String f()
  {
    if (k() <= this.h) {
      return NumberFormat.getInstance(this.e.o()).format(k());
    }
    Context localContext = (Context)this.a.get();
    if (localContext == null) {
      return "";
    }
    return String.format(this.e.o(), localContext.getString(R.string.mtrl_exceed_max_badge_number_suffix), new Object[] { Integer.valueOf(this.h), "+" });
  }
  
  private int m()
  {
    int i1;
    if (o()) {
      i1 = this.e.k();
    } else {
      i1 = this.e.l();
    }
    return i1 + this.e.b();
  }
  
  private int n()
  {
    int i1;
    if (o()) {
      i1 = this.e.q();
    } else {
      i1 = this.e.r();
    }
    return i1 + this.e.c();
  }
  
  private void p()
  {
    this.c.e().setAlpha(getAlpha());
    invalidateSelf();
  }
  
  private void q()
  {
    ColorStateList localColorStateList = ColorStateList.valueOf(this.e.e());
    if (this.b.x() != localColorStateList)
    {
      this.b.b0(localColorStateList);
      invalidateSelf();
    }
  }
  
  private void r()
  {
    Object localObject = this.l;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      View localView = (View)this.l.get();
      localObject = this.m;
      if (localObject != null) {
        localObject = (FrameLayout)((WeakReference)localObject).get();
      } else {
        localObject = null;
      }
      G(localView, (FrameLayout)localObject);
    }
  }
  
  private void s()
  {
    this.c.e().setColor(this.e.g());
    invalidateSelf();
  }
  
  private void t()
  {
    I();
    this.c.i(true);
    H();
    invalidateSelf();
  }
  
  private void u()
  {
    this.c.i(true);
    H();
    invalidateSelf();
  }
  
  private void v()
  {
    boolean bool = this.e.t();
    setVisible(bool, false);
    if ((b.a) && (h() != null) && (!bool)) {
      ((ViewGroup)h().getParent()).invalidate();
    }
  }
  
  private void w()
  {
    t();
    u();
    p();
    q();
    s();
    r();
    H();
    v();
  }
  
  public void A(int paramInt)
  {
    paramInt = Math.max(0, paramInt);
    if (this.e.n() != paramInt)
    {
      this.e.z(paramInt);
      u();
    }
  }
  
  public void D(boolean paramBoolean)
  {
    this.e.A(paramBoolean);
    v();
  }
  
  public void G(View paramView, FrameLayout paramFrameLayout)
  {
    this.l = new WeakReference(paramView);
    boolean bool = b.a;
    if ((bool) && (paramFrameLayout == null)) {
      E(paramView);
    } else {
      this.m = new WeakReference(paramFrameLayout);
    }
    if (!bool) {
      F(paramView);
    }
    H();
    invalidateSelf();
  }
  
  public void a()
  {
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((!getBounds().isEmpty()) && (getAlpha() != 0))
    {
      if (!isVisible()) {
        return;
      }
      this.b.draw(paramCanvas);
      if (o()) {
        e(paramCanvas);
      }
    }
  }
  
  public CharSequence g()
  {
    if (!isVisible()) {
      return null;
    }
    if (o())
    {
      if (this.e.j() != 0)
      {
        Context localContext = (Context)this.a.get();
        if (localContext == null) {
          return null;
        }
        if (k() <= this.h) {
          return localContext.getResources().getQuantityString(this.e.j(), k(), new Object[] { Integer.valueOf(k()) });
        }
        return localContext.getString(this.e.h(), new Object[] { Integer.valueOf(this.h) });
      }
      return null;
    }
    return this.e.i();
  }
  
  public int getAlpha()
  {
    return this.e.d();
  }
  
  public int getIntrinsicHeight()
  {
    return this.d.height();
  }
  
  public int getIntrinsicWidth()
  {
    return this.d.width();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public FrameLayout h()
  {
    WeakReference localWeakReference = this.m;
    if (localWeakReference != null) {
      return (FrameLayout)localWeakReference.get();
    }
    return null;
  }
  
  public int i()
  {
    return this.e.l();
  }
  
  public boolean isStateful()
  {
    return false;
  }
  
  public int j()
  {
    return this.e.m();
  }
  
  public int k()
  {
    if (o()) {
      return this.e.n();
    }
    return 0;
  }
  
  BadgeState.State l()
  {
    return this.e.p();
  }
  
  public boolean o()
  {
    return this.e.s();
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    this.e.v(paramInt);
    p();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void x(int paramInt)
  {
    this.e.w(paramInt);
    q();
  }
  
  public void y(int paramInt)
  {
    if (this.c.e().getColor() != paramInt)
    {
      this.e.x(paramInt);
      s();
    }
  }
  
  public void z(int paramInt)
  {
    if (this.e.m() != paramInt)
    {
      this.e.y(paramInt);
      t();
    }
  }
  
  class a
    implements Runnable
  {
    a(View paramView, FrameLayout paramFrameLayout) {}
    
    public void run()
    {
      a.this.G(paramView, this.b);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.badge.a
 * JD-Core Version:    0.7.0.1
 */