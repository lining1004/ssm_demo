package com.briup.service;

import com.briup.bean.Student;
import com.briup.dao.StudentMapper;
import com.briup.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 使用 @Autowired注解：
 * 1.根据类型获取ioc容器对象  StudentMapper
 * 2.ioc容器中只有一个类型对象 ，并且必须有对象
 * 3.对应的类型上必须使用注解 @组件
 * @Author lining
 * @Date 2022/10/17
 */
@Service//spring ioc容器创建并管理
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentMapper mapper;//映射器对象 从ioc容器中获取
    @Override
    public Student findById(int id) {
        if(id == 0){
           throw new CustomException("模拟异常，测试异常处理器");
        }
        return mapper.selectById(id);
    }

    @Override
    public List<Student> findAllByCondition(int pageNum, int pageSize, int id, String name) {
        return null;
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public void deleteById(int id) {
        mapper.deleteById(id);
        //模拟当异常发生时，实现事务回滚操作，删除失效
        if(id == 4){
            throw new CustomException("模拟异常，观察事务是否回滚");
        }
    }
}
