package org.webrtc;

import android.graphics.Matrix;
import android.opengl.GLES20;
import java.nio.ByteBuffer;

public class YuvConverter
{
  private static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
  private final GlGenericDrawer drawer;
  private final GlTextureFrameBuffer i420TextureFrameBuffer;
  private final ShaderCallbacks shaderCallbacks;
  private final ThreadUtils.ThreadChecker threadChecker;
  private final VideoFrameDrawer videoFrameDrawer;
  
  public YuvConverter()
  {
    this(new VideoFrameDrawer());
  }
  
  public YuvConverter(VideoFrameDrawer paramVideoFrameDrawer)
  {
    ThreadUtils.ThreadChecker localThreadChecker = new ThreadUtils.ThreadChecker();
    this.threadChecker = localThreadChecker;
    this.i420TextureFrameBuffer = new GlTextureFrameBuffer(6408);
    ShaderCallbacks localShaderCallbacks = new ShaderCallbacks(null);
    this.shaderCallbacks = localShaderCallbacks;
    this.drawer = new GlGenericDrawer("uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n", localShaderCallbacks);
    this.videoFrameDrawer = paramVideoFrameDrawer;
    localThreadChecker.detachThread();
  }
  
  public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer paramTextureBuffer)
  {
    this.threadChecker.checkIsOnValidThread();
    paramTextureBuffer = (VideoFrame.TextureBuffer)this.videoFrameDrawer.prepareBufferForViewportSize(paramTextureBuffer, paramTextureBuffer.getWidth(), paramTextureBuffer.getHeight());
    int i = paramTextureBuffer.getWidth();
    int j = paramTextureBuffer.getHeight();
    int k = (i + 7) / 8 * 8;
    int m = (j + 1) / 2;
    int n = j + m;
    ByteBuffer localByteBuffer1 = JniCommon.nativeAllocateByteBuffer(k * n);
    int i1 = k / 4;
    Object localObject1 = new Matrix();
    ((Matrix)localObject1).preTranslate(0.5F, 0.5F);
    ((Matrix)localObject1).preScale(1.0F, -1.0F);
    ((Matrix)localObject1).preTranslate(-0.5F, -0.5F);
    this.i420TextureFrameBuffer.setSize(i1, n);
    GLES20.glBindFramebuffer(36160, this.i420TextureFrameBuffer.getFrameBufferId());
    GlUtil.checkNoGLES2Error("glBindFramebuffer");
    this.shaderCallbacks.setPlaneY();
    VideoFrameDrawer.drawTexture(this.drawer, paramTextureBuffer, (Matrix)localObject1, i, j, 0, 0, i1, j);
    this.shaderCallbacks.setPlaneU();
    Object localObject2 = this.drawer;
    n = i1 / 2;
    VideoFrameDrawer.drawTexture((RendererCommon.GlDrawer)localObject2, paramTextureBuffer, (Matrix)localObject1, i, j, 0, j, n, m);
    this.shaderCallbacks.setPlaneV();
    VideoFrameDrawer.drawTexture(this.drawer, paramTextureBuffer, (Matrix)localObject1, i, j, n, j, n, m);
    GLES20.glReadPixels(0, 0, this.i420TextureFrameBuffer.getWidth(), this.i420TextureFrameBuffer.getHeight(), 6408, 5121, localByteBuffer1);
    GlUtil.checkNoGLES2Error("YuvConverter.convert");
    GLES20.glBindFramebuffer(36160, 0);
    n = k * j + 0;
    int i2 = k / 2;
    i1 = n + i2;
    localByteBuffer1.position(0);
    localByteBuffer1.limit(n);
    localObject1 = localByteBuffer1.slice();
    localByteBuffer1.position(n);
    m = (m - 1) * k + i2;
    localByteBuffer1.limit(n + m);
    localObject2 = localByteBuffer1.slice();
    localByteBuffer1.position(i1);
    localByteBuffer1.limit(i1 + m);
    ByteBuffer localByteBuffer2 = localByteBuffer1.slice();
    paramTextureBuffer.release();
    return JavaI420Buffer.wrap(i, j, (ByteBuffer)localObject1, k, (ByteBuffer)localObject2, k, localByteBuffer2, k, new u0(localByteBuffer1));
  }
  
  public void release()
  {
    this.threadChecker.checkIsOnValidThread();
    this.drawer.release();
    this.i420TextureFrameBuffer.release();
    this.videoFrameDrawer.release();
    this.threadChecker.detachThread();
  }
  
  private static class ShaderCallbacks
    implements GlGenericDrawer.ShaderCallbacks
  {
    private static final float[] uCoeffs = { -0.148223F, -0.290993F, 0.439216F, 0.501961F };
    private static final float[] vCoeffs = { 0.439216F, -0.367788F, -0.0714274F, 0.501961F };
    private static final float[] yCoeffs = { 0.256788F, 0.504129F, 0.0979059F, 0.0627451F };
    private float[] coeffs;
    private int coeffsLoc;
    private float stepSize;
    private int xUnitLoc;
    
    public void onNewShader(GlShader paramGlShader)
    {
      this.xUnitLoc = paramGlShader.getUniformLocation("xUnit");
      this.coeffsLoc = paramGlShader.getUniformLocation("coeffs");
    }
    
    public void onPrepareShader(GlShader paramGlShader, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
      paramInt2 = this.xUnitLoc;
      float f1 = this.stepSize;
      float f2 = paramArrayOfFloat[0];
      float f3 = paramInt1;
      GLES20.glUniform2f(paramInt2, f2 * f1 / f3, f1 * paramArrayOfFloat[1] / f3);
    }
    
    public void setPlaneU()
    {
      this.coeffs = uCoeffs;
      this.stepSize = 2.0F;
    }
    
    public void setPlaneV()
    {
      this.coeffs = vCoeffs;
      this.stepSize = 2.0F;
    }
    
    public void setPlaneY()
    {
      this.coeffs = yCoeffs;
      this.stepSize = 1.0F;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.YuvConverter
 * JD-Core Version:    0.7.0.1
 */