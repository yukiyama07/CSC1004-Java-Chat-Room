package kernel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(Main.class.getResource("login.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Main.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root,572,400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}