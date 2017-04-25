import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;

/**
 * This application shows a feedback form using NESTED branches.
 * It does not handle button clicks.
 */
public class FeedbackApplication extends Application {
	public static void main(String[] args) { launch(args); }

	private Label feedbackLbl;
	private TextArea feedbackTa;
	private Button cancelBtn;
	private Button submitBtn;

	@Override
	public void start(Stage stage) throws Exception {
		// Create the leaves
		feedbackLbl = new Label("Enter feedback");
		feedbackLbl.setFont(new Font("Arial", 20));
		feedbackTa = new TextArea();
		feedbackTa.setPrefColumnCount(12);
		feedbackTa.setPrefRowCount(3);
		feedbackTa.setWrapText(true);
		cancelBtn = new Button("Cancel");
		submitBtn = new Button("Submit");

		// Create nested branches
		HBox headerBox = new HBox(feedbackLbl);
		headerBox.setAlignment(Pos.CENTER);
		HBox buttonsBox = new HBox(cancelBtn, submitBtn);
		buttonsBox.setAlignment(Pos.CENTER);
		VBox vBox = new VBox(headerBox, feedbackTa, buttonsBox);

		// Set the scene, show the stage
		stage.setScene(new Scene(vBox));
		stage.setTitle("Feedback");
		stage.show();
	}
}
