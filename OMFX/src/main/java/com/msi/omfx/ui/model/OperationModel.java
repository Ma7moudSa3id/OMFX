/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msi.omfx.ui.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Eng.MSI
 */
public class OperationModel {

    private final SimpleIntegerProperty no;
    private final SimpleIntegerProperty grossWeight;
    private final SimpleIntegerProperty netWeight;
    private final SimpleIntegerProperty price;
    private final SimpleIntegerProperty totalPrice;
    private final SimpleStringProperty type;
    private final SimpleStringProperty supplier;
    private final SimpleStringProperty notes;

    public OperationModel(Integer no, Integer grossWeight, Integer netWeight, Integer price, Integer totalPrice, String type, String supplier, String notes) {
        this.no = new SimpleIntegerProperty(no);
        this.grossWeight = new SimpleIntegerProperty(grossWeight);
        this.netWeight = new SimpleIntegerProperty(netWeight);
        this.price = new SimpleIntegerProperty(price);
        this.totalPrice = new SimpleIntegerProperty(totalPrice);
        this.type = new SimpleStringProperty(type);
        this.supplier = new SimpleStringProperty(supplier);
        this.notes = new SimpleStringProperty(notes);
    }

    public Integer getNo() {
        return no.get();
    }

    public void setNo(Integer no) {
        this.no.set(no);
    }

    public Integer getGrossWeight() {
        return grossWeight.get();
    }

    public void setGrossWeight(Integer grossWeight) {
        this.grossWeight.set(grossWeight);
    }

    public Integer getNetWeight() {
        return netWeight.get();
    }

    public void setNetWeight(Integer netWeight) {
        this.netWeight.set(netWeight);
    }

    public Integer getPrice() {
        return price.get();
    }

    public void setPrice(Integer price) {
        this.price.set(price);
    }

    public Integer getTotalPrice() {
        return totalPrice.get();
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    public String getSupplier() {
        return this.supplier.get();
    }

    public void setSupplier(String supplier) {
        this.supplier.set(supplier);
    }

}
