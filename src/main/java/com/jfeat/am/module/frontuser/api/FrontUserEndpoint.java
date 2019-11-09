package com.jfeat.am.module.frontuser.api;


import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.common.annotation.Permission;
import com.jfeat.am.core.jwt.JWTKit;
import com.jfeat.am.module.frontuser.services.domain.dao.QueryFrontUserDao;
import com.jfeat.am.module.frontuser.services.domain.model.FrontUserRecord;
import com.jfeat.am.module.frontuser.services.domain.service.FrontUserService;
import com.jfeat.am.module.frontuser.services.gen.persistence.model.FrontUser;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.jfeat.am.module.frontuser.definition.*;

import javax.annotation.Resource;
import java.util.Date;


/**
 * <p>
 * api
 * </p>
 *
 * @author Code Generator
 * @since 2019-08-22
 */
@RestController

@Api("FrontUser")
@RequestMapping("/api/crud/user/users")
public class FrontUserEndpoint {


    @Resource
    FrontUserService frontUserService;



    @Resource
    QueryFrontUserDao queryFrontUserDao;


    @BusinessLog(name = "FrontUser", value = "create FrontUser")
    @PostMapping
    @ApiOperation(value = "新建 FrontUser", response = FrontUser.class)
    public Tip createUser(@RequestBody FrontUser entity) {

        Integer affected = 0;
        try {
            affected = frontUserService.createMaster(entity);

        } catch (DuplicateKeyException e) {
            throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
    }

    @BusinessLog(name = "FrontUser", value = "查看 FrontUser")
    @GetMapping("/{id}")
    @ApiOperation(value = "查看 FrontUser", response = FrontUser.class)
    @Permission(FrontUserPermission.FRONTUSER_VIEW)
    public Tip getUser(@PathVariable Long id) {
        return SuccessTip.create(frontUserService.retrieveMaster(id));
    }

    @BusinessLog(name = "FrontUser", value = "update FrontUser")
    @PutMapping("/{id}")
    @ApiOperation(value = "修改 FrontUser", response = FrontUser.class)
    public Tip updateUser(@PathVariable Long id, @RequestBody FrontUser entity) {
        entity.setId(id);
        return SuccessTip.create(frontUserService.updateMaster(entity));
    }

    @BusinessLog(name = "FrontUser", value = "delete FrontUser")
    @DeleteMapping("/{id}")
    @ApiOperation("删除 FrontUser")
    public Tip deleteUser(@PathVariable Long id) {
        return SuccessTip.create(frontUserService.deleteMaster(id));
    }

    @BusinessLog(name = "FrontUser", value = "delete FrontUser")
    @ApiOperation(value = "FrontUser 列表信息", response = FrontUserRecord.class)
    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer"),
            @ApiImplicitParam(name = "search", dataType = "String"),
            @ApiImplicitParam(name = "id", dataType = "Long"),
            @ApiImplicitParam(name = "loginName", dataType = "String"),
            @ApiImplicitParam(name = "name", dataType = "String"),
            @ApiImplicitParam(name = "realName", dataType = "String"),
            @ApiImplicitParam(name = "password", dataType = "String"),
            @ApiImplicitParam(name = "email", dataType = "String"),
            @ApiImplicitParam(name = "phone", dataType = "String"),
            @ApiImplicitParam(name = "weixin", dataType = "String"),
            @ApiImplicitParam(name = "registerDate", dataType = "Date"),
            @ApiImplicitParam(name = "lastLoginDate", dataType = "Date"),
            @ApiImplicitParam(name = "salt", dataType = "String"),
            @ApiImplicitParam(name = "status", dataType = "String"),
            @ApiImplicitParam(name = "tokenSalt", dataType = "String"),
            @ApiImplicitParam(name = "tokenExpiredDate", dataType = "Date"),
            @ApiImplicitParam(name = "invitationCode", dataType = "String"),
            @ApiImplicitParam(name = "inviterId", dataType = "Long"),
            @ApiImplicitParam(name = "avatar", dataType = "String"),
            @ApiImplicitParam(name = "sex", dataType = "Integer"),
            @ApiImplicitParam(name = "birthday", dataType = "Date"),
            @ApiImplicitParam(name = "details", dataType = "String"),
            @ApiImplicitParam(name = "uid", dataType = "String"),
            @ApiImplicitParam(name = "followed", dataType = "Integer"),
            @ApiImplicitParam(name = "followTime", dataType = "Date"),
            @ApiImplicitParam(name = "invitationQrcodeUrl", dataType = "String"),
            @ApiImplicitParam(name = "invitationQrcode", dataType = "String"),
            @ApiImplicitParam(name = "wxUnionid", dataType = "String"),
            @ApiImplicitParam(name = "wxaOpenid", dataType = "String"),
            @ApiImplicitParam(name = "appUser", dataType = "Integer"),
            @ApiImplicitParam(name = "cabinCode", dataType = "String"),
            @ApiImplicitParam(name = "storeCode", dataType = "String"),
            @ApiImplicitParam(name = "assistantCode", dataType = "String"),
            @ApiImplicitParam(name = "wechatName", dataType = "String"),
            @ApiImplicitParam(name = "wxappOpenid", dataType = "String"),
            @ApiImplicitParam(name = "grade", dataType = "String"),
            @ApiImplicitParam(name = "contactPhone", dataType = "String"),
            @ApiImplicitParam(name = "contactWxNumber", dataType = "String"),
            @ApiImplicitParam(name = "lastModifiedTime", dataType = "Date"),
            @ApiImplicitParam(name = "orderBy", dataType = "String"),
            @ApiImplicitParam(name = "sort", dataType = "String")
    })
    @Permission(FrontUserPermission.FRONTUSER_VIEW)
    public Tip queryUsers(Page<FrontUserRecord> page,
                          @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                          @RequestParam(name = "search", required = false) String search,
                          @RequestParam(name = "id", required = false) Long id,
                          @RequestParam(name = "loginName", required = false) String loginName,
                          @RequestParam(name = "name", required = false) String name,
                          @RequestParam(name = "realName", required = false) String realName,
                          @RequestParam(name = "password", required = false) String password,
                          @RequestParam(name = "email", required = false) String email,
                          @RequestParam(name = "phone", required = false) String phone,
                          @RequestParam(name = "weixin", required = false) String weixin,
                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date registerDate,
                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date lastLoginDate,
                          @RequestParam(name = "salt", required = false) String salt,
                          @RequestParam(name = "status", required = false) String status,
                          @RequestParam(name = "tokenSalt", required = false) String tokenSalt,
                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date tokenExpiredDate,
                          @RequestParam(name = "invitationCode", required = false) String invitationCode,
                          @RequestParam(name = "inviterId", required = false) Long inviterId,
                          @RequestParam(name = "avatar", required = false) String avatar,
                          @RequestParam(name = "sex", required = false) Integer sex,
                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date birthday,
                          @RequestParam(name = "details", required = false) String details,
                          @RequestParam(name = "uid", required = false) String uid,
                          @RequestParam(name = "followed", required = false) Integer followed,
                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date followTime,
                          @RequestParam(name = "invitationQrcodeUrl", required = false) String invitationQrcodeUrl,
                          @RequestParam(name = "invitationQrcode", required = false) String invitationQrcode,
                          @RequestParam(name = "wxUnionid", required = false) String wxUnionid,
                          @RequestParam(name = "wxaOpenid", required = false) String wxaOpenid,
                          //@RequestParam(name = "appUser", required = false) Integer appUser,
                          @RequestParam(name = "cabinCode", required = false) String cabinCode,
                          @RequestParam(name = "storeCode", required = false) String storeCode,
                          @RequestParam(name = "assistantCode", required = false) String assistantCode,
                          @RequestParam(name = "wechatName", required = false) String wechatName,
                          @RequestParam(name = "wxappOpenid", required = false) String wxappOpenid,
                          @RequestParam(name = "grade", required = false) String grade,
                          @RequestParam(name = "contactPhone", required = false) String contactPhone,
                          @RequestParam(name = "contactWxNumber", required = false) String contactWxNumber,
                          @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date lastModifiedTime,
                          @RequestParam(name = "orderBy", required = false) String orderBy,
                          @RequestParam(name = "sort", required = false) String sort) {
        if (orderBy != null && orderBy.length() > 0) {
            if (sort != null && sort.length() > 0) {
                String pattern = "(ASC|DESC|asc|desc)";
                if (!sort.matches(pattern)) {
                    throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
                }
            } else {
                sort = "ASC";

            }
            orderBy = "`" + orderBy + "`" + " " + sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

        FrontUserRecord record = new FrontUserRecord();
        record.setId(id);
        record.setLoginName(loginName);
        record.setName(name);
        record.setRealName(realName);
        record.setPassword(password);
        record.setEmail(email);
        record.setPhone(phone);
        record.setWeixin(weixin);
        record.setRegisterDate(registerDate);
        record.setLastLoginDate(lastLoginDate);
        record.setSalt(salt);
        record.setStatus(status);
        record.setTokenSalt(tokenSalt);
        record.setTokenExpiredDate(tokenExpiredDate);
        record.setInvitationCode(invitationCode);
        record.setInviterId(inviterId);
        record.setAvatar(avatar);
        record.setSex(sex);
        record.setBirthday(birthday);
        record.setDetails(details);
        record.setUid(uid);
        record.setFollowed(followed);
        record.setFollowTime(followTime);
        record.setInvitationQrcodeUrl(invitationQrcodeUrl);
        record.setInvitationQrcode(invitationQrcode);
        record.setWxUnionid(wxUnionid);
        record.setWxaOpenid(wxaOpenid);
        record.setAppUser(1);
        record.setCabinCode(cabinCode);
        record.setStoreCode(storeCode);
        record.setAssistantCode(assistantCode);
        record.setWechatName(wechatName);
        record.setWxappOpenid(wxappOpenid);
        record.setGrade(grade);
        record.setContactPhone(contactPhone);
        record.setContactWxNumber(contactWxNumber);
        record.setLastModifiedTime(lastModifiedTime);
//        record.setOrgId(JWTKit.getOrgId());
        page.setRecords(this.queryFrontUserDao.findUserPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
    }
}
