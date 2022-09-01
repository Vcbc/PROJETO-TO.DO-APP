
package TASKAPP;

import CONTROLLER.PROJECTCONTROLLER;
import MODEL.PROJECT;
import java.sql.Connection;
import java.util.List;

public class Main {

   
    public static void main(String[] args) {
        
        PROJECTCONTROLLER projectcontroller = new PROJECTCONTROLLER();
        
        PROJECT project = new PROJECT();
        
        project.setNAME("projeto teste");
        project.setDESCRIPTION("descrição");
        projectcontroller.Save(project);
        
        project.setNAME("novo projeto");
        projectcontroller.Update(project);
        
        List<PROJECT> projects = projectcontroller.getall();
        System.out.println("total " + projects.size());
        
        
       
       
       

        
        
        
        
        
    }
    
}
