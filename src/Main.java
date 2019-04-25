import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {	
	public static int BUFFER_SIZE = 200000;
	public static TreeNode [] node = new TreeNode[BUFFER_SIZE];
	public static BST bst = new BST();
	public static void main(String[] args) {
		FileReader f_reader = null;
		try {
			f_reader = new FileReader("shuffled_dict.txt");
			BufferedReader inFile = new BufferedReader(f_reader);
			while(true) {
				String tmp=null;
				tmp = inFile.readLine();
				if(tmp==null) break;
				if(tmp.trim().equals("")) continue;
				String name = null;
				String pron = null;
				String cont = null;
				int index1 = tmp.indexOf("(");
				int index2 = tmp.indexOf(")");
				name=tmp.substring(0 ,index1-1);
				pron=tmp.substring(index1+1, index2);
				cont=tmp.substring(index2+1,tmp.length());
				bst.insertBST(name,pron, cont);
			}
			inFile.close();
			f_reader.close();
		}catch(FileNotFoundException e){e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		String command = null; 				
		Scanner kb = new Scanner(System.in);
		while(true) {		
			String data=null;
			System.out.print("$ ");
			command = kb.next();
			if(command.equals("size")) {
				int size = 0;
				TreeNode root = bst.getRoot();
				size = Size(root);
				System.out.println(size);
			}
			else if(command.equals("find")) {
				data = kb.next();
				FindWord(data);
			}
			else if(command.equals("add")) {
				String Name = null;
				String Class = null;
				String Mean = null;
				System.out.print("word: ");
				Name = kb.next();
				System.out.print("class: ");
				Class = kb.nextLine();	
				kb.nextLine();
				System.out.print("meaning: ");
				Mean = kb.nextLine();
				AddWord(Name, Class, Mean);
			}
			else if(command.equals("delete")) {
				data = kb.next();
				DeleteWord(data);
			}
			else if(command.equals("deleteall")) {
				data = kb.next();
				DeleteallWord(data);
			}
			else break;
		}kb.close();
	}
	public static void FindWord(String data) {
		if(bst.searchBST(data)==null){
			System.out.println("Not found.");
		}
		else {
			TreeNode tmp = bst.searchBST(data);		
			System.out.println(tmp.cont);
		}
	}
	public static void AddWord(String Name, String Class, String Mean) {
		bst.insertBST(Name,Class,Mean);
	}
	public static void DeleteWord(String data) {
		TreeNode tmp = null;
		if(bst.searchBST(data)==null){
			System.out.println("Not found.");
		}
		else {
			tmp = bst.searchBST(data);
			bst.TreeDelete(tmp);
			System.out.println("Deleted successfully.");
		}
	}
	public static void DeleteallWord(String data) {
		int deleteSize=0;
		FileReader f_reader = null;
		try {
			f_reader = new FileReader(data);
			BufferedReader inFile = new BufferedReader(f_reader);
			while(true) {
				String name = null;
				name = inFile.readLine();
				if(name==null) break;
				if(bst.searchBST(name)!=null) {
					bst.TreeDelete(bst.searchBST(name));
					deleteSize++;
				}
			}
			inFile.close();
			f_reader.close();
		}catch(FileNotFoundException e){e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		
		System.out.println(deleteSize+" words were deleted successfully. ");
	}
	public static int Size(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + Size(root.left) + Size(root.right);
	}	
}
