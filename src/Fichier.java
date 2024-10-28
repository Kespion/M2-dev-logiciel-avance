public class Fichier {

    private String nom;
    private String contenu;

    public Fichier(String nom, String contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

}
