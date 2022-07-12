package com.baidu.location;

public class Jni
{
  private static int a = 0;
  private static int b = 1;
  private static int c = 2;
  private static int d = 11;
  private static int e = 12;
  private static int f = 13;
  private static int g = 14;
  private static int h = 15;
  private static int i = 1024;
  private static boolean j = false;
  
  static
  {
    try
    {
      System.loadLibrary("locSDK8b");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      j = true;
    }
  }
  
  private static native String a(byte[] paramArrayOfByte, int paramInt);
  
  private static native String b(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);
  
  private static native String c(byte[] paramArrayOfByte, int paramInt);
  
  public static double[] coorEncrypt(double paramDouble1, double paramDouble2, String paramString)
  {
    double[] arrayOfDouble = new double[2];
    double[] tmp7_5 = arrayOfDouble;
    tmp7_5[0] = 0.0D;
    double[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0.0D;
    tmp11_7;
    if (j) {
      return tmp11_7;
    }
    int k = -1;
    if (paramString.equals("bd09")) {
      k = a;
    } else if (paramString.equals("bd09ll")) {
      k = b;
    } else if (paramString.equals("gcj02")) {
      k = c;
    } else if (paramString.equals("gps2gcj")) {
      k = d;
    } else if (paramString.equals("bd092gcj")) {
      k = e;
    } else if (paramString.equals("bd09ll2gcj")) {
      k = f;
    } else if (paramString.equals("wgs842mc")) {
      k = h;
    }
    if (paramString.equals("gcj2wgs")) {
      k = 16;
    }
    try
    {
      paramString = b(paramDouble1, paramDouble2, k, 132456).split(":");
      tmp11_7[0] = Double.parseDouble(paramString[0]);
      tmp11_7[1] = Double.parseDouble(paramString[1]);
      return tmp11_7;
    }
    finally
    {
      label206:
      break label206;
    }
    tmp11_7[0] = 0.0D;
    tmp11_7[1] = 0.0D;
    return tmp11_7;
  }
  
  private static native String ee(String paramString, int paramInt);
  
  public static String en1(String paramString)
  {
    if (j) {
      return "err!";
    }
    if (paramString == null) {
      return "null";
    }
    paramString = paramString.getBytes();
    byte[] arrayOfByte = new byte[i];
    int m = paramString.length;
    int k = m;
    if (m > 740) {
      k = 740;
    }
    m = 0;
    int i1;
    for (int n = 0; m < k; n = i1)
    {
      i1 = n;
      if (paramString[m] != 0)
      {
        arrayOfByte[n] = paramString[m];
        i1 = n + 1;
      }
      m += 1;
    }
    try
    {
      paramString = a(arrayOfByte, 132456);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return "err!";
  }
  
  public static String encode(String paramString)
  {
    if (j) {
      return "err!";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(en1(paramString));
    localStringBuilder.append("|tp=3");
    return localStringBuilder.toString();
  }
  
  public static String encode2(String paramString)
  {
    if (j) {
      return "err!";
    }
    if (paramString == null) {
      return "null";
    }
    paramString = paramString.getBytes();
    try
    {
      paramString = c(paramString, 132456);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
    }
    return "err!";
  }
  
  public static Long encode3(String paramString)
  {
    if (j) {
      return null;
    }
    try
    {
      paramString = new String(paramString.getBytes(), "UTF-8");
    }
    catch (Exception paramString)
    {
      label25:
      break label25;
    }
    paramString = "";
    try
    {
      long l = murmur(paramString);
      return Long.valueOf(l);
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
      return null;
    }
  }
  
  private static native String encodeNotLimit(String paramString, int paramInt);
  
  public static String encodeOfflineLocationUpdateRequest(String paramString)
  {
    boolean bool = j;
    Object localObject = "err!";
    if (bool) {
      return "err!";
    }
    try
    {
      paramString = new String(paramString.getBytes(), "UTF-8");
    }
    catch (Exception paramString)
    {
      label31:
      break label31;
    }
    paramString = "";
    try
    {
      paramString = encodeNotLimit(paramString, 132456);
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
      paramString = (String)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("|tp=3");
    return ((StringBuilder)localObject).toString();
  }
  
  public static String encodeTp4(String paramString)
  {
    boolean bool = j;
    Object localObject = "err!";
    if (bool) {
      return "err!";
    }
    try
    {
      paramString = new String(paramString.getBytes(), "UTF-8");
    }
    catch (Exception paramString)
    {
      label31:
      break label31;
    }
    paramString = "";
    try
    {
      paramString = ee(paramString, 132456);
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
      paramString = (String)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("|tp=4");
    return ((StringBuilder)localObject).toString();
  }
  
  public static String encodeTp4NoTag(String paramString)
  {
    if (j) {
      return "err!";
    }
    try
    {
      paramString = new String(paramString.getBytes(), "UTF-8");
    }
    catch (Exception paramString)
    {
      label26:
      break label26;
    }
    paramString = "";
    try
    {
      paramString = ee(paramString, 132456);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramString.printStackTrace();
      return "err!";
    }
  }
  
  public static double getGpsSwiftRadius(float paramFloat, double paramDouble1, double paramDouble2)
  {
    if (j) {
      return 0.0D;
    }
    try
    {
      paramDouble1 = gsr(paramFloat, paramDouble1, paramDouble2);
      return paramDouble1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
    return 0.0D;
  }
  
  public static String getldkaiv()
  {
    if (j) {
      return null;
    }
    try
    {
      String str = ldkaiv();
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return null;
  }
  
  private static native double gsr(float paramFloat, double paramDouble1, double paramDouble2);
  
  private static native String ldkaiv();
  
  private static native long murmur(String paramString);
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.Jni
 * JD-Core Version:    0.7.0.1
 */