package GUI;

import javax.swing.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
  
class Kayit extends JFrame {  
    
    Kayit() {  
        File file = new File("ilanData\\Kullanici\\aktif\\aktif.txt");

            try {
                FileWriter fw = new FileWriter(file);
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        JFrame kayit=new JFrame("Kayıt Ol");  
        
        JLabel l3,l4,l1,l2;  
        l1=new JLabel("Kullanıcı Adı:");  
        l1.setBounds(50,50, 100,30);  
        l2=new JLabel("Telefon Numarası:");  
        l2.setBounds(50,100, 130,30);  
        l3=new JLabel("E-Posta:");  
        l3.setBounds(50,150, 100,30);  
        l4=new JLabel("Sifre:");  
        l4.setBounds(50,200, 100,30);
        kayit.add(l1); kayit.add(l2);kayit.add(l3); kayit.add(l4); 

        final JTextField ad=new JTextField();  
        ad.setBounds(50,75, 150,25);

        final JTextField tel=new JTextField();  
        tel.setBounds(50,125, 150,25);
        
        final JTextField ep=new JTextField();  
        ep.setBounds(50,175, 150,25);
        
        final JTextField sfr=new JTextField();  
        sfr.setBounds(50,225, 150,25);

        JButton b1=new JButton("Kaydol!");  
        b1.setBounds(50,260,150,30);  
        b1.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){
            
            String yeniid, id = null;
       
            String path = "ilanData\\intel\\id.txt";

            InputStream is = null;
            try {
                is = new FileInputStream("ilanData\\intel\\id.txt");
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
            
            File file = new File("ilanData\\intel\\id.txt");
            if (file.exists()) {
                    FileWriter fos = null;
                try {
                    fos = new FileWriter(file, false);
                    fos.write(yeniid);
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fos.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            System.out.println(yeniid);

            if(ad.getText().contentEquals("Admin")){
                try {
                FileWriter ozelYaz = new FileWriter("ilanData\\Kullanici\\aktif\\aktif.txt", true);
                ozelYaz.write(ad.getText()+"\n");
                ozelYaz.write(sfr.getText()+"\n");
                ozelYaz.write(tel.getText()+"\n");
                ozelYaz.write(ep.getText()+"\n");
                ozelYaz.write(yeniid+"\n");
                ozelYaz.write("1");
                ozelYaz.close();
                
                File yeni = new File("ilanData\\Kullanici\\tumu\\"+yeniid+".txt");
                
                  
                FileWriter genelYaz = new FileWriter(yeni.getAbsolutePath(), true);
                genelYaz.write(ad.getText()+"\n");
                genelYaz.write(sfr.getText()+"\n");
                genelYaz.write(tel.getText()+"\n");
                genelYaz.write(ep.getText()+"\n");
                genelYaz.write(yeniid+"\n");
                genelYaz.write("1");
                genelYaz.close();
            } catch (IOException ex) {
//                System.out.println("Bir Hata Oldu!");

            }
            
            
            }
        
            else {
                try {
                FileWriter ozelYaz = new FileWriter("ilanData\\Kullanici\\aktif\\aktif.txt", true);
                ozelYaz.write(ad.getText()+"\n");
                ozelYaz.write(sfr.getText()+"\n");
                ozelYaz.write(tel.getText()+"\n");
                ozelYaz.write(ep.getText()+"\n");
                ozelYaz.write(yeniid+"\n");
                ozelYaz.write("0");
                ozelYaz.close();
                
                File yeni = new File("ilanData\\Kullanici\\tumu\\"+yeniid+".txt");
                
                  
                FileWriter genelYaz = new FileWriter(yeni.getAbsolutePath(), true);
                genelYaz.write(ad.getText()+"\n");
                genelYaz.write(sfr.getText()+"\n");
                genelYaz.write(tel.getText()+"\n");
                genelYaz.write(ep.getText()+"\n");
                genelYaz.write(yeniid+"\n");
                genelYaz.write("0");
                genelYaz.close();
            } catch (IOException ex) {
//                System.out.println("Bir Hata Oldu!");

            }
            
            
            }
                Anasayfa anasayfa = new Anasayfa();
                kayit.dispose();
                anasayfa.setVisible(true);
//                  
            }  
        });
        
        JButton c=new JButton("Geri");  
        c.setBounds(50,295,150,30);
        c.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                Giriş f = new Giriş();
                kayit.dispose();
                f.setVisible(true);
            }
        }); 
        
        kayit.add(c);
        
        kayit.setSize(260, 400);  
        kayit.setLayout(null);  
        kayit.setVisible(true);
        kayit.add(b1);kayit.add(ad);kayit.add(tel);kayit.add(ep);kayit.add(sfr);kayit.add(b1);   
    }  
}  
