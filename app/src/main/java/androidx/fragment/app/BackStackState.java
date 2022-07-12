package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new a();
  final int[] a;
  final ArrayList<String> b;
  final int[] c;
  final int[] d;
  final int e;
  final String f;
  final int g;
  final int h;
  final CharSequence i;
  final int j;
  final CharSequence k;
  final ArrayList<String> l;
  final ArrayList<String> m;
  final boolean n;
  
  public BackStackState(Parcel paramParcel)
  {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.createStringArrayList();
    this.c = paramParcel.createIntArray();
    this.d = paramParcel.createIntArray();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.j = paramParcel.readInt();
    this.k = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.l = paramParcel.createStringArrayList();
    this.m = paramParcel.createStringArrayList();
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.n = bool;
  }
  
  public BackStackState(a parama)
  {
    int i3 = parama.c.size();
    this.a = new int[i3 * 5];
    if (parama.i)
    {
      this.b = new ArrayList(i3);
      this.c = new int[i3];
      this.d = new int[i3];
      int i1 = 0;
      int i2 = 0;
      while (i1 < i3)
      {
        q.a locala = (q.a)parama.c.get(i1);
        Object localObject = this.a;
        int i4 = i2 + 1;
        localObject[i2] = locala.a;
        ArrayList localArrayList = this.b;
        localObject = locala.b;
        if (localObject != null) {
          localObject = ((Fragment)localObject).mWho;
        } else {
          localObject = null;
        }
        localArrayList.add(localObject);
        localObject = this.a;
        i2 = i4 + 1;
        localObject[i4] = locala.c;
        i4 = i2 + 1;
        localObject[i2] = locala.d;
        i2 = i4 + 1;
        localObject[i4] = locala.e;
        localObject[i2] = locala.f;
        this.c[i1] = locala.g.ordinal();
        this.d[i1] = locala.h.ordinal();
        i1 += 1;
        i2 += 1;
      }
      this.e = parama.h;
      this.f = parama.k;
      this.g = parama.v;
      this.h = parama.l;
      this.i = parama.m;
      this.j = parama.n;
      this.k = parama.o;
      this.l = parama.p;
      this.m = parama.q;
      this.n = parama.r;
      return;
    }
    throw new IllegalStateException("Not on back stack");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public a g(FragmentManager paramFragmentManager)
  {
    a locala = new a(paramFragmentManager);
    int i2 = 0;
    int i1 = 0;
    while (i2 < this.a.length)
    {
      q.a locala1 = new q.a();
      Object localObject = this.a;
      int i4 = i2 + 1;
      locala1.a = localObject[i2];
      if (FragmentManager.G0(2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Instantiate ");
        ((StringBuilder)localObject).append(locala);
        ((StringBuilder)localObject).append(" op #");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" base fragment #");
        ((StringBuilder)localObject).append(this.a[i4]);
        Log.v("FragmentManager", ((StringBuilder)localObject).toString());
      }
      localObject = (String)this.b.get(i1);
      if (localObject != null) {
        localObject = paramFragmentManager.h0((String)localObject);
      } else {
        localObject = null;
      }
      locala1.b = ((Fragment)localObject);
      locala1.g = androidx.lifecycle.h.c.values()[this.c[i1]];
      locala1.h = androidx.lifecycle.h.c.values()[this.d[i1]];
      localObject = this.a;
      int i3 = i4 + 1;
      i2 = localObject[i4];
      locala1.c = i2;
      int i5 = i3 + 1;
      i4 = localObject[i3];
      locala1.d = i4;
      i3 = i5 + 1;
      i5 = localObject[i5];
      locala1.e = i5;
      int i6 = localObject[i3];
      locala1.f = i6;
      locala.d = i2;
      locala.e = i4;
      locala.f = i5;
      locala.g = i6;
      locala.e(locala1);
      i1 += 1;
      i2 = i3 + 1;
    }
    locala.h = this.e;
    locala.k = this.f;
    locala.v = this.g;
    locala.i = true;
    locala.l = this.h;
    locala.m = this.i;
    locala.n = this.j;
    locala.o = this.k;
    locala.p = this.l;
    locala.q = this.m;
    locala.r = this.n;
    locala.r(1);
    return locala;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  class a
    implements Parcelable.Creator<BackStackState>
  {
    public BackStackState a(Parcel paramParcel)
    {
      return new BackStackState(paramParcel);
    }
    
    public BackStackState[] b(int paramInt)
    {
      return new BackStackState[paramInt];
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.fragment.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */