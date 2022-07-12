package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.c;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import l1.b.e;
import s3.t;
import s3.v;
import u3.b0;

public class UserBannerHeaderView
  extends AppBarLayout
  implements View.OnClickListener, AppBarLayout.c, v
{
  private BannerView u;
  private TextView v;
  private WebImageView w;
  private CollapsingToolbarLayout x;
  private t y;
  private s3.b z;
  
  public UserBannerHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void I()
  {
    s3.b localb = this.z;
    if (localb != null) {
      localb.y0(this);
    }
  }
  
  private void J()
  {
    s3.b localb = this.z;
    if (localb != null) {
      localb.u0(this);
    }
  }
  
  public void F(long paramLong)
  {
    this.u.f(b0.k(paramLong));
  }
  
  public void G(String paramString)
  {
    this.u.f(paramString);
  }
  
  public void H(long paramLong)
  {
    this.w.o(b0.l(paramLong));
  }
  
  public void a(AppBarLayout paramAppBarLayout, int paramInt)
  {
    if (paramInt == 0)
    {
      J();
      return;
    }
    if (-paramInt == paramAppBarLayout.getTotalScrollRange()) {
      I();
    }
  }
  
  public void b(l1.b paramb)
  {
    paramb = paramb.m();
    if (paramb != null) {
      this.x.setContentScrimColor(paramb.e());
    }
  }
  
  public WebImageView getLogoView()
  {
    return this.w;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.y;
    if (paramView != null) {
      paramView.m0();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    e(this);
    this.x = ((CollapsingToolbarLayout)findViewById(2131230896));
    BannerView localBannerView = (BannerView)findViewById(2131231623);
    this.u = localBannerView;
    localBannerView.setOnPaletteCompletedListener(this);
    this.v = ((TextView)findViewById(2131231273));
    this.w = ((WebImageView)findViewById(2131231053));
    findViewById(2131231056).setOnClickListener(this);
  }
  
  public void setAppbarLayoutEventListener(s3.b paramb)
  {
    this.z = paramb;
  }
  
  public void setBannerResource(int paramInt)
  {
    this.u.setImageResource(paramInt);
  }
  
  public void setMotto(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.trim().length() == 0) {
        return;
      }
      this.v.setText(paramString.trim());
    }
  }
  
  public void setOnLogoClickedListener(t paramt)
  {
    this.y = paramt;
  }
  
  public void setTitle(String paramString)
  {
    this.x.setTitle(paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.UserBannerHeaderView
 * JD-Core Version:    0.7.0.1
 */