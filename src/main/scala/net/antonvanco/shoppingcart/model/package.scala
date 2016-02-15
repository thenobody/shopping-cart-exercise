package net.antonvanco.shoppingcart

/**
 * Created by antonvanco on 15/02/2016.
 */
package object model {

  sealed trait Item {
    def regularPrice: Double
  }

  case class Apple(regularPrice: Double) extends Item
  object Apple {
    val DefaultRegularPrice = 0.6
    def apply(): Apple = Apple(DefaultRegularPrice)
  case class Orange(regularPrice: Double) extends Item
  }

  case class Orange(regularPrice: Double) extends Item
  object Orange {
    val DefaultRegularPrice = 0.25
    def apply(): Orange = Orange(DefaultRegularPrice)
  }

  object Item {
    val itemMapping = Map(
      "apple" -> Apple.apply,
      "orange" -> Orange.apply
    )

    def apply(itemName: String): Item = itemMapping.getOrElse(
      itemName.toLowerCase,
      throw new IllegalArgumentException(s"Unknown item name: $itemName")
    )
  }
}
