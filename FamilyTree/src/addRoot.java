import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.*;
import javafx.scene.control.RadioButton;

/**
 *addRoot.java - this class is used to create the add Root GUI to allow user to add a root
 * @author vicky
 */
public class addRoot extends VBox{

    /**
     * the firstname of the root person
     */
    protected TextField tf1;

    /**
     * the last name of the root person
     */
    protected TextField tf2;
    /**
     * tf3-the maiden name of the root person
     * tf4-the street number
     * tf5-the street name
     * tf6-the suburb
     * tf7-the postcode
     */
    protected TextField tf3, tf4, tf5, tf6, tf7;

    /**
     * button to select the gender of the root person
     */
    protected RadioButton male, female;

    /**
     * textarea for life description
     */
    protected TextArea textArea;

    /**
     * person object of FamilyMember
     */
    private  FamilyMember person;
    /**
     * address object of Address
     */
    protected Address address;

    /**
     * hold the radio button to select gender
     */
    protected ToggleGroup radioGroup;
    /**
     * the add root button of the add root GUI
     */
    private Button addRoot;


    /**
     * constrcutor that will build the add root GUI
     */
    public addRoot() {

        //build area to add person info
        Label personalInfo = new Label("Personal Information :");
        personalInfo.setFont(Font.font("Arial", FontWeight.BOLD, 18));

        Label firstname = new Label("Firstname");
        Label lastname = new Label("Lastname");
        Label maidenname = new Label("Maiden name ");


        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();


        Label gender = new Label("Gender");

        radioGroup = new ToggleGroup();

        //radio button
        male = new RadioButton("Male");
        female = new RadioButton("Female");

        male.setToggleGroup(radioGroup);
        female.setToggleGroup(radioGroup);

        HBox genderButton = new HBox();
        genderButton.setSpacing(10);
        genderButton.getChildren().addAll(male, female);

        Label lifeDescript = new Label("Life Description");
        textArea = new TextArea();


        //address info
        Label addressinfo = new Label("Address Information :");
        addressinfo.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        addressinfo.setPadding(new Insets(10, 0, 5, 0));
        Label streetNum = new Label("Street Number ");
        Label stname = new Label("Street Name ");
        Label suburb = new Label("Suburb ");
        Label postcode = new Label("Postcode ");

        tf4 = new TextField();
        tf5 = new TextField();
        tf6 = new TextField();
        tf7 = new TextField();

        addRoot = new Button("Add Root");
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(5);
        this.getChildren().addAll(personalInfo, firstname, tf1, lastname, tf2, maidenname, tf3, gender, genderButton, lifeDescript, textArea);
        this.getChildren().addAll(addressinfo, streetNum, tf4, stname, tf5, suburb, tf6, postcode, tf7);
        this.getChildren().add(addRoot);
    }

    /**
     * this will return the add root button
     * @return Button
     */
    public Button getaddButton(){
        return this.addRoot;
    }

    /**
     * method to get the address information from the gui
     * @return Address
     */
    Address getAddress() {
        address = new Address(tf4.getText(), tf5.getText(), tf6.getText(), tf7.getText());
        return address;
    }

    /**
     * method to get the personal information of user from GUI
     * @return FamilyMember
     */

    FamilyMember getPersonalInfo() {
        String gender;
        RadioButton selectedRadioButton =
                (RadioButton) radioGroup.getSelectedToggle();

        if (selectedRadioButton == male) {
            gender = FamilyMember.MALE;
        } else {

            gender = FamilyMember.FEMALE;
        }

        person = new FamilyMember(tf1.getText() , tf2.getText(), tf3.getText(), gender, textArea.getText());

        return person;
    }
}


