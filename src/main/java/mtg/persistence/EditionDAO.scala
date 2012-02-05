package mtg.persistence

import mtg.model.Edition
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.DBObject

object EditionDAO extends Connection {

  lazy val collection = conn("edition")

  def upsert(edition: Edition) {
    val builder = MongoDBObject.newBuilder
    builder += "name" -> edition.name
    builder += "ssgId" -> edition.ssgId

    val searchObject = (MongoDBObject.newBuilder += "name" -> edition.name).result()

    collection.update(searchObject, builder.result(), true, false)
  }

  def findAll(limit: Int): Iterator[Edition] = {
    collection.find().limit(limit).toIterator.map(obj2 => {
      val obj:DBObject = obj2
      new Edition(
        obj.get("name").asInstanceOf[String],
        obj.get("ssgId").asInstanceOf[String]
    )
    })
  }
}