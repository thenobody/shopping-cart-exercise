package net.antonvanco.shoppingcart.model

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by antonvanco on 15/02/2016.
 */
class ItemSpec extends FlatSpec with Matchers {

  behavior of Item.getClass.getSimpleName

  it should "parse and return an Apple item" in {
    val input1 = "Apple"
    val input2 = "APPLE"
    val input3 = "apple"
    val input4 = "AppLe"

    val expResult = new Apple(Apple.DefaultRegularPrice)

    val result1 = Item(input1)
    val result2 = Item(input2)
    val result3 = Item(input3)
    val result4 = Item(input4)

    result1 shouldEqual expResult
    result2 shouldEqual expResult
    result3 shouldEqual expResult
    result4 shouldEqual expResult
  }

  it should "parse and return an Orange item" in {
    val input1 = "Orange"
    val input2 = "ORANGE"
    val input3 = "orange"
    val input4 = "OraNGe"

    val expResult = new Orange(Orange.DefaultRegularPrice)

    val result1 = Item(input1)
    val result2 = Item(input2)
    val result3 = Item(input3)
    val result4 = Item(input4)

    result1 shouldEqual expResult
    result2 shouldEqual expResult
    result3 shouldEqual expResult
    result4 shouldEqual expResult
  }

  it should "throw an exception on invalid item name" in {
    val input1 = "Apple "
    val input2 = "UNKNOWN"

    val exception1 = intercept[IllegalArgumentException](Item(input1))
    exception1.getMessage shouldEqual s"Unknown item name: $input1"

    val exception2 = intercept[IllegalArgumentException](Item(input2))
    exception2.getMessage shouldEqual s"Unknown item name: $input2"
  }

}
