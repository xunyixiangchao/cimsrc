package i5;

import java.util.LinkedList;
import java.util.List;

public class c
{
  public static final List<Byte> a;
  public static final List<Byte> b;
  public static final List<Byte> c;
  
  static
  {
    Object localObject = new LinkedList();
    a = (List)localObject;
    LinkedList localLinkedList1 = new LinkedList();
    b = localLinkedList1;
    LinkedList localLinkedList2 = new LinkedList();
    c = localLinkedList2;
    ((List)localObject).add(Byte.valueOf((byte)6));
    ((List)localObject).add(Byte.valueOf((byte)13));
    localObject = Byte.valueOf((byte)4);
    localLinkedList1.add(localObject);
    Byte localByte = Byte.valueOf((byte)5);
    localLinkedList1.add(localByte);
    localLinkedList2.add(localObject);
    localLinkedList2.add(localByte);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     i5.c
 * JD-Core Version:    0.7.0.1
 */