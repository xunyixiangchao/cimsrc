package androidx.camera.core;

final class l2
  extends j0
{
  private boolean c = false;
  
  l2(e1 parame1)
  {
    super(parame1);
  }
  
  public void close()
  {
    try
    {
      if (!this.c)
      {
        this.c = true;
        super.close();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.core.l2
 * JD-Core Version:    0.7.0.1
 */