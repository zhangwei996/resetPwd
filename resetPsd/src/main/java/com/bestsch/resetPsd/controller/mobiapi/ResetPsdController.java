package com.bestsch.resetPsd.controller.mobiapi;

import com.bestsch.openapi.BoaUser;
import com.bestsch.openapi.BschBaseOpenApi;
import com.bestsch.resetPsd.Config;
import com.bestsch.resetPsd.controller.BaseController;
import com.bestsch.resetPsd.service.ResetPsdService;
import com.bestsch.resetPsd.util.Page;
import com.bestsch.utils.DHttp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.ZhangW
 * @date 2020/3/12 11:15
 * @description:重置密码
 */
@RestController
@RequestMapping(Config.MOBILEAPI_PATH)
public class ResetPsdController {

    @Autowired
    private ResetPsdService resetPsdService;

    @Autowired
    private BschBaseOpenApi bschBaseOpenApi;


    /**
     * 通过教师id，获取所有的班级列表
     */
    @GetMapping(value = "GetAllClassList")
    public Object getAllClassList(BoaUser authUserWithDept) {

        return resetPsdService.getAllClassList(authUserWithDept.getId(),authUserWithDept.getSchool().getId());
    }


    /**
     * 通过班级id,获取所有的学生列表
     */
    @GetMapping("GetAllStuList")
    public Object getAllStuList(Integer ClassID) {

        return resetPsdService.getAllStuList(ClassID);
    }

    

    /**
     * 重置密码
     *
     * @param userID
     * @param stuID
     */
    @PostMapping(value = "SavePwd")
    public void savePwd(Integer userID,String stuID) {

        resetPsdService.savePwd(userID, stuID);
    }


    /**
     * 获取个人信息
     *
     * @return
     */
    @GetMapping("GetUserInfo")
    public Object getUserInfo(BoaUser authUserWithDept) {
        System.out.println(authUserWithDept.getSchool().getId());
        return authUserWithDept;
    }








    /*@GetMapping("GetUserInfo")
    public BoaUser getUserInfo(BoaUser authUser){
        BoaUser user =  bschBaseOpenApi.getUserInfoWithDept(authUser.getId());
        System.out.println(user);
        return user;
    }*/
}

