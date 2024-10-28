import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Fichier extends ReentrantReadWriteLock {

    private String nom;
    private String contenu;
    private boolean enEcriture;

    public Fichier(String nom, String contenu) {
        this.nom = nom;
        this.contenu = contenu;
        this.enEcriture = false;
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

    public boolean isEnEcriture() {
        return enEcriture;
    }

    public void setEnEcriture(boolean enEcriture) {
        this.enEcriture = enEcriture;
    }

    public void lire(Reader reader) throws InterruptedException {
        System.out.println(reader.getNom() + " lit le fichier : " + this.getNom() + "\n" + this.contenu);
        Thread.sleep((int)(Math.random() * 2000) + 2000);
    }

    public synchronized void ecrire(Writer writer) throws InterruptedException {
        while (this.enEcriture) {
            wait();
        }
        setEnEcriture(true);
        this.contenu += "\t" + writer.getMessage() + "\n";
        System.out.println(writer.getNom() + " a écrit : <" + writer.getMessage() + "> dans le fichier " + this.getNom());
        setEnEcriture(false);
        notifyAll();
    }

}
