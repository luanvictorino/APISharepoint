`Customer`

**GET `customer`**
```shell
 curl \
  -X GET \
  -H "Accept: application/json" \
  http://localhost:8081/customer
```
```JSON
/** example of `All Customer` JSON Object */
[
   {
      "name":"",
      "notes":"",
      "dbInfo":"",
      "usesVpn":false,
      "usesNewIntegration":false,
      "tier":"",
      "segment":"",
      "responsible":"",
      "contact":{
         "name":"",
         "email":"",
         "phone":"",
         "cellphone":"",
         "main":true
      }
   }
]
```
**POST `customer`**
```shell
 curl \
  -X POST \
  -H "Accept: application/json" \
  http://localhost:8081/customer \
  -d '{ "name":"", "notes":"", "dbInfo": "", "usesVpn":false, "usesNewIntegration":false, "tier":"", "segment": "", "responsible":"" }'
```
```JSON
/** example of `Customer` JSON Object */
{
   "name":"",
   "notes":"",
   "dbInfo":"",
   "usesVpn":false,
   "usesNewIntegration":false,
   "tier":"",
   "segment":"",
   "responsible":""
}
```
**PUT `customer/:id`**
```shell
 curl \
  -X PUT \
  -H "Accept: application/json" \
  http://localhost:8081/customer/:id \
  -d '{ "name":"", "notes":"", "dbInfo": "", "usesVpn":false, "usesNewIntegration":false, "tier":"", "segment": "", "responsible":"" }'
```
```JSON
/** example of `Customer` JSON Object */
{
   "name":"",
   "notes":"",
   "dbInfo":"",
   "usesVpn":false,
   "usesNewIntegration":false,
   "tier":"",
   "segment":"",
   "responsible":""
}
```
**DELETE `customer/:id`**
```shell
 curl \
  -X DELETE \
  -H "Accept: application/json" \
  http://localhost:8081/customer/:id
```

`Server`

**GET `/server/customer/:id`**
```shell
 curl \
  -X GET \
  -H "Accept: application/json" \
  http://localhost:8081/server/customer/:id
```
```JSON
/** example of `CustomerServer` JSON Object */ 
[
   {
      "ip":"",
      "dns":"",
      "login":"",
      "password":"",
      "name":"",
      "notes":""
   }
]
```
**POST `/server`** 
```shell
 curl \
  -X POST \
  -H "Accept: application/json" \
  http://localhost:8081/server \
  -d '{ "ip":"", "dns":"", "login":"", "password":"", "name":"", "notes":"" }'  
```
```JSON
/** example of `Server` JSON Object */
{
   "ip":"",
   "dns":"",
   "login":"",
   "password":"",
   "name":"",
   "notes":""
}
```
**PUT `/server/:id`** 
```shell
 curl \
  -X PUT \
  -H "Accept: application/json" \
  http://localhost:8081/server/:id \
  -d '{ "ip":"", "dns":"", "login":"", "password":"", "name":"", "notes":"" }' 
```
```JSON
/** example of `Server` JSON Object */
{
   "ip":"",
   "dns":"",
   "login":"",
   "password":"",
   "name":"",
   "notes":""
}
```
**DELETE `/server/:id`** 
```shell
 curl \
  -X DELETE \
  -H "Accept: application/json" \
  http://localhost:8081/server/:id
```

`Product`

**GET `/product/customer/:id`**
```shell
 curl \
  -X GET \
  -H "Accept: application/json" \
  http://localhost:8081/product/customer/:id
```
```JSON
/** example of `CustomerProduct` JSON Object */
[
   {
      "name":"",
      "notes":"",
      "acquisitionDate":""
   }
]
```
**POST `/product`**
```shell
 curl \
  -X POST \
  -H "Accept: application/json" \
  http://localhost:8081/product \
  -d '{ "name":"", "notes":"" }'  
```
```JSON
/** example of `Product` JSON Object */
{
   "name":"",
   "notes":"",
   "acquisitionDate":""
}
```
**PUT `/product/:id`**
```shell
 curl \
  -X PUT \
  -H "Accept: application/json" \
  http://localhost:8081/product/:id \
  -d '{ "name":"", "notes":"" }'  
```
```JSON
/** example of `Product` JSON Object */
{
   "name":"",
   "notes":"",
   "acquisitionDate":""
}
```
**DELETE `/product/:id`**
```shell
 curl \
  -X PUT \
  -H "Accept: application/json" \
  http://localhost:8081/product/:id \
```
   
`Contact`

**GET `/contact/customer/:id`**
```shell
 curl \
  -X GET \
  -H "Accept: application/json" \
  http://localhost:8081/contact/customer/:id
```
```JSON
[
   {
      "name":"",
      "email":"",
      "phone":"",
      "cellphone":"",
      "main":false
   }
]
```
**POST `/contact`** 
```shell
 curl \
  -X POST \
  -H "Accept: application/json" \
  http://localhost:8081/contact \
  -d '{ "name":"", "email":"", "phone":"", "cellphone":"", "main":false }'  
```
```JSON
{
   "name":"",
   "email":"",
   "phone":"",
   "cellphone":"",
   "main":false
}
```
**PUT `/contact/:id`** 
```shell
 curl \
  -X PUT \
  -H "Accept: application/json" \
  http://localhost:8081/contact/:id \
  -d '{ "name":"", "email":"", "phone":"", "cellphone":"", "main":false }'  
```
```JSON
{
   "name":"",
   "email":"",
   "phone":"",
   "cellphone":"",
   "main":false
}
```
**DELETE `/contact/:id`** 
```shell
 curl \
  -X DELETE \
  -H "Accept: application/json" \
  http://localhost:8081/contact/:id
```

 





