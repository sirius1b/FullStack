
## Requirements

- Create a representation for the chessboard.
- Represent all the pieces: King, Queen, Bishop, Knight, Rook, and Pawn.
- Differentiate the pieces based on color: Black and White.
- Each piece should have a method to determine its legal moves based on its current position.
- The chessboard should have a method to move a piece from one position to another.
- There should be a way to check the status of the game, e.g., ongoing, check, checkmate, or stalemate.
- The game should support special moves: castling, pawn promotion, and en passant.
- Implement a player class, where each player has a color and a set of pieces.
- Include a game class that will handle turn-based gameplay between two players.
- The game should have a method to capture and remove a piece from the board.





        

    


```mermaid

classDiagram
    
    class Game
        Game --> GameStatus : depends
        
        Game: - nextPlayerIndex int
        Game: - board Board
        Game: - status GameStatus
        Game: - finishStrategies List[FinishStrategy]
        Game: players List[Player]

        Game: + Game()
        Game: + start()
        Game: - declareWinner()
    
    
    class GameStatus
        <<Enum>> GameStatus
        GameStatus: NOT_STARTED
        GameStatus: ONGOING
        GameStatus: CHECKMATE
        GameStatus: STALEMATE
        GameStatus: PAUSED
    

    class Board

        Board --* Game :composition

        Board: - grid List[List[Cell]]
        Board: history List[Move]

        Board: + render()
        Board: ~ makeMove(move)
        Board: - removePiece(Cell)
        Board: - addPiece(Cell)



    class Color
        <<Enum>> Color
        Color: BLACK
        Color: WHITE


    class Cell

        Cell --> Color :depends
        Cell --* Board: composition

        Cell: + color Color
        Cell: - col int
        Cell: - row int
        Cell: - piece Piece
        Cell: ~ removePiece()
        Cell: ~ addPiece(piece)

    class Piece
        <<Abstract>> Piece
        Piece --> Color :depends
        Piece --* Player: composition
        Piece --* Cell: composition
        Piece: - color Color
        Piece: - currentCol int
        Piece: - currentRow int
        Piece: ~ isLegalMove(board, move)*
        Piece: + getRow()
        Piece: + getCol()
    
    class Rook
        Rook --|> Piece :extends
        Rook: ~ isLegalMove(board, move)
    class Knight
        Knight --|> Piece :extends
        Knight: ~ isLegalMove(board, move)
    class King
        King --|> Piece :extends
        King: ~ isLegalMove(board, move)
    class Queen
        Queen --|> Piece :extends
        Queen: ~ isLegalMove(board, move)
    class Bishop
        Bishop --|> Piece :extends
        Bishop: ~ isLegalMove(board, move)
    class Pawn
        Pawn --|> Piece :extends
        Pawn: ~ isLegalMove(board, move)


    class Move
        Move --o Board: aggregate
        Move: ~ col int
        Move: ~ row int
        Move: ~ piece Piece
        Move: + getCol()
        Move: + getRow()
        Move: + getPiece()


    class Player

        Player --o Game :aggregate
        Player --> Color: depends

        Player: - name string
        Player: - color Color
        Player: - alivePiece List<Piece>
        Player: - deadPiece  List<Piece>

        Player: + getName()
        Player: + getColor()
        Player: + getMove()
        
    
    class FinishStrategy
        FinishStrategy --o Game: aggregate
        <<Interface>> FinishStrategy 
        FinishStrategy: isApplicable(board, player)*
    
    class DetectCheckmate
        DetectCheckmate ..|> FinishStrategy : implements
        DetectCheckmate: isApplicable(board, player)
    
    class DetectStalemate
        DetectStalemate ..|> FinishStrategy : implements
        DetectStalemate: isApplicable(board, player)
    
    class EnemyKingDefeated 
        EnemyKingDefeated ..|> FinishStrategy : implements
        EnemyKingDefeated: isApplicable(board, player)
    


```


