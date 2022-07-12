package a3;

import com.farsunset.cim.sdk.android.model.BinaryBody;
import java.nio.ByteBuffer;

public class b
{
  private byte[] a(byte paramByte, int paramInt)
  {
    return new byte[] { paramByte, (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF) };
  }
  
  public ByteBuffer b(BinaryBody paramBinaryBody)
  {
    byte[] arrayOfByte = paramBinaryBody.getByteArray();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(arrayOfByte.length + 3);
    localByteBuffer.put(a(paramBinaryBody.getType(), arrayOfByte.length));
    localByteBuffer.put(arrayOfByte);
    localByteBuffer.flip();
    return localByteBuffer;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a3.b
 * JD-Core Version:    0.7.0.1
 */