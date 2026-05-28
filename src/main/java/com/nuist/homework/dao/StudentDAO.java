package com.nuist.homework.dao;

// 要求：
// 使用Map<Integer,Student>模拟数据库存储
// 提供CRUD方法 list() getById() add() update() delete()
// 在构造方法中初始化一些测试数据（至少2条）
// 使用@Repository注解标注为DAO层组件

import com.nuist.homework.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDAO {
    private static Map<Integer, Student> students = new HashMap<>();

    public StudentDAO() {
        students.put(1, new Student(1, "张三", 18, "zhangsan@163.com", "男"));
        students.put(2, new Student(2, "李四", 19, "lisi@163.com", "女"));
    }

    public Map<Integer, Student> list() {
        return students;
    }

    public Student getById(Integer id) {
        return students.get(id) == null ? null : students.get(id);
    }

    public void add(Student student) {
        students.put(student.getId(), student);
    }

    public boolean update(Student student) {
        for (Integer id : students.keySet()) {
            if (id.equals(student.getId())) {
                students.put(id, student);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Integer id) {
        for (Integer i : students.keySet()){
            if (i.equals(id)) {
                students.remove(id);
                return true;
            }
        }
        return false;
    }

    public Map<Integer, Student> searchByGender(String gender) {
        Map<Integer, Student> result = new HashMap<>();
        for (Integer id : students.keySet()) {
            if (students.get(id).getGender().equals(gender)) {
                result.put(id, students.get(id));
            }
        }
        return result;
    }
}
