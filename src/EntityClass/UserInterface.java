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
public interface UserInterface {
    public RequestInterface getRequest();
    public GuardInterface getGuard();
    public ToolsInterface getTools();
    public void setRequest(RequestInterface request);
    public void setGuard(GuardInterface guard);
    public void setTools(ToolsInterface tools);
}
