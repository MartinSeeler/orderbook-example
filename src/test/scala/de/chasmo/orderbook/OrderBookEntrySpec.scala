package de.chasmo.orderbook

import org.scalatest._
import spire.algebra.Order
import spire.syntax.order
import spire.compat.ordering

class OrderBookEntrySpec extends FlatSpec with Matchers {

  behavior of "The OrderBookEntry"

  it must "be sorted for the Bids" in {

    val entry1 = OrderBookEntry("O102", 1000120307, 5, 33.74)
    val entry2 = OrderBookEntry("O104", 1000120318, 1, 33.75)
    val entry3 = OrderBookEntry("O101", 1000120236, 2, 33.75)

    val entries = Seq(entry1, entry2, entry3)

    entries.sorted(Order.ordering[OrderBookEntry](OrderBookEntry.priceTimeOrderBids)) should equal (Seq(entry3, entry2, entry1))

  }

}
