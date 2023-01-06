/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kullanici;

/**
 *
 * @author Lenovo
 */
public class admin extends kullanici implements Genel{
    
    @Override
    public int silmeyetkisi() {
        return 1;
    }

    @Override
    public void setTel(String tel) {
        super.setTel(tel); 
    }

    @Override
    public void setSfr(String sfr) {
        super.setSfr(sfr); 
    }

    @Override
    public void setPosta(String posta) {
        super.setPosta(posta);
    }

    @Override
    public void setId(String id) {
        super.setId(id); 
    }

    @Override
    public void setAd(String ad) {
        super.setAd(ad); 
    }

    @Override
    public String getPosta() {
        return super.getPosta(); 
    }

    @Override
    public String getSfr() {
        return super.getSfr(); 
    }

    @Override
    public String getId() {
        return super.getId(); 
    }

    @Override
    public String getTel() {
        return super.getTel(); 
    }

    @Override
    public String getAd() {
        return super.getAd(); 
    }

}
