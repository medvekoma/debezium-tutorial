## Schema Changes

```sql
ALTER TABLE customers DROP nickname;
```

```json
// key
{"databaseName": "inventory"}
```
```json
// value
{  
   "source":{  
      "name":"dbserver1",
      "server_id":223344,
      "ts_sec":1497357933,
      "gtid":null,
      "file":"mysql-bin.000003",
      "pos":414,
      "row":0,
      "snapshot":null,
      "thread":null,
      "db":null,
      "table":null
   },
   "databaseName":"inventory",
   "ddl":"ALTER TABLE customers DROP nickname"
}
```

## Insert row

```sql
INSERT INTO customers 
  (id, first_name, last_name, email) 
VALUES 
  (1005, "Max", "Mustermann", "max@mustermann.de");
```

```json
// key
{"id": 1005}
```
```json
// value
{  
   "before":null,
   "after":{  
      "id":1005,
      "first_name":"Max",
      "last_name":"Mustermann",
      "email":"max@mustermann.de",
      "nickname":null
   },
   "source":{  
      "name":"dbserver1",
      "server_id":223344,
      "ts_sec":1497358431,
      "gtid":null,
      "file":"mysql-bin.000003",
      "pos":1305,
      "row":0,
      "snapshot":null,
      "thread":11,
      "db":"inventory",
      "table":"customers"
   },
   "op":"c",
   "ts_ms":1497358431334
}
```
```json
// value schema
{  
   "type":"record",
   "name":"Envelope",
   "namespace":"dbserver1.inventory.customers",
   "fields":[  
      {  
         "name":"before",
         "type":[  
            "null",
            {  
               "type":"record",
               "name":"Value",
               "fields":[  
                  {  
                     "name":"id",
                     "type":"int"
                  },
                  {  
                     "name":"first_name",
                     "type":"string"
                  },
                  {  
                     "name":"last_name",
                     "type":"string"
                  },
                  {  
                     "name":"email",
                     "type":"string"
                  },
                  {  
                     "name":"nickname",
                     "type":[  
                        "null",
                        "string"
                     ],
                     "default":null
                  }
               ],
               "connect.name":"dbserver1.inventory.customers.Value"
            }
         ],
         "default":null
      },
      {  
         "name":"after",
         "type":[  
            "null",
            "Value"
         ],
         "default":null
      },
      {  
         "name":"source",
         "type":{  
            "type":"record",
            "name":"Source",
            "namespace":"io.debezium.connector.mysql",
            "fields":[  
               {  
                  "name":"name",
                  "type":"string"
               },
               {  
                  "name":"server_id",
                  "type":"long"
               },
               {  
                  "name":"ts_sec",
                  "type":"long"
               },
               {  
                  "name":"gtid",
                  "type":[  
                     "null",
                     "string"
                  ],
                  "default":null
               },
               {  
                  "name":"file",
                  "type":"string"
               },
               {  
                  "name":"pos",
                  "type":"long"
               },
               {  
                  "name":"row",
                  "type":"int"
               },
               {  
                  "name":"snapshot",
                  "type":[  
                     "null",
                     "boolean"
                  ],
                  "default":null
               },
               {  
                  "name":"thread",
                  "type":[  
                     "null",
                     "long"
                  ],
                  "default":null
               },
               {  
                  "name":"db",
                  "type":[  
                     "null",
                     "string"
                  ],
                  "default":null
               },
               {  
                  "name":"table",
                  "type":[  
                     "null",
                     "string"
                  ],
                  "default":null
               }
            ],
            "connect.name":"io.debezium.connector.mysql.Source"
         }
      },
      {  
         "name":"op",
         "type":"string"
      },
      {  
         "name":"ts_ms",
         "type":[  
            "null",
            "long"
         ],
         "default":null
      }
   ],
   "connect.version":1,
   "connect.name":"dbserver1.inventory.customers.Envelope"
}
```
## Update row

```sql
UPDATE customers SET nickname = "Sal" WHERE id = 1001;
```

```json
// key
{"id": 1001}
// value
```
```json
{  
   "before":{  
      "id":1001,
      "first_name":"Sally",
      "last_name":"Thomas",
      "email":"sally.thomas@acme.com",
      "nickname":null
   },
   "after":{  
      "id":1001,
      "first_name":"Sally",
      "last_name":"Thomas",
      "email":"sally.thomas@acme.com",
      "nickname":"Sal"
   },
   "source":{  
      "name":"dbserver1",
      "server_id":223344,
      "ts_sec":1497358191,
      "gtid":null,
      "file":"mysql-bin.000003",
      "pos":941,
      "row":0,
      "snapshot":null,
      "thread":11,
      "db":"inventory",
      "table":"customers"
   },
   "op":"u",
   "ts_ms":1497358191831
}
```