package proiect;

public class Mancare extends Produse {
    private int idMancare;
    private String ingrediente;
    private boolean dePost;

    public Mancare(int idMancare, String categorieProdus, String numeProdus, double pretProdus, String ingrediente, boolean dePost) {
        super(categorieProdus, numeProdus, pretProdus);
        this.idMancare = idMancare;
        this.ingrediente = ingrediente;
        this.dePost = dePost;
    }

    protected void detaliiMancare() {
        super.detaliiProdus();
        System.out.println("Ingrediente: " + ingrediente);
        System.out.println("De post: " + dePost);
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
