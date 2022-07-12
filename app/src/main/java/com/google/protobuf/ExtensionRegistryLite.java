package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtensionRegistryLite
{
  static final ExtensionRegistryLite EMPTY_REGISTRY_LITE = new ExtensionRegistryLite(true);
  static final String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
  private static volatile boolean eagerlyParseMessageSets = false;
  private static final Class<?> extensionClass = ;
  private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;
  
  ExtensionRegistryLite()
  {
    this.extensionsByNumber = new HashMap();
  }
  
  ExtensionRegistryLite(ExtensionRegistryLite paramExtensionRegistryLite)
  {
    if (paramExtensionRegistryLite == EMPTY_REGISTRY_LITE) {
      paramExtensionRegistryLite = Collections.emptyMap();
    } else {
      paramExtensionRegistryLite = Collections.unmodifiableMap(paramExtensionRegistryLite.extensionsByNumber);
    }
    this.extensionsByNumber = paramExtensionRegistryLite;
  }
  
  ExtensionRegistryLite(boolean paramBoolean)
  {
    this.extensionsByNumber = Collections.emptyMap();
  }
  
  public static ExtensionRegistryLite getEmptyRegistry()
  {
    return ExtensionRegistryFactory.createEmpty();
  }
  
  public static boolean isEagerlyParseMessageSets()
  {
    return eagerlyParseMessageSets;
  }
  
  public static ExtensionRegistryLite newInstance()
  {
    return ExtensionRegistryFactory.create();
  }
  
  static Class<?> resolveExtensionClass()
  {
    try
    {
      Class localClass = Class.forName("com.google.protobuf.Extension");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public static void setEagerlyParseMessageSets(boolean paramBoolean)
  {
    eagerlyParseMessageSets = paramBoolean;
  }
  
  public final void add(ExtensionLite<?, ?> paramExtensionLite)
  {
    if (GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(paramExtensionLite.getClass())) {
      add((GeneratedMessageLite.GeneratedExtension)paramExtensionLite);
    }
    if (ExtensionRegistryFactory.isFullRegistry(this)) {
      try
      {
        getClass().getMethod("add", new Class[] { extensionClass }).invoke(this, new Object[] { paramExtensionLite });
        return;
      }
      catch (Exception localException)
      {
        throw new IllegalArgumentException(String.format("Could not invoke ExtensionRegistry#add for %s", new Object[] { paramExtensionLite }), localException);
      }
    }
  }
  
  public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> paramGeneratedExtension)
  {
    this.extensionsByNumber.put(new ObjectIntPair(paramGeneratedExtension.getContainingTypeDefaultInstance(), paramGeneratedExtension.getNumber()), paramGeneratedExtension);
  }
  
  public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType paramContainingType, int paramInt)
  {
    return (GeneratedMessageLite.GeneratedExtension)this.extensionsByNumber.get(new ObjectIntPair(paramContainingType, paramInt));
  }
  
  public ExtensionRegistryLite getUnmodifiable()
  {
    return new ExtensionRegistryLite(this);
  }
  
  private static final class ObjectIntPair
  {
    private final int number;
    private final Object object;
    
    ObjectIntPair(Object paramObject, int paramInt)
    {
      this.object = paramObject;
      this.number = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof ObjectIntPair;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (ObjectIntPair)paramObject;
      bool1 = bool2;
      if (this.object == paramObject.object)
      {
        bool1 = bool2;
        if (this.number == paramObject.number) {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public int hashCode()
    {
      return System.identityHashCode(this.object) * 65535 + this.number;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.ExtensionRegistryLite
 * JD-Core Version:    0.7.0.1
 */