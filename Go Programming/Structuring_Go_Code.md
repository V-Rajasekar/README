- [1. Structuring Go Code](#1-structuring-go-code)
	- [1.1. Packages and functions](#11-packages-and-functions)
	- [1.2. Functions](#12-functions)
	- [1.3. Defining function as member/method of Custom Types](#13-defining-function-as-membermethod-of-custom-types)
	- [1.4. Defining and implementing interfaces](#14-defining-and-implementing-interfaces)
	- [1.5. Handling errors](#15-handling-errors)
	- [1.6. Deferring function calls](#16-deferring-function-calls)
  
- [Go ReadMe Main](./Go_ReadMe.md)	 

# 1. Structuring Go Code

## 1.1. Packages and functions 
Every Go program is made up of packages. 

Programs start running in main package. 

This program is using the packages with import paths "fmt" and "math/rand". 

By convention, the package name is the same as the last element of the import path. For instance, the "math/rand" package comprises files that begin with the statement package rand. 

In Go, a name is exported if it begins with a capital letter. For example, Pizza is an exported name, as is Pi, which is exported from the math package. 

```go
package main

	import (
		"fmt"
		"math/rand"
		"math"
	)

	func main() {
		fmt.Println("My favorite number is", rand.Intn(10))
		fmt.Println(math.Pi) //Pizza is an exported name as Pi
	}

```
 
 ## 1.2. Functions
 - Go functions can take 0 or more arguments. `Notice the type comes after the variable name`
 - function access privelege (public, private) is decided based on the initial function method char function start with lowercase is private and with upper case is public.
 - Go can return multiple values from function.
 - `No method overloading in GO` each function name has to be unique eventhough the method signature is different.
  
 ```go
	func swap(x, y string) (string, string) {
		return y, x
	}
	//Running 
	func main() {
		a, b := swap("hello", "world")
		fmt.Println(a, b)
	}

 ```
-  `Naked Return function` A return statement without arguments returns the named return values. This is known as a "naked" return. 
 
 ```go

    func main() {
       fullName, length := FullName("Sana", "Rajasekar")
       fmt.Printf("FullName: %V  No of Char: %V", fullName, length)

       fullName, length := FullName("Yugan", "Rajasekar")
       fmt.Printf("FullName: %V  No of Char: %V", fullName, length)
       
    }

	func FullName(f, l string) (string, int) {
        full := f + " " + l
        length := len(full)
        return full, length
    }

    func FullNameNakedReturn(f, l string) (full string, length int) {
        full = f + " " + l //Notice its not := as the variable is already declared in the param
        length = len(full)
        return 
    }

 ```

## 1.3. Defining function as member/method of Custom Types
- In Java a function/method is a member of a class where as in Go a funct is a member of a type. 

```go
import "fmt"

type Dog struct {
	Breed string
	Weight int
	Sound string
}

func (d Dog) Speak() {
	fmt.Println(d.Sound)
}

func (d Dog) SpeakTwoTimes() {
	d.Sound = fmt.Sprintf("%v! %v!", d.Sound, d.Sound)
	fmt.Println(d.Sound)
}

func (d *Dog) SpeakThreeTimes() {
	fmt.Println("Before: "+ d.Sound)
	d.Sound = fmt.Sprintf("%v! %v! %v!", d.Sound, d.Sound, d.Sound)
	fmt.Println(d.Sound)
}

func main() {
	poodle := Dog{"Poodle", 37, "Woof"}
	fmt.Println(poodle)
	poodle.Speak()
	
	poodle.Sound = "Arf"
	poodle.Speak()
	
	//Pass by value
 	poodle.SpeakTwoTimes() // Prints Arf! Arf!
 	poodle.SpeakTwoTimes() // Arf! Arf!

	fmt.Println("Method call with by passBy Reference pointer") 
	//Pass by reference using pointer *Dog 
	poodle.SpeakThreeTimes() //Prints Arf! Arf! Arf!
	poodle.SpeakThreeTimes() // Arf! Arf! Arf! Arf! Arf! Arf! Arf! Arf! Arf! 
}

```

## 1.4. Defining and implementing interfaces 
- `No implements keyword` Unlike in Java there is no keyword like implements in Go to implement an interface. If a type implements all of the methods defined in a interface, then it's an implementation of that interface. 
- `Every type og Go is an implementation of some interface` And whether or not there's a specific interface that it implements with a specific set of methods, every type also is an implementation of a no-methods interface simply named "Interface."
(e.g) fmt package many of the functions receives a set of arguments, an arbitrary number of objects that implements an interface of some kind.  
- `In Go every simple value is an instance of type (an int, a string, a byte and so on) and every type is an implementation of atleast one interface`

```go

import "fmt"

type Animal interface {
	Speak() string
}

type Dog struct {
}

func (d Dog) Speak() string {
	return "Woof!"
}

type Cat struct {
}

func (c Cat) Speak() string {
	return "Meow!"
}

type Cow struct {
}

func (c Cow) Speak() string {
	return "Moo!"
}

type Tree struct {
	
}

func main() {
	poodle := Animal(Dog{})
	fmt.Println(poodle)
	
	animals := []Animal{Dog{}, Cat{}, Cow{}}
	for _, animal := range animals {
		fmt.Println(animal.Speak())
	}
}

```

## 1.5. Handling errors
- No classic exception-handling sytax (try, catch and finally). 
- There is n't super-type exception and subtypes for different exception-handling syntax.
- Error in Go is an instance of an interface  that defines a single method, named error, and that method returns a string and that string is the error message

```go

import (
	"fmt"
	"os"
	"errors"
)

func main() {
	f, err := os.Open("filename.ext")

	if err == nil {
		fmt.Println(f)
	} else {
		fmt.Println(err.Error())
	}
	
	//Creating a customer error object with error message using errors
	myError := errors.New("My error string")
	fmt.Println(myError)

	//Checking whether a key is present in a map, if present ok with be true and attended=value of the lookup key
	attendance := map[string]bool{
		"Ann": true,
		"Mike": true}
	attended, ok := attendance["M"]
	if ok {
		fmt.Println("Mike attended?", attended)
	} else {
		fmt.Println("No info for Mike")
	}

}

```

## 1.6. Deferring function calls

Go's "defer" statement does exactly what it says. It defers execution of a block of code until everything else in the current function is finished.

Each time you call the "defer" statement, it adds an instruction to a stack, and when the deferred statements are executed, they're handled in last in, first out order, known as LIFO. Here's a demonstration. 

