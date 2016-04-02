package de.chasmo.orderbook

import spire.algebra.Order
import spire.implicits._

case class OrderBookEntry(
  id: String,
  time: Long,
  size: Int,
  price: Double
)
object OrderBookEntry {

  val lowestPriceFirst: Order[Double] = Order[Double]
  val highestPriceFirst: Order[Double] = lowestPriceFirst.reverse
  val lowestTimeFirst: Order[Long] = Order[Long]

  val priceTimeOrderBids: spire.algebra.Order[OrderBookEntry] = spire.algebra.Order.from[OrderBookEntry] { (lhs, rhs) =>
    highestPriceFirst.compare(lhs.price,rhs.price) match {
      case 0 => lowestTimeFirst.compare(lhs.time, rhs.time)
      case n => n
    }
  }

  val priceTimeOrderAsks: spire.algebra.Order[OrderBookEntry] = spire.algebra.Order.from[OrderBookEntry] { (lhs, rhs) =>
    lowestPriceFirst.compare(lhs.price,rhs.price) match {
      case 0 => lowestTimeFirst.compare(lhs.time, rhs.time)
      case n => n
    }
  }

}