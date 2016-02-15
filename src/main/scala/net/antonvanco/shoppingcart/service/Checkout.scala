package net.antonvanco.shoppingcart.service

import net.antonvanco.shoppingcart.model.Cart

/**
 * Created by antonvanco on 15/02/2016.
 */
class CheckoutService {

  def checkoutCart(cart: Cart): CheckOutCart = {
    CheckOutCart(cart, cart.overallPrice)
  }

}

case class CheckOutCart(cart: Cart, finalPrice: Double) {
  def getItemsString: String = "[ " + cart.items.map(_.name).mkString(", ") + " ]"
  def getFinalPriceString: String = s"£${cart.overallPrice}"
  override def toString: String = s"$getItemsString => $getFinalPriceString"
}
