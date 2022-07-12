package com.baidu.location.e;

import java.util.Iterator;
import java.util.LinkedList;

public class e
{
  private static e a;
  private static final double[] b = { 110.38964799999999D, 105.070224D, 96.898844999999994D, 95.617052999999999D, 93.822557000000003D, 91.387164999999996D, 91.387164999999996D, 89.079901000000007D, 87.221340999999995D, 86.259996999999998D, 85.170461000000003D, 85.234525000000005D, 82.863260999999994D, 81.901916999999997D, 79.594684999999998D, 80.395797999999999D, 79.931141999999994D, 77.800173999999998D, 75.252622000000002D, 73.490157999999994D, 73.185732000000002D, 73.874699000000007D, 74.403435000000002D, 74.099002999999996D, 75.460904999999997D, 76.774739999999994D, 78.280851999999996D, 78.152659999999997D, 78.376980000000003D, 78.889700000000005D, 79.690817999999993D, 81.196914000000007D, 81.805762000000001D, 83.888673999999995D, 85.939537999999999D, 87.862215000000006D, 89.031846999999999D, 90.057287000000002D, 91.098741000000004D, 92.156212999999994D, 93.742420999999993D, 95.825333000000001D, 97.956327000000002D, 97.123142999999999D, 98.212678999999994D, 99.206055000000006D, 101.657471D, 102.52267000000001D, 102.23427D, 105.022158D, 106.095662D, 107.858116D, 111.639396D, 109.588503D, 112.280343D, 117.792023D, 118.945559D, 114.203031D, 118.689303D, 123.143466D, 122.72685799999999D, 120.93236899999999D, 123.415857D, 122.374385D, 122.13405400000001D, 121.586108D, 121.17271D, 120.676006D, 120.243409D, 122.790961D, 122.871076D, 121.300884D, 122.134052D, 123.736285D, 126.412019D, 128.55902699999999D, 129.712627D, 131.21870699999999D, 131.98779500000001D, 133.622084D, 135.60888D, 131.37899200000001D, 130.86622399999999D, 128.623088D, 126.091572D, 124.393204D, 122.214164D, 119.65058000000001D, 119.778772D, 118.561044D, 116.510192D, 114.811824D, 119.073776D, 116.446096D, 111.735536D, 110.38964799999999D };
  private static final double[] c = { 43.216754999999999D, 42.378596999999999D, 43.172612000000001D, 44.421188000000001D, 45.097507999999998D, 45.565731999999997D, 47.334547999999998D, 48.687187999999999D, 49.623620000000003D, 48.947316000000001D, 48.479092000000001D, 47.334547999999998D, 47.438595999999997D, 46.033940000000001D, 45.201555999999997D, 43.344095000000003D, 42.328662999999999D, 41.395882D, 40.829126000000002D, 39.955382D, 39.258747999999997D, 38.361381999999999D, 38.054394000000002D, 37.168841999999998D, 36.389552999999999D, 35.362313D, 34.311456999999997D, 32.587581D, 31.572149D, 30.781054999999999D, 30.438642000000002D, 29.777429999999999D, 30.096229999999998D, 28.714766000000001D, 27.71114D, 27.581257999999998D, 27.014503999999999D, 27.781984000000001D, 27.510414999999998D, 26.506786999999999D, 26.707512999999999D, 27.959095000000001D, 27.297879999999999D, 23.649404000000001D, 23.625789999999999D, 21.677574D, 20.780213D, 21.323353000000001D, 22.185290999999999D, 22.315173000000001D, 22.515896999999999D, 16.802288999999998D, 13.198973000000001D, 0.6933510000000001D, 1.541191D, 10.504054999999999D, 15.591094999999999D, 17.892375000000001D, 19.951383D, 22.187501000000001D, 25.375613000000001D, 25.617567999999999D, 30.627458000000001D, 31.082902000000001D, 31.894165999999998D, 32.503117000000003D, 32.805056D, 34.256784000000003D, 35.155304000000001D, 36.90119D, 37.834110000000003D, 37.940728D, 38.647080000000003D, 38.966937000000001D, 40.979374D, 41.253698D, 42.069802000000003D, 42.488880000000002D, 44.650449999999999D, 44.691251999999999D, 48.620679000000003D, 48.091310999999997D, 49.194150999999998D, 50.032311D, 53.274664999999999D, 53.627577000000002D, 53.892257000000001D, 52.987929000000001D, 52.017425000000003D, 50.230825000000003D, 50.186706999999998D, 47.495778999999999D, 47.341379000000003D, 46.503219000000001D, 45.245983000000003D, 43.216754999999999D };
  private LinkedList<b> d = null;
  
