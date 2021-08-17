package com.twu.refactoring;

import java.util.List;

public class Order {
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String getLineItemsString() {
        StringBuilder result = new StringBuilder();
        for (LineItem lineItem : this.getLineItems()) {
            result.append(lineItem.getDescription())
                    .append('\t')
                    .append(lineItem.getPrice())
                    .append('\t')
                    .append(lineItem.getQuantity())
                    .append('\t')
                    .append(lineItem.totalAmount())
                    .append('\n');
        }
        return result.toString();
    }

    public String getTotSaleTax() {
        double totSalesTx = 0d;
        for (LineItem lineItem : this.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;
        }
        return "Sales Tax\t" + totSalesTx;
    }

    public String getTotalAmount() {
        double totalAmount = 0d;
        for (LineItem lineItem : this.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totalAmount += lineItem.totalAmount() + salesTax;
        }
        return "Total Amount\t" + totalAmount;
    }
}
