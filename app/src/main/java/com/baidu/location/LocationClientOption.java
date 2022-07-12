package com.baidu.location;

import android.text.TextUtils;

public final class LocationClientOption {
    public static final int FUZZY_MODE = 4;
    public static final int GPS_ONLY = 2;
    public static final int GpsFirst = 1;
    public static final int LOC_SENSITIVITY_HIGHT = 1;
    public static final int LOC_SENSITIVITY_LOW = 3;
    public static final int LOC_SENSITIVITY_MIDDLE = 2;
    public static final int MIN_AUTO_NOTIFY_INTERVAL = 10000;
    public static final int MIN_SCAN_SPAN = 1000;
    public static final int NETWORK_FIRST = 3;
    protected LocationMode a;
    public String addrType = "noaddr";
    public float autoNotifyLocSensitivity = 0.5F;
    public int autoNotifyMaxInterval = 0;
    public int autoNotifyMinDistance = 0;
    public int autoNotifyMinTimeInterval = 0;
    public String coorType = "gcj02";
    public boolean disableLocCache = true;
    public boolean enableSimulateGps = false;
    public FirstLocType firstLocType = FirstLocType.SPEED_IN_FIRST_LOC;
    public boolean isEnableBeidouMode = false;
    public boolean isIgnoreCacheException = true;
    public boolean isIgnoreKillProcess = true;
    public boolean isNeedAltitude = false;
    public boolean isNeedAptag = false;
    public boolean isNeedAptagd = false;
    public boolean isNeedNewVersionRgc = true;
    public boolean isNeedPoiRegion = false;
    public boolean isNeedRegular = false;
    public boolean isOnceLocation = false;
    public int locLegalStatus = 1;
    public boolean location_change_notify = false;
    public boolean mIsNeedDeviceDirect = false;
    public boolean openGps = false;
    public int priority = 1;
    public String prodName = "SDK6.0";
    public int scanSpan = 0;
    public String serviceName = "com.baidu.location.service_v2.9";
    public int timeOut = 12000;
    public int wifiCacheTimeOut = 2147483647;

    public LocationClientOption() {
    }

    public LocationClientOption(LocationClientOption paramLocationClientOption) {
        this.coorType = paramLocationClientOption.coorType;
        this.addrType = paramLocationClientOption.addrType;
        this.openGps = paramLocationClientOption.openGps;
        this.scanSpan = paramLocationClientOption.scanSpan;
        this.timeOut = paramLocationClientOption.timeOut;
        this.prodName = paramLocationClientOption.prodName;
        this.priority = paramLocationClientOption.priority;
        this.location_change_notify = paramLocationClientOption.location_change_notify;
        this.serviceName = paramLocationClientOption.serviceName;
        this.disableLocCache = paramLocationClientOption.disableLocCache;
        this.isIgnoreCacheException = paramLocationClientOption.isIgnoreCacheException;
        this.isIgnoreKillProcess = paramLocationClientOption.isIgnoreKillProcess;
        this.enableSimulateGps = paramLocationClientOption.enableSimulateGps;
        this.a = paramLocationClientOption.a;
        this.isNeedAptag = paramLocationClientOption.isNeedAptag;
        this.isNeedAptagd = paramLocationClientOption.isNeedAptagd;
        this.isNeedPoiRegion = paramLocationClientOption.isNeedPoiRegion;
        this.isNeedRegular = paramLocationClientOption.isNeedRegular;
        this.mIsNeedDeviceDirect = paramLocationClientOption.mIsNeedDeviceDirect;
        this.isNeedAltitude = paramLocationClientOption.isNeedAltitude;
        this.autoNotifyMaxInterval = paramLocationClientOption.autoNotifyMaxInterval;
        this.autoNotifyLocSensitivity = paramLocationClientOption.autoNotifyLocSensitivity;
        this.autoNotifyMinTimeInterval = paramLocationClientOption.autoNotifyMinTimeInterval;
        this.autoNotifyMinDistance = paramLocationClientOption.autoNotifyMinDistance;
        this.wifiCacheTimeOut = paramLocationClientOption.wifiCacheTimeOut;
        this.isNeedNewVersionRgc = paramLocationClientOption.isNeedNewVersionRgc;
        this.isOnceLocation = paramLocationClientOption.isOnceLocation;
        this.locLegalStatus = paramLocationClientOption.locLegalStatus;
        this.isEnableBeidouMode = paramLocationClientOption.isEnableBeidouMode;
        this.firstLocType = paramLocationClientOption.firstLocType;
    }

