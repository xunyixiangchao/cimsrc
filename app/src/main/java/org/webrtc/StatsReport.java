package org.webrtc;

public class StatsReport
{
  public final String id;
  public final double timestamp;
  public final String type;
  public final Value[] values;
  
  @CalledByNative
  public StatsReport(String paramString1, String paramString2, double paramDouble, Value[] paramArrayOfValue)
  {
    this.id = paramString1;
    this.type = paramString2;
    this.timestamp = paramDouble;
    this.values = paramArrayOfValue;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", type: ");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", timestamp: ");
    localStringBuilder.append(this.timestamp);
    localStringBuilder.append(", values: ");
    int i = 0;
    for (;;)
    {
      Value[] arrayOfValue = this.values;
      if (i >= arrayOfValue.length) {
        break;
      }
      localStringBuilder.append(arrayOfValue[i].toString());
      localStringBuilder.append(", ");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static class Value
  {
    public final String name;
    public final String value;
    
    @CalledByNative("Value")
    public Value(String paramString1, String paramString2)
    {
      this.name = paramString1;
      this.value = paramString2;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.name);
      localStringBuilder.append(": ");
      localStringBuilder.append(this.value);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.StatsReport
 * JD-Core Version:    0.7.0.1
 */