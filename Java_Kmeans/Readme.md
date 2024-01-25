# K-Means Clustering Example in Java

This is a simple Java project that demonstrates the K-means clustering algorithm using the Apache Commons Math library.

## Getting Started:

1. Clone the repository:

   git clone ..

2. Open the project in your favorite Java IDE.

3. Add the Apache Commons Math library to your project. You can download it from here: https://commons.apache.org/proper/commons-math/download_math.cgi

4. Build and run the KMeansExample class.

## Project Structure:

- src/KMeans.java: The main class that contains the K-means clustering example.
- lib/commons-math3-3.6.1: The Apache Commons Math library JAR file.[Note: download it from link above]

## Usage:

Adjust the parameters such as the number of clusters (k), maximum iterations, and tolerance in the main method of the KMeansExample class based on your requirements.

```java
    int k = 3; // Number of clusters
    int maxIterations = 100;
    double tolerance = 0.0001;
```
The example includes a helper method (generateDataPoints()) to generate sample data points. You can replace it with your dataset.

## Dependencies:

- Apache Commons Math: https://commons.apache.org/proper/commons-math/ - A library of lightweight, self-contained mathematics and statistics components for Java.

## License:

This project is licensed under the MIT License - see the LICENSE file for details.
