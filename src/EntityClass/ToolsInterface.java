package EntityClass;

public interface ToolsInterface extends Comparable<ToolsInterface>{
    public String getName();
    public int getEmergencyLevel();
    public void setName(String TName);
    public void setEmergencyLevel(int EmergencyLevel);
}
