package cardealership;

import cardealership.service.Service;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ItemListLayout {

    private Item[] items;
    private Label header;

    public ItemListLayout(Item[] items, Label header) {
        this.items = items;
        this.header = header;
        header.setStyle("-fx-font-size: 20pt;");
    }

    public Scene createScene(Stage stage, Scene backToMain){

        BorderPane borderpane = new BorderPane();
        borderpane.setPadding(new Insets(10, 10, 10, 10));

        HBox topHBox = new HBox();
        topHBox.getChildren().add(this.header);
        topHBox.setPadding(new Insets(10, 10, 10, 10));

        VBox listVBox = new VBox();
        listVBox.setPadding(new Insets(15, 15, 15, 15));


        for (Item item : items) {
            Label itemDescription = new Label(item.listItem());
            itemDescription.setId("header");
            listVBox.getChildren().add(itemDescription);
            if(item instanceof Service){
                Button seeMore = new Button("View this Service");
                seeMore.setPrefSize(150, 20);
                listVBox.getChildren().add(seeMore);
                ServiceView serviceView = new ServiceView(item);
                Scene serviceViewScene = serviceView.serviceScene(stage, backToMain);
                seeMore.setOnAction(e -> stage.setScene(serviceViewScene));
            }
        }
        VBox bottomVBox = new VBox();
        bottomVBox.setPadding(new Insets(15, 15, 15, 15));
        Button backButton = new Button("Back to main");
        backButton.setPrefSize(180, 20);
        backButton.setOnAction(e -> stage.setScene(backToMain));
        bottomVBox.getChildren().add(backButton);

        borderpane.setCenter(listVBox);
        borderpane.setTop(topHBox);
        borderpane.setBottom(bottomVBox);

        return new Scene(borderpane, 600, 350);
    }



}
