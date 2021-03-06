package hu.progtech.bead;

import java.lang.invoke.VarHandle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CelestialBodiesCRUD {
    static ArrayList<Galaxy> galaxies;
    static ArrayList<Star> stars;
    static ArrayList<Planet> planets;
    static MySQLConnection mySQLConnection;

    public static ArrayList<String> select(String type,String universe_id) throws SQLException {
        mySQLConnection = new MySQLConnection();
        String sql = "SELECT * FROM "+ type +" WHERE universe_id="+universe_id;
        Statement statement = mySQLConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        ArrayList<String> data = new ArrayList<>();

        if (type.equals("galaxies")) {
            galaxies = new ArrayList<>();
        }
        else if(type.equals("stars")){
            stars = new ArrayList<>();
        }
        else if(type.equals("planets")){
            planets = new ArrayList<>();
        }

        while(result.next()){
            String id = result.getString("id");
            String name = result.getString("name");
            String diameter = result.getString("diameter");
            String mass = result.getString("mass");

            data.add(name);

            if (type.equals("galaxies")) {
                String numberOfStars = result.getString("numberOfStars");
                galaxies.add(new Galaxy(id,name,diameter,mass,numberOfStars,universe_id));
            }

            else if (type.equals("stars")) {
                String brightness = result.getString("brightness");
                stars.add(new Star(id,name,diameter,mass,brightness,universe_id));
            }
            else if (type.equals("planets")) {
                String orbitalPeriod = result.getString("orbitalPeriod");
                planets.add(new Planet(id,name,diameter,mass,orbitalPeriod,universe_id));
            }
        }
        statement.close();
        mySQLConnection.close();
        return data;
    }
    public static void insert(String type,String universe_id,String[] values) throws SQLException {
        mySQLConnection = new MySQLConnection();
        String sql = "INSERT INTO universe."+type +" VALUES (NULL, ? , ?, ?, ?, ?)";
        PreparedStatement statement = mySQLConnection.prepareStatement(sql);
        statement.setString(1, values[0]);
        statement.setString(2,values[1]);
        statement.setString(3, values[2]);
        statement.setString(4,values[3]);
        statement.setString(5,universe_id);
        System.out.println(statement.executeUpdate());

        statement.close();
        mySQLConnection.close();
    }
    public static void update(String type,String universe_id,String[] values,String id) throws SQLException {
        mySQLConnection = new MySQLConnection();
        String sql = "";
        if(type.equals("planets")){
             sql = "UPDATE " + type + " SET `name` = ?, `diameter` = ?, `mass` = ?," +
                    " `orbitalPeriod` = ?, `universe_id` = ? WHERE `id` = ?;";
        }
        else if(type.equals("stars")){
             sql = "UPDATE " + type + " SET `name` = ?, `diameter` = ?, `mass` = ?," +
                    " `brightness` = ?, `universe_id` = ? WHERE `id` = ?;";
        }
        else if(type.equals("galaxies")){
             sql = "UPDATE " + type + " SET `name` = ?, `diameter` = ?, `mass` = ?," +
                    " `numberOfStars` = ?, `universe_id` = ? WHERE `id` = ?;";
        }
        PreparedStatement statement = mySQLConnection.prepareStatement(sql);
        statement.setString(1, values[0]);
        statement.setString(2,values[1]);
        statement.setString(3, values[2]);
        statement.setString(4,values[3]);
        statement.setString(5,universe_id);
        statement.setString(6,id);
        System.out.println(statement.executeUpdate());

        statement.close();
        mySQLConnection.close();
    }
    public static void delete(String type, String id) throws SQLException {
        mySQLConnection = new MySQLConnection();
        String sql = "DELETE FROM " + type + " WHERE id = ?;";
        PreparedStatement statement = mySQLConnection.prepareStatement(sql);
        statement.setString(1,id);
        System.out.println(statement.executeUpdate());

        statement.close();
        mySQLConnection.close();
    }
}
