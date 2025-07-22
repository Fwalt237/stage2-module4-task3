package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        double square = event.getSource().getSideA()*event.getSource().getSideB();
        double perimeter = 2.0 * event.getSource().getSideA() + 2.0 * event.getSource().getSideB();
        RectangleValues rv = new RectangleValues(square, perimeter);

        Integer rectangleId = event.getSource().getId();

        RectangleWarehouse.getInstance().put(rectangleId, rv);

    }
    // Write your code here!

}
