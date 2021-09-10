import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * addRelative.java -this class is used to build the add new relative GUI .
 * it inherits from the addRoot class as both have almost same characteristics(components)
 * and other methods
 * @author vicky
 */


public class addRelative extends addRoot {

    /**
     * combo box to which will hold the different relative type
     */
    private ComboBox<String> relativeType;

    /**
     * add button of the GUI
     */
    private Button add;

    /**
     * chooseType label
     */
    private  Label chooseType;

    /**
     * this method will create a VBox which will hold all the textfields and nodes for the
     * add relative GUI
     * @return VBox
     */

    public VBox addRelative(){

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

        chooseType = new Label("Choose Relative Type");
        chooseType.setFont(Font.font("Arial", FontWeight.BOLD, 18));
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

        relativeType = new ComboBox<>();
        relativeType.getItems().addAll("Parent","Spouse","Children");
        add = new Button("Add");

        VBox addrel = new VBox();
        addrel.setPadding(new Insets(10, 10, 10, 10));
        addrel.setSpacing(5);

        addrel.getChildren().addAll(chooseType,relativeType);
        addrel.getChildren().addAll(personalInfo, firstname, tf1, lastname, tf2, maidenname, tf3, gender, genderButton, lifeDescript, textArea);
        addrel.getChildren().addAll(addressinfo, streetNum, tf4, stname, tf5, suburb, tf6, postcode, tf7);
        addrel.getChildren().add(add);
       return  addrel;
    }

    /**
     * this method will get the add button
     * @return Button
     */
    public Button getaddButton(){
        return this.add;
    }

    /**
     * this method will return the relative type selected using the combo box
     * @return String
     */

    public String getRelationType(){
        return this.relativeType.getSelectionModel().getSelectedItem().toString();
    }

}
