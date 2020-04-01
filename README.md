# acs
A scale-out key-value data store.

Implementation
---------------
Redis installed on one instance so scaling made easy while each added instance can connect to it to store or retrieve a resource.In Redis, read and write operations are extremely fast because of storing data in primary memory. Yet primary memory is in lesser in size and much expensive than secondary so 
for Production environment with much data, would be better to set-up Redis cluster where data is sharded across multiple nodes. In addition, Redis cluster also gives a degree of availability during partitions.
The API, implemented with Spring rest controller, was extended to support multiple resources by using /{resource} path variable as the entity key. That way, Post and Get requests can be sent with /api/resource1, /api/resource2, /api/someOtherResourceKey and so on.
For deployment, there are two docker-compose files: both build and run the jar, but one file also install Redis and is for a single instance use (As mentioned, other instances just connect to this Redis).

Security
---------
Communication between instances and Redis is through their internal network.

Test with Postman
------------------
Import acs_tests.postman_collection.json file (in root project directory) to Postman and send the requests.

Build with Docker
------------------------
git clone to each instance and then:

* Run the following commands on argus1.lgrsdev.com instance:
docker-compose -f docker-compose-redis.yaml build
docker-compose -f docker-compose-redis.yaml up

* Run the following commands on argus2.lgrsdev.com instance:
docker-compose -f docker-compose.yaml build
docker-compose -f docker-compose.yaml up
