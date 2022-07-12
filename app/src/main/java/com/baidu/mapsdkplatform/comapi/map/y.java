package com.baidu.mapsdkplatform.comapi.map;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.a;

public class y
  extends LinearLayout
  implements View.OnTouchListener
{
  private ImageView a;
  private ImageView b;
  private Context c;
  private Bitmap d;
  private Bitmap e;
  private Bitmap f;
  private Bitmap g;
  private Bitmap h;
  private Bitmap i;
  private Bitmap j;
  private Bitmap k;
  private int l;
  private boolean m;
  private boolean n = false;
  
  @Deprecated
  public y(Context paramContext)
  {
    super(paramContext);
    this.m = false;
    this.c = paramContext;
    a();
    if ((this.d != null) && (this.e != null) && (this.f != null))
    {
      if (this.g == null) {
        return;
      }
      this.a = new ImageView(this.c);
      this.b = new ImageView(this.c);
      this.a.setImageBitmap(this.d);
      this.b.setImageBitmap(this.f);
      this.l = a(this.f.getHeight() / 6);
      a(this.a, "main_topbtn_up.9.png");
      a(this.b, "main_bottombtn_up.9.png");
      this.a.setId(0);
      this.b.setId(1);
      this.a.setClickable(true);
      this.b.setClickable(true);
      this.a.setOnTouchListener(this);
      this.b.setOnTouchListener(this);
      setOrientation(1);
      setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      addView(this.a);
      addView(this.b);
      this.n = true;
    }
  }
  
  public y(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.c = paramContext;
    this.m = paramBoolean;
    this.a = new ImageView(this.c);
    this.b = new ImageView(this.c);
    if (paramBoolean)
    {
      b();
      if ((this.h != null) && (this.i != null) && (this.j != null))
      {
        if (this.k == null) {
          return;
        }
        this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.a.setImageBitmap(this.h);
        this.b.setImageBitmap(this.j);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(0);
      }
    }
    else
    {
      a();
      paramContext = this.d;
      if ((paramContext == null) || (this.e == null) || (this.f == null)) {
        return;
      }
      if (this.g == null) {
        return;
      }
      this.a.setImageBitmap(paramContext);
      this.b.setImageBitmap(this.f);
      this.l = a(this.f.getHeight() / 6);
      a(this.a, "main_topbtn_up.9.png");
      a(this.b, "main_bottombtn_up.9.png");
      setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      setOrientation(1);
    }
    this.a.setId(0);
    this.b.setId(1);
    this.a.setClickable(true);
    this.b.setClickable(true);
    this.a.setOnTouchListener(this);
    this.b.setOnTouchListener(this);
    addView(this.a);
    addView(this.b);
    this.n = true;
  }
  
  private int a(int paramInt)
  {
    return (int)(this.c.getResources().getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  private Bitmap a(String paramString)
  {
    Matrix localMatrix = new Matrix();
    int i1 = SysOSUtil.getDensityDpi();
    float f1;
    if (i1 > 480) {
      f1 = 1.8F;
    }
    for (;;)
    {
      localMatrix.postScale(f1, f1);
      break;
      if ((i1 > 320) && (i1 <= 480)) {
        f1 = 1.5F;
      } else {
        f1 = 1.2F;
      }
    }
    paramString = a.a(paramString, this.c);
    if (paramString == null) {
      return null;
    }
    return Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), localMatrix, true);
  }
  
  private void a()
  {
    this.d = a("main_icon_zoomin.png");
    this.e = a("main_icon_zoomin_dis.png");
    this.f = a("main_icon_zoomout.png");
    this.g = a("main_icon_zoomout_dis.png");
  }
  
  private void a(View paramView, String paramString)
  {
    paramString = a.a(paramString, this.c);
    byte[] arrayOfByte = paramString.getNinePatchChunk();
    NinePatch.isNinePatchChunk(arrayOfByte);
    paramView.setBackgroundDrawable(new NinePatchDrawable(paramString, arrayOfByte, new Rect(), null));
    int i1 = this.l;
    paramView.setPadding(i1, i1, i1, i1);
  }
  
  private void b()
  {
    this.h = a("wear_zoom_in.png");
    this.i = a("wear_zoom_in_pressed.png");
    this.j = a("wear_zoon_out.png");
    this.k = a("wear_zoom_out_pressed.png");
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).setEnabled(paramBoolean);
    ImageView localImageView;
    if (!paramBoolean)
    {
      localImageView = this.a;
      localObject = this.e;
    }
    else
    {
      localImageView = this.a;
      localObject = this.d;
    }
    localImageView.setImageBitmap((Bitmap)localObject);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).setEnabled(paramBoolean);
    ImageView localImageView;
    if (!paramBoolean)
    {
      localImageView = this.b;
      localObject = this.g;
    }
    else
    {
      localImageView = this.b;
      localObject = this.f;
    }
    localImageView.setImageBitmap((Bitmap)localObject);
  }
  
  public boolean c()
  {
    return this.n;
  }
  
  public void d()
  {
    Bitmap localBitmap = this.d;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.d.recycle();
      this.d = null;
    }
    localBitmap = this.e;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.e.recycle();
      this.e = null;
    }
    localBitmap = this.f;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.f.recycle();
      this.f = null;
    }
    localBitmap = this.g;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.g.recycle();
      this.g = null;
    }
    localBitmap = this.h;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.h.recycle();
      this.h = null;
    }
    localBitmap = this.i;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.i.recycle();
      this.i = null;
    }
    localBitmap = this.j;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.j.recycle();
      this.j = null;
    }
    localBitmap = this.k;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.k.recycle();
      this.k = null;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof ImageView))
    {
      int i1 = ((ImageView)paramView).getId();
      if (i1 != 0)
      {
        if (i1 != 1) {
          break label192;
        }
        if (paramMotionEvent.getAction() == 0)
        {
          if (!this.m)
          {
            paramView = this.b;
            paramMotionEvent = "main_bottombtn_down.9.png";
          }
          else
          {
            paramView = this.b;
            paramMotionEvent = this.k;
            break label145;
          }
        }
        else
        {
          if (paramMotionEvent.getAction() != 1) {
            break label192;
          }
          if (!this.m)
          {
            paramView = this.b;
            paramMotionEvent = "main_bottombtn_up.9.png";
          }
          else
          {
            paramView = this.b;
            paramMotionEvent = this.j;
            break label145;
          }
        }
      }
      else
      {
        if (paramMotionEvent.getAction() != 0) {
          break label153;
        }
        if (this.m) {
          break label135;
        }
        paramView = this.a;
        paramMotionEvent = "main_topbtn_down.9.png";
      }
      a(paramView, paramMotionEvent);
      break label192;
      label135:
      paramView = this.a;
      for (paramMotionEvent = this.i;; paramMotionEvent = this.h)
      {
        label145:
        paramView.setImageBitmap(paramMotionEvent);
        break label192;
        label153:
        if (paramMotionEvent.getAction() != 1) {
          break label192;
        }
        if (!this.m)
        {
          paramView = this.a;
          paramMotionEvent = "main_topbtn_up.9.png";
          break;
        }
        paramView = this.a;
      }
    }
    label192:
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.y
 * JD-Core Version:    0.7.0.1
 */