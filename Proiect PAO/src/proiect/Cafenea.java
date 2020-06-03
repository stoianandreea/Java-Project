package proiect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cafenea {
    private String numeCafenea;
    private String locatie;
    private List<Bucatar> bucatari = new ArrayList<>();
    private List<Ospatar> ospatari = new ArrayList<>();
    private List<Produse> prod = new ArrayList<>();
    private List<Comanda> comenzi = new ArrayList<>();
    public AuditCSV audit = AuditCSV.getInstance();
    public CSVRepository csv = CSVRepository.getInstance();

    public Cafenea(){
        this.numeCafenea = "Coffeol";
        this.locatie = "Bucuresti";
        /*
        Bucatar b = new Bucatar("Ionescu Alex", 40, 2000, "cafea, prajitura");
        this.bucatari.add(b);
        Ospatar o = new Ospatar("Popescu Ion", 30, 1000);
        this.ospatari.add(o);
        Produse drink1 = new Bautura("cafea", "Cafea cu lapte", 10.0, "cafea, lapte", true);
        this.prod.add(drink1);
        Produse drink2 = new Bautura("cafea", "Iced coffee", 16.0, "cafea, lapte, gheata", true);
        this.prod.add(drink2);
        Produse food1 = new Mancare("prajitura", "Cheesecake", 20.50, "blat, branza, fructe", false);
        this.prod.add(food1);
        Produse food2 = new Mancare("inghetata", "Inghetata ciocolata", 7.50, "inghetata, sirop", false);
        this.prod.add(food2);
        */
    }

    public void adaugaBucatar(Bucatar bucatar) {
        this.bucatari.add(bucatar);
        audit.scrieAudit("Am adaugat un bucatar!");
    }

    public void adaugaOspatar(Ospatar ospatar) {
        this.ospatari.add(ospatar);
        audit.scrieAudit("Am adaugat un ospatar!");
    }

    public void adaugaMancare(Mancare food){
        this.prod.add(food);
        audit.scrieAudit("Am adaugat un preparat!");
    }

    public void adaugaBautura(Bautura drink){
        this.prod.add(drink);
        audit.scrieAudit("Am adaugat o bautura!");
    }

    public void adaugaComanda(Comanda order) {
        this.comenzi.add(order);
        audit.scrieAudit("Am adaugat o comanda!");
    }

    public void arataInformatiiBucatari() {
        for (Bucatar bucatar: bucatari) {
            bucatar.detaliiBucatar();
        }
        audit.scrieAudit("Am afisat bucatarii!");
    }

    public void arataComenzi() {
        for (Comanda com: comenzi) {
                com.arataComanda();
        }
        audit.scrieAudit("Am afisat comenzile!");
    }

    public void InfoCafenea(){
        System.out.println("Nume cafenea: " + numeCafenea);
        System.out.println("Locatie: " + locatie);
        System.out.println("Angajati: ");
        for (Bucatar bucatar: bucatari) {
            bucatar.afiseazaJobul();
        }
        for(Ospatar ospatar: ospatari){
            ospatar.afiseazaJobul();
        }
        System.out.println("Feluri de mancare: \n");
        for(Produse food: prod){
            food.afiseazaProduse();
            System.out.println(", ");
        }
        System.out.println(" ");
        audit.scrieAudit("Am afisat informatiile cafenelei!");
    }

    public void stergeProdus(String prodSters) {
        bucatari.removeIf(chef -> chef.getNume().toLowerCase().equals(prodSters.toLowerCase()));
        audit.scrieAudit("Produs sters");
    }

    public void sortare() {
        audit.scrieAudit("Produsele au fost sortate");
    }

    public List<Produse> getProd() {
        return prod;
    }

    public void citesteBucatari() {
        csv.citesteBucatari(bucatari);
    }

    public void citesteOspatari() {
        csv.citesteOspatari(ospatari);
    }

    public void citesteComenzi() {
        csv.citesteComenzi(comenzi);
    }

    public void citesteProduse() {
        csv.citesteProduse(prod);
    }

    public void scrieBucatari() {
       csv.scrieBucatari(bucatari);
    }

    public void scrieOspatari() {
        csv.scrieOspatari(ospatari);
    }

    public void scrieComenzi() {
        csv.scrieComenzi(comenzi);
    }

    public void scrieProduse() {
        List<Mancare> m = new ArrayList<>();
        List<Bautura> b = new ArrayList<>();
        for(Produse p : prod){
            if(p instanceof Mancare)
                m.add((Mancare) p);
            else if(p instanceof Bautura)
                b.add((Bautura) p);
        }
        csv.scrieProduse(m, b);
    }

}
