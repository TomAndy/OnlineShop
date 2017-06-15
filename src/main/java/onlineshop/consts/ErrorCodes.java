package onlineshop.consts;

public class ErrorCodes {

    /*Generic errors*/
    public static final String GEN_ERR = "GEN_ERR_100";

    /*DB errors*/
    public static final String DB_SQL_ERR = "DB_ERR_100";
    public static final String DB_CONN_ERR = "DB_ERR_200";
    public static final String DB_GEN_ERR = "DB_ERR_300";
    public static final String DB_TABLE_ERROR = "DB_ERR_400";

    /*Validation errors*/
    public static final String VAL_ERR = "VAL_ERR_100";

    private ErrorCodes() {
    }
}
