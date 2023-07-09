# what are the different ways of authenticate, authorize in AZ to access resource ?

- **Method1:** Authorizing access using the `connection String embedded with AccountKey`.
- **Method2:** Use of the `application object and subsequently using managed identity`.(ClientSecretCredentials) 
 The application will authenticate itself with the Azure AD using the (tenantId, clientId, clientSecret)
- **Method3:**  Using Postman with application object we could access the graph api and storage api.
 `Step 1:` Get the access token using POST API call to https://login.microsoftonline.com/<tenantId>/oauth2/v2.0/token with header grant_type=client_credentials,client_id,
 client_secret,scope=https://graph.microsoft.com/default
 `Step 2:` GET graph API to get the user details.
## Adding Authentication using the Microsoft Identity 
- **Method4:** Authorization code grant flow.(Oauth Authorization grant flow)
1. Add an APP in AZ AD app registration
2. Configure the microsoft authentication URL htpps://login.microsoftonline.com, clientId, tenantId.
3. Use Microsoft.Identity.Web ASP.Net Core library to authenticate and authorize support to web apps and API's integrating with  the Microsoft Identity platform
> - OAuth used the OpenID protocol to perform the authentication
## Adding Authorization
1. Go to the Registered APP settings -> Authentication -> Add a platform (Web)
2. Next-> Configure Redirection URL (localhost:7046) enable  I.T tokens are made available, i.e. tokens can be used to actually identify the user who is signing in.
3. login to the app with a registered user
> Note: While authenticating an Web application we were using the delegate permission and not providing the `_Grant Admin consent_` unlike we did it for postman.this is because we want to get the user constents to read their basic profiles.
5. Go to API persmission > configure the signin-oidc, signout-oidc url

## Getting User claims or Authorization: 
You can get the information about the user in AZ active directly by enabling the following property in APP that is is registered in AZ active directory.
 APP -> Authentication -> ID tokens.
**Acquiring Group claim:** <br>
- Go to the `APP -> TokenConfiguration -> Add group claim`
- Add optional claim:` APP -> TokenConfiguration -> Optional claim` once you add (e.g) email permission. Automatically you will see the in the API permissions

## Getting an access token.
```
Case: User A wants to access the storage account via your application. 
User -> APP -> Storage account
```
What we have to do ? 
Here we first have to grant user access permission on the storage account, then for the app
to access with the user_impersonation. 
1. Go to storage account -> I AM permission -> Add user with Read, Storage data read role
2. Go to App -> API permission -> Storage account -> Delegate -> Permission User_impersonation.
Next Authentication -> Enable Access tokens(used for implict flows).

## Accessing storage account through POSTMAN
1. Provide read access role in Storage account for the POSTMAN App, create client_secret
2. GET call to https://login.microsoftonline.com/{tenantId}/oauth2/v2.0/token with params grant_type=client_credentials, scope=http://storage.azure.com/.default
   client_id, client_secret. 
3. Get Call to the storage https://btfsandbox12.blob.core.windows.net/tfstate/storage-account/storageaccount.tfstate   with Authorization Bearer <token from previous step resp>, x-ms-version=2017-11-09

## Calling Protected API(Product API) from PostMan
`Step 1:` Protecting the API (Product API) <br>
Prerequest App registration for both the Product API and the Postman client. Next change the Product API App config >   manifesto property having accessTokenAcceptedVersion = "2", since we want to use OAuth2.0 for authenication and authorization. 
2. Do relevant code/config changes in your API to get access token pass/config client_id, tenant_id (Product API), Instance=https://login.microsoftonline.com/
3. Go to ProductAPI > `App roles` (allowing applications to interact with this API) > create new app role ProductAccess
4. Product API > Expose an API > set Application ID URI > copy the ID value
5. GET call to https://login.microsoftonline.com/{tenantId}/oauth2/v2.0/token with params `grant_type=client_credentials, scope=<ID URL value from previous step> client_id, client_secret` of Postman APP object.
6. Go to Product API > API permissions > My APIs > Product API > Product Access > Grant Admin consents   
6. Trigger step 5 to get the access token
7. Call Product API with header > `Authorization Bearer <access token>`




  

