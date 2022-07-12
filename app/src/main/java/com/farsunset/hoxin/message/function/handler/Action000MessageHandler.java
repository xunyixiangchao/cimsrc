package com.farsunset.hoxin.message.function.handler;

import android.os.Bundle;

import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.message.entity.Message;
import com.farsunset.hoxin.message.model.ChatEmoticon;
import com.farsunset.hoxin.message.model.ChatFile;
import com.farsunset.hoxin.message.model.ChatMap;
import com.farsunset.hoxin.message.model.ChatProfile;
import com.farsunset.hoxin.message.model.ChatVoice;

import g0.g;
import j5.b;

import java.io.File;

import l3.h;
import m5.e;
import u3.a0;
import u3.b0;
import u3.l;
import u3.r;
import u3.s;
import u3.z;

public class Action000MessageHandler
        implements MessageHandler {
    private static final g0.a<Byte, ResourceLoader> LOADER_ARRAY_MAP;

    static {
        g0.a locala = new g0.a();
        LOADER_ARRAY_MAP = locala;
        locala.put(Byte.valueOf((byte) 2), new VoiceFileLoader(null));
        locala.put(Byte.valueOf((byte) 1), new ImageFileLoader(null));
        locala.put(Byte.valueOf((byte) 5), new MapFileLoader(null));
        locala.put(Byte.valueOf((byte) 4), new FileLoader(null));
        locala.put(Byte.valueOf((byte) 3), new VideoFileLoader(null));
        locala.put(Byte.valueOf((byte) 14), new ProfileCardLoader(null));
        locala.put(Byte.valueOf((byte) 15), new EmoticonLoader(null));
    }

    public void handle(Message paramMessage, Bundle paramBundle, e parame) {
        if (!i4.a.o(paramMessage.sender.longValue())) {
            b.d(paramMessage.id);
            return;
        }
        loadResource(paramMessage);
        parame.c(paramMessage, paramBundle);
    }

    void loadResource(Message paramMessage) {
        ResourceLoader localResourceLoader = (ResourceLoader) LOADER_ARRAY_MAP.get(Byte.valueOf(paramMessage.format));
        if (localResourceLoader != null) {
            localResourceLoader.handle(paramMessage);
        }
    }

    private static class EmoticonLoader
            implements Action000MessageHandler.ResourceLoader {
        public void handle(Message paramMessage) {
            paramMessage = (ChatEmoticon) l.s0(paramMessage.content, ChatEmoticon.class);
            if (a4.a.e(paramMessage.id)) {
                return;
            }
            paramMessage = y3.a.e(paramMessage.id);
            if (paramMessage == null) {
                return;
            }
            paramMessage.state = -1;
            a4.a.a(paramMessage);
        }
    }

    private static class FileLoader
            implements Action000MessageHandler.ResourceLoader {
        public void handle(Message paramMessage) {
            if (!l.g0()) {
                return;
            }
            ChatFile localChatFile = (ChatFile) l.s0(paramMessage.content, ChatFile.class);
            File localFile = a0.e(localChatFile.name);
            l.n(localFile);
            localFile.setLastModified(paramMessage.createTime.longValue());
            if (!localFile.exists()) {
                z.g(b0.b(localChatFile.file), localFile);
            }
        }
    }

    private static class ImageFileLoader
            implements Action000MessageHandler.ResourceLoader {
        public void handle(Message paramMessage) {
            paramMessage = (CloudImage) l.s0(paramMessage.content, CloudImage.class);
            s.a().c(b0.c(paramMessage.thumb));
        }
    }

    private static class MapFileLoader
            implements Action000MessageHandler.ResourceLoader {
        public void handle(Message paramMessage) {
            paramMessage = (ChatMap) l.s0(paramMessage.content, ChatMap.class);
            s.a().c(b0.c(paramMessage.image));
        }
    }

    private static class ProfileCardLoader
            implements Action000MessageHandler.ResourceLoader {
        public void handle(Message paramMessage) {
            paramMessage = (ChatProfile) l.s0(paramMessage.content, ChatProfile.class);
            if (i4.a.e(paramMessage.id.longValue())) {
                return;
            }
            i4.a.a(h.e(paramMessage.id.longValue()), (byte) 3);
        }
    }

    private static abstract interface ResourceLoader {
        public abstract void handle(Message paramMessage);
    }

    private static class VideoFileLoader
            implements Action000MessageHandler.ResourceLoader {
        public void handle(Message paramMessage) {
            paramMessage = (CloudVideo) l.s0(paramMessage.content, CloudVideo.class);
            s.a().c(b0.c(paramMessage.image));
            if ((!a0.g(paramMessage.video).exists()) && (l.g0())) {
                z.g(b0.b(paramMessage.video), a0.g(paramMessage.video));
            }
        }
    }

    private static class VoiceFileLoader
            implements Action000MessageHandler.ResourceLoader {
        public void handle(Message paramMessage) {
            paramMessage = (ChatVoice) l.s0(paramMessage.content, ChatVoice.class);
            File localFile = a0.g(paramMessage.file);
            if (!localFile.exists()) {
                z.g(b0.b(paramMessage.file), localFile);
            }
        }
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.message.function.handler.Action000MessageHandler

 * JD-Core Version:    0.7.0.1

 */