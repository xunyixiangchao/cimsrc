package com.baidu.mapsdkplatform.comapi.map;

import android.os.Message;

class o
{
  private n a;
  
  void a(Message paramMessage)
  {
    if (paramMessage.what != 65289) {
      return;
    }
    int i = paramMessage.arg1;
    if ((i != 12) && (i != 101) && (i != 102)) {
      switch (i)
      {
      default: 
        return;
      }
    }
    n localn = this.a;
    if (localn != null) {
      localn.a(i, paramMessage.arg2);
    }
  }
  
  void a(n paramn)
  {
    this.a = paramn;
  }
  
  void b(n paramn)
  {
    this.a = null;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.o
 * JD-Core Version:    0.7.0.1
 */