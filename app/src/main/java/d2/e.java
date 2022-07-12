package d2;

import b2.d;
import b2.h;
import f2.a.b;
import java.io.File;

class e<DataType>
  implements a.b
{
  private final d<DataType> a;
  private final DataType b;
  private final h c;
  
  e(d<DataType> paramd, DataType paramDataType, h paramh)
  {
    this.a = paramd;
    this.b = paramDataType;
    this.c = paramh;
  }
  
  public boolean a(File paramFile)
  {
    return this.a.a(this.b, paramFile, this.c);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d2.e
 * JD-Core Version:    0.7.0.1
 */