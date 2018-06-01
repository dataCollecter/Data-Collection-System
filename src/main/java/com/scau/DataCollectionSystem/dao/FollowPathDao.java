package com.scau.DataCollectionSystem.dao;

import com.scau.DataCollectionSystem.entity.FollowPath;

/**
 * Created by 哲帆 on 2018.5.31.
 */
public interface FollowPathDao extends MongoBase<FollowPath> {

    public void removeFollowPath(String spiderName);
}
