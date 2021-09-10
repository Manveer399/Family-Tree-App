import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.nio.file.Paths;

/***
 * mainGUI.java class .this class is used to build the initial GUI and contain all the methods to handle the events.
 * @author vicky
 */

public class mainGUI extends VBox {

    /**
     *treeview layout of type familyMember to display the tree of the family
     */
    protected TreeView<FamilyMember>familyTree = new TreeView<>();
    /**
     * the root person of the family
     */
    protected FamilyMember rootperson;

    /**
     * hold the person value selected by user on the tree
     */
    protected FamilyMember selected;

    /**
     * HBox to hold the title of the application
     */
    protected HBox title;

    /**
     *the sets of button b1-Load b2-save b3-create new b4-add root person
     */
    protected Button b1,b2,b3,b4;

    /**
     * HBox to hold the the load,save and create new button
     */
    protected HBox holdButton;

    /**
     * VBOx layout-to hold the treeView , addRoot-hold the add root person button and a label
     */
    protected VBox layout ,addRoot;
    /**
     * object of type displayInfo which will be used to build the GUI to display the information of a person
     */
    protected displayInfo displayData;

    /**
     * Labels of the main GUI LabelAddRoot-hold the label (load or add new root person)
     * labelSelect-hold the label (select item to view info)
     */
    protected Label labelAddRoot , labelSelect;

    /**
     * hold the item which the user clicked on which will be used to display information
     */
    protected static TreeItem<FamilyMember> item;

    /**
     * the main pane that will hold all the nodes of the mainGui
     */
    protected BorderPane pane;

    /**
     * the pane that will hold the displayInfo GUI
     */
    protected BorderPane detailspane;


    /**
     * the constructor which will take in a parameter of type Stage
     * this will be used to create the mainGUI of the application
     * @param pstage the primary stage of the application
     */


  public mainGUI(Stage pstage) {


        // create a label
        Label label = new Label("Welcome To The Family Tree Application");
        label.setFont(Font.font("Cambria", 20.0));


        BackgroundFill background_fill = new BackgroundFill(Color.rgb(153, 230, 255),
                CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);

        //hbox for label
        title = new HBox();
        title.getChildren().add(label);
        title.setAlignment(Pos.BASELINE_CENTER);
        title.setBackground(background);


        //load tree button
        b1 = new Button("Load Tree");
       b1.setOnAction(e->loadFamily(pstage));

        //save tree button
        b2 = new Button("Save Tree");
        b2.setOnAction(e->{
            saveTree(pstage);
        });
        //Create tree button
        b3 = new Button("Create New Tree");
      b3.setOnAction(e->{
          handleCreateNewTree();
      });

        //add root person button
        b4 = new Button("Add root person");

        b4.setOnAction(e->{
            CreatRoot();
        });

        holdButton = new HBox();//box to load button
        holdButton.getChildren().addAll(b1, b2, b3);
        holdButton.setSpacing(30.0);
        holdButton.setAlignment(Pos.BASELINE_CENTER);
        familyTree.setPrefHeight(10000);



        layout = new VBox();
        layout.setPrefWidth(300);
        layout.getChildren().add(familyTree);




        //scene 1
        //label for adding root
        labelAddRoot = new Label("Load a tree or add a new root person");
        labelAddRoot.setFont(Font.font("Cambria", FontWeight.BOLD,15.0));

        labelSelect = new Label("Select items to view details");
        labelSelect.setFont(Font.font("Cambria", FontWeight.BOLD,20.0));
        labelSelect.setPadding(new Insets(5,0,0,5));

        labelSelect.setVisible(false);

        addRoot = new VBox();
        VBox.setMargin(b4, new Insets(10, 0, 10, 10));

        addRoot.getChildren().add(labelSelect);
        addRoot.getChildren().add(b4);
        VBox.setMargin(labelAddRoot, new Insets(0, 0, 0, 10));
        addRoot.getChildren().add(labelAddRoot);






        VBox mainBox = new VBox();
        //mainBox.getChildren().add(menuBar);
        mainBox.getChildren().add(title);
        mainBox.setMargin(title, new Insets(0, 0, 5, 0));

        mainBox.getChildren().add(holdButton);
        mainBox.setMargin(holdButton, new Insets(0, 0, 5, 0));


        detailspane = new BorderPane();
        detailspane.setLeft(addRoot);
        detailspane.autosize();

        pane = new BorderPane();
        pane.autosize();
        pane.setTop(mainBox);
        pane.setLeft(layout);

        ScrollPane scrollable = new ScrollPane();
        scrollable.setContent(detailspane);
        pane.setCenter(scrollable);


        Scene scene1 = new Scene(pane);
        pstage.setHeight(800);
        pstage.setWidth(800);
        pstage.setScene(scene1);
        pstage.setTitle("Family Tree App");
        pstage.show();

    }

