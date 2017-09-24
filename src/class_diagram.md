```puml

namespace net.hikaruna.rolling {
    interface Enumerable {
        - each
        - map
        - reduce
    }
    interface Collection
    interface List
    interface Set
    interface Map
    class ArrayList
    class LinkedList
    class HashSet
    class HashMap

    Enumerable <|-- Collection
    Collection <|-- List
    Collection <|-- Set
    Enumerable <|-- Map
    List <-- ArrayList
    List <-- LinkedList
    Set <-- HashSet
    Map <-- HashMap

    List -[hidden] Set
    Set -[hidden] Map
    ArrayList -[hidden] LinkedList
}

namespace java.util {
    interface Collection
    interface List
    interface Set
    interface Map
    class ArrayList
    class LinkedList
    class HashSet
    class HashMap

    Collection <|-- List
    Collection <|-- Set
    List <-- ArrayList
    List <-- LinkedList
    Set <-- HashSet
    Map <-- HashMap

    List -[hidden] Set
    Set -[hidden] Map
    ArrayList -[hidden] LinkedList
}

net.hikaruna.rolling -> java.util : use
net.hikaruna.rolling.Collection <|- java.util.Collection
net.hikaruna.rolling.List <|- java.util.List
net.hikaruna.rolling.Set <|- java.util.Set
net.hikaruna.rolling.Map <|- java.util.Map
net.hikaruna.rolling.ArrayList <|- java.util.ArrayList
net.hikaruna.rolling.LinkedList <|- java.util.LinkedList
net.hikaruna.rolling.HashSet <|- java.util.HashSet
net.hikaruna.rolling.HashMap <|- java.util.HashMap
```
