package de.chasmo.orderbook

sealed trait Direction
case object Buy extends Direction
case object Sell extends Direction
