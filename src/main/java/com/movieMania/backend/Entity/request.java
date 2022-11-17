package com.movieMania.backend.Entity;

import lombok.Data;

@Data
public class request {

    Long requestId;
    String adminStatus="pending";
    String customerName;
    String customerEmail;
    String contact;
    String code;
    String driverLink;
    String slipUrl;
    String payableStatus="notPayable";
    String adminShow="notShow";

    String multiCode="none";

    Long movieId;

    public request() {
    }

    public String getPayableStatus() {
        return payableStatus;
    }

    public void setPayableStatus(String payableStatus) {
        this.payableStatus = payableStatus;
    }

    public String getAdminShow() {
        return adminShow;
    }

    public void setAdminShow(String adminShow) {
        this.adminShow = adminShow;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public String getMultiCode() {
        return multiCode;
    }

    public void setMultiCode(String multiCode) {
        this.multiCode = multiCode;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDriverLink() {
        return driverLink;
    }

    public void setDriverLink(String driverLink) {
        this.driverLink = driverLink;
    }

    public String getSlipUrl() {
        return slipUrl;
    }

    public void setSlipUrl(String slipUrl) {
        this.slipUrl = slipUrl;
    }
}
