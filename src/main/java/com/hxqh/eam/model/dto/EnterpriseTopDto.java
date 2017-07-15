package com.hxqh.eam.model.dto;

import com.hxqh.eam.model.view.VEnterpriseTicket;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/11.
 */

public class EnterpriseTopDto {

    private List<VEnterpriseTicket> rightnowList;
    private List<VEnterpriseTicket> proactiveList;

    private List<String> nameList;

    private Map<String, List<Integer>> rightnowTicketM;

    private Map<String, List<Integer>> proactiveTicketM;

    private EnterpriseThreeColor threeColor;

    private String name;

    private List<EnterpriseIconDto> iconList;

    private List<EnterpriseEventDto> eventList;

    private Map<String, List<Integer>> enterprise6M;

    private Map<String, List<Integer>> enterprise7M;

    private List<String> nRegionProductList;

    public EnterpriseTopDto() {
    }

    public EnterpriseTopDto(List<VEnterpriseTicket> rightnowList, List<VEnterpriseTicket> proactiveList, List<String> nameList, Map<String, List<Integer>> rightnowTicketM, Map<String, List<Integer>> proactiveTicketM, EnterpriseThreeColor threeColor, String name, List<EnterpriseIconDto> iconList, List<EnterpriseEventDto> eventList, Map<String, List<Integer>> enterprise6M, Map<String, List<Integer>> enterprise7M, List<String> nRegionProductList) {
        this.rightnowList = rightnowList;
        this.proactiveList = proactiveList;
        this.nameList = nameList;
        this.rightnowTicketM = rightnowTicketM;
        this.proactiveTicketM = proactiveTicketM;
        this.threeColor = threeColor;
        this.name = name;
        this.iconList = iconList;
        this.eventList = eventList;
        this.enterprise6M = enterprise6M;
        this.enterprise7M = enterprise7M;
        this.nRegionProductList = nRegionProductList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VEnterpriseTicket> getRightnowList() {
        return rightnowList;
    }

    public void setRightnowList(List<VEnterpriseTicket> rightnowList) {
        this.rightnowList = rightnowList;
    }

    public List<VEnterpriseTicket> getProactiveList() {
        return proactiveList;
    }

    public void setProactiveList(List<VEnterpriseTicket> proactiveList) {
        this.proactiveList = proactiveList;
    }


    public Map<String, List<Integer>> getRightnowTicketM() {
        return rightnowTicketM;
    }

    public void setRightnowTicketM(Map<String, List<Integer>> rightnowTicketM) {
        this.rightnowTicketM = rightnowTicketM;
    }

    public Map<String, List<Integer>> getProactiveTicketM() {
        return proactiveTicketM;
    }

    public void setProactiveTicketM(Map<String, List<Integer>> proactiveTicketM) {
        this.proactiveTicketM = proactiveTicketM;
    }

    public EnterpriseThreeColor getThreeColor() {
        return threeColor;
    }

    public void setThreeColor(EnterpriseThreeColor threeColor) {
        this.threeColor = threeColor;
    }

    public List<EnterpriseIconDto> getIconList() {
        return iconList;
    }

    public void setIconList(List<EnterpriseIconDto> iconList) {
        this.iconList = iconList;
    }

    public List<EnterpriseEventDto> getEventList() {
        return eventList;
    }

    public void setEventList(List<EnterpriseEventDto> eventList) {
        this.eventList = eventList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public Map<String, List<Integer>> getEnterprise6M() {
        return enterprise6M;
    }

    public void setEnterprise6M(Map<String, List<Integer>> enterprise6M) {
        this.enterprise6M = enterprise6M;
    }

    public Map<String, List<Integer>> getEnterprise7M() {
        return enterprise7M;
    }

    public void setEnterprise7M(Map<String, List<Integer>> enterprise7M) {
        this.enterprise7M = enterprise7M;
    }

    public List<String> getnRegionProductList() {
        return nRegionProductList;
    }

    public void setnRegionProductList(List<String> nRegionProductList) {
        this.nRegionProductList = nRegionProductList;
    }
}
