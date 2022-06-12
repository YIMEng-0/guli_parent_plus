package com.luobin.demo.edu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.luobin.demo.edu.entity.excel.SubjectData;
import com.luobin.demo.edu.service.EduSubjectService;

/**
 * @author Doraemon
 * @date 2022/6/12 7:36 下午
 * @version 1.0
 */

/**
 * 实现一个监听器
 *
 * 这个监听器是在 service 中 new 出来的，不需要使用 Spring 进行管理操作，
 * 因为没有使用 Spring 进行对象的管理，所以其他的对象在这里也是不能 Autowired 的，不可以直接注入进来
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {
    public EduSubjectService subjectService;

    public SubjectExcelListener() {

    }

    public SubjectExcelListener(EduSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(SubjectData data, AnalysisContext context) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
