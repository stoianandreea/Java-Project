package proiect;

public class Bautura extends Produse {
    private int idBautura;
    private String ingrediente;
    private boolean areZahar;

    public Bautura(int idBautura, String categorieProdus, String numeProdus, double pretProdus, String ingrediente, boolean areZahar) {
        super(categorieProdus, numeProdus, pretProdus);
        this.idBautura = idBautura;
        this.ingrediente = ingrediente;
        this.areZahar = areZahar;
    }

    protected void detaliiBautura() {
        super.detaliiProdus();
        System.out.println("Ingrediente: " + ingrediente);
        System.out.println("Are zahar: " + areZahar);
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
