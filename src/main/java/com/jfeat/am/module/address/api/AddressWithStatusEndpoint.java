package com.jfeat.am.module.address.api;


import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.am.module.address.services.domain.service.AddressService;
import com.jfeat.am.module.address.services.gen.persistence.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/crud/address/AddressWithStatusEndpoint")
public class AddressWithStatusEndpoint {

    @Resource
    AddressService addressService;

    @PostMapping
    public Tip addAddress(@RequestBody  Address entity){
        return SuccessTip.create(addressService.addWithDefaultAddress(entity));
    }

    @PutMapping("/{id}")
    public Tip updateAddress(@PathVariable("id") Long id,@RequestBody Address entity){
        entity.setId(id);
        return SuccessTip.create(addressService.updateWhitDefaultAddress(entity));
    }

    @DeleteMapping("/{id}")
    public Tip deleteAddress(@PathVariable("id") Long id){
        return SuccessTip.create(addressService.deleteWithDefaultAddress(id));
    }

    @GetMapping("/getDefaultAddress")
    public Tip queryDefaultAddress(@RequestBody Address entity){
        if (entity.getUserId()==null){
            throw new BusinessException(BusinessCode.CodeBase,"userId为必填项");
        }
        return SuccessTip.create(addressService.queryDefaultAddress(entity.getUserId()));
    }
}
