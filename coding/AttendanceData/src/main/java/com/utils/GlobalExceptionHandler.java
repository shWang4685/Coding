package com.utils;

import com.assist.Msg;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 找不到页面的时候
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "shihengwang");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Msg defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        Msg msg=new Msg();
        msg.setMsg(e.getMessage());
        //msg.setMessage(e.getMessage());
        //msg.setMessage(e.getMessage());
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            msg.setCode(404);
        }else {
            msg.setCode(500);
        }
        return msg;
    }

}
