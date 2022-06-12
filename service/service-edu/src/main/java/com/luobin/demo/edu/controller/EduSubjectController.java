package com.luobin.demo.edu.controller;


import com.luobin.common_utils.R;
import com.luobin.demo.edu.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author luobin
 * @since 2022-06-03
 */
@RestController
@RequestMapping("/edu/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

    /**
     * 添加课程分类
     *  课程的文件通过 前端传递过来之后，直接读取文件的名字即可，因为目的不是将文件上传到服务器上面，而是读取内容
     *
     *  获取到上传文件的内容；
     */
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file) { // 得到上传的文件
        eduSubjectService.saveSubject(file);

        return R.ok();
    }
}

