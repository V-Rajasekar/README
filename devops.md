
## Running in CI with Public Github runner:

Postgres: use Postgres Test Containers. It uses dockerized version of the Postgres. Easy to configure with Spring integration https://www.testcontainers.org/modules/databases/jdbc/. Test cases to manage table creation and  insert required data.
Kafka: use Spring embedded Kafka
Cosmos: We have 2 choices here, tests cases can connect to either:
Create Cosmos for test purpose in SIT environment (400RUs - monthly cost ~230 NOK)
Use Windows VM and install Cosmos emulator (low configuration B2S instance - monthly cost ~400 NOK)
         Considering this we will go with option 1 since its a cheaper option with minimal overhead 

## Creation of TAG in Github and ACR

Gradle release plugin is used to create the TAG for each release before image are pushed to Azure container registry



https://github.com/researchgate/gradle-release

Release plugin perform below steps

Check if projects is using any SNAPSHOT dependency
Build the project
Remove the snapshot from version
Increment the snapshot version and commit gradle.properties file
Create release tag from current version in gradle.properties file
Check in the TAG in github
Post release : Publish artifacts to Github packages

Gradle release supported branches : Currently release tags will be created only for master and branch with prefix hotfix-<*>

Master:

        Version is specified in gradle.properties file like version=1.0.5-SNAPSHOT

Hotfix: All branches for release should start from hotfix- <hotfix→<master TAG>-<US Story number>-<functionalityname>


Create branch from TAG : git checkout -b hotfix-1.0.4-158701-templaterepo 1.0.4

update gradle.properties with  version=hotfix-<master TAG>-<US story number>-<Functionality>-<Version Number>-SNAPSHOT

Images are pushed to ACR with same TAG as created in github repo  example <Service NAME>:<TAG>         

## Using Github as the packags registry 

[Github packages registry](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry)
