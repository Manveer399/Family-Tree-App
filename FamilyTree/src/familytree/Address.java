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
final public class Address implements Serializable{
    private int streetNum;
    private String streetName;
    private String suburb;
    private long postCode;
    
    /**
     *
     * @return
     */
    Address(int streetNum,String streetName,String suburb,int postCode){
      this.streetNum = streetNum;
      this.streetName = streetName;
      this.suburb = suburb;
      this.postCode = postCode;
    } 
    /**
     *
     * @return
     */
    public String getStreetName(){
        return this.streetName;
    }
    
     /**
     *
     * @return
     */
    public  int getStreetNum(){
        return this.streetNum;
    }
    
     /**
     *
     * @return
     */
     public String getSuburb(){
        return this.suburb;
     }
     
     
      /**
     *
     * @return
     */
     public long getPostCode(){
         return this.postCode;
     }
     
      /**
     *
     * 
     */
     public void setPostCode(long postcode){
         this.postCode = postcode;
     }
     
      /**
     *
     * 
     */
     public void setStreetName(String streetName){
         this.streetName = streetName;
     }
      /**
     *
     * 
     */
     public void setSuburb(String suburb){
         this.suburb=suburb;
     }
     
      /**
     *
     * 
     */
     public void setStreetNum(int streetNum){
         this.streetNum=streetNum;
     }
     
}


