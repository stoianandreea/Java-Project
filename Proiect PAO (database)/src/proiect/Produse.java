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

    protected void detaliiProdus() {
        System.out.println("Categorie produs: " + categorieProdus);
        System.out.println("Nume produs: " + numeProdus);
        System.out.println("Pret produs: " + pretProdus);
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
