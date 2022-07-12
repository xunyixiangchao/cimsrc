package t9;

import a9.f;
import aa.e.a;
import f9.l;
import m9.o;

public final class e
{
  public static final e a = new e();
  public static final aa.e b = aa.e.d.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  private static final String[] c = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
  private static final String[] d = new String[64];
  private static final String[] e;
  
  static
  {
    Object localObject1 = new String[256];
    int k = 0;
    int i = 0;
    while (i < 256)
    {
      localObject2 = Integer.toBinaryString(i);
      f.e(localObject2, "toBinaryString(it)");
      localObject1[i] = l.s(o.i("%8s", new Object[] { localObject2 }), ' ', '0', false, 4, null);
      i += 1;
    }
    e = (String[])localObject1;
    Object localObject2 = d;
    localObject2[0] = "";
    localObject2[1] = "END_STREAM";
    localObject1 = new int[1];
    localObject1[0] = 1;
    localObject2[8] = "PADDED";
    i = 0;
    while (i < 1)
    {
      j = localObject1[i];
      i += 1;
      localObject2 = d;
      localObject2[(j | 0x8)] = f.m(localObject2[j], "|PADDED");
    }
    localObject2 = d;
    localObject2[4] = "END_HEADERS";
    localObject2[32] = "PRIORITY";
    localObject2[36] = "END_HEADERS|PRIORITY";
    int j = 0;
    if (j < 3)
    {
      int n = new int[] { 4, 32, 36 }[j];
      int m = j + 1;
      i = 0;
      for (;;)
      {
        j = m;
        if (i >= 1) {
          break;
        }
        j = localObject1[i];
        i += 1;
        localObject2 = d;
        int i1 = j | n;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject2[j]);
        localStringBuilder.append('|');
        localStringBuilder.append(localObject2[n]);
        localObject2[i1] = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject2[j]);
        localStringBuilder.append('|');
        localStringBuilder.append(localObject2[n]);
        localStringBuilder.append("|PADDED");
        localObject2[(i1 | 0x8)] = localStringBuilder.toString();
      }
    }
    j = d.length;
    i = k;
    while (i < j)
    {
      localObject1 = d;
      if (localObject1[i] == null) {
        localObject1[i] = e[i];
      }
      i += 1;
    }
  }
  
  public final String a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return "";
    }
    if ((paramInt1 != 2) && (paramInt1 != 3)) {
      if ((paramInt1 != 4) && (paramInt1 != 6))
      {
        if ((paramInt1 != 7) && (paramInt1 != 8))
        {
          Object localObject = d;
          if (paramInt2 < localObject.length)
          {
            localObject = localObject[paramInt2];
            f.c(localObject);
          }
          else
          {
            localObject = e[paramInt2];
          }
          String str1;
          if ((paramInt1 == 5) && ((paramInt2 & 0x4) != 0)) {
            str1 = "HEADERS";
          }
          for (String str2 = "PUSH_PROMISE";; str2 = "COMPRESSED")
          {
            return l.t((String)localObject, str1, str2, false, 4, null);
            if ((paramInt1 != 0) || ((paramInt2 & 0x20) == 0)) {
              break;
            }
            str1 = "PRIORITY";
          }
          return localObject;
        }
      }
      else
      {
        if (paramInt2 == 1) {
          return "ACK";
        }
        return e[paramInt2];
      }
    }
    return e[paramInt2];
  }
  
  public final String b(int paramInt)
  {
    String[] arrayOfString = c;
    if (paramInt < arrayOfString.length) {
      return arrayOfString[paramInt];
    }
    return o.i("0x%02x", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final String c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str2 = b(paramInt3);
    String str3 = a(paramInt3, paramInt4);
    String str1;
    if (paramBoolean) {
      str1 = "<<";
    } else {
      str1 = ">>";
    }
    return o.i("%s 0x%08x %5d %-13s %s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str2, str3 });
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t9.e
 * JD-Core Version:    0.7.0.1
 */