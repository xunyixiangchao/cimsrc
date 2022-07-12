package y7;

import b8.b;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import v7.f;
import v7.v;
import v7.w;
import x7.e;
import x7.j;

public final class c
  extends v<Date>
{
  public static final w b = new a();
  private final List<DateFormat> a;
  
  public c()
  {
    ArrayList localArrayList = new ArrayList();
    this.a = localArrayList;
    Locale localLocale = Locale.US;
    localArrayList.add(DateFormat.getDateTimeInstance(2, 2, localLocale));
    if (!Locale.getDefault().equals(localLocale)) {
      localArrayList.add(DateFormat.getDateTimeInstance(2, 2));
    }
    if (e.e()) {
      localArrayList.add(j.c(2, 2));
    }
  }
  
  /* Error */
  private Date e(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	y7/c:a	Ljava/util/List;
    //   6: invokeinterface 72 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface 77 1 0
    //   18: ifeq +23 -> 41
    //   21: aload_2
    //   22: invokeinterface 81 1 0
    //   27: checkcast 34	java/text/DateFormat
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 84	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   36: astore_3
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_3
    //   40: areturn
    //   41: aload_1
    //   42: new 86	java/text/ParsePosition
    //   45: dup
    //   46: iconst_0
    //   47: invokespecial 89	java/text/ParsePosition:<init>	(I)V
    //   50: invokestatic 94	z7/a:c	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: areturn
    //   58: astore_2
    //   59: new 96	v7/t
    //   62: dup
    //   63: aload_1
    //   64: aload_2
    //   65: invokespecial 99	v7/t:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   68: athrow
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: astore_3
    //   75: goto -63 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	c
    //   0	78	1	paramString	java.lang.String
    //   11	46	2	localObject1	Object
    //   58	7	2	localParseException1	java.text.ParseException
    //   30	10	3	localObject2	Object
    //   74	1	3	localParseException2	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   41	54	58	java/text/ParseException
    //   2	12	69	finally
    //   12	31	69	finally
    //   31	37	69	finally
    //   41	54	69	finally
    //   59	69	69	finally
    //   31	37	74	java/text/ParseException
  }
  
  public Date f(b8.a parama)
  {
    if (parama.u0() == b.i)
    {
      parama.q0();
      return null;
    }
    return e(parama.s0());
  }
  
  public void g(b8.c paramc, Date paramDate)
  {
    if (paramDate == null) {}
    try
    {
      paramc.k0();
      return;
    }
    finally {}
    paramc.x0(((DateFormat)this.a.get(0)).format(paramDate));
  }
  
  static final class a
    implements w
  {
    public <T> v<T> a(f paramf, com.google.gson.reflect.a<T> parama)
    {
      if (parama.getRawType() == Date.class) {
        return new c();
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.c
 * JD-Core Version:    0.7.0.1
 */