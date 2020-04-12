public class proses{
    double saldo=0;
    public proses(double saldo){
        this.saldo = saldo;
    }
    public proses(double saldo, double am){
        this.saldo -= am;   
    }
    public proses(double saldo, double am, double ts){
        this.saldo += ts;
    }
}