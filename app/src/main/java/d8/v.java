package d8;

import android.content.Context;

public final class v
  implements l
{
  private static boolean b(Context paramContext)
  {
    return new a(paramContext).a();
  }
  
  private static boolean c(Context paramContext)
  {
    return new f(paramContext).a();
  }
  
  private static boolean d(Context paramContext)
  {
    return new j(paramContext).a();
  }
  
  private static boolean e(Context paramContext)
  {
    return new k(paramContext).a();
  }
  
  private static boolean f(Context paramContext)
  {
    return new b(paramContext).a();
  }
  
  private static boolean g(Context paramContext)
  {
    return new d(paramContext).a();
  }
  
  private static boolean h(Context paramContext)
  {
    return new g(paramContext).a();
  }
  
  private static boolean i(Context paramContext)
  {
    return new n(paramContext).a();
  }
  
  private static boolean j(Context paramContext)
  {
    return new r(paramContext).a();
  }
  
  private static boolean k()
  {
    return new t().a();
  }
  
  private static boolean l(Context paramContext)
  {
    return new o(paramContext).a();
  }
  
  private static boolean m(Context paramContext)
  {
    return new p(paramContext).a();
  }
  
  private static boolean n(Context paramContext)
  {
    return new q(paramContext).a();
  }
  
  private static boolean o(Context paramContext)
  {
    return new c(paramContext).a();
  }
  
  private static boolean p(Context paramContext)
  {
    return new e(paramContext).a();
  }
  
  private static boolean q(Context paramContext)
  {
    return new h(paramContext.getContentResolver()).a();
  }
  
  private static boolean r()
  {
    return new u().a();
  }
  
  private boolean s(Context paramContext, String paramString)
  {
    int i = -1;
    try
    {
      switch (paramString.hashCode())
      {
      case 2133799037: 
        if (!paramString.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
          break label652;
        }
        i = 13;
      }
    }
    finally
    {
      boolean bool;
      return false;
    }
    if (paramString.equals("android.permission.READ_CONTACTS"))
    {
      i = 3;
      break label652;
      if (paramString.equals("android.permission.RECORD_AUDIO"))
      {
        i = 8;
        break label652;
        if (paramString.equals("android.permission.WRITE_EXTERNAL_STORAGE"))
        {
          i = 23;
          break label652;
          if (paramString.equals("android.permission.GET_ACCOUNTS"))
          {
            i = 5;
            break label652;
            if (paramString.equals("android.permission.PROCESS_OUTGOING_CALLS"))
            {
              i = 15;
              break label652;
              if (paramString.equals("android.permission.USE_SIP"))
              {
                i = 14;
                break label652;
                if (paramString.equals("android.permission.WRITE_CALL_LOG"))
                {
                  i = 12;
                  break label652;
                  if (paramString.equals("android.permission.WRITE_CALENDAR"))
                  {
                    i = 1;
                    break label652;
                    if (paramString.equals("android.permission.CAMERA"))
                    {
                      i = 2;
                      break label652;
                      if (paramString.equals("android.permission.WRITE_CONTACTS"))
                      {
                        i = 4;
                        break label652;
                        if (paramString.equals("android.permission.CALL_PHONE"))
                        {
                          i = 10;
                          break label652;
                          if (paramString.equals("android.permission.SEND_SMS"))
                          {
                            i = 17;
                            break label652;
                            if (paramString.equals("android.permission.READ_PHONE_STATE"))
                            {
                              i = 9;
                              break label652;
                              if (paramString.equals("android.permission.ACCESS_COARSE_LOCATION"))
                              {
                                i = 6;
                                break label652;
                                if (paramString.equals("android.permission.READ_EXTERNAL_STORAGE"))
                                {
                                  i = 22;
                                  break label652;
                                  if (paramString.equals("android.permission.RECEIVE_SMS"))
                                  {
                                    i = 21;
                                    break label652;
                                    if (paramString.equals("android.permission.RECEIVE_MMS"))
                                    {
                                      i = 18;
                                      break label652;
                                      if (paramString.equals("android.permission.BODY_SENSORS"))
                                      {
                                        i = 16;
                                        break label652;
                                        if (paramString.equals("android.permission.RECEIVE_WAP_PUSH"))
                                        {
                                          i = 20;
                                          break label652;
                                          if (paramString.equals("android.permission.ACCESS_FINE_LOCATION"))
                                          {
                                            i = 7;
                                            break label652;
                                            if (paramString.equals("android.permission.READ_CALL_LOG"))
                                            {
                                              i = 11;
                                              break label652;
                                              if (paramString.equals("android.permission.READ_CALENDAR"))
                                              {
                                                i = 0;
                                                break label652;
                                                if (paramString.equals("android.permission.READ_SMS"))
                                                {
                                                  i = 19;
                                                  break label652;
                                                  return r();
                                                  return k();
                                                  return j(paramContext);
                                                  return m(paramContext);
                                                  return n(paramContext);
                                                  return b(paramContext);
                                                  return p(paramContext);
                                                  return g(paramContext);
                                                  return i(paramContext);
                                                  return l(paramContext);
                                                  return e(paramContext);
                                                  return d(paramContext);
                                                  return q(paramContext);
                                                  return h(paramContext);
                                                  return c(paramContext);
                                                  return o(paramContext);
                                                  bool = f(paramContext);
                                                  return bool;
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label652:
    switch (i)
    {
    }
    return true;
  }
  
  public boolean a(Context paramContext, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (!s(paramContext, paramVarArgs[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     d8.v
 * JD-Core Version:    0.7.0.1
 */