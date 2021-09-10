import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.*;

/**
 * displayInfo.java -this class is used to build the displayinfo GUI which will be used to display the information about person
 * @author vicky
 */

public class displayInfo extends VBox {

    /**
     * textfield to hold the firstname of the person
     */
    protected TextField fname;
    /**
     * textfield to hold the last name of the person
     */
    protected TextField lname;

    /**
     * textfields to hold the maiden name ,gender , address information and relative information
     */
    protected TextField mName, gend, stnum, stname, suburb, post, mother, father, spouse,child;;

    /**
     * textarea to hold the life description of a person
     */
    protected TextArea lifedes;

    /**
     * person of type FamilyMember
     */
    protected FamilyMember person;

    /**
     * address object of type Address
     */
    protected Address address;

    /**
     * button for edit details ,add relatives and save
     */
    private Button editDetails, addRel ,save;

    /**
     * constructor to build the displayInfo GUI
     */

    displayInfo() {
        Label personalInfo = new Label("Personal Information :");
        personalInfo.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        Label firstname = new Label("Firstname");
        Label lastname = new Label("Lastname");
        Label maidenname = new Label("Maiden name ");
        Label gender = new Label("Gender");


        fname = new TextField();
        lname = new TextField();

        mName = new TextField();
        gend = new TextField();

        Label lifeDescript = new Label("Life Description");
        lifedes = new TextArea();


        fname.setEditable(false);
        lname.setEditable(false);
        mName.setEditable(false);
        gend.setEditable(false);
        lifedes.setEditable(false);
        //address info
        Label addressinfo = new Label("Address Information :");
        addressinfo.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        addressinfo.setPadding(new Insets(10, 0, 5, 0));
        Label streetNum = new Label("Street Number ");
        Label streetname = new Label("Street Name ");
        Label sub = new Label("Suburb ");
        Label postcode = new Label("Postcode ");

        stnum = new TextField();
        stname = new TextField();
        suburb = new TextField();
        post = new TextField();

        stnum.setEditable(false);
        stname.setEditable(false);
        suburb.setEditable(false);
        post.setEditable(false);

        Label fath = new Label("Father");
        Label moth = new Label("Mother");
        Label spous = new Label("Spouse");
        Label childs = new Label("Children");

        father = new TextField();
        mother = new TextField();
        spouse = new TextField();
        child = new TextField();


        father.setEditable(false);
        mother.setEditable(false);
        spouse.setEditable(false);
        child.setEditable(false);


        editDetails = new Button("EditDetails");
        addRel = new Button("AddRelatives");
        save = new Button("save");
        save.setVisible(false);


        HBox holdButton = new HBox();
        holdButton.setSpacing(5);
        holdButton.getChildren().add(editDetails);
        holdButton.getChildren().add(addRel);
        holdButton.getChildren().add(save);


        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(5);
        this.getChildren().addAll(personalInfo, firstname, fname, lastname, lname, maidenname, mName, gender, gend, lifeDescript, lifedes);
        this.getChildren().addAll(addressinfo, streetNum, stnum, streetname, stname, sub, suburb, postcode, post);
        this.getChildren().addAll(fath, father, moth, mother, spous, spouse, childs, child);
        this.getChildren().add(holdButton);

    }

    /**
     * get method that will read the address infromation from the text fields
     * @return Address
     */
    Address getAddress() {
        address = new Address(stnum.getText(), stname.getText(), suburb.getText(), post.getText());
        return address;
    }

    /**
     * get method that will read the personal information from the textfields
     * @return FamilyMember
     */

    FamilyMember getPersonalInfo() {
        person = new FamilyMember(fname.getText(), lname.getText(), mName.getText(), gend.getText(), lifedes.getText());

        return person;
    }

    /**
     * method to get the save button
     * @return Button
     */

    public Button getSave(){
        return this.save;
    }

    /**
     * method to get the edit details button
     * @return Button
     */

    public Button getEditDetails() {
        return this.editDetails;
    }

    /**
     * method to get the add relative button
     * @return Button
     */
    public Button getAddRel() {
        return this.addRel;
    }

    /**
     * get method to get the firstname text field
     * @return TextField
     */

    public TextField getFname() {
        return this.fname;
    }


    /**
     * this will return the textfield of lastname
     * @return TextField
     */
    public TextField getLname() {
        return this.lname;
    }

    /**
     *this will return the maiden name textfield
     * @return TextField
     */

    public TextField getmName() {
        return this.mName;
    }


    /**
     *this will return the gender textfield
     * @return TextField
     */
    public TextField getGend() {
        return this.gend;
    }

    /**
     *this will return the life description text area
     * @return TextArea
     */

    public TextArea getLifedes() {
        return this.lifedes;
    }

    /**
     *this will return the street number textField
     * @return TextField
     */
    public TextField getStnum() {
        return this.stnum;
    }


    /**
     *this will return the street name textfield
     * @return TextField
     */
    public TextField getStname() {
        return this.stname;
    }

    /**
     *this will return the suburb textfield
     * @return TextField
     */

    public TextField getSuburb() {
        return this.suburb;
    }

    /**
     *this will return the postcode textfield
     * @return TextField
     */
    public TextField getPost() {
        return this.post;
    }
    /**
     *this will return the father textfield
     * @return TextField
     */

    public TextField getFather() {
        return this.father;
    }

    /**
     *this will return the mother textfield
     * @return TextField
     */
    public TextField getMother() {
        return this.mother;
    }

    /**
     *this will return the spouse textfield
     * @return TextField
     */
    public TextField getSpouse() {
        return this.spouse;
    }

    /**
     *this will return the children textfield
     * @return TextField
     */
    public TextField getChild() {
        return this.child;
    }
}





