databaseChangeLog() {
    changeSet(id: "2", author: "richard") {
        loadData(file:"2015-12-17-Data.csv", schemaName:"MyDb", quotchar:"'", tableName="CSV_TABLE")
    }
}