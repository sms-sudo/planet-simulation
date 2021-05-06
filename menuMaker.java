/*
 * Salwa Abdalla - ICS4U
 * 20/01/2020 Jeff Radulovic
 * ICS Culminating
 * 
 * This is the class that creates the menu bar for the top of
 * the main application.
 * 
 */

//importing necessary imports
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class menuMaker {

	//creating main menu bar
	public MenuBar createMenuBar(Group world, worldMaker outline2) {

		//creating an instance of the application launcher to control the planet view
		applicationLauncher aL = new applicationLauncher();

		// Create MenuBar
		MenuBar menuBar = new MenuBar();

		// Create menus
		Menu fileMenu = new Menu("File");
		Menu editMenu = new Menu("View");
		Menu helpMenu = new Menu("Help");

		// Create MenuItems
		Menu openFileItem = new Menu("Open Planet");
		
		//if there is an atmosphere jpg, display when selected
		CheckMenuItem view1 = new CheckMenuItem("Atmosphere");       
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				if (((CheckMenuItem)e.getSource()).isSelected()) 
					world.getChildren().add(outline2.prepareAtmosphere("Image Resources/" + aL.getNumber() + "_" + aL.getPlanet() + "/" + aL.getPlanet() + "-c.jpg"));
				else
					world.getChildren().remove(outline2.prepareAtmosphere("Image Resources/" + aL.getNumber() + "_" + aL.getPlanet() + "/" + aL.getPlanet() + "-c.jpg"));
			} 
		}; 
		view1.setOnAction(event); 

		//if there is an illumination jpg, display when selected
		CheckMenuItem view4 = new CheckMenuItem("Illumination");     
		EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				if (((CheckMenuItem)e.getSource()).isSelected()) 
					world.getChildren().add(outline2.prepareIllumination(aL.getPlanet(), aL.getNumber()));
				else
					world.getChildren().remove(outline2.prepareIllumination(aL.getPlanet(), aL.getNumber()));
			} 
		};        
		view4.setOnAction(event3);
		
		//if there is a texture jpg, display when selected
		CheckMenuItem view5 = new CheckMenuItem("Texture");     
		EventHandler<ActionEvent> event14 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				if (((CheckMenuItem)e.getSource()).isSelected()) 
					world.getChildren().add(outline2.prepareTexture(aL.getPlanet(), aL.getNumber()));
				else
					world.getChildren().remove(outline2.prepareTexture(aL.getPlanet(), aL.getNumber()));
			} 
		};        
		view5.setOnAction(event14);

		
		//the following 10 menu items and menu item handlers are meant to display the different planets 
		
		MenuItem planet1 = new MenuItem("Sun");
		EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{
				aL.setPlanet("sun", "01");
				world.getChildren().add(outline2.prepareWorld(aL.getPlanet(), aL.getNumber()));  
			} 
		};        
		planet1.setOnAction(event4);

		MenuItem planet2 = new MenuItem("Mercury");
		EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				aL.setPlanet("mercury", "02");
				world.getChildren().clear();
				world.getChildren().add(outline2.prepareWorld(aL.getPlanet(), aL.getNumber()));
			} 
		};        
		planet2.setOnAction(event5);

		MenuItem planet3 = new MenuItem("Venus");
		EventHandler<ActionEvent> event6 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				aL.setPlanet("venus", "03");
				world.getChildren().clear();
				world.getChildren().add(outline2.prepareWorld(aL.getPlanet(), aL.getNumber()));
			} 
		};        
		planet3.setOnAction(event6);

		MenuItem planet4 = new MenuItem("Earth");
		EventHandler<ActionEvent> event7 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				aL.setPlanet("earth", "04");
				world.getChildren().clear();
				world.getChildren().add(outline2.prepareWorld(aL.getPlanet(), aL.getNumber()));
			} 
		};        
		planet4.setOnAction(event7);

		MenuItem planet5 = new MenuItem("Mars");
		EventHandler<ActionEvent> event8 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				aL.setPlanet("mars", "05");
				world.getChildren().clear();
				world.getChildren().add(outline2.prepareWorld(aL.getPlanet(), aL.getNumber()));
			} 
		};        
		planet5.setOnAction(event8);

		MenuItem planet6 = new MenuItem("Jupiter");
		EventHandler<ActionEvent> event9 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				aL.setPlanet("jupiter", "06");
				world.getChildren().clear();
				world.getChildren().add(outline2.prepareWorld(aL.getPlanet(), aL.getNumber()));
			} 
		};        
		planet6.setOnAction(event9);

		MenuItem planet7 = new MenuItem("Saturn");
		EventHandler<ActionEvent> event10 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				aL.setPlanet("saturn", "07");
				world.getChildren().clear();
				world.getChildren().add(outline2.prepareWorld(aL.getPlanet(), aL.getNumber()));
			} 
		};        
		planet7.setOnAction(event10);

		MenuItem planet8 = new MenuItem("Uranus");
		EventHandler<ActionEvent> event11 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				aL.setPlanet("uranus", "08");
				world.getChildren().clear();
				world.getChildren().add(outline2.prepareWorld(aL.getPlanet(), aL.getNumber()));
			} 
		};        
		planet8.setOnAction(event11);

		MenuItem planet9 = new MenuItem("Neptune");
		EventHandler<ActionEvent> event12 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				aL.setPlanet("neptune", "09");
				world.getChildren().clear();
				world.getChildren().add(outline2.prepareWorld(aL.getPlanet(), aL.getNumber()));
			} 
		};        
		planet9.setOnAction(event12);


		//opening the user manual in a pdf
		MenuItem usermanual = new MenuItem("UserManual");
		EventHandler<ActionEvent> event14 = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				File file = new File("src/UserManual.pdf");
				HostServices hostServices = getHostServices();
				hostServices.showDocument(file.getAbsolutePath());
			} 
		};        
		usermanual.setOnAction(event14);

		// Add menuItems to the Menus
		fileMenu.getItems().add(openFileItem);
		editMenu.getItems().addAll(view1, view4, view5);
		openFileItem.getItems().addAll(planet1, planet2, planet3, planet4, planet5, planet6, planet7, planet8, planet9);
		helpMenu.getItems().addAll(usermanual);

		// Add Menus to the MenuBar
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu);
		menuBar.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

		return menuBar;

	}

}