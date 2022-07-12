package org.webrtc;

import java.util.Locale;

public class SessionDescription
{
  public final String description;
  public final Type type;
  
  @CalledByNative
  public SessionDescription(Type paramType, String paramString)
  {
    this.type = paramType;
    this.description = paramString;
  }
  
  @CalledByNative
  String getDescription()
  {
    return this.description;
  }
  
  @CalledByNative
  String getTypeInCanonicalForm()
  {
    return this.type.canonicalForm();
  }
  
  public static enum Type
  {
    static
    {
      Type localType1 = new Type("OFFER", 0);
      OFFER = localType1;
      Type localType2 = new Type("PRANSWER", 1);
      PRANSWER = localType2;
      Type localType3 = new Type("ANSWER", 2);
      ANSWER = localType3;
      $VALUES = new Type[] { localType1, localType2, localType3 };
    }
    
    private Type() {}
    
    @CalledByNative("Type")
    public static Type fromCanonicalForm(String paramString)
    {
      return (Type)Enum.valueOf(Type.class, paramString.toUpperCase(Locale.US));
    }
    
    public String canonicalForm()
    {
      return name().toLowerCase(Locale.US);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.SessionDescription
 * JD-Core Version:    0.7.0.1
 */