/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClass;



/**
 *
 * @author JE
 */
public interface GuardInterface extends Comparable<GuardInterface> {
    public void setExp(int exp);
    public void setGuardName(String guardName);
    public int getExp();
    public String getGuardName();
    public int getLv();
    public void setLv(int lv);
    
}
