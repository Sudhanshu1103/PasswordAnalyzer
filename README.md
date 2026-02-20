# PasswordAnalyzer

A Java-based password strength analyzer that evaluates password security by calculating a numerical score and providing an assessment of password robustness.

## Features

- **Comprehensive Scoring System**: Evaluates passwords across multiple security dimensions
- **Strength Assessment**: Categorizes passwords as Very Weak, Not Weak, or Strong
- **Multiple Criteria**: Analyzes character variety, length, repetition, and adjacent characters
- **Real-time Feedback**: Provides immediate security scores and verdicts

## How It Works

The analyzer calculates a security score based on:

### Scoring Points
- **Length**: 3 points per character (minimum 8 characters required)
- **Uppercase Letters**: +4 points
- **Lowercase Letters**: +2 points
- **Digits**: +3 points
- **Special Symbols**: +6 points

### Penalties
- **Repeated Characters**: -2 points each
- **Adjacent Repeated Characters**: -3 points each

### Strength Levels
- **Score < 30**: Very weak (can be breached)
- **Score 30-59**: Not weak but can be breached
- **Score ≥ 60**: Strong password

## Supported Special Characters

`! @ # % ^ & * ( ) _ + = - ` ~ [ ] \ { } | ; ' : " , . / < > ?`

## Usage

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Compile
```bash
javac PasswordAnalyzer.java
```

### Run
```bash
java PasswordAnalyzer
```

When prompted, enter a password and the program will display:
- The password you entered
- Security score
- Strength verdict

### Example
```
Type in a password: MyP@ssw0rd!
Password you entered: MyP@ssw0rd!
Security Score: 87
Verdict: Strong password
```

## Installation

1. Clone the repository or download `PasswordAnalyzer.java`
2. Navigate to the directory containing the file
3. Follow the compilation and run instructions above

## License

See [LICENSE](LICENSE) for details.
