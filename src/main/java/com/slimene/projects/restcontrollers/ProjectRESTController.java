package com.slimene.projects.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.slimene.projects.dto.ProjectDTO;
import com.slimene.projects.entities.Project;
import com.slimene.projects.service.ProjectService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProjectRESTController {
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ProjectDTO> getAllProduits() {
		return projectService.getAllProjects();
	 } 		
	@GetMapping("/{id}")
	public ProjectDTO getProduitById(@PathVariable("id") Long id) {	
		return projectService.getProject(id);
    }
	
	@PostMapping
	public ProjectDTO createProduit(@RequestBody ProjectDTO projectDTO) {
		return projectService.saveProject(projectDTO);
	}

	@PutMapping
	public Project updateProduit(@RequestBody ProjectDTO projectDTO) {
		return projectService.updateProject(projectDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable("id") Long id)
	{
		projectService.deleteProjectById(id);
	}
	
	@GetMapping("/prodscat/{idCat}")
	public List<Project> getProduitsByCatId(@PathVariable("idDep") Long idDep) {
		return projectService.findByDepartementIdDep(idDep);
	 }
}
