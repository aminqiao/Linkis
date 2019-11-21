package com.webank.wedatasphere.linkis.filesystem.service.impl;

import com.webank.wedatasphere.linkis.filesystem.dao.ResourceVersionMapper;
import com.webank.wedatasphere.linkis.filesystem.entity.ResourceVersion;
import com.webank.wedatasphere.linkis.filesystem.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    ResourceVersionMapper resourceVersionMapper;

    @Override
    public void addScript(String modelName,String userName,Integer version){
        ResourceVersion resourceVersion = new ResourceVersion(null,version+1,userName,new Date(),modelName,"remark");
        resourceVersionMapper.insertResourceVersion(resourceVersion);
    }
}
