/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package İlan;


/**
 *
 * @author Lenovo
 */
public class İlan {
    public String id;
    public String ad;
    public String tel;
    public String posta;
    
    public İlan sonraki;
    public İlan onceki;
    
    public void setilanid(String id){
        this.id = id;
    }

    public void setilanAd(String ad) {
        this.ad = ad;
    }

    public void setilanTel(String tel) {
        this.tel = tel;
    }

    public void setilanPosta(String posta) {
        this.posta = posta;
    }
    
    public String getid(){
        return id;
    }
    
    public String getad(){
        return ad;
    }
    
    public String gettel(){
        return tel;
    }
    
    public String getposta(){
        return posta;
    }
}
