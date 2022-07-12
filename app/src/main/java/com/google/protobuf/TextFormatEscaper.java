package com.google.protobuf;

final class TextFormatEscaper
{
  static String escapeBytes(ByteString paramByteString)
  {
    escapeBytes(new ByteSequence()
    {
      public byte byteAt(int paramAnonymousInt)
      {
        return this.val$input.byteAt(paramAnonymousInt);
      }
      
      public int size()
      {
        return this.val$input.size();
      }
    });
  }
  
  static String escapeBytes(ByteSequence paramByteSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramByteSequence.size());
    int i = 0;
    while (i < paramByteSequence.size())
    {
      int j = paramByteSequence.byteAt(i);
      String str;
      if (j != 34) {
        if (j != 39) {
          if (j != 92) {
            switch (j)
            {
            default: 
              if ((j < 32) || (j > 126))
              {
                localStringBuilder.append('\\');
                localStringBuilder.append((char)((j >>> 6 & 0x3) + 48));
                localStringBuilder.append((char)((j >>> 3 & 0x7) + 48));
                j = (j & 0x7) + 48;
              }
              localStringBuilder.append((char)j);
              break;
            case 13: 
              str = "\\r";
              break;
            case 12: 
              str = "\\f";
              break;
            case 11: 
              str = "\\v";
              break;
            case 10: 
              str = "\\n";
              break;
            case 9: 
              str = "\\t";
              break;
            case 8: 
              str = "\\b";
              break;
            case 7: 
              str = "\\a";
            }
          }
        }
      }
      for (;;)
      {
        localStringBuilder.append(str);
        break;
        str = "\\\\";
        continue;
        str = "\\'";
        continue;
        str = "\\\"";
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  static String escapeBytes(byte[] paramArrayOfByte)
  {
    escapeBytes(new ByteSequence()
    {
      public byte byteAt(int paramAnonymousInt)
      {
        return this.val$input[paramAnonymousInt];
      }
      
      public int size()
      {
        return this.val$input.length;
      }
    });
  }
  
  static String escapeDoubleQuotesAndBackslashes(String paramString)
  {
    return paramString.replace("\\", "\\\\").replace("\"", "\\\"");
  }
  
  static String escapeText(String paramString)
  {
    return escapeBytes(ByteString.copyFromUtf8(paramString));
  }
  
  private static abstract interface ByteSequence
  {
    public abstract byte byteAt(int paramInt);
    
    public abstract int size();
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.TextFormatEscaper
 * JD-Core Version:    0.7.0.1
 */