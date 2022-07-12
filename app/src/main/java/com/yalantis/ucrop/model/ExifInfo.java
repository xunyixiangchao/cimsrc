package com.yalantis.ucrop.model;

public class ExifInfo
{
  private int mExifDegrees;
  private int mExifOrientation;
  private int mExifTranslation;
  
  public ExifInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mExifOrientation = paramInt1;
    this.mExifDegrees = paramInt2;
    this.mExifTranslation = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ExifInfo)paramObject;
      if (this.mExifOrientation != paramObject.mExifOrientation) {
        return false;
      }
      if (this.mExifDegrees != paramObject.mExifDegrees) {
        return false;
      }
      return this.mExifTranslation == paramObject.mExifTranslation;
    }
    return false;
  }
  
  public int getExifDegrees()
  {
    return this.mExifDegrees;
  }
  
  public int getExifOrientation()
  {
    return this.mExifOrientation;
  }
  
  public int getExifTranslation()
  {
    return this.mExifTranslation;
  }
  
  public int hashCode()
  {
    return (this.mExifOrientation * 31 + this.mExifDegrees) * 31 + this.mExifTranslation;
  }
  
  public void setExifDegrees(int paramInt)
  {
    this.mExifDegrees = paramInt;
  }
  
  public void setExifOrientation(int paramInt)
  {
    this.mExifOrientation = paramInt;
  }
  
  public void setExifTranslation(int paramInt)
  {
    this.mExifTranslation = paramInt;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.yalantis.ucrop.model.ExifInfo
 * JD-Core Version:    0.7.0.1
 */