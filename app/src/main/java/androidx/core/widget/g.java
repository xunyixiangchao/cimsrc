package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import u0.a;

public final class g
{
  public static EdgeEffect a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (a.c()) {
      return a.a(paramContext, paramAttributeSet);
    }
    return new EdgeEffect(paramContext);
  }
  
  public static float b(EdgeEffect paramEdgeEffect)
  {
    if (a.c()) {
      return a.b(paramEdgeEffect);
    }
    return 0.0F;
  }
  
  public static void c(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    paramEdgeEffect.onPull(paramFloat1, paramFloat2);
  }
  
  public static float d(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
  {
    if (a.c()) {
      return a.c(paramEdgeEffect, paramFloat1, paramFloat2);
    }
    c(paramEdgeEffect, paramFloat1, paramFloat2);
    return paramFloat1;
  }
  
  private static class a
  {
    public static EdgeEffect a(Context paramContext, AttributeSet paramAttributeSet)
    {
      try
      {
        paramAttributeSet = new EdgeEffect(paramContext, paramAttributeSet);
        return paramAttributeSet;
      }
      finally
      {
        label12:
        break label12;
      }
      return new EdgeEffect(paramContext);
    }
    
    public static float b(EdgeEffect paramEdgeEffect)
    {
      try
      {
        float f = paramEdgeEffect.getDistance();
        return f;
      }
      finally
      {
        label7:
        break label7;
      }
      return 0.0F;
    }
    
    public static float c(EdgeEffect paramEdgeEffect, float paramFloat1, float paramFloat2)
    {
      try
      {
        float f = paramEdgeEffect.onPullDistance(paramFloat1, paramFloat2);
        return f;
      }
      finally
      {
        label9:
        break label9;
      }
      paramEdgeEffect.onPull(paramFloat1, paramFloat2);
      return 0.0F;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.core.widget.g
 * JD-Core Version:    0.7.0.1
 */