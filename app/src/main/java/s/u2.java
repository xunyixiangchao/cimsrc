package s;

import android.content.Context;

public abstract interface u2
{
  public static final u2 a = new a();
  
  public abstract s0 a(b paramb, int paramInt);
  
  class a
    implements u2
  {
    public s0 a(u2.b paramb, int paramInt)
    {
      return null;
    }
  }
  
  public static enum b
  {
    static
    {
      b localb1 = new b("IMAGE_CAPTURE", 0);
      a = localb1;
      b localb2 = new b("PREVIEW", 1);
      b = localb2;
      b localb3 = new b("IMAGE_ANALYSIS", 2);
      c = localb3;
      b localb4 = new b("VIDEO_CAPTURE", 3);
      d = localb4;
      e = new b[] { localb1, localb2, localb3, localb4 };
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract u2 a(Context paramContext);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     s.u2
 * JD-Core Version:    0.7.0.1
 */