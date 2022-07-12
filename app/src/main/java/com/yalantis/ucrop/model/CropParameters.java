package com.yalantis.ucrop.model;

import android.graphics.Bitmap.CompressFormat;

public class CropParameters
{
  private Bitmap.CompressFormat mCompressFormat;
  private int mCompressQuality;
  private ExifInfo mExifInfo;
  private String mImageInputPath;
  private String mImageOutputPath;
  private int mMaxResultImageSizeX;
  private int mMaxResultImageSizeY;
  
  public CropParameters(int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString1, String paramString2, ExifInfo paramExifInfo)
  {
    this.mMaxResultImageSizeX = paramInt1;
    this.mMaxResultImageSizeY = paramInt2;
    this.mCompressFormat = paramCompressFormat;
    this.mCompressQuality = paramInt3;
    this.mImageInputPath = paramString1;
    this.mImageOutputPath = paramString2;
    this.mExifInfo = paramExifInfo;
  }
  
  public Bitmap.CompressFormat getCompressFormat()
  {
    return this.mCompressFormat;
  }
  
  public int getCompressQuality()
  {
    return this.mCompressQuality;
  }
  
  public ExifInfo getExifInfo()
  {
    return this.mExifInfo;
  }
  
  public String getImageInputPath()
  {
    return this.mImageInputPath;
  }
  
  public String getImageOutputPath()
  {
    return this.mImageOutputPath;
  }
  
  public int getMaxResultImageSizeX()
  {
    return this.mMaxResultImageSizeX;
  }
  
  public int getMaxResultImageSizeY()
  {
    return this.mMaxResultImageSizeY;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.model.CropParameters
 * JD-Core Version:    0.7.0.1
 */