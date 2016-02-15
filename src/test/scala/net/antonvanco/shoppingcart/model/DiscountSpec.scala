package net.antonvanco.shoppingcart.model

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by antonvanco on 15/02/2016.
 */
class DiscountSpec extends FlatSpec with Matchers {

  BuyOneGetOneFreeAppleDiscount.getClass.getSimpleName should "calculate the correct discount" in {
    val items = Seq(Apple(), Apple(), Apple(), Orange())
    val cart = Cart(items)

    val expResult = - Apple.DefaultRegularPrice

    val result = BuyOneGetOneFreeAppleDiscount.apply(cart)

    result should be (expResult +- 0.000001) // tolerance due to Double precision issues
  }

  ThreeForThePriceOfTwoOrangeDiscount.getClass.getSimpleName should "calculate the correct discount" in {
    val items = Seq(Apple(), Orange(), Orange(), Orange(), Orange())
    val cart = Cart(items)

    val expResult = - Orange.DefaultRegularPrice

    val result = ThreeForThePriceOfTwoOrangeDiscount(cart)

    result should be (expResult +- 0.000001) // tolerance due to Double precision issues
  }

}
