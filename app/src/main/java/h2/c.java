package h2;

import android.util.Log;
import b2.d;
import b2.h;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import x2.a;

public class c
  implements d<ByteBuffer>
{
  public boolean c(ByteBuffer paramByteBuffer, File paramFile, h paramh)
  {
    try
    {
      a.f(paramByteBuffer, paramFile);
      return true;
    }
    catch (IOException paramByteBuffer)
    {
      if (Log.isLoggable("ByteBufferEncoder", 3)) {
        Log.d("ByteBufferEncoder", "Failed to write data", paramByteBuffer);
      }
    }
    return false;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     h2.c
 * JD-Core Version:    0.7.0.1
 */