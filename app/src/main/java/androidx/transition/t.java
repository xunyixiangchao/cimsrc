package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class t
{
  public final Map<String, Object> a = new HashMap();
  public View b;
  final ArrayList<Transition> c = new ArrayList();
  
  @Deprecated
  public t() {}
  
  public t(View paramView)
  {
    this.b = paramView;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof t))
    {
      View localView = this.b;
      paramObject = (t)paramObject;
      if ((localView == paramObject.b) && (this.a.equals(paramObject.a))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode() * 31 + this.a.hashCode();
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TransitionValues@");
    ((StringBuilder)localObject1).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject1).append(":\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("    view = ");
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append("\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("    values:");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = this.a.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("    ");
      localStringBuilder.append(str);
      localStringBuilder.append(": ");
      localStringBuilder.append(this.a.get(str));
      localStringBuilder.append("\n");
      localObject1 = localStringBuilder.toString();
    }
    return localObject1;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.transition.t
 * JD-Core Version:    0.7.0.1
 */