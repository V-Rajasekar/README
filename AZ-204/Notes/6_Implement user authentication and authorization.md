<h1>Implement user authentication and authorization</h1>

## Authenticate and authorize users by using the Microsoft Identity platform
what is Azure active directory?
- This is a cloud based identity ad access management service.
- It basically helps in authentication and it can also help in the authorization for users to access resources or applications within an on premise environment.
- You can manage identities such as users, groups, and even application.
- Manage security aspects when it comes to identity.
- This can uses as an identity provider for Azure Microsoft 365 and other sas products as well.

What are the tiers available in AZ active directory and its benefits?

|Tier|Benefits|
|---|---|
|Free||
|Premium p1||
|Premium p2||

```tex
what is role based access control (RBAC) ? 
Azure role-based access control (Azure RBAC) helps you manage who has access to Azure resources, what they can do with those resources, and what areas they have access to.

Role can be applied at the subscription, Resource group, and resource.

What are the default roles available in RBAC ? 
Contributor, Owner, Read. 

what is application object?
- An application object is used as a template or blueprint to create one or more service principal objects
- An application object is defined/registered in Azure active directory.
```

How to create an application object and assign the roles ? 
1. Go to Azure Active directory -> App registration -> Create New Application object (Application Identity). (e.g) Blob App
2. Suppose you want to give the read access to the storage account, reading the blob within the container of the storage account then
   Go to -> Storage account -> Access control ( I AM) choose role Read -> Add role assignment -> select Blob App now this application identity has access to 
   reading the properties of the storage account
   Add one more role -> Storage Blob Data Reader -> select Blob App, Now the application identity can read the blob within the container of that storage account.

How to use this application identity in your program ? 
Copy the clientId, tenentId available in Application Identity, Create a new client secret in the Application object configuration (clientSecret)

```c#
using Azure.Identity;
using Azure.Storage.Blobs;

String clientId = "";
String tenantId = "";
String clientSecret = "";

String blobUri = "https://stoageaccountname.blob.core.windows.net/data/script.sql"
ClientSecretCredential accountCredentials = new ClientSecretCredential(tenantId, clientId, clientSecret);
BlobClient serviceClient = new BlobClient(new Uri(blobUri), accountCredentials);
await blobClient.DownloadToAsync(filePath);

```


## Authenticate and authorize users and apps by using Microsoft Azure Active Directory (Azure AD), part of Microsoft Entra

## Create and implement shared access signatures

## Implement solutions that interact with Microsoft Graph
What is Microsoft Graph in Azure?
Microsoft Graph is a RESTful web API that enables you to access Microsoft Cloud service resources. After you register your app and get authentication tokens for a user or service,
 you can make requests to the Microsoft Graph API.

Microsoft Graph provides access to data stored across Microsoft 365 services. Custom applications can use the Microsoft Graph API to connect to data 
and use it in custom applications to enhance organizational productivity.

Reading All users in the Azure Active directory. 
1. Register an application i Azure AD `(PostmanClient)`
2. Provide permissions
> Note: Two types of permissions `1. Delegated permissions (RUNS on behalf of the user, you have to signin) 2. Application permissions (Runs on behalf of the application)`
3. Provide admin consent
4. Finally call the Graph API.

To get the access token which has to be pased in Microsoft Graph API call. Go to the Application Identity(PostmanClient) in the Azure AD -> End points -> OAuth 2.0 token endpoint
Make an API call with 
POST `https://login.microsoftonline.com/4343-534545-45454/oauth2/v2.0/token`
under `x-www-form-urlencoded` add the following params
`grand_type=client_credentials`, `client_id=<your Application Object's clientId>`, `client_secret= <your Application Object's clientSecret>`, `scope=https://graph.microsoft.com/.default`

GET https://graph.microsoft.com/v1.0/users
Authorization Bearer <access token copied from earlier call>
> Note: Eveytime you have to generate the access token if you have changed the access permission on you application object, because the access token which is generated its not only based on your app object, but also the permissions granted on to your app object. 

### Azure Key vaults
- what is Azure key vaults ?
   Its an Azure service to hold your encrypted keys, secrets and certificates
 
Lab: Azure Key Vault secrets.

```c#
using Azure.Identity;
using Azure.Security.Secret;

String tenantId = "";
String clientId = "";
String clientSecret = "";


ClientSecretCredential accountCredentials = new ClientSecretCredential(tenantId, clientId, clientSecret);
String keyVaultURI = "https://appvault2030.valut.azure.net/"
String secretName = "dbconnectionString";

SecretClient secretClient = new SecretClient(new Uri(keyVaultURI), accountCredentials);
String dbConnectionString = secretClient.GetSecret(secretName).Value.Value; 
SqlConnection sqlConnection = new SqlConnection(dbConnectionString);
```

How to give required access to user and application in the Key Vault ? <br> 
Go to: Key vault -> Access policies -> Add Key permissions -> Select principal -> (Keyapp)

Lab: Configure managed identity and access to storage account.
Managed identity are special identity available in Azure services like Azure VM. This allows us to create and identity and register in Azure VM.
Step1: Go to Azure VM where in your application is going to be hosted -> Identity -> System assigned identity
Step2: Go to Storage account a) assign Reader role 2) assign Storage Blob Data Read role for that VM name(AppName)

```c#
using Azure.Core;
using Azure.Identity;
using Azure.Storage.Blobs;


String blobUri = "https://stoageaccountname.blob.core.windows.net/data/script.sql"
TokenCredential credentials = new DefaultAzureCredential();
BlobClient serviceClient = new BlobClient(new Uri(blobUri), credentials);
await blobClient.DownloadToAsync(filePath);

```

Lab: Managed Identity - Getting access token from Azure Instance Metadata Service (IMDS) endpoint. 

`GET 'http://169.254.169.254/metadata/identity/oauth2/token?api-version=2018-02-01&resource=https://management.azure.com/' HTTP/1.1 Metadata: true`
> Note: 169.254.169.254 is the standard Azure Instance Metadata service, Resource= Basically Azure services like `https://storage.azure.com` and HttpHeader Metadata=true.

Lab: Managed Identity - Using access token to access the blob.s
Make an HttpCall to Blob present in the container using the blobURI passing the header `Authenication: Bearer <token>`

<h4>Types of Managed Identities</h4>

- `System Assigned Identities:`  Identities which are assigned per Azure resources like Azure VM, Azure WebApp service, then you have to go to the individual resource to grant access to those Identities(e.g) storage account assign roles
- `User Assigned Identities:` A single identities is a managed resources in Azure like Azure group, or Azure VM and it can be used across the Azure resources Also, Even when the resource is deleted the identity still remains there. User Assigned identities are good for management perspective.
