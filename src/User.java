import java.util.List;

public abstract class User extends Thread {

    private String nom;
    private List<Fichier> fichiers;

    public User(String nom, List<Fichier> fichiers) {
        this.nom = nom;
        this.fichiers = fichiers;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Fichier> getFichiers() {
        return fichiers;
    }

    public void setFichiers(List<Fichier> fichiers) {
        this.fichiers = fichiers;
    }

    public Fichier getRandomFichier() {
        return fichiers.get((int)(Math.random() * fichiers.size()));
    }

}
