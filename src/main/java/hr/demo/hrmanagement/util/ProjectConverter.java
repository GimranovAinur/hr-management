package hr.demo.hrmanagement.util;

import hr.demo.hrmanagement.entity.Project;
import hr.demo.hrmanagement.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProjectConverter implements Converter<String, Project> {

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public Project convert(String s) {
        return projectRepository.getById(Long.valueOf(s));
    }

}
