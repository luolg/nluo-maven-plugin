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

@Mojo(name = "my")
public class MyMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    MavenProject project;

    @Parameter(property = "hobby", defaultValue = "basketball")
    String hobby;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("hello my man");
        getLog().info("my hobby is : " + hobby);
        List<Dependency> dependencyList = project.getDependencies();
        for (Dependency d : dependencyList) {
            String out = String.format("group : %s, arti : %s, version: %s, scope: %s, key: %s, lala: %s",
                    d.getGroupId(), d.getArtifactId(), d.getVersion(), d.getScope(), d.getManagementKey(), d.getOptional());
            getLog().info(out);
            getLog().info("---->        "+ d.toString());
            getLog().info("");
        }
    }
}