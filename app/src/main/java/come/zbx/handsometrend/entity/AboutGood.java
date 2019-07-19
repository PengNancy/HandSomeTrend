package come.zbx.handsometrend.entity;

public class AboutGood {
    private String img_url;
    private String tv_title;
    private String price;
    private String buy_peoplenumber;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBuy_peoplenumber() {
        return buy_peoplenumber;
    }

    public void setBuy_peoplenumber(String buy_peoplenumber) {
        this.buy_peoplenumber = buy_peoplenumber;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }
}
