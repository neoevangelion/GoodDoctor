package com.xywy.drug.engine;

/**
 * Created by eWalk_iOS on 14-8-8.
 */
public class NetworkConst {
    public static final String HOST_NAME = "http://www.xywy.com/yao/drugmobile.php";

    public static final String GET_DISEASE_LIST_QUERY = "?a=getill";

    public static final String SEARCH_MEDICINE_BY_DISEASE_QUERY = "?a=getdruglist&type=ill&id=%s&pagesize=%d&page=%d";

    public static final String SEARCH_MEDICINE_BY_KEYWORD_QUERY = "?a=searchdruglist&keywords=%s&pagesize=%d&page=%d";

    public static final String GET_MEDICINE_DETAIL_BY_ID = "?a=getdrugdetail&uuidDrug=%s";

    public static final String GET_MEDICINE_EVALUATION_BY_ID = "?a=getdrugcomment&uuidDrug=&s&num=%d";
}
