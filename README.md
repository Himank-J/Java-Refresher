## Quick Notes & Important Concepts

1. use camelCase for variables
2. value of identifier (variable) is called literal - 5 is int literal, 5.0 is double literal
3. Unary operator
    3.1 x = -y    // Unary minus: negates the value of y
    3.2 x = ++y   // Pre-increment: increments y first, then assigns to x
    3.3 x = --y   // Pre-decrement: decrements y first, then assigns to x
    3.4 x = y++   // Post-increment: assigns y to x first, then increments y
    3.5 x = y--   // Post-decrement: assigns y to x first, then decrements y
4. If-else -> curly brackets can be omitted for single statements but not recommended
    4.1 eg - If true System.out.println('Yes');
    4.2 if () {

    } else if () {

    } else {
        
    }
5. Code blocks
    5.1 static code block - runs once in class lifetime; when class if loaded
    eg - static {
        int x = 0;
    }
    5.2 Initialisation block - runs each time an instance (object) is created
    eg - {
        x++;
    }
6. Stack vs Heap memory
    6.1 Stack Memory
        - Stores method call stack, local variables, and references to objects.
        - When a method is called, a new "frame" is pushed onto the stack.
        - When the method ends, its stack frame is popped off (automatically cleared).
        - Highly efficient because it follows the LIFO order.
        - Used For: Method calls, local variables, reference variables
        - Memory Allocation: Last-In-First-Out (LIFO)
        - Size: Smaller
        - Speed: Very fast
        - Life Span: Exists only while the method is running
        - Thread Safety: Each thread has its own stack (thread-safe)
        - Managed By: Compiler
        - Example Data: Primitives, object references (not objects)
        - Pitfall - StackOverflowError: Happens when recursive calls go too deep (stack exceeds limit).

    6.2 Heap Memory
        - Stores all Java objects (created with new keyword).
        - Objects can be shared across methods and threads.
        - Managed by Java's Garbage Collector (GC), which automatically frees unused objects.
        - More flexible, but slower to access than stack memory.
        - Used For: Objects and instance variables
        - Memory Allocation: Dynamic (allocated at runtime)
        - Size: Larger
        - Speed: Slower than stack
        - Life Span: Exists until object is garbage collected
        - Thread Safety: Shared between threads (not thread-safe by default)
        - Managed By: Garbage Collector
        - Example Data: Actual objects, arrays
        - Pitfall - Memory leaks in heap: Can occur if references to unused objects aren't cleared, preventing garbage collection.

7. Primitives vs Reference Types
    7.1 Primitives are stored in stack; Reference type in Heap

8. Garbage collection
    8.1 Garbage collection is the process of identifying and reclaiming memory used by objects that are no longer reachable (i.e., not referenced by any part of your program). This frees up heap memory and prevents memory leaks.
    8.2 An object is eligible for GC if no references to it exist anymore. Java uses a concept called the "reachability graph" to determine this.
    8.3 Memory generations: Young, Old, PermGen
        8.3.1 Young Generation
            - Purpose: Stores newly created objects, Most objects die young (short-lived), so GC is fast and frequent here.
            - Subdivided into:
                - Eden Space: Where new objects are first allocated.
                - Survivor Spaces (S0 and S1): Surviving objects are copied here after GC.

            - GC Process:
                - Minor GC: Happens frequently in Young Gen.
                - Copies live objects from Eden → Survivor
                - Cleans up the rest (dead objects)
        
        8.3.2 Old (Tenured) Generation
            - Purpose: Stores long-lived objects that survived multiple Minor GCs. GC here is slower and more expensive.
            - Objects that survive several GCs in Young Gen are promoted to Old Gen.
        
        8.3.3 Permanent Generation (PermGen)
            - Used to store class metadata, method info, interned strings, etc.
            - Had fixed size → prone to OutOfMemoryError: PermGen space
            - Removed in Java 8 and later
        
        8.3.3 Metaspace (Java 8+)
            - Replacement for PermGen
            - Stores class metadata
            - Grows automatically as needed (limited by system memory)
            - Stored outside the heap

