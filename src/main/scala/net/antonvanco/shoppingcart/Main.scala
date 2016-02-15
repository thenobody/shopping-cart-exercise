package net.antonvanco.shoppingcart

import net.antonvanco.shoppingcart.model.{Cart, Item}
import net.antonvanco.shoppingcart.service.CheckoutService

/**
 * Created by antonvanco on 15/02/2016.
 */
object Main {

  def main(args: Array[String]): Unit = {
    val cart = Cart(args.map(Item.apply))
    val checkoutService = new CheckoutService

    println(checkoutService.checkoutCart(cart))
  }
}
