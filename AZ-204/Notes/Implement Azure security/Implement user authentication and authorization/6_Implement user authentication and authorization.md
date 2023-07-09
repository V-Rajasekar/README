<h1>Implement user authentication and authorization</h1>

- [Authenticate and authorize users by using the Microsoft Identity platform](#authenticate-and-authorize-users-by-using-the-microsoft-identity-platform)
- [Authenticate and authorize users and apps by using Microsoft Azure Active Directory (Azure AD), part of Microsoft Entra](#authenticate-and-authorize-users-and-apps-by-using-microsoft-azure-active-directory-azure-ad-part-of-microsoft-entra)
- [Discover permissions and consent.](#discover-permissions-and-consent)
- [Permission types](#permission-types)
- [Consent types](#consent-types)
- [Configuring  managed identities](#configuring--managed-identities)
  - [System-assigned managed identity](#system-assigned-managed-identity)
  - [New VM with managed identity](#new-vm-with-managed-identity)
  - [Enable system-assigned managed identity on an existing AZ machine.](#enable-system-assigned-managed-identity-on-an-existing-az-machine)
  - [User-assigned managed identity](#user-assigned-managed-identity)
    - [Creating a user-assigned identity](#creating-a-user-assigned-identity)
    - [Assign a user-assigned managed identity during the creation of an Azure virtual machine](#assign-a-user-assigned-managed-identity-during-the-creation-of-an-azure-virtual-machine)
- [Implement solutions that interact with Microsoft Graph](#implement-solutions-that-interact-with-microsoft-graph)
- [Create and implement shared access signatures](#create-and-implement-shared-access-signatures)

## Authenticate and authorize users by using the Microsoft Identity platform

The Microsoft identity platform for developers is a set of tools that includes authentication service, open-source libraries, and application management tools.
<h4>Exploring Application object and service principal</h4>
To delegate Identity and access management functions to AZ Active directory, an application must register with an AZ active directory tenant. When you register an application, an application object(global uniqid: clientID) and a service principal object are automatically created in your home tenant. 

`what is application object?`<br>
- An application object is used as a template or blueprint to create one or more service principal objects
- An application object resides in the AZ active directory tenant where the application was registered.

`what is service prinicipal object ?`<br>
 A service principal is created in every tenant where the application is used. Similar to a class in object-oriented programming, the application object has some static properties that are applied to all the created service principals (or application instances).

<h4>Service principal object</h4>
The security principal defines the access policy and permissions for the user/application in the Azure Active Directory tenant. This enables core features such as authentication of the user/application during sign-in, and authorization during resource access.<br>

**Type of Service principal:** <br>
1. `Application:` A service principal is created in each tenant referencing the global unique app object.The service principal object defines what the app can actually do in the specific tenant, who can access the app, and what resources the app can access
2. Managed identity provide an identitiy for applications to use when connecting to resources(Key vault) that support Azure AD authentication
- Types:
  - `A System assigned managed identity`
    - Identity is enabled directly on an Azure service instance like Azure VM, Azure WebApp service, then you have to go to the individual resource to grant access to those Identities(e.g) storage account, Azure function assign roles. Azure creates an identity for the instance in the Azure AD tenant that's trusted by the subscription of the instance. If the instance is deleted Azure automatically cleans up the credentials and the identity in Azure AD.
  - `A use-assigned managed identity.`
    - Its created as a standalone Azure resource. After the identity is created by the Azure, the identity can be assigned to one or more service instances. Its a single identities is a managed resources in Azure like Azure group, or Azure VM and it can be used across the Azure resources Also, Even when the resource is deleted the identity still remains there. User Assigned identities are good for management perspective.
  
  |Characteristic|System-assigned managed|User-assigned|
  |---|---|---|
  |Creation| Creation as a part of an Azure resource(Azure VM)|Created as a stand-alone Azure resource|
  |Lifecycle|When parent resource is deleted the the identity is deleted|Independent life-cycle|
  |Sharing across Azure resources|Cannot be shared, it can only be associated with a single Azure resource.|Can be shared the same user-assigned managed identity can be associated with more than one Azure resource.|

> Note **Managed Identity are special type of Identities available in some Azure service like Azure VM, Azure Web App. When you create a Managed identity on such type of resource then an service principal is created automatically in Azure AD. Go to the resource where in you need the access like Storage blob, Azure Key Vault (Add access policy) and select the service principal.**
 

1. `Legacy`  A legacy service principal can have credentials, service principal names, reply URLs, and other properties that an authorized user can edit, but doesn't have an associated app registration. As the app created before app registrations. The service principal can only be used in the tenant where it was created.

what is Azure active directory?<br>
- This is a cloud based identity ad access management service.
- It basically helps in authentication and it can also help in the authorization for users to access resources or applications within an on premise environment.
- You can manage identities such as users, groups, and even application.
- Manage security aspects when it comes to identity.
- This can use as an identity provider for Azure Microsoft 365 and other sas products as well.

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
 
```



## Authenticate and authorize users and apps by using Microsoft Azure Active Directory (Azure AD), part of Microsoft Entra
**Discover permissions and consent**


## Discover permissions and consent.
- MS identitiy platform implements the OAuth2.0 authorization protocol. Its a method through which a 3rd party app can access web-hosted resources on behalf of a user. 
- Any wen-hosted resources that integrated with the MS identity platform has a resource identifier like Microsoft
- web-hosted resources: Azure Key Vault: https://vault.azure.net
-  Any of these resources also can define a set of permissions that can be used to divide the functionality of that resource into smaller chunks. When a resource's functionality is chunked into small permission sets, third-party apps can be built to request only the permissions that they need to perform their function. Users and administrators can know what data the app can access.
-  In OAuth2.0 these types of permission sets are called scopes. Often referred to as permissions.
-   Identity platform supports several well-defined OpenID Connect scopes as well as resource-based permissions (each permission is indicated by appending the permission value to the resource's identifier or application ID URI). For example, the permission string https://graph.microsoft.com/Calendars.Read is used to request permission to read users calendars in Microsoft Graph.scope=User.Read is equivalent to https://graph.microsoft.com/User.Read

## Permission types
- **Delegated permissions **  The app is delegated with the permission to act as a signed-in user when it makes calls to the target resource.
- **Application permissions ** apps that run as background services or daemons. Only an administrator can consent to application permissions.

## Consent types
There are three consent types: static user consent, incremental and dynamic user consent, and admin consent.

**static user consent**
In the static user consent scenario, you must specify all the permissions it needs in the app's configuration in the Azure portal. If the user (or administrator, as appropriate) has not granted consent for this app, then Microsoft identity platform will prompt the user to provide consent at this time.

The app needs to request all the permissions it would ever need upon the user's first sign-in. This can lead to a long list of permissions that discourages end users from approving the app's access on initial sign-in.
**Incremental and dynamic user consent**

You can ask for a minimum set of permissions upfront and request more over time as the customer uses additional app features by inclusing the new scopes in the scope parameter when requesting an access token - without the need to predefined them in the application registration information.

 If the user hasn't yet consented to new scopes added to the request, they'll be prompted to consent only to the new permissions. Incremental, or dynamic consent, only applies to delegated permissions and not to application permissions.

 **Admin consent**

 Admin consent done on behalf of an organization still requires the static permissions registered for the app.

 Admin consent ensures that administrators have some additional controls before authorizing apps or users to access highly privileged data from the organization.

<h3>How to create an application object and assign the roles ? </h3>
1. Go to Azure Active directory -> App registration -> Create New Application object (Application Identity). (e.g) Blob App
2. Suppose you want to give the read access to the storage account, reading the blob within the container of the storage account then
   
- Go to -> Storage account -> Access control ( I AM) choose role Read -> Add role assignment -> select Blob App now this application identity has access to 
   reading the properties of the storage account
-  Add one more role -> Storage Blob Data Reader -> select Blob App, Now the application identity can read the blob within the container of that storage account.

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

<h3>Lab: Configure managed identity(System assigned) and access to storage account.</h3>
Managed identity are special identity available in Azure services like Azure VM. This allows us to create and identity and register in Azure VM.<br>

Step1:`Configure managed identity for Azure VM` Go to Azure VM where in your application is going to be hosted -> Identity -> System assigned identity
Note: Step 1 will create a new APPRegisration in AZ active directory.
Step2: Go to Storage account a) assign Reader role 2) assign Storage Blob Data Read role for that VM name(AppName)

```c#
using Azure.Core;
using Azure.Identity;
using Azure.Storage.Blobs;


String blobUri = "https://stoageaccountname.blob.core.windows.net/data/script.sql"
TokenCredential credentials = new DefaultAzureCredential();
//Note DefaultAzureCredential automatically take the accessToken if the following credential types like ManagedIdentity credential.
BlobClient serviceClient = new BlobClient(new Uri(blobUri), credentials);
await blobClient.DownloadToAsync(filePath);

```
<h3>Lab: Managed Identity - Getting access token from Azure Instance Metadata Service (IMDS) endpoint.</h3> 

`GET 'http://169.254.169.254/metadata/identity/oauth2/token?api-version=2018-02-01&resource=https://management.azure.com/' HTTP/1.1 Metadata: true`
> Note: 169.254.169.254 is the standard Azure Instance Metadata service, Resource= Basically Azure services like `https://storage.azure.com` and HttpHeader Metadata=true.

Lab: Managed Identity - Using access token to access the blob.s
Make an HttpCall to Blob present in the container using the blobURI passing the header `Authenication: Bearer <token>`

## Configuring  managed identities
  You can configure an Azure virtual machine with a managed identity during, or after, the creation of the virtual machine. Below are some CLI examples showing the commands for both 
  system- and user-assigned identities.

 ### System-assigned managed identity
 Prerequest: **Virutal Machine Contributor** role assignment is required. No additional Azure AD directory role assignments are required.

### New VM with managed identity
`Creation an virtual machine with a system-assigned managed identity, as requested by the --assign-identity parameter. admin credentials are the Virtal machine admin sign-in credentials`

```bash
az vm create --resource-group myResourceGroup \
    --name myVM --image win2016datacenter \
    --generate-ssh-keys \
    --assign-identity \
    --admin-username azureuser \
    --admin-password myPassword12

``` 
### Enable system-assigned managed identity on an existing AZ machine.
Use `az vm identity assign` command enable the system-assigned identity to an existing virtual machine.

`az vm identity assign -g myResourceGroup -n myVm`

### User-assigned managed identity
Prerequest: **Virtual Machine Contributor** and **Managed Identity Operator** role assignments.

Enabling user-assigned managed identities is a two-step process:

1. Create the user-assigned identity

2. Assign the identity to a virtual machine
  
#### Creating a user-assigned identity

```bash
az identity create -g myResourceGroup -n myUserAssignedIdenti
```

#### Assign a user-assigned managed identity during the creation of an Azure virtual machine

**Creating a new VM with the user assigned identity**

```bash
    az vm create \
    --resource-group <RESOURCE GROUP> \
    --name <VM NAME> \
    --image UbuntuLTS \
    --admin-username <USER NAME> \
    --admin-password <PASSWORD> \
    --assign-identity <USER ASSIGNED IDENTITY NAME>
```

Assign a user-assigned managed identity to an existing AZ machine

```bash
az vm identity assign \
    -g <RESOURCE GROUP> \
    -n <VM NAME> \
    --identities <USER ASSIGNED IDENTITY>
```
## Implement solutions that interact with Microsoft Graph
What is Microsoft Graph in Azure?
- `Microsoft Graph API`  with a single REST endpoint (`https://graph.microsoft.com`)that enables you to access Microsoft Cloud service resources.<br>  

Microsoft Graph provides access to data stored across Microsoft 365 services. Custom applications can use the Microsoft Graph API to connect to data 
and use it in custom applications to enhance organizational productivity.<br>

Which of the components of the Microsoft 365 platform is used to deliver data external to Azure into Microsoft Graph services and applications?<br>
- `Microsoft Graph connectors` Delivering data external to the Microsoft cloud into Microsoft Graph services and applications. Microsoft Graph connectors work in the incoming direction. Connectors exist for many commonly used data sources such as Box, Google Drive, Jira, and Salesforce.
  
- `Microsoft Graph Data Connect` provides a set of tools to streamline secure and scalable delivery of Microsoft Graph data to popular Azure data stores.

<h3>LAB: Reading All users in the Azure Active directory through `POSTMAN`</h3>

1. Go to  Azure AD -> App registrations-> Add new registration `(Postman)`
2. Next Azure AD -> API permission By default Microsoft Graph (User.Read) permission is provided in all the newly registered APP.
3. Add permission -> Application permission -> User.Read.All -> Grant admin consent for Default Directory
4. Go to the Postman application object -> Certificates & secrets -> Generate client secret.
   
> Note: Two types of permissions `1. Delegated permissions (RUNS on behalf of the user, you have to signin) 2. Application permissions (Runs on behalf of the application) Only an administrator can consent to app-only access permissions.`
1. Provide admin consent
2. Finally call the Graph API.

- Step 1: Generate access token
To get the access token which has to be pased in Microsoft Graph API call.Read A Go to the Application Identity(Postman) in the Azure AD -> End points -> OAuth 2.0 token endpoint
Make an API call with 
`POST` `https://login.microsoftonline.com/4343-534545-45454/oauth2/v2.0/token`
under `x-www-form-urlencoded` add the following params
`grand_type=client_credentials`, `client_id=<your Application Object's clientId>`, `client_secret= <your Application Object's clientSecret>`, `scope=https://graph.microsoft.com/.default`

- Step 2: Call to Graph API to get all users.

`GET` https://graph.microsoft.com/v1.0/users
Header: `Authorization` value: `Bearer <access token copied from earlier call>`

> Note: Eveytime you have to generate the access token if you have changed the access permission on you application object, because the access token which is generated its not only based on your app object, but also the permissions granted on to your app object. 


## Create and implement shared access signatures
[Shared Access signature](./Shared%20Access%20signature.md)
