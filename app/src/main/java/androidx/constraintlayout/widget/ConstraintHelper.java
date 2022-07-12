package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import k0.e;
import k0.f;
import k0.i;
import k0.j;

public abstract class ConstraintHelper
  extends View
{
  protected int[] a = new int[32];
  protected int b;
  protected Context c;
  protected i d;
  protected boolean e = false;
  protected String f;
  protected String g;
  private View[] h = null;
  protected HashMap<Integer, String> i = new HashMap();
  
  public ConstraintHelper(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    o(null);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    o(paramAttributeSet);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    o(paramAttributeSet);
  }
  
  private void e(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (this.c == null) {
        return;
      }
      paramString = paramString.trim();
      if ((getParent() instanceof ConstraintLayout)) {
        localObject = (ConstraintLayout)getParent();
      }
      int j = m(paramString);
      if (j != 0)
      {
        this.i.put(Integer.valueOf(j), paramString);
        f(j);
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find id of \"");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\"");
      Log.w("ConstraintHelper", ((StringBuilder)localObject).toString());
    }
  }
  
  private void f(int paramInt)
  {
    if (paramInt == getId()) {
      return;
    }
    int j = this.b;
    int[] arrayOfInt = this.a;
    if (j + 1 > arrayOfInt.length) {
      this.a = Arrays.copyOf(arrayOfInt, arrayOfInt.length * 2);
    }
    arrayOfInt = this.a;
    j = this.b;
    arrayOfInt[j] = paramInt;
    this.b = (j + 1);
  }
  
  private void g(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (this.c == null) {
        return;
      }
      String str = paramString.trim();
      paramString = null;
      if ((getParent() instanceof ConstraintLayout)) {
        paramString = (ConstraintLayout)getParent();
      }
      if (paramString == null)
      {
        Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
        return;
      }
      int k = paramString.getChildCount();
      int j = 0;
      while (j < k)
      {
        View localView = paramString.getChildAt(j);
        Object localObject = localView.getLayoutParams();
        if (((localObject instanceof ConstraintLayout.LayoutParams)) && (str.equals(((ConstraintLayout.LayoutParams)localObject).c0))) {
          if (localView.getId() == -1)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("to use ConstraintTag view ");
            ((StringBuilder)localObject).append(localView.getClass().getSimpleName());
            ((StringBuilder)localObject).append(" must have an ID");
            Log.w("ConstraintHelper", ((StringBuilder)localObject).toString());
          }
          else
          {
            f(localView.getId());
          }
        }
        j += 1;
      }
    }
  }
  
  private int[] k(View paramView, String paramString)
  {
    String[] arrayOfString = paramString.split(",");
    paramView.getContext();
    paramString = new int[arrayOfString.length];
    int j = 0;
    int m;
    for (int k = 0; j < arrayOfString.length; k = m)
    {
      int n = m(arrayOfString[j].trim());
      m = k;
      if (n != 0)
      {
        paramString[k] = n;
        m = k + 1;
      }
      j += 1;
    }
    paramView = paramString;
    if (k != arrayOfString.length) {
      paramView = Arrays.copyOf(paramString, k);
    }
    return paramView;
  }
  
  private int l(ConstraintLayout paramConstraintLayout, String paramString)
  {
    if (paramString != null)
    {
      if (paramConstraintLayout == null) {
        return 0;
      }
      Resources localResources = this.c.getResources();
      if (localResources == null) {
        return 0;
      }
      int k = paramConstraintLayout.getChildCount();
      int j = 0;
      while (j < k)
      {
        View localView = paramConstraintLayout.getChildAt(j);
        Object localObject;
        if (localView.getId() != -1) {
          localObject = null;
        }
        try
        {
          String str = localResources.getResourceEntryName(localView.getId());
          localObject = str;
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          label75:
          break label75;
        }
        if (paramString.equals(localObject)) {
          return localView.getId();
        }
        j += 1;
      }
    }
    else
    {
      return 0;
    }
  }
  
  private int m(String paramString)
  {
    ConstraintLayout localConstraintLayout;
    if ((getParent() instanceof ConstraintLayout)) {
      localConstraintLayout = (ConstraintLayout)getParent();
    } else {
      localConstraintLayout = null;
    }
    boolean bool = isInEditMode();
    int j = 0;
    int k = j;
    if (bool)
    {
      k = j;
      if (localConstraintLayout != null)
      {
        Object localObject = localConstraintLayout.h(0, paramString);
        k = j;
        if ((localObject instanceof Integer)) {
          k = ((Integer)localObject).intValue();
        }
      }
    }
    j = k;
    if (k == 0)
    {
      j = k;
      if (localConstraintLayout != null) {
        j = l(localConstraintLayout, paramString);
      }
    }
    k = j;
    if (j == 0) {}
    try
    {
      k = R.id.class.getField(paramString).getInt(null);
      j = k;
      if (k == 0) {
        j = this.c.getResources().getIdentifier(paramString, "id", this.c.getPackageName());
      }
      return j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        k = j;
      }
    }
  }
  
  public int[] getReferencedIds()
  {
    return Arrays.copyOf(this.a, this.b);
  }
  
  protected void h()
  {
    ViewParent localViewParent = getParent();
    if ((localViewParent != null) && ((localViewParent instanceof ConstraintLayout))) {
      i((ConstraintLayout)localViewParent);
    }
  }
  
  protected void i(ConstraintLayout paramConstraintLayout)
  {
    int k = getVisibility();
    float f1 = getElevation();
    int j = 0;
    while (j < this.b)
    {
      View localView = paramConstraintLayout.l(this.a[j]);
      if (localView != null)
      {
        localView.setVisibility(k);
        if (f1 > 0.0F) {
          localView.setTranslationZ(localView.getTranslationZ() + f1);
        }
      }
      j += 1;
    }
  }
  
  protected void j(ConstraintLayout paramConstraintLayout) {}
  
  protected View[] n(ConstraintLayout paramConstraintLayout)
  {
    View[] arrayOfView = this.h;
    if ((arrayOfView == null) || (arrayOfView.length != this.b)) {
      this.h = new View[this.b];
    }
    int j = 0;
    while (j < this.b)
    {
      int k = this.a[j];
      this.h[j] = paramConstraintLayout.l(k);
      j += 1;
    }
    return this.h;
  }
  
  protected void o(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int k = paramAttributeSet.getIndexCount();
      int j = 0;
      while (j < k)
      {
        int m = paramAttributeSet.getIndex(j);
        String str;
        if (m == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids)
        {
          str = paramAttributeSet.getString(m);
          this.f = str;
          setIds(str);
        }
        else if (m == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags)
        {
          str = paramAttributeSet.getString(m);
          this.g = str;
          setReferenceTags(str);
        }
        j += 1;
      }
      paramAttributeSet.recycle();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = this.f;
    if (str != null) {
      setIds(str);
    }
    str = this.g;
    if (str != null) {
      setReferenceTags(str);
    }
  }
  
  public void onDraw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.e)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(0, 0);
  }
  
  public void p(c.a parama, j paramj, ConstraintLayout.LayoutParams paramLayoutParams, SparseArray<e> paramSparseArray)
  {
    paramLayoutParams = parama.e;
    int[] arrayOfInt = paramLayoutParams.k0;
    if (arrayOfInt != null)
    {
      setReferencedIds(arrayOfInt);
    }
    else
    {
      paramLayoutParams = paramLayoutParams.l0;
      if (paramLayoutParams != null) {
        if (paramLayoutParams.length() > 0)
        {
          paramLayoutParams = parama.e;
          paramLayoutParams.k0 = k(this, paramLayoutParams.l0);
        }
        else
        {
          parama.e.k0 = null;
        }
      }
    }
    if (paramj != null)
    {
      paramj.c();
      if (parama.e.k0 != null)
      {
        int j = 0;
        for (;;)
        {
          paramLayoutParams = parama.e.k0;
          if (j >= paramLayoutParams.length) {
            break;
          }
          paramLayoutParams = (e)paramSparseArray.get(paramLayoutParams[j]);
          if (paramLayoutParams != null) {
            paramj.a(paramLayoutParams);
          }
          j += 1;
        }
      }
    }
  }
  
  public void q(e parame, boolean paramBoolean) {}
  
  public void r(ConstraintLayout paramConstraintLayout) {}
  
  public void s(ConstraintLayout paramConstraintLayout) {}
  
  protected void setIds(String paramString)
  {
    this.f = paramString;
    if (paramString == null) {
      return;
    }
    int j = 0;
    this.b = 0;
    for (;;)
    {
      int k = paramString.indexOf(',', j);
      if (k == -1)
      {
        e(paramString.substring(j));
        return;
      }
      e(paramString.substring(j, k));
      j = k + 1;
    }
  }
  
  protected void setReferenceTags(String paramString)
  {
    this.g = paramString;
    if (paramString == null) {
      return;
    }
    int j = 0;
    this.b = 0;
    for (;;)
    {
      int k = paramString.indexOf(',', j);
      if (k == -1)
      {
        g(paramString.substring(j));
        return;
      }
      g(paramString.substring(j, k));
      j = k + 1;
    }
  }
  
  public void setReferencedIds(int[] paramArrayOfInt)
  {
    this.f = null;
    int j = 0;
    this.b = 0;
    while (j < paramArrayOfInt.length)
    {
      f(paramArrayOfInt[j]);
      j += 1;
    }
  }
  
  public void setTag(int paramInt, Object paramObject)
  {
    super.setTag(paramInt, paramObject);
    if ((paramObject == null) && (this.f == null)) {
      f(paramInt);
    }
  }
  
  public void t(ConstraintLayout paramConstraintLayout) {}
  
  public void u(ConstraintLayout paramConstraintLayout)
  {
    if (isInEditMode()) {
      setIds(this.f);
    }
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    ((i)localObject).c();
    int j = 0;
    while (j < this.b)
    {
      int k = this.a[j];
      View localView = paramConstraintLayout.l(k);
      localObject = localView;
      if (localView == null)
      {
        String str = (String)this.i.get(Integer.valueOf(k));
        k = l(paramConstraintLayout, str);
        localObject = localView;
        if (k != 0)
        {
          this.a[j] = k;
          this.i.put(Integer.valueOf(k), str);
          localObject = paramConstraintLayout.l(k);
        }
      }
      if (localObject != null) {
        this.d.a(paramConstraintLayout.p((View)localObject));
      }
      j += 1;
    }
    this.d.b(paramConstraintLayout.c);
  }
  
  public void v(f paramf, i parami, SparseArray<e> paramSparseArray)
  {
    parami.c();
    int j = 0;
    while (j < this.b)
    {
      parami.a((e)paramSparseArray.get(this.a[j]));
      j += 1;
    }
  }
  
  public void w()
  {
    if (this.d == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((localLayoutParams instanceof ConstraintLayout.LayoutParams)) {
      ((ConstraintLayout.LayoutParams)localLayoutParams).v0 = ((e)this.d);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintHelper
 * JD-Core Version:    0.7.0.1
 */