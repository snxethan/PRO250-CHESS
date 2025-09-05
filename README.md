# PRO250 Chess Game

A feature-rich chess game implementation in Java with a graphical user interface built using Swing. This project supports both traditional chess and Chess960 (Fischer Random Chess) variants.

## Features

- **Traditional Chess**: Complete implementation of standard chess rules
- **Chess960 Support**: Fischer Random Chess with randomized starting positions
- **Interactive GUI**: User-friendly graphical interface built with Java Swing
- **Mouse Controls**: Click-and-drag piece movement
- **Game Validation**: Complete move validation and game state checking
- **Check/Checkmate Detection**: Automatic detection of check, checkmate, and stalemate
- **Piece Promotion**: Pawn promotion to Queen, Rook, Bishop, or Knight
- **Castling**: Support for both kingside and queenside castling
- **En Passant**: Special pawn capture rule implementation

## System Requirements

- **Java**: JDK 17 or higher
- **Operating System**: Windows, macOS, or Linux
- **Memory**: 512 MB RAM minimum
- **Display**: 800x600 minimum resolution

## How to Build and Run

### Option 1: Using Command Line

1. **Clone the repository**:
   ```bash
   git clone https://github.com/snxethan/PRO250-CHESS.git
   cd PRO250-CHESS
   ```

2. **Compile the project**:
   ```bash
   mkdir -p build
   javac -cp src -d build src/main/*.java src/piece/*.java
   ```

3. **Run the game**:
   ```bash
   java -cp build:res main.Main
   ```

### Option 2: Using IntelliJ IDEA

1. Open IntelliJ IDEA
2. Select "Open" and choose the project directory
3. The project should load automatically with the existing `.iml` configuration
4. Run the `Main.java` class

## How to Play

### Starting the Game

1. Launch the application
2. Choose between:
   - **Standard Chess**: Traditional chess with standard starting positions
   - **Chess960**: Fischer Random Chess with randomized piece positions

### Game Controls

- **Move Pieces**: Click on a piece to select it, then click on the destination square
- **Piece Selection**: Valid moves are highlighted when a piece is selected
- **Promotion**: When a pawn reaches the opposite end, choose the promotion piece
- **New Game**: Restart the application to start a new game

### Chess Rules

The game follows standard FIDE chess rules including:
- Standard piece movements (King, Queen, Rook, Bishop, Knight, Pawn)
- Special moves: Castling, En Passant, Pawn Promotion
- Win conditions: Checkmate
- Draw conditions: Stalemate

## Project Structure

```
PRO250-CHESS/
├── src/
│   ├── main/
│   │   ├── Main.java           # Application entry point
│   │   ├── GamePanel.java      # Main game logic and rendering
│   │   ├── Board.java          # Chess board representation
│   │   ├── Mouse.java          # Mouse input handling
│   │   ├── StartScreen.java    # Start menu interface
│   │   └── Type.java           # Piece type enumeration
│   ├── piece/
│   │   ├── Piece.java          # Base piece class
│   │   ├── King.java           # King piece implementation
│   │   ├── Queen.java          # Queen piece implementation
│   │   ├── Rook.java           # Rook piece implementation
│   │   ├── Bishop.java         # Bishop piece implementation
│   │   ├── Knight.java         # Knight piece implementation
│   │   └── Pawn.java           # Pawn piece implementation
│   └── test/
│       └── java/
│           └── main/           # Test classes (JUnit)
├── res/
│   ├── chess.png              # Chess piece sprite sheet
│   └── piece/                 # Individual piece images
├── out/                       # Compiled output directory
├── .idea/                     # IntelliJ IDEA configuration
├── ChessGame.iml             # IntelliJ IDEA module file
└── README.md                 # This file
```

## Development

### Architecture Overview

The project follows an object-oriented design with clear separation of concerns:

- **Main Package**: Contains the main application logic, UI components, and game management
- **Piece Package**: Contains individual chess piece implementations with their specific movement rules
- **Resource Management**: Images and assets are loaded from the `res/` directory

### Key Classes

- `GamePanel`: Core game engine handling game state, piece movement, and rendering
- `Board`: Represents the chess board and provides utility methods for board operations
- `Piece`: Abstract base class for all chess pieces with common functionality
- Individual piece classes: Implement specific movement patterns and rules

### Testing

The project includes JUnit test infrastructure. Tests can be run using:

```bash
# Compile tests
javac -cp src:build:/path/to/junit-4.13.1.jar -d build src/test/java/main/*.java

# Run tests (if test files exist)
java -cp build:/path/to/junit-4.13.1.jar org.junit.runner.JUnitCore main.TestClassName
```

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Coding Standards

- Follow Java naming conventions
- Add JavaDoc comments for public methods
- Maintain consistent indentation and formatting
- Write unit tests for new functionality

## License

This project is part of the PRO250 course curriculum. Please check with the course instructor regarding usage and distribution rights.

## Acknowledgments

- Chess piece images and sprites used in the game
- Java Swing framework for GUI implementation
- JUnit framework for testing infrastructure

---

## Author(s)

- [**Ethan Townsend (snxethan)**](www.ethantownsend.dev)
