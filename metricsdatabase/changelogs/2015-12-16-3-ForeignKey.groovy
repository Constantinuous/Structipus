databaseChangeLog() {
    changeSet(id: "foo", author: "richard") {
        createTable(tableName: 'users') {
            column(name: 'id', autoIncrement: true, type: 'int') {
                constraints(primaryKey: true, nullable: false, primaryKeyName:'pk_users')
            }
            column(name: 'firstName', type: 'varchar(128)') {
                constraints(nullable: false)
            }
            column(name: 'lastName', type: 'varchar(128)') {
                constraints(nullable: false)
            }
        }
        createTable(tableName: 'roles') {
            column(name: 'id', autoIncrement: true, type: 'int') {
                constraints(primaryKey: true, nullable: false, primaryKeyName:'pk_role')
            }
            column(name: 'name', type: 'varchar(64)') {
                constraints(nullable: false, unique: true)
            }
            column(name: 'description', type: 'varchar(128)') {
            }
        }
        createTable(tableName: 'users_roles') {
            column(name: 'user_id', type: 'int') {
                constraints(foreignKeyName: "fk_users_roles_users", references:"users(id)", nullable:"false" )
            }
            column(name: 'role_id', type: 'int') {
                constraints(foreignKeyName: "fk_users_roles_roles", references:"roles(id)", nullable:"false")
            }
        }


        rollback() {
            dropTable(tableName: 'users_roles')
            dropTable(tableName: 'roles')
            dropTable(tableName: 'users')
        }
    }
}