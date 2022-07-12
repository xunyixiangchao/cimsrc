package com.farsunset.hoxin.common.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback;
import com.baidu.mapapi.map.BaiduMap.OnMapStatusChangeListener;
import com.baidu.mapapi.map.BaiduMap.SnapshotReadyCallback;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.MyLocationData.Builder;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.core.SearchResult.ERRORNO;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.utils.DistanceUtil;
import com.farsunset.hoxin.common.model.Location;
import com.farsunset.hoxin.common.model.MapAddress;
import com.farsunset.hoxin.common.widget.ToolbarSearchView;
import com.farsunset.hoxin.message.model.ChatMap;
import com.tencent.bugly.crashreport.CrashReport;

import e1.b;
import e1.e;
import j3.f;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import s3.x;
import u3.a0;
import u3.l;

public class MapLocationActivity
        extends BaseActivity
        implements BaiduMap.SnapshotReadyCallback, BaiduMap.OnMapLoadedCallback, BaiduMap.OnMapStatusChangeListener, s3.p<PoiInfo>, OnGetGeoCoderResultListener, OnGetPoiSearchResultListener, x {
    private PoiInfo e;
    private Button f;
    private MapView g;
    private BaiduMap h;
    private LocationClient i;
    private ProgressBar j;
    private RecyclerView k;
    private ToolbarSearchView l;
    private f m;
    private final GeoCoder n = GeoCoder.newInstance();
    private final PoiSearch o = PoiSearch.newInstance();
    private boolean p;
    private boolean q = true;
    private View r;
    private Location s;
    private final BDAbstractLocationListener t = new a();

    private void i1(LatLng paramLatLng, boolean paramBoolean) {
        this.j.setVisibility(0);
        this.k.setVisibility(8);
        this.f.setEnabled(false);
        this.n.reverseGeoCode(new ReverseGeoCodeOption().radius(2000).pageSize(50).location(paramLatLng));
        this.r.setSelected(true);
        if (paramBoolean) {
            ((e1.d) new e1.d(this.r, b.n).p(new e(0.0F).d(0.75F).f(50.0F)).h(-l.p(32.0F))).i();
        }
    }

    public int H0() {
        return 2131427384;
    }

    public void M0() {
        setStatusBarColor(17170445);
        Object localObject = (RecyclerView) findViewById(2131231391);
        this.k = ((RecyclerView) localObject);
        ((RecyclerView) localObject).setLayoutManager(new LinearLayoutManager(this));
        localObject = this.k;
        f localf = new f();
        this.m = localf;
        ((RecyclerView) localObject).setAdapter(localf);
        this.m.M(this);
        this.j = ((ProgressBar) findViewById(2131231416));
        this.r = findViewById(2131231154);
        localObject = (ToolbarSearchView) findViewById(2131231417);
        this.l = ((ToolbarSearchView) localObject);
        ((ToolbarSearchView) localObject).setOnSearchActionListener(this);
        localObject = (MapView) findViewById(2131231153);
        this.g = ((MapView) localObject);
        ((MapView) localObject).showZoomControls(false);
        if (u3.d.q()) {
            this.g.setMapCustomStylePath(l.F());
            this.g.setMapCustomStyleEnable(true);
        }
        localObject = this.g.getMap();
        this.h = ((BaiduMap) localObject);
        ((BaiduMap) localObject).setOnMapLoadedCallback(this);
        this.h.setMyLocationEnabled(true);
        this.h.getUiSettings().setCompassEnabled(true);
        this.h.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING, true, BitmapDescriptorFactory.fromBitmap(l.u(this, 2131165539)), 0, 0));
        this.h.setOnMapStatusChangeListener(this);
        localObject = u3.d.i();
        if (localObject != null) {
            this.h.setMyLocationData(new MyLocationData.Builder().latitude(((Location) localObject).latitude).longitude(((Location) localObject).longitude).build());
        }
        try {
            localObject = new LocationClient(this);
            this.i = ((LocationClient) localObject);
            ((LocationClient) localObject).registerLocationListener(this.t);
            this.n.setOnGetGeoCodeResultListener(this);
            this.o.setOnGetPoiSearchResultListener(this);
            localObject = new LocationClientOption();
            ((LocationClientOption) localObject).setOpenGps(true);
            ((LocationClientOption) localObject).setCoorType("bd09ll");
            ((LocationClientOption) localObject).setIsNeedAddress(true);
            this.i.setLocOption((LocationClientOption) localObject);
            return;
        } catch (Exception localException) {
            CrashReport.postCatchedException(localException);
        }
    }

    protected boolean O0() {
        return true;
    }

    public void b0(String paramString) {
        this.l.b();
        Location localLocation = this.s;
        if ((localLocation != null) && (!TextUtils.isEmpty(localLocation.city))) {
            this.o.searchInCity(new PoiCitySearchOption().city(this.s.city).keyword(paramString).pageNum(0).pageCapacity(20));
            return;
        }
        X0(2131690090);
    }

    public void h1(PoiInfo paramPoiInfo, View paramView) {
        this.e = paramPoiInfo;
        this.f.setEnabled(true);
        if (paramView != null) {
            this.q = false;
            this.h.animateMapStatus(MapStatusUpdateFactory.newLatLng(this.e.location));
        }
    }

    public void onClick(View paramView) {
        paramView = getIntent().getAction();
        if ("com.farsunset.hoxin.ACTION_SELECT_ADDRESS".equals(paramView)) {
            MapAddress localMapAddress = new MapAddress();
            Object localObject = this.e;
            localMapAddress.name = ((PoiInfo) localObject).name;
            localMapAddress.address = ((PoiInfo) localObject).getAddress();
            localObject = this.e.location;
            localMapAddress.latitude = ((LatLng) localObject).latitude;
            localMapAddress.longitude = ((LatLng) localObject).longitude;
            localObject = new Intent();
            ((Intent) localObject).putExtra(MapAddress.class.getName(), localMapAddress);
            setResult(-1, (Intent) localObject);
            finish();
        }
        if ("com.farsunset.hoxin.ACTION_SELECT_CHAT_MAP".equals(paramView)) {
            int i1 = this.g.getMeasuredWidth();
            int i3 = this.g.getMeasuredHeight();
            int i2 = (int) (i1 / 2.4D);
            i3 = (i3 - i2) / 2;
            paramView = new Rect(0, i3, i1, i2 + i3);
            this.h.setMyLocationEnabled(false);
            this.h.snapshotScope(paramView, this);
            U0(getString(2131690077, new Object[]{getString(2131689535)}));
        }
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492890, paramMenu);
        this.f = ((Button) paramMenu.findItem(2131231192).getActionView().findViewById(2131230850));
        if ("com.farsunset.hoxin.ACTION_SELECT_ADDRESS".equals(getIntent().getAction())) {
            this.f.setText(2131689522);
        }
        if ("com.farsunset.hoxin.ACTION_SELECT_CHAT_MAP".equals(getIntent().getAction())) {
            this.f.setText(2131689555);
        }
        this.f.setEnabled(false);
        this.f.setOnClickListener(this);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        this.g.onDestroy();
        this.i.unRegisterLocationListener(this.t);
        this.i.stop();
        u3.d.z(this.s);
    }

    public void onGetGeoCodeResult(GeoCodeResult paramGeoCodeResult) {
    }

    public void onGetPoiDetailResult(PoiDetailResult paramPoiDetailResult) {
    }

    public void onGetPoiDetailResult(PoiDetailSearchResult paramPoiDetailSearchResult) {
    }

    public void onGetPoiIndoorResult(PoiIndoorResult paramPoiIndoorResult) {
    }

    public void onGetPoiResult(PoiResult paramPoiResult) {
        if ((paramPoiResult.error == SearchResult.ERRORNO.NO_ERROR) && (paramPoiResult.getAllPoi() != null)) {
            if (paramPoiResult.getAllPoi().isEmpty()) {
                return;
            }
            Iterator localIterator = paramPoiResult.getAllPoi().iterator();
            while (localIterator.hasNext()) {
                PoiInfo localPoiInfo = (PoiInfo) localIterator.next();
                LatLng localLatLng = localPoiInfo.location;
                Location localLocation = this.s;
                localPoiInfo.distance = ((int) DistanceUtil.getDistance(localLatLng, new LatLng(localLocation.latitude, localLocation.longitude)));
            }
            this.m.I(paramPoiResult.getAllPoi(), this.l.getText());
            this.k.s1(0);
            this.f.setEnabled(false);
        }
    }

    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult paramReverseGeoCodeResult) {
        this.r.setSelected(false);
        this.j.setVisibility(8);
        this.k.setVisibility(0);
        if ((paramReverseGeoCodeResult.error == SearchResult.ERRORNO.NO_ERROR) && (paramReverseGeoCodeResult.getPoiList() != null)) {
            if (paramReverseGeoCodeResult.getPoiList().isEmpty()) {
                return;
            }
            this.m.I(paramReverseGeoCodeResult.getPoiList(), null);
            this.k.s1(0);
            this.f.setEnabled(true);
        }
    }

    public void onLocationClick(View paramView) {
        this.i.start();
        this.l.a();
    }

    public void onMapLoaded() {
        this.h.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0F));
        this.i.start();
    }

    public void onMapStatusChange(MapStatus paramMapStatus) {
    }

    public void onMapStatusChangeFinish(MapStatus paramMapStatus) {
        this.l.b();
        if ((this.p) && (this.q)) {
            i1(paramMapStatus.target, true);
        }
        this.q = true;
    }

    public void onMapStatusChangeStart(MapStatus paramMapStatus) {
    }

    public void onMapStatusChangeStart(MapStatus paramMapStatus, int paramInt) {
    }

    public void onPause() {
        super.onPause();
        this.g.onPause();
    }

    public void onResume() {
        super.onResume();
        this.g.onResume();
    }

    public void onSnapshotReady(Bitmap paramBitmap) {
        J0();
        Object localObject1 = a0.g(l.K());
        u3.p.d(paramBitmap, (File) localObject1);
        paramBitmap = new ChatMap();
        Object localObject2 = this.e;
        paramBitmap.address = ((PoiInfo) localObject2).address;
        paramBitmap.name = ((PoiInfo) localObject2).name;
        localObject2 = ((PoiInfo) localObject2).location;
        paramBitmap.latitude = ((LatLng) localObject2).latitude;
        paramBitmap.longitude = ((LatLng) localObject2).longitude;
        paramBitmap.image = ((File) localObject1).getName();
        localObject1 = new Intent();
        ((Intent) localObject1).putExtra(ChatMap.class.getName(), paramBitmap);
        setResult(-1, (Intent) localObject1);
        finish();
    }

    class a
            extends BDAbstractLocationListener {
        a() {
        }

        public void onReceiveLocation(BDLocation paramBDLocation) {
            MapLocationActivity.a1(MapLocationActivity.this).stop();
            if (paramBDLocation == null) {
                return;
            }
            MapLocationActivity.b1(MapLocationActivity.this, true);
            double d1 = paramBDLocation.getLatitude();
            double d2 = paramBDLocation.getLongitude();
            MapLocationActivity.d1(MapLocationActivity.this, new Location());
            MapLocationActivity.c1(MapLocationActivity.this).latitude = d1;
            MapLocationActivity.c1(MapLocationActivity.this).longitude = d2;
            MapLocationActivity.c1(MapLocationActivity.this).city = paramBDLocation.getCity();
            paramBDLocation = new MyLocationData.Builder().accuracy(paramBDLocation.getRadius()).direction(paramBDLocation.getDirection()).latitude(d1).longitude(d2).build();
            MapLocationActivity.e1(MapLocationActivity.this).setMyLocationData(paramBDLocation);
            MapLocationActivity.f1(MapLocationActivity.this, false);
            MapLocationActivity.g1(MapLocationActivity.this, new LatLng(d1, d2), false);
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.MapLocationActivity

 * JD-Core Version:    0.7.0.1

 */