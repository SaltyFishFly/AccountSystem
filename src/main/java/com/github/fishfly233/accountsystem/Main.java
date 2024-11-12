package com.github.fishfly233.accountsystem;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class Main {

    public static void main(String[] args) throws LifecycleException {
        var tomcat = new Tomcat();
        tomcat.setPort(8080);
        var ctor = tomcat.getConnector();
        ctor.setURIEncoding("UTF-8");
        ctor.setEnforceEncodingInGetWriter(true);
        tomcat.setBaseDir(".");
        var ctx = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
        var resources = new StandardRoot(ctx);
        resources.addPreResources(
                new DirResourceSet(resources, "/WEB-INF/classes", new File("target/classes").getAbsolutePath(), "/")
        );
        ctx.setResources(resources);
        tomcat.start();
        tomcat.getServer().await();

    }
}
