package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.h0;
import androidx.core.view.h0.m;
import androidx.core.view.r;
import androidx.core.view.x;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.c;
import androidx.fragment.app.q;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.drawable;
import com.google.android.material.R.id;
import com.google.android.material.R.layout;
import com.google.android.material.R.string;
import com.google.android.material.R.style;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.e;
import com.google.android.material.internal.t;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class g<S>
  extends c
{
  static final Object N = "CONFIRM_BUTTON_TAG";
  static final Object O = "CANCEL_BUTTON_TAG";
  static final Object P = "TOGGLE_BUTTON_TAG";
  private CharSequence A;
  private boolean B;
  private int C;
  private int E;
  private CharSequence F;
  private int G;
  private CharSequence H;
  private TextView I;
  private CheckableImageButton J;
  private r7.h K;
  private Button L;
  private boolean M;
  private final LinkedHashSet<h<? super S>> q = new LinkedHashSet();
  private final LinkedHashSet<View.OnClickListener> r = new LinkedHashSet();
  private final LinkedHashSet<DialogInterface.OnCancelListener> s = new LinkedHashSet();
  private final LinkedHashSet<DialogInterface.OnDismissListener> t = new LinkedHashSet();
  private int u;
  private DateSelector<S> v;
  private m<S> w;
  private CalendarConstraints x;
  private f<S> y;
  private int z;
  
  private static Drawable F(Context paramContext)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    Drawable localDrawable = c.a.b(paramContext, R.drawable.material_ic_calendar_black_24dp);
    localStateListDrawable.addState(new int[] { 16842912 }, localDrawable);
    paramContext = c.a.b(paramContext, R.drawable.material_ic_edit_black_24dp);
    localStateListDrawable.addState(new int[0], paramContext);
    return localStateListDrawable;
  }
  
  private void G(Window paramWindow)
  {
    if (this.M) {
      return;
    }
    final View localView = requireView().findViewById(R.id.fullscreen_header);
    e.a(paramWindow, true, t.d(localView), null);
    final int i = localView.getPaddingTop();
    x.E0(localView, new c(localView.getLayoutParams().height, localView, i));
    this.M = true;
  }
  
  private DateSelector<S> I()
  {
    if (this.v == null) {
      this.v = ((DateSelector)getArguments().getParcelable("DATE_SELECTOR_KEY"));
    }
    return this.v;
  }
  
  private static int K(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
    int j = Month.m().d;
    return i * 2 + paramContext.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * j + (j - 1) * paramContext.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding);
  }
  
  private int M(Context paramContext)
  {
    int i = this.u;
    if (i != 0) {
      return i;
    }
    return I().b(paramContext);
  }
  
  private void N(Context paramContext)
  {
    this.J.setTag(P);
    this.J.setImageDrawable(F(paramContext));
    paramContext = this.J;
    boolean bool;
    if (this.C != 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext.setChecked(bool);
    x.q0(this.J, null);
    U(this.J);
    this.J.setOnClickListener(new e());
  }
  
  static boolean O(Context paramContext)
  {
    return Q(paramContext, 16843277);
  }
  
  static boolean P(Context paramContext)
  {
    return Q(paramContext, R.attr.nestedScrollable);
  }
  
  static boolean Q(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(o7.b.d(paramContext, R.attr.materialCalendarStyle, f.class.getCanonicalName()), new int[] { paramInt });
    boolean bool = paramContext.getBoolean(0, false);
    paramContext.recycle();
    return bool;
  }
  
  private void R()
  {
    int i = M(requireContext());
    this.y = f.C(I(), i, this.x);
    if (this.J.isChecked()) {
      localObject = i.l(I(), i, this.x);
    } else {
      localObject = this.y;
    }
    this.w = ((m)localObject);
    T();
    Object localObject = getChildFragmentManager().m();
    ((q)localObject).o(R.id.mtrl_calendar_frame, this.w);
    ((q)localObject).i();
    this.w.e(new d());
  }
  
  private void T()
  {
    String str = J();
    this.I.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), new Object[] { str }));
    this.I.setText(str);
  }
  
  private void U(CheckableImageButton paramCheckableImageButton)
  {
    boolean bool = this.J.isChecked();
    paramCheckableImageButton = paramCheckableImageButton.getContext();
    int i;
    if (bool) {
      i = R.string.mtrl_picker_toggle_to_calendar_input_mode;
    } else {
      i = R.string.mtrl_picker_toggle_to_text_input_mode;
    }
    paramCheckableImageButton = paramCheckableImageButton.getString(i);
    this.J.setContentDescription(paramCheckableImageButton);
  }
  
  public String J()
  {
    return I().a(getContext());
  }
  
  public final S L()
  {
    return I().j();
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    Iterator localIterator = this.s.iterator();
    while (localIterator.hasNext()) {
      ((DialogInterface.OnCancelListener)localIterator.next()).onCancel(paramDialogInterface);
    }
    super.onCancel(paramDialogInterface);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    this.u = localBundle.getInt("OVERRIDE_THEME_RES_ID");
    this.v = ((DateSelector)localBundle.getParcelable("DATE_SELECTOR_KEY"));
    this.x = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
    this.z = localBundle.getInt("TITLE_TEXT_RES_ID_KEY");
    this.A = localBundle.getCharSequence("TITLE_TEXT_KEY");
    this.C = localBundle.getInt("INPUT_MODE_KEY");
    this.E = localBundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
    this.F = localBundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
    this.G = localBundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
    this.H = localBundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i;
    if (this.B) {
      i = R.layout.mtrl_picker_fullscreen;
    } else {
      i = R.layout.mtrl_picker_dialog;
    }
    paramBundle = paramLayoutInflater.inflate(i, paramViewGroup);
    Context localContext = paramBundle.getContext();
    if (this.B)
    {
      paramViewGroup = paramBundle.findViewById(R.id.mtrl_calendar_frame);
      paramLayoutInflater = new LinearLayout.LayoutParams(K(localContext), -2);
    }
    else
    {
      paramViewGroup = paramBundle.findViewById(R.id.mtrl_calendar_main_pane);
      paramLayoutInflater = new LinearLayout.LayoutParams(K(localContext), -1);
    }
    paramViewGroup.setLayoutParams(paramLayoutInflater);
    paramLayoutInflater = (TextView)paramBundle.findViewById(R.id.mtrl_picker_header_selection_text);
    this.I = paramLayoutInflater;
    x.s0(paramLayoutInflater, 1);
    this.J = ((CheckableImageButton)paramBundle.findViewById(R.id.mtrl_picker_header_toggle));
    paramLayoutInflater = (TextView)paramBundle.findViewById(R.id.mtrl_picker_title_text);
    paramViewGroup = this.A;
    if (paramViewGroup != null) {
      paramLayoutInflater.setText(paramViewGroup);
    } else {
      paramLayoutInflater.setText(this.z);
    }
    N(localContext);
    this.L = ((Button)paramBundle.findViewById(R.id.confirm_button));
    if (I().e()) {
      this.L.setEnabled(true);
    } else {
      this.L.setEnabled(false);
    }
    this.L.setTag(N);
    paramLayoutInflater = this.F;
    if (paramLayoutInflater != null)
    {
      this.L.setText(paramLayoutInflater);
    }
    else
    {
      i = this.E;
      if (i != 0) {
        this.L.setText(i);
      }
    }
    this.L.setOnClickListener(new a());
    paramLayoutInflater = (Button)paramBundle.findViewById(R.id.cancel_button);
    paramLayoutInflater.setTag(O);
    paramViewGroup = this.H;
    if (paramViewGroup != null)
    {
      paramLayoutInflater.setText(paramViewGroup);
    }
    else
    {
      i = this.G;
      if (i != 0) {
        paramLayoutInflater.setText(i);
      }
    }
    paramLayoutInflater.setOnClickListener(new b());
    return paramBundle;
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    Object localObject = this.t.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((DialogInterface.OnDismissListener)((Iterator)localObject).next()).onDismiss(paramDialogInterface);
    }
    localObject = (ViewGroup)getView();
    if (localObject != null) {
      ((ViewGroup)localObject).removeAllViews();
    }
    super.onDismiss(paramDialogInterface);
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("OVERRIDE_THEME_RES_ID", this.u);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", this.v);
    CalendarConstraints.b localb = new CalendarConstraints.b(this.x);
    if (this.y.x() != null) {
      localb.b(this.y.x().f);
    }
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", localb.a());
    paramBundle.putInt("TITLE_TEXT_RES_ID_KEY", this.z);
    paramBundle.putCharSequence("TITLE_TEXT_KEY", this.A);
    paramBundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.E);
    paramBundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.F);
    paramBundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.G);
    paramBundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.H);
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = v().getWindow();
    if (this.B)
    {
      localWindow.setLayout(-1, -1);
      localWindow.setBackgroundDrawable(this.K);
      G(localWindow);
    }
    else
    {
      localWindow.setLayout(-2, -2);
      int i = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
      Rect localRect = new Rect(i, i, i, i);
      localWindow.setBackgroundDrawable(new InsetDrawable(this.K, i, i, i, i));
      localWindow.getDecorView().setOnTouchListener(new h7.a(v(), localRect));
    }
    R();
  }
  
  public void onStop()
  {
    this.w.j();
    super.onStop();
  }
  
  public final Dialog r(Bundle paramBundle)
  {
    paramBundle = new Dialog(requireContext(), M(requireContext()));
    Context localContext = paramBundle.getContext();
    this.B = O(localContext);
    int i = o7.b.d(localContext, R.attr.colorSurface, g.class.getCanonicalName());
    r7.h localh = new r7.h(localContext, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
    this.K = localh;
    localh.Q(localContext);
    this.K.b0(ColorStateList.valueOf(i));
    this.K.a0(x.w(paramBundle.getWindow().getDecorView()));
    return paramBundle;
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      paramView = g.x(g.this).iterator();
      while (paramView.hasNext()) {
        ((h)paramView.next()).a(g.this.L());
      }
      g.this.n();
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      Iterator localIterator = g.y(g.this).iterator();
      while (localIterator.hasNext()) {
        ((View.OnClickListener)localIterator.next()).onClick(paramView);
      }
      g.this.n();
    }
  }
  
  class c
    implements r
  {
    c(int paramInt1, View paramView, int paramInt2) {}
    
    public h0 a(View paramView, h0 paramh0)
    {
      int i = paramh0.f(h0.m.c()).b;
      if (this.a >= 0)
      {
        localView.getLayoutParams().height = (this.a + i);
        paramView = localView;
        paramView.setLayoutParams(paramView.getLayoutParams());
      }
      paramView = localView;
      paramView.setPadding(paramView.getPaddingLeft(), i + i, localView.getPaddingRight(), localView.getPaddingBottom());
      return paramh0;
    }
  }
  
  class d
    extends l<S>
  {
    d() {}
    
    public void a()
    {
      g.B(g.this).setEnabled(false);
    }
    
    public void b(S paramS)
    {
      g.z(g.this);
      g.B(g.this).setEnabled(g.A(g.this).e());
    }
  }
  
  class e
    implements View.OnClickListener
  {
    e() {}
    
    public void onClick(View paramView)
    {
      g.B(g.this).setEnabled(g.A(g.this).e());
      g.C(g.this).toggle();
      paramView = g.this;
      g.D(paramView, g.C(paramView));
      g.E(g.this);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.datepicker.g
 * JD-Core Version:    0.7.0.1
 */