package laucher;

import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;

//import fxml.controller.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class WebCamAppLauncher extends Application {

	private Stage myPrimaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		
		myPrimaryStage = primaryStage;
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("/fxml/gui/WebCamPreview.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
        Scene scene = new Scene(root, 900, 690);
    
        primaryStage.setTitle("WebCam Capture Sarxos API using JavaFx with FXML ");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	
	//New method 
	public void saveOnDisk(BufferedImage image){
		FileChooser fileChooser = new FileChooser();
		  
	    //Set extension filter
	    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", ".png");
	    fileChooser.getExtensionFilters().add(extFilter);
	    
	    //Show save file dialog
	    File file = fileChooser.showSaveDialog(myPrimaryStage);
	    
	    if(file != null){
	        saveImage(image, file);
	    }
	}
	    
	    private void saveImage(BufferedImage image, File file){
	        try {
	            ImageIO.write(image, "png", file);
	            
	        } catch (IOException ex) {
	        	ex.printStackTrace();
	        }
	         
	    }   
	
}
