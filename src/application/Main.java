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
		Blackjack bj = new Blackjack();
		bj.dealHand();
		for(int i = 0; i < 1000; i++) {
			bj.play();
			bj.reset();
			System.out.println("------------------Hand #" +  i + "------------------");
			bj.dealHand();
			
		}
	}
}
