package com.xsr.web;

import com.xsr.param.UserParam;
import com.xsr.utils.BusinessException;
import com.xsr.utils.ReturnType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

/**
 * Created by 145811 on 2018/3/27.
 */

@RestController
@RequestMapping(value = "/vali")
@Api("参数校验接口")
public class HelloValidateController extends BaseController{

    /**
     * body 中的参数校验
     * @param param
     * @return
     */

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public Boolean addUser(@RequestBody @Valid UserParam param, BindingResult result) {
        if(result.hasErrors()){
            List<ObjectError> list =result.getAllErrors();
            StringBuffer sb = new StringBuffer();
            for(ObjectError  error:list){
                System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
                sb.append(error.getDefaultMessage());
                sb.append("</br>");
            }
            throw new BusinessException(ReturnType.ParamIllegal, sb.toString());
        }
        return true;
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ApiOperation(value = "查询用户", notes = "查询用户")
    @Validated
    public Boolean search(@Range(min = 1, max = 9, message = "年级只能从1-9")
                              @RequestParam(name = "grade", required = true)
                                      int grade,
                          @Min(value = 1, message = "班级最小只能1")
                              @Max(value = 99, message = "班级最大只能99")
                              @RequestParam(name = "classroom", required = true)
                                      int classroom) {
        System.out.println(grade + "," + classroom);
        return true;
    }
}
