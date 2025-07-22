/**
 * Copyright (c) 2025 Sami Menik, PhD. All rights reserved.
 * 
 * Unauthorized copying of this file, via any medium, is strictly prohibited.
 * This software is provided "as is," without warranty of any kind.
 */
package cs2725.examples;

import java.io.File;

import cs2725.api.nn.NeuralNetwork;
import cs2725.impl.nn.DigitsDataset;
import cs2725.impl.nn.SimpleNeuralNetwork;

/**
 * This class tests the accuracy of the neural network using the loaded dataset.
 */
public class DigitNetworkAccuracy {

    public static void main(String[] args) {
        DigitsDataset dataset = DigitsDataset.load();

        String weightsPath = "resources" + File.separator + "digits_network_weights.txt";
        NeuralNetwork network = new SimpleNeuralNetwork(weightsPath);

        int correctPredictions = 0;
        int totalSamples = dataset.size();

        // iterate over each sample in the dataset
        for (int i = 0; i < totalSamples; i++) {
            float[] input = dataset.getInput(i);
            int trueLabel = dataset.getLabel(i);

            // get prediction output from the network
            float[] outputs = network.predict(input);

            // find the index of the maximum value in the output array
            int predictedLabel = 0;
            float maxOutput = outputs[0];
            for (int j = 1; j < outputs.length; j++) {
                if (outputs[j] > maxOutput) {
                    maxOutput = outputs[j];
                    predictedLabel = j;
                } // if
            } // for

            if (predictedLabel == trueLabel) {
                correctPredictions++;
            } // if
        } // for

        // calculate and display accuracy
        double accuracy = (double) correctPredictions / totalSamples;
        System.out.printf("Accuracy: %.2f%%%n", accuracy * 100);
    } // main
} //digitnetworkaccuracy
