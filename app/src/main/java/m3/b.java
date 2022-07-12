package m3;

import com.farsunset.hoxin.common.api.response.BaseResult;
import ga.l;
import ga.o;
import ga.q;
import ga.s;
import l9.a0.c;

public abstract interface b
{
  @o("file/count/{bucket}/{key}")
  public abstract ea.b<BaseResult> a(@s("bucket") String paramString1, @s("key") String paramString2);
  
  @l
  @o("file/{bucket}/{key}")
  public abstract ea.b<BaseResult> b(@q a0.c paramc, @s("bucket") String paramString1, @s("key") String paramString2);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     m3.b
 * JD-Core Version:    0.7.0.1
 */