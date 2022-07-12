package androidx.camera.camera2.internal;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.utils.b;
import androidx.camera.core.n1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import n.f;
import n.m0;
import n.z;
import q.d;
import q.e;
import q.n;
import q.q;
import s.a;
import s.h1;
import s.j1;
import s.l2;
import s.l2.a;
import s.l2.b;
import s.m2;
import s.t2;
import x0.h;

final class k2
{
  private static final Size q = new Size(640, 480);
  private static final Size r = new Size(0, 0);
  private static final Size s = new Size(1920, 1080);
  private static final Size t = new Size(720, 480);
  private static final Rational u = new Rational(4, 3);
  private static final Rational v = new Rational(3, 4);
  private static final Rational w = new Rational(16, 9);
  private static final Rational x = new Rational(9, 16);
  private final List<s.k2> a = new ArrayList();
  private final Map<Integer, Size> b = new HashMap();
  private final String c;
  private final c d;
  private final z e;
  private final d f;
  private final e g;
  private final int h;
  private final boolean i;
  private final Map<Integer, List<Size>> j = new HashMap();
  private boolean k = false;
  private boolean l = false;
  private m2 m;
  private Map<Integer, Size[]> n = new HashMap();
  private final x1 o;
  private final n p = new n();
  
  k2(Context paramContext, String paramString, m0 paramm0, c paramc)
  {
    String str = (String)h.g(paramString);
    this.c = str;
    this.d = ((c)h.g(paramc));
    this.f = new d(paramString);
    this.g = new e();
    this.o = x1.b(paramContext);
    for (;;)
    {
      try
      {
        paramContext = paramm0.c(str);
        this.e = paramContext;
        paramContext = (Integer)paramContext.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (paramContext != null)
        {
          i1 = paramContext.intValue();
          this.h = i1;
          this.i = H();
          h();
          i();
          a();
          return;
        }
      }
      catch (f paramContext)
      {
        throw l1.a(paramContext);
      }
      int i1 = 2;
    }
  }
  