  private e()
  {
    int j = b.length;
    this.d = new LinkedList();
    int i = 0;
    while (i < j - 1)
    {
      LinkedList localLinkedList = this.d;
      double[] arrayOfDouble1 = b;
      double d1 = arrayOfDouble1[i];
      double[] arrayOfDouble2 = c;
      a locala = new a(d1 * 100000.0D, arrayOfDouble2[i] * 100000.0D);
      i += 1;
      localLinkedList.add(new b(locala, new a(arrayOfDouble1[i] * 100000.0D, arrayOfDouble2[i] * 100000.0D)));
    }
  }
  
  public static e a()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  int a(double paramDouble)
  {
    if (paramDouble < -1.0E-008D) {
      return -1;
    }
    if (paramDouble > 1.0E-008D) {
      return 1;
    }
    return 0;
  }
  
  public boolean a(double paramDouble1, double paramDouble2)
  {
    boolean bool = true;
    try
    {
      a locala = new a(paramDouble1 * 100000.0D, paramDouble2 * 100000.0D);
      Iterator localIterator = this.d.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb.b(locala)) {
          return true;
        }
        int k = a(localb.a(locala));
        int m = a(localb.a.b - locala.b);
        int n = a(localb.b.b - locala.b);
        int j = i;
        if (k > 0)
        {
          j = i;
          if (m <= 0)
          {
            j = i;
            if (n > 0) {
              j = i + 1;
            }
          }
        }
        i = j;
        if (k < 0)
        {
          i = j;
          if (n <= 0)
          {
            i = j;
            if (m > 0) {
              i = j - 1;
            }
          }
        }
      }
      if (i == 0) {
        bool = false;
      }
      return bool;
    }
    catch (Exception localException) {}
    return true;
  }
  
  class a
  {
    double a;
    double b;
    
    a(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }
  }
  
  class b
  {
    e.a a;
    e.a b;
    
    b(e.a parama1, e.a parama2)
    {
      this.a = parama1;
      this.b = parama2;
    }
    
    double a(e.a parama)
    {
      Object localObject1 = e.this;
      Object localObject2 = this.b;
      double d = ((e.a)localObject2).a;
      e.a locala = this.a;
      localObject1 = new e.a((e)localObject1, d - locala.a, ((e.a)localObject2).b - locala.b);
      localObject2 = e.this;
      d = parama.a;
      locala = this.a;
      parama = new e.a((e)localObject2, d - locala.a, parama.b - locala.b);
      return ((e.a)localObject1).a * parama.b - ((e.a)localObject1).b * parama.a;
    }
    
    boolean b(e.a parama)
    {
      return (e.this.a(a(parama)) == 0) && (parama.a < Math.max(this.a.a, this.b.a) + 1.0E-008D) && (parama.a > Math.min(this.a.a, this.b.a) - 1.0E-008D) && (parama.b < Math.max(this.a.b, this.b.b) + 1.0E-008D) && (parama.b > Math.min(this.a.b, this.b.b) - 1.0E-008D);
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.location.e.e
 * JD-Core Version:    0.7.0.1
 */