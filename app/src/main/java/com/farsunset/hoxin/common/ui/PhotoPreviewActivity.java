package com.farsunset.hoxin.common.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.widget.WebPhotoView;

import u3.l;

public class PhotoPreviewActivity
        extends BaseActivity {
    public int H0() {
        return 2131427406;
    }

    public int I0() {
        return 2131690168;
    }

    public void M0() {
        WebPhotoView localWebPhotoView = (WebPhotoView) findViewById(2131231355);
        CloudImage localCloudImage = (CloudImage) getIntent().getSerializableExtra(CloudImage.class.getName());
        String str = localCloudImage.uri;
        if (str == null) {
            str = l.w(localCloudImage);
        }
        localWebPhotoView.b(str, null);
    }

    public void onClick(View paramView) {
        setResult(-1);
        finish();
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        getMenuInflater().inflate(2131492890, paramMenu);
        Button localButton = (Button) paramMenu.findItem(2131231192).getActionView().findViewById(2131230850);
        localButton.setOnClickListener(this);
        int i;
        if ("com.farsunset.hoxin.ACTION_FROM_CHATTING".equals(getIntent().getAction())) {
            i = 2131689555;
        } else {
            i = 2131689562;
        }
        localButton.setText(i);
        return super.onCreateOptionsMenu(paramMenu);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.PhotoPreviewActivity

 * JD-Core Version:    0.7.0.1

 */