    /**
     * this method will be used to create the add root  GUI and will call the methods required to add the root
     *it will call the method handleAddRoot() method to create and add the root when the user enters the information and
     * click on the add button of the Add root GUI
     * the handleSelectItem() method is called here to enable selection of items on the tree
     */

    public void CreatRoot(){

        addRoot addrootscene = new addRoot();
        VBox addroot = addrootscene;

        Scene newScene = new Scene(addroot,500,800);
        Stage stage = new Stage();
        stage.setScene(newScene);
        stage.setTitle("Create a new root");
        stage.show();
        addrootscene.getaddButton().setOnAction(e->{
           handleAddRoot(addrootscene,stage);
        });

        handleSelectTreeItem();
    }

    /**
     * this method will handle the events when user click on the add button of the Add root GUI
     * this method will get the information enter by the user and set the Personal and address information of the root person
     * it create the root item and add the root to the familyTree
     * the method buildFamilyTree() is called to build the tree
     * @param rootScene the add root scene which will display the gui
     * @param stage the stage that holds the add root gui
     */
    public void handleAddRoot(addRoot rootScene ,Stage stage){

        rootperson = rootScene.getPersonalInfo();
        rootperson.setAddress(rootScene.getAddress());

        TreeItem <FamilyMember> root;
        root = new TreeItem<>(rootperson);
        familyTree.setShowRoot(true);

        familyTree.setRoot(root);


        buildFamilyTree(rootperson,root);

        stage.close();
        b4.setVisible(false);
        labelAddRoot.setVisible(false);
        labelSelect.setVisible(true);
    }

    /**
     * this methods handle the event when user click on a person of the tree
     * if e.getClickCount is greater or equals to one means user click on an item
     * if count is greater of equals to one ,the displayData() method is called to display
     * the information of the item selected
     */

    public void handleSelectTreeItem(){

        familyTree.setOnMouseClicked(e->{
            if(e.getClickCount()>=1){
                item= familyTree.getSelectionModel().getSelectedItem();
                displayData(item);
            }
        });
    }

    /**
     * this method is used to build the display info GUI and display the information of a selected item
     * on the tree.
     *the edit details button will call the editDetails() method which will handle the event of editing a person details
     *the add relatives button will call the addRelatives() method which will handle the event of adding a relative to a person
     * @throws  NullPointerException
     * @throws  ClassNotFoundException
     * @param newValue item selected by user
     */

    public void displayData(TreeItem<FamilyMember>newValue){
        try {

            TreeItem<FamilyMember> person = (TreeItem<FamilyMember>) newValue;
            selected= person.getValue();
            displayData = new displayInfo();
            displayData.getFname().setText(person.getValue().getFirstname());
            displayData.getLname().setText(person.getValue().getLastname());
            displayData.getmName().setText(person.getValue().getMaidenName());
            displayData.getFname().setText(person.getValue().getFirstname());
            displayData.getGend().setText(person.getValue().getGender());
            displayData.getLifedes().setText(person.getValue().getDescription());
            displayData.getStnum().setText(person.getValue().getAddress().getStreetNum());
            displayData.getStname().setText(person.getValue().getAddress().getStreetName());
            displayData.getSuburb().setText(person.getValue().getAddress().getSuburb());
            displayData.getPost().setText(person.getValue().getAddress().getPostCode());
            displayData.getChild().setText(person.getValue().getChild().toString().replace("[", "").replace("]", ""));

            if (person.getValue().getSpouse() != null) {
                displayData.getSpouse().setText(person.getValue().getSpouse().toString());

            }

            for (int i = 0; i < FamilyMember.MAX_PARENTS; i++) {
                if (person.getValue().getParents(i) != null) {
                    if (person.getValue().getParents(i).getGender().equals(FamilyMember.MALE)) {
                        displayData.getFather().setText(person.getValue().getParents(i).toString()+","+displayData.getFather().getText());
                    } else {
                        displayData.getMother().setText(person.getValue().getParents(i).toString()+","+displayData.getMother().getText());
                    }
                }
            }
            VBox v = displayData;

            displayData.getAddRel().setOnAction(e -> {
                addRelatives();
            });

            displayData.getEditDetails().setOnAction(e -> {
               editDetails(selected);
            });
            detailspane.setLeft(v);
        }
        catch (ClassCastException e){


        }

        catch (NullPointerException e){

        }
    }

