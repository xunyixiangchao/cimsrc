package f9;

import c9.c;
import c9.g;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

public final class k
{
  private static final h d(Matcher paramMatcher, int paramInt, CharSequence paramCharSequence)
  {
    if (!paramMatcher.find(paramInt)) {
      return null;
    }
    return new i(paramMatcher, paramCharSequence);
  }
  
  private static final c e(MatchResult paramMatchResult)
  {
    return g.i(paramMatchResult.start(), paramMatchResult.end());
  }
  
  private static final c f(MatchResult paramMatchResult, int paramInt)
  {
    return g.i(paramMatchResult.start(paramInt), paramMatchResult.end(paramInt));
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     f9.k
 * JD-Core Version:    0.7.0.1
 */