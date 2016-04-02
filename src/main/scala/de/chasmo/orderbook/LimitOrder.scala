package de.chasmo.orderbook

case class LimitOrder(
  symbol: String,
  direction: Direction,
  price: Double,
  size: Int
)