    /**
     *this method is a recursive function which will build the family tree of a person
     * @param famRoot root of the tree
     * @param treeRoot root item that hold the root of the tree
     * @return TreeItem<FamilyMember>
     */

  TreeItem<FamilyMember> buildFamilyTree(FamilyMember famRoot, TreeItem<FamilyMember> treeRoot) {
         treeRoot.setExpanded(true);
        TreeItem parents, spouse, childs;

        if (famRoot != null) {
            //parents
            parents = new TreeItem("Parents:");
            treeRoot.getChildren().add(parents);
            parents.setExpanded(true);

            for (int i = 0; i < FamilyMember.MAX_PARENTS; i++) {
                if (famRoot.getParents(i) != null) {
                    TreeItem<FamilyMember> p = new TreeItem<FamilyMember>(famRoot.getParents(i));
                    parents.getChildren().add(p);
                }
            }

            //spouse
            spouse = new TreeItem("Spouse:");
            treeRoot.getChildren().add(spouse);
            spouse.setExpanded(true);
            if (famRoot.getSpouse() != null) {
                TreeItem<FamilyMember> s = new TreeItem<FamilyMember>(famRoot.getSpouse());
                spouse.getChildren().add(s);
            }

            //children
            childs = new TreeItem("Children:");
            treeRoot.getChildren().add(childs);
            childs.setExpanded(true);
            if (!famRoot.getChild().isEmpty()) {
                for (FamilyMember c : famRoot.getChild()) {
                    TreeItem<FamilyMember> children = new TreeItem<FamilyMember>(c);
                    childs.getChildren().add(children);

                    //System.out.println(c.getFirstname());
                    children = buildFamilyTree(c,children);
                }
            }
        }
        return treeRoot;
    }

    /**
     * this method is used to create the add relatives GUI and will handle the event when user
     * click the add button .
     * The add Button will call the handleAddRelatives() method which will handle the event of adding the
     * relative to the tree
     *
     */
    public void addRelatives(){
        addRelative addRel = new addRelative();
        VBox createRel = addRel.addRelative();

        ScrollPane sroll = new ScrollPane();
        sroll.setContent(createRel);

        Scene newScene = new Scene(sroll,500,800);
        Stage stage = new Stage();
        stage.setScene(newScene);
        stage.setTitle("Add new relatives");
        stage.show();
        addRel.getaddButton().setOnAction(e->{
          handleAddRelatives(addRel,stage);
        });
    }


    /**
     * this method will check which type of relatives is being added and add the new relative to the tree.
     * @param addRel the add relative GUI
     * @param stage the stage that holds the add relative GUI
     */
    public void handleAddRelatives( addRelative addRel,Stage stage){

        FamilyMember newMember = addRel.getPersonalInfo();
        newMember.setAddress(addRel.getAddress());

        if (addRel.getRelationType() .equals( "Parent") ){



            if(selected.getParents(0)!=null && selected.getParents(1)!=null){
                Alert a = new Alert(AlertType.INFORMATION);
                a.setContentText("You already have 2 parents added!"+"\n"+"Please select a parent from the tree and edit the information to the new parent you want to add");
                a.show();
            }
            else{
                newMember.addChild(selected);
                selected.addParent(newMember);
            }

        }

        if (addRel.getRelationType() .equals( "Spouse") ){

            if(selected.getSpouse()!=null){
                Alert a = new Alert(AlertType.INFORMATION);
                a.setContentText("You already have a spouse added!"+"\n"+"Please select the existing spouse from the tree and edit the information to the new spouse you want to add");
                a.show();
            }
            else {
                newMember.addSpouse(selected);
                selected.addSpouse(newMember);
            }
        }

        if (addRel.getRelationType().equals("Children")){
            newMember.addParent(selected);
            selected.addChild(newMember);
        }

        for( FamilyMember c : selected.getChild()){
            c.addParent(selected.getSpouse());
        }

        TreeItem<FamilyMember> tempRoot = familyTree.getRoot();

        tempRoot.getChildren().clear();
        buildFamilyTree(rootperson,familyTree.getRoot());

        displayData(item);
        stage.close();
    }

    /**
     * this method is used to edit enable user to edit details of a selected button when
     * the user click on the edit details Button .The save button will appear.
     * the save button will handle the event to save the edited details by calling the method handleSaveNewDetails()
     * @param personSelected the FamilyMember selected
     */

