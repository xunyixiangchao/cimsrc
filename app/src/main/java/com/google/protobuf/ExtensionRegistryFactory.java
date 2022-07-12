package com.google.protobuf;

import java.lang.reflect.Method;

final class ExtensionRegistryFactory
{
  static final Class<?> EXTENSION_REGISTRY_CLASS = ;
  static final String FULL_REGISTRY_CLASS_NAME = "com.google.protobuf.ExtensionRegistry";
  
  public static ExtensionRegistryLite create()
  {
    if (EXTENSION_REGISTRY_CLASS != null) {}
    try
    {
      ExtensionRegistryLite localExtensionRegistryLite = invokeSubclassFactory("newInstance");
      return localExtensionRegistryLite;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    return new ExtensionRegistryLite();
  }
  
  public static ExtensionRegistryLite createEmpty()
  {
    if (EXTENSION_REGISTRY_CLASS != null) {}
    try
    {
      ExtensionRegistryLite localExtensionRegistryLite = invokeSubclassFactory("getEmptyRegistry");
      return localExtensionRegistryLite;
    }
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    return ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
  }
  
  private static final ExtensionRegistryLite invokeSubclassFactory(String paramString)
  {
    return (ExtensionRegistryLite)EXTENSION_REGISTRY_CLASS.getMethod(paramString, new Class[0]).invoke(null, new Object[0]);
  }
  
  static boolean isFullRegistry(ExtensionRegistryLite paramExtensionRegistryLite)
  {
    Class localClass = EXTENSION_REGISTRY_CLASS;
    return (localClass != null) && (localClass.isAssignableFrom(paramExtensionRegistryLite.getClass()));
  }
  
  static Class<?> reflectExtensionRegistry()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.ExtensionRegistry");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label8:
      break label8;
    }
    return null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.ExtensionRegistryFactory
 * JD-Core Version:    0.7.0.1
 */