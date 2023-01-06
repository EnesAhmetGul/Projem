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
public class textislemler {
    public text ilk = null;
    public text son = null;
    
    public void textEkle(String id)
    {
        text yenitext = new text();
        yenitext.setId(id);
        
        yenitext.sonraki = null;
        
        text son = ilk;
        
        if(ilk == null)
        {
            yenitext.onceki = null;
            ilk = yenitext;
            return;
        }
        
        while(son.sonraki!= null)
        {
            son = son.sonraki;
        }
        
        son.sonraki = yenitext;
        yenitext.onceki = son;
        
    }
    
    public İlan listedenSil(int i){
        text yeni = ilk;
        text nnn = yeni;
        if(ilk == null)
            return null;
        else
        {
            do{
                text sonrakiDugum = yeni.sonraki;
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
                        
                        File myObj = new File("ilanData\\İlanlarin\\ilantext\\"+nnn.id+".txt"); 
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
