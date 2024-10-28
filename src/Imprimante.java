import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Imprimante {

    private final BlockingQueue<DemandeImpression> fileAttente;
    private final Semaphore semaphore;

    public Imprimante() {
        this.fileAttente = new LinkedBlockingQueue<>();
        this.semaphore = new Semaphore(1);
        Thread threadImpression = new Thread(this::traiterFileAttente);
        threadImpression.start();
    }

    public BlockingQueue<DemandeImpression> getFileAttente() {
        return fileAttente;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void ajouterDemande(DemandeImpression demandeImpression) {
        try {
            fileAttente.put(demandeImpression);
            //System.out.println("Demande ajoutée pour : " + document);
        } catch (InterruptedException e) {
            System.out.println("Erreur lors de l'ajout de la demande");
            Thread.currentThread().interrupt();
        }
    }

    private void traiterFileAttente() {
        while (true) {
            try {
                DemandeImpression demandeImpression = fileAttente.take();
                imprimer(demandeImpression.getDocument());
            } catch (InterruptedException e) {
                System.out.println("Erreur lors de l'impression");
                Thread.currentThread().interrupt();
            }
        }
    }

    private void imprimer(String document) {
        try {
            semaphore.acquire();
            System.out.println("Impression du document : " + document);
            Thread.sleep((int)(Math.random() * 1500) + 1500);
            System.out.println("Document imprimé : " + document);
        } catch (InterruptedException e) {
            System.out.println("Impression interrompue");
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}