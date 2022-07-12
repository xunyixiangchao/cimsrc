package com.baidu.location.b;

import android.util.Base64;
import com.baidu.location.Jni;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class i
{
  private boolean a = false;
  private String[] b = null;
  
  private i()
  {
    try
    {
      Object localObject = Jni.getldkaiv();
      if ((localObject != null) && (((String)localObject).contains("|")))
      {
        localObject = ((String)localObject).split("\\|");
        this.b = ((String[])localObject);
        if ((localObject != null) && (localObject.length == 2))
        {
          this.a = true;
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static i a()
  {
    return a.a();
  }
  
  public String a(String paramString)
  {
    try
    {
      boolean bool = this.a;
      if (bool) {
        try
        {
          IvParameterSpec localIvParameterSpec = new IvParameterSpec(this.b[1].getBytes("UTF-8"));
          SecretKeySpec localSecretKeySpec = new SecretKeySpec(this.b[0].getBytes("UTF-8"), "AES");
          Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
          localCipher.init(1, localSecretKeySpec, localIvParameterSpec);
          paramString = Base64.encodeToString(localCipher.doFinal(paramString.getBytes()), 0);
          return paramString;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      return null;
    }
    finally {}
  }
  
  /* Error */
  public String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/baidu/location/b/i:a	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aconst_null
    //   14: areturn
    //   15: new 54	javax/crypto/spec/IvParameterSpec
    //   18: dup
    //   19: aload_0
    //   20: getfield 22	com/baidu/location/b/i:b	[Ljava/lang/String;
    //   23: iconst_1
    //   24: aaload
    //   25: ldc 56
    //   27: invokevirtual 60	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   30: invokespecial 63	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   33: astore_3
    //   34: new 65	javax/crypto/spec/SecretKeySpec
    //   37: dup
    //   38: aload_0
    //   39: getfield 22	com/baidu/location/b/i:b	[Ljava/lang/String;
    //   42: iconst_0
    //   43: aaload
    //   44: ldc 56
    //   46: invokevirtual 60	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   49: ldc 67
    //   51: invokespecial 70	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   54: astore 4
    //   56: ldc 72
    //   58: invokestatic 78	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   61: astore 5
    //   63: aload 5
    //   65: iconst_2
    //   66: aload 4
    //   68: aload_3
    //   69: invokevirtual 82	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   72: new 32	java/lang/String
    //   75: dup
    //   76: aload 5
    //   78: aload_1
    //   79: iconst_0
    //   80: invokestatic 99	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   83: invokevirtual 89	javax/crypto/Cipher:doFinal	([B)[B
    //   86: ldc 56
    //   88: invokespecial 100	java/lang/String:<init>	([BLjava/lang/String;)V
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: areturn
    //   96: astore_1
    //   97: aload_1
    //   98: invokevirtual 45	java/lang/Exception:printStackTrace	()V
    //   101: aload_0
    //   102: monitorexit
    //   103: aconst_null
    //   104: areturn
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	i
    //   0	110	1	paramString	String
    //   6	2	2	bool	boolean
    //   33	36	3	localIvParameterSpec	IvParameterSpec
    //   54	13	4	localSecretKeySpec	SecretKeySpec
    //   61	16	5	localCipher	Cipher
    // Exception table:
    //   from	to	target	type
    //   15	92	96	java/lang/Exception
    //   2	7	105	finally
    //   15	92	105	finally
    //   97	101	105	finally
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  private static class a
  {
    private static i a = new i(null);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.b.i
 * JD-Core Version:    0.7.0.1
 */