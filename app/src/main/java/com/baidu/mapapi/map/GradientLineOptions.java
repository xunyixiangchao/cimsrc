package com.baidu.mapapi.map;

import com.baidu.mapapi.model.LatLng;
import java.util.Iterator;
import java.util.List;

public class GradientLineOptions
  extends OverlayOptions
{
  private List<LatLng> a;
  private List<Integer> b;
  private List<Integer> c;
  private int d = 5;
  private boolean e = true;
  private LineDirectionCross180 f = LineDirectionCross180.NONE;
  
  Overlay a()
  {
    GradientLine localGradientLine = new GradientLine();
    localGradientLine.h = this.d;
    localGradientLine.c = this.e;
    localGradientLine.i = this.f;
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() >= 2))
    {
      localGradientLine.e = this.a;
      localObject = this.c;
      if (localObject != null)
      {
        if (((List)localObject).size() != 0)
        {
          localObject = new int[this.c.size()];
          Iterator localIterator = this.c.iterator();
          int j = 0;
          int i = 0;
          while (localIterator.hasNext())
          {
            localObject[i] = ((Integer)localIterator.next()).intValue();
            i += 1;
          }
          localGradientLine.g = ((int[])localObject);
          localObject = this.b;
          if (localObject != null)
          {
            if (((List)localObject).size() != 0)
            {
              localObject = new int[this.b.size()];
              localIterator = this.b.iterator();
              i = j;
              while (localIterator.hasNext())
              {
                localObject[i] = ((Integer)localIterator.next()).intValue();
                i += 1;
              }
              localGradientLine.f = ((int[])localObject);
              return localGradientLine;
            }
            throw new IllegalStateException("BDMapSDKException: Indexs list size can not be Equal to zero");
          }
          throw new IllegalStateException("BDMapSDKException: Indexs list can not be null");
        }
        throw new IllegalStateException("BDMapSDKException: colors list size can not be Equal to zero");
      }
      throw new IllegalStateException("BDMapSDKException: colors list can not be null");
    }
    throw new IllegalStateException("BDMapSDKException: when you add GradientLine, you must at least supply 2 points");
  }
  
  public List<Integer> getColors()
  {
    return this.c;
  }
  
  public List<Integer> getIndexs()
  {
    return this.b;
  }
  
  public LineDirectionCross180 getLineDirectionCross180()
  {
    return this.f;
  }
  
  public List<LatLng> getPoints()
  {
    return this.a;
  }
  
  public int getWidth()
  {
    return this.d;
  }
  
  public boolean isVisible()
  {
    return this.e;
  }
  
  public GradientLineOptions setColorIndex(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (!paramList.contains(null))
      {
        if (paramList.size() != 0)
        {
          this.b = paramList;
          return this;
        }
        throw new IllegalStateException("BDMapSDKException: indexs list size can not be Equal to zero");
      }
      throw new IllegalArgumentException("BDMapSDKException: indexs list can not contains null");
    }
    throw new IllegalArgumentException("BDMapSDKException: indexs list can not be null");
  }
  
  public GradientLineOptions setColorsValues(List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (!paramList.contains(null))
      {
        if (paramList.size() != 0)
        {
          this.c = paramList;
          return this;
        }
        throw new IllegalStateException("BDMapSDKException: colors list list size can not be Equal to zero");
      }
      throw new IllegalArgumentException("BDMapSDKException: colors list can not contains null");
    }
    throw new IllegalArgumentException("BDMapSDKException: colors list can not be null");
  }
  
  public GradientLineOptions setLineDirectionCross180(LineDirectionCross180 paramLineDirectionCross180)
  {
    this.f = paramLineDirectionCross180;
    return this;
  }
  
  public GradientLineOptions setPoints(List<LatLng> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 2)
      {
        if (!paramList.contains(null))
        {
          this.a = paramList;
          return this;
        }
        throw new IllegalArgumentException("BDMapSDKException: points list can not contains null");
      }
      throw new IllegalArgumentException("BDMapSDKException: points count can not less than 2");
    }
    throw new IllegalArgumentException("BDMapSDKException: points list can not be null");
  }
  
  public GradientLineOptions setWidth(int paramInt)
  {
    if (paramInt > 0) {
      this.d = paramInt;
    }
    return this;
  }
  
  public GradientLineOptions visible(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public static enum LineDirectionCross180
  {
    static
    {
      LineDirectionCross180 localLineDirectionCross1801 = new LineDirectionCross180("NONE", 0);
      NONE = localLineDirectionCross1801;
      LineDirectionCross180 localLineDirectionCross1802 = new LineDirectionCross180("FROM_EAST_TO_WEST", 1);
      FROM_EAST_TO_WEST = localLineDirectionCross1802;
      LineDirectionCross180 localLineDirectionCross1803 = new LineDirectionCross180("FROM_WEST_TO_EAST", 2);
      FROM_WEST_TO_EAST = localLineDirectionCross1803;
      a = new LineDirectionCross180[] { localLineDirectionCross1801, localLineDirectionCross1802, localLineDirectionCross1803 };
    }
    
    private LineDirectionCross180() {}
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.GradientLineOptions
 * JD-Core Version:    0.7.0.1
 */