9. Do-While
    9.1 Executes code block first, then checks condition - guranteed to run atleast once

## String Class

10. String Pool
    10.1 The String Pool (also called the intern pool) is a special area in Java's heap memory where String literals are stored and reused.
        - When you write:
            String s1 = "hello";
            String s2 = "hello";
        - Both s1 and s2 point to the same object in the String Pool, not two separate objects.
        - Java stores "hello" only once in memory — this saves memory and improves performance.
    
    10.2 Why String Pool Exists
        - Strings are immutable in Java — their value can’t change once created.
        - So it’s safe to share strings without worrying one variable might change another.
        - Reduces memory usage when the same string is used repeatedly.
    
    10.3 How to Force a String into the Pool
        String e = new String("Java");
        String f = e.intern();  // f now refers to the string in the pool
        String g = "Java";
        System.out.println(f == g); ==> True
    
11. Concatenating string using "+" creates multiple versions of string which increases memory. Better way is to use string formats
    11.1 use printf with %s, %f, %d, %c, %b
    | Feature             | `String`            | `StringBuilder` | `StringBuffer`               |
    | ------------------- | ------------------- | --------------- | ---------------------------- |
    | **Mutability**      | Immutable           | Mutable         | Mutable                      |
    | **Thread-safe**     | No                  | No              | ✅ Yes                        |
    | **Performance**     | Slowest for changes | ✅ Fastest       | Slower than `StringBuilder`  |
    | **Synchronization** | No                  | No              | ✅ Yes (methods synchronized) |
    | **Use in Loops**    | 🚫 Avoid            | ✅ Recommended   | ⚠️ Use if thread-safe        |

12. Final keywords make variables a constant and immutable. By convention declared as uppercase with underscores

13. Access modifiers (ordered by leat resricted to most) - 
    13.1 Public - Accessible from any class within same package (class / sub class / non sub class) and from different package (sub class / non sub class)
    13.2 Protected - Accesible within same package (class / sub class / non sub class) and from different package (sub class)
    13.3 Default - Accesible only within same package (class / sub class / non sub class)
    13.4 Private - Accesible only within same class

14. Equals and Hashcode
    14.1 The equals() method in Java is used to compare two objects for logical equality — i.e., whether two objects are meaningfully equal in terms of their data/state.
    14.2 The hashCode() method returns an int value, called a hash code, that represents the internal memory address or state of an object. It's used in hash-based collections like HashMap, HashSet, and Hashtable.
    14.3 [IMP] If two objects are equal according to equal() they must have the same hash code. However, two objects with the same hash code arent necessarily equal.

15. Nested and Inner Classes
    15.1 Nested classes - defined within aother class - static and non static (inner) class
    15.2 [IMP] Static Nested classes: Acts as static members of outer class; can access outer class's static members but not non static member
    15.2 Inner class: associated with an instance of outer class; can access all members of outer class including private ones

## Abstraction & Interfaces

16. Abstraction
    16.1 Abstraction is the concept of hiding the complex implementation details and showing only the necessary features to the user. In Java, abstraction is achieved through abstract classes and interfaces. 
    16.2 Why Use Abstraction?
        - Simplification: Reduces complexity by hiding unnecessary implementation details.
        - Code Reusability: Abstraction allows you to write more generic code that can be reused.
        - Flexibility and Maintainability: You can modify or update code behind the scenes without affecting other parts of the program.
    16.3 An abstract class is a class that cannot be instantiated on its own and must be subclassed by other classes.
    16.4 Abstract classes can have both abstract methods (methods without a body) and concrete methods (methods with a body).
    16.5 An abstract class can have constructors, fields, and methods (both abstract and concrete).

