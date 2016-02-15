package net.antonvanco.shoppingcart.model

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by antonvanco on 15/02/2016.
 */
class CartSpec extends FlatSpec with Matchers {

  behavior of classOf[Cart].getSimpleName

  it should "add items to an empty cart" in {
    val instance = Cart(Seq.empty)
    val items = Seq(Apple(), Apple(), Orange(), Apple())
    val expResult = Cart(items)

    val result = instance.addItems(items)

    result shouldEqual expResult
  }

  it should "add items to a non-empty cart" in {
    val existingItems = Seq(Apple(), Apple(), Orange(), Apple())
    val instance = Cart(existingItems)
    val newItems = Seq(Orange(), Orange(), Apple())

    val expResult = Cart(existingItems ++ newItems)

    val result = instance.addItems(newItems)

    result shouldEqual expResult
  }

  it should "calculate the overall price of all items" in {
    val priceApple = 0.9
    val priceOrange = 0.8

    val items = Seq(Apple(priceApple), Apple(priceApple), Orange(priceOrange), Apple(priceApple), Orange(priceOrange))
    val overallPriceApples = 3 * priceApple
    val overallPriceOrange = 2 * priceOrange
    val expResult = overallPriceApples + overallPriceOrange

    val instance = Cart(items)

    instance.overallPrice should be (expResult +- 0.000001) // tolerance due to Double precision issues
  }

  it should "calculate individual item quantities" in {
    val items = Seq(Apple(), Apple(), Orange(), Apple(), Orange())
    val expResult = Map(Apple() -> 3, Orange() -> 2)

    val result = Cart(items).getQuantities

    result shouldEqual expResult
  }

}
