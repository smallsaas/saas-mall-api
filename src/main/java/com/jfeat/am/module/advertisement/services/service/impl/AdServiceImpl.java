package com.jfeat.am.module.advertisement.services.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import com.jfeat.am.module.advertisement.services.persistence.dao.AdMapper;
import com.jfeat.am.module.advertisement.services.persistence.model.Ad;
import com.jfeat.am.module.advertisement.services.service.AdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-09-20
 */
@Service
public class AdServiceImpl extends CRUDServiceOnlyImpl<Ad> implements AdService {
    @Resource
    private AdMapper adMapper;

    @Override
    protected BaseMapper<Ad> getMasterMapper() {
        return adMapper;
    }

}
