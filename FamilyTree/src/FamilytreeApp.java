import javafx.application.Application;
import javafx.stage.Stage;

/**
 * FamilyTreeApp.java -The main class that will run the application
 * @author vicky
 */
public class FamilytreeApp extends Application {

    mainGUI primaryScene;
     @Override
    public void start(Stage primaryStage) {
         primaryScene = new mainGUI(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
