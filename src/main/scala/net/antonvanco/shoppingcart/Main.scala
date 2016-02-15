package net.antonvanco.shoppingcart

import net.antonvanco.shoppingcart.model.{Cart, Item}

/**
 * Created by antonvanco on 15/02/2016.
 */
object Main {

  def main(args: Array[String]): Unit = {
    val cart = Cart(args.map(Item.apply))
    val itemsString = "[ " + cart.items.map(_.name).mkString(", ") + " ]"
    val overallPrice = cart.overallPrice

    println(s"$itemsString => £$overallPrice")
  }
}
