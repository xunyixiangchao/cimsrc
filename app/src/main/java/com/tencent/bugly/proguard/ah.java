package com.tencent.bugly.proguard;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class ah
  implements af
{
  public final byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ZipOutputStream localZipOutputStream = new ZipOutputStream(localByteArrayOutputStream);
    ZipEntry localZipEntry = new ZipEntry("zip");
    localZipEntry.setSize(paramArrayOfByte.length);
    localZipOutputStream.putNextEntry(localZipEntry);
    localZipOutputStream.write(paramArrayOfByte);
    localZipOutputStream.closeEntry();
    localZipOutputStream.close();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    return paramArrayOfByte;
  }
  
  public final byte[] b(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    ZipInputStream localZipInputStream = new ZipInputStream(localByteArrayInputStream);
    paramArrayOfByte = null;
    while (localZipInputStream.getNextEntry() != null)
    {
      paramArrayOfByte = new byte[1024];
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        int i = localZipInputStream.read(paramArrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(paramArrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
    }
    localZipInputStream.close();
    localByteArrayInputStream.close();
    return paramArrayOfByte;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.proguard.ah
 * JD-Core Version:    0.7.0.1
 */