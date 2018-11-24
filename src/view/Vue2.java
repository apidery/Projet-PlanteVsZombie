package view;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Casque;
import model.EnsCase;
import model.Environnement;
import model.Jeu;
import model.Mouton;
import model.Noix;
import model.Patate;
import model.ZombiePerchiste;
import model.Perso;
import model.PersoMobile;
import model.PistoPois;
import model.PistoPoisClassic;
import model.PistoSnowPea;
import model.Plante;
import model.Pois;
import model.Projectile;
import model.Soleil;
import model.StrategiePerche;
import model.Tournesol;
import model.ZombieCasque;
import model.ZombieDeBase;
import model.ZombieMagicien;
import model.ZombiePogo;

import java.io.File;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;

public class Vue2 extends Application {
	private Jeu jeu;
	private Environnement environnement;
	private Label texteGain = new Label();
	private Plante planteSelectionnee;
	private ImageView IVTournesol;
	private ImageView IVPistoPois;
	private ImageView IVNoix;
	private ImageView IVPatate;
	private ImageView IVPistoGlace;
	private boolean clicok=false;
	private Scene theScene;

	@Override
	public void init() throws Exception {
		jeu = new Jeu(900,6);
		jeu.initialisation();
		texteGain.textProperty().bind(jeu.getCagnote().asString());
	}

