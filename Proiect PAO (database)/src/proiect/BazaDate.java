package proiect;

import java.sql. *;
import java.util.ArrayList;
import java.util.List;

public class BazaDate {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/java-project";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD= "root";

    // BUCATARI
    private static final String GET_ALL_CHEFS = "SELECT * FROM bucatari";
    private static final String ADD_NEW_CHEF = "INSERT INTO bucatari values(NULL, ?, ?, ?, ?)";
    private static final String DELETE_CHEF = "DELETE FROM bucatari WHERE id_bucatar = ?";
    // OSPATARI
    private static final String GET_ALL_WAITERS = "SELECT * FROM ospatari";
    private static final String ADD_NEW_WAITER = "INSERT INTO ospatari values(NULL, ?, ?, ?)";
    private static final String DELETE_WAITER = "DELETE FROM ospatari WHERE id_ospatar = ?";
    // MANCARE
    private static final String GET_ALL_FOOD = "SELECT * FROM mancare";
    private static final String ADD_NEW_FOOD = "INSERT INTO mancare values(NULL, ?, ?, ?, ?, ?)";
    private static final String DELETE_FOOD = "DELETE FROM mancare WHERE id_mancare = ?";
    // BAUTURA
    private static final String GET_ALL_DRINKS = "SELECT * FROM bauturi";
    private static final String ADD_NEW_DRINK = "INSERT INTO bauturi values(NULL, ?, ?, ?, ?, ?)";
    private static final String DELETE_DRINK = "DELETE FROM bauturi WHERE id_bautura = ?";
    // COMENZI
    private static final String GET_ALL_ORDERS = "SELECT * FROM comenzi";
    private static final String ADD_NEW_ORDER = "INSERT INTO comenzi values(NULL, ?, ?)";
    private static final String DELETE_ORDER = "DELETE FROM comenzi WHERE id_comanda = ?";

    public static Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL,DATABASE_USER,DATABASE_PASSWORD);
    }

/////////////////////////////////////////////// BUCATARI ////////////////////////////////////////////////////
    public List<Bucatar> getChefs() throws SQLException {
        List<Bucatar> returnedList = new ArrayList<>();
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(GET_ALL_CHEFS);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Bucatar chef = new Bucatar(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4),
                    resultSet.getString(5));
            returnedList.add(chef);
        }
        return returnedList;
    }

    public boolean addChef(Bucatar chef) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(ADD_NEW_CHEF);
        preparedStatement.setString(1, chef.getNume());
        preparedStatement.setInt(2, chef.getVarsta());
        preparedStatement.setInt(3, chef.getSalariu());
        preparedStatement.setString(4, chef.getProduse());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateChef(String column, String modifiedValue, int chefId) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement("UPDATE bucatari SET " + column + " = ? WHERE id_bucatar = ?");
        if(column.equals("nume") || column.equals("produse"))
            preparedStatement.setString(1, modifiedValue);
        else if(column.equals("varsta") || column.equals("salariu"))
            preparedStatement.setInt(1, Integer.parseInt(modifiedValue));
        preparedStatement.setInt(2, chefId);

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteChef(int chefId) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(DELETE_CHEF);
        preparedStatement.setInt(1, chefId);

        return preparedStatement.executeUpdate() > 0;
    }

/////////////////////////////////////////////// OSPATARI ////////////////////////////////////////////////////
    public List<Ospatar> getWaiters() throws SQLException {
        List<Ospatar> returnedList = new ArrayList<>();
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(GET_ALL_WAITERS);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Ospatar waiter = new Ospatar(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4));
            returnedList.add(waiter);
        }
        return returnedList;
    }

    public boolean addWaiter(Ospatar waiter) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(ADD_NEW_WAITER);
        preparedStatement.setString(1, waiter.getNume());
        preparedStatement.setInt(2, waiter.getVarsta());
        preparedStatement.setInt(3, waiter.getSalariu());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateWaiter(String column, String modifiedValue, int waiterId) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement("UPDATE ospatari SET " + column + " = ? WHERE id_ospatar = ?");
        if(column.equals("nume"))
            preparedStatement.setString(1, modifiedValue);
        else if(column.equals("varsta") || column.equals("salariu"))
            preparedStatement.setInt(1, Integer.parseInt(modifiedValue));
        preparedStatement.setInt(2, waiterId);

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteWaiter(int waiterId) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(DELETE_WAITER);
        preparedStatement.setInt(1, waiterId);

        return preparedStatement.executeUpdate() > 0;
    }

