package com.slimene.projects.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.slimene.projects.dto.ProjectDTO;
import com.slimene.projects.entities.Departement;
import com.slimene.projects.entities.Project;
import com.slimene.projects.repos.DepartementRepository;
import com.slimene.projects.repos.ProjectRepository;
@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectRepository projectRepo;
	@Autowired
	private DepartementRepository departementRepo;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public ProjectDTO saveProject(ProjectDTO p) {
		return convertEntityToDto(projectRepo.save(convertDtoToEntity(p)));
	}

	@Override
	public Project updateProject(ProjectDTO p) {
		return projectRepo.save(convertDtoToEntity(p));
	}

	@Override
	public void deleteProject(Project p) {
		projectRepo.delete(p);
		
	}

	@Override
	public void deleteProjectById(Long id) {
		 projectRepo.deleteById(id);
		
	}

	@Override
	public ProjectDTO getProject(Long id) {
		return convertEntityToDto(projectRepo.findById(id).get());
	}

	@Override
	public List<ProjectDTO> getAllProjects() {
		return projectRepo.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public Page<Project> getAllProjectsParPage(int page, int size) {
		return projectRepo.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Project> findByNomProject(String nom) {
		return projectRepo.findByNomProject(nom);
	}

	@Override
	public List<Project> findByNomProjectContains(String nom) {
		// TODO Auto-generated method stub
		return projectRepo.findByNomProjectContains(nom);
	}

	@Override
	public List<Project> findByNomMontant(String nom, Double montant) {
		// TODO Auto-generated method stub
		return projectRepo.findByNomMontant(nom, montant);
	}

	@Override
	public List<Project> findByDepartement(Departement departement) {
		// TODO Auto-generated method stub
		return projectRepo.findByDepartement(departement);
	}

	@Override
	public List<Project> findByDepartementIdDep(Long id) {
		// TODO Auto-generated method stub
		return projectRepo.findByDepartementIdDep(id);
	}

	@Override
	public List<Project> findByOrderByNomProjectAsc() {
		// TODO Auto-generated method stub
		return projectRepo.findByOrderByNomProjectAsc();
	}

	@Override
	public List<Project> trierProjectsNomsMontant() {
		// TODO Auto-generated method stub
		return projectRepo.trierProjectsNomsMontant();
	}

	@Override
	public List<Departement> getAllDepartements() {
		return departementRepo.findAll();
	}
	@Override
	public Project convertDtoToEntity(ProjectDTO projectDto) {
	Project project = new Project();
	project = modelMapper.map(projectDto, Project.class);
	project.setIdProject(project.getIdProject());
	project.setNomProject(project.getNomProject());
	project.setMontantProject(project.getMontantProject());
	project.setDateDeb(project.getDateDeb());
	project.setDepartement(project.getDepartement());
	 return project;
	}
	@Override
	public ProjectDTO convertEntityToDto(Project project) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		ProjectDTO projectDTO = modelMapper.map(project, ProjectDTO.class);
		return projectDTO;
	}
	
}
