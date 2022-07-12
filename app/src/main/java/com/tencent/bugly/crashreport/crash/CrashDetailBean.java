package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ab;
import java.util.Map;
import java.util.UUID;

public class CrashDetailBean
  implements Parcelable, Comparable<CrashDetailBean>
{
  public static final Parcelable.Creator<CrashDetailBean> CREATOR = new a();
  public String A;
  public String B;
  public long C;
  public long D;
  public long E;
  public long F;
  public long G;
  public long H;
  public long I;
  public long J;
  public long K;
  public String L;
  public String M;
  public String N;
  public String O;
  public long P;
  public boolean Q;
  public Map<String, String> R;
  public Map<String, String> S;
  public int T;
  public int U;
  public Map<String, String> V;
  public Map<String, String> W;
  public byte[] X;
  public String Y;
  public String Z;
  public long a = -1L;
  private String aa;
  public int b;
  public String c;
  public boolean d;
  public String e;
  public String f;
  public String g;
  public Map<String, PlugInBean> h;
  public Map<String, PlugInBean> i;
  public boolean j;
  public boolean k;
  public int l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public long r;
  public String s;
  public int t;
  public String u;
  public String v;
  public String w;
  public String x;
  public byte[] y;
  public Map<String, String> z;
  
  public CrashDetailBean()
  {
    this.b = 0;
    this.c = UUID.randomUUID().toString();
    this.d = false;
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = null;
    this.i = null;
    this.j = false;
    this.k = false;
    this.l = 0;
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = -1L;
    this.s = null;
    this.t = 0;
    this.u = "";
    this.v = "";
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = "";
    this.B = "";
    this.C = -1L;
    this.D = -1L;
    this.E = -1L;
    this.F = -1L;
    this.G = -1L;
    this.H = -1L;
    this.I = -1L;
    this.J = -1L;
    this.K = -1L;
    this.L = "";
    this.aa = "";
    this.M = "";
    this.N = "";
    this.O = "";
    this.P = -1L;
    this.Q = false;
    this.R = null;
    this.S = null;
    this.T = -1;
    this.U = -1;
    this.V = null;
    this.W = null;
    this.X = null;
    this.Y = null;
    this.Z = null;
  }
  
  public CrashDetailBean(Parcel paramParcel)
  {
    boolean bool2 = false;
    this.b = 0;
    this.c = UUID.randomUUID().toString();
    this.d = false;
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = null;
    this.i = null;
    this.j = false;
    this.k = false;
    this.l = 0;
    this.m = "";
    this.n = "";
    this.o = "";
    this.p = "";
    this.q = "";
    this.r = -1L;
    this.s = null;
    this.t = 0;
    this.u = "";
    this.v = "";
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = "";
    this.B = "";
    this.C = -1L;
    this.D = -1L;
    this.E = -1L;
    this.F = -1L;
    this.G = -1L;
    this.H = -1L;
    this.I = -1L;
    this.J = -1L;
    this.K = -1L;
    this.L = "";
    this.aa = "";
    this.M = "";
    this.N = "";
    this.O = "";
    this.P = -1L;
    this.Q = false;
    this.R = null;
    this.S = null;
    this.T = -1;
    this.U = -1;
    this.V = null;
    this.W = null;
    this.X = null;
    this.Y = null;
    this.Z = null;
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.d = bool1;
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.j = bool1;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.k = bool1;
    this.l = paramParcel.readInt();
    this.m = paramParcel.readString();
    this.n = paramParcel.readString();
    this.o = paramParcel.readString();
    this.p = paramParcel.readString();
    this.q = paramParcel.readString();
    this.r = paramParcel.readLong();
    this.s = paramParcel.readString();
    this.t = paramParcel.readInt();
    this.u = paramParcel.readString();
    this.v = paramParcel.readString();
    this.w = paramParcel.readString();
    this.z = ab.b(paramParcel);
    this.A = paramParcel.readString();
    this.B = paramParcel.readString();
    this.C = paramParcel.readLong();
    this.D = paramParcel.readLong();
    this.E = paramParcel.readLong();
    this.F = paramParcel.readLong();
    this.G = paramParcel.readLong();
    this.H = paramParcel.readLong();
    this.L = paramParcel.readString();
    this.aa = paramParcel.readString();
    this.M = paramParcel.readString();
    this.N = paramParcel.readString();
    this.O = paramParcel.readString();
    this.P = paramParcel.readLong();
    boolean bool1 = bool2;
    if (paramParcel.readByte() == 1) {
      bool1 = true;
    }
    this.Q = bool1;
    this.R = ab.b(paramParcel);
    this.h = ab.a(paramParcel);
    this.i = ab.a(paramParcel);
    this.T = paramParcel.readInt();
    this.U = paramParcel.readInt();
    this.V = ab.b(paramParcel);
    this.W = ab.b(paramParcel);
    this.X = paramParcel.createByteArray();
    this.y = paramParcel.createByteArray();
    this.Y = paramParcel.readString();
    this.Z = paramParcel.readString();
    this.x = paramParcel.readString();
    this.I = paramParcel.readLong();
    this.J = paramParcel.readLong();
    this.K = paramParcel.readLong();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeByte((byte)this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeByte((byte)this.j);
    paramParcel.writeByte((byte)this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeString(this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeLong(this.r);
    paramParcel.writeString(this.s);
    paramParcel.writeInt(this.t);
    paramParcel.writeString(this.u);
    paramParcel.writeString(this.v);
    paramParcel.writeString(this.w);
    ab.b(paramParcel, this.z);
    paramParcel.writeString(this.A);
    paramParcel.writeString(this.B);
    paramParcel.writeLong(this.C);
    paramParcel.writeLong(this.D);
    paramParcel.writeLong(this.E);
    paramParcel.writeLong(this.F);
    paramParcel.writeLong(this.G);
    paramParcel.writeLong(this.H);
    paramParcel.writeString(this.L);
    paramParcel.writeString(this.aa);
    paramParcel.writeString(this.M);
    paramParcel.writeString(this.N);
    paramParcel.writeString(this.O);
    paramParcel.writeLong(this.P);
    paramParcel.writeByte((byte)this.Q);
    ab.b(paramParcel, this.R);
    ab.a(paramParcel, this.h);
    ab.a(paramParcel, this.i);
    paramParcel.writeInt(this.T);
    paramParcel.writeInt(this.U);
    ab.b(paramParcel, this.V);
    ab.b(paramParcel, this.W);
    paramParcel.writeByteArray(this.X);
    paramParcel.writeByteArray(this.y);
    paramParcel.writeString(this.Y);
    paramParcel.writeString(this.Z);
    paramParcel.writeString(this.x);
    paramParcel.writeLong(this.I);
    paramParcel.writeLong(this.J);
    paramParcel.writeLong(this.K);
  }
  
  static final class a
    implements Parcelable.Creator<CrashDetailBean>
  {}
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.tencent.bugly.crashreport.crash.CrashDetailBean
 * JD-Core Version:    0.7.0.1
 */