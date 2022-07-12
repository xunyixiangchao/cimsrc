package z3;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.emoticon.api.response.EmoticonItemListResult;
import com.farsunset.hoxin.emoticon.api.response.EmoticonPageResult;
import com.farsunset.hoxin.emoticon.api.response.EmoticonResult;
import ea.b;
import ga.f;
import ga.o;
import ga.s;

public abstract interface a
{
  @f("emoticon/{id}")
  public abstract b<EmoticonResult> a(@s("id") long paramLong);
  
  @o("emoticon/disable/{id}")
  public abstract b<BaseResult> b(@s("id") long paramLong);
  
  @o("emoticon/enable/{id}")
  public abstract b<BaseResult> c(@s("id") long paramLong);
  
  @o("emoticon/{id}")
  public abstract b<BaseResult> d(@s("id") long paramLong);
  
  @f("emoticon/item/list/{id}")
  public abstract b<EmoticonItemListResult> e(@s("id") long paramLong);
  
  @f("emoticon/mall/list/{currentPage}")
  public abstract b<EmoticonPageResult> f(@s("currentPage") int paramInt);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     z3.a
 * JD-Core Version:    0.7.0.1
 */