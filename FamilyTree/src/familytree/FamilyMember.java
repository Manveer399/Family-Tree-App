/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree;
import java.io.Serializable;
/**
 * 
 * @author vicky
 */
public class FamilyMember implements Serializable {
    private String name;
    private String maidenName;
    private Address address;
    private String gender;
    private String lifeDescription;
    
    
    /**
 *
 * 
 */
 
    FamilyMember(String name,String maidenName,String gender,String lifeDescription,int streetNum,String streetName,String suburb,int postCode){
        this.name = name;
        this.maidenName = maidenName;
        this.gender = gender;
        this.lifeDescription= lifeDescription;
        this.address = new Address(streetNum,streetName,suburb,postCode);
    }
    
    /**
 *
 * 
 */
    public String getName(){
        return this.name;
    }
    
    /**
 *
 * 
 */
    public String getMaidenName(){
        return this.maidenName;
    }
    public String getGender(){
        return this.gender;
    }
      /**
 *
 * 
 */
    public String getDescription(){
        return this.lifeDescription;
    }
      /**
 *
 * 
 */
    
    public Address getAddress(){
        return this.address;
    }
    
      /**
 *
 * 
 */
    
    public void setName(String  name){
        this.name = name;
    }
    
      /**
 *
 * 
 */
    
    public void setMaidenName(String maidenName){
        this.maidenName = maidenName;
    }
    
      /**
 *
 * 
 */
    
    public void setDescription(String description){
        this.lifeDescription = description;
    }
    
      /**
 *
 * 
 */
    
    public void setGender(String gender){
        this.gender = gender;
    }
}

