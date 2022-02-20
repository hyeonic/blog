package bank;

public class Franc {
    private final int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Franc franc = (Franc) object;
        return this.amount == franc.amount;
    }
}
