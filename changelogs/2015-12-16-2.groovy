databaseChangeLog() {
    changeSet(id: "3", author: "richard") {
        comment('A comment')
        createTable(tableName: 'TEST_TABLE') {
            column(name: 'id', type: 'int') {
                constraints(primaryKey: true, nullable: false)
            }
            column(name: 'name', type: 'character varying(100)') {
                constraints(nullable: false)
            }
            column(name: 'active', type: 'character varying(10)') {
                constraints(nullable: false)
            }
        }
        createIndex(indexName: 'idx_test_table_name', tableName: 'TEST_TABLE') {
            column(name: 'name')
        }
        rollback() {
            dropTable(tableName: 'TEST_TABLE')
        }
    }
}