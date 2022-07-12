package u3;

import android.app.Activity;
import android.app.Application;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.farsunset.hoxin.HoxinApplication;
import com.farsunset.hoxin.common.model.CloudImage;
import com.farsunset.hoxin.common.model.CloudVideo;
import com.farsunset.hoxin.common.model.SharedFile;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCrop.Options;
import i8.c;
import i8.d;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.webrtc.Camera1Enumerator;
import org.webrtc.Camera2Enumerator;
import org.webrtc.CameraEnumerator;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.VideoCapturer;
import s3.w;

public class l
{
  public static File A(long paramLong)
  {
    return a0.g(String.format("group_%s_icon.png", new Object[] { Long.valueOf(paramLong) }));
  }
  
  public static void A0(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Toast.makeText(paramContext, paramString, 0).show();
  }
  
  public static String B(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      label14:
      break label14;
    }
    return null;
  }
  
  public static void B0(View paramView, int paramInt)
  {
    paramView.startAnimation(AnimationUtils.loadAnimation(HoxinApplication.h(), paramInt));
  }
  
  private static String C(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ca.b.b(paramString));
    localStringBuilder.append(".jpg");
    return localStringBuilder.toString();
  }
  
  public static void C0(AppCompatActivity paramAppCompatActivity)
  {
    c8.b.j(paramAppCompatActivity).b().a(c.b).d(new h(paramAppCompatActivity)).c(new i(paramAppCompatActivity)).start();
  }
  
  public static Uri D(Cursor paramCursor)
  {
    long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    paramCursor = paramCursor.getString(paramCursor.getColumnIndex("mime_type"));
    if (b0(paramCursor)) {
      paramCursor = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }
    for (;;)
    {
      return ContentUris.withAppendedId(paramCursor, l);
      if (f0(paramCursor)) {
        paramCursor = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
      } else {
        paramCursor = MediaStore.Files.getContentUri("external");
      }
    }
  }
  
  public static void D0(AppCompatActivity paramAppCompatActivity, Uri paramUri)
  {
    E0(paramAppCompatActivity, paramUri, 256, 256, 1, 1);
  }
  
  public static String E(long paramLong)
  {
    return new SimpleDateFormat("MM").format(new Date(paramLong));
  }
  
  public static void E0(AppCompatActivity paramAppCompatActivity, Uri paramUri, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    UCrop.Options localOptions = new UCrop.Options();
    localOptions.setCompressionFormat(Bitmap.CompressFormat.PNG);
    localOptions.setCompressionQuality(100);
    localOptions.setToolbarColor(androidx.core.content.b.b(paramAppCompatActivity, 2131034168));
    localOptions.setToolbarWidgetColor(androidx.core.content.b.b(paramAppCompatActivity, 2131034730));
    localOptions.setStatusBarColor(androidx.core.content.b.b(paramAppCompatActivity, 2131034168));
    localOptions.setActiveControlsWidgetColor(androidx.core.content.b.b(paramAppCompatActivity, 2131034167));
    localOptions.withAspectRatio(paramInt3, paramInt4);
    localOptions.withMaxResultSize(paramInt1, paramInt2);
    localOptions.setAllowedGestures(1, 2, 3);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(K());
    localStringBuilder.append(".jpg");
    UCrop.of(paramUri, Uri.fromFile(a0.g(localStringBuilder.toString()))).withOptions(localOptions).start(paramAppCompatActivity);
  }
  
  public static String F()
  {
    return a0.c("map_night.sty").getAbsolutePath();
  }
  
  public static void F0(AppCompatActivity paramAppCompatActivity, Uri paramUri)
  {
    E0(paramAppCompatActivity, paramUri, 720, 400, 9, 5);
  }
  
  private static String G(String paramString)
  {
    paramString = ca.b.c(paramString).toLowerCase();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(K());
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void G0(CameraVideoCapturer paramCameraVideoCapturer)
  {
    if (paramCameraVideoCapturer == null) {
      return;
    }
    try
    {
      paramCameraVideoCapturer.stopCapture();
      return;
    }
    catch (InterruptedException paramCameraVideoCapturer) {}
  }
  
  public static CharSequence H(long paramLong)
  {
    return DateUtils.getRelativeTimeSpanString(paramLong, System.currentTimeMillis(), 60000L, 262144);
  }
  
  public static String H0(Object paramObject)
  {
    return new v7.f().q(paramObject);
  }
  
  public static String I(int paramInt)
  {
    return HoxinApplication.h().getString(paramInt);
  }
  
  public static String I0(long paramLong)
  {
    paramLong /= 1000L;
    long l = paramLong / 60L;
    return new Formatter().format("%02d:%02d", new Object[] { Long.valueOf(l % 60L), Long.valueOf(paramLong % 60L) }).toString();
  }
  
  public static String J(int paramInt, Object... paramVarArgs)
  {
    return HoxinApplication.h().getString(paramInt, paramVarArgs);
  }
  
  public static void J0(int paramInt)
  {
    ((Vibrator)androidx.core.content.b.h(HoxinApplication.h(), Vibrator.class)).vibrate(paramInt);
  }
  
  public static String K()
  {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  
  public static Uri L(File paramFile)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return FileProvider.e(HoxinApplication.h(), "com.farsunset.hoxin.fileprovider", paramFile);
    }
    return Uri.fromFile(paramFile);
  }
  
  private static int M(Uri paramUri)
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(HoxinApplication.h(), paramUri);
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(9));
      return i;
    }
    catch (Exception paramUri)
    {
      label28:
      break label28;
    }
    return 0;
  }
  
  private static byte N(Uri paramUri)
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(HoxinApplication.h(), paramUri);
      int j = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(24));
      int i = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(18));
      int k = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(19));
      if (i > k) {
        i = 1;
      } else {
        i = 0;
      }
      if ((j != 0) && (j != 180)) {
        j = 0;
      } else {
        j = 1;
      }
      if ((j != 0) && (i != 0)) {
        return 0;
      }
      return 1;
    }
    catch (Exception paramUri) {}
    return 1;
  }
  
  private static File O(SharedFile paramSharedFile)
  {
    Object localObject = new MediaMetadataRetriever();
    ((MediaMetadataRetriever)localObject).setDataSource(HoxinApplication.h(), paramSharedFile.uri);
    localObject = ((MediaMetadataRetriever)localObject).getFrameAtTime();
    paramSharedFile = a0.g(C(paramSharedFile.name));
    p.f((Bitmap)localObject, paramSharedFile);
    return paramSharedFile;
  }
  
  public static File P(File paramFile)
  {
    Object localObject = new MediaMetadataRetriever();
    ((MediaMetadataRetriever)localObject).setDataSource(HoxinApplication.h(), L(paramFile));
    localObject = ((MediaMetadataRetriever)localObject).getFrameAtTime();
    paramFile = a0.g(C(paramFile.getName()));
    if (!paramFile.exists()) {
      p.f((Bitmap)localObject, paramFile);
    }
    return paramFile;
  }
  
  public static boolean Q(Context paramContext)
  {
    return c8.b.i(paramContext, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  public static boolean R(Context paramContext)
  {
    return c8.b.i(paramContext, c.b);
  }
  
  public static boolean S(long paramLong)
  {
    return a0.g(String.format("group_%s_icon.png", new Object[] { Long.valueOf(paramLong) })).exists();
  }
  
  public static boolean T(Context paramContext)
  {
    return c8.b.i(paramContext, c.i);
  }
  
  public static Spannable U(String paramString1, String paramString2)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString1);
    if (paramString2 != null)
    {
      if (paramString2.trim().length() == 0) {
        return localSpannableStringBuilder;
      }
      paramString1 = Pattern.compile(paramString2, 2).matcher(paramString1);
      while (paramString1.find()) {
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(androidx.core.content.b.b(HoxinApplication.h(), 2131034167)), paramString1.start(), paramString1.end(), 33);
      }
    }
    return localSpannableStringBuilder;
  }
  
  public static String V(long paramLong)
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
    localGregorianCalendar1.setTimeInMillis(paramLong);
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar();
    int i;
    if (localGregorianCalendar1.get(1) != localGregorianCalendar2.get(1)) {
      i = 524309;
    } else if (localGregorianCalendar1.get(6) != localGregorianCalendar2.get(6)) {
      i = 524305;
    } else {
      i = 524289;
    }
    return DateUtils.formatDateTime(HoxinApplication.h(), paramLong, i);
  }
  
  public static String W(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replaceAll("&nbsp;", " ").replaceAll("\\n", "\n");
  }
  
  public static String X(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return TextUtils.htmlEncode(paramString);
  }
  
  public static void Y()
  {
    File localFile = a0.c("map_night.sty");
    if (!localFile.exists()) {}
    try
    {
      ca.a.h(HoxinApplication.h().getAssets().open("style/map_night.sty"), localFile);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static boolean Z(CharSequence paramCharSequence)
  {
    return c0(paramCharSequence) ^ true;
  }
  
  public static boolean a0(Collection<?> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static boolean b0(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("image/"));
  }
  
  public static boolean c0(CharSequence paramCharSequence)
  {
    return (paramCharSequence != null) && (paramCharSequence.toString().trim().length() > 0);
  }
  
  public static boolean d0(Activity paramActivity, MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = ViewConfiguration.get(paramActivity).getScaledWindowTouchSlop();
    paramActivity = paramActivity.getWindow().getDecorView();
    int m = -k;
    return (i < m) || (j < m) || (i > paramActivity.getWidth() + k) || (j > paramActivity.getHeight() + k);
  }
  
  public static boolean e0(CloudImage paramCloudImage)
  {
    return Objects.equals(w(paramCloudImage), v(paramCloudImage));
  }
  
  public static boolean f0(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("video/"));
  }
  
  public static boolean g0()
  {
    boolean bool2 = false;
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)androidx.core.content.b.h(HoxinApplication.h(), ConnectivityManager.class)).getActiveNetworkInfo();
      boolean bool1 = bool2;
      if (localNetworkInfo != null)
      {
        int i = localNetworkInfo.getType();
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static void h(Context paramContext, w paramw)
  {
    if (Q(paramContext))
    {
      paramw.a();
      return;
    }
    c8.b.k(paramContext).b().a(new String[] { "android.permission.RECORD_AUDIO" }).d(new j(paramw)).c(new f(paramContext, paramw)).start();
  }
  
  public static void i(Context paramContext, w paramw)
  {
    c8.b.k(paramContext).b().a(c.d).d(new k(paramw)).c(new g(paramContext, paramw)).start();
  }
  
  public static void j(Cursor paramCursor)
  {
    if (paramCursor != null) {}
    try
    {
      paramCursor.close();
      return;
    }
    catch (Exception paramCursor) {}
  }
  
  public static boolean k(long[] paramArrayOfLong, long paramLong)
  {
    if (paramArrayOfLong != null)
    {
      if (paramArrayOfLong.length == 0) {
        return false;
      }
      int j = paramArrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfLong[i] == paramLong) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static void l(File paramFile1, File paramFile2)
  {
    try
    {
      ca.a.f(paramFile1, paramFile2);
      return;
    }
    catch (IOException paramFile1) {}
  }
  
  public static VideoCapturer m()
  {
    Object localObject;
    if (Camera2Enumerator.isSupported(HoxinApplication.h())) {
      localObject = new Camera2Enumerator(HoxinApplication.h());
    } else {
      localObject = new Camera1Enumerator(true);
    }
    String[] arrayOfString = ((CameraEnumerator)localObject).getDeviceNames();
    int k = arrayOfString.length;
    int j = 0;
    int i = 0;
    String str;
    while (i < k)
    {
      str = arrayOfString[i];
      if (((CameraEnumerator)localObject).isFrontFacing(str)) {
        return ((CameraEnumerator)localObject).createCapturer(str, null);
      }
      i += 1;
    }
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      if (!((CameraEnumerator)localObject).isFrontFacing(str)) {
        return ((CameraEnumerator)localObject).createCapturer(str, null);
      }
      i += 1;
    }
    return null;
  }
  
  public static void n(File paramFile)
  {
    if (!paramFile.exists()) {}
    try
    {
      ca.a.o(paramFile);
      paramFile.createNewFile();
      return;
    }
    catch (IOException paramFile) {}
  }
  
  public static void o(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {
      return;
    }
    try
    {
      paramMediaPlayer.stop();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramMediaPlayer.release();
          return;
        }
        catch (Exception paramMediaPlayer) {}
        localException = localException;
      }
    }
  }
  
  public static CloudVideo o0(Uri paramUri, o3.b paramb)
  {
    CloudVideo localCloudVideo = new CloudVideo();
    SharedFile localSharedFile = z(paramUri);
    localSharedFile.name = G(localSharedFile.name);
    localCloudVideo.duration = (M(paramUri) / 1000);
    localCloudVideo.size = localSharedFile.size;
    localCloudVideo.video = localSharedFile.name;
    localCloudVideo.uri = paramUri.toString();
    localCloudVideo.image = O(localSharedFile).getName();
    localCloudVideo.mode = N(paramUri);
    localCloudVideo.bucket = paramb.a();
    return localCloudVideo;
  }
  
  public static int p(float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, Resources.getSystem().getDisplayMetrics());
  }
  
  public static void p0(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -2);
    }
    int j = ViewGroup.getChildMeasureSpec(0, 0, localLayoutParams1.width);
    int i = localLayoutParams1.height;
    if (i > 0) {
      i = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    } else {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(j, i);
  }
  
  public static void q(String paramString1, String paramString2, String paramString3)
  {
    paramString2 = URLUtil.guessFileName(paramString1, paramString2, paramString3);
    paramString1 = new DownloadManager.Request(Uri.parse(paramString1));
    paramString1.allowScanningByMediaScanner();
    paramString1.setNotificationVisibility(1);
    paramString1.setAllowedNetworkTypes(3);
    paramString1.setTitle(HoxinApplication.h().getString(2131690044, new Object[] { paramString2 }));
    paramString1.setAllowedOverMetered(false);
    paramString1.setVisibleInDownloadsUi(false);
    paramString1.setAllowedOverRoaming(true);
    paramString1.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, paramString2);
    ((DownloadManager)androidx.core.content.b.h(HoxinApplication.h(), DownloadManager.class)).enqueue(paramString1);
  }
  
  public static void q0(AppCompatActivity paramAppCompatActivity)
  {
    Intent localIntent = new Intent("android.intent.action.OPEN_DOCUMENT");
    localIntent.setType("image/*");
    localIntent.addFlags(1);
    localIntent.addCategory("android.intent.category.OPENABLE");
    paramAppCompatActivity.startActivityForResult(localIntent, 9);
  }
  
  public static String r(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public static void r0()
  {
    Intent localIntent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
    localIntent.setFlags(268435456);
    if (Build.VERSION.SDK_INT >= 26)
    {
      localIntent.putExtra("android.provider.extra.APP_PACKAGE", HoxinApplication.h().getPackageName());
    }
    else
    {
      localIntent.putExtra("app_package", HoxinApplication.h().getPackageName());
      localIntent.putExtra("app_uid", HoxinApplication.h().getApplicationInfo().uid);
    }
    HoxinApplication.h().startActivity(localIntent);
  }
  
  public static String s(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramLong /= 1000L;
    int i = (int)(paramLong / 3600L);
    paramLong %= 3600L;
    int j = (int)(paramLong / 60L);
    int k = (int)(paramLong % 60L);
    if (i <= 9) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(i);
    localStringBuilder.append(":");
    if (j <= 9) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(j);
    localStringBuilder.append(":");
    if (k <= 9) {
      localStringBuilder.append("0");
    }
    localStringBuilder.append(k);
    return localStringBuilder.toString();
  }
  
  public static <T> T s0(String paramString, Class<T> paramClass)
  {
    return new v7.f().i(paramString, paramClass);
  }
  
  public static Spanned t(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Html.fromHtml(paramString);
  }
  
  public static <T> T t0(String paramString, Type paramType)
  {
    return new v7.f().j(paramString, paramType);
  }
  
  public static Bitmap u(Context paramContext, int paramInt)
  {
    paramContext = androidx.core.content.b.d(paramContext, paramInt);
    if ((paramContext instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramContext).getBitmap();
    }
    if ((!(paramContext instanceof VectorDrawable)) && (!(paramContext instanceof androidx.vectordrawable.graphics.drawable.h))) {
      throw new IllegalArgumentException("unsupported drawable type");
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramContext.getIntrinsicWidth(), paramContext.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramContext.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramContext.draw(localCanvas);
    return localBitmap;
  }
  
  public static <T> List<T> u0(String paramString, Class<T> paramClass)
  {
    paramClass = x7.b.o(null, ArrayList.class, new Type[] { paramClass });
    return (List)new v7.f().j(paramString, paramClass);
  }
  
  public static String v(CloudImage paramCloudImage)
  {
    Object localObject = paramCloudImage.uri;
    if (localObject != null) {
      return localObject;
    }
    localObject = a0.g(paramCloudImage.image);
    if (((File)localObject).exists()) {
      return L((File)localObject).toString();
    }
    return b0.f(paramCloudImage.bucket, paramCloudImage.image);
  }
  
  public static void v0(int paramInt)
  {
    MediaPlayer localMediaPlayer = MediaPlayer.create(HoxinApplication.h(), paramInt);
    localMediaPlayer.setAudioStreamType(3);
    localMediaPlayer.setOnCompletionListener(e.a);
    localMediaPlayer.start();
  }
  
  public static String w(CloudImage paramCloudImage)
  {
    Object localObject = paramCloudImage.uri;
    if (localObject != null) {
      return localObject;
    }
    localObject = a0.g(paramCloudImage.thumb);
    if (((File)localObject).exists()) {
      return L((File)localObject).toString();
    }
    return b0.f(paramCloudImage.bucket, paramCloudImage.thumb);
  }
  
  public static void w0(long paramLong)
  {
    a0.g(String.format("group_%s_icon.png", new Object[] { Long.valueOf(paramLong) })).delete();
  }
  
  public static String x(long paramLong)
  {
    return new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(new Date(paramLong));
  }
  
  public static void x0(long paramLong, Bitmap paramBitmap)
  {
    File localFile = a0.g(String.format("group_%s_icon.png", new Object[] { Long.valueOf(paramLong) }));
    ca.a.k(localFile);
    p.e(paramBitmap, localFile, Bitmap.CompressFormat.PNG);
    p3.b.a(L(localFile).toString());
  }
  
  public static String y(long paramLong)
  {
    return new SimpleDateFormat("dd").format(new Date(paramLong));
  }
  
  public static void y0(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof CheckBox)) {
      ((CheckBox)paramView).setChecked(paramBoolean);
    }
  }
  
  public static SharedFile z(Uri paramUri)
  {
    d1.a locala = d1.a.a(HoxinApplication.h(), paramUri);
    SharedFile localSharedFile = new SharedFile();
    localSharedFile.uri = paramUri;
    localSharedFile.name = locala.b();
    localSharedFile.size = locala.d();
    localSharedFile.lastModified = locala.c();
    return localSharedFile;
  }
  
  public static void z0(Context paramContext, int paramInt)
  {
    A0(paramContext, paramContext.getString(paramInt));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     u3.l
 * JD-Core Version:    0.7.0.1
 */