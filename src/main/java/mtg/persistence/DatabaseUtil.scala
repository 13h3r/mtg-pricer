package mtg.persistence

import com.mongodb.casbah.commons.MongoDBObjectBuilder
import com.mongodb.casbah.MongoConnection

object DatabaseUtil {
  def copyDB(from : String , to : String) {
    var command = new MongoDBObjectBuilder();
    command +="copydb" -> "1"
    command +="fromdb" -> from
    command +="todb" -> to
    val result = MongoConnection()("admin").command(command.result())
    assert(result.ok())
  }
}
