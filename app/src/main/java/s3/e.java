package s3;

import com.farsunset.hoxin.common.api.response.BaseResult;

public abstract interface e<T extends BaseResult>
{
  public abstract void onHttpException(Exception paramException);
  
  public abstract void onHttpResponse(T paramT);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s3.e
 * JD-Core Version:    0.7.0.1
 */