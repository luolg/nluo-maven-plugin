package com.luolg;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "bad", defaultPhase = LifecyclePhase.CLEAN)
public class Bad extends AbstractMojo {

    @Parameter(property = "country", defaultValue = "japan")
    protected String country;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("bad  " + country);
    }
}
