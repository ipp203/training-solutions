package staticattrmeth;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankTransaction {

    private static final long MIN_TRX_VALUE = 1;
    private static final long MAX_TRX_VALUE = 10_000_000;

    private long trxValue;
    private static int trxCounter;
    private static BigDecimal sumOfTrxs;
    private static long currentMinValue;
    private static long currentMaxValue;


    public BankTransaction(long trxValue) {
        if (trxValue < MIN_TRX_VALUE || trxValue > MAX_TRX_VALUE) {
            throw new IllegalArgumentException("The value is out of min - max bounds");
        }

        this.trxValue = trxValue;
        if (trxCounter == 0) {
            currentMinValue = trxValue;
            currentMaxValue = trxValue;
        } else {
            currentMinValue = Math.min(currentMinValue, trxValue);
            currentMaxValue = Math.max(currentMaxValue, trxValue);
        }
        trxCounter++;
        sumOfTrxs = sumOfTrxs.add(BigDecimal.valueOf(trxValue));
    }

    public long getTrxValue() {
        return trxValue;
    }

    public static long getCurrentMinValue() {
        return currentMinValue;
    }

    public static long getCurrentMaxValue() {
        return currentMaxValue;
    }

    public static BigDecimal getSumOfTrxs() {
        return sumOfTrxs;
    }

    public static void initTheDay() {
        sumOfTrxs = new BigDecimal(0);
        currentMinValue = 0;
        currentMaxValue = 0;
        trxCounter = 0;
    }

    public static BigDecimal averageOfTransaction() {
        if (trxCounter > 0) {
            return sumOfTrxs.divide(BigDecimal.valueOf(trxCounter), RoundingMode.HALF_DOWN);
        }
        return new BigDecimal(0);
    }

}
