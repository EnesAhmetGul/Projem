/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Kullanici.kullanici;
import İlan.İlan;
import İlan.liste;
import İlan.text;
import İlan.textislemler;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Lenovo
 */
public class İlanlar extends JFrame{
    İlanlar() throws FileNotFoundException{    
        File directoryPath = new File("ilanData\\İlanlarin\\verenbilgi");
                    
        File filesList[] = directoryPath.listFiles();
                    
                    
        İlan yeniİlan = new İlan();
        liste ilkL = new liste();
        
        for(File file : filesList) {
                        try {
                            List<String> allLines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                            int i = 0;
                            for (String line : allLines) {
                                if(i == 0){
                                    yeniİlan.setilanid(line);
                                }
                                if(i == 1){
                                    yeniİlan.setilanAd(line);
                                }
                                if(i == 2){
                                    yeniİlan.setilanPosta(line);
                                }
                                if(i == 3){
                                    yeniİlan.setilanTel(line);
                                }
                                i++;
                            }
                            ilkL.Ekle(yeniİlan.getid() ,yeniİlan.getad() ,yeniİlan.gettel() ,yeniİlan.getposta());
                        } catch (IOException ex) {
                            Logger.getLogger(ilanOlustur.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
        
        }
        
        textislemler textL = new textislemler();
        
        File digerPath = new File("ilanData\\İlanlarin\\verenbilgi");
                   
        File List[] = digerPath.listFiles();
        
        for(File file : List) {
                
                textL.textEkle(file.getName());
        }
        
        
        
        İlan ilk = ilkL.ilk;
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  
        
        JFrame ilanlar=new JFrame("İlanlarım");
        
        JLabel a1;  
        a1=new JLabel("Güncel İlanlar!"); 
        a1.setFont(new Font("Serif", Font.PLAIN, 40));
        a1.setBounds(90,40, 300,50);
        ilanlar.add(a1);
        
        JTextArea İlanBil=new JTextArea();  
        İlanBil.setBounds(50,90, 300,150); 
        İlanBil.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        İlanBil.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        ilanlar.add(İlanBil);
        
        File liste = new File("ilanData\\İlanlarin\\ilantext\\1.txt");
        Scanner oku = new Scanner(liste);
        while (oku.hasNextLine()) {
            String data = oku.nextLine();
            İlanBil.setText(data+"\n");
        }
        oku.close();
        
        
        JButton c=new JButton("Geri");  
        c.setBounds(150,400,90,40);
        c.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                Anasayfa anasayfa = new Anasayfa();
                ilanlar.dispose();
                anasayfa.setVisible(true);
            }
        }); 
        
        ilanlar.add(c);
        
        JLabel kacinci,ulasin,adi,tel,posta;  
        
        kacinci=new JLabel("1");  
        kacinci.setBounds(250,250, 100,40);  

        ulasin=new JLabel("İlanverene Ulaşın!");  
        ulasin.setBounds(50,250, 140,40);  

        adi=new JLabel("Adı:" + ilk.ad);  
        adi.setBounds(50,270, 100,40);  
        
        tel=new JLabel("Tel No:" + ilk.tel);  
        tel.setBounds(50,290, 100,40); 
        
        posta=new JLabel("E-posta:" + ilk.posta);  
        posta.setBounds(50,310, 250,40); 
        
        ilanlar.add(kacinci);ilanlar.add(ulasin);ilanlar.add(adi);ilanlar.add(tel);ilanlar.add(posta);
        
        
         
        JButton sonraki=new JButton("Sonraki");  
        sonraki.setBounds(250,350,90,40);
        sonraki.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                try {
                    String a = kacinci.getText();
                    int j = Integer.parseInt(a);
                    j++;
                    kacinci.setText(String.valueOf(j));
                    
                    text text = textL.ilk;
                    int i = 1;
        
                    while(text.sonraki != null && i <= j)
                    {
                        text = text.sonraki;
                        i++;
                    }
                    
                    File snrk = new File("ilanData\\İlanlarin\\ilantext\\"+text.getId());
                    Scanner oku = new Scanner(snrk);
                    while (oku.hasNextLine()) {
                        String data = oku.nextLine();
                        İlanBil.setText(data+"\n");
                    }
                    oku.close();
                    
                    i = 1;
                    
                    İlan yeni = ilkL.ilk;
        
                    while(yeni.sonraki != null && i <= j)
                    {
                        yeni = yeni.sonraki;
                        i++;
                    }

                    adi.setText("Adı:" + yeni.ad);
                    tel.setText("Tel No:" + yeni.tel);
                    posta.setText("E-posta:" + yeni.posta);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(İlanlar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
        
        JButton onceki=new JButton("Önceki");  
        onceki.setBounds(50,350,90,40);
        onceki.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                try {
                    String a = kacinci.getText();
                    int j = Integer.parseInt(a);
                    j--;
                    kacinci.setText(String.valueOf(j));
                    
                    text text = textL.ilk;
                    int i = 1;
        
                    while(text.sonraki != null && i <= j)
                    {
                        text = text.sonraki;
                        i++;
                    }
                    
                    File snrk = new File("ilanData\\İlanlarin\\ilantext\\"+text.getId());
                    Scanner oku = new Scanner(snrk);
                    while (oku.hasNextLine()) {
                        String data = oku.nextLine();
                        İlanBil.setText(data+"\n");
                    }
                    oku.close();
                    
                    i = 1;
                    
                    İlan yeni = ilkL.ilk;
        
                    while(yeni.sonraki != null && i <= j)
                    {
                        yeni = yeni.sonraki;
                        i++;
                    }

                    adi.setText("Adı:" + yeni.ad);
                    tel.setText("Tel No:" + yeni.tel);
                    posta.setText("E-posta:" + yeni.posta);
                    
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(İlanlar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }); 
        
        JButton sil=new JButton("İlanı Sil!");  
        sil.setBounds(150,350,90,40);
        sil.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                String a = kacinci.getText();
                int j = Integer.parseInt(a);
                ilkL.listedenSil(j);
                
                textL.listedenSil(j);
            }
        }); 

        ilanlar.add(sonraki);ilanlar.add(onceki);
        
        kullanici suanki = new kullanici ();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("ilanData\\Kullanici\\aktif\\aktif.txt"));
            String line = reader.readLine();
            int i = 0;
            while (line != null) {
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
                    line = reader.readLine();
            }

                    reader.close();
            } catch (IOException e) {
                    e.printStackTrace();
            }
        
        if(suanki.ad.contentEquals("Admin")){
            ilanlar.add(sil);
        }
        
        
        ilanlar.setSize(420, 500);  
        ilanlar.setLayout(null);  
        ilanlar.setVisible(true);
    }
}
