import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int NOMBRE_DEMANDES_IMPRESSION = 5;

    public static void main(String[] args) throws InterruptedException {

        Imprimante imprimante = new Imprimante();

        List<DemandeImpression> demandeImpressionList = new ArrayList<>();
        for (int i = 0; i < NOMBRE_DEMANDES_IMPRESSION; i++) {
            demandeImpressionList.add(new DemandeImpression("DI N°" + i, "Document de DI N°" + i, imprimante));
        }

        for (DemandeImpression demandeImpression : demandeImpressionList) {
            demandeImpression.start();
        }

        for (DemandeImpression demandeImpression : demandeImpressionList) {
            demandeImpression.join();
        }

    }

}