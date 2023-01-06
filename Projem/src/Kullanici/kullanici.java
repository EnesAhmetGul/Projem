/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kullanici;

/**
 *
 * @author Lenovo
 */
public class kullanici implements Genel{
    public String ad;
    public String sfr;
    public String tel;
    public String posta;
    public String id;
    
    @Override
    public int silmeyetkisi() {
        return 0;
    }

    @Override
    public String getAd() {
        return ad;
    }

    @Override
    public void setAd(String ad) {
        this.ad = ad;
    }

    @Override
    public String getSfr() {
        return sfr;
    }

    @Override
    public void setSfr(String sfr) {
        this.sfr = sfr;
    }

    @Override
    public String getTel() {
        return tel;
    }

    @Override
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String getPosta() {
        return posta;
    }

    @Override
    public void setPosta(String posta) {
        this.posta = posta;
    }
    
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    
}
