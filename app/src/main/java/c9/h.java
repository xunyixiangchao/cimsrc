package c9;

import a9.f;

class h
{
  public static final void a(boolean paramBoolean, Number paramNumber)
  {
    f.f(paramNumber, "step");
    if (paramBoolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Step must be positive, was: ");
    localStringBuilder.append(paramNumber);
    localStringBuilder.append('.');
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     c9.h
 * JD-Core Version:    0.7.0.1
 */