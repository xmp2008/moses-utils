package cn.xmp.moses.controller;

import cn.xmp.moses.entity.Person;
import cn.xmp.moses.entity.PersonV;
import cn.xmp.moses.enums.ReturnCodeEnum;
import cn.xmp.moses.model.response.BaseResponse;
import cn.xmp.moses.validator.AttributeValidatorException;
import cn.xmp.moses.validator.ValidationGroup;
import cn.xmp.moses.validator.ValidatorConditionType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 首页
 * </p>
 *
 * @package: com.xkcoding.admin.client.controller
 * @description: 首页
 * @author: yangkai.shen
 * @date: Created in 2018/10/8 2:15 PM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@RestController
public class IndexController {
    @GetMapping(value = {"", "/"})
    public String index() {
        return "This is a Spring Boot Admin Client.";
    }


    @PostMapping("/person")
    public BaseResponse getPerson(@Validated(ValidationGroup.Create.class) @RequestBody Person person) {
        BaseResponse response = new BaseResponse();
        response.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        response.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
        response.setDataInfo(person);
        return response;
//        return BaseResponse.builder().message(ReturnCodeEnum.CODE_1000.getValue())
//                .returnCode(ReturnCodeEnum.CODE_1000.getCode())
//                .dataInfo(person)
//                .build();
    }
    @PostMapping("/personV")
    public BaseResponse getPersonV(@RequestBody PersonV person) throws AttributeValidatorException {
        BaseResponse response = new BaseResponse();
//        try {
            person.validate(ValidatorConditionType.READ);
//        } catch (AttributeValidatorException e) {
//            e.printStackTrace();
//            response.setReturnCode(ReturnCodeEnum.CODE_1006.getCode());
//            response.setMessage(e.getMessage());
//            return response;
//        }

        response.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        response.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
        response.setDataInfo(person);
        return response;
    }

}
