package z;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.e1;
import androidx.camera.core.e1.a;
import androidx.camera.core.n1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class b
{
  public static Rect a(Size paramSize, Rational paramRational)
  {
    if (!f(paramRational))
    {
      n1.k("ImageUtil", "Invalid view ratio.");
      return null;
    }
    int i = paramSize.getWidth();
    int k = paramSize.getHeight();
    float f1 = i;
    float f2 = k;
    float f3 = f1 / f2;
    int m = paramRational.getNumerator();
    int n = paramRational.getDenominator();
    float f4 = paramRational.floatValue();
    int j = 0;
    if (f4 > f3)
    {
      n = Math.round(f1 / m * n);
      m = (k - n) / 2;
      k = n;
    }
    else
    {
      m = Math.round(f2 / n * m);
      j = (i - m) / 2;
      i = m;
      m = 0;
    }
    return new Rect(j, m, i + j, k + m);
  }
  
  public static Rect b(Rect paramRect, int paramInt1, Size paramSize, int paramInt2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(paramInt2 - paramInt1);
    paramSize = o(paramSize);
    localMatrix.mapPoints(paramSize);
    float f1 = k(paramSize[0], paramSize[2], paramSize[4], paramSize[6]);
    float f2 = k(paramSize[1], paramSize[3], paramSize[5], paramSize[7]);
    localMatrix.postTranslate(-f1, -f2);
    localMatrix.invert(localMatrix);
    paramSize = new RectF();
    localMatrix.mapRect(paramSize, new RectF(paramRect));
    paramSize.sort();
    paramRect = new Rect();
    paramSize.round(paramRect);
    return paramRect;
  }
  
  private static byte[] c(byte[] paramArrayOfByte, Rect paramRect, int paramInt)
  {
    try
    {
      paramArrayOfByte = BitmapRegionDecoder.newInstance(paramArrayOfByte, 0, paramArrayOfByte.length, false);
      paramRect = paramArrayOfByte.decodeRegion(paramRect, new BitmapFactory.Options());
      paramArrayOfByte.recycle();
      if (paramRect != null)
      {
        paramArrayOfByte = new ByteArrayOutputStream();
        if (paramRect.compress(Bitmap.CompressFormat.JPEG, paramInt, paramArrayOfByte))
        {
          paramRect.recycle();
          return paramArrayOfByte.toByteArray();
        }
        throw new a("Encode bitmap failed.", b.a.a.a);
      }
      throw new a("Decode byte array failed.", b.a.a.b);
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      paramRect = new StringBuilder();
      paramRect.append("Decode byte array failed with illegal argument.");
      paramRect.append(paramArrayOfByte);
      throw new a(paramRect.toString(), b.a.a.b);
    }
    catch (IOException paramArrayOfByte)
    {
      label85:
      break label85;
    }
    throw new a("Decode byte array failed.", b.a.a.b);
  }
  
  public static Rational d(int paramInt, Rational paramRational)
  {
    if ((paramInt != 90) && (paramInt != 270)) {
      return new Rational(paramRational.getNumerator(), paramRational.getDenominator());
    }
    return e(paramRational);
  }
  
  private static Rational e(Rational paramRational)
  {
    if (paramRational == null) {
      return paramRational;
    }
    return new Rational(paramRational.getDenominator(), paramRational.getNumerator());
  }
  
  public static boolean f(Rational paramRational)
  {
    return (paramRational != null) && (paramRational.floatValue() > 0.0F) && (!paramRational.isNaN());
  }
  
  public static boolean g(Size paramSize, Rational paramRational)
  {
    return (paramRational != null) && (paramRational.floatValue() > 0.0F) && (h(paramSize, paramRational)) && (!paramRational.isNaN());
  }
  
  private static boolean h(Size paramSize, Rational paramRational)
  {
    int i = paramSize.getWidth();
    int j = paramSize.getHeight();
    int k = paramRational.getNumerator();
    int m = paramRational.getDenominator();
    float f2 = i;
    float f1 = k;
    f2 /= f1;
    float f3 = m;
    return (j != Math.round(f2 * f3)) || (i != Math.round(j / f3 * f1));
  }
  
  public static byte[] i(e1 parame1)
  {
    if (parame1.getFormat() == 256)
    {
      parame1 = parame1.j()[0].b();
      localObject = new byte[parame1.capacity()];
      parame1.rewind();
      parame1.get((byte[])localObject);
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Incorrect image format of the input image proxy: ");
    ((StringBuilder)localObject).append(parame1.getFormat());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static byte[] j(e1 parame1, Rect paramRect, int paramInt)
  {
    if (parame1.getFormat() == 256) {
      return c(i(parame1), paramRect, paramInt);
    }
    paramRect = new StringBuilder();
    paramRect.append("Incorrect image format of the input image proxy: ");
    paramRect.append(parame1.getFormat());
    throw new IllegalArgumentException(paramRect.toString());
  }
  
  public static float k(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.min(Math.min(paramFloat1, paramFloat2), Math.min(paramFloat3, paramFloat4));
  }
  
  private static byte[] l(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect, int paramInt3)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    YuvImage localYuvImage = new YuvImage(paramArrayOfByte, 17, paramInt1, paramInt2, null);
    paramArrayOfByte = paramRect;
    if (paramRect == null) {
      paramArrayOfByte = new Rect(0, 0, paramInt1, paramInt2);
    }
    if (localYuvImage.compressToJpeg(paramArrayOfByte, paramInt3, localByteArrayOutputStream)) {
      return localByteArrayOutputStream.toByteArray();
    }
    throw new a("YuvImage failed to encode jpeg.", b.a.a.a);
  }
  
  public static boolean m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (paramInt1 != paramInt3) || (paramInt2 != paramInt4);
  }
  
  public static boolean n(e1 parame1)
  {
    return m(parame1.getWidth(), parame1.getHeight(), parame1.C().width(), parame1.C().height());
  }
  
  public static float[] o(Size paramSize)
  {
    return new float[] { 0.0F, 0.0F, paramSize.getWidth(), 0.0F, paramSize.getWidth(), paramSize.getHeight(), 0.0F, paramSize.getHeight() };
  }
  
  public static byte[] p(e1 parame1, Rect paramRect, int paramInt)
  {
    if (parame1.getFormat() == 35) {
      return l(q(parame1), parame1.getWidth(), parame1.getHeight(), paramRect, paramInt);
    }
    paramRect = new StringBuilder();
    paramRect.append("Incorrect image format of the input image proxy: ");
    paramRect.append(parame1.getFormat());
    throw new IllegalArgumentException(paramRect.toString());
  }
  
  public static byte[] q(e1 parame1)
  {
    Object localObject = parame1.j()[0];
    e1.a locala1 = parame1.j()[1];
    e1.a locala2 = parame1.j()[2];
    ByteBuffer localByteBuffer3 = ((e1.a)localObject).b();
    ByteBuffer localByteBuffer1 = locala1.b();
    ByteBuffer localByteBuffer2 = locala2.b();
    localByteBuffer3.rewind();
    localByteBuffer1.rewind();
    localByteBuffer2.rewind();
    int k = localByteBuffer3.remaining();
    byte[] arrayOfByte = new byte[parame1.getWidth() * parame1.getHeight() / 2 + k];
    int j = 0;
    int i = j;
    while (j < parame1.getHeight())
    {
      localByteBuffer3.get(arrayOfByte, i, parame1.getWidth());
      i += parame1.getWidth();
      localByteBuffer3.position(Math.min(k, localByteBuffer3.position() - parame1.getWidth() + ((e1.a)localObject).a()));
      j += 1;
    }
    int i2 = parame1.getHeight() / 2;
    int i3 = parame1.getWidth() / 2;
    int i4 = locala2.a();
    int i5 = locala1.a();
    int i6 = locala2.c();
    int i7 = locala1.c();
    parame1 = new byte[i4];
    localObject = new byte[i5];
    j = 0;
    for (int i1 = i; j < i2; i1 = i)
    {
      localByteBuffer2.get(parame1, 0, Math.min(i4, localByteBuffer2.remaining()));
      localByteBuffer1.get((byte[])localObject, 0, Math.min(i5, localByteBuffer1.remaining()));
      int m = 0;
      i = m;
      k = i;
      int n = i;
      i = i1;
      while (m < i3)
      {
        i1 = i + 1;
        arrayOfByte[i] = parame1[n];
        i = i1 + 1;
        arrayOfByte[i1] = localObject[k];
        n += i6;
        k += i7;
        m += 1;
      }
      j += 1;
    }
    return arrayOfByte;
  }
  
  public static final class a
    extends Exception
  {
    private a a;
    
    a(String paramString, a parama)
    {
      super();
      this.a = parama;
    }
    
    public a a()
    {
      return this.a;
    }
    
    public static enum a
    {
      static
      {
        a locala1 = new a("ENCODE_FAILED", 0);
        a = locala1;
        a locala2 = new a("DECODE_FAILED", 1);
        b = locala2;
        a locala3 = new a("UNKNOWN", 2);
        c = locala3;
        d = new a[] { locala1, locala2, locala3 };
      }
      
      private a() {}
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z.b
 * JD-Core Version:    0.7.0.1
 */