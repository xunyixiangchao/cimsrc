package com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

public class LazyField
  extends LazyFieldLite
{
  private final MessageLite defaultInstance;
  
  public LazyField(MessageLite paramMessageLite, ExtensionRegistryLite paramExtensionRegistryLite, ByteString paramByteString)
  {
    super(paramExtensionRegistryLite, paramByteString);
    this.defaultInstance = paramMessageLite;
  }
  
  public boolean containsDefaultInstance()
  {
    return (super.containsDefaultInstance()) || (this.value == this.defaultInstance);
  }
  
  public boolean equals(Object paramObject)
  {
    return getValue().equals(paramObject);
  }
  
  public MessageLite getValue()
  {
    return getValue(this.defaultInstance);
  }
  
  public int hashCode()
  {
    return getValue().hashCode();
  }
  
  public String toString()
  {
    return getValue().toString();
  }
  
  static class LazyEntry<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, LazyField> entry;
    
    private LazyEntry(Map.Entry<K, LazyField> paramEntry)
    {
      this.entry = paramEntry;
    }
    
    public LazyField getField()
    {
      return (LazyField)this.entry.getValue();
    }
    
    public K getKey()
    {
      return this.entry.getKey();
    }
    
    public Object getValue()
    {
      LazyField localLazyField = (LazyField)this.entry.getValue();
      if (localLazyField == null) {
        return null;
      }
      return localLazyField.getValue();
    }
    
    public Object setValue(Object paramObject)
    {
      if ((paramObject instanceof MessageLite)) {
        return ((LazyField)this.entry.getValue()).setValue((MessageLite)paramObject);
      }
      throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
  }
  
  static class LazyIterator<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> iterator;
    
    public LazyIterator(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.iterator = paramIterator;
    }
    
    public boolean hasNext()
    {
      return this.iterator.hasNext();
    }
    
    public Map.Entry<K, Object> next()
    {
      Map.Entry localEntry = (Map.Entry)this.iterator.next();
      if ((localEntry.getValue() instanceof LazyField)) {
        return new LazyField.LazyEntry(localEntry, null);
      }
      return localEntry;
    }
    
    public void remove()
    {
      this.iterator.remove();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.LazyField
 * JD-Core Version:    0.7.0.1
 */