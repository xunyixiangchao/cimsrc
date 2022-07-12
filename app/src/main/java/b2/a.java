package b2;

public enum a
{
  static
  {
    a locala1 = new a("LOCAL", 0);
    a = locala1;
    a locala2 = new a("REMOTE", 1);
    b = locala2;
    a locala3 = new a("DATA_DISK_CACHE", 2);
    c = locala3;
    a locala4 = new a("RESOURCE_DISK_CACHE", 3);
    d = locala4;
    a locala5 = new a("MEMORY_CACHE", 4);
    e = locala5;
    f = new a[] { locala1, locala2, locala3, locala4, locala5 };
  }
  
  private a() {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     b2.a
 * JD-Core Version:    0.7.0.1
 */