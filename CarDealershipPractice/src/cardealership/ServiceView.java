package cardealership;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ServiceView {

    private Item service;

    public ServiceView(Item service){
        this.service = service;
    }

    public Scene serviceScene(Stage stage, Scene backScene){

        BorderPane borderpane = new BorderPane();

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 15, 15, 15));

        vbox.setPadding(new Insets(15, 15, 15, 15));
        Label description = new Label(this.service.listItem());
        Label subDescription = new Label(this.service.getDescription());
        Label title = new Label(this.service.getName());
        title.setStyle("-fx-font-size: 16;");
        vbox.getChildren().addAll(title, description, subDescription);

        HBox footer = new HBox();
        footer.setPadding(new Insets(15, 15, 15, 15));
        Button backButton = new Button("Back to main");
        backButton.setPrefSize(120, 20);
        backButton.setOnAction(e -> stage.setScene(backScene));
        footer.getChildren().add(backButton);

        //borderpane.setCenter(vbox);
        borderpane.setTop(vbox);
        borderpane.setBottom(footer);


        return new Scene(borderpane, 600, 350);
    }
}
