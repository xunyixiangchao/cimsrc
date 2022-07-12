package org.webrtc;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

class GlGenericDrawer
  implements RendererCommon.GlDrawer
{
  private static final String DEFAULT_VERTEX_SHADER_STRING = "varying vec2 tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\nuniform mat4 tex_mat;\nvoid main() {\n  gl_Position = in_pos;\n  tc = (tex_mat * in_tc).xy;\n}\n";
  private static final FloatBuffer FULL_RECTANGLE_BUFFER = GlUtil.createFloatBuffer(new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F });
  private static final FloatBuffer FULL_RECTANGLE_TEXTURE_BUFFER = GlUtil.createFloatBuffer(new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F });
  private static final String INPUT_TEXTURE_COORDINATE_NAME = "in_tc";
  private static final String INPUT_VERTEX_COORDINATE_NAME = "in_pos";
  private static final String TEXTURE_MATRIX_NAME = "tex_mat";
  private GlShader currentShader;
  private ShaderType currentShaderType;
  private final String genericFragmentSource;
  private int inPosLocation;
  private int inTcLocation;
  private final ShaderCallbacks shaderCallbacks;
  private int texMatrixLocation;
  private final String vertexShader;
  
  public GlGenericDrawer(String paramString1, String paramString2, ShaderCallbacks paramShaderCallbacks)
  {
    this.vertexShader = paramString1;
    this.genericFragmentSource = paramString2;
    this.shaderCallbacks = paramShaderCallbacks;
  }
  
  public GlGenericDrawer(String paramString, ShaderCallbacks paramShaderCallbacks)
  {
    this("varying vec2 tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\nuniform mat4 tex_mat;\nvoid main() {\n  gl_Position = in_pos;\n  tc = (tex_mat * in_tc).xy;\n}\n", paramString, paramShaderCallbacks);
  }
  
  static String createFragmentShaderString(String paramString, ShaderType paramShaderType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ShaderType localShaderType = ShaderType.OES;
    if (paramShaderType == localShaderType) {
      localStringBuilder.append("#extension GL_OES_EGL_image_external : require\n");
    }
    localStringBuilder.append("precision mediump float;\n");
    localStringBuilder.append("varying vec2 tc;\n");
    if (paramShaderType == ShaderType.YUV)
    {
      localStringBuilder.append("uniform sampler2D y_tex;\n");
      localStringBuilder.append("uniform sampler2D u_tex;\n");
      localStringBuilder.append("uniform sampler2D v_tex;\n");
      localStringBuilder.append("vec4 sample(vec2 p) {\n");
      localStringBuilder.append("  float y = texture2D(y_tex, p).r * 1.16438;\n");
      localStringBuilder.append("  float u = texture2D(u_tex, p).r;\n");
      localStringBuilder.append("  float v = texture2D(v_tex, p).r;\n");
      localStringBuilder.append("  return vec4(y + 1.59603 * v - 0.874202,\n");
      localStringBuilder.append("    y - 0.391762 * u - 0.812968 * v + 0.531668,\n");
      localStringBuilder.append("    y + 2.01723 * u - 1.08563, 1);\n");
      localStringBuilder.append("}\n");
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      break;
      if (paramShaderType == localShaderType) {
        paramShaderType = "samplerExternalOES";
      } else {
        paramShaderType = "sampler2D";
      }
      localStringBuilder.append("uniform ");
      localStringBuilder.append(paramShaderType);
      localStringBuilder.append(" tex;\n");
      paramString = paramString.replace("sample(", "texture2D(tex, ");
    }
    return localStringBuilder.toString();
  }
  
  private void prepareShader(ShaderType paramShaderType, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramShaderType.equals(this.currentShaderType))
    {
      paramShaderType = this.currentShader;
    }
    else
    {
      this.currentShaderType = paramShaderType;
      GlShader localGlShader = this.currentShader;
      if (localGlShader != null) {
        localGlShader.release();
      }
      localGlShader = createShader(paramShaderType);
      this.currentShader = localGlShader;
      localGlShader.useProgram();
      if (paramShaderType == ShaderType.YUV)
      {
        GLES20.glUniform1i(localGlShader.getUniformLocation("y_tex"), 0);
        GLES20.glUniform1i(localGlShader.getUniformLocation("u_tex"), 1);
        GLES20.glUniform1i(localGlShader.getUniformLocation("v_tex"), 2);
      }
      else
      {
        GLES20.glUniform1i(localGlShader.getUniformLocation("tex"), 0);
      }
      GlUtil.checkNoGLES2Error("Create shader");
      this.shaderCallbacks.onNewShader(localGlShader);
      this.texMatrixLocation = localGlShader.getUniformLocation("tex_mat");
      this.inPosLocation = localGlShader.getAttribLocation("in_pos");
      this.inTcLocation = localGlShader.getAttribLocation("in_tc");
      paramShaderType = localGlShader;
    }
    paramShaderType.useProgram();
    GLES20.glEnableVertexAttribArray(this.inPosLocation);
    GLES20.glVertexAttribPointer(this.inPosLocation, 2, 5126, false, 0, FULL_RECTANGLE_BUFFER);
    GLES20.glEnableVertexAttribArray(this.inTcLocation);
    GLES20.glVertexAttribPointer(this.inTcLocation, 2, 5126, false, 0, FULL_RECTANGLE_TEXTURE_BUFFER);
    GLES20.glUniformMatrix4fv(this.texMatrixLocation, 1, false, paramArrayOfFloat, 0);
    this.shaderCallbacks.onPrepareShader(paramShaderType, paramArrayOfFloat, paramInt1, paramInt2, paramInt3, paramInt4);
    GlUtil.checkNoGLES2Error("Prepare shader");
  }
  
  GlShader createShader(ShaderType paramShaderType)
  {
    return new GlShader(this.vertexShader, createFragmentShaderString(this.genericFragmentSource, paramShaderType));
  }
  
  public void drawOes(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    prepareShader(ShaderType.OES, paramArrayOfFloat, paramInt2, paramInt3, paramInt6, paramInt7);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(36197, paramInt1);
    GLES20.glViewport(paramInt4, paramInt5, paramInt6, paramInt7);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindTexture(36197, 0);
  }
  
  public void drawRgb(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    prepareShader(ShaderType.RGB, paramArrayOfFloat, paramInt2, paramInt3, paramInt6, paramInt7);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glViewport(paramInt4, paramInt5, paramInt6, paramInt7);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindTexture(3553, 0);
  }
  
  public void drawYuv(int[] paramArrayOfInt, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    prepareShader(ShaderType.YUV, paramArrayOfFloat, paramInt1, paramInt2, paramInt5, paramInt6);
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      GLES20.glActiveTexture(33984 + paramInt1);
      GLES20.glBindTexture(3553, paramArrayOfInt[paramInt1]);
      paramInt1 += 1;
    }
    GLES20.glViewport(paramInt3, paramInt4, paramInt5, paramInt6);
    GLES20.glDrawArrays(5, 0, 4);
    paramInt1 = 0;
    while (paramInt1 < 3)
    {
      GLES20.glActiveTexture(paramInt1 + 33984);
      GLES20.glBindTexture(3553, 0);
      paramInt1 += 1;
    }
  }
  
  public void release()
  {
    GlShader localGlShader = this.currentShader;
    if (localGlShader != null)
    {
      localGlShader.release();
      this.currentShader = null;
      this.currentShaderType = null;
    }
  }
  
  public static abstract interface ShaderCallbacks
  {
    public abstract void onNewShader(GlShader paramGlShader);
    
    public abstract void onPrepareShader(GlShader paramGlShader, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static enum ShaderType
  {
    static
    {
      ShaderType localShaderType1 = new ShaderType("OES", 0);
      OES = localShaderType1;
      ShaderType localShaderType2 = new ShaderType("RGB", 1);
      RGB = localShaderType2;
      ShaderType localShaderType3 = new ShaderType("YUV", 2);
      YUV = localShaderType3;
      $VALUES = new ShaderType[] { localShaderType1, localShaderType2, localShaderType3 };
    }
    
    private ShaderType() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.GlGenericDrawer
 * JD-Core Version:    0.7.0.1
 */