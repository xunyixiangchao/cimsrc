package a3;

import com.farsunset.cim.sdk.android.model.Message;
import com.farsunset.cim.sdk.android.model.Ping;
import com.farsunset.cim.sdk.android.model.ReplyBody;
import com.farsunset.cim.sdk.android.model.proto.MessageProto.Model;
import com.farsunset.cim.sdk.android.model.proto.ReplyBodyProto.Model;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class a
{
  private int b(byte paramByte1, byte paramByte2)
  {
    return paramByte1 & 0xFF | (paramByte2 & 0xFF) << 8;
  }
  
  public Object a(ByteBuffer paramByteBuffer, SocketChannel paramSocketChannel)
  {
    paramByteBuffer.position(0);
    int i = paramByteBuffer.get();
    byte b1 = paramByteBuffer.get();
    byte b2 = paramByteBuffer.get();
    paramByteBuffer.clear();
    int j = b(b1, b2);
    paramByteBuffer = ByteBuffer.allocate(j);
    do
    {
      paramSocketChannel.read(paramByteBuffer);
    } while (paramByteBuffer.position() != j);
    if (1 == i) {
      return Ping.getInstance();
    }
    if (4 == i)
    {
      paramByteBuffer = ReplyBodyProto.Model.parseFrom(paramByteBuffer.array());
      paramSocketChannel = new ReplyBody();
      paramSocketChannel.setKey(paramByteBuffer.getKey());
      paramSocketChannel.setTimestamp(paramByteBuffer.getTimestamp());
      paramSocketChannel.putAll(paramByteBuffer.getDataMap());
      paramSocketChannel.setCode(paramByteBuffer.getCode());
      paramSocketChannel.setMessage(paramByteBuffer.getMessage());
      return paramSocketChannel;
    }
    paramByteBuffer = MessageProto.Model.parseFrom(paramByteBuffer.array());
    paramSocketChannel = new Message();
    paramSocketChannel.setId(paramByteBuffer.getId());
    paramSocketChannel.setAction(paramByteBuffer.getAction());
    paramSocketChannel.setContent(paramByteBuffer.getContent());
    paramSocketChannel.setSender(paramByteBuffer.getSender());
    paramSocketChannel.setReceiver(paramByteBuffer.getReceiver());
    paramSocketChannel.setTitle(paramByteBuffer.getTitle());
    paramSocketChannel.setExtra(paramByteBuffer.getExtra());
    paramSocketChannel.setTimestamp(paramByteBuffer.getTimestamp());
    paramSocketChannel.setFormat(paramByteBuffer.getFormat());
    return paramSocketChannel;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     a3.a
 * JD-Core Version:    0.7.0.1
 */