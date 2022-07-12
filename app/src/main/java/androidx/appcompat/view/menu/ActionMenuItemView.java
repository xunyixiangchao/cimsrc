package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.R.styleable;
import androidx.appcompat.widget.ActionMenuView.a;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.n0;
import androidx.appcompat.widget.w;
import h.e;

public class ActionMenuItemView
  extends AppCompatTextView
  implements k.a, View.OnClickListener, ActionMenuView.a
{
  g a;
  private CharSequence b;
  private Drawable c;
  e.b d;
  private w e;
  b f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.g = l();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionMenuItemView, paramInt, 0);
    this.i = paramContext.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
    paramContext.recycle();
    this.k = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.j = -1;
    setSaveEnabled(false);
  }
  
  private boolean l()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int m = localConfiguration.screenWidthDp;
    int n = localConfiguration.screenHeightDp;
    return (m >= 480) || ((m >= 640) && (n >= 480)) || (localConfiguration.orientation == 2);
  }
  
  private void m()
  {
    boolean bool = TextUtils.isEmpty(this.b);
    int n = 1;
    int m = n;
    if (this.c != null)
    {
      if (this.a.B())
      {
        m = n;
        if (this.g) {
          break label52;
        }
        if (this.h)
        {
          m = n;
          break label52;
        }
      }
      m = 0;
    }
    label52:
    m = (bool ^ true) & m;
    Object localObject2 = null;
    if (m != 0) {
      localObject1 = this.b;
    } else {
      localObject1 = null;
    }
    setText((CharSequence)localObject1);
    CharSequence localCharSequence = this.a.getContentDescription();
    Object localObject1 = localCharSequence;
    if (TextUtils.isEmpty(localCharSequence)) {
      if (m != 0) {
        localObject1 = null;
      } else {
        localObject1 = this.a.getTitle();
      }
    }
    setContentDescription((CharSequence)localObject1);
    localObject1 = this.a.getTooltipText();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (m != 0) {
        localObject1 = localObject2;
      } else {
        localObject1 = this.a.getTitle();
      }
      n0.a(this, (CharSequence)localObject1);
      return;
    }
    n0.a(this, (CharSequence)localObject1);
  }
  
  public boolean c()
  {
    return k();
  }
  
  public boolean d()
  {
    return true;
  }
  
  public boolean e()
  {
    return (k()) && (this.a.getIcon() == null);
  }
  
  public g getItemData()
  {
    return this.a;
  }
  
  public void j(g paramg, int paramInt)
  {
    this.a = paramg;
    setIcon(paramg.getIcon());
    setTitle(paramg.i(this));
    setId(paramg.getItemId());
    if (paramg.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    }
    setVisibility(paramInt);
    setEnabled(paramg.isEnabled());
    if ((paramg.hasSubMenu()) && (this.e == null)) {
      this.e = new a();
    }
  }
  
  public boolean k()
  {
    return TextUtils.isEmpty(getText()) ^ true;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.d;
    if (paramView != null) {
      paramView.a(this.a);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.g = l();
    m();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = k();
    if (bool)
    {
      m = this.j;
      if (m >= 0) {
        super.setPadding(m, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int n = getMeasuredWidth();
    if (m == -2147483648) {
      paramInt1 = Math.min(paramInt1, this.i);
    } else {
      paramInt1 = this.i;
    }
    if ((m != 1073741824) && (this.i > 0) && (n < paramInt1)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
    }
    if ((!bool) && (this.c != null)) {
      super.setPadding((getMeasuredWidth() - this.c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a.hasSubMenu())
    {
      w localw = this.e;
      if ((localw != null) && (localw.onTouch(this, paramMotionEvent))) {
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.h != paramBoolean)
    {
      this.h = paramBoolean;
      g localg = this.a;
      if (localg != null) {
        localg.c();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.c = paramDrawable;
    if (paramDrawable != null)
    {
      int i2 = paramDrawable.getIntrinsicWidth();
      int i3 = paramDrawable.getIntrinsicHeight();
      int i1 = this.k;
      int m = i2;
      int n = i3;
      float f1;
      if (i2 > i1)
      {
        f1 = i1 / i2;
        n = (int)(i3 * f1);
        m = i1;
      }
      if (n > i1)
      {
        f1 = i1 / n;
        m = (int)(m * f1);
      }
      else
      {
        i1 = n;
      }
      paramDrawable.setBounds(0, 0, m, i1);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    m();
  }
  
  public void setItemInvoker(e.b paramb)
  {
    this.d = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.j = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.f = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    m();
  }
  
  private class a
    extends w
  {
    public a()
    {
      super();
    }
    
    public e b()
    {
      ActionMenuItemView.b localb = ActionMenuItemView.this.f;
      if (localb != null) {
        return localb.a();
      }
      return null;
    }
    
    protected boolean c()
    {
      Object localObject = ActionMenuItemView.this;
      e.b localb = ((ActionMenuItemView)localObject).d;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localb != null)
      {
        bool1 = bool2;
        if (localb.a(((ActionMenuItemView)localObject).a))
        {
          localObject = b();
          bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (((e)localObject).c()) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
  }
  
  public static abstract class b
  {
    public abstract e a();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.appcompat.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */