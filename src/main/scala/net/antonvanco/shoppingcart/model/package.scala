package net.antonvanco.shoppingcart

/**
 * Created by antonvanco on 15/02/2016.
 */
package object model {

  sealed trait Item {
    def name: String
    def regularPrice: Double
  }

  case class Apple(name: String, regularPrice: Double) extends Item
  object Apple {
    val Name = "apple"
    val DefaultRegularPrice = 0.6
    def apply(): Apple = Apple(DefaultRegularPrice)
    def apply(price: Double): Apple = Apple(Name, price)
  }

  case class Orange(name: String, regularPrice: Double) extends Item
  object Orange {
    val Name = "orange"
    val DefaultRegularPrice = 0.25
    def apply(): Orange = Orange(Name, DefaultRegularPrice)
    def apply(price: Double): Orange = Orange(Name, price)
  }

  object Item {
    val itemMapping = Map(
      Apple.Name -> Apple.apply,
      Orange.Name -> Orange.apply
    )

    def apply(itemName: String): Item = itemMapping.getOrElse(
      itemName.toLowerCase,
      throw new IllegalArgumentException(s"Unknown item name: $itemName")
    )
  }

  sealed trait Discount {
    def apply(cart: Cart): Double
  }

  case object BuyOneGetOneFreeAppleDiscount extends Discount {
    def apply(cart: Cart): Double = cart.quantities.get(Apple()) match {
      case Some(apples) =>
        val originalPrice = apples * Apple.DefaultRegularPrice
        (apples / 2 + apples % 2) * Apple.DefaultRegularPrice - originalPrice
      case None => 0
    }
  }

  case object ThreeForThePriceOfTwoOrangeDiscount extends Discount {
    def apply(cart: Cart): Double = cart.quantities.get(Orange()) match {
      case Some(oranges) =>
        val originalPrice = oranges * Orange.DefaultRegularPrice
        (oranges - oranges / 3) * Orange.DefaultRegularPrice - originalPrice
      case None => 0
    }
  }
}
