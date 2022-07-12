package com.farsunset.hoxin.account.api.response;

import com.farsunset.hoxin.common.api.response.BaseResult;
import com.farsunset.hoxin.emoticon.entity.Emoticon;
import com.farsunset.hoxin.friend.entity.Friend;
import com.farsunset.hoxin.group.entity.Group;
import com.farsunset.hoxin.micro.entity.MicroServer;
import com.farsunset.hoxin.moment.entity.MomentRule;
import com.farsunset.hoxin.organization.entity.Organization;
import java.util.List;

public class BaseDataResult
  extends BaseResult
{
  public List<Friend> bothList;
  public List<Friend> contactList;
  public List<Emoticon> emoticonList;
  public List<Friend> friendList;
  public List<Group> groupList;
  public List<MicroServer> microServerList;
  public List<MomentRule> momentRuleList;
  public Organization organization;
}


/* Location:           E:\android_tools\AndroidKiller_v1.3.1\projects\hoxin-release\ProjectSrc\smali\
 * Qualified Name:     com.farsunset.hoxin.account.api.response.BaseDataResult
 * JD-Core Version:    0.7.0.1
 */