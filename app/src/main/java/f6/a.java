package f6;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.common.api.response.LongResult;
import com.farsunset.hoxin.moment.api.response.CommentResult;
import com.farsunset.hoxin.moment.entity.Comment;
import ga.f;
import ga.o;
import ga.s;

public abstract interface a
{
  @f("comment/{id}")
  public abstract ea.b<CommentResult> a(@s("id") long paramLong);
  
  @ga.b("comment/{id}")
  public abstract ea.b<BaseResult> b(@s("id") long paramLong);
  
  @o("comment")
  public abstract ea.b<LongResult> d(@ga.a Comment paramComment);
  
  @o("comment/praise/{momentId}")
  public abstract ea.b<LongResult> e(@s("momentId") long paramLong);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f6.a
 * JD-Core Version:    0.7.0.1
 */