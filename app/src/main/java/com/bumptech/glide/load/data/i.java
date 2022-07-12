package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;

public class i
  extends l<ParcelFileDescriptor>
{
  public i(ContentResolver paramContentResolver, Uri paramUri)
  {
    super(paramContentResolver, paramUri);
  }
  
  public Class<ParcelFileDescriptor> a()
  {
    return ParcelFileDescriptor.class;
  }
  
  protected void g(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    paramParcelFileDescriptor.close();
  }
  
  protected ParcelFileDescriptor h(Uri paramUri, ContentResolver paramContentResolver)
  {
    paramContentResolver = paramContentResolver.openAssetFileDescriptor(paramUri, "r");
    if (paramContentResolver != null) {
      return paramContentResolver.getParcelFileDescriptor();
    }
    paramContentResolver = new StringBuilder();
    paramContentResolver.append("FileDescriptor is null for: ");
    paramContentResolver.append(paramUri);
    throw new FileNotFoundException(paramContentResolver.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.i
 * JD-Core Version:    0.7.0.1
 */