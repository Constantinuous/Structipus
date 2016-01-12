databaseChangeLog() {
    changeSet(id: "data", author: "richard") {
        insert(tableName: "roles"){
            column(name: "id", value:"1")
            column(name: "name", value:"Guest")
        }
        insert(tableName: "roles"){
            column(name: "name", value:"User")
        }
        insert(tableName: "roles"){
            column(name: "name", value:"Admin")
        }

        insert(tableName: "users"){
            column(name: "id", value:"1")
            column(name: "firstName", value:"John")
            column(name: "lastName", value:"Doe")
        }
        insert(tableName: "users"){
            column(name: "firstName", value:"James")
            column(name: "lastName", value:"Brown")
        }
        insert(tableName: "users"){
            column(name: "firstName", value:"Andrew")
            column(name: "lastName", value:"Green")
        }

        insert(tableName: "users_roles"){
            column(name: "user_id", value:"1")
            column(name: "role_id", value:"1")
        }
        insert(tableName: "users_roles"){
            column(name: "user_id", value:"2")
            column(name: "role_id", value:"2")
        }
        insert(tableName: "users_roles"){
            column(name: "user_id", value:"3")
            column(name: "role_id", value:"3")
        }
    }
}