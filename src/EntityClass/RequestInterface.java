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
public interface RequestInterface extends Comparable<RequestInterface>{
    public int getLevel();
    public String getIncident();
    public String getName();
    public String getDate();
    public void setLevel(int level);
    public void setIncident(String incident);
    public void setName(String name);
    public void setDate(String date);
    public void setStatus(String status);
    public String getStatus();
}
