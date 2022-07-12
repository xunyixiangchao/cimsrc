package com.farsunset.hoxin.moment.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import w7.a;

public class Moment
  implements Serializable
{
  public static final byte FORMAT_IMAGE = 0;
  public static final byte FORMAT_LINK = 1;
  public static final byte FORMAT_MULTI_IMAGE = 4;
  public static final byte FORMAT_TEXT = 3;
  public static final byte FORMAT_VIDEO = 2;
  private static final long serialVersionUID = 1L;
  private final List<Comment> commentList = new ArrayList();
  public String content;
  public Long createTime;
  public String extra;
  @a(serialize=false)
  public long id;
  public String text;
  public byte type;
  public long uid;
  
  private List<Comment> getVisibleList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.commentList.iterator();
    while (localIterator.hasNext())
    {
      Comment localComment = (Comment)localIterator.next();
      if (!localComment.deleted) {
        localArrayList.add(localComment);
      }
    }
    return localArrayList;
  }
  
  public void add(Comment paramComment)
  {
    this.commentList.add(paramComment);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof Moment;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (Moment)paramObject;
      bool1 = bool2;
      if (this.id == paramObject.id)
      {
        bool1 = bool2;
        if (paramObject.getVisibleList().equals(getVisibleList())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public Comment findOne(Long paramLong)
  {
    if (paramLong == null) {
      return null;
    }
    Iterator localIterator = this.commentList.iterator();
    while (localIterator.hasNext())
    {
      Comment localComment = (Comment)localIterator.next();
      if (localComment.id == paramLong.longValue()) {
        return localComment;
      }
    }
    return null;
  }
  
  public int getAllCount()
  {
    return this.commentList.size();
  }
  
  public List<Comment> getCommentList()
  {
    return this.commentList;
  }
  
  public int getPraiseCount()
  {
    Iterator localIterator = this.commentList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Comment localComment = (Comment)localIterator.next();
      if ((localComment.type.equals("2")) && (!localComment.deleted)) {
        i += 1;
      }
    }
    return i;
  }
  
  public List<Comment> getPraiseList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.commentList.iterator();
    while (localIterator.hasNext())
    {
      Comment localComment = (Comment)localIterator.next();
      if ((localComment.type.equals("2")) && (!localComment.deleted)) {
        localArrayList.add(localComment);
      }
    }
    return localArrayList;
  }
  
  public int getTextCount()
  {
    Iterator localIterator = this.commentList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Comment localComment = (Comment)localIterator.next();
      if ((!localComment.type.equals("2")) && (!localComment.deleted)) {
        i += 1;
      }
    }
    return i;
  }
  
  public List<Comment> getTextList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.commentList.iterator();
    while (localIterator.hasNext())
    {
      Comment localComment = (Comment)localIterator.next();
      if ((!localComment.type.equals("2")) && (!localComment.deleted)) {
        localArrayList.add(localComment);
      }
    }
    return localArrayList;
  }
  
  public int hashCode()
  {
    return getClass().getName().hashCode();
  }
  
  public void remove(Comment paramComment)
  {
    this.commentList.remove(paramComment);
  }
  
  public void setCommentList(List<Comment> paramList)
  {
    this.commentList.clear();
    this.commentList.addAll(paramList);
  }
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.moment.entity.Moment
 * JD-Core Version:    0.7.0.1
 */