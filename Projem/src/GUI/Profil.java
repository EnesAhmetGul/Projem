/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Kullanici.kullanici;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
public class Profil extends JFrame{
    Profil(){
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  
        
        JFrame profil=new JFrame("Profil Sayfası");
        
        JButton c=new JButton("Geri");  
        c.setBounds(50,295,150,30);
        c.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                Anasayfa anasayfa = new Anasayfa();
                profil.dispose();
                anasayfa.setVisible(true);
            }
        }); 
        
        profil.add(c);
        
        kullanici suanki = new kullanici ();
        
        JLabel l3,l4,l1,l2;  
        l1=new JLabel("Kullanıcı Adınız:");  
        l1.setBounds(50,50, 100,30);  
        l2=new JLabel("Telefon Numaranız:");  
        l2.setBounds(50,100, 130,30);  
        l3=new JLabel("E-Postanız:");  
        l3.setBounds(50,150, 100,30);  
        l4=new JLabel("Sifreniz:");  
        l4.setBounds(50,200, 100,30);
        profil.add(l1); profil.add(l2);profil.add(l3); profil.add(l4); 
        
        

        final JTextField isim=new JTextField(suanki.ad);  
        isim.setBounds(50,75, 150,25);

        final JTextField tele=new JTextField(suanki.tel);  
        tele.setBounds(50,125, 150,25);
        
        final JTextField epost=new JTextField(suanki.posta);  
        epost.setBounds(50,175, 150,25);
        
        final JTextField sifre=new JTextField(suanki.sfr);  
        sifre.setBounds(50,225, 150,25);
        
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("ilanData\\Kullanici\\aktif\\aktif.txt"));
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
                    if(i == 0){
                        suanki.setAd(line);
                        isim.setText(line);
                    }
                    if(i == 1){
                        suanki.setSfr(line);
                        sifre.setText(line);
                    }
                    if(i == 2){
                        suanki.setPosta(line);
                        epost.setText(line);
                    }
                    if(i == 3){
                        suanki.setTel(line);
                        tele.setText(line);
                    }
                    if(i == 4){
                        suanki.setId(line);
                    }
                    i++;
                    line = reader.readLine();
            }

                    reader.close();
            } catch (IOException e) {
                    e.printStackTrace();
            }
        
        JButton b1=new JButton("Bilgilerimi Güncelle!");  
        b1.setBounds(50,260,150,30);  
        b1.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){
            File file = new File("ilanData\\Kullanici\\aktif\\aktif.txt");

                try {
                    FileWriter fw = new FileWriter(file);
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
            }
            File fil = new File("ilanData\\Kullanici\\tumu\\"+suanki.getId()+".txt");

                try {
                    FileWriter fw = new FileWriter(fil);
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                FileWriter Yaz = null;
            try {
                Yaz = new FileWriter("ilanData\\Kullanici\\aktif\\aktif.txt", true);
                Yaz.write(isim.getText()+"\n");
                Yaz.write(sifre.getText()+"\n");
                Yaz.write(epost.getText()+"\n");
                Yaz.write(tele.getText()+"\n");
                Yaz.write(suanki.getId()+"\n");
                Yaz.write("0");
                Yaz.close();
            } catch (IOException ex) {
                Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    Yaz.close();
                } catch (IOException ex) {
                    Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
                FileWriter Yaz2 = null;
            try {
                Yaz2 = new FileWriter("ilanData\\Kullanici\\tumu\\"+suanki.getId()+".txt", true);
                Yaz2.write(isim.getText()+"\n");
                Yaz2.write(sifre.getText()+"\n");
                Yaz2.write(epost.getText()+"\n");
                Yaz2.write(tele.getText()+"\n");
                Yaz2.write(suanki.getId()+"\n");
                Yaz2.write("0");
                Yaz2.close();
            } catch (IOException ex) {
                Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    Yaz2.close();
                } catch (IOException ex) {
                    Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
                  
            }  
        });
        
        profil.add(b1);profil.add(isim);profil.add(tele);profil.add(epost);profil.add(sifre);profil.add(b1);
        profil.setSize(260, 410);  
        profil.setLayout(null);  
        profil.setVisible(true);
    }
}
