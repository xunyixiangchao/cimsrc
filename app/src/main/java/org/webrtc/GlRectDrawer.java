package org.webrtc;

public class GlRectDrawer
  extends GlGenericDrawer
{
  private static final String FRAGMENT_SHADER = "void main() {\n  gl_FragColor = sample(tc);\n}\n";
  
  public GlRectDrawer()
  {
    super("void main() {\n  gl_FragColor = sample(tc);\n}\n", new ShaderCallbacks(null));
  }
  
  private static class ShaderCallbacks
    implements GlGenericDrawer.ShaderCallbacks
  {
    public void onNewShader(GlShader paramGlShader) {}
    
    public void onPrepareShader(GlShader paramGlShader, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.GlRectDrawer
 * JD-Core Version:    0.7.0.1
 */