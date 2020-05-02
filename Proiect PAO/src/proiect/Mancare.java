package proiect;

public class Mancare extends Produse {
    private String ingrediente;
    private boolean dePost;

    public Mancare(String categorieProdus, String numeProdus, double pretProdus, String ingrediente, boolean dePost) {
        super(categorieProdus, numeProdus, pretProdus);
        this.ingrediente = ingrediente;
        this.dePost = dePost;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public boolean isDePost() {
        return dePost;
    }

    @Override
    public void afiseazaProduse() {
        System.out.print(this.getNumeProdus());
    }

}
