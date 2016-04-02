package de.chasmo.orderbook

import de.knutwalker.akka.typed._
import de.chasmo.orderbook.OrderBookEntryHandler.{AddEntry, Command, PrintList}
import spire.algebra.Order

class OrderBookEntryHandler(ordering: Order[OrderBookEntry]) extends TypedActor.Of[Command] {

  def typedReceive: TypedReceive = working(Seq.empty)

  def working(entries: Seq[OrderBookEntry]): TypedReceive = Total {
    case AddEntry(entry) =>
      val newEntries = (entries :+ entry).sorted(Order.ordering(ordering))
      println("entries")
      newEntries.foreach(println)
      typedBecome(working(newEntries))
    case PrintList =>
      entries.foreach(println)
  }

}
object OrderBookEntryHandler {

  sealed trait Command
  case class AddEntry(orderBookEntry: OrderBookEntry) extends Command
  case object PrintList extends Command

  def props(ordering: Order[OrderBookEntry]) = Props[Command, OrderBookEntryHandler](classOf[OrderBookEntryHandler], ordering)

}
