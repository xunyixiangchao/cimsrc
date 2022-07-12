package d2;

import b2.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import x2.k;

public class t<Data, ResourceType, Transcode>
{
  private final Class<Data> a;
  private final x0.e<List<Throwable>> b;
  private final List<? extends i<Data, ResourceType, Transcode>> c;
  private final String d;
  
  public t(Class<Data> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<i<Data, ResourceType, Transcode>> paramList, x0.e<List<Throwable>> parame)
  {
    this.a = paramClass;
    this.b = parame;
    this.c = ((List)k.c(paramList));
    paramList = new StringBuilder();
    paramList.append("Failed LoadPath{");
    paramList.append(paramClass.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass1.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass2.getSimpleName());
    paramList.append("}");
    this.d = paramList.toString();
  }
  
  private v<Transcode> b(com.bumptech.glide.load.data.e<Data> parame, h paramh, int paramInt1, int paramInt2, i.a<ResourceType> parama, List<Throwable> paramList)
  {
    int j = this.c.size();
    int i = 0;
    Object localObject1 = null;
    Object localObject3;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      localObject2 = (i)this.c.get(i);
      try
      {
        localObject2 = ((i)localObject2).a(parame, paramInt1, paramInt2, paramh, parama);
        localObject1 = localObject2;
      }
      catch (q localq)
      {
        paramList.add(localq);
      }
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        break;
      }
      i += 1;
    }
    if (localObject3 != null) {
      return localObject3;
    }
    throw new q(this.d, new ArrayList(paramList));
  }
  
  public v<Transcode> a(com.bumptech.glide.load.data.e<Data> parame, h paramh, int paramInt1, int paramInt2, i.a<ResourceType> parama)
  {
    List localList = (List)k.d(this.b.b());
    try
    {
      parame = b(parame, paramh, paramInt1, paramInt2, parama, localList);
      return parame;
    }
    finally
    {
      this.b.a(localList);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoadPath{decodePaths=");
    localStringBuilder.append(Arrays.toString(this.c.toArray()));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.t
 * JD-Core Version:    0.7.0.1
 */