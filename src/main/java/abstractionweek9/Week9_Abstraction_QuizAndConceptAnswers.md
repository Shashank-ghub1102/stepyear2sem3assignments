# Week 9: Abstraction — Quiz and Concept Questions & Answers

---

## Part B — Quiz Questions

### Q1. Which of the following best describes abstraction in object-oriented programming?
- **Options:**
  - A. Showing all internal details of an object to the user
  - B. Protecting data inside an object from unauthorized access
  - C. Hiding how an object performs its operations and showing only what it does
  - D. Allowing a class to inherit from multiple parent classes
- **Answer:** **C. Hiding how an object performs its operations and showing only what it does**
- **Explanation:** Abstraction focuses on exposing essential features and interfaces of an object while hiding the complex internal mechanisms and implementation details. Option B describes encapsulation, while Option D describes multiple inheritance.

---

### Q2. Which statement about an abstract class in Java is true?
- **Options:**
  - A. It must contain at least one abstract method
  - B. It can be instantiated if it has no abstract methods
  - C. It cannot be instantiated directly
  - D. It can extend multiple other classes
- **Answer:** **C. It cannot be instantiated directly**
- **Explanation:** In Java, an abstract class is declared with the `abstract` keyword and can never be instantiated using `new MyAbstractClass()`, regardless of whether it has abstract methods or only concrete methods. Java also does not support multiple class inheritance (ruling out D).

---

### Q3. If a concrete class extends an abstract class but fails to implement an inherited abstract method, what is the consequence?
- **Options:**
  - A. Java automatically provides an empty implementation for the method
  - B. The class must be declared abstract, or the code will not compile
  - C. A runtime error will occur only when the unimplemented method is called
  - D. The compiler will issue a warning but still allow compilation
- **Answer:** **B. The class must be declared abstract, or the code will not compile**
- **Explanation:** When a class extends an abstract class, it inherits the contractual obligation to implement all abstract methods. If any abstract method remains unimplemented, the class itself must be declared `abstract`; otherwise, the Java compiler raises a compile-time error.

---

### Q4. Which of the following modifiers is NOT allowed for an abstract method in Java?
- **Options:**
  - A. protected
  - B. public
  - C. private
  - D. default (package-private)
- **Answer:** **C. private**
- **Explanation:** An abstract method is meant to be overridden and implemented by derived subclasses. A `private` method is inaccessible and hidden from subclasses, making it impossible to override. Therefore, declaring a method `abstract private` is a compile-time error.

---

### Q5. Fields declared within a Java interface are implicitly:
- **Options:**
  - A. private and static
  - B. protected and final
  - C. public, static, and final
  - D. public and instance-specific
- **Answer:** **C. public, static, and final**
- **Explanation:** In a Java interface, every field is automatically `public static final`, meaning it acts as a constant accessible globally that belongs to the interface type itself and cannot be modified.

---

### Q6. How many interfaces can a single Java class implement?
- **Options:**
  - A. Only one interface at a time
  - B. At most two interfaces
  - C. Any number of interfaces
  - D. None, if the class already extends another class
- **Answer:** **C. Any number of interfaces**
- **Explanation:** Java supports multiple interface inheritance. A class can extend at most one superclass via `extends`, but can implement any number of interfaces separated by commas via `implements InterfaceA, InterfaceB, ...`.

---

### Q7. If a class implements an interface, what access modifier must it use for the implemented methods?
- **Options:**
  - A. default (package-private)
  - B. private
  - C. protected
  - D. public
- **Answer:** **D. public**
- **Explanation:** All methods declared in a Java interface are implicitly `public` (and `abstract`, unless marked `default` or `static`). When overriding a method, a subclass cannot assign weaker access privileges. Therefore, the implementing class must explicitly declare the method as `public`.

---

### Q8. Why does Java allow a class to implement multiple interfaces but only extend a single class?
- **Options:**
  - A. Implementing interfaces makes the code run faster
  - B. Classes are unable to contain any methods
  - C. Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance
  - D. Interfaces are compiled independently from classes
- **Answer:** **C. Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance**
- **Explanation:** The primary hazard in multiple inheritance is conflicting instance state (fields and object layouts) from two parent classes inheriting from a common ancestor. Because interfaces carry no instance fields (instance state) and have no constructors, state conflicts are completely avoided.

---

### Q9. What happens if a class implements two interfaces that both provide a default method with the same signature, and the class does not override this method?
- **Options:**
  - A. The method from the first interface listed in the implements clause is used
  - B. The method from the last interface listed in the implements clause is used
  - C. A runtime exception occurs when the method is called
  - D. A compile-time error occurs until the class overrides the method
