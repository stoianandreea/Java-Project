package proiect;

import java.util.ArrayList;
import java.util.List;

public class Cafenea {
    private String numeCafenea;
    private String locatie;
    private List<Bucatar> bucatari = new ArrayList<>();
    private List<Ospatar> ospatari = new ArrayList<>();
    private List<Produse> prod = new ArrayList<>();
    private List<Comanda> comenzi = new ArrayList<>();

    public Cafenea(){
        this.numeCafenea = "Coffeol";
        this.locatie = "Bucuresti";
    }
}
