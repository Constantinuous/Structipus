databaseChangeLog() {
    changeSet(id: "my first changeset", author: "richard") {
        comment('A comment')
        createTable(tableName: 'my_table') {
            column(name: 'id', type: 'int') {
                constraints(primaryKey: true, nullable: false)
            }
            column(name: 'name', type: 'character varying(100)') {
                constraints(nullable: false)
            }
            column(name: 'active', type: 'boolean') {
                constraints(nullable: false)
            }
        }
        createIndex(indexName: 'idx_name', tableName: 'my_table') {
            column(name: 'name')
        }
        rollback() {
            dropTable(tableName: 'my_table')
        }
    }
}