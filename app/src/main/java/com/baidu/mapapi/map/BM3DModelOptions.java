package com.baidu.mapapi.map;

import android.text.TextUtils;
import com.baidu.mapapi.model.LatLng;

public final class BM3DModelOptions
  extends OverlayOptions
{
  private String a;
  private String b;
  private LatLng c;
  private float d = 1.0F;
  private boolean e = false;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private boolean l = true;
  private BM3DModelType m = BM3DModelType.BM3DModelTypeObj;
  
  Overlay a()
  {
    BM3DModel localBM3DModel = new BM3DModel();
    if (!TextUtils.isEmpty(this.a))
    {
      localBM3DModel.e = this.a;
      if (!TextUtils.isEmpty(this.b))
      {
        localBM3DModel.f = this.b;
        LatLng localLatLng = this.c;
        if (localLatLng != null)
        {
          localBM3DModel.g = localLatLng;
          localBM3DModel.h = this.d;
          localBM3DModel.i = this.e;
          localBM3DModel.j = this.f;
          localBM3DModel.k = this.g;
          localBM3DModel.l = this.h;
          localBM3DModel.m = this.i;
          localBM3DModel.n = this.j;
          localBM3DModel.o = this.k;
          localBM3DModel.c = this.l;
          localBM3DModel.p = this.m;
          return localBM3DModel;
        }
        throw new IllegalArgumentException("BDMapSDKException: BM3DModel mPosition can not be null");
      }
      throw new IllegalArgumentException("BDMapSDKException: BM3DModel mModelName can not be null");
    }
    throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
  }
  
  public BM3DModelType getBM3DModelType()
  {
    return this.m;
  }
  
  public String getModelName()
  {
    return this.b;
  }
  
  public String getModelPath()
  {
    return this.a;
  }
  
  public float getOffsetX()
  {
    return this.i;
  }
  
  public float getOffsetY()
  {
    return this.j;
  }
  
  public float getOffsetZ()
  {
    return this.k;
  }
  
  public LatLng getPosition()
  {
    return this.c;
  }
  
  public float getRotateX()
  {
    return this.f;
  }
  
  public float getRotateY()
  {
    return this.g;
  }
  
  public float getRotateZ()
  {
    return this.h;
  }
  
  public float getScale()
  {
    return this.d;
  }
  
  public boolean isVisible()
  {
    return this.l;
  }
  
  public boolean isZoomFixed()
  {
    return this.e;
  }
  
  public BM3DModelOptions setBM3DModelType(BM3DModelType paramBM3DModelType)
  {
    this.m = paramBM3DModelType;
    return this;
  }
  
  public BM3DModelOptions setModelName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.b = paramString;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelName can not be null");
  }
  
  public BM3DModelOptions setModelPath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.a = paramString;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: BM3DModel modelPath can not be null");
  }
  
  public BM3DModelOptions setOffset(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.i = paramFloat1;
    this.j = paramFloat2;
    this.k = paramFloat3;
    return this;
  }
  
  public BM3DModelOptions setPosition(LatLng paramLatLng)
  {
    if (paramLatLng != null)
    {
      this.c = paramLatLng;
      return this;
    }
    throw new IllegalArgumentException("BDMapSDKException: BM3DModel position can not be null");
  }
  
  public BM3DModelOptions setRotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.h = paramFloat3;
    return this;
  }
  
  public BM3DModelOptions setScale(float paramFloat)
  {
    this.d = paramFloat;
    return this;
  }
  
  public BM3DModelOptions setZoomFixed(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public BM3DModelOptions visible(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }
  
  public static enum BM3DModelType
  {
    static
    {
      BM3DModelType localBM3DModelType1 = new BM3DModelType("BM3DModelTypeObj", 0);
      BM3DModelTypeObj = localBM3DModelType1;
      BM3DModelType localBM3DModelType2 = new BM3DModelType("BM3DModelTypeglTF", 1);
      BM3DModelTypeglTF = localBM3DModelType2;
      a = new BM3DModelType[] { localBM3DModelType1, localBM3DModelType2 };
    }
    
    private BM3DModelType() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.BM3DModelOptions
 * JD-Core Version:    0.7.0.1
 */