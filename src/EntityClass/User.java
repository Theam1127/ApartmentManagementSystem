/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClass;

/**
 *
 * @author Yeap Theam
 */
public class User implements UserInterface {
    RequestInterface request = new Request();
    GuardInterface guard = new Guard();
    ToolsInterface tools = new Tools();
    
    public User(){}
    
    public User(UserInterface user){
        this.request = user.getRequest();
        this.guard = user.getGuard();
        this.tools = user.getTools();
    }
    
    public User(RequestInterface request, GuardInterface guard, ToolsInterface tools){
        this.request = request;
        this.guard = guard;
        this.tools = tools;
    }
    
   
    public RequestInterface getRequest() {
        return request;
    }

    
    public GuardInterface getGuard() {
        return guard;
    }

    
    public ToolsInterface getTools() {
        return tools;
    }
    
    public void setRequest(RequestInterface request) {
        this.request = request;
    }

    
    public void setGuard(GuardInterface guard) {
        this.guard = guard;
    }

    
    public void setTools(ToolsInterface tools) {
        this.tools = tools;
    }

    @Override
    public String toString() {
        return "Emergency Level\t> "+request.getLevel()+"\nIncident\t> "+request.getIncident()+"\nStaff Name\t> "+request.getName()+
                "\nDate\t\t> "+request.getDate()+"\nStatus\t\t> "+request.getStatus()+"\nGuard in charge\t> "+guard.getGuardName()+"\nTool used\t> "+tools.getName()+"\n";
    }
    
    
}
