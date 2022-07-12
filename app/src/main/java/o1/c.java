package o1;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.CancellationSignal;
import androidx.room.f0;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p1.g;
import p1.j;

public class c
{
  public static void a(g paramg)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = paramg.a0("SELECT name FROM sqlite_master WHERE type = 'trigger'");
    try
    {
      while (((Cursor)localObject1).moveToNext()) {
        ((List)localObject2).add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (((String)localObject2).startsWith("room_fts_content_sync_"))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("DROP TRIGGER IF EXISTS ");
          localStringBuilder.append((String)localObject2);
          paramg.p(localStringBuilder.toString());
        }
      }
      return;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
  
  public static Cursor b(f0 paramf0, j paramj, boolean paramBoolean, CancellationSignal paramCancellationSignal)
  {
    paramj = paramf0.A(paramj, paramCancellationSignal);
    paramf0 = paramj;
    if (paramBoolean)
    {
      paramf0 = paramj;
      if ((paramj instanceof AbstractWindowedCursor))
      {
        paramCancellationSignal = (AbstractWindowedCursor)paramj;
        int j = paramCancellationSignal.getCount();
        int i;
        if (paramCancellationSignal.hasWindow()) {
          i = paramCancellationSignal.getWindow().getNumRows();
        } else {
          i = j;
        }
        paramf0 = paramj;
        if (i < j) {
          paramf0 = b.a(paramCancellationSignal);
        }
      }
    }
    return paramf0;
  }
  
  public static int c(File paramFile)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localObject1 = localObject2;
      paramFile = new FileInputStream(paramFile).getChannel();
      localObject1 = paramFile;
      paramFile.tryLock(60L, 4L, true);
      localObject1 = paramFile;
      paramFile.position(60L);
      localObject1 = paramFile;
      if (paramFile.read(localByteBuffer) == 4)
      {
        localObject1 = paramFile;
        localByteBuffer.rewind();
        localObject1 = paramFile;
        int i = localByteBuffer.getInt();
        paramFile.close();
        return i;
      }
      localObject1 = paramFile;
      throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
    }
    finally
    {
      if (localObject1 != null) {
        ((FileChannel)localObject1).close();
      }
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     o1.c
 * JD-Core Version:    0.7.0.1
 */