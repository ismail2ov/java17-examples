package com.github.ismail2ov;

sealed interface Driveable permits Motorcycle, Vehicle {

}

public sealed class Vehicle implements Driveable permits Car {

}

sealed class Car extends Vehicle permits GasolineCar, DieselCar, HybridCar {

}

final class GasolineCar extends Car {

}

final class DieselCar extends Car {

}

final class HybridCar extends Car {

}

non-sealed class Motorcycle implements Driveable {}

class Scooter extends Motorcycle {}