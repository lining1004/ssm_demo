package com.briup.web.controller;

import com.briup.bean.Student;
import com.briup.service.IStudentService;
import com.briup.utils.Result;
import com.briup.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器类  学生信息管理模块
 * @Author lining
 * @Date 2022/10/17
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService service;//service对象从哪里来?

    @GetMapping("/{id}")
    @ResponseBody  //json格式数据
    public Student findById(@PathVariable int id){
        return service.findById(id);
    }
    /*
       1.返回逻辑视图 String
       2.返回视图和模型  modelAndView
       3.返回json格式数据  业务对象类型 Student Result
       4.返回异常 ：当方法运行出现错误
       5.无任何返回 使用响应对象操作
       6.返回ResponseEntity 表示返回的一个用户定义响应信息
       7.返回一个内部跳转和重定向的资源
           动态资源 ：调用另一个方法的返回结果
           静态资源： 调用返回的一个真实的页码信息/WEB_INF/a.html
           deleteById(int id);
           deletBybatch(int[] id);
    *
    * */
    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteById(@PathVariable int id){
        service.deleteById(id);
        return ResultUtil.success();
    }

}
