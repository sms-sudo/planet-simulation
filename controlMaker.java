/*
 * Salwa Abdalla - ICS4U
 * 20/01/2020 Jeff Radulovic
 * ICS Culminating
 * 
 * This is the class that creates the slider for planet control
 * to be used when switching the earths that are being shown
 * 
 */

//importing necessary imports
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

public class controlMaker {

	//creating a default slider
	//all settings were tested with various backgrounds
	//these setting look best with current images
	public Slider createSlider() {
		int max = 550;
		int min = -550;
		int minW = 500;
		int prefW = 100;
		int layX = 150;
		int layY = 200;
		int translate = 5;
		String style = "-fx-base: black";		
		Slider slider = new Slider();
		slider.setMax(max);
		slider.setMin(min);
		slider.setMinWidth(minW);
		slider.setPrefWidth(prefW);
		slider.setLayoutX(layX);
		slider.setLayoutY(layY);
		slider.setShowTickLabels(true);
		slider.setTranslateZ(translate);
		slider.setStyle(style);
		slider.isShowTickLabels();
		return slider;
	}

	//creating a customizable slider (polymorphism)
	public Slider createSlider(int max, int min, int pw, int lx, int ly, int translate, String style) {
		Slider slider = new Slider();
		slider.setMax(max);
		slider.setMin(min);
		slider.setPrefWidth(pw);
		slider.setLayoutX(lx);
		slider.setLayoutY(ly);
		slider.setShowTickLabels(true);
		slider.setTranslateZ(translate);
		slider.setStyle(style);
		return slider;
	}

	//creating a button with specific sizes for controls
	public Button createButton(String text) {
		int[] size = {75, 25};
		Button button = new Button();
		button.setMinSize(size[0], size[1]);
		button.setText(text);

		return button;
	}

}