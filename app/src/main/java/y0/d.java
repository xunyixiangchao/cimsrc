package y0;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;
import androidx.core.R.id;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d
{
  private static int d;
  private final AccessibilityNodeInfo a;
  public int b = -1;
  private int c = -1;
  
  private d(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.a = paramAccessibilityNodeInfo;
  }
  
  private int A(ClickableSpan paramClickableSpan, SparseArray<WeakReference<ClickableSpan>> paramSparseArray)
  {
    if (paramSparseArray != null)
    {
      i = 0;
      while (i < paramSparseArray.size())
      {
        if (paramClickableSpan.equals((ClickableSpan)((WeakReference)paramSparseArray.valueAt(i)).get())) {
          return paramSparseArray.keyAt(i);
        }
        i += 1;
      }
    }
    int i = d;
    d = i + 1;
    return i;
  }
  
  public static d J0(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    return new d(paramAccessibilityNodeInfo);
  }
  
  public static d O()
  {
    return J0(AccessibilityNodeInfo.obtain());
  }
  
  public static d P(View paramView)
  {
    return J0(AccessibilityNodeInfo.obtain(paramView));
  }
  
  public static d Q(d paramd)
  {
    return J0(AccessibilityNodeInfo.obtain(paramd.a));
  }
  
  private void U(View paramView)
  {
    paramView = w(paramView);
    if (paramView != null)
    {
      ArrayList localArrayList = new ArrayList();
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramView.size()) {
          break;
        }
        if (((WeakReference)paramView.valueAt(i)).get() == null) {
          localArrayList.add(Integer.valueOf(i));
        }
        i += 1;
      }
      while (j < localArrayList.size())
      {
        paramView.remove(((Integer)localArrayList.get(j)).intValue());
        j += 1;
      }
    }
  }
  
  private void W(int paramInt, boolean paramBoolean)
  {
    Bundle localBundle = s();
    if (localBundle != null)
    {
      int j = localBundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
      int i;
      if (paramBoolean) {
        i = paramInt;
      } else {
        i = 0;
      }
      localBundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | j & paramInt);
    }
  }
  
  private void e(ClickableSpan paramClickableSpan, Spanned paramSpanned, int paramInt)
  {
    h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(paramSpanned.getSpanStart(paramClickableSpan)));
    h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(paramSpanned.getSpanEnd(paramClickableSpan)));
    h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(paramSpanned.getSpanFlags(paramClickableSpan)));
    h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(paramInt));
  }
  
  private void g()
  {
    this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
    this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
    this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
    this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
  }
  
  private List<Integer> h(String paramString)
  {
    ArrayList localArrayList2 = this.a.getExtras().getIntegerArrayList(paramString);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.a.getExtras().putIntegerArrayList(paramString, localArrayList1);
    }
    return localArrayList1;
  }
  
  private static String j(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            switch (paramInt)
            {
            default: 
              return "ACTION_UNKNOWN";
            case 16908362: 
              return "ACTION_PRESS_AND_HOLD";
            case 16908361: 
              return "ACTION_PAGE_RIGHT";
            case 16908360: 
              return "ACTION_PAGE_LEFT";
            case 16908359: 
              return "ACTION_PAGE_DOWN";
            case 16908358: 
              return "ACTION_PAGE_UP";
            case 16908357: 
              return "ACTION_HIDE_TOOLTIP";
            }
            return "ACTION_SHOW_TOOLTIP";
          case 16908349: 
            return "ACTION_SET_PROGRESS";
          case 16908348: 
            return "ACTION_CONTEXT_CLICK";
          case 16908347: 
            return "ACTION_SCROLL_RIGHT";
          case 16908346: 
            return "ACTION_SCROLL_DOWN";
          case 16908345: 
            return "ACTION_SCROLL_LEFT";
          case 16908344: 
            return "ACTION_SCROLL_UP";
          case 16908343: 
            return "ACTION_SCROLL_TO_POSITION";
          }
          return "ACTION_SHOW_ON_SCREEN";
        case 16908372: 
          return "ACTION_IME_ENTER";
        case 16908354: 
          return "ACTION_MOVE_WINDOW";
        case 2097152: 
          return "ACTION_SET_TEXT";
        case 524288: 
          return "ACTION_COLLAPSE";
        case 262144: 
          return "ACTION_EXPAND";
        case 131072: 
          return "ACTION_SET_SELECTION";
        case 65536: 
          return "ACTION_CUT";
        case 32768: 
          return "ACTION_PASTE";
        case 16384: 
          return "ACTION_COPY";
        case 8192: 
          return "ACTION_SCROLL_BACKWARD";
        case 4096: 
          return "ACTION_SCROLL_FORWARD";
        case 2048: 
          return "ACTION_PREVIOUS_HTML_ELEMENT";
        case 1024: 
          return "ACTION_NEXT_HTML_ELEMENT";
        case 512: 
          return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
        case 256: 
          return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
        case 128: 
          return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
        case 64: 
          return "ACTION_ACCESSIBILITY_FOCUS";
        case 32: 
          return "ACTION_LONG_CLICK";
        case 16: 
          return "ACTION_CLICK";
        case 8: 
          return "ACTION_CLEAR_SELECTION";
        }
        return "ACTION_SELECT";
      }
      return "ACTION_CLEAR_FOCUS";
    }
    return "ACTION_FOCUS";
  }
  
  private boolean l(int paramInt)
  {
    Bundle localBundle = s();
    boolean bool = false;
    if (localBundle == null) {
      return false;
    }
    if ((localBundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & paramInt) == paramInt) {
      bool = true;
    }
    return bool;
  }
  
  public static ClickableSpan[] q(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof Spanned)) {
      return (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
    }
    return null;
  }
  
  private SparseArray<WeakReference<ClickableSpan>> u(View paramView)
  {
    SparseArray localSparseArray2 = w(paramView);
    SparseArray localSparseArray1 = localSparseArray2;
    if (localSparseArray2 == null)
    {
      localSparseArray1 = new SparseArray();
      paramView.setTag(R.id.tag_accessibility_clickable_spans, localSparseArray1);
    }
    return localSparseArray1;
  }
  
  private SparseArray<WeakReference<ClickableSpan>> w(View paramView)
  {
    return (SparseArray)paramView.getTag(R.id.tag_accessibility_clickable_spans);
  }
  
  private boolean z()
  {
    return h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty() ^ true;
  }
  
  public void A0(boolean paramBoolean)
  {
    this.a.setSelected(paramBoolean);
  }
  
  public boolean B()
  {
    return this.a.isAccessibilityFocused();
  }
  
  public void B0(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.a.setShowingHintText(paramBoolean);
      return;
    }
    W(4, paramBoolean);
  }
  
  public boolean C()
  {
    return this.a.isCheckable();
  }
  
  public void C0(View paramView)
  {
    this.c = -1;
    this.a.setSource(paramView);
  }
  
  public boolean D()
  {
    return this.a.isChecked();
  }
  
  public void D0(View paramView, int paramInt)
  {
    this.c = paramInt;
    this.a.setSource(paramView, paramInt);
  }
  
  public boolean E()
  {
    return this.a.isClickable();
  }
  
  public void E0(CharSequence paramCharSequence)
  {
    if (u0.a.b())
    {
      this.a.setStateDescription(paramCharSequence);
      return;
    }
    this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", paramCharSequence);
  }
  
  public boolean F()
  {
    return this.a.isEnabled();
  }
  
  public void F0(CharSequence paramCharSequence)
  {
    this.a.setText(paramCharSequence);
  }
  
  public boolean G()
  {
    return this.a.isFocusable();
  }
  
  public void G0(View paramView)
  {
    this.a.setTraversalAfter(paramView);
  }
  
  public boolean H()
  {
    return this.a.isFocused();
  }
  
  public void H0(boolean paramBoolean)
  {
    this.a.setVisibleToUser(paramBoolean);
  }
  
  public boolean I()
  {
    return this.a.isLongClickable();
  }
  
  public AccessibilityNodeInfo I0()
  {
    return this.a;
  }
  
  public boolean J()
  {
    return this.a.isPassword();
  }
  
  public boolean K()
  {
    return this.a.isScrollable();
  }
  
  public boolean L()
  {
    return this.a.isSelected();
  }
  
  public boolean M()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return this.a.isShowingHintText();
    }
    return l(4);
  }
  
  public boolean N()
  {
    return this.a.isVisibleToUser();
  }
  
  public boolean R(int paramInt, Bundle paramBundle)
  {
    return this.a.performAction(paramInt, paramBundle);
  }
  
  public void S()
  {
    this.a.recycle();
  }
  
  public boolean T(a parama)
  {
    return this.a.removeAction((AccessibilityNodeInfo.AccessibilityAction)parama.a);
  }
  
  public void V(boolean paramBoolean)
  {
    this.a.setAccessibilityFocused(paramBoolean);
  }
  
  @Deprecated
  public void X(Rect paramRect)
  {
    this.a.setBoundsInParent(paramRect);
  }
  
  public void Y(Rect paramRect)
  {
    this.a.setBoundsInScreen(paramRect);
  }
  
  public void Z(boolean paramBoolean)
  {
    this.a.setCanOpenPopup(paramBoolean);
  }
  
  public void a(int paramInt)
  {
    this.a.addAction(paramInt);
  }
  
  public void a0(boolean paramBoolean)
  {
    this.a.setCheckable(paramBoolean);
  }
  
  public void b(a parama)
  {
    this.a.addAction((AccessibilityNodeInfo.AccessibilityAction)parama.a);
  }
  
  public void b0(boolean paramBoolean)
  {
    this.a.setChecked(paramBoolean);
  }
  
  public void c(View paramView)
  {
    this.a.addChild(paramView);
  }
  
  public void c0(CharSequence paramCharSequence)
  {
    this.a.setClassName(paramCharSequence);
  }
  
  public void d(View paramView, int paramInt)
  {
    this.a.addChild(paramView, paramInt);
  }
  
  public void d0(boolean paramBoolean)
  {
    this.a.setClickable(paramBoolean);
  }
  
  public void e0(Object paramObject)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = this.a;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = (AccessibilityNodeInfo.CollectionInfo)((b)paramObject).a;
    }
    localAccessibilityNodeInfo.setCollectionInfo(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof d)) {
      return false;
    }
    paramObject = (d)paramObject;
    AccessibilityNodeInfo localAccessibilityNodeInfo = this.a;
    if (localAccessibilityNodeInfo == null)
    {
      if (paramObject.a != null) {
        return false;
      }
    }
    else if (!localAccessibilityNodeInfo.equals(paramObject.a)) {
      return false;
    }
    if (this.c != paramObject.c) {
      return false;
    }
    return this.b == paramObject.b;
  }
  
  public void f(CharSequence paramCharSequence, View paramView)
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      g();
      U(paramView);
      ClickableSpan[] arrayOfClickableSpan = q(paramCharSequence);
      if ((arrayOfClickableSpan != null) && (arrayOfClickableSpan.length > 0))
      {
        s().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
        paramView = u(paramView);
        int i = 0;
        while (i < arrayOfClickableSpan.length)
        {
          int j = A(arrayOfClickableSpan[i], paramView);
          paramView.put(j, new WeakReference(arrayOfClickableSpan[i]));
          e(arrayOfClickableSpan[i], (Spanned)paramCharSequence, j);
          i += 1;
        }
      }
    }
  }
  
  public void f0(Object paramObject)
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = this.a;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = (AccessibilityNodeInfo.CollectionItemInfo)((c)paramObject).a;
    }
    localAccessibilityNodeInfo.setCollectionItemInfo(paramObject);
  }
  
  public void g0(CharSequence paramCharSequence)
  {
    this.a.setContentDescription(paramCharSequence);
  }
  
  public void h0(boolean paramBoolean)
  {
    this.a.setDismissable(paramBoolean);
  }
  
  public int hashCode()
  {
    AccessibilityNodeInfo localAccessibilityNodeInfo = this.a;
    if (localAccessibilityNodeInfo == null) {
      return 0;
    }
    return localAccessibilityNodeInfo.hashCode();
  }
  
  public List<a> i()
  {
    List localList = this.a.getActionList();
    if (localList != null)
    {
      ArrayList localArrayList = new ArrayList();
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(new a(localList.get(i)));
        i += 1;
      }
      return localArrayList;
    }
    return Collections.emptyList();
  }
  
  public void i0(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
  }
  
  public void j0(CharSequence paramCharSequence)
  {
    this.a.setError(paramCharSequence);
  }
  
  public int k()
  {
    return this.a.getActions();
  }
  
  public void k0(boolean paramBoolean)
  {
    this.a.setFocusable(paramBoolean);
  }
  
  public void l0(boolean paramBoolean)
  {
    this.a.setFocused(paramBoolean);
  }
  
  @Deprecated
  public void m(Rect paramRect)
  {
    this.a.getBoundsInParent(paramRect);
  }
  
  public void m0(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.a.setHeading(paramBoolean);
      return;
    }
    W(2, paramBoolean);
  }
  
  public void n(Rect paramRect)
  {
    this.a.getBoundsInScreen(paramRect);
  }
  
  public void n0(CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.a.setHintText(paramCharSequence);
      return;
    }
    this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", paramCharSequence);
  }
  
  public int o()
  {
    return this.a.getChildCount();
  }
  
  public void o0(View paramView)
  {
    this.a.setLabelFor(paramView);
  }
  
  public CharSequence p()
  {
    return this.a.getClassName();
  }
  
  public void p0(boolean paramBoolean)
  {
    this.a.setLongClickable(paramBoolean);
  }
  
  public void q0(int paramInt)
  {
    this.a.setMaxTextLength(paramInt);
  }
  
  public CharSequence r()
  {
    return this.a.getContentDescription();
  }
  
  public void r0(int paramInt)
  {
    this.a.setMovementGranularities(paramInt);
  }
  
  public Bundle s()
  {
    return this.a.getExtras();
  }
  
  public void s0(CharSequence paramCharSequence)
  {
    this.a.setPackageName(paramCharSequence);
  }
  
  public int t()
  {
    return this.a.getMovementGranularities();
  }
  
  public void t0(CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.a.setPaneTitle(paramCharSequence);
      return;
    }
    this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", paramCharSequence);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    Object localObject1 = new Rect();
    m((Rect)localObject1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("; boundsInParent: ");
    ((StringBuilder)localObject2).append(localObject1);
    localStringBuilder.append(((StringBuilder)localObject2).toString());
    n((Rect)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("; boundsInScreen: ");
    ((StringBuilder)localObject2).append(localObject1);
    localStringBuilder.append(((StringBuilder)localObject2).toString());
    localStringBuilder.append("; packageName: ");
    localStringBuilder.append(v());
    localStringBuilder.append("; className: ");
    localStringBuilder.append(p());
    localStringBuilder.append("; text: ");
    localStringBuilder.append(x());
    localStringBuilder.append("; contentDescription: ");
    localStringBuilder.append(r());
    localStringBuilder.append("; viewId: ");
    localStringBuilder.append(y());
    localStringBuilder.append("; checkable: ");
    localStringBuilder.append(C());
    localStringBuilder.append("; checked: ");
    localStringBuilder.append(D());
    localStringBuilder.append("; focusable: ");
    localStringBuilder.append(G());
    localStringBuilder.append("; focused: ");
    localStringBuilder.append(H());
    localStringBuilder.append("; selected: ");
    localStringBuilder.append(L());
    localStringBuilder.append("; clickable: ");
    localStringBuilder.append(E());
    localStringBuilder.append("; longClickable: ");
    localStringBuilder.append(I());
    localStringBuilder.append("; enabled: ");
    localStringBuilder.append(F());
    localStringBuilder.append("; password: ");
    localStringBuilder.append(J());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("; scrollable: ");
    ((StringBuilder)localObject1).append(K());
    localStringBuilder.append(((StringBuilder)localObject1).toString());
    localStringBuilder.append("; [");
    List localList = i();
    int i = 0;
    while (i < localList.size())
    {
      a locala = (a)localList.get(i);
      localObject2 = j(locala.b());
      localObject1 = localObject2;
      if (((String)localObject2).equals("ACTION_UNKNOWN"))
      {
        localObject1 = localObject2;
        if (locala.c() != null) {
          localObject1 = locala.c().toString();
        }
      }
      localStringBuilder.append((String)localObject1);
      if (i != localList.size() - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void u0(View paramView)
  {
    this.b = -1;
    this.a.setParent(paramView);
  }
  
  public CharSequence v()
  {
    return this.a.getPackageName();
  }
  
  public void v0(View paramView, int paramInt)
  {
    this.b = paramInt;
    this.a.setParent(paramView, paramInt);
  }
  
  public void w0(d paramd)
  {
    this.a.setRangeInfo((AccessibilityNodeInfo.RangeInfo)paramd.a);
  }
  
  public CharSequence x()
  {
    if (z())
    {
      List localList1 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
      List localList2 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
      List localList3 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
      List localList4 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
      Object localObject = this.a.getText();
      int j = this.a.getText().length();
      int i = 0;
      localObject = new SpannableString(TextUtils.substring((CharSequence)localObject, 0, j));
      while (i < localList1.size())
      {
        ((Spannable)localObject).setSpan(new a(((Integer)localList4.get(i)).intValue(), this, s().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer)localList1.get(i)).intValue(), ((Integer)localList2.get(i)).intValue(), ((Integer)localList3.get(i)).intValue());
        i += 1;
      }
      return localObject;
    }
    return this.a.getText();
  }
  
  public void x0(CharSequence paramCharSequence)
  {
    this.a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", paramCharSequence);
  }
  
  public String y()
  {
    return this.a.getViewIdResourceName();
  }
  
  public void y0(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.a.setScreenReaderFocusable(paramBoolean);
      return;
    }
    W(1, paramBoolean);
  }
  
  public void z0(boolean paramBoolean)
  {
    this.a.setScrollable(paramBoolean);
  }
  
  public static class a
  {
    public static final a A;
    public static final a B;
    public static final a C;
    public static final a D;
    public static final a E;
    public static final a F;
    public static final a G;
    public static final a H;
    public static final a I;
    public static final a J;
    public static final a K;
    public static final a L;
    public static final a M;
    public static final a N;
    public static final a O;
    public static final a P;
    public static final a Q;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    public static final a l;
    public static final a m;
    public static final a n;
    public static final a o;
    public static final a p;
    public static final a q;
    public static final a r;
    public static final a s;
    public static final a t;
    public static final a u;
    public static final a v;
    public static final a w;
    public static final a x;
    public static final a y;
    public static final a z;
    final Object a;
    private final int b;
    private final Class<? extends g.a> c;
    protected final g d;
    
    static
    {
      Object localObject2 = null;
      e = new a(1, null);
      f = new a(2, null);
      g = new a(4, null);
      h = new a(8, null);
      i = new a(16, null);
      j = new a(32, null);
      k = new a(64, null);
      l = new a(128, null);
      m = new a(256, null, g.b.class);
      n = new a(512, null, g.b.class);
      o = new a(1024, null, g.c.class);
      p = new a(2048, null, g.c.class);
      q = new a(4096, null);
      r = new a(8192, null);
      s = new a(16384, null);
      t = new a(32768, null);
      u = new a(65536, null);
      v = new a(131072, null, g.g.class);
      w = new a(262144, null);
      x = new a(524288, null);
      y = new a(1048576, null);
      z = new a(2097152, null, g.h.class);
      int i1 = Build.VERSION.SDK_INT;
      A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, null, null, null);
      B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, null, null, g.e.class);
      C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, null, null, null);
      D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, null, null, null);
      E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, null, null, null);
      F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, null, null, null);
      if (i1 >= 29) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
      } else {
        localObject1 = null;
      }
      G = new a(localObject1, 16908358, null, null, null);
      if (i1 >= 29) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
      } else {
        localObject1 = null;
      }
      H = new a(localObject1, 16908359, null, null, null);
      if (i1 >= 29) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
      } else {
        localObject1 = null;
      }
      I = new a(localObject1, 16908360, null, null, null);
      if (i1 >= 29) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
      } else {
        localObject1 = null;
      }
      J = new a(localObject1, 16908361, null, null, null);
      K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, null, null, null);
      if (i1 >= 24) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
      } else {
        localObject1 = null;
      }
      L = new a(localObject1, 16908349, null, null, g.f.class);
      if (i1 >= 26) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
      } else {
        localObject1 = null;
      }
      M = new a(localObject1, 16908354, null, null, g.d.class);
      if (i1 >= 28) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
      } else {
        localObject1 = null;
      }
      N = new a(localObject1, 16908356, null, null, null);
      if (i1 >= 28) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
      } else {
        localObject1 = null;
      }
      O = new a(localObject1, 16908357, null, null, null);
      if (i1 >= 30) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
      } else {
        localObject1 = null;
      }
      P = new a(localObject1, 16908362, null, null, null);
      Object localObject1 = localObject2;
      if (i1 >= 30) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
      }
      Q = new a(localObject1, 16908372, null, null, null);
    }
    
    public a(int paramInt, CharSequence paramCharSequence)
    {
      this(null, paramInt, paramCharSequence, null, null);
    }
    
    private a(int paramInt, CharSequence paramCharSequence, Class<? extends g.a> paramClass)
    {
      this(null, paramInt, paramCharSequence, null, paramClass);
    }
    
    public a(int paramInt, CharSequence paramCharSequence, g paramg)
    {
      this(null, paramInt, paramCharSequence, paramg, null);
    }
    
    a(Object paramObject)
    {
      this(paramObject, 0, null, null, null);
    }
    
    a(Object paramObject, int paramInt, CharSequence paramCharSequence, g paramg, Class<? extends g.a> paramClass)
    {
      this.b = paramInt;
      this.d = paramg;
      paramg = paramObject;
      if (paramObject == null) {
        paramg = new AccessibilityNodeInfo.AccessibilityAction(paramInt, paramCharSequence);
      }
      this.a = paramg;
      this.c = paramClass;
    }
    
    public a a(CharSequence paramCharSequence, g paramg)
    {
      return new a(null, this.b, paramCharSequence, paramg, this.c);
    }
    
    public int b()
    {
      return ((AccessibilityNodeInfo.AccessibilityAction)this.a).getId();
    }
    
    public CharSequence c()
    {
      return ((AccessibilityNodeInfo.AccessibilityAction)this.a).getLabel();
    }
    
    public boolean d(View paramView, Bundle paramBundle)
    {
      if (this.d != null)
      {
        Object localObject1 = null;
        Object localObject2 = null;
        Object localObject4 = this.c;
        Bundle localBundle;
        if (localObject4 != null)
        {
          try
          {
            localObject1 = (g.a)((Class)localObject4).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            try
            {
              ((g.a)localObject1).a(paramBundle);
            }
            catch (Exception localException2)
            {
              paramBundle = (Bundle)localObject1;
              localObject1 = localException2;
            }
            localObject3 = this.c;
          }
          catch (Exception localException1)
          {
            paramBundle = localException2;
          }
          Object localObject3;
          if (localObject3 == null) {
            localObject3 = "null";
          } else {
            localObject3 = ((Class)localObject3).getName();
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("Failed to execute command with argument class ViewCommandArgument: ");
          ((StringBuilder)localObject4).append((String)localObject3);
          Log.e("A11yActionCompat", ((StringBuilder)localObject4).toString(), localException1);
          localBundle = paramBundle;
        }
        return this.d.a(paramView, localBundle);
      }
      return false;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      Object localObject = (a)paramObject;
      paramObject = this.a;
      localObject = ((a)localObject).a;
      if (paramObject == null)
      {
        if (localObject != null) {
          return false;
        }
      }
      else if (!paramObject.equals(localObject)) {
        return false;
      }
      return true;
    }
    
    public int hashCode()
    {
      Object localObject = this.a;
      if (localObject != null) {
        return localObject.hashCode();
      }
      return 0;
    }
  }
  
  public static class b
  {
    final Object a;
    
    b(Object paramObject)
    {
      this.a = paramObject;
    }
    
    public static b a(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      return new b(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean));
    }
    
    public static b b(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    {
      return new b(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean, paramInt3));
    }
  }
  
  public static class c
  {
    final Object a;
    
    c(Object paramObject)
    {
      this.a = paramObject;
    }
    
    public static c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new c(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean1, paramBoolean2));
    }
  }
  
  public static class d
  {
    final Object a;
    
    d(Object paramObject)
    {
      this.a = paramObject;
    }
    
    public static d a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    {
      return new d(AccessibilityNodeInfo.RangeInfo.obtain(paramInt, paramFloat1, paramFloat2, paramFloat3));
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y0.d
 * JD-Core Version:    0.7.0.1
 */