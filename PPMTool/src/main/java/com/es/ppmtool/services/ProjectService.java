package com.es.ppmtool.services;


import com.es.ppmtool.domain.Project;
import com.es.ppmtool.exceptions.ProjectIdException;
import com.es.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository ;
    //Create an instance of ProjectRepository

    public Project saveOrUpdateProject (Project project){

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            //Change projectIdentifier to uppercase even if the user has inputed lowercase
            return projectRepository.save(project);
            //Saves project into project repository , using build in crud repository class.
        }catch (Exception e){
            throw new ProjectIdException("Project id '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
            // throws a ProjectIdException if projectIdentifier is already in use.
            //Turn to uppercase fisrt since all entries are uppercase.
        }
    }
    public Project findProjectByIdentifier(String projectId){
    //Find project by projectIdentifier.
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw new ProjectIdException("Project ID '"+projectId.toUpperCase()+"' doesn't exist");
        }

        return project ;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll() ;
    }
    public void deleteProjectById (String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project== null){
            throw new ProjectIdException("Cannot find project with id :"+projectId);
        }
        projectRepository.delete(project);
    }
}
