/*
 * Salwa Abdalla - ICS4U
 * 20/01/2020 Jeff Radulovic
 * ICS Culminating
 * 
 * This is the class that creates the actual planets that are displayed
 * in the GUI. It includes all of the additional featues such as
 * illumination, texture and atmosphere.
 * 
 */

//importing necessary imports
import javafx.animation.AnimationTimer;
import javafx.scene.Camera;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.image.Image;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;

public class worldMaker {

	//creating 4 sphere for the 4 potential sphere states
	private Sphere sphere = new Sphere(150);
	private Sphere sphere2 = new Sphere(150);
	private Sphere sphere3 = new Sphere(150);
	private Sphere sphere4 = new Sphere(150);
	
	//creating camera to allow for zoom
	private Camera camera = new PerspectiveCamera(true);

	//preparing the camera and in what range can it see the planets
	public Camera prepareCamera() {
		camera.setNearClip(0);
		camera.setFarClip(10000);
		camera.translateZProperty().set(-1000);
		return camera;
	}
	
	//returning main sphere
	public Sphere returnSphere() {
		return sphere;
	}
	
	//setting main sphere
	public void setSphere(Sphere sphere) {
		this.sphere = sphere;
	}

	//preparing animation timer for rotation animation
	public AnimationTimer prepareAnimation(double rotateDegree) {
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				//get current rotation degree and subtract the rotation speed
				sphere.rotateProperty().set(sphere.getRotate() - rotateDegree);
				sphere2.rotateProperty().set(sphere2.getRotate() - rotateDegree);
				sphere3.rotateProperty().set(sphere3.getRotate() - rotateDegree);
				sphere4.rotateProperty().set(sphere4.getRotate() - rotateDegree);
			}
		};
		timer.start();
		return timer;
	}

	//default prepare world (earth with all possible maps already rendered
	public Node prepareWorld() {
		PhongMaterial earthMaterial = new PhongMaterial();
		earthMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("Image Resources/04_earth/earth-n.jpg")));
		earthMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream("Image Resources/04_earth/earth-l.jpg")));
		earthMaterial.setBumpMap(new Image(getClass().getResourceAsStream("Image Resources/04_earth/earth-b(2).jpg")));
		
		sphere.setRotationAxis(Rotate.Y_AXIS);
		sphere.setMaterial(earthMaterial);
		return sphere;
	}
	
	//prepare for every world
	public Node prepareWorld(String starter, String number) {
		PhongMaterial worldMaterial = new PhongMaterial();
		worldMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("Image Resources/" + number + "_" + starter + "/" + starter + "-n.jpg")));
		
		sphere4.setRotationAxis(Rotate.Y_AXIS);
		sphere4.setMaterial(worldMaterial);
		return sphere4;
	}
	
	//prepare atmosphere for every planet
	public Node prepareAtmosphere(String link) {
		//make material
		PhongMaterial cloudMaterial = new PhongMaterial();		
		//set material and main material as the maps for the sphere
		cloudMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream(link)));
		//set the rotation axis and return the sphere
		sphere2.setRotationAxis(Rotate.Y_AXIS);
		sphere2.setMaterial(cloudMaterial);
		return sphere2;
	}
	
	//prepare illumination for every planet
	public Node prepareIllumination(String starter, String number) {
		//make material
		PhongMaterial worldMaterial = new PhongMaterial();
		//set material and main material as the maps for the sphere
		worldMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("Image Resources/" + number + "_" + starter + "/" + starter + "-n.jpg")));
		worldMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream("Image Resources/" + number + "_" + starter + "/" + starter + "-l.jpg")));
		
		//set the rotation axis and return the sphere
		sphere3.setRotationAxis(Rotate.Y_AXIS);
		sphere3.setMaterial(worldMaterial);
		return sphere3;
	}
	
	public Node prepareTexture(String starter, String number) {
		//make material
		PhongMaterial worldMaterial = new PhongMaterial();
		//set material and main material as the maps for the sphere
		worldMaterial.setDiffuseMap(new Image(getClass().getResourceAsStream("Image Resources/" + number + "_" + starter + "/" + starter + "-n.jpg")));
		worldMaterial.setSelfIlluminationMap(new Image(getClass().getResourceAsStream("Image Resources/" + number + "_" + starter + "/" + starter + "-b.jpg")));
		//set the rotation axis and return the sphere
		sphere4.setRotationAxis(Rotate.Y_AXIS);
		sphere4.setMaterial(worldMaterial);
		return sphere4;
	}

}
