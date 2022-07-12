package d4;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import com.farsunset.hoxin.emoticon.entity.EmoticonItem;
import java.util.Iterator;
import java.util.List;
import u3.b0;

public class d
  implements c
{
  private static d a = new d();
  
  public static d c()
  {
    return a;
  }
  
  private c e(long paramLong)
  {
    if (paramLong == 0L) {
      return b.d();
    }
    return a.c();
  }
  
  public int a(long paramLong)
  {
    return e(paramLong).a(paramLong);
  }
  
  public List<EmoticonItem> b(long paramLong)
  {
    return e(paramLong).b(paramLong);
  }
  
  public List<Emoticon> d()
  {
    List localList = a4.a.g();
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Emoticon localEmoticon = (Emoticon)((Iterator)localObject).next();
      localEmoticon.icon = b0.e(localEmoticon.id.longValue());
    }
    localObject = new Emoticon();
    ((Emoticon)localObject).id = Long.valueOf(0L);
    ((Emoticon)localObject).icon = androidx.core.content.b.d(HoxinApplication.h(), 2131165561);
    localList.add(0, localObject);
    return localList;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d4.d
 * JD-Core Version:    0.7.0.1
 */