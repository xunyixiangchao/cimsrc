package o1;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class d
{
  @SuppressLint({"LambdaLast"})
  public static void a(ReadableByteChannel paramReadableByteChannel, FileChannel paramFileChannel)
  {
    try
    {
      if (Build.VERSION.SDK_INT > 23)
      {
        paramFileChannel.transferFrom(paramReadableByteChannel, 0L, 9223372036854775807L);
      }
      else
      {
        InputStream localInputStream = Channels.newInputStream(paramReadableByteChannel);
        OutputStream localOutputStream = Channels.newOutputStream(paramFileChannel);
        byte[] arrayOfByte = new byte[4096];
        for (;;)
        {
          int i = localInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          localOutputStream.write(arrayOfByte, 0, i);
        }
      }
      paramFileChannel.force(false);
      return;
    }
    finally
    {
      paramReadableByteChannel.close();
      paramFileChannel.close();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o1.d
 * JD-Core Version:    0.7.0.1
 */