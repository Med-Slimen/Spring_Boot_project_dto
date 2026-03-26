package com.slimene.projects.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProj", types = { Project.class })
public interface ProjectProjection {
	public String getNomProject();
}
