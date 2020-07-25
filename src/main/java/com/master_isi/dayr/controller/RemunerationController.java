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


import com.master_isi.dayr.model.Remuneration;
import com.master_isi.dayr.service.RemunerationService;

@Controller
public class RemunerationController {
	@Autowired
	private RemunerationService service;
	@RequestMapping("/listRemu")
	public String viewHomePage(Model model){
		
	List<Remuneration> listremunerations = service.listAll();
	model.addAttribute("listremunerations" , listremunerations);
	return "listremuneration"; 
	}
	
@RequestMapping("/newremunerations")
public String showRemunerationForm(Model model){
	Remuneration remuneration = new  Remuneration();
model.addAttribute("remuneration", remuneration);
return "new_remuneration"; 
}
@RequestMapping(value= "/saveremuneration" , method = RequestMethod.POST)
public String saveRemuneration(@ModelAttribute("remuneration") Remuneration remuneration){
service.save(remuneration);
return "redirect:/listRemu";
}

@RequestMapping("/edits/{id}")
public ModelAndView showRemunerationForm(@PathVariable(name="id") Long id){
ModelAndView mav = new ModelAndView("editremuneration");
Remuneration remuneration = service.get(id);
mav.addObject("remuneration",remuneration);
return mav; 
}


@RequestMapping("/deletes/{id}")
public String deleteRemuneration(@PathVariable(name="id") Long id){

 service.delete(id);

return "redirect:/listRemu";
}

}
