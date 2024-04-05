package net.rouma;

public class Main {
    public static void main(String[] args) {
        // Création d'un point et modification de l'attribut 'ville'
        PointGPS paris = new PointGPS();
        paris.ville = "Paris";
        paris.setWhat3words("goûtons.baisser.tapant");
        paris.setTousLesAttributs();
        System.out.println("Ville : "+paris.ville);
        System.out.println("what3words : "+paris.getWhat3words());
    }
}