package algs32.kdtree;
import algs12.Point2D;

import algs13.Queue;
import stdlib.*;

import algs32.kdtree.RectHV;;

/* a set of points implemented as kd-tree */
public class KdTree {
	
	private int N;
	
  private static class Node {
	public Point2D point;
    public Node left,right;
	public boolean vertical;
	public RectHV container;
	public Node(Point2D point, final boolean vert, RectHV container) {
		this.point = point;
		this.vertical = vert;		
		this.container = container;
	}
	
  }
  private Node root;

  /* construct an empty set of points */
  public KdTree() {
	  N = 0;
	  root = null;
  }

  /* is the set empty? */
  public boolean isEmpty() {
	  return N == 0;
  }

  /* add the point p to the set (if it is not already in the set) */
  public void insert(Point2D p) {
	  if (contains(p) == false) {
		  insertHelper(root, p, true, new RectHV (0,0,1,1));
	  }
	  else {
	  }
  }
  private Node insertHelper (Node node, Point2D p, boolean vertical, RectHV r) {
	  
	  if (node == null) {
		  return new Node (p, vertical, r);
	  }
	  if (node.vertical == true && p.x() < node.point.x() || node.vertical == false && p.y() < node.point.y()) {
		  if (vertical == true) {
			  node.left = insertHelper(node.left, p, !vertical, new RectHV(r.xmin(), r.ymin(), node.point.x(),r.ymax()));
		  }
		  else {
			  node.left = insertHelper(node.left, p, !vertical, new RectHV(r.xmin(), r.ymin(), r.xmax(), node.point.y()));
		  }
	  }
	  else {
		  if (vertical == true) {
			  node.right = insertHelper(node.right, p, !vertical, new RectHV(node.point.x(), r.ymin(), r.xmax(), r.ymax()));
		  }
		  else {
			  node.right = insertHelper(node.right, p, !vertical, new RectHV(r.xmin(), node.point.y(), r.xmax(), r.ymax()));
		  }
	  }
	  return node;
	  
  }
  /* does the set contain the point p? */
  public boolean contains(Point2D target) {
	  return containsHelper(root, target.x(), target.y());
  }
  
  private boolean containsHelper(Node node, double x, double y) {
	  if (node == null) {
		  return false;
	  }
	  if (node.point.x() == x && node.point.y() == y) {
		  return true;
	  }
	  if (node.vertical == true && x < node.point.x() || node.vertical == false && y < node.point.y()) {
		  return containsHelper(node.left, x, y);
	  }
	  else {
		  return containsHelper(node.right, x, y);
	  }
  }

  /* all points in the set that are inside the target rectangle */
  public Iterable<Point2D> range(RectHV target) {
    Queue<Point2D> points = new Queue<>();
    Queue<Node> queue = new Queue<>();
    while (!queue.isEmpty()) {
    	Node node = queue.dequeue();
    	if (node == null) continue;
    	if (target.contains(node.point) && node.left == null && node.right == null) {
    		points.enqueue(node.point);
    	}
    	else {
    		if (node.vertical == true) {
    			if (target.xmin() < node.point.x() && node.point.x() < target.xmax()) {
    				queue.enqueue(node.left);
    				queue.enqueue(node.right);
    			}
    			else if (target.xmax() < node.point.x()){
    				queue.enqueue(node.left);
    			}
    			else if (node.point.x() < target.xmin()) {
    				queue.enqueue(node.right);
    			}
    		}
    		else {
    			if (target.ymin() < node.point.y() && node.point.y() < target.ymax()) {
    				queue.enqueue(node.left);
    				queue.enqueue(node.right);
    			}
    			else if (target.ymax() < node.point.y()){
    				queue.enqueue(node.left);
    			}
    			else if (node.point.y() < target.ymin()) {
    				queue.enqueue(node.right);
    			}
    		}
    	}
    }
    return points;
  }

