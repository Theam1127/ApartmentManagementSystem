package EntityClass;


public class Tools<T> implements ToolsInterface {
    
    private String TName;
    private int EmergencyLevel;
        
    public Tools(){
    
    }
    
    public Tools(ToolsInterface tools){
        this.EmergencyLevel = tools.getEmergencyLevel();
        this.TName = tools.getName();
    }
    
    public Tools(String TName, int EmergencyLevel){
        this.TName = TName;
        this.EmergencyLevel = EmergencyLevel;
    }
    
    public String getName(){
        return TName;
    }
    
    public int getEmergencyLevel(){
        return EmergencyLevel;
    }
    
    public void setName(String TName){
        this.TName = TName;
    }
    
    public void setEmergencyLevel(int EmergencyLevel){
        this.EmergencyLevel = EmergencyLevel;
    }
    
    @Override
    public String toString() {
        return "Tools Name\t\t> " + TName + "\nCondition Level\t\t> " + EmergencyLevel;
    }
    
    @Override
    public int compareTo(ToolsInterface tools) {
        return Integer.toString(getEmergencyLevel()).compareTo(Integer.toString(tools.getEmergencyLevel()));
    }
}
