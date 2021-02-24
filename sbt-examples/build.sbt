name := "Spark Fluff Examples"

version := "1.0"

scalaVersion := "2.11.12"

val sparkVersion = "2.4.0"

// Note the dependencies are provided
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,
  "com.github.solomonronald" % "spark-fluff" % "1.0.0"
)