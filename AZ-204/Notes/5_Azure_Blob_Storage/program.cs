using Azure.Storage;
using Azure.Storage.Blobs;
using Azure.Storage.Blobs.Models;
using System;
using System.Threading.Tasks;    
 public class Program
 {
     //Update the blobServiceEndpoint value that you recorded previously in this lab.        
     private const string blobServiceEndpoint = "https://storage811931788.blob.core.windows.net/";

     //Update the storageAccountName value that you recorded previously in this lab.
     private const string storageAccountName = "storage811931788";

     //Update the storageAccountKey value that you recorded previously in this lab.
     private const string storageAccountKey = "9y5ZEqxFdD7Lalcbyti1cf4tvAG2p5yEIaeGlZDAeLgTCnFgZwKjTwsGybS6e6AnnwQ3BnkGIDGY+AStrAk0Pw==";    

     

     //The following code to create a new asynchronous Main method
     public static async Task Main(string[] args)
     { 
        //The following line of code to create a new instance of the StorageSharedKeyCredential class by using the storageAccountName and storageAccountKey constants as constructor parameters
        StorageSharedKeyCredential accountCredentials = new StorageSharedKeyCredential(storageAccountName, storageAccountKey);
        //The following line of code to create a new instance of the BlobServiceClient class by using the blobServiceEndpoint constant and the accountCredentials variable as constructor parameters
        BlobServiceClient serviceClient = new BlobServiceClient(new Uri(blobServiceEndpoint), accountCredentials);

        //The following line of code to invoke the GetAccountInfoAsync method of the BlobServiceClient class to retrieve account metadata from the service
         AccountInfo info = await serviceClient.GetAccountInfoAsync();
         await Console.Out.WriteLineAsync($"Connected to Azure Storage Account");
         await Console.Out.WriteLineAsync($"Account name:\t{storageAccountName}");
         await Console.Out.WriteLineAsync($"Account kind:\t{info?.AccountKind}");
         await Console.Out.WriteLineAsync($"Account sku:\t{info?.SkuName}");

        await EnumerateContainersAsync(serviceClient);
        string existingContainerName = "raster-graphics";

        await EnumerateBlobsAsync(serviceClient, existingContainerName);
         
        BlobContainerClient containerClient = await GetContainerAsync(serviceClient, existingContainerName);

        string uploadedBlobName = "graph.svg";
        BlobClient blobClient = await GetBlobAsync(containerClient, uploadedBlobName);
        await Console.Out.WriteLineAsync($"Blob Url:\t{blobClient.Uri}");

     }

    private static async Task EnumerateContainersAsync(BlobServiceClient client)
    {   
        /*Create an asynchronous foreach loop that iterates over the results of 
            an invocation of the GetBlobContainersAsync method of the BlobServiceClient class. */    
        await foreach (BlobContainerItem container in client.GetBlobContainersAsync())
        {   
            //Print the name of each container
            await Console.Out.WriteLineAsync($"Container:\t{container.Name}");
        }
    }

    private static async Task EnumerateBlobsAsync(BlobServiceClient client, string containerName)
    {   
        /* Get a new instance of the BlobContainerClient class by using the
            GetBlobContainerClient method of the BlobServiceClient class, 
            passing in the containerName parameter */   
        BlobContainerClient container = client.GetBlobContainerClient(containerName);

        /* Render the name of the container that will be enumerated */
        await Console.Out.WriteLineAsync($"Searching:\t{container.Name}");

        /* Create an asynchronous foreach loop that iterates over the results of
            an invocation of the GetBlobsAsync method of the BlobContainerClient class */
        await foreach (BlobItem blob in container.GetBlobsAsync())
        {     
            //Print the name of each blob    
            await Console.Out.WriteLineAsync($"Existing Blob:\t{blob.Name}");
        }
    }

    private static async Task<BlobClient> GetBlobAsync(BlobContainerClient client, string blobName)
    {   
        /* Get a new instance of the BlobClient class by using the GetBlobClient method
            of the BlobContainerClient class, and to pass in the blobName parameter */   
        BlobClient blob = client.GetBlobClient(blobName);

        /* Render the name of the blob that was referenced */
        await Console.Out.WriteLineAsync($"Blob Found:\t{blob.Name}");

        /* Return blob as the result of the GetBlobAsync method */
        return blob;
    }

    private static async Task<BlobContainerClient> GetContainerAsync(BlobServiceClient client, string containerName)
        {   
        /* Get a new instance of the BlobContainerClient class from BlobServiceClient */   
        BlobContainerClient container = client.GetBlobContainerClient(containerName);

        /* Invoke the CreateIfNotExistsAsync method of the BlobContainerClient class */
        await container.CreateIfNotExistsAsync(PublicAccessType.Blob);

        /* Render the name of the container that was potentially created */
        await Console.Out.WriteLineAsync($"New Container:\t{container.Name}");

        /* Return the container as the result of the GetContainerAsync */        
        return container;
        }
    }

 //output 
 Connected to Azure Storage Account
Account name:   storage811931788
Account kind:   StorageV2
Account sku:    StandardLrs
Container:      compressed-audio
Container:      myfiles
Container:      raster-graphics
Container:      vector-graphics
Searching:      raster-graphics
Existing Blob:  graph.PNG
New Container:  raster-graphics
Blob Found:     graph.svg
Blob Url:       https://storage811931788.blob.core.windows.net/raster-graphics/graph.svg
