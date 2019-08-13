package com.jfeat.am.module.termconfig.services.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.am.common.crud.impl.CRUDServiceOnlyImpl;
import com.jfeat.am.module.termconfig.services.crud.service.TermConfigService;
import com.jfeat.am.module.termconfig.services.persistence.dao.TermConfigMapper;
import com.jfeat.am.module.termconfig.services.persistence.model.TermConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * <p>
 *  implementation
 * </p>
 *
 * @author Code Generator
 * @since 2017-12-09
 */
@Service
public class TermConfigServiceImpl  extends CRUDServiceOnlyImpl<TermConfig> implements TermConfigService {

    @Resource
    private TermConfigMapper termConfigMapper;

    @Override
    protected BaseMapper<TermConfig> getMasterMapper() {
        return termConfigMapper;
    }

    @Override
    public TermConfig getTermConfigByType(String type) {
        TermConfig termConfig = new TermConfig();
        termConfig.setType(type);
        return termConfigMapper.selectOne(termConfig);
    }
}


