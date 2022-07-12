package org.webrtc;

import java.io.UnsupportedEncodingException;
import java.util.Map.Entry;

class JniHelper
{
  @CalledByNative
  static Object getKey(Map.Entry paramEntry)
  {
    return paramEntry.getKey();
  }
  
  @CalledByNative
  static byte[] getStringBytes(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label9:
      break label9;
    }
    throw new RuntimeException("ISO-8859-1 is unsupported");
  }
  
  @CalledByNative
  static Object getStringClass()
  {
    return String.class;
  }
  
  @CalledByNative
  static Object getValue(Map.Entry paramEntry)
  {
    return paramEntry.getValue();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.JniHelper
 * JD-Core Version:    0.7.0.1
 */