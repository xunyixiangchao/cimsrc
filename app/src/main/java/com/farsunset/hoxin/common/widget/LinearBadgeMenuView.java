package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import s3.p;
import u3.l;

public class LinearBadgeMenuView
  extends LinearLayout
  implements View.OnClickListener
{
  private final List<ViewGroup> a = new LinkedList();
  private p<Object> b;
  private final LinearLayout.LayoutParams c = new LinearLayout.LayoutParams(0, -2, 1.0F);
  
  public LinearBadgeMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    setOrientation(0);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    b(paramObject, paramInt, null);
  }
  
  public void b(Object paramObject, int paramInt, Integer paramInteger)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    localFrameLayout.setForegroundGravity(17);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.setGravity(16);
    localLinearLayout.setBackgroundResource(2131165285);
    localLinearLayout.setPadding(l.p(8.0F), l.p(3.0F), l.p(8.0F), l.p(3.0F));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setHorizontalGravity(17);
    if (paramInteger != null)
    {
      ImageView localImageView = new ImageView(getContext());
      localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      localImageView.setImageResource(paramInteger.intValue());
      localImageView.setId(2131231053);
      localLinearLayout.addView(localImageView);
    }
    paramInteger = new TextView(getContext());
    paramInteger.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    paramInteger.setText(paramInt);
    paramInteger.setGravity(17);
    paramInteger.setTextSize(2, 14.0F);
    paramInteger.setTextColor(b.c(getContext(), 2131034147));
    localLinearLayout.addView(paramInteger);
    localFrameLayout.addView(localLinearLayout, localLayoutParams);
    localLinearLayout.setOnClickListener(this);
    localLinearLayout.setTag(paramObject);
    this.a.add(localLinearLayout);
    addView(localFrameLayout, this.c);
  }
  
  public boolean c(Object paramObject)
  {
    paramObject = findViewWithTag(paramObject);
    return (paramObject != null) && (paramObject.isSelected());
  }
  
  public void d(Object paramObject, float paramFloat)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView.getTag() == paramObject) {
        ((LinearLayout.LayoutParams)localView.findViewById(2131231053).getLayoutParams()).topMargin = l.p(paramFloat);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.isSelected()) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((View)localIterator.next()).setSelected(false);
    }
    paramView.setSelected(true);
    this.b.C0(paramView.getTag(), paramView);
  }
  
  public void setOnItemClickedListener(p<Object> paramp)
  {
    this.b = paramp;
  }
  
  public void setSelected(Object paramObject)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView.getTag() == paramObject) {
        localView.setSelected(true);
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.LinearBadgeMenuView
 * JD-Core Version:    0.7.0.1
 */