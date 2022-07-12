package com.google.protobuf;

import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;

final class RopeByteString
  extends ByteString
{
  private static final int[] minLengthByDepth;
  private static final long serialVersionUID = 1L;
  private final ByteString left;
  private final int leftLength;
  private final ByteString right;
  private final int totalLength;
  private final int treeDepth;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    int j = 1;
    for (;;)
    {
      int k = j;
      if (i <= 0) {
        break;
      }
      localArrayList.add(Integer.valueOf(i));
      j = i;
      i = k + i;
    }
    localArrayList.add(Integer.valueOf(2147483647));
    minLengthByDepth = new int[localArrayList.size()];
    i = 0;
    for (;;)
    {
      int[] arrayOfInt = minLengthByDepth;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
  }
  
  private RopeByteString(ByteString paramByteString1, ByteString paramByteString2)
  {
    this.left = paramByteString1;
    this.right = paramByteString2;
    int i = paramByteString1.size();
    this.leftLength = i;
    this.totalLength = (i + paramByteString2.size());
    this.treeDepth = (Math.max(paramByteString1.getTreeDepth(), paramByteString2.getTreeDepth()) + 1);
  }
  
  static ByteString concatenate(ByteString paramByteString1, ByteString paramByteString2)
  {
    if (paramByteString2.size() == 0) {
      return paramByteString1;
    }
    if (paramByteString1.size() == 0) {
      return paramByteString2;
    }
    int i = paramByteString1.size() + paramByteString2.size();
    if (i < 128) {
      return concatenateBytes(paramByteString1, paramByteString2);
    }
    if ((paramByteString1 instanceof RopeByteString))
    {
      RopeByteString localRopeByteString = (RopeByteString)paramByteString1;
      if (localRopeByteString.right.size() + paramByteString2.size() < 128)
      {
        paramByteString1 = concatenateBytes(localRopeByteString.right, paramByteString2);
        return new RopeByteString(localRopeByteString.left, paramByteString1);
      }
      if ((localRopeByteString.left.getTreeDepth() > localRopeByteString.right.getTreeDepth()) && (localRopeByteString.getTreeDepth() > paramByteString2.getTreeDepth()))
      {
        paramByteString1 = new RopeByteString(localRopeByteString.right, paramByteString2);
        return new RopeByteString(localRopeByteString.left, paramByteString1);
      }
    }
    int j = Math.max(paramByteString1.getTreeDepth(), paramByteString2.getTreeDepth());
    if (i >= minLengthByDepth[(j + 1)]) {
      return new RopeByteString(paramByteString1, paramByteString2);
    }
    return new Balancer(null).balance(paramByteString1, paramByteString2);
  }
  
  private static ByteString concatenateBytes(ByteString paramByteString1, ByteString paramByteString2)
  {
    int i = paramByteString1.size();
    int j = paramByteString2.size();
    byte[] arrayOfByte = new byte[i + j];
    paramByteString1.copyTo(arrayOfByte, 0, 0, i);
    paramByteString2.copyTo(arrayOfByte, 0, i, j);
    return ByteString.wrap(arrayOfByte);
  }
  
  private boolean equalsFragments(ByteString paramByteString)
  {
    PieceIterator localPieceIterator1 = new PieceIterator(this, null);
    ByteString.LeafByteString localLeafByteString = (ByteString.LeafByteString)localPieceIterator1.next();
    PieceIterator localPieceIterator2 = new PieceIterator(paramByteString, null);
    paramByteString = (ByteString.LeafByteString)localPieceIterator2.next();
    int j = 0;
    int i = j;
    int k = i;
    for (;;)
    {
      int i1 = localLeafByteString.size() - j;
      int m = paramByteString.size() - i;
      int n = Math.min(i1, m);
      boolean bool;
      if (j == 0) {
        bool = localLeafByteString.equalsRange(paramByteString, i, n);
      } else {
        bool = paramByteString.equalsRange(localLeafByteString, j, n);
      }
      if (!bool) {
        return false;
      }
      k += n;
      int i2 = this.totalLength;
      if (k >= i2)
      {
        if (k == i2) {
          return true;
        }
        throw new IllegalStateException();
      }
      if (n == i1)
      {
        localLeafByteString = (ByteString.LeafByteString)localPieceIterator1.next();
        j = 0;
      }
      else
      {
        j += n;
      }
      if (n == m)
      {
        paramByteString = (ByteString.LeafByteString)localPieceIterator2.next();
        i = 0;
      }
      else
      {
        i += n;
      }
    }
  }
  
  static RopeByteString newInstanceForTest(ByteString paramByteString1, ByteString paramByteString2)
  {
    return new RopeByteString(paramByteString1, paramByteString2);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
  }
  
  public ByteBuffer asReadOnlyByteBuffer()
  {
    return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
  }
  
  public List<ByteBuffer> asReadOnlyByteBufferList()
  {
    ArrayList localArrayList = new ArrayList();
    PieceIterator localPieceIterator = new PieceIterator(this, null);
    while (localPieceIterator.hasNext()) {
      localArrayList.add(localPieceIterator.next().asReadOnlyByteBuffer());
    }
    return localArrayList;
  }
  
  public byte byteAt(int paramInt)
  {
    ByteString.checkIndex(paramInt, this.totalLength);
    int i = this.leftLength;
    if (paramInt < i) {
      return this.left.byteAt(paramInt);
    }
    return this.right.byteAt(paramInt - i);
  }
  
  public void copyTo(ByteBuffer paramByteBuffer)
  {
    this.left.copyTo(paramByteBuffer);
    this.right.copyTo(paramByteBuffer);
  }
  
  protected void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.leftLength;
    ByteString localByteString;
    if (paramInt1 + paramInt3 <= i) {
      localByteString = this.left;
    }
    for (;;)
    {
      localByteString.copyToInternal(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return;
      if (paramInt1 < i) {
        break;
      }
      localByteString = this.right;
      paramInt1 -= i;
    }
    i -= paramInt1;
    this.left.copyToInternal(paramArrayOfByte, paramInt1, paramInt2, i);
    this.right.copyToInternal(paramArrayOfByte, 0, paramInt2 + i, paramInt3 - i);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ByteString)) {
      return false;
    }
    paramObject = (ByteString)paramObject;
    if (this.totalLength != paramObject.size()) {
      return false;
    }
    if (this.totalLength == 0) {
      return true;
    }
    int i = peekCachedHashCode();
    int j = paramObject.peekCachedHashCode();
    if ((i != 0) && (j != 0) && (i != j)) {
      return false;
    }
    return equalsFragments(paramObject);
  }
  
  protected int getTreeDepth()
  {
    return this.treeDepth;
  }
  
  protected boolean isBalanced()
  {
    return this.totalLength >= minLengthByDepth[this.treeDepth];
  }
  
  public boolean isValidUtf8()
  {
    ByteString localByteString = this.left;
    int i = this.leftLength;
    boolean bool = false;
    i = localByteString.partialIsValidUtf8(0, 0, i);
    localByteString = this.right;
    if (localByteString.partialIsValidUtf8(i, 0, localByteString.size()) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public CodedInputStream newCodedInput()
  {
    return CodedInputStream.newInstance(new RopeInputStream());
  }
  
  public InputStream newInput()
  {
    return new RopeInputStream();
  }
  
  protected int partialHash(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.leftLength;
    if (paramInt2 + paramInt3 <= i) {
      return this.left.partialHash(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= i) {
      return this.right.partialHash(paramInt1, paramInt2 - i, paramInt3);
    }
    i -= paramInt2;
    paramInt1 = this.left.partialHash(paramInt1, paramInt2, i);
    return this.right.partialHash(paramInt1, 0, paramInt3 - i);
  }
  
  protected int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.leftLength;
    if (paramInt2 + paramInt3 <= i) {
      return this.left.partialIsValidUtf8(paramInt1, paramInt2, paramInt3);
    }
    if (paramInt2 >= i) {
      return this.right.partialIsValidUtf8(paramInt1, paramInt2 - i, paramInt3);
    }
    i -= paramInt2;
    paramInt1 = this.left.partialIsValidUtf8(paramInt1, paramInt2, i);
    return this.right.partialIsValidUtf8(paramInt1, 0, paramInt3 - i);
  }
  
  public int size()
  {
    return this.totalLength;
  }
  
  public ByteString substring(int paramInt1, int paramInt2)
  {
    int i = ByteString.checkRange(paramInt1, paramInt2, this.totalLength);
    if (i == 0) {
      return ByteString.EMPTY;
    }
    if (i == this.totalLength) {
      return this;
    }
    i = this.leftLength;
    if (paramInt2 <= i) {
      return this.left.substring(paramInt1, paramInt2);
    }
    if (paramInt1 >= i) {
      return this.right.substring(paramInt1 - i, paramInt2 - i);
    }
    return new RopeByteString(this.left.substring(paramInt1), this.right.substring(0, paramInt2 - this.leftLength));
  }
  
  protected String toStringInternal(Charset paramCharset)
  {
    return new String(toByteArray(), paramCharset);
  }
  
  Object writeReplace()
  {
    return ByteString.wrap(toByteArray());
  }
  
  void writeTo(ByteOutput paramByteOutput)
  {
    this.left.writeTo(paramByteOutput);
    this.right.writeTo(paramByteOutput);
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    this.left.writeTo(paramOutputStream);
    this.right.writeTo(paramOutputStream);
  }
  
  void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    int i = this.leftLength;
    ByteString localByteString;
    if (paramInt1 + paramInt2 <= i) {
      localByteString = this.left;
    }
    for (;;)
    {
      localByteString.writeToInternal(paramOutputStream, paramInt1, paramInt2);
      return;
      if (paramInt1 < i) {
        break;
      }
      localByteString = this.right;
      paramInt1 -= i;
    }
    i -= paramInt1;
    this.left.writeToInternal(paramOutputStream, paramInt1, i);
    this.right.writeToInternal(paramOutputStream, 0, paramInt2 - i);
  }
  
  private static class Balancer
  {
    private final Stack<ByteString> prefixesStack = new Stack();
    
    private ByteString balance(ByteString paramByteString1, ByteString paramByteString2)
    {
      doBalance(paramByteString1);
      doBalance(paramByteString2);
      for (paramByteString1 = (ByteString)this.prefixesStack.pop(); !this.prefixesStack.isEmpty(); paramByteString1 = new RopeByteString((ByteString)this.prefixesStack.pop(), paramByteString1, null)) {}
      return paramByteString1;
    }
    
    private void doBalance(ByteString paramByteString)
    {
      if (paramByteString.isBalanced())
      {
        insert(paramByteString);
        return;
      }
      if ((paramByteString instanceof RopeByteString))
      {
        paramByteString = (RopeByteString)paramByteString;
        doBalance(paramByteString.left);
        doBalance(paramByteString.right);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Has a new type of ByteString been created? Found ");
      localStringBuilder.append(paramByteString.getClass());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    private int getDepthBinForLength(int paramInt)
    {
      int i = Arrays.binarySearch(RopeByteString.minLengthByDepth, paramInt);
      paramInt = i;
      if (i < 0) {
        paramInt = -(i + 1) - 1;
      }
      return paramInt;
    }
    
    private void insert(ByteString paramByteString)
    {
      int i = getDepthBinForLength(paramByteString.size());
      int j = RopeByteString.minLengthByDepth[(i + 1)];
      if ((!this.prefixesStack.isEmpty()) && (((ByteString)this.prefixesStack.peek()).size() < j))
      {
        i = RopeByteString.minLengthByDepth[i];
        for (Object localObject = (ByteString)this.prefixesStack.pop(); (!this.prefixesStack.isEmpty()) && (((ByteString)this.prefixesStack.peek()).size() < i); localObject = new RopeByteString((ByteString)this.prefixesStack.pop(), (ByteString)localObject, null)) {}
        for (paramByteString = new RopeByteString((ByteString)localObject, paramByteString, null); !this.prefixesStack.isEmpty(); paramByteString = new RopeByteString((ByteString)this.prefixesStack.pop(), paramByteString, null))
        {
          i = getDepthBinForLength(paramByteString.size());
          i = RopeByteString.minLengthByDepth[(i + 1)];
          if (((ByteString)this.prefixesStack.peek()).size() >= i) {
            break;
          }
        }
        this.prefixesStack.push(paramByteString);
        return;
      }
      this.prefixesStack.push(paramByteString);
    }
  }
  
  private static class PieceIterator
    implements Iterator<ByteString.LeafByteString>
  {
    private final Stack<RopeByteString> breadCrumbs = new Stack();
    private ByteString.LeafByteString next = getLeafByLeft(paramByteString);
    
    private PieceIterator(ByteString paramByteString) {}
    
    private ByteString.LeafByteString getLeafByLeft(ByteString paramByteString)
    {
      while ((paramByteString instanceof RopeByteString))
      {
        paramByteString = (RopeByteString)paramByteString;
        this.breadCrumbs.push(paramByteString);
        paramByteString = paramByteString.left;
      }
      return (ByteString.LeafByteString)paramByteString;
    }
    
    private ByteString.LeafByteString getNextNonEmptyLeaf()
    {
      ByteString.LeafByteString localLeafByteString;
      do
      {
        if (this.breadCrumbs.isEmpty()) {
          return null;
        }
        localLeafByteString = getLeafByLeft(((RopeByteString)this.breadCrumbs.pop()).right);
      } while (localLeafByteString.isEmpty());
      return localLeafByteString;
    }
    
    public boolean hasNext()
    {
      return this.next != null;
    }
    
    public ByteString.LeafByteString next()
    {
      ByteString.LeafByteString localLeafByteString = this.next;
      if (localLeafByteString != null)
      {
        this.next = getNextNonEmptyLeaf();
        return localLeafByteString;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private class RopeInputStream
    extends InputStream
  {
    private ByteString.LeafByteString currentPiece;
    private int currentPieceIndex;
    private int currentPieceOffsetInRope;
    private int currentPieceSize;
    private int mark;
    private RopeByteString.PieceIterator pieceIterator;
    
    public RopeInputStream()
    {
      initialize();
    }
    
    private void advanceIfCurrentPieceFullyRead()
    {
      if (this.currentPiece != null)
      {
        int i = this.currentPieceIndex;
        int j = this.currentPieceSize;
        if (i == j)
        {
          this.currentPieceOffsetInRope += j;
          i = 0;
          this.currentPieceIndex = 0;
          if (this.pieceIterator.hasNext())
          {
            ByteString.LeafByteString localLeafByteString = this.pieceIterator.next();
            this.currentPiece = localLeafByteString;
            i = localLeafByteString.size();
          }
          else
          {
            this.currentPiece = null;
          }
          this.currentPieceSize = i;
        }
      }
    }
    
    private void initialize()
    {
      Object localObject = new RopeByteString.PieceIterator(RopeByteString.this, null);
      this.pieceIterator = ((RopeByteString.PieceIterator)localObject);
      localObject = ((RopeByteString.PieceIterator)localObject).next();
      this.currentPiece = ((ByteString.LeafByteString)localObject);
      this.currentPieceSize = ((ByteString)localObject).size();
      this.currentPieceIndex = 0;
      this.currentPieceOffsetInRope = 0;
    }
    
    private int readSkipInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int j = paramInt2;
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt1 > 0)
      {
        advanceIfCurrentPieceFullyRead();
        if (this.currentPiece == null)
        {
          if (paramInt1 != paramInt2) {
            break;
          }
          return -1;
        }
        int k = Math.min(this.currentPieceSize - this.currentPieceIndex, paramInt1);
        j = i;
        if (paramArrayOfByte != null)
        {
          this.currentPiece.copyTo(paramArrayOfByte, this.currentPieceIndex, i, k);
          j = i + k;
        }
        this.currentPieceIndex += k;
        paramInt1 -= k;
        i = j;
      }
      return paramInt2 - paramInt1;
    }
    
    public int available()
    {
      int i = this.currentPieceOffsetInRope;
      int j = this.currentPieceIndex;
      return RopeByteString.this.size() - (i + j);
    }
    
    public void mark(int paramInt)
    {
      this.mark = (this.currentPieceOffsetInRope + this.currentPieceIndex);
    }
    
    public boolean markSupported()
    {
      return true;
    }
    
    public int read()
    {
      advanceIfCurrentPieceFullyRead();
      ByteString.LeafByteString localLeafByteString = this.currentPiece;
      if (localLeafByteString == null) {
        return -1;
      }
      int i = this.currentPieceIndex;
      this.currentPieceIndex = (i + 1);
      return localLeafByteString.byteAt(i) & 0xFF;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      Objects.requireNonNull(paramArrayOfByte);
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt2 <= paramArrayOfByte.length - paramInt1)) {
        return readSkipInternal(paramArrayOfByte, paramInt1, paramInt2);
      }
      throw new IndexOutOfBoundsException();
    }
    
    public void reset()
    {
      try
      {
        initialize();
        readSkipInternal(null, 0, this.mark);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public long skip(long paramLong)
    {
      if (paramLong >= 0L)
      {
        long l = paramLong;
        if (paramLong > 2147483647L) {
          l = 2147483647L;
        }
        return readSkipInternal(null, 0, (int)l);
      }
      throw new IndexOutOfBoundsException();
    }
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.google.protobuf.RopeByteString
 * JD-Core Version:    0.7.0.1
 */