package com.baizhi.controller;

import com.baizhi.entity.Dept;
import com.baizhi.entity.Vo;
import com.baizhi.service.DeptService;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private EmpService empService;

    @RequestMapping("findAll")
    public String findAll(Vo vo) {
        vo.setDepts(deptService.findAll());
        return "/dept/deptlist";
    }

    @RequestMapping("delete")
    public String delete(String id) {
        empService.deleteDid(id);
        deptService.delete(id);
        return "redirect:/dept/findAll";
    }

    @RequestMapping("save")
    public String save(Dept dept) {
        deptService.save(dept);
        return "redirect:/dept/findAll";
    }

    @RequestMapping("show")
    public String show(String id, HttpServletRequest request) {
        Dept dept = deptService.findById(id);
        request.setAttribute("dept", dept);
        return "/dept/updateDept";
    }

    @RequestMapping("update")
    public String update(Dept dept) {
        deptService.update(dept);
        return "redirect:/dept/findAll";
    }
}
