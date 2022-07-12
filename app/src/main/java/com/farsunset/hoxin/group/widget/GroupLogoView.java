package com.farsunset.hoxin.group.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.farsunset.hoxin.common.widget.BadgeLogoView;
import com.farsunset.hoxin.common.widget.WebImageView;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import s3.c;
import u3.l;

public class GroupLogoView
  extends BadgeLogoView
  implements c
{
  private List<String> b;
  private long c;
  private final AtomicInteger d = new AtomicInteger();
  
  public GroupLogoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void c()
  {
    if (this.d.get() != getChildCount()) {
      return;
    }
    buildDrawingCache();
    Bitmap localBitmap = getDrawingCache();
    l.x0(this.c, localBitmap);
  }
  
  private void d()
  {
    removeAllViews();
    if (this.b.isEmpty()) {
      return;
    }
    if (this.b.size() == 1)
    {
      j((String)this.b.get(0));
      return;
    }
    if (this.b.size() == 2)
    {
      n(this.b);
      return;
    }
    if (this.b.size() == 3)
    {
      m(this.b);
      return;
    }
    if ((this.b.size() != 4) && (this.b.size() != 5))
    {
      if (this.b.size() == 6)
      {
        l(this.b);
        return;
      }
      if (this.b.size() == 7)
      {
        k(this.b);
        return;
      }
      if (this.b.size() == 8)
      {
        f(this.b);
        return;
      }
      i(this.b);
      return;
    }
    h(this.b);
  }
  
  private void f(List<String> paramList)
  {
    k(paramList);
    addView(o((String)paramList.get(7)), s());
  }
  
  private void g(List<String> paramList)
  {
    setColumnCount(3);
    addView(o((String)paramList.get(0)), getCellWidth(), getCellWidth());
    addView(o((String)paramList.get(1)), q());
    addView(o((String)paramList.get(2)), q());
    addView(o((String)paramList.get(3)), r());
    addView(o((String)paramList.get(4)), s());
  }
  
  private int getCellWidth()
  {
    return (getMeasuredWidth() - getPadding() * (getColumnCount() + 1)) / getColumnCount();
  }
  
  private int getPadding()
  {
    return getPaddingStart();
  }
  
  private void h(List<String> paramList)
  {
    m(paramList);
    addView(o((String)paramList.get(3)), s());
  }
  
  private void i(List<String> paramList)
  {
    f(paramList);
    addView(o((String)paramList.get(8)), s());
  }
  
  private void j(String paramString)
  {
    addView(o(paramString), -1, -1);
  }
  
  private void k(List<String> paramList)
  {
    l(paramList);
    addView(o((String)paramList.get(6)), r());
  }
  
  private void l(List<String> paramList)
  {
    g(paramList);
    addView(o((String)paramList.get(5)), s());
  }
  
  private void m(List<String> paramList)
  {
    setColumnCount(2);
    addView(o((String)paramList.get(0)), getCellWidth(), getCellWidth());
    addView(o((String)paramList.get(1)), q());
    addView(o((String)paramList.get(2)), r());
  }
  
  private void n(List<String> paramList)
  {
    setColumnCount(2);
    addView(o((String)paramList.get(0)), getCellWidth(), -1);
    GridLayout.LayoutParams localLayoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(getCellWidth(), -1));
    localLayoutParams.leftMargin = getPadding();
    addView(o((String)paramList.get(1)), localLayoutParams);
  }
  
  private WebImageView o(String paramString)
  {
    WebImageView localWebImageView = new WebImageView(getContext());
    localWebImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localWebImageView.r(paramString, this);
    return localWebImageView;
  }
  
  private GridLayout.LayoutParams q()
  {
    GridLayout.LayoutParams localLayoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(getCellWidth(), getCellWidth()));
    localLayoutParams.leftMargin = getPadding();
    return localLayoutParams;
  }
  
  private GridLayout.LayoutParams r()
  {
    GridLayout.LayoutParams localLayoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(getCellWidth(), getCellWidth()));
    localLayoutParams.topMargin = getPadding();
    return localLayoutParams;
  }
  
  private GridLayout.LayoutParams s()
  {
    GridLayout.LayoutParams localLayoutParams = new GridLayout.LayoutParams(new ViewGroup.LayoutParams(getCellWidth(), getCellWidth()));
    localLayoutParams.leftMargin = getPadding();
    localLayoutParams.topMargin = getPadding();
    return localLayoutParams;
  }
  
  public void b(o3.b paramb, long paramLong)
  {
    e(paramLong, p4.b.n(paramLong, 9));
  }
  
  public void e(long paramLong, List<String> paramList)
  {
    this.c = paramLong;
    this.b = paramList;
    if ((getMeasuredWidth() > 0) && (getMeasuredHeight() > 0)) {
      d();
    }
  }
  
  public void l0(Object paramObject, ImageView paramImageView)
  {
    this.d.incrementAndGet();
    c();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getMeasuredWidth() > 0) && (getMeasuredHeight() > 0) && (getChildCount() == 0)) {
      d();
    }
  }
  
  public void p(Object paramObject, ImageView paramImageView, BitmapDrawable paramBitmapDrawable)
  {
    this.d.incrementAndGet();
    paramImageView.setImageDrawable(paramBitmapDrawable);
    c();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.group.widget.GroupLogoView
 * JD-Core Version:    0.7.0.1
 */