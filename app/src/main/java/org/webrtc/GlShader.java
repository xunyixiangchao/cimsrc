package org.webrtc;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class GlShader
{
  private static final String TAG = "GlShader";
  private int program;
  
  public GlShader(String paramString1, String paramString2)
  {
    int i = compileShader(35633, paramString1);
    int j = compileShader(35632, paramString2);
    int k = GLES20.glCreateProgram();
    this.program = k;
    if (k != 0)
    {
      GLES20.glAttachShader(k, i);
      GLES20.glAttachShader(this.program, j);
      GLES20.glLinkProgram(this.program);
      paramString1 = new int[1];
      paramString1[0] = 0;
      GLES20.glGetProgramiv(this.program, 35714, paramString1, 0);
      if (paramString1[0] == 1)
      {
        GLES20.glDeleteShader(i);
        GLES20.glDeleteShader(j);
        GlUtil.checkNoGLES2Error("Creating GlShader");
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("Could not link program: ");
      paramString1.append(GLES20.glGetProgramInfoLog(this.program));
      Logging.e("GlShader", paramString1.toString());
      throw new RuntimeException(GLES20.glGetProgramInfoLog(this.program));
    }
    paramString1 = new StringBuilder();
    paramString1.append("glCreateProgram() failed. GLES20 error: ");
    paramString1.append(GLES20.glGetError());
    throw new RuntimeException(paramString1.toString());
  }
  
  private static int compileShader(int paramInt, String paramString)
  {
    paramInt = GLES20.glCreateShader(paramInt);
    if (paramInt != 0)
    {
      GLES20.glShaderSource(paramInt, paramString);
      GLES20.glCompileShader(paramInt);
      Object localObject = new int[1];
      localObject[0] = 0;
      GLES20.glGetShaderiv(paramInt, 35713, (int[])localObject, 0);
      if (localObject[0] == 1)
      {
        GlUtil.checkNoGLES2Error("compileShader");
        return paramInt;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Compile error ");
      ((StringBuilder)localObject).append(GLES20.glGetShaderInfoLog(paramInt));
      ((StringBuilder)localObject).append(" in shader:\n");
      ((StringBuilder)localObject).append(paramString);
      Logging.e("GlShader", ((StringBuilder)localObject).toString());
      throw new RuntimeException(GLES20.glGetShaderInfoLog(paramInt));
    }
    paramString = new StringBuilder();
    paramString.append("glCreateShader() failed. GLES20 error: ");
    paramString.append(GLES20.glGetError());
    throw new RuntimeException(paramString.toString());
  }
  
  public int getAttribLocation(String paramString)
  {
    int i = this.program;
    if (i != -1)
    {
      i = GLES20.glGetAttribLocation(i, paramString);
      if (i >= 0) {
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not locate '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' in program");
      throw new RuntimeException(localStringBuilder.toString());
    }
    throw new RuntimeException("The program has been released");
  }
  
  public int getUniformLocation(String paramString)
  {
    int i = this.program;
    if (i != -1)
    {
      i = GLES20.glGetUniformLocation(i, paramString);
      if (i >= 0) {
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not locate uniform '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' in program");
      throw new RuntimeException(localStringBuilder.toString());
    }
    throw new RuntimeException("The program has been released");
  }
  
  public void release()
  {
    Logging.d("GlShader", "Deleting shader.");
    int i = this.program;
    if (i != -1)
    {
      GLES20.glDeleteProgram(i);
      this.program = -1;
    }
  }
  
  public void setVertexAttribArray(String paramString, int paramInt1, int paramInt2, FloatBuffer paramFloatBuffer)
  {
    if (this.program != -1)
    {
      int i = getAttribLocation(paramString);
      GLES20.glEnableVertexAttribArray(i);
      GLES20.glVertexAttribPointer(i, paramInt1, 5126, false, paramInt2, paramFloatBuffer);
      GlUtil.checkNoGLES2Error("setVertexAttribArray");
      return;
    }
    throw new RuntimeException("The program has been released");
  }
  
  public void setVertexAttribArray(String paramString, int paramInt, FloatBuffer paramFloatBuffer)
  {
    setVertexAttribArray(paramString, paramInt, 0, paramFloatBuffer);
  }
  
  public void useProgram()
  {
    if (this.program != -1) {
      synchronized (EglBase.lock)
      {
        GLES20.glUseProgram(this.program);
        GlUtil.checkNoGLES2Error("glUseProgram");
        return;
      }
    }
    throw new RuntimeException("The program has been released");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.GlShader
 * JD-Core Version:    0.7.0.1
 */