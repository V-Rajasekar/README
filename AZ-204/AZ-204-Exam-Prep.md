When you don't know where and how to start preparing for the Az204 exam. Read through this document
which gives the steps I followed to complete my AZ204 exam with more than 90% score.

Go to https://learn.microsoft.com/ -> Learn  Certifications  Browse Certifications 
and search for the certification 

1.  [MS exams az-204](https://learn.microsoft.com/en-us/certifications/exams/az-204/)

2. Objective domain (OD) break down.
Weight of the skills to be covered in the exam

||||
|---|---|---|
|Group 1| 25 - 30%| Develop Azure compute solutions|
|Group 2| 15 - 20%| Develop for Azure storage|
|Group 3| 20 - 25%| Implement Azure security|
|Group 4| 15 - 20%| Monitor, trouble shoot, and optimize azure solutions|
|Group 5| 15 - 20%| Connect to and consume Azure services and 3rd party services|

3. Practise test
[AZ-204 Practise Assessment test](https://learn.microsoft.com/en-us/credentials/certifications/azure-developer/practice/assessment?assessment-type=practice&assessmentId=35&practice-assessment-type=certification)

# Develop AZ compute solutions
1.1. Implement containerized solutions
 - Use ACR to build and maintain container artifacts.
 `Task scenarios:` Quick task, Automatically triggered tasks, Multi-step task
 - Familiers with how to configure yml file to define the task and ACL task commands from CLI
 Azure container reg: It is used to store container image and used by deployment targets such as Orchetstration systems like AZ kubernetes, Azure services like App service, Azure Batch,
  Service Fabrics
 - Know how to configure repository and maintain, manage container images in the ACR.  
 ACR task to manage the images in container repository.
 - Azure Container Instances when and Why to ACI ? Similarly 
 when to use Azure kubernetes (AKS) instead of ACI?
 -  Explore AZ containe Instances(ACI)
  Where's option to configure the ACI
  **`Deployment:`** Deployment a multi-container group via ARM template
   or a YAML files. 
   ARM template is recommended when you want to deploy container 
   along with oher Azure services like FileShare
   YAML file format is more concise than the ARM and recommended for only container instance

   **Resource allocation:** Allocates resources such as CPUs, memory, 
   and optionally GPUs to a container group. An container group with two container instance requets for 1 cpu then it allocates 2 cpu for the container group.

   **Networking** Container with in the container groups share ipaddress, but needs to own their own port with in the ipaddress namespace.

   **storage** Specific ext volumns to mount within a container group. Map those volumes into specific paths within the individual containers in a container group.

   **Common scenarios:** Having separate container groups incase you want to divide  single functional taks to smaller no of container images. Like Application contain and logging container to collect log metrics from the APP, other case can be Front end container group and backend container groups.

   ## Creating solutions usings the Azure container Apps.
   Using Azure container apps you can run microservice and containerized application 
on a server less platform. You can deploy apps like Micro services, Background apps, Handle event-driven processing. 
AZ container apps advantange over ACI aris their ability to scale, scaling based on HTTP traffic, Event-driven processing, CPU or memory load, Any KEDA supported scaler.
- Difference container configuration options for the exam?
## How to create an Azure App service Web App. 
Difference between Azure app service plan and Azure app service web app?
App service plan can host multiple web app. 
which pricing tiers to choose for an given scenario?
**Scaling** In the free and shared tiers can't scale, they are based on the CPU mins on a shared VM
In other tiers, the App Service plan can scale to multiple instance you should know  the scaling limit on the standard, premium and isolated tiers 

Features of the App service Web App.

- Build in auto scale (up) support, scaled down is done manually.
- Scaling up is from standard tier and above
- Continuous integration/deployment support(AzureDevops, Github, FTP or local Git on your development machine)
- Deployment slots: Know how to work with deployment slots to aApp service web app.
- App Service on Linux you can't mix the windows App service web app and Linux Web App on the same App service plan.
## Enable diagnostic logging
- How to enable application logging in windows, Linux container ?
Comfortable with the following different scenarios for the exam.
- Enable web server logging, Add log message in code, Stream logs, Access log files.
How to configure the application settings for your web app? Add and edit app settings in bulk setting connection strings.

## Deploy to App Service
- How to configure the different deployments? Like Automated, Manual and deployment slots.
  
# Enable Autoscaling 

# Discover Azure Functions
- Comfortable with creating function code, config and structure.
- Able to configure the Function App
  -  configuration, pricing plan
  -  configuring triggers and binding for your functions
  -  Trigger and bindings definitions
     -   C# and Java library - decorating methods and parameters with C# attributes, and java using annotations
     -   Other languages(JS, python, Typescripts) updating function.json schema
- Familier with different triggers and bindings.
  
  Review: 
  1. Create and manage container images for solutions.
  2. Discover the Azure Container Registry and explore Azure Container instance (ACI)
  3. Create solutions by using Azure Container Apps and an Azure App Service Web App
  4. Enable diagnostics logging and configure application settings.
  5. Deploy to App Service
  6. Configure Settings in App Service
  7. Examine autoscale factors 
  8. Explore autoscale in App Service
  9. Explore autoscale best practices
  10. Explore Azure Functions development
  11. Create triggers and bindings

  






 Azure container register service tiers(Basic, Standard, Premium) difference 


1.2 Implement AZ App service web apps

1.2 Implement AZ functions


 
 
