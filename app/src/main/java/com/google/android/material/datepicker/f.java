package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import androidx.core.view.x;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.o;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.t;
import androidx.recyclerview.widget.RecyclerView.z;
import androidx.recyclerview.widget.r;
import com.google.android.material.R.dimen;
import com.google.android.material.R.id;
import com.google.android.material.R.integer;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class f<S>
  extends m<S>
{
  static final Object l = "MONTHS_VIEW_GROUP_TAG";
  static final Object m = "NAVIGATION_PREV_TAG";
  static final Object n = "NAVIGATION_NEXT_TAG";
  static final Object o = "SELECTOR_TOGGLE_TAG";
  private int b;
  private DateSelector<S> c;
  private CalendarConstraints d;
  private Month e;
  private k f;
  private b g;
  private RecyclerView h;
  private RecyclerView i;
  private View j;
  private View k;
  
  private static int A(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i1 = paramContext.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
    int i2 = paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding);
    int i3 = paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
    int i4 = paramContext.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
    int i5 = j.f;
    return i1 + i2 + i3 + i4 + (paramContext.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i5 + (i5 - 1) * paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
  }
  
  public static <T> f<T> C(DateSelector<T> paramDateSelector, int paramInt, CalendarConstraints paramCalendarConstraints)
  {
    f localf = new f();
    Bundle localBundle = new Bundle();
    localBundle.putInt("THEME_RES_ID_KEY", paramInt);
    localBundle.putParcelable("GRID_SELECTOR_KEY", paramDateSelector);
    localBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    localBundle.putParcelable("CURRENT_MONTH_KEY", paramCalendarConstraints.r());
    localf.setArguments(localBundle);
    return localf;
  }
  
  private void D(final int paramInt)
  {
    this.i.post(new a(paramInt));
  }
  
  private void t(View paramView, final k paramk)
  {
    final MaterialButton localMaterialButton1 = (MaterialButton)paramView.findViewById(R.id.month_navigation_fragment_toggle);
    localMaterialButton1.setTag(o);
    x.q0(localMaterialButton1, new f());
    MaterialButton localMaterialButton2 = (MaterialButton)paramView.findViewById(R.id.month_navigation_previous);
    localMaterialButton2.setTag(m);
    MaterialButton localMaterialButton3 = (MaterialButton)paramView.findViewById(R.id.month_navigation_next);
    localMaterialButton3.setTag(n);
    this.j = paramView.findViewById(R.id.mtrl_calendar_year_selector_frame);
    this.k = paramView.findViewById(R.id.mtrl_calendar_day_selector_frame);
    F(k.a);
    localMaterialButton1.setText(this.e.q());
    this.i.l(new g(paramk, localMaterialButton1));
    localMaterialButton1.setOnClickListener(new h());
    localMaterialButton3.setOnClickListener(new i(paramk));
    localMaterialButton2.setOnClickListener(new j(paramk));
  }
  
  private RecyclerView.o u()
  {
    return new e();
  }
  
  static int z(Context paramContext)
  {
    return paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
  }
  
  LinearLayoutManager B()
  {
    return (LinearLayoutManager)this.i.getLayoutManager();
  }
  
  void E(Month paramMonth)
  {
    k localk = (k)this.i.getAdapter();
    int i3 = localk.L(paramMonth);
    int i4 = i3 - localk.L(this.e);
    int i1 = Math.abs(i4);
    int i2 = 1;
    if (i1 > 3) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i4 <= 0) {
      i2 = 0;
    }
    this.e = paramMonth;
    if ((i1 != 0) && (i2 != 0))
    {
      paramMonth = this.i;
      i1 = i3 - 3;
    }
    else
    {
      if (i1 == 0) {
        break label109;
      }
      paramMonth = this.i;
      i1 = i3 + 3;
    }
    paramMonth.k1(i1);
    label109:
    D(i3);
  }
  
  void F(k paramk)
  {
    this.f = paramk;
    if (paramk == k.b)
    {
      this.h.getLayoutManager().x1(((q)this.h.getAdapter()).K(this.e.c));
      this.j.setVisibility(0);
      this.k.setVisibility(8);
      return;
    }
    if (paramk == k.a)
    {
      this.j.setVisibility(8);
      this.k.setVisibility(0);
      E(this.e);
    }
  }
  
  void G()
  {
    k localk1 = this.f;
    k localk2 = k.b;
    if (localk1 == localk2)
    {
      F(k.a);
      return;
    }
    if (localk1 == k.a) {
      F(localk2);
    }
  }
  
  public boolean e(l<S> paraml)
  {
    return super.e(paraml);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    this.b = localBundle.getInt("THEME_RES_ID_KEY");
    this.c = ((DateSelector)localBundle.getParcelable("GRID_SELECTOR_KEY"));
    this.d = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
    this.e = ((Month)localBundle.getParcelable("CURRENT_MONTH_KEY"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = new ContextThemeWrapper(getContext(), this.b);
    this.g = new b(paramBundle);
    paramLayoutInflater = paramLayoutInflater.cloneInContext(paramBundle);
    Object localObject = this.d.s();
    final int i2;
    if (g.O(paramBundle))
    {
      i1 = R.layout.mtrl_calendar_vertical;
      i2 = 1;
    }
    else
    {
      i1 = R.layout.mtrl_calendar_horizontal;
      i2 = 0;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(i1, paramViewGroup, false);
    paramLayoutInflater.setMinimumHeight(A(requireContext()));
    paramViewGroup = (GridView)paramLayoutInflater.findViewById(R.id.mtrl_calendar_days_of_week);
    x.q0(paramViewGroup, new b());
    paramViewGroup.setAdapter(new e());
    paramViewGroup.setNumColumns(((Month)localObject).d);
    paramViewGroup.setEnabled(false);
    this.i = ((RecyclerView)paramLayoutInflater.findViewById(R.id.mtrl_calendar_months));
    paramViewGroup = new c(getContext(), i2, false, i2);
    this.i.setLayoutManager(paramViewGroup);
    this.i.setTag(l);
    paramViewGroup = new k(paramBundle, this.c, this.d, new d());
    this.i.setAdapter(paramViewGroup);
    int i1 = paramBundle.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
    localObject = (RecyclerView)paramLayoutInflater.findViewById(R.id.mtrl_calendar_year_selector_frame);
    this.h = ((RecyclerView)localObject);
    if (localObject != null)
    {
      ((RecyclerView)localObject).setHasFixedSize(true);
      this.h.setLayoutManager(new GridLayoutManager(paramBundle, i1, 1, false));
      this.h.setAdapter(new q(this));
      this.h.h(u());
    }
    if (paramLayoutInflater.findViewById(R.id.month_navigation_fragment_toggle) != null) {
      t(paramLayoutInflater, paramViewGroup);
    }
    if (!g.O(paramBundle)) {
      new androidx.recyclerview.widget.n().b(this.i);
    }
    this.i.k1(paramViewGroup.L(this.e));
    return paramLayoutInflater;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("THEME_RES_ID_KEY", this.b);
    paramBundle.putParcelable("GRID_SELECTOR_KEY", this.c);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.d);
    paramBundle.putParcelable("CURRENT_MONTH_KEY", this.e);
  }
  
  CalendarConstraints v()
  {
    return this.d;
  }
  
  b w()
  {
    return this.g;
  }
  
  Month x()
  {
    return this.e;
  }
  
  public DateSelector<S> y()
  {
    return this.c;
  }
  
  class a
    implements Runnable
  {
    a(int paramInt) {}
    
    public void run()
    {
      f.l(f.this).s1(paramInt);
    }
  }
  
  class b
    extends androidx.core.view.a
  {
    b() {}
    
    public void g(View paramView, y0.d paramd)
    {
      super.g(paramView, paramd);
      paramd.e0(null);
    }
  }
  
  class c
    extends n
  {
    c(Context paramContext, int paramInt1, boolean paramBoolean, int paramInt2)
    {
      super(paramInt1, paramBoolean);
    }
    
    protected void M1(RecyclerView.z paramz, int[] paramArrayOfInt)
    {
      if (i2 == 0)
      {
        paramArrayOfInt[0] = f.l(f.this).getWidth();
        paramArrayOfInt[1] = f.l(f.this).getWidth();
        return;
      }
      paramArrayOfInt[0] = f.l(f.this).getHeight();
      paramArrayOfInt[1] = f.l(f.this).getHeight();
    }
  }
  
  class d
    implements f.l
  {
    d() {}
    
    public void a(long paramLong)
    {
      if (f.n(f.this).o().c(paramLong))
      {
        f.o(f.this).k(paramLong);
        Iterator localIterator = f.this.a.iterator();
        while (localIterator.hasNext()) {
          ((l)localIterator.next()).b(f.o(f.this).j());
        }
        f.l(f.this).getAdapter().j();
        if (f.p(f.this) != null) {
          f.p(f.this).getAdapter().j();
        }
      }
    }
  }
  
  class e
    extends RecyclerView.o
  {
    private final Calendar a = p.q();
    private final Calendar b = p.q();
    
    e() {}
    
    public void g(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.z paramz)
    {
      if ((paramRecyclerView.getAdapter() instanceof q))
      {
        if (!(paramRecyclerView.getLayoutManager() instanceof GridLayoutManager)) {
          return;
        }
        paramz = (q)paramRecyclerView.getAdapter();
        GridLayoutManager localGridLayoutManager = (GridLayoutManager)paramRecyclerView.getLayoutManager();
        Iterator localIterator = f.o(f.this).d().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (x0.d)localIterator.next();
          Object localObject2 = ((x0.d)localObject1).a;
          if ((localObject2 != null) && (((x0.d)localObject1).b != null))
          {
            this.a.setTimeInMillis(((Long)localObject2).longValue());
            this.b.setTimeInMillis(((Long)((x0.d)localObject1).b).longValue());
            int j = paramz.K(this.a.get(1));
            int i = paramz.K(this.b.get(1));
            localObject1 = localGridLayoutManager.C(j);
            localObject2 = localGridLayoutManager.C(i);
            int m = j / localGridLayoutManager.V2();
            int n = i / localGridLayoutManager.V2();
            i = m;
            while (i <= n)
            {
              View localView = localGridLayoutManager.C(localGridLayoutManager.V2() * i);
              if (localView != null)
              {
                int i1 = localView.getTop();
                int i2 = f.q(f.this).d.c();
                int i3 = localView.getBottom();
                int i4 = f.q(f.this).d.b();
                if (i == m) {
                  j = ((View)localObject1).getLeft() + ((View)localObject1).getWidth() / 2;
                } else {
                  j = 0;
                }
                int k;
                if (i == n) {
                  k = ((View)localObject2).getLeft() + ((View)localObject2).getWidth() / 2;
                } else {
                  k = paramRecyclerView.getWidth();
                }
                paramCanvas.drawRect(j, i1 + i2, k, i3 - i4, f.q(f.this).h);
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  class f
    extends androidx.core.view.a
  {
    f() {}
    
    public void g(View paramView, y0.d paramd)
    {
      super.g(paramView, paramd);
      int i;
      if (f.r(f.this).getVisibility() == 0)
      {
        paramView = f.this;
        i = R.string.mtrl_picker_toggle_to_year_selection;
      }
      else
      {
        paramView = f.this;
        i = R.string.mtrl_picker_toggle_to_day_selection;
      }
      paramd.n0(paramView.getString(i));
    }
  }
  
  class g
    extends RecyclerView.t
  {
    g(k paramk, MaterialButton paramMaterialButton) {}
    
    public void a(RecyclerView paramRecyclerView, int paramInt)
    {
      if (paramInt == 0) {
        paramRecyclerView.announceForAccessibility(localMaterialButton1.getText());
      }
    }
    
    public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      paramRecyclerView = f.this.B();
      if (paramInt1 < 0) {
        paramInt1 = paramRecyclerView.Y1();
      } else {
        paramInt1 = paramRecyclerView.a2();
      }
      f.s(f.this, paramk.J(paramInt1));
      localMaterialButton1.setText(paramk.K(paramInt1));
    }
  }
  
  class h
    implements View.OnClickListener
  {
    h() {}
    
    public void onClick(View paramView)
    {
      f.this.G();
    }
  }
  
  class i
    implements View.OnClickListener
  {
    i(k paramk) {}
    
    public void onClick(View paramView)
    {
      int i = f.this.B().Y1() + 1;
      if (i < f.l(f.this).getAdapter().d()) {
        f.this.E(paramk.J(i));
      }
    }
  }
  
  class j
    implements View.OnClickListener
  {
    j(k paramk) {}
    
    public void onClick(View paramView)
    {
      int i = f.this.B().a2() - 1;
      if (i >= 0) {
        f.this.E(paramk.J(i));
      }
    }
  }
  
  static enum k
  {
    static
    {
      k localk1 = new k("DAY", 0);
      a = localk1;
      k localk2 = new k("YEAR", 1);
      b = localk2;
      c = new k[] { localk1, localk2 };
    }
    
    private k() {}
  }
  
  static abstract interface l
  {
    public abstract void a(long paramLong);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.f
 * JD-Core Version:    0.7.0.1
 */