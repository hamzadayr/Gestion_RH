package com.master_isi.dayr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.master_isi.dayr.model.Departement;
import com.master_isi.dayr.service.DepartementService;

@Controller
public class DepartementController {
	@Autowired
	private DepartementService service;
	@RequestMapping("/listDepartement")
	public String viewHomePage(Model model){
		
	List<Departement> listdepartements = service.listAll();
	model.addAttribute("listdepartements" , listdepartements);
	return "admin"; 
	}
	
@RequestMapping("/new")
public String showDepartmentForm(Model model){
Departement departement = new  Departement();
model.addAttribute("departement", departement);
return "new_departement"; 
}
@RequestMapping(value= "/save" , method = RequestMethod.POST)
public String saveDepatement(@ModelAttribute("departement") Departement depatement){
service.save(depatement);
return "redirect:/listDepartement";
}

@RequestMapping("/edit/{id}")
public ModelAndView showDepartmentForm(@PathVariable(name="id") Long id){
ModelAndView mav = new ModelAndView("editdepartement");
Departement departement = service.get(id);
mav.addObject("departement",departement);
return mav; 
}
@RequestMapping("/delete/{id}")
public String deleteepartment(@PathVariable(name="id") Long id){

 service.delete(id);

return "redirect:/listDepartement";
}

}
