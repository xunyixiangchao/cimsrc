package d6;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.moment.api.response.CommentResult;
import com.farsunset.hoxin.moment.entity.Comment;
import ea.t;
import java.io.IOException;
import l3.b.c;
import l3.b.d;
import s3.h0;

public class a
  extends l3.b
{
  public static void b(long paramLong, s3.e<BaseResult> parame)
  {
    ((f6.a)l3.b.a(f6.a.class)).b(paramLong).B(new b.d(parame));
  }
  
  public static Comment c(long paramLong)
  {
    Object localObject = (f6.a)l3.b.a(f6.a.class);
    try
    {
      localObject = ((f6.a)localObject).a(paramLong).g();
      if ((((t)localObject).d()) && (((t)localObject).a() != null))
      {
        localObject = ((CommentResult)((t)localObject).a()).data;
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
  
  public static void d(long paramLong, s3.e<CommentResult> parame)
  {
    ((f6.a)l3.b.a(f6.a.class)).e(paramLong).B(new b.c(new b(paramLong, parame)));
  }
  
  public static void e(Comment paramComment, final s3.e<CommentResult> parame)
  {
    ((f6.a)l3.b.a(f6.a.class)).d(paramComment).B(new b.c(new a(parame)));
  }
  
  class a
    extends h0<LongResult>
  {
    a(s3.e parame) {}
    
    public void a(LongResult paramLongResult)
    {
      a.this.uid = i3.e.o().longValue();
      a.this.id = paramLongResult.data.longValue();
      a.this.createTime = Long.valueOf(System.currentTimeMillis());
      CommentResult localCommentResult = new CommentResult();
      localCommentResult.data = a.this;
      localCommentResult.code = paramLongResult.code;
      parame.onHttpResponse(localCommentResult);
    }
    
    public void onHttpException(Exception paramException)
    {
      parame.onHttpException(paramException);
    }
  }
  
  class b
    extends h0<LongResult>
  {
    b(s3.e parame) {}
    
    public void a(LongResult paramLongResult)
    {
      Comment localComment = new Comment();
      localComment.createTime = Long.valueOf(System.currentTimeMillis());
      localComment.id = paramLongResult.data.longValue();
      localComment.momentId = this.a;
      localComment.type = "2";
      localComment.uid = i3.e.o().longValue();
      CommentResult localCommentResult = new CommentResult();
      localCommentResult.data = localComment;
      localCommentResult.code = paramLongResult.code;
      this.b.onHttpResponse(localCommentResult);
    }
    
    public void onHttpException(Exception paramException)
    {
      this.b.onHttpException(paramException);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d6.a
 * JD-Core Version:    0.7.0.1
 */