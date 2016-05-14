package de.engelhardt.pluginappfx;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ro.fortsoft.pf4j.DefaultPluginManager;
import ro.fortsoft.pf4j.PluginManager;


public class Launcer extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PluginAppFx.fxml"));
			BorderPane root = (BorderPane)loader.load();
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			// TODO: Hier könnten die Plugins geladen werden und würden sich dann z.B. im Menue einhängen
			PluginManager pluginManager = new DefaultPluginManager();
			pluginManager.loadPlugins();
			pluginManager.startPlugins(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		 launch(args);
	}
}
