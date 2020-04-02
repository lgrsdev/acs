# acs
A scale-out key-value data store.

Implementation
---------------
Redis installed on one instance so scaling made easy while each added instance can connect to it to store or retrieve a resource.<br>
In Redis, read and write operations are extremely fast because of storing data in primary memory.<br>
Yet, primary memory is in lesser in size and much expensive than secondary so for Production environment with much data, would be better to set-up Redis cluster where data is sharded across multiple nodes.
In addition, Redis cluster also gives a degree of availability during partitions.<br>

The API, implemented with Spring rest controller, was extended to support multiple resources by using /{resource} path variable as the entity key. That way, Post and Get requests can be sent with /api/resource1, /api/resource2, /api/someOtherResourceKey and so on.<br>

For deployment, there are two docker-compose files: both build and run the jar, but one file also install Redis and is for a single instance use (As mentioned, other instances just connect to this Redis).<br>

argus.lgrsdev.com was defined to point to both servers and with extreme load one can add servers to the DNS and get it distributed.

Security
---------
Ngnix is used for TLS termination configured with mozills SSL config generator (https://ssl-config.mozilla.org/)<br>The certificate is a short lived TLS certificate from Let's Encrypt. <br>
In production though, would be better configure the certificate to automatically rotated, but since this is an exercise DNS challenge was used.<br>
https://www.ssllabs.com/ssltest/analyze.html?d=argus.lgrsdev.com&latest<br>
Communication between instances and Redis is through internal network.

Test
----
curl -k -X POST -d {"something":"blabla"} https://argus1.lgrsdev.com/api/resource<br>
curl -k https://argus2.lgrsdev.com/api/resource

Test with Postman
------------------
Import acs_tests.postman_collection.json file (in root project directory) to Postman and send the requests.

Build with Docker
------------------------
cd acs<br>
git clone to each instance and then:

* Run the following command on argus1.lgrsdev.com instance:<br>
docker-compose -f docker-compose-redis.yaml build<br>
docker-compose -f docker-compose-redis.yaml up -d

* Run the following commands on argus2.lgrsdev.com instance:<br>
docker-compose -f docker-compose.yaml build<br>
docker-compose -f docker-compose.yaml up -d
