package com.baidu.b.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import com.baidu.b.a.d;
import com.baidu.b.d.b;
import com.baidu.b.h;
import com.baidu.b.h.a;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class e
  extends a
{
  private Context d;
  private f e;
  
  public e()
  {
    super("upc", 9000000L);
    f localf = new f();
    this.e = localf;
    localf.a();
  }
  
  private a a(String paramString, int paramInt1, List paramList, int paramInt2, e parame)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e.c.a locala = (e.c.a)paramList.next();
      if (a(paramString, paramInt1, e.c.a.b(locala), paramInt2, parame))
      {
        locala.a();
        return e.c.a.b(locala);
      }
    }
    return null;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".cesium");
    return localStringBuilder.toString();
  }
  
  private String a(String paramString, int paramInt, a parama)
  {
    return String.format("content://%s/dat/v1/i%d/%s", new Object[] { a(paramString), Integer.valueOf(paramInt), parama.a() });
  }
  
  private String a(String paramString, a parama)
  {
    return String.format("content://%s/dic/v1/%s", new Object[] { a(paramString), parama.a() });
  }
  
  private boolean a(String paramString, int paramInt1, a parama, int paramInt2, e parame)
  {
    paramString = Uri.parse(a(paramString, paramInt1, parama));
    paramInt1 = 0;
    if ((paramInt1 >= 2) || (parame != null)) {}
    try
    {
      parame.a += 1;
      int i = this.e.a(this.d, paramString, 0, paramInt2, 1);
      paramInt1 = i;
    }
    finally
    {
      try
      {
        for (;;)
        {
          Thread.sleep(5L);
          label65:
          paramInt1 += 1;
          break;
          paramInt1 = -1;
          if (paramInt1 == 0) {
            return true;
          }
          if (parame != null) {
            parame.b += 1;
          }
          return false;
          parama = finally;
        }
      }
      catch (Exception parama)
      {
        break label65;
      }
    }
  }
  
  private boolean a(String paramString, a parama, int paramInt)
  {
    paramString = Uri.parse(a(paramString, parama));
    int i = 0;
    if (i < 2) {}
    try
    {
      int j = this.e.a(this.d, paramString, 0, paramInt, 1);
      paramInt = j;
    }
    finally
    {
      try
      {
        for (;;)
        {
          Thread.sleep(5L);
          label48:
          i += 1;
          break;
          paramInt = -1;
          return paramInt == 0;
          parama = finally;
        }
      }
      catch (Exception parama)
      {
        break label48;
      }
    }
  }
  
  public a.e a(String paramString, a.d paramd)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return a.e.b();
    }
    int i = -1;
    paramd = this.d.getPackageManager();
    try
    {
      j = paramd.getPackageUid(paramString, 0);
      i = j;
    }
    catch (PackageManager.NameNotFoundException paramd)
    {
      int j;
      label35:
      e locale;
      b localb1;
      c localc1;
      c localc2;
      Object localObject;
      byte[] arrayOfByte;
      byte b;
      boolean bool1;
      a locala;
      b localb2;
      break label35;
    }
    if (i < 0) {
      return a.e.b();
    }
    locale = new e();
    localb1 = new b();
    localc1 = new c();
    localc2 = new c();
    j = 0;
    while (j < 16)
    {
      paramd = a.a(j);
      if (a(paramString, paramd, i)) {
        localc1.a(paramd);
      } else {
        localc2.a(paramd);
      }
      j += 1;
    }
    j = 0;
    while (j < 32)
    {
      localObject = a(paramString, j, localc1.a(), i, locale);
      paramd = (a.d)localObject;
      if (localObject == null) {
        paramd = a(paramString, j, localc2.a(), i, locale);
      }
      if (paramd == null) {
        return a.e.b();
      }
      localb1.a(paramd);
      j += 1;
    }
    arrayOfByte = localb1.b();
    paramd = new byte[3];
    paramd[0] = "0".getBytes()[0];
    b = "O".getBytes()[0];
    bool1 = true;
    paramd[1] = b;
    paramd[2] = "V".getBytes()[0];
    j = 0;
    for (;;)
    {
      localb1 = null;
      if (j >= 3) {
        break;
      }
      b = paramd[j];
      localObject = a.a(b, false);
      boolean bool2 = bool1;
      if (a(paramString, 32, (a)localObject, i, locale))
      {
        locala = a.a(b, bool2);
        if (a(paramString, 33, locala, i, locale))
        {
          paramd = new b();
          paramd.a((a)localObject);
          paramd.a(locala);
          paramd = Byte.valueOf(paramd.b()[0]);
          break label371;
        }
      }
      j += 1;
      bool1 = bool2;
    }
    paramd = null;
    label371:
    if (paramd == null)
    {
      paramd = new b();
      j = 32;
      while (j < 34)
      {
        locala = a(paramString, j, localc1.a(), i, locale);
        localObject = locala;
        if (locala == null) {
          localObject = a(paramString, j, localc2.a(), i, locale);
        }
        if (localObject == null) {
          return a.e.b();
        }
        paramd.a((a)localObject);
        j += 1;
      }
      paramd = Byte.valueOf(paramd.b()[0]);
    }
    else
    {
      bool1 = false;
    }
    localObject = localb1;
    if (bool1)
    {
      localb2 = new b();
      j = 34;
      while (j < 94)
      {
        locala = a(paramString, j, localc1.a(), i, locale);
        localObject = locala;
        if (locala == null) {
          localObject = a(paramString, j, localc2.a(), i, locale);
        }
        if (localObject == null) {
          break;
        }
        localb2.a((a)localObject);
        j += 1;
      }
      localObject = localb1;
      if (localb2.a() > 0) {
        localObject = localb2.b();
      }
    }
    return a.e.a(new d(arrayOfByte, paramd.byteValue(), (byte[])localObject).a());
  }
  
  public void a(a.c paramc)
  {
    this.d = this.a.a;
  }
  
  static final class a
    implements Comparable
  {
    private static final String[] a = { "read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3" };
    private final int b;
    
    private a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public static a a(byte paramByte, boolean paramBoolean)
    {
      paramByte &= 0xFF;
      if (paramBoolean) {
        paramByte >>= 4;
      }
      for (;;)
      {
        return a(paramByte);
        paramByte &= 0xF;
      }
    }
    
    public static a a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < 16)) {
        return new a(paramInt);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid idx ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public int a(a parama)
    {
      return this.b - parama.b;
    }
    
    public String a()
    {
      return a[this.b];
    }
    
    public byte b()
    {
      return (byte)this.b;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (a.class != paramObject.getClass()) {
          return false;
        }
        paramObject = (a)paramObject;
        return this.b == paramObject.b;
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.b;
    }
  }
  
  class b
  {
    private int b = 33;
    private e.a[] c = new e.a[33];
    private int d;
    
    public b() {}
    
    private void b(int paramInt)
    {
      e.a[] arrayOfa = this.c;
      if (paramInt - arrayOfa.length > 0)
      {
        int i = arrayOfa.length;
        i += (i >> 1);
        if (i - paramInt >= 0) {
          paramInt = i;
        }
        this.c = ((e.a[])Arrays.copyOf(arrayOfa, paramInt));
      }
    }
    
    public int a()
    {
      return this.d;
    }
    
    public e.a a(int paramInt)
    {
      if (paramInt < this.d) {
        return this.c[paramInt];
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("idx ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" size ");
      localStringBuilder.append(this.d);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    public void a(e.a parama)
    {
      b(this.d + 1);
      e.a[] arrayOfa = this.c;
      int i = this.d;
      this.d = (i + 1);
      arrayOfa[i] = parama;
    }
    
    public byte[] b()
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      int i = 0;
      int j;
      for (;;)
      {
        j = this.d;
        if (i >= j / 2) {
          break;
        }
        j = i * 2;
        int k = a(j).b();
        localByteArrayOutputStream.write((byte)((a(j + 1).b() & 0xFF) << 4 | k & 0xFF));
        i += 1;
      }
      if (j % 2 != 0) {
        localByteArrayOutputStream.write((byte)(a(j - 1).b() & 0xFF));
      }
      return localByteArrayOutputStream.toByteArray();
    }
  }
  
  static class c
  {
    private List a = new ArrayList();
    
    public List a()
    {
      ArrayList localArrayList = new ArrayList(this.a);
      Collections.sort(localArrayList, new f(this));
      return localArrayList;
    }
    
    public void a(e.a parama)
    {
      this.a.add(new a(parama));
    }
    
    static class a
    {
      private int a;
      private e.a b;
      
      public a(e.a parama)
      {
        this.b = parama;
      }
      
      public void a()
      {
        this.a += 1;
      }
    }
  }
  
  static class d
  {
    byte[] a;
    byte b;
    byte[] c;
    
    public d(byte[] paramArrayOfByte1, byte paramByte, byte[] paramArrayOfByte2)
    {
      this.a = paramArrayOfByte1;
      this.b = paramByte;
      this.c = paramArrayOfByte2;
    }
    
    public h.a a()
    {
      for (;;)
      {
        try
        {
          String str1 = b.a(this.a, "", true);
          String str2 = new String(new byte[] { this.b }, "UTF-8");
          Object localObject1 = this.c;
          if (localObject1 != null)
          {
            localObject1 = new String((byte[])localObject1, "UTF-8");
            localObject1 = h.a(str1, str2, (String)localObject1);
            return localObject1;
          }
        }
        catch (Exception localException)
        {
          return null;
        }
        Object localObject2 = null;
      }
    }
  }
  
  static class e
  {
    public int a;
    public int b;
    public int c = 16;
    
    public String toString()
    {
      return "";
    }
  }
  
  static class f
  {
    private Method a;
    private Method b;
    private Method c;
    private Method d;
    private Method e;
    
    public int a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, int paramInt3)
    {
      try
      {
        paramInt1 = ((Integer)this.a.invoke(paramContext, new Object[] { paramUri, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).intValue();
        return paramInt1;
      }
      catch (Exception paramContext)
      {
        throw new com.baidu.b.a.e.a(paramContext);
      }
    }
    
    void a()
    {
      try
      {
        String str = com.baidu.b.a.e.a(d.d());
        Class localClass = Integer.TYPE;
        this.a = com.baidu.b.a.e.a(Context.class, str, new Class[] { Uri.class, localClass, localClass, localClass });
        this.b = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(d.e()), new Class[] { String.class, Uri.class, localClass });
        this.c = com.baidu.b.a.e.a(ContentResolver.class, com.baidu.b.a.e.a(d.f()), new Class[] { Uri.class, localClass });
        this.d = com.baidu.b.a.e.a(Context.class, com.baidu.b.a.e.a(d.g()), new Class[] { Uri.class, localClass });
        this.e = com.baidu.b.a.e.a(ContentResolver.class, com.baidu.b.a.e.a(d.h()), new Class[] { Uri.class, localClass });
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.b.b.e
 * JD-Core Version:    0.7.0.1
 */