
package View;

import Addition.Validation;
import Model.Task;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ScreenView {
    Validation vl = new Validation();
    List<Task> tasks;
    
    public ScreenView() {
        tasks = new ArrayList<>();
    }
    
    public void Add(){
      String name = vl.getNonEmptyString("Requirement Name: ");
      String type = vl.getNonEmptyString("Task Type: ");
      System.out.print("Enter Date: ");
      Date date = vl.getDateFromInput();
      Float from = vl.getValidFloatInRange("From: ", 8, 17.5f);
      Float to = vl.getValidFloatInRange("To: ", 8, 17.5f);
      while (to <from){
          System.out.println("Please enter Ending time later Starting time");
          to = vl.getValidFloatInRange("To: ", 8, 17.5f);
      }
      Float time = to - from;
      String asg = vl.getNonEmptyString("Assignee: ");
      String reviewer = vl.getNonEmptyString("Reviewer: ");
      Task task = new Task(name, type, date, time, asg, reviewer);
      tasks.add(task);
      System.out.println("Task added successfully.");
  }  
    
    public void deleteTaskById(int id) {
    int index = -1;
    for (int i = 0; i < tasks.size(); i++) {
        Task task = tasks.get(i);
        if (task.getId() == id) {
            index = i;
            break;
        }
    }
  
    if (index != -1) {
        Task deletedTask = tasks.remove(index);
        System.out.println("Task deleted successfully:");
        System.out.println(deletedTask);
    } else {
        System.out.println("Task with ID " + id + " not found.");
    }
}
    
    public void Delete(){
    int id = vl.getIntAboveZeroFromInput("ID: ");
    deleteTaskById(id);
    }
    
   public void viewAllTasks() {
    System.out.println("ID\tName\t\tType\t\tDate\t\tTime\t\tAssignee\t\tReviewer");
    for (Task task : tasks) {
        System.out.println(task.toString());
    }
}
}
