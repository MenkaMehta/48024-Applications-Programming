import javafx.application.*;
import javafx.fxml.*;
import javafx.stage.*;
import javafx.scene.*;
import java.io.*;
import java.lang.reflect.*;
import javafx.beans.property.*;

public abstract class Controller<M> {
	public static <T> void showStage(T model, String fxml, String title, Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(Controller.class.getResource(fxml), null, null,
				type -> {
					try {
						Controller<T> controller = (Controller<T>)type.newInstance();
						controller.model = model;
						controller.stage = stage;
						return controller;
					} catch (Exception e) { throw new RuntimeException(e); }
				});
		Parent root = loader.load();
		stage.setTitle(title);
		stage.setScene(new Scene(root));
		stage.sizeToScene();
		stage.show();
	}

	private M model;
	private Stage stage;

	public final M getModel() { return model; }
	protected Stage getStage() { return stage; }
}
