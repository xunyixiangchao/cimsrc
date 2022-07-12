package z1;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class e
  implements a
{
  private static final String u = "e";
  private int[] a;
  private final int[] b = new int[256];
  private final a.a c;
  private ByteBuffer d;
  private byte[] e;
  private short[] f;
  private byte[] g;
  private byte[] h;
  private byte[] i;
  private int[] j;
  private int k;
  private c l;
  private Bitmap m;
  private boolean n;
  private int o;
  private int p;
  private int q;
  private int r;
  private Boolean s;
  private Bitmap.Config t = Bitmap.Config.ARGB_8888;
  
  public e(a.a parama)
  {
    this.c = parama;
    this.l = new c();
  }
  
  public e(a.a parama, c paramc, ByteBuffer paramByteBuffer, int paramInt)
  {
    this(parama);
    p(paramc, paramByteBuffer, paramInt);
  }
  
  private int h(int paramInt1, int paramInt2, int paramInt3)
  {
    int i6 = paramInt1;
    int i5 = 0;
    int i4 = i5;
    int i3 = i4;
    int i2 = i3;
    byte[] arrayOfByte;
    int i11;
    int i9;
    int i8;
    for (int i1 = i2; i6 < this.p + paramInt1; i1 = i7)
    {
      arrayOfByte = this.i;
      if ((i6 >= arrayOfByte.length) || (i6 >= paramInt2)) {
        break;
      }
      i7 = arrayOfByte[i6];
      int i12 = this.a[(i7 & 0xFF)];
      i11 = i5;
      i10 = i4;
      i9 = i3;
      i8 = i2;
      i7 = i1;
      if (i12 != 0)
      {
        i11 = i5 + (i12 >> 24 & 0xFF);
        i10 = i4 + (i12 >> 16 & 0xFF);
        i9 = i3 + (i12 >> 8 & 0xFF);
        i8 = i2 + (i12 & 0xFF);
        i7 = i1 + 1;
      }
      i6 += 1;
      i5 = i11;
      i4 = i10;
      i3 = i9;
      i2 = i8;
    }
    int i10 = paramInt1 + paramInt3;
    paramInt1 = i10;
    int i7 = i5;
    while (paramInt1 < this.p + i10)
    {
      arrayOfByte = this.i;
      if ((paramInt1 >= arrayOfByte.length) || (paramInt1 >= paramInt2)) {
        break;
      }
      paramInt3 = arrayOfByte[paramInt1];
      i11 = this.a[(paramInt3 & 0xFF)];
      i9 = i7;
      i8 = i4;
      i6 = i3;
      i5 = i2;
      paramInt3 = i1;
      if (i11 != 0)
      {
        i9 = i7 + (i11 >> 24 & 0xFF);
        i8 = i4 + (i11 >> 16 & 0xFF);
        i6 = i3 + (i11 >> 8 & 0xFF);
        i5 = i2 + (i11 & 0xFF);
        paramInt3 = i1 + 1;
      }
      paramInt1 += 1;
      i7 = i9;
      i4 = i8;
      i3 = i6;
      i2 = i5;
      i1 = paramInt3;
    }
    if (i1 == 0) {
      return 0;
    }
    return i7 / i1 << 24 | i4 / i1 << 16 | i3 / i1 << 8 | i2 / i1;
  }
  
  private void i(b paramb)
  {
    int[] arrayOfInt1 = this.j;
    int i1 = paramb.d;
    int i16 = this.p;
    int i9 = i1 / i16;
    i1 = paramb.b / i16;
    int i4 = paramb.c / i16;
    int i17 = paramb.a / i16;
    int i8;
    if (this.k == 0) {
      i8 = 1;
    } else {
      i8 = 0;
    }
    int i18 = this.r;
    int i19 = this.q;
    byte[] arrayOfByte = this.i;
    int[] arrayOfInt2 = this.a;
    Object localObject1 = this.s;
    int i5 = 8;
    int i6 = 0;
    int i2 = 0;
    int i10;
    for (int i3 = 1; i6 < i9; i3 = i10)
    {
      int i7;
      int i11;
      if (paramb.e)
      {
        if (i2 >= i9)
        {
          i3 += 1;
          if (i3 != 2)
          {
            if (i3 != 3)
            {
              i7 = i3;
              if (i3 != 4)
              {
                i3 = i7;
              }
              else
              {
                i2 = 1;
                i5 = 2;
                i3 = i7;
              }
            }
            else
            {
              i5 = 4;
              i2 = 2;
            }
          }
          else {
            i2 = 4;
          }
        }
        i7 = i2 + i5;
        i11 = i2;
        i10 = i3;
      }
      else
      {
        i11 = i6;
        i10 = i3;
        i7 = i2;
      }
      i3 = i11 + i1;
      if (i16 == 1) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (i3 < i19)
      {
        i11 = i3 * i18;
        int i12 = i11 + i17;
        i3 = i12 + i4;
        int i13 = i11 + i18;
        i11 = i3;
        if (i13 < i3) {
          i11 = i13;
        }
        i13 = i6 * i16 * paramb.c;
        if (i2 != 0)
        {
          i2 = i12;
          for (;;)
          {
            i3 = i1;
            localObject2 = localObject1;
            if (i2 >= i11) {
              break;
            }
            i3 = arrayOfInt2[(arrayOfByte[i13] & 0xFF)];
            if (i3 != 0)
            {
              arrayOfInt1[i2] = i3;
              localObject2 = localObject1;
            }
            else
            {
              localObject2 = localObject1;
              if (i8 != 0)
              {
                localObject2 = localObject1;
                if (localObject1 == null) {
                  localObject2 = Boolean.TRUE;
                }
              }
            }
            i13 += i16;
            i2 += 1;
            localObject1 = localObject2;
          }
        }
        int i14 = i1;
        i3 = i12;
        i2 = i13;
        i1 = i4;
        i4 = i3;
        for (;;)
        {
          int i15 = i2;
          i3 = i14;
          localObject2 = localObject1;
          i2 = i1;
          if (i4 >= i11) {
            break;
          }
          i2 = h(i15, (i11 - i12) * i16 + i13, paramb.c);
          if (i2 != 0)
          {
            arrayOfInt1[i4] = i2;
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if (i8 != 0)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = Boolean.TRUE;
              }
            }
          }
          i2 = i15 + i16;
          i4 += 1;
          localObject1 = localObject2;
        }
      }
      Object localObject2 = localObject1;
      i3 = i1;
      i2 = i4;
      localObject1 = localObject2;
      i6 += 1;
      i1 = i3;
      i4 = i2;
      i2 = i7;
    }
    if (this.s == null)
    {
      boolean bool;
      if (localObject1 == null) {
        bool = false;
      } else {
        bool = ((Boolean)localObject1).booleanValue();
      }
      this.s = Boolean.valueOf(bool);
    }
  }
  
  private void j(b paramb)
  {
    Object localObject = paramb;
    int[] arrayOfInt1 = this.j;
    int i4 = ((b)localObject).d;
    int i10 = ((b)localObject).b;
    int i11 = ((b)localObject).c;
    int i12 = ((b)localObject).a;
    int i1;
    if (this.k == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i13 = this.r;
    localObject = this.i;
    int[] arrayOfInt2 = this.a;
    int i2 = 0;
    int i6 = -1;
    while (i2 < i4)
    {
      int i3 = (i2 + i10) * i13;
      int i5 = i3 + i12;
      int i7 = i5 + i11;
      int i8 = i3 + i13;
      i3 = i7;
      if (i8 < i7) {
        i3 = i8;
      }
      i7 = paramb.c * i2;
      while (i5 < i3)
      {
        int i9 = localObject[i7];
        int i14 = i9 & 0xFF;
        i8 = i6;
        if (i14 != i6)
        {
          i8 = arrayOfInt2[i14];
          if (i8 != 0)
          {
            arrayOfInt1[i5] = i8;
            i8 = i6;
          }
          else
          {
            i8 = i9;
          }
        }
        i7 += 1;
        i5 += 1;
        i6 = i8;
      }
      i2 += 1;
    }
    paramb = this.s;
    boolean bool;
    if (((paramb != null) && (paramb.booleanValue())) || ((this.s == null) && (i1 != 0) && (i6 != -1))) {
      bool = true;
    } else {
      bool = false;
    }
    this.s = Boolean.valueOf(bool);
  }
  
  private void k(b paramb)
  {
    Object localObject = this;
    if (paramb != null) {
      ((e)localObject).d.position(paramb.j);
    }
    if (paramb == null)
    {
      paramb = ((e)localObject).l;
      i3 = paramb.f;
      i2 = paramb.g;
    }
    else
    {
      i3 = paramb.c;
      i2 = paramb.d;
    }
    int i22 = i3 * i2;
    paramb = ((e)localObject).i;
    if ((paramb == null) || (paramb.length < i22)) {
      ((e)localObject).i = ((e)localObject).c.c(i22);
    }
    byte[] arrayOfByte1 = ((e)localObject).i;
    if (((e)localObject).f == null) {
      ((e)localObject).f = new short[4096];
    }
    short[] arrayOfShort = ((e)localObject).f;
    if (((e)localObject).g == null) {
      ((e)localObject).g = new byte[4096];
    }
    byte[] arrayOfByte2 = ((e)localObject).g;
    if (((e)localObject).h == null) {
      ((e)localObject).h = new byte[4097];
    }
    paramb = ((e)localObject).h;
    int i2 = o();
    int i23 = 1 << i2;
    int i8 = i23 + 2;
    int i17 = i2 + 1;
    int i15 = (1 << i17) - 1;
    int i16 = 0;
    i2 = 0;
    while (i2 < i23)
    {
      arrayOfShort[i2] = 0;
      arrayOfByte2[i2] = ((byte)i2);
      i2 += 1;
    }
    localObject = ((e)localObject).e;
    int i3 = i17;
    i2 = i8;
    int i11 = i15;
    int i10 = 0;
    int i13 = i10;
    int i7 = i13;
    int i14 = i7;
    int i6 = i14;
    int i5 = i6;
    int i12 = i5;
    int i4 = -1;
    int i9 = i6;
    i6 = i8;
    i8 = i17;
    while (i16 < i22)
    {
      i17 = i10;
      if (i10 == 0)
      {
        i17 = n();
        if (i17 <= 0)
        {
          this.o = 3;
          break;
        }
        i13 = 0;
      }
      i14 += ((localObject[i13] & 0xFF) << i7);
      int i19 = i13 + 1;
      int i20 = i17 - 1;
      i17 = i7 + 8;
      i7 = i2;
      i2 = i4;
      i13 = i5;
      i4 = i3;
      i10 = i16;
      i3 = i6;
      i5 = i7;
      i6 = i13;
      i7 = i17;
      for (;;)
      {
        if (i7 < i4) {
          break label793;
        }
        i13 = i14 & i11;
        i14 >>= i4;
        i7 -= i4;
        if (i13 == i23)
        {
          i11 = i15;
          i4 = i8;
          i13 = i3;
          i2 = -1;
          i5 = i3;
          i3 = i13;
        }
        else
        {
          int i18;
          if (i13 == i23 + 1)
          {
            i17 = i6;
            i18 = i5;
            i6 = i3;
            i5 = i2;
            i3 = i4;
            i16 = i10;
            i10 = i20;
            i13 = i19;
            i2 = i18;
            i4 = i5;
            i5 = i17;
            break;
          }
          if (i2 == -1)
          {
            arrayOfByte1[i9] = arrayOfByte2[i13];
            i9 += 1;
            i10 += 1;
            i2 = i13;
            i6 = i2;
          }
          else
          {
            if (i13 >= i5)
            {
              paramb[i12] = ((byte)i6);
              i6 = i12 + 1;
              i12 = i2;
            }
            else
            {
              i16 = i13;
              i6 = i12;
            }
            for (i12 = i16; i12 >= i23; i12 = arrayOfShort[i12])
            {
              paramb[i6] = arrayOfByte2[i12];
              i6 += 1;
            }
            int i21 = arrayOfByte2[i12] & 0xFF;
            int i1 = (byte)i21;
            arrayOfByte1[i9] = i1;
            i12 = i6;
            for (;;)
            {
              i9 += 1;
              i10 += 1;
              if (i12 <= 0) {
                break;
              }
              i12 -= 1;
              arrayOfByte1[i9] = paramb[i12];
            }
            i18 = i5;
            i17 = i4;
            i16 = i11;
            if (i5 < 4096)
            {
              arrayOfShort[i5] = ((short)i2);
              arrayOfByte2[i5] = i1;
              i2 = i5 + 1;
              i18 = i2;
              i17 = i4;
              i16 = i11;
              if ((i2 & i11) == 0)
              {
                i18 = i2;
                i17 = i4;
                i16 = i11;
                if (i2 < 4096)
                {
                  i17 = i4 + 1;
                  i16 = i11 + i2;
                  i18 = i2;
                }
              }
            }
            i2 = i13;
            i6 = i21;
            i5 = i18;
            i4 = i17;
            i11 = i16;
          }
        }
      }
      label793:
      i17 = i2;
      i2 = i5;
      i5 = i6;
      i6 = i3;
      i16 = i10;
      i10 = i20;
      i13 = i19;
      i3 = i4;
      i4 = i17;
    }
    Arrays.fill(arrayOfByte1, i9, i22, (byte)0);
  }
  
  private Bitmap m()
  {
    Object localObject = this.s;
    if ((localObject != null) && (!((Boolean)localObject).booleanValue())) {
      localObject = this.t;
    } else {
      localObject = Bitmap.Config.ARGB_8888;
    }
    localObject = this.c.a(this.r, this.q, (Bitmap.Config)localObject);
    ((Bitmap)localObject).setHasAlpha(true);
    return localObject;
  }
  
  private int n()
  {
    int i1 = o();
    if (i1 <= 0) {
      return i1;
    }
    ByteBuffer localByteBuffer = this.d;
    localByteBuffer.get(this.e, 0, Math.min(i1, localByteBuffer.remaining()));
    return i1;
  }
  
  private int o()
  {
    return this.d.get() & 0xFF;
  }
  
  private Bitmap q(b paramb1, b paramb2)
  {
    int[] arrayOfInt = this.j;
    int i1 = 0;
    Object localObject;
    if (paramb2 == null)
    {
      localObject = this.m;
      if (localObject != null) {
        this.c.f((Bitmap)localObject);
      }
      this.m = null;
      Arrays.fill(arrayOfInt, 0);
    }
    if ((paramb2 != null) && (paramb2.g == 3) && (this.m == null)) {
      Arrays.fill(arrayOfInt, 0);
    }
    if (paramb2 != null)
    {
      int i2 = paramb2.g;
      if (i2 > 0)
      {
        if (i2 == 2)
        {
          i2 = i1;
          if (!paramb1.f)
          {
            localObject = this.l;
            i2 = ((c)localObject).l;
            if ((paramb1.k != null) && (((c)localObject).j == paramb1.h)) {
              i2 = i1;
            }
          }
          i1 = paramb2.d;
          int i3 = this.p;
          int i5 = i1 / i3;
          i1 = paramb2.b / i3;
          int i6 = paramb2.c / i3;
          i3 = paramb2.a / i3;
          int i7 = this.r;
          int i4 = i1 * i7 + i3;
          i1 = i4;
          while (i1 < i5 * i7 + i4)
          {
            i3 = i1;
            while (i3 < i1 + i6)
            {
              arrayOfInt[i3] = i2;
              i3 += 1;
            }
            i1 += this.r;
          }
        }
        if (i2 == 3)
        {
          paramb2 = this.m;
          if (paramb2 != null)
          {
            i1 = this.r;
            paramb2.getPixels(arrayOfInt, 0, i1, 0, 0, i1, this.q);
          }
        }
      }
    }
    k(paramb1);
    if ((!paramb1.e) && (this.p == 1)) {
      j(paramb1);
    } else {
      i(paramb1);
    }
    if (this.n)
    {
      i1 = paramb1.g;
      if ((i1 == 0) || (i1 == 1))
      {
        if (this.m == null) {
          this.m = m();
        }
        paramb1 = this.m;
        i1 = this.r;
        paramb1.setPixels(arrayOfInt, 0, i1, 0, 0, i1, this.q);
      }
    }
    paramb1 = m();
    i1 = this.r;
    paramb1.setPixels(arrayOfInt, 0, i1, 0, 0, i1, this.q);
    return paramb1;
  }
  
  public int a()
  {
    return this.k;
  }
  
  public void b()
  {
    this.k = ((this.k + 1) % this.l.c);
  }
  
  public int c()
  {
    return this.l.c;
  }
  
  public void clear()
  {
    this.l = null;
    Object localObject = this.i;
    if (localObject != null) {
      this.c.b((byte[])localObject);
    }
    localObject = this.j;
    if (localObject != null) {
      this.c.d((int[])localObject);
    }
    localObject = this.m;
    if (localObject != null) {
      this.c.f((Bitmap)localObject);
    }
    this.m = null;
    this.d = null;
    this.s = null;
    localObject = this.e;
    if (localObject != null) {
      this.c.b((byte[])localObject);
    }
  }
  
  public int d()
  {
    if (this.l.c > 0)
    {
      int i1 = this.k;
      if (i1 >= 0) {
        return l(i1);
      }
    }
    return 0;
  }
  
  public int e()
  {
    return this.d.limit() + this.i.length + this.j.length * 4;
  }
  
  public void f(Bitmap.Config paramConfig)
  {
    if ((paramConfig != Bitmap.Config.ARGB_8888) && (paramConfig != Bitmap.Config.RGB_565))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unsupported format: ");
      localStringBuilder.append(paramConfig);
      localStringBuilder.append(", must be one of ");
      localStringBuilder.append(Bitmap.Config.ARGB_8888);
      localStringBuilder.append(" or ");
      localStringBuilder.append(Bitmap.Config.RGB_565);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.t = paramConfig;
  }
  
  public void g()
  {
    this.k = -1;
  }
  
  public ByteBuffer getData()
  {
    return this.d;
  }
  
  public Bitmap getNextFrame()
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        Object localObject4;
        if ((this.l.c <= 0) || (this.k < 0))
        {
          localObject1 = u;
          if (Log.isLoggable((String)localObject1, 3))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Unable to decode frame, frameCount=");
            ((StringBuilder)localObject4).append(this.l.c);
            ((StringBuilder)localObject4).append(", framePointer=");
            ((StringBuilder)localObject4).append(this.k);
            Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
          }
          this.o = 1;
        }
        int i1 = this.o;
        if ((i1 != 1) && (i1 != 2))
        {
          this.o = 0;
          if (this.e == null) {
            this.e = this.c.c(255);
          }
          b localb = (b)this.l.e.get(this.k);
          i1 = this.k - 1;
          if (i1 >= 0)
          {
            localObject1 = (b)this.l.e.get(i1);
            localObject4 = localb.k;
            if (localObject4 == null) {
              localObject4 = this.l.a;
            }
            this.a = ((int[])localObject4);
            if (localObject4 == null)
            {
              localObject1 = u;
              if (Log.isLoggable((String)localObject1, 3))
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("No valid color table found for frame #");
                ((StringBuilder)localObject4).append(this.k);
                Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
              }
              this.o = 1;
              return null;
            }
            if (localb.f)
            {
              System.arraycopy(localObject4, 0, this.b, 0, localObject4.length);
              localObject4 = this.b;
              this.a = ((int[])localObject4);
              localObject4[localb.h] = 0;
              if ((localb.g == 2) && (this.k == 0)) {
                this.s = Boolean.TRUE;
              }
            }
            localObject1 = q(localb, (b)localObject1);
            return localObject1;
          }
        }
        else
        {
          localObject1 = u;
          if (Log.isLoggable((String)localObject1, 3))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("Unable to decode frame, status=");
            ((StringBuilder)localObject4).append(this.o);
            Log.d((String)localObject1, ((StringBuilder)localObject4).toString());
          }
          return null;
        }
      }
      finally {}
      Object localObject3 = null;
    }
  }
  
  public int l(int paramInt)
  {
    if (paramInt >= 0)
    {
      c localc = this.l;
      if (paramInt < localc.c) {
        return ((b)localc.e.get(paramInt)).i;
      }
    }
    return -1;
  }
  
  public void p(c paramc, ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramInt > 0) {
      try
      {
        paramInt = Integer.highestOneBit(paramInt);
        this.o = 0;
        this.l = paramc;
        this.k = -1;
        paramByteBuffer = paramByteBuffer.asReadOnlyBuffer();
        this.d = paramByteBuffer;
        paramByteBuffer.position(0);
        this.d.order(ByteOrder.LITTLE_ENDIAN);
        this.n = false;
        paramByteBuffer = paramc.e.iterator();
        while (paramByteBuffer.hasNext()) {
          if (((b)paramByteBuffer.next()).g == 3) {
            this.n = true;
          }
        }
        this.p = paramInt;
        int i1 = paramc.f;
        this.r = (i1 / paramInt);
        int i2 = paramc.g;
        this.q = (i2 / paramInt);
        this.i = this.c.c(i1 * i2);
        this.j = this.c.e(this.r * this.q);
        return;
      }
      finally
      {
        break label212;
      }
    }
    paramc = new StringBuilder();
    paramc.append("Sample size must be >=0, not: ");
    paramc.append(paramInt);
    throw new IllegalArgumentException(paramc.toString());
    label212:
    throw paramc;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z1.e
 * JD-Core Version:    0.7.0.1
 */