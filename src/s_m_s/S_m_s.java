
package s_m_s;

// imports
import interfaces.welcome;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Dasun Nethsara
 */
public class S_m_s {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // theme activation
//        FlatLightLaf.setup();
        // theme activation
        File myObj = new File("C:\\Windows\\Temp\\GravityTemp.ini");
        if (myObj.exists()) {
            try {
                try (Scanner myReader = new Scanner(myObj)) {
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        if (data.equals("Light")){
                            FlatLightLaf.setup();
                        } else if (data.equals("Dark")){
                            FlatDarkLaf.setup();
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
            }
        } else {
        }
        
        // calling the main ui
        welcome w = new welcome();
        w.setVisible(true);
        
        // connected with database_connection class
        Connection con = s_m_s.database_connection.connect();
    }
    
}
