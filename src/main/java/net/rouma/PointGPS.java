package net.rouma;
import java.util.regex.*;

public class PointGPS {
    private double x;
    private double y;
    private double z;
    private String what3words;
    public String ville;

    // Constructeur
    public PointGPS(double x, double y, String ville) {
        this.setX(x);
        this.setY(y);
        this.ville = ville;
        // il doit être possible de trouver what3words avec des coordonnées GPS...
    }
    public PointGPS() {

    }
    private String getwhat3wordsFromGPS(double x, double y) {
        What3WordsV3 what3words = What3Words.withApiKey("VOTRE_CLE_API");
        return "";
    }
    public String getWhat3words() {
        return this.what3words;
    }
    public void setWhat3words(String what3words) {
        String regex = "^\\p{L}{2,}\\.\\p{L}{2,}\\.\\p{L}{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(what3words);
        if (matcher.matches()) {
            this.what3words = what3words;
        }
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {
        if (x >= -180 && x <= 180) {
            this.x = x;
        }
    }
    public double getY() {
        return y;
    }

    // Mutateur pour la variable y avec vérification des contraintes
    public void setY(double y) {
        if (y >= -90 && y <= 90) {
            this.y = y;
        }
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        if (z >= -10972 && z <= 8849) {
            this.z = z;
        }
    }
    public void setTousLesAttributs() {
        this.x = 2000d;
        this.y = 9999.99999d;
        this.z = 30000.0d;
        this.what3words = "a.b.c.d.e.f";
    }
}
