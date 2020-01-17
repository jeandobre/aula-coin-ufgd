package ddd;

import java.util.Objects;

public final class BusinessPriority {

    private BusinessPriorityRatings ratings;

    public BusinessPriority(BusinessPriorityRatings ratings) {
        this.setRatings(ratings);
        this.initialize();
    }

    public BusinessPriority(BusinessPriority aBussinessPriority) {
        this(aBussinessPriority.ratings);
    }

    private void initialize(){

    }

    public void setRatings(BusinessPriorityRatings aRatings) {
        if(aRatings == null){
            throw new IllegalArgumentException("The ratings are required");
        }
        this.ratings = aRatings;
    }

    public BusinessPriorityRatings ratings() {
        return ratings;
    }

    public float costPercentage(BusinessPriorityTotals aTotals){
        return (float) 100 * this.ratings().cost() / aTotals.totalCost();
    }

    public float priority(BusinessPriorityTotals aTotals){
        return this.valuePercentage(aTotals) / (this.costPercentage(aTotals) + this.riskPercentage(atotals));
    }

    public float riskPercentage(BusinessPriorityTotals aTotals){
        return (float) 100 * this.ratings().risk() /
                aTotals.totalRisk();
    }

    public float totalValue(){
        return this.ratings().benefit() + this.ratings().penalty();
    }

    public float valuePercentage(BusinessPriorityTotals aTotals){
        return (float) 100 * this.totalValue() / aTotals.totalValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessPriority that = (BusinessPriority) o;
        return Objects.equals(this.ratings(), that.ratings());
    }

    @Override
    public int hashCode() {
        int hashCodeValue = (169065 * 179) + this.ratings().hashCode();

        return hashCodeValue;
    }

    @Override
    public String toString() {
        return "BusinessPriority" +
                " ratings = " + this.ratings();
    }
}
