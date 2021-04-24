- [1. Go Basics](#1-go-basics)
	- [1.1. Characteristic of Go](#11-characteristic-of-go)
	- [1.2. Go essentials](#12-go-essentials)
		- [1.2.1. Go command line](#121-go-command-line)
		- [1.2.2. Creating and compiling Go workspace](#122-creating-and-compiling-go-workspace)
		- [1.2.3. Output string with fmt package](#123-output-string-with-fmt-package)
		- [1.2.4. Getting input from console](#124-getting-input-from-console)
	- [1.3. Exploring variables, constants and Type](#13-exploring-variables-constants-and-type)
		- [1.3.1. Variable declaration](#131-variable-declaration)
		- [1.3.2. Constant declaration](#132-constant-declaration)
		- [1.3.3. Basic types](#133-basic-types)
		- [1.3.4. Predeclared Complex Type](#134-predeclared-complex-type)
			- [1.3.4.1. Data Collections](#1341-data-collections)
			- [1.3.4.2. Language Organization](#1342-language-organization)
			- [1.3.4.3. Data Management](#1343-data-management)
	- [1.4. Working with Primitive Type conversion](#14-working-with-primitive-type-conversion)
	- [1.5. Working with string values](#15-working-with-string-values)
	- [1.6. Working with Arithmetic operators and math package](#16-working-with-arithmetic-operators-and-math-package)
	- [1.7. Working with dates and time](#17-working-with-dates-and-time)
	- [Conclusion](#conclusion)
		- [Concurrency in GO](#concurrency-in-go)
				- [Goroutine](#goroutine)
				- [Channel](#channel)
				- [Select](#select)
		- [Web Frameworks](#web-frameworks)
		- [Database Drivers](#database-drivers)

- [2. Types](./Go_Types.md) 	
- [3. Go Control Statements](./Go_ControlStatements.md) 	
- [4. Structuring Go Code](./Structuring_Go_Code.md)	 	

# 1. Go Basics
## 1.1. Characteristic of Go
1. Go is a compiled, statically types language (i.e) All variables have specific type associated to a variable at compile time variable types can be explicity mentioned or can inferred from the assigned value by the compiler at compilation time.
2. Compiled executables are OS specific (i.e) can't run application compiled in Windows on Mac
3. No external JVM required to run a Go application,  as the runtime is statically linked to Go application thats why the executable file is big in size.
4. Go has some object oriented program

**Supported**
 - You can define custom interfaces, customer types. Customer struct(data structures) and they can have member fields.
 
**Not Supported**
 -  No Type inheritance (no class) super type, sub type
 -  No Method or operator overloading
 -  No Structured exception handling like super class and subtypes and no try and catch finally
 -  No Implicit numeric conversions assigning int to float
 5. Go is designed as a next-gen language for C. Go borrows syntax from c, pascal
 6. Go is case sensitive.
 7. variable and package are lower and mixed case. 
 8. Exported functions and fields have an upper-case characters that has special meaning that is a field or function with 
  uppercase character is available to rest of the application like (Public) 
 9. Line feed ends a statement so no semicolon(;) required at the end of each line.
 10. Code blocks are wrapped with braces.
 11. starting brace on same line as preceding statement, Also parenthese are not required in conditional statements (e.g)

 ```
	for i=0; i < 5; i++ {
		fmt.Println(i)
	}
 ```
 12. Built-in-function and members of builtin package are always available in your code without explicitly importing.
	- len(string) - returns length of the given string
	- panic(error) - stops execution and displays error message
	- recover() - manage behaviour of a panicking goroutine.
	- for buildin packages see http://golang.org/pkg/builtin

## 1.2. Go essentials 
### 1.2.1. Go command line 
1. `go run`    - compile and run Go program (temp executable file)
2. `go build`  -   compile packages and dependencies
3. `go install` -  compile and install packages and dependencies (creates executable file under \bin)
4. checkout more details with `go help`

### 1.2.2. Creating and compiling Go workspace
-  create a goworkspace(go) with a structure similar to below steps
1. /home/user/go/
        src/
            foo/
                bar/               (go code in package bar)
                    x.go
		bin/
		pkg/
2. set GOPATH=/home/user/go
3. Run: go install
4. This creats a executable file .exe in bin/
5. set GOOS=darwin to create a executable file in diff OS, similarly you can executable app for different OS
  - This creates a executable file \bin\darwin\

For in detail [creating and compiling Go workspace](https://golang.org/doc/code.html)  

### 1.2.3. Output string with fmt package 
```
	str1 := "The quick red fox"
	str2 := "jumped over"
	str3 := "the lazy brown dog."
	aNumber := 42
	isTrue := true
	
	stringLength, _ := fmt.Println(str1, str2, str3) // _ dont want to care about err
	
	// if err == nil {
		fmt.Println("String length:", stringLength)
	// }
	
	fmt.Printf("Value of aNumber: %v\n", aNumber)
	fmt.Printf("Value of isTrue: %v\n", isTrue)
	fmt.Printf("Value of aNumber as float: %.2f\n", float64(aNumber)) // %.2f given floating number with 2 decimal point.
	
	fmt.Printf("Data types: %T, %T, %T, %T, and %T\n",
		str1, str2, str3, aNumber, isTrue)

	myString := fmt.Sprintf("Data types as var: %T, %T, %T, %T, and %T",
		str1, str2, str3, aNumber, isTrue) 
	fmt.Print(myString)

```
- For more details checkout [fmt](https://golang.org/pkg/fmt) package

### 1.2.4. Getting input from console
- For simple reading string  `var s fmt.Scanln(&s)`
- For reading complex input (i.e) sentence or series of word use bufio and os

```go

	import (
		"fmt"
		"bufio"
		"os"
		"strconv"
		"strings"
	)

	func main() {
 
        //Reading simple string value 
		  var s string
		  fmt.Scanln(&s)
		  fmt.Println(s)

        //Reading complex values using bufio and os
		reader := bufio.NewReader(os.Stdin)
		fmt.Print("Enter text: ")
		str, _ := reader.ReadString('\n')
		fmt.Println(str)
		
		fmt.Print("Enter a number: ")
		str, _ = reader.ReadString('\n')
		f, err := strconv.ParseFloat(strings.TrimSpace(str), 64)
		if err != nil {
			fmt.Println(err)
		} else {
			fmt.Println("Value of number:", f)
		}
	}
```

## 1.3. Exploring variables, constants and Type
 - Go is a statically types language. 
 - All variables have assigned types during compilation process
 - You can set type explicitly or implicitily by infering it from its assigned value 
 
 ### 1.3.1. Variable declaration  
 ` Explicit` 
  - var anInteger int = 45
  - var aString string = "I am Go"

  (e.g) var c, python, java bool // Package level
  	    var i, j int = 1, 2
 
 `Implicit`
  Using := assignment operator without var 
  - anInteger := 45 
  - aString := "Hello Go!"

  `:= short assigment are not allowed` **Outside a function** 
	
	When declaring a variable without specifying an explicit type (either by using the := syntax or var = expression syntax),  `variable's type is inferred from the value on the right hand side. `
	
	```
		var i int = 42
		j := i           // int
		f := 3.142        // float64
		g := 0.867 + 0.5i // complex128
		
		fmt.Printf("v is of type  %T %T %T\n",  j, f, g)
		//Output int float64 complex128
	
	```

### 1.3.2. Constant declaration 

` Explicit`
 - const anInteger int = 42

`Implicit`
 - const aString = "This is GO!"

`Note no := only type is omited`

### 1.3.3. Basic types
Go's basic types are 

- bool
- string
- int  int8  int16  int32  int64
- uint uint8 uint16 uint32 uint64 uintptr
- byte // alias for uint8
- rune // alias for int32
     // represents a Unicode code point
- float32 float64
- complex64 complex128

`Default values: bool - false, int - 0, string - "" `

```
	package main
	import (
		"fmt"
		"math/cmplx"
	)

	var (
		ToBe   bool       = false
		MaxInt uint64     = 1<<64 - 1
		z      complex128 = cmplx.Sqrt(-5 + 12i)
	) 

	func main() {
		fmt.Printf("Type: %v Value: %v\n", ToBe, ToBe)
		fmt.Printf("Type: %T Value: %v\n", MaxInt, MaxInt)
		fmt.Printf("Type: %T Value: %v\n", z, z)
	}
```
### 1.3.4. Predeclared Complex Type
#### 1.3.4.1. Data Collections 
	`Arrays` `Slices` `Map` `Structs` 
#### 1.3.4.2. Language Organization	
	`function - func` `Interfaces` `Channels`
#### 1.3.4.3. Data Management	 
	`Pointers` 


## 1.4. Working with Primitive Type conversion
The expression T(v) converts the value v to the type T. 

Some numeric conversions: 

- var i int = 42
- var f float64 = float64(i)
- var u uint = uint(f)

Or, put more simply: 
- i := 42
- f := float64(i)
- u := uint(f)

Unlike in C, in Go assignment between items of different type requires an explicit conversion. 
```
    var x, y int = 3, 4
	var f float64 = math.Sqrt(float64(x*x + y*y))
	var z uint = uint(f)
	fmt.Println(x, y, z)
``` 

## 1.5. Working with string values
- Use package [strings](https://golang.org/pkg/strings) to manipulate string 

```
str := "I am String"
strings.ToUpper(str)
strings.Title(str) // All words starting letter to upper case in the str
strings.EqualFold(str1, str2)  // Compare string equalIgnorecase
strings.contains(str1, "expression")
```

## 1.6. Working with Arithmetic operators and math package 
- Use package [maths](https://golang.org/pkg/math/) to work with mathematical operations 

```
	package main

	import (
		"fmt"
		"math/big"
		"math"
	)

	func main() {
		
		i1, i2, i3 := 12, 45, 68
		intSum := i1 + i2 + i3
		fmt.Println("Integer sum:", intSum)

		f1, f2, f3 := 23.5, 65.1, 76.3
		floatSum := f1 + f2 + f3
		fmt.Println("Float sum:", floatSum)

        //To have precision values use math/big
		var b1, b2, b3, bigSum big.Float
		b1.SetFloat64(23.5)
		b2.SetFloat64(65.1)
		b3.SetFloat64(76.3)
		bigSum.Add(&b1, &b2).Add(&bigSum, &b3)
		fmt.Printf("BigSum = %.10g\n", &bigSum)
		
		cirleRadius := 15.5
		circumference := cirleRadius * math.Pi
		fmt.Printf("Circumference: %.2f\n", circumference)
	}

```

## 1.7. Working with dates and time 
- Use package [time](https://golang.org/pkg/time/)  
- Create Date 
   - time.Date(year, monthm date, hour, min, sec, nano sec, Timezone)
   - t:= time.NOW()
- Manipulating date
   - tomorrow := t.AddDate(0, 0, 1) // tommorroe date   
- Formatting date
   - tommorrow.   

```
package main

import (
	"fmt"
	"time"
)

func main() {
	t := time.Date(2009, time.November, 10, 23, 0, 0, 0, time.UTC)
	fmt.Printf("Go launched at %s\n", t)
	
	now := time.Now()
	fmt.Printf("The time now is %s\n", now)
	
	fmt.Println("The month is", t.Month())
	fmt.Println("The day is", t.Day())
	fmt.Println("The weekday is", t.Weekday())
	
	tomorrow := t.AddDate(0, 0, 1)
	fmt.Printf("Tomorrow is %v, %v %v, %v\n",
		tomorrow.Weekday(), tomorrow.Month(), tomorrow.Day(), tomorrow.Year())
		
	longFormat := "Monday, January 2, 2006"
	fmt.Println("Tomorrow is", tomorrow.Format(longFormat))
	shortFormat := "1/2/06"
	fmt.Println("Tomorrow is", tomorrow.Format(shortFormat))
	
}

```

## Conclusion
### Concurrency in GO
##### Goroutine
- A lightweight synchronized thread managed by the runtime
##### Channel
- A type conduit for message between goroutines
##### Select
- Lets a goroutine wait for multiple communication process

### Web Frameworks
[build-a-rest-api-in-go](https://nordicapis.com/7-frameworks-to-build-a-rest-api-in-go/)

[Web Framework comparision](https://github.com/diyan/go-web-framework-comparison)

### Database Drivers

- Standard database functions: database/sql
- Driver interfaces: database/sql/driver
- Available for relational and NoSQL databases.

