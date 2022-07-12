package q9;

public final class e
  implements n.c
{
  private final n.a a;
  private final boolean b;
  
  public e(Throwable paramThrowable)
  {
    this.a = new n.a(this, null, paramThrowable, 2, null);
  }
  
  public n.a b()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.b;
  }
  
  public Void e()
  {
    throw new IllegalStateException("unexpected cancel".toString());
  }
  
  public n.a f()
  {
    return this.a;
  }
  
  public final n.a g()
  {
    return this.a;
  }
  
  public Void h()
  {
    throw new IllegalStateException("unexpected call".toString());
  }
  
  public Void i()
  {
    throw new IllegalStateException("unexpected retry".toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.e
 * JD-Core Version:    0.7.0.1
 */