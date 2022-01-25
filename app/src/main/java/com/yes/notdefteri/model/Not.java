package com.yes.notdefteri.model;

public class Not {

        private String baslik;
        private String icerik;
        private String fav;
        private String renk;
        private String check;

        public Not(){}

    public Not(String baslik, String icerik, String fav, String renk,String check) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.fav = fav;
        this.renk = renk;
        this.check = check;

    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
}
