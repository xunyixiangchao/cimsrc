package com.google.protobuf;

abstract interface MutabilityOracle
{
  public static final MutabilityOracle IMMUTABLE = new MutabilityOracle()
  {
    public void ensureMutable()
    {
      throw new UnsupportedOperationException();
    }
  };
  
  public abstract void ensureMutable();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.MutabilityOracle
 * JD-Core Version:    0.7.0.1
 */