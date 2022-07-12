package com.farsunset.hoxin.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import l1.b;
import l1.b.b;
import s3.d;
import s3.v;
import u3.r;
import u3.s;
import v3.a;

public class BannerView
  extends AppCompatImageView
{
  private v a;
  
  public BannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private int b(int paramInt)
  {
    return (int)(paramInt * 0.6F);
  }
  
  private void g(Bitmap paramBitmap)
  {
    if (this.a == null) {
      return;
    }
    b.b(paramBitmap).a(new a(this));
  }
  
  public void f(String paramString)
  {
    s.a().g(paramString, new a());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    setMeasuredDimension(paramInt1, b(paramInt1));
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    g(paramBitmap);
  }
  
  public void setImageResource(int paramInt)
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
    setImageBitmap(localBitmap);
    g(localBitmap);
  }
  
  public void setOnPaletteCompletedListener(v paramv)
  {
    this.a = paramv;
    paramv = ((BitmapDrawable)getDrawable()).getBitmap();
    if (paramv != null) {
      g(paramv);
    }
  }
  
  class a
    implements d
  {
    a() {}
    
    public void D0(Object paramObject, Bitmap paramBitmap)
    {
      BannerView.this.setImageBitmap(paramBitmap);
    }
    
    public void v(Object paramObject) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.widget.BannerView
 * JD-Core Version:    0.7.0.1
 */