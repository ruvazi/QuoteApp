package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SettingsTest {
    
    @Test
    public void testGetSingleProperty(){
        assertEquals("3306", Settings.getPropertyValue("db.port"));
    }
    
    @Test
    public void testGetDEV_DBConnection(){
        //This test is a little bit hacky since it uses a property that can be changed by users
        String dbName = Settings.getPropertyValue("db.database");
        assertEquals(String.format("jdbc:mysql://localhost:3306/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&&useSSL=false",dbName), Settings.getDEV_DBConnection());
    }
    
    @Test
    public void testGetTEST_DBConnection(){
        //This test is also a little bit hacky since it uses a property that can be changed by users
        String dbName = Settings.getPropertyValue("dbtest.database");
        assertEquals(String.format("jdbc:mysql://localhost:3306/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&&useSSL=false",dbName), Settings.getTEST_DBConnection());
    }
    
}
