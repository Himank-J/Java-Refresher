## Creation Patterns

Creational patterns deal with object creation mechanisms — how objects are instantiated, configured, and composed.
They help make systems independent of how objects are created, improving flexibility, scalability, and testability.

### Singleton Pattern
Ensures only one instance of a class exists and provides a global point of access to it.

**When to Use**

- You need exactly one instance (e.g., configuration manager, connection pool, logger).
- Centralized control of resources.

### Factory Method Pattern
Defines an interface for creating an object but allows subclasses to decide which class to instantiate.

**When to Use**

- You don’t know in advance which class you’ll need.
- You want to delegate object creation to subclasses.

### Abstract Factory Pattern
Provides an interface to create families of related objects without specifying their concrete classes.

**When to Use**

- You need to ensure that products created together are compatible.
- Your system should be configurable with multiple product families.

### Builder Pattern
Separates object construction from its representation so that the same construction process can create different representations.

**When to Use**

- You need to create complex objects step-by-step.
- You want immutable objects or avoid long constructors.

---

## Structure Patterns

Structural design patterns explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient

### Adapter Pattern
The Adapter Pattern allows incompatible interfaces to work together.
It acts as a bridge between two classes that otherwise couldn’t communicate due to interface mismatches.

**When to Use**
- When you want to use an existing class, but its interface doesn’t match the one you need.

- When you want to create a reusable class that cooperates with classes that don’t necessarily have compatible interfaces.

### Facade Pattern
Ensures only one instance of a class exists and provides a global point of access to it.

**When to Use**

### Decorator Pattern
The Decorator Pattern dynamically adds new behaviors or responsibilities to objects without modifying their code.
It provides a flexible alternative to subclassing for extending functionality.

**When to Use**

- When you need to add behavior to individual objects at runtime.
- When subclassing would create an explosion of classes for every combination of features.