package t1;

import android.view.View;
import androidx.transition.t;
import java.util.Map;

public abstract class d
  extends c
{
  private static final String[] a = { "android:visibilityPropagation:visibility", "android:visibilityPropagation:center" };
  
  private static int d(t paramt, int paramInt)
  {
    if (paramt == null) {
      return -1;
    }
    paramt = (int[])paramt.a.get("android:visibilityPropagation:center");
    if (paramt == null) {
      return -1;
    }
    return paramt[paramInt];
  }
  
  public void a(t paramt)
  {
    View localView = paramt.b;
    Integer localInteger = (Integer)paramt.a.get("android:visibility:visibility");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(localView.getVisibility());
    }
    paramt.a.put("android:visibilityPropagation:visibility", localObject);
    localObject = new int[2];
    localView.getLocationOnScreen((int[])localObject);
    localObject[0] += Math.round(localView.getTranslationX());
    localObject[0] += localView.getWidth() / 2;
    localObject[1] += Math.round(localView.getTranslationY());
    localObject[1] += localView.getHeight() / 2;
    paramt.a.put("android:visibilityPropagation:center", localObject);
  }
  
  public String[] b()
  {
    return a;
  }
  
  public int e(t paramt)
  {
    if (paramt == null) {
      return 8;
    }
    paramt = (Integer)paramt.a.get("android:visibilityPropagation:visibility");
    if (paramt == null) {
      return 8;
    }
    return paramt.intValue();
  }
  
  public int f(t paramt)
  {
    return d(paramt, 0);
  }
  
  public int g(t paramt)
  {
    return d(paramt, 1);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     t1.d
 * JD-Core Version:    0.7.0.1
 */