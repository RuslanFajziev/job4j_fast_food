package service;

import domain.model.Courier;

public interface CourierManagement {
    boolean addOrderCourier(Courier courier);

    Courier assignCurrentCoordinates(int latitude, int longitude);
}