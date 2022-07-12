package org.webrtc;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GlUtil
{
  public static void checkNoGLES2Error(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      if (i == 1285)
      {
        paramString = new GlOutOfMemoryException(paramString);
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(": GLES20 error: ");
        localStringBuilder.append(i);
        paramString = new RuntimeException(localStringBuilder.toString());
      }
      throw paramString;
    }
  }
  
  public static FloatBuffer createFloatBuffer(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static int generateTexture(int paramInt)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindTexture(paramInt, i);
    GLES20.glTexParameterf(paramInt, 10241, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    GLES20.glTexParameterf(paramInt, 10242, 33071.0F);
    GLES20.glTexParameterf(paramInt, 10243, 33071.0F);
    checkNoGLES2Error("generateTexture");
    return i;
  }
  
  public static class GlOutOfMemoryException
    extends RuntimeException
  {
    public GlOutOfMemoryException(String paramString)
    {
      super();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.GlUtil
 * JD-Core Version:    0.7.0.1
 */