
# Requirements

- There should be two players in the game: 'X' and 'O'.
- The board should have 3x3 cells.
- Players take alternate turns to place their marks on the board.
- A player can place their mark only on an unoccupied cell.
- The game should be able to identify and announce the winner (if there is one) or if the game is a draw.
- The game should be able to display the current state of the board.
- The game should have the ability to reset the board for a new game.
- There should be methods to validate the move.
- The game should maintain the history of moves.
- Players should be able to query the game's rules.



```mermaid 

classDiagram
    class Game

        Game  -->  GameState : depends

        Game: - board Board
        Game: - players List[Player]
        Game: - nextPlayerIndex int
        Game: - state GameState
        Game: - winnings List[WinningStrategy]

        Game: + Game()
        Game: + start()
        Game: - render()
        Game: - declareWinner()
        Game: + getState()
        Game: + reset()

    class GameState  
        <<Enum>> GameState

        GameState: NOT_STARTED
        GameState: PENDING
        GameState: FINISHED

    class Player
        Player --o Game :aggregate
        Player: id int
        Player: name string
        Player: symbol Symbol

        Player: + Player()
        Player: + getSymbol()
        Player: + getMove(board)* 
        Player: + getName()
    
    
    
    class HumanPlayer 
        HumanPlayer --|> Player : extends

        HumanPlayer: + getMove(board)


    class BotPlayer
        BotPlayer --|> Player : extends
        BotPlayer --> BotLevel :depends

        BotPlayer: moveStrategy MoveStrategy
        BotPlayer: + BotPlayer(BotLevel)
        BotPlayer: + getMove(board)

    class MoveStrategy
        <<Interface>> MoveStrategy
        MoveStrategy  --o  BotPlayer : aggregate

        MoveStrategy: + getMove(board)*
    
    class EasyMoveStrategy
        EasyMoveStrategy ..|> MoveStrategy : implements
        EasyMoveStrategy: + getMove(board)

    class MediumMoveStrategy
        MediumMoveStrategy ..|> MoveStrategy : implements
        MediumMoveStrategy: + getMove(board)

    class HardMoveStrategy
        HardMoveStrategy ..|> MoveStrategy : implements
        HardMoveStrategy: + getMove(board)

    class BotLevel
        <<Enum>> BotLevel
        BotLevel: EASY
        BotLevel: MEDIUM
        BotLevel: HARD


    class WinningStrategy   
        <<Interface>> WinningStrategy
        WinningStrategy --o  Game : aggregate
        WinningStrategy: + checkWinning(board, lastMove)*

    class VerticalWinning
        VerticalWinning ..|> WinningStrategy : implements
        VerticalWinning: + checkWinning(board, lastMove)


    class HorizontalWinning
        HorizontalWinning ..|> WinningStrategy : implements
        HorizontalWinning: + checkWinning(board, lastMove)





    class Board
        Board --* Game :composition
        Board: size int 
        Board: grid List[List[Cell]]

        Board: ~ makeMove(move)

    Class Cell
        Cell --* Board :composition
        Cell --> CellState : depends
        Cell: cellState CellState
        Cell: player Player
    
    class CellState
        <<Enum>> CellState
        CellState: EMPTY
        CellState: FILLED
    
    class Symbol
        Symbol --o Player :aggregate
        Symbol: c char
        Symbol: color string

    class Move
        Move --> Player : depends
        Move: player Player
        Move: col int  
        Move: row int

```