package q0;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

public class d
{
  private static void a(ArrayList<b> paramArrayList, char paramChar, float[] paramArrayOfFloat)
  {
    paramArrayList.add(new b(paramChar, paramArrayOfFloat));
  }
  
  public static boolean b(b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    if (paramArrayOfb1 != null)
    {
      if (paramArrayOfb2 == null) {
        return false;
      }
      if (paramArrayOfb1.length != paramArrayOfb2.length) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfb1.length) {
        if (paramArrayOfb1[i].a == paramArrayOfb2[i].a)
        {
          if (paramArrayOfb1[i].b.length != paramArrayOfb2[i].b.length) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  static float[] c(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfFloat.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        float[] arrayOfFloat = new float[paramInt2];
        System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, 0, i);
        return arrayOfFloat;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static b[] d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int i = 0;
    while (j < paramString.length())
    {
      j = i(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0)
      {
        float[] arrayOfFloat = h(str);
        a(localArrayList, str.charAt(0), arrayOfFloat);
      }
      i = j;
      j += 1;
    }
    if ((j - i == 1) && (i < paramString.length())) {
      a(localArrayList, paramString.charAt(i), new float[0]);
    }
    return (b[])localArrayList.toArray(new b[localArrayList.size()]);
  }
  
  public static Path e(String paramString)
  {
    Path localPath = new Path();
    Object localObject = d(paramString);
    if (localObject != null) {
      try
      {
        b.e((b[])localObject, localPath);
        return localPath;
      }
      catch (RuntimeException localRuntimeException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Error in parsing ");
        ((StringBuilder)localObject).append(paramString);
        throw new RuntimeException(((StringBuilder)localObject).toString(), localRuntimeException);
      }
    }
    return null;
  }
  
  public static b[] f(b[] paramArrayOfb)
  {
    if (paramArrayOfb == null) {
      return null;
    }
    b[] arrayOfb = new b[paramArrayOfb.length];
    int i = 0;
    while (i < paramArrayOfb.length)
    {
      arrayOfb[i] = new b(paramArrayOfb[i]);
      i += 1;
    }
    return arrayOfb;
  }
  
  private static void g(String paramString, int paramInt, a parama)
  {
    parama.b = false;
    int j = paramInt;
    int n = 0;
    int i = n;
    int k = i;
    int m = i;
    i = n;
    while (j < paramString.length())
    {
      n = paramString.charAt(j);
      if (n != 32)
      {
        if ((n != 69) && (n != 101)) {}
        switch (n)
        {
        default: 
          break;
        case 46: 
          if (m == 0)
          {
            i = 0;
            m = 1;
          }
          break;
        case 45: 
          do
          {
            parama.b = true;
            break;
          } while ((j != paramInt) && (i == 0));
          i = 0;
          break label140;
          i = 1;
          break;
        }
      }
      i = 0;
      k = 1;
      label140:
      if (k != 0) {
        break;
      }
      j += 1;
    }
    parama.a = j;
  }
  
  private static float[] h(String paramString)
  {
    if ((paramString.charAt(0) != 'z') && (paramString.charAt(0) != 'Z')) {}
    for (;;)
    {
      int m;
      int j;
      try
      {
        float[] arrayOfFloat = new float[paramString.length()];
        localObject = new a();
        int n = paramString.length();
        i = 1;
        k = 0;
        if (i < n)
        {
          g(paramString, i, (a)localObject);
          m = ((a)localObject).a;
          j = k;
          if (i < m)
          {
            arrayOfFloat[k] = Float.parseFloat(paramString.substring(i, m));
            j = k + 1;
          }
          if (!((a)localObject).b) {
            break label177;
          }
          i = m;
          k = j;
          continue;
        }
        arrayOfFloat = c(arrayOfFloat, 0, k);
        return arrayOfFloat;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error in parsing \"");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("\"");
        throw new RuntimeException(((StringBuilder)localObject).toString(), localNumberFormatException);
      }
      return new float[0];
      label177:
      int i = m + 1;
      int k = j;
    }
  }
  
  private static int i(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((((i - 65) * (i - 90) <= 0) || ((i - 97) * (i - 122) <= 0)) && (i != 101) && (i != 69)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public static void j(b[] paramArrayOfb1, b[] paramArrayOfb2)
  {
    int i = 0;
    while (i < paramArrayOfb2.length)
    {
      paramArrayOfb1[i].a = paramArrayOfb2[i].a;
      int j = 0;
      while (j < paramArrayOfb2[i].b.length)
      {
        paramArrayOfb1[i].b[j] = paramArrayOfb2[i].b[j];
        j += 1;
      }
      i += 1;
    }
  }
  
  private static class a
  {
    int a;
    boolean b;
  }
  
  public static class b
  {
    public char a;
    public float[] b;
    
    b(char paramChar, float[] paramArrayOfFloat)
    {
      this.a = paramChar;
      this.b = paramArrayOfFloat;
    }
    
    b(b paramb)
    {
      this.a = paramb.a;
      paramb = paramb.b;
      this.b = d.c(paramb, 0, paramb.length);
    }
    
    private static void a(Path paramPath, float[] paramArrayOfFloat1, char paramChar1, char paramChar2, float[] paramArrayOfFloat2)
    {
      float f7 = paramArrayOfFloat1[0];
      float f8 = paramArrayOfFloat1[1];
      float f9 = paramArrayOfFloat1[2];
      float f10 = paramArrayOfFloat1[3];
      float f6 = paramArrayOfFloat1[4];
      float f5 = paramArrayOfFloat1[5];
      float f1 = f7;
      float f2 = f8;
      float f3 = f9;
      float f4 = f10;
      char c1;
      switch (paramChar2)
      {
      default: 
        f4 = f10;
        f3 = f9;
        f2 = f8;
        f1 = f7;
      case 'L': 
      case 'M': 
      case 'T': 
      case 'l': 
      case 'm': 
      case 't': 
      case 'Z': 
      case 'z': 
        for (;;)
        {
          c1 = '\002';
          break;
          paramPath.close();
          paramPath.moveTo(f6, f5);
          f1 = f6;
          f3 = f1;
          f2 = f5;
          f4 = f2;
        }
      case 'Q': 
      case 'S': 
      case 'q': 
      case 's': 
        c1 = '\004';
        f1 = f7;
        f2 = f8;
        f3 = f9;
        f4 = f10;
        break;
      case 'H': 
      case 'V': 
      case 'h': 
      case 'v': 
        c1 = '\001';
        f1 = f7;
        f2 = f8;
        f3 = f9;
        f4 = f10;
        break;
      case 'C': 
      case 'c': 
        c1 = '\006';
        break;
      case 'A': 
      case 'a': 
        c1 = '\007';
      }
      f4 = f10;
      f3 = f9;
      f2 = f8;
      f1 = f7;
      char c2 = '\000';
      int i = paramChar1;
      f7 = f5;
      f8 = f6;
      paramChar1 = c2;
      for (;;)
      {
        c2 = paramChar2;
        if (paramChar1 >= paramArrayOfFloat2.length) {
          break;
        }
        int j;
        label1223:
        boolean bool1;
        label1549:
        label1560:
        boolean bool2;
        if (c2 != 'A')
        {
          int k;
          if (c2 != 'C')
          {
            if (c2 != 'H')
            {
              if (c2 != 'Q')
              {
                if (c2 != 'V')
                {
                  if (c2 != 'a')
                  {
                    if (c2 != 'c') {
                      if (c2 != 'h') {
                        if (c2 != 'q') {
                          if (c2 != 'v') {
                            if (c2 != 'L') {
                              if (c2 != 'M') {
                                if (c2 != 'S') {
                                  if (c2 != 'T') {
                                    if (c2 != 'l') {
                                      if (c2 != 'm') {
                                        if (c2 != 's') {
                                          if (c2 != 't') {
                                            break label2120;
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    for (;;)
                    {
                      if ((i != 113) && (i != 116) && (i != 81) && (i != 84))
                      {
                        f4 = 0.0F;
                        f3 = 0.0F;
                      }
                      else
                      {
                        f3 = f1 - f3;
                        f4 = f2 - f4;
                      }
                      i = paramChar1 + '\000';
                      f5 = paramArrayOfFloat2[i];
                      c2 = paramChar1 + '\001';
                      paramPath.rQuadTo(f3, f4, f5, paramArrayOfFloat2[c2]);
                      f5 = f1 + paramArrayOfFloat2[i];
                      f6 = f2 + paramArrayOfFloat2[c2];
                      f4 += f2;
                      f3 += f1;
                      f2 = f6;
                      f1 = f5;
                      continue;
                      if ((i != 99) && (i != 115) && (i != 67) && (i != 83))
                      {
                        f3 = 0.0F;
                        f4 = 0.0F;
                      }
                      else
                      {
                        f4 = f2 - f4;
                        f3 = f1 - f3;
                      }
                      i = paramChar1 + '\000';
                      f5 = paramArrayOfFloat2[i];
                      c2 = paramChar1 + '\001';
                      f6 = paramArrayOfFloat2[c2];
                      j = paramChar1 + '\002';
                      f9 = paramArrayOfFloat2[j];
                      k = paramChar1 + '\003';
                      paramPath.rCubicTo(f3, f4, f5, f6, f9, paramArrayOfFloat2[k]);
                      f6 = paramArrayOfFloat2[i] + f1;
                      f3 = paramArrayOfFloat2[c2] + f2;
                      f4 = f1 + paramArrayOfFloat2[j];
                      f5 = paramArrayOfFloat2[k];
                      f1 = f6;
                      break label1549;
                      i = paramChar1 + '\000';
                      f1 += paramArrayOfFloat2[i];
                      c2 = paramChar1 + '\001';
                      f2 += paramArrayOfFloat2[c2];
                      if (paramChar1 > 0)
                      {
                        paramPath.rLineTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                      }
                      else
                      {
                        paramPath.rMoveTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                        break label1223;
                        i = paramChar1 + '\000';
                        f5 = paramArrayOfFloat2[i];
                        c2 = paramChar1 + '\001';
                        paramPath.rLineTo(f5, paramArrayOfFloat2[c2]);
                        f1 += paramArrayOfFloat2[i];
                        for (f5 = paramArrayOfFloat2[c2];; f5 = paramArrayOfFloat2[i])
                        {
                          f2 += f5;
                          break;
                          if ((i != 113) && (i != 116) && (i != 81))
                          {
                            f6 = f2;
                            f5 = f1;
                            if (i != 84) {}
                          }
                          else
                          {
                            f5 = f1 * 2.0F - f3;
                            f6 = f2 * 2.0F - f4;
                          }
                          i = paramChar1 + '\000';
                          f1 = paramArrayOfFloat2[i];
                          c2 = paramChar1 + '\001';
                          paramPath.quadTo(f5, f6, f1, paramArrayOfFloat2[c2]);
                          f1 = paramArrayOfFloat2[i];
                          f2 = paramArrayOfFloat2[c2];
                          f4 = f6;
                          f3 = f5;
                          break;
                          if ((i != 99) && (i != 115) && (i != 67))
                          {
                            f6 = f2;
                            f5 = f1;
                            if (i != 83) {}
                          }
                          else
                          {
                            f5 = f1 * 2.0F - f3;
                            f6 = f2 * 2.0F - f4;
                          }
                          i = paramChar1 + '\000';
                          f1 = paramArrayOfFloat2[i];
                          c2 = paramChar1 + '\001';
                          f2 = paramArrayOfFloat2[c2];
                          j = paramChar1 + '\002';
                          f3 = paramArrayOfFloat2[j];
                          k = paramChar1 + '\003';
                          paramPath.cubicTo(f5, f6, f1, f2, f3, paramArrayOfFloat2[k]);
                          f1 = paramArrayOfFloat2[i];
                          f3 = paramArrayOfFloat2[c2];
                          f5 = paramArrayOfFloat2[j];
                          f2 = paramArrayOfFloat2[k];
                          break label1560;
                          i = paramChar1 + '\000';
                          f1 = paramArrayOfFloat2[i];
                          c2 = paramChar1 + '\001';
                          f2 = paramArrayOfFloat2[c2];
                          if (paramChar1 > 0)
                          {
                            paramPath.lineTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                            break;
                          }
                          paramPath.moveTo(paramArrayOfFloat2[i], paramArrayOfFloat2[c2]);
                          f7 = f2;
                          f8 = f1;
                          break;
                          i = paramChar1 + '\000';
                          f1 = paramArrayOfFloat2[i];
                          c2 = paramChar1 + '\001';
                          paramPath.lineTo(f1, paramArrayOfFloat2[c2]);
                          f1 = paramArrayOfFloat2[i];
                          f2 = paramArrayOfFloat2[c2];
                          break;
                          i = paramChar1 + '\000';
                          paramPath.rLineTo(0.0F, paramArrayOfFloat2[i]);
                        }
                        i = paramChar1 + '\000';
                        f3 = paramArrayOfFloat2[i];
                        c2 = paramChar1 + '\001';
                        f4 = paramArrayOfFloat2[c2];
                        j = paramChar1 + '\002';
                        f5 = paramArrayOfFloat2[j];
                        k = paramChar1 + '\003';
                        paramPath.rQuadTo(f3, f4, f5, paramArrayOfFloat2[k]);
                        f6 = paramArrayOfFloat2[i] + f1;
                        f3 = paramArrayOfFloat2[c2] + f2;
                        f4 = f1 + paramArrayOfFloat2[j];
                        f5 = paramArrayOfFloat2[k];
                        f1 = f6;
                        break label1549;
                        i = paramChar1 + '\000';
                        paramPath.rLineTo(paramArrayOfFloat2[i], 0.0F);
                        f1 += paramArrayOfFloat2[i];
                        continue;
                        f3 = paramArrayOfFloat2[(paramChar1 + '\000')];
                        f4 = paramArrayOfFloat2[(paramChar1 + '\001')];
                        i = paramChar1 + '\002';
                        f5 = paramArrayOfFloat2[i];
                        c2 = paramChar1 + '\003';
                        f6 = paramArrayOfFloat2[c2];
                        j = paramChar1 + '\004';
                        f9 = paramArrayOfFloat2[j];
                        k = paramChar1 + '\005';
                        paramPath.rCubicTo(f3, f4, f5, f6, f9, paramArrayOfFloat2[k]);
                        f6 = paramArrayOfFloat2[i] + f1;
                        f3 = paramArrayOfFloat2[c2] + f2;
                        f4 = f1 + paramArrayOfFloat2[j];
                        f5 = paramArrayOfFloat2[k];
                        f1 = f6;
                        f2 += f5;
                        f5 = f4;
                        f4 = f3;
                        f3 = f1;
                        f1 = f5;
                      }
                    }
                  }
                  i = paramChar1 + '\005';
                  f3 = paramArrayOfFloat2[i];
                  c2 = paramChar1 + '\006';
                  f4 = paramArrayOfFloat2[c2];
                  f5 = paramArrayOfFloat2[(paramChar1 + '\000')];
                  f6 = paramArrayOfFloat2[(paramChar1 + '\001')];
                  f9 = paramArrayOfFloat2[(paramChar1 + '\002')];
                  if (paramArrayOfFloat2[(paramChar1 + '\003')] != 0.0F) {
                    bool1 = true;
                  } else {
                    bool1 = false;
                  }
                  if (paramArrayOfFloat2[(paramChar1 + '\004')] != 0.0F) {
                    bool2 = true;
                  } else {
                    bool2 = false;
                  }
                  c(paramPath, f1, f2, f3 + f1, f4 + f2, f5, f6, f9, bool1, bool2);
                  f1 += paramArrayOfFloat2[i];
                  f2 += paramArrayOfFloat2[c2];
                }
                else
                {
                  i = paramChar1 + '\000';
                  paramPath.lineTo(f1, paramArrayOfFloat2[i]);
                  f2 = paramArrayOfFloat2[i];
                  break label2120;
                }
              }
              else
              {
                i = paramChar1;
                c2 = i + 0;
                f1 = paramArrayOfFloat2[c2];
                j = i + 1;
                f2 = paramArrayOfFloat2[j];
                k = i + 2;
                f3 = paramArrayOfFloat2[k];
                i += 3;
                paramPath.quadTo(f1, f2, f3, paramArrayOfFloat2[i]);
                f3 = paramArrayOfFloat2[c2];
                f4 = paramArrayOfFloat2[j];
                f1 = paramArrayOfFloat2[k];
                f2 = paramArrayOfFloat2[i];
                break label2120;
              }
            }
            else
            {
              i = paramChar1 + '\000';
              paramPath.lineTo(paramArrayOfFloat2[i], f2);
              f1 = paramArrayOfFloat2[i];
              break label2120;
            }
          }
          else
          {
            i = paramChar1;
            f1 = paramArrayOfFloat2[(i + 0)];
            f2 = paramArrayOfFloat2[(i + 1)];
            c2 = i + 2;
            f3 = paramArrayOfFloat2[c2];
            j = i + 3;
            f4 = paramArrayOfFloat2[j];
            k = i + 4;
            f5 = paramArrayOfFloat2[k];
            i += 5;
            paramPath.cubicTo(f1, f2, f3, f4, f5, paramArrayOfFloat2[i]);
            f1 = paramArrayOfFloat2[k];
            f2 = paramArrayOfFloat2[i];
            f3 = paramArrayOfFloat2[c2];
            f4 = paramArrayOfFloat2[j];
            break label2120;
          }
        }
        else
        {
          i = paramChar1;
          c2 = i + 5;
          f3 = paramArrayOfFloat2[c2];
          j = i + 6;
          f4 = paramArrayOfFloat2[j];
          f5 = paramArrayOfFloat2[(i + 0)];
          f6 = paramArrayOfFloat2[(i + 1)];
          f9 = paramArrayOfFloat2[(i + 2)];
          if (paramArrayOfFloat2[(i + 3)] != 0.0F) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (paramArrayOfFloat2[(i + 4)] != 0.0F) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          c(paramPath, f1, f2, f3, f4, f5, f6, f9, bool1, bool2);
          f1 = paramArrayOfFloat2[c2];
          f2 = paramArrayOfFloat2[j];
        }
        f4 = f2;
        f3 = f1;
        label2120:
        paramChar1 += c1;
        i = paramChar2;
      }
      paramArrayOfFloat1[0] = f1;
      paramArrayOfFloat1[1] = f2;
      paramArrayOfFloat1[2] = f3;
      paramArrayOfFloat1[3] = f4;
      paramArrayOfFloat1[4] = f8;
      paramArrayOfFloat1[5] = f7;
    }
    
    private static void b(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
    {
      int i = (int)Math.ceil(Math.abs(paramDouble9 * 4.0D / 3.141592653589793D));
      double d4 = Math.cos(paramDouble7);
      double d5 = Math.sin(paramDouble7);
      double d2 = Math.cos(paramDouble8);
      double d3 = Math.sin(paramDouble8);
      paramDouble7 = -paramDouble3;
      double d9 = paramDouble7 * d4;
      double d10 = paramDouble4 * d5;
      paramDouble7 *= d5;
      double d11 = paramDouble4 * d4;
      double d6 = paramDouble9 / i;
      double d1 = d3 * paramDouble7 + d2 * d11;
      d2 = d9 * d3 - d10 * d2;
      int j = 0;
      d3 = paramDouble8;
      paramDouble9 = paramDouble6;
      paramDouble4 = paramDouble7;
      paramDouble8 = paramDouble5;
      paramDouble7 = d6;
      paramDouble6 = d5;
      paramDouble5 = d4;
      for (;;)
      {
        d4 = paramDouble3;
        if (j >= i) {
          break;
        }
        d6 = d3 + paramDouble7;
        double d7 = Math.sin(d6);
        double d12 = Math.cos(d6);
        double d8 = paramDouble1 + d4 * paramDouble5 * d12 - d10 * d7;
        d4 = paramDouble2 + d4 * paramDouble6 * d12 + d11 * d7;
        d5 = d9 * d7 - d10 * d12;
        d7 = d7 * paramDouble4 + d12 * d11;
        d3 = d6 - d3;
        d12 = Math.tan(d3 / 2.0D);
        d3 = Math.sin(d3) * (Math.sqrt(d12 * 3.0D * d12 + 4.0D) - 1.0D) / 3.0D;
        paramPath.rLineTo(0.0F, 0.0F);
        paramPath.cubicTo((float)(paramDouble8 + d2 * d3), (float)(paramDouble9 + d1 * d3), (float)(d8 - d3 * d5), (float)(d4 - d3 * d7), (float)d8, (float)d4);
        j += 1;
        paramDouble8 = d8;
        d3 = d6;
        d1 = d7;
        d2 = d5;
        paramDouble9 = d4;
      }
    }
    
    private static void c(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
    {
      double d5 = Math.toRadians(paramFloat7);
      double d6 = Math.cos(d5);
      double d7 = Math.sin(d5);
      double d8 = paramFloat1;
      double d9 = paramFloat2;
      double d10 = paramFloat5;
      double d1 = (d8 * d6 + d9 * d7) / d10;
      double d2 = -paramFloat1;
      double d11 = paramFloat6;
      double d4 = (d2 * d7 + d9 * d6) / d11;
      double d3 = paramFloat3;
      d2 = paramFloat4;
      double d12 = (d3 * d6 + d2 * d7) / d10;
      double d13 = (-paramFloat3 * d7 + d2 * d6) / d11;
      double d15 = d1 - d12;
      double d14 = d4 - d13;
      d3 = (d1 + d12) / 2.0D;
      d2 = (d4 + d13) / 2.0D;
      double d16 = d15 * d15 + d14 * d14;
      if (d16 == 0.0D)
      {
        Log.w("PathParser", " Points are coincident");
        return;
      }
      double d17 = 1.0D / d16 - 0.25D;
      if (d17 < 0.0D)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Points are too far apart ");
        localStringBuilder.append(d16);
        Log.w("PathParser", localStringBuilder.toString());
        float f = (float)(Math.sqrt(d16) / 1.99999D);
        c(paramPath, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5 * f, paramFloat6 * f, paramFloat7, paramBoolean1, paramBoolean2);
        return;
      }
      d16 = Math.sqrt(d17);
      d15 *= d16;
      d14 = d16 * d14;
      if (paramBoolean1 == paramBoolean2)
      {
        d3 -= d14;
        d2 += d15;
      }
      else
      {
        d3 += d14;
        d2 -= d15;
      }
      d14 = Math.atan2(d4 - d2, d1 - d3);
      d4 = Math.atan2(d13 - d2, d12 - d3) - d14;
      boolean bool = d4 < 0.0D;
      if (!bool) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      d1 = d4;
      if (paramBoolean2 != paramBoolean1) {
        if (bool) {
          d1 = d4 - 6.283185307179586D;
        } else {
          d1 = d4 + 6.283185307179586D;
        }
      }
      d3 *= d10;
      d2 *= d11;
      b(paramPath, d3 * d6 - d2 * d7, d3 * d7 + d2 * d6, d10, d11, d8, d9, d5, d14, d1);
    }
    
    public static void e(b[] paramArrayOfb, Path paramPath)
    {
      float[] arrayOfFloat = new float[6];
      char c = 'm';
      int i = 0;
      while (i < paramArrayOfb.length)
      {
        a(paramPath, arrayOfFloat, c, paramArrayOfb[i].a, paramArrayOfb[i].b);
        c = paramArrayOfb[i].a;
        i += 1;
      }
    }
    
    public void d(b paramb1, b paramb2, float paramFloat)
    {
      this.a = paramb1.a;
      int i = 0;
      for (;;)
      {
        float[] arrayOfFloat = paramb1.b;
        if (i >= arrayOfFloat.length) {
          break;
        }
        this.b[i] = (arrayOfFloat[i] * (1.0F - paramFloat) + paramb2.b[i] * paramFloat);
        i += 1;
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q0.d
 * JD-Core Version:    0.7.0.1
 */