    public void SetIgnoreCacheException(boolean paramBoolean) {
        this.isIgnoreCacheException = paramBoolean;
    }

    int a() {
        return this.autoNotifyMaxInterval;
    }

    float b() {
        return this.autoNotifyLocSensitivity;
    }

    public void disableCache(boolean paramBoolean) {
        this.disableLocCache = paramBoolean;
    }

    public String getAddrType() {
        return this.addrType;
    }

    public int getAutoNotifyMinDistance() {
        return this.autoNotifyMinDistance;
    }

    public int getAutoNotifyMinTimeInterval() {
        return this.autoNotifyMinTimeInterval;
    }

    public String getCoorType() {
        return this.coorType;
    }

    public LocationMode getLocationMode() {
        return this.a;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getProdName() {
        return this.prodName;
    }

    public int getScanSpan() {
        return this.scanSpan;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public boolean isDisableCache() {
        return this.disableLocCache;
    }

    public boolean isLocationNotify() {
        return this.location_change_notify;
    }

    public boolean isOnceLocation() {
        return this.isOnceLocation;
    }

    public boolean isOpenGps() {
        return this.openGps;
    }

    public boolean optionEquals(LocationClientOption paramLocationClientOption) {
        return (this.coorType.equals(paramLocationClientOption.coorType)) && (this.addrType.equals(paramLocationClientOption.addrType)) && (this.openGps == paramLocationClientOption.openGps) && (this.scanSpan == paramLocationClientOption.scanSpan) && (this.timeOut == paramLocationClientOption.timeOut) && (this.prodName.equals(paramLocationClientOption.prodName)) && (this.location_change_notify == paramLocationClientOption.location_change_notify) && (this.priority == paramLocationClientOption.priority) && (this.disableLocCache == paramLocationClientOption.disableLocCache) && (this.isIgnoreCacheException == paramLocationClientOption.isIgnoreCacheException) && (this.isNeedNewVersionRgc == paramLocationClientOption.isNeedNewVersionRgc) && (this.isIgnoreKillProcess == paramLocationClientOption.isIgnoreKillProcess) && (this.isNeedAptag == paramLocationClientOption.isNeedAptag) && (this.isNeedAptagd == paramLocationClientOption.isNeedAptagd) && (this.isNeedPoiRegion == paramLocationClientOption.isNeedPoiRegion) && (this.isNeedRegular == paramLocationClientOption.isNeedRegular) && (this.mIsNeedDeviceDirect == paramLocationClientOption.mIsNeedDeviceDirect) && (this.autoNotifyMaxInterval == paramLocationClientOption.autoNotifyMaxInterval) && (this.autoNotifyLocSensitivity == paramLocationClientOption.autoNotifyLocSensitivity) && (this.autoNotifyMinTimeInterval == paramLocationClientOption.autoNotifyMinTimeInterval) && (this.autoNotifyMinDistance == paramLocationClientOption.autoNotifyMinDistance) && (this.wifiCacheTimeOut == paramLocationClientOption.wifiCacheTimeOut) && (this.isOnceLocation == paramLocationClientOption.isOnceLocation) && (this.locLegalStatus == paramLocationClientOption.locLegalStatus) && (this.isEnableBeidouMode == paramLocationClientOption.isEnableBeidouMode) && (this.isNeedAltitude == paramLocationClientOption.isNeedAltitude) && (this.a == paramLocationClientOption.a) && (this.enableSimulateGps == paramLocationClientOption.enableSimulateGps) && (this.firstLocType == paramLocationClientOption.firstLocType);
    }

    @Deprecated
    public void setAddrType(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return;
        }
        boolean bool;
        if ("all".equals(paramString)) {
            bool = true;
        } else {
            bool = false;
        }
        setIsNeedAddress(bool);
    }

    public void setCoorType(String paramString) {
        paramString = paramString.toLowerCase();
        if ((paramString.equals("gcj02")) || (paramString.equals("bd09")) || (paramString.equals("bd09ll"))) {
            this.coorType = paramString;
        }
    }

    public void setEnableSimulateGps(boolean paramBoolean) {
        this.enableSimulateGps = paramBoolean;
    }

    public void setFirstLocType(FirstLocType paramFirstLocType) {
        this.firstLocType = paramFirstLocType;
    }

    public void setIgnoreKillProcess(boolean paramBoolean) {
        this.isIgnoreKillProcess = paramBoolean;
    }

    public void setIsEnableBeidouMode(boolean paramBoolean) {
        this.isEnableBeidouMode = paramBoolean;
    }

    public void setIsNeedAddress(boolean paramBoolean) {
        String str;
        if (paramBoolean) {
            str = "all";
        } else {
            str = "noaddr";
        }
        this.addrType = str;
    }

    public void setIsNeedAltitude(boolean paramBoolean) {
        this.isNeedAltitude = paramBoolean;
    }

    public void setIsNeedLocationDescribe(boolean paramBoolean) {
        this.isNeedAptag = paramBoolean;
    }

    public void setIsNeedLocationPoiList(boolean paramBoolean) {
        this.isNeedAptagd = paramBoolean;
    }

    public void setLocStatus(boolean paramBoolean) {
        int i;
        if (paramBoolean) {
            i = 1;
        } else if (!paramBoolean) {
            i = -2;
        } else {
            i = 0;
        }
        this.locLegalStatus = i;
    }

    public void setLocationMode(LocationMode paramLocationMode) {
        int i = 1. a[paramLocationMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        this.priority = 4;
                        this.openGps = false;
                    } else {
                        StringBuilder localStringBuilder = new StringBuilder();
                        localStringBuilder.append("Illegal this mode : ");
                        localStringBuilder.append(paramLocationMode);
                        throw new IllegalArgumentException(localStringBuilder.toString());
                    }
                } else {
                    this.priority = 2;
                    this.openGps = true;
                }
            } else {
                this.openGps = false;
                this.priority = 3;
            }
        } else {
            this.openGps = true;
            this.priority = 1;
        }
        this.a = paramLocationMode;
    }

    public void setLocationNotify(boolean paramBoolean) {
        this.location_change_notify = paramBoolean;
    }

    public void setLocationPurpose(BDLocationPurpose paramBDLocationPurpose) {
        if (paramBDLocationPurpose != null) {
            if (paramBDLocationPurpose == BDLocationPurpose.SignIn) {
                setLocationMode(LocationMode.Hight_Accuracy);
                setLocationNotify(false);
                setScanSpan(0);
                setNeedNewVersionRgc(true);
                setIsNeedAddress(true);
                setIsNeedLocationPoiList(true);
                setIsNeedAltitude(true);
                setIsNeedLocationDescribe(true);
                setWifiCacheTimeOut(10000);
                return;
            }
            if (paramBDLocationPurpose == BDLocationPurpose.Sport) {
                setLocationMode(LocationMode.Hight_Accuracy);
                setLocationNotify(true);
                setScanSpan(3000);
            }
            for (; ; ) {
                setNeedNewVersionRgc(true);
                setIsNeedAddress(true);
                setIsNeedLocationPoiList(false);
                setIsNeedAltitude(true);
                setIsNeedLocationDescribe(false);
                setWifiCacheTimeOut(1000);
                return;
                if (paramBDLocationPurpose != BDLocationPurpose.Transport) {
                    break;
                }
                setLocationMode(LocationMode.Hight_Accuracy);
                setLocationNotify(true);
                setScanSpan(1000);
            }
        }
    }

    public void setNeedDeviceDirect(boolean paramBoolean) {
        this.mIsNeedDeviceDirect = paramBoolean;
    }

    public void setNeedNewVersionRgc(boolean paramBoolean) {
        this.isNeedNewVersionRgc = paramBoolean;
    }

    public void setOnceLocation(boolean paramBoolean) {
        this.isOnceLocation = paramBoolean;
    }

    public void setOpenAutoNotifyMode() {
        setOpenAutoNotifyMode(0, 0, 1);
    }

    public void setOpenAutoNotifyMode(int paramInt1, int paramInt2, int paramInt3) {
        int i = 180000;
        if (paramInt1 > 180000) {
            i = paramInt1 + 1000;
        }
        if (i >= 10000) {
            float f;
            if (paramInt3 != 1) {
                if (paramInt3 != 2) {
                    if (paramInt3 == 3) {
                        f = 0.1F;
                    } else {
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("Illegal this locSensitivity : ");
                        localStringBuilder.append(paramInt3);
                        throw new IllegalArgumentException(localStringBuilder.toString());
                    }
                } else {
                    f = 0.3F;
                }
            } else {
                f = 0.5F;
            }
            this.autoNotifyLocSensitivity = f;
            this.autoNotifyMaxInterval = i;
            this.autoNotifyMinTimeInterval = paramInt1;
            this.autoNotifyMinDistance = paramInt2;
            return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Illegal this maxLocInterval : ");
        localStringBuilder.append(i);
        localStringBuilder.append(" , maxLocInterval must >= ");
        localStringBuilder.append(10000);
        throw new IllegalArgumentException(localStringBuilder.toString());
    }

    public void setOpenGps(boolean paramBoolean) {
        this.openGps = paramBoolean;
    }

    @Deprecated
    public void setPriority(int paramInt) {
        if ((paramInt == 1) || (paramInt == 3)) {
            this.priority = paramInt;
        }
    }

    public void setProdName(String paramString) {
        String str = paramString;
        if (paramString.length() > 64) {
            str = paramString.substring(0, 64);
        }
        this.prodName = str;
    }

    public void setScanSpan(int paramInt) {
        if (paramInt >= 0) {
            this.scanSpan = paramInt;
        }
    }

    @Deprecated
    public void setSema(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        this.isNeedAptag = paramBoolean1;
        this.isNeedPoiRegion = paramBoolean2;
        this.isNeedRegular = paramBoolean3;
    }

    public void setServiceName(String paramString) {
        this.serviceName = paramString;
    }

    public void setTimeOut(int paramInt) {
        this.timeOut = paramInt;
    }

    public void setWifiCacheTimeOut(int paramInt) {
        if (paramInt >= 10000) {
            this.wifiCacheTimeOut = paramInt;
        }
    }

    public static enum BDLocationPurpose {
        static {
            BDLocationPurpose localBDLocationPurpose1 = new BDLocationPurpose("SignIn", 0);
            SignIn = localBDLocationPurpose1;
            BDLocationPurpose localBDLocationPurpose2 = new BDLocationPurpose("Sport", 1);
            Sport = localBDLocationPurpose2;
            BDLocationPurpose localBDLocationPurpose3 = new BDLocationPurpose("Transport", 2);
            Transport = localBDLocationPurpose3;
            $VALUES = new BDLocationPurpose[]{localBDLocationPurpose1, localBDLocationPurpose2, localBDLocationPurpose3};
        }

        private BDLocationPurpose() {
        }
    }

    public static enum FirstLocType {
        static {
            FirstLocType localFirstLocType1 = new FirstLocType("SPEED_IN_FIRST_LOC", 0);
            SPEED_IN_FIRST_LOC = localFirstLocType1;
            FirstLocType localFirstLocType2 = new FirstLocType("ACCURACY_IN_FIRST_LOC", 1);
            ACCURACY_IN_FIRST_LOC = localFirstLocType2;
            $VALUES = new FirstLocType[]{localFirstLocType1, localFirstLocType2};
        }

        private FirstLocType() {
        }
    }

    public static enum LocationMode {
        static {
            LocationMode localLocationMode1 = new LocationMode("Hight_Accuracy", 0);
            Hight_Accuracy = localLocationMode1;
            LocationMode localLocationMode2 = new LocationMode("Battery_Saving", 1);
            Battery_Saving = localLocationMode2;
            LocationMode localLocationMode3 = new LocationMode("Device_Sensors", 2);
            Device_Sensors = localLocationMode3;
            LocationMode localLocationMode4 = new LocationMode("Fuzzy_Locating", 3);
            Fuzzy_Locating = localLocationMode4;
            $VALUES = new LocationMode[]{localLocationMode1, localLocationMode2, localLocationMode3, localLocationMode4};
        }

        private LocationMode() {
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.baidu.location.LocationClientOption

 * JD-Core Version:    0.7.0.1

 */