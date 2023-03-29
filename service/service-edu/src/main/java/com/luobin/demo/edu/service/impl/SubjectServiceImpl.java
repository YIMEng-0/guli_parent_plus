package com.luobin.demo.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.luobin.demo.edu.entity.EduSubject;
import com.luobin.demo.edu.entity.excel.SubjectData;
import com.luobin.demo.edu.listener.SubjectExcelListener;
import com.luobin.demo.edu.mapper.EduSubjectMapper;
import com.luobin.demo.edu.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
     * @param file
     */
    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        try {
            InputStream in = file.getInputStream();
            EasyExcel.read(in, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
