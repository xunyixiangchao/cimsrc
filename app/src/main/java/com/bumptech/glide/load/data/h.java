package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

public class h
  extends b<AssetFileDescriptor>
{
  public h(AssetManager paramAssetManager, String paramString)
  {
    super(paramAssetManager, paramString);
  }
  
  public Class<AssetFileDescriptor> a()
  {
    return AssetFileDescriptor.class;
  }
  
  protected void g(AssetFileDescriptor paramAssetFileDescriptor)
  {
    paramAssetFileDescriptor.close();
  }
  
  protected AssetFileDescriptor h(AssetManager paramAssetManager, String paramString)
  {
    return paramAssetManager.openFd(paramString);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.h
 * JD-Core Version:    0.7.0.1
 */