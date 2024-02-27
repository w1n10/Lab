
package Model;


public class Fruit {
    private String Fid;
    private String Fname;
    private double Fprice;
    private int Fquantity;
    private String Forigin;

    public Fruit(String Fid, String Fname, double Fprice, int Fquantity, String Forigin) {
        this.Fid = Fid;
        this.Fname = Fname;
        this.Fprice = Fprice;
        this.Fquantity = Fquantity;
        this.Forigin = Forigin;
    }



    public String getFid() {
        return Fid;
    }

    public void setFid(String Fid) {
        this.Fid = Fid;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public double getFprice() {
        return Fprice;
    }

    public void setFprice(double Fprice) {
        this.Fprice = Fprice;
    }

    public int getFquantity() {
        return Fquantity;
    }

    public void setFquantity(int Fquantity) {
        this.Fquantity = Fquantity;
    }

    public String getForigin() {
        return Forigin;
    }

    public void setForigin(String Forigin) {
        this.Forigin = Forigin;
    }

       
        @Override
    public String toString() {
        return Fid + "," + Fname + "," + Fprice + "," + Fquantity + "," + Forigin;
    }
   
    
    public String showFruitManage(){
       return (String.format("| %-8s | %-8s | %-8s | %-8s | %-8s |",Fid,Fname,Forigin,Fprice+"$",Fquantity));

    }
    
    public String showFruitCustome(){ 
       return (String.format("| %-8s | %-8s | %-8s | %-8s |",Fid,Fname,Forigin,Fprice+"$"));
    }
}
