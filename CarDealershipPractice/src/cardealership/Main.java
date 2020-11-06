package cardealership;

import cardealership.car.*;
import cardealership.part.*;
import cardealership.service.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Scene mainScene, carScene, serviceScene, partScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Car Dealership");

        //Main scene code
        Label mainTitle = new Label("Welcome to the very snazzy car dealership!");
        mainTitle.setStyle("-fx-font-size: 20pt;");
        Label subTitle = new Label("We sell very real cars and our prices always make sense.");
        subTitle.setStyle("-fx-font-size: 14pt;");
        HBox buttonMainHBox = new HBox();
        buttonMainHBox.setPadding(new Insets(10, 10, 10, 10));
        VBox mainVBox = new VBox();
        mainVBox.setPadding(new Insets(10, 10, 10, 10));

        Button viewCars = new Button("View our cars");
        viewCars.setPrefSize(180, 20);
        viewCars.setOnAction(e -> window.setScene(carScene));
        Button viewServices = new Button("View our services");
        viewServices.setPrefSize(180, 20);
        viewServices.setOnAction(e -> window.setScene(serviceScene));
        Button viewParts = new Button("View our parts for sale");
        viewParts.setPrefSize(180, 20);
        viewParts.setOnAction(e -> window.setScene(partScene));
        buttonMainHBox.getChildren().addAll(viewCars, viewParts, viewServices);

        mainVBox.getChildren().addAll(mainTitle, subTitle, buttonMainHBox);
        mainScene = new Scene(mainVBox, 600, 350);

        window.setScene(mainScene);
        window.show();

        //Car scene
        Car[] cars = {new Batmobile(), new Delorean(true), new Delorean(false), new FlyingFordAnglia(), new MysteryMachine()};
        ItemListLayout carList = new ItemListLayout(cars, new Label("Cars for sale:"));
        carScene = carList.createScene(window, mainScene);

        //Part scene
        Part[] parts = {new Battery(), new DashboardHulaDancer(), new Lights(), new Oil(), new Tires()};
        ItemListLayout partList = new ItemListLayout(parts, new Label("Parts we sell:"));
        partScene = partList.createScene(window, mainScene);

        //Services scene
        Service[] services = {new BasicCheckup(), new BrakeService(), new OilChange(), new PremiumCheckup()};
        ItemListLayout serviceList = new ItemListLayout(services, new Label("Services we provide:"));
        serviceScene = serviceList.createScene(window, mainScene);
    }

}
