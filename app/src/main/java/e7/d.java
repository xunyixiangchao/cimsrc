package e7;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R.id;

public class d
  extends Property<ViewGroup, Float>
{
  public static final Property<ViewGroup, Float> a = new d("childrenAlpha");
  
  private d(String paramString)
  {
    super(Float.class, paramString);
  }
  
  public Float a(ViewGroup paramViewGroup)
  {
    paramViewGroup = (Float)paramViewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
    if (paramViewGroup != null) {
      return paramViewGroup;
    }
    return Float.valueOf(1.0F);
  }
  
  public void b(ViewGroup paramViewGroup, Float paramFloat)
  {
    float f = paramFloat.floatValue();
    paramViewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(f));
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramViewGroup.getChildAt(i).setAlpha(f);
      i += 1;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     e7.d
 * JD-Core Version:    0.7.0.1
 */