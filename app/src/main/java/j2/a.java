package j2;

import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder.DecodeException;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.OnPartialImageListener;
import android.graphics.ImageDecoder.Source;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Size;
import b2.b;
import b2.g;
import b2.h;
import b2.i;
import k2.l;
import k2.m;
import k2.r;

public final class a
  implements ImageDecoder.OnHeaderDecodedListener
{
  private final r a = r.b();
  private final int b;
  private final int c;
  private final b d;
  private final l e;
  private final boolean f;
  private final i g;
  
  public a(int paramInt1, int paramInt2, h paramh)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = ((b)paramh.c(m.f));
    this.e = ((l)paramh.c(l.h));
    g localg = m.j;
    boolean bool;
    if ((paramh.c(localg) != null) && (((Boolean)paramh.c(localg)).booleanValue())) {
      bool = true;
    } else {
      bool = false;
    }
    this.f = bool;
    this.g = ((i)paramh.c(m.g));
  }
  
  public void onHeaderDecoded(ImageDecoder paramImageDecoder, ImageDecoder.ImageInfo paramImageInfo, ImageDecoder.Source paramSource)
  {
    paramSource = this.a;
    int i = this.b;
    int j = this.c;
    boolean bool = this.f;
    int k = 0;
    if (paramSource.e(i, j, bool, false)) {
      paramImageDecoder.setAllocator(3);
    } else {
      paramImageDecoder.setAllocator(1);
    }
    if (this.d == b.b) {
      paramImageDecoder.setMemorySizePolicy(0);
    }
    paramImageDecoder.setOnPartialImageListener(new a());
    paramSource = paramImageInfo.getSize();
    j = this.b;
    i = j;
    if (j == -2147483648) {
      i = paramSource.getWidth();
    }
    int m = this.c;
    j = m;
    if (m == -2147483648) {
      j = paramSource.getHeight();
    }
    float f1 = this.e.b(paramSource.getWidth(), paramSource.getHeight(), i, j);
    i = Math.round(paramSource.getWidth() * f1);
    j = Math.round(paramSource.getHeight() * f1);
    if (Log.isLoggable("ImageDecoder", 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Resizing from [");
      localStringBuilder.append(paramSource.getWidth());
      localStringBuilder.append("x");
      localStringBuilder.append(paramSource.getHeight());
      localStringBuilder.append("] to [");
      localStringBuilder.append(i);
      localStringBuilder.append("x");
      localStringBuilder.append(j);
      localStringBuilder.append("] scaleFactor: ");
      localStringBuilder.append(f1);
      Log.v("ImageDecoder", localStringBuilder.toString());
    }
    paramImageDecoder.setTargetSize(i, j);
    paramSource = this.g;
    if (paramSource != null)
    {
      i = Build.VERSION.SDK_INT;
      if (i >= 28)
      {
        i = k;
        if (paramSource == i.b)
        {
          i = k;
          if (paramImageInfo.getColorSpace() != null)
          {
            i = k;
            if (paramImageInfo.getColorSpace().isWideGamut()) {
              i = 1;
            }
          }
        }
        if (i != 0)
        {
          paramImageInfo = ColorSpace.Named.DISPLAY_P3;
          break label382;
        }
      }
      else if (i < 26)
      {
        return;
      }
      paramImageInfo = ColorSpace.Named.SRGB;
      label382:
      paramImageDecoder.setTargetColorSpace(ColorSpace.get(paramImageInfo));
    }
  }
  
  class a
    implements ImageDecoder.OnPartialImageListener
  {
    a() {}
    
    public boolean onPartialImage(ImageDecoder.DecodeException paramDecodeException)
    {
      return false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     j2.a
 * JD-Core Version:    0.7.0.1
 */