package com.pojo;

public class Order {
    private Integer id;
    private Integer d_id;
    private Boolean d_state ;
    private String information;
    private String d_name;
    private String d_role;
    private String address;


    public Order() {
    }

    public Order(Integer id, Integer d_id, Boolean d_state, String information, String d_name, String d_role, String address) {
        this.id = id;
        this.d_id = d_id;
        this.d_state = d_state;
        this.information = information;
        this.d_name = d_name;
        this.d_role = d_role;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public Boolean getD_state() {
        return d_state;
    }

    public void setD_state(Boolean d_state) {
        this.d_state = d_state;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_role() {
        return d_role;
    }

    public void setD_role(String d_role) {
        this.d_role = d_role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", d_id=" + d_id +
                ", d_state=" + d_state +
                ", information='" + information + '\'' +
                ", d_name='" + d_name + '\'' +
                ", d_role='" + d_role + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
