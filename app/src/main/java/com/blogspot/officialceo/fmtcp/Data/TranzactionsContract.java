package com.blogspot.officialceo.fmtcp.Data;

import android.provider.BaseColumns;

public class TranzactionsContract {

    public static final class TranzactionsEntry implements BaseColumns{

        public static final String TABLE_NAME = "tranzactions";
        public static final String COLUMN_PAYMENT_METHOD = "paymentMethod";
        public static final String COLUMN_FUND_USAGE = "fundUsage";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_DATE = "date";

    }

}
