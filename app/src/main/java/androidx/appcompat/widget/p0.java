package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.style;

class p0
{
  private final Context a;
  private final View b;
  private final TextView c;
  private final WindowManager.LayoutParams d;
  private final Rect e;
  private final int[] f;
  private final int[] g;
  
  p0(Context paramContext)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    this.d = localLayoutParams;
    this.e = new Rect();
    this.f = new int[2];
    this.g = new int[2];
    this.a = paramContext;
    View localView = LayoutInflater.from(paramContext).inflate(R.layout.abc_tooltip, null);
    this.b = localView;
    this.c = ((TextView)localView.findViewById(R.id.message));
    localLayoutParams.setTitle(getClass().getSimpleName());
    localLayoutParams.packageName = paramContext.getPackageName();
    localLayoutParams.type = 1002;
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.format = -3;
    localLayoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
    localLayoutParams.flags = 24;
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.token = paramView.getApplicationWindowToken();
    int i = this.a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
    if (paramView.getWidth() < i) {
      paramInt1 = paramView.getWidth() / 2;
    }
    if (paramView.getHeight() >= i)
    {
      j = this.a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
      i = paramInt2 + j;
      j = paramInt2 - j;
      paramInt2 = i;
      i = j;
    }
    else
    {
      paramInt2 = paramView.getHeight();
      i = 0;
    }
    paramLayoutParams.gravity = 49;
    Object localObject1 = this.a.getResources();
    if (paramBoolean) {
      j = R.dimen.tooltip_y_offset_touch;
    } else {
      j = R.dimen.tooltip_y_offset_non_touch;
    }
    int k = ((Resources)localObject1).getDimensionPixelOffset(j);
    localObject1 = b(paramView);
    if (localObject1 == null)
    {
      Log.e("TooltipPopup", "Cannot find app view");
      return;
    }
    ((View)localObject1).getWindowVisibleDisplayFrame(this.e);
    Object localObject2 = this.e;
    if ((((Rect)localObject2).left < 0) && (((Rect)localObject2).top < 0))
    {
      localObject2 = this.a.getResources();
      j = ((Resources)localObject2).getIdentifier("status_bar_height", "dimen", "android");
      if (j != 0) {
        j = ((Resources)localObject2).getDimensionPixelSize(j);
      } else {
        j = 0;
      }
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      this.e.set(0, j, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
    }
    ((View)localObject1).getLocationOnScreen(this.g);
    paramView.getLocationOnScreen(this.f);
    paramView = this.f;
    int j = paramView[0];
    localObject2 = this.g;
    paramView[0] = (j - localObject2[0]);
    paramView[1] -= localObject2[1];
    paramLayoutParams.x = (paramView[0] + paramInt1 - ((View)localObject1).getWidth() / 2);
    paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.b.measure(paramInt1, paramInt1);
    paramInt1 = this.b.getMeasuredHeight();
    paramView = this.f;
    i = paramView[1] + i - k - paramInt1;
    paramInt2 = paramView[1] + paramInt2 + k;
    if (paramBoolean ? i < 0 : paramInt1 + paramInt2 <= this.e.height())
    {
      paramLayoutParams.y = paramInt2;
      return;
    }
    paramLayoutParams.y = i;
  }
  
  private static View b(View paramView)
  {
    View localView = paramView.getRootView();
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (((localLayoutParams instanceof WindowManager.LayoutParams)) && (((WindowManager.LayoutParams)localLayoutParams).type == 2)) {
      return localView;
    }
    for (paramView = paramView.getContext(); (paramView instanceof ContextWrapper); paramView = ((ContextWrapper)paramView).getBaseContext()) {
      if ((paramView instanceof Activity)) {
        return ((Activity)paramView).getWindow().getDecorView();
      }
    }
    return localView;
  }
  
  void c()
  {
    if (!d()) {
      return;
    }
    ((WindowManager)this.a.getSystemService("window")).removeView(this.b);
  }
  
  boolean d()
  {
    return this.b.getParent() != null;
  }
  
  void e(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    if (d()) {
      c();
    }
    this.c.setText(paramCharSequence);
    a(paramView, paramInt1, paramInt2, paramBoolean, this.d);
    ((WindowManager)this.a.getSystemService("window")).addView(this.b, this.d);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.p0
 * JD-Core Version:    0.7.0.1
 */