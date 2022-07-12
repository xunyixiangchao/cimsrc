package m9;

import a9.f;
import aa.c;
import aa.d;
import aa.e;
import aa.e.a;
import aa.o;
import aa.o.a;
import f9.h;
import f9.j;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import l9.e0;
import l9.e0.a;
import l9.w;
import l9.w.b;

public final class l
{
  public static final byte[] a;
  private static final o b;
  private static final w c;
  private static final e0 d;
  
  static
  {
    byte[] arrayOfByte = new byte[0];
    a = arrayOfByte;
    o.a locala = o.d;
    e.a locala1 = e.d;
    b = locala.d(new e[] { locala1.a("efbbbf"), locala1.a("feff"), locala1.a("fffe"), locala1.a("0000ffff"), locala1.a("ffff0000") });
    c = w.b.a(new String[0]);
    d = e0.a.g(e0.a, arrayOfByte, null, 0, 0, 7, null);
  }
  
  public static final int A(d paramd)
  {
    f.f(paramd, "<this>");
    int i = b(paramd.readByte(), 255);
    int j = b(paramd.readByte(), 255);
    return b(paramd.readByte(), 255) | i << 16 | j << 8;
  }
  
  public static final int B(aa.b paramb, byte paramByte)
  {
    f.f(paramb, "<this>");
    int i = 0;
    while ((!paramb.D()) && (paramb.i0(0L) == paramByte))
    {
      i += 1;
      paramb.readByte();
    }
    return i;
  }
  
  public static final long C(String paramString, long paramLong)
  {
    f.f(paramString, "<this>");
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
  
  public static final int D(String paramString, int paramInt)
  {
    if (paramString == null) {
      paramString = null;
    }
    while (paramString != null)
    {
      try
      {
        paramString = Long.valueOf(Long.parseLong(paramString));
      }
      catch (NumberFormatException paramString)
      {
        long l;
        return paramInt;
      }
      l = paramString.longValue();
      if (l > 2147483647L) {
        return 2147483647;
      }
      if (l < 0L) {
        return 0;
      }
      return (int)l;
    }
    return paramInt;
  }
  
  public static final String E(String paramString, int paramInt1, int paramInt2)
  {
    f.f(paramString, "<this>");
    paramInt1 = q(paramString, paramInt1, paramInt2);
    paramString = paramString.substring(paramInt1, s(paramString, paramInt1, paramInt2));
    f.e(paramString, "this as java.lang.String…ing(startIndex, endIndex)");
    return paramString;
  }
  
  public static final Throwable G(Exception paramException, List<? extends Exception> paramList)
  {
    f.f(paramException, "<this>");
    f.f(paramList, "suppressed");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      o8.a.a(paramException, (Exception)paramList.next());
    }
    return paramException;
  }
  
  public static final void H(c paramc, int paramInt)
  {
    f.f(paramc, "<this>");
    paramc.F(paramInt >>> 16 & 0xFF);
    paramc.F(paramInt >>> 8 & 0xFF);
    paramc.F(paramInt & 0xFF);
  }
  
  public static final <E> void a(List<E> paramList, E paramE)
  {
    f.f(paramList, "<this>");
    if (!paramList.contains(paramE)) {
      paramList.add(paramE);
    }
  }
  
  public static final int b(byte paramByte, int paramInt)
  {
    return paramByte & paramInt;
  }
  
  public static final int c(short paramShort, int paramInt)
  {
    return paramShort & paramInt;
  }
  
  public static final long d(int paramInt, long paramLong)
  {
    return paramInt & paramLong;
  }
  
