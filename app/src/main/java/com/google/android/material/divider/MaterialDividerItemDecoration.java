package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.x;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.z;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.p;
import o7.c;
import r0.a;

public class MaterialDividerItemDecoration
  extends RecyclerView.o
{
  private static final int i = R.style.Widget_MaterialComponents_MaterialDivider;
  private Drawable a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private final Rect h = new Rect();
  
  public MaterialDividerItemDecoration(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, R.attr.materialDividerStyle, paramInt);
  }
  
  public MaterialDividerItemDecoration(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramAttributeSet = p.h(paramContext, paramAttributeSet, R.styleable.MaterialDivider, paramInt1, i, new int[0]);
    this.c = c.a(paramContext, paramAttributeSet, R.styleable.MaterialDivider_dividerColor).getDefaultColor();
    this.b = paramAttributeSet.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, paramContext.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
    this.e = paramAttributeSet.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
    this.f = paramAttributeSet.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
    this.g = paramAttributeSet.getBoolean(R.styleable.MaterialDivider_lastItemDecorated, true);
    paramAttributeSet.recycle();
    this.a = new ShapeDrawable();
    l(this.c);
    m(paramInt2);
  }
  
  private void j(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    paramCanvas.save();
    boolean bool = paramRecyclerView.getClipToPadding();
    int m = 0;
    int j;
    int k;
    if (bool)
    {
      j = paramRecyclerView.getPaddingTop();
      k = paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom();
      paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), j, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), k);
    }
    else
    {
      k = paramRecyclerView.getHeight();
      j = 0;
    }
    int n = this.e;
    int i1 = this.f;
    int i2 = paramRecyclerView.getChildCount();
    while (m < i2)
    {
      View localView = paramRecyclerView.getChildAt(m);
      paramRecyclerView.getLayoutManager().P(localView, this.h);
      int i3 = this.h.right + Math.round(localView.getTranslationX());
      int i4 = this.a.getIntrinsicWidth();
      int i5 = this.b;
      this.a.setBounds(i3 - i4 - i5, j + n, i3, k - i1);
      this.a.draw(paramCanvas);
      m += 1;
    }
    paramCanvas.restore();
  }
  
  private void k(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    paramCanvas.save();
    boolean bool = paramRecyclerView.getClipToPadding();
    int i2 = 0;
    int j;
    int k;
    if (bool)
    {
      j = paramRecyclerView.getPaddingLeft();
      k = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      paramCanvas.clipRect(j, paramRecyclerView.getPaddingTop(), k, paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
    }
    else
    {
      k = paramRecyclerView.getWidth();
      j = 0;
    }
    int m = x.B(paramRecyclerView);
    int n = 1;
    if (m != 1) {
      n = 0;
    }
    if (n != 0) {
      m = this.f;
    } else {
      m = this.e;
    }
    if (n != 0) {
      n = this.e;
    } else {
      n = this.f;
    }
    int i1 = paramRecyclerView.getChildCount();
    if (!this.g) {
      i1 -= 1;
    }
    while (i2 < i1)
    {
      View localView = paramRecyclerView.getChildAt(i2);
      paramRecyclerView.i0(localView, this.h);
      int i3 = this.h.bottom + Math.round(localView.getTranslationY());
      int i4 = this.a.getIntrinsicHeight();
      int i5 = this.b;
      this.a.setBounds(j + m, i3 - i4 - i5, k - n, i3);
      this.a.draw(paramCanvas);
      i2 += 1;
    }
    paramCanvas.restore();
  }
  
  public void e(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.z paramz)
  {
    paramRect.set(0, 0, 0, 0);
    if (this.d == 1)
    {
      paramRect.bottom = (this.a.getIntrinsicHeight() + this.b);
      return;
    }
    paramRect.right = (this.a.getIntrinsicWidth() + this.b);
  }
  
  public void g(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.z paramz)
  {
    if (paramRecyclerView.getLayoutManager() == null) {
      return;
    }
    if (this.d == 1)
    {
      k(paramCanvas, paramRecyclerView);
      return;
    }
    j(paramCanvas, paramRecyclerView);
  }
  
  public void l(int paramInt)
  {
    this.c = paramInt;
    Drawable localDrawable = a.r(this.a);
    this.a = localDrawable;
    a.n(localDrawable, paramInt);
  }
  
  public void m(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid orientation: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(". It should be either HORIZONTAL or VERTICAL");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.d = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.divider.MaterialDividerItemDecoration
 * JD-Core Version:    0.7.0.1
 */