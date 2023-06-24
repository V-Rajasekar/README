1. Azure Blob service
- Creating a storage account <br>
  `az storage account create -n $storageAccountName --resource-group $resource --sku Standard_LRS`
- Verifying storage account is present <br>
` az storage account show -g $resource -n $storageAccountName`
- Storing the storage account access key as its required in container creation<br>
 `storageKey=$(az storage account keys list -g $resource -n $storageAccountName --output json --query [0].value)`
- Creating a container named myfiles passing account name and access key<br> 
 `az storage container create -n myfiles --account-name $storageAccountName --account-key $storageKey`
- Verifying container is created <br>
  `az storage container list --account-name $storageAccountName --account-key $storageKey`
- Create a new text file.<br>
  `echo "This is my first blob file. I will upload it to my first container!" > blob.txt`
- Upload the new text file to the container<br>
  `az storage blob upload --account-name $storageAccountName --account-key $storageKey --container-name myfiles --file blob.txt --name blob.txt`
- List the blob container to verify the blob.txt is present.<br>
  `az storage blob list --account-name $storageAccountName --account-key $storageKey --container-name myfiles`
   

2. Working with Azure Table storage
Azure Table storage is an Azure storage account service for storing nonrelational structured data (also known as structured NoSQL data) in the cloud, providing a key/attribute store with a schema-less design.

- storageKey=$(az storage account keys list -g $resource -n $storageAccountName --output json --query [0].value)
- Create table(people): `az storage table create --name people --account-name $storageAccountName --account-key $storageKey`
- Verify table in table list: `az storage table list --account-name $storageAccountName --account-key $storageKey`
- Insert new record: `az storage entity insert --entity PartitionKey=0001 RowKey=SN123456 Name=John Last=Smith Email=john.Smith@test.com --if-exists fail --table-name  people --account-name $storageAccountName --account-key $storageKey`
- verify table entry: `az storage entity query --table-name people --account-name $storageAccountName --account-key $storageKey`
- Delete entry: `az storage entity delete --table-name people --partition-key 0001 --row-key SN123456 --account-name $storageAccountName --account-key $storageKey`
- Delete table: `az storage table delete --name people --account-name $storageAccountName --account-key $storageKey`
- Delete storage account: `az storage account delete -n $storageAccountName -g $resource`
- List storage account in a resource group: `az storage account list -g $resource`

3. Azure Queue storage
Azure Queue Storage is an Azure storage account service for storing large numbers of messages. You access messages from anywhere in the world via authenticated calls using HTTP or HTTPS.

- Create Queue: `az storage queue create --name orders --account-name $storageAccountName --account-key $storageKey`
- Lsit Queue: `az storage queue list --account-name $storageAccountName --account-key $storageKey`
- Insert record: `az storage message put --content "order=1x_cheese_pizza" --queue-name orders --account-name $storageAccountName --account-key $storageKey`
- Retrieve Record: `az storage message peek --queue-name orders --account-name $storageAccountName --account-key $storageKey`
- Delete Queue: `az storage queue delete --name orders --account-name $storageAccountName --account-key $storageKey`

4. Azure File Share

- `az storage share create --name documents --account-name $storageAccountName --account-key $storageKey`
- `az storage share list --account-name $storageAccountName --account-key $storageKey`
- `echo "This is a document to be shared with the company employees!" > mydocument.txt`
- `az storage file upload --share-name documents --source ./mydocument.txt --account-name $storageAccountName --account-key $storageKey`
- `az storage file list --share-name documents --account-name $storageAccountName --account-key $storageKey`
- `az storage file delete --share-name documents --path mydocument.txt --account-name $storageAccountName --account-key $storageKey`
- `az storage file list --share-name documents --account-name $storageAccountName --account-key $storageKey`
- `az storage share delete --name documents --account-name $storageAccountName --account-key $storageKey`
- `az storage share list --account-name $storageAccountName --account-key $storageKey`
  
Syntax:

- operation: create, list, delete
 > az storage <account/table/queue/share> <operation> --name <resource name> --account-name <accountName> --account-key <accountKey> 
- Insert new record:
- Blob: prerequest container. 
`az storage blob upload --account-name $storageAccountName --account-key $storageKey --container-name myfiles --file blob.txt --name blob.txt`

table:  `az storage entity insert --entity PartitionKey=0001 RowKey=SN123456 Name=John Last=Smith Email=john.Smith@test.com --if-exists fail --table-name  people --account-name $storageAccountName --account-key $storageKey`

- Queue:  `az storage message put --queue-name orders  --content "order=1x_cheese_pizza" --account-name $storageAccountName --account-key $storageKey`
- Insert = put, retrieve=peek, delete  
- Share: `az storage file upload --share-name documents --source ./mydocument.txt --account-name $storageAccountName --account-key $storageKey`  
- Insert = upload --source <source file>, delete = delete --share-name <share name> --path mydocument.txt
