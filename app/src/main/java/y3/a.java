package y3;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.emoticon.api.response.EmoticonItemListResult;
import com.farsunset.hoxin.emoticon.api.response.EmoticonPageResult;
import com.farsunset.hoxin.emoticon.api.response.EmoticonResult;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import ea.t;
import l3.b.c;
import s3.e;

public class a
  extends l3.b
{
  public static void b(long paramLong, e<BaseResult> parame)
  {
    ((z3.a)l3.b.a(z3.a.class)).d(paramLong).B(new b.c(parame));
  }
  
  public static void c(long paramLong)
  {
    ((z3.a)l3.b.a(z3.a.class)).b(paramLong).B(l3.b.a);
  }
  
  public static void d(long paramLong)
  {
    ((z3.a)l3.b.a(z3.a.class)).c(paramLong).B(l3.b.a);
  }
  
  public static Emoticon e(long paramLong)
  {
    Object localObject = (z3.a)l3.b.a(z3.a.class);
    try
    {
      localObject = ((z3.a)localObject).a(paramLong).g();
      if ((((t)localObject).d()) && (((t)localObject).a() != null))
      {
        localObject = ((EmoticonResult)((t)localObject).a()).data;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      label49:
      break label49;
    }
    return null;
  }
  
  public static void f(long paramLong, e<EmoticonItemListResult> parame)
  {
    ((z3.a)l3.b.a(z3.a.class)).e(paramLong).B(new b.c(parame));
  }
  
  public static void g(int paramInt, e<EmoticonPageResult> parame)
  {
    ((z3.a)l3.b.a(z3.a.class)).f(paramInt).B(new b.c(parame));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y3.a
 * JD-Core Version:    0.7.0.1
 */