package com.master_isi.dayr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.master_isi.dayr.model.Employee;
import com.master_isi.dayr.service.EmployeeService;
import com.master_isi.dayr.service.RemunerationService;
import com.master_isi.dayr.service.DepartementService;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartementService departementService;
    @Autowired
    private  RemunerationService remunerationService;

    @GetMapping("/employee")
    public String index(Model model) {
        model.addAttribute("employees", employeeService.findAll());
     
        return "test";
    }

    @GetMapping("/employee/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departements", departementService.listAll());
        model.addAttribute("remunerations", remunerationService.listAll());
        return "form";
    }

    @GetMapping("/employee/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.findOne(id));
        model.addAttribute("departements", departementService.listAll());
        model.addAttribute("remunerations", remunerationService.listAll());
        return "form";
    }

    @PostMapping("/employee/save")
    public String save(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        employeeService.save(employee);
        redirect.addFlashAttribute("success", "Saved employee successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        employeeService.delete(id);
        redirect.addFlashAttribute("success", "Deleted employee successfully!");
        return "redirect:/employee";
    } 

    @GetMapping("/employee/search")
    public String search(@RequestParam("s") String s, Model model) {
        if (s.equals("")) {
            return "redirect:/employee";
        }

        model.addAttribute("employees", employeeService.search(s));
        return "test";
    }
}