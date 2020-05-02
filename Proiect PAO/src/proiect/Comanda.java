package proiect;

public class Comanda {
    private int idComanda;
    private double pretComanda;
    private String produseComanda;

    public Comanda(int numarComanda, double pretComanda, String produseComanda) {
        this.idComanda = numarComanda;
        this.pretComanda = pretComanda;
        this.produseComanda = produseComanda;
    }

    public void arataComanda() {
        System.out.println("Comanda numarul: " + idComanda + " cu pretul " + pretComanda + " si produsele " + produseComanda);
    }

    public int getIdComanda() {
        return idComanda;
    }

    public double getPretComanda() {
        return pretComanda;
    }

    public String getProduseComanda() {
        return produseComanda;
    }
}
