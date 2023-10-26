import java.util.ArrayList;
import java.util.Scanner;

public class FindPathInBst {
	
	public static BstNode<Integer> takingInput(boolean isRoot,int parentData,boolean isLeft){
		if(isRoot) {
			System.out.println("Enter root data");
		}else {
			if(isLeft) {
				System.out.println("Enter left child of " + parentData);
			}else {
				System.out.println("Enter right child of " + parentData);
			}
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData == -1) {
			return null;
		}
		BstNode<Integer> root = new BstNode<Integer>(rootData);
		BstNode<Integer> rootLeft = takingInput(false,rootData,true);
	    BstNode<Integer> rootRight = takingInput(false,rootData,false);
	    root.left = rootLeft;
	    root.right = rootRight;
	    return root;
	}
	
	public static void print(BstNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if(root.left != null) {
			System.out.print("L" + root.left.data + ", ");
		}if(root.right != null) {
			System.out.print("R" + root.right.data);
		}
		System.out.println();
		print(root.left);
		print(root.right);
	}
	
	public static ArrayList<Integer> findPath(BstNode<Integer> root, int x){
		if(root == null) {
			return null;
		}
		if(root.data == x) {
			ArrayList<Integer> rootAns = new ArrayList<>();
			rootAns.add(root.data);
			return rootAns;
		}
		else if(x < root.data) {
			ArrayList<Integer> leftAns = findPath(root.left,x);
			if(leftAns != null) {
				leftAns.add(root.data);
			}
			return leftAns;
		}else {
			ArrayList<Integer> rightAns = findPath(root.right,x);
			if(rightAns != null) {
				rightAns.add(root.data);
			}
			return rightAns;
		}
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BstNode<Integer> root = takingInput(true, 0, true);
		print(root);
		System.out.println("Enter value of x: ");
		int x = s.nextInt();
		ArrayList<Integer> path = findPath(root,x);
		if(path == null) {
			System.out.println("Not Found");
		}else {
			for(int i : path) { // for each loop
				System.out.print(i + " ");
			}
		}
		
	}

}
