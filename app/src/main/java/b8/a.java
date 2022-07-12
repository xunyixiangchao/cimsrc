package b8;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import x7.f;
import y7.e;

public class a
  implements Closeable
{
  private static final char[] p = ")]}'\n".toCharArray();
  private final Reader a;
  private boolean b = false;
  private final char[] c = new char[1024];
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  int h = 0;
  private long i;
  private int j;
  private String k;
  private int[] l;
  private int m;
  private String[] n;
  private int[] o;
  
  static
  {
    f.a = new a();
  }
  
  public a(Reader paramReader)
  {
    int[] arrayOfInt = new int[32];
    this.l = arrayOfInt;
    this.m = (0 + 1);
    arrayOfInt[0] = 6;
    this.n = new String[32];
    this.o = new int[32];
    Objects.requireNonNull(paramReader, "in == null");
    this.a = paramReader;
  }
  
  private void A0(char paramChar)
  {
    char[] arrayOfChar = this.c;
    label88:
    do
    {
      char c1 = this.d;
      char c3 = this.e;
      for (;;)
      {
        if (c1 >= c3) {
          break label88;
        }
        char c2 = c1 + '\001';
        c1 = arrayOfChar[c1];
        if (c1 == paramChar)
        {
          this.d = c2;
          return;
        }
        if (c1 == '\\')
        {
          this.d = c2;
          y0();
          break;
        }
        if (c1 == '\n')
        {
          this.f += 1;
          this.g = c2;
        }
        c1 = c2;
      }
      this.d = c1;
    } while (f0(1));
    throw F0("Unterminated string");
  }
  
  private boolean B0(String paramString)
  {
    int i2 = paramString.length();
    int i3 = this.d;
    int i4 = this.e;
    int i1 = 0;
    if ((i3 + i2 > i4) && (!f0(i2))) {
      return false;
    }
    char[] arrayOfChar = this.c;
    i3 = this.d;
    if (arrayOfChar[i3] == '\n')
    {
      this.f += 1;
      this.g = (i3 + 1);
    }
    for (;;)
    {
      if (i1 >= i2) {
        break label128;
      }
      if (this.c[(this.d + i1)] != paramString.charAt(i1))
      {
        this.d += 1;
        break;
      }
      i1 += 1;
    }
    label128:
    return true;
  }
  
  private void C0()
  {
    int i2;
    do
    {
      if ((this.d >= this.e) && (!f0(1))) {
        break;
      }
      char[] arrayOfChar = this.c;
      i2 = this.d;
      int i1 = i2 + 1;
      this.d = i1;
      i2 = arrayOfChar[i2];
      if (i2 == 10)
      {
        this.f += 1;
        this.g = i1;
        return;
      }
    } while (i2 != 13);
  }
  
  private void D0()
  {
    label143:
    label154:
    do
    {
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = this.d;
        if (i2 + i1 >= this.e) {
          break label154;
        }
        i2 = this.c[(i2 + i1)];
        if ((i2 == 9) || (i2 == 10) || (i2 == 12) || (i2 == 13) || (i2 == 32)) {
          break label143;
        }
        if (i2 == 35) {
          break;
        }
        if (i2 == 44) {
          break label143;
        }
        if ((i2 == 47) || (i2 == 61)) {
          break;
        }
        if ((i2 == 123) || (i2 == 125) || (i2 == 58)) {
          break label143;
        }
        if (i2 == 59) {
          break;
        }
        switch (i2)
        {
        default: 
          i1 += 1;
        }
      }
      h();
      this.d += i1;
      return;
      this.d = (i2 + i1);
    } while (f0(1));
  }
  
  private IOException F0(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(j0());
    throw new d(localStringBuilder.toString());
  }
  
  private boolean f0(int paramInt)
  {
    char[] arrayOfChar = this.c;
    int i2 = this.g;
    int i1 = this.d;
    this.g = (i2 - i1);
    i2 = this.e;
    if (i2 != i1)
    {
      i2 -= i1;
      this.e = i2;
      System.arraycopy(arrayOfChar, i1, arrayOfChar, 0, i2);
    }
    else
    {
      this.e = 0;
    }
    this.d = 0;
    do
    {
      Reader localReader = this.a;
      i1 = this.e;
      i1 = localReader.read(arrayOfChar, i1, arrayOfChar.length - i1);
      if (i1 == -1) {
        break;
      }
      i2 = this.e + i1;
      this.e = i2;
      i1 = paramInt;
      if (this.f == 0)
      {
        int i3 = this.g;
        i1 = paramInt;
        if (i3 == 0)
        {
          i1 = paramInt;
          if (i2 > 0)
          {
            i1 = paramInt;
            if (arrayOfChar[0] == 65279)
            {
              this.d += 1;
              this.g = (i3 + 1);
              i1 = paramInt + 1;
            }
          }
        }
      }
      paramInt = i1;
    } while (i2 < i1);
    return true;
    return false;
  }
  
  private void h()
  {
    if (this.b) {
      return;
    }
    throw F0("Use JsonReader.setLenient(true) to accept malformed JSON");
  }
  
  private void i()
  {
    p0(true);
    int i1 = this.d - 1;
    this.d = i1;
    char[] arrayOfChar = p;
    if ((i1 + arrayOfChar.length > this.e) && (!f0(arrayOfChar.length))) {
      return;
    }
    i1 = 0;
    for (;;)
    {
      arrayOfChar = p;
      if (i1 >= arrayOfChar.length) {
        break;
      }
      if (this.c[(this.d + i1)] != arrayOfChar[i1]) {
        return;
      }
      i1 += 1;
    }
    this.d += arrayOfChar.length;
  }
  
  private boolean i0(char paramChar)
  {
    if ((paramChar != '\t') && (paramChar != '\n') && (paramChar != '\f') && (paramChar != '\r') && (paramChar != ' '))
    {
      if (paramChar != '#')
      {
        if (paramChar == ',') {
          break label110;
        }
        if ((paramChar != '/') && (paramChar != '='))
        {
          if ((paramChar == '{') || (paramChar == '}') || (paramChar == ':')) {
            break label110;
          }
          if (paramChar == ';') {}
        }
      }
      switch (paramChar)
      {
      default: 
        return true;
      case '\\': 
        h();
      }
    }
    label110:
    return false;
  }
  
  private int p0(boolean paramBoolean)
  {
    Object localObject = this.c;
    int i1 = this.d;
    label11:
    int i2;
    for (int i3 = this.e;; i3 = i2)
    {
      int i4 = i1;
      i2 = i3;
      if (i1 == i3)
      {
        this.d = i1;
        if (!f0(1))
        {
          if (!paramBoolean) {
            return -1;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("End of input");
          ((StringBuilder)localObject).append(j0());
          throw new EOFException(((StringBuilder)localObject).toString());
        }
        i4 = this.d;
        i2 = this.e;
      }
      i1 = i4 + 1;
      i3 = localObject[i4];
      if (i3 == 10)
      {
        this.f += 1;
        this.g = i1;
      }
      else if ((i3 != 32) && (i3 != 13) && (i3 != 9))
      {
        if (i3 == 47)
        {
          this.d = i1;
          if (i1 == i2)
          {
            this.d = (i1 - 1);
            boolean bool = f0(2);
            this.d += 1;
            if (!bool) {
              return i3;
            }
          }
          h();
          i1 = this.d;
          i2 = localObject[i1];
          if (i2 != 42)
          {
            if (i2 != 47) {
              return i3;
            }
            this.d = (i1 + 1);
          }
        }
        for (;;)
        {
          C0();
          break;
          this.d = (i1 + 1);
          if (B0("*/"))
          {
            i1 = this.d + 2;
            break label11;
          }
          throw F0("Unterminated comment");
          this.d = i1;
          if (i3 != 35) {
            break label304;
          }
          h();
        }
        label304:
        return i3;
      }
    }
  }
  
  private String r0(char paramChar)
  {
    char[] arrayOfChar = this.c;
    Object localObject1 = null;
    for (;;)
    {
      char c2 = this.d;
      int i1 = this.e;
      char c1 = c2;
      char c3;
      for (;;)
      {
        c3 = c1;
        if (c3 >= i1) {
          break label192;
        }
        c1 = c3 + '\001';
        c3 = arrayOfChar[c3];
        if (c3 == paramChar)
        {
          this.d = c1;
          paramChar = c1 - c2 - 1;
          if (localObject1 == null) {
            return new String(arrayOfChar, c2, paramChar);
          }
          localObject1.append(arrayOfChar, c2, paramChar);
          return localObject1.toString();
        }
        if (c3 == '\\')
        {
          this.d = c1;
          c1 = c1 - c2 - 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder(Math.max((c1 + '\001') * 2, 16));
          }
          ((StringBuilder)localObject2).append(arrayOfChar, c2, c1);
          ((StringBuilder)localObject2).append(y0());
          localObject1 = localObject2;
          break;
        }
        if (c3 == '\n')
        {
          this.f += 1;
          this.g = c1;
        }
      }
      label192:
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(Math.max((c3 - c2) * 2, 16));
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c2, c3 - c2);
      this.d = c3;
      if (!f0(1)) {
        break;
      }
      localObject1 = localObject2;
    }
    throw F0("Unterminated string");
  }
  
  private String t0()
  {
    int i2 = 0;
    Object localObject1 = null;
    label150:
    label172:
    label175:
    Object localObject2;
    do
    {
      i1 = 0;
      do
      {
        for (;;)
        {
          int i3 = this.d;
          if (i3 + i1 >= this.e) {
            break label150;
          }
          i3 = this.c[(i3 + i1)];
          if ((i3 == 9) || (i3 == 10) || (i3 == 12) || (i3 == 13) || (i3 == 32)) {
            break label172;
          }
          if (i3 == 35) {
            break;
          }
          if (i3 == 44) {
            break label172;
          }
          if ((i3 == 47) || (i3 == 61)) {
            break;
          }
          if ((i3 == 123) || (i3 == 125) || (i3 == 58)) {
            break label172;
          }
          if (i3 == 59) {
            break;
          }
          switch (i3)
          {
          default: 
            i1 += 1;
          }
        }
        h();
        break;
        if (i1 >= this.c.length) {
          break label175;
        }
      } while (f0(i1 + 1));
      break;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(Math.max(i1, 16));
      }
      ((StringBuilder)localObject2).append(this.c, this.d, i1);
      this.d += i1;
      localObject1 = localObject2;
    } while (f0(1));
    localObject1 = localObject2;
    int i1 = i2;
    if (localObject1 == null)
    {
      localObject1 = new String(this.c, this.d, i1);
    }
    else
    {
      ((StringBuilder)localObject1).append(this.c, this.d, i1);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    this.d += i1;
    return localObject1;
  }
  
  private int v0()
  {
    int i1 = this.c[this.d];
    String str1;
    String str2;
    if ((i1 != 116) && (i1 != 84))
    {
      if ((i1 != 102) && (i1 != 70))
      {
        if ((i1 != 110) && (i1 != 78)) {
          return 0;
        }
        i1 = 7;
        str1 = "null";
        str2 = "NULL";
      }
      else
      {
        i1 = 6;
        str1 = "false";
        str2 = "FALSE";
      }
    }
    else
    {
      i1 = 5;
      str1 = "true";
      str2 = "TRUE";
    }
    int i3 = str1.length();
    int i2 = 1;
    while (i2 < i3)
    {
      if ((this.d + i2 >= this.e) && (!f0(i2 + 1))) {
        return 0;
      }
      int i4 = this.c[(this.d + i2)];
      if ((i4 != str1.charAt(i2)) && (i4 != str2.charAt(i2))) {
        return 0;
      }
      i2 += 1;
    }
    if (((this.d + i3 < this.e) || (f0(i3 + 1))) && (i0(this.c[(this.d + i3)]))) {
      return 0;
    }
    this.d += i3;
    this.h = i1;
    return i1;
  }
  
  private int w0()
  {
    char[] arrayOfChar = this.c;
    int i5 = this.d;
    int i3 = this.e;
    int i2 = 1;
    int i6 = 0;
    int i1 = i6;
    int i7 = i1;
    long l1 = 0L;
    for (;;)
    {
      int i9 = i5;
      int i8 = i3;
      if (i5 + i6 == i3)
      {
        if (i6 == arrayOfChar.length) {
          return 0;
        }
        if (f0(i6 + 1))
        {
          i9 = this.d;
          i8 = this.e;
        }
      }
      else
      {
        char c1 = arrayOfChar[(i9 + i6)];
        i3 = 3;
        if (c1 == '+') {
          break label477;
        }
        if ((c1 == 'E') || (c1 == 'e')) {
          break label457;
        }
        if (c1 == '-') {
          break label428;
        }
        if (c1 == '.') {
          break label415;
        }
        if ((c1 >= '0') && (c1 <= '9'))
        {
          long l2;
          if ((i1 != 1) && (i1 != 0))
          {
            boolean bool;
            if (i1 == 2)
            {
              if (l1 == 0L) {
                return 0;
              }
              l2 = 10L * l1 - (c1 - '0');
              bool = l1 < -922337203685477580L;
              if ((!bool) && ((bool) || (l2 >= l1))) {
                bool = false;
              } else {
                bool = true;
              }
              i5 = i2 & bool;
              bool = i1;
            }
            else
            {
              if (i1 == 3)
              {
                i1 = 4;
                break label294;
              }
              if (i1 != 5)
              {
                bool = i1;
                i5 = i2;
                l2 = l1;
                if (i1 != 6) {}
              }
              else
              {
                i1 = 7;
                break label294;
              }
            }
          }
          else
          {
            l2 = -(c1 - '0');
            i4 = 2;
            i5 = i2;
          }
          l1 = l2;
          i2 = i5;
          i1 = i4;
          label294:
          break label489;
        }
        if (i0(c1)) {
          break label413;
        }
      }
      if ((i1 == 2) && (i2 != 0) && ((l1 != -9223372036854775808L) || (i7 != 0)) && ((l1 != 0L) || (i7 == 0)))
      {
        if (i7 == 0) {
          l1 = -l1;
        }
        this.i = l1;
        this.d += i6;
      }
      for (i1 = 15;; i1 = 16)
      {
        this.h = i1;
        return i1;
        if ((i1 != 2) && (i1 != 4) && (i1 != 7)) {
          return 0;
        }
        this.j = i6;
      }
      label413:
      return 0;
      label415:
      if (i1 == 2)
      {
        i1 = i4;
      }
      else
      {
        return 0;
        label428:
        i4 = 6;
        if (i1 == 0)
        {
          i1 = 1;
          i7 = i1;
        }
        else if (i1 == 5)
        {
          i1 = i4;
        }
        else
        {
          return 0;
          label457:
          if ((i1 != 2) && (i1 != 4)) {
            return 0;
          }
          i1 = 5;
          break label489;
          label477:
          i4 = 6;
          if (i1 != 5) {
            break;
          }
          i1 = i4;
        }
      }
      label489:
      i6 += 1;
      i5 = i9;
      int i4 = i8;
    }
    return 0;
  }
  
  private void x0(int paramInt)
  {
    int i1 = this.m;
    int[] arrayOfInt1 = this.l;
    if (i1 == arrayOfInt1.length)
    {
      int[] arrayOfInt2 = new int[i1 * 2];
      int[] arrayOfInt3 = new int[i1 * 2];
      String[] arrayOfString = new String[i1 * 2];
      System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i1);
      System.arraycopy(this.o, 0, arrayOfInt3, 0, this.m);
      System.arraycopy(this.n, 0, arrayOfString, 0, this.m);
      this.l = arrayOfInt2;
      this.o = arrayOfInt3;
      this.n = arrayOfString;
    }
    arrayOfInt1 = this.l;
    i1 = this.m;
    this.m = (i1 + 1);
    arrayOfInt1[i1] = paramInt;
  }
  
  private char y0()
  {
    if ((this.d == this.e) && (!f0(1))) {
      throw F0("Unterminated escape sequence");
    }
    Object localObject = this.c;
    int i1 = this.d;
    int i2 = i1 + 1;
    this.d = i2;
    char c1 = localObject[i1];
    if (c1 != '\n')
    {
      if ((c1 != '"') && (c1 != '\'') && (c1 != '/') && (c1 != '\\'))
      {
        if (c1 != 'b')
        {
          if (c1 != 'f')
          {
            if (c1 != 'n')
            {
              if (c1 != 'r')
              {
                if (c1 != 't')
                {
                  if (c1 == 'u')
                  {
                    if ((i2 + 4 > this.e) && (!f0(4))) {
                      throw F0("Unterminated escape sequence");
                    }
                    c1 = '\000';
                    i2 = this.d;
                    int i3;
                    for (i1 = i2;; i1 = i3 + 1)
                    {
                      i3 = i1;
                      if (i3 >= i2 + 4) {
                        break label313;
                      }
                      i1 = this.c[i3];
                      int i4 = (char)(c1 << '\004');
                      if ((i1 >= 48) && (i1 <= 57))
                      {
                        i1 -= 48;
                        c1 = (char)(i4 + i1);
                      }
                      else
                      {
                        if ((i1 >= 97) && (i1 <= 102)) {
                          i1 -= 97;
                        }
                        for (;;)
                        {
                          i1 += 10;
                          break;
                          if ((i1 < 65) || (i1 > 70)) {
                            break label261;
                          }
                          i1 -= 65;
                        }
                      }
                    }
                    label261:
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("\\u");
                    ((StringBuilder)localObject).append(new String(this.c, this.d, 4));
                    throw new NumberFormatException(((StringBuilder)localObject).toString());
                    label313:
                    this.d += 4;
                    return c1;
                  }
                  throw F0("Invalid escape sequence");
                }
                return '\t';
              }
              return '\r';
            }
            return '\n';
          }
          return '\f';
        }
        return '\b';
      }
    }
    else
    {
      this.f += 1;
      this.g = i2;
    }
    return c1;
  }
  
  int B()
  {
    Object localObject = this.l;
    int i2 = this.m;
    int i1 = localObject[(i2 - 1)];
    if (i1 == 1)
    {
      localObject[(i2 - 1)] = 2;
    }
    else if (i1 == 2)
    {
      i2 = p0(true);
      if (i2 != 44)
      {
        if (i2 != 59)
        {
          if (i2 == 93)
          {
            this.h = 4;
            return 4;
          }
          throw F0("Unterminated array");
        }
        h();
      }
    }
    else
    {
      if ((i1 == 3) || (i1 == 5)) {
        break label472;
      }
      if (i1 == 4)
      {
        localObject[(i2 - 1)] = 5;
        i2 = p0(true);
        if (i2 != 58) {
          if (i2 == 61)
          {
            h();
            if ((this.d < this.e) || (f0(1)))
            {
              localObject = this.c;
              i2 = this.d;
              if (localObject[i2] == '>') {
                this.d = (i2 + 1);
              }
            }
          }
          else
          {
            throw F0("Expected ':'");
          }
        }
      }
      else if (i1 == 6)
      {
        if (this.b) {
          i();
        }
        this.l[(this.m - 1)] = 7;
      }
      else if (i1 == 7)
      {
        if (p0(false) == -1) {
          i1 = 17;
        }
      }
    }
    for (;;)
    {
      this.h = i1;
      return i1;
      h();
      this.d -= 1;
      if (i1 != 8)
      {
        i2 = p0(true);
        if (i2 != 34)
        {
          if (i2 != 39)
          {
            if ((i2 != 44) && (i2 != 59)) {
              if (i2 != 91)
              {
                if (i2 != 93)
                {
                  if (i2 != 123)
                  {
                    this.d -= 1;
                    i1 = v0();
                    if (i1 != 0) {
                      return i1;
                    }
                    i1 = w0();
                    if (i1 != 0) {
                      return i1;
                    }
                    if (i0(this.c[this.d]))
                    {
                      h();
                      i1 = 10;
                      continue;
                    }
                    throw F0("Expected value");
                  }
                  this.h = 1;
                  return 1;
                }
                if (i1 == 1)
                {
                  this.h = 4;
                  return 4;
                }
              }
              else
              {
                this.h = 3;
                return 3;
              }
            }
            if ((i1 != 1) && (i1 != 2)) {
              throw F0("Unexpected value");
            }
            h();
            this.d -= 1;
            this.h = 7;
            return 7;
          }
          else
          {
            h();
            this.h = 8;
            return 8;
          }
        }
        else {
          i1 = 9;
        }
      }
      else
      {
        throw new IllegalStateException("JsonReader is closed");
        label472:
        localObject[(i2 - 1)] = 4;
        if (i1 == 5)
        {
          i2 = p0(true);
          if (i2 != 44)
          {
            if (i2 != 59)
            {
              if (i2 == 125)
              {
                this.h = 2;
                return 2;
              }
              throw F0("Unterminated object");
            }
            h();
          }
        }
        i2 = p0(true);
        if (i2 != 34)
        {
          if (i2 != 39)
          {
            if (i2 != 125)
            {
              h();
              this.d -= 1;
              if (i0((char)i2)) {
                i1 = 14;
              } else {
                throw F0("Expected name");
              }
            }
            else
            {
              if (i1 != 5)
              {
                this.h = 2;
                return 2;
              }
              throw F0("Expected name");
            }
          }
          else
          {
            h();
            i1 = 12;
          }
        }
        else {
          i1 = 13;
        }
      }
    }
  }
  
  public void E0()
  {
    int i2 = 0;
    label187:
    do
    {
      i1 = this.h;
      int i3 = i1;
      if (i1 == 0) {
        i3 = B();
      }
      if (i3 == 3) {
        x0(1);
      }
      for (;;)
      {
        i1 = i2 + 1;
        break label187;
        if (i3 != 1) {
          break;
        }
        x0(3);
      }
      if (i3 == 4) {}
      while (i3 == 2)
      {
        this.m -= 1;
        i1 = i2 - 1;
        break;
      }
      if ((i3 != 14) && (i3 != 10))
      {
        char c1;
        if ((i3 != 8) && (i3 != 12))
        {
          if ((i3 != 9) && (i3 != 13))
          {
            i1 = i2;
            if (i3 != 16) {
              break label187;
            }
            this.d += this.j;
            i1 = i2;
            break label187;
          }
          c1 = '"';
        }
        else
        {
          c1 = '\'';
        }
        A0(c1);
        i1 = i2;
      }
      else
      {
        D0();
        i1 = i2;
      }
      this.h = 0;
      i2 = i1;
    } while (i1 != 0);
    int[] arrayOfInt = this.o;
    int i1 = this.m;
    i2 = i1 - 1;
    arrayOfInt[i2] += 1;
    this.n[(i1 - 1)] = "null";
  }
  
  public String G()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    int i2 = this.m;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = this.l[i1];
      if ((i3 != 1) && (i3 != 2))
      {
        if ((i3 == 3) || (i3 == 4) || (i3 == 5))
        {
          localStringBuilder.append('.');
          String[] arrayOfString = this.n;
          if (arrayOfString[i1] != null) {
            localStringBuilder.append(arrayOfString[i1]);
          }
        }
      }
      else
      {
        localStringBuilder.append('[');
        localStringBuilder.append(this.o[i1]);
        localStringBuilder.append(']');
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 3)
    {
      x0(1);
      this.o[(this.m - 1)] = 0;
      this.h = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected BEGIN_ARRAY but was ");
    localStringBuilder.append(u0());
    localStringBuilder.append(j0());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void close()
  {
    this.h = 0;
    this.l[0] = 8;
    this.m = 1;
    this.a.close();
  }
  
  public void d0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 4)
    {
      i1 = this.m - 1;
      this.m = i1;
      localObject = this.o;
      i1 -= 1;
      localObject[i1] += 1;
      this.h = 0;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected END_ARRAY but was ");
    ((StringBuilder)localObject).append(u0());
    ((StringBuilder)localObject).append(j0());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void e0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 2)
    {
      i1 = this.m - 1;
      this.m = i1;
      this.n[i1] = null;
      localObject = this.o;
      i1 -= 1;
      localObject[i1] += 1;
      this.h = 0;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected END_OBJECT but was ");
    ((StringBuilder)localObject).append(u0());
    ((StringBuilder)localObject).append(j0());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void g()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 1)
    {
      x0(3);
      this.h = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected BEGIN_OBJECT but was ");
    localStringBuilder.append(u0());
    localStringBuilder.append(j0());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public boolean g0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    return (i1 != 2) && (i1 != 4);
  }
  
  public final boolean h0()
  {
    return this.b;
  }
  
  String j0()
  {
    int i1 = this.f;
    int i2 = this.d;
    int i3 = this.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" at line ");
    localStringBuilder.append(i1 + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(i2 - i3 + 1);
    localStringBuilder.append(" path ");
    localStringBuilder.append(G());
    return localStringBuilder.toString();
  }
  
  public boolean k0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 5)
    {
      this.h = 0;
      localObject = this.o;
      i1 = this.m - 1;
      localObject[i1] += 1;
      return true;
    }
    if (i1 == 6)
    {
      this.h = 0;
      localObject = this.o;
      i1 = this.m - 1;
      localObject[i1] += 1;
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a boolean but was ");
    ((StringBuilder)localObject).append(u0());
    ((StringBuilder)localObject).append(j0());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public double l0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 15)
    {
      this.h = 0;
      localObject = this.o;
      i1 = this.m - 1;
      localObject[i1] += 1;
      return this.i;
    }
    if (i1 == 16)
    {
      this.k = new String(this.c, this.d, this.j);
      this.d += this.j;
    }
    else
    {
      if ((i1 != 8) && (i1 != 9))
      {
        if (i1 == 10)
        {
          localObject = t0();
        }
        else
        {
          if (i1 == 11) {
            break label234;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Expected a double but was ");
          ((StringBuilder)localObject).append(u0());
          ((StringBuilder)localObject).append(j0());
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        char c1;
        if (i1 == 8) {
          c1 = '\'';
        } else {
          c1 = '"';
        }
        localObject = r0(c1);
      }
      this.k = ((String)localObject);
    }
    label234:
    this.h = 11;
    double d1 = Double.parseDouble(this.k);
    if ((!this.b) && ((Double.isNaN(d1)) || (Double.isInfinite(d1))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSON forbids NaN and infinities: ");
      ((StringBuilder)localObject).append(d1);
      ((StringBuilder)localObject).append(j0());
      throw new d(((StringBuilder)localObject).toString());
    }
    this.k = null;
    this.h = 0;
    Object localObject = this.o;
    i1 = this.m - 1;
    localObject[i1] += 1;
    return d1;
  }
  
  public int m0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 15)
    {
      long l1 = this.i;
      i1 = (int)l1;
      if (l1 == i1)
      {
        this.h = 0;
        localObject = this.o;
        i2 = this.m - 1;
        localObject[i2] += 1;
        return i1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Expected an int but was ");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(j0());
      throw new NumberFormatException(((StringBuilder)localObject).toString());
    }
    if (i1 == 16)
    {
      this.k = new String(this.c, this.d, this.j);
      this.d += this.j;
    }
    else
    {
      if ((i1 != 8) && (i1 != 9) && (i1 != 10))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Expected an int but was ");
        ((StringBuilder)localObject).append(u0());
        ((StringBuilder)localObject).append(j0());
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      if (i1 == 10) {}
      char c1;
      for (localObject = t0();; localObject = r0(c1))
      {
        this.k = ((String)localObject);
        break;
        if (i1 == 8) {
          c1 = '\'';
        } else {
          c1 = '"';
        }
      }
    }
    try
    {
      i1 = Integer.parseInt(this.k);
      this.h = 0;
      localObject = this.o;
      i2 = this.m - 1;
      localObject[i2] += 1;
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label345:
      double d1;
      break label345;
    }
    this.h = 11;
    d1 = Double.parseDouble(this.k);
    i1 = (int)d1;
    if (i1 == d1)
    {
      this.k = null;
      this.h = 0;
      localObject = this.o;
      i2 = this.m - 1;
      localObject[i2] += 1;
      return i1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected an int but was ");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append(j0());
    throw new NumberFormatException(((StringBuilder)localObject).toString());
  }
  
  public long n0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 15)
    {
      this.h = 0;
      localObject = this.o;
      i1 = this.m - 1;
      localObject[i1] += 1;
      return this.i;
    }
    if (i1 == 16)
    {
      this.k = new String(this.c, this.d, this.j);
      this.d += this.j;
    }
    else
    {
      if ((i1 != 8) && (i1 != 9) && (i1 != 10))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Expected a long but was ");
        ((StringBuilder)localObject).append(u0());
        ((StringBuilder)localObject).append(j0());
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      if (i1 == 10) {}
      char c1;
      for (localObject = t0();; localObject = r0(c1))
      {
        this.k = ((String)localObject);
        break;
        if (i1 == 8) {
          c1 = '\'';
        } else {
          c1 = '"';
        }
      }
    }
    try
    {
      l1 = Long.parseLong(this.k);
      this.h = 0;
      localObject = this.o;
      i1 = this.m - 1;
      localObject[i1] += 1;
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      long l1;
      label276:
      double d1;
      break label276;
    }
    this.h = 11;
    d1 = Double.parseDouble(this.k);
    l1 = d1;
    if (l1 == d1)
    {
      this.k = null;
      this.h = 0;
      localObject = this.o;
      i1 = this.m - 1;
      localObject[i1] += 1;
      return l1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a long but was ");
    ((StringBuilder)localObject).append(this.k);
    ((StringBuilder)localObject).append(j0());
    throw new NumberFormatException(((StringBuilder)localObject).toString());
  }
  
  public String o0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 14)
    {
      localObject = t0();
    }
    else
    {
      if (i1 == 12) {}
      for (char c1 = '\'';; c1 = '"')
      {
        localObject = r0(c1);
        break;
        if (i1 != 13) {
          break label83;
        }
      }
    }
    this.h = 0;
    this.n[(this.m - 1)] = localObject;
    return localObject;
    label83:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a name but was ");
    ((StringBuilder)localObject).append(u0());
    ((StringBuilder)localObject).append(j0());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void q0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 7)
    {
      this.h = 0;
      localObject = this.o;
      i1 = this.m - 1;
      localObject[i1] += 1;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected null but was ");
    ((StringBuilder)localObject).append(u0());
    ((StringBuilder)localObject).append(j0());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public String s0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    if (i1 == 10)
    {
      localObject = t0();
    }
    else
    {
      if (i1 == 8) {}
      for (char c1 = '\'';; c1 = '"')
      {
        localObject = r0(c1);
        break label140;
        if (i1 != 9) {
          break;
        }
      }
      if (i1 == 11)
      {
        localObject = this.k;
        this.k = null;
      }
      else if (i1 == 15)
      {
        localObject = Long.toString(this.i);
      }
      else
      {
        if (i1 != 16) {
          break label171;
        }
        localObject = new String(this.c, this.d, this.j);
        this.d += this.j;
      }
    }
    label140:
    this.h = 0;
    int[] arrayOfInt = this.o;
    i1 = this.m - 1;
    arrayOfInt[i1] += 1;
    return localObject;
    label171:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a string but was ");
    ((StringBuilder)localObject).append(u0());
    ((StringBuilder)localObject).append(j0());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(j0());
    return localStringBuilder.toString();
  }
  
  public b u0()
  {
    int i2 = this.h;
    int i1 = i2;
    if (i2 == 0) {
      i1 = B();
    }
    switch (i1)
    {
    default: 
      throw new AssertionError();
    case 17: 
      return b.j;
    case 15: 
    case 16: 
      return b.g;
    case 12: 
    case 13: 
    case 14: 
      return b.e;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return b.f;
    case 7: 
      return b.i;
    case 5: 
    case 6: 
      return b.h;
    case 4: 
      return b.b;
    case 3: 
      return b.a;
    case 2: 
      return b.d;
    }
    return b.c;
  }
  
  public final void z0(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  static final class a
    extends f
  {
    public void a(a parama)
    {
      if ((parama instanceof e))
      {
        ((e)parama).J0();
        return;
      }
      int j = parama.h;
      int i = j;
      if (j == 0) {
        i = parama.B();
      }
      if (i == 13) {
        i = 9;
      }
      for (;;)
      {
        parama.h = i;
        return;
        if (i == 12)
        {
          i = 8;
        }
        else
        {
          if (i != 14) {
            break;
          }
          i = 10;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected a name but was ");
      localStringBuilder.append(parama.u0());
      localStringBuilder.append(parama.j0());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b8.a
 * JD-Core Version:    0.7.0.1
 */