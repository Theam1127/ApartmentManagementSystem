/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import ADT.GuardLinkedQueue;
import ADT.RequestDLinkedQueue;
import ADT.ToolsLinkedQueue;
import ADT.ToolsQueueInterface;
import EntityClass.Request;
import EntityClass.RequestInterface;
import EntityClass.Tools;
import EntityClass.ToolsInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import ADT.RequestQueueInterface;
import ADT.ServedLinkedQueue;
import ADT.ServedQueueInterface;
import EntityClass.Guard;
import EntityClass.GuardInterface;
import EntityClass.User;
import EntityClass.UserInterface;
import ADT.GuardQueueInterface;

/**
 *
 * @author Yeap Theam
 */
public class EmergencyAlert{
    public static void main(String[] args) {
        RequestQueueInterface<RequestInterface> AlertList = new RequestDLinkedQueue<>();
        ServedQueueInterface<UserInterface> ServedList = new ServedLinkedQueue<>();
        ToolsQueueInterface<ToolsInterface> ToolsList = new ToolsLinkedQueue<>();
        GuardQueueInterface<GuardInterface> GuardList = new GuardLinkedQueue<>();
        RequestInterface request = new Request();
        ToolsInterface tool = new Tools();
        GuardInterface guard = new Guard();
        UserInterface user = new User();
        
        Scanner input = new Scanner(System.in);
        int level, scenario=0 , cont=0;
        String name = "Lee Yeap Theam";
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy '@' hh:mm:ssa");
        String currentDate = "";
        String status = "Incomplete";
        String[] lv1Incidents = {"Small fire", "Small electrical outages", "House was intruded by stranger","Door locked"};
        String[] lv2Incidents = {"Small Explosion/Medium fire", "Power outage","Gas Leakage","Hazardous material found"};
        String[] lv3Incidents = {"Big Explosion","Earthquake","Snake foound in house","House is being intruded"};
        String incident = "";
        
        Tools t1 = new Tools("Fire Extinguisher", 1);
        Tools t2 = new Tools("Toolbox", 1);
        Tools t3 = new Tools("Notepad and Pencil", 1);
        Tools t4 = new Tools("Hammer", 1);
        Tools t5 = new Tools("Fire Entinguisher and Water Hos", 2);
        Tools t6 = new Tools("Electricity Toolbox", 2);
        Tools t7 = new Tools("Gas Mask", 2);
        Tools t8 = new Tools("Spill Kit", 2);
        Tools t9 = new Tools("Big Tank of Water and Water Hos", 3);
        Tools t10 = new Tools("Body Bag", 3);
        Tools t11 = new Tools("Snake Tongs", 3);
        Tools t12 = new Tools("Handcuffs and Taser Gun", 3);
        
        Request r1 = new Request(3,lv3Incidents[2],name,"03/08/2017 @ 01:02:20AM", "Incomplete");
        Request r2 = new Request(1,lv1Incidents[0],name,"03/08/2017 @ 05:14:30PM", "Incomplete");
        Request r3 = new Request(2,lv2Incidents[1],name,"03/08/2017 @ 06:30:41PM", "Incomplete");
        Request r4 = new Request(1,lv1Incidents[3],name,"03/08/2017 @ 07:22:33PM", "Incomplete");
        Request r5 = new Request(3,lv3Incidents[1],name,"03/08/2017 @ 11:52:09PM", "Incomplete");
        
        Guard g1 = new Guard("Tan Ah Kow",6,3);
        Guard g2 = new Guard("Ong Juin Ta",5,1);
        Guard g3 = new Guard("Ting Shu Hang",4,1);
        Guard g4 = new Guard("Che Zhen Feng",3,1);
        Guard g5 = new Guard("Rong Wei Xuan",1,1);
        
        ToolsList.enqueue(t1);
        ToolsList.enqueue(t2);
        ToolsList.enqueue(t3);
        ToolsList.enqueue(t4);
        ToolsList.enqueue(t5);
        ToolsList.enqueue(t6);
        ToolsList.enqueue(t7);
        ToolsList.enqueue(t8);
        ToolsList.enqueue(t9);
        ToolsList.enqueue(t10);
        ToolsList.enqueue(t11);
        ToolsList.enqueue(t12);
        
        
        AlertList.addNewRequest(r1);
        AlertList.addNewRequest(r2);
        AlertList.addNewRequest(r3);
        AlertList.addNewRequest(r4);
        AlertList.addNewRequest(r5);
        
        
        GuardList.enqueue(g1);
        GuardList.enqueue(g2);
        GuardList.enqueue(g3);
        GuardList.enqueue(g4);
        GuardList.enqueue(g5);
        
        int menuChoice = 0;
        
        System.out.println("APARTMENT HARMONY");
        
        do{
            System.out.println("====================");
            System.out.println("    Main Menu");
            System.out.println("====================");
            System.out.println("Select what you want to perform.");
            System.out.println("1. Tools Management");
            System.out.println("2. Emergency Alert");
            System.out.print("3. Guards Management\n> ");
            menuChoice = input.nextInt();
            switch(menuChoice){
                case 1:
                    System.out.println("====================");
                    System.out.println("  Tools Management");
                    System.out.println("====================");
                    System.out.println("Select what you want to perform.");
                    System.out.println("1. Add new Tools");
                    System.out.println("2. Update Tools");
                    System.out.println("3. Delete Tools");
                    System.out.print("4. Display Tools\n> ");
                    int choice1 = input.nextInt();
                    
                    switch(choice1){
                    case 1:
                        int confirmation = 0;

                        System.out.print("Enter the name of the new tool: ");
                        input.nextLine();
                        String newTool = input.nextLine();
                        System.out.print("Enter the level of the new tool: ");
                        int newLevel = input.nextInt();


                        System.out.println("Are you sure you want to insert the tool?");
                        System.out.print("1. Yes\n2. No\n> ");
                        confirmation = input.nextInt();

                        if(confirmation == 1){
                            tool = new Tools(newTool, newLevel);

                            ToolsList.enqueue(tool);
                            System.out.println("Your tool has been inserted into the database");
                        }
                        break;
                    
                    case 2:
                        String newName;
                        if(ToolsList.displayTools() == true){
                            System.out.print("Select which tool you would like to edit > ");
                            int toolPosition = input.nextInt();
                            if(toolPosition <= ToolsList.getLength() && toolPosition > 0){
                                System.out.print("Enter the new name for the tool > ");
                                input.nextLine();
                                newName= input.nextLine();    
                                System.out.print("Enter the new level for the tool > ");
                                newLevel = input.nextInt();
                                           
                                System.out.println("You have entered the following information :");
                                System.out.println("Tool's name\t> " + newName);
                                System.out.println("Level of tools\t> " + newLevel);
                                System.out.println("Are you confirmed you want to edit this tool?");
                                System.out.print("1. Yes\n2. No\n> ");
                                confirmation = input.nextInt();

                                if(confirmation == 1){
                                    tool = new Tools(newName, newLevel);  
                                    ToolsList.updateTools(toolPosition, tool);
                                    System.out.println("The tool has been updated!");
                                }
                            }
                            else
                                System.out.println("Invalid input.");
                            }
                        break;
                        
                    case 3:
                        if(ToolsList.displayTools() == true){
                            System.out.print("Select which tool you want to delete > ");
                            int deleteTools = input.nextInt();

                            if(deleteTools <= ToolsList.getLength() && deleteTools > 0){
                                System.out.println("Are you sure you want to delete this tool?");
                                System.out.print("1. Yes\n2. No\n> ");
                                confirmation = input.nextInt();

                                if(confirmation == 1){
                                    tool = ToolsList.deleteTools(deleteTools);
                                    System.out.println(tool.getName()+" has been delete successfully!");
                                }
                            }
                            else
                                System.out.println("Invalid input.");
                        }             
                        break;
                        
                    case 4:
                        ToolsList.displayTools();
                        break;
                    default:
                        System.out.println("Invalid input.");
                    }
                    break;
                case 2:
                    System.out.println("====================");
                    System.out.println("  Emergency Alert");
                    System.out.println("====================");
                    System.out.println("Select what you want to perform.");
                    System.out.println("1. Add New Request");
                    System.out.println("2. Update Request");
                    System.out.println("3. Delete Request");
                    System.out.println("4. Solve a Request");
                    System.out.println("5. Update Served Request Status");
                    System.out.println("6. Display Served Requests");
                    System.out.print("7. Display Unserved Requests\n> ");
                    int choice = input.nextInt();
                    switch(choice){
                        case 1:
                            int confirmation = 0;
                            System.out.println("Select emergency level");
                            System.out.print("1. Level 1\n2. Level 2 \n3. Level 3 \n> ");
                            level = input.nextInt();
                            if(level<1 || level>3){
                                System.out.println("Invalid input.");
                                break;
                            }
                            System.out.println("Select the incident to report:");
                            if(level==1){
                                for(int a=0;a<4;a++)
                                    System.out.println(a+1+". "+lv1Incidents[a]);
                                System.out.print("> ");
                                scenario = input.nextInt();
                                if(scenario>0&&scenario<5)
                                    incident = lv1Incidents[scenario-1];
                            }
                            else if(level==2){
                                for(int a=0;a<4;a++)
                                    System.out.println(a+1+". "+lv2Incidents[a]);
                                System.out.print("> ");
                                scenario = input.nextInt();
                                if(scenario>0&&scenario<5)
                                    incident = lv2Incidents[scenario-1];
                            }
                            else if(level==3){
                                for(int a=0;a<4;a++)
                                    System.out.println(a+1+". "+lv3Incidents[a]);
                                System.out.print("> ");
                                scenario = input.nextInt();
                                if(scenario>0&&scenario<5)
                                    incident = lv3Incidents[scenario-1];
                            }
                            if(scenario<1 || scenario>4){
                                System.out.println("Invalid input.");
                                break;
                            }

                            System.out.println("You have entered the following:");
                            System.out.println("Level of emergency\t> "+level);
                            System.out.println("Incident\t\t> "+incident);
                            System.out.println("Staff name\t\t> "+name);
                            date = new Date();
                            currentDate = df.format(date);
                            System.out.println("Current Date\t\t> "+currentDate);
                            System.out.println("Are you sure you want to insert the request?");
                            System.out.print("1. Yes\n2. No\n> ");
                            confirmation = input.nextInt();
                            

                            if(confirmation == 1){
                                request = new Request(level,incident,name, currentDate, status);
                                AlertList.addNewRequest(request);
                                System.out.println("Your request has been inserted into the database");
                            }
                            break;
                        case 2:
                            if(AlertList.displayEntry()==true){
                                System.out.print("Select which request you would like to edit > ");
                                int position = input.nextInt();
                                if(position<=AlertList.getLength() && position > 0){
                                    System.out.println("Enter your edition:");
                                    System.out.println("Select emergency level");
                                    System.out.print("1. Level 1\n2. Level 2 \n3. Level 3 \n> ");
                                    level = input.nextInt();
                                    input.nextLine();
                                    System.out.print("Enter the incident > ");
                                    incident = input.nextLine();
                                    date = new Date();
                                    currentDate = df.format(date);
                                    request = new Request(level,incident,name, currentDate, status);
                                    System.out.println("You have entered the following:");
                                    System.out.println("Level of emergency\t> "+level);
                                    System.out.println("Incident\t\t> "+incident);
                                    System.out.println("Staff name\t\t> "+name);
                                    System.out.println("Current date\t\t> "+currentDate);
                                    System.out.println("Are you confirmed that you want to edit the request?");
                                    System.out.print("1. Yes\n2. No\n> ");
                                    confirmation = input.nextInt();
                                   if(confirmation == 1){
                                       AlertList.updateRequest(position, request);
                                       System.out.println("The request has been updated!");
                                   }
                                }
                                else
                                    System.out.println("Invalid input.");
                            }
                            break;
                        case 3:
                            if(AlertList.displayEntry()==true){
                            System.out.print("Select which request you would like to delete > ");
                            int deletePosition = input.nextInt();
                            if(deletePosition <= AlertList.getLength() && deletePosition > 0){
                            System.out.println("Are you confirmed that you want to delete the request?");
                            System.out.print("1. Yes\n2. No\n> ");
                            confirmation = input.nextInt();
                           if(confirmation == 1){
                               AlertList.removeRequest(deletePosition);
                               System.out.println("The request has been deleted.");
                           }
                            }
                            else
                                System.out.println("Invalid input.");
                            }
                            break;
                        case 4:
                            request = AlertList.getFront();
                            if(request!=null){
                            System.out.println("Request to be solve:");
                            System.out.println(request.toString()+"\n");
                            }
                            else
                                break;
                            guard = GuardList.dequeue(request.getLevel());
                            int toolUse = 0;
                            if(guard!=null){
                                if(ToolsList.displayToolsByLevel(request.getLevel())!=false){
                                do{
                                    System.out.print("Select which tool you would like to use for this request(0 if no tool is suitable) > ");
                                    toolUse = input.nextInt();
                                    if(toolUse > 0 && toolUse <= ToolsList.getCountNodes()){
                                    tool = ToolsList.deleteTools(toolUse+ToolsList.getTotalNodesBefore());
                                    AlertList.dequeue();
                                    System.out.println("\n"+tool.getName()+" has been dequeued from the list.");
                                    System.out.println(guard.getGuardName()+" has been assigned to solve this request\n");
                                    user = new User(request, guard, tool);
                                    ServedList.enqueue(user);
                                    }
                                    else if(toolUse == 0){
                                        GuardList.enqueue(guard);
                                        break;
                                    }
                                    else
                                        System.out.println("Invalid input");
                                }while(toolUse<0 || toolUse > ToolsList.getCountNodes());
                                }
                                else
                                    GuardList.enqueue(guard);
                            }
                            break;
                        case 5:
                            if(ServedList.displayServed()==true){
                                System.out.print("Select which request status you would like to mark as completed > ");
                                int servedPosition = input.nextInt();
                                if(servedPosition <= ServedList.getSize() && servedPosition > 0){
                                    user = ServedList.getServed(servedPosition);
                                    request = user.getRequest();
                                    if(request.getStatus().equals("Completed"))
                                        System.out.println("This status is already completed");
                                    else{
                                        request.setStatus("Completed");
                                        user.setRequest(request);
                                        ServedList.updateServed(servedPosition, user);
                                        System.out.println("The request has been updated!");
                                        GuardList.enqueue(user.getGuard());
                                        ToolsList.enqueue(user.getTools());
                                    }
                                }
                                else{
                                    System.out.println("Invalid Input.");
                                }
                            }
                            break;
                        case 6:
                            ServedList.displayServed();
                            break;
                        case 7:
                            AlertList.displayEntry();
                            break;

                        default:
                            System.out.println("Invalid input");
                    }
                    break;
                case 3:
                    System.out.println("====================");
                    System.out.println("  Guard Management");
                    System.out.println("====================");
                    System.out.println("Select what you want to perform.");
                    System.out.println("1. Add New Guard");
                    System.out.println("2. Update Guard");
                    System.out.println("3. Delete Guard");
                    System.out.print("4. Display Guards\n> ");
                    int choice2 = input.nextInt();
                    
                    switch(choice2){
                    case 1:
                        int confirmation = 0;

                        System.out.print("Enter the name of the new guard: ");
                        input.nextLine();
                        String newGuard = input.nextLine();
                        System.out.print("Enter the experience level of "+newGuard+": ");
                        int newExperience = input.nextInt();
                        System.out.print("Enter the guard level of "+newGuard+": ");
                        int newLevel = input.nextInt();

                        System.out.println("Are you sure you want to insert the guard?");
                        System.out.print("1. Yes\n2. No\n> ");
                        confirmation = input.nextInt();

                        if(confirmation == 1){
                            guard = new Guard(newGuard,newExperience,newLevel);

                            GuardList.enqueue(guard);
                            System.out.println(newGuard+" has been inserted into the database");
                        }
                        break;
                    
                    case 2:
                        if(GuardList.displayGuardList()==true){
                            System.out.print("Select which guard you would like to edit > ");
                            int guardPosition = input.nextInt();
                            if(guardPosition <= GuardList.getCounter() && guardPosition > 0){
                                System.out.print("Enter the name of the new guard: ");
                                input.nextLine();
                                String guardName = input.nextLine();
                                System.out.print("Enter the experience level of "+guardName+": ");
                                int guardExperience = input.nextInt();
                                System.out.print("Enter the guard level of "+guardName+": ");
                                int guardLevel = input.nextInt();
                                           
                                System.out.println("You have entered the following information :");
                                System.out.println("Guard's name\t\t\t> " + guardName);
                                System.out.println("Guard's Experience Level\t> "+guardExperience);
                                System.out.println("Level of Guard\t\t\t> " + guardLevel);
                                System.out.println("Are you confirmed you want to edit this guard?");
                                System.out.print("1. Yes\n2. No\n> ");
                                confirmation = input.nextInt();

                                if(confirmation == 1){
                                    guard = new Guard(guardName,guardExperience,guardLevel);
                                    GuardList.updateGuard(guardPosition, guard);
                                    System.out.println("The guard has been updated!");
                                }
                            }
                            else
                                System.out.println("Invalid input.");
                            }
                        break;
                        case 3:
                        if(GuardList.displayGuardList()==true){
                            System.out.print("Select which guard you would like to edit > ");
                            int guardPosition = input.nextInt();
                            
                            if(guardPosition <= GuardList.getCounter() && guardPosition > 0){
                                System.out.println("Are you sure you want to delete this guard?");
                                System.out.print("1. Yes\n2. No\n> ");
                                confirmation = input.nextInt();

                                if(confirmation == 1){
                                    GuardList.deleteGuard(guardPosition);
                                    System.out.println("The guard has been delete successfully!");
                                }
                            }
                            else
                                System.out.println("Invalid input.");
                        }             
                        break;
                    
                    case 4:
                        GuardList.displayGuardList();
                        break;
                    default:
                        System.out.println("Invalid input.");
                    }
                    break;
                default:
                    System.out.println("Invalid input.");
        }
            System.out.print("Do you want to continue with the system? Press 1 to continue > ");
            cont = input.nextInt();
        }while(cont==1);
            
        System.out.println("\nTHANK YOU FOR USIING THE SYSTEM");
        
        
        
        // TODO code application logic here
    }
    
}
