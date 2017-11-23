package com.hxqh.eam.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/20.
 */
public class ComplaintData {

    private Map<String, List<BigDecimal>> listM;

    private Map<String, List<BigDecimal>> listUN;

    private List<String> listTime;


    public Map<String, List<BigDecimal>> getlistUN() {
        return listUN;
    }

    public void setlistUN(Map<String, List<BigDecimal>> listUN) {
        this.listUN = listUN;
    }

   /* public ComplaintData(Map<String, List<BigDecimal>> listM,Map<String, List<BigDecimal>> listUN) {
        this.listM = listM;
        this.listUN = listUN;

    }*/

    public ComplaintData(Map<String, List<BigDecimal>> listM, Map<String, List<BigDecimal>> listUN, List<String> listTime) {
        this.listM = listM;
        this.listUN = listUN;
        this.listTime = listTime;
    }

    public Map<String, List<BigDecimal>> getListM() {
        return listM;
    }

    public void setListM(Map<String, List<BigDecimal>> listM) {
        this.listM = listM;
    }

    public List<String> getListTime() {
        return listTime;
    }

    public void setListTime(List<String> listTime) {
        this.listTime = listTime;
    }
}
