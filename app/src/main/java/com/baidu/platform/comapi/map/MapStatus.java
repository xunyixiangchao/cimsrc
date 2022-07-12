package com.baidu.platform.comapi.map;

import java.io.Serializable;

public class MapStatus
  implements Serializable
{
  public int animationTime;
  public int animationType = 0;
  public boolean bOverlookSpringback;
  public boolean bfpp;
  public double centerPtX;
  public double centerPtY;
  public double centerPtZ;
  public GeoBound geoRound;
  public int hasAnimation;
  public boolean isBirdEye;
  public float level;
  public int minOverlooking;
  public int overlooking;
  public String panoId;
  public float roadOffsetX;
  public float roadOffsetY;
  public int rotation;
  public int streetExt;
  public float streetIndicateAngle;
  public WinRound winRound;
  public float xOffset;
  public float xScreenOffset;
  public float yOffset;
  public float yScreenOffset;
  
  public MapStatus()
  {
    this.level = -1.0F;
    this.rotation = -1;
    this.overlooking = -1;
    this.centerPtX = -1.0D;
    this.centerPtY = -1.0D;
    this.centerPtZ = 0.0D;
    this.xOffset = 0.0F;
    this.yOffset = 0.0F;
    this.winRound = new WinRound();
    this.geoRound = new GeoBound();
    this.bfpp = false;
    this.panoId = "";
    this.streetIndicateAngle = 0.0F;
    this.isBirdEye = false;
    this.streetExt = 0;
    this.roadOffsetX = 0.0F;
    this.roadOffsetY = 0.0F;
    this.bOverlookSpringback = false;
    this.minOverlooking = -1;
    this.xScreenOffset = 0.0F;
    this.yScreenOffset = 0.0F;
  }
  
  public MapStatus(MapStatus paramMapStatus)
  {
    this.level = paramMapStatus.level;
    this.rotation = paramMapStatus.rotation;
    this.overlooking = paramMapStatus.overlooking;
    this.centerPtX = paramMapStatus.centerPtX;
    this.centerPtY = paramMapStatus.centerPtY;
    this.centerPtZ = paramMapStatus.centerPtZ;
    this.xOffset = paramMapStatus.xOffset;
    this.yOffset = paramMapStatus.yOffset;
    this.winRound = paramMapStatus.winRound;
    this.geoRound = paramMapStatus.geoRound;
    this.bfpp = paramMapStatus.bfpp;
    this.panoId = paramMapStatus.panoId;
    this.streetIndicateAngle = paramMapStatus.streetIndicateAngle;
    this.isBirdEye = paramMapStatus.isBirdEye;
    this.streetExt = paramMapStatus.streetExt;
    this.roadOffsetX = paramMapStatus.roadOffsetX;
    this.roadOffsetY = paramMapStatus.roadOffsetY;
    this.bOverlookSpringback = paramMapStatus.bOverlookSpringback;
    this.minOverlooking = paramMapStatus.minOverlooking;
    this.xScreenOffset = paramMapStatus.xScreenOffset;
    this.yScreenOffset = paramMapStatus.yScreenOffset;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MapStatus)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    paramObject = (MapStatus)paramObject;
    if (this.centerPtX != paramObject.centerPtX) {
      return false;
    }
    if (this.centerPtY != paramObject.centerPtY) {
      return false;
    }
    if (this.centerPtZ != paramObject.centerPtZ) {
      return false;
    }
    if (this.bfpp != paramObject.bfpp) {
      return false;
    }
    Object localObject = this.geoRound;
    if (localObject == null)
    {
      if (paramObject.geoRound != null) {
        return false;
      }
    }
    else if (!((GeoBound)localObject).equals(paramObject.geoRound)) {
      return false;
    }
    if (Float.floatToIntBits(this.level) != Float.floatToIntBits(paramObject.level)) {
      return false;
    }
    if (this.overlooking != paramObject.overlooking) {
      return false;
    }
    if (this.rotation != paramObject.rotation) {
      return false;
    }
    if (this.yOffset != paramObject.yOffset) {
      return false;
    }
    if (this.xOffset != paramObject.xOffset) {
      return false;
    }
    if (this.xScreenOffset != paramObject.xScreenOffset) {
      return false;
    }
    if (this.yScreenOffset != paramObject.yScreenOffset) {
      return false;
    }
    localObject = this.winRound;
    paramObject = paramObject.winRound;
    if (localObject == null)
    {
      if (paramObject != null) {
        return false;
      }
    }
    else if (!((WinRound)localObject).equals(paramObject)) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MapStatus{level=");
    localStringBuilder.append(this.level);
    localStringBuilder.append(", rotation=");
    localStringBuilder.append(this.rotation);
    localStringBuilder.append(", overlooking=");
    localStringBuilder.append(this.overlooking);
    localStringBuilder.append(", centerPtX=");
    localStringBuilder.append(this.centerPtX);
    localStringBuilder.append(", centerPtY=");
    localStringBuilder.append(this.centerPtY);
    localStringBuilder.append(", centerPtZ=");
    localStringBuilder.append(this.centerPtZ);
    localStringBuilder.append(", winRound=");
    localStringBuilder.append(this.winRound);
    localStringBuilder.append(", geoRound=");
    localStringBuilder.append(this.geoRound);
    localStringBuilder.append(", xOffset=");
    localStringBuilder.append(this.xOffset);
    localStringBuilder.append(", yOffset=");
    localStringBuilder.append(this.yOffset);
    localStringBuilder.append(", bfpp=");
    localStringBuilder.append(this.bfpp);
    localStringBuilder.append(", panoId='");
    localStringBuilder.append(this.panoId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", streetIndicateAngle=");
    localStringBuilder.append(this.streetIndicateAngle);
    localStringBuilder.append(", isBirdEye=");
    localStringBuilder.append(this.isBirdEye);
    localStringBuilder.append(", streetExt=");
    localStringBuilder.append(this.streetExt);
    localStringBuilder.append(", roadOffsetX=");
    localStringBuilder.append(this.roadOffsetX);
    localStringBuilder.append(", roadOffsetY=");
    localStringBuilder.append(this.roadOffsetY);
    localStringBuilder.append(", xScreenOffset=");
    localStringBuilder.append(this.xScreenOffset);
    localStringBuilder.append(", yScreenOffset=");
    localStringBuilder.append(this.yScreenOffset);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class GeoBound
    implements Serializable
  {
    public long bottom = 0L;
    public long left = 0L;
    public long right = 0L;
    public long top = 0L;
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof GeoBound)) {
        return false;
      }
      paramObject = (GeoBound)paramObject;
      if (this.bottom != paramObject.bottom) {
        return false;
      }
      if (this.left != paramObject.left) {
        return false;
      }
      if (this.right != paramObject.right) {
        return false;
      }
      return this.top == paramObject.top;
    }
    
    public int hashCode()
    {
      long l = this.bottom;
      int i = (int)(l ^ l >>> 32);
      l = this.left;
      int j = (int)(l ^ l >>> 32);
      l = this.right;
      int k = (int)(l ^ l >>> 32);
      l = this.top;
      return (((i + 31) * 31 + j) * 31 + k) * 31 + (int)(l >>> 32 ^ l);
    }
  }
  
  public static class WinRound
    implements Serializable
  {
    public int bottom = 0;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof WinRound)) {
        return false;
      }
      paramObject = (WinRound)paramObject;
      if (this.bottom != paramObject.bottom) {
        return false;
      }
      if (this.left != paramObject.left) {
        return false;
      }
      if (this.right != paramObject.right) {
        return false;
      }
      return this.top == paramObject.top;
    }
    
    public int hashCode()
    {
      return (((this.bottom + 31) * 31 + this.left) * 31 + this.right) * 31 + this.top;
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.platform.comapi.map.MapStatus
 * JD-Core Version:    0.7.0.1
 */