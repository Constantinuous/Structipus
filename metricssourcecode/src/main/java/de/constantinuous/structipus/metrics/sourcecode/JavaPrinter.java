package de.constantinuous.structipus.metrics.sourcecode;

import com.github.javaparser.ParseException;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by RichardG on 17.12.2015.
 */
public class JavaPrinter {

    public void print(String fileName) {
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
            // parse the file

            // visit and print the methods names
            AstMetricCounter metricCounter = new AstMetricCounter(inputStream);

            System.out.println("IOException: " + metricCounter.getMcCabe());
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        } catch (ParseException p){
            System.out.println("ParseException: " + p);
        }
    }

}
