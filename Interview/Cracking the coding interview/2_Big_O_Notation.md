## 2. Big O Notation

### What: Asymptote Runtime (Infinity)
* Language/metric - describes efficiency of algorithms
* Time to share a file:
    * Electronic transfer: size increases, time increases **O(size)**
    * Physical handover: constant time **O(1)**
    * Other runtimes: **O(log n)**, **O(n log n)**, **O(n)**, **O(n²)**, **O(2ⁿ)**

### Big O, Big Theta, Big Omega
* **Big O**: Upper bound on the time
* **Big Omega (Ω)**: Lower bound on the time (won't be faster than this)
* **Big Theta (Θ)**: Both O and Ω - tight bound on runtime
* **Note**: This book uses Big O (industry standard) to offer tighter description of runtime
    * **Why**: If O(n) is the upper bound, then O(n²), O(n³) are also upper bounds
    * **But what we mean**: O(n) is the slowest runtime of the algorithm (similar to Θ)
    * O(n²) and O(n³) are loose; tighter one is O(n)

### Quick Sort (Simple Intro)

#### Overview
* **Quick sort**: pivot element (swap: before pivot = everything less, after = greater)
* **Pivot selection strategies**: first, last (worst for sorted), middle (balanced), random (popular), median of (low, mid, last)

#### Example: Pivot Selection
* `[2, 4, 1, 5, 8]`: pivot = median(2, 1, 8) = median(1, 2, 8) = **2**
    * 1 < 2 < 8 (3 variables, choose second greatest/second lowest)

#### Why Median of Three for Pivot?
* **Advantages**:
    * More predictable, faster, avoids worst case scenario
    * Simple (3 comparisons), no extra memory
    * Tackles: sorted, nearly sorted, and reverse sorted cases
    * Better cache performance (faster RAM access): uses nearby data
    * No need to randomly load - everything is nearby
    * CPU loads as a block: 64 bytes (cache miss is reduced) - low memory access

* **Why not random**:
    * Need generator, overhead per partition
    * Harder to debug (random not deterministic)
    * Not cache friendly

* **Why not true median**: Costs O(n) per recursion - not preferred

#### Partition
* Rearrange array → everything < pivot moved left
* Rearrange array → everything > pivot moved right

#### Partition Methods: Lomuto
* Single forward iteration: first move the pivot to the end
* **Example**: `[4, 3, 2, 1]` → pivot at end: `[4, 1, 2, 3]`
    * (i = low - 1, j = low to high - 1)
    * j = 0 → arr[0] ≤ pivot → no
    * j = 1 → 1 ≤ 3 → yes (i++, swap(arr[i], arr[j]) → `[3, 4, 2, 1]`
    * j = 2 → 2 ≤ 3 → yes (i++, swap(4, 2) → `[3, 2, 4, 1]`
    * j = 3 → 1 ≤ 3 → yes (i++, swap(4, 1) → `[3, 2, 1, 4]`

#### Recursion
* `quicksort(start, pivot_index - 1)`
* `quicksort(pivot_index + 1, end)`

#### Popular Library Implementations (Uses Mixture)
* **Java**: Dual pivot quick sort, fallback to insertion sort for smaller arrays
* **Python**: Timsort
* **C++ (std::sort)**: Introsort (median of three pivot), switches to heap sort if recursion is deep

### Best Case, Worst Case, Expected Case (Quick Sort)

#### Best Case: O(n)
* All elements equal: traverse only once
* **Example**: `quicksort(0, 3): [2, 1, 4, 7]`
    * median(2, 1, 7) = 2, partition: `[1, 2, 4, 7]` → pivotIndex = 1
    * `quicksort(start: 0, pivotIndex - 1: 0)`: `[1]` - no partition, no pivot
    * `quicksort(pivotIndex + 1: 2, end: 3)`: `[4, 7]` - median(4, 4, 7) = 4, partition: `[4, 7]`
        * `quicksort(2, 1)`: empty
        * `quicksort(3, 3)`: single array

#### Worst Case: O(n²)
* Array sorted in reverse order
* **Example**: `quicksort(0, 3): [4, 3, 2, 1]`
    * median(4, 3, 1) = 3, partition...
    * `quicksort(0, 1)`: `[2, 4]`
    * `quicksort(2, 3)`
