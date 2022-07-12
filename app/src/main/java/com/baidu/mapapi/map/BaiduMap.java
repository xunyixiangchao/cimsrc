package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.track.TraceAnimationListener;
import com.baidu.mapapi.map.track.TraceOptions;
import com.baidu.mapapi.map.track.TraceOverlay;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapsdkplatform.comapi.commonutils.b;
import com.baidu.mapsdkplatform.comapi.map.e;
import com.baidu.mapsdkplatform.comapi.map.i;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mapsdkplatform.comapi.map.s;
import com.baidu.mapsdkplatform.comapi.map.w;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.g;
import com.baidu.platform.comapi.map.x;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.microedition.khronos.opengles.GL10;

import org.json.JSONArray;
import org.json.JSONObject;

public class BaiduMap {
    public static final int MAP_TYPE_NONE = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final float REAL_MAX_ZOOM_LEVEL = 21.0F;
    public static final float REAL_MIN_ZOOM_LEVEL = 4.0F;
    private static final String W = "BaiduMap";
    public static int mapStatusReason = 256;
    private OnMapRenderValidDataListener A;
    private OnSynchronizationListener B;
    private TileOverlay C;
    private HeatMap D;
    private Lock E = new ReentrantLock();
    private Lock F = new ReentrantLock();
    private Map<String, InfoWindow> G;
    private Map<InfoWindow, Marker> H;
    private Marker I;
    private MyLocationData J;
    private MyLocationConfiguration K;
    MapView L;
    TextureMapView M;
    WearMapView N;
    r O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private Point T;
    private volatile boolean U = false;
    private com.baidu.mapsdkplatform.comapi.map.z.c V;
    private Projection a;
    private UiSettings b;
    private MapSurfaceView c;
    private MapTextureView d;
    private com.baidu.mapsdkplatform.comapi.map.c e;
    private List<Overlay> f;
    private List<Marker> g;
    private List<Marker> h;
    private List<InfoWindow> i;
    private Overlay.a j;
    private InfoWindow.a k;
    private OnMapStatusChangeListener l;
    private OnMapTouchListener m;
    private OnMapClickListener n;
    private OnMapLoadedCallback o;
    private OnMapRenderCallback p;
    private OnMapDoubleClickListener q;
    private OnMapLongClickListener r;
    private CopyOnWriteArrayList<OnMarkerClickListener> s = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<OnPolylineClickListener> t = new CopyOnWriteArrayList();
    private CopyOnWriteArrayList<OnMultiPointClickListener> u = new CopyOnWriteArrayList();
    private OnMarkerDragListener v;
    private OnMyLocationClickListener w;
    private SnapshotReadyCallback x;
    private OnMapDrawFrameCallback y;
    private OnBaseIndoorMapListener z;

    BaiduMap(Context paramContext, MapSurfaceView paramMapSurfaceView, q paramq) {
        this.c = paramMapSurfaceView;
        paramContext = new com.baidu.mapsdkplatform.comapi.map.c(paramContext, paramMapSurfaceView, paramq, null, 0);
        this.e = paramContext;
        paramMapSurfaceView.setBaseMap(paramContext);
        this.O = r.a;
        b();
    }

    BaiduMap(Context paramContext, MapTextureView paramMapTextureView, q paramq) {
        this.d = paramMapTextureView;
        paramContext = new com.baidu.mapsdkplatform.comapi.map.c(paramContext, paramMapTextureView, paramq, null, 0);
        this.e = paramContext;
        paramMapTextureView.setBaseMap(paramContext);
        this.O = r.b;
        b();
    }