  public static final void e(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) >= 0L) && (paramLong2 <= paramLong1) && (paramLong1 - paramLong2 >= paramLong3)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("length=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", offset=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(", count=");
    localStringBuilder.append(paramLong2);
    throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public static final void f(Closeable paramCloseable)
  {
    f.f(paramCloseable, "<this>");
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static final String[] g(String[] paramArrayOfString, String paramString)
  {
    f.f(paramArrayOfString, "<this>");
    f.f(paramString, "value");
    paramArrayOfString = Arrays.copyOf(paramArrayOfString, paramArrayOfString.length + 1);
    f.e(paramArrayOfString, "copyOf(this, newSize)");
    paramArrayOfString = (String[])paramArrayOfString;
    paramArrayOfString[p8.f.p(paramArrayOfString)] = paramString;
    return paramArrayOfString;
  }
  
  public static final int h(String paramString, char paramChar, int paramInt1, int paramInt2)
  {
    f.f(paramString, "<this>");
    while (paramInt1 < paramInt2)
    {
      if (paramString.charAt(paramInt1) == paramChar) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static final int i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    f.f(paramString1, "<this>");
    f.f(paramString2, "delimiters");
    while (paramInt1 < paramInt2)
    {
      if (f9.l.B(paramString2, paramString1.charAt(paramInt1), false, 2, null)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static final w k()
  {
    return c;
  }
  
  public static final e0 l()
  {
    return d;
  }
  
  public static final o m()
  {
    return b;
  }
  
  public static final boolean n(String[] paramArrayOfString1, String[] paramArrayOfString2, Comparator<? super String> paramComparator)
  {
    f.f(paramArrayOfString1, "<this>");
    f.f(paramComparator, "comparator");
    int i;
    if (paramArrayOfString1.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (paramArrayOfString2 != null))
    {
      if (paramArrayOfString2.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return false;
      }
      int k = paramArrayOfString1.length;
      i = 0;
      if (i < k)
      {
        String str = paramArrayOfString1[i];
        int j = i + 1;
        Iterator localIterator = a9.b.a(paramArrayOfString2);
        do
        {
          i = j;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (paramComparator.compare(str, (String)localIterator.next()) != 0);
        return true;
      }
    }
    return false;
  }
  
  public static final int o(String[] paramArrayOfString, String paramString, Comparator<String> paramComparator)
  {
    f.f(paramArrayOfString, "<this>");
    f.f(paramString, "value");
    f.f(paramComparator, "comparator");
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      int j;
      if (paramComparator.compare(paramArrayOfString[i], paramString) == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final int p(String paramString)
  {
    f.f(paramString, "<this>");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      int k = paramString.charAt(i);
      if (f.h(k, 31) > 0)
      {
        if (f.h(k, 127) >= 0) {
          return i;
        }
        i += 1;
      }
      else
      {
        return i;
      }
    }
    return -1;
  }
  
  public static final int q(String paramString, int paramInt1, int paramInt2)
  {
    f.f(paramString, "<this>");
    while (paramInt1 < paramInt2)
    {
      int k = paramString.charAt(paramInt1);
      int j = 0;
      if (k == 9) {}
      while (k == 10)
      {
        i = 1;
        break;
      }
      int i = 0;
      if (i != 0) {}
      while (k == 12)
      {
        i = 1;
        break;
      }
      i = 0;
      if (i != 0) {}
      while (k == 13)
      {
        i = 1;
        break;
      }
      i = 0;
      if (i != 0) {}
      do
      {
        i = 1;
        break;
        i = j;
      } while (k == 32);
      if (i != 0) {
        paramInt1 += 1;
      } else {
        return paramInt1;
      }
    }
    return paramInt2;
  }
  
  public static final int s(String paramString, int paramInt1, int paramInt2)
  {
    f.f(paramString, "<this>");
    paramInt2 -= 1;
    if (paramInt1 <= paramInt2)
    {
      for (;;)
      {
        int k = paramString.charAt(paramInt2);
        int j = 0;
        if (k == 9) {}
        while (k == 10)
        {
          i = 1;
          break;
        }
        int i = 0;
        if (i != 0) {}
        while (k == 12)
        {
          i = 1;
          break;
        }
        i = 0;
        if (i != 0) {}
        while (k == 13)
        {
          i = 1;
          break;
        }
        i = 0;
        if (i != 0) {}
        do
        {
          i = 1;
          break;
          i = j;
        } while (k == 32);
        if (i == 0) {
          break;
        }
        if (paramInt2 == paramInt1) {
          return paramInt1;
        }
        paramInt2 -= 1;
      }
      return paramInt2 + 1;
    }
    return paramInt1;
  }
  
  public static final int u(String paramString, int paramInt)
  {
    f.f(paramString, "<this>");
    int i = paramString.length();
    while (paramInt < i)
    {
      int j = paramString.charAt(paramInt);
      if ((j != 32) && (j != 9)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramString.length();
  }
  
  public static final <T> List<T> v(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    f.f(paramIterable1, "a");
    f.f(paramIterable2, "b");
    paramIterable1 = paramIterable1.iterator();
    paramIterable2 = paramIterable2.iterator();
    List localList = p8.l.c();
    for (;;)
    {
      if ((!paramIterable1.hasNext()) && (!paramIterable2.hasNext())) {
        return p8.l.a(localList);
      }
      if (paramIterable1.hasNext()) {
        localList.add(paramIterable1.next());
      }
      if (paramIterable2.hasNext()) {
        localList.add(paramIterable2.next());
      }
    }
  }
  
  public static final String[] w(String[] paramArrayOfString1, String[] paramArrayOfString2, Comparator<? super String> paramComparator)
  {
    f.f(paramArrayOfString1, "<this>");
    f.f(paramArrayOfString2, "other");
    f.f(paramComparator, "comparator");
    ArrayList localArrayList = new ArrayList();
    int m = paramArrayOfString1.length;
    int i = 0;
    while (i < m)
    {
      String str1 = paramArrayOfString1[i];
      int k = i + 1;
      int n = paramArrayOfString2.length;
      int j = 0;
      String str2;
      do
      {
        i = k;
        if (j >= n) {
          break;
        }
        str2 = paramArrayOfString2[j];
        j += 1;
      } while (paramComparator.compare(str1, str2) != 0);
      localArrayList.add(str1);
      i = k;
    }
    paramArrayOfString1 = localArrayList.toArray(new String[0]);
    Objects.requireNonNull(paramArrayOfString1, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    return (String[])paramArrayOfString1;
  }
  
  public static final boolean x(String paramString)
  {
    f.f(paramString, "name");
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!f9.l.l(paramString, "Authorization", true))
    {
      bool1 = bool2;
      if (!f9.l.l(paramString, "Cookie", true))
      {
        bool1 = bool2;
        if (!f9.l.l(paramString, "Proxy-Authorization", true))
        {
          if (f9.l.l(paramString, "Set-Cookie", true)) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public static final h y(j paramj, CharSequence paramCharSequence, int paramInt)
  {
    f.f(paramj, "<this>");
    f.f(paramCharSequence, "input");
    paramj = paramj.a(paramCharSequence, paramInt);
    if (paramj == null) {
      return null;
    }
    if (paramj.c().a() != paramInt) {
      return null;
    }
    return paramj;
  }
  
  public static final int z(char paramChar)
  {
    char c2 = '\001';
    if (('0' <= paramChar) && (paramChar < ':')) {
      c1 = '\001';
    } else {
      c1 = '\000';
    }
    if (c1 != 0) {
      return paramChar - '0';
    }
    char c3 = 'a';
    if (('a' <= paramChar) && (paramChar < 'g')) {
      c1 = '\001';
    } else {
      c1 = '\000';
    }
    if (c1 != 0) {}
    for (char c1 = c3;; c1 = c3)
    {
      return paramChar - c1 + 10;
      c3 = 'A';
      if (('A' <= paramChar) && (paramChar < 'G')) {
        c1 = c2;
      } else {
        c1 = '\000';
      }
      if (c1 == 0) {
        break;
      }
    }
    return -1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m9.l
 * JD-Core Version:    0.7.0.1
 */