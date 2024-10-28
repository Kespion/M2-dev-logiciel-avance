public class DemandeImpression extends Thread {

    private String document;
    private Imprimante imprimante;

    public DemandeImpression(String requestor, String document, Imprimante imprimante) {
        super(requestor);
        this.document = document;
        this.imprimante = imprimante;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Imprimante getImprimante() {
        return imprimante;
    }

    public void setImprimante(Imprimante imprimante) {
        this.imprimante = imprimante;
    }

    @Override
    public void run() {

        while (true) {

            System.out.println("Envoi de la demande d'impression pour : " + document);
            imprimante.ajouterDemande(this);
            try {
                Thread.sleep((int)(Math.random() * 5000) + 5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
