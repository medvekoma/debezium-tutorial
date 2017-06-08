## Update field

```sql
update customers set first_name = "Anne Marie" where id = 1004;
```

```json
{
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "int32",
            "optional": false,
            "field": "id"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Key"
    },
    "payload": {
        "id": 1004
    }
} {
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "struct",
            "fields": [{
                "type": "int32",
                "optional": false,
                "field": "id"
            }, {
                "type": "string",
                "optional": false,
                "field": "first_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "last_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "email"
            }],
            "optional": true,
            "name": "dbserver1.inventory.customers.Value",
            "field": "before"
        }, {
            "type": "struct",
            "fields": [{
                "type": "int32",
                "optional": false,
                "field": "id"
            }, {
                "type": "string",
                "optional": false,
                "field": "first_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "last_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "email"
            }],
            "optional": true,
            "name": "dbserver1.inventory.customers.Value",
            "field": "after"
        }, {
            "type": "struct",
            "fields": [{
                "type": "string",
                "optional": false,
                "field": "name"
            }, {
                "type": "int64",
                "optional": false,
                "field": "server_id"
            }, {
                "type": "int64",
                "optional": false,
                "field": "ts_sec"
            }, {
                "type": "string",
                "optional": true,
                "field": "gtid"
            }, {
                "type": "string",
                "optional": false,
                "field": "file"
            }, {
                "type": "int64",
                "optional": false,
                "field": "pos"
            }, {
                "type": "int32",
                "optional": false,
                "field": "row"
            }, {
                "type": "boolean",
                "optional": true,
                "field": "snapshot"
            }, {
                "type": "int64",
                "optional": true,
                "field": "thread"
            }, {
                "type": "string",
                "optional": true,
                "field": "db"
            }, {
                "type": "string",
                "optional": true,
                "field": "table"
            }],
            "optional": false,
            "name": "io.debezium.connector.mysql.Source",
            "field": "source"
        }, {
            "type": "string",
            "optional": false,
            "field": "op"
        }, {
            "type": "int64",
            "optional": true,
            "field": "ts_ms"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Envelope",
        "version": 1
    },
    "payload": {
        "before": {
            "id": 1004,
            "first_name": "Anne",
            "last_name": "Kretchmar",
            "email": "annek@noanswer.org"
        },
        "after": {
            "id": 1004,
            "first_name": "Anne Marie",
            "last_name": "Kretchmar",
            "email": "annek@noanswer.org"
        },
        "source": {
            "name": "dbserver1",
            "server_id": 223344,
            "ts_sec": 1496900692,
            "gtid": null,
            "file": "mysql-bin.000003",
            "pos": 364,
            "row": 0,
            "snapshot": null,
            "thread": 11,
            "db": "inventory",
            "table": "customers"
        },
        "op": "u",
        "ts_ms": 1496900692577
    }
}
```

## Insert record
```sql
insert into customers (id, first_name, last_name, email) values (2001, "Max", "Mustermann", "max@mustermann.de");
```

```json
{
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "int32",
            "optional": false,
            "field": "id"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Key"
    },
    "payload": {
        "id": 2001
    }
} {
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "struct",
            "fields": [{
                "type": "int32",
                "optional": false,
                "field": "id"
            }, {
                "type": "string",
                "optional": false,
                "field": "first_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "last_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "email"
            }],
            "optional": true,
            "name": "dbserver1.inventory.customers.Value",
            "field": "before"
        }, {
            "type": "struct",
            "fields": [{
                "type": "int32",
                "optional": false,
                "field": "id"
            }, {
                "type": "string",
                "optional": false,
                "field": "first_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "last_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "email"
            }],
            "optional": true,
            "name": "dbserver1.inventory.customers.Value",
            "field": "after"
        }, {
            "type": "struct",
            "fields": [{
                "type": "string",
                "optional": false,
                "field": "name"
            }, {
                "type": "int64",
                "optional": false,
                "field": "server_id"
            }, {
                "type": "int64",
                "optional": false,
                "field": "ts_sec"
            }, {
                "type": "string",
                "optional": true,
                "field": "gtid"
            }, {
                "type": "string",
                "optional": false,
                "field": "file"
            }, {
                "type": "int64",
                "optional": false,
                "field": "pos"
            }, {
                "type": "int32",
                "optional": false,
                "field": "row"
            }, {
                "type": "boolean",
                "optional": true,
                "field": "snapshot"
            }, {
                "type": "int64",
                "optional": true,
                "field": "thread"
            }, {
                "type": "string",
                "optional": true,
                "field": "db"
            }, {
                "type": "string",
                "optional": true,
                "field": "table"
            }],
            "optional": false,
            "name": "io.debezium.connector.mysql.Source",
            "field": "source"
        }, {
            "type": "string",
            "optional": false,
            "field": "op"
        }, {
            "type": "int64",
            "optional": true,
            "field": "ts_ms"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Envelope",
        "version": 1
    },
    "payload": {
        "before": null,
        "after": {
            "id": 2001,
            "first_name": "Max",
            "last_name": "Mustermann",
            "email": "max@mustermann.de"
        },
        "source": {
            "name": "dbserver1",
            "server_id": 223344,
            "ts_sec": 1496900812,
            "gtid": null,
            "file": "mysql-bin.000003",
            "pos": 725,
            "row": 0,
            "snapshot": null,
            "thread": 11,
            "db": "inventory",
            "table": "customers"
        },
        "op": "c",
        "ts_ms": 1496900812167
    }
}
```

