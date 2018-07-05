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
public class Request implements RequestInterface{
    private int level;
    private String incident;
    private String name;
    private String date;
    private String status;

 
    public Request(){}
    
    public Request(int level, String incident, String name, String date, String status){
        this.level = level;
        this.incident = incident;
        this.name = name;
        this.date = date;
        this.status = status;
    }

    public void setLevel(int level) {
        this.level = level;
    }

       public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public void setIncident(String incident) {
        this.incident = incident;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
    
    public int getLevel() {
        return level;
    }

    public String getIncident() {
        return incident;
    }

    public String getName() {
        return name;
    }

  
    @Override
    public int compareTo(RequestInterface request) {
        return Integer.toString(getLevel()).compareTo(Integer.toString(request.getLevel()));
    }
    
    public String toString(){
        return "Level\t\t> "+level+"\nIncident\t> "+incident+"\nStaff Name\t> "+name+"\nDate\t\t> "+date+"\nStatus\t\t> "+status;
    }
}
