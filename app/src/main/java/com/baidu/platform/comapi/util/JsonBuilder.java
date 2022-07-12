package com.baidu.platform.comapi.util;

import org.json.JSONObject;

public class JsonBuilder
{
  private StringBuilder a = new StringBuilder();
  private boolean b = false;
  
  private void a()
  {
    if (this.b) {
      this.a.append(",");
    }
  }
  
  private void b()
  {
    this.b = true;
  }
  
  private void c()
  {
    this.b = false;
  }
  
  public JsonBuilder arrayValue()
  {
    a();
    this.a.append("[");
    c();
    return this;
  }
  
  public JsonBuilder endArrayValue()
  {
    this.a.append("]");
    b();
    return this;
  }
  
  public JsonBuilder endObject()
  {
    this.a.append("}");
    b();
    return this;
  }
  
  public String getJson()
  {
    return this.a.toString();
  }
  
  public JsonBuilder key(String paramString)
  {
    a();
    this.a.append(JSONObject.quote(paramString));
    this.a.append(":");
    c();
    return this;
  }
  
  public JsonBuilder object()
  {
    a();
    this.a.append("{");
    c();
    return this;
  }
  
  public JsonBuilder objectValue(String paramString)
  {
    a();
    this.a.append(paramString);
    b();
    return this;
  }
  
  public JsonBuilder putObjectValue(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      key(paramString1).objectValue(paramString2);
    }
    return this;
  }
  
  public JsonBuilder putStringValue(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      key(paramString1).value(paramString2);
    }
    return this;
  }
  
  public void reset()
  {
    this.a.setLength(0);
    this.b = false;
  }
  
  public String toString()
  {
    return getJson();
  }
  
  public JsonBuilder value(double paramDouble)
  {
    a();
    this.a.append(String.format("%f", new Object[] { Double.valueOf(paramDouble) }));
    b();
    return this;
  }
  
  public JsonBuilder value(int paramInt)
  {
    a();
    this.a.append(paramInt);
    b();
    return this;
  }
  
  public JsonBuilder value(long paramLong)
  {
    a();
    this.a.append(paramLong);
    b();
    return this;
  }
  
  public JsonBuilder value(Object paramObject)
  {
    if ((paramObject instanceof Number))
    {
      Number localNumber = (Number)paramObject;
      if ((paramObject instanceof Byte)) {
        return value(localNumber.byteValue());
      }
      if ((paramObject instanceof Short)) {
        return value(localNumber.shortValue());
      }
      if ((paramObject instanceof Integer)) {
        return value(localNumber.intValue());
      }
      if ((paramObject instanceof Long)) {
        return value(localNumber.longValue());
      }
      if ((paramObject instanceof Float)) {
        return value(localNumber.floatValue());
      }
      if ((paramObject instanceof Double)) {
        return value(localNumber.doubleValue());
      }
    }
    return value(paramObject.toString());
  }
  
  public JsonBuilder value(String paramString)
  {
    a();
    this.a.append(JSONObject.quote(paramString));
    b();
    return this;
  }
  
  public JsonBuilder value(boolean paramBoolean)
  {
    a();
    this.a.append(paramBoolean);
    b();
    return this;
  }
  
  public JsonBuilder valueDirect(String paramString)
  {
    a();
    this.a.append(paramString);
    b();
    return this;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.util.JsonBuilder
 * JD-Core Version:    0.7.0.1
 */