package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R.styleable;
import androidx.core.widget.k;

class AppCompatPopupWindow
  extends PopupWindow
{
  private static final boolean b = false;
  private boolean a;
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public AppCompatPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = k0.v(paramContext, paramAttributeSet, R.styleable.PopupWindow, paramInt1, paramInt2);
    paramInt1 = R.styleable.PopupWindow_overlapAnchor;
    if (paramContext.s(paramInt1)) {
      b(paramContext.a(paramInt1, false));
    }
    setBackgroundDrawable(paramContext.g(R.styleable.PopupWindow_android_popupBackground));
    paramContext.w();
  }
  
  private void b(boolean paramBoolean)
  {
    if (b)
    {
      this.a = paramBoolean;
      return;
    }
    k.a(this, paramBoolean);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (b)
    {
      i = paramInt2;
      if (this.a) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    if (b)
    {
      i = paramInt2;
      if (this.a) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.showAsDropDown(paramView, paramInt1, i, paramInt3);
  }
  
  public void update(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2;
    if (b)
    {
      i = paramInt2;
      if (this.a) {
        i = paramInt2 - paramView.getHeight();
      }
    }
    super.update(paramView, paramInt1, i, paramInt3, paramInt4);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.AppCompatPopupWindow
 * JD-Core Version:    0.7.0.1
 */