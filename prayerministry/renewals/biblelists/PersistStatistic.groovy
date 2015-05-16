class PersistStatistic {
String dbLocation = "jdbc:sqlite:db/renewal.db"
String dbDriver = "org.sqlite.JDBC"
def getDb(){
return groovy.sql.Sql.newInstance(dbLocation, dbDriver)
}
void insert(data){
def sql = getDb()
try{
sql.execute("create table if not exists bible(id Integer,key BLOB,version TEXT,txt BLOB,category TEXT)")
}catch (Exception e){ }
sql.execute("insert into bible(id,key,version,txt,category) values(?,?,?,?,?)",data)
}
void printContents(){
def sql = getDb()
sql.rows("select * from bible ").each{ println(it) }
}
}
