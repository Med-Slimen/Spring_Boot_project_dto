package com.slimene.projects.entities;

import java.util.Date;

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
private Double montantProject;
private Date dateDeb;
private Departement departement;
private String nomDep;
}