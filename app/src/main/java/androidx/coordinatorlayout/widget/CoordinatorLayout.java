package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.coordinatorlayout.R.attr;
import androidx.coordinatorlayout.R.style;
import androidx.coordinatorlayout.R.styleable;
import androidx.core.view.h0;
import androidx.core.view.o;
import androidx.core.view.p;
import androidx.core.view.q;
import androidx.core.view.r;
import androidx.core.view.x;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import x0.c;
import x0.g;

public class CoordinatorLayout
  extends ViewGroup
  implements o, p
{
  static final String u;
  static final Class<?>[] v = { Context.class, AttributeSet.class };
  static final ThreadLocal<Map<String, Constructor<Behavior>>> w = new ThreadLocal();
  static final Comparator<View> x;
  private static final x0.e<Rect> y = new g(12);
  private final List<View> a = new ArrayList();
  private final a<View> b = new a();
  private final List<View> c = new ArrayList();
  private final List<View> d = new ArrayList();
  private Paint e;
  private final int[] f = new int[2];
  private final int[] g = new int[2];
  private boolean h;
  private boolean i;
  private int[] j;
  private View k;
  private View l;
  private f m;
  private boolean n;
  private h0 o;
  private boolean p;
  private Drawable q;
  ViewGroup.OnHierarchyChangeListener r;
  private r s;
  private final q t = new q(this);
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null) {
      localObject = ((Package)localObject).getName();
    } else {
      localObject = null;
    }
    u = (String)localObject;
    x = new g();
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.coordinatorLayoutStyle);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    int i1 = 0;
    Object localObject = R.styleable.CoordinatorLayout;
    if (paramInt == 0) {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, 0, R.style.Widget_Support_CoordinatorLayout);
    } else {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
    }
    if (Build.VERSION.SDK_INT >= 29)
    {
      int[] arrayOfInt = R.styleable.CoordinatorLayout;
      if (paramInt == 0) {
        saveAttributeDataForStyleable(paramContext, arrayOfInt, paramAttributeSet, (TypedArray)localObject, 0, R.style.Widget_Support_CoordinatorLayout);
      } else {
        saveAttributeDataForStyleable(paramContext, arrayOfInt, paramAttributeSet, (TypedArray)localObject, paramInt, 0);
      }
    }
    paramInt = ((TypedArray)localObject).getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
    if (paramInt != 0)
    {
      paramContext = paramContext.getResources();
      this.j = paramContext.getIntArray(paramInt);
      float f1 = paramContext.getDisplayMetrics().density;
      int i2 = this.j.length;
      paramInt = i1;
      while (paramInt < i2)
      {
        paramContext = this.j;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f1));
        paramInt += 1;
      }
    }
    this.q = ((TypedArray)localObject).getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
    ((TypedArray)localObject).recycle();
    b0();
    super.setOnHierarchyChangeListener(new d());
    if (x.z(this) == 0) {
      x.B0(this, 1);
    }
  }
  
  private int A(int paramInt)
  {
    Object localObject = this.j;
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No keylines defined for ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" - attempted index lookup ");
      ((StringBuilder)localObject).append(paramInt);
    }
    for (;;)
    {
      Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString());
      return 0;
      if ((paramInt >= 0) && (paramInt < localObject.length)) {
        return localObject[paramInt];
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Keyline index ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" out of range for ");
      ((StringBuilder)localObject).append(this);
    }
  }
  
  private void D(List<View> paramList)
  {
    paramList.clear();
    boolean bool = isChildrenDrawingOrderEnabled();
    int i3 = getChildCount();
    int i1 = i3 - 1;
    while (i1 >= 0)
    {
      int i2;
      if (bool) {
        i2 = getChildDrawingOrder(i3, i1);
      } else {
        i2 = i1;
      }
      paramList.add(getChildAt(i2));
      i1 -= 1;
    }
    Comparator localComparator = x;
    if (localComparator != null) {
      Collections.sort(paramList, localComparator);
    }
  }
  
  private boolean E(View paramView)
  {
    return this.b.j(paramView);
  }
  
  private void G(View paramView, int paramInt)
  {
    e locale = (e)paramView.getLayoutParams();
    Rect localRect1 = a();
    localRect1.set(getPaddingLeft() + locale.leftMargin, getPaddingTop() + locale.topMargin, getWidth() - getPaddingRight() - locale.rightMargin, getHeight() - getPaddingBottom() - locale.bottomMargin);
    if ((this.o != null) && (x.y(this)) && (!x.y(paramView)))
    {
      localRect1.left += this.o.j();
      localRect1.top += this.o.l();
      localRect1.right -= this.o.k();
      localRect1.bottom -= this.o.i();
    }
    Rect localRect2 = a();
    androidx.core.view.e.a(W(locale.c), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect1, localRect2, paramInt);
    paramView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
    S(localRect1);
    S(localRect2);
  }
  
  private void H(View paramView1, View paramView2, int paramInt)
  {
    Rect localRect1 = a();
    Rect localRect2 = a();
    try
    {
      x(paramView2, localRect1);
      y(paramView1, paramInt, localRect1, localRect2);
      paramView1.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
      return;
    }
    finally
    {
      S(localRect1);
      S(localRect2);
    }
  }
  
  private void I(View paramView, int paramInt1, int paramInt2)
  {
    e locale = (e)paramView.getLayoutParams();
    int i1 = androidx.core.view.e.b(X(locale.c), paramInt2);
    int i7 = i1 & 0x7;
    int i6 = i1 & 0x70;
    int i5 = getWidth();
    int i4 = getHeight();
    int i2 = paramView.getMeasuredWidth();
    int i3 = paramView.getMeasuredHeight();
    i1 = paramInt1;
    if (paramInt2 == 1) {
      i1 = i5 - paramInt1;
    }
    paramInt1 = A(i1) - i2;
    paramInt2 = 0;
    if (i7 != 1)
    {
      if (i7 == 5) {
        paramInt1 += i2;
      }
    }
    else {
      paramInt1 += i2 / 2;
    }
    if (i6 != 16)
    {
      if (i6 == 80) {
        paramInt2 = i3 + 0;
      }
    }
    else {
      paramInt2 = 0 + i3 / 2;
    }
    paramInt1 = Math.max(getPaddingLeft() + locale.leftMargin, Math.min(paramInt1, i5 - getPaddingRight() - i2 - locale.rightMargin));
    paramInt2 = Math.max(getPaddingTop() + locale.topMargin, Math.min(paramInt2, i4 - getPaddingBottom() - i3 - locale.bottomMargin));
    paramView.layout(paramInt1, paramInt2, i2 + paramInt1, i3 + paramInt2);
  }
  
  private void J(View paramView, Rect paramRect, int paramInt)
  {
    if (!x.U(paramView)) {
      return;
    }
    if (paramView.getWidth() > 0)
    {
      if (paramView.getHeight() <= 0) {
        return;
      }
      e locale = (e)paramView.getLayoutParams();
      Behavior localBehavior = locale.f();
      Rect localRect1 = a();
      Rect localRect2 = a();
      localRect2.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      if ((localBehavior != null) && (localBehavior.b(this, paramView, localRect1)))
      {
        if (!localRect2.contains(localRect1))
        {
          paramView = new StringBuilder();
          paramView.append("Rect should be within the child's bounds. Rect:");
          paramView.append(localRect1.toShortString());
          paramView.append(" | Bounds:");
          paramView.append(localRect2.toShortString());
          throw new IllegalArgumentException(paramView.toString());
        }
      }
      else {
        localRect1.set(localRect2);
      }
      S(localRect2);
      if (localRect1.isEmpty())
      {
        S(localRect1);
        return;
      }
      int i3 = androidx.core.view.e.b(locale.h, paramInt);
      int i2 = 1;
      if ((i3 & 0x30) == 48)
      {
        paramInt = localRect1.top - locale.topMargin - locale.j;
        i1 = paramRect.top;
        if (paramInt < i1)
        {
          Z(paramView, i1 - paramInt);
          paramInt = 1;
          break label252;
        }
      }
      paramInt = 0;
      label252:
      int i1 = paramInt;
      if ((i3 & 0x50) == 80)
      {
        int i4 = getHeight() - localRect1.bottom - locale.bottomMargin + locale.j;
        int i5 = paramRect.bottom;
        i1 = paramInt;
        if (i4 < i5)
        {
          Z(paramView, i4 - i5);
          i1 = 1;
        }
      }
      if (i1 == 0) {
        Z(paramView, 0);
      }
      if ((i3 & 0x3) == 3)
      {
        paramInt = localRect1.left - locale.leftMargin - locale.i;
        i1 = paramRect.left;
        if (paramInt < i1)
        {
          Y(paramView, i1 - paramInt);
          paramInt = 1;
          break label383;
        }
      }
      paramInt = 0;
      label383:
      if ((i3 & 0x5) == 5)
      {
        i1 = getWidth() - localRect1.right - locale.rightMargin + locale.i;
        i3 = paramRect.right;
        if (i1 < i3)
        {
          Y(paramView, i1 - i3);
          paramInt = i2;
        }
      }
      if (paramInt == 0) {
        Y(paramView, 0);
      }
      S(localRect1);
    }
  }
  
  static Behavior O(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (paramString.startsWith("."))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getPackageName());
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else if (paramString.indexOf('.') >= 0)
    {
      localObject1 = paramString;
    }
    else
    {
      localObject2 = u;
      localObject1 = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append('.');
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    try
    {
      Object localObject3 = w;
      localObject2 = (Map)((ThreadLocal)localObject3).get();
      paramString = (String)localObject2;
      if (localObject2 == null)
      {
        paramString = new HashMap();
        ((ThreadLocal)localObject3).set(paramString);
      }
      localObject3 = (Constructor)paramString.get(localObject1);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = Class.forName((String)localObject1, false, paramContext.getClassLoader()).getConstructor(v);
        ((Constructor)localObject2).setAccessible(true);
        paramString.put(localObject1, localObject2);
      }
      paramContext = (Behavior)((Constructor)localObject2).newInstance(new Object[] { paramContext, paramAttributeSet });
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramAttributeSet = new StringBuilder();
      paramAttributeSet.append("Could not inflate Behavior subclass ");
      paramAttributeSet.append((String)localObject1);
      throw new RuntimeException(paramAttributeSet.toString(), paramContext);
    }
  }
  
  private boolean P(MotionEvent paramMotionEvent, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void Q()
  {
    this.a.clear();
    this.b.c();
    int i3 = getChildCount();
    int i1 = 0;
    while (i1 < i3)
    {
      View localView1 = getChildAt(i1);
      e locale = C(localView1);
      locale.d(this, localView1);
      this.b.b(localView1);
      int i2 = 0;
      while (i2 < i3)
      {
        if (i2 != i1)
        {
          View localView2 = getChildAt(i2);
          if (locale.b(this, localView1, localView2))
          {
            if (!this.b.d(localView2)) {
              this.b.b(localView2);
            }
            this.b.a(localView2, localView1);
          }
        }
        i2 += 1;
      }
      i1 += 1;
    }
    this.a.addAll(this.b.i());
    Collections.reverse(this.a);
  }
  
  private static void S(Rect paramRect)
  {
    paramRect.setEmpty();
    y.a(paramRect);
  }
  
  private void U(boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      Behavior localBehavior = ((e)localView.getLayoutParams()).f();
      if (localBehavior != null)
      {
        long l1 = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        if (paramBoolean) {
          localBehavior.k(this, localView, localMotionEvent);
        } else {
          localBehavior.D(this, localView, localMotionEvent);
        }
        localMotionEvent.recycle();
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < i2)
    {
      ((e)getChildAt(i1).getLayoutParams()).m();
      i1 += 1;
    }
    this.k = null;
    this.h = false;
  }
  
  private static int V(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = 17;
    }
    return i1;
  }
  
  private static int W(int paramInt)
  {
    int i1 = paramInt;
    if ((paramInt & 0x7) == 0) {
      i1 = paramInt | 0x800003;
    }
    paramInt = i1;
    if ((i1 & 0x70) == 0) {
      paramInt = i1 | 0x30;
    }
    return paramInt;
  }
  
  private static int X(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == 0) {
      i1 = 8388661;
    }
    return i1;
  }
  
  private void Y(View paramView, int paramInt)
  {
    e locale = (e)paramView.getLayoutParams();
    int i1 = locale.i;
    if (i1 != paramInt)
    {
      x.a0(paramView, paramInt - i1);
      locale.i = paramInt;
    }
  }
  
  private void Z(View paramView, int paramInt)
  {
    e locale = (e)paramView.getLayoutParams();
    int i1 = locale.j;
    if (i1 != paramInt)
    {
      x.b0(paramView, paramInt - i1);
      locale.j = paramInt;
    }
  }
  
  private static Rect a()
  {
    Rect localRect2 = (Rect)y.b();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  private void b0()
  {
    if (x.y(this))
    {
      if (this.s == null) {
        this.s = new a();
      }
      x.E0(this, this.s);
      setSystemUiVisibility(1280);
      return;
    }
    x.E0(this, null);
  }
  
  private static int h(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  private void k(e parame, Rect paramRect, int paramInt1, int paramInt2)
  {
    int i2 = getWidth();
    int i1 = getHeight();
    i2 = Math.max(getPaddingLeft() + parame.leftMargin, Math.min(paramRect.left, i2 - getPaddingRight() - paramInt1 - parame.rightMargin));
    i1 = Math.max(getPaddingTop() + parame.topMargin, Math.min(paramRect.top, i1 - getPaddingBottom() - paramInt2 - parame.bottomMargin));
    paramRect.set(i2, i1, paramInt1 + i2, paramInt2 + i1);
  }
  
  private h0 l(h0 paramh0)
  {
    if (paramh0.p()) {
      return paramh0;
    }
    int i1 = 0;
    int i2 = getChildCount();
    for (h0 localh0 = paramh0; i1 < i2; localh0 = paramh0)
    {
      View localView = getChildAt(i1);
      paramh0 = localh0;
      if (x.y(localView))
      {
        Behavior localBehavior = ((e)localView.getLayoutParams()).f();
        paramh0 = localh0;
        if (localBehavior != null)
        {
          localh0 = localBehavior.f(this, localView, localh0);
          paramh0 = localh0;
          if (localh0.p()) {
            return localh0;
          }
        }
      }
      i1 += 1;
    }
    return localh0;
  }
  
  private void z(View paramView, int paramInt1, Rect paramRect1, Rect paramRect2, e parame, int paramInt2, int paramInt3)
  {
    int i1 = androidx.core.view.e.b(V(parame.c), paramInt1);
    paramInt1 = androidx.core.view.e.b(W(parame.d), paramInt1);
    int i4 = i1 & 0x7;
    int i3 = i1 & 0x70;
    int i2 = paramInt1 & 0x7;
    i1 = paramInt1 & 0x70;
    if (i2 != 1)
    {
      if (i2 != 5) {
        paramInt1 = paramRect1.left;
      } else {
        paramInt1 = paramRect1.right;
      }
    }
    else {
      paramInt1 = paramRect1.left + paramRect1.width() / 2;
    }
    if (i1 != 16)
    {
      if (i1 != 80) {
        i1 = paramRect1.top;
      } else {
        i1 = paramRect1.bottom;
      }
    }
    else {
      i1 = paramRect1.top + paramRect1.height() / 2;
    }
    if (i4 != 1)
    {
      i2 = paramInt1;
      if (i4 != 5) {
        i2 = paramInt1 - paramInt2;
      }
    }
    else
    {
      i2 = paramInt1 - paramInt2 / 2;
    }
    if (i3 != 16)
    {
      paramInt1 = i1;
      if (i3 != 80) {
        paramInt1 = i1 - paramInt3;
      }
    }
    else
    {
      paramInt1 = i1 - paramInt3 / 2;
    }
    paramRect2.set(i2, paramInt1, paramInt2 + i2, paramInt3 + paramInt1);
  }
  
  void B(View paramView, Rect paramRect)
  {
    paramRect.set(((e)paramView.getLayoutParams()).h());
  }
  
  e C(View paramView)
  {
    e locale = (e)paramView.getLayoutParams();
    if (!locale.b)
    {
      if ((paramView instanceof b))
      {
        paramView = ((b)paramView).getBehavior();
        if (paramView == null) {
          Log.e("CoordinatorLayout", "Attached behavior class is null");
        }
        locale.o(paramView);
      }
      for (;;)
      {
        locale.b = true;
        return locale;
        Class localClass = paramView.getClass();
        Object localObject;
        for (paramView = null; localClass != null; paramView = (View)localObject)
        {
          localObject = (c)localClass.getAnnotation(c.class);
          paramView = (View)localObject;
          if (localObject != null) {
            break;
          }
          localClass = localClass.getSuperclass();
        }
        if (paramView != null) {
          try
          {
            locale.o((Behavior)paramView.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
          }
          catch (Exception localException)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Default behavior class ");
            ((StringBuilder)localObject).append(paramView.value().getName());
            ((StringBuilder)localObject).append(" could not be instantiated. Did you forget a default constructor?");
            Log.e("CoordinatorLayout", ((StringBuilder)localObject).toString(), localException);
          }
        }
      }
    }
    return locale;
  }
  
  public boolean F(View paramView, int paramInt1, int paramInt2)
  {
    Rect localRect = a();
    x(paramView, localRect);
    try
    {
      boolean bool = localRect.contains(paramInt1, paramInt2);
      return bool;
    }
    finally
    {
      S(localRect);
    }
  }
  
  void K(View paramView, int paramInt)
  {
    e locale = (e)paramView.getLayoutParams();
    if (locale.k != null)
    {
      Rect localRect1 = a();
      Rect localRect2 = a();
      Rect localRect3 = a();
      x(locale.k, localRect1);
      int i1 = 0;
      u(paramView, false, localRect2);
      int i2 = paramView.getMeasuredWidth();
      int i3 = paramView.getMeasuredHeight();
      z(paramView, paramInt, localRect1, localRect3, locale, i2, i3);
      if (localRect3.left == localRect2.left)
      {
        paramInt = i1;
        if (localRect3.top == localRect2.top) {}
      }
      else
      {
        paramInt = 1;
      }
      k(locale, localRect3, i2, i3);
      i1 = localRect3.left - localRect2.left;
      i2 = localRect3.top - localRect2.top;
      if (i1 != 0) {
        x.a0(paramView, i1);
      }
      if (i2 != 0) {
        x.b0(paramView, i2);
      }
      if (paramInt != 0)
      {
        Behavior localBehavior = locale.f();
        if (localBehavior != null) {
          localBehavior.h(this, paramView, locale.k);
        }
      }
      S(localRect1);
      S(localRect2);
      S(localRect3);
    }
  }
  
  final void L(int paramInt)
  {
    int i3 = x.B(this);
    int i4 = this.a.size();
    Rect localRect1 = a();
    Rect localRect2 = a();
    Rect localRect3 = a();
    int i1 = 0;
    while (i1 < i4)
    {
      View localView = (View)this.a.get(i1);
      Object localObject1 = (e)localView.getLayoutParams();
      if ((paramInt != 0) || (localView.getVisibility() != 8))
      {
        int i2 = 0;
        Object localObject2;
        while (i2 < i1)
        {
          localObject2 = (View)this.a.get(i2);
          if (((e)localObject1).l == localObject2) {
            K(localView, i3);
          }
          i2 += 1;
        }
        u(localView, true, localRect2);
        if ((((e)localObject1).g != 0) && (!localRect2.isEmpty()))
        {
          i2 = androidx.core.view.e.b(((e)localObject1).g, i3);
          int i5 = i2 & 0x70;
          if (i5 != 48)
          {
            if (i5 == 80) {
              localRect1.bottom = Math.max(localRect1.bottom, getHeight() - localRect2.top);
            }
          }
          else {
            localRect1.top = Math.max(localRect1.top, localRect2.bottom);
          }
          i2 &= 0x7;
          if (i2 != 3)
          {
            if (i2 == 5) {
              localRect1.right = Math.max(localRect1.right, getWidth() - localRect2.left);
            }
          }
          else {
            localRect1.left = Math.max(localRect1.left, localRect2.right);
          }
        }
        if ((((e)localObject1).h != 0) && (localView.getVisibility() == 0)) {
          J(localView, localRect1, i3);
        }
        if (paramInt != 2)
        {
          B(localView, localRect3);
          if (!localRect3.equals(localRect2)) {
            R(localView, localRect2);
          }
        }
        else
        {
          i2 = i1 + 1;
          while (i2 < i4)
          {
            localObject1 = (View)this.a.get(i2);
            localObject2 = (e)((View)localObject1).getLayoutParams();
            Behavior localBehavior = ((e)localObject2).f();
            if ((localBehavior != null) && (localBehavior.e(this, (View)localObject1, localView))) {
              if ((paramInt == 0) && (((e)localObject2).g()))
              {
                ((e)localObject2).k();
              }
              else
              {
                boolean bool;
                if (paramInt != 2)
                {
                  bool = localBehavior.h(this, (View)localObject1, localView);
                }
                else
                {
                  localBehavior.i(this, (View)localObject1, localView);
                  bool = true;
                }
                if (paramInt == 1) {
                  ((e)localObject2).p(bool);
                }
              }
            }
            i2 += 1;
          }
        }
      }
      i1 += 1;
    }
    S(localRect1);
    S(localRect2);
    S(localRect3);
  }
  
  public void M(View paramView, int paramInt)
  {
    e locale = (e)paramView.getLayoutParams();
    if (!locale.a())
    {
      View localView = locale.k;
      if (localView != null)
      {
        H(paramView, localView, paramInt);
        return;
      }
      int i1 = locale.e;
      if (i1 >= 0)
      {
        I(paramView, i1, paramInt);
        return;
      }
      G(paramView, paramInt);
      return;
    }
    throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
  }
  
  public void N(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureChildWithMargins(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void R(View paramView, Rect paramRect)
  {
    ((e)paramView.getLayoutParams()).q(paramRect);
  }
  
  void T()
  {
    if ((this.i) && (this.m != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.m);
    }
    this.n = false;
  }
  
  final h0 a0(h0 paramh0)
  {
    h0 localh0 = paramh0;
    if (!c.a(this.o, paramh0))
    {
      this.o = paramh0;
      boolean bool2 = true;
      boolean bool1;
      if ((paramh0 != null) && (paramh0.l() > 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.p = bool1;
      if ((!bool1) && (getBackground() == null)) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      setWillNotDraw(bool1);
      localh0 = l(paramh0);
      requestLayout();
    }
    return localh0;
  }
  
  public void c(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    this.t.c(paramView1, paramView2, paramInt1, paramInt2);
    this.l = paramView2;
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      Object localObject = (e)localView.getLayoutParams();
      if (((e)localObject).j(paramInt2))
      {
        localObject = ((e)localObject).f();
        if (localObject != null) {
          ((Behavior)localObject).v(this, localView, paramView1, paramView2, paramInt1, paramInt2);
        }
      }
      i1 += 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof e)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    e locale = (e)paramView.getLayoutParams();
    Behavior localBehavior = locale.a;
    if (localBehavior != null)
    {
      float f1 = localBehavior.d(this, paramView);
      if (f1 > 0.0F)
      {
        if (this.e == null) {
          this.e = new Paint();
        }
        this.e.setColor(locale.a.c(this, paramView));
        this.e.setAlpha(h(Math.round(f1 * 255.0F), 0, 255));
        int i1 = paramCanvas.save();
        if (paramView.isOpaque()) {
          paramCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom(), Region.Op.DIFFERENCE);
        }
        paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.e);
        paramCanvas.restoreToCount(i1);
      }
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.q;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = false | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  void g()
  {
    if (this.i)
    {
      if (this.m == null) {
        this.m = new f();
      }
      getViewTreeObserver().addOnPreDrawListener(this.m);
    }
    this.n = true;
  }
  
  final List<View> getDependencySortedChildren()
  {
    Q();
    return Collections.unmodifiableList(this.a);
  }
  
  public final h0 getLastWindowInsets()
  {
    return this.o;
  }
  
  public int getNestedScrollAxes()
  {
    return this.t.a();
  }
  
  public Drawable getStatusBarBackground()
  {
    return this.q;
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public void i(View paramView, int paramInt)
  {
    this.t.e(paramView, paramInt);
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      e locale = (e)localView.getLayoutParams();
      if (locale.j(paramInt))
      {
        Behavior localBehavior = locale.f();
        if (localBehavior != null) {
          localBehavior.C(this, localView, paramView, paramInt);
        }
        locale.l(paramInt);
        locale.k();
      }
      i1 += 1;
    }
    this.l = null;
  }
  
  public void j(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i7 = getChildCount();
    int i5 = 0;
    int i1 = i5;
    int i2 = i1;
    int i3 = i2;
    int i4 = i2;
    i2 = i1;
    int i6 = i5;
    while (i2 < i7)
    {
      Object localObject1 = getChildAt(i2);
      if (((View)localObject1).getVisibility() == 8)
      {
        i5 = i4;
        i1 = i3;
      }
      else
      {
        Object localObject2 = (e)((View)localObject1).getLayoutParams();
        if (!((e)localObject2).j(paramInt3))
        {
          i5 = i4;
          i1 = i3;
        }
        else
        {
          localObject2 = ((e)localObject2).f();
          i5 = i4;
          i1 = i3;
          if (localObject2 != null)
          {
            int[] arrayOfInt = this.f;
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            ((Behavior)localObject2).q(this, (View)localObject1, paramView, paramInt1, paramInt2, arrayOfInt, paramInt3);
            localObject1 = this.f;
            if (paramInt1 > 0) {
              i1 = Math.max(i4, localObject1[0]);
            } else {
              i1 = Math.min(i4, localObject1[0]);
            }
            i4 = i1;
            localObject1 = this.f;
            if (paramInt2 > 0) {
              i1 = Math.max(i3, localObject1[1]);
            } else {
              i1 = Math.min(i3, localObject1[1]);
            }
            i6 = 1;
            i5 = i4;
          }
        }
      }
      i2 += 1;
      i4 = i5;
      i3 = i1;
    }
    paramArrayOfInt[0] = i4;
    paramArrayOfInt[1] = i3;
    if (i6 != 0) {
      L(1);
    }
  }
  
  public void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    int i7 = getChildCount();
    int i5 = 0;
    int i1 = i5;
    int i2 = i1;
    int i3 = i2;
    int i4 = i2;
    i2 = i1;
    int i6 = i5;
    while (i2 < i7)
    {
      Object localObject1 = getChildAt(i2);
      if (((View)localObject1).getVisibility() == 8)
      {
        i5 = i4;
        i1 = i3;
      }
      else
      {
        Object localObject2 = (e)((View)localObject1).getLayoutParams();
        if (!((e)localObject2).j(paramInt5))
        {
          i5 = i4;
          i1 = i3;
        }
        else
        {
          localObject2 = ((e)localObject2).f();
          i5 = i4;
          i1 = i3;
          if (localObject2 != null)
          {
            int[] arrayOfInt = this.f;
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            ((Behavior)localObject2).t(this, (View)localObject1, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, arrayOfInt);
            localObject1 = this.f;
            if (paramInt3 > 0) {
              i1 = Math.max(i4, localObject1[0]);
            } else {
              i1 = Math.min(i4, localObject1[0]);
            }
            i4 = i1;
            if (paramInt4 > 0) {
              i1 = Math.max(i3, this.f[1]);
            } else {
              i1 = Math.min(i3, this.f[1]);
            }
            i6 = 1;
            i5 = i4;
          }
        }
      }
      i2 += 1;
      i4 = i5;
      i3 = i1;
    }
    paramArrayOfInt[0] += i4;
    paramArrayOfInt[1] += i3;
    if (i6 != 0) {
      L(1);
    }
  }
  
  public void n(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    m(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0, this.g);
  }
  
  public boolean o(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    U(false);
    if (this.n)
    {
      if (this.m == null) {
        this.m = new f();
      }
      getViewTreeObserver().addOnPreDrawListener(this.m);
    }
    if ((this.o == null) && (x.y(this))) {
      x.n0(this);
    }
    this.i = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    U(false);
    if ((this.n) && (this.m != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.m);
    }
    View localView = this.l;
    if (localView != null) {
      onStopNestedScroll(localView);
    }
    this.i = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.p) && (this.q != null))
    {
      h0 localh0 = this.o;
      int i1;
      if (localh0 != null) {
        i1 = localh0.l();
      } else {
        i1 = 0;
      }
      if (i1 > 0)
      {
        this.q.setBounds(0, 0, getWidth(), i1);
        this.q.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0) {
      U(true);
    }
    boolean bool = P(paramMotionEvent, 0);
    if ((i1 == 1) || (i1 == 3)) {
      U(true);
    }
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = x.B(this);
    paramInt3 = this.a.size();
    paramInt1 = 0;
    while (paramInt1 < paramInt3)
    {
      View localView = (View)this.a.get(paramInt1);
      if (localView.getVisibility() != 8)
      {
        Behavior localBehavior = ((e)localView.getLayoutParams()).f();
        if ((localBehavior == null) || (!localBehavior.l(this, localView, paramInt2))) {
          M(localView, paramInt2);
        }
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Q();
    q();
    int i11 = getPaddingLeft();
    int i13 = getPaddingTop();
    int i14 = getPaddingRight();
    int i15 = getPaddingBottom();
    int i16 = x.B(this);
    int i3;
    if (i16 == 1) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i17 = View.MeasureSpec.getMode(paramInt1);
    int i18 = View.MeasureSpec.getSize(paramInt1);
    int i19 = View.MeasureSpec.getMode(paramInt2);
    int i20 = View.MeasureSpec.getSize(paramInt2);
    int i9 = getSuggestedMinimumWidth();
    int i8 = getSuggestedMinimumHeight();
    int i4;
    if ((this.o != null) && (x.y(this))) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    int i5 = this.a.size();
    int i2 = 0;
    int i6 = 0;
    int i7;
    for (int i1 = i11;; i1 = i7)
    {
      i7 = i1;
      if (i6 >= i5) {
        break;
      }
      View localView = (View)this.a.get(i6);
      if (localView.getVisibility() != 8)
      {
        e locale = (e)localView.getLayoutParams();
        i1 = locale.e;
        int i10;
        if ((i1 >= 0) && (i17 != 0))
        {
          i1 = A(i1);
          i10 = androidx.core.view.e.b(X(locale.c), i16) & 0x7;
          if (((i10 == 3) && (i3 == 0)) || ((i10 == 5) && (i3 != 0)))
          {
            i1 = Math.max(0, i18 - i14 - i1);
            break label293;
          }
          if (((i10 == 5) && (i3 == 0)) || ((i10 == 3) && (i3 != 0)))
          {
            i1 = Math.max(0, i1 - i7);
            break label293;
          }
        }
        i1 = 0;
        label293:
        int i12 = i2;
        if ((i4 != 0) && (!x.y(localView)))
        {
          i2 = this.o.j();
          int i22 = this.o.k();
          i10 = this.o.l();
          int i21 = this.o.i();
          i2 = View.MeasureSpec.makeMeasureSpec(i18 - (i2 + i22), i17);
          i10 = View.MeasureSpec.makeMeasureSpec(i20 - (i10 + i21), i19);
        }
        else
        {
          i2 = paramInt1;
          i10 = paramInt2;
        }
        Behavior localBehavior = locale.f();
        if (localBehavior != null) {
          if (localBehavior.m(this, localView, i2, i1, i10, 0)) {
            break label429;
          }
        }
        N(localView, i2, i1, i10, 0);
        label429:
        i9 = Math.max(i9, i11 + i14 + localView.getMeasuredWidth() + locale.leftMargin + locale.rightMargin);
        i8 = Math.max(i8, i13 + i15 + localView.getMeasuredHeight() + locale.topMargin + locale.bottomMargin);
        i2 = View.combineMeasuredStates(i12, localView.getMeasuredState());
      }
      i6 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(i9, paramInt1, 0xFF000000 & i2), View.resolveSizeAndState(i8, paramInt2, i2 << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    j(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    n(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    c(paramView1, paramView2, paramInt, 0);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.g());
    paramParcelable = paramParcelable.c;
    int i1 = 0;
    int i2 = getChildCount();
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      int i3 = localView.getId();
      Behavior localBehavior = C(localView).f();
      if ((i3 != -1) && (localBehavior != null))
      {
        Parcelable localParcelable = (Parcelable)paramParcelable.get(i3);
        if (localParcelable != null) {
          localBehavior.x(this, localView, localParcelable);
        }
      }
      i1 += 1;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = getChildAt(i1);
      int i3 = ((View)localObject).getId();
      Behavior localBehavior = ((e)((View)localObject).getLayoutParams()).f();
      if ((i3 != -1) && (localBehavior != null))
      {
        localObject = localBehavior.y(this, (View)localObject);
        if (localObject != null) {
          localSparseArray.append(i3, localObject);
        }
      }
      i1 += 1;
    }
    localSavedState.c = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return o(paramView1, paramView2, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    i(paramView, 0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool1;
    if (this.k == null)
    {
      bool1 = P(paramMotionEvent, 1);
      bool2 = bool1;
      if (!bool1) {
        break label76;
      }
    }
    else
    {
      bool1 = false;
    }
    Behavior localBehavior = ((e)this.k.getLayoutParams()).f();
    boolean bool2 = bool1;
    boolean bool3;
    if (localBehavior != null)
    {
      bool3 = localBehavior.D(this, this.k, paramMotionEvent);
      bool2 = bool1;
      bool1 = bool3;
    }
    else
    {
      label76:
      bool1 = false;
    }
    View localView = this.k;
    localBehavior = null;
    if (localView == null)
    {
      bool3 = bool1 | super.onTouchEvent(paramMotionEvent);
      paramMotionEvent = localBehavior;
    }
    else
    {
      bool3 = bool1;
      paramMotionEvent = localBehavior;
      if (bool2)
      {
        long l1 = SystemClock.uptimeMillis();
        paramMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        super.onTouchEvent(paramMotionEvent);
        bool3 = bool1;
      }
    }
    if (paramMotionEvent != null) {
      paramMotionEvent.recycle();
    }
    if ((i1 == 1) || (i1 == 3)) {
      U(false);
    }
    return bool3;
  }
  
  public void p(View paramView)
  {
    List localList = this.b.g(paramView);
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i1 = 0;
      while (i1 < localList.size())
      {
        View localView = (View)localList.get(i1);
        Behavior localBehavior = ((e)localView.getLayoutParams()).f();
        if (localBehavior != null) {
          localBehavior.h(this, localView, paramView);
        }
        i1 += 1;
      }
    }
  }
  
  void q()
  {
    int i2 = getChildCount();
    int i4 = 0;
    int i1 = 0;
    int i3;
    for (;;)
    {
      i3 = i4;
      if (i1 >= i2) {
        break;
      }
      if (E(getChildAt(i1)))
      {
        i3 = 1;
        break;
      }
      i1 += 1;
    }
    if (i3 != this.n)
    {
      if (i3 != 0)
      {
        g();
        return;
      }
      T();
    }
  }
  
  protected e r()
  {
    return new e(-2, -2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    Behavior localBehavior = ((e)paramView.getLayoutParams()).f();
    if ((localBehavior != null) && (localBehavior.w(this, paramView, paramRect, paramBoolean))) {
      return true;
    }
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.h))
    {
      U(false);
      this.h = true;
    }
  }
  
  public e s(AttributeSet paramAttributeSet)
  {
    return new e(getContext(), paramAttributeSet);
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    b0();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.r = paramOnHierarchyChangeListener;
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.q;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.q = localDrawable1;
      if (localDrawable1 != null)
      {
        if (localDrawable1.isStateful()) {
          this.q.setState(getDrawableState());
        }
        r0.a.m(this.q, x.B(this));
        paramDrawable = this.q;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.q.setCallback(this);
      }
      x.h0(this);
    }
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    setStatusBarBackground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarBackgroundResource(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = androidx.core.content.b.d(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    setStatusBarBackground(localDrawable);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = this.q;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.q.setVisible(bool, false);
    }
  }
  
  protected e t(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof e)) {
      return new e((e)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new e((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new e(paramLayoutParams);
  }
  
  void u(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((!paramView.isLayoutRequested()) && (paramView.getVisibility() != 8))
    {
      if (paramBoolean)
      {
        x(paramView, paramRect);
        return;
      }
      paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
      return;
    }
    paramRect.setEmpty();
  }
  
  public List<View> v(View paramView)
  {
    paramView = this.b.h(paramView);
    this.d.clear();
    if (paramView != null) {
      this.d.addAll(paramView);
    }
    return this.d;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.q);
  }
  
  public List<View> w(View paramView)
  {
    paramView = this.b.g(paramView);
    this.d.clear();
    if (paramView != null) {
      this.d.addAll(paramView);
    }
    return this.d;
  }
  
  void x(View paramView, Rect paramRect)
  {
    b.a(this, paramView, paramRect);
  }
  
  void y(View paramView, int paramInt, Rect paramRect1, Rect paramRect2)
  {
    e locale = (e)paramView.getLayoutParams();
    int i1 = paramView.getMeasuredWidth();
    int i2 = paramView.getMeasuredHeight();
    z(paramView, paramInt, paramRect1, paramRect2, locale, i1, i2);
    k(locale, paramRect2, i1, i2);
  }
  
  public static abstract class Behavior<V extends View>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet) {}
    
    public boolean A(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0) {
        return z(paramCoordinatorLayout, paramV, paramView1, paramView2, paramInt1);
      }
      return false;
    }
    
    @Deprecated
    public void B(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView) {}
    
    public void C(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt)
    {
      if (paramInt == 0) {
        B(paramCoordinatorLayout, paramV, paramView);
      }
    }
    
    public boolean D(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return d(paramCoordinatorLayout, paramV) > 0.0F;
    }
    
    public boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, Rect paramRect)
    {
      return false;
    }
    
    public int c(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return -16777216;
    }
    
    public float d(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return 0.0F;
    }
    
    public boolean e(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
    {
      return false;
    }
    
    public h0 f(CoordinatorLayout paramCoordinatorLayout, V paramV, h0 paramh0)
    {
      return paramh0;
    }
    
    public void g(CoordinatorLayout.e parame) {}
    
    public boolean h(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
    {
      return false;
    }
    
    public void i(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView) {}
    
    public void j() {}
    
    public boolean k(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public boolean l(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
    {
      return false;
    }
    
    public boolean m(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      return false;
    }
    
    public boolean n(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      return false;
    }
    
    public boolean o(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
    {
      return false;
    }
    
    @Deprecated
    public void p(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
    
    public void q(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      if (paramInt3 == 0) {
        p(paramCoordinatorLayout, paramV, paramView, paramInt1, paramInt2, paramArrayOfInt);
      }
    }
    
    @Deprecated
    public void r(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    @Deprecated
    public void s(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if (paramInt5 == 0) {
        r(paramCoordinatorLayout, paramV, paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public void t(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
    {
      paramArrayOfInt[0] += paramInt3;
      paramArrayOfInt[1] += paramInt4;
      s(paramCoordinatorLayout, paramV, paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    }
    
    @Deprecated
    public void u(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt) {}
    
    public void v(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      if (paramInt2 == 0) {
        u(paramCoordinatorLayout, paramV, paramView1, paramView2, paramInt1);
      }
    }
    
    public boolean w(CoordinatorLayout paramCoordinatorLayout, V paramV, Rect paramRect, boolean paramBoolean)
    {
      return false;
    }
    
    public void x(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable) {}
    
    public Parcelable y(CoordinatorLayout paramCoordinatorLayout, V paramV)
    {
      return View.BaseSavedState.EMPTY_STATE;
    }
    
    @Deprecated
    public boolean z(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt)
    {
      return false;
    }
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new a();
    SparseArray<Parcelable> c;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      int j = paramParcel.readInt();
      int[] arrayOfInt = new int[j];
      paramParcel.readIntArray(arrayOfInt);
      paramParcel = paramParcel.readParcelableArray(paramClassLoader);
      this.c = new SparseArray(j);
      int i = 0;
      while (i < j)
      {
        this.c.append(arrayOfInt[i], paramParcel[i]);
        i += 1;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      Object localObject = this.c;
      int j = 0;
      int i;
      if (localObject != null) {
        i = ((SparseArray)localObject).size();
      } else {
        i = 0;
      }
      paramParcel.writeInt(i);
      localObject = new int[i];
      Parcelable[] arrayOfParcelable = new Parcelable[i];
      while (j < i)
      {
        localObject[j] = this.c.keyAt(j);
        arrayOfParcelable[j] = ((Parcelable)this.c.valueAt(j));
        j += 1;
      }
      paramParcel.writeIntArray((int[])localObject);
      paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
    }
    
    static final class a
      implements Parcelable.ClassLoaderCreator<CoordinatorLayout.SavedState>
    {
      public CoordinatorLayout.SavedState a(Parcel paramParcel)
      {
        return new CoordinatorLayout.SavedState(paramParcel, null);
      }
      
      public CoordinatorLayout.SavedState b(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        return new CoordinatorLayout.SavedState(paramParcel, paramClassLoader);
      }
      
      public CoordinatorLayout.SavedState[] c(int paramInt)
      {
        return new CoordinatorLayout.SavedState[paramInt];
      }
    }
  }
  
  class a
    implements r
  {
    a() {}
    
    public h0 a(View paramView, h0 paramh0)
    {
      return CoordinatorLayout.this.a0(paramh0);
    }
  }
  
  public static abstract interface b
  {
    public abstract CoordinatorLayout.Behavior getBehavior();
  }
  
  @Deprecated
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface c
  {
    Class<? extends CoordinatorLayout.Behavior> value();
  }
  
  private class d
    implements ViewGroup.OnHierarchyChangeListener
  {
    d() {}
    
    public void onChildViewAdded(View paramView1, View paramView2)
    {
      ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = CoordinatorLayout.this.r;
      if (localOnHierarchyChangeListener != null) {
        localOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public void onChildViewRemoved(View paramView1, View paramView2)
    {
      CoordinatorLayout.this.L(2);
      ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = CoordinatorLayout.this.r;
      if (localOnHierarchyChangeListener != null) {
        localOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
  
  public static class e
    extends ViewGroup.MarginLayoutParams
  {
    CoordinatorLayout.Behavior a;
    boolean b = false;
    public int c = 0;
    public int d = 0;
    public int e = -1;
    int f = -1;
    public int g = 0;
    public int h = 0;
    int i;
    int j;
    View k;
    View l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    final Rect q = new Rect();
    Object r;
    
    public e(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    e(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout_Layout);
      this.c = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
      this.f = localTypedArray.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
      this.d = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
      this.e = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
      this.g = localTypedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
      this.h = localTypedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
      int i1 = R.styleable.CoordinatorLayout_Layout_layout_behavior;
      boolean bool = localTypedArray.hasValue(i1);
      this.b = bool;
      if (bool) {
        this.a = CoordinatorLayout.O(paramContext, paramAttributeSet, localTypedArray.getString(i1));
      }
      localTypedArray.recycle();
      paramContext = this.a;
      if (paramContext != null) {
        paramContext.g(this);
      }
    }
    
    public e(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public e(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public e(e parame)
    {
      super();
    }
    
    private void n(View paramView, CoordinatorLayout paramCoordinatorLayout)
    {
      View localView = paramCoordinatorLayout.findViewById(this.f);
      this.k = localView;
      if (localView != null) {
        if (localView == paramCoordinatorLayout) {
          if (!paramCoordinatorLayout.isInEditMode()) {}
        }
      }
      label118:
      while (paramCoordinatorLayout.isInEditMode())
      {
        this.l = null;
        this.k = null;
        return;
        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        for (localObject = localView.getParent();; localObject = ((ViewParent)localObject).getParent())
        {
          if ((localObject == paramCoordinatorLayout) || (localObject == null)) {
            break label118;
          }
          if (localObject == paramView)
          {
            if (paramCoordinatorLayout.isInEditMode()) {
              break;
            }
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
          }
          if ((localObject instanceof View)) {
            localView = (View)localObject;
          }
        }
        this.l = localView;
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find CoordinatorLayout descendant view with id ");
      ((StringBuilder)localObject).append(paramCoordinatorLayout.getResources().getResourceName(this.f));
      ((StringBuilder)localObject).append(" to anchor view ");
      ((StringBuilder)localObject).append(paramView);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    
    private boolean s(View paramView, int paramInt)
    {
      int i1 = androidx.core.view.e.b(((e)paramView.getLayoutParams()).g, paramInt);
      return (i1 != 0) && ((androidx.core.view.e.b(this.h, paramInt) & i1) == i1);
    }
    
    private boolean t(View paramView, CoordinatorLayout paramCoordinatorLayout)
    {
      if (this.k.getId() != this.f) {
        return false;
      }
      View localView = this.k;
      ViewParent localViewParent = localView.getParent();
      while (localViewParent != paramCoordinatorLayout) {
        if ((localViewParent != null) && (localViewParent != paramView))
        {
          if ((localViewParent instanceof View)) {
            localView = (View)localViewParent;
          }
          localViewParent = localViewParent.getParent();
        }
        else
        {
          this.l = null;
          this.k = null;
          return false;
        }
      }
      this.l = localView;
      return true;
    }
    
    boolean a()
    {
      return (this.k == null) && (this.f != -1);
    }
    
    boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      if ((paramView2 != this.l) && (!s(paramView2, x.B(paramCoordinatorLayout))))
      {
        CoordinatorLayout.Behavior localBehavior = this.a;
        if ((localBehavior == null) || (!localBehavior.e(paramCoordinatorLayout, paramView1, paramView2))) {
          return false;
        }
      }
      return true;
    }
    
    boolean c()
    {
      if (this.a == null) {
        this.m = false;
      }
      return this.m;
    }
    
    View d(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      if (this.f == -1)
      {
        this.l = null;
        this.k = null;
        return null;
      }
      if ((this.k == null) || (!t(paramView, paramCoordinatorLayout))) {
        n(paramView, paramCoordinatorLayout);
      }
      return this.k;
    }
    
    public int e()
    {
      return this.f;
    }
    
    public CoordinatorLayout.Behavior f()
    {
      return this.a;
    }
    
    boolean g()
    {
      return this.p;
    }
    
    Rect h()
    {
      return this.q;
    }
    
    boolean i(CoordinatorLayout paramCoordinatorLayout, View paramView)
    {
      boolean bool2 = this.m;
      if (bool2) {
        return true;
      }
      CoordinatorLayout.Behavior localBehavior = this.a;
      boolean bool1;
      if (localBehavior != null) {
        bool1 = localBehavior.a(paramCoordinatorLayout, paramView);
      } else {
        bool1 = false;
      }
      bool1 |= bool2;
      this.m = bool1;
      return bool1;
    }
    
    boolean j(int paramInt)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return false;
        }
        return this.o;
      }
      return this.n;
    }
    
    void k()
    {
      this.p = false;
    }
    
    void l(int paramInt)
    {
      r(paramInt, false);
    }
    
    void m()
    {
      this.m = false;
    }
    
    public void o(CoordinatorLayout.Behavior paramBehavior)
    {
      CoordinatorLayout.Behavior localBehavior = this.a;
      if (localBehavior != paramBehavior)
      {
        if (localBehavior != null) {
          localBehavior.j();
        }
        this.a = paramBehavior;
        this.r = null;
        this.b = true;
        if (paramBehavior != null) {
          paramBehavior.g(this);
        }
      }
    }
    
    void p(boolean paramBoolean)
    {
      this.p = paramBoolean;
    }
    
    void q(Rect paramRect)
    {
      this.q.set(paramRect);
    }
    
    void r(int paramInt, boolean paramBoolean)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1) {
          return;
        }
        this.o = paramBoolean;
        return;
      }
      this.n = paramBoolean;
    }
  }
  
  class f
    implements ViewTreeObserver.OnPreDrawListener
  {
    f() {}
    
    public boolean onPreDraw()
    {
      CoordinatorLayout.this.L(0);
      return true;
    }
  }
  
  static class g
    implements Comparator<View>
  {
    public int a(View paramView1, View paramView2)
    {
      float f1 = x.N(paramView1);
      float f2 = x.N(paramView2);
      if (f1 > f2) {
        return -1;
      }
      if (f1 < f2) {
        return 1;
      }
      return 0;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.coordinatorlayout.widget.CoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */