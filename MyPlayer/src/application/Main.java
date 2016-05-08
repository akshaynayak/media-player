package application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	
	
	Player player;
	FileChooser fileChooser;
	
	public void start(final Stage primaryStage) {
		
		
		MenuItem open=new MenuItem("Open");
		Menu file=new Menu("File");
		MenuBar menu=new MenuBar();
		

		file.getItems().add(open);
		menu.getMenus().add(file);
		
		fileChooser=new FileChooser();
		open.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				player.player.pause();
				File file=fileChooser.showOpenDialog(primaryStage);
				if(file!=null){
					try {
						player=new Player(file.toURI().toURL().toExternalForm());
						Scene scene=new Scene(player,720,447,Color.BLACK);
						primaryStage.setScene(scene);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		
		
		player=new Player("file:///E:/Game.of.Thrones.S05E01.HDTV.x264-Xclusive.mp4");
		player.setTop(menu);
		Scene scene=new Scene(player,720,447,Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
