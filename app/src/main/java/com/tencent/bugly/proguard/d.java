package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class d
  extends c
{
  private static HashMap<String, byte[]> f;
  private static HashMap<String, HashMap<String, byte[]>> g;
  private f e;
  
  public d()
  {
    f localf = new f();
    this.e = localf;
    localf.a = 2;
  }
  
  public final void a(int paramInt)
  {
    this.e.b = 1;
  }
  
  public final <T> void a(String paramString, T paramT)
  {
    if (!paramString.startsWith("."))
    {
      super.a(paramString, paramT);
      return;
    }
    paramT = new StringBuilder("put name can not startwith . , now is ");
    paramT.append(paramString);
    throw new IllegalArgumentException(paramT.toString());
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 4) {
      try
      {
        paramArrayOfByte = new h(paramArrayOfByte, 4);
        paramArrayOfByte.a(this.b);
        this.e.a(paramArrayOfByte);
        paramArrayOfByte = this.e;
        int i = paramArrayOfByte.a;
        HashMap localHashMap;
        if (i == 3)
        {
          paramArrayOfByte = new h(paramArrayOfByte.e);
          paramArrayOfByte.a(this.b);
          if (f == null)
          {
            localHashMap = new HashMap();
            f = localHashMap;
            localHashMap.put("", new byte[0]);
          }
          this.d = paramArrayOfByte.a(f, 0, false);
          return;
        }
        paramArrayOfByte = new h(paramArrayOfByte.e);
        paramArrayOfByte.a(this.b);
        if (g == null)
        {
          g = new HashMap();
          localHashMap = new HashMap();
          localHashMap.put("", new byte[0]);
          g.put("", localHashMap);
        }
        this.a = paramArrayOfByte.a(g, 0, false);
        new HashMap();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        throw new RuntimeException(paramArrayOfByte);
      }
    }
    throw new IllegalArgumentException("decode package must include size head");
  }
  
  public final byte[] a()
  {
    Object localObject1 = this.e;
    if (((f)localObject1).a == 2)
    {
      if (!((f)localObject1).c.equals(""))
      {
        if (this.e.d.equals("")) {
          throw new IllegalArgumentException("funcName can not is null");
        }
      }
      else {
        throw new IllegalArgumentException("servantName can not is null");
      }
    }
    else
    {
      if (((f)localObject1).c == null) {
        ((f)localObject1).c = "";
      }
      if (((f)localObject1).d == null) {
        ((f)localObject1).d = "";
      }
    }
    Object localObject2 = new i(0);
    ((i)localObject2).a(this.b);
    if (this.e.a == 2) {
      localObject1 = this.a;
    } else {
      localObject1 = this.d;
    }
    ((i)localObject2).a((Map)localObject1, 0);
    this.e.e = k.a(((i)localObject2).a());
    localObject1 = new i(0);
    ((i)localObject1).a(this.b);
    this.e.a((i)localObject1);
    localObject1 = k.a(((i)localObject1).a());
    int i = localObject1.length + 4;
    localObject2 = ByteBuffer.allocate(i);
    ((ByteBuffer)localObject2).putInt(i).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
  
  public final void b(String paramString)
  {
    this.e.c = paramString;
  }
  
  public final void c()
  {
    super.c();
    this.e.a = 3;
  }
  
  public final void c(String paramString)
  {
    this.e.d = paramString;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.d
 * JD-Core Version:    0.7.0.1
 */