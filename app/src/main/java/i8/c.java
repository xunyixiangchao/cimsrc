package i8;

import android.os.Build.VERSION;

public final class c
{
  public static final String[] a = { "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR" };
  public static final String[] b = { "android.permission.CAMERA" };
  public static final String[] c = { "android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS" };
  public static final String[] d = { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" };
  public static final String[] e = { "android.permission.RECORD_AUDIO" };
  public static final String[] f;
  public static final String[] g = { "android.permission.BODY_SENSORS" };
  public static final String[] h = { "android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS" };
  public static final String[] i = { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" };
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26) {
      f = new String[] { "android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.READ_PHONE_NUMBERS", "android.permission.ANSWER_PHONE_CALLS" };
    } else {
      f = new String[] { "android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS" };
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i8.c
 * JD-Core Version:    0.7.0.1
 */