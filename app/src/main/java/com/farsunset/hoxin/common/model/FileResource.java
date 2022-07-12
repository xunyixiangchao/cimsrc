package com.farsunset.hoxin.common.model;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;
import com.farsunset.hoxin.HoxinApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import o3.b;

public class FileResource
{
  public b bucket;
  public InputStream file;
  public String name;
  
  public static FileResource of(b paramb, String paramString, Uri paramUri)
  {
    FileResource localFileResource = new FileResource();
    localFileResource.name = paramString;
    try
    {
      localFileResource.file = HoxinApplication.h().getContentResolver().openInputStream(paramUri);
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    localFileResource.bucket = paramb;
    return localFileResource;
  }
  
  public static FileResource of(b paramb, String paramString, File paramFile)
  {
    FileResource localFileResource = new FileResource();
    localFileResource.name = paramString;
    localFileResource.bucket = paramb;
    try
    {
      localFileResource.file = new FileInputStream(paramFile);
      return localFileResource;
    }
    catch (FileNotFoundException paramb)
    {
      paramb.printStackTrace();
    }
    return localFileResource;
  }
  
  public static FileResource of(b paramb, String paramString, InputStream paramInputStream)
  {
    FileResource localFileResource = new FileResource();
    localFileResource.name = paramString;
    localFileResource.file = paramInputStream;
    localFileResource.bucket = paramb;
    return localFileResource;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.common.model.FileResource
 * JD-Core Version:    0.7.0.1
 */