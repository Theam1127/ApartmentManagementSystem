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
public class Guard implements GuardInterface{
    
    private int exp;
    private String guardName;
    private int lv;
    
    public Guard(){
        
    }
    public Guard(String guardName,int exp,int lv){
        this.guardName = guardName;
        this.exp = exp;
        this.lv = lv;
    }
    
    @Override
    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public void setGuardName(String guardName) {
        this.guardName = guardName;
    }

    @Override
    public int getExp() {
        return exp;
    }

    @Override
    public String getGuardName() {
        return guardName;
    }

    @Override
    public int compareTo(GuardInterface t) {
        return Integer.compare(exp, t.getExp());
    }

    @Override
    public int getLv() {
        return lv;
    }

    @Override
    public void setLv(int lv) {
        this.lv = lv;
    }
    
}
