package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.R.attr;
import com.google.android.material.R.layout;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.internal.f;
import com.google.android.material.internal.p;
import s7.a;

public class MaterialAutoCompleteTextView
  extends AppCompatAutoCompleteTextView
{
  private final ListPopupWindow e;
  private final AccessibilityManager f;
  private final Rect g = new Rect();
  private final int h;
  
  public MaterialAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
  }
  
  public MaterialAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(a.c(paramContext, paramAttributeSet, paramInt, 0), paramAttributeSet, paramInt);
    paramContext = getContext();
    paramAttributeSet = p.h(paramContext, paramAttributeSet, R.styleable.MaterialAutoCompleteTextView, paramInt, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
    paramInt = R.styleable.MaterialAutoCompleteTextView_android_inputType;
    if ((paramAttributeSet.hasValue(paramInt)) && (paramAttributeSet.getInt(paramInt, 0) == 0)) {
      setKeyListener(null);
    }
    this.h = paramAttributeSet.getResourceId(R.styleable.MaterialAutoCompleteTextView_simpleItemLayout, R.layout.mtrl_auto_complete_simple_item);
    this.f = ((AccessibilityManager)paramContext.getSystemService("accessibility"));
    paramContext = new ListPopupWindow(paramContext);
    this.e = paramContext;
    paramContext.J(true);
    paramContext.D(this);
    paramContext.I(2);
    paramContext.p(getAdapter());
    paramContext.L(new a());
    paramInt = R.styleable.MaterialAutoCompleteTextView_simpleItems;
    if (paramAttributeSet.hasValue(paramInt)) {
      setSimpleItems(paramAttributeSet.getResourceId(paramInt, 0));
    }
    paramAttributeSet.recycle();
  }
  
  private TextInputLayout d()
  {
    for (ViewParent localViewParent = getParent(); localViewParent != null; localViewParent = localViewParent.getParent()) {
      if ((localViewParent instanceof TextInputLayout)) {
        return (TextInputLayout)localViewParent;
      }
    }
    return null;
  }
  
  private int e()
  {
    ListAdapter localListAdapter = getAdapter();
    TextInputLayout localTextInputLayout = d();
    int k = 0;
    if (localListAdapter != null)
    {
      if (localTextInputLayout == null) {
        return 0;
      }
      int i1 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
      int i2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
      int i = Math.max(0, this.e.x());
      int i3 = Math.min(localListAdapter.getCount(), i + 15);
      int j = Math.max(0, i3 - 15);
      Object localObject = null;
      i = 0;
      while (j < i3)
      {
        int n = localListAdapter.getItemViewType(j);
        int m = k;
        if (n != k)
        {
          localObject = null;
          m = n;
        }
        localObject = localListAdapter.getView(j, (View)localObject, localTextInputLayout);
        if (((View)localObject).getLayoutParams() == null) {
          ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        ((View)localObject).measure(i1, i2);
        i = Math.max(i, ((View)localObject).getMeasuredWidth());
        j += 1;
        k = m;
      }
      localObject = this.e.g();
      j = i;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(this.g);
        localObject = this.g;
        j = i + (((Rect)localObject).left + ((Rect)localObject).right);
      }
      return j + localTextInputLayout.getEndIconView().getMeasuredWidth();
    }
    return 0;
  }
  
  private <T extends ListAdapter,  extends Filterable> void f(Object paramObject)
  {
    setText(convertSelectionToString(paramObject), false);
  }
  
  public CharSequence getHint()
  {
    TextInputLayout localTextInputLayout = d();
    if ((localTextInputLayout != null) && (localTextInputLayout.O())) {
      return localTextInputLayout.getHint();
    }
    return super.getHint();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    TextInputLayout localTextInputLayout = d();
    if ((localTextInputLayout != null) && (localTextInputLayout.O()) && (super.getHint() == null) && (f.c())) {
      setHint("");
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (View.MeasureSpec.getMode(paramInt1) == -2147483648) {
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), e()), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight());
    }
  }
  
  public <T extends ListAdapter,  extends Filterable> void setAdapter(T paramT)
  {
    super.setAdapter(paramT);
    this.e.p(getAdapter());
  }
  
  public void setSimpleItems(int paramInt)
  {
    setSimpleItems(getResources().getStringArray(paramInt));
  }
  
  public void setSimpleItems(String[] paramArrayOfString)
  {
    setAdapter(new ArrayAdapter(getContext(), this.h, paramArrayOfString));
  }
  
  public void showDropDown()
  {
    AccessibilityManager localAccessibilityManager = this.f;
    if ((localAccessibilityManager != null) && (localAccessibilityManager.isTouchExplorationEnabled()))
    {
      this.e.a();
      return;
    }
    super.showDropDown();
  }
  
  class a
    implements AdapterView.OnItemClickListener
  {
    a() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      paramAdapterView = MaterialAutoCompleteTextView.this;
      if (paramInt < 0) {
        paramAdapterView = MaterialAutoCompleteTextView.b(paramAdapterView).v();
      } else {
        paramAdapterView = paramAdapterView.getAdapter().getItem(paramInt);
      }
      MaterialAutoCompleteTextView.c(MaterialAutoCompleteTextView.this, paramAdapterView);
      paramAdapterView = MaterialAutoCompleteTextView.this.getOnItemClickListener();
      if (paramAdapterView != null)
      {
        int i;
        if (paramView != null)
        {
          i = paramInt;
          if (paramInt >= 0) {}
        }
        else
        {
          paramView = MaterialAutoCompleteTextView.b(MaterialAutoCompleteTextView.this).y();
          i = MaterialAutoCompleteTextView.b(MaterialAutoCompleteTextView.this).x();
          paramLong = MaterialAutoCompleteTextView.b(MaterialAutoCompleteTextView.this).w();
        }
        paramAdapterView.onItemClick(MaterialAutoCompleteTextView.b(MaterialAutoCompleteTextView.this).h(), paramView, i, paramLong);
      }
      MaterialAutoCompleteTextView.b(MaterialAutoCompleteTextView.this).dismiss();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.android.material.textfield.MaterialAutoCompleteTextView
 * JD-Core Version:    0.7.0.1
 */