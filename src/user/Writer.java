package user;

public class Writer extends User {

    private String message;

    public Writer(String nom, String message) {
        super.setNom(nom);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {

    }

}
