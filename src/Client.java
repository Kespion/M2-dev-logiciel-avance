public class Client extends Thread {

    private final Piscine piscine;

    public Client(String nom, Piscine piscine) {
        super(nom);
        this.piscine = piscine;
    }

    @Override
    public void run() {
        while (true) {
            try {
                boolean aObtenuRessources = false;
                while (!aObtenuRessources) {
                    aObtenuRessources = piscine.utiliserCabineEtPanier(this);
                    if (!aObtenuRessources) {
                        Thread.sleep(500);
                    }
                }

                System.out.println(getName() + " nage...");
                Thread.sleep((int) (Math.random() * 5000) + 5000);

                boolean aRetourneRessources = false;
                while (!aRetourneRessources) {
                    aRetourneRessources = piscine.retournerCabineEtPanier(this);
                    if (!aRetourneRessources) {
                        Thread.sleep(500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}