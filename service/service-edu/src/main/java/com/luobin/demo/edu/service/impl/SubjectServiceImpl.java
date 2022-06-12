package com.luobin.demo.edu.service.impl;

import com.luobin.demo.edu.entity.EduSubject;
import com.luobin.demo.edu.mapper.EduSubjectMapper;
import com.luobin.demo.edu.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author luobin
 * @since 2022-06-03
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {
    /**
     * 添加课程分类
     * 获取上传来的文件，将文件内容读取出来
     * 前端上传的 Excel 内容读取里面的内容
     * @param file
     */
    @Override
    public void saveSubject(MultipartFile file) {

    }
}
