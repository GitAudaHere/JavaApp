import javafx.application.Application;
import javafx.geometry.Insets;
// import javafx.scene.control.ChoiceBox;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene scene, scene2;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("My First App");

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        /* 
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        */

        BorderPane layout = new BorderPane();

        // Name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        // Name input
        TextField nameInput = new TextField(); // Parameter can be default text. eg. last login
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput, 1, 0);

        // Name label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        // Name input
        TextField passInput = new TextField();
        passInput.setPromptText("Password"); // Like HTML input placeholder
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Log in");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> {
            isInt(nameInput, nameInput.getText());
        });

        // Scene change button
        Button changeScene = new Button("Change Scene1");
        GridPane.setConstraints(changeScene, 1, 3);
        changeScene.setOnAction(e -> {
            window.setScene(scene2);
        });

        Button changeScene2 = new Button("Change Scene");
        changeScene2.setOnAction(e -> {
            window.setScene(scene);
        });

        // Menus
        Menu fileMenu = new Menu("_File");

        MenuItem file_newFile = new MenuItem("_New File");
        MenuItem file_newWindow = new MenuItem("New _Window");
        MenuItem file_openFile = new MenuItem("_Open File");
        MenuItem file_openFolder = new MenuItem("Open _Folder");
        MenuItem file_openWorkspace = new MenuItem("Open Wor_kspace");
        MenuItem file_openRecent = new MenuItem("Open _Recent");

        fileMenu.getItems().addAll(file_newFile, file_newWindow, new SeparatorMenuItem(), file_openFile, file_openFolder, file_openWorkspace, file_openRecent);

        Menu editMenu = new Menu("_Edit");

        MenuItem edit_undo = new MenuItem("_Undo");
        MenuItem edit_redo = new MenuItem("_Redo");
        MenuItem edit_cut = new MenuItem("Cu_t");
        MenuItem edit_copy = new MenuItem("_Copy");
        MenuItem edit_paste = new MenuItem("_Paste");
        MenuItem edit_find = new MenuItem("_Find");
        MenuItem edit_replace = new MenuItem("_Replace");
        MenuItem edit_findInFiles = new MenuItem("Find _in Files");
        MenuItem edit_replaceInFiles = new MenuItem("Replace _in Files");

        editMenu.getItems().addAll(edit_undo, edit_redo, new SeparatorMenuItem(), edit_cut, edit_copy, edit_paste, new SeparatorMenuItem(), edit_find, edit_replace, new SeparatorMenuItem(), edit_findInFiles, edit_replaceInFiles);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu);

        layout.setTop(menuBar);


        // Dropdown list
        // ChoiceBox<String> choiceBox = new ChoiceBox<>();

        // getItems return the ObservableList object which you can add items to
        /* choiceBox.getItems().addAll("New File", "New Window", "Open File");
        choiceBox.setValue("New File"); */

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, changeScene);
        layout.getChildren().addAll(changeScene2/* , choiceBox */);

        scene = new Scene(grid, 600, 400);
        scene2 = new Scene(layout, 600, 400);

        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Confirm", "Are you sure you want to leave?");
        if (answer) {
            window.close();
        }
    }

    private boolean isInt(TextField input, String str) {
        try {
            int num = Integer.parseInt(str);
            System.out.println("User is " + num);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: " + str + " is not a number");
            return false;
        }
    }

}
