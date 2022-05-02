package com.luobin.demo.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luobin.common_utils.R;
import com.luobin.demo.edu.entity.EduTeacher;
import com.luobin.demo.edu.service.EduTeacherService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.ListUI;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author luobin
 * @since 2022-04-28
 */

/**
 *     @RestController = @Controller + @ResponseBody组成，等号右边两位注解简单介绍两句，
 *        就明白我们@RestController的意义了：
 *
 *     @Controller 将当前修饰的类注入SpringBoot IOC容器，使得从该类所在的项目跑起来的过程中，
 *        这个类就被实例化。当然也有语义化的作用，即代表该类是充当Controller的作用
 *     @ResponseBody 它的作用简短截说就是指该类中所有的API接口返回的数据，甭管你
 *        对应的方法返回Map或是其他Object，它会以Json字符串的形式返回给客户端
 */

/**
 * @RequestMapping 可以放置到类上面以及方法上面，放在类上面表示访问的根路径就是这个地方
 *                 放置在方法上面表示请求的根路径下面的子路径地址
 */

/**
 *      整体的访问逻辑是：请求来到后端，使用 service 调用相关的方法，service 调用 mapper ,
 * mapper 里面调用写了数据库代码的 SQL 语句，SQL  语句执行，查询数据库，得到最终的结果；
 *
 * @author yimeng
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/edu/teacher")   // 前端访问的路径/
public class EduTeacherController {
    /**
     * Controller 中注入 service ,调用相关的方法
     */
    @Autowired
    private EduTeacherService teacherService;

    /**
     * 查询表中的所有数据
     * rest 风格 在访问的时候，可以添加上去相关的访问方法
     * 浏览器访问的地址 ：http://localhost:8001/edu/teacher/findAll
     * @return
     */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAllTeacher() {
        // 调用 service 里面的方法，实现查询所有的操作
        // 经过了 service 调用 mapper mapper 执行并且返回数据，数据的格式是 json
        List<EduTeacher> list = teacherService.list(null);

        return R.ok().data("items", list);
    }

    /**
     * 逻辑删除的方式
     *   @DeleteMapping("{id}") 表示将来的这个参数是从 URL 访问的路径取到的
     *   @PathVariable 表示的是这个参数是在路径中获取到的参数 得到路径中的 id 值
     */
    @ApiOperation(value = "根据 id 删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@PathVariable String id) {
        // 服务调用相关方法即可

        boolean flag = teacherService.removeById(id);
        System.out.println("运行的结果是： " + flag);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 分页查询讲师的列表
     * @return 返回查询成功或者失败
     *
     * 将查询的参数在请求路径中进行传递
     */
    @ApiOperation("查询指定的页")
    @GetMapping("pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable long current, @PathVariable long limit) {
        // 创建 page 对象
        // Page 里面传递的参数，1 标识当前页数 3 表示当前页的条数
        Page<EduTeacher> pageTeacher = new Page<>(current, limit);

        // 调用方法，实现分页功能
        // pageTeacher 是翻页对象，后面是添加的条件，没有条件就写 null
        // 调用方法的时候，将分页的数据封装到 pageTeacher 里面去，
        teacherService.page(pageTeacher, null);

        // 在上面将所有的数据封装到了 pageTeacher 里面去，下面把数据取出来
        // 总记录数量
        long total = pageTeacher.getTotal();
        System.out.println("total: " + total);

        // 数据 List 的集合 就是在每一个 页面中的数据个体的集合
        List<EduTeacher> records = pageTeacher.getRecords();
        System.out.println("records:" + records);

        return R.ok().data("total", total).data("rows", records);
    }
}
