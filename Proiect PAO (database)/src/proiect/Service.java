package proiect;

import java.sql.SQLException;
import java.util.*;

public class Service {
    BazaDate db;

    public Service() {
        this.db = new BazaDate();
    }

    public void Run() throws SQLException {
        String option = "";
        Scanner input = new Scanner(System.in);

        while(!option.equals("iesire")) {

            System.out.println("Alegeti dintre urmatoarele optiuni: ");
            // BUCATARI
            System.out.print("afiseazaBucatari, ");
            System.out.print("adaugaBucatar, ");
            System.out.print("modificaBucatar, ");
            System.out.print("stergeBucatar\n");
            // OSPATARI
            System.out.print("afiseazaOspatari, ");
            System.out.print("adaugaOspatar, ");
            System.out.print("modificaOspatar, ");
            System.out.print("stergeOspatar\n");
            // MANCARE
            System.out.print("afiseazaMancare, ");
            System.out.print("adaugaMancare, ");
            System.out.print("modificaMancare, ");
            System.out.print("stergeMancare\n");
            // BAUTURA
            System.out.print("afiseazaBauturi, ");
            System.out.print("adaugaBautura, ");
            System.out.print("modificaBautura, ");
            System.out.print("stergeBautura\n");
            // COMENZI
            System.out.print("afiseazaComenzi, ");
            System.out.print("adaugaComanda, ");
            System.out.print("modificaComanda, ");
            System.out.print("stergeComanda\n");

            System.out.println("iesire");

            System.out.println("Scrieti optiunea:");
            option = input.nextLine();

            switch (option) {
/////////////////////////////////////////// AFISEAZA BUCATARI /////////////////////////////////////////////////
                case "afiseazaBucatari":
                    System.out.println("Afiseaza toti bucatarii: ");
                    List<Bucatar> chefs = db.getChefs();
                    for (Bucatar chef : chefs) {
                        chef.detaliiBucatar();
                    }

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

                    // idBucatar = 0 deoarece coloana "id_bucatar" din baza de date are auto-increment
                    Bucatar bucatarNou = new Bucatar(0, nume, varsta, salariu, prod);
                    db.addChef(bucatarNou);
                    System.out.println("Am adaugat bucatarul nou.\n");

                    break;

/////////////////////////////////////////// MODIFICA BUCATAR /////////////////////////////////////////////////
                case "modificaBucatar":
                    System.out.println("ID-ul bucatarului pe care doriti sa il modificati: ");
                    int id;
                    id = Integer.parseInt(input.nextLine());

                    System.out.println("Alegeti coloana de modificat: nume, varsta, salariu, produse.");
                    String col;
                    col = input.nextLine();
                    while(!col.equals("nume")
                            && !col.equals("varsta")
                            && !col.equals("salariu")
                            && !col.equals("produse")){
                        System.out.println("Nu ati facut alegerea corecta. Reincercati!");
                        col = input.nextLine();
                    }

                    System.out.println("Modificarea pe care o doriti: ");
                    String modif;
                    modif = input.nextLine();

                    db.updateChef(col, modif, id);
                    System.out.println("Am modificat bucatarul cu id = " + id + ".\n");

                    break;

/////////////////////////////////////////// STERGE BUCATAR /////////////////////////////////////////////////
                case "stergeBucatar":
                    System.out.println("ID-ul bucatarului pe care doriti sa il stergeti: ");
                    id = Integer.parseInt(input.nextLine());

                    db.deleteChef(id);
                    System.out.println("Am sters bucatarul cu id " + id + ".\n");

                    break;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////// AFISEAZA OSPATARI /////////////////////////////////////////////////
                case "afiseazaOspatari":
                    System.out.println("Afiseaza toti ospatarii: ");
                    List<Ospatar> waiters = db.getWaiters();
                    for (Ospatar waiter : waiters) {
                        waiter.detaliiOspatar();
                    }

                    break;

/////////////////////////////////////////// ADAUGA OSPATAR /////////////////////////////////////////////////
                case "adaugaOspatar":
                    System.out.println("Nume: ");
                    nume = input.nextLine();

                    System.out.println("Varsta: ");
                    varsta = Integer.parseInt(input.nextLine());

                    System.out.println("Salariu: ");
                    salariu = Integer.parseInt(input.nextLine());

                    Ospatar ospatarNou = new Ospatar(0, nume, varsta, salariu);
                    db.addWaiter(ospatarNou);
                    System.out.println("Am adaugat ospatarul nou.\n");

                    break;

/////////////////////////////////////////// MODIFICA OSPATAR /////////////////////////////////////////////////
                case "modificaOspatar":
                    System.out.println("ID-ul ospatarului pe care doriti sa il modificati: ");
                    id = Integer.parseInt(input.nextLine());

                    System.out.println("Alegeti coloana de modificat: nume, varsta, salariu.");
                    col = input.nextLine();
                    while(!col.equals("nume")
                            && !col.equals("varsta")
                            && !col.equals("salariu")){
                        System.out.println("Nu ati facut alegerea corecta. Reincercati!");
                        col = input.nextLine();
                    }

                    System.out.println("Modificarea pe care o doriti: ");
                    modif = input.nextLine();

                    db.updateWaiter(col, modif, id);
                    System.out.println("Am modificat ospatarul cu id = " + id + ".\n");

                    break;

/////////////////////////////////////////// STERGE OSPATAR /////////////////////////////////////////////////
                case "stergeOspatar":
                    System.out.println("ID-ul ospatarului pe care doriti sa il stergeti: ");
                    id = Integer.parseInt(input.nextLine());

                    db.deleteWaiter(id);
                    System.out.println("Am sters ospatarul cu id " + id + ".\n");

                    break;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////// AFISEAZA MANCARE /////////////////////////////////////////////////
                case "afiseazaMancare":
                    System.out.println("Afiseaza felurile de mancarea: ");
                    List<Mancare> foods = db.getFood();
                    for (Mancare food : foods) {
                        food.detaliiMancare();
                    }

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

                    System.out.println("De Post: ");
                    boolean dePost;
                    dePost = Boolean.parseBoolean(input.nextLine());

                    Mancare mancareNoua = new Mancare(0, categorie, nume, pret, ingrediente, dePost);
                    db.addFood(mancareNoua);
                    System.out.println("Am adaugat felul de mancare.\n");

                    break;

/////////////////////////////////////////// MODIFICA MANCARE /////////////////////////////////////////////////
                case "modificaMancare":
                    System.out.println("ID-ul felului de mancare pe care doriti sa il modificati: ");
                    id = Integer.parseInt(input.nextLine());

                    System.out.println("Alegeti coloana de modificat: categorie, nume, pret, ingrediente, de_post.");
                    col = input.nextLine();
                    while(!col.equals("categorie")
                            && !col.equals("nume")
                            && !col.equals("pret")
                            && !col.equals("ingrediente")
                            && !col.equals("de_post")){
                        System.out.println("Nu ati facut alegerea corecta. Reincercati!");
                        col = input.nextLine();
                    }

                    System.out.println("Modificarea pe care o doriti: ");
                    modif = input.nextLine();

                    db.updateFood(col, modif, id);
                    System.out.println("Am modificat felul de mancare cu id = " + id + ".\n");

                    break;

/////////////////////////////////////////// STERGE MANCARE /////////////////////////////////////////////////
                case "stergeMancare":
                    System.out.println("ID-ul felului de mancare pe care doriti sa il stergeti: ");
                    id = Integer.parseInt(input.nextLine());

                    db.deleteFood(id);
                    System.out.println("Am sters felul de mancare cu id " + id + ".\n");

                    break;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////// AFISEAZA BAUTURA /////////////////////////////////////////////////
                case "afiseazaBautura":
                    System.out.println("Afiseaza toata bautura: ");
                    List<Bautura> drinks = db.getDrinks();
                    for (Bautura drink : drinks) {
                        drink.detaliiBautura();
                    }

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

                    Bautura bauturaNoua = new Bautura(0, categorie, nume, pret, ingrediente, areZahar);
                    db.addDrink(bauturaNoua);
                    System.out.println("Am adaugat bautura.\n");

                    break;

/////////////////////////////////////////// MODIFICA BAUTURA /////////////////////////////////////////////////
                case "modificaBautura":
                    System.out.println("ID-ul bauturii pe care doriti sa o modificati: ");
                    id = Integer.parseInt(input.nextLine());

                    System.out.println("Alegeti coloana de modificat: categorie, nume, pret, ingrediente, are_zahar.");
                    col = input.nextLine();
                    while(!col.equals("categorie")
                            && !col.equals("nume")
                            && !col.equals("pret")
                            && !col.equals("ingrediente")
                            && !col.equals("are_zahar")){
                        System.out.println("Nu ati facut alegerea corecta. Reincercati!");
                        col = input.nextLine();
                    }

                    System.out.println("Modificarea pe care o doriti: ");
                    modif = input.nextLine();

                    db.updateDrink(col, modif, id);
                    System.out.println("Am modificat bautura cu id = " + id + ".\n");

                    break;

/////////////////////////////////////////// STERGE BAUTURA /////////////////////////////////////////////////
                case "stergeBautura":
                    System.out.println("ID-ul bauturii pe care doriti sa o stergeti: ");
                    id = Integer.parseInt(input.nextLine());

                    db.deleteDrink(id);
                    System.out.println("Am sters bautura cu id " + id + ".\n");

                    break;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////// AFISEAZA COMENZILE /////////////////////////////////////////////////
                case "afiseazaComenzi":
                    System.out.println("Afiseaza toate comenzile: ");
                    List<Comanda> orders = db.getOrders();
                    for (Comanda order : orders) {
                        order.arataComanda();
                    }

                    break;

/////////////////////////////////////////// ADAUGA COMANDA /////////////////////////////////////////////////
                case "adaugaComanda":
                    System.out.println("Pret: ");
                    pret = Double.parseDouble(input.nextLine());

                    System.out.println("Produse: ");
                    prod = input.nextLine();

                    Comanda comandaNoua = new Comanda(0, pret, prod);
                    db.addOrder(comandaNoua);
                    System.out.println("Am adaugat comanda noua.\n");

                    break;

/////////////////////////////////////////// MODIFICA COMANDA /////////////////////////////////////////////////
                case "modificaComanda":
                    System.out.println("ID-ul comenzii pe care doriti sa o modificati: ");
                    id = Integer.parseInt(input.nextLine());

                    System.out.println("Alegeti coloana de modificat: pret, produse.");
                    col = input.nextLine();
                    while(!col.equals("pret")
                            && !col.equals("produse")){
                        System.out.println("Nu ati facut alegerea corecta. Reincercati!");
                        col = input.nextLine();
                    }

                    System.out.println("Modificarea pe care o doriti: ");
                    modif = input.nextLine();

                    db.updateOrder(col, modif, id);
                    System.out.println("Am modificat comanda cu id = " + id + ".\n");

                    break;

/////////////////////////////////////////// STERGE COMANDA /////////////////////////////////////////////////
                case "stergeComanda":
                    System.out.println("ID-ul comenzii pe care doriti sa o stergeti: ");
                    id = Integer.parseInt(input.nextLine());

                    db.deleteOrder(id);
                    System.out.println("Am sters comanda cu id " + id + ".\n");

                    break;

////////////////////////////////////////////////// IESIRE /////////////////////////////////////////////////////////
                case "iesire":
                    System.out.println("Iesire");
                    break;

                default:
                    System.out.println("Invalid");
            }
        }
        input.close();
    }
}
