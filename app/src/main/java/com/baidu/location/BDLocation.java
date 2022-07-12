package com.baidu.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.baidu.location.e.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class BDLocation
  implements Parcelable
{
  public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
  public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
  public static final String BDLOCATION_COOR_TYPE_BD09LL = "bd09";
  public static final String BDLOCATION_COOR_TYPE_BD09MC = "bd09mc";
  public static final String BDLOCATION_COOR_TYPE_GCJ02 = "gcj02";
  public static final String BDLOCATION_COOR_TYPE_GCJ03 = "gcj03";
  public static final String BDLOCATION_COOR_TYPE_WGS84 = "wgs84";
  public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
  public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
  public static final String BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU = "bd_beidou";
  public static final String BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM = "system";
  public static final String BDLOCATION_WGS84_TO_GCJ02 = "gps2gcj";
  public static final Parcelable.Creator<BDLocation> CREATOR = new Parcelable.Creator()
  {
    public BDLocation createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BDLocation(paramAnonymousParcel, null);
    }
    
    public BDLocation[] newArray(int paramAnonymousInt)
    {
      return new BDLocation[paramAnonymousInt];
    }
  };
  public static final int GPS_ACCURACY_BAD = 3;
  public static final int GPS_ACCURACY_GOOD = 1;
  public static final int GPS_ACCURACY_MID = 2;
  public static final int GPS_ACCURACY_UNKNOWN = 0;
  public static final int GPS_RECTIFY_INDOOR = 1;
  public static final int GPS_RECTIFY_NONE = 0;
  public static final int GPS_RECTIFY_OUTDOOR = 2;
  public static final int INDOOR_LOCATION_NEARBY_SURPPORT_TRUE = 2;
  public static final int INDOOR_LOCATION_SOURCE_BLUETOOTH = 4;
  public static final int INDOOR_LOCATION_SOURCE_MAGNETIC = 2;
  public static final int INDOOR_LOCATION_SOURCE_SMALLCELLSTATION = 8;
  public static final int INDOOR_LOCATION_SOURCE_UNKNOWN = 0;
  public static final int INDOOR_LOCATION_SOURCE_WIFI = 1;
  public static final int INDOOR_LOCATION_SURPPORT_FALSE = 0;
  public static final int INDOOR_LOCATION_SURPPORT_TRUE = 1;
  public static final int INDOOR_NETWORK_STATE_HIGH = 2;
  public static final int INDOOR_NETWORK_STATE_LOW = 0;
  public static final int INDOOR_NETWORK_STATE_MIDDLE = 1;
  public static final int LOCATION_WHERE_IN_CN = 1;
  public static final int LOCATION_WHERE_OUT_CN = 0;
  public static final int LOCATION_WHERE_UNKNOW = 2;
  public static final int MOCK_GPS_PROBABILITY_HIGH = 3;
  public static final int MOCK_GPS_PROBABILITY_LOW = 1;
  public static final int MOCK_GPS_PROBABILITY_MIDDLE = 2;
  public static final int MOCK_GPS_PROBABILITY_UNKNOW = -1;
  public static final int MOCK_GPS_PROBABILITY_ZERO = 0;
  public static final int OPERATORS_TYPE_MOBILE = 1;
  public static final int OPERATORS_TYPE_TELECOMU = 3;
  public static final int OPERATORS_TYPE_UNICOM = 2;
  public static final int OPERATORS_TYPE_UNKONW = 0;
  public static final int TYPE_HD_LOCATION = 601;
  public static final int TypeCacheLocation = 65;
  public static final int TypeCriteriaException = 62;
  public static final int TypeGpsLocation = 61;
  public static final int TypeNetWorkException = 63;
  public static final int TypeNetWorkLocation = 161;
  public static final int TypeNone = 0;
  public static final int TypeOffLineLocation = 66;
  public static final int TypeOffLineLocationFail = 67;
  public static final int TypeOffLineLocationNetworkFail = 68;
  public static final int TypeServerCheckKeyError = 505;
  public static final int TypeServerDecryptError = 162;
  public static final int TypeServerError = 167;
  public static final int USER_INDDOR_TRUE = 1;
  public static final int USER_INDOOR_FALSE = 0;
  public static final int USER_INDOOR_UNKNOW = -1;
  private String A;
  private String B;
  private double C;
  private boolean D;
  private int E;
  private int F;
  private String G;
  private int H;
  private String I;
  private int J;
  private int K;
  private int L;
  private int M;
  private String N;
  private String O;
  private String P;
  private int Q;
  private List<Poi> R;
  private String S;
  private String T;
  private String U;
  private Bundle V;
  private int W;
  private int X;
  private long Y;
  private String Z;
  private int a;
  private String aa;
  private double ab;
  private double ac;
  private boolean ad;
  private PoiRegion ae;
  private float af;
  private double ag;
  private int ah;
  private int ai;
  private BDLocation aj;
  private Bundle ak;
  private String al;
  private String b;
  private double c;
  private double d;
  private boolean e;
  private double f;
  private boolean g;
  private float h;
  private boolean i;
  private float j;
  private String k;
  private float l;
  private int m;
  private float n;
  private boolean o;
  private int p;
  private float q;
  private String r;
  private boolean s;
  private String t;
  private String u;
  private String v;
  private String w;
  private boolean x;
  private Address y;
  private String z;
  
  public BDLocation()
  {
    this.a = 0;
    this.b = null;
    this.c = 4.9E-324D;
    this.d = 4.9E-324D;
    this.e = false;
    this.f = 4.9E-324D;
    this.g = false;
    this.h = 0.0F;
    this.i = false;
    this.j = 0.0F;
    this.l = 0.0F;
    this.m = -1;
    this.n = 0.0F;
    this.o = false;
    this.p = -1;
    this.q = -1.0F;
    this.r = null;
    this.s = false;
    this.t = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.x = false;
    this.y = new Address.Builder().build();
    this.z = null;
    this.A = null;
    this.B = null;
    this.D = false;
    this.E = 0;
    this.F = 1;
    this.G = null;
    this.I = "";
    this.J = -1;
    this.K = 0;
    this.L = 2;
    this.M = 0;
    this.N = null;
    this.O = null;
    this.P = null;
    this.Q = -1;
    this.R = null;
    this.S = null;
    this.T = null;
    this.U = null;
    this.V = new Bundle();
    this.W = 0;
    this.X = 0;
    this.Y = 0L;
    this.Z = null;
    this.aa = null;
    this.ab = 4.9E-324D;
    this.ac = 4.9E-324D;
    this.ad = false;
    this.ae = null;
    this.af = -1.0F;
    this.ag = -1.0D;
    this.ah = 0;
    this.ai = -1;
    this.ak = null;
    this.al = null;
  }
  
  private BDLocation(Parcel paramParcel)
  {
    this.a = 0;
    this.b = null;
    this.c = 4.9E-324D;
    this.d = 4.9E-324D;
    this.e = false;
    this.f = 4.9E-324D;
    this.g = false;
    this.h = 0.0F;
    this.i = false;
    this.j = 0.0F;
    this.l = 0.0F;
    this.m = -1;
    this.n = 0.0F;
    this.o = false;
    this.p = -1;
    this.q = -1.0F;
    this.r = null;
    this.s = false;
    this.t = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.x = false;
    this.y = new Address.Builder().build();
    this.z = null;
    this.A = null;
    this.B = null;
    this.D = false;
    this.E = 0;
    this.F = 1;
    this.G = null;
    this.I = "";
    this.J = -1;
    this.K = 0;
    this.L = 2;
    this.M = 0;
    this.N = null;
    this.O = null;
    this.P = null;
    this.Q = -1;
    this.R = null;
    this.S = null;
    this.T = null;
    this.U = null;
    this.V = new Bundle();
    this.W = 0;
    this.X = 0;
    this.Y = 0L;
    this.Z = null;
    this.aa = null;
    this.ab = 4.9E-324D;
    this.ac = 4.9E-324D;
    this.ad = false;
    this.ae = null;
    this.af = -1.0F;
    this.ag = -1.0D;
    this.ah = 0;
    this.ai = -1;
    this.ak = null;
    this.al = null;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.readDouble();
    this.d = paramParcel.readDouble();
    this.f = paramParcel.readDouble();
    this.h = paramParcel.readFloat();
    this.j = paramParcel.readFloat();
    this.k = paramParcel.readString();
    this.l = paramParcel.readFloat();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readFloat();
    this.p = paramParcel.readInt();
    this.q = paramParcel.readFloat();
    this.z = paramParcel.readString();
    this.E = paramParcel.readInt();
    this.A = paramParcel.readString();
    this.B = paramParcel.readString();
    this.C = paramParcel.readDouble();
    this.G = paramParcel.readString();
    Object localObject = paramParcel.readString();
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    paramParcel.readString();
    String str6 = paramParcel.readString();
    String str7 = paramParcel.readString();
    String str8 = paramParcel.readString();
    String str9 = paramParcel.readString();
    this.y = new Address.Builder().country(str6).countryCode(str7).province((String)localObject).city(str1).cityCode(str5).district(str2).street(str3).streetNumber(str4).adcode(str8).town(str9).build();
    localObject = new boolean[8];
    this.H = paramParcel.readInt();
    this.I = paramParcel.readString();
    this.u = paramParcel.readString();
    this.v = paramParcel.readString();
    this.w = paramParcel.readString();
    this.F = paramParcel.readInt();
    this.S = paramParcel.readString();
    this.J = paramParcel.readInt();
    this.K = paramParcel.readInt();
    this.L = paramParcel.readInt();
    this.M = paramParcel.readInt();
    this.N = paramParcel.readString();
    this.O = paramParcel.readString();
    this.P = paramParcel.readString();
    this.Q = paramParcel.readInt();
    this.W = paramParcel.readInt();
    this.T = paramParcel.readString();
    this.X = paramParcel.readInt();
    this.U = paramParcel.readString();
    this.Z = paramParcel.readString();
    this.aa = paramParcel.readString();
    this.Y = paramParcel.readLong();
    this.ab = paramParcel.readDouble();
    this.ac = paramParcel.readDouble();
    this.af = paramParcel.readFloat();
    this.ag = paramParcel.readDouble();
    this.ah = paramParcel.readInt();
    this.ai = paramParcel.readInt();
    this.r = paramParcel.readString();
    this.al = paramParcel.readString();
    try
    {
      this.aj = ((BDLocation)paramParcel.readParcelable(BDLocation.class.getClassLoader()));
    }
    catch (Exception localException4)
    {
      this.aj = null;
      localException4.printStackTrace();
    }
    try
    {
      paramParcel.readBooleanArray((boolean[])localObject);
      this.e = localObject[0];
      this.g = localObject[1];
      this.i = localObject[2];
      this.o = localObject[3];
      this.s = localObject[4];
      this.x = localObject[5];
      this.D = localObject[6];
      this.ad = localObject[7];
      label949:
      localObject = new ArrayList();
      try
      {
        paramParcel.readList((List)localObject, Poi.class.getClassLoader());
      }
      catch (Exception localException5)
      {
        localException5.printStackTrace();
      }
      if (((List)localObject).size() == 0) {
        this.R = null;
      } else {
        this.R = ((List)localObject);
      }
      try
      {
        this.V = paramParcel.readBundle();
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.V = new Bundle();
      }
      try
      {
        this.ak = paramParcel.readBundle();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.ak = new Bundle();
      }
      try
      {
        this.ae = ((PoiRegion)paramParcel.readParcelable(PoiRegion.class.getClassLoader()));
        return;
      }
      catch (Exception paramParcel)
      {
        this.ae = null;
        paramParcel.printStackTrace();
        return;
      }
    }
    catch (Exception localException3)
    {
      break label949;
    }
  }
  
  public BDLocation(BDLocation paramBDLocation)
  {
    int i1 = 0;
    this.a = 0;
    Object localObject = null;
    this.b = null;
    this.c = 4.9E-324D;
    this.d = 4.9E-324D;
    this.e = false;
    this.f = 4.9E-324D;
    this.g = false;
    this.h = 0.0F;
    this.i = false;
    this.j = 0.0F;
    this.l = 0.0F;
    this.m = -1;
    this.n = 0.0F;
    this.o = false;
    this.p = -1;
    this.q = -1.0F;
    this.r = null;
    this.s = false;
    this.t = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.x = false;
    this.y = new Address.Builder().build();
    this.z = null;
    this.A = null;
    this.B = null;
    this.D = false;
    this.E = 0;
    this.F = 1;
    this.G = null;
    this.I = "";
    this.J = -1;
    this.K = 0;
    this.L = 2;
    this.M = 0;
    this.N = null;
    this.O = null;
    this.P = null;
    this.Q = -1;
    this.R = null;
    this.S = null;
    this.T = null;
    this.U = null;
    this.V = new Bundle();
    this.W = 0;
    this.X = 0;
    this.Y = 0L;
    this.Z = null;
    this.aa = null;
    this.ab = 4.9E-324D;
    this.ac = 4.9E-324D;
    this.ad = false;
    this.ae = null;
    this.af = -1.0F;
    this.ag = -1.0D;
    this.ah = 0;
    this.ai = -1;
    this.ak = null;
    this.al = null;
    this.a = paramBDLocation.a;
    this.b = paramBDLocation.b;
    this.c = paramBDLocation.c;
    this.d = paramBDLocation.d;
    this.e = paramBDLocation.e;
    this.f = paramBDLocation.f;
    this.g = paramBDLocation.g;
    this.h = paramBDLocation.h;
    this.i = paramBDLocation.i;
    this.j = paramBDLocation.j;
    this.k = paramBDLocation.k;
    this.l = paramBDLocation.l;
    this.m = paramBDLocation.m;
    this.n = paramBDLocation.n;
    this.o = paramBDLocation.o;
    this.p = paramBDLocation.p;
    this.q = paramBDLocation.q;
    this.r = paramBDLocation.r;
    this.s = paramBDLocation.s;
    this.t = paramBDLocation.t;
    this.x = paramBDLocation.x;
    this.y = new Address.Builder().country(paramBDLocation.y.country).countryCode(paramBDLocation.y.countryCode).province(paramBDLocation.y.province).city(paramBDLocation.y.city).cityCode(paramBDLocation.y.cityCode).district(paramBDLocation.y.district).street(paramBDLocation.y.street).streetNumber(paramBDLocation.y.streetNumber).adcode(paramBDLocation.y.adcode).town(paramBDLocation.y.town).build();
    this.z = paramBDLocation.z;
    this.A = paramBDLocation.A;
    this.B = paramBDLocation.B;
    this.C = paramBDLocation.C;
    this.F = paramBDLocation.F;
    this.E = paramBDLocation.E;
    this.D = paramBDLocation.D;
    this.G = paramBDLocation.G;
    this.H = paramBDLocation.H;
    this.I = paramBDLocation.I;
    this.u = paramBDLocation.u;
    this.v = paramBDLocation.v;
    this.w = paramBDLocation.w;
    this.J = paramBDLocation.J;
    this.K = paramBDLocation.K;
    this.L = paramBDLocation.K;
    this.M = paramBDLocation.M;
    this.N = paramBDLocation.N;
    this.O = paramBDLocation.O;
    this.P = paramBDLocation.P;
    this.Q = paramBDLocation.Q;
    this.W = paramBDLocation.W;
    this.U = paramBDLocation.U;
    this.Z = paramBDLocation.Z;
    this.aa = paramBDLocation.aa;
    this.ab = paramBDLocation.ab;
    this.ac = paramBDLocation.ac;
    this.Y = paramBDLocation.Y;
    this.ag = paramBDLocation.ag;
    this.ah = paramBDLocation.ah;
    this.ai = paramBDLocation.ai;
    this.aj = paramBDLocation.aj;
    this.T = paramBDLocation.T;
    if (paramBDLocation.R == null)
    {
      this.R = ((List)localObject);
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        localObject = localArrayList;
        if (i1 >= paramBDLocation.R.size()) {
          break;
        }
        localObject = (Poi)paramBDLocation.R.get(i1);
        localArrayList.add(new Poi(((Poi)localObject).getId(), ((Poi)localObject).getName(), ((Poi)localObject).getRank(), ((Poi)localObject).getTags(), ((Poi)localObject).getAddr()));
        i1 += 1;
      }
    }
    this.S = paramBDLocation.S;
    this.V = paramBDLocation.V;
    this.X = paramBDLocation.X;
    this.ad = paramBDLocation.ad;
    this.ae = paramBDLocation.ae;
    this.af = paramBDLocation.af;
    this.ak = paramBDLocation.ak;
    this.al = paramBDLocation.al;
  }
  
  public BDLocation(String paramString) {}
  
  private void a(Boolean paramBoolean)
  {
    this.x = paramBoolean.booleanValue();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public double getAcc()
  {
    return this.C;
  }
  
  public String getAdCode()
  {
    return this.y.adcode;
  }
  
  public String getAddrStr()
  {
    return this.y.address;
  }
  
  public Address getAddress()
  {
    return this.y;
  }
  
  public double getAltitude()
  {
    return this.f;
  }
  
  public String getBuildingID()
  {
    return this.A;
  }
  
  public String getBuildingName()
  {
    return this.B;
  }
  
  public String getCity()
  {
    return this.y.city;
  }
  
  public String getCityCode()
  {
    return this.y.cityCode;
  }
  
  public String getCoorType()
  {
    return this.r;
  }
  
  public String getCountry()
  {
    return this.y.country;
  }
  
  public String getCountryCode()
  {
    return this.y.countryCode;
  }
  
  public long getDelayTime()
  {
    return this.Y;
  }
  
  @Deprecated
  public float getDerect()
  {
    return this.q;
  }
  
  public float getDirection()
  {
    return this.q;
  }
  
  public double getDisToRealLocation()
  {
    return this.ag;
  }
  
  public String getDistrict()
  {
    return this.y.district;
  }
  
  public Bundle getExtraInfo()
  {
    return this.ak;
  }
  
  public Location getExtraLocation(String paramString)
  {
    Bundle localBundle = this.V;
    if (localBundle != null)
    {
      paramString = localBundle.getParcelable(paramString);
      if ((paramString instanceof Location)) {
        return (Location)paramString;
      }
    }
    return null;
  }
  
  public String getFloor()
  {
    return this.z;
  }
  
  public double[] getFusionLocInfo(String paramString)
  {
    return this.V.getDoubleArray(paramString);
  }
  
  public String getGnssProvider()
  {
    return this.al;
  }
  
  public int getGpsAccuracyStatus()
  {
    return this.W;
  }
  
  public float getGpsBiasProb()
  {
    return this.af;
  }
  
  public int getGpsCheckStatus()
  {
    return this.X;
  }
  
  public int getInOutStatus()
  {
    return this.Q;
  }
  
  public int getIndoorLocationSource()
  {
    return this.M;
  }
  
  public int getIndoorLocationSurpport()
  {
    return this.K;
  }
  
  public String getIndoorLocationSurpportBuidlingID()
  {
    return this.O;
  }
  
  public String getIndoorLocationSurpportBuidlingName()
  {
    return this.N;
  }
  
  public int getIndoorNetworkState()
  {
    return this.L;
  }
  
  public String getIndoorSurpportPolygon()
  {
    return this.P;
  }
  
  public double getLatitude()
  {
    return this.c;
  }
  
  public int getLocType()
  {
    return this.a;
  }
  
  public String getLocTypeDescription()
  {
    return this.S;
  }
  
  public String getLocationDescribe()
  {
    return this.u;
  }
  
  public String getLocationID()
  {
    return this.T;
  }
  
  public int getLocationWhere()
  {
    return this.F;
  }
  
  public double getLongitude()
  {
    return this.d;
  }
  
  public int getMockGpsProbability()
  {
    return this.ai;
  }
  
  public int getMockGpsStrategy()
  {
    return this.ah;
  }
  
  public String getNetworkLocationType()
  {
    return this.G;
  }
  
  public double getNrlLat()
  {
    return this.ab;
  }
  
  public double getNrlLon()
  {
    return this.ac;
  }
  
  public String getNrlResult()
  {
    return this.Z;
  }
  
  public int getOperators()
  {
    return this.H;
  }
  
  public List<Poi> getPoiList()
  {
    return this.R;
  }
  
  public PoiRegion getPoiRegion()
  {
    return this.ae;
  }
  
  public String getProvince()
  {
    return this.y.province;
  }
  
  public float getRadius()
  {
    return this.j;
  }
  
  public BDLocation getReallLocation()
  {
    if (getMockGpsStrategy() > 0) {
      return this.aj;
    }
    return null;
  }
  
  public String getRetFields(String paramString)
  {
    return this.V.getString(paramString);
  }
  
  public String getRoadLocString()
  {
    return this.U;
  }
  
  public int getSatelliteNumber()
  {
    this.o = true;
    return this.p;
  }
  
  @Deprecated
  public String getSemaAptag()
  {
    return this.u;
  }
  
  public float getSpeed()
  {
    return this.h;
  }
  
  public String getStreet()
  {
    return this.y.street;
  }
  
  public String getStreetNumber()
  {
    return this.y.streetNumber;
  }
  
  public String getTime()
  {
    return this.b;
  }
  
  public String getTown()
  {
    return this.y.town;
  }
  
  public String getTraffic()
  {
    return this.k;
  }
  
  public float getTrafficConfidence()
  {
    return this.l;
  }
  
  public float getTrafficSkipProb()
  {
    return this.n;
  }
  
  public int getUserIndoorState()
  {
    return this.J;
  }
  
  public String getVdrJsonString()
  {
    Bundle localBundle = this.V;
    if ((localBundle != null) && (localBundle.containsKey("vdr"))) {
      return this.V.getString("vdr");
    }
    return null;
  }
  
  public String getViaductResult()
  {
    return this.aa;
  }
  
  public boolean hasAddr()
  {
    return this.s;
  }
  
  public boolean hasAltitude()
  {
    return this.e;
  }
  
  public boolean hasRadius()
  {
    return this.i;
  }
  
  public boolean hasSateNumber()
  {
    return this.o;
  }
  
  public boolean hasSpeed()
  {
    return this.g;
  }
  
  public boolean isCellChangeFlag()
  {
    return this.x;
  }
  
  public boolean isInIndoorPark()
  {
    return this.ad;
  }
  
  public boolean isIndoorLocMode()
  {
    return this.D;
  }
  
  public boolean isNrlAvailable()
  {
    return (this.ac != 4.9E-324D) && (this.ab != 4.9E-324D);
  }
  
  public int isParkAvailable()
  {
    return this.E;
  }
  
  public int isTrafficStation()
  {
    return this.m;
  }
  
  public void setAcc(double paramDouble)
  {
    this.C = paramDouble;
  }
  
  public void setAddr(Address paramAddress)
  {
    if (paramAddress != null)
    {
      this.y = paramAddress;
      this.s = true;
    }
  }
  
  public void setAddrStr(String paramString)
  {
    this.t = paramString;
    boolean bool;
    if (paramString == null) {
      bool = false;
    } else {
      bool = true;
    }
    this.s = bool;
  }
  
  public void setAltitude(double paramDouble)
  {
    if (paramDouble < 9999.0D)
    {
      this.f = paramDouble;
      this.e = true;
    }
  }
  
  public void setBuildingID(String paramString)
  {
    this.A = paramString;
  }
  
  public void setBuildingName(String paramString)
  {
    this.B = paramString;
  }
  
  public void setCoorType(String paramString)
  {
    this.r = paramString;
  }
  
  public void setDelayTime(long paramLong)
  {
    this.Y = paramLong;
  }
  
  public void setDirection(float paramFloat)
  {
    this.q = paramFloat;
  }
  
  public void setDisToRealLocation(double paramDouble)
  {
    this.ag = paramDouble;
  }
  
  public void setExtraLocation(String paramString, Location paramLocation)
  {
    if (this.V == null) {
      this.V = new Bundle();
    }
    this.V.putParcelable(paramString, paramLocation);
  }
  
  public void setExtrainfo(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = null;
    } else {
      paramBundle = new Bundle(paramBundle);
    }
    this.ak = paramBundle;
  }
  
  public void setFloor(String paramString)
  {
    this.z = paramString;
  }
  
  public void setFusionLocInfo(String paramString, double[] paramArrayOfDouble)
  {
    if (this.V == null) {
      this.V = new Bundle();
    }
    this.V.putDoubleArray(paramString, paramArrayOfDouble);
  }
  
  public void setGnssProvider(String paramString)
  {
    this.al = paramString;
  }
  
  public void setGpsAccuracyStatus(int paramInt)
  {
    this.W = paramInt;
  }
  
  public void setGpsBiasProb(float paramFloat)
  {
    this.af = paramFloat;
  }
  
  public void setGpsCheckStatus(int paramInt)
  {
    this.X = paramInt;
  }
  
  public void setInOutStatus(int paramInt)
  {
    this.Q = paramInt;
  }
  
  public void setIndoorLocMode(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void setIndoorLocationSource(int paramInt)
  {
    this.M = paramInt;
  }
  
  public void setIndoorLocationSurpport(int paramInt)
  {
    this.K = paramInt;
  }
  
  public void setIndoorNetworkState(int paramInt)
  {
    this.L = paramInt;
  }
  
  public void setIndoorSurpportPolygon(String paramString)
  {
    this.P = paramString;
  }
  
  public void setIsInIndoorPark(boolean paramBoolean)
  {
    this.ad = paramBoolean;
  }
  
  public void setIsTrafficStation(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void setLatitude(double paramDouble)
  {
    this.c = paramDouble;
  }
  
  public void setLocType(int paramInt)
  {
    this.a = paramInt;
    String str;
    if (paramInt != 66) {
      if (paramInt != 67) {
        if (paramInt != 161) {
          if (paramInt != 162) {
            if (paramInt != 167) {
              if (paramInt != 505) {
                switch (paramInt)
                {
                default: 
                  str = "UnKnown!";
                  break;
                case 62: 
                  str = "Location failed beacuse we can not get any loc information!";
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      setLocTypeDescription(str);
      return;
      setLocTypeDescription("GPS location successful!");
      setUserIndoorState(0);
      setGnssProvider("system");
      return;
      str = "NetWork location failed because baidu location service check the key is unlegal, please check the key in AndroidManifest.xml !";
      continue;
      str = "NetWork location failed because baidu location service can not caculate the location!";
      continue;
      str = "NetWork location failed because baidu location service can not decrypt the request query, please check the so file !";
      continue;
      str = "NetWork location successful!";
      continue;
      str = "Offline location failed, please check the net (wifi/cell)!";
      continue;
      str = "Offline location successful!";
    }
  }
  
  public void setLocTypeDescription(String paramString)
  {
    this.S = paramString;
  }
  
  public void setLocationDescribe(String paramString)
  {
    this.u = paramString;
  }
  
  public void setLocationID(String paramString)
  {
    this.T = paramString;
  }
  
  public void setLocationWhere(int paramInt)
  {
    this.F = paramInt;
  }
  
  public void setLongitude(double paramDouble)
  {
    this.d = paramDouble;
  }
  
  public void setMockGpsProbability(int paramInt)
  {
    this.ai = paramInt;
  }
  
  public void setMockGpsStrategy(int paramInt)
  {
    this.ah = paramInt;
  }
  
  public void setNetworkLocationType(String paramString)
  {
    this.G = paramString;
  }
  
  public void setNrlData(String paramString)
  {
    this.Z = paramString;
  }
  
  public void setOperators(int paramInt)
  {
    this.H = paramInt;
  }
  
  public void setParkAvailable(int paramInt)
  {
    this.E = paramInt;
  }
  
  public void setPoiList(List<Poi> paramList)
  {
    this.R = paramList;
  }
  
  public void setPoiRegion(PoiRegion paramPoiRegion)
  {
    this.ae = paramPoiRegion;
  }
  
  public void setRadius(float paramFloat)
  {
    this.j = paramFloat;
    this.i = true;
  }
  
  public void setReallLocation(BDLocation paramBDLocation)
  {
    if (getMockGpsStrategy() > 0) {
      this.aj = paramBDLocation;
    }
  }
  
  public void setRetFields(String paramString1, String paramString2)
  {
    if (this.V == null) {
      this.V = new Bundle();
    }
    this.V.putString(paramString1, paramString2);
  }
  
  public void setRoadLocString(float paramFloat1, float paramFloat2, String paramString)
  {
    double d1 = paramFloat1;
    String str2 = "";
    String str1;
    if (d1 > 0.001D) {
      str1 = String.format("%.2f", new Object[] { Float.valueOf(paramFloat1) });
    } else {
      str1 = "";
    }
    if (paramFloat2 > 0.001D) {
      str2 = String.format("%.2f", new Object[] { Float.valueOf(paramFloat2) });
    }
    String str3 = this.Z;
    if (str3 != null)
    {
      Locale localLocale = Locale.US;
      str1 = String.format(localLocale, "%s|%s,%s", new Object[] { str3, str1, str2 });
      this.U = str1;
      str2 = this.aa;
      if (str2 != null) {
        this.U = String.format(localLocale, "%s|%s", new Object[] { str1, str2 });
      }
    }
    if (paramString != null) {
      this.U = String.format(Locale.US, "%s|%s", new Object[] { this.U, paramString });
    }
  }
  
  public void setSatelliteNumber(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void setSpeed(float paramFloat)
  {
    this.h = paramFloat;
    this.g = true;
  }
  
  public void setTime(String paramString)
  {
    this.b = paramString;
    setLocationID(h.a(paramString));
  }
  
  public void setTraffic(String paramString)
  {
    this.k = paramString;
  }
  
  public void setTrafficConfidence(float paramFloat)
  {
    this.l = paramFloat;
  }
  
  public void setTrafficSkipProb(float paramFloat)
  {
    this.n = paramFloat;
  }
  
  public void setUserIndoorState(int paramInt)
  {
    this.J = paramInt;
  }
  
  public void setVdrJsonValue(String paramString)
  {
    if (this.V == null) {
      this.V = new Bundle();
    }
    this.V.putString("vdr", paramString);
  }
  
  public void setViaductData(String paramString)
  {
    this.aa = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&loctype=");
    localStringBuilder.append(getLocType());
    localStringBuilder.append("&lat=");
    localStringBuilder.append(getLatitude());
    localStringBuilder.append("&lon=");
    localStringBuilder.append(getLongitude());
    localStringBuilder.append("&radius=");
    localStringBuilder.append(getRadius());
    localStringBuilder.append("&biasprob=");
    localStringBuilder.append(getGpsBiasProb());
    localStringBuilder.append("&extrainfo=");
    localStringBuilder.append(getExtraInfo());
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeDouble(this.c);
    paramParcel.writeDouble(this.d);
    paramParcel.writeDouble(this.f);
    paramParcel.writeFloat(this.h);
    paramParcel.writeFloat(this.j);
    paramParcel.writeString(this.k);
    paramParcel.writeFloat(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeFloat(this.n);
    paramParcel.writeInt(this.p);
    paramParcel.writeFloat(this.q);
    paramParcel.writeString(this.z);
    paramParcel.writeInt(this.E);
    paramParcel.writeString(this.A);
    paramParcel.writeString(this.B);
    paramParcel.writeDouble(this.C);
    paramParcel.writeString(this.G);
    paramParcel.writeString(this.y.province);
    paramParcel.writeString(this.y.city);
    paramParcel.writeString(this.y.district);
    paramParcel.writeString(this.y.street);
    paramParcel.writeString(this.y.streetNumber);
    paramParcel.writeString(this.y.cityCode);
    paramParcel.writeString(this.y.address);
    paramParcel.writeString(this.y.country);
    paramParcel.writeString(this.y.countryCode);
    paramParcel.writeString(this.y.adcode);
    paramParcel.writeString(this.y.town);
    paramParcel.writeInt(this.H);
    paramParcel.writeString(this.I);
    paramParcel.writeString(this.u);
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.w);
    paramParcel.writeInt(this.F);
    paramParcel.writeString(this.S);
    paramParcel.writeInt(this.J);
    paramParcel.writeInt(this.K);
    paramParcel.writeInt(this.L);
    paramParcel.writeInt(this.M);
    paramParcel.writeString(this.N);
    paramParcel.writeString(this.O);
    paramParcel.writeString(this.P);
    paramParcel.writeInt(this.Q);
    paramParcel.writeInt(this.W);
    paramParcel.writeString(this.T);
    paramParcel.writeInt(this.X);
    paramParcel.writeString(this.U);
    paramParcel.writeString(this.Z);
    paramParcel.writeString(this.aa);
    paramParcel.writeLong(this.Y);
    paramParcel.writeDouble(this.ab);
    paramParcel.writeDouble(this.ac);
    paramParcel.writeFloat(this.af);
    paramParcel.writeDouble(this.ag);
    paramParcel.writeInt(this.ah);
    paramParcel.writeInt(this.ai);
    paramParcel.writeString(this.r);
    paramParcel.writeString(this.al);
    paramParcel.writeParcelable(this.aj, paramInt);
    paramParcel.writeBooleanArray(new boolean[] { this.e, this.g, this.i, this.o, this.s, this.x, this.D, this.ad });
    paramParcel.writeList(this.R);
    paramParcel.writeBundle(this.V);
    paramParcel.writeBundle(this.ak);
    paramParcel.writeParcelable(this.ae, paramInt);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.BDLocation
 * JD-Core Version:    0.7.0.1
 */