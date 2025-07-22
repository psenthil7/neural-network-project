# Neural Network Digit Recognition

This project implements a simple feedforward neural network designed to recognize handwritten digits. The network uses a modified BFS (Breadth-First Search) approach to process input and hidden layers in a clean, layer-by-layer fashion.

---

## How It Works

Each pixel of the input image is treated as an input neuron. The network enqueues all input neurons first to ensure that all downstream neurons receive their full set of inputs before any computations happen.

### Traversal Order

```
I[0], I[1], ..., I[783] → H1[0], H1[1], ..., H1[255] → H2[0], ..., H2[127] → O[0], ..., O[9]
```

* `I[n]`: Input neurons (pixels)
* `H1[n]`: First hidden layer
* `H2[n]`: Second hidden layer
* `O[n]`: Output layer (digit 0-9)

Each neuron is visited once in order, ensuring a complete and structured forward pass.

---

## Demo Results

We tested the model with handwritten digit inputs. Here's what we found:

* Digits like 0, 1 and, 8 were recognized accurately when written neatly and centered.
* Digits like 4, 5, and, 9 caused more errors, especially with curved or unusual handwriting.
* The network is sensitive to handwriting style** since no input preprocessing is applied.
* It performs best with simple, symmetric digits.


## Contact

Have questions or want to improve the project? Open an issue or submit a pull request!
