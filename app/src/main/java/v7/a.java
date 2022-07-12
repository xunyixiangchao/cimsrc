package v7;

import b8.b;
import b8.c;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import x7.e;
import x7.j;

final class a
  extends v<java.util.Date>
{
  private final Class<? extends java.util.Date> a;
  private final List<DateFormat> b;
  
  public a(Class<? extends java.util.Date> paramClass, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    this.b = localArrayList;
    this.a = g(paramClass);
    paramClass = Locale.US;
    localArrayList.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2, paramClass));
    if (!Locale.getDefault().equals(paramClass)) {
      localArrayList.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2));
    }
    if (e.e()) {
      localArrayList.add(j.c(paramInt1, paramInt2));
    }
  }
  
  a(Class<? extends java.util.Date> paramClass, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    this.b = localArrayList;
    this.a = g(paramClass);
    paramClass = Locale.US;
    localArrayList.add(new SimpleDateFormat(paramString, paramClass));
    if (!Locale.getDefault().equals(paramClass)) {
      localArrayList.add(new SimpleDateFormat(paramString));
    }
  }
  
  private java.util.Date e(String paramString)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      synchronized (this.b)
      {
        localObject1 = this.b.iterator();
        if (((Iterator)localObject1).hasNext()) {
          localObject2 = (DateFormat)((Iterator)localObject1).next();
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = ((DateFormat)localObject2).parse(paramString);
          return localObject2;
        }
        catch (ParseException localParseException2) {}
        try
        {
          localObject1 = z7.a.c(paramString, new ParsePosition(0));
          return localObject1;
        }
        catch (ParseException localParseException1)
        {
          throw new t(paramString, localParseException1);
        }
      }
      paramString = finally;
      throw paramString;
    }
  }
  
  private static Class<? extends java.util.Date> g(Class<? extends java.util.Date> paramClass)
  {
    if ((paramClass != java.util.Date.class) && (paramClass != java.sql.Date.class))
    {
      if (paramClass == Timestamp.class) {
        return paramClass;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Date type must be one of ");
      localStringBuilder.append(java.util.Date.class);
      localStringBuilder.append(", ");
      localStringBuilder.append(Timestamp.class);
      localStringBuilder.append(", or ");
      localStringBuilder.append(java.sql.Date.class);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(paramClass);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramClass;
  }
  
  public java.util.Date f(b8.a parama)
  {
    if (parama.u0() == b.i)
    {
      parama.q0();
      return null;
    }
    parama = e(parama.s0());
    Class localClass = this.a;
    if (localClass == java.util.Date.class) {
      return parama;
    }
    if (localClass == Timestamp.class) {
      return new Timestamp(parama.getTime());
    }
    if (localClass == java.sql.Date.class) {
      return new java.sql.Date(parama.getTime());
    }
    throw new AssertionError();
  }
  
  public void h(c paramc, java.util.Date paramDate)
  {
    if (paramDate == null)
    {
      paramc.k0();
      return;
    }
    synchronized (this.b)
    {
      paramc.x0(((DateFormat)this.b.get(0)).format(paramDate));
      return;
    }
  }
  
  public String toString()
  {
    Object localObject = (DateFormat)this.b.get(0);
    StringBuilder localStringBuilder;
    if ((localObject instanceof SimpleDateFormat))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DefaultDateTypeAdapter(");
    }
    for (localObject = ((SimpleDateFormat)localObject).toPattern();; localObject = localObject.getClass().getSimpleName())
    {
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DefaultDateTypeAdapter(");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     v7.a
 * JD-Core Version:    0.7.0.1
 */