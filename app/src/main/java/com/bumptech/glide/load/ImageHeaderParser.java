package com.bumptech.glide.load;

import e2.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract interface ImageHeaderParser
{
  public abstract ImageType a(ByteBuffer paramByteBuffer);
  
  public abstract int b(ByteBuffer paramByteBuffer, b paramb);
  
  public abstract int c(InputStream paramInputStream, b paramb);
  
  public abstract ImageType d(InputStream paramInputStream);
  
  public static enum ImageType
  {
    private final boolean a;
    
    static
    {
      ImageType localImageType1 = new ImageType("GIF", 0, true);
      GIF = localImageType1;
      ImageType localImageType2 = new ImageType("JPEG", 1, false);
      JPEG = localImageType2;
      ImageType localImageType3 = new ImageType("RAW", 2, false);
      RAW = localImageType3;
      ImageType localImageType4 = new ImageType("PNG_A", 3, true);
      PNG_A = localImageType4;
      ImageType localImageType5 = new ImageType("PNG", 4, false);
      PNG = localImageType5;
      ImageType localImageType6 = new ImageType("WEBP_A", 5, true);
      WEBP_A = localImageType6;
      ImageType localImageType7 = new ImageType("WEBP", 6, false);
      WEBP = localImageType7;
      ImageType localImageType8 = new ImageType("ANIMATED_WEBP", 7, true);
      ANIMATED_WEBP = localImageType8;
      ImageType localImageType9 = new ImageType("AVIF", 8, true);
      AVIF = localImageType9;
      ImageType localImageType10 = new ImageType("UNKNOWN", 9, false);
      UNKNOWN = localImageType10;
      $VALUES = new ImageType[] { localImageType1, localImageType2, localImageType3, localImageType4, localImageType5, localImageType6, localImageType7, localImageType8, localImageType9, localImageType10 };
    }
    
    private ImageType(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    public boolean hasAlpha()
    {
      return this.a;
    }
    
    public boolean isWebp()
    {
      int i = ImageHeaderParser.a.a[ordinal()];
      return (i == 1) || (i == 2) || (i == 3);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.bumptech.glide.load.ImageHeaderParser
 * JD-Core Version:    0.7.0.1
 */