package com.jfeat.am.module.order.api;

import com.jfeat.am.module.order.services.domain.service.DevService;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController

@Api("Dev")
@RequestMapping("/api/crud/dev")
public class DevEndpoint {

    @Resource
    DevService devService;

    @DeleteMapping("/delete/order")
    public Tip deleteOrder(@RequestParam(name = "type", required = true) String type){
        Integer integer = devService.deleteOrder(type);

        return SuccessTip.create(integer);
    }

    @DeleteMapping("/delete/orderRefunds")
    public Tip deleteOrderRefunds(){
        Integer integer = devService.deleteOrderRefunds();

        return SuccessTip.create(integer);
    }

    @DeleteMapping("/delete/ownerBalance")
    public Tip deleteOwnerBalance(){
        Integer integer = devService.deleteOwnerBalance();

        return SuccessTip.create(integer);
    }

}
