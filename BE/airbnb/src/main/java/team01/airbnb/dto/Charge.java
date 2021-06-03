package team01.airbnb.dto;

public class Charge {
    private final int charge;

    public static Charge wons(int charge) {
        return new Charge(charge);
    }

    public Charge(int charge) {
        this.charge = charge;
    }

    public int getCharge() {
        return this.charge;
    }

    public Charge plus(Charge charge) {
        return Charge.wons(this.charge + charge.getCharge());
    }

    public Charge times(double percents) {
        return wons((int) (this.charge * percents));
    }
}
