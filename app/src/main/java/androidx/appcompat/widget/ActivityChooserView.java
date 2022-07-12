package androidx.appcompat.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import androidx.appcompat.R.dimen;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.string;
import androidx.appcompat.R.styleable;
import androidx.core.view.b;
import androidx.core.view.x;
import h.e;
import y0.d;

public class ActivityChooserView
  extends ViewGroup
{
  final f a;
  private final g b;
  private final View c;
  private final Drawable d;
  final FrameLayout e;
  private final ImageView f;
  final FrameLayout g;
  private final ImageView h;
  private final int i;
  b j;
  final DataSetObserver k = new a();
  private final ViewTreeObserver.OnGlobalLayoutListener l = new b();
  private ListPopupWindow m;
  PopupWindow.OnDismissListener n;
  boolean o;
  int p = 4;
  private boolean q;
  private int r;
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject2 = R.styleable.ActivityChooserView;
    Object localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject2, paramInt, 0);
    x.o0(this, paramContext, (int[])localObject2, paramAttributeSet, (TypedArray)localObject1, paramInt, 0);
    this.p = ((TypedArray)localObject1).getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
    paramAttributeSet = ((TypedArray)localObject1).getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
    ((TypedArray)localObject1).recycle();
    LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
    localObject1 = new g();
    this.b = ((g)localObject1);
    localObject2 = findViewById(R.id.activity_chooser_view_content);
    this.c = ((View)localObject2);
    this.d = ((View)localObject2).getBackground();
    localObject2 = (FrameLayout)findViewById(R.id.default_activity_button);
    this.g = ((FrameLayout)localObject2);
    ((FrameLayout)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    ((FrameLayout)localObject2).setOnLongClickListener((View.OnLongClickListener)localObject1);
    paramInt = R.id.image;
    this.h = ((ImageView)((FrameLayout)localObject2).findViewById(paramInt));
    localObject2 = (FrameLayout)findViewById(R.id.expand_activities_button);
    ((FrameLayout)localObject2).setOnClickListener((View.OnClickListener)localObject1);
    ((FrameLayout)localObject2).setAccessibilityDelegate(new c());
    ((FrameLayout)localObject2).setOnTouchListener(new d((View)localObject2));
    this.e = ((FrameLayout)localObject2);
    localObject1 = (ImageView)((FrameLayout)localObject2).findViewById(paramInt);
    this.f = ((ImageView)localObject1);
    ((ImageView)localObject1).setImageDrawable(paramAttributeSet);
    paramAttributeSet = new f();
    this.a = paramAttributeSet;
    paramAttributeSet.registerDataSetObserver(new e());
    paramContext = paramContext.getResources();
    this.i = Math.max(paramContext.getDisplayMetrics().widthPixels / 2, paramContext.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
  }
  
  public boolean a()
  {
    if (b())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this.l);
      }
    }
    return true;
  }
  
  public boolean b()
  {
    return getListPopupWindow().c();
  }
  
  public boolean c()
  {
    if (!b())
    {
      if (!this.q) {
        return false;
      }
      this.o = false;
      d(this.p);
      return true;
    }
    return false;
  }
  
  void d(int paramInt)
  {
    this.a.b();
    throw new IllegalStateException("No data model. Did you call #setDataModel?");
  }
  
  void e()
  {
    if (this.a.getCount() > 0) {
      this.e.setEnabled(true);
    } else {
      this.e.setEnabled(false);
    }
    int i1 = this.a.a();
    int i2 = this.a.d();
    Object localObject1;
    Object localObject2;
    if ((i1 != 1) && ((i1 <= 1) || (i2 <= 0)))
    {
      this.g.setVisibility(8);
    }
    else
    {
      this.g.setVisibility(0);
      localObject1 = this.a.c();
      localObject2 = getContext().getPackageManager();
      this.h.setImageDrawable(((ResolveInfo)localObject1).loadIcon((PackageManager)localObject2));
      if (this.r != 0)
      {
        localObject1 = ((ResolveInfo)localObject1).loadLabel((PackageManager)localObject2);
        localObject1 = getContext().getString(this.r, new Object[] { localObject1 });
        this.g.setContentDescription((CharSequence)localObject1);
      }
    }
    if (this.g.getVisibility() == 0)
    {
      localObject1 = this.c;
      localObject2 = this.d;
    }
    else
    {
      localObject1 = this.c;
      localObject2 = null;
    }
    ((View)localObject1).setBackgroundDrawable((Drawable)localObject2);
  }
  
  public c getDataModel()
  {
    this.a.b();
    return null;
  }
  
  ListPopupWindow getListPopupWindow()
  {
    if (this.m == null)
    {
      ListPopupWindow localListPopupWindow = new ListPopupWindow(getContext());
      this.m = localListPopupWindow;
      localListPopupWindow.p(this.a);
      this.m.D(this);
      this.m.J(true);
      this.m.L(this.b);
      this.m.K(this.b);
    }
    return this.m;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.b();
    this.q = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.b();
    ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
    if (localViewTreeObserver.isAlive()) {
      localViewTreeObserver.removeGlobalOnLayoutListener(this.l);
    }
    if (b()) {
      a();
    }
    this.q = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!b()) {
      a();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = this.c;
    int i1 = paramInt2;
    if (this.g.getVisibility() != 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localView, paramInt1, i1);
    setMeasuredDimension(localView.getMeasuredWidth(), localView.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(c paramc)
  {
    this.a.f(paramc);
    if (b())
    {
      a();
      c();
    }
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    this.f.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    this.f.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.n = paramOnDismissListener;
  }
  
  public void setProvider(b paramb)
  {
    this.j = paramb;
  }
  
  public static class InnerLayout
    extends LinearLayout
  {
    private static final int[] a = { 16842964 };
    
    public InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = k0.u(paramContext, paramAttributeSet, a);
      setBackgroundDrawable(paramContext.g(0));
      paramContext.w();
    }
  }
  
  class a
    extends DataSetObserver
  {
    a() {}
    
    public void onChanged()
    {
      super.onChanged();
      ActivityChooserView.this.a.notifyDataSetChanged();
    }
    
    public void onInvalidated()
    {
      super.onInvalidated();
      ActivityChooserView.this.a.notifyDataSetInvalidated();
    }
  }
  
  class b
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    b() {}
    
    public void onGlobalLayout()
    {
      if (ActivityChooserView.this.b())
      {
        if (!ActivityChooserView.this.isShown())
        {
          ActivityChooserView.this.getListPopupWindow().dismiss();
          return;
        }
        ActivityChooserView.this.getListPopupWindow().a();
        b localb = ActivityChooserView.this.j;
        if (localb != null) {
          localb.l(true);
        }
      }
    }
  }
  
  class c
    extends View.AccessibilityDelegate
  {
    c() {}
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
      d.J0(paramAccessibilityNodeInfo).Z(true);
    }
  }
  
  class d
    extends w
  {
    d(View paramView)
    {
      super();
    }
    
    public e b()
    {
      return ActivityChooserView.this.getListPopupWindow();
    }
    
    protected boolean c()
    {
      ActivityChooserView.this.c();
      return true;
    }
    
    protected boolean d()
    {
      ActivityChooserView.this.a();
      return true;
    }
  }
  
  class e
    extends DataSetObserver
  {
    e() {}
    
    public void onChanged()
    {
      super.onChanged();
      ActivityChooserView.this.e();
    }
  }
  
  private class f
    extends BaseAdapter
  {
    private int a = 4;
    private boolean b;
    private boolean c;
    private boolean d;
    
    f() {}
    
    public int a()
    {
      throw null;
    }
    
    public c b()
    {
      return null;
    }
    
    public ResolveInfo c()
    {
      throw null;
    }
    
    public int d()
    {
      throw null;
    }
    
    public boolean e()
    {
      return this.b;
    }
    
    public void f(c paramc)
    {
      ActivityChooserView.this.a.b();
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      throw null;
    }
    
    public Object getItem(int paramInt)
    {
      paramInt = getItemViewType(paramInt);
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          return null;
        }
        throw new IllegalArgumentException();
      }
      boolean bool = this.b;
      throw null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((this.d) && (paramInt == getCount() - 1)) {
        return 1;
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      View localView;
      if (i != 0)
      {
        if (i == 1)
        {
          if (paramView != null)
          {
            localView = paramView;
            if (paramView.getId() == 1) {}
          }
          else
          {
            localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
            localView.setId(1);
            ((TextView)localView.findViewById(R.id.title)).setText(ActivityChooserView.this.getContext().getString(R.string.abc_activity_chooser_view_see_all));
          }
          return localView;
        }
        throw new IllegalArgumentException();
      }
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == R.id.list_item) {}
      }
      else
      {
        localView = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
      }
      paramView = ActivityChooserView.this.getContext().getPackageManager();
      paramViewGroup = (ImageView)localView.findViewById(R.id.icon);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
      ((TextView)localView.findViewById(R.id.title)).setText(localResolveInfo.loadLabel(paramView));
      if ((this.b) && (paramInt == 0) && (this.c))
      {
        localView.setActivated(true);
        return localView;
      }
      localView.setActivated(false);
      return localView;
    }
    
    public int getViewTypeCount()
    {
      return 3;
    }
  }
  
  private class g
    implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener
  {
    g() {}
    
    private void a()
    {
      PopupWindow.OnDismissListener localOnDismissListener = ActivityChooserView.this.n;
      if (localOnDismissListener != null) {
        localOnDismissListener.onDismiss();
      }
    }
    
    public void onClick(View paramView)
    {
      ActivityChooserView localActivityChooserView = ActivityChooserView.this;
      if (paramView != localActivityChooserView.g)
      {
        if (paramView == localActivityChooserView.e)
        {
          localActivityChooserView.o = false;
          localActivityChooserView.d(localActivityChooserView.p);
          return;
        }
        throw new IllegalArgumentException();
      }
      localActivityChooserView.a();
      ActivityChooserView.this.a.c();
      ActivityChooserView.this.a.b();
      throw null;
    }
    
    public void onDismiss()
    {
      a();
      b localb = ActivityChooserView.this.j;
      if (localb != null) {
        localb.l(false);
      }
    }
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      int i = ((ActivityChooserView.f)paramAdapterView.getAdapter()).getItemViewType(paramInt);
      if (i != 0)
      {
        if (i == 1)
        {
          ActivityChooserView.this.d(2147483647);
          return;
        }
        throw new IllegalArgumentException();
      }
      ActivityChooserView.this.a();
      paramAdapterView = ActivityChooserView.this;
      if (paramAdapterView.o)
      {
        if (paramInt <= 0) {
          return;
        }
        paramAdapterView.a.b();
        throw null;
      }
      paramAdapterView.a.e();
      ActivityChooserView.this.a.b();
      throw null;
    }
    
    public boolean onLongClick(View paramView)
    {
      ActivityChooserView localActivityChooserView = ActivityChooserView.this;
      if (paramView == localActivityChooserView.g)
      {
        if (localActivityChooserView.a.getCount() > 0)
        {
          paramView = ActivityChooserView.this;
          paramView.o = true;
          paramView.d(paramView.p);
        }
        return true;
      }
      throw new IllegalArgumentException();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView
 * JD-Core Version:    0.7.0.1
 */