17. Interface
    17.1 An interface is a reference type, similar to a class, that can contain only abstract methods (until Java 8) and default methods (since Java 8).
    17.2 Interfaces represent a contract: classes that implement an interface must provide concrete implementations of all methods in the interface.
    17.3 An interface cannot have constructors.
    17.4 Since Java 8, interfaces can have default and static methods, which allows you to provide default behavior.
    <br>
    **Advanced concepts**
    17.5 Concrete Methods in Abstract Classes
        17.5.1 Concrete methods can be used to provide a default behavior that can be overridden by subclasses.
    17.6 Default Methods in Interfaces (Java 8+)
        17.6.1 Java 8 introduced the concept of default methods in interfaces. This allows you to provide default implementations for methods in interfaces. 
        17.6.2 Default methods can help to evolve interfaces without breaking the existing implementation.
    17.7 Static Methods in Interfaces (Java 8+)
        17.7.1 Interfaces can now have static methods that are not inherited by implementing classes. These methods must be called using the interface name.
        
```python

interface Animal {
    static void sleep() {
        System.out.println("Sleeping...");
    }
}

public class Test {
    public static void main(String[] args) {
        Animal.sleep(); // Calling static method
    }
}
```
      
18. Abstraction vs Interface

18.1 Key differences
| Feature                | Interface                                   | Abstract Class                                    |
| ---------------------- | ------------------------------------------- | ------------------------------------------------- |
| Multiple inheritance   | ✅ Allowed                                   | ❌ Not allowed (only one abstract class per class) |
| Constructors           | ❌ Not allowed                               | ✅ Allowed                                         |
| Fields (state)         | Only static final (constants)               | Can have instance variables                       |
| Access Modifiers       | Methods are implicitly `public`             | Methods can have `protected`, `private`, etc.     |
| Default Implementation | ✅ From Java 8+ (`default`/`static` methods) | ✅                                                 |
| Use Case               | "What" the object can do                    | "What" the object is                              |
| Purpose                | Define a **contract**                       | Provide a **partial implementation**              |

18.2 Decision Table
| Use Case                               | Use Interface   | Use Abstract Class |
| -------------------------------------- | --------------- | ------------------ |
| Define a contract                      | ✅               | ✅                  |
| Share state or fields                  | ❌               | ✅                  |
| Allow multiple inheritance             | ✅               | ❌                  |
| Provide default method implementations | ✅ (from Java 8) | ✅                  |
| Share base logic across subclasses     | ❌               | ✅                  |
| Define plugin architecture             | ✅               | Optional           |
| Enforce “is-a” relationship            | ❌               | ✅                  |

🚦 When to Use Interface + Abstract Class Together

- Define a contract (interface)
- Provide a base implementation of that contract (abstract class)
- Allow flexibility for subclasses to override or extend behavior

```python
// Step 1: Interface defines the contract
public interface DataService {
    void saveData(Data data);
    Data fetchData(String id);
}

// Step 2: Abstract class provides partial implementation
public abstract class AbstractDataService implements DataService {
    @Override
    public void saveData(Data data) {
        System.out.println("Validating data...");
        // common validation logic
        doSave(data); // subclass-specific logic
    }

    // Let subclasses handle the actual saving
    protected abstract void doSave(Data data);
}

// Step 3: Concrete class implements specifics
public class SQLDataService extends AbstractDataService {
    @Override
    public Data fetchData(String id) {
        System.out.println("Fetching from SQL DB...");
        return new Data();
    }

    @Override
    protected void doSave(Data data) {
        System.out.println("Saving to SQL DB...");
    }
}
```

18.3 ✅ Final Rule of Thumb

