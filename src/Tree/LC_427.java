package Tree;

public class LC_427 {
    
    // Construct Quad Tree
    /*Given a n * n matrix grid of 0's and 1's only. We want to represent grid with a Quad-Tree.
    Return the root of the Quad-Tree representing grid. 
    A Quad-Tree is a tree data structure in which each internal node has exactly four children. 
    Besides, each node has two attributes:
        -- val: True if the node represents a grid of 1's or False if the node represents a grid of 0's. 
        Notice that you can assign the val to True or False when isLeaf is False, and both are accepted in the answer.
        -- isLeaf: True if the node is a leaf node on the tree or False if the node has four children.

        class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
    }

    We can construct a Quad-Tree from a two-dimensional area using the following steps:
        -- If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and 
        set val to the value of the grid and set the four children to Null and stop.
        -- If the current grid has different values, set isLeaf to False and set val to any value 
        and divide the current grid into four sub-grids as shown in the photo.
        -- Recurse for each of the children with the proper sub-grid.
    */

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

    
        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
    
        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
    
        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
}

    public static void main(String[] args) {
        LC_427 obj = new LC_427();
        int[][] grid = {
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {1, 0, 1, 1},
            {1, 1, 1, 1}
        };
        obj.printQuadTree(obj.construct(grid), "");
    }

    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) return null;
        return build(grid, 0, 0, grid.length);
    }

    // Recursive function to build the Quad Tree
    private Node build(int[][] grid, int row, int col, int size) {
        // Check if the subgrid has all same values
        boolean isLeaf = true;
        int val = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
            if (!isLeaf) break;
        }

        if (isLeaf) {
            // All same → leaf node
            return new Node(val == 1, true);
        }

        // Otherwise → internal node, divide into 4 parts
        int newSize = size / 2;
        Node topLeft = build(grid, row, col, newSize);
        Node topRight = build(grid, row, col + newSize, newSize);
        Node bottomLeft = build(grid, row + newSize, col, newSize);
        Node bottomRight = build(grid, row + newSize, col + newSize, newSize);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    public void printQuadTree(Node node, String indent) {
        if (node == null) return;

        if (node.isLeaf) {
            System.out.println(indent + "Leaf: " + (node.val ? "1" : "0"));
        } else {
            System.out.println(indent + "Internal Node");
            printQuadTree(node.topLeft, indent + "  topLeft -> ");
            printQuadTree(node.topRight, indent + "  topRight -> ");
            printQuadTree(node.bottomLeft, indent + "  bottomLeft -> ");
            printQuadTree(node.bottomRight, indent + "  bottomRight -> ");
        }
    }

}
