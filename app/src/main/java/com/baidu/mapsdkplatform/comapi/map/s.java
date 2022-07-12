package com.baidu.mapsdkplatform.comapi.map;

import android.os.Bundle;
import com.baidu.mapapi.map.WinRound;
import com.baidu.platform.comapi.basestruct.Point;

public class s
{
  public float a = 12.0F;
  public int b = 0;
  public int c = 0;
  public double d = 12958162.0D;
  public double e = 4825907.0D;
  public int f = -1;
  public int g = -1;
  public float h = 0.0F;
  public float i = 0.0F;
  public WinRound j = new WinRound();
  public a k = new a();
  public boolean l = false;
  public double m;
  public int n;
  public String o;
  public float p;
  public boolean q;
  public int r;
  
  public Bundle a(c paramc)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    this.a = ((float)paramBundle.getDouble("level"));
    this.b = ((int)paramBundle.getDouble("rotation"));
    this.c = ((int)paramBundle.getDouble("overlooking"));
    this.d = paramBundle.getDouble("centerptx");
    this.e = paramBundle.getDouble("centerpty");
    this.j.left = paramBundle.getInt("left");
    this.j.right = paramBundle.getInt("right");
    this.j.top = paramBundle.getInt("top");
    this.j.bottom = paramBundle.getInt("bottom");
    this.h = paramBundle.getFloat("xoffset");
    float f1 = paramBundle.getFloat("yoffset");
    this.i = f1;
    Object localObject = this.j;
    int i1 = ((WinRound)localObject).right;
    if (i1 != 0)
    {
      int i2 = ((WinRound)localObject).bottom;
      if (i2 != 0)
      {
        i1 = (i1 - ((WinRound)localObject).left) / 2;
        i2 = (i2 - ((WinRound)localObject).top) / 2;
        int i3 = (int)this.h;
        int i4 = (int)-f1;
        this.f = (i3 + i1);
        this.g = (i4 + i2);
      }
    }
    this.k.a = paramBundle.getLong("gleft");
    this.k.b = paramBundle.getLong("gright");
    this.k.c = paramBundle.getLong("gtop");
    this.k.d = paramBundle.getLong("gbottom");
    localObject = this.k;
    if (((a)localObject).a <= -20037508L) {
      ((a)localObject).a = -20037508L;
    }
    if (((a)localObject).b >= 20037508L) {
      ((a)localObject).b = 20037508L;
    }
    if (((a)localObject).c >= 20037508L) {
      ((a)localObject).c = 20037508L;
    }
    if (((a)localObject).d <= -20037508L) {
      ((a)localObject).d = -20037508L;
    }
    Point localPoint = ((a)localObject).e;
    double d2 = ((a)localObject).a;
    localPoint.doubleX = d2;
    double d1 = ((a)localObject).d;
    localPoint.doubleY = d1;
    localPoint = ((a)localObject).f;
    localPoint.doubleX = d2;
    d2 = ((a)localObject).c;
    localPoint.doubleY = d2;
    localPoint = ((a)localObject).g;
    double d3 = ((a)localObject).b;
    localPoint.doubleX = d3;
    localPoint.doubleY = d2;
    localObject = ((a)localObject).h;
    ((Point)localObject).doubleX = d3;
    ((Point)localObject).doubleY = d1;
    i1 = paramBundle.getInt("bfpp");
    boolean bool2 = false;
    if (i1 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.l = bool1;
    this.m = paramBundle.getFloat("adapterZoomUnits");
    paramBundle.getDouble("zoomunit");
    this.o = paramBundle.getString("panoid");
    this.p = paramBundle.getFloat("siangle");
    boolean bool1 = bool2;
    if (paramBundle.getInt("isbirdeye") != 0) {
      bool1 = true;
    }
    this.q = bool1;
    this.r = paramBundle.getInt("ssext");
  }
  
  public class a
  {
    public long a = 0L;
    public long b = 0L;
    public long c = 0L;
    public long d = 0L;
    public Point e = new Point(0, 0);
    public Point f = new Point(0, 0);
    public Point g = new Point(0, 0);
    public Point h = new Point(0, 0);
    
    public a() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapsdkplatform.comapi.map.s
 * JD-Core Version:    0.7.0.1
 */