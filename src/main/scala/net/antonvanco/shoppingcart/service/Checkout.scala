package net.antonvanco.shoppingcart.service

import java.text.DecimalFormat

import net.antonvanco.shoppingcart.model._

/**
 * Created by antonvanco on 15/02/2016.
 */
class CheckoutService(val discounts: Seq[Discount]) {
  def checkoutCart(cart: Cart): CheckOutCart = {
    val finalPrice = discounts.foldLeft(cart.overallPrice) { (acc, discount) =>
      acc + discount(cart)
    }
    CheckOutCart(cart, finalPrice)
  }
}

object CheckoutService {
  val discounts: Seq[Discount] = Seq(BuyOneGetOneFreeAppleDiscount, ThreeForThePriceOfTwoOrangeDiscount)
  val priceFormatter = new DecimalFormat("0.00")

  def apply(): CheckoutService = new CheckoutService(discounts)
}

case class CheckOutCart(cart: Cart, finalPrice: Double) {
  def getItemsString: String = "[ " + cart.items.map(_.name).mkString(", ") + " ]"
  def getFinalPriceString: String = s"£${CheckoutService.priceFormatter.format(finalPrice)}"
  override def toString: String = s"$getItemsString => $getFinalPriceString"
}