- **Answer:** **D. A compile-time error occurs until the class overrides the method**
- **Explanation:** If two implemented interfaces provide conflicting `default` method implementations with identical signatures, Java refuses to guess or pick an arbitrary order. The compiler produces an error stating that the class inherits unrelated defaults, forcing the developer to explicitly override the method and resolve the ambiguity.

---

### Q10. Which of the following is true regarding constructors in Java?
- **Options:**
  - A. Concrete classes cannot have constructors
  - B. Abstract classes can have constructors that run when a subclass object is created
  - C. Interfaces must have at least one constructor
  - D. Constructors in abstract classes are used to create objects of the abstract class directly
- **Answer:** **B. Abstract classes can have constructors that run when a subclass object is created**
- **Explanation:** Abstract classes cannot be directly instantiated via `new`, but they can declare constructors to initialize shared fields and establish class invariants. When a concrete subclass constructor is invoked, constructor chaining (`super(...)`) executes the abstract superclass constructor first.

---

## Part C — Concept Questions

### Question 1
**Explain abstraction in your own words. Provide a real-life example, different from those mentioned in the material, detailing what is shown to the user and what details are hidden.**

**Answer:**
**Abstraction** is the object-oriented principle of presenting only the essential, high-level features and capabilities of a system to the outside world while concealing internal complexity, algorithm details, and background mechanics.

**Real-Life Example: An ATM (Automated Teller Machine)**
- **What is shown to the user:** Screen with options (Withdraw Cash, Check Balance, Deposit), keypad for PIN and amount, cash dispenser slot.
- **What details are hidden:** Network communication protocols, cryptographic handshake, database queries, balance verifications, transaction rollbacks, internal mechanical rollers, optical banknote sensors, and solenoid actuators.

---

### Question 2
**Describe the primary difference between abstraction and encapsulation. Explain how these two concepts work together within a single class.**

**Answer:**
- **Abstraction** is concerned with **"what"** an object does from an external viewpoint — hiding *complexity* by providing a simplified interface.
- **Encapsulation** is concerned with **"how"** the object's data is secured — hiding *internal state* using access specifiers (`private`) to prevent unauthorized tampering.

Together: Encapsulation protects the integrity of data by declaring fields `private` with controlled methods. Abstraction presents those public methods as an intuitive contract to caller code, concealing the underlying algorithms. Encapsulation protects the data; abstraction reduces mental overhead for the caller.

---

### Question 3
**An abstract class cannot be instantiated, yet it can define a constructor. Explain why, and describe when this constructor is executed.**

**Answer:**
- **Why:** Even though an abstract class cannot be instantiated directly, it typically defines state variables (fields) common to all derived subclasses (e.g., `id`, `name`). A constructor in the abstract class guarantees shared state is properly initialized in one centralized place, preventing code duplication across subclasses.
- **When:** The abstract class constructor is executed during **subclass object creation**. When a concrete subclass is instantiated with `new Subclass(...)`, its constructor first invokes the superclass constructor—either implicitly via default `super()` or explicitly via `super(args)`—before running its own body.

---

### Question 4
**Explain why an abstract method cannot be declared with the private, static, or final modifiers.**

**Answer:**
1. **`private` Restriction:** A `private` method is invisible to subclasses and cannot be overridden. An abstract method that cannot be overridden can never be implemented — violating its purpose.
2. **`static` Restriction:** A `static` method belongs to the class itself and is bound at compile-time (method hiding), not dynamically dispatched at runtime (method overriding). Abstract methods rely on dynamic polymorphism, so `static` is incompatible.
3. **`final` Restriction:** The `final` modifier explicitly prohibits overriding. Declaring a method both `abstract` (must be overridden) and `final` (cannot be overridden) is a direct logical contradiction rejected by the compiler.

---

### Question 5
**What is the 'diamond problem'? Explain how Java's design addresses it.**

**Answer:**
- **The Diamond Problem:** Occurs when class D inherits from classes B and C, both inheriting from a common base class A. If B and C both override a method or hold state from A, the compiler cannot determine which parent's implementation or state to use.
- **How Java Resolves It:**
  1. **Single Class Inheritance (`extends`):** A class can extend only one superclass, eliminating ambiguity in object layout, constructor chaining, and mutable instance state.
  2. **Multiple Interface Implementation (`implements`):** Interfaces hold only behavior contracts with no instance state. If two interfaces offer the same `default` method signature, Java throws a compile-time error until the developer explicitly overrides the method (e.g., `InterfaceA.super.method()`).
