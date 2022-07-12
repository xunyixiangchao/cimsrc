package d6;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.common.api.response.UrlListResult;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.moment.api.response.MomentListResult;
import com.farsunset.hoxin.moment.api.response.MomentResult;
import com.farsunset.hoxin.moment.entity.Moment;
import ea.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l3.b.c;
import s3.e;
import u3.b0;
import u3.l;

public class b
  extends l3.b
{
  public static void b(long paramLong, byte paramByte, e<BaseResult> parame)
  {
    ((f6.b)l3.b.a(f6.b.class)).g(paramLong, paramByte).B(new b.c(parame));
  }
  
  public static void c(long paramLong, e<BaseResult> parame)
  {
    ((f6.b)l3.b.a(f6.b.class)).b(paramLong).B(new b.c(parame));
  }
  
  public static void d(long paramLong, e<UrlListResult> parame)
  {
    ((f6.b)l3.b.a(f6.b.class)).h(paramLong).B(new b.c(new a(parame)));
  }
  
  public static Moment e(long paramLong)
  {
    Object localObject = (f6.b)l3.b.a(f6.b.class);
    try
    {
      localObject = ((f6.b)localObject).a(paramLong).g();
      if ((((t)localObject).d()) && (((t)localObject).a() != null))
      {
        localObject = ((MomentResult)((t)localObject).a()).data;
        return localObject;
      }
    }
    catch (IOException localIOException)
    {
      label49:
      break label49;
    }
    return null;
  }
  
  public static void f(long paramLong, e<MomentResult> parame)
  {
    ((f6.b)l3.b.a(f6.b.class)).a(paramLong).B(new b.c(parame));
  }
  
  public static LongResult g(Moment paramMoment)
  {
    f6.b localb = (f6.b)l3.b.a(f6.b.class);
    try
    {
      paramMoment = (LongResult)localb.f(paramMoment).g().a();
      return paramMoment;
    }
    catch (Exception paramMoment)
    {
      label30:
      break label30;
    }
    return null;
  }
  
  public static void h(int paramInt, e<MomentListResult> parame)
  {
    ((f6.b)l3.b.a(f6.b.class)).i(paramInt).B(new b.c(parame));
  }
  
  public static void i(long paramLong, int paramInt, e<MomentListResult> parame)
  {
    ((f6.b)l3.b.a(f6.b.class)).j(paramLong, paramInt).B(new b.c(parame));
  }
  
  public static void j(int paramInt, e<MomentListResult> parame)
  {
    ((f6.b)l3.b.a(f6.b.class)).l(paramInt).B(new b.c(parame));
  }
  
  public static void k(long paramLong, byte paramByte, e<BaseResult> parame)
  {
    ((f6.b)l3.b.a(f6.b.class)).k(paramLong, paramByte).B(new b.c(parame));
  }
  
  public static void l()
  {
    ((f6.b)l3.b.a(f6.b.class)).m().B(l3.b.a);
  }
  
  class a
    implements e<MomentListResult>
  {
    a() {}
    
    public void a(MomentListResult paramMomentListResult)
    {
      if (paramMomentListResult.isEmpty()) {
        return;
      }
      UrlListResult localUrlListResult = new UrlListResult();
      Iterator localIterator = paramMomentListResult.data.iterator();
      while (localIterator.hasNext())
      {
        paramMomentListResult = (Moment)localIterator.next();
        int i = paramMomentListResult.type;
        Object localObject;
        if (i == 2)
        {
          paramMomentListResult = (CloudVideo)l.s0(paramMomentListResult.content, CloudVideo.class);
          localObject = localUrlListResult.data;
        }
        for (paramMomentListResult = paramMomentListResult.image;; paramMomentListResult = paramMomentListResult.thumb)
        {
          ((List)localObject).add(b0.h(paramMomentListResult));
          break;
          if (i != 0) {
            break label126;
          }
          paramMomentListResult = (CloudImage)l.s0(paramMomentListResult.content, CloudImage.class);
          localObject = localUrlListResult.data;
        }
        label126:
        if (i == 4)
        {
          paramMomentListResult = l.u0(paramMomentListResult.content, CloudImage.class).iterator();
          while (paramMomentListResult.hasNext())
          {
            localObject = (CloudImage)paramMomentListResult.next();
            localUrlListResult.data.add(b0.h(((CloudImage)localObject).thumb));
          }
        }
      }
      b.this.onHttpResponse(localUrlListResult);
    }
    
    public void onHttpException(Exception paramException) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d6.b
 * JD-Core Version:    0.7.0.1
 */