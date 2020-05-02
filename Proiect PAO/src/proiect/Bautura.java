package proiect;

public class Bautura extends Produse {
    public String ingrediente;
    public boolean areZahar;

    public Bautura(String categorieProdus, String numeProdus, double pretProdus, String ingrediente, boolean areZahar) {
        super(categorieProdus, numeProdus, pretProdus);
        this.ingrediente = ingrediente;
        this.areZahar = areZahar;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public boolean areZahar() {
        return areZahar;
    }

    @Override
    public void afiseazaProduse() {
        System.out.print(this.getNumeProdus());
    }

}
