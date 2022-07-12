package com.baidu.mapapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.e;

public final class BM3DModel
  extends Overlay
{
  String e;
  String f;
  LatLng g;
  float h = 1.0F;
  boolean i = false;
  float j;
  float k;
  float l;
  float m;
  float n;
  float o;
  BM3DModelOptions.BM3DModelType p = BM3DModelOptions.BM3DModelType.BM3DModelTypeObj;
  
  public BM3DModel()
  {
    this.type = e.m;
  }
  
  Bundle a(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public BM3DModelOptions.BM3DModelType getBM3DModelType()
  {
    return this.p;
  }
  
  public String getModelName()
  {
    return this.f;
  }
  
  public String getModelPath()
  {
    return this.e;
  }
  
  public float getOffsetX()
  {
    return this.m;
  }
  
  public float getOffsetY()
  {
    return this.n;
  }
  
  public float getOffsetZ()
  {
    return this.o;
  }
  
  public LatLng getPosition()
  {
    return this.g;
  }
  
  public float getRotateX()
  {
    return this.j;
  }
  
  public float getRotateY()
  {
    return this.k;
  }
  
  public float getRotateZ()
  {
    return this.l;
  }
  
  public float getScale()
  {
    return this.h;
  }
  
  public boolean isZoomFixed()
  {
    return this.i;
  }
  
  public void setBM3DModelType(BM3DModelOptions.BM3DModelType paramBM3DModelType)
  {
    this.p = paramBM3DModelType;
    this.listener.c(this);
  }
  
  public void setModelName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.f = paramString;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
  }
  
  public void setModelPath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.e = paramString;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
  }
  
  public void setOffset(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.m = paramFloat1;
    this.n = paramFloat2;
    this.o = paramFloat3;
    this.listener.c(this);
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.g = paramLatLng;
      this.listener.c(this);
      return;
    }
    throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
  }
  
  public void setRotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.j = paramFloat1;
    this.k = paramFloat2;
    this.l = paramFloat3;
    this.listener.c(this);
  }
  
  public void setScale(float paramFloat)
  {
    this.h = paramFloat;
    this.listener.c(this);
  }
  
  public void setZoomFixed(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.listener.c(this);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.BM3DModel
 * JD-Core Version:    0.7.0.1
 */