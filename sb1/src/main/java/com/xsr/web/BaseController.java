package com.xsr.web;

import com.xsr.utils.MyDateEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by 145811 on 2018/3/23.
 */
public class BaseController {
//    private Boolean isJson(HttpServletRequest request){
//        String header = request.getHeader("content-type");
//        return header != null && header.contains("json");
//    }
//    @ExceptionHandler(BaseException.class)
//    public Object handleBaseException(HttpServletRequest request, baseException e) {
//        if(isJson(request)) {
//            return ResponseUtils.restResponse(
//                    e.getCode(),
//                    e.getMessage(),
//                    e.getStatus()
//            );
//        } else {
//            ModelAndView modelAndView = initModelAndView();
//            if (e.getCode().equalsIgnoreCase("login_first")) {
//                modelAndView.setViewName("redirect:/list");
//            }
//            if (e.getCode().equalsIgnoreCase("real_name_not_set")) {
//                modelAndView.setViewName("redirect:/account");
//            }else{
//                modelAndView.setViewName("/404");
//            }
//            modelAndView.addObject("exception", e);
//            return modelAndView;
//        }
//    }


//
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ErrorInfo<String> r = new ErrorInfo<String>();
//        r.setMessage(e.getMessage());
//        r.setCode(ErrorInfo.ERROR);
//        r.setData("Some Data");
//        r.setUrl(req.getRequestURL().toString());
//        return r;
//    }
//
//    public static final String DEFAULT_ERROR_VIEW = "error";
//
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName(DEFAULT_ERROR_VIEW);
//        return mav;
//    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new MyDateEditor());
        binder.registerCustomEditor(Time.class, new CustomDateEditor(new SimpleDateFormat("HH:mm:ss"), true));
    }
}
