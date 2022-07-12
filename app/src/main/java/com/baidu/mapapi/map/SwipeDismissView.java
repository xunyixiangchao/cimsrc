package com.baidu.mapapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class SwipeDismissView
  extends RelativeLayout
{
  WearMapView.OnDismissCallback a = null;
  
  public SwipeDismissView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, View paramView)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramView);
  }
  
  public SwipeDismissView(Context paramContext, AttributeSet paramAttributeSet, View paramView)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramView);
  }
  
  public SwipeDismissView(Context paramContext, View paramView)
  {
    super(paramContext);
    a(paramContext, paramView);
  }
  
  void a(Context paramContext, View paramView)
  {
    setOnTouchListener(new SwipeDismissTouchListener(paramView, new Object(), new a()));
  }
  
  public void setCallback(WearMapView.OnDismissCallback paramOnDismissCallback)
  {
    this.a = paramOnDismissCallback;
  }
  
  class a
    implements SwipeDismissTouchListener.DismissCallbacks
  {
    a() {}
    
    public boolean canDismiss(Object paramObject)
    {
      return true;
    }
    
    public void onDismiss(View paramView, Object paramObject)
    {
      paramView = SwipeDismissView.this.a;
      if (paramView == null) {
        return;
      }
      paramView.onDismiss();
    }
    
    public void onNotify()
    {
      WearMapView.OnDismissCallback localOnDismissCallback = SwipeDismissView.this.a;
      if (localOnDismissCallback == null) {
        return;
      }
      localOnDismissCallback.onNotify();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.SwipeDismissView
 * JD-Core Version:    0.7.0.1
 */