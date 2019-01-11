package application;
	


public class Main{
//	@Override
//	public void start(Stage primaryStage) {
//		try {
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,1000,800);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		//launch(args);
		Sleeve s = new Sleeve(8, 0.75);
		Dealer d = new Dealer();
		d.playHand(s);
	}
}
