package proiect;

import java.util.*;

public class Service {
    Cafenea cafenea;

    public Service() {
        this.cafenea = new Cafenea();
    }

    public void Run() {
        cafenea.citesteBucatari();
        cafenea.citesteOspatari();
        cafenea.citesteComenzi();
        cafenea.citesteProduse();

        String option = "";
        Scanner input = new Scanner(System.in);

        while(option.equals("iesire") == false) {

            System.out.println("Alegeti dintre urmatoarele optiuni: ");
            System.out.print("afiseazaInfoCafenea, ");
            System.out.print("adaugaBucatar, ");
            System.out.print("adaugaOspatar, ");
            System.out.print("adaugaMancare, ");
            System.out.print("adaugaBautura, ");
            System.out.print("adaugaComanda, ");
            System.out.print("afiseazaComenzi, ");
            System.out.print("afiseazaBucatari, ");
            System.out.print("sorteazaPret, ");
            System.out.print("stergeProdus, ");
            System.out.println("iesire");

            System.out.println("Scrieti optiunea:");
            option = input.nextLine();

            switch (option) {
/////////////////////////////////////////// AFISEAZA INFORMATII CAFENEA /////////////////////////////////////////////////
                case "afiseazaInfoCafenea":
                    cafenea.InfoCafenea();

                    break;

/////////////////////////////////////////// ADAUGA BUCATAR /////////////////////////////////////////////////
                case "adaugaBucatar":
                    System.out.println("Nume: ");
                    String nume;
                    nume = input.nextLine();

                    System.out.println("Varsta: ");
                    int varsta;
                    varsta = Integer.parseInt(input.nextLine());

                    System.out.println("Salariu: ");
                    int salariu;
                    salariu = Integer.parseInt(input.nextLine());

                    System.out.println("Produse: ");
                    String prod;
                    prod = input.nextLine();

                    Bucatar bucatarNou = new Bucatar(nume, varsta, salariu, prod);
                    cafenea.adaugaBucatar(bucatarNou);
                    System.out.println("Am adaugat bucatarul nou.\n");

                    break;

/////////////////////////////////////////// ADAUGA OSPATAR /////////////////////////////////////////////////
                case "adaugaOspatar":
                    System.out.println("Nume: ");
                    nume = input.nextLine();

                    System.out.println("Varsta: ");
                    varsta = Integer.parseInt(input.nextLine());

                    System.out.println("Salariu: ");
                    salariu = Integer.parseInt(input.nextLine());

                    Ospatar ospatarNou = new Ospatar(nume, varsta, salariu);
                    cafenea.adaugaOspatar(ospatarNou);
                    System.out.println("Am adaugat ospatarul nou.\n");

                    break;

/////////////////////////////////////////// ADAUGA MANCARE /////////////////////////////////////////////////
                case "adaugaMancare":
                    System.out.println("Categorie: ");
                    String categorie;
                    categorie = input.nextLine();

                    System.out.println("Nume: ");
                    nume = input.nextLine();

                    System.out.println("Pret: ");
                    double pret;
                    pret = Double.parseDouble(input.nextLine());

                    System.out.println("Ingrediente: ");
                    String ingrediente;
                    ingrediente = input.nextLine();

                    System.out.println("De post: ");
                    boolean dePost;
                    dePost = Boolean.parseBoolean(input.nextLine());

                    Mancare mancareNoua = new Mancare(categorie, nume, pret, ingrediente, dePost);
                    cafenea.adaugaMancare(mancareNoua);
                    System.out.println("Am adaugat mancarea in meniu.\n");

                    break;

/////////////////////////////////////////// ADAUGA BAUTURA /////////////////////////////////////////////////
                case "adaugaBautura":
                    System.out.println("Categorie: ");
                    categorie = input.nextLine();

                    System.out.println("Nume: ");
                    nume = input.nextLine();

                    System.out.println("Pret: ");
                    pret = Double.parseDouble(input.nextLine());

                    System.out.println("Ingrediente: ");
                    ingrediente = input.nextLine();

                    System.out.println("Are zahar: ");
                    boolean areZahar;
                    areZahar = Boolean.parseBoolean(input.nextLine());

                    Bautura bauturaNoua = new Bautura(categorie, nume, pret, ingrediente, areZahar);
                    cafenea.adaugaBautura(bauturaNoua);
                    System.out.println("Am adaugat bautura in meniu.\n");

                    break;

//////////////////////////////////// ADAUGA COMANDA //////////////////////////////////////////
                case "adaugaComanda":
                    System.out.println("ID Comanda: ");
                    int id;
                    id = Integer.parseInt(input.nextLine());

                    System.out.println("Pret: ");
                    pret = Integer.parseInt(input.nextLine());

                    System.out.println("Produse: ");
                    prod = input.nextLine();

                    Comanda comanda = new Comanda(id, pret, prod);
                    cafenea.adaugaComanda(comanda);

                    break;

//////////////////////////////// AFISEAZA COMENZILE DIN CAFENEA ////////////////////////////
                case "afiseazaComenzi":
                    System.out.println("Toate comenzile");
                    cafenea.arataComenzi();
                    break;


/////////////////////////////////////// STERGE PRODUS ///////////////////////////////////////////////////
                case "stergeProdus":

                    System.out.println("Stergeti produsul: ");
                    String prodSters = "";
                    prodSters = input.nextLine();
                    cafenea.stergeProdus(prodSters);
                    System.out.println(prodSters + " a fost sters!");

                    break;

/////////////////////////////////////////// AFISEAZA BUCATARI /////////////////////////////////////////////////

                case "afiseazaBucatari":
                    System.out.println("Afiseaza toti bucatarii: ");
                    cafenea.arataInformatiiBucatari();

                    break;

//////////////////////////////////////// SORTEAZA PRODUSE DUPA PRET /////////////////////////////////////////////////
                case "sorteazaPret":
                    List<Produse> produse = cafenea.getProd();
                    Collections.sort(produse, Comparator.comparing(Produse::getPretProdus));
                    for(Produse pr : produse) {
                        pr.afiseazaProduse();
                        System.out.println(", ");
                    }
                    cafenea.sortare();
                    System.out.println("\n");

                    break;
////////////////////////////////////////////////// IESIRE /////////////////////////////////////////////////////////
                case "iesire":
                    cafenea.scrieBucatari();
                    cafenea.scrieOspatari();
                    cafenea.scrieComenzi();
                    cafenea.scrieProduse();
                    System.out.println("Iesire");

                    break;

                default:
                    System.out.println("Invalid");
            }
        }
        input.close();
    }

}
