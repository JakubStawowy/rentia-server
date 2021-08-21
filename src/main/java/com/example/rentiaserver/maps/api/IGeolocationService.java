package com.example.rentiaserver.maps.api;

public interface IGeolocationService {
    double getHalfwayPoint(double firstCoordinate, double secondCoordinate);
    long getZoomLevel(double fromLongitude, double toLongitude, int mapWidth);
}
