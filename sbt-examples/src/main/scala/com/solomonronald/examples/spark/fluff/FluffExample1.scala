package com.solomonronald.examples.spark.fluff

import com.github.solomonronald.spark.fluff.Fluff
import org.apache.spark.sql.{DataFrame, SparkSession}

object FluffExample1 {

  def main(args: Array[String]): Unit = {

    // Create a spark session
    val spark: SparkSession = SparkSession
      .builder()
      .appName("SparkFluffExample1")
      .master("local[*]")
      .getOrCreate()

    // Set path for columns csv input file
    val inputColumnsCsvPath = this.getClass.getResource("/columns1.csv").getPath
    // Set path for functions csv input file
    val inputFunctionsCsvPath = this.getClass.getResource("/functions1.csv").getPath

    // Create fluffy data frame with random data defined in above files
    val fluffyDf: DataFrame = Fluff(spark).generate(
      columnsCsvPath = inputColumnsCsvPath, functionsCsvPath = inputFunctionsCsvPath, numRows = 100)

    // Print a sample in logs
    fluffyDf.show(5)

    // Set path where the output will be stored.
    val outputPath = "./fluff-output/"
    println(s"Writing output to $outputPath")

    // Write fluffy data frame to output path
    fluffyDf.write.csv(outputPath)
  }

}