## Delete row

```sql
delete from customers where id = 2001;
```

```json
{
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "int32",
            "optional": false,
            "field": "id"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Key"
    },
    "payload": {
        "id": 2001
    }
} {
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "struct",
            "fields": [{
                "type": "int32",
                "optional": false,
                "field": "id"
            }, {
                "type": "string",
                "optional": false,
                "field": "first_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "last_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "email"
            }],
            "optional": true,
            "name": "dbserver1.inventory.customers.Value",
            "field": "before"
        }, {
            "type": "struct",
            "fields": [{
                "type": "int32",
                "optional": false,
                "field": "id"
            }, {
                "type": "string",
                "optional": false,
                "field": "first_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "last_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "email"
            }],
            "optional": true,
            "name": "dbserver1.inventory.customers.Value",
            "field": "after"
        }, {
            "type": "struct",
            "fields": [{
                "type": "string",
                "optional": false,
                "field": "name"
            }, {
                "type": "int64",
                "optional": false,
                "field": "server_id"
            }, {
                "type": "int64",
                "optional": false,
                "field": "ts_sec"
            }, {
                "type": "string",
                "optional": true,
                "field": "gtid"
            }, {
                "type": "string",
                "optional": false,
                "field": "file"
            }, {
                "type": "int64",
                "optional": false,
                "field": "pos"
            }, {
                "type": "int32",
                "optional": false,
                "field": "row"
            }, {
                "type": "boolean",
                "optional": true,
                "field": "snapshot"
            }, {
                "type": "int64",
                "optional": true,
                "field": "thread"
            }, {
                "type": "string",
                "optional": true,
                "field": "db"
            }, {
                "type": "string",
                "optional": true,
                "field": "table"
            }],
            "optional": false,
            "name": "io.debezium.connector.mysql.Source",
            "field": "source"
        }, {
            "type": "string",
            "optional": false,
            "field": "op"
        }, {
            "type": "int64",
            "optional": true,
            "field": "ts_ms"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Envelope",
        "version": 1
    },
    "payload": {
        "before": {
            "id": 2001,
            "first_name": "Max",
            "last_name": "Mustermann",
            "email": "max@mustermann.de"
        },
        "after": null,
        "source": {
            "name": "dbserver1",
            "server_id": 223344,
            "ts_sec": 1496900855,
            "gtid": null,
            "file": "mysql-bin.000003",
            "pos": 1039,
            "row": 0,
            "snapshot": null,
            "thread": 11,
            "db": "inventory",
            "table": "customers"
        },
        "op": "d",
        "ts_ms": 1496900855166
    }
} {
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "int32",
            "optional": false,
            "field": "id"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Key"
    },
    "payload": {
        "id": 2001
    }
} {
    "schema": null,
    "payload": null
}
```

## Add column

```sql
alter table customers add nickname varchar(20);
```

```json
```

## Drop column

```sql
alter table customers drop nickname;
```

```json
```

## Add column with default value

```sql
alter table customers add nickname varchar(20) default "joe";
```

```json
```

## Update newly added column

```sql
update customers set nickname="anne" where id = 1004;
```

