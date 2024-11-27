package sio.fenelon;

public class Main {

    // Méthode principale d'entrée du programme
    public static void main(String[] args)
    {
        // Création d'un point GPS = instance de la classe PointGPS
        PointGPS paris = new PointGPS();

        // Initialisation des attributs de l'objet paris
        paris.ville = "Paris";

        // Définition des coordonnées GPS de Paris
        paris.setX(48.8566);
        paris.setY(2.3522);

        paris.getWhat3words();

        //paris.setWhat3words("goûtons.baisser.tapant");
        //paris.setTousLesAttributs();

        // Affichage des attributs de l'objet paris
        System.out.println("Ville : " + paris.ville);
        System.out.println("X : " + paris.getX());
        System.out.println("Y : " + paris.getY());

        System.out.println("what3words : " + paris.getWhat3words());
    }
}