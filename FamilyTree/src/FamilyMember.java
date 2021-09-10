
import java.io.Serializable;
import java.util.ArrayList;
/**
 * FamilyMember.java -This a class which will be used to create the root person and its immediate relatives
 * @author vicky
 */

public class FamilyMember implements Serializable {
    public static String MALE = "Male";
    public static String FEMALE = "Female";
    public static int MAX_PARENTS = 2;


    private String firstname; ///firstname of the familymember
    private String lastname; ///lastname of the familymember
    private String fullName; //fullname of the familymember
    private String maidenName; ///maiden name of the familymember
    private Address address ; ///address of the familymember
    private String gender ; ///gender of the person
    private String lifeDescription; ///life description of the person
    private FamilyMember[] parents = new FamilyMember[MAX_PARENTS]; ///array of parent with a max size of 2
    private ArrayList<FamilyMember> children = new ArrayList<FamilyMember>(); ///arraylist of children
    private FamilyMember spouse = null; ///spouse of the perosn

    /**
     * This is the default constructor
     */

    FamilyMember(){};

    /***
     *This is the parametrized constructor to instantiate a new FamilyMember object
     * @param firstname the firstname of the person
     * @param lastname the lastname of the person
     * @param maidenName the after marriage name of the person
     * @param gender the gender of the person
     * @param lifeDescription the life description of the person
     */

    FamilyMember(String firstname ,String lastname, String maidenName, String gender, String lifeDescription){
        this.firstname = firstname ;
        this.lastname = lastname;
        this.maidenName = maidenName;
        this.gender = gender;
        this.lifeDescription= lifeDescription;
    }


    /**
     * this is a get method that will return the full name of the family member
     * @return -String
     */
    public String getFullName(){
        return this.fullName;
    }

    /***
     * This is a get method that will return the first name of the person
     * @return -String
     */

    public String getFirstname(){
        return  this.firstname;

    }


    /***
     * This is a get method that will return the lastname of the person
     * @return - String
     */

    public String getLastname(){
        return this.lastname;
    }

    /**
     * this will return the after marriage name (maidenname)
     * @return -String
     */
    public String getMaidenName(){
        return this.maidenName;
    }

    /**
     * this will return the gender of the person
     * @return -String
     */
    public String getGender(){
        return this.gender;
    }

    /**
     * this will return the life description of the person
     * @return -String
     */
    public String getDescription(){
        return this.lifeDescription;
    }

    /**
     * this will return the address of the person
     * @return -Address
     */

    public Address getAddress(){
        return this.address;
    }

    /**
     * this will return the person based on the index in the array
     * @param index the positon of the parent inside array
     * @return -FamilyMember
     */
    public FamilyMember getParents(int index) {
        return this.parents[index];
    }

    /**
     * this will return the child at index i of the arraylist
     * @param index position of child inside arraylist
     * @return -FamilyMember
     */
    public FamilyMember getChild(int index) {
        return  this.children.get(index);
    }

    /**
     * this will return the spouse of the person
     * @return -FamilyMember
     */
    public FamilyMember getSpouse(){
        return  this.spouse;
    }

    /**
     * this will return the list of children of a person
     * @return -ArrayList<FamilyMember>
     */
    public ArrayList<FamilyMember> getChild(){
        return  this.children;
    }

    /**
     * this will return the array of parents
     * @return - FamilyMember[]
     */

    public FamilyMember[] getParents(){
        return this.parents;
    }

    /**
     * this will set the fullname of the person
     * @param firstname firstname of the person
     * @param lastname lastname of the person
     */

    public void setFullName(String  firstname ,String lastname){
        this.fullName = firstname + " "+lastname;
    }

    /**
     * this will set the firstname of the person
     * @param firstname firstname of the person
     */
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    /**
     * this will set the lastname of the person
     * @param lastname lastname of the person
     */

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    /**
     * this will set the maidename of the person
     * @param maidenName afer marriage name of the person
     */

    public void setMaidenName(String maidenName){
        this.maidenName = maidenName;
    }

    /**
     * this will set the description of the person
     * @param description lifedescription
     */

    public void setDescription(String description){
        this.lifeDescription = description;
    }

    /**
     * this will set the gender of the person
     * @param gender gender of the person
     */

    public void setGender(String gender){
        this.gender = gender;
    }

    /**
     * this will set the full address of the person
     * @param streetNum street number
     * @param streetName street name
     * @param suburb   suburb
     * @param postCode postcode
     */

    public void setAddress(String streetNum,String streetName,String suburb,String postCode){
        this.address = new Address(streetNum,streetName,suburb,postCode);
    }

    /**
     * this will set the address of the person
     * @param addr full address
     */
    public  void setAddress(Address addr){
        this.address = addr;
    }

    /**
     * this will add/set the spouse of a person
     * @param spouse spouse of the person
     */
    public void addSpouse(FamilyMember spouse){
        this.spouse=spouse;
    }

    /**
     * this will add parents to the array
     * @param parent parent of a person
     */

    public void addParent(FamilyMember parent){
        for(int i = 0;i< MAX_PARENTS;i++){
            if(parents[i] == null){
                parents[i]=parent;
                break;
            }

        }
    }

    /**
     * this will add a child to the array list
     * @param child a children of a person
     */
    public void addChild(FamilyMember child){
        children.add(child);
    }

    /**
     * this is an overriden method of the toString() which is used to display the name of the tree
     * @return -String
     */
    @Override
    public String toString() {

        return this.firstname;
    }
}


