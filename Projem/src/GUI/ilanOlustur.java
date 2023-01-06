/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import İlan.İlan;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
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
public class ilanOlustur extends JFrame{
    ilanOlustur(){ 
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  
        
        JFrame ilanolustur=new JFrame("İlan Oluştur");
        
        JLabel a1;  
        a1=new JLabel("Lütfen İlan Bilgilerini Aşağıya Girin:"); 
        a1.setFont(new Font("Serif", Font.PLAIN, 20));
        a1.setBounds(50,50, 300,50);
        ilanolustur.add(a1);
        
        JTextArea İlanBil=new JTextArea();  
        İlanBil.setBounds(50,90, 300,150); 
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        İlanBil.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        İlanBil.setColumns(8);
        İlanBil.setTabSize(WIDTH);
        İlanBil.setRows(8);
        ilanolustur.add(İlanBil);  
        
        JButton c=new JButton("Geri");  
        c.setBounds(200,295,150,30);
        c.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                Anasayfa anasayfa = new Anasayfa();
                ilanolustur.dispose();
                anasayfa.setVisible(true);
            }
        });
        
        İlan yeniİlan = new İlan();
        
        JButton b=new JButton("İlanı Yayınla!");  
        b.setBounds(50,295,150,30);
        b.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                
                try {
                    
                    String yeniid, id = null;
                    
                    String path = "ilanData\\intel\\ilanS.txt";
                    
                    InputStream is = null;
                    try {
                        is = new FileInputStream("ilanData\\intel\\ilanS.txt");
                    } catch (FileNotFoundException ex) {
                        
                    }
                    
                    try (Scanner sc = new Scanner(is, StandardCharsets.UTF_8.name())) {
                        while (sc.hasNextLine()) {
                            id = sc.nextLine();
                        }
                    }
                    int a = Integer.parseInt(id);
                    a++;
                    yeniid = String.valueOf(a);
                    
                    yeniİlan.setilanid(yeniid);
                    
                    File file1 = new File("ilanData\\intel\\ilanS.txt");
                    if (file1.exists()) {
                            FileWriter fos = new FileWriter(file1, false);
                            fos.write(yeniid);
                            fos.close();
                    }
                    
                    File directoryPath = new File("ilanData\\Kullanici\\aktif");
                    //List of all files and directories
                    File filesList[] = directoryPath.listFiles();
                    for(File file : filesList) {
                        try {
                            List<String> allLines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                            int i = 0;
                            for (String line : allLines) {
                                if(i == 0){
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
                        } catch (IOException ex) {
                            Logger.getLogger(ilanOlustur.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        
                    }
                    File yeni = new File("ilanData\\İlanlarin\\verenbilgi\\"+yeniid+".txt");
                    
                    
                    FileWriter genelYaz = new FileWriter(yeni.getAbsolutePath(), true);
                    genelYaz.write(yeniİlan.id+"\n");
                    genelYaz.write(yeniİlan.ad+"\n");
                    genelYaz.write(yeniİlan.posta+"\n");
                    genelYaz.write(yeniİlan.tel+"\n");
                    genelYaz.close();
                    
                    
                    File yeni2 = new File("ilanData\\İlanlarin\\ilantext\\"+yeniid+".txt");
                    
                    FileWriter bilgiYaz = new FileWriter(yeni2.getAbsolutePath(), true);
                    bilgiYaz.write(İlanBil.getText()+"\n");
                    bilgiYaz.close();
                } catch (IOException ex) {
                    Logger.getLogger(ilanOlustur.class.getName()).log(Level.SEVERE, null, ex);

                }
                
                Anasayfa anasayfa = new Anasayfa();
                ilanolustur.dispose();
                anasayfa.setVisible(true);
            }
           
        });
        
        ilanolustur.add(b);ilanolustur.add(c);
        
        ilanolustur.setSize(420, 400);  
        ilanolustur.setLayout(null);  
        ilanolustur.setVisible(true);
    }
}