  private Rational A(j1 paramj1)
  {
    int i1 = new q().a(this.c, this.e);
    Size localSize;
    if (i1 != 0) {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return null;
          }
          localSize = B(paramj1);
          if (paramj1.m())
          {
            i1 = paramj1.o();
            if (i1 != 0)
            {
              if (i1 != 1)
              {
                paramj1 = new StringBuilder();
                paramj1.append("Undefined target aspect ratio: ");
                paramj1.append(i1);
                n1.c("SupportedSurfaceCombination", paramj1.toString());
                return null;
              }
              if (!this.i) {
                break label183;
              }
              break label176;
            }
            if (!this.i) {
              break label204;
            }
            break label197;
          }
        }
      }
    }
    for (;;)
    {
      return paramj1;
      if (localSize == null) {
        break;
      }
      return new Rational(localSize.getWidth(), localSize.getHeight());
      paramj1 = f(256);
      return new Rational(paramj1.getWidth(), paramj1.getHeight());
      if (this.i)
      {
        label176:
        paramj1 = w;
      }
      else
      {
        label183:
        paramj1 = x;
        continue;
        if (this.i) {
          label197:
          paramj1 = u;
        } else {
          label204:
          paramj1 = v;
        }
      }
    }
    return null;
  }
  
  private Size B(j1 paramj1)
  {
    int i1 = paramj1.D(0);
    return g(paramj1.z(null), i1);
  }
  
  private List<Integer> C(List<t2<?>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    Iterator localIterator = paramList.iterator();
    int i1;
    while (localIterator.hasNext())
    {
      i1 = ((t2)localIterator.next()).n(0);
      if (!((List)localObject).contains(Integer.valueOf(i1))) {
        ((List)localObject).add(Integer.valueOf(i1));
      }
    }
    Collections.sort((List)localObject);
    Collections.reverse((List)localObject);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      i1 = ((Integer)((Iterator)localObject).next()).intValue();
      localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        t2 localt2 = (t2)localIterator.next();
        if (i1 == localt2.n(0)) {
          localArrayList.add(Integer.valueOf(paramList.indexOf(localt2)));
        }
      }
    }
    return localArrayList;
  }
  
  private Map<Rational, List<Size>> D(List<Size> paramList)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(u, new ArrayList());
    localHashMap.put(w, new ArrayList());
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      Size localSize = (Size)localIterator1.next();
      paramList = null;
      Iterator localIterator2 = localHashMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        Rational localRational = (Rational)localIterator2.next();
        if (E(localSize, localRational))
        {
          paramList = (List)localHashMap.get(localRational);
          if (!paramList.contains(localSize)) {
            paramList.add(localSize);
          }
          paramList = localRational;
        }
      }
      if (paramList == null) {
        localHashMap.put(new Rational(localSize.getWidth(), localSize.getHeight()), new ArrayList(Collections.singleton(localSize)));
      }
    }
    return localHashMap;
  }
  
  static boolean E(Size paramSize, Rational paramRational)
  {
    boolean bool = false;
    if (paramRational == null) {
      return false;
    }
    if (paramRational.equals(new Rational(paramSize.getWidth(), paramSize.getHeight()))) {
      return true;
    }
    if (l(paramSize) >= l(q)) {
      bool = F(paramSize, paramRational);
    }
    return bool;
  }
  
  private static boolean F(Size paramSize, Rational paramRational)
  {
    int i1 = paramSize.getWidth();
    int i2 = paramSize.getHeight();
    paramSize = new Rational(paramRational.getDenominator(), paramRational.getNumerator());
    int i3 = i1 % 16;
    boolean bool = false;
    if ((i3 == 0) && (i2 % 16 == 0))
    {
      if ((I(Math.max(0, i2 - 16), i1, paramRational)) || (I(Math.max(0, i1 - 16), i2, paramSize))) {
        bool = true;
      }
      return bool;
    }
    if (i3 == 0) {
      return I(i2, i1, paramRational);
    }
    if (i2 % 16 == 0) {
      return I(i1, i2, paramSize);
    }
    return false;
  }
  
  private boolean G(int paramInt)
  {
    Integer localInteger1 = (Integer)this.e.a(CameraCharacteristics.SENSOR_ORIENTATION);
    h.h(localInteger1, "Camera HAL in bad state, unable to retrieve the SENSOR_ORIENTATION");
    paramInt = b.b(paramInt);
    Integer localInteger2 = (Integer)this.e.a(CameraCharacteristics.LENS_FACING);
    h.h(localInteger2, "Camera HAL in bad state, unable to retrieve the LENS_FACING");
    int i1 = localInteger2.intValue();
    boolean bool2 = false;
    boolean bool1;
    if (1 == i1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramInt = b.a(paramInt, localInteger1.intValue(), bool1);
    if (paramInt != 90)
    {
      bool1 = bool2;
      if (paramInt != 270) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private boolean H()
  {
    Size localSize = (Size)this.e.a(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
    boolean bool = true;
    if (localSize != null)
    {
      if (localSize.getWidth() >= localSize.getHeight()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private static boolean I(int paramInt1, int paramInt2, Rational paramRational)
  {
    boolean bool;
    if (paramInt2 % 16 == 0) {
      bool = true;
    } else {
      bool = false;
    }
    h.a(bool);
    double d1 = paramInt1 * paramRational.getNumerator() / paramRational.getDenominator();
    return (d1 > Math.max(0, paramInt2 - 16)) && (d1 < paramInt2 + 16);
  }
  
  private void J()
  {
    this.o.e();
    if (this.m == null)
    {
      i();
      return;
    }
    Size localSize = this.o.d();
    this.m = m2.a(this.m.b(), localSize, this.m.d());
  }
  
  private void K(List<Size> paramList, Size paramSize)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      int i2 = -1;
      ArrayList localArrayList = new ArrayList();
      int i3;
      for (int i1 = 0; i1 < paramList.size(); i1 = i3)
      {
        Size localSize = (Size)paramList.get(i1);
        if ((localSize.getWidth() < paramSize.getWidth()) || (localSize.getHeight() < paramSize.getHeight())) {
          break;
        }
        if (i2 >= 0) {
          localArrayList.add((Size)paramList.get(i2));
        }
        i3 = i1 + 1;
        i2 = i1;
      }
      paramList.removeAll(localArrayList);
    }
  }
  
  private void a() {}
  
  private Size[] c(int paramInt)
  {
    Object localObject = (StreamConfigurationMap)this.e.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (localObject != null)
    {
      localObject = ((StreamConfigurationMap)localObject).getOutputSizes(paramInt);
      if (localObject != null)
      {
        localObject = d((Size[])localObject, paramInt);
        Arrays.sort((Object[])localObject, new androidx.camera.core.impl.utils.c(true));
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Can not get supported output size for the format: ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
  }
  
  private Size[] d(Size[] paramArrayOfSize, int paramInt)
  {
    List localList = e(paramInt);
    paramArrayOfSize = new ArrayList(Arrays.asList(paramArrayOfSize));
    paramArrayOfSize.removeAll(localList);
    return (Size[])paramArrayOfSize.toArray(new Size[0]);
  }
  
  private List<Size> e(int paramInt)
  {
    List localList2 = (List)this.j.get(Integer.valueOf(paramInt));
    List localList1 = localList2;
    if (localList2 == null)
    {
      localList1 = this.f.a(paramInt);
      this.j.put(Integer.valueOf(paramInt), localList1);
    }
    return localList1;
  }
  
  private Size f(int paramInt)
  {
    Size localSize = (Size)this.b.get(Integer.valueOf(paramInt));
    if (localSize != null) {
      return localSize;
    }
    localSize = t(paramInt);
    this.b.put(Integer.valueOf(paramInt), localSize);
    return localSize;
  }
  
  private Size g(Size paramSize, int paramInt)
  {
    Size localSize = paramSize;
    if (paramSize != null)
    {
      localSize = paramSize;
      if (G(paramInt)) {
        localSize = new Size(paramSize.getHeight(), paramSize.getWidth());
      }
    }
    return localSize;
  }
  
  private void h()
  {
    this.a.addAll(q());
    int i1 = this.h;
    if ((i1 == 0) || (i1 == 1) || (i1 == 3)) {
      this.a.addAll(s());
    }
    i1 = this.h;
    if ((i1 == 1) || (i1 == 3)) {
      this.a.addAll(p());
    }
    int[] arrayOfInt = (int[])this.e.a(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
    if (arrayOfInt != null)
    {
      int i2 = arrayOfInt.length;
      i1 = 0;
      while (i1 < i2)
      {
        int i3 = arrayOfInt[i1];
        if (i3 == 3) {
          this.k = true;
        } else if (i3 == 6) {
          this.l = true;
        }
        i1 += 1;
      }
    }
    if (this.k) {
      this.a.addAll(u());
    }
    if ((this.l) && (this.h == 0)) {
      this.a.addAll(m());
    }
    if (this.h == 3) {
      this.a.addAll(r());
    }
    this.a.addAll(this.g.a(this.c, this.h));
  }
  
  private void i()
  {
    this.m = m2.a(new Size(640, 480), this.o.d(), v());
  }
  
  private Size[] j(int paramInt)
  {
    Size[] arrayOfSize2 = (Size[])this.n.get(Integer.valueOf(paramInt));
    Size[] arrayOfSize1 = arrayOfSize2;
    if (arrayOfSize2 == null)
    {
      arrayOfSize1 = c(paramInt);
      this.n.put(Integer.valueOf(paramInt), arrayOfSize1);
    }
    return arrayOfSize1;
  }
  
  private List<List<Size>> k(List<List<Size>> paramList)
  {
    Object localObject = paramList.iterator();
    int i1 = 1;
    while (((Iterator)localObject).hasNext()) {
      i1 *= ((List)((Iterator)localObject).next()).size();
    }
    if (i1 != 0)
    {
      localObject = new ArrayList();
      int i2 = 0;
      while (i2 < i1)
      {
        ((List)localObject).add(new ArrayList());
        i2 += 1;
      }
      i2 = i1 / ((List)paramList.get(0)).size();
      int i4 = i1;
      int i3 = 0;
      while (i3 < paramList.size())
      {
        List localList = (List)paramList.get(i3);
        int i5 = 0;
        while (i5 < i1)
        {
          ((List)((List)localObject).get(i5)).add((Size)localList.get(i5 % i4 / i2));
          i5 += 1;
        }
        i5 = i2;
        if (i3 < paramList.size() - 1)
        {
          i5 = i2 / ((List)paramList.get(i3 + 1)).size();
          i4 = i2;
        }
        i3 += 1;
        i2 = i5;
      }
      return localObject;
    }
    throw new IllegalArgumentException("Failed to find supported resolutions.");
  }
  
  private static int l(Size paramSize)
  {
    return paramSize.getWidth() * paramSize.getHeight();
  }
  
  private l2.b n(int paramInt)
  {
    if (paramInt == 35) {
      return l2.b.b;
    }
    if (paramInt == 256) {
      return l2.b.c;
    }
    if (paramInt == 32) {
      return l2.b.d;
    }
    return l2.b.a;
  }
  
  private Size[] o(int paramInt, j1 paramj1)
  {
    Object localObject1 = null;
    Object localObject2 = paramj1.l(null);
    paramj1 = (j1)localObject1;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      do
      {
        paramj1 = (j1)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramj1 = (Pair)((Iterator)localObject2).next();
      } while (((Integer)paramj1.first).intValue() != paramInt);
      paramj1 = (Size[])paramj1.second;
    }
    localObject1 = paramj1;
    if (paramj1 != null)
    {
      localObject1 = d(paramj1, paramInt);
      Arrays.sort((Object[])localObject1, new androidx.camera.core.impl.utils.c(true));
    }
    return localObject1;
  }
  
  private Size v()
  {
    try
    {
      int i1 = Integer.parseInt(this.c);
      CamcorderProfile localCamcorderProfile = null;
      if (this.d.b(i1, 1)) {
        localCamcorderProfile = this.d.a(i1, 1);
      }
      if (localCamcorderProfile != null) {
        return new Size(localCamcorderProfile.videoFrameWidth, localCamcorderProfile.videoFrameHeight);
      }
      return w(i1);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label62:
      break label62;
    }
    return x();
  }
  
  private Size w(int paramInt)
  {
    Size localSize = t;
    Object localObject = this.d;
    int i1 = 10;
    if (((c)localObject).b(paramInt, 10)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              localObject = this.d.a(paramInt, i1);
              break;
              localObject = this.d;
              i1 = 8;
            } while (((c)localObject).b(paramInt, 8));
            localObject = this.d;
            i1 = 12;
          } while (((c)localObject).b(paramInt, 12));
          localObject = this.d;
          i1 = 6;
        } while (((c)localObject).b(paramInt, 6));
        localObject = this.d;
        i1 = 5;
      } while (((c)localObject).b(paramInt, 5));
      localObject = this.d;
      i1 = 4;
    } while (((c)localObject).b(paramInt, 4));
    localObject = null;
    if (localObject != null) {
      localSize = new Size(((CamcorderProfile)localObject).videoFrameWidth, ((CamcorderProfile)localObject).videoFrameHeight);
    }
    return localSize;
  }
  
  private Size x()
  {
    Object localObject = (StreamConfigurationMap)this.e.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (localObject != null)
    {
      localObject = ((StreamConfigurationMap)localObject).getOutputSizes(MediaRecorder.class);
      if (localObject == null) {
        return t;
      }
      Arrays.sort((Object[])localObject, new androidx.camera.core.impl.utils.c(true));
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Size localSize1 = localObject[i1];
        int i3 = localSize1.getWidth();
        Size localSize2 = s;
        if ((i3 <= localSize2.getWidth()) && (localSize1.getHeight() <= localSize2.getHeight())) {
          return localSize1;
        }
        i1 += 1;
      }
      return t;
    }
    throw new IllegalArgumentException("Can not retrieve SCALER_STREAM_CONFIGURATION_MAP");
  }
  
  l2 L(int paramInt, Size paramSize)
  {
    l2.b localb = n(paramInt);
    l2.a locala = l2.a.f;
    Size localSize = f(paramInt);
    if (paramSize.getWidth() * paramSize.getHeight() <= this.m.b().getWidth() * this.m.b().getHeight()) {
      locala = l2.a.b;
    } else if (paramSize.getWidth() * paramSize.getHeight() <= this.m.c().getWidth() * this.m.c().getHeight()) {
      locala = l2.a.c;
    } else if (paramSize.getWidth() * paramSize.getHeight() <= this.m.d().getWidth() * this.m.d().getHeight()) {
      locala = l2.a.d;
    } else if (paramSize.getWidth() * paramSize.getHeight() <= localSize.getWidth() * localSize.getHeight()) {
      locala = l2.a.e;
    }
    return l2.a(localb, locala);
  }
  
  boolean b(List<l2> paramList)
  {
    Iterator localIterator = this.a.iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      boolean bool2 = ((s.k2)localIterator.next()).d(paramList);
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  List<s.k2> m()
  {
    ArrayList localArrayList = new ArrayList();
    s.k2 localk2 = new s.k2();
    l2.b localb = l2.b.a;
    l2.a locala1 = l2.a.c;
    localk2.a(l2.a(localb, locala1));
    l2.a locala2 = l2.a.e;
    localk2.a(l2.a(localb, locala2));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a(localb, locala1));
    localb = l2.b.b;
    localk2.a(l2.a(localb, locala2));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a(localb, locala1));
    localk2.a(l2.a(localb, locala2));
    localArrayList.add(localk2);
    return localArrayList;
  }
  
  List<s.k2> p()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new s.k2();
    Object localObject1 = l2.b.a;
    l2.a locala1 = l2.a.c;
    ((s.k2)localObject2).a(l2.a((l2.b)localObject1, locala1));
    l2.a locala2 = l2.a.e;
    ((s.k2)localObject2).a(l2.a((l2.b)localObject1, locala2));
    localArrayList.add(localObject2);
    Object localObject3 = new s.k2();
    ((s.k2)localObject3).a(l2.a((l2.b)localObject1, locala1));
    localObject2 = l2.b.b;
    ((s.k2)localObject3).a(l2.a((l2.b)localObject2, locala2));
    localArrayList.add(localObject3);
    localObject3 = new s.k2();
    ((s.k2)localObject3).a(l2.a((l2.b)localObject2, locala1));
    ((s.k2)localObject3).a(l2.a((l2.b)localObject2, locala2));
    localArrayList.add(localObject3);
    localObject3 = new s.k2();
    ((s.k2)localObject3).a(l2.a((l2.b)localObject1, locala1));
    ((s.k2)localObject3).a(l2.a((l2.b)localObject1, locala1));
    ((s.k2)localObject3).a(l2.a(l2.b.c, locala2));
    localArrayList.add(localObject3);
    s.k2 localk2 = new s.k2();
    localObject3 = l2.a.b;
    localk2.a(l2.a((l2.b)localObject2, (l2.a)localObject3));
    localk2.a(l2.a((l2.b)localObject1, locala1));
    localk2.a(l2.a((l2.b)localObject2, locala2));
    localArrayList.add(localk2);
    localObject1 = new s.k2();
    ((s.k2)localObject1).a(l2.a((l2.b)localObject2, (l2.a)localObject3));
    ((s.k2)localObject1).a(l2.a((l2.b)localObject2, locala1));
    ((s.k2)localObject1).a(l2.a((l2.b)localObject2, locala2));
    localArrayList.add(localObject1);
    return localArrayList;
  }
  
  List<s.k2> q()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new s.k2();
    l2.b localb = l2.b.a;
    l2.a locala = l2.a.e;
    ((s.k2)localObject1).a(l2.a(localb, locala));
    localArrayList.add(localObject1);
    Object localObject2 = new s.k2();
    localObject1 = l2.b.c;
    ((s.k2)localObject2).a(l2.a((l2.b)localObject1, locala));
    localArrayList.add(localObject2);
    Object localObject3 = new s.k2();
    localObject2 = l2.b.b;
    ((s.k2)localObject3).a(l2.a((l2.b)localObject2, locala));
    localArrayList.add(localObject3);
    s.k2 localk2 = new s.k2();
    localObject3 = l2.a.c;
    localk2.a(l2.a(localb, (l2.a)localObject3));
    localk2.a(l2.a((l2.b)localObject1, locala));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a((l2.b)localObject2, (l2.a)localObject3));
    localk2.a(l2.a((l2.b)localObject1, locala));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a(localb, (l2.a)localObject3));
    localk2.a(l2.a(localb, (l2.a)localObject3));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a(localb, (l2.a)localObject3));
    localk2.a(l2.a((l2.b)localObject2, (l2.a)localObject3));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a(localb, (l2.a)localObject3));
    localk2.a(l2.a((l2.b)localObject2, (l2.a)localObject3));
    localk2.a(l2.a((l2.b)localObject1, locala));
    localArrayList.add(localk2);
    return localArrayList;
  }
  
  List<s.k2> r()
  {
    ArrayList localArrayList = new ArrayList();
    s.k2 localk2 = new s.k2();
    l2.b localb1 = l2.b.a;
    l2.a locala1 = l2.a.c;
    localk2.a(l2.a(localb1, locala1));
    l2.a locala2 = l2.a.b;
    localk2.a(l2.a(localb1, locala2));
    l2.b localb2 = l2.b.b;
    l2.a locala3 = l2.a.e;
    localk2.a(l2.a(localb2, locala3));
    localb2 = l2.b.d;
    localk2.a(l2.a(localb2, locala3));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a(localb1, locala1));
    localk2.a(l2.a(localb1, locala2));
    localk2.a(l2.a(l2.b.c, locala3));
    localk2.a(l2.a(localb2, locala3));
    localArrayList.add(localk2);
    return localArrayList;
  }
  
  List<s.k2> s()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new s.k2();
    Object localObject1 = l2.b.a;
    l2.a locala1 = l2.a.c;
    ((s.k2)localObject2).a(l2.a((l2.b)localObject1, locala1));
    l2.a locala2 = l2.a.d;
    ((s.k2)localObject2).a(l2.a((l2.b)localObject1, locala2));
    localArrayList.add(localObject2);
    Object localObject3 = new s.k2();
    ((s.k2)localObject3).a(l2.a((l2.b)localObject1, locala1));
    localObject2 = l2.b.b;
    ((s.k2)localObject3).a(l2.a((l2.b)localObject2, locala2));
    localArrayList.add(localObject3);
    localObject3 = new s.k2();
    ((s.k2)localObject3).a(l2.a((l2.b)localObject2, locala1));
    ((s.k2)localObject3).a(l2.a((l2.b)localObject2, locala2));
    localArrayList.add(localObject3);
    s.k2 localk2 = new s.k2();
    localk2.a(l2.a((l2.b)localObject1, locala1));
    localk2.a(l2.a((l2.b)localObject1, locala2));
    localObject3 = l2.b.c;
    localk2.a(l2.a((l2.b)localObject3, locala2));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a((l2.b)localObject1, locala1));
    localk2.a(l2.a((l2.b)localObject2, locala2));
    localk2.a(l2.a((l2.b)localObject3, locala2));
    localArrayList.add(localk2);
    localObject1 = new s.k2();
    ((s.k2)localObject1).a(l2.a((l2.b)localObject2, locala1));
    ((s.k2)localObject1).a(l2.a((l2.b)localObject2, locala1));
    ((s.k2)localObject1).a(l2.a((l2.b)localObject3, l2.a.e));
    localArrayList.add(localObject1);
    return localArrayList;
  }
  
  Size t(int paramInt)
  {
    return (Size)Collections.max(Arrays.asList(j(paramInt)), new androidx.camera.core.impl.utils.c());
  }
  
  List<s.k2> u()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new s.k2();
    l2.b localb1 = l2.b.d;
    l2.a locala = l2.a.e;
    ((s.k2)localObject1).a(l2.a(localb1, locala));
    localArrayList.add(localObject1);
    Object localObject2 = new s.k2();
    l2.b localb2 = l2.b.a;
    localObject1 = l2.a.c;
    ((s.k2)localObject2).a(l2.a(localb2, (l2.a)localObject1));
    ((s.k2)localObject2).a(l2.a(localb1, locala));
    localArrayList.add(localObject2);
    s.k2 localk2 = new s.k2();
    localObject2 = l2.b.b;
    localk2.a(l2.a((l2.b)localObject2, (l2.a)localObject1));
    localk2.a(l2.a(localb1, locala));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a(localb2, (l2.a)localObject1));
    localk2.a(l2.a(localb2, (l2.a)localObject1));
    localk2.a(l2.a(localb1, locala));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a(localb2, (l2.a)localObject1));
    localk2.a(l2.a((l2.b)localObject2, (l2.a)localObject1));
    localk2.a(l2.a(localb1, locala));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a((l2.b)localObject2, (l2.a)localObject1));
    localk2.a(l2.a((l2.b)localObject2, (l2.a)localObject1));
    localk2.a(l2.a(localb1, locala));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a(localb2, (l2.a)localObject1));
    localb2 = l2.b.c;
    localk2.a(l2.a(localb2, locala));
    localk2.a(l2.a(localb1, locala));
    localArrayList.add(localk2);
    localk2 = new s.k2();
    localk2.a(l2.a((l2.b)localObject2, (l2.a)localObject1));
    localk2.a(l2.a(localb2, locala));
    localk2.a(l2.a(localb1, locala));
    localArrayList.add(localk2);
    return localArrayList;
  }
  
  Map<t2<?>, Size> y(List<a> paramList, List<t2<?>> paramList1)
  {
    J();
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((a)((Iterator)localObject2).next()).d());
    }
    localObject2 = paramList1.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(L(((t2)((Iterator)localObject2).next()).q(), new Size(640, 480)));
    }
    if (b((List)localObject1))
    {
      List localList1 = C(paramList1);
      localObject1 = new ArrayList();
      localObject2 = localList1.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(z((t2)paramList1.get(((Integer)((Iterator)localObject2).next()).intValue())));
      }
      localObject1 = k((List)localObject1);
      localObject2 = null;
      Iterator localIterator = ((List)localObject1).iterator();
      List localList2;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localList2 = (List)localIterator.next();
        localObject1 = new ArrayList();
        Object localObject3 = paramList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((List)localObject1).add(((a)((Iterator)localObject3).next()).d());
        }
        int i1 = 0;
        while (i1 < localList2.size())
        {
          localObject3 = (Size)localList2.get(i1);
          ((List)localObject1).add(L(((t2)paramList1.get(((Integer)localList1.get(i1)).intValue())).q(), (Size)localObject3));
          i1 += 1;
        }
      } while (!b((List)localObject1));
      localObject2 = new HashMap();
      localIterator = paramList1.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (t2)localIterator.next();
        ((Map)localObject2).put(localObject1, (Size)localList2.get(localList1.indexOf(Integer.valueOf(paramList1.indexOf(localObject1)))));
      }
      if (localObject1 != null) {
        return localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("No supported surface combination is found for camera device - Id : ");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append(" and Hardware level: ");
      ((StringBuilder)localObject1).append(this.h);
      ((StringBuilder)localObject1).append(". May be the specified resolution is too large and not supported. Existing surfaces: ");
      ((StringBuilder)localObject1).append(paramList);
      ((StringBuilder)localObject1).append(" New configs: ");
      ((StringBuilder)localObject1).append(paramList1);
      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("No supported surface combination is found for camera device - Id : ");
    ((StringBuilder)localObject1).append(this.c);
    ((StringBuilder)localObject1).append(".  May be attempting to bind too many use cases. Existing surfaces: ");
    ((StringBuilder)localObject1).append(paramList);
    ((StringBuilder)localObject1).append(" New configs: ");
    ((StringBuilder)localObject1).append(paramList1);
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  List<Size> z(t2<?> paramt2)
  {
    int i2 = paramt2.q();
    j1 localj1 = (j1)paramt2;
    Object localObject1 = o(i2, localj1);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = j(i2);
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = localj1.f(null);
    Object localObject4 = t(i2);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = localObject1;
      if (l((Size)localObject4) >= l((Size)localObject1)) {}
    }
    else
    {
      localObject3 = localObject4;
    }
    Arrays.sort((Object[])localObject2, new androidx.camera.core.impl.utils.c(true));
    localObject4 = B(localj1);
    Object localObject5 = q;
    int i1 = l((Size)localObject5);
    if (l((Size)localObject3) < i1)
    {
      localObject1 = r;
    }
    else
    {
      localObject1 = localObject5;
      if (localObject4 != null)
      {
        localObject1 = localObject5;
        if (l((Size)localObject4) < i1) {
          localObject1 = localObject4;
        }
      }
    }
    int i3 = localObject2.length;
    i1 = 0;
    while (i1 < i3)
    {
      localObject5 = localObject2[i1];
      if ((l((Size)localObject5) <= l((Size)localObject3)) && (l((Size)localObject5) >= l((Size)localObject1)) && (!localArrayList.contains(localObject5))) {
        localArrayList.add(localObject5);
      }
      i1 += 1;
    }
    if (!localArrayList.isEmpty())
    {
      localObject2 = A(localj1);
      localObject1 = localObject4;
      if (localObject4 == null) {
        localObject1 = localj1.u(null);
      }
      localObject3 = new ArrayList();
      new HashMap();
      if (localObject2 == null)
      {
        ((List)localObject3).addAll(localArrayList);
        if (localObject1 != null) {
          K((List)localObject3, (Size)localObject1);
        }
      }
      else
      {
        localObject4 = D(localArrayList);
        if (localObject1 != null)
        {
          localObject5 = ((Map)localObject4).keySet().iterator();
          while (((Iterator)localObject5).hasNext()) {
            K((List)((Map)localObject4).get((Rational)((Iterator)localObject5).next()), (Size)localObject1);
          }
        }
        localObject1 = new ArrayList(((Map)localObject4).keySet());
        Collections.sort((List)localObject1, new a((Rational)localObject2));
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((List)((Map)localObject4).get((Rational)((Iterator)localObject1).next())).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject5 = (Size)((Iterator)localObject2).next();
            if (!((List)localObject3).contains(localObject5)) {
              ((List)localObject3).add(localObject5);
            }
          }
        }
      }
      return this.p.a(n(paramt2.q()), (List)localObject3);
    }
    paramt2 = new StringBuilder();
    paramt2.append("Can not get supported output size under supported maximum for the format: ");
    paramt2.append(i2);
    throw new IllegalArgumentException(paramt2.toString());
  }
  
  static final class a
    implements Comparator<Rational>
  {
    private Rational a;
    
    a(Rational paramRational)
    {
      this.a = paramRational;
    }
    
    public int a(Rational paramRational1, Rational paramRational2)
    {
      if (paramRational1.equals(paramRational2)) {
        return 0;
      }
      float f1 = Math.abs(paramRational1.floatValue() - this.a.floatValue());
      float f2 = Math.abs(paramRational2.floatValue() - this.a.floatValue());
      return (int)Math.signum(Float.valueOf(f1).floatValue() - Float.valueOf(f2).floatValue());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.camera.camera2.internal.k2
 * JD-Core Version:    0.7.0.1
 */