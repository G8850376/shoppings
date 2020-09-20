package com.pojo;

public class Logistics {
    private Integer id;//物流id
    private Integer l_id;//物流号
    private String name;//快递员姓名
    private Integer phone;//快递员电话
    private Boolean state;//状态
    private String role;//角色
    private String address;


    public Logistics() {

    }

    public Logistics(Integer id, Integer l_id, String name, Integer phone, Boolean state, String role, String address) {
        this.id = id;
        this.l_id = l_id;
        this.name = name;
        this.phone = phone;
        this.state = state;
        this.role = role;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getL_id() {
        return l_id;
    }

    public void setL_id(Integer l_id) {
        this.l_id = l_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "id=" + id +
                ", l_id=" + l_id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", state=" + state +
                ", role='" + role + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
