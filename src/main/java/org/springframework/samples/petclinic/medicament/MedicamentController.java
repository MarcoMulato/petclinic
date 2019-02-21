/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.medicament;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.samples.petclinic.users.loginReports;
import org.springframework.samples.petclinic.users.userReportsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Isaac
 */

@Controller
class MedicamentController {
    private static final String VIEWS_MEDICAMENT_CREATE_OR_UPDATE_FORM = "medicaments/createOrUpdateMedicamentForm";
    private final MedicamentRepository medicaments;
    private final Medicament_reportRepository t;
    private final userReportsRepository urr;
    
    private static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/resources/images/medicinas/";
    
    public MedicamentController(MedicamentRepository clinicService, Medicament_reportRepository ru, userReportsRepository urr) {
        this.medicaments = clinicService;
        this.t=ru;
        this. urr = urr;
    }
    
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    
    @GetMapping("/medicament/new")
    public String initCreationForm(Map<String, Object> model){
        System.out.println("Estoy en funcion 1");
        Medicament medicament = new Medicament();
        model.put("medicament", medicament);
        return VIEWS_MEDICAMENT_CREATE_OR_UPDATE_FORM;
    }
    
    @PostMapping("/medicament/new")
    public String processCreationForm(@RequestParam("files") MultipartFile[]files, @Valid Medicament medicament, BindingResult result){
        
        Date fecha = new Date();
        Medicament_report reporte = new Medicament_report();
        
        String nombre=null;
        System.out.println("Estoy en funcion 2");
        StringBuilder fileNames = new StringBuilder();
        for(MultipartFile file: files){
            System.out.println("ARCHIVO: " + file.getOriginalFilename());
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            nombre=file.getOriginalFilename();
            fileNames.append(file.getOriginalFilename());
            try{
                Files.write(fileNameAndPath, file.getBytes());
            }catch(IOException e){
                e.printStackTrace();
            }
            medicament.setImagen(nombre);
            //model.addAttribute("msg", "Se logró copiar " + fileNames.toString());
        }
       // System.out.println("¿Existe? " + this.medicaments.findId(medicament.getNombre()));
        //this.medicaments.findId(medicament.getNombre());
        if (result.hasErrors()) {
            System.out.println("Ocurrió un error.");
            System.out.println(result.getAllErrors());
            return VIEWS_MEDICAMENT_CREATE_OR_UPDATE_FORM;
        } else {
            System.out.println("Nombre: " + medicament.getNombre());
            reporte.setNombre(medicament.getNombre());
            reporte.setAccion("Fue creado");
            reporte.setFecha(fecha.toString());
            this.t.save(reporte);
            this.medicaments.save(medicament);
            return "redirect:/medicaments/";
        }
    }
        
    @GetMapping("/medicament/find")
    public String initFindForm(Map<String, Object> model) {
        Medicament medicament = new Medicament();
        model.put("medicament", medicament);
        return "medicaments/findMedicaments";
    }
        @GetMapping("/login/report")
	public String getLoginReport(Map<String, Object> model) {
		//System.out.println("Im in");
                Collection<loginReports> results = this.urr.findAll();
		model.put("selections", results);
		//System.out.println("R: " + results.get(0).getCorreo());
                System.out.println("Voy a reedirigir");
		return "medicaments/loginReports";	
	}
    
