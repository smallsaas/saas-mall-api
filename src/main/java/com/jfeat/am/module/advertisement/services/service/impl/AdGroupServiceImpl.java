package com.jfeat.am.module.advertisement.services.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import com.jfeat.am.module.advertisement.services.persistence.dao.AdGroupMapper;
import com.jfeat.am.module.advertisement.services.persistence.dao.AdMapper;
import com.jfeat.am.module.advertisement.services.persistence.model.Ad;
import com.jfeat.am.module.advertisement.services.persistence.model.AdGroup;
import com.jfeat.am.module.advertisement.services.service.AdGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-09-20
 */
@Service
public class AdGroupServiceImpl extends CRUDServiceOnlyImpl<AdGroup> implements AdGroupService {
    @Resource
    private AdGroupMapper adGroupMapper;
    @Resource
    private AdMapper adMapper;

    @Override
    protected BaseMapper<AdGroup> getMasterMapper() {
        return adGroupMapper;
    }

    @Override
    public List<Ad> showAdGroupsById(Long id) {
        return adMapper.selectList(new EntityWrapper<Ad>().eq("group_id", id));
    }

    @Override
    public List<Ad> showAdGroupsByIdCurrent(Long id) {
        return adMapper.selectList(new EntityWrapper<Ad>().eq("group_id", id).eq("enabled",1));
    }
}
