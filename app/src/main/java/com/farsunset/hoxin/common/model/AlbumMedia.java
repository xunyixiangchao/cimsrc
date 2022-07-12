package com.farsunset.hoxin.common.model;

import android.net.Uri;

import java.io.Serializable;

public class AlbumMedia
        implements Serializable {
    private static final transient long serialVersionUID = 1L;
    public long duration;
    public String mimeType;
    public long size;
    public Uri uri;

    public boolean equals(Object paramObject) {
        if ((paramObject instanceof AlbumMedia)) {
            return this.uri.equals(((AlbumMedia) paramObject).uri);
        }
        return false;
    }

    public boolean isImage() {
        return this.mimeType.startsWith("image/");
    }

    public boolean isVideo() {
        return this.mimeType.startsWith("video/");
    }
}



/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\

 * Qualified Name:     com.farsunset.hoxin.common.model.AlbumMedia

 * JD-Core Version:    0.7.0.1

 */