- [1. Go Types [structs, slices, and maps]](#1-go-types-structs-slices-and-maps)
  - [1.1. Pointers](#11-pointers)
  - [1.2. Arrays](#12-arrays)
  - [1.3. Slice](#13-slice)
  - [1.4. How memory is allocated and managed in Go](#14-how-memory-is-allocated-and-managed-in-go)
    - [1.4.1. `The new() function`](#141-the-new-function)
    - [1.4.2. `The make() function`](#142-the-make-function)
    - [1.4.3. ResultsCreating a nil objects](#143-resultscreating-a-nil-objects)
    - [1.4.4. Memory deallocation](#144-memory-deallocation)
  - [1.5. Maps](#15-maps)
  - [1.6. Structs](#16-structs)
  - [1.7. Struct Literals](#17-struct-literals)
- [Go ReadMe Main](./Go_ReadMe.md)	 	   
# 1. Go Types [structs, slices, and maps]

## 1.1. Pointers

Go has a pointer. A pointer holds the memory address of a value.

- & generates a pointer to is operand
- `*` operator denotes the pointers underlying value.

```go

    import "fmt"

    func main() {
        i, j := 42, 2701

        p := &i         // point to i
        
        fmt.Println(p)  // address of value i
        fmt.Println(*p) // read i through the pointer
        *p = 21         // set i through the pointer
        fmt.Println(i)  // see the new value of i

        p = &j         // Connection the value j to the pointer
        *p = *p / 37   // divide j through the pointer
        fmt.Println(j) // see the new value of j

       	var p *int  // Explicit pointer delcaration
        i := 42
        p = &i
        fmt.Printf("Ointer value %v and %T", *p, p)
        // Note without code line 29 30 it will throw deferencing nil pointer reference
 
    }

```

## 1.2. Arrays
- Array is an ordered collection of similar values 
- Declaring an array
 
 ```go
   var colors [3] string
   colrs[0] = "RED"
   colors[1] = "BLUE"
   colors[2] = "GREEN"
   fmt.Println(colors) //Print array
```
- Declaring and initializing an array

```go
var numbers = [5]int {1,2,3,4,5}
fmt.Println("Number of elements in number", len(numbers))

```

## 1.3. Slice
 - Slices are like array but they are resizable 
 - A slice can be sorted using sort function
 - Add element with buildint function append(slice, <value>)
 - Remove first element `append(slice[1:])` and Last `append(slice[: len(slice)-1] )`
 
 ```go
  
import (
	"fmt"
	"sort"
)

func main() {

    // Declaring an Slice
	var colors = []string{"Red", "Green", "Blue"}
	fmt.Println(colors)
    
    // Appending element at the end
	colors = append(colors, "Purple")
	fmt.Println(colors)
    
    //Removing first element
	colors = append(colors[1:len(colors)])
	fmt.Println(colors)
    
    //Removing last element
	colors = append(colors[:len(colors)-1])
	fmt.Println(colors)
    
    //Declaring a Slice initial size and capacity
	numbers := make([]int, 5, 5)
	numbers[0] = 134
	numbers[1] = 72
	numbers[2] = 32
	numbers[3] = 12
	numbers[4] = 156
	fmt.Println(numbers)
	
	numbers = append(numbers, 235)
    fmt.Println(numbers)
    //Print Capacity of numbers
	fmt.Println(cap(numbers))

	sort.Ints(numbers)
	fmt.Println(numbers)
	
}


 ```

## 1.4. How memory is allocated and managed in Go
- The Go run time is statically linked into the application.
- Memory is allocated and decallocated automatically. 
- Use `make()` `new()` to initialize
    -  **maps**  **Slices** **channels**  
### 1.4.1. `The new() function`
 - Allocates memory but doesn't initialize memory
 - Results in zereod storage but returns a memory address
### 1.4.2. `The make() function`
- Allocate and initialized memory. 
- Allocates non zereod storage and returns a memory address with ready to accept values.

### 1.4.3. ResultsCreating a nil objects
You must initialize complex objects before adding values.

Declarations without make () can make panic

```go 
//Wrong memory initialization
var maps map[string]int
maps["key"] = 42  // Panic assigment to entry in nil map and app crashes
fmt.Println(maps)

// Correct memory initialization

maps := make(map[string]int)
maps["key"] = 42
fmt.Println(maps)
// map[key:42]
```

### 1.4.4. Memory deallocation
Memory is automatically by Garbage Collector(GC) 
Objects out of scope are set to nil are eligible.
GC was rebuild in Go 1.5 for very low latency.

 More details in [runtime](https://golang.org/pkg/runtime)

##  1.5. Maps

- A map in Go is a unordered collection, every time you iterate the map you get elments in unordered. 
- TO get elements in ordered you have to hack using slice and sort.strings function

```go

import (
	"fmt"
	"sort"
)

func main() {
	states := make(map[string]string)
	fmt.Println(states)
	
	states["WA"] = "Washington"
	states["OR"] = "Oregon"
	states["CA"] = "California"
	fmt.Println(states)

	desc := states["CA"]
	fmt.Println(desc)
	
	delete(states, "OR")  // Delete
	fmt.Println(states)

	states["NY"] = "New York" // Add
	
	for k, v := range states {
		fmt.Printf("%v: %v\n", k, v)
	}
	
	// creating a slice and populate with map keys
	keys := make([]string, len(states))
	i := 0
	for k := range states {
		keys[i] = k
		i++
	}

	sort.Strings(keys) // sorting keys

	fmt.Println("\nSorted") //Looping slice and printing map values in ascending
	for i := range keys {
		fmt.Println(states[keys[i]])
	}

}

//Prints as below
map[]
map[CA:California OR:Oregon WA:Washington]
California
map[CA:California WA:Washington]
WA: Washington
NY: New York
CA: California

Sorted
California
New York
Washington


```


## 1.6. Structs

1. A struct is a collection of fields.
2. Its fields are accessed using a dot.
3. Struct fields can be accessed through a struct pointer.

```go
    import "fmt"

    type Vertex struct {
        X int
        Y int
    }

    type Dog struct {
        Breed string  //Makes it public by starting with Uppercase
        Weight int
    }


//Prints {1 2}
    func main() {
        v := Vertex{1, 2}   // 1. Creating a struct collection of fields
        v.X = 4             // 2. Accessing its field using a dot
        fmt.Println(v.X)
        fmt.Println(v)

        p := &v             // 3 Struct fields can be accessed through a struct pointer.
        p.X = 1e9
        fmt.Println(v)

        poodle := Dog{"Poodle", 34}
        fmt.Println(poodle)
        fmt.Printf("%+v\n", poodle)
        fmt.Printf("Breed: %v\nWeight: %v", poodle.Breed, poodle.Weight)
    }

```



## 1.7. Struct Literals

```go
    import "fmt"

    type Vertex struct {
        X, Y int
    }

    var (
        v1 = Vertex{1, 2}  // has type Vertex
        v2 = Vertex{X: 1}  // Y:0 is implicit
        v3 = Vertex{}      // X:0 and Y:0
        p  = &Vertex{1, 2} // has type *Vertex
    )

    func main() {
        fmt.Println(v1, v2, v3, p)
    }
```