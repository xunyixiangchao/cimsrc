package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import java.util.HashMap;

public class b
{
  static final HashMap<Pair<Integer, Integer>, String> f;
  static final HashMap<String, String> g;
  private final MotionLayout a;
  private String b = null;
  private String c = null;
  private int d = -1;
  private int e = -1;
  
  static
  {
    HashMap localHashMap1 = new HashMap();
    f = localHashMap1;
    HashMap localHashMap2 = new HashMap();
    g = localHashMap2;
    Integer localInteger1 = Integer.valueOf(4);
    localHashMap1.put(Pair.create(localInteger1, localInteger1), "layout_constraintBottom_toBottomOf");
    Integer localInteger2 = Integer.valueOf(3);
    localHashMap1.put(Pair.create(localInteger1, localInteger2), "layout_constraintBottom_toTopOf");
    localHashMap1.put(Pair.create(localInteger2, localInteger1), "layout_constraintTop_toBottomOf");
    localHashMap1.put(Pair.create(localInteger2, localInteger2), "layout_constraintTop_toTopOf");
    localInteger1 = Integer.valueOf(6);
    localHashMap1.put(Pair.create(localInteger1, localInteger1), "layout_constraintStart_toStartOf");
    localInteger2 = Integer.valueOf(7);
    localHashMap1.put(Pair.create(localInteger1, localInteger2), "layout_constraintStart_toEndOf");
    localHashMap1.put(Pair.create(localInteger2, localInteger1), "layout_constraintEnd_toStartOf");
    localHashMap1.put(Pair.create(localInteger2, localInteger2), "layout_constraintEnd_toEndOf");
    localInteger1 = Integer.valueOf(1);
    localHashMap1.put(Pair.create(localInteger1, localInteger1), "layout_constraintLeft_toLeftOf");
    localInteger2 = Integer.valueOf(2);
    localHashMap1.put(Pair.create(localInteger1, localInteger2), "layout_constraintLeft_toRightOf");
    localHashMap1.put(Pair.create(localInteger2, localInteger2), "layout_constraintRight_toRightOf");
    localHashMap1.put(Pair.create(localInteger2, localInteger1), "layout_constraintRight_toLeftOf");
    localInteger1 = Integer.valueOf(5);
    localHashMap1.put(Pair.create(localInteger1, localInteger1), "layout_constraintBaseline_toBaselineOf");
    localHashMap2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
    localHashMap2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
    localHashMap2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
    localHashMap2.put("layout_constraintTop_toTopOf", "layout_marginTop");
    localHashMap2.put("layout_constraintStart_toStartOf", "layout_marginStart");
    localHashMap2.put("layout_constraintStart_toEndOf", "layout_marginStart");
    localHashMap2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
    localHashMap2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
    localHashMap2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
    localHashMap2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
    localHashMap2.put("layout_constraintRight_toRightOf", "layout_marginRight");
    localHashMap2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
  }
  
  public b(MotionLayout paramMotionLayout)
  {
    this.a = paramMotionLayout;
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     androidx.constraintlayout.motion.widget.b
 * JD-Core Version:    0.7.0.1
 */