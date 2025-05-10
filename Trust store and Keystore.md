To create the `signed-cert.crt` from the `cert-request.csr`, you need a Certificate Authority (CA) to sign the request. If you're using a self-signed CA, follow these steps:

### **Step-by-Step Process**
#### **1. Generate a Self-Signed CA Certificate**
```sh
openssl req -new -x509 -days 365 -key ca.key -out ca.crt -subj "/CN=MyCA"
```
- This creates a self-signed CA certificate (`ca.crt`) valid for 365 days.

#### **2. Sign the Certificate Signing Request (CSR)**
```sh
openssl x509 -req -in cert-request.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out signed-cert.crt -days 365 -sha256
```
- This signs the CSR using the CA certificate and private key, generating `signed-cert.crt`.

#### **3. Verify the Signed Certificate**
```sh
openssl x509 -in signed-cert.crt -text -noout
```
- This displays the details of the signed certificate.

You can find more details on signing certificates [here](https://stackoverflow.com/questions/21297139/how-do-you-sign-a-certificate-signing-request-with-your-certification-authority) and [here](https://stackoverflow.com/questions/54421916/openssl-creating-a-certificate-from-a-csr-no-private-key-stored-in-another-sy). Let me know if you need further clarification! 🚀

The error **"Illegal base64 character 20"** usually occurs when decoding a Base64 string that contains unexpected characters, such as spaces or special symbols. Here are some possible causes and solutions:

### **Possible Causes**
1. **Spaces in the Encoded String**  
   - If your Base64 string contains spaces, it might be due to improper encoding or transmission issues.  
   - Example: `"3aW0qv4pN y3Tj8raXDHtos95ChpLu2JzEnfW KfgEE="` (spaces should not be present).

2. **Incorrect Encoding Format**  
   - Ensure you're using the correct Base64 encoder/decoder.  
   - Example: `Base64.getEncoder().encodeToString(bytes)` for encoding and `Base64.getDecoder().decode(encodedString)` for decoding.

3. **URL Encoding Issues**  
   - If your Base64 string is being passed in a URL, characters like `+` may be converted to spaces.  
   - Solution: Use `Base64.getUrlEncoder()` instead of `Base64.getEncoder()`.

### **Solutions**
#### **1. Remove Spaces Before Decoding**
```java
String cleanedBase64 = encodedString.replaceAll("\\s+", "");
byte[] decodedBytes = Base64.getDecoder().decode(cleanedBase64);
```

#### **2. Use URL-Safe Encoding**
```java
String encodedUrlSafe = Base64.getUrlEncoder().encodeToString(bytes);
byte[] decodedUrlSafe = Base64.getUrlDecoder().decode(encodedUrlSafe);
```

#### **3. Verify Encoding Format**
Ensure that the Base64 string is properly encoded before decoding.

You can check out more details on this issue [here](https://stackoverflow.com/questions/42917768/console-error-illegal-base64-character-20) and [here](https://stackoverflow.com/questions/28584080/base64-java-lang-illegalargumentexception-illegal-character). Let me know if you need further debugging help! 🚀


Certainly! If your **JKS file name contains spaces**, you need to handle it properly in the OpenSSL Base64 encoding command. Here’s how:

### **Command Handling Spaces in File Names**
#### **Encoding JKS to Base64**
```sh
openssl base64 -in "my keystore.jks" | tr -d '\n' > "my keystore.b64"
```
- **`"my keystore.jks"`**: Wrap the file name in **quotes** to handle spaces.
- **`tr -d '\n'`**: Removes newline characters to ensure a single-line Base64 output.
- **`> "my keystore.b64"`**: Saves the output to a file with spaces handled.

#### **Decoding Base64 Back to JKS**
```sh
openssl base64 -d -in "my keystore.b64" -out "my keystore.jks"
```
- This restores the original JKS file from the Base64-encoded version.

### **Alternative Approach (Without Output File)**
If you want to encode directly to the terminal:
```sh
openssl base64 -in "my keystore.jks" | tr -d '\n'
```
- This prints the Base64 output **without line breaks**.

To decode from a Base64 string:
```sh
echo "BASE64_STRING_HERE" | openssl base64 -d > "my keystore.jks"
```

Would you like help integrating this into a script or storing it securely? 🚀

Here’s a complete **Java project** that reads a **JKS (Java KeyStore) file**, converts it to **Base64**, and includes necessary dependencies for compilation, execution, and testing.

---

## **1. Project Structure**
```
JKSBase64Converter/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.example.jksbase64/
│   │   │   │   ├── JKSBase64Converter.java
│   │   │   │   ├── KeystoreUtils.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── com.example.jksbase64/
│   │   │   │   ├── KeystoreUtilsTest.java
│── keystore.jks
│── pom.xml (For Maven)
│── build.gradle (For Gradle)
```

---

## **2. Dependencies**
If using **Maven**, include this in `pom.xml`:
```xml
<dependencies>
    <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.11.0</version>
    </dependency>
</dependencies>
```

If using **Gradle**, include this in `build.gradle`:
```gradle
dependencies {
    implementation 'org.apache.commons:commons-io:2.11.0'
}
```

---

## **3. Java Classes**

### **`JKSBase64Converter.java` (Main Application)**
```java
package com.example.jksbase64;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class JKSBase64Converter {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java JKSBase64Converter <keystore.jks>");
            return;
        }

        String jksFilePath = args[0];
        try {
            String base64Encoded = KeystoreUtils.convertJKSFileToBase64(jksFilePath);
            System.out.println("Base64 Encoded JKS:\n" + base64Encoded);
        } catch (Exception e) {
            System.err.println("Error processing JKS file: " + e.getMessage());
        }
    }
}
```

### **`KeystoreUtils.java` (Utility Class)**
```java
package com.example.jksbase64;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class KeystoreUtils {
    public static String convertJKSFileToBase64(String jksFilePath) throws Exception {
        byte[] fileBytes = Files.readAllBytes(Paths.get(jksFilePath));
        return Base64.getEncoder().encodeToString(fileBytes);
    }
}
```

---

## **4. Testing**
### **`KeystoreUtilsTest.java` (JUnit Test)**
```java
package com.example.jksbase64;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KeystoreUtilsTest {
    @Test
    public void testBase64Encoding() throws Exception {
        String base64String = KeystoreUtils.convertJKSFileToBase64("src/test/resources/sample.jks");
        assertNotNull(base64String);
        assertFalse(base64String.isEmpty());
    }
}
```

---

## **5. Compilation & Execution**
### **Compile and Run**
```sh
javac -d out -cp . src/main/java/com/example/jksbase64/*.java
java -cp out com.example.jksbase64.JKSBase64Converter keystore.jks
```

### **Run Tests**
If using **Maven**:
```sh
mvn test
```
If using **Gradle**:
```sh
gradle test
```

---

## **6. Additional Improvements**
- **Store JKS securely in HashiCorp Vault**  
- **Logging using Log4J or SLF4J**  
- **Handle password-protected Keystores**

Would you like enhancements or integration with Vault storage? 🚀