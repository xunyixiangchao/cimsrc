package q9;

import a9.f;
import aa.y;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import l9.b0;
import l9.c0;
import l9.c0.a;
import l9.d0;
import l9.f0;
import l9.f0.a;
import l9.g.b;
import l9.h0;
import l9.t;
import l9.v.a;
import r9.d.a;
import u9.h.a;

public final class b
  implements n.c, d.a
{
  public static final a s = new a(null);
  private final b0 a;
  private final h b;
  private final k c;
  private final h0 d;
  private final List<h0> e;
  private final int f;
  private final d0 g;
  private final int h;
  private final boolean i;
  private final t j;
  private volatile boolean k;
  private Socket l;
  private Socket m;
  private l9.v n;
  private c0 o;
  private aa.d p;
  private aa.c q;
  private i r;
  
  public b(b0 paramb0, h paramh, k paramk, h0 paramh0, List<h0> paramList, int paramInt1, d0 paramd0, int paramInt2, boolean paramBoolean)
  {
    this.a = paramb0;
    this.b = paramh;
    this.c = paramk;
    this.d = paramh0;
    this.e = paramList;
    this.f = paramInt1;
    this.g = paramd0;
    this.h = paramInt2;
    this.i = paramBoolean;
    this.j = paramh.o();
  }
  
  private final void j()
  {
    Object localObject = e().b().type();
    int i1;
    if (localObject == null) {
      i1 = -1;
    } else {
      i1 = b.a[localObject.ordinal()];
    }
    if ((i1 != 1) && (i1 != 2))
    {
      localObject = new Socket(e().b());
    }
    else
    {
      localObject = e().a().j().createSocket();
      f.c(localObject);
    }
    this.l = ((Socket)localObject);
    if (!this.k)
    {
      ((Socket)localObject).setSoTimeout(this.a.F());
      try
      {
        u9.h.a.g().f((Socket)localObject, e().d(), this.a.k());
        try
        {
          this.p = aa.l.b(aa.l.g((Socket)localObject));
          this.q = aa.l.a(aa.l.e((Socket)localObject));
          return;
        }
        catch (NullPointerException localNullPointerException)
        {
          if (!f.a(localNullPointerException.getMessage(), "throw with null exception")) {
            return;
          }
          throw new IOException(localNullPointerException);
        }
        ConnectException localConnectException2;
        throw new IOException("canceled");
      }
      catch (ConnectException localConnectException1)
      {
        localConnectException2 = new ConnectException(f.m("Failed to connect to ", e().d()));
        localConnectException2.initCause(localConnectException1);
        throw localConnectException2;
      }
    }
  }
  
  private final void k(SSLSocket paramSSLSocket, l9.l paraml)
  {
    final l9.a locala = e().a();
    try
    {
      if (paraml.h()) {
        u9.h.a.g().e(paramSSLSocket, locala.l().i(), locala.f());
      }
      paramSSLSocket.startHandshake();
      Object localObject1 = paramSSLSocket.getSession();
      Object localObject2 = l9.v.e;
      f.e(localObject1, "sslSocketSession");
      localObject2 = ((v.a)localObject2).a((SSLSession)localObject1);
      Object localObject3 = locala.e();
      f.c(localObject3);
      boolean bool = ((HostnameVerifier)localObject3).verify(locala.l().i(), (SSLSession)localObject1);
      localObject1 = null;
      if (!bool)
      {
        paraml = ((l9.v)localObject2).d();
        if ((paraml.isEmpty() ^ true))
        {
          paraml = (X509Certificate)paraml.get(0);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("\n            |Hostname ");
          ((StringBuilder)localObject1).append(locala.l().i());
          ((StringBuilder)localObject1).append(" not verified:\n            |    certificate: ");
          ((StringBuilder)localObject1).append(l9.g.c.a(paraml));
          ((StringBuilder)localObject1).append("\n            |    DN: ");
          ((StringBuilder)localObject1).append(paraml.getSubjectDN().getName());
          ((StringBuilder)localObject1).append("\n            |    subjectAltNames: ");
          ((StringBuilder)localObject1).append(x9.d.a.a(paraml));
          ((StringBuilder)localObject1).append("\n            ");
          throw new SSLPeerUnverifiedException(f9.l.e(((StringBuilder)localObject1).toString(), null, 1, null));
        }
        paraml = new StringBuilder();
        paraml.append("Hostname ");
        paraml.append(locala.l().i());
        paraml.append(" not verified (no certificates)");
        throw new SSLPeerUnverifiedException(paraml.toString());
      }
      localObject3 = locala.a();
      f.c(localObject3);
      localObject2 = new l9.v(((l9.v)localObject2).e(), ((l9.v)localObject2).a(), ((l9.v)localObject2).c(), new d((l9.g)localObject3, (l9.v)localObject2, locala));
      this.n = ((l9.v)localObject2);
      ((l9.g)localObject3).b(locala.l().i(), new c((l9.v)localObject2));
      if (paraml.h()) {
        localObject1 = u9.h.a.g().g(paramSSLSocket);
      }
      this.m = paramSSLSocket;
      this.p = aa.l.b(aa.l.g(paramSSLSocket));
      this.q = aa.l.a(aa.l.e(paramSSLSocket));
      if (localObject1 != null) {
        paraml = c0.b.a((String)localObject1);
      } else {
        paraml = c0.d;
      }
      this.o = paraml;
      u9.h.a.g().b(paramSSLSocket);
      return;
    }
    finally
    {
      u9.h.a.g().b(paramSSLSocket);
      m9.o.g(paramSSLSocket);
    }
  }
  
  private final b m(int paramInt1, d0 paramd0, int paramInt2, boolean paramBoolean)
  {
    return new b(this.a, this.b, this.c, e(), this.e, paramInt1, paramd0, paramInt2, paramBoolean);
  }
  
  private final d0 o()
  {
    d0 locald0 = this.g;
    f.c(locald0);
    Object localObject1 = e().a().l();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("CONNECT ");
    ((StringBuilder)localObject2).append(m9.o.s((l9.x)localObject1, true));
    ((StringBuilder)localObject2).append(" HTTP/1.1");
    localObject1 = ((StringBuilder)localObject2).toString();
    aa.c localc;
    Object localObject3;
    for (;;)
    {
      localObject2 = this.p;
      f.c(localObject2);
      localc = this.q;
      f.c(localc);
      s9.b localb = new s9.b(null, this, (aa.d)localObject2, localc);
      localObject3 = ((aa.x)localObject2).c();
      long l1 = this.a.F();
      TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
      ((y)localObject3).g(l1, localTimeUnit);
      localc.c().g(this.a.K(), localTimeUnit);
      localb.A(locald0.e(), (String)localObject1);
      localb.c();
      localObject3 = localb.h(false);
      f.c(localObject3);
      localObject3 = ((f0.a)localObject3).q(locald0).c();
      localb.z((f0)localObject3);
      int i1 = ((f0)localObject3).B();
      if (i1 == 200) {
        break label316;
      }
      if (i1 != 407) {
        break label294;
      }
      locald0 = e().a().h().a(e(), (f0)localObject3);
      if (locald0 == null) {
        break;
      }
      if (f9.l.l("close", f0.h0((f0)localObject3, "Connection", null, 2, null), true)) {
        return locald0;
      }
    }
    throw new IOException("Failed to authenticate with proxy");
    label294:
    throw new IOException(f.m("Unexpected response code for CONNECT: ", Integer.valueOf(((f0)localObject3).B())));
    label316:
    if ((((aa.d)localObject2).b().D()) && (localc.b().D())) {
      return null;
    }
    throw new IOException("TLS tunnel buffered too many bytes!");
  }
  
  public n.c a()
  {
    return new b(this.a, this.b, this.c, e(), this.e, this.f, this.g, this.h, this.i);
  }
  
  /* Error */
  public n.a b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 155	q9/b:l	Ljava/net/Socket;
    //   4: astore 5
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore 4
    //   11: iconst_0
    //   12: istore_2
    //   13: aload 5
    //   15: ifnull +8 -> 23
    //   18: iconst_1
    //   19: istore_1
    //   20: goto +5 -> 25
    //   23: iconst_0
    //   24: istore_1
    //   25: iload_1
    //   26: ifeq +786 -> 812
    //   29: aload_0
    //   30: invokevirtual 531	q9/b:d	()Z
    //   33: iconst_1
    //   34: ixor
    //   35: ifeq +763 -> 798
    //   38: aload_0
    //   39: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   42: invokevirtual 139	l9/h0:a	()Ll9/a;
    //   45: invokevirtual 533	l9/a:b	()Ljava/util/List;
    //   48: astore 5
    //   50: aload_0
    //   51: getfield 81	q9/b:b	Lq9/h;
    //   54: invokevirtual 536	q9/h:s	()Ljava/util/concurrent/CopyOnWriteArrayList;
    //   57: aload_0
    //   58: invokeinterface 540 2 0
    //   63: pop
    //   64: aconst_null
    //   65: astore 8
    //   67: iload_3
    //   68: istore_1
    //   69: aload_0
    //   70: getfield 91	q9/b:g	Ll9/d0;
    //   73: ifnull +90 -> 163
    //   76: iload_3
    //   77: istore_1
    //   78: aload_0
    //   79: invokevirtual 542	q9/b:l	()Lq9/n$a;
    //   82: astore 6
    //   84: iload_3
    //   85: istore_1
    //   86: aload 6
    //   88: invokevirtual 546	q9/n$a:c	()Lq9/n$c;
    //   91: ifnonnull +17 -> 108
    //   94: iload_3
    //   95: istore_1
    //   96: aload 6
    //   98: invokevirtual 549	q9/n$a:e	()Ljava/lang/Throwable;
    //   101: astore 7
    //   103: aload 7
    //   105: ifnull +58 -> 163
    //   108: aload_0
    //   109: getfield 81	q9/b:b	Lq9/h;
    //   112: invokevirtual 536	q9/h:s	()Ljava/util/concurrent/CopyOnWriteArrayList;
    //   115: aload_0
    //   116: invokeinterface 552 2 0
    //   121: pop
    //   122: aload_0
    //   123: getfield 389	q9/b:m	Ljava/net/Socket;
    //   126: astore 5
    //   128: aload 5
    //   130: ifnonnull +6 -> 136
    //   133: goto +8 -> 141
    //   136: aload 5
    //   138: invokestatic 411	m9/o:g	(Ljava/net/Socket;)V
    //   141: aload_0
    //   142: getfield 155	q9/b:l	Ljava/net/Socket;
    //   145: astore 5
    //   147: aload 5
    //   149: ifnonnull +6 -> 155
    //   152: aload 6
    //   154: areturn
    //   155: aload 5
    //   157: invokestatic 411	m9/o:g	(Ljava/net/Socket;)V
    //   160: aload 6
    //   162: areturn
    //   163: iload_3
    //   164: istore_1
    //   165: aload_0
    //   166: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   169: invokevirtual 139	l9/h0:a	()Ll9/a;
    //   172: invokevirtual 555	l9/a:k	()Ljavax/net/ssl/SSLSocketFactory;
    //   175: ifnull +187 -> 362
    //   178: iload_3
    //   179: istore_1
    //   180: aload_0
    //   181: getfield 102	q9/b:j	Ll9/t;
    //   184: aload_0
    //   185: getfield 81	q9/b:b	Lq9/h;
    //   188: invokevirtual 560	l9/t:B	(Ll9/e;)V
    //   191: iload_3
    //   192: istore_1
    //   193: aload_0
    //   194: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   197: invokevirtual 139	l9/h0:a	()Ll9/a;
    //   200: invokevirtual 555	l9/a:k	()Ljavax/net/ssl/SSLSocketFactory;
    //   203: aload_0
    //   204: getfield 155	q9/b:l	Ljava/net/Socket;
    //   207: aload_0
    //   208: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   211: invokevirtual 139	l9/h0:a	()Ll9/a;
    //   214: invokevirtual 240	l9/a:l	()Ll9/x;
    //   217: invokevirtual 244	l9/x:i	()Ljava/lang/String;
    //   220: aload_0
    //   221: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   224: invokevirtual 139	l9/h0:a	()Ll9/a;
    //   227: invokevirtual 240	l9/a:l	()Ll9/x;
    //   230: invokevirtual 562	l9/x:n	()I
    //   233: iconst_1
    //   234: invokevirtual 567	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   237: astore 6
    //   239: aload 6
    //   241: ifnull +108 -> 349
    //   244: iload_3
    //   245: istore_1
    //   246: aload 6
    //   248: checkcast 252	javax/net/ssl/SSLSocket
    //   251: astore 6
    //   253: iload_3
    //   254: istore_1
    //   255: aload_0
    //   256: aload 5
    //   258: aload 6
    //   260: invokevirtual 570	q9/b:r	(Ljava/util/List;Ljavax/net/ssl/SSLSocket;)Lq9/b;
    //   263: astore 7
    //   265: iload_3
    //   266: istore_1
    //   267: aload 5
    //   269: aload 7
    //   271: getfield 93	q9/b:h	I
    //   274: invokeinterface 295 2 0
    //   279: checkcast 234	l9/l
    //   282: astore 9
    //   284: iload_3
    //   285: istore_1
    //   286: aload 7
    //   288: aload 5
    //   290: aload 6
    //   292: invokevirtual 572	q9/b:q	(Ljava/util/List;Ljavax/net/ssl/SSLSocket;)Lq9/b;
    //   295: astore 5
    //   297: iload_3
    //   298: istore_1
    //   299: aload 9
    //   301: aload 6
    //   303: aload 7
    //   305: getfield 95	q9/b:i	Z
    //   308: invokevirtual 575	l9/l:b	(Ljavax/net/ssl/SSLSocket;Z)V
    //   311: iload_3
    //   312: istore_1
    //   313: aload_0
    //   314: aload 6
    //   316: aload 9
    //   318: invokespecial 577	q9/b:k	(Ljavax/net/ssl/SSLSocket;Ll9/l;)V
    //   321: iload_3
    //   322: istore_1
    //   323: aload_0
    //   324: getfield 102	q9/b:j	Ll9/t;
    //   327: aload_0
    //   328: getfield 81	q9/b:b	Lq9/h;
    //   331: aload_0
    //   332: getfield 378	q9/b:n	Ll9/v;
    //   335: invokevirtual 580	l9/t:A	(Ll9/e;Ll9/v;)V
    //   338: goto +90 -> 428
    //   341: astore 6
    //   343: iload 4
    //   345: istore_2
    //   346: goto +255 -> 601
    //   349: iload_3
    //   350: istore_1
    //   351: new 108	java/lang/NullPointerException
    //   354: dup
    //   355: ldc_w 582
    //   358: invokespecial 583	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   361: athrow
    //   362: iload_3
    //   363: istore_1
    //   364: aload_0
    //   365: aload_0
    //   366: getfield 155	q9/b:l	Ljava/net/Socket;
    //   369: putfield 389	q9/b:m	Ljava/net/Socket;
    //   372: iload_3
    //   373: istore_1
    //   374: aload_0
    //   375: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   378: invokevirtual 139	l9/h0:a	()Ll9/a;
    //   381: invokevirtual 247	l9/a:f	()Ljava/util/List;
    //   384: astore 6
    //   386: iload_3
    //   387: istore_1
    //   388: getstatic 585	l9/c0:g	Ll9/c0;
    //   391: astore 5
    //   393: iload_3
    //   394: istore_1
    //   395: aload 6
    //   397: aload 5
    //   399: invokeinterface 588 2 0
    //   404: ifeq +6 -> 410
    //   407: goto +10 -> 417
    //   410: iload_3
    //   411: istore_1
    //   412: getstatic 401	l9/c0:d	Ll9/c0;
    //   415: astore 5
    //   417: iload_3
    //   418: istore_1
    //   419: aload_0
    //   420: aload 5
    //   422: putfield 403	q9/b:o	Ll9/c0;
    //   425: aconst_null
    //   426: astore 5
    //   428: iload_3
    //   429: istore_1
    //   430: new 590	q9/i
    //   433: dup
    //   434: aload_0
    //   435: getfield 79	q9/b:a	Ll9/b0;
    //   438: invokevirtual 594	l9/b0:v	()Lp9/d;
    //   441: aload_0
    //   442: getfield 79	q9/b:a	Ll9/b0;
    //   445: invokevirtual 597	l9/b0:l	()Ll9/k;
    //   448: invokevirtual 602	l9/k:a	()Lq9/j;
    //   451: aload_0
    //   452: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   455: aload_0
    //   456: getfield 155	q9/b:l	Ljava/net/Socket;
    //   459: aload_0
    //   460: getfield 389	q9/b:m	Ljava/net/Socket;
    //   463: aload_0
    //   464: getfield 378	q9/b:n	Ll9/v;
    //   467: aload_0
    //   468: getfield 403	q9/b:o	Ll9/c0;
    //   471: aload_0
    //   472: getfield 194	q9/b:p	Laa/d;
    //   475: aload_0
    //   476: getfield 202	q9/b:q	Laa/c;
    //   479: aload_0
    //   480: getfield 79	q9/b:a	Ll9/b0;
    //   483: invokevirtual 604	l9/b0:z	()I
    //   486: invokespecial 607	q9/i:<init>	(Lp9/d;Lq9/j;Ll9/h0;Ljava/net/Socket;Ljava/net/Socket;Ll9/v;Ll9/c0;Laa/d;Laa/c;I)V
    //   489: astore 6
    //   491: iload_3
    //   492: istore_1
    //   493: aload_0
    //   494: aload 6
    //   496: putfield 609	q9/b:r	Lq9/i;
    //   499: iload_3
    //   500: istore_1
    //   501: aload 6
    //   503: invokevirtual 612	q9/i:y	()V
    //   506: iload_3
    //   507: istore_1
    //   508: aload_0
    //   509: getfield 102	q9/b:j	Ll9/t;
    //   512: aload_0
    //   513: getfield 81	q9/b:b	Lq9/h;
    //   516: aload_0
    //   517: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   520: invokevirtual 179	l9/h0:d	()Ljava/net/InetSocketAddress;
    //   523: aload_0
    //   524: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   527: invokevirtual 116	l9/h0:b	()Ljava/net/Proxy;
    //   530: aload_0
    //   531: getfield 403	q9/b:o	Ll9/c0;
    //   534: invokevirtual 615	l9/t:g	(Ll9/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Ll9/c0;)V
    //   537: new 544	q9/n$a
    //   540: dup
    //   541: aload_0
    //   542: aconst_null
    //   543: aconst_null
    //   544: bipush 6
    //   546: aconst_null
    //   547: invokespecial 618	q9/n$a:<init>	(Lq9/n$c;Lq9/n$c;Ljava/lang/Throwable;ILa9/d;)V
    //   550: astore 6
    //   552: aload_0
    //   553: getfield 81	q9/b:b	Lq9/h;
    //   556: invokevirtual 536	q9/h:s	()Ljava/util/concurrent/CopyOnWriteArrayList;
    //   559: aload_0
    //   560: invokeinterface 552 2 0
    //   565: pop
    //   566: aload 6
    //   568: areturn
    //   569: astore 5
    //   571: iconst_1
    //   572: istore_1
    //   573: goto +166 -> 739
    //   576: astore 6
    //   578: iconst_1
    //   579: istore_2
    //   580: goto +5 -> 585
    //   583: astore 6
    //   585: goto +16 -> 601
    //   588: astore 5
    //   590: goto +149 -> 739
    //   593: astore 6
    //   595: aconst_null
    //   596: astore 5
    //   598: iload 4
    //   600: istore_2
    //   601: iload_2
    //   602: istore_1
    //   603: aload_0
    //   604: getfield 102	q9/b:j	Ll9/t;
    //   607: aload_0
    //   608: getfield 81	q9/b:b	Lq9/h;
    //   611: aload_0
    //   612: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   615: invokevirtual 179	l9/h0:d	()Ljava/net/InetSocketAddress;
    //   618: aload_0
    //   619: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   622: invokevirtual 116	l9/h0:b	()Ljava/net/Proxy;
    //   625: aconst_null
    //   626: aload 6
    //   628: invokevirtual 621	l9/t:h	(Ll9/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Ll9/c0;Ljava/io/IOException;)V
    //   631: iload_2
    //   632: istore_1
    //   633: aload 8
    //   635: astore 7
    //   637: aload_0
    //   638: getfield 79	q9/b:a	Ll9/b0;
    //   641: invokevirtual 624	l9/b0:G	()Z
    //   644: ifeq +20 -> 664
    //   647: iload_2
    //   648: istore_1
    //   649: aload 6
    //   651: invokestatic 629	q9/q:a	(Ljava/io/IOException;)Z
    //   654: ifne +172 -> 826
    //   657: aload 8
    //   659: astore 7
    //   661: goto +3 -> 664
    //   664: iload_2
    //   665: istore_1
    //   666: new 544	q9/n$a
    //   669: dup
    //   670: aload_0
    //   671: aload 7
    //   673: aload 6
    //   675: invokespecial 632	q9/n$a:<init>	(Lq9/n$c;Lq9/n$c;Ljava/lang/Throwable;)V
    //   678: astore 5
    //   680: aload_0
    //   681: getfield 81	q9/b:b	Lq9/h;
    //   684: invokevirtual 536	q9/h:s	()Ljava/util/concurrent/CopyOnWriteArrayList;
    //   687: aload_0
    //   688: invokeinterface 552 2 0
    //   693: pop
    //   694: iload_2
    //   695: ifne +41 -> 736
    //   698: aload_0
    //   699: getfield 389	q9/b:m	Ljava/net/Socket;
    //   702: astore 6
    //   704: aload 6
    //   706: ifnonnull +6 -> 712
    //   709: goto +8 -> 717
    //   712: aload 6
    //   714: invokestatic 411	m9/o:g	(Ljava/net/Socket;)V
    //   717: aload_0
    //   718: getfield 155	q9/b:l	Ljava/net/Socket;
    //   721: astore 6
    //   723: aload 6
    //   725: ifnonnull +6 -> 731
    //   728: aload 5
    //   730: areturn
    //   731: aload 6
    //   733: invokestatic 411	m9/o:g	(Ljava/net/Socket;)V
    //   736: aload 5
    //   738: areturn
    //   739: aload_0
    //   740: getfield 81	q9/b:b	Lq9/h;
    //   743: invokevirtual 536	q9/h:s	()Ljava/util/concurrent/CopyOnWriteArrayList;
    //   746: aload_0
    //   747: invokeinterface 552 2 0
    //   752: pop
    //   753: iload_1
    //   754: ifne +41 -> 795
    //   757: aload_0
    //   758: getfield 389	q9/b:m	Ljava/net/Socket;
    //   761: astore 6
    //   763: aload 6
    //   765: ifnonnull +6 -> 771
    //   768: goto +8 -> 776
    //   771: aload 6
    //   773: invokestatic 411	m9/o:g	(Ljava/net/Socket;)V
    //   776: aload_0
    //   777: getfield 155	q9/b:l	Ljava/net/Socket;
    //   780: astore 6
    //   782: aload 6
    //   784: ifnonnull +6 -> 790
    //   787: goto +8 -> 795
    //   790: aload 6
    //   792: invokestatic 411	m9/o:g	(Ljava/net/Socket;)V
    //   795: aload 5
    //   797: athrow
    //   798: new 634	java/lang/IllegalStateException
    //   801: dup
    //   802: ldc_w 636
    //   805: invokevirtual 637	java/lang/Object:toString	()Ljava/lang/String;
    //   808: invokespecial 638	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   811: athrow
    //   812: new 634	java/lang/IllegalStateException
    //   815: dup
    //   816: ldc_w 640
    //   819: invokevirtual 637	java/lang/Object:toString	()Ljava/lang/String;
    //   822: invokespecial 638	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   825: athrow
    //   826: aload 5
    //   828: astore 7
    //   830: goto -166 -> 664
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	b
    //   19	735	1	i1	int
    //   12	683	2	i2	int
    //   7	500	3	i3	int
    //   9	590	4	i4	int
    //   4	423	5	localObject1	Object
    //   569	1	5	localObject2	Object
    //   588	1	5	localObject3	Object
    //   596	231	5	locala	n.a
    //   82	233	6	localObject4	Object
    //   341	1	6	localIOException1	IOException
    //   384	183	6	localObject5	Object
    //   576	1	6	localIOException2	IOException
    //   583	1	6	localIOException3	IOException
    //   593	81	6	localIOException4	IOException
    //   702	89	6	localSocket	Socket
    //   101	728	7	localObject6	Object
    //   65	593	8	localObject7	Object
    //   282	35	9	locall	l9.l
    // Exception table:
    //   from	to	target	type
    //   299	311	341	java/io/IOException
    //   313	321	341	java/io/IOException
    //   323	338	341	java/io/IOException
    //   537	552	569	finally
    //   537	552	576	java/io/IOException
    //   430	491	583	java/io/IOException
    //   493	499	583	java/io/IOException
    //   501	506	583	java/io/IOException
    //   508	537	583	java/io/IOException
    //   69	76	588	finally
    //   78	84	588	finally
    //   86	94	588	finally
    //   96	103	588	finally
    //   165	178	588	finally
    //   180	191	588	finally
    //   193	239	588	finally
    //   246	253	588	finally
    //   255	265	588	finally
    //   267	284	588	finally
    //   286	297	588	finally
    //   299	311	588	finally
    //   313	321	588	finally
    //   323	338	588	finally
    //   351	362	588	finally
    //   364	372	588	finally
    //   374	386	588	finally
    //   388	393	588	finally
    //   395	407	588	finally
    //   412	417	588	finally
    //   419	425	588	finally
    //   430	491	588	finally
    //   493	499	588	finally
    //   501	506	588	finally
    //   508	537	588	finally
    //   603	631	588	finally
    //   637	647	588	finally
    //   649	657	588	finally
    //   666	680	588	finally
    //   69	76	593	java/io/IOException
    //   78	84	593	java/io/IOException
    //   86	94	593	java/io/IOException
    //   96	103	593	java/io/IOException
    //   165	178	593	java/io/IOException
    //   180	191	593	java/io/IOException
    //   193	239	593	java/io/IOException
    //   246	253	593	java/io/IOException
    //   255	265	593	java/io/IOException
    //   267	284	593	java/io/IOException
    //   286	297	593	java/io/IOException
    //   351	362	593	java/io/IOException
    //   364	372	593	java/io/IOException
    //   374	386	593	java/io/IOException
    //   388	393	593	java/io/IOException
    //   395	407	593	java/io/IOException
    //   412	417	593	java/io/IOException
    //   419	425	593	java/io/IOException
  }
  
  public i c()
  {
    this.b.m().u().a(e());
    Object localObject1 = this.c.k(this, this.e);
    if (localObject1 != null) {
      return ((l)localObject1).i();
    }
    localObject1 = this.r;
    f.c(localObject1);
    try
    {
      this.a.l().a().e((i)localObject1);
      this.b.c((i)localObject1);
      o8.o localo = o8.o.a;
      this.j.j(this.b, (l9.j)localObject1);
      return localObject1;
    }
    finally {}
  }
  
  public void cancel()
  {
    this.k = true;
    Socket localSocket = this.l;
    if (localSocket == null) {
      return;
    }
    m9.o.g(localSocket);
  }
  
  public boolean d()
  {
    return this.o != null;
  }
  
  public h0 e()
  {
    return this.d;
  }
  
  /* Error */
  public n.a f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 155	q9/b:l	Ljava/net/Socket;
    //   4: astore 4
    //   6: iconst_1
    //   7: istore_3
    //   8: iconst_1
    //   9: istore_2
    //   10: aload 4
    //   12: ifnonnull +8 -> 20
    //   15: iconst_1
    //   16: istore_1
    //   17: goto +5 -> 22
    //   20: iconst_0
    //   21: istore_1
    //   22: iload_1
    //   23: ifeq +225 -> 248
    //   26: aload_0
    //   27: getfield 81	q9/b:b	Lq9/h;
    //   30: invokevirtual 536	q9/h:s	()Ljava/util/concurrent/CopyOnWriteArrayList;
    //   33: aload_0
    //   34: invokeinterface 540 2 0
    //   39: pop
    //   40: aload_0
    //   41: getfield 102	q9/b:j	Ll9/t;
    //   44: aload_0
    //   45: getfield 81	q9/b:b	Lq9/h;
    //   48: aload_0
    //   49: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   52: invokevirtual 179	l9/h0:d	()Ljava/net/InetSocketAddress;
    //   55: aload_0
    //   56: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   59: invokevirtual 116	l9/h0:b	()Ljava/net/Proxy;
    //   62: invokevirtual 681	l9/t:i	(Ll9/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V
    //   65: aload_0
    //   66: invokespecial 683	q9/b:j	()V
    //   69: iload_3
    //   70: istore_1
    //   71: new 544	q9/n$a
    //   74: dup
    //   75: aload_0
    //   76: aconst_null
    //   77: aconst_null
    //   78: bipush 6
    //   80: aconst_null
    //   81: invokespecial 618	q9/n$a:<init>	(Lq9/n$c;Lq9/n$c;Ljava/lang/Throwable;ILa9/d;)V
    //   84: astore 4
    //   86: aload_0
    //   87: getfield 81	q9/b:b	Lq9/h;
    //   90: invokevirtual 536	q9/h:s	()Ljava/util/concurrent/CopyOnWriteArrayList;
    //   93: aload_0
    //   94: invokeinterface 552 2 0
    //   99: pop
    //   100: aload 4
    //   102: areturn
    //   103: astore 4
    //   105: goto +14 -> 119
    //   108: astore 4
    //   110: iconst_0
    //   111: istore_1
    //   112: goto +96 -> 208
    //   115: astore 4
    //   117: iconst_0
    //   118: istore_2
    //   119: iload_2
    //   120: istore_1
    //   121: aload_0
    //   122: getfield 102	q9/b:j	Ll9/t;
    //   125: aload_0
    //   126: getfield 81	q9/b:b	Lq9/h;
    //   129: aload_0
    //   130: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   133: invokevirtual 179	l9/h0:d	()Ljava/net/InetSocketAddress;
    //   136: aload_0
    //   137: invokevirtual 111	q9/b:e	()Ll9/h0;
    //   140: invokevirtual 116	l9/h0:b	()Ljava/net/Proxy;
    //   143: aconst_null
    //   144: aload 4
    //   146: invokevirtual 621	l9/t:h	(Ll9/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Ll9/c0;Ljava/io/IOException;)V
    //   149: iload_2
    //   150: istore_1
    //   151: new 544	q9/n$a
    //   154: dup
    //   155: aload_0
    //   156: aconst_null
    //   157: aload 4
    //   159: iconst_2
    //   160: aconst_null
    //   161: invokespecial 618	q9/n$a:<init>	(Lq9/n$c;Lq9/n$c;Ljava/lang/Throwable;ILa9/d;)V
    //   164: astore 4
    //   166: aload_0
    //   167: getfield 81	q9/b:b	Lq9/h;
    //   170: invokevirtual 536	q9/h:s	()Ljava/util/concurrent/CopyOnWriteArrayList;
    //   173: aload_0
    //   174: invokeinterface 552 2 0
    //   179: pop
    //   180: iload_2
    //   181: ifne +22 -> 203
    //   184: aload_0
    //   185: getfield 155	q9/b:l	Ljava/net/Socket;
    //   188: astore 5
    //   190: aload 5
    //   192: ifnonnull +6 -> 198
    //   195: aload 4
    //   197: areturn
    //   198: aload 5
    //   200: invokestatic 411	m9/o:g	(Ljava/net/Socket;)V
    //   203: aload 4
    //   205: areturn
    //   206: astore 4
    //   208: aload_0
    //   209: getfield 81	q9/b:b	Lq9/h;
    //   212: invokevirtual 536	q9/h:s	()Ljava/util/concurrent/CopyOnWriteArrayList;
    //   215: aload_0
    //   216: invokeinterface 552 2 0
    //   221: pop
    //   222: iload_1
    //   223: ifne +22 -> 245
    //   226: aload_0
    //   227: getfield 155	q9/b:l	Ljava/net/Socket;
    //   230: astore 5
    //   232: aload 5
    //   234: ifnonnull +6 -> 240
    //   237: goto +8 -> 245
    //   240: aload 5
    //   242: invokestatic 411	m9/o:g	(Ljava/net/Socket;)V
    //   245: aload 4
    //   247: athrow
    //   248: new 634	java/lang/IllegalStateException
    //   251: dup
    //   252: ldc_w 685
    //   255: invokevirtual 637	java/lang/Object:toString	()Ljava/lang/String;
    //   258: invokespecial 638	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   261: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	b
    //   16	207	1	i1	int
    //   9	172	2	i2	int
    //   7	63	3	i3	int
    //   4	97	4	localObject1	Object
    //   103	1	4	localIOException1	IOException
    //   108	1	4	localObject2	Object
    //   115	43	4	localIOException2	IOException
    //   164	40	4	locala	n.a
    //   206	40	4	localObject3	Object
    //   188	53	5	localSocket	Socket
    // Exception table:
    //   from	to	target	type
    //   71	86	103	java/io/IOException
    //   40	69	108	finally
    //   40	69	115	java/io/IOException
    //   71	86	206	finally
    //   121	149	206	finally
    //   151	166	206	finally
  }
  
  public void g(h paramh, IOException paramIOException)
  {
    f.f(paramh, "call");
  }
  
  public void h() {}
  
  public final void i()
  {
    Socket localSocket = this.m;
    if (localSocket == null) {
      return;
    }
    m9.o.g(localSocket);
  }
  
  public final n.a l()
  {
    Object localObject = o();
    if (localObject == null) {
      return new n.a(this, null, null, 6, null);
    }
    Socket localSocket = this.l;
    if (localSocket != null) {
      m9.o.g(localSocket);
    }
    int i1 = this.f + 1;
    if (i1 < 21)
    {
      this.j.g(this.b, e().d(), e().b(), null);
      return new n.a(this, n(this, i1, (d0)localObject, 0, false, 12, null), null, 4, null);
    }
    localObject = new ProtocolException("Too many tunnel connections attempted: 21");
    this.j.h(this.b, e().d(), e().b(), null, (IOException)localObject);
    return new n.a(this, null, (Throwable)localObject, 2, null);
  }
  
  public final List<h0> p()
  {
    return this.e;
  }
  
  public final b q(List<l9.l> paramList, SSLSocket paramSSLSocket)
  {
    f.f(paramList, "connectionSpecs");
    f.f(paramSSLSocket, "sslSocket");
    int i1 = this.h;
    boolean bool = true;
    i1 += 1;
    int i3 = paramList.size();
    int i2;
    do
    {
      i2 = i1;
      if (i2 >= i3) {
        break;
      }
      i1 = i2 + 1;
    } while (!((l9.l)paramList.get(i2)).e(paramSSLSocket));
    if (this.h == -1) {
      bool = false;
    }
    return n(this, 0, null, i2, bool, 3, null);
    return null;
  }
  
  public final b r(List<l9.l> paramList, SSLSocket paramSSLSocket)
  {
    f.f(paramList, "connectionSpecs");
    f.f(paramSSLSocket, "sslSocket");
    if (this.h != -1) {
      return this;
    }
    Object localObject = q(paramList, paramSSLSocket);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unable to find acceptable protocols. isFallback=");
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(", modes=");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(", supported protocols=");
    paramList = paramSSLSocket.getEnabledProtocols();
    f.c(paramList);
    paramList = Arrays.toString(paramList);
    f.e(paramList, "toString(this)");
    ((StringBuilder)localObject).append(paramList);
    throw new UnknownServiceException(((StringBuilder)localObject).toString());
  }
  
  public static final class a {}
  
  static final class c
    extends a9.g
    implements z8.a<List<? extends X509Certificate>>
  {
    c(l9.v paramv)
    {
      super();
    }
    
    public final List<X509Certificate> d()
    {
      Object localObject = this.b.d();
      ArrayList localArrayList = new ArrayList(p8.l.q((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((X509Certificate)((Iterator)localObject).next());
      }
      return localArrayList;
    }
  }
  
  static final class d
    extends a9.g
    implements z8.a<List<? extends Certificate>>
  {
    d(l9.g paramg, l9.v paramv, l9.a parama)
    {
      super();
    }
    
    public final List<Certificate> d()
    {
      x9.c localc = this.b.d();
      f.c(localc);
      return localc.a(this.c.d(), locala.l().i());
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     q9.b
 * JD-Core Version:    0.7.0.1
 */