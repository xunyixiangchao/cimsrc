package d2;

import android.util.Log;
import b2.h;
import b2.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import x2.k;

public class i<DataType, ResourceType, Transcode>
{
  private final Class<DataType> a;
  private final List<? extends j<DataType, ResourceType>> b;
  private final p2.e<ResourceType, Transcode> c;
  private final x0.e<List<Throwable>> d;
  private final String e;
  
  public i(Class<DataType> paramClass, Class<ResourceType> paramClass1, Class<Transcode> paramClass2, List<? extends j<DataType, ResourceType>> paramList, p2.e<ResourceType, Transcode> parame, x0.e<List<Throwable>> parame1)
  {
    this.a = paramClass;
    this.b = paramList;
    this.c = parame;
    this.d = parame1;
    paramList = new StringBuilder();
    paramList.append("Failed DecodePath{");
    paramList.append(paramClass.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass1.getSimpleName());
    paramList.append("->");
    paramList.append(paramClass2.getSimpleName());
    paramList.append("}");
    this.e = paramList.toString();
  }
  
  private v<ResourceType> b(com.bumptech.glide.load.data.e<DataType> parame, int paramInt1, int paramInt2, h paramh)
  {
    List localList = (List)k.d(this.d.b());
    try
    {
      parame = c(parame, paramInt1, paramInt2, paramh, localList);
      return parame;
    }
    finally
    {
      this.d.a(localList);
    }
  }
  
  private v<ResourceType> c(com.bumptech.glide.load.data.e<DataType> parame, int paramInt1, int paramInt2, h paramh, List<Throwable> paramList)
  {
    int j = this.b.size();
    Object localObject1 = null;
    int i = 0;
    Object localObject3;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      j localj = (j)this.b.get(i);
      localObject2 = localObject1;
      try
      {
        if (!localj.b(parame.a(), paramh)) {
          break label161;
        }
        localObject2 = localj.a(parame.a(), paramInt1, paramInt2, paramh);
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}catch (RuntimeException localRuntimeException) {}catch (IOException localIOException) {}
      if (Log.isLoggable("DecodePath", 2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to decode data for ");
        localStringBuilder.append(localj);
        Log.v("DecodePath", localStringBuilder.toString(), localIOException);
      }
      paramList.add(localIOException);
      localObject3 = localObject1;
      label161:
      if (localObject3 != null) {
        break;
      }
      i += 1;
      localObject1 = localObject3;
    }
    if (localObject3 != null) {
      return localObject3;
    }
    throw new q(this.e, new ArrayList(paramList));
  }
  
  public v<Transcode> a(com.bumptech.glide.load.data.e<DataType> parame, int paramInt1, int paramInt2, h paramh, a<ResourceType> parama)
  {
    parame = parama.a(b(parame, paramInt1, paramInt2, paramh));
    return this.c.a(parame, paramh);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DecodePath{ dataClass=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", decoders=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", transcoder=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  static abstract interface a<ResourceType>
  {
    public abstract v<ResourceType> a(v<ResourceType> paramv);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.i
 * JD-Core Version:    0.7.0.1
 */