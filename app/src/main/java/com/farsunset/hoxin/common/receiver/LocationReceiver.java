package com.farsunset.hoxin.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.LocationClientOption.LocationMode;
import com.farsunset.cim.sdk.android.h;
import com.farsunset.cim.sdk.android.model.SentBody;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.Location;
import com.tencent.bugly.crashreport.CrashReport;

import i3.e;
import u3.d;
import u3.t;

public class LocationReceiver
        extends BroadcastReceiver {
    private static final String c = LocationReceiver.class.getSimpleName();
    private LocationClient a;
    private final BDAbstractLocationListener b = new a();

    public void onReceive(Context paramContext, Intent paramIntent) {
        if (!d.b()) {
            return;
        }
        try {
            this.a = new LocationClient(paramContext);
            paramContext = new LocationClientOption();
            paramContext.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
            paramContext.setCoorType("bd09ll");
            paramContext.setIsNeedAddress(true);
            this.a.setLocOption(paramContext);
            this.a.registerLocationListener(this.b);
            this.a.start();
            return;
        } catch (Exception paramContext) {
            CrashReport.postCatchedException(paramContext);
        }
    }

    class a
            extends BDAbstractLocationListener {
        a() {
        }

        public void onReceiveLocation(BDLocation paramBDLocation) {
            d.x();
            LocationReceiver.a(LocationReceiver.this).stop();
            LocationReceiver.a(LocationReceiver.this).unRegisterLocationListener(this);
            if (paramBDLocation != null) {
                if (!h.k(HoxinApplication.h())) {
                    return;
                }
                double d1 = paramBDLocation.getLatitude();
                double d2 = paramBDLocation.getLongitude();
                Object localObject = new SentBody();
                ((SentBody) localObject).setKey("client_location");
                ((SentBody) localObject).put("uid", String.valueOf(e.o()));
                ((SentBody) localObject).put("latitude", String.valueOf(d1));
                ((SentBody) localObject).put("longitude", String.valueOf(d2));
                ((SentBody) localObject).put("location", paramBDLocation.getAddrStr());
                h.r(HoxinApplication.h(), (SentBody) localObject);
                localObject = new Location();
                ((Location) localObject).latitude = d1;
                ((Location) localObject).longitude = d2;
                ((Location) localObject).city = paramBDLocation.getCity();
                d.z((Location) localObject);
                localObject = LocationReceiver.b();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("*******************定位成功:");
                localStringBuilder.append(paramBDLocation.getAddrStr());
                t.c((String) localObject, localStringBuilder.toString());
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.receiver.LocationReceiver

 * JD-Core Version:    0.7.0.1

 */