package com.nuist.homework.controller;

// 要求：
// 遵循RESTful规范
// 路径前缀： /api/students
// 使用ResultVO统一返回格式
// 使用@RestController和@RequestMapping注解
// 注入StudentDAO

import com.nuist.homework.dao.StudentDAO;
import com.nuist.homework.entity.Student;
import com.nuist.homework.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    // 获取所有学生
    @GetMapping("/students")
/*    public Map<Integer, Student> getStudents() {
        return studentDAO.list(); // Changed from return studentDAO.list(); to return studentDAO.list();
    }*/
    public ResultVO getStudents() {
        return ResultVO.success(studentDAO.list());
    }

    // 获取单个学生
    @GetMapping("/students/{id}")
/*    public Student getStudent(@PathVariable Integer id) {
        return studentDAO.getById(id);
    }*/
    public ResultVO getStudent(@PathVariable Integer id) {
        return studentDAO.getById(id) == null ? ResultVO.error(404,"未找到该学生") : ResultVO.success(studentDAO.getById(id));
    }

    // 添加学生
    @PostMapping("/students")
    public ResultVO addStudent(@RequestBody Student student) {
        studentDAO.add(student);
        return ResultVO.success();
    }

    // 更新学生
    @PutMapping("/students")
    public ResultVO updateStudent(@RequestBody Student student) {
        return studentDAO.update(student) ? ResultVO.success() : ResultVO.error(500,"更新失败");
    }

    // 删除学生
    @DeleteMapping("/students/{id}")
    public ResultVO deleteStudent(@PathVariable Integer id) {
        return studentDAO.delete(id) ? ResultVO.success() : ResultVO.error(500,"删除失败");
    }

    // 按性别查询
    @GetMapping("/students/search")
    public ResultVO searchByGender(@RequestParam String gender) {
        return ResultVO.success(studentDAO.searchByGender(gender));
    }
}