    private Point a(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return null;
        }
        paramString = paramString.replaceAll("^\\{", "").replaceAll("\\}$", "").split(",");
        int i5 = paramString.length;
        int i3 = 0;
        int i1 = i3;
        int i2 = i1;
        int i4 = i1;
        i1 = i3;
        while (i1 < i5) {
            String[] arrayOfString = paramString[i1].replaceAll("\"", "").split(":");
            i3 = i4;
            if ("x".equals(arrayOfString[0])) {
                i3 = Integer.valueOf(arrayOfString[1]).intValue();
            }
            if ("y".equals(arrayOfString[0])) {
                i2 = Integer.valueOf(arrayOfString[1]).intValue();
            }
            i1 += 1;
            i4 = i3;
        }
        return new Point(i4, i2);
    }

    private BitmapDescriptor a(InfoWindow paramInfoWindow) {
        View localView = paramInfoWindow.c;
        if ((localView != null) && (paramInfoWindow.k)) {
            if (paramInfoWindow.h) {
                if (paramInfoWindow.i <= 0) {
                    paramInfoWindow.i = SysOSUtil.getDensityDpi();
                }
                return BitmapDescriptorFactory.fromViewWithDpi(paramInfoWindow.c, paramInfoWindow.i);
            }
            return BitmapDescriptorFactory.fromView(localView);
        }
        return paramInfoWindow.b;
    }

    private s a(MapStatusUpdate paramMapStatusUpdate) {
        Object localObject = this.e;
        if (localObject == null) {
            return null;
        }
        localObject = ((com.baidu.mapsdkplatform.comapi.map.c) localObject).t();
        paramMapStatusUpdate = paramMapStatusUpdate.a(this.e, getMapStatus());
        if (paramMapStatusUpdate == null) {
            return null;
        }
        return paramMapStatusUpdate.b((s) localObject);
    }

    private String a(int paramInt) {
        if (paramInt != 0) {
            switch (paramInt) {
                default:
                    return "";
                case 1019:
                    return "SSL握手超时";
                case 1018:
                    return "SSL握手错误";
                case 1017:
                    return "网络写错误";
                case 1016:
                    return "DNS解析超时";
                case 1015:
                    return "DNS解析错误";
                case 1014:
                    return "网络接收超时";
                case 1013:
                    return "网络发送超时";
                case 1012:
                    return "网络连接超时";
                case 1011:
                    return "网络超时错误";
                case 1010:
                    return "请求取消";
                case 1009:
                    return "数据不一致";
                case 1008:
                    return "当前网络类型有问题";
                case 1007:
                    return "返回响应数据过大，数据溢出";
                case 1006:
                    return "响应数据读取失败";
                case 1005:
                    return "请求发送错误";
            }
            return "网络连接错误";
        }
        return "数据请求成功";
    }

    private final void a(MyLocationData paramMyLocationData, MyLocationConfiguration paramMyLocationConfiguration) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    private void b() {
        this.U = false;
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
        this.h = new CopyOnWriteArrayList();
        this.G = new ConcurrentHashMap();
        this.H = new ConcurrentHashMap();
        this.i = new CopyOnWriteArrayList();
        this.T = new Point((int) (SysOSUtil.getDensity() * 40.0F), (int) (SysOSUtil.getDensity() * 40.0F));
        Object localObject = this.e;
        this.b = new UiSettings((com.baidu.mapsdkplatform.comapi.map.c) localObject);
        this.j = new b();
        this.k = new c();
        ((com.baidu.mapsdkplatform.comapi.map.c) localObject).a(new d());
        localObject = new e();
        this.e.a((i) localObject);
        localObject = new f();
        this.e.a((w) localObject);
        this.P = this.e.P();
        this.Q = this.e.B();
    }

    private void b(InfoWindow paramInfoWindow) {
        if (paramInfoWindow != null) {
            if (this.U) {
                return;
            }
            Object localObject1 = this.H.keySet();
            if ((!((Set) localObject1).isEmpty()) && (((Set) localObject1).contains(paramInfoWindow))) {
                localObject1 = paramInfoWindow.c;
                Object localObject3;
                if ((localObject1 != null) && (paramInfoWindow.k)) {
                    ((View) localObject1).destroyDrawingCache();
                    localObject2 = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(paramInfoWindow.d).yOffset(paramInfoWindow.g).build();
                    i1 = a.b[this.O.ordinal()];
                    if (i1 != 1) {
                        if (i1 == 2) {
                            localObject3 = this.L;
                            if (localObject3 != null) {
                                ((MapView) localObject3).addView((View) localObject1, (ViewGroup.LayoutParams) localObject2);
                            }
                        }
                    } else {
                        localObject3 = this.M;
                        if (localObject3 != null) {
                            ((TextureMapView) localObject3).addView((View) localObject1, (ViewGroup.LayoutParams) localObject2);
                            ((View) localObject1).setLayoutParams((ViewGroup.LayoutParams) localObject2);
                        }
                    }
                    if (paramInfoWindow.j) {
                        i1 = 0;
                        break label182;
                    }
                }
                int i1 = 1;
                label182:
                localObject1 = a(paramInfoWindow);
                Object localObject2 = (Marker) this.H.get(paramInfoWindow);
                if (localObject2 != null) {
                    localObject3 = new Bundle();
                    if (paramInfoWindow.b != null) {
                        ((Overlay) localObject2).type = e.b;
                        ((Marker) localObject2).f = ((BitmapDescriptor) localObject1);
                        if (paramInfoWindow.c != null) {
                            ((Bundle) localObject3).putInt("draw_with_view", 1);
                        } else {
                            ((Bundle) localObject3).putInt("draw_with_view", 0);
                        }
                    }
                    ((Marker) localObject2).e = paramInfoWindow.d;
                    ((Marker) localObject2).m = paramInfoWindow.g;
                    ((Marker) localObject2).a((Bundle) localObject3);
                    if ((this.e != null) && (i1 != 0) && (!this.U)) {
                        this.e.f((Bundle) localObject3);
                    }
                }
                return;
            }
            showInfoWindow(paramInfoWindow, false);
        }
    }

    void a(HeatMap paramHeatMap) {
        this.E.lock();
        try {
            HeatMap localHeatMap = this.D;
            if ((localHeatMap != null) && (this.e != null) && (paramHeatMap == localHeatMap)) {
                localHeatMap.a();
                this.D.d();
                this.D.m = null;
                this.e.e();
                this.D = null;
                this.e.i(false);
            }
            return;
        } finally {
            this.E.unlock();
        }
    }

    void a(TileOverlay paramTileOverlay) {
        this.F.lock();
        if (paramTileOverlay != null) {
            try {
                if (this.C == paramTileOverlay) {
                    paramTileOverlay.c();
                    paramTileOverlay.a = null;
                    paramTileOverlay = this.e;
                    if (paramTileOverlay != null) {
                        paramTileOverlay.Q();
                    }
                }
            } finally {
                this.C = null;
                this.F.unlock();
            }
        }
        this.C = null;
        this.F.unlock();
    }

    boolean a() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return false;
        }
        return localc.c();
    }

    public void addHeatMap(HeatMap paramHeatMap) {
        if (paramHeatMap != null) {
            if (this.e == null) {
                return;
            }
            this.E.lock();
            try {
                HeatMap localHeatMap = this.D;
                if (paramHeatMap == localHeatMap) {
                }
                for (; ; ) {
                    return;
                    if (localHeatMap != null) {
                        localHeatMap.a();
                        this.D.d();
                        this.D.m = null;
                        this.e.e();
                    }
                    this.D = paramHeatMap;
                    paramHeatMap.m = this;
                    this.e.i(true);
                }
                return;
            } finally {
                this.E.unlock();
            }
        }
    }

    public final Overlay addOverlay(OverlayOptions paramOverlayOptions) {
        if ((paramOverlayOptions != null) && (!this.U)) {
            paramOverlayOptions = paramOverlayOptions.a();
            paramOverlayOptions.listener = this.j;
            if ((paramOverlayOptions instanceof Marker)) {
                localObject1 = (Marker) paramOverlayOptions;
                ((Marker) localObject1).D = this.k;
                Object localObject2 = ((Marker) localObject1).v;
                if ((localObject2 != null) && (((ArrayList) localObject2).size() != 0)) {
                    this.g.add(localObject1);
                    localObject2 = this.e;
                    if (localObject2 != null) {
                        ((com.baidu.mapsdkplatform.comapi.map.c) localObject2).l(true);
                    }
                }
                this.h.add(localObject1);
                localObject1 = ((Marker) localObject1).C;
                if (localObject1 != null) {
                    showInfoWindow((InfoWindow) localObject1, false);
                }
            }
            Object localObject1 = new Bundle();
            paramOverlayOptions.a((Bundle) localObject1);
            if ((this.e != null) && (!this.U)) {
                this.e.b((Bundle) localObject1);
            }
            this.f.add(paramOverlayOptions);
            return paramOverlayOptions;
        }
        return null;
    }

    public final List<Overlay> addOverlays(List<OverlayOptions> paramList) {
        if (paramList != null) {
            if (this.U) {
                return null;
            }
            ArrayList localArrayList = new ArrayList();
            int i3 = paramList.size();
            int i4 = i3 / 400;
            int i2 = 0;
            while (i2 < i4 + 1) {
                if (i4 == 0) {
                    i1 = i3;
                } else if (i2 == i4) {
                    i1 = i3 - i4 * 400;
                } else {
                    i1 = 400;
                }
                Bundle[] arrayOfBundle = new Bundle[i1];
                int i1 = 0;
                while (i1 < 400) {
                    int i5 = i2 * 400 + i1;
                    if (i5 >= i3) {
                        break;
                    }
                    if (this.U) {
                        return null;
                    }
                    Object localObject2 = (OverlayOptions) paramList.get(i5);
                    if (localObject2 != null) {
                        localObject1 = new Bundle();
                        localObject2 = ((OverlayOptions) localObject2).a();
                        ((Overlay) localObject2).listener = this.j;
                        if ((localObject2 instanceof Marker)) {
                            Marker localMarker = (Marker) localObject2;
                            localMarker.D = this.k;
                            Object localObject3 = localMarker.v;
                            if ((localObject3 != null) && (((ArrayList) localObject3).size() != 0)) {
                                this.g.add(localMarker);
                                localObject3 = this.e;
                                if (localObject3 != null) {
                                    ((com.baidu.mapsdkplatform.comapi.map.c) localObject3).l(true);
                                }
                            }
                            this.h.add(localMarker);
                        }
                        this.f.add(localObject2);
                        localArrayList.add(localObject2);
                        ((Overlay) localObject2).a((Bundle) localObject1);
                        localObject2 = this.e;
                        if (localObject2 != null) {
                            ((com.baidu.mapsdkplatform.comapi.map.c) localObject2).a((Bundle) localObject1);
                        }
                        arrayOfBundle[i1] = localObject1;
                    }
                    i1 += 1;
                }
                Object localObject1 = this.e;
                if (localObject1 != null) {
                    ((com.baidu.mapsdkplatform.comapi.map.c) localObject1).a(arrayOfBundle);
                }
                i2 += 1;
            }
            return localArrayList;
        }
        return null;
    }

    public TileOverlay addTileLayer(TileOverlayOptions paramTileOverlayOptions) {
        if (paramTileOverlayOptions == null) {
            return null;
        }
        Object localObject = this.C;
        if (localObject != null) {
            ((TileOverlay) localObject).c();
            this.C.a = null;
        }
        localObject = this.e;
        if ((localObject != null) && (((com.baidu.mapsdkplatform.comapi.map.c) localObject).c(paramTileOverlayOptions.a()))) {
            paramTileOverlayOptions = paramTileOverlayOptions.a(this);
            this.C = paramTileOverlayOptions;
            return paramTileOverlayOptions;
        }
        return null;
    }

    public final TraceOverlay addTraceOverlay(TraceOptions paramTraceOptions, TraceAnimationListener paramTraceAnimationListener) {
        if (paramTraceOptions == null) {
            return null;
        }
        Object localObject = this.V;
        if ((localObject == null) || (((com.baidu.mapsdkplatform.comapi.map.z.c) localObject).c())) {
            localObject = this.O;
            if (localObject == r.a) {
            }
            for (localObject = new com.baidu.mapsdkplatform.comapi.map.z.c(this.c); ; localObject = new com.baidu.mapsdkplatform.comapi.map.z.c(this.d)) {
                this.V = ((com.baidu.mapsdkplatform.comapi.map.z.c) localObject);
                break;
                if (localObject != r.b) {
                    break label100;
                }
            }
            this.V.b();
        }
        this.V.a(paramTraceAnimationListener);
        return this.V.a(paramTraceOptions);
        label100:
        return null;
    }

    public final void animateMapStatus(MapStatusUpdate paramMapStatusUpdate) {
        animateMapStatus(paramMapStatusUpdate, 300);
    }

    public final void animateMapStatus(MapStatusUpdate paramMapStatusUpdate, int paramInt) {
        if (paramMapStatusUpdate != null) {
            if (paramInt <= 0) {
                return;
            }
            paramMapStatusUpdate = a(paramMapStatusUpdate);
            com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
            if (localc == null) {
                return;
            }
            mapStatusReason |= 0x100;
            if (!this.S) {
                localc.a(paramMapStatusUpdate);
                return;
            }
            localc.a(paramMapStatusUpdate, paramInt);
        }
    }

    void c() {
        this.U = true;
        com.baidu.mapsdkplatform.comapi.map.z.c localc = this.V;
        if (localc != null) {
            localc.d();
            this.V = null;
        }
        hideInfoWindow();
    }

    public void changeLocationLayerOrder(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.a(paramBoolean);
    }

    public void cleanCache(int paramInt) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.a(paramInt);
    }

    public final void clear() {
        if (this.U) {
            return;
        }
        this.f.clear();
        this.g.clear();
        this.h.clear();
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            localc.l(false);
            this.e.d();
        }
        hideInfoWindow();
    }

    void d() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.S();
    }

    public List<InfoWindow> getAllInfoWindows() {
        return this.i;
    }

    public final Point getCompassPosition() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            return a(localc.k());
        }
        return null;
    }

    public MapBaseIndoorMapInfo getFocusedBaseIndoorMapInfo() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return null;
        }
        return localc.m();
    }

    public final int getFontSizeLevel() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            localc.n();
        }
        return 1;
    }

    public MapSurfaceView getGLMapView() {
        return this.c;
    }

    @Deprecated
    public final MyLocationConfiguration getLocationConfigeration() {
        return getLocationConfiguration();
    }

    public final MyLocationConfiguration getLocationConfiguration() {
        return this.K;
    }

    public final MyLocationData getLocationData() {
        return this.J;
    }

    public final String getMapApprovalNumber() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return "";
        }
        return localc.r();
    }

    public MapLanguage getMapLanguage() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            int i1 = localc.s();
            return MapLanguage.values()[i1];
        }
        return MapLanguage.CHINESE;
    }

    public final MapStatus getMapStatus() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return null;
        }
        return MapStatus.a(localc.t());
    }

    public final LatLngBounds getMapStatusLimit() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return null;
        }
        return localc.u();
    }

    public MapTextureView getMapTextureView() {
        return this.d;
    }

    public final int getMapType() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        int i1 = 1;
        if (localc == null) {
            return 1;
        }
        if (!localc.G()) {
            return 3;
        }
        if (this.e.K()) {
            i1 = 2;
        }
        return i1;
    }

    public List<Marker> getMarkersInBounds(LatLngBounds paramLatLngBounds) {
        if (getMapStatus() == null) {
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        if (this.h.size() == 0) {
            return null;
        }
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext()) {
            Marker localMarker = (Marker) localIterator.next();
            if (paramLatLngBounds.contains(localMarker.getPosition())) {
                localArrayList.add(localMarker);
            }
        }
        return localArrayList;
    }

    public final float getMaxZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return 0.0F;
        }
        return localc.v();
    }

    public final float getMinZoomLevel() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return 0.0F;
        }
        return localc.b;
    }

    public final Projection getProjection() {
        return this.a;
    }

    public float[] getProjectionMatrix() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return null;
        }
        return localc.w();
    }

    public final UiSettings getUiSettings() {
        return this.b;
    }

    public float[] getViewMatrix() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return null;
        }
        return localc.x();
    }

    public float getZoomToBound(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return 0.0F;
        }
        return localc.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    }

    @Deprecated
    public MapSurfaceView getmGLMapView() {
        return this.c;
    }

    public void hideInfoWindow() {
        Object localObject1 = this.G.values();
        Object localObject2;
        Object localObject3;
        if (!((Collection) localObject1).isEmpty()) {
            localObject1 = ((Collection) localObject1).iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (InfoWindow) ((Iterator) localObject1).next();
                if (localObject2 != null) {
                    localObject2 = ((InfoWindow) localObject2).c;
                    if (localObject2 != null) {
                        int i1 = a.b[this.O.ordinal()];
                        if (i1 != 1) {
                            if (i1 == 2) {
                                localObject3 = this.L;
                                if (localObject3 != null) {
                                    ((MapView) localObject3).removeView((View) localObject2);
                                }
                            }
                        } else {
                            localObject3 = this.M;
                            if (localObject3 != null) {
                                ((TextureMapView) localObject3).removeView((View) localObject2);
                            }
                        }
                    }
                }
            }
        }
        localObject1 = this.f.iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (Overlay) ((Iterator) localObject1).next();
            localObject3 = this.G.keySet();
            String str = ((Overlay) localObject2).a;
            if (((localObject2 instanceof Marker)) && (!((Set) localObject3).isEmpty()) && (((Set) localObject3).contains(str))) {
                ((Overlay) localObject2).remove();
            }
        }
        this.G.clear();
        this.H.clear();
        this.i.clear();
    }

    public void hideInfoWindow(InfoWindow paramInfoWindow) {
        Object localObject1 = this.H.keySet();
        if ((paramInfoWindow != null) && (!((Set) localObject1).isEmpty())) {
            if (!((Set) localObject1).contains(paramInfoWindow)) {
                return;
            }
            localObject1 = paramInfoWindow.c;
            if (localObject1 != null) {
                int i1 = a.b[this.O.ordinal()];
                Object localObject2;
                if (i1 != 1) {
                    if (i1 == 2) {
                        localObject2 = this.L;
                        if (localObject2 != null) {
                            ((MapView) localObject2).removeView((View) localObject1);
                        }
                    }
                } else {
                    localObject2 = this.M;
                    if (localObject2 != null) {
                        ((TextureMapView) localObject2).removeView((View) localObject1);
                    }
                }
            }
            localObject1 = (Marker) this.H.get(paramInfoWindow);
            if (localObject1 != null) {
                ((Overlay) localObject1).remove();
                this.G.remove(((Overlay) localObject1).a);
            }
            this.H.remove(paramInfoWindow);
            this.i.remove(paramInfoWindow);
        }
    }

    public void hideSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.A();
    }

    public final boolean isBaiduHeatMapEnabled() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return false;
        }
        return localc.E();
    }

    public boolean isBaseIndoorMapMode() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return false;
        }
        return localc.F();
    }

    public final boolean isBuildingsEnabled() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return false;
        }
        return localc.H();
    }

    public final boolean isMyLocationEnabled() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return false;
        }
        return localc.q();
    }

    public final boolean isShowMapPoi() {
        return this.P;
    }

    public final boolean isSupportBaiduHeatMap() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return false;
        }
        return localc.i();
    }

    public final boolean isTrafficEnabled() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return false;
        }
        return localc.M();
    }

    public final void removeMarkerClickListener(OnMarkerClickListener paramOnMarkerClickListener) {
        if (this.s.contains(paramOnMarkerClickListener)) {
            this.s.remove(paramOnMarkerClickListener);
        }
    }

    public void removeOverLays(List<Overlay> paramList) {
        if (paramList != null) {
            if (this.U) {
                return;
            }
            int i3 = paramList.size();
            int i4 = i3 / 400;
            int i2 = 0;
            while (i2 < i4 + 1) {
                if (i4 == 0) {
                    i1 = i3;
                } else if (i2 == i4) {
                    i1 = i3 - i4 * 400;
                } else {
                    i1 = 400;
                }
                Bundle[] arrayOfBundle = new Bundle[i1];
                int i1 = 0;
                while (i1 < 400) {
                    int i5 = i2 * 400 + i1;
                    if (i5 >= i3) {
                        break;
                    }
                    if (this.U) {
                        return;
                    }
                    localObject1 = (Overlay) paramList.get(i5);
                    if (localObject1 != null) {
                        Object localObject2 = ((Overlay) localObject1).a();
                        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
                        if (localc != null) {
                            localc.a((Bundle) localObject2);
                        }
                        arrayOfBundle[i1] = localObject2;
                        localObject2 = this.h;
                        if ((localObject2 != null) && (((List) localObject2).contains(localObject1))) {
                            this.h.remove(localObject1);
                        }
                        if (this.g.contains(localObject1)) {
                            localObject1 = (Marker) localObject1;
                            if (((Marker) localObject1).v != null) {
                                this.g.remove(localObject1);
                                if (this.g.size() == 0) {
                                    localObject1 = this.e;
                                    if (localObject1 != null) {
                                        ((com.baidu.mapsdkplatform.comapi.map.c) localObject1).l(false);
                                    }
                                }
                            }
                        }
                    }
                    i1 += 1;
                }
                Object localObject1 = this.e;
                if (localObject1 != null) {
                    ((com.baidu.mapsdkplatform.comapi.map.c) localObject1).b(arrayOfBundle);
                }
                i2 += 1;
            }
            this.f.removeAll(paramList);
        }
    }

    public final void setBaiduHeatMapEnabled(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            localc.d(paramBoolean);
        }
    }

    public final void setBuildingsEnabled(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            localc.b(paramBoolean);
        }
    }

    public void setCompassEnable(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.c(paramBoolean);
    }

    public void setCompassIcon(Bitmap paramBitmap) {
        if (paramBitmap != null) {
            com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
            if (localc == null) {
                return;
            }
            localc.a(paramBitmap);
            return;
        }
        throw new IllegalArgumentException("BDMapSDKException: compass's icon can not be null");
    }

    public void setCompassPosition(Point paramPoint) {
        if (this.e == null) {
            return;
        }
        Point localPoint = new Point(paramPoint.x, paramPoint.y);
        if (this.e.a(localPoint)) {
            this.T = paramPoint;
        }
    }

    @Deprecated
    public boolean setCustomTrafficColor(String paramString1, String paramString2, String paramString3, String paramString4) {
        if (this.e == null) {
            return false;
        }
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
            if ((paramString1.matches("^#[0-9a-fA-F]{8}$")) && (paramString2.matches("^#[0-9a-fA-F]{8}$")) && (paramString3.matches("^#[0-9a-fA-F]{8}$")) && (paramString4.matches("^#[0-9a-fA-F]{8}$"))) {
                this.e.a(Color.parseColor(paramString1), Color.parseColor(paramString2), Color.parseColor(paramString3), Color.parseColor(paramString4), true);
            } else {
                Log.e(W, "the string of the input customTrafficColor is error");
                return false;
            }
        } else if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString4))) {
            this.e.a(Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), Color.parseColor("#ffffffff"), false);
        }
        return true;
    }

    public final void setFontSizeLevel(int paramInt) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            localc.b(paramInt);
        }
    }

    public final void setIndoorEnable(boolean paramBoolean) {
        Object localObject = this.e;
        if (localObject != null) {
            this.R = paramBoolean;
            ((com.baidu.mapsdkplatform.comapi.map.c) localObject).v(paramBoolean);
        }
        localObject = this.z;
        if ((localObject != null) && (!paramBoolean)) {
            ((OnBaseIndoorMapListener) localObject).onBaseIndoorMapMode(false, null);
        }
    }

    public void setLayerClickable(MapLayer paramMapLayer, boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.a(paramMapLayer, paramBoolean);
    }

    public final void setMapLanguage(MapLanguage paramMapLanguage) {
    }

    public final void setMapStatus(MapStatusUpdate paramMapStatusUpdate) {
        if (paramMapStatusUpdate == null) {
            return;
        }
        paramMapStatusUpdate = a(paramMapStatusUpdate);
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.a(paramMapStatusUpdate);
        paramMapStatusUpdate = this.l;
        if (paramMapStatusUpdate != null) {
            paramMapStatusUpdate.onMapStatusChange(getMapStatus());
        }
    }

    public final void setMapStatusLimits(LatLngBounds paramLatLngBounds) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.a(paramLatLngBounds);
        setMapStatus(MapStatusUpdateFactory.newLatLngBounds(paramLatLngBounds));
    }

    public final void setMapType(int paramInt) {
        Object localObject = this.e;
        if (localObject == null) {
            return;
        }
        if (paramInt != 1) {
            if (paramInt != 2) {
                if (paramInt == 3) {
                    if (((com.baidu.mapsdkplatform.comapi.map.c) localObject).P()) {
                        this.e.y(false);
                    }
                    if (this.e.B()) {
                        this.e.w(false);
                    }
                    this.e.e(false);
                    this.e.v(false);
                }
            } else {
                ((com.baidu.mapsdkplatform.comapi.map.c) localObject).p(true);
                this.e.y(this.P);
                this.e.w(this.Q);
                this.e.e(true);
            }
        } else {
            ((com.baidu.mapsdkplatform.comapi.map.c) localObject).p(false);
            this.e.y(this.P);
            this.e.w(this.Q);
            this.e.e(true);
            this.e.v(this.R);
        }
        if (OpenLogUtil.isMapLogEnable()) {
            localObject = b.a();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("BasicMap setMapType type = ");
            localStringBuilder.append(paramInt);
            ((b) localObject).a(localStringBuilder.toString());
        }
    }

    public final void setMaxAndMinZoomLevel(float paramFloat1, float paramFloat2) {
        if (paramFloat1 > 21.0F) {
            return;
        }
        if (paramFloat2 < 4.0F) {
            return;
        }
        if (paramFloat1 < paramFloat2) {
            return;
        }
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            localc.a(paramFloat1, paramFloat2);
        }
    }

    @Deprecated
    public final void setMyLocationConfigeration(MyLocationConfiguration paramMyLocationConfiguration) {
        setMyLocationConfiguration(paramMyLocationConfiguration);
    }

    public final void setMyLocationConfiguration(MyLocationConfiguration paramMyLocationConfiguration) {
        this.K = paramMyLocationConfiguration;
        a(this.J, paramMyLocationConfiguration);
    }

    public final void setMyLocationData(MyLocationData paramMyLocationData) {
        this.J = paramMyLocationData;
        if (this.K == null) {
            this.K = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, false, null);
        }
        a(paramMyLocationData, this.K);
    }

    public final void setMyLocationEnabled(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            localc.j(paramBoolean);
        }
    }

    public final void setOnBaseIndoorMapListener(OnBaseIndoorMapListener paramOnBaseIndoorMapListener) {
        this.z = paramOnBaseIndoorMapListener;
    }

    public final void setOnMapClickListener(OnMapClickListener paramOnMapClickListener) {
        this.n = paramOnMapClickListener;
    }

    public final void setOnMapDoubleClickListener(OnMapDoubleClickListener paramOnMapDoubleClickListener) {
        this.q = paramOnMapDoubleClickListener;
    }

    public final void setOnMapDrawFrameCallback(OnMapDrawFrameCallback paramOnMapDrawFrameCallback) {
        this.y = paramOnMapDrawFrameCallback;
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback paramOnMapLoadedCallback) {
        this.o = paramOnMapLoadedCallback;
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener) {
        this.r = paramOnMapLongClickListener;
    }

    public void setOnMapRenderCallbadk(OnMapRenderCallback paramOnMapRenderCallback) {
        this.p = paramOnMapRenderCallback;
    }

    public final void setOnMapRenderValidDataListener(OnMapRenderValidDataListener paramOnMapRenderValidDataListener) {
        this.A = paramOnMapRenderValidDataListener;
    }

    public final void setOnMapStatusChangeListener(OnMapStatusChangeListener paramOnMapStatusChangeListener) {
        this.l = paramOnMapStatusChangeListener;
    }

    public final void setOnMapTouchListener(OnMapTouchListener paramOnMapTouchListener) {
        this.m = paramOnMapTouchListener;
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener paramOnMarkerClickListener) {
        if ((paramOnMarkerClickListener != null) && (!this.s.contains(paramOnMarkerClickListener))) {
            this.s.add(paramOnMarkerClickListener);
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener paramOnMarkerDragListener) {
        this.v = paramOnMarkerDragListener;
    }

    public final void setOnMultiPointClickListener(OnMultiPointClickListener paramOnMultiPointClickListener) {
        if (paramOnMultiPointClickListener != null) {
            this.u.add(paramOnMultiPointClickListener);
        }
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener paramOnMyLocationClickListener) {
        this.w = paramOnMyLocationClickListener;
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener paramOnPolylineClickListener) {
        if (paramOnPolylineClickListener != null) {
            this.t.add(paramOnPolylineClickListener);
        }
    }

    public final void setOnSynchronizationListener(OnSynchronizationListener paramOnSynchronizationListener) {
        this.B = paramOnSynchronizationListener;
    }

    public void setOverlayUnderPoi(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.m(paramBoolean);
    }

    @Deprecated
    public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        setViewPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public void setPixelFormatTransparent(boolean paramBoolean) {
        MapSurfaceView localMapSurfaceView = this.c;
        if (localMapSurfaceView == null) {
            return;
        }
        if (paramBoolean) {
            paramBoolean = true;
        } else {
            paramBoolean = false;
        }
        localMapSurfaceView.setPixelFormatTransparent(paramBoolean);
    }

    public final void setTrafficEnabled(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            localc.r(paramBoolean);
        }
    }

    public final void setViewPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt3 >= 0)) {
            if (paramInt4 < 0) {
                return;
            }
            if (this.e == null) {
                return;
            }
            int i1 = a.b[this.O.ordinal()];
            Object localObject;
            float f1;
            float f2;
            float f3;
            Point localPoint;
            if (i1 != 1) {
                if (i1 != 2) {
                    return;
                }
                localObject = this.L;
                if (localObject == null) {
                    return;
                }
                f1 = (((ViewGroup) localObject).getWidth() - paramInt1 - paramInt3) / this.L.getWidth();
                f2 = (this.L.getHeight() - paramInt2 - paramInt4) / this.L.getHeight();
                localObject = this.e;
                f3 = paramInt1;
                localPoint = this.T;
                ((com.baidu.mapsdkplatform.comapi.map.c) localObject).a(new Point((int) (f3 + localPoint.x * f1), (int) (paramInt2 + localPoint.y * f2)));
                this.L.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
                localObject = this.L;
            } else {
                localObject = this.M;
                if (localObject == null) {
                    return;
                }
                f1 = (((ViewGroup) localObject).getWidth() - paramInt1 - paramInt3) / this.M.getWidth();
                f2 = (this.M.getHeight() - paramInt2 - paramInt4) / this.M.getHeight();
                localObject = this.e;
                f3 = paramInt1;
                localPoint = this.T;
                ((com.baidu.mapsdkplatform.comapi.map.c) localObject).a(new Point((int) (f3 + localPoint.x * f1), (int) (paramInt2 + localPoint.y * f2)));
                this.M.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
                localObject = this.M;
            }
            ((ViewGroup) localObject).invalidate();
        }
    }

    public void showInfoWindow(InfoWindow paramInfoWindow) {
        showInfoWindow(paramInfoWindow, true);
    }

    public void showInfoWindow(InfoWindow paramInfoWindow, boolean paramBoolean) {
        Object localObject1 = this.H.keySet();
        if ((paramInfoWindow != null) && (!((Set) localObject1).contains(paramInfoWindow))) {
            if (this.U) {
                return;
            }
            if (paramBoolean) {
                hideInfoWindow();
            }
            paramInfoWindow.f = this.k;
            localObject1 = paramInfoWindow.c;
            int i1;
            if ((localObject1 != null) && (paramInfoWindow.k)) {
                ((View) localObject1).destroyDrawingCache();
                localObject2 = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(paramInfoWindow.d).yOffset(paramInfoWindow.g).build();
                i1 = a.b[this.O.ordinal()];
                Object localObject3;
                if (i1 != 1) {
                    if (i1 == 2) {
                        localObject3 = this.L;
                        if (localObject3 != null) {
                            ((MapView) localObject3).addView((View) localObject1, (ViewGroup.LayoutParams) localObject2);
                        }
                    }
                } else {
                    localObject3 = this.M;
                    if (localObject3 != null) {
                        ((TextureMapView) localObject3).addView((View) localObject1, (ViewGroup.LayoutParams) localObject2);
                    }
                }
                i1 = 0;
            } else {
                i1 = 1;
            }
            localObject1 = a(paramInfoWindow);
            if (localObject1 == null) {
                return;
            }
            localObject1 = new MarkerOptions().perspective(false).icon((BitmapDescriptor) localObject1).position(paramInfoWindow.d).zIndex(2147483647).yOffset(paramInfoWindow.g).infoWindow(paramInfoWindow).a();
            ((Overlay) localObject1).listener = this.j;
            ((Overlay) localObject1).type = e.b;
            Object localObject2 = new Bundle();
            ((Overlay) localObject1).a((Bundle) localObject2);
            if (paramInfoWindow.c != null) {
                ((Bundle) localObject2).putInt("draw_with_view", 1);
            } else {
                ((Bundle) localObject2).putInt("draw_with_view", 0);
            }
            if ((this.e != null) && (i1 != 0) && (!this.U)) {
                this.e.b((Bundle) localObject2);
                this.f.add(localObject1);
            }
            localObject1 = (Marker) localObject1;
            ((Marker) localObject1).D = this.k;
            this.G.put(((Overlay) localObject1).a, paramInfoWindow);
            this.H.put(paramInfoWindow, localObject1);
            this.i.add(paramInfoWindow);
        }
    }

    public void showInfoWindows(List<InfoWindow> paramList) {
        if (paramList != null) {
            if (paramList.isEmpty()) {
                return;
            }
            paramList = paramList.iterator();
            while (paramList.hasNext()) {
                showInfoWindow((InfoWindow) paramList.next(), false);
            }
        }
    }

    public final void showMapIndoorPoi(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            localc.w(paramBoolean);
            this.Q = paramBoolean;
        }
    }

    public final void showMapPoi(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc != null) {
            localc.y(paramBoolean);
            this.P = paramBoolean;
        }
    }

    public void showOperateLayer(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.x(paramBoolean);
    }

    public void showSDKLayer() {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.R();
    }

    public final void snapshot(SnapshotReadyCallback paramSnapshotReadyCallback) {
        this.x = paramSnapshotReadyCallback;
        int i1 = a.b[this.O.ordinal()];
        if (i1 != 1) {
            if (i1 != 2) {
                return;
            }
            paramSnapshotReadyCallback = this.c;
            if ((paramSnapshotReadyCallback != null) && (paramSnapshotReadyCallback.getController() != null)) {
                paramSnapshotReadyCallback = this.c;
                paramSnapshotReadyCallback.doCaptureMapView(new h(), paramSnapshotReadyCallback.getController().getScreenWidth(), this.c.getController().getScreenHeight(), Bitmap.Config.ARGB_8888);
                this.c.requestRender();
            }
        } else {
            paramSnapshotReadyCallback = this.d;
            if ((paramSnapshotReadyCallback != null) && (paramSnapshotReadyCallback.getController() != null)) {
                paramSnapshotReadyCallback = this.d;
                paramSnapshotReadyCallback.doCaptureMapView(new g(), paramSnapshotReadyCallback.getController().getScreenWidth(), this.d.getController().getScreenHeight(), Bitmap.Config.ARGB_8888);
                this.d.requestRender();
            }
        }
    }

    public final void snapshotScope(Rect paramRect, SnapshotReadyCallback paramSnapshotReadyCallback) {
        if (this.e == null) {
            return;
        }
        this.x = paramSnapshotReadyCallback;
        int i1 = a.b[this.O.ordinal()];
        if (i1 != 1) {
            if (i1 != 2) {
                return;
            }
            paramSnapshotReadyCallback = this.c;
            if (paramSnapshotReadyCallback != null) {
                paramSnapshotReadyCallback.doCaptureMapView(new j(), paramRect, Bitmap.Config.ARGB_8888);
                this.c.requestRender();
            }
        } else {
            paramSnapshotReadyCallback = this.d;
            if (paramSnapshotReadyCallback != null) {
                paramSnapshotReadyCallback.doCaptureMapView(new i(), paramRect, Bitmap.Config.ARGB_8888);
                this.d.requestRender();
            }
        }
    }

    public MapBaseIndoorMapInfo.SwitchFloorError switchBaseIndoorMapFloor(String paramString1, String paramString2) {
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
            Object localObject = getFocusedBaseIndoorMapInfo();
            if (localObject == null) {
                return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
            }
            if (!paramString2.equals(((MapBaseIndoorMapInfo) localObject).a)) {
                return MapBaseIndoorMapInfo.SwitchFloorError.FOCUSED_ID_ERROR;
            }
            localObject = ((MapBaseIndoorMapInfo) localObject).getFloors();
            if ((localObject != null) && (((List) localObject).contains(paramString1))) {
                localObject = this.e;
                if ((localObject != null) && (((com.baidu.mapsdkplatform.comapi.map.c) localObject).b(paramString1, paramString2))) {
                    return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_OK;
                }
                return MapBaseIndoorMapInfo.SwitchFloorError.SWITCH_ERROR;
            }
            return MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_OVERLFLOW;
        }
        return MapBaseIndoorMapInfo.SwitchFloorError.FLOOR_INFO_ERROR;
    }

    public void switchLayerOrder(MapLayer paramMapLayer1, MapLayer paramMapLayer2) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return;
        }
        localc.a(paramMapLayer1, paramMapLayer2);
    }

    public boolean switchOverlayLayerAndNavigationLayer(boolean paramBoolean) {
        com.baidu.mapsdkplatform.comapi.map.c localc = this.e;
        if (localc == null) {
            return false;
        }
        return localc.z(paramBoolean);
    }

    public static abstract interface OnBaseIndoorMapListener {
        public abstract void onBaseIndoorMapMode(boolean paramBoolean, MapBaseIndoorMapInfo paramMapBaseIndoorMapInfo);
    }

    public static abstract interface OnMapClickListener {
        public abstract void onMapClick(LatLng paramLatLng);

        public abstract void onMapPoiClick(MapPoi paramMapPoi);
    }

    public static abstract interface OnMapDoubleClickListener {
        public abstract void onMapDoubleClick(LatLng paramLatLng);
    }

    public static abstract interface OnMapDrawFrameCallback {
        public abstract void onMapDrawFrame(MapStatus paramMapStatus);

        @Deprecated
        public abstract void onMapDrawFrame(GL10 paramGL10, MapStatus paramMapStatus);
    }

    public static abstract interface OnMapLoadedCallback {
        public abstract void onMapLoaded();
    }

    public static abstract interface OnMapLongClickListener {
        public abstract void onMapLongClick(LatLng paramLatLng);
    }

    public static abstract interface OnMapRenderCallback {
        public abstract void onMapRenderFinished();
    }

    public static abstract interface OnMapRenderValidDataListener {
        public abstract void onMapRenderValidData(boolean paramBoolean, int paramInt, String paramString);
    }

    public static abstract interface OnMapStatusChangeListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        public abstract void onMapStatusChange(MapStatus paramMapStatus);

        public abstract void onMapStatusChangeFinish(MapStatus paramMapStatus);

        public abstract void onMapStatusChangeStart(MapStatus paramMapStatus);

        public abstract void onMapStatusChangeStart(MapStatus paramMapStatus, int paramInt);
    }

    public static abstract interface OnMapTouchListener {
        public abstract void onTouch(MotionEvent paramMotionEvent);
    }

    public static abstract interface OnMarkerClickListener {
        public abstract boolean onMarkerClick(Marker paramMarker);
    }

    public static abstract interface OnMarkerDragListener {
        public abstract void onMarkerDrag(Marker paramMarker);

        public abstract void onMarkerDragEnd(Marker paramMarker);

        public abstract void onMarkerDragStart(Marker paramMarker);
    }

    public static abstract interface OnMultiPointClickListener {
        public abstract boolean onMultiPointClick(MultiPoint paramMultiPoint, MultiPointItem paramMultiPointItem);
    }

    public static abstract interface OnMyLocationClickListener {
        public abstract boolean onMyLocationClick();
    }

    public static abstract interface OnPolylineClickListener {
        public abstract boolean onPolylineClick(Polyline paramPolyline);
    }

    public static abstract interface OnSynchronizationListener {
        public abstract void onMapStatusChangeReason(int paramInt);
    }

    public static abstract interface SnapshotReadyCallback {
        public abstract void onSnapshotReady(Bitmap paramBitmap);
    }

    class b
            implements Overlay.a {
        b() {
        }

        public void a(Overlay paramOverlay) {
            if (BaiduMap.a(BaiduMap.this)) {
                return;
            }
            if ((paramOverlay != null) && (BaiduMap.b(BaiduMap.this).contains(paramOverlay))) {
                Bundle localBundle = paramOverlay.a();
                if (BaiduMap.l(BaiduMap.this) != null) {
                    BaiduMap.l(BaiduMap.this).e(localBundle);
                }
                BaiduMap.b(BaiduMap.this).remove(paramOverlay);
            }
            if ((paramOverlay != null) && (BaiduMap.v(BaiduMap.this).contains(paramOverlay))) {
                BaiduMap.v(BaiduMap.this).remove(paramOverlay);
            }
            if ((paramOverlay != null) && (BaiduMap.y(BaiduMap.this).contains(paramOverlay))) {
                paramOverlay = (Marker) paramOverlay;
                if (paramOverlay.v != null) {
                    BaiduMap.y(BaiduMap.this).remove(paramOverlay);
                    if ((BaiduMap.y(BaiduMap.this).size() == 0) && (BaiduMap.l(BaiduMap.this) != null)) {
                        BaiduMap.l(BaiduMap.this).l(false);
                    }
                }
            }
        }

        public boolean b(Overlay paramOverlay) {
            return (BaiduMap.b(BaiduMap.this) != null) && (!BaiduMap.b(BaiduMap.this).contains(paramOverlay));
        }

        public void c(Overlay paramOverlay) {
            if (BaiduMap.a(BaiduMap.this)) {
                return;
            }
            if ((paramOverlay != null) && (BaiduMap.b(BaiduMap.this).contains(paramOverlay))) {
                int j = 0;
                int i = j;
                Object localObject1;
                if ((paramOverlay instanceof Marker)) {
                    localObject1 = (Marker) paramOverlay;
                    Object localObject2;
                    if (((Marker) localObject1).f != null) {
                        localObject2 = ((Marker) localObject1).v;
                        i = j;
                        if (localObject2 != null) {
                            i = j;
                            if (((ArrayList) localObject2).size() > 1) {
                                localObject2 = new Bundle();
                                i = j;
                                if (BaiduMap.l(BaiduMap.this) != null) {
                                    i = j;
                                    if (!BaiduMap.a(BaiduMap.this)) {
                                        ((Overlay) localObject1).remove();
                                        ((Marker) localObject1).v.clear();
                                        BaiduMap.l(BaiduMap.this).b(paramOverlay.a((Bundle) localObject2));
                                        BaiduMap.b(BaiduMap.this).add(paramOverlay);
                                        i = 1;
                                    }
                                }
                            }
                        }
                    } else {
                        localObject2 = ((Marker) localObject1).v;
                        i = j;
                        if (localObject2 != null) {
                            i = j;
                            if (((ArrayList) localObject2).size() != 0) {
                                if (BaiduMap.y(BaiduMap.this).contains(localObject1)) {
                                    BaiduMap.y(BaiduMap.this).remove(localObject1);
                                }
                                BaiduMap.y(BaiduMap.this).add(localObject1);
                                i = j;
                                if (BaiduMap.l(BaiduMap.this) != null) {
                                    BaiduMap.l(BaiduMap.this).l(true);
                                    i = j;
                                }
                            }
                        }
                    }
                }
                if ((BaiduMap.l(BaiduMap.this) != null) && (i == 0) && (!BaiduMap.a(BaiduMap.this))) {
                    localObject1 = new Bundle();
                    BaiduMap.l(BaiduMap.this).f(paramOverlay.a((Bundle) localObject1));
                }
            }
            if (BaiduMap.v(BaiduMap.this).contains(paramOverlay)) {
                BaiduMap.v(BaiduMap.this).remove(paramOverlay);
            }
            if ((paramOverlay instanceof Marker)) {
                paramOverlay = (Marker) paramOverlay;
                BaiduMap.v(BaiduMap.this).add(paramOverlay);
            }
        }
    }

    class c
            implements InfoWindow.a {
        c() {
        }

        public void a(InfoWindow paramInfoWindow) {
            BaiduMap.this.hideInfoWindow(paramInfoWindow);
        }

        public void b(InfoWindow paramInfoWindow) {
            BaiduMap.a(BaiduMap.this, paramInfoWindow);
        }
    }

    class d
            implements x {
        d() {
        }

        public void a() {
            if (BaiduMap.l(BaiduMap.this) != null) {
                BaiduMap.l(BaiduMap.this).l(false);
            }
            BaiduMap.p(BaiduMap.this).lock();
            try {
                if (BaiduMap.q(BaiduMap.this) != null) {
                    BaiduMap localBaiduMap = BaiduMap.this;
                    localBaiduMap.a(BaiduMap.q(localBaiduMap));
                }
                return;
            } finally {
                BaiduMap.p(BaiduMap.this).unlock();
            }
        }

        public void a(MotionEvent paramMotionEvent) {
            if (BaiduMap.B(BaiduMap.this) != null) {
                BaiduMap.B(BaiduMap.this).onTouch(paramMotionEvent);
            }
        }

        public void a(s params) {
            int i = BaiduMap.mapStatusReason;
            if ((i & 0x100) == 256) {
                i = 3;
            } else if ((i & 0x10) == 16) {
                i = 2;
            } else {
                i = 1;
            }
            if (BaiduMap.z(BaiduMap.this) != null) {
                params = MapStatus.a(params);
                BaiduMap.z(BaiduMap.this).onMapStatusChangeStart(params);
                BaiduMap.z(BaiduMap.this).onMapStatusChangeStart(params, i);
            }
            if (BaiduMap.A(BaiduMap.this) != null) {
                BaiduMap.A(BaiduMap.this).onMapStatusChangeReason(i);
            }
            BaiduMap.mapStatusReason = 0;
        }

        public void a(GeoPoint paramGeoPoint) {
            if ((BaiduMap.n(BaiduMap.this) != null) && (BaiduMap.n(BaiduMap.this).j)) {
                paramGeoPoint = CoordUtil.mc2ll(paramGeoPoint);
                paramGeoPoint = BaiduMap.e(BaiduMap.this).toScreenLocation(paramGeoPoint);
                paramGeoPoint = new Point(paramGeoPoint.x, paramGeoPoint.y - 60);
                paramGeoPoint = BaiduMap.e(BaiduMap.this).fromScreenLocation(paramGeoPoint);
                BaiduMap.n(BaiduMap.this).setPosition(paramGeoPoint);
                if ((BaiduMap.o(BaiduMap.this) != null) && (BaiduMap.n(BaiduMap.this).j)) {
                    BaiduMap.o(BaiduMap.this).onMarkerDragEnd(BaiduMap.n(BaiduMap.this));
                }
                BaiduMap.a(BaiduMap.this, null);
            }
        }

        public void a(GL10 paramGL10, s params) {
            if ((BaiduMap.i(BaiduMap.this) != null) && (!BaiduMap.i(BaiduMap.this).values().isEmpty())) {
                paramGL10 = BaiduMap.i(BaiduMap.this).values().iterator();
                while (paramGL10.hasNext()) {
                    final InfoWindow localInfoWindow = (InfoWindow) paramGL10.next();
                    if (localInfoWindow != null) {
                        View localView = localInfoWindow.c;
                        if (localView != null) {
                            localView.post(new a(localInfoWindow));
                        }
                    }
                }
            }
            if (BaiduMap.r(BaiduMap.this) != null) {
                paramGL10 = MapStatus.a(params);
                BaiduMap.r(BaiduMap.this).onMapDrawFrame(paramGL10);
            }
        }

        public void a(boolean paramBoolean) {
            if (BaiduMap.s(BaiduMap.this) != null) {
                MapBaseIndoorMapInfo localMapBaseIndoorMapInfo = BaiduMap.this.getFocusedBaseIndoorMapInfo();
                BaiduMap.s(BaiduMap.this).onBaseIndoorMapMode(paramBoolean, localMapBaseIndoorMapInfo);
            }
        }

        public void a(boolean paramBoolean, int paramInt) {
            if (BaiduMap.t(BaiduMap.this) != null) {
                String str = BaiduMap.a(BaiduMap.this, paramInt);
                BaiduMap.t(BaiduMap.this).onMapRenderValidData(paramBoolean, paramInt, str);
            }
        }

        public boolean a(String paramString) {
            boolean bool2 = false;
            try {
                paramString = new JSONObject(paramString).optJSONArray("dataset");
                if (paramString == null) {
                    return false;
                }
                paramString = paramString.optJSONObject(0);
                if (paramString == null) {
                    return false;
                }
                boolean bool1 = bool2;
                if (paramString.optInt("ty") == 90909) {
                    paramString = paramString.optString("marker_id");
                    Object localObject = BaiduMap.i(BaiduMap.this).keySet();
                    if (!((Set) localObject).isEmpty()) {
                        bool1 = bool2;
                        if (((Set) localObject).contains(paramString)) {
                        }
                    } else {
                        localObject = BaiduMap.b(BaiduMap.this).iterator();
                        Overlay localOverlay;
                        do {
                            bool1 = bool2;
                            if (!((Iterator) localObject).hasNext()) {
                                break;
                            }
                            localOverlay = (Overlay) ((Iterator) localObject).next();
                        } while ((!(localOverlay instanceof Marker)) || (!localOverlay.a.equals(paramString)));
                        paramString = (Marker) localOverlay;
                        bool1 = bool2;
                        if (paramString.j) {
                            BaiduMap.a(BaiduMap.this, paramString);
                            paramString = BaiduMap.e(BaiduMap.this).toScreenLocation(BaiduMap.n(BaiduMap.this).e);
                            paramString = new Point(paramString.x, paramString.y - 60);
                            paramString = BaiduMap.e(BaiduMap.this).fromScreenLocation(paramString);
                            BaiduMap.n(BaiduMap.this).setPosition(paramString);
                            if (BaiduMap.o(BaiduMap.this) != null) {
                                BaiduMap.o(BaiduMap.this).onMarkerDragStart(BaiduMap.n(BaiduMap.this));
                            }
                            bool1 = true;
                        }
                    }
                }
                return bool1;
            } catch (Exception paramString) {
            }
            return false;
        }

        public void b() {
            if (BaiduMap.g(BaiduMap.this) != null) {
                BaiduMap.g(BaiduMap.this).onMapRenderFinished();
            }
        }

        public void b(s params) {
            if (BaiduMap.z(BaiduMap.this) != null) {
                params = MapStatus.a(params);
                BaiduMap.z(BaiduMap.this).onMapStatusChangeFinish(params);
            }
            BaiduMap.mapStatusReason = 0;
        }

        public void b(GeoPoint paramGeoPoint) {
            if (BaiduMap.c(BaiduMap.this) != null) {
                paramGeoPoint = CoordUtil.mc2ll(paramGeoPoint);
                BaiduMap.c(BaiduMap.this).onMapDoubleClick(paramGeoPoint);
            }
        }

        public void b(String paramString) {
            try {
                paramString = new JSONObject(paramString);
                GeoPoint localGeoPoint = BaiduMap.l(BaiduMap.this).a(paramString.optInt("px"), paramString.optInt("py"));
                paramString = paramString.optJSONArray("dataset");
                Object localObject1 = null;
                int j = -1;
                int i = j;
                if (paramString != null) {
                    paramString = paramString.optJSONObject(0);
                    localObject1 = paramString;
                    i = j;
                    if (paramString != null) {
                        i = paramString.optInt("ty");
                        localObject1 = paramString;
                    }
                }
                if (i == 17) {
                    if (BaiduMap.C(BaiduMap.this) != null) {
                        paramString = new MapPoi();
                        paramString.a((JSONObject) localObject1);
                        BaiduMap.C(BaiduMap.this).onMapPoiClick(paramString);
                    }
                } else {
                    if (i == 18) {
                        if (BaiduMap.h(BaiduMap.this) != null) {
                            BaiduMap.h(BaiduMap.this).onMyLocationClick();
                            return;
                        }
                    }
                    do {
                        do {
                            c(localGeoPoint);
                            return;
                            if (i == 19) {
                                if (BaiduMap.l(BaiduMap.this) == null) {
                                    break label840;
                                }
                                paramString = BaiduMap.l(BaiduMap.this).t();
                                if (paramString == null) {
                                    return;
                                }
                                paramString.c = 0;
                                paramString.b = 0;
                                BaiduMap.mapStatusReason |= 0x10;
                                BaiduMap.l(BaiduMap.this).a(paramString, 300);
                                return;
                            }
                            paramString = "";
                            if (i != 90909) {
                                break label490;
                            }
                            if (localObject1 != null) {
                                paramString = ((JSONObject) localObject1).optString("marker_id");
                            }
                            localObject1 = BaiduMap.i(BaiduMap.this).keySet();
                            if ((((Set) localObject1).isEmpty()) || (!((Set) localObject1).contains(paramString))) {
                                break;
                            }
                            localObject1 = ((Set) localObject1).iterator();
                            do {
                                if (!((Iterator) localObject1).hasNext()) {
                                    break;
                                }
                                localObject2 = (String) ((Iterator) localObject1).next();
                            } while ((localObject2 == null) || (!((String) localObject2).equals(paramString)));
                            paramString = (InfoWindow) BaiduMap.i(BaiduMap.this).get(localObject2);
                        } while (paramString == null);
                        paramString = paramString.e;
                    } while (paramString == null);
                    paramString.onInfoWindowClick();
                    return;
                    Object localObject2 = BaiduMap.b(BaiduMap.this).iterator();
                    while (((Iterator) localObject2).hasNext()) {
                        localObject1 = (Overlay) ((Iterator) localObject2).next();
                        if (((localObject1 instanceof Marker)) && (((Overlay) localObject1).a.equals(paramString))) {
                            if (!BaiduMap.j(BaiduMap.this).isEmpty()) {
                                paramString = BaiduMap.j(BaiduMap.this).iterator();
                                while (paramString.hasNext()) {
                                    ((BaiduMap.OnMarkerClickListener) paramString.next()).onMarkerClick((Marker) localObject1);
                                }
                            }
                            c(localGeoPoint);
                        }
                    }
                    label490:
                    Object localObject3;
                    if (i == 90910) {
                        if (localObject1 != null) {
                            paramString = ((JSONObject) localObject1).optString("polyline_id");
                        }
                        localObject1 = BaiduMap.b(BaiduMap.this).iterator();
                        while (((Iterator) localObject1).hasNext()) {
                            localObject2 = (Overlay) ((Iterator) localObject1).next();
                            if (((localObject2 instanceof Polyline)) && (((Overlay) localObject2).a.equals(paramString))) {
                                if (!BaiduMap.k(BaiduMap.this).isEmpty()) {
                                    localObject3 = BaiduMap.k(BaiduMap.this).iterator();
                                    while (((Iterator) localObject3).hasNext()) {
                                        ((BaiduMap.OnPolylineClickListener) ((Iterator) localObject3).next()).onPolylineClick((Polyline) localObject2);
                                    }
                                } else {
                                    c(localGeoPoint);
                                }
                            }
                        }
                    }
                    if (i == 90911) {
                        if (localObject1 != null) {
                            paramString = ((JSONObject) localObject1).optString("multipoint_id");
                        }
                        localObject2 = BaiduMap.b(BaiduMap.this).iterator();
                        while (((Iterator) localObject2).hasNext()) {
                            localObject3 = (Overlay) ((Iterator) localObject2).next();
                            if (((localObject3 instanceof MultiPoint)) && (((Overlay) localObject3).a.equals(paramString))) {
                                if (!BaiduMap.m(BaiduMap.this).isEmpty()) {
                                    Iterator localIterator = BaiduMap.m(BaiduMap.this).iterator();
                                    while (localIterator.hasNext()) {
                                        BaiduMap.OnMultiPointClickListener localOnMultiPointClickListener = (BaiduMap.OnMultiPointClickListener) localIterator.next();
                                        MultiPoint localMultiPoint = (MultiPoint) localObject3;
                                        List localList = localMultiPoint.getMultiPointItems();
                                        if (localObject1 != null) {
                                            i = ((JSONObject) localObject1).optInt("multipoint_index");
                                            if ((localList != null) && (i >= 0) && (localList.size() > i)) {
                                                localOnMultiPointClickListener.onMultiPointClick(localMultiPoint, (MultiPointItem) localList.get(i));
                                            }
                                        }
                                    }
                                } else {
                                    c(localGeoPoint);
                                }
                            }
                        }
                    }
                }
                label840:
                return;
            } catch (Exception paramString) {
            }
        }

        public void c() {
        }

        public void c(s params) {
            if (BaiduMap.z(BaiduMap.this) != null) {
                params = MapStatus.a(params);
                BaiduMap.z(BaiduMap.this).onMapStatusChange(params);
            }
        }

        public void c(GeoPoint paramGeoPoint) {
            if (BaiduMap.C(BaiduMap.this) != null) {
                paramGeoPoint = CoordUtil.mc2ll(paramGeoPoint);
                BaiduMap.C(BaiduMap.this).onMapClick(paramGeoPoint);
            }
        }

        public void d() {
            BaiduMap localBaiduMap = BaiduMap.this;
            BaiduMap.a(localBaiduMap, new Projection(BaiduMap.l(localBaiduMap)));
            BaiduMap.a(BaiduMap.this, true);
            if (BaiduMap.f(BaiduMap.this) != null) {
                BaiduMap.f(BaiduMap.this).onMapLoaded();
            }
        }

        public void d(GeoPoint paramGeoPoint) {
            if (BaiduMap.d(BaiduMap.this) != null) {
                paramGeoPoint = CoordUtil.mc2ll(paramGeoPoint);
                BaiduMap.d(BaiduMap.this).onMapLongClick(paramGeoPoint);
            }
        }

        public void e(GeoPoint paramGeoPoint) {
            if ((BaiduMap.n(BaiduMap.this) != null) && (BaiduMap.n(BaiduMap.this).j)) {
                paramGeoPoint = CoordUtil.mc2ll(paramGeoPoint);
                paramGeoPoint = BaiduMap.e(BaiduMap.this).toScreenLocation(paramGeoPoint);
                paramGeoPoint = new Point(paramGeoPoint.x, paramGeoPoint.y - 60);
                paramGeoPoint = BaiduMap.e(BaiduMap.this).fromScreenLocation(paramGeoPoint);
                BaiduMap.n(BaiduMap.this).setPosition(paramGeoPoint);
                if ((BaiduMap.o(BaiduMap.this) != null) && (BaiduMap.n(BaiduMap.this).j)) {
                    BaiduMap.o(BaiduMap.this).onMarkerDrag(BaiduMap.n(BaiduMap.this));
                }
            }
        }

        class a
                implements Runnable {
            a(InfoWindow paramInfoWindow) {
            }

            public void run() {
                MapViewLayoutParams localMapViewLayoutParams = new MapViewLayoutParams.Builder().layoutMode(MapViewLayoutParams.ELayoutMode.mapMode).position(localInfoWindow.d).yOffset(localInfoWindow.g).build();
                localInfoWindow.c.setLayoutParams(localMapViewLayoutParams);
            }
        }
    }

    class e
            implements i {
        e() {
        }

        public Bundle a(int paramInt1, int paramInt2, int paramInt3) {
            BaiduMap.p(BaiduMap.this).lock();
            try {
                if (BaiduMap.q(BaiduMap.this) != null) {
                    Object localObject1 = BaiduMap.q(BaiduMap.this).a(paramInt1, paramInt2, paramInt3);
                    if (localObject1 != null) {
                        localObject1 = ((Tile) localObject1).toBundle();
                        return localObject1;
                    }
                }
                return null;
            } finally {
                BaiduMap.p(BaiduMap.this).unlock();
            }
        }
    }

    class f
            implements w {
        f() {
        }

        public Bundle a(int paramInt1, int paramInt2, int paramInt3, Context paramContext) {
            BaiduMap.u(BaiduMap.this).lock();
            for (; ; ) {
                try {
                    if (BaiduMap.w(BaiduMap.this) != null) {
                        paramContext = BaiduMap.w(BaiduMap.this).a(paramInt1, paramInt2, paramInt3);
                        StringBuilder localStringBuilder = new StringBuilder();
                        localStringBuilder.append("mapLayerDataReq tile t == null = ");
                        if (paramContext != null) {
                            break label142;
                        }
                        bool = true;
                        localStringBuilder.append(bool);
                        Log.e("SDKTileLayer", localStringBuilder.toString());
                        if (paramContext != null) {
                            paramContext = paramContext.toBundle();
                            return paramContext;
                        }
                    }
                    return null;
                } finally {
                    BaiduMap.u(BaiduMap.this).unlock();
                }
                label142:
                boolean bool = false;
            }
        }
    }

    class g
            implements com.baidu.platform.comapi.map.c {
        g() {
        }

        public void a(Bitmap paramBitmap) {
            BaiduMap.x(BaiduMap.this).onSnapshotReady(paramBitmap);
        }
    }

    class h
            implements com.baidu.platform.comapi.map.c {
        h() {
        }

        public void a(Bitmap paramBitmap) {
            BaiduMap.x(BaiduMap.this).onSnapshotReady(paramBitmap);
        }
    }

    class i
            implements com.baidu.platform.comapi.map.c {
        i() {
        }

        public void a(Bitmap paramBitmap) {
            BaiduMap.x(BaiduMap.this).onSnapshotReady(paramBitmap);
        }
    }

    class j
            implements com.baidu.platform.comapi.map.c {
        j() {
        }

        public void a(Bitmap paramBitmap) {
            BaiduMap.x(BaiduMap.this).onSnapshotReady(paramBitmap);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.baidu.mapapi.map.BaiduMap

 * JD-Core Version:    0.7.0.1

 */