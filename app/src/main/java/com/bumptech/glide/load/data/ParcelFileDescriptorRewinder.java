package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

public final class ParcelFileDescriptorRewinder
  implements e<ParcelFileDescriptor>
{
  private final InternalRewinder a;
  
  public ParcelFileDescriptorRewinder(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.a = new InternalRewinder(paramParcelFileDescriptor);
  }
  
  public static boolean c()
  {
    return true;
  }
  
  public void b() {}
  
  public ParcelFileDescriptor d()
  {
    return this.a.rewind();
  }
  
  private static final class InternalRewinder
  {
    private final ParcelFileDescriptor a;
    
    InternalRewinder(ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.a = paramParcelFileDescriptor;
    }
    
    ParcelFileDescriptor rewind()
    {
      try
      {
        Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
        return this.a;
      }
      catch (ErrnoException localErrnoException)
      {
        throw new IOException(localErrnoException);
      }
    }
  }
  
  public static final class a
    implements e.a<ParcelFileDescriptor>
  {
    public Class<ParcelFileDescriptor> a()
    {
      return ParcelFileDescriptor.class;
    }
    
    public e<ParcelFileDescriptor> c(ParcelFileDescriptor paramParcelFileDescriptor)
    {
      return new ParcelFileDescriptorRewinder(paramParcelFileDescriptor);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.data.ParcelFileDescriptorRewinder
 * JD-Core Version:    0.7.0.1
 */