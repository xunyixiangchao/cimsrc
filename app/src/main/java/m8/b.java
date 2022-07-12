package m8;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import b2.f;
import e2.d;
import java.security.MessageDigest;

public class b
  extends a
{
  private final int b;
  private final int c;
  
  public b()
  {
    this(25, 1);
  }
  
  public b(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void b(MessageDigest paramMessageDigest)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jp.wasabeef.glide.transformations.BlurTransformation.1");
    localStringBuilder.append(this.b);
    localStringBuilder.append(this.c);
    paramMessageDigest.update(localStringBuilder.toString().getBytes(f.a));
  }
  
  protected Bitmap d(Context paramContext, d paramd, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    paramInt1 = paramBitmap.getWidth();
    paramInt2 = paramBitmap.getHeight();
    int i = this.c;
    paramd = paramd.c(paramInt1 / i, paramInt2 / i, Bitmap.Config.ARGB_8888);
    c(paramBitmap, paramd);
    Canvas localCanvas = new Canvas(paramd);
    paramInt1 = this.c;
    localCanvas.scale(1.0F / paramInt1, 1.0F / paramInt1);
    Paint localPaint = new Paint();
    localPaint.setFlags(2);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    try
    {
      paramContext = n8.b.a(paramContext, paramd, this.b);
      return paramContext;
    }
    catch (RSRuntimeException paramContext)
    {
      label112:
      break label112;
    }
    return n8.a.a(paramd, this.b, true);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      if ((paramObject.b == this.b) && (paramObject.c == this.c)) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return 737513610 + this.b * 1000 + this.c * 10;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BlurTransformation(radius=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", sampling=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m8.b
 * JD-Core Version:    0.7.0.1
 */