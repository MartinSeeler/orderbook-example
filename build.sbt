name := "orderbook-example"
version := "0.1.0"
scalaVersion := "2.11.8"

val akkaV = "2.4.2"
val catsV = "0.4.1"
val typedActorsV = "2.0.0-a24-c3a146559115ef742edb8c79f9db53ba1e73c40e"
val scalaTestV = "2.2.6"
val scalaCheckV = "1.12.5"

resolvers += Resolver.bintrayRepo("knutwalker", "maven")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor"           % akkaV,
  "com.typesafe.akka" %% "akka-persistence"     % akkaV,
  "org.typelevel"     %% "cats-core"            % catsV,
  "org.spire-math"    %% "spire"                % "0.11.0",
  "de.knutwalker"     %% "typed-actors"         % typedActorsV,
  "de.knutwalker"     %% "typed-actors-creator" % typedActorsV,

  "com.typesafe.akka" %% "akka-testkit"         % akkaV             % "test",
  "org.scalatest"     %% "scalatest"            % scalaTestV        % "test",
  "org.scalacheck"    %% "scalacheck"           % scalaCheckV       % "test"
)