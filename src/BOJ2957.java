import java.util.Scanner;

// 이진탐색트리 Binary Search Tree
public class BOJ2957 {
	public static void main(String[] args) {
		BST tree = new BST();
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		for(int i = 0; i < N; i++){
			int X = scanner.nextInt();
			tree.insert(X, tree.getRoot());
			System.out.println(tree.getCount());
		}
		scanner.close();
	}
}
class BST{
	private BSTNode root;
	private int count = 0;
	
	public BSTNode getRoot(){
		return root;
	}
	public int getCount(){
		return count;
	}
	public void insert(int X, BSTNode nodeN){
		if(nodeN == null){
			root = new BSTNode(X, null, null);
			return;
		}
		count += 1;
		if(X < nodeN.getValue()){
			if(nodeN.getLeft() == null){
				nodeN.setLeft(new BSTNode(X, null, null));
			}
			else{
				insert(X, nodeN.getLeft());
			}
		}
		else{
			if(nodeN.getRight() == null){
				nodeN.setRight(new BSTNode(X, null, null));
			}
			else{
				insert(X, nodeN.getRight());
			}
		}
	}
}
class BSTNode {
	private int value;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(int v, BSTNode l, BSTNode r){
		value = v;
		left = l;
		right = r;
	}

	public void setLeft(BSTNode l){
		left = l;
	}
	public void setRight(BSTNode r){
		right = r;
	}
	public int getValue(){
		return value;
	}
	public BSTNode getLeft(){
		return left;
	}
	public BSTNode getRight(){
		return right;
	}
}