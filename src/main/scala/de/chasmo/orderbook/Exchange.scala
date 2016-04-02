package de.chasmo.orderbook

import de.chasmo.orderbook.Exchange.{PlaceOrder, PrintList}
import de.chasmo.orderbook.OrderBookEntryHandler.AddEntry
import de.knutwalker.akka.typed._

class Exchange(symbol: String) extends TypedActor.Of[Exchange.Command] {

  private[this] val bids = ActorOf(OrderBookEntryHandler.props(OrderBookEntry.priceTimeOrderBids), name = "bids")
  private[this] val asks = ActorOf(OrderBookEntryHandler.props(OrderBookEntry.priceTimeOrderAsks), name = "asks")

  def typedReceive: TypedReceive = Total {
    case PlaceOrder(order) => order.direction match {
      case Buy => bids ! AddEntry(OrderBookEntry(System.currentTimeMillis().toString, System.currentTimeMillis(), order.size, order.price))
      case Sell => asks ! AddEntry(OrderBookEntry(System.currentTimeMillis().toString, System.currentTimeMillis(), order.size, order.price))
    }
  }

}
object Exchange {

  sealed trait Command
  case class PlaceOrder(limitOrder: LimitOrder) extends Command
  case object PrintList extends Command

  def props(symbol: String) = Props[Command, Exchange](classOf[Exchange], symbol)

}
