package p9;

import a9.f;
import a9.l;
import java.util.Arrays;
import java.util.logging.Logger;

public final class b
{
  public static final String b(long paramLong)
  {
    if (paramLong <= -999500000L) {
      localObject = new StringBuilder();
    }
    for (paramLong -= 500000000;; paramLong += 500000000)
    {
      ((StringBuilder)localObject).append(paramLong / 1000000000);
      ((StringBuilder)localObject).append(" s ");
      localObject = ((StringBuilder)localObject).toString();
      break;
      if (paramLong <= -999500L) {
        localObject = new StringBuilder();
      }
      for (paramLong -= 500000;; paramLong += 500000)
      {
        ((StringBuilder)localObject).append(paramLong / 1000000);
        ((StringBuilder)localObject).append(" ms");
        break;
        if (paramLong <= 0L) {
          localObject = new StringBuilder();
        }
        for (paramLong -= 500;; paramLong += 500)
        {
          ((StringBuilder)localObject).append(paramLong / 1000);
          ((StringBuilder)localObject).append(" µs");
          break;
          if (paramLong >= 999500L) {
            break label157;
          }
          localObject = new StringBuilder();
        }
        label157:
        if (paramLong >= 999500000L) {
          break label182;
        }
        localObject = new StringBuilder();
      }
      label182:
      localObject = new StringBuilder();
    }
    l locall = l.a;
    Object localObject = String.format("%6s", Arrays.copyOf(new Object[] { localObject }, 1));
    f.e(localObject, "format(format, *args)");
    return localObject;
  }
  
  private static final void c(Logger paramLogger, a parama, c paramc, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramc.h());
    localStringBuilder.append(' ');
    paramc = l.a;
    paramc = String.format("%-22s", Arrays.copyOf(new Object[] { paramString }, 1));
    f.e(paramc, "format(format, *args)");
    localStringBuilder.append(paramc);
    localStringBuilder.append(": ");
    localStringBuilder.append(parama.b());
    paramLogger.fine(localStringBuilder.toString());
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     p9.b
 * JD-Core Version:    0.7.0.1
 */