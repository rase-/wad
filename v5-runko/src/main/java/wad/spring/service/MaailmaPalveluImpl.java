/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author tonykovanen
 */
@Service
public class MaailmaPalveluImpl implements MaailmaPalvelu{
    private String viimeisinTieto;
    
    @Override
    @Async
    public void pyyda() {
        String string = "";
        try {
            URLConnection conn = new URL("http://t-avihavai.users.cs.helsinki.fi/slow/Service").openConnection();
            Scanner sc = new Scanner(conn.getInputStream());
            while(sc.hasNextLine()) {
                string += sc.nextLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(MaailmaPalveluImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        viimeisinTieto = string;
    }

    @Override
    public String lue() {
        return viimeisinTieto;
    }
    
}