```json
{
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "int32",
            "optional": false,
            "field": "id"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Key"
    },
    "payload": {
        "id": 1004
    }
} {
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "struct",
            "fields": [{
                "type": "int32",
                "optional": false,
                "field": "id"
            }, {
                "type": "string",
                "optional": false,
                "field": "first_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "last_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "email"
            }, {
                "type": "string",
                "optional": true,
                "field": "nickname"
            }],
            "optional": true,
            "name": "dbserver1.inventory.customers.Value",
            "field": "before"
        }, {
            "type": "struct",
            "fields": [{
                "type": "int32",
                "optional": false,
                "field": "id"
            }, {
                "type": "string",
                "optional": false,
                "field": "first_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "last_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "email"
            }, {
                "type": "string",
                "optional": true,
                "field": "nickname"
            }],
            "optional": true,
            "name": "dbserver1.inventory.customers.Value",
            "field": "after"
        }, {
            "type": "struct",
            "fields": [{
                "type": "string",
                "optional": false,
                "field": "name"
            }, {
                "type": "int64",
                "optional": false,
                "field": "server_id"
            }, {
                "type": "int64",
                "optional": false,
                "field": "ts_sec"
            }, {
                "type": "string",
                "optional": true,
                "field": "gtid"
            }, {
                "type": "string",
                "optional": false,
                "field": "file"
            }, {
                "type": "int64",
                "optional": false,
                "field": "pos"
            }, {
                "type": "int32",
                "optional": false,
                "field": "row"
            }, {
                "type": "boolean",
                "optional": true,
                "field": "snapshot"
            }, {
                "type": "int64",
                "optional": true,
                "field": "thread"
            }, {
                "type": "string",
                "optional": true,
                "field": "db"
            }, {
                "type": "string",
                "optional": true,
                "field": "table"
            }],
            "optional": false,
            "name": "io.debezium.connector.mysql.Source",
            "field": "source"
        }, {
            "type": "string",
            "optional": false,
            "field": "op"
        }, {
            "type": "int64",
            "optional": true,
            "field": "ts_ms"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Envelope",
        "version": 1
    },
    "payload": {
        "before": {
            "id": 1004,
            "first_name": "Anne Marie",
            "last_name": "Kretchmar",
            "email": "annek@noanswer.org",
            "nickname": "joe"
        },
        "after": {
            "id": 1004,
            "first_name": "Anne Marie",
            "last_name": "Kretchmar",
            "email": "annek@noanswer.org",
            "nickname": "anne"
        },
        "source": {
            "name": "dbserver1",
            "server_id": 223344,
            "ts_sec": 1496901153,
            "gtid": null,
            "file": "mysql-bin.000003",
            "pos": 1944,
            "row": 0,
            "snapshot": null,
            "thread": 11,
            "db": "inventory",
            "table": "customers"
        },
        "op": "u",
        "ts_ms": 1496901153887
    }
}
```

## Rename column

```sql
alter table customers change nickname nick varchar(20);
```

```json
```

## Update renamed column

```sql
update customers set nick = "sal" where id = 1001;
```

```json
{
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "int32",
            "optional": false,
            "field": "id"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Key"
    },
    "payload": {
        "id": 1001
    }
} {
    "schema": {
        "type": "struct",
        "fields": [{
            "type": "struct",
            "fields": [{
                "type": "int32",
                "optional": false,
                "field": "id"
            }, {
                "type": "string",
                "optional": false,
                "field": "first_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "last_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "email"
            }, {
                "type": "string",
                "optional": true,
                "field": "nick"
            }],
            "optional": true,
            "name": "dbserver1.inventory.customers.Value",
            "field": "before"
        }, {
            "type": "struct",
            "fields": [{
                "type": "int32",
                "optional": false,
                "field": "id"
            }, {
                "type": "string",
                "optional": false,
                "field": "first_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "last_name"
            }, {
                "type": "string",
                "optional": false,
                "field": "email"
            }, {
                "type": "string",
                "optional": true,
                "field": "nick"
            }],
            "optional": true,
            "name": "dbserver1.inventory.customers.Value",
            "field": "after"
        }, {
            "type": "struct",
            "fields": [{
                "type": "string",
                "optional": false,
                "field": "name"
            }, {
                "type": "int64",
                "optional": false,
                "field": "server_id"
            }, {
                "type": "int64",
                "optional": false,
                "field": "ts_sec"
            }, {
                "type": "string",
                "optional": true,
                "field": "gtid"
            }, {
                "type": "string",
                "optional": false,
                "field": "file"
            }, {
                "type": "int64",
                "optional": false,
                "field": "pos"
            }, {
                "type": "int32",
                "optional": false,
                "field": "row"
            }, {
                "type": "boolean",
                "optional": true,
                "field": "snapshot"
            }, {
                "type": "int64",
                "optional": true,
                "field": "thread"
            }, {
                "type": "string",
                "optional": true,
                "field": "db"
            }, {
                "type": "string",
                "optional": true,
                "field": "table"
            }],
            "optional": false,
            "name": "io.debezium.connector.mysql.Source",
            "field": "source"
        }, {
            "type": "string",
            "optional": false,
            "field": "op"
        }, {
            "type": "int64",
            "optional": true,
            "field": "ts_ms"
        }],
        "optional": false,
        "name": "dbserver1.inventory.customers.Envelope",
        "version": 1
    },
    "payload": {
        "before": {
            "id": 1001,
            "first_name": "Sally",
            "last_name": "Thomas",
            "email": "sally.thomas@acme.com",
            "nick": "joe"
        },
        "after": {
            "id": 1001,
            "first_name": "Sally",
            "last_name": "Thomas",
            "email": "sally.thomas@acme.com",
            "nick": "sal"
        },
        "source": {
            "name": "dbserver1",
            "server_id": 223344,
            "ts_sec": 1496901476,
            "gtid": null,
            "file": "mysql-bin.000003",
            "pos": 2526,
            "row": 0,
            "snapshot": null,
            "thread": 11,
            "db": "inventory",
            "table": "customers"
        },
        "op": "u",
        "ts_ms": 1496901476178
    }
}
```