package com.jfeat.am.module.advertisement.api;

import com.jfeat.am.common.constant.tips.SuccessTip;
import com.jfeat.am.common.constant.tips.Tip;
import com.jfeat.am.common.controller.BaseController;
import com.jfeat.am.module.advertisement.services.service.PatchGroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  运维API, 不提供配置
 * </p>
 *
 * @author admin
 * @since 2017-09-20
 */
@RestController
@RequestMapping("/api/adm/ad/groups/data")
public class PatchGroupEndpoint extends BaseController {
    @Resource
    private PatchGroupService patchGroupService;

    @GetMapping
    public Tip getAllGroupData() {
        return SuccessTip.create(patchGroupService.getAllGroupData());
    }
}
