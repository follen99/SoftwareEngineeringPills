package Sangue;

public class Sacca{
    public Sacca(String seriale, String gruppo){
        this.seriale = seriale;
        this.gruppo = gruppo;
    }

    @Override
    public String toString() {
        return "Sacca{" +
                "seriale='" + seriale + '\'' +
                ", gruppo='" + gruppo + '\'' +
                '}';
    }

    public String getGruppo() {
        return gruppo;
    }

    public String getSeriale() {
        return seriale;
    }

    public void setGruppo(String gruppo) {
        this.gruppo = gruppo;
    }

    public void setSeriale(String seriale) {
        this.seriale = seriale;
    }

    private String seriale;
    private String gruppo;
}
