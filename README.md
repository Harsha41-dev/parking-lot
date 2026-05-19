# Parking Lot Management System - LLD v1

Java console implementation of a Parking Lot Low Level Design problem.

This version models the core parking flow using separate classes for vehicles, slots, floors, tickets, billing, display, and parking logic.

## Problem Statement

Design and implement a parking lot management system that can assign available parking slots to incoming vehicles and release those slots when vehicles leave.

The system should support multiple floors, vehicle-specific slot types, ticket generation, vehicle exit handling, fee calculation, and availability display. Each vehicle should be parked only in a compatible slot, and each active ticket should track the vehicle, parking location, entry time, exit time, and status.

The design should remain easy to extend. Adding a new vehicle type, slot allocation strategy, or pricing rule should require minimal changes to the main parking lot logic.

## Features

- Park bikes, cars, and trucks
- Support multiple parking floors
- Support different slot types
- Generate a parking ticket
- Remove a vehicle using ticket id
- Calculate parking fee
- Show available slots
- Use simple strategy interfaces for slot selection and fee calculation

## How To Run

Open terminal in this folder and run:

```bash
javac ParkingLotDemo.java
java ParkingLotDemo
```

`ParkingLotDemo.java` uses the other classes, so `javac` will compile the required files automatically.

## Project Structure

```text
parking-lot
|-- ParkingLotDemo.java
|-- ParkingLot.java
|-- ParkingFloor.java
|-- ParkingSlot.java
|-- ParkingLocation.java
|-- Ticket.java
|-- ParkingBill.java
|-- ParkingDisplay.java
|-- Vehicle.java
|-- Bike.java
|-- Car.java
|-- Truck.java
|-- VehicleType.java
|-- FeeCalculator.java
|-- SimpleFeeCalculator.java
|-- SlotSelectionStrategy.java
|-- FirstAvailableSlotStrategy.java
```

## Main Classes

### ParkingLotDemo

Entry point for running the demo.

Creates:

- parking lot
- floors
- slots
- vehicles
- fee calculator
- slot selection strategy

Parks vehicles, removes one vehicle, and prints available slots.

### ParkingLot

Handles parking operations.

Responsibilities:

- adding floors
- parking vehicles
- removing vehicles
- creating tickets
- creating parking bills

Fee calculation and slot search are delegated to separate interfaces.

### ParkingFloor

One floor in the parking lot. Contains parking slots.

### ParkingSlot

One parking slot.

Fields:

- slot number
- allowed vehicle type
- occupied/free status
- parked vehicle

### Vehicle, Bike, Car, Truck

`Vehicle` is an abstract parent class.

`Bike`, `Car`, and `Truck` are concrete vehicle classes.

New vehicle types can be added by extending `Vehicle`.

### Ticket

Stores parking ticket details:

- ticket id
- vehicle
- floor number
- slot
- entry time
- exit time
- active status

Ticket only stores ticket-related data. It does not calculate the fee.

### ParkingBill

Stores the final bill after a vehicle exits.

It has:

- ticket
- amount

### ParkingDisplay

Handles printing output to the console.

Parking logic and console output are kept separate.

## Strategy Interfaces

### SlotSelectionStrategy

Contract for selecting a parking slot.

Implemented by:

- `FirstAvailableSlotStrategy`

Finds the first free slot that matches the vehicle type.

Other strategies can be added later:

- nearest slot strategy
- floor-wise priority strategy
- random slot strategy

`ParkingLot` does not need to change for a new strategy.

### FeeCalculator

Contract for calculating parking fee.

Implemented by:

- `SimpleFeeCalculator`

Current prices:

| Vehicle Type | Price Per Hour |
| ------------ | -------------- |
| BIKE         | Rs. 10         |
| CAR          | Rs. 20         |
| TRUCK        | Rs. 50         |

Other fee calculators can be added later:

- weekend fee calculator
- mall customer discount calculator
- first hour free calculator

`ParkingLot` does not need to change for a new fee rule.

## Parking Flow

1. User creates a vehicle.
2. `ParkingLot` asks `SlotSelectionStrategy` to find a free slot.
3. If a slot is found, the vehicle is parked.
4. A `Ticket` is created.
5. When the vehicle exits, `ParkingLot` closes the ticket.
6. `FeeCalculator` calculates the fee.
7. `ParkingBill` is returned.
8. `ParkingDisplay` prints the result.

## SOLID Principles Used

### Single Responsibility Principle

- `ParkingDisplay` only prints output
- `SimpleFeeCalculator` only calculates fee
- `FirstAvailableSlotStrategy` only finds a slot
- `Ticket` only stores ticket details

### Open/Closed Principle

New fee rules can be added by creating another class that implements `FeeCalculator`.
New slot search rules can be added by creating another class that implements `SlotSelectionStrategy`.

### Liskov Substitution Principle

`Bike`, `Car`, and `Truck` can be used wherever `Vehicle` is expected.

Example:

```java
Vehicle car = new Car("DL-01-AB-1234");
```

### Interface Segregation Principle

- `FeeCalculator`
- `SlotSelectionStrategy`

### Dependency Inversion Principle

`ParkingLot` depends on interfaces, not concrete classes.

Example:

```java
SlotSelectionStrategy slotSelectionStrategy = new FirstAvailableSlotStrategy();
FeeCalculator feeCalculator = new SimpleFeeCalculator();
```

These objects are passed to `ParkingLot` through the constructor.

## Sample Output

```text
Vehicle parked successfully.
Ticket id: 1
Vehicle number: DL-01-AB-1234
Floor: 1
Slot: 2

Vehicle removed successfully.
Ticket id: 1
Vehicle number: DL-01-AB-1234
Total fee: Rs. 20
```

## Possible Improvements

- Add package structure like `model`, `service`, `strategy`
- Add unit tests
- Add input from user using `Scanner`
- Add admin operations to add/remove floors and slots
- Store tickets in a `Map` instead of a `List`
- Add more realistic pricing rules
- Add entry gate and exit gate classes
