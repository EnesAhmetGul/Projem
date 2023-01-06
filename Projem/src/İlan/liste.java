/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package İlan;

import java.io.File;

/**
 *
 * @author Lenovo
 */
public class liste {
    public İlan ilk = null;
    public İlan son = null;
    
    public void Ekle(String id,String ad,String tel,String posta)
    {
        İlan yeniİlan = new İlan();
        yeniİlan.setilanid(id);
        yeniİlan.setilanAd(ad);
        yeniİlan.setilanTel(tel);
        yeniİlan.setilanPosta(posta);
        
        yeniİlan.sonraki = null;
        
        İlan son = ilk;
        
        if(ilk == null)
        {
            yeniİlan.onceki = null;
            ilk = yeniİlan;
            return;
        }
        
        while(son.sonraki!= null)
        {
            son = son.sonraki;
        }
        
        son.sonraki = yeniİlan;
        yeniİlan.onceki = son;
        
    }

    public İlan listedenSil(int i){
        İlan yeni = ilk;
        İlan nnn = yeni;
        if(ilk == null)
            return null;
        else
        {
            do{
                İlan sonrakiDugum = yeni.sonraki;
                i--;
                if(yeni.sonraki != null && i == 0)
                {
                    if(ilk == son)
                    {
                        ilk = null;
                        son = null;
                    }
                    else
                    {
                        nnn = yeni.sonraki;
                        
                        File myObj = new File("ilanData\\İlanlarin\\verenbilgi\\"+nnn.id+".txt"); 
                        if (myObj.delete()) { 
                          
                        } else {
                          
                        } 
                        
                        yeni.sonraki = sonrakiDugum.sonraki;
                        
                        if(ilk == sonrakiDugum)
                        {
                            ilk = ilk.sonraki;
                        }
                        if(son == sonrakiDugum)
                        {
                            son = yeni;
                        }
                        
                    }
                }
                
                yeni = sonrakiDugum;
                
            }
            while(yeni != null);
            
            
        }

        return null;

    }
    
    
    
}
