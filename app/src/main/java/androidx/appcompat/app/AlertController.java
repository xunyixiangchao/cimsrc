package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.R.styleable;
import androidx.appcompat.widget.LinearLayoutCompat.LayoutParams;
import androidx.core.view.x;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController
{
  NestedScrollView A;
  private int B = 0;
  private Drawable C;
  private ImageView D;
  private TextView E;
  private TextView F;
  private View G;
  ListAdapter H;
  int I = -1;
  private int J;
  private int K;
  int L;
  int M;
  int N;
  int O;
  private boolean P;
  private int Q = 0;
  Handler R;
  private final View.OnClickListener S = new a();
  private final Context a;
  final e b;
  private final Window c;
  private final int d;
  private CharSequence e;
  private CharSequence f;
  ListView g;
  private View h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private boolean n = false;
  Button o;
  private CharSequence p;
  Message q;
  private Drawable r;
  Button s;
  private CharSequence t;
  Message u;
  private Drawable v;
  Button w;
  private CharSequence x;
  Message y;
  private Drawable z;
  
  public AlertController(Context paramContext, e parame, Window paramWindow)
  {
    this.a = paramContext;
    this.b = parame;
    this.c = paramWindow;
    this.R = new c(parame);
    paramContext = paramContext.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
    this.J = paramContext.getResourceId(R.styleable.AlertDialog_android_layout, 0);
    this.K = paramContext.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
    this.L = paramContext.getResourceId(R.styleable.AlertDialog_listLayout, 0);
    this.M = paramContext.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
    this.N = paramContext.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
    this.O = paramContext.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
    this.P = paramContext.getBoolean(R.styleable.AlertDialog_showTitle, true);
    this.d = paramContext.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
    paramContext.recycle();
    parame.d(1);
  }
  
  static boolean a(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i1 = paramView.getChildCount();
    while (i1 > 0)
    {
      int i2 = i1 - 1;
      i1 = i2;
      if (a(paramView.getChildAt(i2))) {
        return true;
      }
    }
    return false;
  }
  
  private void b(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
  }
  
  private ViewGroup h(View paramView1, View paramView2)
  {
    if (paramView1 == null)
    {
      paramView1 = paramView2;
      if ((paramView2 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView2).inflate();
      }
      return (ViewGroup)paramView1;
    }
    if (paramView2 != null)
    {
      ViewParent localViewParent = paramView2.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView2);
      }
    }
    paramView2 = paramView1;
    if ((paramView1 instanceof ViewStub)) {
      paramView2 = ((ViewStub)paramView1).inflate();
    }
    return (ViewGroup)paramView2;
  }
  
  private int i()
  {
    int i1 = this.K;
    if (i1 == 0) {
      return this.J;
    }
    if (this.Q == 1) {
      return i1;
    }
    return this.J;
  }
  
  private void o(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2)
  {
    View localView1 = this.c.findViewById(R.id.scrollIndicatorUp);
    View localView2 = this.c.findViewById(R.id.scrollIndicatorDown);
    x.I0(paramView, paramInt1, paramInt2);
    if (localView1 != null) {
      paramViewGroup.removeView(localView1);
    }
    if (localView2 != null) {
      paramViewGroup.removeView(localView2);
    }
  }
  
  private void t(ViewGroup paramViewGroup)
  {
    Object localObject = (Button)paramViewGroup.findViewById(16908313);
    this.o = ((Button)localObject);
    ((Button)localObject).setOnClickListener(this.S);
    boolean bool = TextUtils.isEmpty(this.p);
    int i2 = 1;
    int i1;
    if ((bool) && (this.r == null))
    {
      this.o.setVisibility(8);
      i1 = 0;
    }
    else
    {
      this.o.setText(this.p);
      localObject = this.r;
      if (localObject != null)
      {
        i1 = this.d;
        ((Drawable)localObject).setBounds(0, 0, i1, i1);
        this.o.setCompoundDrawables(this.r, null, null, null);
      }
      this.o.setVisibility(0);
      i1 = 1;
    }
    localObject = (Button)paramViewGroup.findViewById(16908314);
    this.s = ((Button)localObject);
    ((Button)localObject).setOnClickListener(this.S);
    int i3;
    if ((TextUtils.isEmpty(this.t)) && (this.v == null))
    {
      this.s.setVisibility(8);
    }
    else
    {
      this.s.setText(this.t);
      localObject = this.v;
      if (localObject != null)
      {
        i3 = this.d;
        ((Drawable)localObject).setBounds(0, 0, i3, i3);
        this.s.setCompoundDrawables(this.v, null, null, null);
      }
      this.s.setVisibility(0);
      i1 |= 0x2;
    }
    localObject = (Button)paramViewGroup.findViewById(16908315);
    this.w = ((Button)localObject);
    ((Button)localObject).setOnClickListener(this.S);
    if ((TextUtils.isEmpty(this.x)) && (this.z == null))
    {
      this.w.setVisibility(8);
    }
    else
    {
      this.w.setText(this.x);
      localObject = this.z;
      if (localObject != null)
      {
        i3 = this.d;
        ((Drawable)localObject).setBounds(0, 0, i3, i3);
        this.w.setCompoundDrawables(this.z, null, null, null);
      }
      this.w.setVisibility(0);
      i1 |= 0x4;
    }
    if (y(this.a))
    {
      if (i1 == 1) {
        localObject = this.o;
      }
      for (;;)
      {
        b((Button)localObject);
        break;
        if (i1 == 2)
        {
          localObject = this.s;
        }
        else
        {
          if (i1 != 4) {
            break;
          }
          localObject = this.w;
        }
      }
    }
    if (i1 != 0) {
      i1 = i2;
    } else {
      i1 = 0;
    }
    if (i1 == 0) {
      paramViewGroup.setVisibility(8);
    }
  }
  
  private void u(ViewGroup paramViewGroup)
  {
    Object localObject = (NestedScrollView)this.c.findViewById(R.id.scrollView);
    this.A = ((NestedScrollView)localObject);
    ((FrameLayout)localObject).setFocusable(false);
    this.A.setNestedScrollingEnabled(false);
    localObject = (TextView)paramViewGroup.findViewById(16908299);
    this.F = ((TextView)localObject);
    if (localObject == null) {
      return;
    }
    CharSequence localCharSequence = this.f;
    if (localCharSequence != null)
    {
      ((TextView)localObject).setText(localCharSequence);
      return;
    }
    ((TextView)localObject).setVisibility(8);
    this.A.removeView(this.F);
    if (this.g != null)
    {
      paramViewGroup = (ViewGroup)this.A.getParent();
      int i1 = paramViewGroup.indexOfChild(this.A);
      paramViewGroup.removeViewAt(i1);
      paramViewGroup.addView(this.g, i1, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    paramViewGroup.setVisibility(8);
  }
  
  private void v(ViewGroup paramViewGroup)
  {
    View localView = this.h;
    int i1 = 0;
    if (localView == null) {
      if (this.i != 0) {
        localView = LayoutInflater.from(this.a).inflate(this.i, paramViewGroup, false);
      } else {
        localView = null;
      }
    }
    if (localView != null) {
      i1 = 1;
    }
    if ((i1 == 0) || (!a(localView))) {
      this.c.setFlags(131072, 131072);
    }
    if (i1 != 0)
    {
      FrameLayout localFrameLayout = (FrameLayout)this.c.findViewById(R.id.custom);
      localFrameLayout.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      if (this.n) {
        localFrameLayout.setPadding(this.j, this.k, this.l, this.m);
      }
      if (this.g != null) {
        ((LinearLayoutCompat.LayoutParams)paramViewGroup.getLayoutParams()).weight = 0.0F;
      }
    }
    else
    {
      paramViewGroup.setVisibility(8);
    }
  }
  
  private void w(ViewGroup paramViewGroup)
  {
    if (this.G != null)
    {
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
      paramViewGroup.addView(this.G, 0, localLayoutParams);
      this.c.findViewById(R.id.title_template).setVisibility(8);
      return;
    }
    this.D = ((ImageView)this.c.findViewById(16908294));
    if (((TextUtils.isEmpty(this.e) ^ true)) && (this.P))
    {
      paramViewGroup = (TextView)this.c.findViewById(R.id.alertTitle);
      this.E = paramViewGroup;
      paramViewGroup.setText(this.e);
      int i1 = this.B;
      if (i1 != 0)
      {
        this.D.setImageResource(i1);
        return;
      }
      paramViewGroup = this.C;
      if (paramViewGroup != null)
      {
        this.D.setImageDrawable(paramViewGroup);
        return;
      }
      this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
      this.D.setVisibility(8);
      return;
    }
    this.c.findViewById(R.id.title_template).setVisibility(8);
    this.D.setVisibility(8);
    paramViewGroup.setVisibility(8);
  }
  
  private void x()
  {
    Object localObject4 = this.c.findViewById(R.id.parentPanel);
    int i1 = R.id.topPanel;
    Object localObject3 = ((View)localObject4).findViewById(i1);
    int i2 = R.id.contentPanel;
    Object localObject2 = ((View)localObject4).findViewById(i2);
    int i3 = R.id.buttonPanel;
    Object localObject1 = ((View)localObject4).findViewById(i3);
    localObject4 = (ViewGroup)((View)localObject4).findViewById(R.id.customPanel);
    v((ViewGroup)localObject4);
    View localView3 = ((ViewGroup)localObject4).findViewById(i1);
    View localView2 = ((ViewGroup)localObject4).findViewById(i2);
    View localView1 = ((ViewGroup)localObject4).findViewById(i3);
    localObject3 = h(localView3, (View)localObject3);
    localObject2 = h(localView2, (View)localObject2);
    localObject1 = h(localView1, (View)localObject1);
    u((ViewGroup)localObject2);
    t((ViewGroup)localObject1);
    w((ViewGroup)localObject3);
    i1 = ((ViewGroup)localObject4).getVisibility();
    i2 = 0;
    if (i1 != 8) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i4;
    if ((localObject3 != null) && (((ViewGroup)localObject3).getVisibility() != 8)) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    boolean bool;
    if ((localObject1 != null) && (((ViewGroup)localObject1).getVisibility() != 8)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((!bool) && (localObject2 != null))
    {
      localObject1 = ((ViewGroup)localObject2).findViewById(R.id.textSpacerNoButtons);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    if (i4 != 0)
    {
      localObject1 = this.A;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setClipToPadding(true);
      }
      localObject1 = null;
      if ((this.f != null) || (this.g != null)) {
        localObject1 = ((ViewGroup)localObject3).findViewById(R.id.titleDividerNoCustom);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    else if (localObject2 != null)
    {
      localObject1 = ((ViewGroup)localObject2).findViewById(R.id.textSpacerNoTitle);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
    }
    localObject1 = this.g;
    if ((localObject1 instanceof RecycleListView)) {
      ((RecycleListView)localObject1).a(i4, bool);
    }
    if (i1 == 0)
    {
      localObject1 = this.g;
      if (localObject1 == null) {
        localObject1 = this.A;
      }
      if (localObject1 != null)
      {
        i1 = i2;
        if (bool) {
          i1 = 2;
        }
        o((ViewGroup)localObject2, (View)localObject1, i4 | i1, 3);
      }
    }
    localObject1 = this.g;
    if (localObject1 != null)
    {
      localObject2 = this.H;
      if (localObject2 != null)
      {
        ((ListView)localObject1).setAdapter((ListAdapter)localObject2);
        i1 = this.I;
        if (i1 > -1)
        {
          ((ListView)localObject1).setItemChecked(i1, true);
          ((ListView)localObject1).setSelection(i1);
        }
      }
    }
  }
  
  private static boolean y(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, localTypedValue, true);
    return localTypedValue.data != 0;
  }
  
  public int c(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    this.a.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  public ListView d()
  {
    return this.g;
  }
  
  public void e()
  {
    int i1 = i();
    this.b.setContentView(i1);
    x();
  }
  
  public boolean f(int paramInt, KeyEvent paramKeyEvent)
  {
    NestedScrollView localNestedScrollView = this.A;
    return (localNestedScrollView != null) && (localNestedScrollView.q(paramKeyEvent));
  }
  
  public boolean g(int paramInt, KeyEvent paramKeyEvent)
  {
    NestedScrollView localNestedScrollView = this.A;
    return (localNestedScrollView != null) && (localNestedScrollView.q(paramKeyEvent));
  }
  
  public void j(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage, Drawable paramDrawable)
  {
    Message localMessage = paramMessage;
    if (paramMessage == null)
    {
      localMessage = paramMessage;
      if (paramOnClickListener != null) {
        localMessage = this.R.obtainMessage(paramInt, paramOnClickListener);
      }
    }
    if (paramInt != -3)
    {
      if (paramInt != -2)
      {
        if (paramInt == -1)
        {
          this.p = paramCharSequence;
          this.q = localMessage;
          this.r = paramDrawable;
          return;
        }
        throw new IllegalArgumentException("Button does not exist");
      }
      this.t = paramCharSequence;
      this.u = localMessage;
      this.v = paramDrawable;
      return;
    }
    this.x = paramCharSequence;
    this.y = localMessage;
    this.z = paramDrawable;
  }
  
  public void k(View paramView)
  {
    this.G = paramView;
  }
  
  public void l(int paramInt)
  {
    this.C = null;
    this.B = paramInt;
    ImageView localImageView = this.D;
    if (localImageView != null)
    {
      if (paramInt != 0)
      {
        localImageView.setVisibility(0);
        this.D.setImageResource(this.B);
        return;
      }
      localImageView.setVisibility(8);
    }
  }
  
  public void m(Drawable paramDrawable)
  {
    this.C = paramDrawable;
    this.B = 0;
    ImageView localImageView = this.D;
    if (localImageView != null)
    {
      if (paramDrawable != null)
      {
        localImageView.setVisibility(0);
        this.D.setImageDrawable(paramDrawable);
        return;
      }
      localImageView.setVisibility(8);
    }
  }
  
  public void n(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    TextView localTextView = this.F;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void p(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    TextView localTextView = this.E;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void q(int paramInt)
  {
    this.h = null;
    this.i = paramInt;
    this.n = false;
  }
  
  public void r(View paramView)
  {
    this.h = paramView;
    this.i = 0;
    this.n = false;
  }
  
  public void s(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.h = paramView;
    this.i = 0;
    this.n = true;
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
  }
  
  public static class RecycleListView
    extends ListView
  {
    private final int a;
    private final int b;
    
    public RecycleListView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecycleListView);
      this.b = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
      this.a = paramContext.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
    }
    
    public void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((!paramBoolean2) || (!paramBoolean1))
      {
        int k = getPaddingLeft();
        int i;
        if (paramBoolean1) {
          i = getPaddingTop();
        } else {
          i = this.a;
        }
        int m = getPaddingRight();
        int j;
        if (paramBoolean2) {
          j = getPaddingBottom();
        } else {
          j = this.b;
        }
        setPadding(k, i, m, j);
      }
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      AlertController localAlertController = AlertController.this;
      Message localMessage;
      if (paramView == localAlertController.o)
      {
        localMessage = localAlertController.q;
        if (localMessage == null) {}
      }
      for (paramView = localMessage;; paramView = localMessage)
      {
        paramView = Message.obtain(paramView);
        break label81;
        if (paramView != localAlertController.s) {
          break;
        }
        localMessage = localAlertController.u;
        if (localMessage == null) {
          break;
        }
      }
      if (paramView == localAlertController.w)
      {
        paramView = localAlertController.y;
        if (paramView != null)
        {
          paramView = Message.obtain(paramView);
          break label81;
        }
      }
      paramView = null;
      label81:
      if (paramView != null) {
        paramView.sendToTarget();
      }
      paramView = AlertController.this;
      paramView.R.obtainMessage(1, paramView.b).sendToTarget();
    }
  }
  
  public static class b
  {
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean E = false;
    public boolean[] F;
    public boolean G;
    public boolean H;
    public int I = -1;
    public DialogInterface.OnMultiChoiceClickListener J;
    public Cursor K;
    public String L;
    public String M;
    public AdapterView.OnItemSelectedListener N;
    public e O;
    public boolean P = true;
    public final Context a;
    public final LayoutInflater b;
    public int c = 0;
    public Drawable d;
    public int e = 0;
    public CharSequence f;
    public View g;
    public CharSequence h;
    public CharSequence i;
    public Drawable j;
    public DialogInterface.OnClickListener k;
    public CharSequence l;
    public Drawable m;
    public DialogInterface.OnClickListener n;
    public CharSequence o;
    public Drawable p;
    public DialogInterface.OnClickListener q;
    public boolean r;
    public DialogInterface.OnCancelListener s;
    public DialogInterface.OnDismissListener t;
    public DialogInterface.OnKeyListener u;
    public CharSequence[] v;
    public ListAdapter w;
    public DialogInterface.OnClickListener x;
    public int y;
    public View z;
    
    public b(Context paramContext)
    {
      this.a = paramContext;
      this.r = true;
      this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
    
    private void b(final AlertController paramAlertController)
    {
      final AlertController.RecycleListView localRecycleListView = (AlertController.RecycleListView)this.b.inflate(paramAlertController.L, null);
      if (this.G)
      {
        if (this.K == null) {
          localObject = new a(this.a, paramAlertController.M, 16908308, this.v, localRecycleListView);
        } else {
          localObject = new b(this.a, this.K, false, localRecycleListView, paramAlertController);
        }
      }
      else
      {
        int i1;
        if (this.H) {
          i1 = paramAlertController.N;
        } else {
          i1 = paramAlertController.O;
        }
        if (this.K != null)
        {
          localObject = new SimpleCursorAdapter(this.a, i1, this.K, new String[] { this.L }, new int[] { 16908308 });
        }
        else
        {
          localObject = this.w;
          if (localObject == null) {
            localObject = new AlertController.d(this.a, i1, 16908308, this.v);
          }
        }
      }
      e locale = this.O;
      if (locale != null) {
        locale.a(localRecycleListView);
      }
      paramAlertController.H = ((ListAdapter)localObject);
      paramAlertController.I = this.I;
      if (this.x != null) {}
      for (Object localObject = new c(paramAlertController);; localObject = new d(localRecycleListView, paramAlertController))
      {
        localRecycleListView.setOnItemClickListener((AdapterView.OnItemClickListener)localObject);
        break;
        if (this.J == null) {
          break;
        }
      }
      localObject = this.N;
      if (localObject != null) {
        localRecycleListView.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject);
      }
      if (this.H) {
        localRecycleListView.setChoiceMode(1);
      } else if (this.G) {
        localRecycleListView.setChoiceMode(2);
      }
      paramAlertController.g = localRecycleListView;
    }
    
    public void a(AlertController paramAlertController)
    {
      Object localObject = this.g;
      if (localObject != null)
      {
        paramAlertController.k((View)localObject);
      }
      else
      {
        localObject = this.f;
        if (localObject != null) {
          paramAlertController.p((CharSequence)localObject);
        }
        localObject = this.d;
        if (localObject != null) {
          paramAlertController.m((Drawable)localObject);
        }
        i1 = this.c;
        if (i1 != 0) {
          paramAlertController.l(i1);
        }
        i1 = this.e;
        if (i1 != 0) {
          paramAlertController.l(paramAlertController.c(i1));
        }
      }
      localObject = this.h;
      if (localObject != null) {
        paramAlertController.n((CharSequence)localObject);
      }
      localObject = this.i;
      if ((localObject != null) || (this.j != null)) {
        paramAlertController.j(-1, (CharSequence)localObject, this.k, null, this.j);
      }
      localObject = this.l;
      if ((localObject != null) || (this.m != null)) {
        paramAlertController.j(-2, (CharSequence)localObject, this.n, null, this.m);
      }
      localObject = this.o;
      if ((localObject != null) || (this.p != null)) {
        paramAlertController.j(-3, (CharSequence)localObject, this.q, null, this.p);
      }
      if ((this.v != null) || (this.K != null) || (this.w != null)) {
        b(paramAlertController);
      }
      localObject = this.z;
      if (localObject != null)
      {
        if (this.E)
        {
          paramAlertController.s((View)localObject, this.A, this.B, this.C, this.D);
          return;
        }
        paramAlertController.r((View)localObject);
        return;
      }
      int i1 = this.y;
      if (i1 != 0) {
        paramAlertController.q(i1);
      }
    }
    
    class a
      extends ArrayAdapter<CharSequence>
    {
      a(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence, AlertController.RecycleListView paramRecycleListView)
      {
        super(paramInt1, paramInt2, paramArrayOfCharSequence);
      }
      
      public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
      {
        paramView = super.getView(paramInt, paramView, paramViewGroup);
        paramViewGroup = AlertController.b.this.F;
        if ((paramViewGroup != null) && (paramViewGroup[paramInt] != 0)) {
          localRecycleListView.setItemChecked(paramInt, true);
        }
        return paramView;
      }
    }
    
    class b
      extends CursorAdapter
    {
      private final int a;
      private final int b;
      
      b(Context paramContext, Cursor paramCursor, boolean paramBoolean, AlertController.RecycleListView paramRecycleListView, AlertController paramAlertController)
      {
        super(paramCursor, paramBoolean);
        paramContext = getCursor();
        this.a = paramContext.getColumnIndexOrThrow(AlertController.b.this.L);
        this.b = paramContext.getColumnIndexOrThrow(AlertController.b.this.M);
      }
      
      public void bindView(View paramView, Context paramContext, Cursor paramCursor)
      {
        ((CheckedTextView)paramView.findViewById(16908308)).setText(paramCursor.getString(this.a));
        paramView = localRecycleListView;
        int i = paramCursor.getPosition();
        int j = paramCursor.getInt(this.b);
        boolean bool = true;
        if (j != 1) {
          bool = false;
        }
        paramView.setItemChecked(i, bool);
      }
      
      public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
      {
        return AlertController.b.this.b.inflate(paramAlertController.M, paramViewGroup, false);
      }
    }
    
    class c
      implements AdapterView.OnItemClickListener
    {
      c(AlertController paramAlertController) {}
      
      public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
      {
        AlertController.b.this.x.onClick(paramAlertController.b, paramInt);
        if (!AlertController.b.this.H) {
          paramAlertController.b.dismiss();
        }
      }
    }
    
    class d
      implements AdapterView.OnItemClickListener
    {
      d(AlertController.RecycleListView paramRecycleListView, AlertController paramAlertController) {}
      
      public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
      {
        paramAdapterView = AlertController.b.this.F;
        if (paramAdapterView != null) {
          paramAdapterView[paramInt] = localRecycleListView.isItemChecked(paramInt);
        }
        AlertController.b.this.J.onClick(paramAlertController.b, paramInt, localRecycleListView.isItemChecked(paramInt));
      }
    }
    
    public static abstract interface e
    {
      public abstract void a(ListView paramListView);
    }
  }
  
  private static final class c
    extends Handler
  {
    private WeakReference<DialogInterface> a;
    
    public c(DialogInterface paramDialogInterface)
    {
      this.a = new WeakReference(paramDialogInterface);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if ((i != -3) && (i != -2) && (i != -1))
      {
        if (i != 1) {
          return;
        }
        ((DialogInterface)paramMessage.obj).dismiss();
        return;
      }
      ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.a.get(), paramMessage.what);
    }
  }
  
  private static class d
    extends ArrayAdapter<CharSequence>
  {
    public d(Context paramContext, int paramInt1, int paramInt2, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt1, paramInt2, paramArrayOfCharSequence);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.app.AlertController
 * JD-Core Version:    0.7.0.1
 */