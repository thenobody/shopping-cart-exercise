package net.antonvanco.shoppingcart.model

/**
 * Created by antonvanco on 15/02/2016.
 */
case class Cart(items: Seq[Item]) {

  def addItem(item: Item): Cart = copy(items = items :+ item)
  def addItems(newItems: Seq[Item]): Cart = copy(items = items ++ newItems)

  def overallPrice: Double = items.map(_.regularPrice).sum
  def getQuantities: Map[Item, Int] = items.groupBy(identity).mapValues(_.size)

  def isEmpty: Boolean = items.isEmpty
}

object Cart {
  def apply(): Cart = Cart(Seq.empty)
}
