package com.evolutiongaming.skafka.consumer

sealed trait GroupProtocol extends Product {
  def name: String
}

object GroupProtocol {
  val Values: Set[GroupProtocol] = Set(Classic, Consumer())

  case object Classic extends GroupProtocol { def name: String = "classic" }

  /** @param remoteAssignor `group.remote.assignor`, the broker default when `None` */
  final case class Consumer(remoteAssignor: Option[String] = None) extends GroupProtocol {
    def name: String = "consumer"
  }
}
