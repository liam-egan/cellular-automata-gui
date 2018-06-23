package ap.gui.grid;

public class Position {
        protected int x;
        protected int y;
    
        public Position() {
            this(0, 0);
        }
    
        public Position(Position p) {
            this(p.getX(), p.getY());
        }
    
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    
        public int getX() {
            return this.x;
        }
    
        public int getY() {
            return this.y;
        }
    
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    
        public boolean equals(Object o) {
            if (!(o instanceof Position)) {
                return false;
            }
    
            Position p = (Position) o;
            return (p.getX() == this.x &&
                            p.getY() == this.y);
        }
    }