  /* a nearest neighbor to target point; null if empty */
  public Point2D nearest(Point2D target) {
    if (target == null || isEmpty() == true) {
    	return null;
    }
    else {
    	return nearestHelper(root,target);
    }
  }
  private Point2D nearestHelper(Node node, Point2D target) {
	  if (target == node.point) {
		  return node.point;
	  }
	  if (node.point.distanceTo(target) < node.right.point.distanceTo(target) && node.point.distanceTo(target) < node.left.point.distanceTo(target)) {
		  return node.point;
	  }
	  else if (node.point.distanceTo(target) < node.right.point.distanceTo(target) && node.point.distanceTo(target) > node.left.point.distanceTo(target)) {
		  return nearestHelper(node.left, target);
	  }
	  else if (node.point.distanceTo(target) > node.right.point.distanceTo(target) && node.point.distanceTo(target) < node.left.point.distanceTo(target)) {
		  return nearestHelper(node.right, target);
	  }
	  else {
		  return node.point;
	  }
  }

  /* draw all of the points to standard draw */
  /* for x-node, use red line to draw the division between left/right */
  /* for y-node, use blue line to draw the division between top/bottom */
  /* see the writeup for examples */
  public void draw () {
	    draw (root);
	}
	private static void draw (Node n) {
	    if (n == null) return;
	    StdDraw.setPenRadius (.003);
	    if (n.vertical) {
	        StdDraw.setPenColor (StdDraw.RED);
	        StdDraw.line (n.point.x (), n.container.ymin (), n.point.x (), n.container.ymax ());
	    } else {
	        StdDraw.setPenColor (StdDraw.BLUE);
	        StdDraw.line (n.container.xmin (), n.point.y (), n.container.xmax (), n.point.y ());
	    }
	    draw (n.left);
	    draw (n.right);

	    StdDraw.setPenRadius (.007);
	    StdDraw.setPenColor (StdDraw.BLACK);
	    n.point.draw ();
	}
  


  /* some test code */
  public void toGraphviz() { GraphvizBuilder.nodesToFile (root); }
  private static void insert5Points (KdTree kdtree, double xoffset, double yoffset) {
    kdtree.insert (new Point2D (0.7 + xoffset, 0.2 + yoffset));
    kdtree.insert (new Point2D (0.5 + xoffset, 0.4 + yoffset));
    kdtree.insert (new Point2D (0.2 + xoffset, 0.3 + yoffset));
    kdtree.insert (new Point2D (0.4 + xoffset, 0.7 + yoffset));
    kdtree.insert (new Point2D (0.9 + xoffset, 0.6 + yoffset));
  }
  public static void main (String[] args) {
    KdTree kdtree = new KdTree ();
    insert5Points (kdtree, 0.0, 0.0); // after this there should be 5 points
    insert5Points (kdtree, 0.0, 0.0); // after doing it twice there should still be 5
    insert5Points (kdtree, 0.1, 0.0); // this should add 5 more points
    insert5Points (kdtree, 0.0, 0.1); // this should add 5 more points


    //        kdtree.insert (new Point2D(0.15, 0.18));
    //        kdtree.insert (new Point2D(0.86, 0.26));
    //        kdtree.insert (new Point2D(0.70, 0.11));
    //        kdtree.insert (new Point2D(0.16, 0.01));
    //        kdtree.insert (new Point2D(0.62, 0.95));
    //        kdtree.insert (new Point2D(0.98, 0.04));
    //        kdtree.insert (new Point2D(0.87, 0.79));
    //        kdtree.insert (new Point2D(0.83, 0.21));

    //        Point2D mid = new Point2D (0.5, 0.5);
    //        Point2D less = new Point2D (0.5, 0.4);
    //        Point2D more = new Point2D (0.5, 0.6);
    //        kdtree.insert (mid);
    //        kdtree.insert (less);
    //        kdtree.insert (more);
    //        StdOut.println (kdtree.contains (less));
    //        StdOut.println (kdtree.contains (more));
    //        StdOut.println (kdtree.range (new RectHV (0.5, 0.4, 0.5, 0.6)));
    //        StdOut.println (kdtree.nearest (less));
    //        StdOut.println (kdtree.nearest (more));

    StdOut.println (kdtree);
	kdtree.toGraphviz ();
    kdtree.draw ();
  }
}