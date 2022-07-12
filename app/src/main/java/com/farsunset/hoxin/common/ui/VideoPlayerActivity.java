package com.farsunset.hoxin.common.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.MediaStore;
import android.provider.MediaStore.Video.Media;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.MediaController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import ca.a;

import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.widget.CircleProgressView;
import com.farsunset.hoxin.common.widget.TextureVideoView;
import com.farsunset.hoxin.common.widget.WebImageView;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.ui.MessageForwardActivity;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import s3.c;
import s3.f;
import s3.u;
import u3.a0;
import u3.b0;
import u3.l;
import u3.z;

public class VideoPlayerActivity
        extends BaseActivity
        implements f, MediaPlayer.OnPreparedListener, c, u<Integer>, MediaPlayer.OnCompletionListener {
    private TextureVideoView e;
    private CircleProgressView f;
    private WebImageView g;
    private CloudVideo h;
    private String i;
    private File j;
    private r3.d k;
    private MediaController l;

    private void b1() {
        Object localObject1 = this.j;
        if (localObject1 == null) {
            return;
        }
        localObject1 = a0.b(((File) localObject1).getName());
        l.l(this.j, (File) localObject1);
        Object localObject2 = new ContentValues();
        ((ContentValues) localObject2).put("title", this.j.getName());
        ((ContentValues) localObject2).put("_display_name", this.j.getName());
        ((ContentValues) localObject2).put("mime_type", "video/mp4");
        ((ContentValues) localObject2).put("_size", Long.valueOf(this.j.length()));
        ((ContentValues) localObject2).put("date_added", Long.valueOf(System.currentTimeMillis()));
        ((ContentValues) localObject2).put("date_modified", Long.valueOf(System.currentTimeMillis()));
        ((ContentValues) localObject2).put("datetaken", Long.valueOf(System.currentTimeMillis()));
        ((ContentValues) localObject2).put("_data", ((File) localObject1).getAbsolutePath());
        localObject1 = getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, (ContentValues) localObject2);
        if ((Build.VERSION.SDK_INT >= 29) && (getApplicationInfo().targetSdkVersion >= 29)) {
        }
        try {
            localObject2 = getContentResolver().openOutputStream((Uri) localObject1);
            a.e(this.j, (OutputStream) localObject2);
            label180:
            sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", (Uri) localObject1));
            Y0(getString(2131690106));
            return;
        } catch (IOException localIOException) {
            break label180;
        }
    }

    private void c1(String paramString, File paramFile) {
        this.i = paramString;
        this.f.setVisibility(0);
        z.f(paramFile, paramString, this);
    }

    private void d1() {
        this.j = a0.g(this.h.video);
        Object localObject = this.h.image;
        if (localObject == null) {
            p(null, this.g, null);
            return;
        }
        localObject = a0.g((String) localObject);
        if (((File) localObject).exists()) {
            this.g.n((File) localObject, this);
            return;
        }
        localObject = this.h;
        localObject = b0.f(((CloudVideo) localObject).bucket, ((CloudVideo) localObject).image);
        this.g.r((String) localObject, this);
    }

    private boolean e1() {
        return "com.farsunset.hoxin.ACTION_FROM_RECORD_VIDEO_PREVIEW".equals(getIntent().getAction());
    }

    private void g1() {
        Message localMessage = new Message();
        localMessage.format = 3;
        localMessage.content = l.H0(this.h);
        Intent localIntent = new Intent(this, MessageForwardActivity.class);
        localIntent.putExtra(Message.NAME, localMessage);
        startActivity(localIntent);
    }

    private void h1(Uri paramUri) {
        this.f.setVisibility(8);
        this.e.setVideoURI(paramUri);
        this.e.start();
    }

    private void i1(File paramFile) {
        this.f.setVisibility(8);
        this.e.setVideoPath(paramFile.getAbsolutePath());
        this.e.start();
    }

    private void j1() {
        this.e.setAlpha(1.0F);
        Animation localAnimation = AnimationUtils.loadAnimation(this, 2130772003);
        localAnimation.setFillAfter(true);
        localAnimation.setDuration(0L);
        this.g.startAnimation(localAnimation);
    }

    public int H0() {
        return 2131427411;
    }

    public void M0() {
        setStatusBarColor(17170444);
        supportPostponeEnterTransition();
        getWindow().setBackgroundDrawableResource(17170444);
        this.e = ((TextureVideoView) findViewById(2131231609));
        this.g = ((WebImageView) findViewById(2131231552));
        this.f = ((CircleProgressView) findViewById(2131231369));
        this.e.setOnPreparedListener(this);
        this.e.setOnCompletionListener(this);
        this.h = ((CloudVideo) getIntent().getSerializableExtra(CloudVideo.class.getName()));
        d1();
        Object localObject = this.e;
        MediaController localMediaController = new MediaController(this);
        this.l = localMediaController;
        ((TextureVideoView) localObject).setMediaController(localMediaController);
        localObject = new r3.d(this);
        this.k = ((r3.d) localObject);
        ((r3.d) localObject).o(this);
    }

    public void O(File paramFile, String paramString) {
        this.f.a();
    }

    public void f1(Integer paramInteger) {
        if (paramInteger.intValue() == 2131231238) {
            b1();
        }
        if (paramInteger.intValue() == 2131231245) {
            g1();
        }
    }

    public void l0(Object paramObject, ImageView paramImageView) {
        p(paramObject, paramImageView, null);
    }

    public void o0(File paramFile, String paramString) {
        i1(this.j);
    }

    public void onBackPressed() {
        this.l.hide();
        this.f.setVisibility(8);
        this.e.C();
        this.e.setVisibility(8);
        z.s(this.i);
        supportFinishAfterTransition();
    }

    public void onCompletion(MediaPlayer paramMediaPlayer) {
        paramMediaPlayer.start();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
    }

    public boolean onCreateOptionsMenu(Menu paramMenu) {
        MenuInflater localMenuInflater;
        int m;
        if (e1()) {
            localMenuInflater = getMenuInflater();
            m = 2131492889;
        } else {
            localMenuInflater = getMenuInflater();
            m = 2131492880;
        }
        localMenuInflater.inflate(m, paramMenu);
        return super.onCreateOptionsMenu(paramMenu);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
        if (paramMenuItem.getItemId() == 2131231241) {
            setResult(-1);
            onBackPressed();
        }
        if (paramMenuItem.getItemId() == 2131231213) {
            this.k.show();
        }
        return super.onOptionsItemSelected(paramMenuItem);
    }

    public void onPointerCaptureChanged(boolean paramBoolean) {
    }

    public void onPrepared(MediaPlayer paramMediaPlayer) {
        this.g.postDelayed(new t3.d(this), 300L);
    }

    public void onStop() {
        super.onStop();
        this.e.C();
    }

    public void p(Object paramObject, ImageView paramImageView, BitmapDrawable paramBitmapDrawable) {
        supportStartPostponedEnterTransition();
        paramObject = this.h.uri;
        if (paramObject != null) {
            h1(Uri.parse(paramObject));
            return;
        }
        if ((this.j.exists()) && (this.j.length() == this.h.size)) {
            i1(this.j);
            return;
        }
        if ((this.j.exists()) && (this.j.length() > this.h.size)) {
            this.j.delete();
        }
        paramObject = this.h;
        c1(b0.f(paramObject.bucket, paramObject.video), this.j);
    }

    public void z0(String paramString, float paramFloat) {
        this.f.setVisibility(0);
        this.f.setProgress((int) paramFloat);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.ui.VideoPlayerActivity

 * JD-Core Version:    0.7.0.1

 */