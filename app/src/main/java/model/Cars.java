package model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Cars")
public class Cars extends ParseObject {
    // Ensure that your subclass has a public default constructor

    public static final String username = "username";
    public static final String Importadora = "importadora";
    public static final String VIN = "VIN";

    // Ensure that your subclass has a public default constructor
    public Cars() {
        super();
    }

    // Add a constructor that contains core properties
    public Cars(String VIN) {
        super();
        getVIN(VIN);
        getImportadora(Importadora);
    }

    public ParseUser getUsername() {
        return getParseUser(username);
    }

    public void setUsername(ParseUser username) {
        put("OWNER", username);
    }

    // Use getString and others to access fields
    public void getVIN(String VIN) {
        getString("VIN");
    }

    public void getImportadora(String Importadora) {
        getString("Importadora");
    }


    // Get the user for this item
    public ParseUser getUser() {
        return getParseUser("user");
    }

    // Associate each item with a user
    public void setOwner(ParseUser user) {
        put("owner", user);
    }
}

