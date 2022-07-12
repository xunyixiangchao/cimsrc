package r7;

public class e
  extends d
{
  float a = -1.0F;
  
  public void a(o paramo, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramo.o(0.0F, paramFloat3 * paramFloat2, 180.0F, 180.0F - paramFloat1);
    double d1 = Math.sin(Math.toRadians(paramFloat1));
    double d2 = paramFloat3;
    double d3 = paramFloat2;
    paramo.m((float)(d1 * d2 * d3), (float)(Math.sin(Math.toRadians(90.0F - paramFloat1)) * d2 * d3));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r7.e
 * JD-Core Version:    0.7.0.1
 */