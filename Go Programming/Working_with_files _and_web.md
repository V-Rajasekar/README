# Working with files and the Web

## Writing to a text file and reading from a text file
- Create a file with  `os.Create(fileName): file,error`
- check and display error in close with  `panic(errorRef)`  
- close the file in anycase with `defer file.Close()` 
- Write string content with `io.WriteString(fileRef, string_content):len_characters`
- Write byte content with `ioutil.WriteFile("./fromBytes.txt", bytes, 0644)`
- Read byte content with `content, err := ioutil.ReadFile(fileName)`
- To convert string to byte (e.g) `bytes := byte[string_ref]()`  
- To bytes to string (e.g) 	`result := string(content)`
  
```go

import (
	"fmt"
	"io"
	"io/ioutil"
	"os"
)

func main() {
	
	content := "Hello from Go!"

	file, err := os.Create("./fromString.txt")
	checkError(err)
	defer file.Close()
	
	ln, err := io.WriteString(file, content)
	checkError(err)
	
	fmt.Printf("All done with file of %v characters", ln)
	
	bytes := []byte(content)
    ioutil.WriteFile("./fromBytes.txt", bytes, 0644) //0644 is permission to the file
    
    //Reading from a text file
  
	fileName := "./hello.txt"
	
	content, err := ioutil.ReadFile(fileName)
	checkError(err)
	
	result := string(content)
	
	fmt.Println("Read from file:", result)	

}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
 
```

## Walking a directory tree
- Go is used to clean up directory structures on a file system. 
- Walk from the package filepath lets you walk a directory structure and work with each directory or file 
- walk function uses this recursive pattern and for the first time, we've seen the process of using a function as a type. As something that you can pass into another function as an object, so that it can then easily be called recursively. 

For more details: [Pkg filepath](https://golang.org/pkg/path/filepath)

```go

import (
	"fmt"
	"os"
	"path/filepath"
)

func main() {
	
	root, _ := filepath.Abs(".")
	fmt.Println("Processing path", root)
	
	err := filepath.Walk(root, processPath)
	if err != nil {
		fmt.Println("error:", err)
	}
}

func processPath(path string, info os.FileInfo, err error) error {
	if err != nil {
		return err
	}
	
	if path != "." {
		if info.IsDir() {
			fmt.Println("Directory:", path)
		} else {
			fmt.Println("File:", path)
		}
	}
	
	return nil
}
```

## GO REST
### Reading a text file from the web
- Go has a rich set of tools that let you work easily with web applications and services. The HTTP package lets you make requests and send data to remote hosts, and also lets you create HTTP server applications that listen for and respond to requests.
  
```go


import (
	"fmt"
	"net/http"
	"io/ioutil"
)

func main() {

	url := "http://services.explorecalifornia.org/json/tours.php"

	resp, err := http.Get(url)
    checkError(err) 	
	fmt.Printf("Response type: %T\n", resp)

	defer resp.Body.Close()
	
	bytes, err := ioutil.ReadAll(resp.Body)
	checkError(err)
	
	content := string(bytes)
	fmt.Print(content) 

}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
```
### Creating and parsing a JSON string
- Using `encoding/json` package you can decode the content retrieved from the service  
 

 ```go
import (
	"fmt"
	"net/http"
	"io/ioutil"
	"encoding/json"
	"strings"
	"math/big"
)

type Tour struct {
	Name, Price string // The field name should match with json label, and upper-casing the field names, even though the labels in the JSON data were lower case. That will export the fields, so that they're usable by the rest of the application
}

func main() {

	url := "http://services.explorecalifornia.org/json/tours.php"
	content := contentFromServer(url)

	tours := toursFromJson(content)
	// fmt.Println(tours)
	
	for _, tour := range tours {
		price, _, _ := big.ParseFloat(tour.Price, 10, 2, big.ToZero)
		fmt.Printf("%v ($%.2f)\n", tour.Name, price)
	}
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}

func contentFromServer(url string) string {
	
	resp, err := http.Get(url)
	checkError(err)
	
	defer resp.Body.Close()
	bytes, err := ioutil.ReadAll(resp.Body)
	checkError(err)

	return string(bytes)
}

func toursFromJson(content string) []Tour {
	tours := make([]Tour, 0, 20) //Creating a flexible slice of initial capacity 20
	
	decoder := json.NewDecoder(strings.NewReader(content))
	_, err := decoder.Token() //JSON decoder can't handle array object so removing the initial bracket from the JSON packet. The first one token itself so throwing away using _
	checkError(err)
	
	var tour Tour
	for decoder.More() {
		err := decoder.Decode(&tour) //Using pointer of Tour to populate tour object
		checkError(err)
		tours = append(tours, tour) // Adding to tours slice
	}
	
	return tours
}
 
 ``` 