/////////////////////////////////////////////// MANCARE ////////////////////////////////////////////////////
    public List<Mancare> getFood() throws SQLException {
        List<Mancare> returnedList = new ArrayList<>();
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(GET_ALL_FOOD);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Mancare food = new Mancare(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5),
                    resultSet.getBoolean(6));
            returnedList.add(food);
        }
        return returnedList;
    }

    public boolean addFood(Mancare food) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(ADD_NEW_FOOD);
        preparedStatement.setString(1, food.getCategorieProdus());
        preparedStatement.setString(2, food.getNumeProdus());
        preparedStatement.setDouble(3, food.getPretProdus());
        preparedStatement.setString(4, food.getIngrediente());
        preparedStatement.setBoolean(5, food.isDePost());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateFood(String column, String modifiedValue, int mancareId) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement("UPDATE mancare SET " + column + " = ? WHERE id_mancare = ?");
        if(column.equals("categorie") || column.equals("nume") || column.equals("ingrediente"))
            preparedStatement.setString(1, modifiedValue);
        else if(column.equals("pret"))
            preparedStatement.setDouble(1, Double.parseDouble(modifiedValue));
        else if(column.equals("de_post"))
            preparedStatement.setBoolean(1, Boolean.parseBoolean(modifiedValue));
        preparedStatement.setInt(2, mancareId);

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteFood(int mancareId) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(DELETE_FOOD);
        preparedStatement.setInt(1, mancareId);

        return preparedStatement.executeUpdate() > 0;
    }

/////////////////////////////////////////////// BAUTURA ////////////////////////////////////////////////////
    public List<Bautura> getDrinks() throws SQLException {
        List<Bautura> returnedList = new ArrayList<>();
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(GET_ALL_DRINKS);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Bautura drink = new Bautura(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5),
                    resultSet.getBoolean(6));
            returnedList.add(drink);
        }
        return returnedList;
    }

    public boolean addDrink(Bautura drink) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(ADD_NEW_DRINK);
        preparedStatement.setString(1, drink.getCategorieProdus());
        preparedStatement.setString(2, drink.getNumeProdus());
        preparedStatement.setDouble(3, drink.getPretProdus());
        preparedStatement.setString(4, drink.getIngrediente());
        preparedStatement.setBoolean(5, drink.areZahar());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateDrink(String column, String modifiedValue, int bauturaId) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement("UPDATE bauturi SET " + column + " = ? WHERE id_bautura = ?");
        if(column.equals("categorie") || column.equals("nume") || column.equals("ingrediente"))
            preparedStatement.setString(1, modifiedValue);
        else if(column.equals("pret"))
            preparedStatement.setDouble(1, Double.parseDouble(modifiedValue));
        else if(column.equals("are_zahar"))
            preparedStatement.setBoolean(1, Boolean.parseBoolean(modifiedValue));
        preparedStatement.setInt(2, bauturaId);

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteDrink(int bauturaId) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(DELETE_DRINK);
        preparedStatement.setInt(1, bauturaId);

        return preparedStatement.executeUpdate() > 0;
    }

/////////////////////////////////////////////// COMENZI ////////////////////////////////////////////////////
    public List<Comanda> getOrders() throws SQLException {
        List<Comanda> returnedList = new ArrayList<>();
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(GET_ALL_ORDERS);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Comanda order = new Comanda(resultSet.getInt(1),
                    resultSet.getDouble(2),
                    resultSet.getString(3));
            returnedList.add(order);
        }
        return returnedList;
    }

    public boolean addOrder(Comanda order) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(ADD_NEW_ORDER);
        preparedStatement.setDouble(1, order.getPretComanda());
        preparedStatement.setString(2, order.getProduseComanda());

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean updateOrder(String column, String modifiedValue, int comandaId) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement("UPDATE comenzi SET " + column + " = ? WHERE id_comanda = ?");
        if(column.equals("produse"))
            preparedStatement.setString(1, modifiedValue);
        else if(column.equals("pret"))
            preparedStatement.setDouble(1, Double.parseDouble(modifiedValue));
        preparedStatement.setInt(2, comandaId);

        return preparedStatement.executeUpdate() > 0;
    }

    public boolean deleteOrder(int comandaId) throws SQLException {
        PreparedStatement preparedStatement = getDBConnection().prepareStatement(DELETE_ORDER);
        preparedStatement.setInt(1, comandaId);

        return preparedStatement.executeUpdate() > 0;
    }
}
