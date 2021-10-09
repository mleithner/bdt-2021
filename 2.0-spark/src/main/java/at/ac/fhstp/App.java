package at.ac.fhstp;

import org.apache.spark.sql.SparkSession;

/**
 * Ingest the data!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Running Ingestion");
        if (args.length == 0) {
            System.out.println("No files provided.");
            System.exit(0);
        }
        IngestionSchemaManipulationApp app = new IngestionSchemaManipulationApp();
        SparkSession spark = SparkSession.builder()
                .appName("Restaurants in Wake County, NC")
                .master("local")
                .getOrCreate();
        app.ingestCSV(spark, args[0]);
        spark.stop();
    }
}
