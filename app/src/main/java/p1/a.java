package p1;

public final class a
  implements j
{
  private final String a;
  private final Object[] b;
  
  public a(String paramString)
  {
    this(paramString, null);
  }
  
  public a(String paramString, Object[] paramArrayOfObject)
  {
    this.a = paramString;
    this.b = paramArrayOfObject;
  }
  
  private static void b(i parami, int paramInt, Object paramObject)
  {
    if (paramObject == null)
    {
      parami.y(paramInt);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      parami.S(paramInt, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof Float)) {}
    for (double d = ((Float)paramObject).floatValue();; d = ((Double)paramObject).doubleValue())
    {
      parami.A(paramInt, d);
      return;
      if (!(paramObject instanceof Double)) {
        break;
      }
    }
    long l;
    if ((paramObject instanceof Long)) {
      l = ((Long)paramObject).longValue();
    }
    for (;;)
    {
      parami.O(paramInt, l);
      return;
      int i;
      if ((paramObject instanceof Integer)) {
        i = ((Integer)paramObject).intValue();
      }
      for (;;)
      {
        l = i;
        break;
        if ((paramObject instanceof Short))
        {
          i = ((Short)paramObject).shortValue();
        }
        else
        {
          if (!(paramObject instanceof Byte)) {
            break label162;
          }
          i = ((Byte)paramObject).byteValue();
        }
      }
      label162:
      if ((paramObject instanceof String))
      {
        parami.r(paramInt, (String)paramObject);
        return;
      }
      if (!(paramObject instanceof Boolean)) {
        break;
      }
      if (((Boolean)paramObject).booleanValue()) {
        l = 1L;
      } else {
        l = 0L;
      }
    }
    parami = new StringBuilder();
    parami.append("Cannot bind ");
    parami.append(paramObject);
    parami.append(" at index ");
    parami.append(paramInt);
    parami.append(" Supported types: null, byte[], float, double, long, int, short, byte, string");
    throw new IllegalArgumentException(parami.toString());
  }
  
  public static void c(i parami, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      return;
    }
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      i += 1;
      b(parami, i, localObject);
    }
  }
  
  public void a(i parami)
  {
    c(parami, this.b);
  }
  
  public String g()
  {
    return this.a;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p1.a
 * JD-Core Version:    0.7.0.1
 */