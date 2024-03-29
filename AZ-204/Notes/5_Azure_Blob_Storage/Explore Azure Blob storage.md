# Develop solutions that use blob storage

# Set and retrieve properties and metadata
# Perform operations on data by using the appropriate SDK
# Implement storage policies, and data archiving and retention
# Implement static site hosting

what is Azure Blob storage? 
- Microsoft's object storage solution for the cloud
- For storing massive amount of unstructured data like text or binary data.
- Designed for Storing files for distributed access, Streaming audio and video, data for backup
  and restore, disaster recovery, and archiving.
- Accessable via HTTP/HTTPS. REST API, Azure PowerShell, Azure CLI, or an Azure Storage client library
- Azure storage account is the top container for all of the Azure Blob storage. It provides a unique 
  namespace for Azure storage data that is accessible from anywhere in the world over HTTP or HTTPS.

## Types of storage account.
- **Standard** general-purpose v2 account. Recommended for most scenarios using Azure storage.
- **Premium** High performance by using solid-state drive. If you create a premium account you can choose between three account types: **_block blobs, page blobs, or file shares_**.

|Storage account type |     Supported storage services| Detail|
|-----|------|------|
|Standard general-purpose v2 |Blob, Queue, and Table storage, Azure Files| This is standard storage for blobs, file shares, queues and tables.|
|Premium block blobs|Blob storage|This is supported for block and appen blobs. This is when you want fast access to your blobs, high transaction rates.|
|Premium page blobs|Page blobs only|When you want fast access to your blobs, high transaction rates.|
|Premium file shares|Azure Files|When you want fast access to your files, high transaction rates.|


## Evaluate Azure Storage redundancy options
Data in an Azure Storage account is always replicated three times in the primary region.
|Redundancy||
|---|---|
|**Locally redundant storage (LRS)**| copies three times within a single physical locations in the primary region.|
| | Least expensive replication option|
||Not suitable for high availability or durability|
|**Zone-redundant storage (ZRS)**| Copies three times  across three Azure availability zones in the primary region.| 
||High availability|
|**Geo-redundant storage (GRS)**| 3 copies in the single physical locations in the primary region using LRS and then 3 copies in the single physical locations in the secondary region using LRS |
|**Geo-zone-redundant storage (GZRS)** | 3 Copies across three Azure availability zones in the primary region using ZRS and then in the secondary region using ZRS|

Note: GRS and GZRS are the secondary region redundancy options

<h3>Blob services</h3>
The blob service is optimized for storing large amounts of unstructured data. So if you want to store files such as your images, your videos, etc., you can post it using the blob service.

<p>You can then have an application that could be hosted on an as the virtual machine accessing these objects that are stored using the blob service in your Azure storage account.
 Now when you start using the blob service as part of your storage account, you create something known has a container.So this is like having a folder allowed folder for your objects.
 </p>

You will create a container and then within this container you will start uploading objects such as your files, images, your videos, etc..

Now each of these is going to be uploaded, has an object, a binary object onto the service, and you

also get a unique you order for each object that is part of the blob service.

Once you upload an object to the container you get a unique Blob storage endpoint like:
 `http://mystorageaccount.blob.core.windows.net/data/AZ-204.jpg`
Note: mystorageaccount - Its the storage account name, blob.core.windows.net - service name, data - container name, and AZ-204.jpg is the object stored in the container.

**Accessing the storage blob objects:**
Change acccess level -> Blob (anonymous read access for blobs only).
Access keys
Shared Access keys 

**Three types of Blob types are:**
- **Block blobs**  store text and binary data, up to 4.7 TB
- **Append blobs** similar to block blob optimized for append operations.Ideal for logging data from VM.
- **Page blobs** stores random access files upto 8 TB. Page blobs store virtual hard drive (VHD) files and serve as disks for Azure virtual machines.


## Access tiers for block blob data
**Hot**: Frequently accessed data, Accessing data is cheap, but storing costs are higher
- New storage accounts are created in the hot tier by default. 
**Cool**: Large amounts of data that is infrequently accesses and stored for atleast 30 days.
**Archive**: Available only for individual Block blobs.For atleast 180 days.Its the most cheapest access tier for storage, but accessing the data is more expensive.

## Resource types
**Storage account**, **container** in the storage account,** A blob** in the container


A storage account can contain unlimited container and a container can contain unlimited blob within it.


### Azure Storage security features
- All data (including metadata) written to Azure Storage is automatically encrypted using Storage Service Encryption (SSE).
-  Azure Active Directory (Azure AD) is supported for blob and queue data operations 
- Use AD for Resource management operations such as key management.
-  Role-Based Access Control (RBAC) You can assign RBAC roles  scoped to a subscription, resource group, storage account, or an individual container or queue to a security principal or a managed identity for Azure resources.
-  Data can be secured in transit between the application and Azure using 
  Client side Encryption, HTTPS, or SMB 3.0
