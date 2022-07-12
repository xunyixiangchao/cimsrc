package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class GalleryViewPager
  extends ViewPager
{
  public GalleryViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      label8:
      break label8;
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.GalleryViewPager
 * JD-Core Version:    0.7.0.1
 */