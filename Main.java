/**
 * This class contains the weka algorithms for the class
 * @Debarghya
 * @Carrie
 * @Arup
 * Date 4/28/2017
 * 
 * */






package weka;





import java.awt.Desktop;
import java.io.IOException;
import java.net.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application{
	
	Stage window1;
	Stage window2; // for the tutorial
	Stage window3; // for the developer part
	Stage window4; // for the application part
	Stage window5; // for the comparison graph
	Button logIn;
	Button next1;
	Button aboutNI; // creates a hyperlink to the wikipedia page of network intrusion in data
	Button dataLink; // creates a hyperlink to the data in the url 
	Button abtProj;  // brief description about the project
	Button appBtn;  // takes us to the application page
	Button devBtn;
	Button backBtn;
	Button compareBtn;// shows the comparison between different classifiers.
	Button applyBtn;
	Scene scene1;
	Scene scene2;
	Scene scene3;
	Scene scene4;
	Scene scene5;
	Scene scene6; // for the graph
	Label tutLbl;
	Label devLbl;
	Label appLbl;
	RadioButton removeBtn;
	RadioButton decisionBtn;
	RadioButton naiveBayesBtn;
	RadioButton knnBtn;
	double max_val =150.0;
	PasswordField text2;
	Label message;
	Label contDev1;
	Label contDev2;
	Label contDev3;
	Label contDev4;
	
	/**graph contants*/
	final static String decision="Decision Tree";
	final static String knn = "KNN Classifier";
	final static String naive= "Naive Bayes Classifier";
	
	
	
	
	public static void main(String[] args)throws Exception
	{
		launch(args); // launches the application
	}
	
	/**
	 * Starts the application
	 * @param the primaryStage for the Project
	 * 
	 * */
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void start(Stage primaryStage) throws Exception{
		
		
		/**creates the home window */
		window1 =primaryStage;
		window1.setTitle("Javafx experiment");
		
	
		/**Implementation of the graph*/
		window5 = new Stage();
		window5.setTitle("Sample Comparison");
		window5.initModality(Modality.APPLICATION_MODAL);
		final CategoryAxis xAxis= new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		
		
		final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
		bc.setTitle("Comparison Summary");
		xAxis.setLabel("Classifiers");
		yAxis.setLabel("Values in percentage");
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("ROC");
		series1.getData().add(new XYChart.Data(knn, 0.999));
		series1.getData().add(new XYChart.Data(naive, 0.999));
		series1.getData().add(new XYChart.Data(decision, 0.999));
		
		
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Mean Absolute Error");
		series2.getData().add(new XYChart.Data(knn, 2.420));
		series2.getData().add(new XYChart.Data(naive, 6.000));
		series2.getData().add(new XYChart.Data(decision, 5.999));
		
		XYChart.Series series3 = new XYChart.Series();
		series3.setName("Root Mean Squared Error");
		series3.getData().add(new XYChart.Data(knn, 4.420));
		series3.getData().add(new XYChart.Data(naive, 10.523));
		series3.getData().add(new XYChart.Data(decision, 7.428));
		
		
		
		
		scene6 = new Scene(bc,800,600);
		bc.getData().addAll(series1,series2,series3);
		window5.setScene(scene6);
		/**Implementation of the graph complete */
		
		
		/** The pane for the first home page */
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(50,20,20,20));
		pane.setVgap(8);
		pane.setHgap(10);
		//pane.setId("pane");
		
		
		//pane2.getChildren().addAll();
		
		
		FlowPane pane3 = new FlowPane();
		pane3.setPadding(new Insets(20,20,20,20));
		pane3.setVgap(8);
		pane3.setHgap(10);
		
		
		
		// the tutorial label 
		tutLbl = new Label("    Welcome to the Tutorial    ");
		tutLbl.setStyle("-fx-text-fill:#e8e8e8");
		tutLbl.setId("fancytext1");
	
		
		
		
		/**Create a separate Window for the developers */
		GridPane pane4 = new GridPane();
		pane4.setPadding(new Insets(20,20,20,20));
		pane4.setVgap(8);
		pane4.setHgap(10);
		
		
		// the developer label
		devLbl = new Label("Developers");
		devLbl.setStyle("-fx-text-fill:#e8e8e8");
		devLbl.setId("fancytext1");
		GridPane.setConstraints(devLbl,1,0);
		
		
		
		contDev1 = new Label(" Three ambitious grad students making a desperate attempt to nail a Datamining Project."
				+ "\n\nCarrie Carlton: Most dedicated individual in our group and a talented Mandolin player \n \n Arup Mondal: Amazing cook and god of debugging \n\n Debarghya Nandi: Just another coder!\n");
		contDev1.setStyle("-fx-text-fill:#e8e8e8");
		contDev1.setId("fancytext1");
		GridPane.setConstraints(contDev1,1,3);
		
/*		contDev2 = new Label("Carrie Carlton: Most dedicated individual in our group and a talented Mandolin player "); 
		contDev2.setId("fancytext1");
		GridPane.setConstraints(contDev2,1,5);
		
		contDev3 = new Label("Arup Mondal: Amazing cook and god of debugging"); 
		contDev3.setId("fancytext1");
		GridPane.setConstraints(contDev3,1,7);
		
		contDev4 = new Label("Debarghya Nandi : Just another coder !!");
		contDev4.setStyle("-fx-text-fill:#e8e8e8");
		contDev4.setId("fancytext1");
		GridPane.setConstraints(contDev4,1,9);
		
		
	*/	
		
		
		
		// Label for the home page
		
		Label label0 = new Label("Data Intrusion");
		label0.setStyle("-fx-text-fill:#e8e8e8");
		label0.setId("fancytext");
		GridPane.setConstraints(label0,1,0);
		
		
		
		// create a  label
		Label label1 = new Label("Username:");
		label1.setStyle("-fx-text-fill:#e8e8e8");
		GridPane.setConstraints(label1,0,2);

		
		// name input
		TextField text1 = new TextField();
		GridPane.setConstraints(text1,1,2);
		
		
		// create a password label
		Label label2 = new Label("Password:");
		label2.setStyle("-fx-text-fill:#e8e8e8");
		GridPane.setConstraints(label2,0,3);
		
		
		// create a text field for the password
		text2= new PasswordField();
		text2.setPromptText("Password");
		GridPane.setConstraints(text2,1,3);
		
		
		message = new Label("");
		GridPane.setConstraints(message,1,3);
		
		
		Image imageOk = new Image(getClass().getResourceAsStream("ok.png"));
		ImageView imageView = new ImageView(imageOk);
		imageView.setFitHeight(50);
		imageView.setFitWidth(70);
		logIn = new Button("LOG IN",imageView);
		logIn.setOnAction(e-> {
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
	
	//	logIn.setMaxSize(50,80);
		GridPane.setConstraints(logIn,1,5);
		

		
		pane.getChildren().addAll(label0,label1,text1,label2,text2,logIn,message);
		
		
		/**For the second window *Options* */
		GridPane pane2 = new GridPane();
		pane2.setPadding(new Insets(35,20,20,20));
		pane2.setVgap(8);
		pane2.setHgap(10);
		//pane2.setId("pane");
	
		
		aboutNI= new Button("About Network Intrusion"); // belongs to the second pop up window
		aboutNI.setOnAction(e-> {
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		aboutNI.setMaxWidth(max_val);
		GridPane.setConstraints(aboutNI,7,1);
		
		dataLink = new Button(" DataSet ");
		dataLink.setOnAction(e-> {
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		dataLink.setMaxWidth(max_val);
		GridPane.setConstraints(dataLink,7,2);
		
		
		abtProj = new Button("Tutorial");
		abtProj.setOnAction(e->{
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		abtProj.setMaxWidth(max_val);
		GridPane.setConstraints(abtProj,7,3);
		
		
		appBtn = new Button("Application");
	 	appBtn.setOnAction(e->{
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		appBtn.setMaxWidth(max_val);
		GridPane.setConstraints(appBtn,7,4);
		
		
		devBtn = new Button("Developers");
		devBtn.setOnAction(e->{
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		devBtn.setMaxWidth(max_val);
		GridPane.setConstraints(devBtn,7,5);
		
		
		backBtn = new Button("Back");
		backBtn.setOnAction(e->{
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		backBtn.setMaxWidth(max_val);
		GridPane.setConstraints(backBtn,7,6);
		
		
		GridPane pane5 = new GridPane();
		pane5.setPadding(new Insets(10,10,10,10));
		pane5.setHgap(10);
		pane5.setVgap(8);
		

		
		
		
		appLbl = new Label("Welcome to the Application");
		appLbl.setStyle("-fx-text-fill:#e8e8e8");
		GridPane.setConstraints(appLbl,0,0);

		/**Adding the radio buttons for the application page */
		
		
		
		//VBox radButtons = new VBox();
		
		final ToggleGroup group = new ToggleGroup();
		
		
		/**to remove a specific attribute/instance */
		removeBtn = new RadioButton(" Remove");
		removeBtn.setId("fancytext1");
	//	removeBtn.setS
		removeBtn.setToggleGroup(group);
		removeBtn.setSelected(true);
		removeBtn.setOnAction(e->{
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		GridPane.setConstraints(removeBtn,0,4);
		/**to discretize a given parameter */
		RadioButton discretizeBtn = new RadioButton(" Discretize");
		//discretizeBtn.setStyle("-fx-text-fill:#e8e8e8");
		discretizeBtn.setId("fancytext1");
		discretizeBtn.setToggleGroup(group);
		discretizeBtn.setSelected(true);
		GridPane.setConstraints(discretizeBtn,2,4);
		
		// to use the naive bayes classifier
		naiveBayesBtn = new RadioButton(" Naive Bayes");
	//	naiveBayesBtn.setStyle("-fx-text-fill:#e8e8e8");
		naiveBayesBtn.setId("fancytext1");
		naiveBayesBtn.setToggleGroup(group);
		naiveBayesBtn.setSelected(true);
		naiveBayesBtn.setOnAction(e->{
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		GridPane.setConstraints(naiveBayesBtn,0,8);
		
		// to use the decision tree classifier
		decisionBtn = new RadioButton(" Decision Tree");
	//	decisionBtn.setStyle("-fx-text-fill:#e8e8e8");
		decisionBtn.setId("fancytext1");
		decisionBtn.setSelected(true);
		decisionBtn.setToggleGroup(group);
		decisionBtn.setOnAction(e->{
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		GridPane.setConstraints(decisionBtn,2,8);
		
		
		// to use the KNN classifier 
		
		knnBtn = new RadioButton(" KNN Classifier");
		//knnBtn.setStyle("-fx-text-fill:#e8e8e8");
		knnBtn.setId("fancytext1");
		
		knnBtn.setSelected(true);
		knnBtn.setToggleGroup(group);
		knnBtn.setOnAction(e->{
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		GridPane.setConstraints(knnBtn,0,12);	
		
		
		// this button applies the following classifiers to the data
		applyBtn = new Button("Exit");
		applyBtn.setOnAction(e->{
			try {
				ButtonClicked(e);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		applyBtn.setMaxWidth(max_val);
		GridPane.setConstraints(applyBtn,2,16);
		
		
		
		
		
		// this buttons creates a comparison between the different classifiers
		compareBtn = new Button("Compare");
		compareBtn.setOnAction(e->{
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		compareBtn.setMaxWidth(max_val);
		GridPane.setConstraints(compareBtn,0,16);
		
		
		
		
		pane2.getChildren().addAll(aboutNI,dataLink,abtProj,appBtn,devBtn,backBtn);
		pane3.getChildren().addAll(tutLbl);
		pane4.getChildren().addAll(devLbl,contDev1);
		pane5.getChildren().addAll(appLbl,removeBtn,discretizeBtn,naiveBayesBtn,decisionBtn,knnBtn,applyBtn,compareBtn);
		
		

		scene1 = new Scene(pane,350,300);
		scene2 = new Scene(pane2,350,300);
		scene3 = new Scene(pane3,350,300);
		scene4 = new Scene(pane4,350,300);
		scene5 = new Scene(pane5,350,300);
		
		
		scene1.getStylesheets().add("styling.css");
		scene2.getStylesheets().add("styling.css");
		scene3.getStylesheets().add("styling.css");
		scene4.getStylesheets().add("styling.css");
		scene5.getStylesheets().add("styling.css");
		
		
	    window2=new Stage();
		window2.setScene(scene3);
		window2.initModality(Modality.APPLICATION_MODAL);
	    window2.setTitle("Tutorial");
	    
	    
	    window3 = new Stage();
	    window3.setScene(scene4);
	    window3.initModality(Modality.APPLICATION_MODAL);
	    window3.setTitle("Developers");
	    
	    window4 = new Stage();
	    window4.setScene(scene5);
	    window4.initModality(Modality.APPLICATION_MODAL);
	    window4.setTitle("Application");
	    
	    
	    
	    
	    
		window1.setScene(scene1);
		window1.show();
		
}	
	
	
	/**
	 * The Action->Controller for the given class
	 * @param the ActionEvent Instance
	 * 
	 * */
	
	public void ButtonClicked(ActionEvent e) throws Exception
	{
		loadData ld = new loadData(); // Creates an object of the loadData Instance 
		
		
		if(e.getSource()==logIn)
		{
			if(text2.getText() != null && text2.getText().equals("cap5771"))
					window1.setScene(scene2);
			else{ 
				text2.setText("");
				message.setText("Incorrect Password!");
			}
		}
		else if(e.getSource()==dataLink)
		{
			Desktop d1= Desktop.getDesktop();
			try {
				d1.browse(new URI("http://kdd.ics.uci.edu/databases/kddcup99/kddcup99.html"));
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		//	window3.showAndWait();
		}
		else if(e.getSource()==aboutNI)
		{
			Desktop d = Desktop.getDesktop();
			try {
				d.browse(new URI("https://en.wikipedia.org/wiki/Intrusion_detection_system"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==backBtn)
		{
			window1.setScene(scene1);
		}
		else if(e.getSource()==abtProj)
		{
			window2.showAndWait();
		}
		else if(e.getSource()==devBtn)
		{
			window3.showAndWait();
		}
		else if(e.getSource()==appBtn)
		{
			window4.showAndWait();
		}
		else if(e.getSource()==removeBtn)
		{
			//loadData ld = new loadData();
			ld.remove();
		}
		else if(e.getSource()==decisionBtn)
		{
		//	loadData ld = new loadData();
			ld.decision();
		}
		else if(e.getSource()==naiveBayesBtn)
		{
		//	loadData ld = new loadData();
			ld.naiveBayes();
		}
		else if(e.getSource()==knnBtn)
		{
		//	loadData ld = new loadData();
			ld.knnCl();
		}
		else if(e.getSource()==compareBtn)
		{
			window5.showAndWait();
		}
		else if(e.getSource()==applyBtn)
		{
		
			window4.close();
			window1.close();
			window2.close();
			window3.close();
			
		}
		else
		{
			window3.close();
		}
	}
	
	
}