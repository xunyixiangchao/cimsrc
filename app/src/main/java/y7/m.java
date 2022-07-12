package y7;

import b8.c;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import v7.f;
import v7.v;

final class m<T>
  extends v<T>
{
  private final f a;
  private final v<T> b;
  private final Type c;
  
  m(f paramf, v<T> paramv, Type paramType)
  {
    this.a = paramf;
    this.b = paramv;
    this.c = paramType;
  }
  
  private Type e(Type paramType, Object paramObject)
  {
    Object localObject = paramType;
    if (paramObject != null) {
      if ((paramType != Object.class) && (!(paramType instanceof TypeVariable)))
      {
        localObject = paramType;
        if (!(paramType instanceof Class)) {}
      }
      else
      {
        localObject = paramObject.getClass();
      }
    }
    return localObject;
  }
  
  public T b(b8.a parama)
  {
    return this.b.b(parama);
  }
  
  public void d(c paramc, T paramT)
  {
    Object localObject1 = this.b;
    Object localObject2 = e(this.c, paramT);
    if (localObject2 != this.c)
    {
      localObject1 = this.a.k(com.google.gson.reflect.a.get((Type)localObject2));
      if ((localObject1 instanceof i.b))
      {
        localObject2 = this.b;
        if (!(localObject2 instanceof i.b)) {
          localObject1 = localObject2;
        }
      }
    }
    ((v)localObject1).d(paramc, paramT);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     y7.m
 * JD-Core Version:    0.7.0.1
 */