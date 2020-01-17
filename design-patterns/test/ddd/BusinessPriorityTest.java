package ddd;

import org.junit.Test;
import play.test.UnitTest;

import java.text.NumberFormat;

public class BusinessPriorityTest extends UnitTest {

    private NumberFormat oneDecimal(){
        return this.decimal(1);
    }

    private NumberFormat twoDecimals(){
        return this.decimal(2);
    }

    private NumberFormat decimal(int aNumberOfDecimals){
        NumberFormat fmt = NumberFormat.getInstance();

        fmt.setMinimumFractionDigits(aNumberOfDecimals);
        fmt.setMaximumFractionDigits(aNumberOfDecimals);

        return fmt;
    }

    @Test
    public void testCostPercentageCalculation() throws Exception{
        BusinessPriority businessPriority = new BusinessPriorityRating(2, 4, 1, 1));

        BusinessPriority businessPriorityCopy = new BusinessPriority(businessPriority);

        assertEquals(businessPriority, businessPriorityCopy);

        BusinessPriorityTotals totals = new BusinessPriorityTotals(53, 49, 53 + 49, 37, 33);

        float cost = businessPriority.contPercentage(totals);

        assertEquals(this.oneDecimal().format(cost), "2.7");

        assertEquals(businessPriority, businessPriorityCopy);
    }

    @Test
    public void testPriorityCalculation() throws Exception{
        BusinessPriority businessPriority = new BusinessPriority(new BusinessPriorityRatings(2, 4, 1, 1));

        BusinessPriority businessPriorityCopy = new BusinessPriority(businessPriority);

        assertEquals(businessPriorityCopy, businessPriority);

        BusinessPriorityTotals totals = new BusinessPriorityTotals(53, 49, 53 + 49, 37, 33);

        float calculatedPriority = businessPriority.priority(totals);

        assertEquals("1.03", this.twoDecimals().format(calculatedPriority));

        assertEquals(businessPriority, businessPriorityCopy);
    }

}