- OS, VM, and data disk can be encrypted using Azure Disk Encryption.
- Delegated access to the Azure storage can be granted using Shared access signature.
-  `Data in Azure Storage is encrypted and decrypted transparently using 256-bit AES encryption`
-  Enryption is enable by default for Azure storage accounts and cannot be disabled.
-  Encrption are default regardless of the tier (Standard or premium) or deployment model (Azure resource Manager or classic)
-  There is no extra cost for the default encryption.

### Encryption key management
- **A customer-managed key** is used to encrypt and decrypt all data in all services in your storage account.
- **A customer-provided key** on Blob storage operations. A client making a read or write request against Blob storage can include an encryption key on the request for granular control over how blob data is encrypted and decrypted.


## Blob Access policy
Access tier can be set while uploading a blob or after uploading.
|Tier| Details|
|---|---|
|Hot and Cold| Access tier at blob and Account level|
|Archieve| Only blob level|
|Hot and Cold| Support all redundant options|
|Archieve|Supports only LRS, GRS, and RA-GRS.|
- Data storage limit are set at the account level and  not per access tier(Hot, Coldm Archive).

## Manage the data lifecycle
- Life cycle management policy rules are available to move aging data to cooler tiers.
- Delete blobs at the end of their lifecycles.
### Implement storage policies, and data archiving and retention

Below is a storage policy containing a rule definition with filter set and action set.
The filter set limits rule actions to a certain set of objects within a container or objects names. The action set applies the tier or delete actions to the filtered set of objects.

```json 
{
  "rules": [
    {
      "name": "ruleFoo",
      "enabled": true,
      "type": "Lifecycle",
      "definition": {
        "filters": {
          "blobTypes": [ "blockBlob" ],
          "prefixMatch": [ "container1/foo" ]
        },
        "actions": {
          "baseBlob": {
            "tierToCool": { "daysAfterModificationGreaterThan": 30 },
            "tierToArchive": { "daysAfterModificationGreaterThan": 90 },
            "delete": { "daysAfterModificationGreaterThan": 2555 }
          },
          "snapshot": {
            "delete": { "daysAfterCreationGreaterThan": 90 }
          }
        }
      }
    }
  ]
}
```
## Rule actions
- Actions are applied to the filtered blobs when the run condition is met.
- Some sample actions: tierToCool, enableAutoTierToHotFromCool, tierToArchive and delete.
- delete is cheaper than action tierToArchive. Action tierToArchive is cheaper than action tierToCool.
- The run conditions are based on age. Base blobs use the last modified time to track age, and blob snapshots use the snapshot creation time to trach age.
- **Run condition:** daysAfterModificationGRaterThan, daysAfterCreationGreaterThan.
   
## Rehydrate blob data from the archive tier.
There are two options for rehydrating a blob that is stored in the archive tier.
- **Copy an archived blob to an new blob in the hot or cool tier** with the Copy Blob or Copy Blob from URL operation
  - 
  - Copying an archived blob to an online destination tier is supported within the same storage account only. You cannot copy an archived blob to a destination blob that is also in the archive tier.
  - 
- **Change a blob's access tier to an online tier**  By changing its tier using the `Set Blob Tier` operation.

### Priority
 using optional header `x-ms-rehydrate-priority` the rehydration operation can be properitized 
- **Standard priority:** 15 hours 
- **High priority:**: Rehyrdation prioritized over standard prioritzed and done in an hour for objects under 10 GB in size.

To check the rehydration priority while the rehydration operation is underway, call Get Blob Properties to return the value of the x-ms-rehydrate-priority header. The rehydration priority property returns either Standard or High.

 Azure Blob storage lifecycle management offers a rich, rule-based policy for General Purpose v2 and Blob storage accounts.

 What you should know about ?

 <h3>Exam pre questions</h3>
Set and retrieve properties and metadata for blob resources by using REST
Explore Azure Blob storage client library
Explore the Azure Blob storage lifecycle
Discover Blob storage lifecycle policies
Implement static site hosting


How to perform operations using the Azure Blob storage client library. Find the class purpose 
BlobClient - Allows to manipulate AZ Storage blobs.
BlobClientOptions - Provides the client conf options for connecting to AZ Blob Storage.
BlobContainerClient - Allows to manipulate AZ storage containers and their blobs.
BlobServiceClient = Allows to manipulate AZ Storage service resources and blob containers. The storage account provides the top-level namespace for the Blob service.
BlobUriBuilder: Provides a convenient way to modify the contents of a URI instance to point to diff AZ storage resources like an account, container, or blob

