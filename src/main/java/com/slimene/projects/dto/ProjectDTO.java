package com.slimene.projects.dto;

import java.util.Date;

import com.slimene.projects.entities.Departement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDTO {
	private Long idProject;
	private String nomProject;
	private String nomClient;
	private Date dateDeb;
	private Departement departement;
}
