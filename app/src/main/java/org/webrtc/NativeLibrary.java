package org.webrtc;

class NativeLibrary
{
  private static String TAG = "NativeLibrary";
  private static boolean libraryLoaded;
  private static Object lock = new Object();
  
  static void initialize(NativeLibraryLoader paramNativeLibraryLoader, String paramString)
  {
    synchronized (lock)
    {
      if (libraryLoaded)
      {
        Logging.d(TAG, "Native library has already been loaded.");
        return;
      }
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Loading native library: ");
      localStringBuilder.append(paramString);
      Logging.d(str, localStringBuilder.toString());
      libraryLoaded = paramNativeLibraryLoader.load(paramString);
      return;
    }
  }
  
  static boolean isLoaded()
  {
    synchronized (lock)
    {
      boolean bool = libraryLoaded;
      return bool;
    }
  }
  
  static class DefaultLoader
    implements NativeLibraryLoader
  {
    public boolean load(String paramString)
    {
      String str = NativeLibrary.TAG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Loading library: ");
      ((StringBuilder)localObject).append(paramString);
      Logging.d(str, ((StringBuilder)localObject).toString());
      try
      {
        System.loadLibrary(paramString);
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localObject = NativeLibrary.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to load native library: ");
        localStringBuilder.append(paramString);
        Logging.e((String)localObject, localStringBuilder.toString(), localUnsatisfiedLinkError);
      }
      return false;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     org.webrtc.NativeLibrary
 * JD-Core Version:    0.7.0.1
 */