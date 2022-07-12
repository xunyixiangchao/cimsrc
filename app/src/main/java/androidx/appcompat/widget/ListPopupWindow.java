package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import androidx.core.view.x;
import androidx.core.widget.k;
import h.e;
import java.lang.reflect.Method;

public class ListPopupWindow
  implements e
{
  private static Method H;
  private static Method I;
  private static Method J;
  private Runnable A;
  final Handler B;
  private final Rect C = new Rect();
  private Rect E;
  private boolean F;
  PopupWindow G;
  private Context a;
  private ListAdapter b;
  u c;
  private int d = -2;
  private int e = -2;
  private int f;
  private int g;
  private int h = 1002;
  private boolean i;
  private boolean j;
  private boolean k;
  private int l = 0;
  private boolean m = false;
  private boolean n = false;
  int o = 2147483647;
  private View p;
  private int q = 0;
  private DataSetObserver r;
  private View s;
  private Drawable t;
  private AdapterView.OnItemClickListener u;
  private AdapterView.OnItemSelectedListener v;
  final g w = new g();
  private final f x = new f();
  private final e y = new e();
  private final c z = new c();
  
  static
  {
    if (Build.VERSION.SDK_INT <= 28) {}
    try
    {
      H = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[] { Boolean.TYPE });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      label31:
      label61:
      break label31;
    }
    Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
    try
    {
      J = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[] { Rect.class });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      break label61;
    }
    Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
    if (Build.VERSION.SDK_INT <= 23) {}
    try
    {
      I = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[] { View.class, Integer.TYPE, Boolean.TYPE });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      label109:
      break label109;
    }
    Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
  }
  
  public ListPopupWindow(Context paramContext)
  {
    this(paramContext, null, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listPopupWindowStyle);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public ListPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.B = new Handler(paramContext.getMainLooper());
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ListPopupWindow, paramInt1, paramInt2);
    this.f = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
    int i1 = localTypedArray.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
    this.g = i1;
    if (i1 != 0) {
      this.i = true;
    }
    localTypedArray.recycle();
    paramContext = new AppCompatPopupWindow(paramContext, paramAttributeSet, paramInt1, paramInt2);
    this.G = paramContext;
    paramContext.setInputMethodMode(1);
  }
  
  private void C()
  {
    Object localObject = this.p;
    if (localObject != null)
    {
      localObject = ((View)localObject).getParent();
      if ((localObject instanceof ViewGroup)) {
        ((ViewGroup)localObject).removeView(this.p);
      }
    }
  }
  
  private void N(boolean paramBoolean)
  {
    Method localMethod;
    if (Build.VERSION.SDK_INT <= 28)
    {
      localMethod = H;
      if (localMethod == null) {
        break label55;
      }
    }
    try
    {
      localMethod.invoke(this.G, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      label37:
      break label37;
    }
    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
    return;
    this.G.setIsClippedToScreen(paramBoolean);
    label55:
  }
  
  private int q()
  {
    Object localObject1 = this.c;
    int i3 = -2147483648;
    boolean bool = true;
    Object localObject2;
    int i1;
    int i2;
    if (localObject1 == null)
    {
      localObject1 = this.a;
      this.A = new a();
      localObject2 = s((Context)localObject1, this.F ^ true);
      this.c = ((u)localObject2);
      Object localObject3 = this.t;
      if (localObject3 != null) {
        ((u)localObject2).setSelector((Drawable)localObject3);
      }
      this.c.setAdapter(this.b);
      this.c.setOnItemClickListener(this.u);
      this.c.setFocusable(true);
      this.c.setFocusableInTouchMode(true);
      this.c.setOnItemSelectedListener(new b());
      this.c.setOnScrollListener(this.y);
      localObject2 = this.v;
      if (localObject2 != null) {
        this.c.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject2);
      }
      localObject2 = this.c;
      localObject3 = this.p;
      if (localObject3 != null)
      {
        localObject1 = new LinearLayout((Context)localObject1);
        ((LinearLayout)localObject1).setOrientation(1);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0F);
        i1 = this.q;
        if (i1 != 0)
        {
          if (i1 != 1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Invalid hint position ");
            ((StringBuilder)localObject2).append(this.q);
            Log.e("ListPopupWindow", ((StringBuilder)localObject2).toString());
          }
          else
          {
            ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
            ((LinearLayout)localObject1).addView((View)localObject3);
          }
        }
        else
        {
          ((LinearLayout)localObject1).addView((View)localObject3);
          ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
        }
        i1 = this.e;
        if (i1 >= 0)
        {
          i2 = -2147483648;
        }
        else
        {
          i1 = 0;
          i2 = i1;
        }
        ((View)localObject3).measure(View.MeasureSpec.makeMeasureSpec(i1, i2), 0);
        localObject2 = (LinearLayout.LayoutParams)((View)localObject3).getLayoutParams();
        i1 = ((View)localObject3).getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
      }
      else
      {
        i1 = 0;
        localObject1 = localObject2;
      }
      this.G.setContentView((View)localObject1);
    }
    else
    {
      localObject1 = (ViewGroup)this.G.getContentView();
      localObject1 = this.p;
      if (localObject1 != null)
      {
        localObject2 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
        i1 = ((View)localObject1).getMeasuredHeight() + ((LinearLayout.LayoutParams)localObject2).topMargin + ((LinearLayout.LayoutParams)localObject2).bottomMargin;
      }
      else
      {
        i1 = 0;
      }
    }
    localObject1 = this.G.getBackground();
    int i5;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).getPadding(this.C);
      localObject1 = this.C;
      i5 = ((Rect)localObject1).top;
      i4 = ((Rect)localObject1).bottom + i5;
      i2 = i4;
      if (!this.i)
      {
        this.g = (-i5);
        i2 = i4;
      }
    }
    else
    {
      this.C.setEmpty();
      i2 = 0;
    }
    if (this.G.getInputMethodMode() != 2) {
      bool = false;
    }
    int i4 = u(t(), this.g, bool);
    if ((!this.m) && (this.d != -1))
    {
      i5 = this.e;
      if (i5 != -2)
      {
        i3 = 1073741824;
        if (i5 != -1)
        {
          i3 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
          break label636;
        }
      }
      i5 = this.a.getResources().getDisplayMetrics().widthPixels;
      localObject1 = this.C;
      i3 = View.MeasureSpec.makeMeasureSpec(i5 - (((Rect)localObject1).left + ((Rect)localObject1).right), i3);
      label636:
      i4 = this.c.d(i3, 0, -1, i4 - i1, -1);
      i3 = i1;
      if (i4 > 0) {
        i3 = i1 + (i2 + (this.c.getPaddingTop() + this.c.getPaddingBottom()));
      }
      return i4 + i3;
    }
    return i4 + i2;
  }
  
  private int u(View paramView, int paramInt, boolean paramBoolean)
  {
    Method localMethod;
    if (Build.VERSION.SDK_INT <= 23)
    {
      localMethod = I;
      if (localMethod == null) {}
    }
    try
    {
      int i1 = ((Integer)localMethod.invoke(this.G, new Object[] { paramView, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) })).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      label60:
      break label60;
    }
    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
    return this.G.getMaxAvailableHeight(paramView, paramInt);
    return this.G.getMaxAvailableHeight(paramView, paramInt, paramBoolean);
  }
  
  public boolean A()
  {
    return this.G.getInputMethodMode() == 2;
  }
  
  public boolean B()
  {
    return this.F;
  }
  
  public void D(View paramView)
  {
    this.s = paramView;
  }
  
  public void E(int paramInt)
  {
    this.G.setAnimationStyle(paramInt);
  }
  
  public void F(int paramInt)
  {
    Object localObject = this.G.getBackground();
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(this.C);
      localObject = this.C;
      this.e = (((Rect)localObject).left + ((Rect)localObject).right + paramInt);
      return;
    }
    Q(paramInt);
  }
  
  public void G(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void H(Rect paramRect)
  {
    if (paramRect != null) {
      paramRect = new Rect(paramRect);
    } else {
      paramRect = null;
    }
    this.E = paramRect;
  }
  
  public void I(int paramInt)
  {
    this.G.setInputMethodMode(paramInt);
  }
  
  public void J(boolean paramBoolean)
  {
    this.F = paramBoolean;
    this.G.setFocusable(paramBoolean);
  }
  
  public void K(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.G.setOnDismissListener(paramOnDismissListener);
  }
  
  public void L(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.u = paramOnItemClickListener;
  }
  
  public void M(boolean paramBoolean)
  {
    this.k = true;
    this.j = paramBoolean;
  }
  
  public void O(int paramInt)
  {
    this.q = paramInt;
  }
  
  public void P(int paramInt)
  {
    u localu = this.c;
    if ((c()) && (localu != null))
    {
      localu.setListSelectionHidden(false);
      localu.setSelection(paramInt);
      if (localu.getChoiceMode() != 0) {
        localu.setItemChecked(paramInt, true);
      }
    }
  }
  
  public void Q(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a()
  {
    int i2 = q();
    boolean bool2 = A();
    k.b(this.G, this.h);
    boolean bool3 = this.G.isShowing();
    boolean bool1 = true;
    int i1;
    if (bool3)
    {
      if (!x.T(t())) {
        return;
      }
      i3 = this.e;
      if (i3 == -1)
      {
        i1 = -1;
      }
      else
      {
        i1 = i3;
        if (i3 == -2) {
          i1 = t().getWidth();
        }
      }
      i3 = this.d;
      if (i3 == -1)
      {
        if (!bool2) {
          i2 = -1;
        }
        if (bool2)
        {
          localObject = this.G;
          if (this.e == -1) {
            i3 = -1;
          } else {
            i3 = 0;
          }
          ((PopupWindow)localObject).setWidth(i3);
          this.G.setHeight(0);
        }
        else
        {
          localObject = this.G;
          if (this.e == -1) {
            i3 = -1;
          } else {
            i3 = 0;
          }
          ((PopupWindow)localObject).setWidth(i3);
          this.G.setHeight(-1);
        }
      }
      else if (i3 != -2)
      {
        i2 = i3;
      }
      localObject = this.G;
      if ((this.n) || (this.m)) {
        bool1 = false;
      }
      ((PopupWindow)localObject).setOutsideTouchable(bool1);
      localObject = this.G;
      View localView = t();
      i3 = this.f;
      int i4 = this.g;
      if (i1 < 0) {
        i1 = -1;
      }
      if (i2 < 0) {
        i2 = -1;
      }
      ((PopupWindow)localObject).update(localView, i3, i4, i1, i2);
      return;
    }
    int i3 = this.e;
    if (i3 == -1)
    {
      i1 = -1;
    }
    else
    {
      i1 = i3;
      if (i3 == -2) {
        i1 = t().getWidth();
      }
    }
    i3 = this.d;
    if (i3 == -1) {
      i2 = -1;
    } else if (i3 != -2) {
      i2 = i3;
    }
    this.G.setWidth(i1);
    this.G.setHeight(i2);
    N(true);
    Object localObject = this.G;
    if ((!this.n) && (!this.m)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((PopupWindow)localObject).setOutsideTouchable(bool1);
    this.G.setTouchInterceptor(this.x);
    if (this.k) {
      k.a(this.G, this.j);
    }
    if (Build.VERSION.SDK_INT <= 28)
    {
      localObject = J;
      if (localObject != null) {
        try
        {
          ((Method)localObject).invoke(this.G, new Object[] { this.E });
        }
        catch (Exception localException)
        {
          Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", localException);
        }
      }
    }
    else
    {
      this.G.setEpicenterBounds(this.E);
    }
    k.c(this.G, t(), this.f, this.g, this.l);
    this.c.setSelection(-1);
    if ((!this.F) || (this.c.isInTouchMode())) {
      r();
    }
    if (!this.F) {
      this.B.post(this.z);
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    this.G.setBackgroundDrawable(paramDrawable);
  }
  
  public boolean c()
  {
    return this.G.isShowing();
  }
  
  public int d()
  {
    return this.f;
  }
  
  public void dismiss()
  {
    this.G.dismiss();
    C();
    this.G.setContentView(null);
    this.c = null;
    this.B.removeCallbacks(this.w);
  }
  
  public Drawable g()
  {
    return this.G.getBackground();
  }
  
  public ListView h()
  {
    return this.c;
  }
  
  public void j(int paramInt)
  {
    this.g = paramInt;
    this.i = true;
  }
  
  public void l(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int n()
  {
    if (!this.i) {
      return 0;
    }
    return this.g;
  }
  
  public void p(ListAdapter paramListAdapter)
  {
    DataSetObserver localDataSetObserver = this.r;
    if (localDataSetObserver == null)
    {
      this.r = new d();
    }
    else
    {
      ListAdapter localListAdapter = this.b;
      if (localListAdapter != null) {
        localListAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    this.b = paramListAdapter;
    if (paramListAdapter != null) {
      paramListAdapter.registerDataSetObserver(this.r);
    }
    paramListAdapter = this.c;
    if (paramListAdapter != null) {
      paramListAdapter.setAdapter(this.b);
    }
  }
  
  public void r()
  {
    u localu = this.c;
    if (localu != null)
    {
      localu.setListSelectionHidden(true);
      localu.requestLayout();
    }
  }
  
  u s(Context paramContext, boolean paramBoolean)
  {
    return new u(paramContext, paramBoolean);
  }
  
  public View t()
  {
    return this.s;
  }
  
  public Object v()
  {
    if (!c()) {
      return null;
    }
    return this.c.getSelectedItem();
  }
  
  public long w()
  {
    if (!c()) {
      return -9223372036854775808L;
    }
    return this.c.getSelectedItemId();
  }
  
  public int x()
  {
    if (!c()) {
      return -1;
    }
    return this.c.getSelectedItemPosition();
  }
  
  public View y()
  {
    if (!c()) {
      return null;
    }
    return this.c.getSelectedView();
  }
  
  public int z()
  {
    return this.e;
  }
  
  class a
    implements Runnable
  {
    a() {}
    
    public void run()
    {
      View localView = ListPopupWindow.this.t();
      if ((localView != null) && (localView.getWindowToken() != null)) {
        ListPopupWindow.this.a();
      }
    }
  }
  
  class b
    implements AdapterView.OnItemSelectedListener
  {
    b() {}
    
    public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      if (paramInt != -1)
      {
        paramAdapterView = ListPopupWindow.this.c;
        if (paramAdapterView != null) {
          paramAdapterView.setListSelectionHidden(false);
        }
      }
    }
    
    public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  }
  
  private class c
    implements Runnable
  {
    c() {}
    
    public void run()
    {
      ListPopupWindow.this.r();
    }
  }
  
  private class d
    extends DataSetObserver
  {
    d() {}
    
    public void onChanged()
    {
      if (ListPopupWindow.this.c()) {
        ListPopupWindow.this.a();
      }
    }
    
    public void onInvalidated()
    {
      ListPopupWindow.this.dismiss();
    }
  }
  
  private class e
    implements AbsListView.OnScrollListener
  {
    e() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if ((paramInt == 1) && (!ListPopupWindow.this.A()) && (ListPopupWindow.this.G.getContentView() != null))
      {
        paramAbsListView = ListPopupWindow.this;
        paramAbsListView.B.removeCallbacks(paramAbsListView.w);
        ListPopupWindow.this.w.run();
      }
    }
  }
  
  private class f
    implements View.OnTouchListener
  {
    f() {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      if (i == 0)
      {
        paramView = ListPopupWindow.this.G;
        if ((paramView != null) && (paramView.isShowing()) && (j >= 0) && (j < ListPopupWindow.this.G.getWidth()) && (k >= 0) && (k < ListPopupWindow.this.G.getHeight()))
        {
          paramView = ListPopupWindow.this;
          paramView.B.postDelayed(paramView.w, 250L);
          break label126;
        }
      }
      if (i == 1)
      {
        paramView = ListPopupWindow.this;
        paramView.B.removeCallbacks(paramView.w);
      }
      label126:
      return false;
    }
  }
  
  private class g
    implements Runnable
  {
    g() {}
    
    public void run()
    {
      Object localObject = ListPopupWindow.this.c;
      if ((localObject != null) && (x.T((View)localObject)) && (ListPopupWindow.this.c.getCount() > ListPopupWindow.this.c.getChildCount()))
      {
        int i = ListPopupWindow.this.c.getChildCount();
        localObject = ListPopupWindow.this;
        if (i <= ((ListPopupWindow)localObject).o)
        {
          ((ListPopupWindow)localObject).G.setInputMethodMode(2);
          ListPopupWindow.this.a();
        }
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.ListPopupWindow
 * JD-Core Version:    0.7.0.1
 */