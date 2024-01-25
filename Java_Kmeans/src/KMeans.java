import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.Cluster;
import org.apache.commons.math3.ml.clustering.Clusterer;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;
import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.ml.distance.DistanceMeasure;

import java.util.ArrayList;
import java.util.List;

public class KMeansExample {

    public static void main(String[] args) {
        // Generate some sample data
        List<double[]> dataPoints = generateDataPoints();

        // Set the number of clusters (you can adjust this based on your needs)
        int k = 3;

        // Set the maximum number of iterations and the tolerance for convergence
        int maxIterations = 100;
        double tolerance = 0.0001;

        // Create a KMeansPlusPlusClusterer with Euclidean distance measure
        DistanceMeasure distanceMeasure = new EuclideanDistance();
        Clusterer<double[]> clusterer = new KMeansPlusPlusClusterer<>(k, maxIterations, tolerance, distanceMeasure);

        // Perform clustering
        List<Cluster<double[]>> clusters = clusterer.cluster(dataPoints);

        // Display the results
        for (int i = 0; i < clusters.size(); i++) {
            System.out.println("Cluster " + (i + 1) + ":");
            CentroidCluster<double[]> cluster = (CentroidCluster<double[]>) clusters.get(i);
            System.out.println("Centroid: " + arrayToString(cluster.getCenter().getPoint()));
            System.out.println("Points: ");
            for (double[] point : cluster.getPoints()) {
                System.out.println(arrayToString(point));
            }
            System.out.println();
        }
    }

    // Helper method to generate sample data points
    private static List<double[]> generateDataPoints() {
        List<double[]> dataPoints = new ArrayList<>();
        dataPoints.add(new double[]{1.0, 2.0});
        dataPoints.add(new double[]{1.5, 1.8});
        dataPoints.add(new double[]{5.0, 8.0});
        dataPoints.add(new double[]{8.0, 8.0});
        dataPoints.add(new double[]{1.0, 0.6});
        dataPoints.add(new double[]{9.0, 11.0});
        dataPoints.add(new double[]{8.0, 2.0});
        dataPoints.add(new double[]{10.0, 2.0});
        dataPoints.add(new double[]{9.0, 3.0});
        return dataPoints;
    }

    // Helper method to convert an array to a string for display
    private static String arrayToString(double[] array) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (double value : array) {
            stringBuilder.append(value).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
