package r7;

public final class g
  extends f
{
  private final float a;
  
  public g(float paramFloat)
  {
    this.a = (paramFloat - 0.001F);
  }
  
  boolean a()
  {
    return true;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, o paramo)
  {
    paramFloat1 = (float)(this.a * Math.sqrt(2.0D) / 2.0D);
    paramFloat3 = (float)Math.sqrt(Math.pow(this.a, 2.0D) - Math.pow(paramFloat1, 2.0D));
    paramo.n(paramFloat2 - paramFloat1, (float)-(this.a * Math.sqrt(2.0D) - this.a) + paramFloat3);
    paramo.m(paramFloat2, (float)-(this.a * Math.sqrt(2.0D) - this.a));
    paramo.m(paramFloat2 + paramFloat1, (float)-(this.a * Math.sqrt(2.0D) - this.a) + paramFloat3);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     r7.g
 * JD-Core Version:    0.7.0.1
 */