    @GetMapping("/medicaments")
    public String processFindForm(Medicament medicament, BindingResult result, Map<String, Object> model) {

        // allow parameterless GET request for /owners to return all records
        if (medicament.getNombre() == null) {
            medicament.setNombre(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        Collection<Medicament> results = this.medicaments.findByName(medicament.getNombre());
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("nombre", "notFound", "not found");
            return "medicaments/findMedicaments";
        } else if (results.size() == 1) {
            // 1 owner found
            medicament = results.iterator().next();
            return "redirect:/medicament/" + medicament.getId();
        } else {
            // multiple owners found
            model.put("selections", results);
            return "medicaments/medicamentsList";
        }
    }
    
    @GetMapping("/medicaments2")
    public String processFindForm2(Medicament medicament, BindingResult result, Map<String, Object> model) {

        // allow parameterless GET request for /owners to return all records
        if (medicament.getNombre() == null) {
            medicament.setNombre(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        Collection<Medicament> results = this.medicaments.findByName(medicament.getNombre());
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("nombre", "notFound", "not found");
            return "medicaments/findMedicaments";
        } else if (results.size() == 1) {
            // 1 owner found
            medicament = results.iterator().next();
            return "redirect:/medicament/" + medicament.getId();
        } else {
            // multiple owners found
            model.put("selections", results);
            return "medicaments/medicamentOnlyList";
        }
    }

    @GetMapping("/medicament/{medId}")
    public ModelAndView showOwner(@PathVariable("medId") int medId) {
        ModelAndView mav = new ModelAndView("medicaments/medicamentDetails");
        mav.addObject(this.medicaments.findById(medId));
        return mav;
    }
    
    @GetMapping("/medicament/delete/{medId}")
    public String deleteMedicament(Medicament medicament, BindingResult result, Map<String, Object> model,@PathVariable("medId") int medId){
        Date fecha = new Date();
        Medicament_report reporte = new Medicament_report();
        Medicament temp = new Medicament(); 
        temp = this.medicaments.findById(medId);
        System.out.println("Voy a eliminer a: " + temp.getNombre());
        reporte.setNombre(temp.getNombre());
        reporte.setAccion("Fue eliminado");
        reporte.setFecha(fecha.toString());
        this.t.save(reporte);   
        this.medicaments.delete(this.medicaments.findById(medId));
        Collection<Medicament> results = this.medicaments.findByName("");
        model.put("selections", results);
        return "redirect:/medicaments";
    }
    
    @GetMapping("/medicament/edit/{medId}")
    public String initUpdateMedicamentForm(@PathVariable("medId") int medId, Model model) {
        Medicament medicament = this.medicaments.findById(medId);
        model.addAttribute(medicament);
        return VIEWS_MEDICAMENT_CREATE_OR_UPDATE_FORM;
    }
    
    @GetMapping("/medicament/report")
	public String getUsers(Map<String, Object> model) {
		//System.out.println("Im in");
		Medicaments_Reports reporte = new Medicaments_Reports();
		reporte.getMedicamentList().addAll( this.t.findAll());
                Collection<Medicament_report> results = this.t.findAll();
		model.put("selections", results);
		//System.out.println("R: " + results.get(0).getCorreo());
                System.out.println("Voy a reedirigir");
		return "medicaments/medicamentReport";	
	}
    
    @PostMapping("/medicament/edit/{medId}")
    public String processUpdateOwnerForm(@RequestParam("files") MultipartFile[]files,@Valid Medicament medicament, BindingResult result, @PathVariable("medId") int medId) {
        String nombre=null;
        Date fecha = new Date();
        Medicament_report reporte = new Medicament_report();
        System.out.println("Estoy en funcion de edición");
        StringBuilder fileNames = new StringBuilder();
        
        for(MultipartFile file: files){
            System.out.println("ARCHIVO: " + file.getOriginalFilename());
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            nombre=file.getOriginalFilename();
            fileNames.append(file.getOriginalFilename());
            try{
                Files.write(fileNameAndPath, file.getBytes());
            }catch(IOException e){
                e.printStackTrace();
            }
            medicament.setImagen(nombre);
        }
        
        
        if (result.hasErrors()) {
            return VIEWS_MEDICAMENT_CREATE_OR_UPDATE_FORM;
        } else {
            System.out.println("Nombre: " + medicament.getNombre());
            reporte.setNombre(medicament.getNombre());
            reporte.setAccion("Fue editado");
            reporte.setFecha(fecha.toString());
            this.t.save(reporte);
            medicament.setId(medId);
            this.medicaments.save(medicament);
            return "redirect:/medicament/{medId}";
        }
    }
}
