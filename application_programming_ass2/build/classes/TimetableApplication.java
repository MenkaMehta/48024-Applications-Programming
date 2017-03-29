
import au.edu.uts.ap.javafx.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.*;

public class TimetableApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ViewLoader.showStage(new University(), "/view/university.fxml", "University", stage);

        /* try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/university.fxml"));
            Parent root = loader.load();
            stage.setTitle("university");
            stage.setScene(new Scene(root));
            stage.sizeToScene();
            stage.show();
            // Add code here to load the root node from the FXML file
            // and show it
        } catch (Exception ex) {
            Logger.getLogger(TimetableApplication.class.getName()).log(Level.SEVERE,null, ex);
       }*/
    }
}
