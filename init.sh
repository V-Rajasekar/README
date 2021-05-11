#!/bin/bash -e
echo "############## Updating apt repository ##############"
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update 
echo "############## Installing openjdk 8 ##############"
sudo apt-get install openjdk-8-jdk -y
echo "############## Installing maven ##############"
sudo apt install maven -y 
echo "############## Installing git ##############"
sudo apt install git -y
echo "################ ADDING NORWEGIAN CERTIFIATES ################"
 sudo cp certs/dev-build03-holding-intra.pem /usr/share/ca-certificates/dev-build03-holding-intra.crt
# THEN copy certificate to /usr/local/share/ca-certificates/
 sudo cp certs/dev-build03-holding-intra.pem /usr/local/share/ca-certificates/
# THEN run sudo dpkg-reconfigure ca-certificates and activate the new certificate
#sudo dpkg-reconfigure ca-certificates
# THEN run update-ca-certificates
#sudo update-ca-certificates
# THEN run service docker restart
#sudo service docker restart
#THEN docker login to dev-build03.holding.intra 
#docker login https://dev-build03.holding.intra
#Image should be downloadable