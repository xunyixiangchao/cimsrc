package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import p0.i;
import q0.d.b;

public class e
{
  private static Animator a(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, float paramFloat)
  {
    return b(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser), null, 0, paramFloat);
  }
  
  private static Animator b(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, AnimatorSet paramAnimatorSet, int paramInt, float paramFloat)
  {
    int k = paramXmlPullParser.getDepth();
    Object localObject3 = null;
    Object localObject2 = null;
    int j;
    int i;
    for (;;)
    {
      int m = paramXmlPullParser.next();
      j = 0;
      i = 0;
      if (((m == 3) && (paramXmlPullParser.getDepth() <= k)) || (m == 1)) {
        break label330;
      }
      if (m == 2)
      {
        Object localObject1 = paramXmlPullParser.getName();
        if (((String)localObject1).equals("objectAnimator")) {
          localObject1 = n(paramContext, paramResources, paramTheme, paramAttributeSet, paramFloat, paramXmlPullParser);
        }
        for (;;)
        {
          break;
          if (((String)localObject1).equals("animator"))
          {
            localObject1 = l(paramContext, paramResources, paramTheme, paramAttributeSet, null, paramFloat, paramXmlPullParser);
          }
          else if (((String)localObject1).equals("set"))
          {
            localObject1 = new AnimatorSet();
            localObject3 = i.k(paramResources, paramTheme, paramAttributeSet, a.h);
            b(paramContext, paramResources, paramTheme, paramXmlPullParser, paramAttributeSet, (AnimatorSet)localObject1, i.g((TypedArray)localObject3, paramXmlPullParser, "ordering", 0, 0), paramFloat);
            ((TypedArray)localObject3).recycle();
          }
          else
          {
            if (!((String)localObject1).equals("propertyValuesHolder")) {
              break label292;
            }
            localObject1 = p(paramContext, paramResources, paramTheme, paramXmlPullParser, Xml.asAttributeSet(paramXmlPullParser));
            if ((localObject1 != null) && ((localObject3 instanceof ValueAnimator))) {
              ((ValueAnimator)localObject3).setValues((PropertyValuesHolder[])localObject1);
            }
            i = 1;
            localObject1 = localObject3;
          }
        }
        localObject3 = localObject1;
        if (paramAnimatorSet != null)
        {
          localObject3 = localObject1;
          if (i == 0)
          {
            Object localObject4 = localObject2;
            if (localObject2 == null) {
              localObject4 = new ArrayList();
            }
            ((ArrayList)localObject4).add(localObject1);
            localObject3 = localObject1;
            localObject2 = localObject4;
          }
        }
      }
    }
    label292:
    paramContext = new StringBuilder();
    paramContext.append("Unknown animator name: ");
    paramContext.append(paramXmlPullParser.getName());
    throw new RuntimeException(paramContext.toString());
    label330:
    if ((paramAnimatorSet != null) && (localObject2 != null))
    {
      paramContext = new Animator[localObject2.size()];
      paramResources = localObject2.iterator();
      i = j;
      while (paramResources.hasNext())
      {
        paramContext[i] = ((Animator)paramResources.next());
        i += 1;
      }
      if (paramInt == 0)
      {
        paramAnimatorSet.playTogether(paramContext);
        return localObject3;
      }
      paramAnimatorSet.playSequentially(paramContext);
    }
    return localObject3;
  }
  
  private static Keyframe c(Keyframe paramKeyframe, float paramFloat)
  {
    if (paramKeyframe.getType() == Float.TYPE) {
      return Keyframe.ofFloat(paramFloat);
    }
    if (paramKeyframe.getType() == Integer.TYPE) {
      return Keyframe.ofInt(paramFloat);
    }
    return Keyframe.ofObject(paramFloat);
  }
  
  private static void d(Keyframe[] paramArrayOfKeyframe, float paramFloat, int paramInt1, int paramInt2)
  {
    paramFloat /= (paramInt2 - paramInt1 + 2);
    while (paramInt1 <= paramInt2)
    {
      paramArrayOfKeyframe[paramInt1].setFraction(paramArrayOfKeyframe[(paramInt1 - 1)].getFraction() + paramFloat);
      paramInt1 += 1;
    }
  }
  
  private static PropertyValuesHolder e(TypedArray paramTypedArray, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject1 = paramTypedArray.peekValue(paramInt2);
    int j;
    if (localObject1 != null) {
      j = 1;
    } else {
      j = 0;
    }
    int m;
    if (j != 0) {
      m = ((TypedValue)localObject1).type;
    } else {
      m = 0;
    }
    localObject1 = paramTypedArray.peekValue(paramInt3);
    int k;
    if (localObject1 != null) {
      k = 1;
    } else {
      k = 0;
    }
    int n;
    if (k != 0) {
      n = ((TypedValue)localObject1).type;
    } else {
      n = 0;
    }
    int i = paramInt1;
    if (paramInt1 == 4) {
      if (((j != 0) && (h(m))) || ((k != 0) && (h(n)))) {
        i = 3;
      } else {
        i = 0;
      }
    }
    if (i == 0) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    localObject1 = null;
    String str = null;
    Object localObject2;
    if (i == 2)
    {
      localObject2 = paramTypedArray.getString(paramInt2);
      str = paramTypedArray.getString(paramInt3);
      d.b[] arrayOfb1 = q0.d.d((String)localObject2);
      d.b[] arrayOfb2 = q0.d.d(str);
      if (arrayOfb1 == null)
      {
        paramTypedArray = (TypedArray)localObject1;
        if (arrayOfb2 == null) {}
      }
      else
      {
        if (arrayOfb1 != null)
        {
          paramTypedArray = new a();
          if (arrayOfb2 != null)
          {
            if (q0.d.b(arrayOfb1, arrayOfb2))
            {
              paramTypedArray = PropertyValuesHolder.ofObject(paramString, paramTypedArray, new Object[] { arrayOfb1, arrayOfb2 });
            }
            else
            {
              paramTypedArray = new StringBuilder();
              paramTypedArray.append(" Can't morph from ");
              paramTypedArray.append((String)localObject2);
              paramTypedArray.append(" to ");
              paramTypedArray.append(str);
              throw new InflateException(paramTypedArray.toString());
            }
          }
          else {
            paramTypedArray = PropertyValuesHolder.ofObject(paramString, paramTypedArray, new Object[] { arrayOfb1 });
          }
          return paramTypedArray;
        }
        paramTypedArray = (TypedArray)localObject1;
        if (arrayOfb2 != null) {
          return PropertyValuesHolder.ofObject(paramString, new a(), new Object[] { arrayOfb2 });
        }
      }
    }
    else
    {
      if (i == 3) {
        localObject2 = f.a();
      } else {
        localObject2 = null;
      }
      if (paramInt1 != 0)
      {
        float f1;
        if (j != 0)
        {
          if (m == 5) {
            f1 = paramTypedArray.getDimension(paramInt2, 0.0F);
          } else {
            f1 = paramTypedArray.getFloat(paramInt2, 0.0F);
          }
          if (k != 0)
          {
            float f2;
            if (n == 5) {
              f2 = paramTypedArray.getDimension(paramInt3, 0.0F);
            } else {
              f2 = paramTypedArray.getFloat(paramInt3, 0.0F);
            }
            paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1, f2 });
          }
          else
          {
            paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
          }
        }
        else
        {
          if (n == 5) {
            f1 = paramTypedArray.getDimension(paramInt3, 0.0F);
          } else {
            f1 = paramTypedArray.getFloat(paramInt3, 0.0F);
          }
          paramTypedArray = PropertyValuesHolder.ofFloat(paramString, new float[] { f1 });
        }
        localObject1 = paramTypedArray;
      }
      else if (j != 0)
      {
        if (m == 5) {
          paramInt1 = (int)paramTypedArray.getDimension(paramInt2, 0.0F);
        } else if (h(m)) {
          paramInt1 = paramTypedArray.getColor(paramInt2, 0);
        } else {
          paramInt1 = paramTypedArray.getInt(paramInt2, 0);
        }
        if (k != 0)
        {
          if (n == 5) {
            paramInt2 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
          } else if (h(n)) {
            paramInt2 = paramTypedArray.getColor(paramInt3, 0);
          } else {
            paramInt2 = paramTypedArray.getInt(paramInt3, 0);
          }
          localObject1 = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1, paramInt2 });
        }
        else
        {
          localObject1 = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
        }
      }
      else
      {
        localObject1 = str;
        if (k != 0)
        {
          if (n == 5) {
            paramInt1 = (int)paramTypedArray.getDimension(paramInt3, 0.0F);
          } else if (h(n)) {
            paramInt1 = paramTypedArray.getColor(paramInt3, 0);
          } else {
            paramInt1 = paramTypedArray.getInt(paramInt3, 0);
          }
          localObject1 = PropertyValuesHolder.ofInt(paramString, new int[] { paramInt1 });
        }
      }
      paramTypedArray = (TypedArray)localObject1;
      if (localObject1 != null)
      {
        paramTypedArray = (TypedArray)localObject1;
        if (localObject2 != null)
        {
          ((PropertyValuesHolder)localObject1).setEvaluator((TypeEvaluator)localObject2);
          paramTypedArray = (TypedArray)localObject1;
        }
      }
    }
    return paramTypedArray;
  }
  
  private static int f(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    TypedValue localTypedValue = paramTypedArray.peekValue(paramInt1);
    int j = 1;
    int k = 0;
    if (localTypedValue != null) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int i;
    if (paramInt1 != 0) {
      i = localTypedValue.type;
    } else {
      i = 0;
    }
    paramTypedArray = paramTypedArray.peekValue(paramInt2);
    if (paramTypedArray != null) {
      paramInt2 = j;
    } else {
      paramInt2 = 0;
    }
    if (paramInt2 != 0) {
      j = paramTypedArray.type;
    } else {
      j = 0;
    }
    if ((paramInt1 == 0) || (!h(i)))
    {
      paramInt1 = k;
      if (paramInt2 != 0)
      {
        paramInt1 = k;
        if (!h(j)) {}
      }
    }
    else
    {
      paramInt1 = 3;
    }
    return paramInt1;
  }
  
  private static int g(Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, XmlPullParser paramXmlPullParser)
  {
    paramResources = i.k(paramResources, paramTheme, paramAttributeSet, a.j);
    int k = 0;
    paramTheme = i.l(paramResources, paramXmlPullParser, "value", 0);
    int i;
    if (paramTheme != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j = k;
    if (i != 0)
    {
      j = k;
      if (h(paramTheme.type)) {
        j = 3;
      }
    }
    paramResources.recycle();
    return j;
  }
  
  private static boolean h(int paramInt)
  {
    return (paramInt >= 28) && (paramInt <= 31);
  }
  
  public static Animator i(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return AnimatorInflater.loadAnimator(paramContext, paramInt);
    }
    return j(paramContext, paramContext.getResources(), paramContext.getTheme(), paramInt);
  }
  
  public static Animator j(Context paramContext, Resources paramResources, Resources.Theme paramTheme, int paramInt)
  {
    return k(paramContext, paramResources, paramTheme, paramInt, 1.0F);
  }
  
  /* Error */
  public static Animator k(Context paramContext, Resources paramResources, Resources.Theme paramTheme, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_1
    //   10: iload_3
    //   11: invokevirtual 296	android/content/res/Resources:getAnimation	(I)Landroid/content/res/XmlResourceParser;
    //   14: astore 8
    //   16: aload 8
    //   18: astore 5
    //   20: aload 8
    //   22: astore 6
    //   24: aload 8
    //   26: astore 7
    //   28: aload_0
    //   29: aload_1
    //   30: aload_2
    //   31: aload 8
    //   33: fload 4
    //   35: invokestatic 298	androidx/vectordrawable/graphics/drawable/e:a	(Landroid/content/Context;Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;F)Landroid/animation/Animator;
    //   38: astore_0
    //   39: aload 8
    //   41: ifnull +10 -> 51
    //   44: aload 8
    //   46: invokeinterface 303 1 0
    //   51: aload_0
    //   52: areturn
    //   53: astore_0
    //   54: goto +143 -> 197
    //   57: astore_0
    //   58: aload 6
    //   60: astore 5
    //   62: new 101	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   69: astore_1
    //   70: aload 6
    //   72: astore 5
    //   74: aload_1
    //   75: ldc_w 305
    //   78: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 6
    //   84: astore 5
    //   86: aload_1
    //   87: iload_3
    //   88: invokestatic 308	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   91: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 6
    //   97: astore 5
    //   99: new 310	android/content/res/Resources$NotFoundException
    //   102: dup
    //   103: aload_1
    //   104: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokespecial 311	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   110: astore_1
    //   111: aload 6
    //   113: astore 5
    //   115: aload_1
    //   116: aload_0
    //   117: invokevirtual 315	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   120: pop
    //   121: aload 6
    //   123: astore 5
    //   125: aload_1
    //   126: athrow
    //   127: astore_0
    //   128: aload 7
    //   130: astore 5
    //   132: new 101	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   139: astore_1
    //   140: aload 7
    //   142: astore 5
    //   144: aload_1
    //   145: ldc_w 305
    //   148: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 7
    //   154: astore 5
    //   156: aload_1
    //   157: iload_3
    //   158: invokestatic 308	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   161: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 7
    //   167: astore 5
    //   169: new 310	android/content/res/Resources$NotFoundException
    //   172: dup
    //   173: aload_1
    //   174: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokespecial 311	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   180: astore_1
    //   181: aload 7
    //   183: astore 5
    //   185: aload_1
    //   186: aload_0
    //   187: invokevirtual 315	android/content/res/Resources$NotFoundException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   190: pop
    //   191: aload 7
    //   193: astore 5
    //   195: aload_1
    //   196: athrow
    //   197: aload 5
    //   199: ifnull +10 -> 209
    //   202: aload 5
    //   204: invokeinterface 303 1 0
    //   209: aload_0
    //   210: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramContext	Context
    //   0	211	1	paramResources	Resources
    //   0	211	2	paramTheme	Resources.Theme
    //   0	211	3	paramInt	int
    //   0	211	4	paramFloat	float
    //   7	196	5	localObject1	Object
    //   1	121	6	localObject2	Object
    //   4	188	7	localObject3	Object
    //   14	31	8	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   9	16	53	finally
    //   28	39	53	finally
    //   62	70	53	finally
    //   74	82	53	finally
    //   86	95	53	finally
    //   99	111	53	finally
    //   115	121	53	finally
    //   125	127	53	finally
    //   132	140	53	finally
    //   144	152	53	finally
    //   156	165	53	finally
    //   169	181	53	finally
    //   185	191	53	finally
    //   195	197	53	finally
    //   9	16	57	java/io/IOException
    //   28	39	57	java/io/IOException
    //   9	16	127	org/xmlpull/v1/XmlPullParserException
    //   28	39	127	org/xmlpull/v1/XmlPullParserException
  }
  
  private static ValueAnimator l(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, ValueAnimator paramValueAnimator, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    TypedArray localTypedArray = i.k(paramResources, paramTheme, paramAttributeSet, a.g);
    paramTheme = i.k(paramResources, paramTheme, paramAttributeSet, a.k);
    paramResources = paramValueAnimator;
    if (paramValueAnimator == null) {
      paramResources = new ValueAnimator();
    }
    q(paramResources, localTypedArray, paramTheme, paramFloat, paramXmlPullParser);
    int i = i.h(localTypedArray, paramXmlPullParser, "interpolator", 0, 0);
    if (i > 0) {
      paramResources.setInterpolator(d.a(paramContext, i));
    }
    localTypedArray.recycle();
    if (paramTheme != null) {
      paramTheme.recycle();
    }
    return paramResources;
  }
  
  private static Keyframe m(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, int paramInt, XmlPullParser paramXmlPullParser)
  {
    paramTheme = i.k(paramResources, paramTheme, paramAttributeSet, a.j);
    float f = i.f(paramTheme, paramXmlPullParser, "fraction", 3, -1.0F);
    paramResources = i.l(paramTheme, paramXmlPullParser, "value", 0);
    int j;
    if (paramResources != null) {
      j = 1;
    } else {
      j = 0;
    }
    int i = paramInt;
    if (paramInt == 4) {
      if ((j != 0) && (h(paramResources.type))) {
        i = 3;
      } else {
        i = 0;
      }
    }
    if (j != 0)
    {
      if (i != 0)
      {
        if ((i != 1) && (i != 3)) {
          paramResources = null;
        } else {
          paramResources = Keyframe.ofInt(f, i.g(paramTheme, paramXmlPullParser, "value", 0, 0));
        }
      }
      else {
        paramResources = Keyframe.ofFloat(f, i.f(paramTheme, paramXmlPullParser, "value", 0, 0.0F));
      }
    }
    else if (i == 0) {
      paramResources = Keyframe.ofFloat(f);
    } else {
      paramResources = Keyframe.ofInt(f);
    }
    paramInt = i.h(paramTheme, paramXmlPullParser, "interpolator", 1, 0);
    if (paramInt > 0) {
      paramResources.setInterpolator(d.a(paramContext, paramInt));
    }
    paramTheme.recycle();
    return paramResources;
  }
  
  private static ObjectAnimator n(Context paramContext, Resources paramResources, Resources.Theme paramTheme, AttributeSet paramAttributeSet, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    ObjectAnimator localObjectAnimator = new ObjectAnimator();
    l(paramContext, paramResources, paramTheme, paramAttributeSet, localObjectAnimator, paramFloat, paramXmlPullParser);
    return localObjectAnimator;
  }
  
  private static PropertyValuesHolder o(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    int j = paramInt;
    for (;;)
    {
      paramInt = paramXmlPullParser.next();
      if ((paramInt == 3) || (paramInt == 1)) {
        break;
      }
      if (paramXmlPullParser.getName().equals("keyframe"))
      {
        paramInt = j;
        if (j == 4) {
          paramInt = g(paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramXmlPullParser);
        }
        Keyframe localKeyframe = m(paramContext, paramResources, paramTheme, Xml.asAttributeSet(paramXmlPullParser), paramInt, paramXmlPullParser);
        Object localObject2 = localObject1;
        if (localKeyframe != null)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localKeyframe);
        }
        paramXmlPullParser.next();
        localObject1 = localObject2;
        j = paramInt;
      }
    }
    paramContext = localObject3;
    if (localObject1 != null)
    {
      int k = localObject1.size();
      paramContext = localObject3;
      if (k > 0)
      {
        int i = 0;
        paramContext = (Keyframe)localObject1.get(0);
        paramResources = (Keyframe)localObject1.get(k - 1);
        float f = paramResources.getFraction();
        paramInt = k;
        if (f < 1.0F) {
          if (f < 0.0F)
          {
            paramResources.setFraction(1.0F);
            paramInt = k;
          }
          else
          {
            localObject1.add(localObject1.size(), c(paramResources, 1.0F));
            paramInt = k + 1;
          }
        }
        f = paramContext.getFraction();
        k = paramInt;
        if (f != 0.0F) {
          if (f < 0.0F)
          {
            paramContext.setFraction(0.0F);
            k = paramInt;
          }
          else
          {
            localObject1.add(0, c(paramContext, 0.0F));
            k = paramInt + 1;
          }
        }
        paramContext = new Keyframe[k];
        localObject1.toArray(paramContext);
        paramInt = i;
        while (paramInt < k)
        {
          paramResources = paramContext[paramInt];
          if (paramResources.getFraction() < 0.0F) {
            if (paramInt == 0)
            {
              paramResources.setFraction(0.0F);
            }
            else
            {
              int n = k - 1;
              if (paramInt == n)
              {
                paramResources.setFraction(1.0F);
              }
              else
              {
                i = paramInt + 1;
                int m = paramInt;
                while ((i < n) && (paramContext[i].getFraction() < 0.0F))
                {
                  m = i;
                  i += 1;
                }
                d(paramContext, paramContext[(m + 1)].getFraction() - paramContext[(paramInt - 1)].getFraction(), paramInt, m);
              }
            }
          }
          paramInt += 1;
        }
        paramResources = PropertyValuesHolder.ofKeyframe(paramString, paramContext);
        paramContext = paramResources;
        if (j == 3)
        {
          paramResources.setEvaluator(f.a());
          paramContext = paramResources;
        }
      }
    }
    return paramContext;
  }
  
  private static PropertyValuesHolder[] p(Context paramContext, Resources paramResources, Resources.Theme paramTheme, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    Object localObject4 = null;
    Object localObject1 = null;
    int j = paramXmlPullParser.getEventType();
    int i = 0;
    if ((j != 3) && (j != 1))
    {
      if (j != 2) {}
      for (;;)
      {
        paramXmlPullParser.next();
        break;
        if (paramXmlPullParser.getName().equals("propertyValuesHolder"))
        {
          TypedArray localTypedArray = i.k(paramResources, paramTheme, paramAttributeSet, a.i);
          String str = i.i(localTypedArray, paramXmlPullParser, "propertyName", 3);
          i = i.g(localTypedArray, paramXmlPullParser, "valueType", 2, 4);
          Object localObject2 = o(paramContext, paramResources, paramTheme, paramXmlPullParser, str, i);
          Object localObject3 = localObject2;
          if (localObject2 == null) {
            localObject3 = e(localTypedArray, i, 0, 1, str);
          }
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localObject3);
          }
          localTypedArray.recycle();
          localObject1 = localObject2;
        }
      }
    }
    paramContext = localObject4;
    if (localObject1 != null)
    {
      j = localObject1.size();
      paramResources = new PropertyValuesHolder[j];
      for (;;)
      {
        paramContext = paramResources;
        if (i >= j) {
          break;
        }
        paramResources[i] = ((PropertyValuesHolder)localObject1.get(i));
        i += 1;
      }
    }
    return paramContext;
  }
  
  private static void q(ValueAnimator paramValueAnimator, TypedArray paramTypedArray1, TypedArray paramTypedArray2, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    long l1 = i.g(paramTypedArray1, paramXmlPullParser, "duration", 1, 300);
    long l2 = i.g(paramTypedArray1, paramXmlPullParser, "startOffset", 2, 0);
    int j = i.g(paramTypedArray1, paramXmlPullParser, "valueType", 7, 4);
    int k = j;
    if (i.j(paramXmlPullParser, "valueFrom"))
    {
      k = j;
      if (i.j(paramXmlPullParser, "valueTo"))
      {
        int i = j;
        if (j == 4) {
          i = f(paramTypedArray1, 5, 6);
        }
        PropertyValuesHolder localPropertyValuesHolder = e(paramTypedArray1, i, 5, 6, "");
        k = i;
        if (localPropertyValuesHolder != null)
        {
          paramValueAnimator.setValues(new PropertyValuesHolder[] { localPropertyValuesHolder });
          k = i;
        }
      }
    }
    paramValueAnimator.setDuration(l1);
    paramValueAnimator.setStartDelay(l2);
    paramValueAnimator.setRepeatCount(i.g(paramTypedArray1, paramXmlPullParser, "repeatCount", 3, 0));
    paramValueAnimator.setRepeatMode(i.g(paramTypedArray1, paramXmlPullParser, "repeatMode", 4, 1));
    if (paramTypedArray2 != null) {
      r(paramValueAnimator, paramTypedArray2, k, paramFloat, paramXmlPullParser);
    }
  }
  
  private static void r(ValueAnimator paramValueAnimator, TypedArray paramTypedArray, int paramInt, float paramFloat, XmlPullParser paramXmlPullParser)
  {
    paramValueAnimator = (ObjectAnimator)paramValueAnimator;
    String str1 = i.i(paramTypedArray, paramXmlPullParser, "pathData", 1);
    if (str1 != null)
    {
      String str2 = i.i(paramTypedArray, paramXmlPullParser, "propertyXName", 2);
      paramXmlPullParser = i.i(paramTypedArray, paramXmlPullParser, "propertyYName", 3);
      if ((paramInt == 2) || ((str2 == null) && (paramXmlPullParser == null)))
      {
        paramValueAnimator = new StringBuilder();
        paramValueAnimator.append(paramTypedArray.getPositionDescription());
        paramValueAnimator.append(" propertyXName or propertyYName is needed for PathData");
        throw new InflateException(paramValueAnimator.toString());
      }
      s(q0.d.e(str1), paramValueAnimator, paramFloat * 0.5F, str2, paramXmlPullParser);
      return;
    }
    paramValueAnimator.setPropertyName(i.i(paramTypedArray, paramXmlPullParser, "propertyName", 0));
  }
  
  private static void s(Path paramPath, ObjectAnimator paramObjectAnimator, float paramFloat, String paramString1, String paramString2)
  {
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    ArrayList localArrayList = new ArrayList();
    float f2 = 0.0F;
    localArrayList.add(Float.valueOf(0.0F));
    float f1 = 0.0F;
    float f3;
    do
    {
      f3 = f1 + localPathMeasure.getLength();
      localArrayList.add(Float.valueOf(f3));
      f1 = f3;
    } while (localPathMeasure.nextContour());
    paramPath = new PathMeasure(paramPath, false);
    int n = Math.min(100, (int)(f3 / paramFloat) + 1);
    float[] arrayOfFloat2 = new float[n];
    float[] arrayOfFloat1 = new float[n];
    float[] arrayOfFloat3 = new float[2];
    f1 = f3 / (n - 1);
    int i = 0;
    int j = i;
    paramFloat = f2;
    for (;;)
    {
      localPathMeasure = null;
      if (i >= n) {
        break;
      }
      paramPath.getPosTan(paramFloat - ((Float)localArrayList.get(j)).floatValue(), arrayOfFloat3, null);
      arrayOfFloat2[i] = arrayOfFloat3[0];
      arrayOfFloat1[i] = arrayOfFloat3[1];
      paramFloat += f1;
      int m = j + 1;
      int k = j;
      if (m < localArrayList.size())
      {
        k = j;
        if (paramFloat > ((Float)localArrayList.get(m)).floatValue())
        {
          paramPath.nextContour();
          k = m;
        }
      }
      i += 1;
      j = k;
    }
    if (paramString1 != null) {
      paramPath = PropertyValuesHolder.ofFloat(paramString1, arrayOfFloat2);
    } else {
      paramPath = null;
    }
    paramString1 = localPathMeasure;
    if (paramString2 != null) {
      paramString1 = PropertyValuesHolder.ofFloat(paramString2, arrayOfFloat1);
    }
    if (paramPath == null)
    {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramString1 });
      return;
    }
    if (paramString1 == null)
    {
      paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath });
      return;
    }
    paramObjectAnimator.setValues(new PropertyValuesHolder[] { paramPath, paramString1 });
  }
  
  private static class a
    implements TypeEvaluator<d.b[]>
  {
    private d.b[] a;
    
    public d.b[] a(float paramFloat, d.b[] paramArrayOfb1, d.b[] paramArrayOfb2)
    {
      if (q0.d.b(paramArrayOfb1, paramArrayOfb2))
      {
        if (!q0.d.b(this.a, paramArrayOfb1)) {
          this.a = q0.d.f(paramArrayOfb1);
        }
        int i = 0;
        while (i < paramArrayOfb1.length)
        {
          this.a[i].d(paramArrayOfb1[i], paramArrayOfb2[i], paramFloat);
          i += 1;
        }
        return this.a;
      }
      throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.vectordrawable.graphics.drawable.e
 * JD-Core Version:    0.7.0.1
 */