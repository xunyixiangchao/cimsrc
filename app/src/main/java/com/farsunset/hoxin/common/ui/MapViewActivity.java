package com.farsunset.hoxin.common.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMap.OnMapLoadedCallback;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.MapAddress;

import u3.d;
import u3.l;

public class MapViewActivity
        extends BaseActivity
        implements BaiduMap.OnMapLoadedCallback {
    private MapView e;
    private BaiduMap f;
    private MapAddress g;

    public int H0() {
        return 2131427385;
    }

    public void M0() {
        this.e = ((MapView) findViewById(2131231153));
        if (d.q()) {
            this.e.setMapCustomStylePath(l.F());
            this.e.setMapCustomStyleEnable(true);
        }
        this.e.showZoomControls(false);
        Object localObject = this.e.getMap();
        this.f = ((BaiduMap) localObject);
        ((BaiduMap) localObject).setOnMapLoadedCallback(this);
        localObject = (MapAddress) getIntent().getSerializableExtra(MapAddress.class.getName());
        this.g = ((MapAddress) localObject);
        S0(((MapAddress) localObject).name);
        R0(this.g.address);
        localObject = this.g;
        localObject = new LatLng(((MapAddress) localObject).latitude, ((MapAddress) localObject).longitude);
        MarkerOptions localMarkerOptions = new MarkerOptions().position((LatLng) localObject).icon(BitmapDescriptorFactory.fromBitmap(l.u(this, 2131165538))).zIndex(9).draggable(true);
        this.f.addOverlay(localMarkerOptions);
        localObject = MapStatusUpdateFactory.newLatLng((LatLng) localObject);
        this.f.animateMapStatus((MapStatusUpdate) localObject);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492891, paramMenu);
        paramMenu.findItem(2131231210).setIcon(2131165571);
        paramMenu.findItem(2131231210).setTitle(2131689540);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public void onDestroy() {
        super.onDestroy();
        this.e.onDestroy();
    }

    public void onMapLoaded() {
        this.f.setMapStatus(MapStatusUpdateFactory.zoomTo(16.0F));
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231210) {
            Intent localIntent = new Intent("android.intent.action.VIEW");
            localIntent.addFlags(268435456);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("geo:");
            localStringBuilder.append(this.g.latitude);
            localStringBuilder.append(",");
            localStringBuilder.append(this.g.longitude);
            localStringBuilder.append("?q=");
            localStringBuilder.append(this.g.name);
            localIntent.setData(Uri.parse(localStringBuilder.toString()));
            HoxinApplication.h().startActivity(localIntent);
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onPause() {
        super.onPause();
        this.e.onPause();
    }

    public void onResume() {
        super.onResume();
        this.e.onResume();
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.MapViewActivity

 * JD-Core Version:    0.7.0.1

 */