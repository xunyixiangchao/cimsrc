package i0;

import java.util.Arrays;
import java.util.HashMap;

public class d
{
  HashMap<Object, HashMap<String, float[]>> a = new HashMap();
  
  public float a(Object paramObject, String paramString, int paramInt)
  {
    if (!this.a.containsKey(paramObject)) {
      return (0.0F / 0.0F);
    }
    paramObject = (HashMap)this.a.get(paramObject);
    if (paramObject != null)
    {
      if (!paramObject.containsKey(paramString)) {
        return (0.0F / 0.0F);
      }
      paramObject = (float[])paramObject.get(paramString);
      if (paramObject == null) {
        return (0.0F / 0.0F);
      }
      if (paramObject.length > paramInt) {
        return paramObject[paramInt];
      }
    }
    return (0.0F / 0.0F);
  }
  
  public void b(Object paramObject, String paramString, int paramInt, float paramFloat)
  {
    Object localObject1;
    if (!this.a.containsKey(paramObject))
    {
      localObject1 = new HashMap();
      localObject2 = new float[paramInt + 1];
      localObject2[paramInt] = paramFloat;
      ((HashMap)localObject1).put(paramString, localObject2);
    }
    for (;;)
    {
      this.a.put(paramObject, localObject1);
      return;
      localObject2 = (HashMap)this.a.get(paramObject);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new HashMap();
      }
      if (((HashMap)localObject1).containsKey(paramString)) {
        break;
      }
      localObject2 = new float[paramInt + 1];
      localObject2[paramInt] = paramFloat;
      ((HashMap)localObject1).put(paramString, localObject2);
    }
    Object localObject2 = (float[])((HashMap)localObject1).get(paramString);
    paramObject = localObject2;
    if (localObject2 == null) {
      paramObject = new float[0];
    }
    localObject2 = paramObject;
    if (paramObject.length <= paramInt) {
      localObject2 = Arrays.copyOf(paramObject, paramInt + 1);
    }
    localObject2[paramInt] = paramFloat;
    ((HashMap)localObject1).put(paramString, localObject2);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i0.d
 * JD-Core Version:    0.7.0.1
 */