package com.baizhi.controller;

import com.baizhi.entity.Dept;
import com.baizhi.entity.Emp;
import com.baizhi.entity.Vo;
import com.baizhi.service.DeptService;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    @RequestMapping("findAll")
    public String findAll(Vo vo, String did) {
        vo.setEmps(empService.findAll(did));
        return "/emp/emplist";
    }

    @RequestMapping("delete")
    public String delete(String id, String did) {
        empService.delete(id);
        return "redirect:/emp/findAll?did=" + did;
    }

    @RequestMapping("showdepts")
    @ResponseBody //用来传递json类型参数
    public List<Dept> showdepts() {
        List<Dept> depts = deptService.findAll();
        return depts;
    }

    @RequestMapping("add")
    public String add(Emp emp) {
        empService.save(emp);
        return "redirect:/emp/findAll?did=" + emp.getDept().getId();
    }

    @RequestMapping("showemp")
    public String showemp(String id, HttpServletRequest request) {
        Emp emp = empService.findById(id);
        //System.out.println(emp);
        request.setAttribute("emp", emp);
        return "/emp/updateEmp";
    }

    @RequestMapping("update")
    public String update(Emp emp) {
        empService.update(emp);
        return "redirect:/emp/findAll?did=" + emp.getDept().getId();
    }
}
