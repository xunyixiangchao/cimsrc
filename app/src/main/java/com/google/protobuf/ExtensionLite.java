package com.google.protobuf;

public abstract class ExtensionLite<ContainingType extends MessageLite, Type>
{
  public abstract Type getDefaultValue();
  
  public abstract WireFormat.FieldType getLiteType();
  
  public abstract MessageLite getMessageDefaultInstance();
  
  public abstract int getNumber();
  
  boolean isLite()
  {
    return true;
  }
  
  public abstract boolean isRepeated();
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.ExtensionLite
 * JD-Core Version:    0.7.0.1
 */