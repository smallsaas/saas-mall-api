package com.jfeat.am.module.address.services.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.am.module.address.services.domain.dao.QueryAddressDao;
import com.jfeat.am.module.address.services.domain.service.AddressService;
import com.jfeat.am.module.address.services.gen.crud.service.impl.CRUDAddressServiceImpl;
import com.jfeat.am.module.address.services.gen.persistence.dao.AddressMapper;
import com.jfeat.am.module.address.services.gen.persistence.model.Address;
import com.jfeat.am.module.address.services.properties.AddressProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */

@Service("addressService")
public class AddressServiceImpl extends CRUDAddressServiceImpl implements AddressService {

    @Resource
    AddressMapper addressMapper;

    @Resource
    QueryAddressDao queryAddressDao;

    @Resource
    AddressProperties addressProperties;

    @Override
    protected String entityName() {
        return "Address";
    }


    /**
     * 更新默认地址
     * @param entity 需要更新的地址 id 和用户id必须填
     * @return 更新记录数
     */
    @Override
    @Transactional
    public int updateDefaultAddress(Address entity) {
        if (entity.getId()==null || entity.getUserId()==null){
            return 0;
        }
        Integer affect = 0;
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq(Address.USER_ID,entity.getUserId());
        List<Address> addressList = addressMapper.selectList(addressQueryWrapper);


//        将其他地址设置为不是默认值
        for (Address address:addressList){
            if (address.getId().equals(entity.getId())){
                address.setDefaultStatus(Address.DEFAULT_STATUS_DEFAULT);
            }else {
                address.setDefaultStatus(Address.DEFAULT_STATUS_NOT_DEFAULT);
            }
        }
//        全部更新
        affect += queryAddressDao.updateAddressList(addressList);
        return affect;
    }

    /**
     * 删除带默认值的地址
     * @param id 需要删除的地址
     * @return 删除记录数
     */
    @Override
    @Transactional
    public int deleteWithDefaultAddress(Long id) {
        if (id==null ){
            return 0;
        }
        Integer affect = 0;
        Address address =  addressMapper.selectById(id);
        if (address==null){
            return affect;
        }
        affect+=addressMapper.deleteById(id);

//        判断删除的是否是默认地址，如果是默认地址就查询用户地址列表，将第一个设置为默认地址
        if (address!=null && address.getDefaultStatus().equals(Address.DEFAULT_STATUS_DEFAULT)){
            QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
            addressQueryWrapper.eq(Address.USER_ID,address.getUserId());
            List<Address> addressList = addressMapper.selectList(addressQueryWrapper);
            if (addressList!=null && addressList.size()>0){
                affect+= this.updateDefaultAddress(addressList.get(0));
            }
        }
        return affect;
    }

    /**
     * 添加带默认值的地址
     * @param entity
     * @return
     */
    @Override
    @Transactional
    public int addWithDefaultAddress(Address entity) {
        if (entity.getUserId()==null){
            return 0;
        }

        Integer affect=0;

        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq(Address.USER_ID,entity.getUserId());
        List<Address> addressList = addressMapper.selectList(addressQueryWrapper);

        if (addressList!=null&&addressList.size()>=addressProperties.getMaxAddressCount()){
            throw new BusinessException(BusinessCode.CodeBase,"地址数量已上限");
        }

        if (entity.getDefaultStatus()==null || addressList==null || addressList.size()<=0){
            entity.setDefaultStatus(Address.DEFAULT_STATUS_DEFAULT);
            affect+=addressMapper.insert(entity);
        }
        if (addressList!=null && addressList.size()>0 && entity.getDefaultStatus()!=null && entity.getDefaultStatus().equals(Address.DEFAULT_STATUS_DEFAULT)){
            affect+=addressMapper.insert(entity);
            affect+=this.updateDefaultAddress(entity);
        }

        return affect;
    }

    /**
     *更新带默认地址的
     * @param entity
     * @return
     */
    @Override
    public int updateWhitDefaultAddress(Address entity) {
        if (entity.getId()==null){
            return 0;
        }
        Integer affect = 0;

        if (entity.getUserId()==null){
            Address address = addressMapper.selectById(entity.getId());
            if (address==null){
                return affect;
            }else {
                entity.setUserId(address.getUserId());
            }
        }

        if (entity.getDefaultStatus()!=null && entity.getDefaultStatus().equals(Address.DEFAULT_STATUS_DEFAULT)){
            affect+=addressMapper.updateById(entity);
            affect+= this.updateDefaultAddress(entity);
        }else {
            affect+=addressMapper.updateById(entity);
        }

        return affect;
    }

    /**
     * 查询用户的默认地址
     * @param userId
     * @return
     */
    @Override
    public Address queryDefaultAddress(Long userId) {
        if (userId==null){
            return null;
        }
        QueryWrapper<Address> addressQueryWrapper = new QueryWrapper<>();
        addressQueryWrapper.eq(Address.USER_ID,userId).eq(Address.DEFAULT_STATUS,Address.DEFAULT_STATUS_DEFAULT);
        Address address = addressMapper.selectOne(addressQueryWrapper);
        return address;
    }


}
