package androidx.camera.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import s.m0;
import s.q0;
import s.q0.a;

final class b0
{
  static m0 a(List<q0> paramList)
  {
    return new a(paramList);
  }
  
  static m0 b(q0... paramVarArgs)
  {
    return new a(Arrays.asList(paramVarArgs));
  }
  
  static m0 c()
  {
    return b(new q0[] { new q0.a() });
  }
  
  static final class a
    implements m0
  {
    final List<q0> a;
    
    a(List<q0> paramList)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.a = Collections.unmodifiableList(new ArrayList(paramList));
        return;
      }
      throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
    }
    
    public List<q0> c()
    {
      return this.a;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.b0
 * JD-Core Version:    0.7.0.1
 */