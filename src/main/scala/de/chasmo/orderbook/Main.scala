package de.chasmo.orderbook

import akka.actor.ActorSystem
import de.chasmo.orderbook.Exchange.PlaceOrder
import de.knutwalker.akka.typed._
object Main extends App {

  implicit val system = ActorSystem("orderbook")


  val exchange = ActorOf(Exchange.props("INTC"), name = "exchange")

  exchange ! PlaceOrder(LimitOrder("INTC", Buy, 33.75, 200))
  exchange ! PlaceOrder(LimitOrder("INTC", Buy, 33.74, 500))
  exchange ! PlaceOrder(LimitOrder("INTC", Sell, 33.78, 300))
  exchange ! PlaceOrder(LimitOrder("INTC", Buy, 33.75, 100))
  exchange ! PlaceOrder(LimitOrder("INTC", Sell, 33.77, 200))

}
