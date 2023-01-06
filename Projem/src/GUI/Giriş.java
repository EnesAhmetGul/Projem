/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Kullanici.kullanici;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Lenovo
 */
public class Giriş extends JFrame{
    Giriş(){
        File file = new File("ilanData\\Kullanici\\aktif\\aktif.txt");

            try {
                FileWriter fw = new FileWriter(file);
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        JFrame f=new JFrame("GİRİŞ");  
    
        JLabel l1,l2;  
        l1=new JLabel("Kullanıcı Adı:");  
        l1.setBounds(50,50, 100,30);  
        l2=new JLabel("Sifre:");  
        l2.setBounds(50,100, 100,30);  
        f.add(l1); f.add(l2); 

        final JTextField isim=new JTextField();  
        isim.setBounds(50,75, 150,25);

        final JTextField sifre=new JTextField();  
        sifre.setBounds(50,125, 150,25);
        
        kullanici suanki = new kullanici ();

        JButton b1=new JButton("Giriş");  
        b1.setBounds(50,155,95,30); 
    
        JButton b2=new JButton("Kaydol"); 
        b2.setBounds(50,190,95,30);  
            
    f.setSize(300,300);  
    f.setLayout(null);  
    f.setVisible(true);
    f.add(b1);f.add(isim);f.add(sifre);f.add(b2);  
    
    b1.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent a){ 
            
        
              File directoryPath = new File("ilanData\\Kullanici\\tumu");
              
              File filesList[] = directoryPath.listFiles();
              for(File file : filesList) {
                 
                try {
			List<String> allLines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                        int i = 0;
			for (String line : allLines) {
				if(i == 0){
                                suanki.setAd(line);
                                }
                                if(i == 1){
                                suanki.setSfr(line);
                                }
                                if(i == 2){
                                suanki.setPosta(line);
                                }
                                if(i == 3){
                                suanki.setTel(line);
                                }
                                if(i == 4){
                                suanki.setId(line);
                                }
                                i++;
                        }
                        
                     
                        
                        if(suanki.ad.equals(isim.getText()) && suanki.sfr.equals(sifre.getText())){
                            
                            FileWriter aktifYaz = new FileWriter("ilanData\\Kullanici\\aktif\\aktif.txt", true);
                            aktifYaz.write(suanki.getAd()+"\n");
                            aktifYaz.write(suanki.getSfr()+"\n");
                            aktifYaz.write(suanki.getPosta()+"\n");
                            aktifYaz.write(suanki.getTel()+"\n");
                            aktifYaz.write(suanki.getId()+"\n");
                            aktifYaz.write("0");
                            aktifYaz.close();    
                            
                                Anasayfa anasayfa = new Anasayfa();  
                                f.dispose();
                                anasayfa.setVisible(true);
                        }
                        
		} catch (IOException e) {
			e.printStackTrace();
		}
            
            }
        
       }
    });
    
    b2.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent a){ 
            
        Kayit kayit = new Kayit();  
        f.dispose();
        kayit.setVisible(true);
        
       } 
    });
}   
}