    @Override
    public void start(Stage theStage) {
        theStage.setTitle( "Plants VS Zombies" );
    	environnement = jeu.getEnvironnement();

    	Font police = new Font("police1", 30);

    	BorderPane root1 = new BorderPane();
        Group root = new Group();
        theScene = new Scene( root1 );
        String Smap = new File("src/images/map.jpg").toURI().toString();
        Image Imap = new Image(Smap);
        ImageView IVmap = new ImageView(Imap);
        IVmap.setFitHeight(600);
        IVmap.setFitWidth(900);
        theStage.setScene( theScene );
    	Label texte = new Label("cagnotte totale : ");
    	texteGain.setTranslateX(830);
    	texte.setTranslateX(590);
    	texteGain.setTextFill(Color.WHITE);
    	texte.setTextFill(Color.WHITE);
    	texteGain.setFont(police);
    	texte.setFont(police);



        root.getChildren().addAll(IVmap,texte,texteGain);
        root1.setCenter(root);

        HBox choixPlante = new HBox();
        choixPlante.setPrefSize(900, 180);
        choixPlante.setSpacing(60);
        choixPlante.setTranslateY(20);
        choixPlante.setAlignment(Pos.CENTER);
        String Ssousmap = new File("src/images/sousmap.png").toURI().toString();
        Image Isousmap = new Image(Ssousmap);
        ImageView IVsousmap = new ImageView(Isousmap);
        IVsousmap.setFitHeight(200);
        IVsousmap.setFitWidth(900);







        VBox emplacement1 = new VBox();
        String STournesol = new File("src/images/tournesol.png").toURI().toString();
        Image ITournesol = new Image(STournesol);
        IVTournesol = new ImageView(ITournesol);
        IVTournesol.setFitHeight(100);
        IVTournesol.setFitWidth(71);
        HBox prix1 = new HBox();
        Label nbSoleil1 = new Label("50");
        nbSoleil1.setFont(police);
        String SSoleil1 = new File("src/images/soleil.png").toURI().toString();
        Image ISoleil1 = new Image(SSoleil1);
        ImageView IVSoleil1 = new ImageView(ISoleil1);
        prix1.getChildren().addAll(nbSoleil1, IVSoleil1);
        emplacement1.getChildren().addAll(IVTournesol, prix1);



        VBox emplacement2 = new VBox();
        String SPistoPois = new File("src/images/peashooter.png").toURI().toString();
        Image IPistoPois = new Image(SPistoPois);
        IVPistoPois = new ImageView(IPistoPois);
        IVPistoPois.setFitHeight(100);
        IVPistoPois.setFitWidth(71);
        HBox prix2 = new HBox();
        Label nbSoleil2 = new Label("100");
        nbSoleil2.setFont(police);
        String SSoleil2 = new File("src/images/soleil.png").toURI().toString();
        Image ISoleil2 = new Image(SSoleil2);
        ImageView IVSoleil2 = new ImageView(ISoleil2);
        prix2.getChildren().addAll(nbSoleil2, IVSoleil2);
        emplacement2.getChildren().addAll(IVPistoPois, prix2);



        VBox emplacement3 = new VBox();
        String SNoix = new File("src/images/noix.png").toURI().toString();
        Image INoix = new Image(SNoix);
        IVNoix = new ImageView(INoix);
        IVNoix.setFitHeight(100);
        IVNoix.setFitWidth(71);
        HBox prix3 = new HBox();
        Label nbSoleil3 = new Label("50");
        nbSoleil3.setFont(police);
        String SSoleil3 = new File("src/images/soleil.png").toURI().toString();
        Image ISoleil3 = new Image(SSoleil3);
        ImageView IVSoleil3 = new ImageView(ISoleil3);
        prix3.getChildren().addAll(nbSoleil3, IVSoleil3);
        emplacement3.getChildren().addAll(IVNoix, prix3);

        VBox emplacement4 = new VBox();
        String SPatate = new File("src/images/patate.png").toURI().toString();
        Image IPatate = new Image(SPatate);
        IVPatate = new ImageView(IPatate);
        IVPatate.setFitHeight(100);
        IVPatate.setFitWidth(71);
        HBox prix4 = new HBox();
        Label nbSoleil4 = new Label("150");
        nbSoleil4.setFont(police);
        String SSoleil4 = new File("src/images/soleil.png").toURI().toString();
        Image ISoleil4 = new Image(SSoleil4);
        ImageView IVSoleil4 = new ImageView(ISoleil4);
        prix4.getChildren().addAll(nbSoleil4, IVSoleil4);
        emplacement4.getChildren().addAll(IVPatate, prix4);

        VBox emplacement5 = new VBox();
        String SPistoGlace = new File("src/images/snowPea.png").toURI().toString();
        Image IPistoGlace = new Image(SPistoGlace);
        IVPistoGlace = new ImageView(IPistoGlace);
        IVPistoGlace.setFitHeight(100);
        IVPistoGlace.setFitWidth(71);
        HBox prix5 = new HBox();
        Label nbSoleil5 = new Label("150");
        nbSoleil5.setFont(police);
        String SSoleil5 = new File("src/images/soleil.png").toURI().toString();
        Image ISoleil5 = new Image(SSoleil5);
        ImageView IVSoleil5 = new ImageView(ISoleil5);
        prix5.getChildren().addAll(nbSoleil5, IVSoleil5);
        emplacement5.getChildren().addAll(IVPistoGlace, prix5);



        choixPlante.getChildren().addAll(emplacement1, emplacement2, emplacement3, emplacement4, emplacement5);

        Group groupeBottom = new Group();
        groupeBottom.getChildren().addAll(IVsousmap, choixPlante);
        root1.setBottom(groupeBottom);






        Canvas canvas = new Canvas( this.jeu.getEnvironnement().getLargeurJardin(), this.jeu.getEnvironnement().nbreLigne()*100);

        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();



        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {


			@Override
		public void handle(MouseEvent event) {
			double clicX = event.getSceneX();
			double clicY = event.getSceneY();
			int caseX;
			int caseY;
			if (!environnement.soleilIsEmpty()){
				for (Soleil s: environnement.getSoleils()){
					if(clicX-15 >= s.getX()-5 && clicX-15 <= s.getX() +15 && s.getLigne() == EnsCase.getCaseY(clicY)){
							s.setRecupere();
							jeu.setCagnote(s.getGain());
							clicok = true;
						}
					}
				}

				if (clicok == false && planteSelectionnee != null) {
					caseX=EnsCase.tradCase(EnsCase.getCaseX(clicX));
					caseY=EnsCase.getCaseY(clicY);
					if (!EnsCase.getCase(caseX, caseY)){
						planteSelectionnee.setX((EnsCase.getCaseX(event.getSceneX()))+30);
						planteSelectionnee.setLigne(EnsCase.getCaseY(event.getSceneY()));
						jeu.setCagnote(-(planteSelectionnee.getPrix()));
						environnement.addPerso(planteSelectionnee);
						planteSelectionnee=null;
						theScene.setCursor(Cursor.DEFAULT);
						EnsCase.setCaseTrue(caseX, caseY);
					}

				}
				clicok=false;
			}

		});

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );

        final long timeStart = System.currentTimeMillis();

        KeyFrame kf = new KeyFrame(
            Duration.seconds(0.017),

            new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent ae)
                {
                	if(jeu.gagne()) {

						gameLoop.stop();


						Alert alert = new Alert(AlertType.INFORMATION,"Gagné !");
						alert.show();
						alert.setOnCloseRequest((event -> System.exit(0)));


                	}
                	else if (jeu.perdu()) {

	            		gameLoop.stop();


						Alert alert = new Alert(AlertType.INFORMATION,"Perdu !");
						alert.show();
						alert.setOnCloseRequest((event -> System.exit(0)));

                	}
                	else{
                	// Clear the canvas
                		gc.clearRect(0, 0, jeu.getEnvironnement().getLargeurJardin(), jeu.getEnvironnement().nbreLigne()*100);
                		Perso p;
                		for (int i = 0; i < jeu.getEnvironnement().nbreLigne(); i++) {
                			for (int j = 0; j < jeu.getEnvironnement().getLignePersos(i).size(); j++) {
                				p = jeu.getEnvironnement().getLignePersos(i).get(j);
                				gc.drawImage(new Image(fichierImageDe(p)),p.getX(), (p.getLigne() * 100));
                			}
                		}
                		for (Soleil s : jeu.getEnvironnement().getSoleils()) {
                			gc.drawImage(new Image("images/soleil.png"),s.getX(), (s.getLigne() * 100));
                		}
                		jeu.unTour();
                	}
                }
            });
        gameLoop.getKeyFrames().add( kf );
        gameLoop.play();
        theStage.show();
        createController();

    }


    public void createController() {

    	IVTournesol.setOnMouseClicked(event -> {if(jeu.getCagnote().getValue()>=50) {
    		  											this.planteSelectionnee = new Tournesol(0, 0, this.environnement);
    		  											String STournesol = new File("src/images/tournesol.png").toURI().toString();
    		  									        Image iTournesol = new Image(STournesol);
    		  											theScene.setCursor(new ImageCursor(iTournesol));
    											}
    											});
    	IVPistoPois.setOnMouseClicked(event -> {if(jeu.getCagnote().getValue()>=100) {
													this.planteSelectionnee = new PistoPoisClassic(0, 0, this.environnement);
													String SPistoPois = new File("src/images/peashooter.png").toURI().toString();
		  									        Image iPistoPois = new Image(SPistoPois);
		  											theScene.setCursor(new ImageCursor(iPistoPois));
    											}
    											});
    	IVNoix.setOnMouseClicked(event -> {if(jeu.getCagnote().getValue()>=50) {
														this.planteSelectionnee = new Noix(0, 0, this.environnement);
														String SNoix = new File("src/images/noix.png").toURI().toString();
    		  									        Image iNoix = new Image(SNoix);
    		  											theScene.setCursor(new ImageCursor(iNoix));
											}
    										});
    	IVPatate.setOnMouseClicked(event -> {if(jeu.getCagnote().getValue()>=100) {
														this.planteSelectionnee = new Patate(0, 0, this.environnement);
														String SPatate = new File("src/images/patate.png").toURI().toString();
    		  									        Image iPatate = new Image(SPatate);
    		  											theScene.setCursor(new ImageCursor(iPatate));
											}
											});

    	IVPistoGlace.setOnMouseClicked(event -> {if(jeu.getCagnote().getValue()>=300) {
												this.planteSelectionnee = new PistoSnowPea(0, 0, this.environnement);
												String SPistoGlace = new File("src/images/snowPea.png").toURI().toString();
											    Image iPistoGlace = new Image(SPistoGlace);
												theScene.setCursor(new ImageCursor(iPistoGlace));
											}
											});


    }




    public String fichierImageDe(Perso p){
    	if (p instanceof Noix) {
			return "images/noix.png";
		}
    	if (p instanceof PistoPois) {
    		if(p instanceof PistoPoisClassic){
    			return "images/peashooter.png";
    		}
    		else{
    			return "images/snowPea.png";
    		}
		}

    	if (p instanceof ZombieDeBase) {
			if(((ZombieDeBase) p).getEtat()){
				return "images/ZombieGlace.png";
			}
			return "images/Zombie.png";
		}


		if (p instanceof ZombieCasque) {
			if(!(((Casque)((PersoMobile)p).getgVie())).casqueCasser()){
				if(!((ZombieCasque) p).getEtat())
					return "images/zombieCasque2.png";
				else
					return "images/zombieCasqueGlace.png";
			}
			else{
				if(!((ZombieCasque) p).getEtat())
					return "images/Zombie.png";
				else
					return "images/ZombieGlace.png";
			}
		}

		if (p instanceof ZombiePerchiste) {
			if (!((StrategiePerche)((PersoMobile)p).getDeplacement()).possedeSonAccessoire()) {
				if(!((ZombiePerchiste) p).getEtat())
					return "images/Zombie.png";
				else
					return "images/ZombieGlace.png";
			}
			else{
				if(!((ZombiePerchiste) p).getEtat())
					return "images/zombiePerchiste.png";
				else
					return "images/zombiePerchisteGlace.png";
			}

		}

		if (p instanceof Projectile) {

			if(p instanceof Pois){
				return "images/pea.png";
			}
			else
				return "images/peaGlace.png";

		}

		if (p instanceof Soleil) {
			return "images/soleil.png";
		}

		if(p instanceof Tournesol){
			return "images/tournesol.png";
		}

		if( p instanceof ZombiePogo){
			if(((ZombiePogo) p).getEtat()){
				return "images/pogoZombieGlace.png";
			}
			return "images/pogoZombie.png";
		}


		if( p instanceof ZombieMagicien){
			if(((ZombieMagicien) p).getEtat()){
				return "images/zombieMagicienGlace.png";
			}
			return "images/zombieMagicien.png";
		}

		if( p instanceof Mouton){
			return "images/mouton.png";
		}

		if(p instanceof Patate){
			if((((Patate)p).aExplose())){
				return "images/patate.png";
			}
			p.getgVie().meurt();
			return "images/patateExplose.png";
		}
		else return "";
    }
}
