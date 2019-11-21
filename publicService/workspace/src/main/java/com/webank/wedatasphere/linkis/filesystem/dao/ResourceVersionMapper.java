package com.webank.wedatasphere.linkis.filesystem.dao;

import com.webank.wedatasphere.linkis.filesystem.entity.ResourceVersion;

public interface ResourceVersionMapper {

    ResourceVersion selectById(Integer id);
    void insertResourceVersion(ResourceVersion resourceVersion);
    ResourceVersion selectByModelName(String model);
}
