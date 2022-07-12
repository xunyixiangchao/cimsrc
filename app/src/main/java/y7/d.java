package y7;

import com.google.gson.reflect.a;
import v7.f;
import v7.k;
import v7.s;
import v7.v;
import v7.w;
import w7.b;
import x7.c;
import x7.i;

public final class d
  implements w
{
  private final c a;
  
  public d(c paramc)
  {
    this.a = paramc;
  }
  
  public <T> v<T> a(f paramf, a<T> parama)
  {
    b localb = (b)parama.getRawType().getAnnotation(b.class);
    if (localb == null) {
      return null;
    }
    return b(this.a, paramf, parama, localb);
  }
  
  v<?> b(c paramc, f paramf, a<?> parama, b paramb)
  {
    Object localObject = paramc.a(a.get(paramb.value())).a();
    if ((localObject instanceof v))
    {
      paramc = (v)localObject;
    }
    else if ((localObject instanceof w))
    {
      paramc = ((w)localObject).a(paramf, parama);
    }
    else
    {
      boolean bool = localObject instanceof s;
      if ((!bool) && (!(localObject instanceof k)))
      {
        paramc = new StringBuilder();
        paramc.append("Invalid attempt to bind an instance of ");
        paramc.append(localObject.getClass().getName());
        paramc.append(" as a @JsonAdapter for ");
        paramc.append(parama.toString());
        paramc.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        throw new IllegalArgumentException(paramc.toString());
      }
      k localk = null;
      if (bool) {
        paramc = (s)localObject;
      } else {
        paramc = null;
      }
      if ((localObject instanceof k)) {
        localk = (k)localObject;
      }
      paramc = new l(paramc, localk, paramf, parama, null);
    }
    paramf = paramc;
    if (paramc != null)
    {
      paramf = paramc;
      if (paramb.nullSafe()) {
        paramf = paramc.a();
      }
    }
    return paramf;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.d
 * JD-Core Version:    0.7.0.1
 */