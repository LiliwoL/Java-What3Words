package sio.fenelon;
import com.what3words.javawrapper.What3WordsV3;
import com.what3words.javawrapper.request.Coordinates;
import com.what3words.javawrapper.response.ConvertTo3WA;

import java.util.regex.*;

// TODO 1) comprendre comment fonction maven
// TODO 2) comprendre pourquoi maven ne peut compiler le projet
public class PointGPS
{
    // Attributs
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
        // What3Words from coords
        this.what3words = getWhat3WordsFromGPS(x, y);
    }

    // Constructeur par défaut
    public PointGPS() {}

    private String getWhat3WordsFromGPS(double x, double y)
    {
        // Instanciation de l'objet What3WordsV3
        What3WordsV3 api = new What3WordsV3("95HDXITI");

        // Convert coordinates to a 3 word address
        ConvertTo3WA words = api.convertTo3wa(new Coordinates(x, y))
                .language("fr")
                .execute();

        // Retourne les mots correspondants aux coordonnées GPS
        return words.getWords();
    }

    // Accesseurs et mutateurs
    public String getWhat3words()
    {
        // Si l'attribut what3words est null, on le cherche (les coordonnées GPS sont connues)
        if (this.what3words == null && this.x != 0 && this.y != 0) {
            this.what3words = getWhat3WordsFromGPS(this.x, this.y);
        }

        // Retourne la valeur de l'attribut what3words
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
