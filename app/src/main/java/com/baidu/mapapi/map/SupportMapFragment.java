package com.baidu.mapapi.map;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class SupportMapFragment
  extends Fragment
{
  private TextureMapView a;
  private BaiduMapOptions b;
  
  public SupportMapFragment() {}
  
  private SupportMapFragment(BaiduMapOptions paramBaiduMapOptions)
  {
    this.b = paramBaiduMapOptions;
  }
  
  public static SupportMapFragment newInstance()
  {
    return new SupportMapFragment();
  }
  
  public static SupportMapFragment newInstance(BaiduMapOptions paramBaiduMapOptions)
  {
    return new SupportMapFragment(paramBaiduMapOptions);
  }
  
  public BaiduMap getBaiduMap()
  {
    TextureMapView localTextureMapView = this.a;
    if (localTextureMapView == null) {
      return null;
    }
    return localTextureMapView.getMap();
  }
  
  public TextureMapView getMapView()
  {
    return this.a;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new TextureMapView(getActivity(), this.b);
    this.a = paramLayoutInflater;
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.a.onDestroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    this.a.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.baidu.mapapi.map.SupportMapFragment
 * JD-Core Version:    0.7.0.1
 */