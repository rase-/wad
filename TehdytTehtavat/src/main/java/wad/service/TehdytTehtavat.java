/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Service;

/**
 *
 * @author tonykovanen
 */
@Service
public class TehdytTehtavat {
    private String opnro = "";
    
    
    public void setOpnro(String nro) {
        opnro = nro;
    }
    
    private String getResponseBody(String url) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        try {
            HttpResponse response = httpclient.execute(httpget);
            return readInputStream(response.getEntity().getContent());
        } catch (IOException ex) {
            Logger.getLogger(TehdytTehtavat.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private String readInputStream(InputStream is) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(is);
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append("\n");
        }

        return sb.toString();
    }
    public String annaSisalto() {
        String sisalto = getResponseBody("http://t-avihavai.users.cs.helsinki.fi/tehdyt/" + opnro);
        return sisalto;
    }
}
