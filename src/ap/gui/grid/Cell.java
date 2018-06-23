package ap.gui.grid;

public class Cell {
        private static final String ENABLED = "\u25A0";
        private static final String DISABLED = "\u25A1";
        
        protected boolean enabled;
    
        public Cell() {
            this(false);
        }
    
        public Cell(Cell c) {
            this(c.getEnabled());
        }
    
        public Cell(boolean enabled) {
            this.enabled = enabled;
        }
    
        public boolean getEnabled() {
            return this.enabled;
        }
    
        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    
        public void toggleEnabled() {
            this.enabled = !this.enabled;
        }
    
        public String toString() {
            return this.enabled ? Cell.ENABLED : Cell.DISABLED;
        }
    
        public boolean equals(Object o) {
            if (!(o instanceof Cell)) {
                return false;
            }
    
            Cell c = (Cell) o;
            return c.getEnabled() == this.enabled;
        }
    }
