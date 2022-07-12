package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

class b
  extends a
{
  private final SparseIntArray d = new SparseIntArray();
  private final Parcel e;
  private final int f;
  private final int g;
  private final String h;
  private int i = -1;
  private int j;
  private int k = -1;
  
  b(Parcel paramParcel)
  {
    this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), "", new g0.a(), new g0.a(), new g0.a());
  }
  
  private b(Parcel paramParcel, int paramInt1, int paramInt2, String paramString, g0.a<String, Method> parama1, g0.a<String, Method> parama2, g0.a<String, Class> parama)
  {
    super(parama1, parama2, parama);
    this.e = paramParcel;
    this.f = paramInt1;
    this.g = paramInt2;
    this.j = paramInt1;
    this.h = paramString;
  }
  
  public void A(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.e.writeInt(paramArrayOfByte.length);
      this.e.writeByteArray(paramArrayOfByte);
      return;
    }
    this.e.writeInt(-1);
  }
  
  protected void C(CharSequence paramCharSequence)
  {
    TextUtils.writeToParcel(paramCharSequence, this.e, 0);
  }
  
  public void E(int paramInt)
  {
    this.e.writeInt(paramInt);
  }
  
  public void G(Parcelable paramParcelable)
  {
    this.e.writeParcelable(paramParcelable, 0);
  }
  
  public void I(String paramString)
  {
    this.e.writeString(paramString);
  }
  
  public void a()
  {
    int m = this.i;
    if (m >= 0)
    {
      m = this.d.get(m);
      int n = this.e.dataPosition();
      this.e.setDataPosition(m);
      this.e.writeInt(n - m);
      this.e.setDataPosition(n);
    }
  }
  
  protected a b()
  {
    Parcel localParcel = this.e;
    int i1 = localParcel.dataPosition();
    int n = this.j;
    int m = n;
    if (n == this.f) {
      m = this.g;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.h);
    localStringBuilder.append("  ");
    return new b(localParcel, i1, m, localStringBuilder.toString(), this.a, this.b, this.c);
  }
  
  public boolean g()
  {
    return this.e.readInt() != 0;
  }
  
  public byte[] i()
  {
    int m = this.e.readInt();
    if (m < 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[m];
    this.e.readByteArray(arrayOfByte);
    return arrayOfByte;
  }
  
  protected CharSequence k()
  {
    return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
  }
  
  public boolean m(int paramInt)
  {
    while (this.j < this.g)
    {
      int m = this.k;
      if (m == paramInt) {
        return true;
      }
      if (String.valueOf(m).compareTo(String.valueOf(paramInt)) > 0) {
        return false;
      }
      this.e.setDataPosition(this.j);
      m = this.e.readInt();
      this.k = this.e.readInt();
      this.j += m;
    }
    return this.k == paramInt;
  }
  
  public int o()
  {
    return this.e.readInt();
  }
  
  public <T extends Parcelable> T q()
  {
    return this.e.readParcelable(getClass().getClassLoader());
  }
  
  public String s()
  {
    return this.e.readString();
  }
  
  public void w(int paramInt)
  {
    a();
    this.i = paramInt;
    this.d.put(paramInt, this.e.dataPosition());
    E(0);
    E(paramInt);
  }
  
  public void y(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.versionedparcelable.b
 * JD-Core Version:    0.7.0.1
 */