    public void editDetails(FamilyMember personSelected){

        displayData.getSave().setVisible(true);
        displayData.getStnum().setEditable(true);
        displayData.getStname().setEditable(true);
        displayData.getSuburb().setEditable(true);
        displayData.getPost().setEditable(true);

        displayData.getFname().setEditable(true);
        displayData.getLname().setEditable(true);
        displayData.getmName().setEditable(true);
        displayData.getGend().setEditable(true);
        displayData.getLifedes().setEditable(true);

        displayData.getSave().setOnAction(e->{
            handleSaveNewDetails(personSelected);
        });
    }

    /**
     * this method will handle the event when user want to save the edited details
     * @param selected familyMember selected by user
     */
    public void handleSaveNewDetails(FamilyMember selected){
        selected.setFirstname(displayData.getFname().getText());
        selected.setLastname(displayData.getLname().getText());
        selected.setMaidenName(displayData.getmName().getText());
        selected.setGender(displayData.getGend().getText());
        selected.setDescription(displayData.getLifedes().getText());
        selected.setAddress(displayData.getAddress());

        displayData(item);
        familyTree.refresh();
    }

    /**
     * this method will act like a reset button to allow user start a new tree
     * this method is called when user click on create new tree
     * This will reset the GUI back to the initial state
     */
    public void handleCreateNewTree(){
        familyTree.setRoot(null);
        labelSelect.setVisible(false);
        b4.setVisible(true);
        labelAddRoot.setVisible(true);
        detailspane.getChildren().clear();
        detailspane.setLeft(addRoot);
    }

    /**
     * this method is used to create the file chooser and handle the event of loading a family tree from
     * selected file and build the familyTree .the method loadTree() is called to read the data from the file and
     * then the buildFamilyTree() method is called to build the tree of the person loaded.This method
     * is called when user click on load button.The file chooser will only filter .txt files
     * @param tempstage will hold the primary stage parameter
     */

    public void loadFamily(Stage tempstage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load family tree file");
        String currentPath = Paths.get("./familytree").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));
        File selectedFile = fileChooser.showOpenDialog(tempstage);

        if( selectedFile!= null)
        {
            handleCreateNewTree();
            rootperson = loadTree(selectedFile);
            familyTree.refresh();
            TreeItem<FamilyMember>root;
            root = new TreeItem<FamilyMember>(rootperson);
            root.setExpanded(true);

            familyTree.setRoot(root);
            buildFamilyTree(rootperson,root);
            b4.setVisible(false);
            labelAddRoot.setVisible(false);
            labelSelect.setVisible(true);
        }
        handleSelectTreeItem();
    }

    /**
     * this method is used to read the file selected.if file is empty it will alert the user file is empty
     * @param fileselected file selected by user from file chooser
     * @throws Exception
     * @return root -the root person read from the file
     */

    FamilyMember  loadTree(File fileselected){
        FamilyMember root = new FamilyMember();
        try {

            FileInputStream fileIn = new FileInputStream(fileselected);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            root =(FamilyMember)  objectIn.readObject();
            objectIn.close();
            return root;

        } catch (Exception ex) {
            ex.printStackTrace();
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("File is empty.Please select a different file!!!");
            a.show();
            return null;
        }

    }

    /**
     * this method will create  file chooser and handle the event of saving a tree to a file selected
     * the method saveFamily() is called to use to write the family tree to the file selected.
     * This method is called when user click on the save button
     * @param tempstage primary stage
     */

    public void saveTree(Stage tempstage){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save family tree file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        String currentPath = Paths.get("./familytree").toAbsolutePath().normalize().toString();
        fileChooser.setInitialDirectory(new File(currentPath));

        File fileselected = fileChooser.showOpenDialog(tempstage);

        if(fileselected !=null){
            saveFamily(fileselected);
        }
    }

    /**
     * this method will write to the file selected and save it
     * @throws IOException
     * @param selectedFolder file selected by user
     */
    void saveFamily(File selectedFolder)
    {
        try {

            FileOutputStream fileOut = new FileOutputStream(selectedFolder);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            FamilyMember root = familyTree.getRoot().getValue();

            if(root!= null)
            {
                objectOut.writeObject(root);
            }
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setContentText("File saved successfully!!");
            a.show();
            objectOut.close();

        } catch (IOException ex) {
            ex.printStackTrace();

            Alert a = new Alert(AlertType.ERROR);
            // set content text
            a.setContentText("File not save!!!");
            // show the dialog
            a.show();
        }
    }



}
