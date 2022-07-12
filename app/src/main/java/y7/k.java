package y7;

import b8.c;
import com.google.gson.reflect.a;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import v7.f;
import v7.v;
import v7.w;

public final class k
  extends v<Time>
{
  public static final w b = new a();
  private final DateFormat a = new SimpleDateFormat("hh:mm:ss a");
  
  /* Error */
  public Time e(b8.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 50	b8/a:u0	()Lb8/b;
    //   6: getstatic 56	b8/b:i	Lb8/b;
    //   9: if_acmpne +11 -> 20
    //   12: aload_1
    //   13: invokevirtual 59	b8/a:q0	()V
    //   16: aload_0
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: new 38	java/sql/Time
    //   23: dup
    //   24: aload_0
    //   25: getfield 29	y7/k:a	Ljava/text/DateFormat;
    //   28: aload_1
    //   29: invokevirtual 63	b8/a:s0	()Ljava/lang/String;
    //   32: invokevirtual 69	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   35: invokevirtual 75	java/util/Date:getTime	()J
    //   38: invokespecial 78	java/sql/Time:<init>	(J)V
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: new 80	v7/t
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 83	v7/t:<init>	(Ljava/lang/Throwable;)V
    //   55: athrow
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	k
    //   0	61	1	parama	b8.a
    // Exception table:
    //   from	to	target	type
    //   20	42	46	java/text/ParseException
    //   2	16	56	finally
    //   20	42	56	finally
    //   47	56	56	finally
  }
  
  public void f(c paramc, Time paramTime)
  {
    if (paramTime == null) {
      paramTime = null;
    }
    try
    {
      paramTime = this.a.format(paramTime);
      paramc.x0(paramTime);
      return;
    }
    finally {}
  }
  
  static final class a
    implements w
  {
    public <T> v<T> a(f paramf, a<T> parama)
    {
      if (parama.getRawType() == Time.class) {
        return new k();
      }
      return null;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.k
 * JD-Core Version:    0.7.0.1
 */