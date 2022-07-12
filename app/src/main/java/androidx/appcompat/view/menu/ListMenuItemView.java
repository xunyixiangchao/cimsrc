package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.id;
import androidx.appcompat.R.layout;
import androidx.appcompat.R.styleable;
import androidx.appcompat.widget.k0;
import androidx.core.view.x;

public class ListMenuItemView
  extends LinearLayout
  implements k.a, AbsListView.SelectionBoundsAdjuster
{
  private g a;
  private ImageView b;
  private RadioButton c;
  private TextView d;
  private CheckBox e;
  private TextView f;
  private ImageView g;
  private ImageView h;
  private LinearLayout i;
  private Drawable j;
  private int k;
  private Context l;
  private boolean m;
  private Drawable n;
  private boolean o;
  private LayoutInflater p;
  private boolean q;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.listMenuViewStyle);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = k0.v(getContext(), paramAttributeSet, R.styleable.MenuView, paramInt, 0);
    this.j = paramAttributeSet.g(R.styleable.MenuView_android_itemBackground);
    this.k = paramAttributeSet.n(R.styleable.MenuView_android_itemTextAppearance, -1);
    this.m = paramAttributeSet.a(R.styleable.MenuView_preserveIconSpacing, false);
    this.l = paramContext;
    this.n = paramAttributeSet.g(R.styleable.MenuView_subMenuArrow);
    paramContext = paramContext.getTheme();
    paramInt = R.attr.dropDownListViewStyle;
    paramContext = paramContext.obtainStyledAttributes(null, new int[] { 16843049 }, paramInt, 0);
    this.o = paramContext.hasValue(0);
    paramAttributeSet.w();
    paramContext.recycle();
  }
  
  private void a(View paramView)
  {
    b(paramView, -1);
  }
  
  private void b(View paramView, int paramInt)
  {
    LinearLayout localLinearLayout = this.i;
    if (localLinearLayout != null)
    {
      localLinearLayout.addView(paramView, paramInt);
      return;
    }
    addView(paramView, paramInt);
  }
  
  private void c()
  {
    CheckBox localCheckBox = (CheckBox)getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
    this.e = localCheckBox;
    a(localCheckBox);
  }
  
  private void e()
  {
    ImageView localImageView = (ImageView)getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
    this.b = localImageView;
    b(localImageView, 0);
  }
  
  private void f()
  {
    RadioButton localRadioButton = (RadioButton)getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
    this.c = localRadioButton;
    a(localRadioButton);
  }
  
  private LayoutInflater getInflater()
  {
    if (this.p == null) {
      this.p = LayoutInflater.from(getContext());
    }
    return this.p;
  }
  
  private void setSubMenuArrowVisible(boolean paramBoolean)
  {
    ImageView localImageView = this.g;
    if (localImageView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localImageView.setVisibility(i1);
    }
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    Object localObject = this.h;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      localObject = (LinearLayout.LayoutParams)this.h.getLayoutParams();
      paramRect.top += this.h.getHeight() + ((LinearLayout.LayoutParams)localObject).topMargin + ((LinearLayout.LayoutParams)localObject).bottomMargin;
    }
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void g(boolean paramBoolean, char paramChar)
  {
    if ((paramBoolean) && (this.a.A())) {
      paramChar = '\000';
    } else {
      paramChar = '\b';
    }
    if (paramChar == 0) {
      this.f.setText(this.a.h());
    }
    if (this.f.getVisibility() != paramChar) {
      this.f.setVisibility(paramChar);
    }
  }
  
  public g getItemData()
  {
    return this.a;
  }
  
  public void j(g paramg, int paramInt)
  {
    this.a = paramg;
    if (paramg.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    setTitle(paramg.i(this));
    setCheckable(paramg.isCheckable());
    g(paramg.A(), paramg.g());
    setIcon(paramg.getIcon());
    setEnabled(paramg.isEnabled());
    setSubMenuArrowVisible(paramg.hasSubMenu());
    setContentDescription(paramg.getContentDescription());
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    x.u0(this, this.j);
    Object localObject = (TextView)findViewById(R.id.title);
    this.d = ((TextView)localObject);
    int i1 = this.k;
    if (i1 != -1) {
      ((TextView)localObject).setTextAppearance(this.l, i1);
    }
    this.f = ((TextView)findViewById(R.id.shortcut));
    localObject = (ImageView)findViewById(R.id.submenuarrow);
    this.g = ((ImageView)localObject);
    if (localObject != null) {
      ((ImageView)localObject).setImageDrawable(this.n);
    }
    this.h = ((ImageView)findViewById(R.id.group_divider));
    this.i = ((LinearLayout)findViewById(R.id.content));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.m))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
      int i1 = localLayoutParams.height;
      if ((i1 > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = i1;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.c == null) && (this.e == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.a.m())
    {
      if (this.c == null) {
        f();
      }
      localObject1 = this.c;
      localObject2 = this.e;
    }
    else
    {
      if (this.e == null) {
        c();
      }
      localObject1 = this.e;
      localObject2 = this.c;
    }
    if (paramBoolean)
    {
      ((CompoundButton)localObject1).setChecked(this.a.isChecked());
      if (((CompoundButton)localObject1).getVisibility() != 0) {
        ((CompoundButton)localObject1).setVisibility(0);
      }
      if ((localObject2 != null) && (((CompoundButton)localObject2).getVisibility() != 8)) {
        ((CompoundButton)localObject2).setVisibility(8);
      }
    }
    else
    {
      localObject1 = this.e;
      if (localObject1 != null) {
        ((CheckBox)localObject1).setVisibility(8);
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        ((RadioButton)localObject1).setVisibility(8);
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    Object localObject;
    if (this.a.m())
    {
      if (this.c == null) {
        f();
      }
      localObject = this.c;
    }
    else
    {
      if (this.e == null) {
        c();
      }
      localObject = this.e;
    }
    ((CompoundButton)localObject).setChecked(paramBoolean);
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.q = paramBoolean;
    this.m = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    ImageView localImageView = this.h;
    if (localImageView != null)
    {
      int i1;
      if ((!this.o) && (paramBoolean)) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localImageView.setVisibility(i1);
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i1;
    if ((!this.a.z()) && (!this.q)) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((i1 == 0) && (!this.m)) {
      return;
    }
    ImageView localImageView = this.b;
    if ((localImageView == null) && (paramDrawable == null) && (!this.m)) {
      return;
    }
    if (localImageView == null) {
      e();
    }
    if ((paramDrawable == null) && (!this.m))
    {
      this.b.setVisibility(8);
      return;
    }
    localImageView = this.b;
    if (i1 == 0) {
      paramDrawable = null;
    }
    localImageView.setImageDrawable(paramDrawable);
    if (this.b.getVisibility() != 0) {
      this.b.setVisibility(0);
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    int i1;
    if (paramCharSequence != null)
    {
      this.d.setText(paramCharSequence);
      if (this.d.getVisibility() == 0) {
        return;
      }
      paramCharSequence = this.d;
      i1 = 0;
    }
    else
    {
      int i2 = this.d.getVisibility();
      i1 = 8;
      if (i2 == 8) {
        return;
      }
      paramCharSequence = this.d;
    }
    paramCharSequence.setVisibility(i1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.ListMenuItemView
 * JD-Core Version:    0.7.0.1
 */