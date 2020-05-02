package proiect;

public abstract class Produse {
    private String categorieProdus;
    private String numeProdus;
    private double pretProdus;

    public Produse(String categorieProdus, String numeProdus, double pretProdus) {
        this.categorieProdus = categorieProdus;
        this.numeProdus = numeProdus;
        this.pretProdus = pretProdus;
    }

    public String getCategorieProdus() {
        return categorieProdus;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public double getPretProdus() {
        return pretProdus;
    }

    public abstract void afiseazaProduse();

}
