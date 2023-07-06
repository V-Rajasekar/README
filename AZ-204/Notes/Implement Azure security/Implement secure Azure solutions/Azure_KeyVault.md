## Secure app configuration data by using App Configuration Azure Key Vault
- Azure Key Vault is a cloud service for securely storing and accessing API keys, passwords (secrets), certificates, cryptographic keys.
-Supports two type of containers: Vaults and Hardware security module(HSM) pools. 
-Vaults support storing software and HSM-backed keys, secrets, and certificates.
- HSM pools only support HSM-backed keys.
- Solves: secrets, key and Certificate management(SSL/TLS).
- Two service tiers: Standard and premium tier includes (HSM) protected keys.

## Key benefits of using Azure Key Vault
- **Securely store secrets and keys**: Access to a key vault is done via Azure Active Directory. Authorization may be done via (Azure Role based access) or Key Vault access policy.
- *Monitor access and use* can be configured to: Archive to a storage account, Stream to an event hub. Send the logs to Azure Monitor logs.

## Best practises
Three ways to authenticate to key valut:
- **Managed identities for Azure resources:** Assigning identity to VM, other AZ resources that has access to Key Vault.By this approach the service principal client secret associated with the identity are automatically rotated.
- **Service principal and certificate:** that has access to key vault. Not recommended
- **Service principal and secret:** to autnenticate to Key Vault, not recommeded.

**Encryption of data in transit**
- AZ keyvault uses (TLS) protocol to protect data when its traveling between AZ Key Vault and clients.
- Perfect Forward Secrecy(PFS) protects connections between customers client systems and MS clous services by unique keys.

- Use separate key vaults: per application per environment
- Control access to your vault: only authorized applications and users.
- Backup: Create regular backups of your vault on update/delete/create of objects within a Vault.
  
**Authenicate to Azure Key Vault**
For applications, there are two ways to obtain a service principal:
- Enable a system-assigned *managed identity* for the application. with managed identity, AZ internally manages the application's service principal and automatically authenticates the application with other AZ service.
- Other option is register the application with AZ AD tenant. Registration also creates a second application object that identifies the app across all tenants.

### Authenicating to Key vault`
-  `SDK` [Azure Identity SDK Java](https://docs.microsoft.com/java/api/overview/azure/identity-readme)
- `REST`  Access tokens must be sent to the service using the HTTP Authorization header:
```python

PUT /keys/MYKEY?api-version=<api_version>  HTTP/1.1
Authorization: Bearer <access_token>

-- Incase of failure
401 Not Authorized
WWW-Authenticate: Bearer authorization="…", resource="…"

```
The parameters on the WWW-Authenticate header are:

authorization: The address of the OAuth2 authorization service that may be used to obtain an access token for the request.

resource: The name of the resource (https://vault.azure.net) to use in the authorization request.



### Azure Key vaults
- what is Azure key vaults ?
   Its an Azure service to hold your encrypted keys, secrets and certificates
 
<h3>Lab: Azure Key Vault accessing secrets and Key using application Object.</h3>

Create a new Azure Key vault with the default permissions.
Register a new app names keyApp in the AZ AD App registration next create a client secret.

```c#
using Azure.Identity;
using Azure.Security.Secret;
using Azure.Security.KeyVault.Keys;


//Create a new APP(KeyApp) registration to get the following values.
String tenantId = "";
String clientId = "";
String clientSecret = "";


ClientSecretCredential accountCredentials = new ClientSecretCredential(tenantId, clientId, clientSecret);
String keyVaultURI = "https://appvault2030.valut.azure.net/"
String secretName = "dbconnectionString";



KeyClient keyClient = new KeyClient(new Uri(keyVaultURI), accountCredentials);
var key = keyClient.GetKey(keyName);


SecretClient secretClient = new SecretClient(new Uri(keyVaultURI), accountCredentials);
String dbConnectionString = secretClient.GetSecret(secretName).Value.Value; 
SqlConnection sqlConnection = new SqlConnection(dbConnectionString);
```

How to give required access to user and application in the Key Vault ? <br> 
Go to: Key vault -> Access policies -> Add Key permissions -> Select principal -> (Keyapp)


Questions: 
 - Managed Identities is the recommeded method of authenticating to Azure key vault.
 - Transport layer security protocol is used when data is travelling between AZ key vaults and client

## Resource
[Developer guide]([https://link](https://docs.microsoft.com/azure/key-vault/general/developers-guide))

  
