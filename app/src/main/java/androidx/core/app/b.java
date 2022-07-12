package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import x0.d;

public class b
{
  public static b a(Activity paramActivity, d<View, String>... paramVarArgs)
  {
    Object localObject = null;
    if (paramVarArgs != null)
    {
      Pair[] arrayOfPair = new Pair[paramVarArgs.length];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfPair;
        if (i >= paramVarArgs.length) {
          break;
        }
        arrayOfPair[i] = Pair.create((View)paramVarArgs[i].a, (String)paramVarArgs[i].b);
        i += 1;
      }
    }
    return new a(ActivityOptions.makeSceneTransitionAnimation(paramActivity, localObject));
  }
  
  public Bundle b()
  {
    throw null;
  }
  
  private static class a
    extends b
  {
    private final ActivityOptions a;
    
    a(ActivityOptions paramActivityOptions)
    {
      this.a = paramActivityOptions;
    }
    
    public Bundle b()
    {
      return this.a.toBundle();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.app.b
 * JD-Core Version:    0.7.0.1
 */