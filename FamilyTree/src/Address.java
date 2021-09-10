import java.io.Serializable;

/**
 *Address.java- This is an Address class which can be use to define the address of a person
 * @author vicky
 */
public class Address implements Serializable{
    private String streetNum;
    private String streetName;
    private String suburb;
    private String postCode;

    /**
     * this is a parametrized constructor to instantiate an Address
     * @param streetNum street number
     * @param streetName street name
     * @param suburb suburb
     * @param postCode postcode
     */
    Address(String streetNum,String streetName,String suburb,String postCode){
        this.streetNum = streetNum;
        this.streetName = streetName;
        this.suburb = suburb;
        this.postCode = postCode;
    }

    /**
     * this will return the street name
     * @return String
     */
    public String getStreetName(){
        return this.streetName;
    }

    /**
     *this will return the street number
     * @return String
     */
    public  String getStreetNum(){
        return this.streetNum;
    }

    /**
     *this will return the suburb
     * @return String
     */
    public String getSuburb(){
        return this.suburb;
    }


    /**
     *this will return the postcode
     * @return String
     */
    public String getPostCode(){
        return this.postCode;
    }

    /**
     * this will set the postcode
     * @param postcode postcode
     */
    public void setPostCode(String postcode){
        this.postCode = postcode;
    }

    /**
     * this will set the street name
     * @param streetName
     */
    public void setStreetName(String streetName){
        this.streetName = streetName;
    }

    /**
     * this will set the suburb
     * @param suburb suburb
     */
    public void setSuburb(String suburb){
        this.suburb=suburb;
    }

    /**
     * this will set the street number
     * @param streetNum street number
     */
    public void setStreetNum(String streetNum){
        this.streetNum=streetNum;
    }

}



