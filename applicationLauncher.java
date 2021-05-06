/*
 * Salwa Abdalla - ICS4U
 * 20/01/2020 Jeff Radulovic
 * ICS Culminating
 * 
 * This the main GUI class and where it launches from.
 * It is meant to create the application layout and incorporate the 
 * other various classes to complete my learning tool
 * 
 */

//importing necessary imports
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//inheriting from Application (javafx)
public class applicationLauncher extends Application {

	//creating default sizes, speeds and settings
	private int[][]dimensions =  {{800, 800},{1400,800}};
	private double rotateSpeed = 0.2;
	private AnimationTimer timer;
	private MyArrayList<String> planets;
	private String planet = "earth";
	private String number = "04";

	//MAIN LAUNCHER
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	//getter for rotation speed
	public double getRotateSpeed() {
		return rotateSpeed;
	}
	
	//getter for animation timer
	public AnimationTimer getTimer() {
		return timer;
	}
	
	//setter for animation timer
	public void setTimer(AnimationTimer timer) {
		this.timer = timer;
	}
	
	//setter for planet and identification number
	public void setPlanet(String planet, String number) {
		this.planet = planet;
		this.number = number;
	}
	
	//getter for planet
	public String getPlanet() {
		return this.planet;
	}
	
	//getter for planet identification number
	public String getNumber() {
		return this.number;
	}

	//creating main stage for javafx GUI
	@Override
	public void start(Stage stage) throws Exception {
		
		//setting up launch page & background
		Label label = new Label("Press any Key to Launch");
		stage.setTitle("ICS Culminating 2020");
		stage.getIcons().add(new Image("Image Resources/earthicon.png"));
		
		//creating directional label
		label.setBackground(new Background(new BackgroundImage(new Image("Image Resources/background_milkyway.jpg"), null, null, null, null)));
		label.setMinSize(dimensions[1][0], dimensions[1][1]);
		label.setAlignment(Pos.CENTER);
		label.setTextFill(Color.WHITE);

		//creating group to display label & background
		Group root = new Group();
		root.getChildren().add(label);
		Scene intro = new Scene(root, dimensions[1][0], dimensions[1][1]);
		
		//displaying
		stage.setScene(intro);
		//creating scene (main application !menu)				
		Scene mainScene = new Scene(createMainApplication(stage, planets), dimensions[1][0], dimensions[1][1]);		
		
		//event handler when pressing anywhere to start
		intro.setOnMousePressed(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	            stage.setScene(mainScene);
	        }
	    });
		
		//event handler when pressing any key to start
		intro.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
            public void handle(final KeyEvent keyEvent) {
            	stage.setScene(mainScene);
            }
        });
		
		stage.show();
		
	}

	//creating borderpane for main application
	public BorderPane createMainApplication(Stage stage, MyArrayList<String> planets) {

		BorderPane borderPane = new BorderPane();

		//creating border outline
		BorderPane root = new BorderPane();
		root.setCache(true);

		//creating planet
		Group world = new Group();
		worldMaker outline2 = new worldMaker();
		world.getChildren().add(outline2.prepareWorld("earth", "04"));
		
		//setting camera up for zoom control
		SubScene subScene = new SubScene(world, dimensions[0][0], dimensions[0][1]-200, false, null);
		Camera camera = outline2.prepareCamera();
		subScene.setCamera(camera);
		root.setCenter(subScene); 
		
		//setting up slider to zoom in and out of the planet
		controlMaker outline3 = new controlMaker();
		Slider slider = outline3.createSlider();
		world.translateZProperty().bind(slider.valueProperty());
		root.setBottom(slider);
		slider.setPadding(new Insets(25));

		//setting the background to stars
		root.setBackground(new Background(new BackgroundImage(new Image("Image Resources/background_milkyway.jpg"), null, null, null, null)));

		//creating menu
		menuMaker outline = new menuMaker();
		MenuBar menuBar = outline.createMenuBar(world, outline2);

		//creating timer for animation
        timer = outline2.prepareAnimation(rotateSpeed);

		//making Stop/Start button
		Button buttonPlay = outline3.createButton("PLAY");
		Button buttonPause = outline3.createButton("PAUSE");

		//play button handler (starting)
		buttonPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle (ActionEvent e) {
				rotateSpeed = 0.2;
				timer.start();
			}
		});

		//pause button handler (stopping)
		buttonPause.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle (ActionEvent e) {
				rotateSpeed = 0;
				timer.stop();
			}
		});

		//creating buttons to speed up and slow down 
		Button speedUp = outline3.createButton("Speed Up");
        Button slowDown = outline3.createButton("Slow Down");
        
        //speed up handler - increasing rotation speed
        speedUp.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle (ActionEvent e) {
        		rotateSpeed += 0.2;
        		timer.stop();
        		timer = outline2.prepareAnimation(rotateSpeed);
        		
        	}
        });
        
        //slow down handler - slowing down until zero - no reversing direction
        slowDown.setOnAction(new EventHandler<ActionEvent>() {
        	@Override public void handle (ActionEvent e) {
        		if (rotateSpeed != 0)
        			rotateSpeed -= 0.2;
        		timer.stop();
        		timer = outline2.prepareAnimation(rotateSpeed);
        	}
        });

        //creating toolbar for top of screen
		ToolBar toolbar = new ToolBar(buttonPlay, buttonPause, speedUp, slowDown);

		//adding menu and toolbar to the same top
		VBox vbox = new VBox();
		vbox.getChildren().addAll(menuBar, toolbar);

		//creating tab to hold information about planets
		TabPane tabPaneLeft = new TabPane();
		Tab tab1 = new Tab("Project List");
		tab1.setContent(createTreeView());
		tabPaneLeft.getTabs().add(tab1);

		//setting up where sections are displayed in borderpane
		borderPane.setTop(vbox);
		borderPane.setLeft(tabPaneLeft);
		borderPane.setCenter(root);

		//returning borderpane
		return borderPane;
	}

	//creating treeview for info tab on side
	public TreeView<String> createTreeView() {
		//reading information from file
		fileReader fR = new fileReader();
		planets = fR.loadPlanets();
		TreeItem<String> rootTreeItem = new TreeItem<>("Information");
		
		//creating list of planet and information, appending to list
		for (int i = 0; i < this.planets.size(); i++) {
			TreeItem<String> ti = new TreeItem<>(String.valueOf(planets.getNode(i)));
			String filename = "src/Info Resources/" + String.valueOf(planets.getNode(i)).toLowerCase() + ".txt";
			rootTreeItem.getChildren().add(ti);
			TreeItem<String> childTreeItem = new TreeItem<>(fR.loadInformation(filename));
			ti.getChildren().add(childTreeItem);
			
		}
		
		//inputing the tree information
		TreeView<String> tv = new TreeView<String>(rootTreeItem);
		tv.setMinWidth(400);
		
		//returning tree view
		return tv;
	}
}