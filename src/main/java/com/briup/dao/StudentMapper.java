package com.briup.dao;

import com.briup.bean.Student;

/**
 * 映射器接口
 * @Author lining
 * @Date 2022/10/17
 */
public interface StudentMapper {
    Student selectById(int id);

    void deleteById(int id);
}
