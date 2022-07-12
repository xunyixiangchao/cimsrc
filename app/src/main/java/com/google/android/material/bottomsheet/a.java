package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.e;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.h0;
import androidx.core.view.r;
import androidx.core.view.x;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.style;
import r7.h;
import y0.d;

public class a
  extends e
{
  private BottomSheetBehavior<FrameLayout> c;
  private FrameLayout d;
  private CoordinatorLayout e;
  private FrameLayout f;
  boolean g;
  boolean h = true;
  private boolean i = true;
  private boolean j;
  private BottomSheetBehavior.f k;
  private boolean l;
  private BottomSheetBehavior.f m = new e();
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
    this.l = getContext().getTheme().obtainStyledAttributes(new int[] { R.attr.enableEdgeToEdge }).getBoolean(0, false);
  }
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext, b(paramContext, paramInt));
    d(1);
    this.l = getContext().getTheme().obtainStyledAttributes(new int[] { R.attr.enableEdgeToEdge }).getBoolean(0, false);
  }
  
  private static int b(Context paramContext, int paramInt)
  {
    int n = paramInt;
    if (paramInt == 0)
    {
      TypedValue localTypedValue = new TypedValue();
      if (paramContext.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, localTypedValue, true)) {
        return localTypedValue.resourceId;
      }
      n = R.style.Theme_Design_Light_BottomSheetDialog;
    }
    return n;
  }
  
  private FrameLayout i()
  {
    if (this.d == null)
    {
      Object localObject = (FrameLayout)View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
      this.d = ((FrameLayout)localObject);
      this.e = ((CoordinatorLayout)((FrameLayout)localObject).findViewById(R.id.coordinator));
      localObject = (FrameLayout)this.d.findViewById(R.id.design_bottom_sheet);
      this.f = ((FrameLayout)localObject);
      localObject = BottomSheetBehavior.f0((View)localObject);
      this.c = ((BottomSheetBehavior)localObject);
      ((BottomSheetBehavior)localObject).W(this.m);
      this.c.z0(this.h);
    }
    return this.d;
  }
  
  public static void k(View paramView, boolean paramBoolean)
  {
    int n = paramView.getSystemUiVisibility();
    if (paramBoolean) {
      n |= 0x2000;
    } else {
      n &= 0xFFFFDFFF;
    }
    paramView.setSystemUiVisibility(n);
  }
  
  private View n(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    i();
    CoordinatorLayout localCoordinatorLayout = (CoordinatorLayout)this.d.findViewById(R.id.coordinator);
    View localView = paramView;
    if (paramInt != 0)
    {
      localView = paramView;
      if (paramView == null) {
        localView = getLayoutInflater().inflate(paramInt, localCoordinatorLayout, false);
      }
    }
    if (this.l) {
      x.E0(this.f, new a());
    }
    this.f.removeAllViews();
    paramView = this.f;
    if (paramLayoutParams == null) {
      paramView.addView(localView);
    } else {
      paramView.addView(localView, paramLayoutParams);
    }
    localCoordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new b());
    x.q0(this.f, new c());
    this.f.setOnTouchListener(new d());
    return this.d;
  }
  
  public void cancel()
  {
    BottomSheetBehavior localBottomSheetBehavior = j();
    if ((this.g) && (localBottomSheetBehavior.j0() != 5))
    {
      localBottomSheetBehavior.G0(5);
      return;
    }
    super.cancel();
  }
  
  public BottomSheetBehavior<FrameLayout> j()
  {
    if (this.c == null) {
      i();
    }
    return this.c;
  }
  
  boolean l()
  {
    if (!this.j)
    {
      TypedArray localTypedArray = getContext().obtainStyledAttributes(new int[] { 16843611 });
      this.i = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
      this.j = true;
    }
    return this.i;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      int n;
      if ((this.l) && (Color.alpha(localWindow.getNavigationBarColor()) < 255)) {
        n = 1;
      } else {
        n = 0;
      }
      Object localObject = this.d;
      if (localObject != null) {
        ((FrameLayout)localObject).setFitsSystemWindows(n ^ 0x1);
      }
      localObject = this.e;
      if (localObject != null) {
        ((CoordinatorLayout)localObject).setFitsSystemWindows(n ^ 0x1);
      }
      if (n != 0) {
        localWindow.getDecorView().setSystemUiVisibility(768);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.setStatusBarColor(0);
      paramBundle.addFlags(-2147483648);
      paramBundle.setLayout(-1, -1);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    BottomSheetBehavior localBottomSheetBehavior = this.c;
    if ((localBottomSheetBehavior != null) && (localBottomSheetBehavior.j0() == 5)) {
      this.c.G0(4);
    }
  }
  
  public void setCancelable(boolean paramBoolean)
  {
    super.setCancelable(paramBoolean);
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      BottomSheetBehavior localBottomSheetBehavior = this.c;
      if (localBottomSheetBehavior != null) {
        localBottomSheetBehavior.z0(paramBoolean);
      }
    }
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean)
  {
    super.setCanceledOnTouchOutside(paramBoolean);
    if ((paramBoolean) && (!this.h)) {
      this.h = true;
    }
    this.i = paramBoolean;
    this.j = true;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(n(paramInt, null, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(n(0, paramView, null));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(n(0, paramView, paramLayoutParams));
  }
  
  class a
    implements r
  {
    a() {}
    
    public h0 a(View paramView, h0 paramh0)
    {
      if (a.e(a.this) != null) {
        a.g(a.this).p0(a.e(a.this));
      }
      if (paramh0 != null)
      {
        paramView = a.this;
        a.f(paramView, new a.f(a.h(paramView), paramh0, null));
        a.g(a.this).W(a.e(a.this));
      }
      return paramh0;
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      paramView = a.this;
      if ((paramView.h) && (paramView.isShowing()) && (a.this.l())) {
        a.this.cancel();
      }
    }
  }
  
  class c
    extends androidx.core.view.a
  {
    c() {}
    
    public void g(View paramView, d paramd)
    {
      super.g(paramView, paramd);
      boolean bool;
      if (a.this.h)
      {
        paramd.a(1048576);
        bool = true;
      }
      else
      {
        bool = false;
      }
      paramd.h0(bool);
    }
    
    public boolean j(View paramView, int paramInt, Bundle paramBundle)
    {
      if (paramInt == 1048576)
      {
        a locala = a.this;
        if (locala.h)
        {
          locala.cancel();
          return true;
        }
      }
      return super.j(paramView, paramInt, paramBundle);
    }
  }
  
  class d
    implements View.OnTouchListener
  {
    d() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  class e
    extends BottomSheetBehavior.f
  {
    e() {}
    
    public void b(View paramView, float paramFloat) {}
    
    public void c(View paramView, int paramInt)
    {
      if (paramInt == 5) {
        a.this.cancel();
      }
    }
  }
  
  private static class f
    extends BottomSheetBehavior.f
  {
    private final boolean a;
    private final boolean b;
    private final h0 c;
    
    private f(View paramView, h0 paramh0)
    {
      this.c = paramh0;
      boolean bool;
      if ((paramView.getSystemUiVisibility() & 0x2000) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.b = bool;
      paramh0 = BottomSheetBehavior.f0(paramView).i0();
      if (paramh0 != null) {
        paramh0 = paramh0.x();
      } else {
        paramh0 = x.s(paramView);
      }
      if (paramh0 != null) {}
      for (int i = paramh0.getDefaultColor();; i = ((ColorDrawable)paramView.getBackground()).getColor())
      {
        this.a = g7.a.f(i);
        return;
        if (!(paramView.getBackground() instanceof ColorDrawable)) {
          break;
        }
      }
      this.a = bool;
    }
    
    private void d(View paramView)
    {
      int i;
      if (paramView.getTop() < this.c.l())
      {
        a.k(paramView, this.a);
        i = paramView.getPaddingLeft();
      }
      for (int j = this.c.l() - paramView.getTop();; j = 0)
      {
        paramView.setPadding(i, j, paramView.getPaddingRight(), paramView.getPaddingBottom());
        return;
        if (paramView.getTop() == 0) {
          break;
        }
        a.k(paramView, this.b);
        i = paramView.getPaddingLeft();
      }
    }
    
    void a(View paramView)
    {
      d(paramView);
    }
    
    public void b(View paramView, float paramFloat)
    {
      d(paramView);
    }
    
    public void c(View paramView, int paramInt)
    {
      d(paramView);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.bottomsheet.a
 * JD-Core Version:    0.7.0.1
 */