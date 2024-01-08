public class room implements reservation{
    private int number;
    private int bedcount;
    private double price;

    public room(int number,int bedcount,double price)
    {
        this.number=number;
        this.bedcount=bedcount;
        this.price=price;
    }

    public int getNumber() {
        return number;
    }

    public int getBedcount() {
        return bedcount;
    }

    public double getPrice() {
        return price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBedcount(int bedcount) {
        this.bedcount = bedcount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String reserve() {
        return null;
    }

    @Override
    public String Return() {
        return null;
    }
}