- Use interfaces to define behavioral contracts (what a class can do).
- Use abstract classes when you want to provide a shared, partial implementation (how it's done).
- Use both together when you need a flexible and extensible architecture that encourages reuse and reduces boilerplate.

19. Polymorphism

19.1 Upcasting
    19.1.1 Upcasting means treating a child class object as if it were a parent class object. It is safe and automatic
    19.1.2 [IMP] Parent reference = Child Object (Child -> Parent)
    19.1.3 Use cases
- Polymorphism in method parameters; When a method is written to accept a superclass, but you pass a subclass.

```
class Animal {
    void makeSound() { System.out.println("Some sound"); }
}

class Dog extends Animal {
    void makeSound() { System.out.println("Bark"); }
}

class Cat extends Animal {
    void makeSound() { System.out.println("Meow"); }
}

public class Zoo {
    static void playSound(Animal a) {  // accepts any Animal
        a.makeSound();
    }

    public static void main(String[] args) {
        Animal dog = new Dog();  // Upcasting
        Animal cat = new Cat();  // Upcasting
        
        playSound(dog);  // prints "Bark"
        playSound(cat);  // prints "Meow"
    }
}

```

- Working with collections of base types; You can store different subclass objects in one collection

```
List<Animal> animals = new ArrayList<>();
animals.add(new Dog()); // Upcast
animals.add(new Cat()); // Upcast

for (Animal a : animals) {
    a.makeSound(); // Calls overridden method dynamically
}
```

19.2 Downcasting
    19.2.1 Downcasting means converting a parent class reference back into a child class reference.
    19.2.2 [IMP] Child reference = Parent Object (Parent -> Child)
    19.2.3 It’s not automatic — you must tell Java explicitly, and it can cause errors if the object isn’t actually that type.

```bash
Animal a = new Dog();  // Upcasting first
Dog d = (Dog) a;       // Downcasting

Animal a = new Animal();
Dog d = (Dog) a;  // ❌ Runtime error: ClassCastException
```

    19.2.4 Use cases

- Accessing subclass-specific features

```
class Animal {
    void makeSound() { System.out.println("Some sound"); }
}

class Dog extends Animal {
    void fetch() { System.out.println("Dog fetches ball!"); }
}

public class Example {
    public static void main(String[] args) {
        Animal a = new Dog(); // Upcasting
        a.makeSound();
        
        // Now we want to call a Dog-specific method:
        if (a instanceof Dog) {
            Dog d = (Dog) a;  // Downcasting
            d.fetch();
        }
    }
}

```

- When retrieving from general collections or APIs, Sometimes APIs return generic types, and you know the specific type.

```
Object obj = getSomeObject();

if (obj instanceof String) {
    String s = (String) obj;  // Downcasting from Object to String
    System.out.println(s.toUpperCase());
}

```

20. Overloading and Overriding

| Feature               | **Overloading**                                                                                                | **Overriding**                                                                                                                 |
| --------------------- | -------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------ |
| **Definition**        | Defining multiple methods **with the same name but different parameters** in the **same class** (or subclass). | Defining a **method in a subclass** that has the **same name, return type, and parameters** as a method in its **superclass**. |
| **Concept type**      | **Compile-time (static)** polymorphism                                                                         | **Runtime (dynamic)** polymorphism                                                                                             |
| **Location**          | Same class or subclass                                                                                         | Different classes (in inheritance hierarchy)                                                                                   |
| **Parameters**        | Must be **different** (number, type, or order)                                                                 | Must be **exactly the same**                                                                                                   |
| **Return type**       | Can be different (if method signature differs)                                                                 | Must be the **same** or **covariant** (subtype of original return type)                                                        |
| **Access modifier**   | Can be anything                                                                                                | Cannot reduce visibility (e.g. `public` → `protected` not allowed)                                                             |
| **Static methods**    | Can be overloaded                                                                                              | Can’t truly be overridden (they are *hidden*)                                                                                  |
| **Polymorphism type** | Resolved **at compile-time**                                                                                   | Resolved **at runtime**                                                                                                        |

21. Throw vs Throws

| Keyword            | **`throw`**                                             | **`throws`**                                                    |
| ------------------ | ------------------------------------------------------- | --------------------------------------------------------------- |
| **Purpose**        | Used **to actually throw** (generate) an exception.     | Used **to declare** that a method *may throw* an exception.     |
| **Position**       | Inside a method or block.                               | In the **method signature** (after the parameters).             |
| **Usage Count**    | Only **one exception** can be thrown at a time.         | Can **declare multiple** exceptions (comma-separated).          |
| **Who handles it** | The **runtime system** or a **catch block** handles it. | The **caller** of the method must handle or re-declare it.      |
| **Keyword Type**   | **Action keyword** — it *does* the throwing.            | **Declaration keyword** — it *warns* about possible exceptions. |
| **Example**        | `throw new IOException("File not found");`              | `void readFile() throws IOException { ... }`                    |

## Collections & Generics

22.1 Varargs (...)
- Java supports variable-length argument lists (like Python’s *args), but not keyword args.

```
void greet(String... names) {
    for (String name : names) {
        System.out.println("Hello, " + name);
    }
}
``` 

22.2 Wrapper Classes
- Wrapper classes are object representations of primitive data types.    

Why?
Primitive types (like int, double) are not objects — they store simple values and have no methods.
Sometimes, however, Java requires objects, not primitives — for example:

- In Collections (ArrayList, HashMap, etc.)
- When using Generics
- For null values
- For object methods (e.g., .toString(), .compareTo())

Autoboxing - Conversion from primitive → wrapper object
Unboxing - Conversion from wrapper object → primitive.

22.2.1 List Interface

Declaration - 
```
List myList = new ArrayList();
OR
List<String> myList = new ArrayList<>();
```

Common Methods - 
1. add(E e): Appends the specified element
2. add(int index, E element): Inserts at specified position
3. remove(Object o): Removes the first occurrence of the specified element
4. remove(int index): Removes the element at the specified position
5. get(int index): Returns the element at the specified position
6. set(int index, E element): Replaces the element at the specified position
7. size(): Returns the number of elements
8. clear(): Removes all of the elements
9. contains(Object o): Returns 'true' if the list contains the specified element.
10. indexOf(Object o): Returns the index of the first occurrence, or -1 if the list does not contain the element.

22.2.2 Queue Interface

Declaration - 
```
Queue myList = new LinkedList();
OR
Queue<String> myList = new LinkedList<>();
```

Common Methods -
1. add(E e): Inserts the specified element into the Uqueue. Throws an exception if the element cannot be added. -
2. offer(E e): Inserts the specified element into the queue. Returns false if the element cannot be added.
3. remove(): Retrieves and removes the head of the queue. Throws an exception if the queue is empty.
4. poll(): Retrieves and removes the head of the queue, or returns null if the queue is empty.
5. element(): Retrieves, but does not remove, the head of the queue. Throws an exception if the queue is empty.
6. peek(): Retrieves, but does not remove, the head of the queue, or returns null if the queue is empty.

22.2.3 Set Interface

Declaration - 
```
Set mySet = new HashSet();
OR
Set<String> mySet = new HashSet<>();
```

Common Methods - 
1. add(E e): Adds the specified element to the set
2. remove(Object o): Removes the specified element from the set
3. contains(Object o): Checks if the set contains the specified element
4. size(): Returns the number of elements in the set.
5. isEmpty(): Checks if the set is empty.

22.2.4 HashMap

Declaration - 
```
Map<String, Integer> myMap = new HashMap<>();
```

Common Methods - 
1. put(K key, V value): Associates the specified value with the specified key in the map.
2. get(Object key): Returns the value to which the specified key is mapped, or null if the map contains no mapping for the key.
3. remove(Object key): Removes the mapping for a key from the map if it is present.
4. containsKey(Object key): Checks if the map contains a mapping for the specified key.
5. keySet(): Returns a Set view of the keys contained in the map.
6. values(): Returns a Collection view of the values contained in the map.

## Enums

Basic Example
```
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class TestEnum {
    public static void main(String[] args) {
        Day today = Day.MONDAY;
        
        System.out.println("Today is " + today);

        // Loop through all enum values
        for (Day d : Day.values()) {
            System.out.println(d);
        }
    }
}
```

Enum with Fields and Methods

```
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6);

    private final double mass;   // in kilograms
    private final double radius; // in meters

    // Constructor
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    double surfaceGravity() {
        final double G = 6.67300E-11;
        return G * mass / (radius * radius);
    }
}

public class TestPlanet {
    public static void main(String[] args) {
        for (Planet p : Planet.values()) {
            System.out.printf("Surface gravity on %s is %f%n", p, p.surfaceGravity());
        }
    }
}

```

## MultiThreading

Threading in Java refers to the ability of a program to perform multiple tasks concurrently.
Each thread represents an independent path of execution within a program.

| Term        | Description                                                                                 |
| ----------- | ------------------------------------------------------------------------------------------- |
| **Process** | An independent program with its own memory space.                                           |
| **Thread**  | A smaller unit of a process that shares the same memory with other threads of that process. |

Multiple threads in the same process share:

- The same heap memory (objects)
- But each has its own stack, program counter, and registers

**Thread Lifecycle**

| State             | Description                                                           |
| ----------------- | --------------------------------------------------------------------- |
| **New**           | Thread created but not yet started (`new Thread()`).                  |
| **Runnable**      | Thread is ready to run or running.                                    |
| **Blocked**       | Waiting to acquire a monitor lock (for synchronization).              |
| **Waiting**       | Waiting indefinitely for another thread to perform a specific action. |
| **Timed Waiting** | Waiting for another thread for a specified time (e.g., `sleep()`).    |
| **Terminated**    | Thread has completed execution.                                       |

**Common Methods** - 

| Method             | Description                               |
| ------------------ | ----------------------------------------- |
| `start()`          | Starts a new thread.                      |
| `run()`            | Contains the code executed by the thread. |
| `sleep(ms)`        | Pauses thread for given milliseconds.     |
| `join()`           | Waits for another thread to finish.       |
| `isAlive()`        | Checks if a thread is still running.      |
| `setPriority(int)` | Sets thread priority (1–10).              |

1. sleep(long millis): Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds.
2. yield(): Causes the currently executing thread to pause and allow other threads to execute. It's a way of suggesting that other threads of the same priority can run.
3. wait(): Causes the current thread to wait until another thread invokes the notify() or notifyAll() method for this object. It releases the lock held by this thread.
4. notify(): Wakes up a single thread that is waiting on the object's monitor. If any threads are waiting, one is chosen to be awakened.
5. notifyAll(): Wakes up all threads that are waiting on the object's monitor.

**Creating Thread**

- Using Threads class

```
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // start() runs the thread asynchronously
    }
}
```

- Using Runnable interface
```
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}

```

## Thread Synchronization

When multiple threads access shared resources, race conditions can occur.

To prevent this, use synchronization. 

Synchronization in Java is the mechanism that ensures only one thread accesses a shared resource (like an object, variable, or block of code) at a time.

Synchronization in Java works on a concept called the monitor lock (intrinsic lock).
- The thread must acquire the lock on someObject before entering the block.
- Only one thread at a time can hold that lock.
- Other threads trying to enter a synchronized block on the same object are blocked until the lock is released.

This means synchronization only works if multiple threads share the same object.
If each thread has its own instance, they each have their own lock — and synchronization doesn’t actually synchronize anything!

```
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Count = " + counter.getCount());
    }
}
```

## Wait(), Notify() and NotifyAll()

wait(), notify(), and notifyAll() are used for inter-thread communication — when two or more threads need to coordinate access to a shared resource.

They all belong to the Object class (not Thread) because every object in Java can act as a monitor (lock).

| Rule                                                   | Explanation                                                                                 |
| ------------------------------------------------------ | ------------------------------------------------------------------------------------------- |
| Must be inside a **`synchronized`** block/method       | Otherwise `IllegalMonitorStateException` occurs                                             |
| Work on the **same object monitor**                    | A thread waiting on `obj.wait()` must be notified using `obj.notify()` or `obj.notifyAll()` |
| `wait()` **releases** the lock                         | The waiting thread gives up control of the monitor until notified                           |
| `notify()` / `notifyAll()` **do not release** the lock | The notifying thread still holds the lock until it exits the synchronized block             |
| Thread wakes up only after re-acquiring the lock       | After being notified, the waiting thread must regain the monitor to continue                |

**Flow — Step-by-Step**

1. Thread A (e.g., Consumer) calls wait()

- Enters a synchronized block on a shared object.
- Calls wait() → releases the lock and goes to waiting state.
- Another thread can now acquire the same lock.

2. Thread B (e.g., Producer) calls notify() or notifyAll()

- Inside a synchronized block on the same object.
- Calls notify() → marks one waiting thread as “ready to run.”
(or notifyAll() → marks all waiting threads)
- The waiting thread(s) move to runnable state, but can’t run yet.
- The notifying thread still owns the lock and keeps executing.

3. Thread B exits the synchronized block

- Lock is released.
- The waiting thread(s) can now compete to re-acquire the lock.

4. Thread A wakes up

- Regains the monitor lock.
- Resumes execution right after the wait() call.
- Continues processing normally.

## Executor Service

**The Problem: Manual Thread Management**
- Hard to control the number of threads.
- No easy way to reuse threads.
- Hard to handle results or exceptions.
- No easy way to gracefully shut down threads.

This made concurrent programming error-prone and inefficient.

**Executor Framework**
Instead of creating threads manually, we use thread pools - 

```
ExecutorService fixedPool = Executors.newFixedThreadPool(5);
ExecutorService cachedPool = Executors.newCachedThreadPool();
ExecutorService singleThread = Executors.newSingleThreadExecutor();
ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
```

| Type                        | Description                                      | Use Case                         |
| --------------------------- | ------------------------------------------------ | -------------------------------- |
| `newFixedThreadPool(n)`     | Pool with fixed number of threads.               | CPU-bound tasks.                 |
| `newCachedThreadPool()`     | Creates new threads as needed, reuses idle ones. | Short-lived tasks.               |
| `newSingleThreadExecutor()` | One thread only, tasks executed sequentially.    | Sequential tasks with isolation. |
| `newScheduledThreadPool(n)` | Executes tasks after delay or periodically.      | Timers, scheduled tasks.         |

**Future Interface**
Future represents a result of an asynchronous computation.

**Proper Shutdown**

Always shut down your executor gracefully:

```
executor.shutdown();

// This will wait for 60 secs and close down executor even if it is running
try {
    if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
        executor.shutdownNow();
    }
} catch (InterruptedException e) {
    executor.shutdownNow();
}
```

**Runnable vs Callable**

| Aspect                    | Runnable              | Callable                    |
| ------------------------- | --------------------- | --------------------------- |
| Interface method          | `void run()`          | `V call() throws Exception` |
| Returns value?            | ❌ No                  | ✅ Yes                       |
| Throws checked exception? | ❌ No                  | ✅ Yes                       |
| Typical use               | Fire-and-forget tasks | Tasks that produce results  |


**Example**

Using **Runnable** with class - 

```
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Define a class that implements Runnable
class MyRunnableTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Running task on thread: " + Thread.currentThread().getName());
    }
}

public class RunnableWithClassExample {
    public static void main(String[] args) {
        // Create a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Create task objects
        MyRunnableTask task1 = new MyRunnableTask();
        MyRunnableTask task2 = new MyRunnableTask();

        // Execute the tasks
        executor.execute(task1);
        executor.execute(task2);

        // Shutdown the executor
        executor.shutdown();
    }
}

```

Using **Callable** with a class - 

```
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Define a class that implements Callable
class MyCallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Calculating sum on thread: " + Thread.currentThread().getName());
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }
        return sum;
    }
}

public class CallableWithClassExample {
    public static void main(String[] args) throws Exception {
        // Create a single-thread executor
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Create a Callable task
        MyCallableTask task = new MyCallableTask();

        // Submit the task and get a Future
        Future<Integer> future = executor.submit(task);

        // Retrieve and print the result
        Integer result = future.get();
        System.out.println("Result of computation: " + result);

        executor.shutdown();
    }
}

```

JPQL query methods
@Query annotation
Native query
Projections
Update queries using JPA - @modifying, @transaction
@transactional in detail - Pending
Pagination

owning side and inverse side
Join table
If i have created an insurance and patient already exists, now I want to assign insurance to patient, where will this code sit? Patient service or insurance service or somewhere else?
Cascade types
fetch types
