# Shared Access signature
- Its a URI grants restricted access rights to AZ storage resources.
- It can point to 1..* storage resources
- THe URI contains token indicates a special set of query param defining the resources may be accessed by the client.
- A SAS is constructed from the SAS param and signed with the key 
- This SAS is used by the AZ storage to authorizee access to the storage resource.
  
## Types:
# **User delegation SAS**: **Applies to only BLOB storage.** Secured by AZAD credentials and the permission specified for the SAS.
- **Service SAS**:  Secured with the storage account key. Access to storage: Blob, Queue, Table storage or Azure files.
- **Account SAS**: Secured with storage account key. All the operations available via service or user delegation SAS are also available via an account SAS.

Note: User delegation SAS which is secured by Azure active directory is recommeded by Azure.

## How SAS works?
It works with two components
1. URI to the resource which you want ot access
2. SAS token that was created to authorze access to the resource.

```markdown
https://medicalrecords.blob.core.windows.net/patient-images/patient-116139-nq8z7f.jpg?sp=r&st=2020-01-20T11:42:32Z&se=2020-01-20T19:42:32Z&spr=https&sv=2019-02-02&sr=b&sig=SrW1HZ5Nb6MbRzTbXCaPm%2BJiSEn15tC91Y4umMPwVZs%3D,
```   

SAS token is made of the following components
- Access add,create, delete, list, write (sp=acdlw)
- st - access start date and time
- se - access end date and time
- sv - Storage API version
- sr - resource type b-blob
- sig - Crypto signature.

## When to use shared access
- Client who doesn't have permission to your resources.
- Client upload and download data via a `front-end proxy` service, which performs authentication. Disadvantage scaling on high demand time may be expensive or difficult
- `AZ SAS provider service` defining the access for the client in SAS and allowing access to storage resources directly with the permissions defined by the SAS and for the interval allowed by the SAS.
-  Additional authorization access is required in SAS for copying scenarion means copy a blob to another blob that resides in a diff storage account.
-  SAS authorize is a must when copying object, even if the source and destination objects reside within the same storage account.

## Explore stored access policies
- A stored access policy provides an additional level of control over (SAS) on the server side. Used to change the st, et time or permission for a signature after it has been issued.
- Supported storage resources: Blob, File shares, Queue and Tables.

## Creating a stored access policy.
- The star time, expiry time and the permissions for the signature must be mentioned in either SAS or stored access policy and not on both the places.
  - To create or modify a stored access policy
  - Use the `Set ACL` operations for the resource like (Set Container ACL, Set Share CL...) with the request body that specifies the terms of the access policy.
- Time to take effect on stored access policy changes is 30 seconds.

```markdown
az storage container policy create \
    --name <stored access policy identifier> \
    --container-name <container name> \
    --start <start time UTC datetime> \
    --expiry <expiry time UTC datetime> \
    --permissions <(a)dd, (c)reate, (d)elete, (l)ist, (r)ead, or (w)rite> \
    --account-key <storage account key> \
    --account-name <storage account name> \

```

- To `Remove` a single access policy call the resource's Set ACL operation passing the stored access policy identifier.
# Shared Access signature
- Its a URI grants restricted access rights to AZ storage resources.
- It can point to 1..* storage resources
- THe URI contains token indicates a special set of query param defining the resources may be accessed by the client.
- A SAS is constructed from the SAS param and signed with the key 
- This SAS is used by the AZ storage to authorizee access to the storage resource.
  
## Types:
# **User delegation SAS**: **Applies to only BLOB storage.** Secured by AZAD credentials and the permission specified for the SAS.
- **Service SAS**:  Secured with the storage account key. Access to storage: Blob, Queue, Table storage or Azure files.
- **Account SAS**: Secured with storage account key. All the operations available via service or user delegation SAS are also available via an account SAS.

Note: User delegation SAS which is secured by Azure active directory is recommeded by Azure.

## How SAS works?
It works with two components
1. URI to the resource which you want to access
2. SAS token that was created to authorze access to the resource.

```markdown
https://medicalrecords.blob.core.windows.net/patient-images/patient-116139-nq8z7f.jpg?sp=r&st=2020-01-20T11:42:32Z&se=2020-01-20T19:42:32Z&spr=https&sv=2019-02-02&sr=b&sig=SrW1HZ5Nb6MbRzTbXCaPm%2BJiSEn15tC91Y4umMPwVZs%3D,
```   

SAS token is made of the following components
- Access add,create, delete, list, write (sp=acdlw)
- st - access start date and time
- se - access end date and time
- sv - Storage API version
- sr - resource type b-blob
- sig - Cryptographic signature.

## When to use shared access
- Client who doesn't have permission to your resources.
- Client upload and download data via a `front-end proxy` service, which performs authentication. Disadvantage scaling on high demand time may be expensive or difficult.Alternate approach is `A lightweight service authenticates the client` as needed and then generates a SAS. Once the client application receives the SAS, they can access storage account resources directly 
- `AZ SAS provider service` defining the access for the client in SAS and allowing access to storage resources directly with the permissions defined by the SAS and for the interval allowed by the SAS.
-  Additional authorization access is required in SAS for copying scenarion means copy a blob to another blob that resides in a diff storage account.
-  SAS authorize is a must when copying object, even if the source and destination objects reside within the same storage account.

## Explore stored access policies
- A stored access policy provides an additional level of control over (SAS) on the server side. Used to change the st, et time or permission for a signature after it has been issued.
- Supported storage resources: Blob, File shares, Queue and Tables.



