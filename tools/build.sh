cd client 
docker build -t myhouse:front .
cd ..
cd server 
docker build -t myhouse:back .
docker run -d -p 8080:8080 myhouse:front
docker run -d -p 9999:9999 myhouse:back 
