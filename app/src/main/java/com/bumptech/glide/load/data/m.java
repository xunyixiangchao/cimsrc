package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.InputStream;

public class m
  extends b<InputStream>
{
  public m(AssetManager paramAssetManager, String paramString)
  {
    super(paramAssetManager, paramString);
  }
  
  public Class<InputStream> a()
  {
    return InputStream.class;
  }
  
  protected void g(InputStream paramInputStream)
  {
    paramInputStream.close();
  }
  
  protected InputStream h(AssetManager paramAssetManager, String paramString)
  {
    return paramAssetManager.open(paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.m
 * JD-Core Version:    0.7.0.1
 */