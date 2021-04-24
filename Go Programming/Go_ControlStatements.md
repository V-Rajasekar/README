
- [1. Control Statements](#1-control-statements)
	- [1.1. For Loop](#11-for-loop)
	- [1.2. For is Go is "while"](#12-for-is-go-is-while)
	- [1.3. If condition](#13-if-condition)
	- [1.4. If else](#14-if-else)
	- [1.5. Switch statement](#15-switch-statement)

- [Go ReadMe Main](./Go_ReadMe.md)	 
  
## 1. Control Statements
`Go loop expressions are not enclosed inside ()`
### 1.1. For Loop
1. Index based for loop

```go
	func main() {
		for i := 0; i < 10; i++ {
		fmt.Println(i)
		}
	}
	//Prints 0-9
```

2. The init and post statements are optional. 

```go
	//Print 1-4
	func main() {
		sum := 1
		for ; sum < 5; {
			fmt.Println(sum)
			sum++
		}
		
	}

```

### 1.2. For is Go is "while"

```go
	//Print 1000
	func main() {
		sum := 1
		for sum < 1000 {
			sum += 1
		}
		fmt.Println(sum)
	}

```

```go

import "fmt"

func main() {

	sum := 1
	fmt.Println("Sum:", sum)
	
	colors := []string{"Red", "Green", "Blue"}
	fmt.Println(colors)
	

	sum = 0
	for i := 0; i < 10; i++ {
		sum += i
	}
	fmt.Println("Sum:", sum)

	//Looping slices
	for i := 0; i < len(colors); i++ {
		fmt.Println(colors[i])
	}

	//Looping slices using range
		for i := range colors {
		fmt.Println(colors[i])
	}
	
	//Go doesn'r have while loop. But you can create a similar loop using for loop
	//You can also shortcircuit the loop using break and goto lable stetments after a condition is meet
	sum = 1
	for sum < 1000 {
		sum += sum
		fmt.Println("Sum:", sum)
		if sum > 200 {
			goto endofprogram
		}
		if sum > 500 {
			break
		}
	}
	
	endofprogram : fmt.Println("end of program")

}


```
### 1.3. If condition

1. Basic if statement

```go
	if x < 0 {
			return sqrt(-x) + "i"
		}
   
```

2. If with a short statement
- Like for, the if statement can start with a short statement to execute before the condition. 
- Variables declared by the statement are only in scope until the end of the if. 

```go

	func pow(x, n, lim float64) float64 {
		if v := math.Pow(x, n); v < lim {
			return v
		}
		return lim
	}
```

### 1.4. If else

- Variables declared inside an if short statement are also available inside any of the else blocks. But not outside the condition block

```go
	func pow(x, n, lim float64) float64 {
		if v := math.Pow(x, n); v < lim {
			return v
		} else {
				fmt.Printf("%g >= %g\n", v, lim)
		}
		// can't use v here, though
		return lim
	}
```

### 1.5. Switch statement

- A switch statement is a short way to write a sequence of if - else statements. It runs the firstcase whos  value is equal to the condition expression. 
the break statement that is needed at the end of each case is provided automatically in Go unlike in other language (C, Java) where break is explicit

```go
	import (
		"fmt"
		"time"
	)

	func main() {
		fmt.Println("When's Saturday?")
		today := time.Now().Weekday()
		switch time.Saturday {
		case today + 0:
			fmt.Println("Today.")
		case today + 1:
			fmt.Println("Tomorrow.")
		case today + 2:
			fmt.Println("In two days.")
		default:
			fmt.Println("Too far away.")
		}
	}
```

- Switch without a condition is the same as switch true.

	This construct can be a clean way to write long if-then-else chains
	
```go

	import (
		"fmt"
		"time"
	)

	func main() {
		t := time.Now()
		fmt.Println(t.Hour())
		switch {
		case t.Hour() < 12:
			fmt.Println("Good morning!")
		case t.Hour() < 17:
			fmt.Println("Good afternoon.")
		default:
			fmt.Println("Good evening.")
		}
	}

```	
