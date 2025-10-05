# Assignment 2 — Shell Sort Implementation and Analysis

## 📘 Overview
This project is part of the *Algorithmic Analysis and Peer Code Review* assignment.  
It implements **Shell Sort** with three gap sequences:
- Shell's original sequence (`n/2, n/4, ..., 1`)
- Knuth's sequence (`(3^k - 1) / 2`)
- Sedgewick's sequence (`4^k + 3*2^(k-1) + 1`)

The implementation tracks performance metrics (comparisons, assignments, swaps) and provides a CLI tool for benchmarking.

---

## 🧩 Project Structure
````bash
assignment2-shellsort/
├── src/
│ ├── main/java/
│ │ ├── algorithms/ShellSort.java
│ │ ├── metrics/PerformanceTracker.java
│ │ └── cli/BenchmarkRunner.java
│ └── test/java/algorithms/ShellSortTest.java
├── docs/
│ ├── analysis-report.pdf
│ └── performance/results.csv
├── pom.xml
└── README.mdassignment2-shellsort/
├── src/
│ ├── main/java/
│ │ ├── algorithms/ShellSort.java
│ │ ├── metrics/PerformanceTracker.java
│ │ └── cli/BenchmarkRunner.java
│ └── test/java/algorithms/ShellSortTest.java
├── docs/
│ ├── analysis-report.pdf
│ └── performance/results.csv
├── pom.xml
└── README.md
````

---

## ⚙️ Build and Run

### 🧱 Compile the project
```bash
mvn compile
```
🧪 Run unit tests
mvn test
🚀 Run benchmark
java -cp target/classes cli.BenchmarkRunner 10000 random knuth

The results (time, comparisons, assignments) will be printed in console and saved to
docs/performance/results.csv.

📊 Report
The detailed algorithmic analysis and performance report can be found here:
📄 docs/analysis-report.pdf

Author
Nurdaulet Aitynbek