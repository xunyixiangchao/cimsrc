package com.baidu.mapapi.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.platform.comjni.tools.ParcelItem;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.baidu.mapapi.map.BitmapDescriptor;>;
import java.util.Iterator;

public final class Marker
  extends Overlay
{
  float A = 1.0F;
  Point B;
  InfoWindow C;
  InfoWindow.a D;
  boolean E = false;
  int F = 2147483647;
  int G = 4;
  int H = 22;
  LatLng e;
  BitmapDescriptor f;
  float g;
  float h;
  boolean i;
  boolean j;
  float k;
  String l;
  int m;
  boolean n = false;
  boolean o = false;
  float p;
  int q;
  boolean r = false;
  boolean s = true;
  boolean t = false;
  boolean u = false;
  ArrayList<BitmapDescriptor> v;
  int w = 20;
  Animation x;
  float y = 1.0F;
  float z = 1.0F;
  
  Marker()
  {
    this.type = e.c;
  }
  
  private void a(InfoWindow paramInfoWindow1, InfoWindow paramInfoWindow2)
  {
    paramInfoWindow1.b = paramInfoWindow2.getBitmapDescriptor();
    paramInfoWindow1.d = paramInfoWindow2.getPosition();
    paramInfoWindow1.a = paramInfoWindow2.getTag();
    paramInfoWindow1.c = paramInfoWindow2.getView();
    paramInfoWindow1.g = paramInfoWindow2.getYOffset();
    paramInfoWindow1.k = paramInfoWindow2.k;
    paramInfoWindow1.e = paramInfoWindow2.e;
  }
  
  private void a(ArrayList<BitmapDescriptor> paramArrayList, Bundle paramBundle)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    int i2;
    int i1;
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      i2 = 0;
      i1 = 0;
      if (!bool) {
        break;
      }
      paramArrayList = (BitmapDescriptor)localIterator.next();
      ParcelItem localParcelItem = new ParcelItem();
      Bundle localBundle = new Bundle();
      paramArrayList = paramArrayList.a;
      Object localObject = ByteBuffer.allocate(paramArrayList.getWidth() * paramArrayList.getHeight() * 4);
      paramArrayList.copyPixelsToBuffer((Buffer)localObject);
      byte[] arrayOfByte = ((ByteBuffer)localObject).array();
      localBundle.putByteArray("image_data", arrayOfByte);
      localBundle.putInt("image_width", paramArrayList.getWidth());
      localBundle.putInt("image_height", paramArrayList.getHeight());
      paramArrayList = null;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        paramArrayList = (ArrayList<BitmapDescriptor>)localObject;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        localNoSuchAlgorithmException.printStackTrace();
      }
      if (paramArrayList != null)
      {
        paramArrayList.update(arrayOfByte, 0, arrayOfByte.length);
        paramArrayList = paramArrayList.digest();
        StringBuilder localStringBuilder = new StringBuilder("");
        while (i1 < paramArrayList.length)
        {
          localStringBuilder.append(Integer.toString((paramArrayList[i1] & 0xFF) + 256, 16).substring(1));
          i1 += 1;
        }
        localBundle.putString("image_hashcode", localStringBuilder.toString());
      }
      localParcelItem.setBundle(localBundle);
      localArrayList.add(localParcelItem);
    }
    if (localArrayList.size() > 0)
    {
      paramArrayList = new ParcelItem[localArrayList.size()];
      i1 = i2;
      while (i1 < localArrayList.size())
      {
        paramArrayList[i1] = ((ParcelItem)localArrayList.get(i1));
        i1 += 1;
      }
      paramBundle.putParcelableArray("icons", paramArrayList);
    }
  }
  
  Bundle a(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void cancelAnimation()
  {
    Animation localAnimation = this.x;
    if (localAnimation != null) {
      localAnimation.bdAnimation.cancelAnimation();
    }
  }
  
  public float getAlpha()
  {
    return this.p;
  }
  
  public float getAnchorX()
  {
    return this.g;
  }
  
  public float getAnchorY()
  {
    return this.h;
  }
  
  public int getEndLevel()
  {
    return this.H;
  }
  
  public Point getFixedPosition()
  {
    return this.B;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.f;
  }
  
  public ArrayList<BitmapDescriptor> getIcons()
  {
    return this.v;
  }
  
  public String getId()
  {
    return this.a;
  }
  
  public InfoWindow getInfoWindow()
  {
    return this.C;
  }
  
  public int getPeriod()
  {
    return this.w;
  }
  
  public LatLng getPosition()
  {
    return this.e;
  }
  
  public int getPriority()
  {
    return this.F;
  }
  
  public float getRotate()
  {
    return this.k;
  }
  
  public float getScale()
  {
    return this.A;
  }
  
  public float getScaleX()
  {
    return this.y;
  }
  
  public float getScaleY()
  {
    return this.z;
  }
  
  public int getStartLevel()
  {
    return this.G;
  }
  
  public String getTitle()
  {
    return this.l;
  }
  
  public int getYOffset()
  {
    return this.m;
  }
  
  public void hideInfoWindow()
  {
    InfoWindow.a locala = this.D;
    if (locala != null)
    {
      locala.a(this.C);
      this.E = false;
    }
    this.C = null;
  }
  
  public boolean isClickable()
  {
    return this.s;
  }
  
  public boolean isDraggable()
  {
    return this.j;
  }
  
  public boolean isFixed()
  {
    return this.r;
  }
  
  public boolean isFlat()
  {
    return this.n;
  }
  
  public boolean isForceDisplay()
  {
    return this.u;
  }
  
  public boolean isInfoWindowEnabled()
  {
    return this.E;
  }
  
  public boolean isJoinCollision()
  {
    return this.t;
  }
  
  public boolean isPerspective()
  {
    return this.i;
  }
  
  public void setAlpha(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0D))
    {
      this.p = paramFloat;
      this.listener.c(this);
      return;
    }
    this.p = 1.0F;
  }
  
  public void setAnchor(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F)
    {
      if (paramFloat1 > 1.0F) {
        return;
      }
      if (paramFloat2 >= 0.0F)
      {
        if (paramFloat2 > 1.0F) {
          return;
        }
        this.g = paramFloat1;
        this.h = paramFloat2;
        this.listener.c(this);
      }
    }
  }
  
  public void setAnimateType(int paramInt)
  {
    this.q = paramInt;
    this.listener.c(this);
  }
  
  public void setAnimation(Animation paramAnimation)
  {
    if (paramAnimation != null)
    {
      this.x = paramAnimation;
      paramAnimation.bdAnimation.setAnimation(this, paramAnimation);
    }
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.s = paramBoolean;
    this.listener.c(this);
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.listener.c(this);
  }
  
  public void setEndLevel(int paramInt)
  {
    this.H = paramInt;
    this.listener.c(this);
  }
  
  public void setFixedScreenPosition(Point paramPoint)
  {
    if (paramPoint != null)
    {
      this.B = paramPoint;
      this.r = true;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: the screenPosition can not be null");
  }
  
  public void setFlat(boolean paramBoolean)
  {
    this.n = paramBoolean;
    this.listener.c(this);
  }
  
  public void setForceDisplay(boolean paramBoolean)
  {
    this.u = paramBoolean;
    this.listener.c(this);
  }
  
  public void setIcon(BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramBitmapDescriptor != null)
    {
      this.f = paramBitmapDescriptor;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: marker's icon can not be null");
  }
  
  public void setIcons(ArrayList<BitmapDescriptor> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      int i2 = paramArrayList.size();
      int i1 = 0;
      if (i2 == 1) {}
      for (paramArrayList = (BitmapDescriptor)paramArrayList.get(0);; paramArrayList = null)
      {
        this.f = paramArrayList;
        break;
        while (i1 < paramArrayList.size()) {
          if (paramArrayList.get(i1) != null)
          {
            if (((BitmapDescriptor)paramArrayList.get(i1)).a == null) {
              return;
            }
            i1 += 1;
          }
          else
          {
            return;
          }
        }
        this.v = ((ArrayList)paramArrayList.clone());
      }
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: marker's icons can not be null");
  }
  
  public void setJoinCollision(boolean paramBoolean)
  {
    this.t = paramBoolean;
    this.listener.c(this);
  }
  
  public void setPeriod(int paramInt)
  {
    if (paramInt > 0)
    {
      this.w = paramInt;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: marker's period must be greater than zero ");
  }
  
  public void setPerspective(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.listener.c(this);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.e = paramLatLng;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
  }
  
  public void setPositionWithInfoWindow(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.e = paramLatLng;
      this.listener.c(this);
      InfoWindow localInfoWindow = this.C;
      if (localInfoWindow != null) {
        localInfoWindow.setPosition(paramLatLng);
      }
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: marker's position can not be null");
  }
  
  public void setPriority(int paramInt)
  {
    this.F = paramInt;
    this.listener.c(this);
  }
  
  public void setRotate(float paramFloat)
  {
    while (paramFloat < 0.0F) {
      paramFloat += 360.0F;
    }
    this.k = (paramFloat % 360.0F);
    this.listener.c(this);
  }
  
  public void setScale(float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat < 0.0F) {
      f1 = 0.0F;
    }
    this.y = f1;
    this.z = f1;
    this.listener.c(this);
  }
  
  public void setScaleX(float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat < 0.0F) {
      f1 = 0.0F;
    }
    this.y = f1;
    this.listener.c(this);
  }
  
  public void setScaleY(float paramFloat)
  {
    float f1 = paramFloat;
    if (paramFloat < 0.0F) {
      f1 = 0.0F;
    }
    this.z = f1;
    this.listener.c(this);
  }
  
  public void setStartLevel(int paramInt)
  {
    this.G = paramInt;
    this.listener.c(this);
  }
  
  public void setTitle(String paramString)
  {
    this.l = paramString;
  }
  
  public void setToTop()
  {
    this.o = true;
    this.listener.c(this);
  }
  
  public void setYOffset(int paramInt)
  {
    this.m = paramInt;
    this.listener.c(this);
  }
  
  public void showInfoWindow(InfoWindow paramInfoWindow)
  {
    if (paramInfoWindow != null)
    {
      InfoWindow localInfoWindow = this.C;
      if (localInfoWindow == null)
      {
        this.C = paramInfoWindow;
      }
      else
      {
        InfoWindow.a locala = this.D;
        if (locala != null) {
          locala.a(localInfoWindow);
        }
        a(this.C, paramInfoWindow);
      }
      paramInfoWindow = this.D;
      if (paramInfoWindow != null)
      {
        paramInfoWindow.b(this.C);
        this.E = true;
      }
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: the InfoWindow can not be null");
  }
  
  public void showSmoothMoveInfoWindow(InfoWindow paramInfoWindow)
  {
    if (paramInfoWindow == null) {
      return;
    }
    if (paramInfoWindow.k)
    {
      if (paramInfoWindow.c != null)
      {
        Object localObject = this.C;
        if (localObject == null) {
          this.C = paramInfoWindow;
        } else {
          a((InfoWindow)localObject, paramInfoWindow);
        }
        paramInfoWindow = this.C;
        paramInfoWindow.j = true;
        localObject = this.D;
        if (localObject != null)
        {
          ((InfoWindow.a)localObject).b(paramInfoWindow);
          this.E = true;
        }
        return;
      }
      throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow's View can not be null");
    }
    throw new IllegalArgumentException("BDMapSDKException: the SmoothMoveInfoWindow must build with View");
  }
  
  public void startAnimation()
  {
    Animation localAnimation = this.x;
    if (localAnimation != null) {
      localAnimation.bdAnimation.startAnimation();
    }
  }
  
  public void updateInfoWindowBitmapDescriptor(BitmapDescriptor paramBitmapDescriptor)
  {
    InfoWindow localInfoWindow = this.C;
    if ((localInfoWindow != null) && (!localInfoWindow.l)) {
      localInfoWindow.setBitmapDescriptor(paramBitmapDescriptor);
    }
  }
  
  public void updateInfoWindowPosition(LatLng paramLatLng)
  {
    InfoWindow localInfoWindow = this.C;
    if (localInfoWindow != null) {
      localInfoWindow.setPosition(paramLatLng);
    }
  }
  
  public void updateInfoWindowView(View paramView)
  {
    InfoWindow localInfoWindow = this.C;
    if ((localInfoWindow != null) && (localInfoWindow.k)) {
      localInfoWindow.setView(paramView);
    }
  }
  
  public void updateInfoWindowYOffset(int paramInt)
  {
    InfoWindow localInfoWindow = this.C;
    if (localInfoWindow != null) {
      localInfoWindow.setYOffset(paramInt);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.Marker
 * JD-Core Version:    0.7.0.1
 */