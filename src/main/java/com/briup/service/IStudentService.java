package com.briup.service;

import com.briup.bean.Student;

import java.util.List;

/**
 * 业务逻辑层
 * @Author lining
 * @Date 2022/10/17
 * 不能以方法的返回值作为是否成功的标志
 */
public interface IStudentService {
    //查
    Student findById(int id);
    //多条件分页查询学生信息列表
    List<Student> findAllByCondition(int pageNum,int pageSize,int id,String name);
    //改  参数对象唯一标识id一定存在
    void updateStudent(Student student);
    //增  主键值 后端生成 默认为null
    void addStudent(Student student);
    //删  主键
    void deleteById(int id);
}
