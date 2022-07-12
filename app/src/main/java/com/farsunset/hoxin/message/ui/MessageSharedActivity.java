package com.farsunset.hoxin.message.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.model.SharedFile;
import com.farsunset.hoxin.common.ui.BaseActivity;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatFile;
import com.farsunset.hoxin.message.model.ChatLink;

import java.util.Objects;

import o3.b;
import p5.c;
import u3.l;

public class MessageSharedActivity
        extends MessageForwardActivity {
    private void e1(Uri paramUri) {
        paramUri = l.z(paramUri);
        if (paramUri.size < 52428800L) {
            ChatFile localChatFile = new ChatFile();
            localChatFile.file = l.K();
            localChatFile.name = paramUri.name;
            localChatFile.size = paramUri.size;
            localChatFile.uri = paramUri.uri.toString();
            this.h.content = l.H0(localChatFile);
            this.h.format = 4;
            return;
        }
        X0(2131690047);
        finish();
    }

    private void f1(Uri paramUri) {
        CloudImage localCloudImage = new CloudImage();
        localCloudImage.uri = paramUri.toString();
        localCloudImage.bucket = b.f.a();
        this.h.content = l.H0(localCloudImage);
        this.h.format = 1;
    }

    private void g1() {
        String str = getIntent().getStringExtra("android.intent.extra.TEXT");
        Object localObject = getIntent().getStringExtra("android.intent.extra.SUBJECT");
        if (localObject == null) {
            localObject = this.h;
            ((Message) localObject).content = str;
            ((Message) localObject).format = 0;
            return;
        }
        ChatLink localChatLink = new ChatLink();
        localChatLink.url = str;
        localChatLink.title = ((String) localObject);
        this.h.content = l.H0(localChatLink);
        this.h.format = 6;
    }

    private void h1(Uri paramUri) {
        paramUri = l.o0(paramUri, b.f);
        if (paramUri.size > 52428800L) {
            X0(2131690047);
            finish();
            return;
        }
        this.h.content = l.H0(paramUri);
        this.h.format = 3;
    }

    public int I0() {
        return 2131689859;
    }

    public void M0() {
        if (!i3.e.q()) {
            HoxinApplication.h().r();
        }
        for (; ; ) {
            finish();
            return;
            super.M0();
            String str = getIntent().getType();
            Uri localUri = (Uri) getIntent().getParcelableExtra("android.intent.extra.STREAM");
            if ((localUri == null) && (Objects.equals(str, "text/plain"))) {
                g1();
                return;
            }
            if ((localUri != null) && (l.b0(str))) {
                f1(localUri);
                return;
            }
            if ((localUri != null) && (l.f0(str))) {
                h1(localUri);
                return;
            }
            if (localUri != null) {
                e1(localUri);
                return;
            }
            X0(2131690094);
        }
    }

    public Message a1() {
        Message localMessage = new Message();
        localMessage.id = System.currentTimeMillis();
        localMessage.createTime = Long.valueOf(System.currentTimeMillis());
        return localMessage;
    }

    public void m() {
        this.g.dismiss();
        U0(getString(2131690077, new Object[]{getString(2131689555)}));
        c.a(this.h, this.i);
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.message.ui.MessageSharedActivity

 * JD-Core Version:    0.7.0.1

 */