## Creating a stored access policy.
- The star time, expiry time and the permissions for the signature must be mentioned in either SAS or stored access policy and not on both the places.
  - To create or modify a stored access policy
  - Use the `Set ACL` operations for the resource like ( Set Container ACL, Set Queue ACL, Set Table ACL, or Set Share ACL.) with the request body that specifies the terms of the access policy.The body of the request includes a unique signed identifier of your choosing, up to 64 characters in length, and the optional parameters of the access policy
- Time to take effect on stored access policy changes is 30 seconds.

```markdown
az storage container policy create \
    --name <stored access policy identifier> \
    --container-name <container name> \
    --start <start time UTC datetime> \
    --expiry <expiry time UTC datetime> \
    --permissions <(a)dd, (c)reate, (d)elete, (l)ist, (r)ead, or (w)rite> \
    --account-key <storage account key> \
    --account-name <storage account name> \

```
## Modifying or revoking a stored access policy

To `remove` a single access policy, call the resource's Set ACL operation, passing in the set of signed identifiers that you wish to maintain on the container. To remove all access policies from the resource, call the Set ACL operation with an empty request body.


## Questions: 

Which of the following best practices provides the `most flexible` and `secure way` to use a service or account shared access signature (SAS)?
The most flexible and secure way to use a service or account SAS is to associate the SAS tokens with a stored access policy.

- To `Remove` a single access policy call the resource's Set ACL operation passing the stored access policy identifier.
# Shared Access signature
- Its a URI grants restricted access rights to AZ storage resources.
- It can point to 1..* storage resources
- THe URI contains token indicates a special set of query param defining the resources may be accessed by the client.
- A SAS is constructed from the SAS param and signed with the key 
- This SAS is used by the AZ storage to authorizee access to the storage resource.
  
## Types:
# **User delegation SAS**: **Applies to only BLOB storage.** Secured by AZAD credentials and the permission specified for the SAS.
- **Service SAS**:  Secured with the storage account key. Access to storage: Blob, Queue, Table storage or Azure files.
- **Account SAS**: Secured with storage account key. All the operations available via service or user delegation SAS are also available via an account SAS.

Note: User delegation SAS which is secured by Azure active directory is recommeded by Azure.

## How SAS works?
It works with two components
1. URI to the resource which you want to access
2. SAS token that was created to authorze access to the resource.

```markdown
https://medicalrecords.blob.core.windows.net/patient-images/patient-116139-nq8z7f.jpg?sp=r&st=2020-01-20T11:42:32Z&se=2020-01-20T19:42:32Z&spr=https&sv=2019-02-02&sr=b&sig=SrW1HZ5Nb6MbRzTbXCaPm%2BJiSEn15tC91Y4umMPwVZs%3D,
```   

SAS token is made of the following components
- Access add,create, delete, list, write (sp=acdlw)
- st - access start date and time
- se - access end date and time
- sv - Storage API version
- sr - resource type b-blob
- sig - Cryptographic signature.

## When to use shared access
- Client who doesn't have permission to your resources.
- Client upload and download data via a `front-end proxy` service, which performs authentication. Disadvantage scaling on high demand time may be expensive or difficult.Alternate approach is `A lightweight service authenticates the client` as needed and then generates a SAS. Once the client application receives the SAS, they can access storage account resources directly 
- `AZ SAS provider service` defining the access for the client in SAS and allowing access to storage resources directly with the permissions defined by the SAS and for the interval allowed by the SAS.
-  Additional authorization access is required in SAS for copying scenarion means copy a blob to another blob that resides in a diff storage account.
-  SAS authorize is a must when copying object, even if the source and destination objects reside within the same storage account.

## Explore stored access policies
- A stored access policy provides an additional level of control over (SAS) on the server side. Used to change the st, et time or permission for a signature after it has been issued.
- Supported storage resources: Blob, File shares, Queue and Tables.



## Creating a stored access policy.
- The star time, expiry time and the permissions for the signature must be mentioned in either SAS or stored access policy and not on both the places.
  - To create or modify a stored access policy
  - Use the `Set ACL` operations for the resource like ( Set Container ACL, Set Queue ACL, Set Table ACL, or Set Share ACL.) with the request body that specifies the terms of the access policy.The body of the request includes a unique signed identifier of your choosing, up to 64 characters in length, and the optional parameters of the access policy
- Time to take effect on stored access policy changes is 30 seconds.

```markdown
az storage container policy create \
    --name <stored access policy identifier> \
    --container-name <container name> \
    --start <start time UTC datetime> \
    --expiry <expiry time UTC datetime> \
    --permissions <(a)dd, (c)reate, (d)elete, (l)ist, (r)ead, or (w)rite> \
    --account-key <storage account key> \
    --account-name <storage account name> \

```
## Modifying or revoking a stored access policy

To `remove` a single access policy, call the resource's Set ACL operation, passing in the set of signed identifiers that you wish to maintain on the container. To remove all access policies from the resource, call the Set ACL operation with an empty request body.


## Questions: 

Which of the following best practices provides the `most flexible` and `secure way` to use a service or account shared access signature (SAS)?
The most flexible and secure way to use a service or account SAS is to associate the SAS tokens with a stored access policy.

A user delegation SAS is the most secure SAS, but isn't highly flexible because you must use Azure Active Directory to manage credentials.