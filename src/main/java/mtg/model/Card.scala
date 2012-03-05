package mtg.model

import java.util.Date


case class CardItem(name: String, edition: String, condition: String)

case class PriceSnapshot(item: CardItem, price: Double, date: Date) {
  var diff: Double = 0;

  def this(item: CardItem, price: Double, date: Date, diff: Double) {
    this(item, price, date)
    this.diff = diff
  }
}

case class Card(name: String)

class Edition {
  var name: String = null
  var ssgId: String = null
  var alias: List[String] = Nil

  def this(name: String, ssgId: String, alias: List[String]) {
    this()
    this.name = name
    this.alias = alias ::: Nil
    this.ssgId = ssgId
  }

  override def toString = List (name, ssgId, alias).foldLeft ("") ((a, b) => (a + "," + b) )
}

