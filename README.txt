
Unlike typical BFS, we enqueue all input neurons because each one represents a unique pixel and must independently pass its value to the next layer. After discussion, we decided that this ensures that all downstream neurons receive their full set of inputs and the network performs a complete forward pass.

Using the modified BFS approach, the neurons are visited layer by layer, starting with all input neurons.
The traversal order: 
I[0], I[1], ..., I[783] → H1[0], H1[1], ..., H1[255] → H2[0], ..., H2[127] → O[0], ..., O[9]
Each neuron is visited exactly once in layer order due to the BFS logic. This ensures all neurons receive their required inputs before computing their outputs.

Existing Demo Findings:

We tested the digit recognition demo and found that the network performed well with clearly written digits like 0, 1, and 8. These were usually predicted correctly, especially when centered and neatly drawn. Digits like 4, 5, and 9 were more prone to errors, especially when written with curves or unusual strokes. Overall, the network seems to do best with simple, symmetric digits and struggles more with ones that vary a lot in handwriting style. This confirmed that the model is sensitive to how the digit is drawn, especially since it's using pixel-based input without any pre-processing.






