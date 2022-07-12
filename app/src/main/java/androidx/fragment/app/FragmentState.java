package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@SuppressLint({"BanParcelableUsage"})
final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR = new a();
  final String a;
  final String b;
  final boolean c;
  final int d;
  final int e;
  final String f;
  final boolean g;
  final boolean h;
  final boolean i;
  final Bundle j;
  final boolean k;
  final int l;
  Bundle m;
  
  FragmentState(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    int n = paramParcel.readInt();
    boolean bool2 = true;
    boolean bool1;
    if (n != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.c = bool1;
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.h = bool1;
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.i = bool1;
    this.j = paramParcel.readBundle();
    if (paramParcel.readInt() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.k = bool1;
    this.m = paramParcel.readBundle();
    this.l = paramParcel.readInt();
  }
  
  FragmentState(Fragment paramFragment)
  {
    this.a = paramFragment.getClass().getName();
    this.b = paramFragment.mWho;
    this.c = paramFragment.mFromLayout;
    this.d = paramFragment.mFragmentId;
    this.e = paramFragment.mContainerId;
    this.f = paramFragment.mTag;
    this.g = paramFragment.mRetainInstance;
    this.h = paramFragment.mRemoving;
    this.i = paramFragment.mDetached;
    this.j = paramFragment.mArguments;
    this.k = paramFragment.mHidden;
    this.l = paramFragment.mMaxState.ordinal();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentState{");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" (");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")}:");
    if (this.c) {
      localStringBuilder.append(" fromLayout");
    }
    if (this.e != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.e));
    }
    String str = this.f;
    if ((str != null) && (!str.isEmpty()))
    {
      localStringBuilder.append(" tag=");
      localStringBuilder.append(this.f);
    }
    if (this.g) {
      localStringBuilder.append(" retainInstance");
    }
    if (this.h) {
      localStringBuilder.append(" removing");
    }
    if (this.i) {
      localStringBuilder.append(" detached");
    }
    if (this.k) {
      localStringBuilder.append(" hidden");
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  class a
    implements Parcelable.Creator<FragmentState>
  {
    public FragmentState a(Parcel paramParcel)
    {
      return new FragmentState(paramParcel);
    }
    
    public FragmentState[] b(int paramInt)
    {
      return new FragmentState[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.FragmentState
 * JD-Core Version:    0.7.0.1
 */