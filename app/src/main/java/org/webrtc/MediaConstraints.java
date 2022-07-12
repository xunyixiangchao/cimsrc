package org.webrtc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MediaConstraints
{
  public final List<KeyValuePair> mandatory = new ArrayList();
  public final List<KeyValuePair> optional = new ArrayList();
  
  private static String stringifyKeyValuePairList(List<KeyValuePair> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("[");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      KeyValuePair localKeyValuePair = (KeyValuePair)paramList.next();
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(localKeyValuePair.toString());
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  @CalledByNative
  List<KeyValuePair> getMandatory()
  {
    return this.mandatory;
  }
  
  @CalledByNative
  List<KeyValuePair> getOptional()
  {
    return this.optional;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mandatory: ");
    localStringBuilder.append(stringifyKeyValuePairList(this.mandatory));
    localStringBuilder.append(", optional: ");
    localStringBuilder.append(stringifyKeyValuePairList(this.optional));
    return localStringBuilder.toString();
  }
  
  public static class KeyValuePair
  {
    private final String key;
    private final String value;
    
    public KeyValuePair(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.value = paramString2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject != null)
      {
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (KeyValuePair)paramObject;
        return (this.key.equals(paramObject.key)) && (this.value.equals(paramObject.value));
      }
      return false;
    }
    
    @CalledByNative("KeyValuePair")
    public String getKey()
    {
      return this.key;
    }
    
    @CalledByNative("KeyValuePair")
    public String getValue()
    {
      return this.value;
    }
    
    public int hashCode()
    {
      return this.key.hashCode() + this.value.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.key);
      localStringBuilder.append(": ");
      localStringBuilder.append(this.value);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.MediaConstraints
 * JD-Core Version:    0.7.0.1
 */