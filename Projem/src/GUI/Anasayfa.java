/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Lenovo
 */
public class Anasayfa extends JFrame{
    Anasayfa(){
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  
        
        JFrame anasayfa=new JFrame("Anasayfa");
        
        JLabel a1;  
        a1=new JLabel("Hoşgeldiniz!"); 
        a1.setFont(new Font("Serif", Font.PLAIN, 40));
        a1.setBounds(90,50, 300,50);
        anasayfa.add(a1);
        
        JButton b1=new JButton("İlanlar");  
        b1.setBounds(85,150,100,50);  
        
        JButton b2=new JButton("Profilim");  
        b2.setBounds(200,150,100,50);
        
        JButton b3=new JButton("İlanlarım");  
        b3.setBounds(85,230,100,50);
        
        JButton b4=new JButton("İlan Ver");  
        b4.setBounds(200,230,100,50);
        
        JButton c=new JButton("Çıkış");  
        c.setBounds(140,295,100,50);
        
        b1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                try {
                    İlanlar ilanlar = new İlanlar();
                    anasayfa.dispose();
                    ilanlar.setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Anasayfa.class.getName()).log(Level.SEVERE, null, ex);
                }
		
            }
        });  
        
        b2.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                Profil profil = new Profil();  
                anasayfa.dispose();
                profil.setVisible(true);
		
            }
        }); 
        
        b3.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                try {
                    İlanlarım ilanlarım = new İlanlarım();
                    anasayfa.dispose();
                    ilanlarım.setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Anasayfa.class.getName()).log(Level.SEVERE, null, ex);
                }
		
            }
        }); 
        
        b4.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                ilanOlustur ilanolustur = new ilanOlustur();  
                anasayfa.dispose();
                ilanolustur.setVisible(true);
		
            }
        }); 
        
        c.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                File file = new File("ilanData\\Kullanici\\aktif\\aktif.txt");

                try {
                    FileWriter fw = new FileWriter(file);
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
            }
                Giriş f = new Giriş();
                anasayfa.dispose();
                f.setVisible(true);
            }
        }); 
        
        anasayfa.add(b4);anasayfa.add(b3);anasayfa.add(b2);anasayfa.add(b1);anasayfa.add(c);
        
        anasayfa.setSize(400, 440);  
        anasayfa.setLayout(null);  
        anasayfa.setVisible(true);
    }
}
