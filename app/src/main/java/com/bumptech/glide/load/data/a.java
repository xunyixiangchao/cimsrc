package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;

public final class a
  extends l<AssetFileDescriptor>
{
  public a(ContentResolver paramContentResolver, Uri paramUri)
  {
    super(paramContentResolver, paramUri);
  }
  
  public Class<AssetFileDescriptor> a()
  {
    return AssetFileDescriptor.class;
  }
  
  protected void g(AssetFileDescriptor paramAssetFileDescriptor)
  {
    paramAssetFileDescriptor.close();
  }
  
  protected AssetFileDescriptor h(Uri paramUri, ContentResolver paramContentResolver)
  {
    paramContentResolver = paramContentResolver.openAssetFileDescriptor(paramUri, "r");
    if (paramContentResolver != null) {
      return paramContentResolver;
    }
    paramContentResolver = new StringBuilder();
    paramContentResolver.append("FileDescriptor is null for: ");
    paramContentResolver.append(paramUri);
    throw new FileNotFoundException(paramContentResolver.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.a
 * JD-Core Version:    0.7.0.1
 */