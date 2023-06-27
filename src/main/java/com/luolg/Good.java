package com.luolg;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "good", defaultPhase = LifecyclePhase.INSTALL)
public class Good extends AbstractMojo {

    @Parameter(property = "name", defaultValue = "jack")
    protected String name;

    public void execute() {
        getLog().info("good man " + name);
    }
}
