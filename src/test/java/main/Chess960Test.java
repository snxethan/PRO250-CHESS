package test.java.main;

import main.GamePanel;
import main.Type;
import org.junit.Before;
import org.junit.Test;
import piece.Piece;

import java.util.*;

import static org.junit.Assert.*;

public class Chess960Test {

    @Before
    public void reset() {
        GamePanel.pieces.clear();
        GamePanel.simPieces.clear();
    }

    private GamePanel newChess960Game() {
        return new GamePanel(true);
    }

    private GamePanel newNormalGame() {
        return new GamePanel(false);
    }

    private Type[] getWhiteBackRank(GamePanel gp) {
        Type[] arr = new Type[8];
        for (Piece p : GamePanel.pieces) {
            if (p.color == GamePanel.WHITE && p.row == 7) {
                arr[p.col] = p.type;
            }
        }
        return arr;
    }

    private Type[] getBlackBackRank(GamePanel gp) {
        Type[] arr = new Type[8];
        for (Piece p : GamePanel.pieces) {
            if (p.color == GamePanel.BLACK && p.row == 0) {
                arr[p.col] = p.type;
            }
        }
        return arr;
    }

    @Test
    public void testBishopsOnOppositeColors() {
        newChess960Game();
        int bishopDark = -1;
        int bishopLight = -1;
        for (Piece p : GamePanel.pieces) {
            if (p.color == GamePanel.WHITE && p.row == 7 && p.type == Type.BISHOP) {
                int squareColor = (p.col + p.row) % 2;
                if (squareColor == 0) bishopLight = p.col;
                else bishopDark = p.col;
            }
        }
        assertTrue("Two bishops expected", bishopDark != -1 && bishopLight != -1);
        assertNotEquals("Bishops must be on opposite colors",
                (bishopDark + 7) % 2, (bishopLight + 7) % 2);
    }

    @Test
    public void testKingBetweenRooks() {
        newChess960Game();
        int kingCol = -1;
        List<Integer> rooks = new ArrayList<>();
        for (Piece p : GamePanel.pieces) {
            if (p.color == GamePanel.WHITE && p.row == 7) {
                if (p.type == Type.KING) kingCol = p.col;
                if (p.type == Type.ROOK) rooks.add(p.col);
            }
        }
        assertEquals(2, rooks.size());
        Collections.sort(rooks);
        assertTrue("King must be between rooks", rooks.get(0) < kingCol && kingCol < rooks.get(1));
    }

    @Test
    public void testCorrectPieceCounts() {
        newChess960Game();
        Map<Type, Integer> counts = new EnumMap<>(Type.class);
        for (Piece p : GamePanel.pieces) {
            if (p.color == GamePanel.WHITE && p.row == 7) {
                counts.merge(p.type, 1, Integer::sum);
            }
        }
        assertEquals(1, (int) counts.getOrDefault(Type.KING, 0));
        assertEquals(1, (int) counts.getOrDefault(Type.QUEEN, 0));
        assertEquals(2, (int) counts.getOrDefault(Type.BISHOP, 0));
        assertEquals(2, (int) counts.getOrDefault(Type.KNIGHT, 0));
        assertEquals(2, (int) counts.getOrDefault(Type.ROOK, 0));
    }

    @Test
    public void testBlackMirrorsWhiteArrangement() {
        GamePanel gp = newChess960Game();
        Type[] white = getWhiteBackRank(gp);
        Type[] black = getBlackBackRank(gp);
        assertArrayEquals("Black back rank must mirror white", white, black);
    }

    @Test
    public void testMultipleGenerationsProduceDifferentArrangements() {
        Set<String> layouts = new HashSet<>();
        for (int i = 0; i < 30; i++) {
            reset();
            newChess960Game();
            StringBuilder sb = new StringBuilder();
            // Collect white back rank after creation
            Type[] white = getWhiteBackRank(null);
            for (Type t : white) sb.append(t.name().charAt(0));
            layouts.add(sb.toString());
            if (layouts.size() > 1) break;
        }
        assertTrue("Expected at least 2 different Chess960 layouts over runs", layouts.size() > 1);
    }

    @Test
    public void testNormalModeStandardSetup() {
        GamePanel gp = newNormalGame();
        Type[] white = getWhiteBackRank(gp);
        Type[] expected = {
                Type.ROOK, Type.KNIGHT, Type.BISHOP, Type.QUEEN,
                Type.KING, Type.BISHOP, Type.KNIGHT, Type.ROOK
        };
        assertArrayEquals(expected, white);
    }
}