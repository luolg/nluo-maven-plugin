package com.luolg;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(name = "dependency-counter", defaultPhase = LifecyclePhase.COMPILE)
public class DependencyMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    MavenProject project;

    //    @Override
//    public void execute() throws MojoExecutionException, MojoFailureException {
//        List<Dependency> dependencyList = project.getDependencies();
//        long numDependencies = dependencyList.stream().count();
//        getLog().info("Number of dependencies : " + numDependencies);
//        for (Dependency d : dependencyList) {
//            getLog().info("group : " + d.getGroupId() + " , artifact : " + d.getArtifactId());
//        }
//    }

    @Parameter(property = "scope")
    String scope;

    public void execute() throws MojoExecutionException, MojoFailureException {
        List<Dependency> dependencyList = project.getDependencies();
        long numDependencies = 0;
        for (Dependency d : dependencyList) {
            if (d.getScope().equals(scope)) {
                getLog().info("group : " + d.getGroupId() + " , artifact : " + d.getArtifactId() + " version: " + d.getVersion());
                numDependencies++;
            }
        }
        getLog().info("Number of dependencies: " + numDependencies);
    }
}

