import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Mr Jack Pocket");
        //primaryStage.setScene(new Scene(root, 1800, 900));
        //primaryStage.show();

        Scene Mainscene = new Scene(root, 1800,900);
        Mainscene.getStylesheets().add(getClass().getResource("CSSButtom.css").toString());

        primaryStage.setScene(Mainscene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
